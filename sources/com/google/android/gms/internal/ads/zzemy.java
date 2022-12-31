package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzemy {
    private static final zzemw zziti = zzbkd();
    private static final zzemw zzitj = new zzemv();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzemw zzbkb() {
        return zziti;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzemw zzbkc() {
        return zzitj;
    }

    private static zzemw zzbkd() {
        try {
            return (zzemw) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
