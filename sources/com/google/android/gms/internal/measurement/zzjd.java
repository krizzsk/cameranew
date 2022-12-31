package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzjd {
    private static final zzjc zza;
    private static final zzjc zzb;

    static {
        zzjc zzjcVar;
        try {
            zzjcVar = (zzjc) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzjcVar = null;
        }
        zza = zzjcVar;
        zzb = new zzjc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjc zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjc zzb() {
        return zzb;
    }
}
