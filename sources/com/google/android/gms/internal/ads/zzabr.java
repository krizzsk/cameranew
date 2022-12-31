package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzabr {
    public static boolean zzcp(String str) {
        return zze((String) zzwr.zzqr().zzd(zzabp.zzcwd), str);
    }

    private static boolean zze(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                return Pattern.matches(str, str2);
            } catch (RuntimeException e2) {
                com.google.android.gms.ads.internal.zzr.zzkv().zza(e2, "NonagonUtil.isPatternMatched");
            }
        }
        return false;
    }
}
