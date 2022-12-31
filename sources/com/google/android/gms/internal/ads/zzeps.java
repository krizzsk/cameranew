package com.google.android.gms.internal.ads;

import java.util.logging.Level;
import java.util.logging.Logger;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeps extends zzept {
    private Logger logger;

    public zzeps(String str) {
        this.logger = Logger.getLogger(str);
    }

    @Override // com.google.android.gms.internal.ads.zzept
    public final void zzio(String str) {
        this.logger.logp(Level.FINE, "com.googlecode.mp4parser.util.JuliLogger", "logDebug", str);
    }
}
