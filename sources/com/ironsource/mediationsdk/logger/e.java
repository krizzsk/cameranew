package com.ironsource.mediationsdk.logger;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
/* compiled from: PublisherLogger.java */
/* loaded from: classes2.dex */
public class e extends IronSourceLogger {
    private d c;

    public e(d dVar, int i2) {
        super("publisher", i2);
        this.c = dVar;
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public synchronized void d(IronSourceLogger.IronSourceTag ironSourceTag, String str, int i2) {
        d dVar = this.c;
        if (dVar != null && str != null) {
            dVar.a(ironSourceTag, str, i2);
        }
    }

    @Override // com.ironsource.mediationsdk.logger.IronSourceLogger
    public void e(IronSourceLogger.IronSourceTag ironSourceTag, String str, Throwable th) {
        if (th != null) {
            d(ironSourceTag, th.getMessage(), 3);
        }
    }
}
