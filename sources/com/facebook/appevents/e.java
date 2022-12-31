package com.facebook.appevents;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.k;
import com.facebook.internal.o;
import com.facebook.internal.r;
import com.facebook.internal.x;
import com.facebook.internal.y;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppEventsLoggerImpl.java */
/* loaded from: classes.dex */
public class e {
    private static final String c = "com.facebook.appevents.e";

    /* renamed from: d  reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f2291d;

    /* renamed from: e  reason: collision with root package name */
    private static AppEventsLogger.FlushBehavior f2292e = AppEventsLogger.FlushBehavior.AUTO;

    /* renamed from: f  reason: collision with root package name */
    private static final Object f2293f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static String f2294g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f2295h;

    /* renamed from: i  reason: collision with root package name */
    private static String f2296i;
    private final String a;
    private final AccessTokenAppIdPair b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppEventsLoggerImpl.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ e b;

        a(Context context, e eVar) {
            this.a = context;
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                Bundle bundle = new Bundle();
                String[] strArr = {"com.facebook.core.Core", "com.facebook.login.Login", "com.facebook.share.Share", "com.facebook.places.Places", "com.facebook.messenger.Messenger", "com.facebook.applinks.AppLinks", "com.facebook.marketing.Marketing", "com.facebook.gamingservices.GamingServices", "com.facebook.all.All", "com.android.billingclient.api.BillingClient", "com.android.vending.billing.IInAppBillingService"};
                String[] strArr2 = {"core_lib_included", "login_lib_included", "share_lib_included", "places_lib_included", "messenger_lib_included", "applinks_lib_included", "marketing_lib_included", "gamingservices_lib_included", "all_lib_included", "billing_client_lib_included", "billing_service_lib_included"};
                int i2 = 0;
                for (int i3 = 0; i3 < 11; i3++) {
                    String str = strArr[i3];
                    String str2 = strArr2[i3];
                    try {
                        Class.forName(str);
                        bundle.putInt(str2, 1);
                        i2 |= 1 << i3;
                    } catch (ClassNotFoundException unused) {
                    }
                }
                SharedPreferences sharedPreferences = this.a.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
                if (sharedPreferences.getInt("kitsBitmask", 0) != i2) {
                    sharedPreferences.edit().putInt("kitsBitmask", i2).apply();
                    this.b.q("fb_sdk_initialize", null, bundle);
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* compiled from: AppEventsLoggerImpl.java */
    /* loaded from: classes.dex */
    static class b implements o.b {
        b() {
        }

        @Override // com.facebook.internal.o.b
        public void a(String str) {
            e.w(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppEventsLoggerImpl.java */
    /* loaded from: classes.dex */
    public static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                HashSet<String> hashSet = new HashSet();
                for (AccessTokenAppIdPair accessTokenAppIdPair : com.facebook.appevents.c.m()) {
                    hashSet.add(accessTokenAppIdPair.getApplicationId());
                }
                for (String str : hashSet) {
                    FetchedAppSettingsManager.o(str, true);
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, String str, AccessToken accessToken) {
        this(x.r(context), str, accessToken);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Application application, String str) {
        if (com.facebook.internal.instrument.e.a.c(e.class)) {
            return;
        }
        try {
            if (com.facebook.f.z()) {
                com.facebook.appevents.a.d();
                i.g();
                if (str == null) {
                    str = com.facebook.f.g();
                }
                com.facebook.f.E(application, str);
                com.facebook.appevents.internal.a.x(application, str);
                return;
            }
            throw new FacebookException("The Facebook sdk must be initialized before calling activateApp");
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, e.class);
        }
    }

    static void b() {
        if (com.facebook.internal.instrument.e.a.c(e.class)) {
            return;
        }
        try {
            if (f() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
                com.facebook.appevents.c.k(FlushReason.EAGER_FLUSHING_EVENT);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, e.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor d() {
        if (com.facebook.internal.instrument.e.a.c(e.class)) {
            return null;
        }
        try {
            if (f2291d == null) {
                j();
            }
            return f2291d;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, e.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(Context context) {
        if (com.facebook.internal.instrument.e.a.c(e.class)) {
            return null;
        }
        try {
            if (f2294g == null) {
                synchronized (f2293f) {
                    if (f2294g == null) {
                        String string = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", null);
                        f2294g = string;
                        if (string == null) {
                            f2294g = "XZ" + UUID.randomUUID().toString();
                            context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", f2294g).apply();
                        }
                    }
                }
            }
            return f2294g;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, e.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AppEventsLogger.FlushBehavior f() {
        AppEventsLogger.FlushBehavior flushBehavior;
        if (com.facebook.internal.instrument.e.a.c(e.class)) {
            return null;
        }
        try {
            synchronized (f2293f) {
                flushBehavior = f2292e;
            }
            return flushBehavior;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, e.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static String g() {
        if (com.facebook.internal.instrument.e.a.c(e.class)) {
            return null;
        }
        try {
            o.d(new b());
            return com.facebook.f.f().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString(Constants.INSTALL_REFERRER, null);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, e.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h() {
        String str;
        if (com.facebook.internal.instrument.e.a.c(e.class)) {
            return null;
        }
        try {
            synchronized (f2293f) {
                str = f2296i;
            }
            return str;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, e.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Context context, String str) {
        if (com.facebook.internal.instrument.e.a.c(e.class)) {
            return;
        }
        try {
            if (com.facebook.f.k()) {
                f2291d.execute(new a(context, new e(context, str, (AccessToken) null)));
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, e.class);
        }
    }

    private static void j() {
        if (com.facebook.internal.instrument.e.a.c(e.class)) {
            return;
        }
        try {
            synchronized (f2293f) {
                if (f2291d != null) {
                    return;
                }
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
                f2291d = scheduledThreadPoolExecutor;
                scheduledThreadPoolExecutor.scheduleAtFixedRate(new c(), 0L, 86400L, TimeUnit.SECONDS);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, e.class);
        }
    }

    private static void k(AppEvent appEvent, AccessTokenAppIdPair accessTokenAppIdPair) {
        if (com.facebook.internal.instrument.e.a.c(e.class)) {
            return;
        }
        try {
            com.facebook.appevents.c.h(accessTokenAppIdPair, appEvent);
            if (FeatureManager.g(FeatureManager.Feature.OnDevicePostInstallEventProcessing) && com.facebook.appevents.ondeviceprocessing.a.b()) {
                com.facebook.appevents.ondeviceprocessing.a.c(accessTokenAppIdPair.getApplicationId(), appEvent);
            }
            if (appEvent.getIsImplicit() || f2295h) {
                return;
            }
            if (appEvent.getName().equals("fb_mobile_activate_app")) {
                f2295h = true;
            } else {
                r.g(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, e.class);
        }
    }

    private static void u(String str) {
        if (com.facebook.internal.instrument.e.a.c(e.class)) {
            return;
        }
        try {
            r.g(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", str);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, e.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void v() {
        if (com.facebook.internal.instrument.e.a.c(e.class)) {
            return;
        }
        try {
            com.facebook.appevents.c.o();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, e.class);
        }
    }

    static void w(String str) {
        if (com.facebook.internal.instrument.e.a.c(e.class)) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = com.facebook.f.f().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
            if (str != null) {
                sharedPreferences.edit().putString(Constants.INSTALL_REFERRER, str).apply();
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, e.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            com.facebook.appevents.c.k(FlushReason.EXPLICIT);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(String str) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            n(str, null);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(String str, double d2, Bundle bundle) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            o(str, Double.valueOf(d2), bundle, false, com.facebook.appevents.internal.a.q());
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(String str, Bundle bundle) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            o(str, null, bundle, false, com.facebook.appevents.internal.a.q());
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    void o(String str, Double d2, Bundle bundle, boolean z, @Nullable UUID uuid) {
        if (com.facebook.internal.instrument.e.a.c(this) || str == null) {
            return;
        }
        try {
            if (str.isEmpty()) {
                return;
            }
            if (k.f("app_events_killswitch", com.facebook.f.g(), false)) {
                r.h(LoggingBehavior.APP_EVENTS, "AppEvents", "KillSwitch is enabled and fail to log app event: %s", str);
                return;
            }
            try {
                k(new AppEvent(this.a, str, d2, bundle, z, com.facebook.appevents.internal.a.s(), uuid), this.b);
            } catch (FacebookException e2) {
                r.h(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event: %s", e2.toString());
            } catch (JSONException e3) {
                r.h(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", e3.toString());
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(String str, String str2) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("_is_suggested_event", "1");
            bundle.putString("_button_text", str2);
            n(str, bundle);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(String str, Double d2, Bundle bundle) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            o(str, d2, bundle, true, com.facebook.appevents.internal.a.q());
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            if (bigDecimal != null && currency != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                Bundle bundle2 = bundle;
                bundle2.putString("fb_currency", currency.getCurrencyCode());
                o(str, Double.valueOf(bigDecimal.doubleValue()), bundle2, true, com.facebook.appevents.internal.a.q());
                return;
            }
            x.Y(c, "purchaseAmount and currency cannot be null");
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    void s(BigDecimal bigDecimal, Currency currency, Bundle bundle, boolean z) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            if (bigDecimal == null) {
                u("purchaseAmount cannot be null");
            } else if (currency == null) {
                u("currency cannot be null");
            } else {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                Bundle bundle2 = bundle;
                bundle2.putString("fb_currency", currency.getCurrencyCode());
                o("fb_mobile_purchase", Double.valueOf(bigDecimal.doubleValue()), bundle2, z, com.facebook.appevents.internal.a.q());
                b();
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            s(bigDecimal, currency, bundle, true);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str, String str2, AccessToken accessToken) {
        y.n();
        this.a = str;
        accessToken = accessToken == null ? AccessToken.j() : accessToken;
        if (accessToken != null && !accessToken.y() && (str2 == null || str2.equals(accessToken.h()))) {
            this.b = new AccessTokenAppIdPair(accessToken);
        } else {
            this.b = new AccessTokenAppIdPair(null, str2 == null ? x.A(com.facebook.f.f()) : str2);
        }
        j();
    }
}
