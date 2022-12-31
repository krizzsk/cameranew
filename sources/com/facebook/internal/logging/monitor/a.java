package com.facebook.internal.logging.monitor;

import android.os.Bundle;
import androidx.annotation.RestrictTo;
import com.facebook.GraphRequest;
import com.facebook.f;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
/* compiled from: Monitor.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class a {
    private static boolean a;
    private static final com.facebook.internal.logging.b b;
    private static final Map<String, Integer> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Monitor.java */
    /* renamed from: com.facebook.internal.logging.monitor.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0112a implements Runnable {
        RunnableC0112a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                JSONObject b = a.b();
                if (b != null) {
                    a.d(b);
                }
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    static {
        new Random();
        b = b.e(MonitorLoggingQueue.getInstance(), MonitorLoggingStore.getInstance());
        MetricsUtil.getInstance();
        c = new HashMap();
        new AtomicLong(0L);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a() {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            if (a) {
                return;
            }
            a = true;
            c();
            b.a();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }

    static JSONObject b() {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("fields", "monitoring_config");
            GraphRequest J = GraphRequest.J(null, f.g(), null);
            J.a0(true);
            J.Z(bundle);
            return J.g().h();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return null;
        }
    }

    static void c() {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            f.p().execute(new RunnableC0112a());
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }

    static void d(JSONObject jSONObject) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONObject("monitoring_config").getJSONArray("sample_rates");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                String string = jSONObject2.getString("key");
                int i3 = jSONObject2.getInt(FirebaseAnalytics.Param.VALUE);
                if (!IADStatisticBase.VARCHAR_DEFALUT_VALUE.equals(string)) {
                    c.put(string, Integer.valueOf(i3));
                }
            }
        } catch (JSONException unused) {
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }
}
