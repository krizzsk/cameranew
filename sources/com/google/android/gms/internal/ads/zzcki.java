package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcki implements zzeqb<zzbya<zzbrr>> {
    private final zzeqo<Executor> zzewf;
    private final zzeqo<zzckd> zzfxt;
    private final zzeqo<zzcph> zzfxu;

    private zzcki(zzeqo<zzckd> zzeqoVar, zzeqo<Executor> zzeqoVar2, zzeqo<zzcph> zzeqoVar3) {
        this.zzfxt = zzeqoVar;
        this.zzewf = zzeqoVar2;
        this.zzfxu = zzeqoVar3;
    }

    public static zzcki zzu(zzeqo<zzckd> zzeqoVar, zzeqo<Executor> zzeqoVar2, zzeqo<zzcph> zzeqoVar3) {
        return new zzcki(zzeqoVar, zzeqoVar2, zzeqoVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        zzbya zzbyaVar;
        zzckd zzckdVar = this.zzfxt.get();
        Executor executor = this.zzewf.get();
        zzcph zzcphVar = this.zzfxu.get();
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdal)).booleanValue()) {
            zzbyaVar = new zzbya(zzcphVar, executor);
        } else {
            zzbyaVar = new zzbya(zzckdVar, executor);
        }
        return (zzbya) zzeqh.zza(zzbyaVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
