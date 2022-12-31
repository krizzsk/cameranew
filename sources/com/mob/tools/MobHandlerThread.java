package com.mob.tools;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
/* loaded from: classes2.dex */
public class MobHandlerThread extends Thread {
    private Looper looper;
    private int priority;
    private int tid;

    public MobHandlerThread() {
        this.tid = -1;
        this.priority = 0;
    }

    public static Handler newHandler(Handler.Callback callback) {
        return newHandler(null, null, callback);
    }

    public Looper getLooper() {
        if (isAlive()) {
            synchronized (this) {
                while (isAlive() && this.looper == null) {
                    try {
                        wait();
                    } catch (Throwable unused) {
                    }
                }
            }
            return this.looper;
        }
        return null;
    }

    public int getThreadId() {
        return this.tid;
    }

    protected void onLooperPrepared() {
    }

    protected void onLooperPrepared(Looper looper) {
    }

    public boolean quit() {
        Looper looper = getLooper();
        if (looper != null) {
            looper.quit();
            return true;
        }
        return false;
    }

    @Deprecated
    public void realRun() {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            realRun();
            this.tid = Process.myTid();
            Looper.prepare();
            synchronized (this) {
                this.looper = Looper.myLooper();
                notifyAll();
            }
            Process.setThreadPriority(this.priority);
            onLooperPrepared(this.looper);
            onLooperPrepared();
            Looper.loop();
            this.tid = -1;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }

    public static Handler newHandler(String str, Handler.Callback callback) {
        return newHandler(str, null, callback);
    }

    public static Handler newHandler(Runnable runnable, Handler.Callback callback) {
        return newHandler(null, runnable, callback);
    }

    public MobHandlerThread(int i2) {
        this.tid = -1;
        this.priority = i2;
    }

    public static Handler newHandler(String str, final Runnable runnable, final Handler.Callback callback) {
        final Handler[] handlerArr = new Handler[1];
        MobHandlerThread mobHandlerThread = new MobHandlerThread() { // from class: com.mob.tools.MobHandlerThread.1
            @Override // com.mob.tools.MobHandlerThread
            protected void onLooperPrepared(Looper looper) {
                synchronized (handlerArr) {
                    handlerArr[0] = new Handler(looper, callback);
                    handlerArr.notifyAll();
                }
            }

            @Override // com.mob.tools.MobHandlerThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
                super.run();
            }
        };
        synchronized (handlerArr) {
            try {
                mobHandlerThread.start();
                handlerArr.wait();
            }
        }
        return handlerArr[0];
    }
}
