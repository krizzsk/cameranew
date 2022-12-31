package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.x;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.config.SharePluginInfo;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserSettingsManager.java */
/* loaded from: classes.dex */
public final class p {
    private static final String a = "com.facebook.p";
    private static AtomicBoolean b = new AtomicBoolean(false);
    private static AtomicBoolean c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    private static b f3138d = new b(true, "com.facebook.sdk.AutoInitEnabled");

    /* renamed from: e  reason: collision with root package name */
    private static b f3139e = new b(true, "com.facebook.sdk.AutoLogAppEventsEnabled");

    /* renamed from: f  reason: collision with root package name */
    private static b f3140f = new b(true, "com.facebook.sdk.AdvertiserIDCollectionEnabled");

    /* renamed from: g  reason: collision with root package name */
    private static b f3141g = new b(false, "auto_event_setup_enabled");

    /* renamed from: h  reason: collision with root package name */
    private static b f3142h = new b(true, "com.facebook.sdk.MonitorEnabled");

    /* renamed from: i  reason: collision with root package name */
    private static SharedPreferences f3143i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UserSettingsManager.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        final /* synthetic */ long a;

        a(long j2) {
            this.a = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.facebook.internal.l o;
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                if (p.a().a() && (o = FetchedAppSettingsManager.o(f.g(), false)) != null && o.b()) {
                    com.facebook.internal.b h2 = com.facebook.internal.b.h(f.f());
                    if (((h2 == null || h2.b() == null) ? null : h2.b()) != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("advertiser_id", h2.b());
                        bundle.putString("fields", "auto_event_setup_enabled");
                        GraphRequest J = GraphRequest.J(null, f.g(), null);
                        J.a0(true);
                        J.Z(bundle);
                        JSONObject h3 = J.g().h();
                        if (h3 != null) {
                            p.b().b = Boolean.valueOf(h3.optBoolean("auto_event_setup_enabled", false));
                            p.b().f3144d = this.a;
                            p.c(p.b());
                        }
                    }
                }
                p.d().set(false);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UserSettingsManager.java */
    /* loaded from: classes.dex */
    public static class b {
        String a;
        Boolean b;
        boolean c;

        /* renamed from: d  reason: collision with root package name */
        long f3144d;

        b(boolean z, String str) {
            this.c = z;
            this.a = str;
        }

        boolean a() {
            Boolean bool = this.b;
            return bool == null ? this.c : bool.booleanValue();
        }
    }

    p() {
    }

    static /* synthetic */ b a() {
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return null;
        }
        try {
            return f3140f;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
            return null;
        }
    }

    static /* synthetic */ b b() {
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return null;
        }
        try {
            return f3141g;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
            return null;
        }
    }

    static /* synthetic */ void c(b bVar) {
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return;
        }
        try {
            v(bVar);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
        }
    }

    static /* synthetic */ AtomicBoolean d() {
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return null;
        }
        try {
            return c;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
            return null;
        }
    }

    public static boolean e() {
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return false;
        }
        try {
            k();
            return f3140f.a();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
            return false;
        }
    }

    public static boolean f() {
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return false;
        }
        try {
            k();
            return f3138d.a();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
            return false;
        }
    }

    public static boolean g() {
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return false;
        }
        try {
            k();
            return f3139e.a();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
            return false;
        }
    }

    public static boolean h() {
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return false;
        }
        try {
            k();
            return f3141g.a();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
            return false;
        }
    }

    public static boolean i() {
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return false;
        }
        try {
            k();
            return f3142h.a();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
            return false;
        }
    }

    private static void j() {
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return;
        }
        try {
            q(f3141g);
            long currentTimeMillis = System.currentTimeMillis();
            b bVar = f3141g;
            if (bVar.b == null || currentTimeMillis - bVar.f3144d >= 604800000) {
                bVar.b = null;
                bVar.f3144d = 0L;
                if (c.compareAndSet(false, true)) {
                    f.p().execute(new a(currentTimeMillis));
                }
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
        }
    }

    public static void k() {
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return;
        }
        try {
            if (f.z() && b.compareAndSet(false, true)) {
                f3143i = f.f().getSharedPreferences("com.facebook.sdk.USER_SETTINGS", 0);
                l(f3139e, f3140f, f3138d);
                j();
                p();
                o();
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
        }
    }

    private static void l(b... bVarArr) {
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return;
        }
        for (b bVar : bVarArr) {
            try {
                if (bVar == f3141g) {
                    j();
                } else if (bVar.b == null) {
                    q(bVar);
                    if (bVar.b == null) {
                        m(bVar);
                    }
                } else {
                    v(bVar);
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, p.class);
                return;
            }
        }
    }

    private static void m(b bVar) {
        Bundle bundle;
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return;
        }
        try {
            u();
            try {
                Context f2 = f.f();
                ApplicationInfo applicationInfo = f2.getPackageManager().getApplicationInfo(f2.getPackageName(), 128);
                if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(bVar.a)) {
                    return;
                }
                bVar.b = Boolean.valueOf(applicationInfo.metaData.getBoolean(bVar.a, bVar.c));
            } catch (PackageManager.NameNotFoundException e2) {
                x.X(a, e2);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void n() {
        Bundle bundle;
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return;
        }
        try {
            Context f2 = f.f();
            ApplicationInfo applicationInfo = f2.getPackageManager().getApplicationInfo(f2.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || !bundle.getBoolean("com.facebook.sdk.AutoAppLinkEnabled", false)) {
                return;
            }
            InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(f2);
            Bundle bundle2 = new Bundle();
            if (!x.L()) {
                bundle2.putString("SchemeWarning", "You haven't set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest");
                Log.w(a, "You haven't set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest");
            }
            internalAppEventsLogger.g("fb_auto_applink", bundle2);
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
        }
    }

    private static void o() {
        int i2;
        ApplicationInfo applicationInfo;
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return;
        }
        try {
            if (b.get() && f.z()) {
                Context f2 = f.f();
                int i3 = 0;
                int i4 = ((f3138d.a() ? 1 : 0) << 0) | 0 | ((f3139e.a() ? 1 : 0) << 1) | ((f3140f.a() ? 1 : 0) << 2) | ((f3142h.a() ? 1 : 0) << 3);
                int i5 = f3143i.getInt("com.facebook.sdk.USER_SETTINGS_BITMASK", 0);
                if (i5 != i4) {
                    f3143i.edit().putInt("com.facebook.sdk.USER_SETTINGS_BITMASK", i4).commit();
                    try {
                        applicationInfo = f2.getPackageManager().getApplicationInfo(f2.getPackageName(), 128);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                    if (applicationInfo != null && applicationInfo.metaData != null) {
                        String[] strArr = {"com.facebook.sdk.AutoInitEnabled", "com.facebook.sdk.AutoLogAppEventsEnabled", "com.facebook.sdk.AdvertiserIDCollectionEnabled", "com.facebook.sdk.MonitorEnabled"};
                        boolean[] zArr = {true, true, true, true};
                        i2 = 0;
                        int i6 = 0;
                        for (int i7 = 0; i7 < 4; i7++) {
                            try {
                                i6 |= (applicationInfo.metaData.containsKey(strArr[i7]) ? 1 : 0) << i7;
                                i2 |= (applicationInfo.metaData.getBoolean(strArr[i7], zArr[i7]) ? 1 : 0) << i7;
                            } catch (PackageManager.NameNotFoundException unused2) {
                            }
                        }
                        i3 = i6;
                        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(f2);
                        Bundle bundle = new Bundle();
                        bundle.putInt(SharePluginInfo.ISSUE_CPU_USAGE, i3);
                        bundle.putInt("initial", i2);
                        bundle.putInt("previous", i5);
                        bundle.putInt("current", i4);
                        internalAppEventsLogger.e(bundle);
                    }
                    i2 = 0;
                    InternalAppEventsLogger internalAppEventsLogger2 = new InternalAppEventsLogger(f2);
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt(SharePluginInfo.ISSUE_CPU_USAGE, i3);
                    bundle2.putInt("initial", i2);
                    bundle2.putInt("previous", i5);
                    bundle2.putInt("current", i4);
                    internalAppEventsLogger2.e(bundle2);
                }
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
        }
    }

    private static void p() {
        Bundle bundle;
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return;
        }
        try {
            Context f2 = f.f();
            ApplicationInfo applicationInfo = f2.getPackageManager().getApplicationInfo(f2.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return;
            }
            if (!bundle.containsKey("com.facebook.sdk.AutoLogAppEventsEnabled")) {
                Log.w(a, "Please set a value for AutoLogAppEventsEnabled. Set the flag to TRUE if you want to collect app install, app launch and in-app purchase events automatically. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.");
            }
            if (!applicationInfo.metaData.containsKey("com.facebook.sdk.AdvertiserIDCollectionEnabled")) {
                Log.w(a, "You haven't set a value for AdvertiserIDCollectionEnabled. Set the flag to TRUE if you want to collect Advertiser ID for better advertising and analytics results. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.");
            }
            if (e()) {
                return;
            }
            Log.w(a, "The value for AdvertiserIDCollectionEnabled is currently set to FALSE so you're sending app events without collecting Advertiser ID. This can affect the quality of your advertising and analytics results.");
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
        }
    }

    private static void q(b bVar) {
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return;
        }
        try {
            u();
            try {
                String string = f3143i.getString(bVar.a, "");
                if (string.isEmpty()) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(string);
                bVar.b = Boolean.valueOf(jSONObject.getBoolean(FirebaseAnalytics.Param.VALUE));
                bVar.f3144d = jSONObject.getLong("last_timestamp");
            } catch (JSONException e2) {
                x.X(a, e2);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
        }
    }

    public static void r(boolean z) {
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return;
        }
        try {
            f3140f.b = Boolean.valueOf(z);
            f3140f.f3144d = System.currentTimeMillis();
            if (b.get()) {
                v(f3140f);
            } else {
                k();
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
        }
    }

    public static void s(boolean z) {
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return;
        }
        try {
            f3138d.b = Boolean.valueOf(z);
            f3138d.f3144d = System.currentTimeMillis();
            if (b.get()) {
                v(f3138d);
            } else {
                k();
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
        }
    }

    public static void t(boolean z) {
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return;
        }
        try {
            f3139e.b = Boolean.valueOf(z);
            f3139e.f3144d = System.currentTimeMillis();
            if (b.get()) {
                v(f3139e);
            } else {
                k();
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
        }
    }

    private static void u() {
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return;
        }
        try {
            if (b.get()) {
                return;
            }
            throw new FacebookSdkNotInitializedException("The UserSettingManager has not been initialized successfully");
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
        }
    }

    private static void v(b bVar) {
        if (com.facebook.internal.instrument.e.a.c(p.class)) {
            return;
        }
        try {
            u();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(FirebaseAnalytics.Param.VALUE, bVar.b);
                jSONObject.put("last_timestamp", bVar.f3144d);
                f3143i.edit().putString(bVar.a, jSONObject.toString()).commit();
                o();
            } catch (Exception e2) {
                x.X(a, e2);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, p.class);
        }
    }
}
