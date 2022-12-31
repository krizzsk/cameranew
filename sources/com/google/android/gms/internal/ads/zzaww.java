package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaww {
    public static boolean isEnabled() {
        return zzado.zzdek.get().booleanValue();
    }

    public static void zzdy(String str) {
        if (zzado.zzdek.get().booleanValue()) {
            zzazk.zzdy(str);
        }
    }
}
