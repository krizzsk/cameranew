package com.ironsource.environment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
/* compiled from: DeviceStatus.java */
/* loaded from: classes2.dex */
public class e {
    private static String a;
    private static String b;

    public static File A(Context context) {
        return context.getExternalFilesDir(null);
    }

    private static long B(File file) {
        long availableBlocksLong;
        long blockSizeLong;
        StatFs statFs = new StatFs(file.getPath());
        if (Build.VERSION.SDK_INT < 19) {
            availableBlocksLong = statFs.getAvailableBlocks();
            blockSizeLong = statFs.getBlockSize();
        } else {
            availableBlocksLong = statFs.getAvailableBlocksLong();
            blockSizeLong = statFs.getBlockSizeLong();
        }
        return (availableBlocksLong * blockSizeLong) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    public static List<ApplicationInfo> C(Context context) {
        return context.getPackageManager().getInstalledApplications(0);
    }

    public static File D(Context context) {
        return context.getCacheDir();
    }

    public static File E(Context context) {
        return context.getFilesDir();
    }

    public static boolean F(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return ((float) displayMetrics.widthPixels) / displayMetrics.density >= 600.0f;
        }
        return false;
    }

    public static String G(Context context) {
        TelephonyManager telephonyManager;
        return (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) ? "" : telephonyManager.getNetworkOperatorName();
    }

    public static String H(Context context) {
        TelephonyManager telephonyManager;
        return (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) ? "" : telephonyManager.getNetworkCountryIso();
    }

    public static synchronized String I(Context context) {
        synchronized (e.class) {
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            if (h.a(context, "Mediation_Shared_Preferences", "uuidEnabled", true)) {
                String b2 = h.b(context, "Mediation_Shared_Preferences", "cachedUUID", "");
                if (TextUtils.isEmpty(b2)) {
                    String uuid = UUID.randomUUID().toString();
                    a = uuid;
                    h.c(context, "Mediation_Shared_Preferences", "cachedUUID", uuid);
                } else {
                    a = b2;
                }
            }
            return a;
        }
    }

    public static int J(Context context) {
        if (context != null) {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
        }
        return -1;
    }

    public static float K(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        try {
            return audioManager.getStreamVolume(3) / audioManager.getStreamMaxVolume(3);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1.0f;
        }
    }

    public static long L(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            if (Build.VERSION.SDK_INT >= 16) {
                return memoryInfo.totalMem;
            }
            return -1L;
        }
        return -1L;
    }

    public static boolean M(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static boolean N(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("status", -1) : -1;
        return intExtra == 2 || intExtra == 5;
    }

    public static boolean O(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) != 1;
    }

    public static boolean P() {
        return "mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable();
    }

    @TargetApi(19)
    public static boolean Q(Activity activity) {
        int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
        return (systemUiVisibility | 4096) == systemUiVisibility || (systemUiVisibility | 2048) == systemUiVisibility;
    }

    public static boolean R(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((PowerManager) context.getSystemService("power")).isPowerSaveMode();
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean S() {
        return b("su");
    }

    public static boolean T(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                return Settings.Global.getInt(context.getContentResolver(), "stay_on_while_plugged_in", 0) != 0;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static int a(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return registerReceiver.getIntExtra("plugged", -1);
        }
        return -1;
    }

    private static boolean b(String str) {
        try {
            String[] strArr = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
            for (int i2 = 0; i2 < 8; i2++) {
                String str2 = strArr[i2];
                if (new File(str2 + str).exists()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int c(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getRequestedOrientation();
        }
        return -1;
    }

    public static String[] d(Context context) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
        Object invoke = cls.getMethod("getAdvertisingIdInfo", Context.class).invoke(cls, context);
        Method method = invoke.getClass().getMethod("getId", new Class[0]);
        Method method2 = invoke.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]);
        String obj = method.invoke(invoke, new Object[0]).toString();
        boolean booleanValue = ((Boolean) method2.invoke(invoke, new Object[0])).booleanValue();
        return new String[]{obj, "" + booleanValue};
    }

    public static int e() {
        return Build.VERSION.SDK_INT;
    }

    public static String f() {
        return Build.VERSION.RELEASE;
    }

    public static synchronized String g(Context context) {
        synchronized (e.class) {
            if (!TextUtils.isEmpty(b)) {
                return b;
            } else if (context == null) {
                return "";
            } else {
                String b2 = h.b(context, "supersonic_shared_preferen", "auid", "");
                b = b2;
                if (TextUtils.isEmpty(b2)) {
                    String uuid = UUID.randomUUID().toString();
                    b = uuid;
                    h.c(context, "supersonic_shared_preferen", "auid", uuid);
                }
                return b;
            }
        }
    }

    public static int h(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public static long i() {
        return B(Environment.getDataDirectory());
    }

    public static long j(String str) {
        return B(new File(str));
    }

    public static int k(Context context) {
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("level", -1) : 0;
            int intExtra2 = registerReceiver != null ? registerReceiver.getIntExtra("scale", -1) : 0;
            if (intExtra == -1 || intExtra2 == -1) {
                return -1;
            }
            return (int) ((intExtra / intExtra2) * 100.0f);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static float l() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static int m() {
        return x();
    }

    public static String n(Context context) throws Exception {
        return context.getResources().getConfiguration().locale.getLanguage();
    }

    public static String o(Context context) throws Exception {
        return context.getResources().getConfiguration().locale.getCountry();
    }

    public static long p() {
        return Calendar.getInstance(TimeZone.getDefault()).getTime().getTime();
    }

    public static String q() {
        return Build.MODEL;
    }

    public static String r() {
        return Build.MANUFACTURER;
    }

    public static int s(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    public static String t() {
        return TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE;
    }

    public static String u() {
        String id = TimeZone.getDefault().getID();
        return id != null ? id : "";
    }

    public static int v() {
        return -(TimeZone.getDefault().getOffset(p()) / 60000);
    }

    public static int w() {
        return y();
    }

    public static int x() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int y() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static File z(Context context) {
        return context.getExternalCacheDir();
    }
}
