package com.facebook.appevents.m;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.facebook.f;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.l;
import com.facebook.internal.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: RestrictiveDataManager.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class a {
    private static boolean a = false;
    private static final String b = "com.facebook.appevents.m.a";
    private static final List<C0081a> c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private static final Set<String> f2323d = new CopyOnWriteArraySet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RestrictiveDataManager.java */
    /* renamed from: com.facebook.appevents.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0081a {
        String a;
        Map<String, String> b;

        C0081a(String str, Map<String, String> map) {
            this.a = str;
            this.b = map;
        }
    }

    public static void a() {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            a = true;
            c();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }

    @Nullable
    private static String b(String str, String str2) {
        try {
            if (com.facebook.internal.instrument.e.a.c(a.class)) {
                return null;
            }
            try {
                for (C0081a c0081a : new ArrayList(c)) {
                    if (c0081a != null && str.equals(c0081a.a)) {
                        for (String str3 : c0081a.b.keySet()) {
                            if (str2.equals(str3)) {
                                return c0081a.b.get(str3);
                            }
                        }
                        continue;
                    }
                }
            } catch (Exception e2) {
                Log.w(b, "getMatchedRuleType failed", e2);
            }
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return null;
        }
    }

    private static void c() {
        String j2;
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            l o = FetchedAppSettingsManager.o(f.g(), false);
            if (o != null && (j2 = o.j()) != null && !j2.isEmpty()) {
                JSONObject jSONObject = new JSONObject(j2);
                c.clear();
                f2323d.clear();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    if (jSONObject2 != null) {
                        JSONObject optJSONObject = jSONObject2.optJSONObject("restrictive_param");
                        C0081a c0081a = new C0081a(next, new HashMap());
                        if (optJSONObject != null) {
                            c0081a.b = x.l(optJSONObject);
                            c.add(c0081a);
                        }
                        if (jSONObject2.has("process_event_name")) {
                            f2323d.add(c0081a.a);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }

    private static boolean d(String str) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return false;
        }
        try {
            return f2323d.contains(str);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return false;
        }
    }

    public static String e(String str) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return null;
        }
        try {
            return a ? d(str) ? "_removed_" : str : str;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
            return null;
        }
    }

    public static void f(Map<String, String> map, String str) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            if (a) {
                HashMap hashMap = new HashMap();
                for (String str2 : new ArrayList(map.keySet())) {
                    String b2 = b(str, str2);
                    if (b2 != null) {
                        hashMap.put(str2, b2);
                        map.remove(str2);
                    }
                }
                if (hashMap.size() > 0) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        for (Map.Entry entry : hashMap.entrySet()) {
                            jSONObject.put((String) entry.getKey(), entry.getValue());
                        }
                        map.put("_restrictedParams", jSONObject.toString());
                    } catch (JSONException unused) {
                    }
                }
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }
}
