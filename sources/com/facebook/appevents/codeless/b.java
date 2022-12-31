package com.facebook.appevents.codeless;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.e;
import com.facebook.f;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.l;
import com.facebook.internal.x;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: CodelessManager.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class b {
    @Nullable
    private static SensorManager b;
    @Nullable
    private static com.facebook.appevents.codeless.d c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static String f2275d;
    private static final e a = new e();

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicBoolean f2276e = new AtomicBoolean(true);

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicBoolean f2277f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    private static volatile Boolean f2278g = Boolean.FALSE;

    /* renamed from: h  reason: collision with root package name */
    private static d f2279h = new a();

    /* compiled from: CodelessManager.java */
    /* loaded from: classes.dex */
    static class a implements d {
        a() {
        }

        @Override // com.facebook.appevents.codeless.b.d
        public void a(String str) {
            b.f(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CodelessManager.java */
    /* renamed from: com.facebook.appevents.codeless.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0072b implements e.a {
        final /* synthetic */ l a;
        final /* synthetic */ String b;

        C0072b(l lVar, String str) {
            this.a = lVar;
            this.b = str;
        }

        @Override // com.facebook.appevents.codeless.e.a
        public void a() {
            l lVar = this.a;
            boolean z = lVar != null && lVar.b();
            boolean z2 = f.o();
            if (z && z2) {
                b.a().a(this.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CodelessManager.java */
    /* loaded from: classes.dex */
    public static class c implements Runnable {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                boolean z = true;
                GraphRequest K = GraphRequest.K(null, String.format(Locale.US, "%s/app_indexing_session", this.a), null, null);
                Bundle y = K.y();
                if (y == null) {
                    y = new Bundle();
                }
                com.facebook.internal.b h2 = com.facebook.internal.b.h(f.f());
                JSONArray jSONArray = new JSONArray();
                String str = Build.MODEL;
                if (str == null) {
                    str = "";
                }
                jSONArray.put(str);
                if (h2 != null && h2.b() != null) {
                    jSONArray.put(h2.b());
                } else {
                    jSONArray.put("");
                }
                jSONArray.put("0");
                jSONArray.put(com.facebook.appevents.internal.b.f() ? "1" : "0");
                Locale w = x.w();
                jSONArray.put(w.getLanguage() + "_" + w.getCountry());
                String jSONArray2 = jSONArray.toString();
                y.putString("device_session_id", b.i());
                y.putString("extinfo", jSONArray2);
                K.Z(y);
                JSONObject h3 = K.g().h();
                AtomicBoolean b = b.b();
                if (h3 == null || !h3.optBoolean("is_app_indexing_enabled", false)) {
                    z = false;
                }
                b.set(z);
                if (!b.b().get()) {
                    b.c(null);
                } else if (b.d() != null) {
                    b.d().k();
                }
                b.e(Boolean.FALSE);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* compiled from: CodelessManager.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public interface d {
        void a(String str);
    }

    static /* synthetic */ d a() {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        try {
            return f2279h;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }

    static /* synthetic */ AtomicBoolean b() {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        try {
            return f2277f;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }

    static /* synthetic */ String c(String str) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        try {
            f2275d = str;
            return str;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }

    static /* synthetic */ com.facebook.appevents.codeless.d d() {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        try {
            return c;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }

    static /* synthetic */ Boolean e(Boolean bool) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        try {
            f2278g = bool;
            return bool;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }

    static void f(String str) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return;
        }
        try {
            if (f2278g.booleanValue()) {
                return;
            }
            f2278g = Boolean.TRUE;
            f.p().execute(new c(str));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
        }
    }

    public static void g() {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return;
        }
        try {
            f2276e.set(false);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
        }
    }

    public static void h() {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return;
        }
        try {
            f2276e.set(true);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String i() {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        try {
            if (f2275d == null) {
                f2275d = UUID.randomUUID().toString();
            }
            return f2275d;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j() {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return false;
        }
        try {
            return f2277f.get();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return false;
        }
    }

    static boolean k() {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
        }
        return false;
    }

    public static void l(Activity activity) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return;
        }
        try {
            CodelessMatcher.getInstance().d(activity);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
        }
    }

    public static void m(Activity activity) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return;
        }
        try {
            if (f2276e.get()) {
                CodelessMatcher.getInstance().g(activity);
                com.facebook.appevents.codeless.d dVar = c;
                if (dVar != null) {
                    dVar.m();
                }
                SensorManager sensorManager = b;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(a);
                }
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
        }
    }

    public static void n(Activity activity) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return;
        }
        try {
            if (f2276e.get()) {
                CodelessMatcher.getInstance().c(activity);
                Context applicationContext = activity.getApplicationContext();
                String g2 = f.g();
                l j2 = FetchedAppSettingsManager.j(g2);
                if ((j2 != null && j2.b()) || k()) {
                    SensorManager sensorManager = (SensorManager) applicationContext.getSystemService("sensor");
                    b = sensorManager;
                    if (sensorManager == null) {
                        return;
                    }
                    Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                    c = new com.facebook.appevents.codeless.d(activity);
                    e eVar = a;
                    eVar.a(new C0072b(j2, g2));
                    b.registerListener(eVar, defaultSensor, 2);
                    if (j2 != null && j2.b()) {
                        c.k();
                    }
                }
                if (!k() || f2277f.get()) {
                    return;
                }
                f2279h.a(g2);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void o(Boolean bool) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return;
        }
        try {
            f2277f.set(bool.booleanValue());
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
        }
    }
}
