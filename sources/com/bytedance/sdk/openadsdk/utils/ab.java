package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.growingio.android.sdk.collection.Constants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: ToolUtils.java */
/* loaded from: classes.dex */
public class ab {
    private static ExecutorService a = Executors.newSingleThreadExecutor();
    private static aa b = new aa();
    private static String c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String f2099d = null;

    /* renamed from: e  reason: collision with root package name */
    private static String f2100e = null;

    /* renamed from: f  reason: collision with root package name */
    private static String f2101f = null;

    /* renamed from: g  reason: collision with root package name */
    private static HashSet<String> f2102g = new HashSet<>(Arrays.asList("Asia/Shanghai", "Asia/Urumqi", "Asia/Chongqing", "Asia/Harbin", "Asia/Kashgar"));

    /* compiled from: ToolUtils.java */
    /* loaded from: classes.dex */
    public static class a implements Callable<String> {
        int a;

        a(int i2) {
            this.a = 1;
            this.a = i2;
        }

        private String b() {
            String str;
            Throwable th;
            try {
                str = System.getProperty("http.agent");
                if (str != null) {
                    try {
                        if (!"unKnow".equals(str)) {
                            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_ua_data", "android_system_ua", str);
                            } else {
                                com.bytedance.sdk.openadsdk.core.d.a(com.bytedance.sdk.openadsdk.core.o.a()).a("android_system_ua", str);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        o.e("getUA", "e:" + th.getMessage());
                        return str;
                    }
                }
            } catch (Throwable th3) {
                str = "unKnow";
                th = th3;
            }
            return str;
        }

        private synchronized String c() {
            final String[] strArr;
            strArr = new String[]{"unKnow"};
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.ab.a.1
                @Override // java.lang.Runnable
                public void run() {
                    strArr[0] = ab.q();
                    o.b("getUA", "webview ua：" + strArr[0]);
                }
            });
            while ("unKnow".equals(strArr[0])) {
            }
            return strArr[0];
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public synchronized String call() throws Exception {
            String c;
            c = this.a == 1 ? c() : "unKnow";
            if (this.a == 2) {
                c = b();
            }
            return c;
        }
    }

    public static Intent a(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(PGImageSDK.SDK_STATUS_CREATE);
        return launchIntentForPackage;
    }

    public static String a(int i2) {
        switch (i2) {
            case 1:
                return "embeded_ad_landingpage";
            case 2:
                return "banner_ad_landingpage";
            case 3:
                return "interaction_landingpage";
            case 4:
                return "splash_ad_landingpage";
            case 5:
                return "fullscreen_interstitial_ad";
            case 6:
                return "draw_ad_landingpage";
            case 7:
                return "rewarded_video_landingpage";
            default:
                return null;
        }
    }

    public static void a(@NonNull com.bytedance.sdk.openadsdk.core.d.h hVar, @NonNull View view) {
    }

    public static String b(int i2) {
        return i2 != 1 ? i2 != 2 ? (i2 == 3 || i2 == 4) ? "splash_ad" : i2 != 7 ? i2 != 8 ? i2 != 9 ? "embeded_ad" : "draw_ad" : "fullscreen_interstitial_ad" : "rewarded_video" : "interaction" : "banner_ad";
    }

    public static boolean b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean c(Context context, String str) {
        return (com.bytedance.sdk.openadsdk.core.h.b() == null || com.bytedance.sdk.openadsdk.core.h.b().a()) ? false : true;
    }

    public static boolean d(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + Uri.encode(str)));
                if (!(context instanceof Activity)) {
                    intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
                }
                b.a(context, intent, null);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static long e(String str) {
        JSONObject b2 = b(str);
        if (b2 != null) {
            return b2.optLong("uid", 0L);
        }
        return 0L;
    }

    public static int f(String str) {
        JSONObject b2 = b(str);
        if (b2 != null) {
            return b2.optInt("ut", 0);
        }
        return 0;
    }

    public static double g(String str) {
        JSONObject b2 = b(str);
        return b2 != null ? b2.optDouble("pack_time", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public static String h(String str) {
        JSONObject b2 = b(str);
        return b2 != null ? b2.optString("req_id", "") : "";
    }

    public static String i(@NonNull String str) {
        String a2;
        String o = com.bytedance.sdk.openadsdk.core.o.h().o();
        if (TextUtils.isEmpty(o)) {
            if (l() == 1) {
                return Constants.HTTPS_PROTOCOL_PREFIX + "pangolin.snssdk.com" + str;
            } else if (l() == 2) {
                return Constants.HTTPS_PROTOCOL_PREFIX + "pangolin16.sgsnssdk.com" + str;
            } else {
                return Constants.HTTPS_PROTOCOL_PREFIX + "pangolin16.isnssdk.com" + str;
            }
        }
        String str2 = Constants.HTTPS_PROTOCOL_PREFIX + o + str;
        return (!aa.a(com.bytedance.sdk.openadsdk.core.o.a()) || (a2 = aa.a("testIp.txt")) == null) ? str2 : aa.a(str2, a2);
    }

    public static String j() {
        return l() == 1 ? "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/package.json" : l() == 2 ? "https://sf-tb-sg.ibytedtos.com/obj/ad-pattern-sg/renderer/package_sg.json" : "https://sf16-muse-va.ibytedtos.com/obj/ad-pattern-va/renderer/package_va.json";
    }

    public static String k() {
        try {
            return TimeZone.getDefault().getID();
        } catch (Exception e2) {
            o.e("ToolUtils", e2.toString());
            return "";
        }
    }

    public static int l() {
        try {
            String id = TimeZone.getDefault().getID();
            if (f2102g.contains(id)) {
                return 1;
            }
            if (id != null) {
                return id.startsWith("Asia/") ? 2 : 3;
            }
            return 3;
        } catch (Exception e2) {
            o.e("ToolUtils", e2.toString());
            return 3;
        }
    }

    public static boolean m() {
        String t = com.bytedance.sdk.openadsdk.core.o.h().t();
        o.b("isGDPRTimeZone", "isGDPRTimeZone-》dc:" + t);
        if (TextUtils.isEmpty(t)) {
            try {
                String id = TimeZone.getDefault().getID();
                o.b("isGDPRTimeZone", "isGDPRTimeZone-》isGDPRTimeZone:id:" + id);
                if (id != null) {
                    if (!id.startsWith("Europe/")) {
                        return false;
                    }
                }
            } catch (Exception e2) {
                o.e("ToolUtils", "can ignore msg : " + e2.toString());
            }
        } else if ("CN".equalsIgnoreCase(t) || "SG".equalsIgnoreCase(t)) {
            return false;
        }
        return true;
    }

    public static int n() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / com.adjust.sdk.Constants.ONE_HOUR;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    public static String o() {
        int i2 = -n();
        if (i2 >= 0) {
            return "Etc/GMT+" + i2;
        }
        return "Etc/GMT" + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String q() {
        try {
            String userAgentString = new WebView(com.bytedance.sdk.openadsdk.core.o.a()).getSettings().getUserAgentString();
            if (userAgentString != null && !"unKnow".equals(userAgentString)) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_ua_data", "webview_ua", userAgentString);
                } else {
                    com.bytedance.sdk.openadsdk.core.d.a(com.bytedance.sdk.openadsdk.core.o.a()).a("webview_ua", userAgentString);
                }
            }
            return userAgentString;
        } catch (Throwable th) {
            o.e("getUA", "e:" + th.getMessage());
            return "unKnow";
        }
    }

    public static boolean c(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        return hVar != null && c(hVar.M()) == 7;
    }

    public static boolean p(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$", str);
    }

    public static int c(String str) {
        JSONObject b2 = b(str);
        if (b2 != null) {
            return b2.optInt("ad_slot_type", 0);
        }
        return 0;
    }

    public static String e(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        if (hVar == null || hVar.K() == null || TextUtils.isEmpty(hVar.K().a())) {
            return null;
        }
        return hVar.K().a();
    }

    public static synchronized String f() {
        String str;
        synchronized (ab.class) {
            if (TextUtils.isEmpty(f2099d) && com.bytedance.sdk.openadsdk.core.o.a() != null) {
                f2099d = com.bytedance.sdk.openadsdk.core.o.a().getPackageName();
            }
            str = f2099d;
        }
        return str;
    }

    public static synchronized String g() {
        String str;
        synchronized (ab.class) {
            if (TextUtils.isEmpty(f2100e) && com.bytedance.sdk.openadsdk.core.o.a() != null) {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.o.a().getPackageManager().getPackageInfo(f(), 0);
                f2100e = String.valueOf(packageInfo.versionCode);
                f2101f = packageInfo.versionName;
            }
            str = f2100e;
        }
        return str;
    }

    public static synchronized String h() {
        String str;
        synchronized (ab.class) {
            if (TextUtils.isEmpty(f2101f) && com.bytedance.sdk.openadsdk.core.o.a() != null) {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.o.a().getPackageManager().getPackageInfo(f(), 0);
                f2100e = String.valueOf(packageInfo.versionCode);
                f2101f = packageInfo.versionName;
            }
            str = f2101f;
        }
        return str;
    }

    public static boolean j(String str) {
        try {
            return Pattern.compile("[一-龥]").matcher(str).find();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return o(str) || p(str);
    }

    public static JSONObject b(String str) {
        if (str != null) {
            try {
                return new JSONObject(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static String k(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 17) {
            return str;
        }
        return com.bytedance.sdk.openadsdk.core.a.b(str.substring(17), q(str.substring(1, 17)));
    }

    public static boolean o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$", str);
    }

    public static String c() {
        String b2;
        String str = "unKnow";
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_multi_ua_data", "webview_ua", "unKnow");
            } else {
                b2 = com.bytedance.sdk.openadsdk.core.d.a(com.bytedance.sdk.openadsdk.core.o.a()).b("webview_ua", "unKnow");
            }
        } catch (Exception e2) {
            o.e("getUA", "ee:" + e2.toString());
        }
        if (b2 != null && !"unKnow".equals(b2)) {
            o.b("getUA", "getWebViewUA5555---userAgent:" + b2);
            return b2;
        }
        FutureTask futureTask = new FutureTask(new a(1));
        a.execute(futureTask);
        str = (String) futureTask.get(1000L, TimeUnit.MILLISECONDS);
        o.b("getUA", "webview ua：" + str);
        return str;
    }

    public static String e() {
        try {
            byte[] bArr = new byte[8];
            new SecureRandom().nextBytes(bArr);
            return h.a(bArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        if (hVar != null) {
            return c(hVar.M()) == 3 || c(hVar.M()) == 4;
        }
        return false;
    }

    public static boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m(str) || n(str);
    }

    public static boolean a(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities;
        return (intent == null || (queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536)) == null || queryIntentActivities.size() <= 0) ? false : true;
    }

    public static String b() {
        String b2;
        String str = "unKnow";
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_multi_ua_data", "android_system_ua", "unKnow");
            } else {
                b2 = com.bytedance.sdk.openadsdk.core.d.a(com.bytedance.sdk.openadsdk.core.o.a()).b("android_system_ua", "unKnow");
            }
        } catch (Exception unused) {
        }
        if (b2 == null || "unKnow".equals(b2)) {
            FutureTask futureTask = new FutureTask(new a(2));
            a.execute(futureTask);
            str = (String) futureTask.get(500L, TimeUnit.MILLISECONDS);
            o.e("getUA", " getAndroidSystemUA userAgent" + str);
            return str;
        }
        return b2;
    }

    public static boolean d(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        return hVar != null && c(hVar.M()) == 8;
    }

    private static String q(String str) {
        String a2 = com.bytedance.sdk.openadsdk.core.a.a(str);
        if (str == null) {
            String a3 = com.bytedance.sdk.openadsdk.core.b.a();
            return a3.concat(a3).substring(8, 24);
        }
        return a2;
    }

    public static int d(String str) {
        JSONObject b2 = b(str);
        if (b2 != null) {
            return b2.optInt("rit", 0);
        }
        return 0;
    }

    public static String e(Context context, String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String readLine;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 4096);
                do {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            return null;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused3) {
                                }
                            }
                        }
                    }
                } while (!readLine.contains(str));
                if (readLine == null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused4) {
                    }
                    try {
                        fileReader.close();
                    } catch (Exception unused5) {
                    }
                    return null;
                }
                String[] split = readLine.split("\\s+");
                o.b("ToolUtils", "getTotalMemory = " + split[1]);
                String str2 = split[1];
                try {
                    bufferedReader.close();
                } catch (Exception unused6) {
                }
                try {
                    fileReader.close();
                } catch (Exception unused7) {
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
            bufferedReader = null;
        }
    }

    public static boolean f(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        if (hVar == null) {
            return true;
        }
        int c2 = com.bytedance.sdk.openadsdk.core.o.h().c(d(hVar.M()));
        if (c2 != 1) {
            return c2 != 2 ? c2 != 3 : q.e(com.bytedance.sdk.openadsdk.core.o.a()) || q.d(com.bytedance.sdk.openadsdk.core.o.a());
        }
        return q.d(com.bytedance.sdk.openadsdk.core.o.a());
    }

    public static int a(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1364000502:
                if (str.equals("rewarded_video")) {
                    c2 = 1;
                    break;
                }
                break;
            case -764631662:
                if (str.equals("fullscreen_interstitial_ad")) {
                    c2 = 2;
                    break;
                }
                break;
            case 174971131:
                if (str.equals("splash_ad")) {
                    c2 = 3;
                    break;
                }
                break;
            case 564365438:
                if (str.equals("cache_splash_ad")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1912999166:
                if (str.equals("draw_ad")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 2;
            case 1:
                return 7;
            case 2:
                return 5;
            case 3:
            case 4:
                return 4;
            case 5:
                return 3;
            case 6:
                return 6;
            default:
                return 1;
        }
    }

    public static String d() {
        return UUID.randomUUID().toString();
    }

    public static boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches("([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}", str);
    }

    public static boolean a(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        return hVar != null && c(hVar.M()) == 9;
    }

    public static String a() {
        String str;
        try {
            str = System.getProperty("http.agent");
        } catch (Exception unused) {
            str = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(";");
        if (lastIndexOf != -1 && str.length() > lastIndexOf) {
            int i2 = lastIndexOf + 1;
            String substring = str.substring(0, i2);
            String substring2 = str.substring(i2);
            str = substring.concat(" " + Locale.getDefault().getLanguage() + PGTransHeader.CONNECTOR + Locale.getDefault().getCountry() + ";").concat(substring2);
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String i() {
        String p = com.bytedance.sdk.openadsdk.core.o.h().p();
        if (TextUtils.isEmpty(p)) {
            return l() == 1 ? "https://extlog.snssdk.com/service/2/app_log/" : l() == 2 ? "https://log.sgsnssdk.com/service/2/app_log/" : "https://log-mva.isnssdk.com/service/2/app_log/";
        } else if (p.startsWith("http")) {
            return p;
        } else {
            return Constants.HTTPS_PROTOCOL_PREFIX + p;
        }
    }

    public static String b(@NonNull Context context) {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            String language = locale.getLanguage();
            String country = locale.getCountry();
            return language + "_" + country;
        } catch (Exception e2) {
            o.e("ToolUtils", e2.toString());
            return "";
        }
    }

    public static String c(@NonNull Context context) {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            return locale.getLanguage();
        } catch (Exception e2) {
            o.e("ToolUtils", e2.toString());
            return "";
        }
    }

    public static String a(Context context) {
        String b2 = com.bytedance.sdk.openadsdk.core.d.a(context).b("total_memory", (String) null);
        if (b2 == null) {
            String e2 = e(context, "MemTotal");
            com.bytedance.sdk.openadsdk.core.d.a(context).a("total_memory", e2);
            return e2;
        }
        return b2;
    }

    public static Map<String, Object> a(boolean z, com.bytedance.sdk.openadsdk.core.d.h hVar, long j2, long j3, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", hVar.J());
        hashMap.put("load_time", Long.valueOf(j2));
        com.bytedance.sdk.openadsdk.core.d.n v = hVar.v();
        if (v != null) {
            hashMap.put("video_size", Long.valueOf(v.d()));
            hashMap.put("video_resolution", v.f());
        }
        if (!z) {
            hashMap.put("error_code", Long.valueOf(j3));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            hashMap.put("error_message", str);
        }
        return hashMap;
    }

    public static Map<String, Object> a(long j2, com.bytedance.sdk.openadsdk.core.d.h hVar, com.bytedance.sdk.openadsdk.core.video.e.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("video_start_duration", Long.valueOf(j2));
        if (hVar != null) {
            if (!TextUtils.isEmpty(hVar.J())) {
                hashMap.put("creative_id", hVar.J());
            }
            com.bytedance.sdk.openadsdk.core.d.n v = hVar.v();
            if (v != null) {
                hashMap.put("video_resolution", v.f());
                hashMap.put("video_size", Long.valueOf(v.d()));
            }
        }
        a(hashMap, dVar);
        return hashMap;
    }

    public static Map<String, Object> a(com.bytedance.sdk.openadsdk.core.d.h hVar, int i2, int i3, com.bytedance.sdk.openadsdk.core.video.e.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", hVar.J());
        hashMap.put("error_code", Integer.valueOf(i2));
        hashMap.put("extra_error_code", Integer.valueOf(i3));
        com.bytedance.sdk.openadsdk.core.d.n v = hVar.v();
        if (v != null) {
            hashMap.put("video_size", Long.valueOf(v.d()));
            hashMap.put("video_resolution", v.f());
        }
        a(hashMap, dVar);
        return hashMap;
    }

    public static Map<String, Object> a(com.bytedance.sdk.openadsdk.core.d.h hVar, long j2, com.bytedance.sdk.openadsdk.core.video.e.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("creative_id", hVar.J());
        hashMap.put("buffers_time", Long.valueOf(j2));
        com.bytedance.sdk.openadsdk.core.d.n v = hVar.v();
        if (v != null) {
            hashMap.put("video_size", Long.valueOf(v.d()));
            hashMap.put("video_resolution", v.f());
        }
        a(hashMap, dVar);
        return hashMap;
    }

    private static void a(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.video.e.d dVar) {
        if (map.containsKey("video_resolution") || dVar == null) {
            return;
        }
        try {
            if (dVar.a() != null) {
                map.put("video_resolution", String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(dVar.a().getVideoWidth()), Integer.valueOf(dVar.a().getVideoHeight())));
            }
        } catch (Throwable unused) {
        }
    }

    public static int a(com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar, boolean z) {
        if (cVar == null || cVar.t() == null || !cVar.t().g()) {
            return 3;
        }
        return !z ? 1 : 0;
    }

    public static JSONObject a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            try {
                String a2 = com.bytedance.sdk.openadsdk.core.a.a();
                String str = 2 + a2 + com.bytedance.sdk.openadsdk.core.a.a(jSONObject.toString(), com.bytedance.sdk.openadsdk.core.a.a(a2));
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put("message", str);
                    jSONObject2.put("cypher", 2);
                } else {
                    jSONObject2.put("message", jSONObject.toString());
                    jSONObject2.put("cypher", 0);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            jSONObject2.put("message", jSONObject.toString());
            jSONObject2.put("cypher", 0);
        }
        return jSONObject2;
    }

    public static void a(com.bytedance.sdk.openadsdk.core.d.h hVar, String str) {
        if (hVar != null) {
            try {
                String A = hVar.A();
                if (TextUtils.isEmpty(A) && hVar.L() != null && hVar.L().c() == 1 && !TextUtils.isEmpty(hVar.L().b())) {
                    A = hVar.L().b();
                }
                String str2 = A;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.x.a(com.bytedance.sdk.openadsdk.core.o.a(), str2, hVar, a(str), str, false);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(JSONObject jSONObject, boolean z) {
        String a2;
        if (!aa.a(com.bytedance.sdk.openadsdk.core.o.a()) || (a2 = aa.a("testGps.txt")) == null) {
            return;
        }
        String[] split = a2.split(",");
        try {
            if (z) {
                jSONObject.put(BigAlbumStore.PhotoColumns.LATITUDE, Float.parseFloat(split[1]));
                jSONObject.put(BigAlbumStore.PhotoColumns.LONGITUDE, Float.parseFloat(split[0]));
            } else {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(BigAlbumStore.PhotoColumns.LATITUDE, Float.parseFloat(split[1]));
                jSONObject2.put(BigAlbumStore.PhotoColumns.LONGITUDE, Float.parseFloat(split[0]));
                jSONObject.put("geo", jSONObject2);
            }
        } catch (JSONException unused) {
        }
    }
}
