package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.location.LocationRequestCompat;
import com.adjust.sdk.Constants;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.tapjoy.TapjoyConstants;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
/* compiled from: Utility.java */
/* loaded from: classes.dex */
public final class x {
    private static int a = 0;
    private static long b = -1;
    private static long c = -1;

    /* renamed from: d  reason: collision with root package name */
    private static long f3092d = -1;

    /* renamed from: e  reason: collision with root package name */
    private static String f3093e = "";

    /* renamed from: f  reason: collision with root package name */
    private static String f3094f = "";

    /* renamed from: g  reason: collision with root package name */
    private static String f3095g = "NoCarrier";

    /* compiled from: Utility.java */
    /* loaded from: classes.dex */
    static class a implements GraphRequest.e {
        final /* synthetic */ c a;
        final /* synthetic */ String b;

        a(c cVar, String str) {
            this.a = cVar;
            this.b = str;
        }

        @Override // com.facebook.GraphRequest.e
        public void a(GraphResponse graphResponse) {
            if (graphResponse.g() != null) {
                this.a.b(graphResponse.g().h());
                return;
            }
            v.b(this.b, graphResponse.h());
            this.a.a(graphResponse.h());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Utility.java */
    /* loaded from: classes.dex */
    public static class b implements FilenameFilter {
        b() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return Pattern.matches("cpu[0-9]+", str);
        }
    }

    /* compiled from: Utility.java */
    /* loaded from: classes.dex */
    public interface c {
        void a(JSONObject jSONObject);

        void b(FacebookException facebookException);
    }

    /* compiled from: Utility.java */
    /* loaded from: classes.dex */
    public interface d<T, K> {
        K apply(T t);
    }

    /* compiled from: Utility.java */
    /* loaded from: classes.dex */
    public static class e {
        List<String> a;
        List<String> b;
        List<String> c;

        public e(List<String> list, List<String> list2, List<String> list3) {
            this.a = list;
            this.b = list2;
            this.c = list3;
        }

        public List<String> a() {
            return this.b;
        }

        public List<String> b() {
            return this.c;
        }

        public List<String> c() {
            return this.a;
        }
    }

    public static String A(Context context) {
        y.l(context, "context");
        com.facebook.f.F(context);
        return com.facebook.f.g();
    }

    public static Method B(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static Method C(String str, String str2, Class<?>... clsArr) {
        try {
            return B(Class.forName(str), str2, clsArr);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @Nullable
    public static Locale D() {
        try {
            return com.facebook.f.f().getResources().getConfiguration().locale;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object E(JSONObject jSONObject, String str, String str2) throws JSONException {
        Object opt = jSONObject.opt(str);
        if (opt != null && (opt instanceof String)) {
            opt = new JSONTokener((String) opt).nextValue();
        }
        if (opt == null || (opt instanceof JSONObject) || (opt instanceof JSONArray)) {
            return opt;
        }
        if (str2 != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt(str2, opt);
            return jSONObject2;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
    }

    public static String F(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    public static e G(JSONObject jSONObject) throws JSONException {
        String optString;
        JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        ArrayList arrayList2 = new ArrayList(jSONArray.length());
        ArrayList arrayList3 = new ArrayList(jSONArray.length());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            String optString2 = optJSONObject.optString("permission");
            if (optString2 != null && !optString2.equals(TapjoyConstants.TJC_INSTALLED) && (optString = optJSONObject.optString("status")) != null) {
                if (optString.equals("granted")) {
                    arrayList.add(optString2);
                } else if (optString.equals("declined")) {
                    arrayList2.add(optString2);
                } else if (optString.equals("expired")) {
                    arrayList3.add(optString2);
                }
            }
        }
        return new e(arrayList, arrayList2, arrayList3);
    }

    private static String H(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b2 : digest) {
            sb.append(Integer.toHexString((b2 >> 4) & 15));
            sb.append(Integer.toHexString((b2 >> 0) & 15));
        }
        return sb.toString();
    }

    private static String I(String str, String str2) {
        return J(str, str2.getBytes());
    }

    private static String J(String str, byte[] bArr) {
        try {
            return H(MessageDigest.getInstance(str), bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static Object K(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean L() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(String.format("fb%s://applinks", com.facebook.f.g())));
            Context f2 = com.facebook.f.f();
            PackageManager packageManager = f2.getPackageManager();
            String packageName = f2.getPackageName();
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 65536)) {
                if (packageName.equals(resolveInfo.activityInfo.packageName)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean M(Context context) {
        AutofillManager autofillManager;
        return Build.VERSION.SDK_INT >= 26 && (autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class)) != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled();
    }

    public static boolean N(Context context) {
        if (Build.VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        String str = Build.DEVICE;
        return str != null && str.matches(".+_cheets|cheets_.+");
    }

    public static boolean O(Uri uri) {
        return uri != null && FirebaseAnalytics.Param.CONTENT.equalsIgnoreCase(uri.getScheme());
    }

    public static boolean P(AccessToken accessToken) {
        return accessToken != null && accessToken.equals(AccessToken.j());
    }

    public static boolean Q() {
        if (com.facebook.internal.instrument.e.a.c(x.class)) {
            return false;
        }
        try {
            JSONObject x = x();
            if (x == null) {
                return false;
            }
            try {
                JSONArray jSONArray = x.getJSONArray("data_processing_options");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    if (jSONArray.getString(i2).toLowerCase().equals("ldu")) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, x.class);
            return false;
        }
    }

    public static boolean R(Uri uri) {
        return uri != null && "file".equalsIgnoreCase(uri.getScheme());
    }

    public static boolean S(String str) {
        return str == null || str.length() == 0;
    }

    public static <T> boolean T(Collection<T> collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean U(Uri uri) {
        return uri != null && ("http".equalsIgnoreCase(uri.getScheme()) || "https".equalsIgnoreCase(uri.getScheme()) || "fbstaging".equalsIgnoreCase(uri.getScheme()));
    }

    public static Set<String> V(JSONArray jSONArray) throws JSONException {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            hashSet.add(jSONArray.getString(i2));
        }
        return hashSet;
    }

    public static List<String> W(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(jSONArray.getString(i2));
        }
        return arrayList;
    }

    public static void X(String str, Exception exc) {
        if (!com.facebook.f.x() || str == null || exc == null) {
            return;
        }
        Log.d(str, exc.getClass().getSimpleName() + ": " + exc.getMessage());
    }

    public static void Y(String str, String str2) {
        if (!com.facebook.f.x() || str == null || str2 == null) {
            return;
        }
        Log.d(str, str2);
    }

    public static void Z(String str, String str2, Throwable th) {
        if (!com.facebook.f.x() || S(str)) {
            return;
        }
        Log.d(str, str2, th);
    }

    public static Map<String, String> a(String str) {
        if (str.isEmpty()) {
            return new HashMap();
        }
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return hashMap;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    public static <T, K> List<K> a0(List<T> list, d<T, K> dVar) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            K apply = dVar.apply(t);
            if (apply != null) {
                arrayList.add(apply);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public static <T> boolean b(T t, T t2) {
        if (t == null) {
            return t2 == null;
        }
        return t.equals(t2);
    }

    public static String b0(Map<String, String> map) {
        if (map.isEmpty()) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public static <T> List<T> c(T... tArr) {
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static String c0(String str) {
        return I(Constants.MD5, str);
    }

    public static JSONObject d(String str) {
        JSONObject a2 = v.a(str);
        if (a2 != null) {
            return a2;
        }
        GraphResponse g2 = y(str).g();
        if (g2.g() != null) {
            return null;
        }
        return g2.h();
    }

    public static boolean d0(Context context) {
        return M(context);
    }

    public static Uri e(String str, String str2, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str3, (String) obj);
                }
            }
        }
        return builder.build();
    }

    public static Bundle e0(String str) {
        Bundle bundle = new Bundle();
        if (!S(str)) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                try {
                    if (split.length == 2) {
                        bundle.putString(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8"));
                    } else if (split.length == 1) {
                        bundle.putString(URLDecoder.decode(split[0], "UTF-8"), "");
                    }
                } catch (UnsupportedEncodingException e2) {
                    X("FacebookSDK", e2);
                }
            }
        }
        return bundle;
    }

    private static void f(Context context, String str) {
        String[] split;
        CookieSyncManager.createInstance(context).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        String cookie = cookieManager.getCookie(str);
        if (cookie == null) {
            return;
        }
        for (String str2 : cookie.split(";")) {
            if (str2.split("=").length > 0) {
                cookieManager.setCookie(str, split[0].trim() + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
            }
        }
        cookieManager.removeExpiredCookie();
    }

    public static boolean f0(Bundle bundle, String str, Object obj) {
        if (obj == null) {
            bundle.remove(str);
            return true;
        } else if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return true;
        } else if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
            return true;
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return true;
        } else if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
            return true;
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
            return true;
        } else if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
            return true;
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return true;
        } else if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
            return true;
        } else if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return true;
        } else if (obj instanceof JSONArray) {
            bundle.putString(str, obj.toString());
            return true;
        } else if (obj instanceof JSONObject) {
            bundle.putString(str, obj.toString());
            return true;
        } else {
            return false;
        }
    }

    public static void g(Context context) {
        f(context, "facebook.com");
        f(context, ".facebook.com");
        f(context, "https://facebook.com");
        f(context, "https://.facebook.com");
    }

    public static void g0(Bundle bundle, String str, String str2) {
        if (S(str2)) {
            return;
        }
        bundle.putString(str, str2);
    }

    public static void h(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void h0(Bundle bundle, String str, Uri uri) {
        if (uri != null) {
            g0(bundle, str, uri.toString());
        }
    }

    public static String i(String str, String str2) {
        return S(str) ? str2 : str;
    }

    public static String i0(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        InputStreamReader inputStreamReader;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
                try {
                    StringBuilder sb = new StringBuilder();
                    char[] cArr = new char[2048];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read != -1) {
                            sb.append(cArr, 0, read);
                        } else {
                            String sb2 = sb.toString();
                            h(bufferedInputStream);
                            h(inputStreamReader);
                            return sb2;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    h(bufferedInputStream);
                    h(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
            }
        } catch (Throwable th4) {
            bufferedInputStream = null;
            th = th4;
            inputStreamReader = null;
        }
    }

    private static long j(double d2) {
        return Math.round(d2 / 1.073741824E9d);
    }

    public static Map<String, String> j0(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < readInt; i2++) {
            hashMap.put(parcel.readString(), parcel.readString());
        }
        return hashMap;
    }

    public static List<String> k(JSONArray jSONArray) {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(jSONArray.getString(i2));
            }
            return arrayList;
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    private static void k0() {
        try {
            if (p()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                f3092d = statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            f3092d = j(f3092d);
        } catch (Exception unused) {
        }
    }

    public static Map<String, String> l(@NonNull JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next);
            if (optString != null) {
                hashMap.put(next, optString);
            }
        }
        return hashMap;
    }

    private static int l0() {
        int i2 = a;
        if (i2 > 0) {
            return i2;
        }
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new b());
            if (listFiles != null) {
                a = listFiles.length;
            }
        } catch (Exception unused) {
        }
        if (a <= 0) {
            a = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return a;
    }

    public static int m(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                byte[] bArr = new byte[8192];
                int i2 = 0;
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                    i2 += read;
                }
                bufferedInputStream2.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                return i2;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void m0(Context context) {
        if (f3095g.equals("NoCarrier")) {
            try {
                f3095g = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
            } catch (Exception unused) {
            }
        }
    }

    public static void n(File file) {
        File[] listFiles;
        if (file.exists()) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    n(file2);
                }
            }
            file.delete();
        }
    }

    private static void n0(Context context) {
        if (b == -1 || System.currentTimeMillis() - b >= TapjoyConstants.SESSION_ID_INACTIVITY_TIME) {
            b = System.currentTimeMillis();
            o0();
            m0(context);
            p0();
            k0();
        }
    }

    public static void o(URLConnection uRLConnection) {
        if (uRLConnection == null || !(uRLConnection instanceof HttpURLConnection)) {
            return;
        }
        ((HttpURLConnection) uRLConnection).disconnect();
    }

    private static void o0() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            f3093e = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            f3094f = timeZone.getID();
        } catch (AssertionError | Exception unused) {
        }
    }

    private static boolean p() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private static void p0() {
        try {
            if (p()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                c = statFs.getBlockCount() * statFs.getBlockSize();
            }
            c = j(c);
        } catch (Exception unused) {
        }
    }

    public static String q(int i2) {
        return new BigInteger(i2 * 5, new Random()).toString(32);
    }

    public static void q0(Runnable runnable) {
        try {
            com.facebook.f.p().execute(runnable);
        } catch (Exception unused) {
        }
    }

    public static String r(Context context) {
        return context == null ? "null" : context == context.getApplicationContext() ? "unknown" : context.getClass().getSimpleName();
    }

    public static String r0(JSONObject jSONObject, String str) {
        return jSONObject != null ? jSONObject.optString(str, "") : "";
    }

    public static String s(Context context) {
        try {
            String h2 = com.facebook.f.h();
            if (h2 != null) {
                return h2;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i2 = applicationInfo.labelRes;
            if (i2 == 0) {
                return applicationInfo.nonLocalizedLabel.toString();
            }
            return context.getString(i2);
        } catch (Exception unused) {
            return "";
        }
    }

    public static void s0(JSONObject jSONObject, com.facebook.internal.b bVar, String str, boolean z) throws JSONException {
        jSONObject.put("anon_id", str);
        jSONObject.put("application_tracking_enabled", !z);
        jSONObject.put("advertiser_id_collection_enabled", com.facebook.f.e());
        if (bVar != null) {
            if (bVar.g() != null) {
                jSONObject.put("attribution", bVar.g());
            }
            if (bVar.b() != null) {
                jSONObject.put("advertiser_id", bVar.b());
                jSONObject.put("advertiser_tracking_enabled", !bVar.k());
            }
            if (!bVar.k()) {
                String d2 = com.facebook.appevents.i.d();
                if (!d2.isEmpty()) {
                    jSONObject.put("ud", d2);
                }
            }
            if (bVar.f() != null) {
                jSONObject.put("installer_package", bVar.f());
            }
        }
    }

    @Nullable
    public static String t() {
        Context f2 = com.facebook.f.f();
        if (f2 == null) {
            return null;
        }
        try {
            return f2.getPackageManager().getPackageInfo(f2.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static void t0(JSONObject jSONObject, Context context) throws JSONException {
        String str;
        Locale locale;
        int i2;
        WindowManager windowManager;
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("a2");
        n0(context);
        String packageName = context.getPackageName();
        int i3 = 0;
        int i4 = -1;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            i4 = packageInfo.versionCode;
            str = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str = "";
        }
        jSONArray.put(packageName);
        jSONArray.put(i4);
        jSONArray.put(str);
        jSONArray.put(Build.VERSION.RELEASE);
        jSONArray.put(Build.MODEL);
        try {
            locale = context.getResources().getConfiguration().locale;
        } catch (Exception unused2) {
            locale = Locale.getDefault();
        }
        jSONArray.put(locale.getLanguage() + "_" + locale.getCountry());
        jSONArray.put(f3093e);
        jSONArray.put(f3095g);
        double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        try {
            windowManager = (WindowManager) context.getSystemService("window");
        } catch (Exception unused3) {
        }
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int i5 = displayMetrics.widthPixels;
            try {
                int i6 = displayMetrics.heightPixels;
                try {
                    d2 = displayMetrics.density;
                } catch (Exception unused4) {
                }
                i3 = i5;
                i2 = i6;
            } catch (Exception unused5) {
                i3 = i5;
            }
            jSONArray.put(i3);
            jSONArray.put(i2);
            jSONArray.put(new DecimalFormat("#.##").format(d2));
            jSONArray.put(l0());
            jSONArray.put(c);
            jSONArray.put(f3092d);
            jSONArray.put(f3094f);
            jSONObject.put("extinfo", jSONArray.toString());
        }
        i2 = 0;
        jSONArray.put(i3);
        jSONArray.put(i2);
        jSONArray.put(new DecimalFormat("#.##").format(d2));
        jSONArray.put(l0());
        jSONArray.put(c);
        jSONArray.put(f3092d);
        jSONArray.put(f3094f);
        jSONObject.put("extinfo", jSONArray.toString());
    }

    public static Date u(Bundle bundle, String str, Date date) {
        long parseLong;
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            parseLong = ((Long) obj).longValue();
        } else if (!(obj instanceof String)) {
            return null;
        } else {
            try {
                parseLong = Long.parseLong((String) obj);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        if (parseLong == 0) {
            return new Date((long) LocationRequestCompat.PASSIVE_INTERVAL);
        }
        return new Date(date.getTime() + (parseLong * 1000));
    }

    public static String u0(byte[] bArr) {
        return J(Constants.SHA1, bArr);
    }

    public static long v(Uri uri) {
        Cursor cursor = null;
        try {
            cursor = com.facebook.f.f().getContentResolver().query(uri, null, null, null, null);
            int columnIndex = cursor.getColumnIndex("_size");
            cursor.moveToFirst();
            return cursor.getLong(columnIndex);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Nullable
    public static String v0(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return I(Constants.SHA256, str);
    }

    public static Locale w() {
        Locale D = D();
        return D != null ? D : Locale.getDefault();
    }

    public static JSONArray w0(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONArray(str);
        }
        return null;
    }

    @Nullable
    public static JSONObject x() {
        if (com.facebook.internal.instrument.e.a.c(x.class)) {
            return null;
        }
        try {
            String string = com.facebook.f.f().getSharedPreferences("com.facebook.sdk.DataProcessingOptions", 0).getString("data_processing_options", null);
            if (string != null) {
                try {
                    return new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, x.class);
            return null;
        }
    }

    public static JSONObject x0(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    private static GraphRequest y(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,name,first_name,middle_name,last_name");
        bundle.putString("access_token", str);
        return new GraphRequest(null, "me", bundle, HttpMethod.GET, null);
    }

    public static <T> Collection<T> y0(T... tArr) {
        return Collections.unmodifiableCollection(Arrays.asList(tArr));
    }

    public static void z(String str, c cVar) {
        JSONObject a2 = v.a(str);
        if (a2 != null) {
            cVar.a(a2);
            return;
        }
        a aVar = new a(cVar, str);
        GraphRequest y = y(str);
        y.V(aVar);
        y.i();
    }

    public static void z0(Parcel parcel, Map<String, String> map) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }
}
