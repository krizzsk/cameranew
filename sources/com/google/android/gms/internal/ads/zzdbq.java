package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdbq implements zzeqb<zzdbp> {
    private final zzeqo<Executor> zzewf;
    private final zzeqo<zzayo> zzhas;

    private zzdbq(zzeqo<Executor> zzeqoVar, zzeqo<zzayo> zzeqoVar2) {
        this.zzewf = zzeqoVar;
        this.zzhas = zzeqoVar2;
    }

    public static zzdbp zza(Executor executor, zzayo zzayoVar) {
        return new zzdbp(executor, zzayoVar);
    }

    public static zzdbq zzas(zzeqo<Executor> zzeqoVar, zzeqo<zzayo> zzeqoVar2) {
        return new zzdbq(zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zza(this.zzewf.get(), this.zzhas.get());
    }
}
