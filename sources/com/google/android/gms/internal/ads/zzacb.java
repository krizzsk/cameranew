package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzacb extends zzabw {
    @Nullable
    private static String zzcs(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i2 = 0;
        int length = str.length();
        while (i2 < str.length() && str.charAt(i2) == ',') {
            i2++;
        }
        while (length > 0 && str.charAt(length - 1) == ',') {
            length--;
        }
        if (length < i2) {
            return null;
        }
        return (i2 == 0 && length == str.length()) ? str : str.substring(i2, length);
    }

    @Override // com.google.android.gms.internal.ads.zzabw
    public final String zzf(@Nullable String str, String str2) {
        String zzcs = zzcs(str);
        String zzcs2 = zzcs(str2);
        if (TextUtils.isEmpty(zzcs)) {
            return zzcs2;
        }
        if (TextUtils.isEmpty(zzcs2)) {
            return zzcs;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(zzcs).length() + 1 + String.valueOf(zzcs2).length());
        sb.append(zzcs);
        sb.append(",");
        sb.append(zzcs2);
        return sb.toString();
    }
}
