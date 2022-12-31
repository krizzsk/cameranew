package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdvr {
    private static int zza(char c) {
        return (char) ((c | ' ') - 97);
    }

    public static boolean zza(CharSequence charSequence, CharSequence charSequence2) {
        int zza;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = charSequence.charAt(i2);
            char charAt2 = charSequence2.charAt(i2);
            if (charAt != charAt2 && ((zza = zza(charAt)) >= 26 || zza != zza(charAt2))) {
                return false;
            }
        }
        return true;
    }
}
