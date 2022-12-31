package com.growingio.android.sdk.monitor;

import com.growingio.android.sdk.monitor.log.MLog;
import java.lang.Thread;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes2.dex */
public class MonitorUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final int MAX_DEPTH = 10;
    private static final String SDK_PACKAGE_NAME_PREFIX = "com.growingio.android";
    private static final String TAG = "MonitorUncaughtExceptionHandler";
    private Thread.UncaughtExceptionHandler defaultExceptionHandler;
    private ConcurrentLinkedQueue<Class> ignoresExceptions = new ConcurrentLinkedQueue<>();
    private volatile Boolean enabled = Boolean.TRUE;

    private MonitorUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.defaultExceptionHandler = uncaughtExceptionHandler;
    }

    private boolean isNeedIgnore(Throwable th) {
        ConcurrentLinkedQueue<Class> concurrentLinkedQueue = this.ignoresExceptions;
        if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
            Iterator<Class> it = this.ignoresExceptions.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                Class next = it.next();
                while (true) {
                    if (th != null) {
                        int i3 = i2 + 1;
                        if (i2 >= 10) {
                            i2 = i3;
                            break;
                        } else if (next.isInstance(th)) {
                            MLog.e(TAG, "ignored exception " + next.getSimpleName() + " received.");
                            return true;
                        } else {
                            th = th.getCause();
                            i2 = i3;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static MonitorUncaughtExceptionHandler setup() {
        MonitorUncaughtExceptionHandler monitorUncaughtExceptionHandler = new MonitorUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
        Thread.setDefaultUncaughtExceptionHandler(monitorUncaughtExceptionHandler);
        return monitorUncaughtExceptionHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addIgnoresException(Class cls) {
        this.ignoresExceptions.add(cls);
    }

    public void disable() {
        this.enabled = Boolean.FALSE;
        if (Thread.getDefaultUncaughtExceptionHandler() == this) {
            Thread.setDefaultUncaughtExceptionHandler(this.defaultExceptionHandler);
        }
    }

    public Boolean isEnabled() {
        return this.enabled;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0073, code lost:
        r3.sendEvent(r1);
     */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void uncaughtException(java.lang.Thread r6, java.lang.Throwable r7) {
        /*
            r5 = this;
            java.lang.Boolean r0 = r5.enabled
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L7d
            boolean r0 = r5.isNeedIgnore(r7)
            if (r0 != 0) goto L7d
            java.lang.String r0 = "MonitorUncaughtExceptionHandler"
            java.lang.String r1 = "Uncaught exception received."
            com.growingio.android.sdk.monitor.log.MLog.e(r0, r1)
            com.growingio.android.sdk.monitor.event.EventBuilder r1 = new com.growingio.android.sdk.monitor.event.EventBuilder
            r1.<init>()
            java.lang.String r2 = r7.getMessage()
            com.growingio.android.sdk.monitor.event.EventBuilder r1 = r1.withMessage(r2)
            com.growingio.android.sdk.monitor.event.Event$Level r2 = com.growingio.android.sdk.monitor.event.Event.Level.FATAL
            com.growingio.android.sdk.monitor.event.EventBuilder r1 = r1.withLevel(r2)
            com.growingio.android.sdk.monitor.event.interfaces.ExceptionInterface r2 = new com.growingio.android.sdk.monitor.event.interfaces.ExceptionInterface
            r2.<init>(r7)
            com.growingio.android.sdk.monitor.event.EventBuilder r1 = r1.withMonitorInterface(r2)
            com.growingio.android.sdk.monitor.analysis.GIOAnalyser r2 = com.growingio.android.sdk.monitor.analysis.GIOAnalyser.getInstance()     // Catch: java.lang.Exception -> L77
            com.growingio.android.sdk.monitor.analysis.Analyser r2 = r2.getAnalyser()     // Catch: java.lang.Exception -> L77
            com.growingio.android.sdk.monitor.analysis.Analysed r2 = r2.analyze(r7)     // Catch: java.lang.Exception -> L77
            boolean r2 = r2.isFindTarget()     // Catch: java.lang.Exception -> L77
            if (r2 == 0) goto L7d
            java.lang.String r2 = "This could be Growing IO exception."
            com.growingio.android.sdk.monitor.log.MLog.e(r0, r2)     // Catch: java.lang.Exception -> L77
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Exception -> L77
            java.util.concurrent.ConcurrentHashMap r3 = com.growingio.android.sdk.monitor.Monitor.getAllStoredClients()     // Catch: java.lang.Exception -> L77
            java.util.Collection r3 = r3.values()     // Catch: java.lang.Exception -> L77
            r2.<init>(r3)     // Catch: java.lang.Exception -> L77
            com.growingio.android.sdk.monitor.MonitorUncaughtExceptionHandler$1 r3 = new com.growingio.android.sdk.monitor.MonitorUncaughtExceptionHandler$1     // Catch: java.lang.Exception -> L77
            r3.<init>()     // Catch: java.lang.Exception -> L77
            java.util.Collections.sort(r2, r3)     // Catch: java.lang.Exception -> L77
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Exception -> L77
        L61:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Exception -> L77
            if (r3 == 0) goto L7d
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Exception -> L77
            com.growingio.android.sdk.monitor.MonitorClient r3 = (com.growingio.android.sdk.monitor.MonitorClient) r3     // Catch: java.lang.Exception -> L77
            boolean r4 = r3.filterThrowable(r7)     // Catch: java.lang.Exception -> L77
            if (r4 == 0) goto L61
            r3.sendEvent(r1)     // Catch: java.lang.Exception -> L77
            goto L7d
        L77:
            r1 = move-exception
            java.lang.String r2 = "Error sending uncaught exception to Monitor."
            com.growingio.android.sdk.monitor.log.MLog.e(r0, r2, r1)
        L7d:
            java.lang.Thread$UncaughtExceptionHandler r0 = r5.defaultExceptionHandler
            if (r0 == 0) goto L84
            r0.uncaughtException(r6, r7)
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.monitor.MonitorUncaughtExceptionHandler.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
