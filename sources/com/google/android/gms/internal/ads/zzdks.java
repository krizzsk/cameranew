package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdks implements zzeqb<zzdkn<zzchi, zzchb>> {
    private final zzeqo<Context> zzewk;
    private final zzeqo<zzdov> zzeyu;
    private final zzeqo<zzdpq> zzeyv;

    public zzdks(zzeqo<Context> zzeqoVar, zzeqo<zzdov> zzeqoVar2, zzeqo<zzdpq> zzeqoVar3) {
        this.zzewk = zzeqoVar;
        this.zzeyu = zzeqoVar2;
        this.zzeyv = zzeqoVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        Object zzdkfVar;
        Context context = this.zzewk.get();
        zzdov zzdovVar = this.zzeyu.get();
        zzdpq zzdpqVar = this.zzeyv.get();
        if (((Integer) zzwr.zzqr().zzd(zzabp.zzcye)).intValue() > 0) {
            zzdpp zza = zzdpqVar.zza(zzdpi.Rewarded, context, zzdovVar, new zzdjv(new zzdjm()));
            zzdke zzdkeVar = new zzdke(new zzdkf());
            zzdpc zzdpcVar = zza.zzhhi;
            zzdzv zzdzvVar = zzazp.zzeic;
            zzdkfVar = new zzdjr(zzdkeVar, new zzdjw(zzdpcVar, zzdzvVar), zza.zzhol, zzdzvVar);
        } else {
            zzdkfVar = new zzdkf();
        }
        return (zzdkn) zzeqh.zza(zzdkfVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
