package com.facebook;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.adjust.sdk.Constants;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.q;
import com.facebook.internal.t;
import com.facebook.internal.w;
import com.facebook.internal.x;
import com.facebook.internal.y;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: FacebookSdk.java */
/* loaded from: classes.dex */
public final class f {
    private static final String a = "com.facebook.f";
    private static Executor c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile String f2613d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static volatile String f2614e;

    /* renamed from: f  reason: collision with root package name */
    private static volatile String f2615f;

    /* renamed from: g  reason: collision with root package name */
    private static volatile Boolean f2616g;

    /* renamed from: l  reason: collision with root package name */
    private static q<File> f2621l;
    private static Context m;
    private static Boolean s;
    private static Boolean t;
    private static j u;
    private static final HashSet<LoggingBehavior> b = new HashSet<>(Arrays.asList(LoggingBehavior.DEVELOPER_ERRORS));

    /* renamed from: h  reason: collision with root package name */
    private static volatile String f2617h = "facebook.com";

    /* renamed from: i  reason: collision with root package name */
    private static AtomicLong f2618i = new AtomicLong(65536);

    /* renamed from: j  reason: collision with root package name */
    private static volatile boolean f2619j = false;

    /* renamed from: k  reason: collision with root package name */
    private static boolean f2620k = false;
    private static int n = 64206;
    private static final Object o = new Object();
    private static String p = w.a();
    public static boolean q = false;
    public static boolean r = false;

    /* compiled from: FacebookSdk.java */
    /* loaded from: classes.dex */
    static class a implements j {
        a() {
        }

        @Override // com.facebook.f.j
        public GraphRequest a(@Nullable AccessToken accessToken, String str, JSONObject jSONObject, @Nullable GraphRequest.e eVar) {
            return GraphRequest.K(accessToken, str, jSONObject, eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FacebookSdk.java */
    /* loaded from: classes.dex */
    public static class b implements Callable<File> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public File call() throws Exception {
            return f.m.getCacheDir();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FacebookSdk.java */
    /* loaded from: classes.dex */
    public static class c implements FeatureManager.c {
        c() {
        }

        @Override // com.facebook.internal.FeatureManager.c
        public void a(boolean z) {
            if (z) {
                com.facebook.internal.instrument.b.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FacebookSdk.java */
    /* loaded from: classes.dex */
    public static class d implements FeatureManager.c {
        d() {
        }

        @Override // com.facebook.internal.FeatureManager.c
        public void a(boolean z) {
            if (z) {
                com.facebook.appevents.f.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FacebookSdk.java */
    /* loaded from: classes.dex */
    public static class e implements FeatureManager.c {
        e() {
        }

        @Override // com.facebook.internal.FeatureManager.c
        public void a(boolean z) {
            if (z) {
                f.q = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FacebookSdk.java */
    /* renamed from: com.facebook.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0096f implements FeatureManager.c {
        C0096f() {
        }

        @Override // com.facebook.internal.FeatureManager.c
        public void a(boolean z) {
            if (z) {
                f.r = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FacebookSdk.java */
    /* loaded from: classes.dex */
    public static class g implements FeatureManager.c {
        g() {
        }

        @Override // com.facebook.internal.FeatureManager.c
        public void a(boolean z) {
            if (z) {
                com.facebook.internal.logging.monitor.c.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FacebookSdk.java */
    /* loaded from: classes.dex */
    public static class h implements Callable<Void> {
        final /* synthetic */ k a;
        final /* synthetic */ Context b;

        h(k kVar, Context context) {
            this.a = kVar;
            this.b = context;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            com.facebook.b.h().i();
            com.facebook.k.b().c();
            if (AccessToken.x() && Profile.c() == null) {
                Profile.b();
            }
            k kVar = this.a;
            if (kVar != null) {
                kVar.a();
            }
            AppEventsLogger.f(f.m, f.f2613d);
            p.n();
            AppEventsLogger.i(this.b.getApplicationContext()).b();
            return null;
        }
    }

    /* compiled from: FacebookSdk.java */
    /* loaded from: classes.dex */
    static class i implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        i(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                f.D(this.a, this.b);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* compiled from: FacebookSdk.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public interface j {
        GraphRequest a(@Nullable AccessToken accessToken, String str, JSONObject jSONObject, @Nullable GraphRequest.e eVar);
    }

    /* compiled from: FacebookSdk.java */
    /* loaded from: classes.dex */
    public interface k {
        void a();
    }

    static {
        Boolean bool = Boolean.FALSE;
        s = bool;
        t = bool;
        u = new a();
    }

    public static boolean A() {
        return f2620k;
    }

    public static boolean B(LoggingBehavior loggingBehavior) {
        boolean z;
        HashSet<LoggingBehavior> hashSet = b;
        synchronized (hashSet) {
            z = x() && hashSet.contains(loggingBehavior);
        }
        return z;
    }

    static void C(Context context) {
        if (context == null) {
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return;
            }
            if (f2613d == null) {
                Object obj = applicationInfo.metaData.get("com.facebook.sdk.ApplicationId");
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.toLowerCase(Locale.ROOT).startsWith("fb")) {
                        f2613d = str.substring(2);
                    } else {
                        f2613d = str;
                    }
                } else if (obj instanceof Number) {
                    throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                }
            }
            if (f2614e == null) {
                f2614e = applicationInfo.metaData.getString("com.facebook.sdk.ApplicationName");
            }
            if (f2615f == null) {
                f2615f = applicationInfo.metaData.getString("com.facebook.sdk.ClientToken");
            }
            if (n == 64206) {
                n = applicationInfo.metaData.getInt("com.facebook.sdk.CallbackOffset", 64206);
            }
            if (f2616g == null) {
                f2616g = Boolean.valueOf(applicationInfo.metaData.getBoolean("com.facebook.sdk.CodelessDebugLogEnabled", false));
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    static void D(Context context, String str) {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return;
        }
        try {
            try {
                if (context != null && str != null) {
                    com.facebook.internal.b h2 = com.facebook.internal.b.h(context);
                    SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
                    String str2 = str + "ping";
                    long j2 = sharedPreferences.getLong(str2, 0L);
                    try {
                        GraphRequest a2 = u.a(null, String.format("%s/activities", str), AppEventsLoggerUtility.a(AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, h2, AppEventsLogger.c(context), t(context), context), null);
                        if (j2 == 0 && a2.g().g() == null) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putLong(str2, System.currentTimeMillis());
                            edit.apply();
                            return;
                        }
                        return;
                    } catch (JSONException e2) {
                        throw new FacebookException("An error occurred while publishing install.", e2);
                    }
                }
                throw new IllegalArgumentException("Both context and applicationId must be non-null");
            } catch (Exception e3) {
                x.X("Facebook-publish", e3);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
        }
    }

    public static void E(Context context, String str) {
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return;
        }
        try {
            p().execute(new i(context.getApplicationContext(), str));
            if (FeatureManager.g(FeatureManager.Feature.OnDeviceEventProcessing) && com.facebook.appevents.ondeviceprocessing.a.b()) {
                com.facebook.appevents.ondeviceprocessing.a.d(str, "com.facebook.sdk.attributionTracking");
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
        }
    }

    @Deprecated
    public static synchronized void F(Context context) {
        synchronized (f.class) {
            G(context, null);
        }
    }

    @Deprecated
    public static synchronized void G(Context context, k kVar) {
        synchronized (f.class) {
            if (s.booleanValue()) {
                if (kVar != null) {
                    kVar.a();
                }
                return;
            }
            y.l(context, "applicationContext");
            y.g(context, false);
            y.i(context, false);
            m = context.getApplicationContext();
            AppEventsLogger.c(context);
            C(m);
            if (!x.S(f2613d)) {
                s = Boolean.TRUE;
                if (j()) {
                    d();
                }
                if ((m instanceof Application) && p.g()) {
                    com.facebook.appevents.internal.a.x((Application) m, f2613d);
                }
                FetchedAppSettingsManager.k();
                t.E();
                BoltsMeasurementEventListener.b(m);
                f2621l = new q<>(new b());
                FeatureManager.a(FeatureManager.Feature.Instrument, new c());
                FeatureManager.a(FeatureManager.Feature.AppEvents, new d());
                FeatureManager.a(FeatureManager.Feature.ChromeCustomTabsPrefetching, new e());
                FeatureManager.a(FeatureManager.Feature.IgnoreAppSwitchToLoggedOut, new C0096f());
                FeatureManager.a(FeatureManager.Feature.Monitoring, new g());
                p().execute(new FutureTask(new h(kVar, context)));
                return;
            }
            throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
        }
    }

    public static void H(boolean z) {
        p.r(z);
    }

    public static void I(boolean z) {
        p.s(z);
        if (z) {
            d();
        }
    }

    public static void J(boolean z) {
        p.t(z);
        if (z) {
            com.facebook.appevents.internal.a.x((Application) m, f2613d);
        }
    }

    public static void K(boolean z) {
        f2619j = z;
    }

    private static void L() {
        HashSet<LoggingBehavior> hashSet = b;
        if (hashSet.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
            if (hashSet.contains(loggingBehavior)) {
                return;
            }
            hashSet.add(loggingBehavior);
        }
    }

    public static void c(LoggingBehavior loggingBehavior) {
        HashSet<LoggingBehavior> hashSet = b;
        synchronized (hashSet) {
            hashSet.add(loggingBehavior);
            L();
        }
    }

    public static void d() {
        t = Boolean.TRUE;
    }

    public static boolean e() {
        return p.e();
    }

    public static Context f() {
        y.n();
        return m;
    }

    public static String g() {
        y.n();
        return f2613d;
    }

    @Nullable
    public static String h() {
        y.n();
        return f2614e;
    }

    public static String i(Context context) {
        PackageManager packageManager;
        if (com.facebook.internal.instrument.e.a.c(f.class)) {
            return null;
        }
        try {
            y.n();
            if (context == null || (packageManager = context.getPackageManager()) == null) {
                return null;
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr != null && signatureArr.length != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
                    messageDigest.update(packageInfo.signatures[0].toByteArray());
                    return Base64.encodeToString(messageDigest.digest(), 9);
                }
            } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, f.class);
            return null;
        }
    }

    public static boolean j() {
        return p.f();
    }

    public static boolean k() {
        return p.g();
    }

    public static File l() {
        y.n();
        return f2621l.c();
    }

    public static int m() {
        y.n();
        return n;
    }

    public static String n() {
        y.n();
        return f2615f;
    }

    public static boolean o() {
        return p.h();
    }

    public static Executor p() {
        synchronized (o) {
            if (c == null) {
                c = AsyncTask.THREAD_POOL_EXECUTOR;
            }
        }
        return c;
    }

    public static String q() {
        return f2617h;
    }

    public static String r() {
        x.Y(a, String.format("getGraphApiVersion: %s", p));
        return p;
    }

    public static String s() {
        AccessToken j2 = AccessToken.j();
        String o2 = j2 != null ? j2.o() : null;
        if (o2 == null) {
            return f2617h;
        }
        if (o2.equals("gaming")) {
            return f2617h.replace("facebook.com", "fb.gg");
        }
        return f2617h;
    }

    public static boolean t(Context context) {
        y.n();
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }

    public static boolean u() {
        return p.i();
    }

    public static long v() {
        y.n();
        return f2618i.get();
    }

    public static String w() {
        return "8.2.0";
    }

    public static boolean x() {
        return f2619j;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static synchronized boolean y() {
        boolean booleanValue;
        synchronized (f.class) {
            booleanValue = t.booleanValue();
        }
        return booleanValue;
    }

    public static synchronized boolean z() {
        boolean booleanValue;
        synchronized (f.class) {
            booleanValue = s.booleanValue();
        }
        return booleanValue;
    }
}
