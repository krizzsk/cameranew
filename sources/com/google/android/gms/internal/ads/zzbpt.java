package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbpt implements zzeqb<zzbya<zzbrq>> {
    private final zzeqo<Executor> zzewf;
    private final zzeqo<zzckb> zzfxt;
    private final zzeqo<zzcpf> zzfxu;

    private zzbpt(zzeqo<zzckb> zzeqoVar, zzeqo<Executor> zzeqoVar2, zzeqo<zzcpf> zzeqoVar3) {
        this.zzfxt = zzeqoVar;
        this.zzewf = zzeqoVar2;
        this.zzfxu = zzeqoVar3;
    }

    public static zzbpt zzh(zzeqo<zzckb> zzeqoVar, zzeqo<Executor> zzeqoVar2, zzeqo<zzcpf> zzeqoVar3) {
        return new zzbpt(zzeqoVar, zzeqoVar2, zzeqoVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        zzbya zzbyaVar;
        zzckb zzckbVar = this.zzfxt.get();
        Executor executor = this.zzewf.get();
        zzcpf zzcpfVar = this.zzfxu.get();
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdal)).booleanValue()) {
            zzbyaVar = new zzbya(zzcpfVar, executor);
        } else {
            zzbyaVar = new zzbya(zzckbVar, executor);
        }
        return (zzbya) zzeqh.zza(zzbyaVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
