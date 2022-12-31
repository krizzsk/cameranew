package com.tencent.matrix.trace.core;

import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Log;
import android.util.Printer;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.tencent.matrix.util.MatrixLog;
import com.tencent.matrix.util.ReflectUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class LooperMonitor implements MessageQueue.IdleHandler {
    private static final long CHECK_TIME = 60000;
    private static final String TAG = "Matrix.LooperMonitor";
    private Looper looper;
    private a printer;
    private static final Map<Looper, LooperMonitor> sLooperMonitorMap = new ConcurrentHashMap();
    private static final LooperMonitor sMainMonitor = of(Looper.getMainLooper());
    private static boolean isReflectLoggingError = false;
    private final HashSet<LooperDispatchListener> listeners = new HashSet<>();
    private long lastCheckPrinterTime = 0;

    /* loaded from: classes3.dex */
    public static abstract class LooperDispatchListener {
        boolean isHasDispatchStart = false;

        public void dispatchEnd() {
        }

        public void dispatchStart() {
        }

        public boolean isValid() {
            return false;
        }

        @CallSuper
        public void onDispatchEnd(String str) {
            this.isHasDispatchStart = false;
            dispatchEnd();
        }

        @CallSuper
        public void onDispatchStart(String str) {
            this.isHasDispatchStart = true;
            dispatchStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Printer {
        public Printer a;
        boolean b = false;
        boolean c = false;

        a(Printer printer) {
            this.a = printer;
        }

        @Override // android.util.Printer
        public void println(String str) {
            Printer printer = this.a;
            if (printer != null) {
                printer.println(str);
                if (this.a == this) {
                    throw new RuntimeException("Matrix.LooperMonitor origin == this");
                }
            }
            if (!this.b) {
                boolean z = str.charAt(0) == '>' || str.charAt(0) == '<';
                this.c = z;
                this.b = true;
                if (!z) {
                    MatrixLog.e(LooperMonitor.TAG, "[println] Printer is inValid! x:%s", str);
                }
            }
            if (this.c) {
                LooperMonitor.this.dispatch(str.charAt(0) == '>', str);
            }
        }
    }

    private LooperMonitor(Looper looper) {
        Objects.requireNonNull(looper);
        this.looper = looper;
        resetPrinter();
        addIdleHandler(looper);
    }

    private synchronized void addIdleHandler(Looper looper) {
        if (Build.VERSION.SDK_INT >= 23) {
            looper.getQueue().addIdleHandler(this);
        } else {
            try {
                ((MessageQueue) ReflectUtils.get(looper.getClass(), "mQueue", looper)).addIdleHandler(this);
            } catch (Exception e2) {
                Log.e(TAG, "[removeIdleHandler] %s", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatch(boolean z, String str) {
        synchronized (this.listeners) {
            Iterator<LooperDispatchListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                LooperDispatchListener next = it.next();
                if (next.isValid()) {
                    if (z) {
                        if (!next.isHasDispatchStart) {
                            next.onDispatchStart(str);
                        }
                    } else if (next.isHasDispatchStart) {
                        next.onDispatchEnd(str);
                    }
                } else if (!z && next.isHasDispatchStart) {
                    next.dispatchEnd();
                }
            }
        }
    }

    public static LooperMonitor of(@NonNull Looper looper) {
        Map<Looper, LooperMonitor> map = sLooperMonitorMap;
        LooperMonitor looperMonitor = map.get(looper);
        if (looperMonitor == null) {
            LooperMonitor looperMonitor2 = new LooperMonitor(looper);
            map.put(looper, looperMonitor2);
            return looperMonitor2;
        }
        return looperMonitor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void register(LooperDispatchListener looperDispatchListener) {
        sMainMonitor.addListener(looperDispatchListener);
    }

    private synchronized void removeIdleHandler(Looper looper) {
        if (Build.VERSION.SDK_INT >= 23) {
            looper.getQueue().removeIdleHandler(this);
        } else {
            try {
                ((MessageQueue) ReflectUtils.get(looper.getClass(), "mQueue", looper)).removeIdleHandler(this);
            } catch (Exception e2) {
                Log.e(TAG, "[removeIdleHandler] %s", e2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0087 A[Catch: all -> 0x0072, TryCatch #1 {, blocks: (B:4:0x0004, B:6:0x0008, B:7:0x0018, B:14:0x0024, B:16:0x003c, B:25:0x0078, B:27:0x0082, B:29:0x0087, B:30:0x00a3, B:32:0x00b1), top: B:39:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b1 A[Catch: all -> 0x0072, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0004, B:6:0x0008, B:7:0x0018, B:14:0x0024, B:16:0x003c, B:25:0x0078, B:27:0x0082, B:29:0x0087, B:30:0x00a3, B:32:0x00b1), top: B:39:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized void resetPrinter() {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 0
            r1 = 1
            r2 = 0
            boolean r3 = com.tencent.matrix.trace.core.LooperMonitor.isReflectLoggingError     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            if (r3 != 0) goto L82
            android.os.Looper r3 = r9.looper     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.Class r3 = r3.getClass()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.String r4 = "mLogging"
            android.os.Looper r5 = r9.looper     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.Object r3 = com.tencent.matrix.util.ReflectUtils.get(r3, r4, r5)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            android.util.Printer r3 = (android.util.Printer) r3     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            com.tencent.matrix.trace.core.LooperMonitor$a r2 = r9.printer     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            if (r3 != r2) goto L20
            if (r2 == 0) goto L20
            monitor-exit(r9)
            return
        L20:
            if (r3 == 0) goto L81
            if (r2 == 0) goto L81
            java.lang.Class r2 = r3.getClass()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            com.tencent.matrix.trace.core.LooperMonitor$a r4 = r9.printer     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            java.lang.Class r4 = r4.getClass()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            boolean r2 = r2.equals(r4)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            if (r2 == 0) goto L81
            java.lang.String r2 = "Matrix.LooperMonitor"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            r4.<init>()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            java.lang.String r5 = "LooperPrinter might be loaded by different classloader, my = "
            r4.append(r5)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            com.tencent.matrix.trace.core.LooperMonitor$a r5 = r9.printer     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            java.lang.ClassLoader r5 = r5.getClassLoader()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            r4.append(r5)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            java.lang.String r5 = ", other = "
            r4.append(r5)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            java.lang.Class r5 = r3.getClass()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            java.lang.ClassLoader r5 = r5.getClassLoader()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            r4.append(r5)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            com.tencent.matrix.util.MatrixLog.w(r2, r4, r5)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> L72
            monitor-exit(r9)
            return
        L70:
            r2 = move-exception
            goto L78
        L72:
            r0 = move-exception
            goto Lca
        L74:
            r3 = move-exception
            r8 = r3
            r3 = r2
            r2 = r8
        L78:
            com.tencent.matrix.trace.core.LooperMonitor.isReflectLoggingError = r1     // Catch: java.lang.Throwable -> L72
            java.lang.String r4 = "Matrix.LooperMonitor"
            java.lang.String r5 = "[resetPrinter] %s"
            android.util.Log.e(r4, r5, r2)     // Catch: java.lang.Throwable -> L72
        L81:
            r2 = r3
        L82:
            com.tencent.matrix.trace.core.LooperMonitor$a r3 = r9.printer     // Catch: java.lang.Throwable -> L72
            r4 = 2
            if (r3 == 0) goto La3
            java.lang.String r3 = "Matrix.LooperMonitor"
            java.lang.String r5 = "maybe thread:%s printer[%s] was replace other[%s]!"
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L72
            android.os.Looper r7 = r9.looper     // Catch: java.lang.Throwable -> L72
            java.lang.Thread r7 = r7.getThread()     // Catch: java.lang.Throwable -> L72
            java.lang.String r7 = r7.getName()     // Catch: java.lang.Throwable -> L72
            r6[r0] = r7     // Catch: java.lang.Throwable -> L72
            com.tencent.matrix.trace.core.LooperMonitor$a r7 = r9.printer     // Catch: java.lang.Throwable -> L72
            r6[r1] = r7     // Catch: java.lang.Throwable -> L72
            r6[r4] = r2     // Catch: java.lang.Throwable -> L72
            com.tencent.matrix.util.MatrixLog.w(r3, r5, r6)     // Catch: java.lang.Throwable -> L72
        La3:
            android.os.Looper r3 = r9.looper     // Catch: java.lang.Throwable -> L72
            com.tencent.matrix.trace.core.LooperMonitor$a r5 = new com.tencent.matrix.trace.core.LooperMonitor$a     // Catch: java.lang.Throwable -> L72
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L72
            r9.printer = r5     // Catch: java.lang.Throwable -> L72
            r3.setMessageLogging(r5)     // Catch: java.lang.Throwable -> L72
            if (r2 == 0) goto Lc8
            java.lang.String r3 = "Matrix.LooperMonitor"
            java.lang.String r5 = "reset printer, originPrinter[%s] in %s"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L72
            r4[r0] = r2     // Catch: java.lang.Throwable -> L72
            android.os.Looper r0 = r9.looper     // Catch: java.lang.Throwable -> L72
            java.lang.Thread r0 = r0.getThread()     // Catch: java.lang.Throwable -> L72
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> L72
            r4[r1] = r0     // Catch: java.lang.Throwable -> L72
            com.tencent.matrix.util.MatrixLog.i(r3, r5, r4)     // Catch: java.lang.Throwable -> L72
        Lc8:
            monitor-exit(r9)
            return
        Lca:
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.trace.core.LooperMonitor.resetPrinter():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void unregister(LooperDispatchListener looperDispatchListener) {
        sMainMonitor.removeListener(looperDispatchListener);
    }

    public void addListener(LooperDispatchListener looperDispatchListener) {
        synchronized (this.listeners) {
            this.listeners.add(looperDispatchListener);
        }
    }

    @Deprecated
    public HashSet<LooperDispatchListener> getListeners() {
        return this.listeners;
    }

    public Looper getLooper() {
        return this.looper;
    }

    public synchronized void onRelease() {
        if (this.printer != null) {
            synchronized (this.listeners) {
                this.listeners.clear();
            }
            MatrixLog.v(TAG, "[onRelease] %s, origin printer:%s", this.looper.getThread().getName(), this.printer.a);
            this.looper.setMessageLogging(this.printer.a);
            removeIdleHandler(this.looper);
            this.looper = null;
            this.printer = null;
        }
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (SystemClock.uptimeMillis() - this.lastCheckPrinterTime >= CHECK_TIME) {
            resetPrinter();
            this.lastCheckPrinterTime = SystemClock.uptimeMillis();
            return true;
        }
        return true;
    }

    public void removeListener(LooperDispatchListener looperDispatchListener) {
        synchronized (this.listeners) {
            this.listeners.remove(looperDispatchListener);
        }
    }
}
