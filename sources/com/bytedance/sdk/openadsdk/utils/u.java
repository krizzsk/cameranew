package com.bytedance.sdk.openadsdk.utils;

import android.os.Build;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
/* compiled from: RomUtils.java */
/* loaded from: classes.dex */
public class u {
    private static final CharSequence c = "sony";

    /* renamed from: d  reason: collision with root package name */
    private static final CharSequence f2109d = "amigo";

    /* renamed from: e  reason: collision with root package name */
    private static final CharSequence f2110e = "funtouch";

    /* renamed from: f  reason: collision with root package name */
    private static ExecutorService f2111f = Executors.newSingleThreadExecutor();
    public static boolean a = false;
    public static boolean b = false;

    /* compiled from: RomUtils.java */
    /* loaded from: classes.dex */
    public static class a implements Callable<String> {
        private String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            String c = u.c(this.a);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            o.b("RomUtils", "property:" + c + ",getSystemProperty use time :" + currentTimeMillis2);
            if (!TextUtils.isEmpty(c)) {
                try {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        o.d("RomUtils", "SPMultiHelper-getPropertyFromSPMultiHelper:" + c);
                        com.bytedance.sdk.openadsdk.multipro.d.a.a("rom_info", "rom_property_info", c);
                    } else {
                        o.d("RomUtils", "SP-getPropertyFromSP:" + c);
                        v.a("rom_info", com.bytedance.sdk.openadsdk.core.o.a()).a("rom_property_info", c);
                    }
                } catch (Throwable unused) {
                }
            }
            return c;
        }
    }

    public static String a() {
        if (o()) {
            return p();
        }
        if (e()) {
            return l();
        }
        if (b()) {
            return q();
        }
        if (r()) {
            return s();
        }
        String m = m();
        if (TextUtils.isEmpty(m)) {
            if (g()) {
                return f();
            }
            if (h()) {
                return i();
            }
            if (d()) {
                return c();
            }
            String j2 = j();
            return !TextUtils.isEmpty(j2) ? j2 : Build.DISPLAY;
        }
        return m;
    }

    public static String c() {
        return d("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean d() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static boolean e() {
        if (!b) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    a = true;
                    b = true;
                    return true;
                }
            } catch (Exception unused) {
            }
            b = true;
        }
        return a;
    }

    public static String f() {
        return d("ro.vivo.os.build.display.id") + "_" + d("ro.vivo.product.version");
    }

    public static boolean g() {
        String d2 = d("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(d2) && d2.toLowerCase().contains(f2110e);
    }

    public static boolean h() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(f2109d);
    }

    public static String i() {
        return Build.DISPLAY + "_" + d("ro.gn.sv.version");
    }

    public static String j() {
        if (k()) {
            return "eui_" + d("ro.letv.release.version") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static boolean k() {
        return !TextUtils.isEmpty(d("ro.letv.release.version"));
    }

    public static String l() {
        if (e()) {
            return "miui_" + d("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
        }
        return "";
    }

    public static String m() {
        String n = n();
        if (n == null || !n.toLowerCase().contains("emotionui")) {
            return "";
        }
        return n + "_" + Build.DISPLAY;
    }

    public static String n() {
        return d("ro.build.version.emui");
    }

    public static boolean o() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    public static String p() {
        if (o()) {
            try {
                String d2 = d("ro.smartisan.version");
                return "smartisan_" + d2;
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static String q() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean r() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("oppo");
    }

    public static String s() {
        if (r()) {
            return "coloros_" + d("ro.build.version.opporom") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static boolean t() {
        try {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith(Constants.REFERRER_API_HUAWEI)) {
                String str2 = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str2)) {
                    return false;
                }
                if (!str2.toLowerCase().startsWith(Constants.REFERRER_API_HUAWEI)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String u() {
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                String b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("rom_info", "rom_property_info", "");
                o.c("RomUtils", "get Property From SPMultiHelper..." + b2);
                return b2;
            }
            String b3 = v.a("rom_info", com.bytedance.sdk.openadsdk.core.o.a()).b("rom_property_info", "");
            o.c("RomUtils", "get Property From SP...=" + b3);
            return b3;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean b() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        String str2 = "";
        try {
            Process exec = Runtime.getRuntime().exec("getprop " + str);
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
            try {
                str2 = bufferedReader.readLine();
                exec.destroy();
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    o.c("ToolUtils", "Exception while closing InputStream", e2);
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                try {
                    o.c("ToolUtils", "Unable to read sysprop " + str, th);
                    return str2;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            o.c("ToolUtils", "Exception while closing InputStream", e3);
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    private static String d(String str) {
        String str2;
        try {
            str2 = u();
            try {
                if (TextUtils.isEmpty(str2)) {
                    FutureTask futureTask = new FutureTask(new a(str));
                    f2111f.execute(futureTask);
                    str2 = (String) futureTask.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str2 = "";
        }
        return str2 == null ? "" : str2;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = n();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || t();
    }
}
