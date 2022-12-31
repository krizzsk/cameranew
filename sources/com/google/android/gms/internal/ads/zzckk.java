package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzckk implements zzeqb<zzbya<zzdrp>> {
    private final zzeqo<Executor> zzewf;
    private final zzeqo<zzckr> zzfxt;
    private final zzeqo<zzcpn> zzfxu;

    private zzckk(zzeqo<zzckr> zzeqoVar, zzeqo<Executor> zzeqoVar2, zzeqo<zzcpn> zzeqoVar3) {
        this.zzfxt = zzeqoVar;
        this.zzewf = zzeqoVar2;
        this.zzfxu = zzeqoVar3;
    }

    public static zzckk zzv(zzeqo<zzckr> zzeqoVar, zzeqo<Executor> zzeqoVar2, zzeqo<zzcpn> zzeqoVar3) {
        return new zzckk(zzeqoVar, zzeqoVar2, zzeqoVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        zzbya zzbyaVar;
        zzckr zzckrVar = this.zzfxt.get();
        Executor executor = this.zzewf.get();
        zzcpn zzcpnVar = this.zzfxu.get();
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdal)).booleanValue()) {
            zzbyaVar = new zzbya(zzcpnVar, executor);
        } else {
            zzbyaVar = new zzbya(zzckrVar, executor);
        }
        return (zzbya) zzeqh.zza(zzbyaVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
