package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzmc implements zzmb {
    public static final zzfg<Boolean> zza;
    public static final zzfg<Boolean> zzb;
    public static final zzfg<Long> zzc;

    static {
        zzfe zzfeVar = new zzfe(zzex.zza("com.google.android.gms.measurement"));
        zza = zzfeVar.zzb("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        zzb = zzfeVar.zzb("measurement.collection.redundant_engagement_removal_enabled", false);
        zzc = zzfeVar.zza("measurement.id.collection.redundant_engagement_removal_enabled", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzmb
    public final boolean zza() {
        return zzb.zze().booleanValue();
    }
}
