package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzejk {
    private static final Class<?> zzilq = zzhx("libcore.io.Memory");
    private static final boolean zzilr;

    static {
        zzilr = zzhx("org.robolectric.Robolectric") != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzbgc() {
        return (zzilq == null || zzilr) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> zzbgd() {
        return zzilq;
    }

    private static <T> Class<T> zzhx(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
