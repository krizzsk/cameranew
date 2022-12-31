package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbpj implements zzeqb<zzbya<zzbrm>> {
    private final zzeqo<Executor> zzewf;
    private final zzeqo<zzbjq> zzftr;

    private zzbpj(zzeqo<zzbjq> zzeqoVar, zzeqo<Executor> zzeqoVar2) {
        this.zzftr = zzeqoVar;
        this.zzewf = zzeqoVar2;
    }

    public static zzbpj zzf(zzeqo<zzbjq> zzeqoVar, zzeqo<Executor> zzeqoVar2) {
        return new zzbpj(zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzbya) zzeqh.zza(new zzbya(this.zzftr.get(), this.zzewf.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
