package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.GraphRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: FetchedAppGateKeepersManager.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class k {
    private static final AtomicBoolean a = new AtomicBoolean(false);
    private static final ConcurrentLinkedQueue<c> b = new ConcurrentLinkedQueue<>();
    private static final Map<String, JSONObject> c = new ConcurrentHashMap();
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static Long f3056d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FetchedAppGateKeepersManager.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ Context b;
        final /* synthetic */ String c;

        a(String str, Context context, String str2) {
            this.a = str;
            this.b = context;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                JSONObject e2 = k.e(this.a);
                if (e2 != null) {
                    k.k(this.a, e2);
                    this.b.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(this.c, e2.toString()).apply();
                    Long unused = k.f3056d = Long.valueOf(System.currentTimeMillis());
                }
                k.l();
                k.a.set(false);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FetchedAppGateKeepersManager.java */
    /* loaded from: classes.dex */
    public static class b implements Runnable {
        final /* synthetic */ c a;

        b(c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                this.a.onCompleted();
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* compiled from: FetchedAppGateKeepersManager.java */
    /* loaded from: classes.dex */
    public interface c {
        void onCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static JSONObject e(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("platform", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
        bundle.putString("sdk_version", com.facebook.f.w());
        bundle.putString("fields", "gatekeepers");
        GraphRequest J = GraphRequest.J(null, String.format("%s/%s", str, "mobile_sdk_gk"), null);
        J.a0(true);
        J.Z(bundle);
        return J.g().h();
    }

    public static boolean f(String str, String str2, boolean z) {
        Boolean bool;
        Map<String, Boolean> g2 = g(str2);
        return (g2.containsKey(str) && (bool = g2.get(str)) != null) ? bool.booleanValue() : z;
    }

    public static Map<String, Boolean> g(String str) {
        i();
        if (str != null) {
            Map<String, JSONObject> map = c;
            if (map.containsKey(str)) {
                HashMap hashMap = new HashMap();
                JSONObject jSONObject = map.get(str);
                if (jSONObject == null) {
                    return new HashMap();
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, Boolean.valueOf(jSONObject.optBoolean(next)));
                }
                return hashMap;
            }
        }
        return new HashMap();
    }

    private static boolean h(@Nullable Long l2) {
        return l2 != null && System.currentTimeMillis() - l2.longValue() < 3600000;
    }

    static void i() {
        j(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void j(@Nullable c cVar) {
        synchronized (k.class) {
            if (cVar != null) {
                b.add(cVar);
            }
            if (h(f3056d)) {
                l();
                return;
            }
            Context f2 = com.facebook.f.f();
            String g2 = com.facebook.f.g();
            String format = String.format("com.facebook.internal.APP_GATEKEEPERS.%s", g2);
            if (f2 == null) {
                return;
            }
            JSONObject jSONObject = null;
            String string = f2.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).getString(format, null);
            if (!x.S(string)) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e2) {
                    x.X("FacebookSDK", e2);
                }
                if (jSONObject != null) {
                    k(g2, jSONObject);
                }
            }
            Executor p = com.facebook.f.p();
            if (p == null) {
                return;
            }
            if (a.compareAndSet(false, true)) {
                p.execute(new a(g2, f2, format));
            }
        }
    }

    protected static synchronized JSONObject k(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (k.class) {
            Map<String, JSONObject> map = c;
            if (map.containsKey(str)) {
                jSONObject2 = map.get(str);
            } else {
                jSONObject2 = new JSONObject();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            JSONObject optJSONObject = optJSONArray != null ? optJSONArray.optJSONObject(0) : null;
            if (optJSONObject != null && optJSONObject.optJSONArray("gatekeepers") != null) {
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("gatekeepers");
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    try {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                        jSONObject2.put(jSONObject3.getString("key"), jSONObject3.getBoolean(FirebaseAnalytics.Param.VALUE));
                    } catch (JSONException e2) {
                        x.X("FacebookSDK", e2);
                    }
                }
            }
            c.put(str, jSONObject2);
        }
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (true) {
            ConcurrentLinkedQueue<c> concurrentLinkedQueue = b;
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            c poll = concurrentLinkedQueue.poll();
            if (poll != null) {
                handler.post(new b(poll));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static JSONObject m(String str, boolean z) {
        if (!z) {
            Map<String, JSONObject> map = c;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        JSONObject e2 = e(str);
        if (e2 == null) {
            return null;
        }
        com.facebook.f.f().getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(String.format("com.facebook.internal.APP_GATEKEEPERS.%s", str), e2.toString()).apply();
        return k(str, e2);
    }
}
