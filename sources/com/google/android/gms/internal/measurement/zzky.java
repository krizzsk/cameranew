package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzky implements zzkx {
    public static final zzfg<Boolean> zza;
    public static final zzfg<Long> zzb;

    static {
        zzfe zzfeVar = new zzfe(zzex.zza("com.google.android.gms.measurement"));
        zza = zzfeVar.zzb("measurement.service.directly_maybe_log_error_events", false);
        zzb = zzfeVar.zza("measurement.id.service.directly_maybe_log_error_events", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzkx
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzkx
    public final boolean zzb() {
        return zza.zze().booleanValue();
    }
}
