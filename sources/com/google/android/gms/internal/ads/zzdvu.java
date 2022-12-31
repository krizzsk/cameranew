package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzdvu {
    public static zzdvu zzb(char c) {
        return new zzdvw(c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzd(char c) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public int zza(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        zzdwl.zzb(i2, length, FirebaseAnalytics.Param.INDEX);
        while (i2 < length) {
            if (zzc(charSequence.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public abstract boolean zzc(char c);
}
