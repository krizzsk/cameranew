package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdqh implements zzeqb<zzdzv> {
    public static zzdqh zzawu() {
        zzdqh zzdqhVar;
        zzdqhVar = zzdqk.zzhpm;
        return zzdqhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        zzdzv zzdzvVar;
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcwv)).booleanValue()) {
            zzdzvVar = zzazp.zzeie;
        } else {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcwu)).booleanValue()) {
                zzdzvVar = zzazp.zzeic;
            } else {
                zzdzvVar = zzazp.zzeig;
            }
        }
        return (zzdzv) zzeqh.zza(zzdzvVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
