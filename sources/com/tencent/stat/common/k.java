package com.tencent.stat.common;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.adjust.sdk.Constants;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.growingio.android.sdk.utils.NetworkUtil;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.tencent.stat.StatConfig;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
/* loaded from: classes3.dex */
public class k {
    private static String a = null;
    private static String b = null;
    private static String c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String f8298d = null;

    /* renamed from: e  reason: collision with root package name */
    private static Random f8299e = null;

    /* renamed from: f  reason: collision with root package name */
    private static StatLogger f8300f = null;

    /* renamed from: g  reason: collision with root package name */
    private static String f8301g = null;

    /* renamed from: h  reason: collision with root package name */
    private static l f8302h = null;

    /* renamed from: i  reason: collision with root package name */
    private static n f8303i = null;

    /* renamed from: j  reason: collision with root package name */
    private static String f8304j = "__MTA_FIRST_ACTIVATE__";

    /* renamed from: k  reason: collision with root package name */
    private static int f8305k = -1;

    public static String A(Context context) {
        List<Sensor> sensorList;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < sensorList.size(); i2++) {
                sb.append(sensorList.get(i2).getType());
                if (i2 != sensorList.size() - 1) {
                    sb.append(",");
                }
            }
            return sb.toString();
        } catch (Throwable th) {
            f8300f.e(th);
            return "";
        }
    }

    public static WifiInfo B(Context context) {
        WifiManager wifiManager;
        if (!a(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null) {
            return null;
        }
        return wifiManager.getConnectionInfo();
    }

    public static String C(Context context) {
        try {
            WifiInfo B = B(context);
            if (B != null) {
                return B.getBSSID();
            }
            return null;
        } catch (Throwable th) {
            f8300f.e(th);
            return null;
        }
    }

    public static String D(Context context) {
        try {
            WifiInfo B = B(context);
            if (B != null) {
                return B.getSSID();
            }
            return null;
        } catch (Throwable th) {
            f8300f.e(th);
            return null;
        }
    }

    public static synchronized int E(Context context) {
        synchronized (k.class) {
            int i2 = f8305k;
            if (i2 != -1) {
                return i2;
            }
            F(context);
            return f8305k;
        }
    }

    public static void F(Context context) {
        int a2 = p.a(context, f8304j, 1);
        f8305k = a2;
        f8300f.e(Integer.valueOf(a2));
        if (f8305k == 1) {
            p.b(context, f8304j, 0);
        }
    }

    private static long G(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static int a() {
        return h().nextInt(Integer.MAX_VALUE);
    }

    public static Long a(String str, String str2, int i2, int i3, Long l2) {
        if (str != null && str2 != null) {
            if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase(Effect.DIVIDER)) {
                str2 = "\\" + str2;
            }
            String[] split = str.split(str2);
            if (split.length == i3) {
                try {
                    Long l3 = 0L;
                    for (String str3 : split) {
                        l3 = Long.valueOf(i2 * (l3.longValue() + Long.valueOf(str3).longValue()));
                    }
                    return l3;
                } catch (NumberFormatException unused) {
                }
            }
        }
        return l2;
    }

    public static String a(long j2) {
        return new SimpleDateFormat(AdvTimeUtils.DATE_FORMAT_DAY).format(new Date(j2));
    }

    public static String a(String str) {
        if (str == null) {
            return "0";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                int i2 = b2 & Draft_75.END_OF_FRAME;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "0";
        }
    }

    public static HttpHost a(Context context) {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        if (context == null) {
            return null;
        }
        try {
        } catch (Throwable th) {
            f8300f.e(th);
        }
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0 && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null) {
            if ((activeNetworkInfo.getTypeName() == null || !activeNetworkInfo.getTypeName().equalsIgnoreCase(NetworkUtil.NETWORK_WIFI)) && (extraInfo = activeNetworkInfo.getExtraInfo()) != null) {
                if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap") && !extraInfo.equals("uniwap")) {
                    if (extraInfo.equals("ctwap")) {
                        return new HttpHost("10.0.0.200", 80);
                    }
                    return null;
                }
                return new HttpHost("10.0.0.172", 80);
            }
            return null;
        }
        return null;
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable th) {
                f8300f.e(th);
            }
        }
    }

    public static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            f8300f.e(th);
            return false;
        }
    }

    public static byte[] a(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
    }

    public static long b(String str) {
        return a(str, ".", 100, 3, 0L).longValue();
    }

    public static synchronized StatLogger b() {
        StatLogger statLogger;
        synchronized (k.class) {
            if (f8300f == null) {
                StatLogger statLogger2 = new StatLogger("MtaSDK");
                f8300f = statLogger2;
                statLogger2.setDebugEnable(false);
            }
            statLogger = f8300f;
        }
        return statLogger;
    }

    public static synchronized String b(Context context) {
        synchronized (k.class) {
            String str = a;
            if (str != null && str.trim().length() != 0) {
                return a;
            }
            String l2 = l(context);
            a = l2;
            if (l2 == null || l2.trim().length() == 0) {
                a = Integer.toString(h().nextInt(Integer.MAX_VALUE));
            }
            return a;
        }
    }

    public static String b(Context context, String str) {
        if (StatConfig.isEnableConcurrentProcess()) {
            if (f8301g == null) {
                f8301g = u(context);
            }
            if (f8301g != null) {
                return str + "_" + f8301g;
            }
        }
        return str;
    }

    public static long c() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis() + AdvTimeUtils.MILLIS_OF_A_DAY;
        } catch (Throwable th) {
            f8300f.e(th);
            return System.currentTimeMillis() + AdvTimeUtils.MILLIS_OF_A_DAY;
        }
    }

    public static synchronized String c(Context context) {
        String str;
        synchronized (k.class) {
            String str2 = c;
            if (str2 == null || "" == str2) {
                c = f(context);
            }
            str = c;
        }
        return str;
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(g.b(e.a(str.getBytes("UTF-8")), 0), "UTF-8");
        } catch (Throwable th) {
            f8300f.e(th);
            return str;
        }
    }

    public static int d() {
        return Build.VERSION.SDK_INT;
    }

    public static DisplayMetrics d(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(e.b(g.a(str.getBytes("UTF-8"), 0)), "UTF-8");
        } catch (Throwable th) {
            f8300f.e(th);
            return str;
        }
    }

    public static String e() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return String.valueOf((statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1000000) + "/" + String.valueOf(f() / 1000000);
    }

    public static boolean e(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
        } catch (Throwable th) {
            f8300f.e(th);
        }
        if (!a(context, "android.permission.ACCESS_WIFI_STATE")) {
            f8300f.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
            for (int i2 = 0; i2 < allNetworkInfo.length; i2++) {
                if (allNetworkInfo[i2].getTypeName().equalsIgnoreCase(NetworkUtil.NETWORK_WIFI) && allNetworkInfo[i2].isConnected()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static long f() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    public static String f(Context context) {
        if (!a(context, "android.permission.ACCESS_WIFI_STATE")) {
            f8300f.e("Could not get permission of android.permission.ACCESS_WIFI_STATE");
            return "";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return wifiManager == null ? "" : wifiManager.getConnectionInfo().getMacAddress();
        } catch (Exception e2) {
            f8300f.e(e2);
            return "";
        }
    }

    public static boolean g(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            if (a(context, "android.permission.INTERNET") && a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getTypeName().equalsIgnoreCase(NetworkUtil.NETWORK_WIFI);
            }
            f8300f.warn("can not get the permisson of android.permission.INTERNET");
        } catch (Throwable th) {
            f8300f.e(th);
        }
        return false;
    }

    private static synchronized Random h() {
        Random random;
        synchronized (k.class) {
            if (f8299e == null) {
                f8299e = new Random();
            }
            random = f8299e;
        }
        return random;
    }

    public static boolean h(Context context) {
        try {
            if (a(context, "android.permission.INTERNET") && a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                        f8300f.w("Network error");
                        return false;
                    }
                    return true;
                }
            } else {
                f8300f.warn("can not get the permisson of android.permission.INTERNET");
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static long i() {
        long j2 = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            j2 = Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * 1024;
            bufferedReader.close();
            return j2;
        } catch (IOException unused) {
            return j2;
        }
    }

    public static String i(Context context) {
        String str = b;
        if (str != null) {
            return str;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("TA_APPKEY");
                if (string != null) {
                    b = string;
                    return string;
                }
                f8300f.w("Could not read APPKEY meta-data from AndroidManifest.xml");
                return null;
            }
            return null;
        } catch (Throwable unused) {
            f8300f.w("Could not read APPKEY meta-data from AndroidManifest.xml");
            return null;
        }
    }

    public static String j(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj = applicationInfo.metaData.get("InstallChannel");
                if (obj != null) {
                    return obj.toString();
                }
                f8300f.w("Could not read InstallChannel meta-data from AndroidManifest.xml");
                return null;
            }
            return null;
        } catch (Throwable unused) {
            f8300f.e("Could not read InstallChannel meta-data from AndroidManifest.xml");
            return null;
        }
    }

    public static String k(Context context) {
        if (context == null) {
            return null;
        }
        return context.getClass().getName();
    }

    public static String l(Context context) {
        try {
            if (!a(context, "android.permission.READ_PHONE_STATE")) {
                f8300f.e("Could not get permission of android.permission.READ_PHONE_STATE");
                return null;
            }
            String deviceId = o(context) ? ((TelephonyManager) context.getSystemService("phone")).getDeviceId() : "";
            if (deviceId != null) {
                return deviceId;
            }
            return null;
        } catch (Throwable th) {
            f8300f.e(th);
            return null;
        }
    }

    public static String m(Context context) {
        TelephonyManager telephonyManager;
        String str = null;
        try {
            if (!a(context, "android.permission.READ_PHONE_STATE")) {
                f8300f.e("Could not get permission of android.permission.READ_PHONE_STATE");
            } else if (o(context) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                str = telephonyManager.getSimOperator();
            }
        } catch (Throwable th) {
            f8300f.e(th);
        }
        return str;
    }

    public static String n(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return str == null ? "" : str;
        } catch (Throwable th) {
            f8300f.e(th);
            return "";
        }
    }

    public static boolean o(Context context) {
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0;
    }

    public static String p(Context context) {
        String str = null;
        try {
        } catch (Throwable th) {
            f8300f.e(th);
        }
        if (a(context, "android.permission.INTERNET") && a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                String typeName = activeNetworkInfo.getTypeName();
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (typeName != null) {
                    if (!typeName.equalsIgnoreCase(NetworkUtil.NETWORK_WIFI)) {
                        if (typeName.equalsIgnoreCase("MOBILE")) {
                            str = extraInfo != null ? extraInfo : "MOBILE";
                        } else {
                            if (extraInfo == null) {
                                str = typeName;
                            }
                        }
                        f8300f.e(th);
                        return str;
                    }
                    str = NetworkUtil.NETWORK_WIFI;
                }
            }
        } else {
            f8300f.e("can not get the permission of android.permission.ACCESS_WIFI_STATE");
        }
        return str;
    }

    public static Integer q(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String r(Context context) {
        String str = "";
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            f8300f.e(th);
        }
        return str != null ? str.length() == 0 ? "unknown" : str : "unknown";
    }

    public static int s(Context context) {
        try {
            return o.a() ? 1 : 0;
        } catch (Throwable th) {
            f8300f.e(th);
            return 0;
        }
    }

    public static String t(Context context) {
        String path;
        try {
        } catch (Throwable th) {
            f8300f.e(th);
        }
        if (!a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            f8300f.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        }
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState != null && externalStorageState.equals("mounted") && (path = Environment.getExternalStorageDirectory().getPath()) != null) {
            StatFs statFs = new StatFs(path);
            return String.valueOf((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1000000) + "/" + String.valueOf((statFs.getBlockCount() * statFs.getBlockSize()) / 1000000);
        }
        return null;
    }

    static String u(Context context) {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String v(Context context) {
        return b(context, StatConstants.a);
    }

    public static synchronized Integer w(Context context) {
        Integer valueOf;
        synchronized (k.class) {
            int i2 = 0;
            try {
                int a2 = p.a(context, "MTA_EVENT_INDEX", 0);
                if (a2 < 2147483646) {
                    i2 = a2;
                }
                p.b(context, "MTA_EVENT_INDEX", i2 + 1);
                valueOf = Integer.valueOf(i2 + 1);
            }
        }
        return valueOf;
    }

    public static String x(Context context) {
        return String.valueOf(G(context) / 1000000) + "/" + String.valueOf(i() / 1000000);
    }

    public static synchronized l y(Context context) {
        l lVar;
        synchronized (k.class) {
            if (f8302h == null) {
                f8302h = new l();
            }
            lVar = f8302h;
        }
        return lVar;
    }

    public static JSONObject z(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            y(context);
            int b2 = l.b();
            if (b2 > 0) {
                jSONObject.put("fx", b2 / 1000000);
            }
            y(context);
            int c2 = l.c();
            if (c2 > 0) {
                jSONObject.put("fn", c2 / 1000000);
            }
            y(context);
            int a2 = l.a();
            if (a2 > 0) {
                jSONObject.put("n", a2);
            }
            y(context);
            String d2 = l.d();
            if (d2 != null && d2.length() == 0) {
                y(context);
                jSONObject.put("na", l.d());
            }
        } catch (Exception e2) {
            f8300f.e(e2);
        }
        return jSONObject;
    }
}
