package com.facebook.appevents;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
/* loaded from: classes.dex */
public class AppEventsLogger {
    private e a;

    /* loaded from: classes.dex */
    public enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY
    }

    /* loaded from: classes.dex */
    public enum ProductAvailability {
        IN_STOCK,
        OUT_OF_STOCK,
        PREORDER,
        AVALIABLE_FOR_ORDER,
        DISCONTINUED
    }

    /* loaded from: classes.dex */
    public enum ProductCondition {
        NEW,
        REFURBISHED,
        USED
    }

    private AppEventsLogger(Context context, String str, AccessToken accessToken) {
        this.a = new e(context, str, accessToken);
    }

    public static void a(Application application, String str) {
        e.a(application, str);
    }

    public static String c(Context context) {
        return e.e(context);
    }

    public static FlushBehavior d() {
        return e.f();
    }

    public static String e() {
        return a.b();
    }

    public static void f(Context context, String str) {
        e.i(context, str);
    }

    public static AppEventsLogger i(Context context) {
        return new AppEventsLogger(context, null, null);
    }

    public static void j() {
        e.v();
    }

    public void b() {
        this.a.c();
    }

    public void g(String str) {
        this.a.l(str);
    }

    public void h(String str, Bundle bundle) {
        this.a.n(str, bundle);
    }
}
