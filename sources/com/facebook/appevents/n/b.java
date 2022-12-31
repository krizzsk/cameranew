package com.facebook.appevents.n;

import android.content.SharedPreferences;
import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.internal.x;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: PredictionHistoryManager.java */
/* loaded from: classes.dex */
final class b {
    private static SharedPreferences b;
    private static final Map<String, String> a = new HashMap();
    private static final AtomicBoolean c = new AtomicBoolean(false);

    b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return;
        }
        try {
            if (!c.get()) {
                c();
            }
            Map<String, String> map = a;
            map.put(str, str2);
            b.edit().putString("SUGGESTED_EVENTS_HISTORY", x.b0(map)).apply();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static String b(View view, String str) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("text", str);
                JSONArray jSONArray = new JSONArray();
                while (view != null) {
                    jSONArray.put(view.getClass().getSimpleName());
                    view = com.facebook.appevents.codeless.internal.d.j(view);
                }
                jSONObject.put("classname", jSONArray);
            } catch (JSONException unused) {
            }
            return x.v0(jSONObject.toString());
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }

    private static void c() {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return;
        }
        try {
            AtomicBoolean atomicBoolean = c;
            if (atomicBoolean.get()) {
                return;
            }
            SharedPreferences sharedPreferences = com.facebook.f.f().getSharedPreferences("com.facebook.internal.SUGGESTED_EVENTS_HISTORY", 0);
            b = sharedPreferences;
            a.putAll(x.a(sharedPreferences.getString("SUGGESTED_EVENTS_HISTORY", "")));
            atomicBoolean.set(true);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static String d(String str) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        try {
            Map<String, String> map = a;
            if (map.containsKey(str)) {
                return map.get(str);
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }
}
