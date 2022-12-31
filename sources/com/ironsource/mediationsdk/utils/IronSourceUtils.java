package com.ironsource.mediationsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.adjust.sdk.Constants;
import com.growingio.android.sdk.utils.NetworkUtil;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.BannerSmash;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
/* loaded from: classes2.dex */
public class IronSourceUtils {
    private static int b = 1;
    private static AtomicBoolean c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    private static String f5653d = null;

    /* renamed from: e  reason: collision with root package name */
    private static Boolean f5654e = null;

    /* renamed from: f  reason: collision with root package name */
    private static IronSourceUtils f5655f = new IronSourceUtils();
    private String a = "";

    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                WebView webView = new WebView(this.a);
                webView.setLayerType(1, null);
                WebSettings settings = webView.getSettings();
                IronSourceUtils.this.a = settings.getUserAgentString();
                webView.destroy();
                IronSourceUtils ironSourceUtils = IronSourceUtils.this;
                ironSourceUtils.W(this.a, ironSourceUtils.a);
            } catch (Exception unused) {
            }
        }
    }

    public static String A(Context context) {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString("last_response", "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long B(Context context, String str, long j2) {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getLong(str, j2);
    }

    public static String C(String str) {
        try {
            String bigInteger = new BigInteger(1, MessageDigest.getInstance(Constants.MD5).digest(str.getBytes())).toString(16);
            while (bigInteger.length() < 32) {
                bigInteger = "0" + bigInteger;
            }
            return bigInteger;
        } catch (Throwable th) {
            if (str == null) {
                com.ironsource.mediationsdk.logger.c.i().e(IronSourceLogger.IronSourceTag.NATIVE, "getMD5(input:null)", th);
                return "";
            }
            com.ironsource.mediationsdk.logger.c.i().e(IronSourceLogger.IronSourceTag.NATIVE, "getMD5(input:" + str + ")", th);
            return "";
        }
    }

    public static JSONObject D(boolean z) {
        return E(z, false, 1);
    }

    public static JSONObject E(boolean z, boolean z2, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("provider", "Mediation");
            if (z) {
                jSONObject.put("isDemandOnly", 1);
            }
            if (z2) {
                jSONObject.put("programmatic", i2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static String F() {
        return com.ironsource.mediationsdk.n0.f.b().a(GuestProfileFragment.USER_ID);
    }

    public static JSONObject G(AbstractSmash abstractSmash) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("providerPriority", abstractSmash.F());
            jSONObject.put("spId", abstractSmash.G());
            jSONObject.put("provider", abstractSmash.m());
            jSONObject.put("providerSDKVersion", abstractSmash.q().getCoreSDKVersion());
            jSONObject.put("providerAdapterVersion", abstractSmash.q().getVersion());
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            i2.e(ironSourceTag, "IronSourceUtils:getProviderAdditionalData(adapter: " + abstractSmash.E() + ")", e2);
        }
        return jSONObject;
    }

    public static JSONObject H(BannerSmash bannerSmash) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("spId", bannerSmash.j());
            jSONObject.put("provider", bannerSmash.f());
            jSONObject.put("providerSDKVersion", bannerSmash.g().getCoreSDKVersion());
            jSONObject.put("providerAdapterVersion", bannerSmash.g().getVersion());
            jSONObject.put("providerPriority", bannerSmash.i());
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            i2.e(ironSourceTag, "IronSourceUtils:getProviderAdditionalData(adapter: " + bannerSmash.h() + ")", e2);
        }
        return jSONObject;
    }

    public static String I() {
        return "7.1.6.1";
    }

    private static String J(String str) {
        try {
            return String.format("%064x", new BigInteger(1, MessageDigest.getInstance(Constants.SHA256).digest(str.getBytes())));
        } catch (NoSuchAlgorithmException e2) {
            if (str == null) {
                com.ironsource.mediationsdk.logger.c.i().e(IronSourceLogger.IronSourceTag.NATIVE, "getSHA256(input:null)", e2);
                return "";
            }
            com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            i2.e(ironSourceTag, "getSHA256(input:" + str + ")", e2);
            return "";
        }
    }

    public static int K() {
        return b;
    }

    public static synchronized String L() {
        String str;
        synchronized (IronSourceUtils.class) {
            if (c.compareAndSet(false, true)) {
                f5653d = UUID.randomUUID().toString();
            }
            str = f5653d;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String M(Context context, String str, String str2) {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(str, str2);
    }

    public static long N() {
        return System.currentTimeMillis();
    }

    public static String O(String str) {
        return J(str);
    }

    public static String P() {
        String a2 = com.ironsource.mediationsdk.n0.f.b().a("userIdType");
        String a3 = com.ironsource.mediationsdk.n0.f.b().a(GuestProfileFragment.USER_ID);
        if (a2 == null || !a2.equals("userGenerated") || TextUtils.isEmpty(a3)) {
            return null;
        }
        return a3;
    }

    public static boolean Q() {
        return c("androidx.appcompat.app.AppCompatActivity") || c("androidx.core.app.CoreComponentFactory") || c("androidx.fragment.app.Fragment") || c("androidx.lifecycle.LiveData") || c("androidx.annotation.Keep");
    }

    public static boolean R(Context context) {
        return (TextUtils.isEmpty(g(context, "appKey")) || TextUtils.isEmpty(g(context, GuestProfileFragment.USER_ID)) || TextUtils.isEmpty(g(context, "response"))) ? false : true;
    }

    public static boolean S(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    public static JSONObject T(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (jSONObject == null && jSONObject2 == null) {
            return new JSONObject();
        }
        if (jSONObject == null) {
            return jSONObject2;
        }
        if (jSONObject2 == null) {
            return jSONObject;
        }
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject.has(next)) {
                jSONObject.put(next, jSONObject2.get(next));
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> U(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        try {
            if (jSONObject != JSONObject.NULL) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!jSONObject.get(next).toString().isEmpty()) {
                        hashMap.put(next, jSONObject.get(next).toString());
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void V(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static synchronized void X(Context context, String str, String str2) {
        synchronized (IronSourceUtils.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
                edit.putString(m(str), str2);
                edit.commit();
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                i2.e(ironSourceTag, "IronSourceUtils:saveDefaultEventsFormatterType(eventType: " + str + ", formatterType:" + str2 + ")", e2);
            }
        }
    }

    public static synchronized void Y(Context context, String str, String str2) {
        synchronized (IronSourceUtils.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
                edit.putString(l(str), str2);
                edit.commit();
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                i2.e(ironSourceTag, "IronSourceUtils:saveDefaultEventsURL(eventType: " + str + ", eventsUrl:" + str2 + ")", e2);
            }
        }
    }

    public static synchronized void Z(Context context, String str, int[] iArr) {
        synchronized (IronSourceUtils.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
                String str2 = null;
                if (iArr != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i2 : iArr) {
                        sb.append(i2);
                        sb.append(",");
                    }
                    str2 = sb.toString();
                }
                edit.putString(o(str), str2);
                edit.commit();
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c.i().e(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultNonConnectivityEvents(eventType: " + str + ", nonConnectivityEvents:" + iArr + ")", e2);
            }
        }
    }

    public static synchronized void a0(Context context, String str, int[] iArr) {
        synchronized (IronSourceUtils.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
                String str2 = null;
                if (iArr != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i2 : iArr) {
                        sb.append(i2);
                        sb.append(",");
                    }
                    str2 = sb.toString();
                }
                edit.putString(q(str), str2);
                edit.commit();
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c.i().e(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultOptInEvents(eventType: " + str + ", optInEvents:" + iArr + ")", e2);
            }
        }
    }

    public static synchronized void b0(Context context, String str, int[] iArr) {
        synchronized (IronSourceUtils.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
                String str2 = null;
                if (iArr != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i2 : iArr) {
                        sb.append(i2);
                        sb.append(",");
                    }
                    str2 = sb.toString();
                }
                edit.putString(s(str), str2);
                edit.commit();
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c.i().e(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultOptOutEvents(eventType: " + str + ", optOutEvents:" + iArr + ")", e2);
            }
        }
    }

    public static boolean c(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static synchronized void c0(Context context, String str, int[] iArr) {
        synchronized (IronSourceUtils.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
                String str2 = null;
                if (iArr != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i2 : iArr) {
                        sb.append(i2);
                        sb.append(",");
                    }
                    str2 = sb.toString();
                }
                edit.putString(u(str), str2);
                edit.commit();
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c.i().e(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultTriggerEvents(eventType: " + str + ", triggerEvents:" + iArr + ")", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(Context context, String str, boolean z) {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getBoolean(str, z);
    }

    public static void d0(Context context, long j2) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
        edit.putLong("firstSessionTimestamp", j2);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void e0(Context context, JSONObject jSONObject) {
        synchronized (IronSourceUtils.class) {
            if (context == null || jSONObject == null) {
                return;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
            edit.putString("general_properties", jSONObject.toString());
            edit.apply();
        }
    }

    private static JSONObject f(Context context) {
        try {
            return new JSONObject(A(context));
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f0(Context context, String str, int i2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
        edit.putInt(str, i2);
        edit.apply();
    }

    public static String g(Context context, String str) {
        return f(context).optString(str);
    }

    public static synchronized void g0(Context context, String str) {
        synchronized (IronSourceUtils.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
            edit.putString("last_response", str);
            edit.apply();
        }
    }

    public static IronSourceUtils getInstance() {
        return f5655f;
    }

    public static String h(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return PortalFollowFeeds.TYPE_NONE;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            return networkCapabilities == null ? PortalFollowFeeds.TYPE_NONE : networkCapabilities.hasTransport(1) ? "wifi" : networkCapabilities.hasTransport(0) ? "cellular" : PortalFollowFeeds.TYPE_NONE;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getTypeName().equalsIgnoreCase(NetworkUtil.NETWORK_WIFI)) {
                return "wifi";
            }
            if (activeNetworkInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                return "cellular";
            }
        }
        return PortalFollowFeeds.TYPE_NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h0(Context context, String str, long j2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
        edit.putLong(str, j2);
        edit.apply();
    }

    public static int i() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i0(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static synchronized String j(Context context, String str, String str2) {
        synchronized (IronSourceUtils.class) {
            try {
                str2 = context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(m(str), str2);
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                i2.e(ironSourceTag, "IronSourceUtils:getDefaultEventsFormatterType(eventType: " + str + ", defaultFormatterType:" + str2 + ")", e2);
            }
        }
        return str2;
    }

    public static synchronized void j0(String str) {
        synchronized (IronSourceUtils.class) {
            com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "automation_log:" + Long.toString(System.currentTimeMillis()) + " text: " + str, 1);
        }
    }

    public static synchronized String k(Context context, String str, String str2) {
        synchronized (IronSourceUtils.class) {
            try {
                str2 = context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(l(str), str2);
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                i2.e(ironSourceTag, "IronSourceUtils:getDefaultEventsURL(eventType: " + str + ", defaultEventsURL:" + str2 + ")", e2);
            }
        }
        return str2;
    }

    private static String l(String str) {
        return "IS".equals(str) ? "default_is_events_url" : "RV".equals(str) ? "default_rv_events_url" : "";
    }

    private static String m(String str) {
        return "IS".equals(str) ? "default_is_events_formatter_type" : "RV".equals(str) ? "default_rv_events_formatter_type" : "";
    }

    public static synchronized int[] n(Context context, String str) {
        int[] iArr;
        synchronized (IronSourceUtils.class) {
            iArr = null;
            try {
                String string = context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(o(str), null);
                if (!TextUtils.isEmpty(string)) {
                    StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
                    ArrayList arrayList = new ArrayList();
                    while (stringTokenizer.hasMoreTokens()) {
                        arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
                    }
                    int size = arrayList.size();
                    iArr = new int[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                    }
                }
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c i3 = com.ironsource.mediationsdk.logger.c.i();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                i3.e(ironSourceTag, "IronSourceUtils:getDefaultNonConnectivityEvents(eventType: " + str + ")", e2);
            }
        }
        return iArr;
    }

    private static String o(String str) {
        return "IS".equals(str) ? "default_is_non_connectivity_events" : "RV".equals(str) ? "default_rv_non_connectivity_events" : "";
    }

    public static synchronized int[] p(Context context, String str) {
        int[] iArr;
        synchronized (IronSourceUtils.class) {
            iArr = null;
            try {
                String string = context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(q(str), null);
                if (!TextUtils.isEmpty(string)) {
                    StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
                    ArrayList arrayList = new ArrayList();
                    while (stringTokenizer.hasMoreTokens()) {
                        arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
                    }
                    int size = arrayList.size();
                    iArr = new int[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                    }
                }
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c i3 = com.ironsource.mediationsdk.logger.c.i();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                i3.e(ironSourceTag, "IronSourceUtils:getDefaultOptInEvents(eventType: " + str + ")", e2);
            }
        }
        return iArr;
    }

    private static String q(String str) {
        return "IS".equals(str) ? "default_is_opt_in_events" : "RV".equals(str) ? "default_rv_opt_in_events" : "";
    }

    public static synchronized int[] r(Context context, String str) {
        int[] iArr;
        synchronized (IronSourceUtils.class) {
            iArr = null;
            try {
                String string = context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(s(str), null);
                if (!TextUtils.isEmpty(string)) {
                    StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
                    ArrayList arrayList = new ArrayList();
                    while (stringTokenizer.hasMoreTokens()) {
                        arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
                    }
                    int size = arrayList.size();
                    iArr = new int[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                    }
                }
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c i3 = com.ironsource.mediationsdk.logger.c.i();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                i3.e(ironSourceTag, "IronSourceUtils:getDefaultOptOutEvents(eventType: " + str + ")", e2);
            }
        }
        return iArr;
    }

    private static String s(String str) {
        return "IS".equals(str) ? "default_is_opt_out_events" : "RV".equals(str) ? "default_rv_opt_out_events" : "";
    }

    public static synchronized int[] t(Context context, String str) {
        int[] iArr;
        synchronized (IronSourceUtils.class) {
            iArr = null;
            try {
                String string = context.getSharedPreferences("Mediation_Shared_Preferences", 0).getString(u(str), null);
                if (!TextUtils.isEmpty(string)) {
                    StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
                    ArrayList arrayList = new ArrayList();
                    while (stringTokenizer.hasMoreTokens()) {
                        arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
                    }
                    int size = arrayList.size();
                    iArr = new int[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                    }
                }
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c i3 = com.ironsource.mediationsdk.logger.c.i();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                i3.e(ironSourceTag, "IronSourceUtils:getDefaultTriggerEvents(eventType: " + str + ")", e2);
            }
        }
        return iArr;
    }

    private static String u(String str) {
        return "IS".equals(str) ? "default_is_trigger_events" : "RV".equals(str) ? "default_rv_trigger_events" : "";
    }

    public static String v(Context context) {
        return com.ironsource.environment.e.F(context) ? "Tablet" : "Phone";
    }

    public static boolean w(Context context) {
        if (f5654e == null) {
            f5654e = Boolean.valueOf(!R(context));
        }
        return f5654e.booleanValue();
    }

    public static long x(Context context) {
        if (context == null) {
            return -1L;
        }
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getLong("firstSessionTimestamp", -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int y(Context context, String str, int i2) {
        return context.getSharedPreferences("Mediation_Shared_Preferences", 0).getInt(str, i2);
    }

    public static JSONObject z(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("provider", "Mediation");
            if (z) {
                jSONObject.put("ext1", "dynamic");
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public synchronized void W(Context context, String str) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("Mediation_Shared_Preferences", 0).edit();
            edit.putString("browser_user_agent", str);
            edit.apply();
        } catch (Exception e2) {
            IronLog ironLog = IronLog.NATIVE;
            ironLog.error("failed to save browser user agent - exception = " + e2);
        }
    }

    public String e() {
        Context a2;
        if (this.a.isEmpty() && (a2 = ContextProvider.getInstance().a()) != null) {
            try {
                return a2.getSharedPreferences("Mediation_Shared_Preferences", 0).getString("browser_user_agent", "");
            } catch (Exception e2) {
                IronLog ironLog = IronLog.NATIVE;
                ironLog.error("failed to get browser user agent - exception = " + e2);
                return "";
            }
        }
        return this.a;
    }

    public void k0() {
        Context a2 = ContextProvider.getInstance().a();
        if (a2 != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    String defaultUserAgent = WebSettings.getDefaultUserAgent(a2);
                    this.a = defaultUserAgent;
                    W(a2, defaultUserAgent);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            ContextProvider.getInstance().e(new a(a2));
        }
    }
}
