package com.growingio.android.sdk.data.net;

import com.growingio.android.sdk.utils.LogUtil;
import java.net.HttpURLConnection;
/* loaded from: classes2.dex */
public class AsyncTimeout {
    private static final String TAG = "GIO.Timeout";
    private Timeout fakeHead;
    private Timeout head;
    private WatchDog watchDog;

    /* loaded from: classes2.dex */
    public static class Timeout {
        private HttpURLConnection connection;
        private long deadlineMills;
        private volatile boolean exit = false;
        private Timeout next;
        private long timeoutMills;

        public Timeout(HttpURLConnection httpURLConnection, long j2) {
            this.connection = httpURLConnection;
            this.timeoutMills = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class WatchDog extends Thread {
        private WatchDog() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (AsyncTimeout.this) {
                while (AsyncTimeout.this.head != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    AsyncTimeout.this.wakeTimeoutConnectionLocked(currentTimeMillis);
                    if (AsyncTimeout.this.head != null) {
                        try {
                            AsyncTimeout.this.wait(AsyncTimeout.this.head.deadlineMills - currentTimeMillis);
                        } catch (InterruptedException e2) {
                            LogUtil.d(AsyncTimeout.TAG, e2.getMessage(), e2);
                        } catch (Throwable th) {
                            LogUtil.e(AsyncTimeout.TAG, th.getMessage(), th);
                        }
                    } else {
                        try {
                            AsyncTimeout.this.wait(50000L);
                        } catch (InterruptedException unused) {
                        }
                        if (AsyncTimeout.this.head == null) {
                            AsyncTimeout.this.watchDog = null;
                            LogUtil.d(AsyncTimeout.TAG, "watchdog: 30(maybe) seconds pass, rm watchdog");
                            return;
                        }
                    }
                }
            }
        }
    }

    private boolean checkAndDisconnectLocked(Timeout timeout, long j2) {
        if (timeout.exit) {
            return true;
        }
        if (timeout.deadlineMills <= j2) {
            HttpURLConnection httpURLConnection = timeout.connection;
            if (httpURLConnection != null) {
                LogUtil.d(TAG, "writeTimeout: ", httpURLConnection);
                httpURLConnection.disconnect();
                timeout.connection = null;
            }
            return true;
        }
        return false;
    }

    private void checkChildThreadStartLocked() {
        if (this.watchDog == null) {
            WatchDog watchDog = new WatchDog();
            this.watchDog = watchDog;
            watchDog.setDaemon(true);
            this.watchDog.start();
        }
    }

    private void insertTimeoutLocked(Timeout timeout) {
        Timeout timeout2;
        Timeout timeout3 = this.head;
        Timeout timeout4 = timeout3.next;
        while (true) {
            Timeout timeout5 = timeout4;
            timeout2 = timeout3;
            timeout3 = timeout5;
            if (timeout3 == null || timeout3.deadlineMills >= timeout.deadlineMills) {
                break;
            }
            timeout4 = timeout3.next;
        }
        timeout2.next = timeout;
        timeout.next = timeout3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wakeTimeoutConnectionLocked(long j2) {
        if (this.head == null) {
            return;
        }
        if (this.fakeHead == null) {
            this.fakeHead = new Timeout(null, 0L);
        }
        this.fakeHead.next = this.head;
        Timeout timeout = this.fakeHead;
        for (Timeout timeout2 = this.head; timeout2 != null; timeout2 = timeout2.next) {
            if (checkAndDisconnectLocked(timeout2, j2)) {
                timeout.next = timeout2.next;
            } else {
                timeout = timeout2;
            }
        }
        this.head = this.fakeHead.next;
        this.fakeHead.next = null;
    }

    public void enter(Timeout timeout) {
        timeout.deadlineMills = System.currentTimeMillis() + timeout.timeoutMills;
        synchronized (this) {
            Timeout timeout2 = this.head;
            if (timeout2 != null) {
                if (timeout2.deadlineMills > timeout.deadlineMills) {
                    Timeout timeout3 = this.head;
                    this.head = timeout;
                    timeout.next = timeout3;
                    notifyAll();
                } else {
                    insertTimeoutLocked(timeout);
                }
            } else {
                this.head = timeout;
            }
            checkChildThreadStartLocked();
        }
    }

    public void exit(Timeout timeout) {
        timeout.exit = true;
        timeout.connection = null;
        synchronized (this) {
            notifyAll();
        }
    }
}
