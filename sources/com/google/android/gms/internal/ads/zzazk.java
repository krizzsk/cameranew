package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class zzazk {
    public static boolean isLoggable(int i2) {
        return i2 >= 5 || Log.isLoggable("Ads", i2);
    }

    public static void zzb(String str, Throwable th) {
        if (isLoggable(3)) {
            Log.d("Ads", str, th);
        }
    }

    public static void zzc(String str, Throwable th) {
        if (isLoggable(6)) {
            Log.e("Ads", str, th);
        }
    }

    public static void zzd(String str, Throwable th) {
        if (isLoggable(5)) {
            Log.w("Ads", str, th);
        }
    }

    public static void zzdy(String str) {
        if (isLoggable(3)) {
            Log.d("Ads", str);
        }
    }

    public static void zze(String str, @Nullable Throwable th) {
        if (isLoggable(5)) {
            if (th != null) {
                zzd(zzey(str), th);
            } else {
                zzex(zzey(str));
            }
        }
    }

    public static void zzev(String str) {
        if (isLoggable(6)) {
            Log.e("Ads", str);
        }
    }

    public static void zzew(String str) {
        if (isLoggable(4)) {
            Log.i("Ads", str);
        }
    }

    public static void zzex(String str) {
        if (isLoggable(5)) {
            Log.w("Ads", str);
        }
    }

    private static String zzey(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= 4) {
            int lineNumber = stackTrace[3].getLineNumber();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
            sb.append(str);
            sb.append(" @");
            sb.append(lineNumber);
            return sb.toString();
        }
        return str;
    }

    public static void zzez(String str) {
        zze(str, null);
    }
}
