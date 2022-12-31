package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzlw implements zzlv {
    public static final zzfg<Long> zza;
    public static final zzfg<Boolean> zzb;

    static {
        zzfe zzfeVar = new zzfe(zzex.zza("com.google.android.gms.measurement"));
        zza = zzfeVar.zza("measurement.id.service.use_appinfo_modified", 0L);
        zzb = zzfeVar.zzb("measurement.service.use_appinfo_modified", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzlv
    public final boolean zzb() {
        return zzb.zze().booleanValue();
    }
}
