package us.pinguo.bigdata.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.adjust.sdk.Constants;
import com.tapjoy.TapjoyConstants;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.UUID;
import us.pinguo.bigdata.config.BDConfigManager;
/* compiled from: BDLocalUtils.java */
/* loaded from: classes3.dex */
public class a {
    private static final String a;
    private static final String b;
    private static String c;

    /* renamed from: d  reason: collision with root package name */
    private static String f9119d;

    /* renamed from: e  reason: collision with root package name */
    private static String f9120e;

    /* renamed from: f  reason: collision with root package name */
    private static String f9121f;

    /* renamed from: g  reason: collision with root package name */
    private static String f9122g;

    /* renamed from: h  reason: collision with root package name */
    private static String f9123h;

    /* renamed from: i  reason: collision with root package name */
    private static String f9124i;

    /* renamed from: j  reason: collision with root package name */
    private static String f9125j;

    /* renamed from: k  reason: collision with root package name */
    private static String f9126k;

    /* renamed from: l  reason: collision with root package name */
    private static String f9127l;
    private static String m;
    private static String n;
    private static int o;
    private static String p;
    private static String q;
    private static String r;
    private static String s;
    private static String t;
    private static String u;
    private static boolean v;
    private static String w;
    private static String x;
    private static String y;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory());
        String str = File.separator;
        sb.append(str);
        sb.append("Camera360");
        sb.append(str);
        sb.append(".IMEI.txt");
        a = sb.toString();
        b = Environment.getExternalStorageDirectory().getAbsolutePath() + str + ".pg_camera" + str + "A_C_N_1";
        c = "";
        f9119d = "";
        f9120e = "";
        f9121f = "";
        f9122g = "";
        f9123h = "";
        f9124i = "";
        f9125j = "";
        f9126k = "";
        f9127l = "";
        m = "";
        n = "";
        o = 0;
        p = "";
        q = "";
        r = "";
        s = "";
        t = "";
        u = "";
        v = false;
        w = "";
        x = "";
        y = "";
    }

    private static String A() {
        return Locale.getDefault().getLanguage();
    }

    private static String B() {
        String logsource = BDConfigManager.instance().getLocalConfig().getLogsource();
        f9120e = logsource;
        return logsource;
    }

    private static String C(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < digest.length; i2++) {
                stringBuffer.append(String.format("%02x", Byte.valueOf(digest[i2])));
            }
            messageDigest.update(stringBuffer.toString().getBytes("UTF-8"));
            StringBuffer stringBuffer2 = new StringBuffer();
            byte[] digest2 = messageDigest.digest();
            for (int i3 = 0; i3 < digest2.length; i3++) {
                stringBuffer2.append(String.format("%02x", Byte.valueOf(digest2[i3])));
            }
            return stringBuffer2.toString();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private static String D() {
        return Build.MODEL;
    }

    public static String E(Context context) {
        return d.b(context);
    }

    private static int F(Context context) {
        int newUser = BDConfigManager.instance().getLocalConfig().getNewUser();
        o = newUser;
        return newUser;
    }

    private static String G() {
        String newUserTime = BDConfigManager.instance().getLocalConfig().getNewUserTime();
        u = newUserTime;
        return newUserTime;
    }

    public static String H(Context context) {
        return z(context);
    }

    private static String I(Context context) {
        String screenHeight = BDConfigManager.instance().getLocalConfig().getScreenHeight();
        t = screenHeight;
        if (screenHeight != null && !screenHeight.equals("")) {
            J(context);
        }
        return t;
    }

    private static String J(Context context) {
        String str = s;
        if (str != null && !str.equals("")) {
            return s;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            s = String.valueOf(displayMetrics.widthPixels);
            t = String.valueOf(displayMetrics.heightPixels);
            BDConfigManager.instance().getLocalConfig().setScreenWidth(s);
            BDConfigManager.instance().getLocalConfig().setScreenHeight(t);
            return s;
        } catch (Exception e2) {
            e2.printStackTrace();
            return s;
        }
    }

    private static String K() {
        String sdkVer = BDConfigManager.instance().getLocalConfig().getSdkVer();
        f9121f = sdkVer;
        return sdkVer;
    }

    private static String L(Context context) {
        String secret = BDConfigManager.instance().getLocalConfig().getSecret();
        f9123h = secret;
        if (!TextUtils.isEmpty(secret)) {
            return f9123h;
        }
        try {
            String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("BD_APP_SECRET");
            f9123h = string;
            if (TextUtils.isEmpty(string)) {
                f9123h = "vCGG9QZ94tcGxTjangCc_b_VuXwmfGd2";
            }
        } catch (Exception unused) {
            f9123h = "vCGG9QZ94tcGxTjangCc_b_VuXwmfGd2";
        }
        BDConfigManager.instance().getLocalConfig().setSecret(f9123h);
        return f9123h;
    }

    private static String M(Context context) {
        return "/appkey/" + g(context) + "/time/" + System.currentTimeMillis();
    }

    private static String N() {
        String sysPicCount = BDConfigManager.instance().getLocalConfig().getSysPicCount();
        q = sysPicCount;
        return sysPicCount;
    }

    private static String O() {
        return Build.VERSION.RELEASE;
    }

    public static String P(Context context) {
        String bdUrl;
        String M = M(context);
        if (BDConfigManager.instance().getLocalConfig().getDebug()) {
            bdUrl = BDConfigManager.instance().getLocalConfig().getDebugBdUrl();
        } else {
            bdUrl = BDConfigManager.instance().getLocalConfig().getBdUrl();
        }
        String a2 = c.a(M, L(context));
        String str = null;
        try {
            str = s(context);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return bdUrl + "/getUploadMech" + M + "/sign/" + a2 + File.separator + "?" + str;
    }

    private static String Q() {
        return "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
    }

    private static String R() {
        return "35" + Build.BOARD + Build.BRAND + Build.CPU_ABI + Build.DEVICE + Build.DISPLAY + Build.HOST + Build.ID + Build.MANUFACTURER + Build.MODEL + Build.PRODUCT + Build.TAGS + Build.TYPE + Build.USER;
    }

    public static boolean S() {
        boolean debug = BDConfigManager.instance().getLocalConfig().getDebug();
        v = debug;
        return debug;
    }

    public static String a(Context context) {
        String str = "app=" + h(context) + ",platform=" + j() + ",version=" + k(context) + ",model=" + D() + ",sys_version=" + O() + ",channel=" + m() + ",push_id=" + n() + ",language=" + A() + ",network=" + E(context) + ",network_type=" + r(context) + ",count=" + i() + ",syscount=" + N() + ",uid=" + u() + ",eid=" + w(context) + ",imsi=" + y(context) + ",logsource=mobilelog,sdk_version=" + K() + ",w=" + J(context) + ",h=" + I(context) + ",locale=" + o() + ",imei=" + x(context) + ",advId=" + d(context) + ",androidId=" + f(context);
        if (p().length() > 2 && q().length() > 2) {
            return str + ",lat=" + p() + ",lon=" + q();
        }
        return str + ",lat=-1,lon=-1";
    }

    private static boolean b(String str) {
        return str != null && str.length() > 5;
    }

    private static String c(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static String d(Context context) {
        if (us.pinguo.bigdata.a.i()) {
            String str = n;
            if (str != null && str.length() > 5) {
                BDConfigManager.instance().getLocalConfig().setAdvertiserId(n);
                return n;
            }
            try {
                n = (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getDeclaredMethod("getId", new Class[0]).invoke(Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getDeclaredMethod("getAdvertisingIdInfo", Context.class).invoke(null, context), new Object[0]);
                us.pinguo.common.log.a.d("Adv", "advertiserId: " + n, new Object[0]);
                BDConfigManager.instance().getLocalConfig().setAdvertiserId(n);
                return n;
            } catch (Throwable unused) {
                us.pinguo.common.log.a.g("Adv", "WARNING:Google Play services SDK jar is missing.", new Object[0]);
                return n;
            }
        }
        return "";
    }

    public static synchronized String e(Context context) {
        synchronized (a.class) {
            if (b(m)) {
                us.pinguo.common.log.a.c("getAid from memo cache:" + m, new Object[0]);
                return m;
            }
            String str = context.getFilesDir().getAbsolutePath() + File.separator + "A_C_N_1";
            String t2 = t(str);
            if (b(t2)) {
                m = t2;
                BDConfigManager.instance().getLocalConfig().setAid(m);
                us.pinguo.common.log.a.c("getAid from internal cache:" + m, new Object[0]);
                return m;
            }
            String str2 = b;
            String t3 = t(str2);
            if (b(t3)) {
                m = t3;
                BDConfigManager.instance().getLocalConfig().setAid(m);
                try {
                    us.pinguo.common.utils.e.m(m.getBytes(), str);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                us.pinguo.common.log.a.c("getAid from sdcard cache:" + m, new Object[0]);
                return m;
            }
            String f2 = f(context);
            String Q = Q();
            if (f2 != null && f2.length() > 5) {
                m = C(f2 + Q);
            } else {
                m = C(R());
            }
            if (!b(m)) {
                m = UUID.randomUUID().toString();
            }
            if (b(m)) {
                try {
                    us.pinguo.common.utils.e.m(m.getBytes(), str);
                    us.pinguo.common.utils.e.m(m.getBytes(), str2);
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            BDConfigManager.instance().getLocalConfig().setAid(m);
            us.pinguo.common.log.a.m("zcm", "aid: " + m + " aidOther: " + C(R()), new Object[0]);
            StringBuilder sb = new StringBuilder();
            sb.append("No cache, getAid from new calculation:");
            sb.append(m);
            us.pinguo.common.log.a.c(sb.toString(), new Object[0]);
            return m;
        }
    }

    public static String f(Context context) {
        if (us.pinguo.bigdata.a.i()) {
            try {
                String string = Settings.Secure.getString(context.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
                BDConfigManager.instance().getLocalConfig().setAndroidId(string);
                return string;
            } catch (Exception e2) {
                us.pinguo.common.log.a.f(e2);
                return "";
            }
        }
        return "";
    }

    private static String g(Context context) {
        String appId = BDConfigManager.instance().getLocalConfig().getAppId();
        f9122g = appId;
        if (!TextUtils.isEmpty(appId)) {
            return f9122g;
        }
        try {
            String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("BD_APP_ID");
            f9122g = string;
            if (TextUtils.isEmpty(string)) {
                f9122g = "ea8d04692735bc1f";
            }
        } catch (Exception unused) {
            f9122g = "ea8d04692735bc1f";
        }
        BDConfigManager.instance().getLocalConfig().setAppId(f9122g);
        return f9122g;
    }

    private static String h(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            Bundle bundle = packageManager.getApplicationInfo(packageName, 128).metaData;
            packageManager.getPackageInfo(packageName, 0);
            return bundle.getString("BD_APP_CLIENT");
        } catch (Exception unused) {
            return "";
        }
    }

    private static String i() {
        String c360PicCount = BDConfigManager.instance().getLocalConfig().getC360PicCount();
        p = c360PicCount;
        return c360PicCount;
    }

    private static String j() {
        return com.growingio.android.sdk.collection.Constants.PLATFORM_ANDROID;
    }

    private static String k(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    private static String l(Context context) {
        f9124i = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            Bundle bundle = packageManager.getApplicationInfo(packageName, 128).metaData;
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String string = bundle.getString("BD_APP_CLIENT");
            f9124i = string + "_Android_" + packageInfo.versionName;
            BDConfigManager.instance().getLocalConfig().setCclient(f9124i);
        } catch (Exception unused) {
        }
        return f9124i;
    }

    private static String m() {
        return BDConfigManager.instance().getLocalConfig().getChannel();
    }

    private static String n() {
        String cid = BDConfigManager.instance().getLocalConfig().getCid();
        r = cid;
        return cid;
    }

    private static String o() {
        return Locale.getDefault().getLanguage() + '-' + Locale.getDefault().getCountry();
    }

    private static String p() {
        return w;
    }

    private static String q() {
        return x;
    }

    private static String r(Context context) {
        String cnetProvider = BDConfigManager.instance().getLocalConfig().getCnetProvider();
        c = cnetProvider;
        if (cnetProvider == null || f9122g.equals("")) {
            x(context);
        }
        return c;
    }

    private static String s(Context context) {
        String str = y;
        if (str != null && !str.equals("")) {
            return y;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("cdeivce=" + c(v()));
        if (us.pinguo.bigdata.a.i()) {
            sb.append("&imsi=" + c(y(context)));
            sb.append("&cuid=" + c(u()));
            sb.append("&androidid=" + c(f(context)));
            sb.append("&advid=" + c(d(context)));
            sb.append("&imei=" + c(x(context)));
            sb.append("&eid=" + c(w(context)));
            sb.append("&aid=" + c(e(context)));
        } else {
            sb.append("&imsi=");
            sb.append("&cuid=");
            sb.append("&androidid=");
            sb.append("&advid=");
            sb.append("&imei=");
            sb.append("&eid=unknown");
            sb.append("&aid=unknown");
        }
        sb.append("&cclient=" + c(l(context)));
        sb.append("&clang=" + c(o()));
        sb.append("&channel=" + c(m()));
        sb.append("&newuser=" + c(String.valueOf(F(context))));
        sb.append("&newusertime=" + c(G()));
        sb.append("&cid=" + c(n()));
        sb.append("&count=" + c(i()));
        sb.append("&syscount=" + c(N()));
        sb.append("&w=" + c(J(context)));
        sb.append("&h=" + c(I(context)));
        sb.append("&debug=" + c(String.valueOf(S())));
        sb.append("&cnetprovider=" + c(r(context)));
        sb.append("&sdkver=" + c(K()));
        sb.append("&logsource=" + c(B()));
        sb.append("&cnet=" + c(E(context)));
        if (p().length() > 2 && q().length() > 2) {
            sb.append("&clatitude=" + c(p()));
            sb.append("&clongitude=" + c(q()));
        }
        String sb2 = sb.toString();
        sb2.replaceAll(" ", "");
        y = sb2;
        return sb2;
    }

    private static String t(String str) {
        try {
            String j2 = us.pinguo.common.utils.e.j(new File(str));
            return j2 != null ? j2.trim() : j2;
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String u() {
        us.pinguo.common.log.a.c("log getCuid: " + f9125j, new Object[0]);
        if (us.pinguo.bigdata.a.i()) {
            if (f9125j.equals("") && !f9126k.equals("")) {
                f9125j = f9126k;
            }
            BDConfigManager.instance().getLocalConfig().setCuid(f9125j);
            return f9125j;
        }
        return "";
    }

    private static String v() {
        return Build.MODEL + '_' + Build.VERSION.RELEASE;
    }

    public static String w(Context context) {
        if (us.pinguo.bigdata.a.i()) {
            String str = f9126k;
            if (str != null && str.length() > 5) {
                BDConfigManager.instance().getLocalConfig().setEid(f9126k);
                return f9126k;
            }
            f9126k = e(context);
            BDConfigManager.instance().getLocalConfig().setEid(f9126k);
            return f9126k;
        }
        return "unknown";
    }

    public static String x(Context context) {
        if (us.pinguo.bigdata.a.i() && context != null) {
            String str = f9127l;
            if (str != null && str.length() > 5) {
                BDConfigManager.instance().getLocalConfig().setImei(f9127l);
                return f9127l;
            }
            String t2 = t(a);
            f9127l = t2;
            return t2;
        }
        return "";
    }

    private static String y(Context context) {
        if (us.pinguo.bigdata.a.i()) {
            String imsi = BDConfigManager.instance().getLocalConfig().getImsi();
            f9119d = imsi;
            if (imsi == null || f9122g.equals("")) {
                x(context);
            }
            BDConfigManager.instance().getLocalConfig().setImsi(f9119d);
            return f9119d;
        }
        return "";
    }

    public static String z(Context context) {
        String bdUrl;
        String M = M(context);
        if (BDConfigManager.instance().getLocalConfig().getDebug()) {
            bdUrl = BDConfigManager.instance().getLocalConfig().getDebugBdUrl();
        } else {
            bdUrl = BDConfigManager.instance().getLocalConfig().getBdUrl();
        }
        String a2 = c.a(M, L(context));
        String str = null;
        try {
            str = s(context);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return bdUrl + M + "/sign/" + a2 + File.separator + "?" + str;
    }
}
