package com.weibo.ssosdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.tapjoy.TapjoyConstants;
import java.io.UnsupportedEncodingException;
import java.net.NetworkInterface;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* loaded from: classes3.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b {
        private Intent a;

        /* JADX INFO: Access modifiers changed from: private */
        public int e() {
            return this.a.getIntExtra("level", 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int f() {
            return this.a.getIntExtra("scale", 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int g() {
            return this.a.getIntExtra("temperature", 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int h() {
            return this.a.getIntExtra("voltage", 0);
        }

        private b(Context context) {
            this.a = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }
    }

    private static String a(Context context) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            String p = p();
            if (!TextUtils.isEmpty(p)) {
                jSONObject.put("os", p);
            }
            String i2 = i(context);
            if (!TextUtils.isEmpty(i2)) {
                jSONObject.put("imei", i2);
            }
            String m = m(context);
            if (!TextUtils.isEmpty(m)) {
                jSONObject.put("meid", m);
            }
            String j2 = j(context);
            if (!TextUtils.isEmpty(j2)) {
                jSONObject.put("imsi", j2);
            }
            String k2 = k(context);
            if (!TextUtils.isEmpty(k2)) {
                jSONObject.put("mac", k2);
            }
            String h2 = h(context);
            if (!TextUtils.isEmpty(h2)) {
                jSONObject.put("iccid", h2);
            }
            String s = s();
            if (!TextUtils.isEmpty(s)) {
                jSONObject.put("serial", s);
            }
            String c = c(context);
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put("androidid", c);
            }
            String f2 = f();
            if (!TextUtils.isEmpty(f2)) {
                jSONObject.put("cpu", f2);
            }
            String o = o();
            if (!TextUtils.isEmpty(o)) {
                jSONObject.put(BigAlbumStore.PhotoTagColumns.MODEL, o);
            }
            String r = r();
            if (!TextUtils.isEmpty(r)) {
                jSONObject.put("sdcard", r);
            }
            String q = q(context);
            if (!TextUtils.isEmpty(q)) {
                jSONObject.put("resolution", q);
            }
            String u = u(context);
            if (!TextUtils.isEmpty(u)) {
                jSONObject.put("ssid", u);
            }
            String v = v(context);
            if (!TextUtils.isEmpty(v)) {
                jSONObject.put("bssid", v);
            }
            String g2 = g();
            if (!TextUtils.isEmpty(g2)) {
                jSONObject.put("deviceName", g2);
            }
            String e2 = e(context);
            if (!TextUtils.isEmpty(e2)) {
                jSONObject.put("connecttype", e2);
            }
            try {
                str = b(context);
            } catch (Exception e3) {
                e3.printStackTrace();
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("ua", str);
            }
            double d2 = d(context);
            jSONObject.put("batterymaxcapacity", String.valueOf(d2));
            jSONObject.put("batterycurrentcapacity", String.valueOf(d2));
            b bVar = new b(context);
            jSONObject.put("batterycurrentvoltage", bVar.h());
            jSONObject.put("batterycurrenttemperature", bVar.g());
            jSONObject.put("batterycurrentcapacity", (d2 * bVar.e()) / bVar.f());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    private static String b(Context context) {
        StringBuilder sb = new StringBuilder();
        String packageName = context.getPackageName();
        String str = (TextUtils.isEmpty(packageName) || !packageName.contains("com.sina.weibo")) ? "ssosdk" : "weibo";
        sb.append(Build.MANUFACTURER);
        sb.append(PGTransHeader.CONNECTOR);
        sb.append(Build.MODEL);
        sb.append("__");
        sb.append(str);
        sb.append("__");
        try {
            sb.append("1.0".replaceAll("\\s+", "_"));
        } catch (Exception unused) {
            sb.append("unknown");
        }
        sb.append("__android__android");
        sb.append(Build.VERSION.RELEASE);
        return sb.toString();
    }

    private static String c(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
        } catch (Exception unused) {
            return "";
        }
    }

    private static double d(Context context) {
        Object obj;
        try {
            obj = Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context);
        } catch (Exception unused) {
            obj = null;
        }
        try {
            return ((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getAveragePower", String.class).invoke(obj, "battery.capacity")).doubleValue();
        } catch (Exception unused2) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
    }

    private static String e(Context context) {
        String str = PortalFollowFeeds.TYPE_NONE;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            str = "2G";
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            str = "3G";
                            break;
                        case 13:
                            str = "4G";
                            break;
                    }
                } else if (activeNetworkInfo.getType() == 1) {
                    str = "wifi";
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }

    private static String f() {
        try {
            return Build.CPU_ABI;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String g() {
        try {
            return Build.BRAND;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String h(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
        } catch (Exception unused) {
            return "";
        }
    }

    private static String i(Context context) {
        Log.e("getImei", "com/weibo/ssosdk/MfpBuilder->getImei:  is returned");
        return "";
    }

    private static String j(Context context) {
        Log.e("getImsi", "com/weibo/ssosdk/MfpBuilder->getImsi:  is returned");
        return "";
    }

    private static String k(Context context) {
        WifiInfo connectionInfo;
        if (Build.VERSION.SDK_INT >= 23) {
            return l();
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                return connectionInfo.getMacAddress();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private static String l() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i2])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    private static String m(Context context) {
        Log.e("getMeid", "com/weibo/ssosdk/MfpBuilder->getMeid:  is returned");
        return "";
    }

    public static String n(Context context) {
        try {
            return new String(a(context).getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    private static String o() {
        try {
            return Build.MODEL;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String p() {
        try {
            return "Android " + Build.VERSION.RELEASE;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String q(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return String.valueOf(displayMetrics.widthPixels) + Marker.ANY_MARKER + String.valueOf(displayMetrics.heightPixels);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String r() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.toString(statFs.getBlockCount() * statFs.getBlockSize());
        } catch (Exception unused) {
            return "";
        }
    }

    private static String s() {
        if (Build.VERSION.SDK_INT >= 26) {
            return t();
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.serialno", "unknown");
        } catch (Exception unused) {
            return "";
        }
    }

    @TargetApi(26)
    private static String t() {
        try {
            return Build.getSerial();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static String u(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getSSID() : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String v(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getBSSID() : "";
        } catch (SecurityException unused) {
            return "";
        }
    }

    public static void w(Context context) {
    }
}
