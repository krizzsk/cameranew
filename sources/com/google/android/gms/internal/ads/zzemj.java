package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzemj {
    private static final zzemh zziso = zzbjx();
    private static final zzemh zzisp = new zzemk();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzemh zzbjv() {
        return zziso;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzemh zzbjw() {
        return zzisp;
    }

    private static zzemh zzbjx() {
        try {
            return (zzemh) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
