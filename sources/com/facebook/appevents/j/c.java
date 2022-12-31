package com.facebook.appevents.j;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: MetadataRule.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class c {

    /* renamed from: d  reason: collision with root package name */
    private static final Set<c> f2320d = new CopyOnWriteArraySet();
    private String a;
    private List<String> b;
    private String c;

    private c(String str, List<String> list, String str2) {
        this.a = str;
        this.b = list;
        this.c = str2;
    }

    private static void a(JSONObject jSONObject) {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("k");
                    String optString2 = optJSONObject.optString("v");
                    if (!optString.isEmpty()) {
                        f2320d.add(new c(next, Arrays.asList(optString.split(",")), optString2));
                    }
                }
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
        }
    }

    public static Set<String> b() {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return null;
        }
        try {
            HashSet hashSet = new HashSet();
            for (c cVar : f2320d) {
                hashSet.add(cVar.d());
            }
            return hashSet;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set<c> e() {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return null;
        }
        try {
            return new HashSet(f2320d);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(String str) {
        if (com.facebook.internal.instrument.e.a.c(c.class)) {
            return;
        }
        try {
            f2320d.clear();
            a(new JSONObject(str));
        } catch (JSONException unused) {
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, c.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> c() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return null;
        }
        try {
            return new ArrayList(this.b);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return null;
        }
        try {
            return this.a;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return null;
        }
        try {
            return this.c;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
            return null;
        }
    }
}
