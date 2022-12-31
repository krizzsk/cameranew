package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzlz implements zzly {
    public static final zzfg<Boolean> zza;
    public static final zzfg<Boolean> zzb;
    public static final zzfg<Boolean> zzc;

    static {
        zzfe zzfeVar = new zzfe(zzex.zza("com.google.android.gms.measurement"));
        zza = zzfeVar.zzb("measurement.client.sessions.check_on_reset_and_enable2", true);
        zzb = zzfeVar.zzb("measurement.client.sessions.check_on_startup", true);
        zzc = zzfeVar.zzb("measurement.client.sessions.start_session_before_view_screen", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzly
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzly
    public final boolean zzb() {
        return zza.zze().booleanValue();
    }
}
