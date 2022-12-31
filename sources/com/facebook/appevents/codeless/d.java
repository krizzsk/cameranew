package com.facebook.appevents.codeless;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.f;
import com.facebook.internal.p;
import com.facebook.internal.r;
import com.facebook.internal.x;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyConstants;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ViewIndexer.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: e  reason: collision with root package name */
    private static final String f2282e = "com.facebook.appevents.codeless.d";
    private WeakReference<Activity> b;
    private Timer c;

    /* renamed from: d  reason: collision with root package name */
    private String f2283d = null;
    private final Handler a = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewIndexer.java */
    /* loaded from: classes.dex */
    public class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                Activity activity = (Activity) d.a(d.this).get();
                View e2 = com.facebook.appevents.internal.b.e(activity);
                if (activity != null && e2 != null) {
                    String simpleName = activity.getClass().getSimpleName();
                    if (com.facebook.appevents.codeless.b.j()) {
                        if (p.b()) {
                            com.facebook.appevents.codeless.internal.c.a();
                            return;
                        }
                        FutureTask futureTask = new FutureTask(new e(e2));
                        d.b(d.this).post(futureTask);
                        String str = "";
                        try {
                            str = (String) futureTask.get(1L, TimeUnit.SECONDS);
                        } catch (Exception e3) {
                            Log.e(d.c(), "Failed to take screenshot.", e3);
                        }
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("screenname", simpleName);
                            jSONObject.put("screenshot", str);
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(com.facebook.appevents.codeless.internal.d.d(e2));
                            jSONObject.put("view", jSONArray);
                        } catch (JSONException unused) {
                            Log.e(d.c(), "Failed to create JSONObject");
                        }
                        d.d(d.this, jSONObject.toString());
                    }
                }
            } catch (Exception e4) {
                Log.e(d.c(), "UI Component tree indexing failure!", e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewIndexer.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        final /* synthetic */ TimerTask a;

        b(TimerTask timerTask) {
            this.a = timerTask;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                try {
                    if (d.e(d.this) != null) {
                        d.e(d.this).cancel();
                    }
                    d.h(d.this, null);
                    d.f(d.this, new Timer());
                    d.e(d.this).scheduleAtFixedRate(this.a, 0L, 1000L);
                } catch (Exception e2) {
                    Log.e(d.c(), "Error scheduling indexing job", e2);
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewIndexer.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {
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
                String c0 = x.c0(this.a);
                AccessToken j2 = AccessToken.j();
                if (c0 == null || !c0.equals(d.g(d.this))) {
                    d.this.j(d.i(this.a, j2, f.g(), "app_indexing"), c0);
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewIndexer.java */
    /* renamed from: com.facebook.appevents.codeless.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0074d implements GraphRequest.e {
        C0074d() {
        }

        @Override // com.facebook.GraphRequest.e
        public void a(GraphResponse graphResponse) {
            r.g(LoggingBehavior.APP_EVENTS, d.c(), "App index sent to FB!");
        }
    }

    /* compiled from: ViewIndexer.java */
    /* loaded from: classes.dex */
    private static class e implements Callable<String> {
        private WeakReference<View> a;

        e(View view) {
            this.a = new WeakReference<>(view);
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public String call() {
            View view = this.a.get();
            if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                return "";
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
            view.draw(new Canvas(createBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        }
    }

    public d(Activity activity) {
        this.b = new WeakReference<>(activity);
    }

    static /* synthetic */ WeakReference a(d dVar) {
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return null;
        }
        try {
            return dVar.b;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
            return null;
        }
    }

    static /* synthetic */ Handler b(d dVar) {
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return null;
        }
        try {
            return dVar.a;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
            return null;
        }
    }

    static /* synthetic */ String c() {
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return null;
        }
        try {
            return f2282e;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
            return null;
        }
    }

    static /* synthetic */ void d(d dVar, String str) {
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return;
        }
        try {
            dVar.l(str);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
        }
    }

    static /* synthetic */ Timer e(d dVar) {
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return null;
        }
        try {
            return dVar.c;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
            return null;
        }
    }

    static /* synthetic */ Timer f(d dVar, Timer timer) {
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return null;
        }
        try {
            dVar.c = timer;
            return timer;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
            return null;
        }
    }

    static /* synthetic */ String g(d dVar) {
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return null;
        }
        try {
            return dVar.f2283d;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
            return null;
        }
    }

    static /* synthetic */ String h(d dVar, String str) {
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return null;
        }
        try {
            dVar.f2283d = str;
            return str;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
            return null;
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static GraphRequest i(String str, AccessToken accessToken, String str2, String str3) {
        if (com.facebook.internal.instrument.e.a.c(d.class) || str == null) {
            return null;
        }
        try {
            GraphRequest K = GraphRequest.K(accessToken, String.format(Locale.US, "%s/app_indexing", str2), null, null);
            Bundle y = K.y();
            if (y == null) {
                y = new Bundle();
            }
            y.putString("tree", str);
            y.putString(TapjoyConstants.TJC_APP_VERSION_NAME, com.facebook.appevents.internal.b.d());
            y.putString("platform", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
            y.putString("request_type", str3);
            if (str3.equals("app_indexing")) {
                y.putString("device_session_id", com.facebook.appevents.codeless.b.i());
            }
            K.Z(y);
            K.V(new C0074d());
            return K;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
            return null;
        }
    }

    private void l(String str) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            f.p().execute(new c(str));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    void j(@Nullable GraphRequest graphRequest, String str) {
        if (com.facebook.internal.instrument.e.a.c(this) || graphRequest == null) {
            return;
        }
        try {
            GraphResponse g2 = graphRequest.g();
            try {
                JSONObject h2 = g2.h();
                if (h2 != null) {
                    if ("true".equals(h2.optString(FirebaseAnalytics.Param.SUCCESS))) {
                        r.g(LoggingBehavior.APP_EVENTS, f2282e, "Successfully send UI component tree to server");
                        this.f2283d = str;
                    }
                    if (h2.has("is_app_indexing_enabled")) {
                        com.facebook.appevents.codeless.b.o(Boolean.valueOf(h2.getBoolean("is_app_indexing_enabled")));
                        return;
                    }
                    return;
                }
                String str2 = f2282e;
                Log.e(str2, "Error sending UI component tree to Facebook: " + g2.g());
            } catch (JSONException e2) {
                Log.e(f2282e, "Error decoding server response.", e2);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    public void k() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            try {
                f.p().execute(new b(new a()));
            } catch (RejectedExecutionException e2) {
                Log.e(f2282e, "Error scheduling indexing job", e2);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    public void m() {
        Timer timer;
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            if (this.b.get() == null || (timer = this.c) == null) {
                return;
            }
            try {
                timer.cancel();
                this.c = null;
            } catch (Exception e2) {
                Log.e(f2282e, "Error unscheduling indexing job", e2);
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }
}
