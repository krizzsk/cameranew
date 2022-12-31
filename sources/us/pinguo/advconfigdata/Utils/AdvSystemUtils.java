package us.pinguo.advconfigdata.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.Interface.AdvConfig;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes3.dex */
public class AdvSystemUtils {
    public static final int ORIENTATION_HYSTERESIS = 20;
    private static HashMap<String, String> cacheMap = new HashMap<>();

    public static int DpToPx(Context context, float f2) {
        return (int) (f2 * context.getResources().getDisplayMetrics().density);
    }

    public static boolean checkApkExist(Activity activity, String str) {
        if (str == null || "".equals(str) || activity.getPackageManager().getLaunchIntentForPackage(str) == null) {
            return false;
        }
        try {
            activity.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static String getDeviceID(Context context) {
        AdvConfig advConfig = AdvConfigManager.getInstance().getAdvConfig();
        return advConfig != null ? advConfig.getDeviceID() : "unknown";
    }

    public static int getDisplayRotation(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation != 1) {
            if (rotation != 2) {
                if (rotation != 3) {
                    return 0;
                }
                return BaseBlurEffect.ROTATION_270;
            }
            return BaseBlurEffect.ROTATION_180;
        }
        return 90;
    }

    public static String getLocationInfo() {
        String language = Locale.getDefault().getLanguage();
        String country = Locale.getDefault().getCountry();
        return language + PGTransHeader.CONNECTOR + country;
    }

    private static String getNavBarOverride() {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public static int getNavigationBarHeight(Context context) {
        Resources resources;
        int identifier;
        if (!hasNavBar(context) || (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE)) <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public static String getNetworkType(Context context) {
        try {
            synchronized (AdvSystemUtils.class) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (Build.VERSION.SDK_INT > 23) {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                    return networkCapabilities == null ? "noNetwork" : networkCapabilities.hasTransport(1) ? "wifi" : "4G";
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                return activeNetworkInfo == null ? "noNetwork" : activeNetworkInfo.getType() == 1 ? "wifi" : "4G";
            }
        } catch (Exception unused) {
            return null;
        }
    }

    private static int[] getScreenRealSize(Context context) {
        int i2;
        int i3;
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
            i2 = point.x;
            i3 = point.y;
        } else {
            defaultDisplay.getSize(point);
            i2 = point.x;
            i3 = point.y;
        }
        Log.i(TJAdUnitConstants.String.VIDEO_INFO, "=========" + i2 + "x" + i3);
        return new int[]{i2, i3};
    }

    public static int[] getScreenSize(Context context) {
        try {
            return getScreenRealSize(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
        }
    }

    public static String getVersionCode(Context context) {
        String str = cacheMap.get("versionCode");
        if (TextUtils.isEmpty(str)) {
            PackageInfo packageInfo = null;
            try {
                synchronized (AdvSystemUtils.class) {
                    packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
                }
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
            if (packageInfo != null) {
                String valueOf = String.valueOf(packageInfo.versionCode);
                cacheMap.put("versionCode", valueOf);
                return valueOf;
            }
            return "";
        }
        return str;
    }

    public static String getVersionName(Context context) {
        String str = cacheMap.get("versionName");
        if (TextUtils.isEmpty(str)) {
            PackageInfo packageInfo = null;
            try {
                synchronized (AdvSystemUtils.class) {
                    packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
                }
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
            if (packageInfo != null) {
                String valueOf = String.valueOf(packageInfo.versionName);
                cacheMap.put("versionName", valueOf);
                return valueOf;
            }
            return "";
        }
        return str;
    }

    public static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
        if (identifier != 0) {
            boolean z = resources.getBoolean(identifier);
            String navBarOverride = getNavBarOverride();
            if ("1".equals(navBarOverride)) {
                return false;
            }
            if ("0".equals(navBarOverride)) {
                return true;
            }
            return z;
        }
        return !ViewConfiguration.get(context).hasPermanentMenuKey();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
        if (r5.isAvailable() != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean hasNet(android.content.Context r5) {
        /*
            r0 = 1
            java.lang.Class<us.pinguo.advconfigdata.Utils.AdvSystemUtils> r1 = us.pinguo.advconfigdata.Utils.AdvSystemUtils.class
            monitor-enter(r1)     // Catch: java.lang.Exception -> L31
            java.lang.String r2 = "connectivity"
            java.lang.Object r5 = r5.getSystemService(r2)     // Catch: java.lang.Throwable -> L2e
            android.net.ConnectivityManager r5 = (android.net.ConnectivityManager) r5     // Catch: java.lang.Throwable -> L2e
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L2e
            r3 = 23
            r4 = 0
            if (r2 <= r3) goto L1e
            android.net.Network r2 = r5.getActiveNetwork()     // Catch: java.lang.Throwable -> L2e
            android.net.NetworkCapabilities r5 = r5.getNetworkCapabilities(r2)     // Catch: java.lang.Throwable -> L2e
            if (r5 == 0) goto L2b
            goto L2a
        L1e:
            android.net.NetworkInfo r5 = r5.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> L2e
            if (r5 == 0) goto L2b
            boolean r5 = r5.isAvailable()     // Catch: java.lang.Throwable -> L2e
            if (r5 == 0) goto L2b
        L2a:
            r4 = 1
        L2b:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2e
            r0 = r4
            goto L31
        L2e:
            r5 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2e
            throw r5     // Catch: java.lang.Exception -> L31
        L31:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.advconfigdata.Utils.AdvSystemUtils.hasNet(android.content.Context):boolean");
    }

    public static boolean isZh() {
        return Locale.getDefault().getLanguage().toLowerCase().equals(Locale.CHINESE.toString().toLowerCase());
    }

    public static int roundOrientation(int i2, int i3) {
        boolean z = true;
        if (i3 != -1) {
            int abs = Math.abs(i2 - i3);
            if (Math.min(abs, 360 - abs) < 65) {
                z = false;
            }
        }
        return z ? (((i2 + 45) / 90) * 90) % BaseBlurEffect.ROTATION_360 : i3;
    }
}
