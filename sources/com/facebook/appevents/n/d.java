package com.facebook.appevents.n;

import android.app.Activity;
import androidx.annotation.RestrictTo;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.l;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: SuggestedEventsManager.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class d {
    private static final AtomicBoolean a = new AtomicBoolean(false);
    private static final Set<String> b = new HashSet();
    private static final Set<String> c = new HashSet();

    /* compiled from: SuggestedEventsManager.java */
    /* loaded from: classes.dex */
    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                if (d.a().get()) {
                    return;
                }
                d.a().set(true);
                d.b();
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    static /* synthetic */ AtomicBoolean a() {
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return null;
        }
        try {
            return a;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
            return null;
        }
    }

    static /* synthetic */ void b() {
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return;
        }
        try {
            d();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
        }
    }

    public static synchronized void c() {
        synchronized (d.class) {
            if (com.facebook.internal.instrument.e.a.c(d.class)) {
                return;
            }
            com.facebook.f.p().execute(new a());
        }
    }

    private static void d() {
        String n;
        File j2;
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return;
        }
        try {
            l o = FetchedAppSettingsManager.o(com.facebook.f.g(), false);
            if (o == null || (n = o.n()) == null) {
                return;
            }
            g(n);
            if ((b.isEmpty() && c.isEmpty()) || (j2 = ModelManager.j(ModelManager.Task.MTML_APP_EVENT_PREDICTION)) == null) {
                return;
            }
            com.facebook.appevents.n.a.d(j2);
            Activity p = com.facebook.appevents.internal.a.p();
            if (p != null) {
                h(p);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(String str) {
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return false;
        }
        try {
            return c.contains(str);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(String str) {
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return false;
        }
        try {
            return b.contains(str);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
            return false;
        }
    }

    protected static void g(String str) {
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("production_events")) {
                JSONArray jSONArray = jSONObject.getJSONArray("production_events");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    b.add(jSONArray.getString(i2));
                }
            }
            if (jSONObject.has("eligible_for_prediction_events")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("eligible_for_prediction_events");
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    c.add(jSONArray2.getString(i3));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
        }
    }

    public static void h(Activity activity) {
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return;
        }
        try {
            if (a.get() && com.facebook.appevents.n.a.f() && (!b.isEmpty() || !c.isEmpty())) {
                e.d(activity);
            } else {
                e.f(activity);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, d.class);
        }
    }
}
