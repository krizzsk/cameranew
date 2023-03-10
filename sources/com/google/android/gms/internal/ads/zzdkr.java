package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdkr {
    public static zzdkn<zzbkx, zzblg> zza(Context context, zzdov zzdovVar, zzdpq zzdpqVar) {
        return zzc(context, zzdovVar, zzdpqVar);
    }

    public static zzdkn<zzblk, zzblq> zzb(Context context, zzdov zzdovVar, zzdpq zzdpqVar) {
        return zzc(context, zzdovVar, zzdpqVar);
    }

    private static <AppOpenAdRequestComponent extends zzbqv<AppOpenAd>, AppOpenAd extends zzbnt> zzdkn<AppOpenAdRequestComponent, AppOpenAd> zzc(Context context, zzdov zzdovVar, zzdpq zzdpqVar) {
        if (((Integer) zzwr.zzqr().zzd(zzabp.zzcys)).intValue() > 0) {
            zzdpp zza = zzdpqVar.zza(zzdpi.AppOpen, context, zzdovVar, new zzdjv(new zzdjm()));
            zzdke zzdkeVar = new zzdke(new zzdkf());
            zzdpc zzdpcVar = zza.zzhhi;
            zzdzv zzdzvVar = zzazp.zzeic;
            return new zzdjr(zzdkeVar, new zzdjw(zzdpcVar, zzdzvVar), zza.zzhol, zzdzvVar);
        }
        return new zzdkf();
    }
}
