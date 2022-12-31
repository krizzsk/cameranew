package com.facebook.appevents.k;

import androidx.annotation.RestrictTo;
import com.facebook.appevents.AppEvent;
import com.facebook.f;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.l;
import com.facebook.internal.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: EventDeactivationManager.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class a {
    private static boolean a = false;
    private static final List<C0080a> b = new ArrayList();
    private static final Set<String> c = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventDeactivationManager.java */
    /* renamed from: com.facebook.appevents.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0080a {
        String a;
        List<String> b;

        C0080a(String str, List<String> list) {
            this.a = str;
            this.b = list;
        }
    }

    public static void a() {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            a = true;
            b();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }

    private static synchronized void b() {
        l o;
        synchronized (a.class) {
            if (com.facebook.internal.instrument.e.a.c(a.class)) {
                return;
            }
            try {
                o = FetchedAppSettingsManager.o(f.g(), false);
            } catch (Exception unused) {
            }
            if (o == null) {
                return;
            }
            String j2 = o.j();
            if (!j2.isEmpty()) {
                JSONObject jSONObject = new JSONObject(j2);
                b.clear();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    if (jSONObject2 != null) {
                        if (jSONObject2.optBoolean("is_deprecated_event")) {
                            c.add(next);
                        } else {
                            JSONArray optJSONArray = jSONObject2.optJSONArray("deprecated_param");
                            C0080a c0080a = new C0080a(next, new ArrayList());
                            if (optJSONArray != null) {
                                c0080a.b = x.k(optJSONArray);
                            }
                            b.add(c0080a);
                        }
                    }
                }
            }
        }
    }

    public static void c(Map<String, String> map, String str) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            if (a) {
                ArrayList<String> arrayList = new ArrayList(map.keySet());
                for (C0080a c0080a : new ArrayList(b)) {
                    if (c0080a.a.equals(str)) {
                        for (String str2 : arrayList) {
                            if (c0080a.b.contains(str2)) {
                                map.remove(str2);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }

    public static void d(List<AppEvent> list) {
        if (com.facebook.internal.instrument.e.a.c(a.class)) {
            return;
        }
        try {
            if (a) {
                Iterator<AppEvent> it = list.iterator();
                while (it.hasNext()) {
                    if (c.contains(it.next().getName())) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, a.class);
        }
    }
}
