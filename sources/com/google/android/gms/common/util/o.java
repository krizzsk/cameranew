package com.google.android.gms.common.util;

import android.os.Build;
import android.util.Log;
import com.adjust.sdk.Constants;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class o {
    private static Boolean a;

    public static boolean a() {
        return true;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 15;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 17;
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public static boolean g() {
        return Build.VERSION.SDK_INT >= 20;
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean i() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean j() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean k() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean l() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean m() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean n() {
        boolean z = false;
        if (m()) {
            if (Build.VERSION.SDK_INT < 30 || !Build.VERSION.CODENAME.equals("REL")) {
                String str = Build.VERSION.CODENAME;
                if (str.length() == 1 && str.charAt(0) >= 'R' && str.charAt(0) <= 'Z') {
                    Boolean bool = a;
                    if (bool != null) {
                        return bool.booleanValue();
                    }
                    try {
                        if (Constants.REFERRER_API_GOOGLE.equals(Build.BRAND) && !Build.ID.startsWith("RPP1") && !Build.ID.startsWith("RPP2") && Integer.parseInt(Build.VERSION.INCREMENTAL) >= 6301457) {
                            z = true;
                        }
                        a = Boolean.valueOf(z);
                    } catch (NumberFormatException unused) {
                        a = Boolean.TRUE;
                    }
                    if (!a.booleanValue()) {
                        Log.w("PlatformVersion", "Build version must be at least 6301457 to support R in gmscore");
                    }
                    return a.booleanValue();
                }
                return false;
            }
            return true;
        }
        return false;
    }
}
