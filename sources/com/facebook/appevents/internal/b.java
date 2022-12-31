package com.facebook.appevents.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.annotation.Nullable;
import com.facebook.internal.x;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: AppEventUtility.java */
/* loaded from: classes.dex */
public class b {
    public static void a() {
    }

    public static void b() {
    }

    public static String c(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i2])));
        }
        return stringBuffer.toString();
    }

    public static String d() {
        Context f2 = com.facebook.f.f();
        try {
            return f2.getPackageManager().getPackageInfo(f2.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    @Nullable
    public static View e(@Nullable Activity activity) {
        if (com.facebook.internal.instrument.e.a.c(b.class) || activity == null) {
            return null;
        }
        try {
            Window window = activity.getWindow();
            if (window == null) {
                return null;
            }
            return window.getDecorView().getRootView();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }

    public static boolean f() {
        String str = Build.FINGERPRINT;
        if (!str.startsWith("generic") && !str.startsWith("unknown")) {
            String str2 = Build.MODEL;
            if (!str2.contains("google_sdk") && !str2.contains("Emulator") && !str2.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion") && ((!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) && !"google_sdk".equals(Build.PRODUCT))) {
                return false;
            }
        }
        return true;
    }

    public static double g(String str) {
        try {
            Matcher matcher = Pattern.compile("[-+]*\\d+([\\,\\.]\\d+)*([\\.\\,]\\d+)?", 8).matcher(str);
            if (matcher.find()) {
                return NumberFormat.getNumberInstance(x.w()).parse(matcher.group(0)).doubleValue();
            }
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        } catch (ParseException unused) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
    }
}
