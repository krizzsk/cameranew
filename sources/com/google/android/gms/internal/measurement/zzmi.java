package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzmi implements zzmh {
    public static final zzfg<Boolean> zza = new zzfe(zzex.zza("com.google.android.gms.measurement")).zzb("measurement.ga.ga_app_id", false);

    @Override // com.google.android.gms.internal.measurement.zzmh
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzmh
    public final boolean zzb() {
        return zza.zze().booleanValue();
    }
}
