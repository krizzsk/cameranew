package com.growingio.android.sdk.monitor.event.helper;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.monitor.event.EventBuilder;
import com.growingio.android.sdk.monitor.event.Sdk;
import com.growingio.android.sdk.monitor.event.interfaces.UserInterface;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes2.dex */
public class AndroidEventBuilderHelper implements EventBuilderHelper {
    private static final Boolean IS_EMULATOR = isEmulator();
    private static final String KERNEL_VERSION = getKernelVersion();
    public static final String TAG = "com.growingio.android.sdk.monitor.event.helper.AndroidEventBuilderHelper";
    private Context appCtx;
    private com.growingio.android.sdk.monitor.context.Context ctx;

    public AndroidEventBuilderHelper(Context context, com.growingio.android.sdk.monitor.context.Context context2) {
        this.appCtx = context;
        this.ctx = context2;
    }

    private static String getApplicationName(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i2 = applicationInfo.labelRes;
            if (i2 == 0) {
                CharSequence charSequence = applicationInfo.nonLocalizedLabel;
                if (charSequence != null) {
                    return charSequence.toString();
                }
                return null;
            }
            return context.getString(i2);
        } catch (Exception e2) {
            Log.e(TAG, "Error getting application name.", e2);
            return null;
        }
    }

    private static Float getBatteryLevel(Context context) {
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null) {
                return null;
            }
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (intExtra != -1 && intExtra2 != -1) {
                return Float.valueOf((intExtra / intExtra2) * 100.0f);
            }
            return null;
        } catch (Exception e2) {
            Log.e(TAG, "Error getting device battery level.", e2);
            return null;
        }
    }

    private Map<String, Map<String, Object>> getContexts() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        hashMap.put("os", hashMap3);
        hashMap.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, hashMap2);
        hashMap.put("app", hashMap4);
        hashMap2.put("manufacturer", Build.MANUFACTURER);
        hashMap2.put("brand", Build.BRAND);
        hashMap2.put(BigAlbumStore.PhotoTagColumns.MODEL, Build.MODEL);
        hashMap2.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_FAMILIY, getFamily());
        hashMap2.put("model_id", Build.ID);
        hashMap2.put("battery_level", getBatteryLevel(this.appCtx));
        hashMap2.put("orientation", getOrientation(this.appCtx));
        hashMap2.put("simulator", IS_EMULATOR);
        hashMap2.put("arch", Build.CPU_ABI);
        hashMap2.put("storage_size", getTotalInternalStorage());
        hashMap2.put("free_storage", getUnusedInternalStorage());
        hashMap2.put("external_storage_size", getTotalExternalStorage());
        hashMap2.put("external_free_storage", getUnusedExternalStorage());
        hashMap2.put("charging", isCharging(this.appCtx));
        hashMap2.put("online", Boolean.valueOf(isConnected(this.appCtx)));
        DisplayMetrics displayMetrics = getDisplayMetrics(this.appCtx);
        if (displayMetrics != null) {
            int max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            hashMap2.put("screen_resolution", Integer.toString(max) + "x" + Integer.toString(min));
            hashMap2.put(TapjoyConstants.TJC_DEVICE_SCREEN_DENSITY, Float.valueOf(displayMetrics.density));
            hashMap2.put("screen_dpi", Integer.valueOf(displayMetrics.densityDpi));
        }
        ActivityManager.MemoryInfo memInfo = getMemInfo(this.appCtx);
        if (memInfo != null) {
            hashMap2.put("free_memory", Long.valueOf(memInfo.availMem));
            if (Build.VERSION.SDK_INT >= 16) {
                hashMap2.put("memory_size", Long.valueOf(memInfo.totalMem));
            }
            hashMap2.put("low_memory", Boolean.valueOf(memInfo.lowMemory));
        }
        hashMap3.put("name", Constants.PLATFORM_ANDROID);
        hashMap3.put("version", Build.VERSION.RELEASE);
        hashMap3.put("build", Build.DISPLAY);
        hashMap3.put("kernel_version", KERNEL_VERSION);
        hashMap3.put("rooted", isRooted());
        PackageInfo packageInfo = getPackageInfo(this.appCtx);
        if (packageInfo != null) {
            hashMap4.put(TapjoyConstants.TJC_APP_VERSION_NAME, packageInfo.versionName);
            hashMap4.put("app_build", Integer.valueOf(packageInfo.versionCode));
            hashMap4.put("app_identifier", packageInfo.packageName);
        }
        hashMap4.put("app_name", getApplicationName(this.appCtx));
        hashMap4.put("app_start_time", stringifyDate(new Date()));
        for (Sdk sdk : this.ctx.getIntegrationSdk()) {
            hashMap4.put(sdk.getName(), sdk.getVersion());
        }
        return hashMap;
    }

    private static DisplayMetrics getDisplayMetrics(Context context) {
        try {
            return context.getResources().getDisplayMetrics();
        } catch (Exception e2) {
            Log.e(TAG, "Error getting DisplayMetrics.", e2);
            return null;
        }
    }

    private static String getFamily() {
        try {
            return Build.MODEL.split(" ")[0];
        } catch (Exception e2) {
            Log.e(TAG, "Error getting device family.", e2);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String getKernelVersion() {
        /*
            java.lang.String r0 = "Exception while attempting to read kernel information"
            java.lang.String r1 = "os.version"
            java.lang.String r1 = java.lang.System.getProperty(r1)
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            java.lang.String r4 = "/proc/version"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            boolean r4 = r3.canRead()     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            if (r4 != 0) goto L17
            return r1
        L17:
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            java.io.FileReader r5 = new java.io.FileReader     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            java.lang.String r1 = r4.readLine()     // Catch: java.lang.Exception -> L30 java.lang.Throwable -> L49
            r4.close()     // Catch: java.io.IOException -> L29
            goto L2f
        L29:
            r2 = move-exception
            java.lang.String r3 = com.growingio.android.sdk.monitor.event.helper.AndroidEventBuilderHelper.TAG
            android.util.Log.e(r3, r0, r2)
        L2f:
            return r1
        L30:
            r2 = move-exception
            goto L37
        L32:
            r1 = move-exception
            goto L4b
        L34:
            r3 = move-exception
            r4 = r2
            r2 = r3
        L37:
            java.lang.String r3 = com.growingio.android.sdk.monitor.event.helper.AndroidEventBuilderHelper.TAG     // Catch: java.lang.Throwable -> L49
            android.util.Log.e(r3, r0, r2)     // Catch: java.lang.Throwable -> L49
            if (r4 == 0) goto L48
            r4.close()     // Catch: java.io.IOException -> L42
            goto L48
        L42:
            r2 = move-exception
            java.lang.String r3 = com.growingio.android.sdk.monitor.event.helper.AndroidEventBuilderHelper.TAG
            android.util.Log.e(r3, r0, r2)
        L48:
            return r1
        L49:
            r1 = move-exception
            r2 = r4
        L4b:
            if (r2 == 0) goto L57
            r2.close()     // Catch: java.io.IOException -> L51
            goto L57
        L51:
            r2 = move-exception
            java.lang.String r3 = com.growingio.android.sdk.monitor.event.helper.AndroidEventBuilderHelper.TAG
            android.util.Log.e(r3, r0, r2)
        L57:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.monitor.event.helper.AndroidEventBuilderHelper.getKernelVersion():java.lang.String");
    }

    private static ActivityManager.MemoryInfo getMemInfo(Context context) {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo;
        } catch (Exception e2) {
            Log.e(TAG, "Error getting MemoryInfo.", e2);
            return null;
        }
    }

    private static String getOrientation(Context context) {
        try {
            int i2 = context.getResources().getConfiguration().orientation;
            if (i2 != 1) {
                if (i2 != 2) {
                    return null;
                }
                return TJAdUnitConstants.String.LANDSCAPE;
            }
            return TJAdUnitConstants.String.PORTRAIT;
        } catch (Exception e2) {
            Log.e(TAG, "Error getting device orientation.", e2);
            return null;
        }
    }

    private static PackageInfo getPackageInfo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(TAG, "Error getting package info.", e2);
            return null;
        }
    }

    private static Long getTotalExternalStorage() {
        try {
            if (isExternalStorageMounted()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return Long.valueOf(statFs.getBlockCount() * statFs.getBlockSize());
            }
            return null;
        } catch (Exception e2) {
            Log.e(TAG, "Error getting total external storage amount.", e2);
            return null;
        }
    }

    private static Long getTotalInternalStorage() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return Long.valueOf(statFs.getBlockCount() * statFs.getBlockSize());
        } catch (Exception e2) {
            Log.e(TAG, "Error getting total internal storage amount.", e2);
            return null;
        }
    }

    private static Long getUnusedExternalStorage() {
        try {
            if (isExternalStorageMounted()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return Long.valueOf(statFs.getAvailableBlocks() * statFs.getBlockSize());
            }
            return null;
        } catch (Exception e2) {
            Log.e(TAG, "Error getting unused external storage amount.", e2);
            return null;
        }
    }

    private static Long getUnusedInternalStorage() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return Long.valueOf(statFs.getAvailableBlocks() * statFs.getBlockSize());
        } catch (Exception e2) {
            Log.e(TAG, "Error getting unused internal storage amount.", e2);
            return null;
        }
    }

    private static Boolean isCharging(Context context) {
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null) {
                return null;
            }
            int intExtra = registerReceiver.getIntExtra("plugged", -1);
            boolean z = true;
            if (intExtra != 1 && intExtra != 2) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception e2) {
            Log.e(TAG, "Error getting device charging state.", e2);
            return null;
        }
    }

    private static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private static Boolean isEmulator() {
        boolean z;
        try {
            String str = Build.FINGERPRINT;
            if (!str.startsWith("generic") && !str.startsWith("unknown")) {
                String str2 = Build.MODEL;
                if (!str2.contains("google_sdk") && !str2.contains("Emulator") && !str2.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion") && ((!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) && !"google_sdk".equals(Build.PRODUCT))) {
                    z = false;
                    return Boolean.valueOf(z);
                }
            }
            z = true;
            return Boolean.valueOf(z);
        } catch (Exception e2) {
            Log.e(TAG, "Error checking whether application is running in an emulator.", e2);
            return null;
        }
    }

    private static boolean isExternalStorageMounted() {
        return Environment.getExternalStorageState().equals("mounted") && !Environment.isExternalStorageEmulated();
    }

    private static Boolean isRooted() {
        String str = Build.TAGS;
        if (str != null && str.contains("test-keys")) {
            return Boolean.TRUE;
        }
        int i2 = 15;
        String[] strArr = {"/data/local/bin/su", "/data/local/su", "/data/local/xbin/su", "/sbin/su", "/su/bin", "/su/bin/su", "/system/app/SuperSU", "/system/app/SuperSU.apk", "/system/app/Superuser", "/system/app/Superuser.apk", "/system/bin/failsafe/su", "/system/bin/su", "/system/sd/xbin/su", "/system/xbin/daemonsu", "/system/xbin/su"};
        for (int i3 = 0; i3 < i2; i3++) {
            try {
            } catch (Exception e2) {
                Log.e(TAG, "Exception while attempting to detect whether the device is rooted", e2);
            }
            if (new File(strArr[i3]).exists()) {
                return Boolean.TRUE;
            }
            continue;
        }
        return Boolean.FALSE;
    }

    private static String stringifyDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH).format(date);
    }

    @Override // com.growingio.android.sdk.monitor.event.helper.EventBuilderHelper
    public void helpBuildingEvent(EventBuilder eventBuilder) {
        eventBuilder.withSdkIntegration(TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
        PackageInfo packageInfo = getPackageInfo(this.appCtx);
        if (packageInfo != null) {
            if (eventBuilder.getEvent().getRelease() == null) {
                eventBuilder.withRelease(packageInfo.packageName + PGTransHeader.CONNECTOR + packageInfo.versionName);
            }
            if (eventBuilder.getEvent().getDist() == null) {
                eventBuilder.withDist(Integer.toString(packageInfo.versionCode));
            }
        }
        String string = Settings.Secure.getString(this.appCtx.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
        if (string != null && !string.trim().equals("")) {
            eventBuilder.withMonitorInterface(new UserInterface("android:" + string, null, null), false);
        }
        eventBuilder.withContexts(getContexts());
    }
}
