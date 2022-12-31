package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzhh {
    private static final zzhf<?> zza = new zzhg();
    private static final zzhf<?> zzb;

    static {
        zzhf<?> zzhfVar;
        try {
            zzhfVar = (zzhf) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzhfVar = null;
        }
        zzb = zzhfVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhf<?> zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhf<?> zzb() {
        zzhf<?> zzhfVar = zzb;
        if (zzhfVar != null) {
            return zzhfVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
