package com.google.android.gms.ads;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zza {
    public static AdSize zza(int i2, int i3, String str) {
        return new AdSize(i2, i3, str);
    }

    public static boolean zzb(AdSize adSize) {
        return adSize.c();
    }

    public static int zzc(AdSize adSize) {
        return adSize.d();
    }

    public static AdSize zza(int i2, int i3) {
        AdSize adSize = new AdSize(i2, i3);
        adSize.a(true);
        adSize.e(i3);
        return adSize;
    }

    public static boolean zza(AdSize adSize) {
        return adSize.b();
    }
}
