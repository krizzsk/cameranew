package com.growingio.android.sdk.utils.rom;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.growingio.android.sdk.utils.LogUtil;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class RomChecker {
    private static String TAG = "GIO.RomChecker";

    public static double getEmuiVersion() {
        try {
            String systemProperty = getSystemProperty("ro.build.version.emui");
            if (TextUtils.isEmpty(systemProperty)) {
                return -1.0d;
            }
            Matcher matcher = Pattern.compile("[0-9]+\\.[0-9]+").matcher(systemProperty);
            if (matcher.find()) {
                return Double.parseDouble(matcher.group());
            }
            return 4.0d;
        } catch (Exception e2) {
            LogUtil.e(TAG, e2.getMessage(), e2);
            return 4.0d;
        }
    }

    public static int getMiuiVersion() {
        String systemProperty = getSystemProperty("ro.miui.ui.version.name");
        if (systemProperty != null) {
            try {
                return Integer.parseInt(systemProperty.substring(1));
            } catch (Exception unused) {
                String str = TAG;
                LogUtil.i(str, "get miui version code error, version : " + systemProperty);
                return -1;
            }
        }
        return -1;
    }

    @SuppressLint({"PrivateApi"})
    public static String getSystemProperty(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, null);
        } catch (Exception e2) {
            LogUtil.e(TAG, e2.getMessage(), e2);
            return null;
        }
    }

    public static boolean is360Rom() {
        String str = Build.MANUFACTURER;
        return str.contains("QiKU") || str.contains("360");
    }

    public static boolean isHuaweiRom() {
        return getEmuiVersion() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public static boolean isMeizuRom() {
        String systemProperty = getSystemProperty("ro.build.display.id");
        if (TextUtils.isEmpty(systemProperty)) {
            return false;
        }
        return systemProperty.contains("flyme") || systemProperty.toLowerCase(Locale.getDefault()).contains("flyme");
    }

    public static boolean isMiuiRom() {
        return !TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name"));
    }
}
