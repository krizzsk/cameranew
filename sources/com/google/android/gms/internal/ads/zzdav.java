package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdav implements zzdfi<Object> {
    private final Executor executor;
    private final zzdzw<String> zzham;

    public zzdav(zzdzw<String> zzdzwVar, Executor executor) {
        this.zzham = zzdzwVar;
        this.executor = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<Object> zzasy() {
        return zzdzk.zzb(this.zzham, zzdau.zzboq, this.executor);
    }
}
