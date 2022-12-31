package com.google.android.gms.internal.ads;

import java.io.PrintWriter;
/* compiled from: com.google.android.gms:play-services-ads-base@@19.7.0 */
/* loaded from: classes2.dex */
final class zzejf extends zzeiz {
    @Override // com.google.android.gms.internal.ads.zzeiz
    public final void zza(Throwable th, Throwable th2) {
        th.addSuppressed(th2);
    }

    @Override // com.google.android.gms.internal.ads.zzeiz
    public final void zza(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
    }
}
