package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzkv implements zzku {
    public static final zzfg<Boolean> zza;
    public static final zzfg<Boolean> zzb;

    static {
        zzfe zzfeVar = new zzfe(zzex.zza("com.google.android.gms.measurement"));
        zza = zzfeVar.zzb("measurement.androidId.delete_feature", true);
        zzb = zzfeVar.zzb("measurement.log_androidId_enabled", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzku
    public final boolean zza() {
        return zza.zze().booleanValue();
    }
}
