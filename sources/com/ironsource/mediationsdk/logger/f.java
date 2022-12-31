package com.ironsource.mediationsdk.logger;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.lang.Thread;
/* compiled from: ThreadExceptionHandler.java */
/* loaded from: classes2.dex */
public class f implements Thread.UncaughtExceptionHandler {
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        c i2 = c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
        i2.e(ironSourceTag, "Thread name =" + thread.getName(), th);
    }
}
