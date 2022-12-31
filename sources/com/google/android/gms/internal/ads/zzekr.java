package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzekr {
    private static final zzekq<?> zzinm = new zzeks();
    private static final zzekq<?> zzinn = zzbhy();

    private static zzekq<?> zzbhy() {
        try {
            return (zzekq) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzekq<?> zzbhz() {
        return zzinm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzekq<?> zzbia() {
        zzekq<?> zzekqVar = zzinn;
        if (zzekqVar != null) {
            return zzekqVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
