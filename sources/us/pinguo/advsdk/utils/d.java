package us.pinguo.advsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.growingio.android.sdk.utils.NetworkUtil;
import com.tapjoy.TapjoyConstants;
import us.pinguo.advsdk.manager.PgAdvManager;
/* compiled from: AdvSystemUtils.java */
/* loaded from: classes3.dex */
public class d {
    public static boolean a(Context context, String str) {
        if (str == null || "".equals(str) || context.getPackageManager().getLaunchIntentForPackage(str) == null) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static String b(Context context) {
        String k2 = PgAdvManager.getInstance().k();
        if (TextUtils.isEmpty(k2) || "unknown".equals(k2)) {
            return "unknown";
        }
        try {
            return Settings.Secure.getString(context.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
        } catch (Exception e2) {
            b.a(e2.getMessage());
            return "";
        }
    }

    public static String c(Context context) {
        return String.valueOf(context.getResources().getDisplayMetrics().densityDpi);
    }

    public static String d(Context context) {
        return PgAdvManager.getInstance().k();
    }

    public static String e(Context context) {
        int b = e.b(context);
        return b == 2 ? "2G" : b == 4 ? "3G" : b == 8 ? "4G" : b == 16 ? NetworkUtil.NETWORK_WIFI : b == -1 ? "NONETWORK" : NetworkUtil.NETWORK_UNKNOWN;
    }

    public static String f(Context context) {
        return PgAdvManager.getInstance().p();
    }

    public static String g() {
        return Build.BRAND;
    }

    public static String h(Context context) {
        if (context == null) {
            return "";
        }
        PackageInfo packageInfo = null;
        try {
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        synchronized (d.class) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return "";
            }
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 16384);
            return packageInfo != null ? String.valueOf(packageInfo.versionName) : "";
        }
    }
}
