package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.AccessToken;
import com.facebook.appevents.AppEventsLogger;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.concurrent.Executor;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class InternalAppEventsLogger {
    private e a;

    public InternalAppEventsLogger(Context context) {
        this(new e(context, (String) null, (AccessToken) null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor b() {
        return e.d();
    }

    public static AppEventsLogger.FlushBehavior c() {
        return e.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d() {
        return e.h();
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    public static void n(Map<String, String> map) {
        i.i(map);
    }

    public void a() {
        this.a.c();
    }

    public void e(Bundle bundle) {
        if (((bundle.getInt("previous") & 2) != 0) || com.facebook.f.k()) {
            this.a.q("fb_sdk_settings_changed", null, bundle);
        }
    }

    public void f(String str, double d2, Bundle bundle) {
        if (com.facebook.f.k()) {
            this.a.m(str, d2, bundle);
        }
    }

    public void g(String str, Bundle bundle) {
        if (com.facebook.f.k()) {
            this.a.n(str, bundle);
        }
    }

    public void h(String str, String str2) {
        this.a.p(str, str2);
    }

    public void i(String str) {
        if (com.facebook.f.k()) {
            this.a.q(str, null, null);
        }
    }

    public void j(String str, Bundle bundle) {
        if (com.facebook.f.k()) {
            this.a.q(str, null, bundle);
        }
    }

    public void k(String str, Double d2, Bundle bundle) {
        if (com.facebook.f.k()) {
            this.a.q(str, d2, bundle);
        }
    }

    public void l(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (com.facebook.f.k()) {
            this.a.r(str, bigDecimal, currency, bundle);
        }
    }

    public void m(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (com.facebook.f.k()) {
            this.a.t(bigDecimal, currency, bundle);
        }
    }

    public InternalAppEventsLogger(Context context, String str) {
        this(new e(context, str, (AccessToken) null));
    }

    public InternalAppEventsLogger(String str, String str2, AccessToken accessToken) {
        this(new e(str, str2, accessToken));
    }

    @VisibleForTesting
    InternalAppEventsLogger(e eVar) {
        this.a = eVar;
    }
}
