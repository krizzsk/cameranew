package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcps implements zzeqb<zzbya<zzbrr>> {
    private final zzeqo<zzcpz> zzewe;
    private final zzeqo<Executor> zzewf;

    private zzcps(zzeqo<zzcpz> zzeqoVar, zzeqo<Executor> zzeqoVar2) {
        this.zzewe = zzeqoVar;
        this.zzewf = zzeqoVar2;
    }

    public static zzcps zzao(zzeqo<zzcpz> zzeqoVar, zzeqo<Executor> zzeqoVar2) {
        return new zzcps(zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzbya) zzeqh.zza(new zzbya(this.zzewe.get(), this.zzewf.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
