package com.facebook.appevents;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Patterns;
import androidx.annotation.RestrictTo;
import com.facebook.internal.x;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: UserDataStore.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class i {
    private static final String a = "i";
    private static SharedPreferences b;
    private static AtomicBoolean c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f2300d = new ConcurrentHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f2301e = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UserDataStore.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                if (!i.a().get()) {
                    i.b();
                }
                i.c().edit().putString(this.a, this.b).apply();
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    static /* synthetic */ AtomicBoolean a() {
        if (com.facebook.internal.instrument.e.a.c(i.class)) {
            return null;
        }
        try {
            return c;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, i.class);
            return null;
        }
    }

    static /* synthetic */ void b() {
        if (com.facebook.internal.instrument.e.a.c(i.class)) {
            return;
        }
        try {
            f();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, i.class);
        }
    }

    static /* synthetic */ SharedPreferences c() {
        if (com.facebook.internal.instrument.e.a.c(i.class)) {
            return null;
        }
        try {
            return b;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, i.class);
            return null;
        }
    }

    public static String d() {
        if (com.facebook.internal.instrument.e.a.c(i.class)) {
            return null;
        }
        try {
            if (!c.get()) {
                f();
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(f2300d);
            hashMap.putAll(e());
            return x.b0(hashMap);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, i.class);
            return null;
        }
    }

    private static Map<String, String> e() {
        if (com.facebook.internal.instrument.e.a.c(i.class)) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            Set<String> b2 = com.facebook.appevents.j.c.b();
            for (String str : f2301e.keySet()) {
                if (b2.contains(str)) {
                    hashMap.put(str, f2301e.get(str));
                }
            }
            return hashMap;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, i.class);
            return null;
        }
    }

    private static synchronized void f() {
        synchronized (i.class) {
            if (com.facebook.internal.instrument.e.a.c(i.class)) {
                return;
            }
            if (c.get()) {
                return;
            }
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(com.facebook.f.f());
            b = defaultSharedPreferences;
            String string = defaultSharedPreferences.getString("com.facebook.appevents.UserDataStore.userData", "");
            String string2 = b.getString("com.facebook.appevents.UserDataStore.internalUserData", "");
            f2300d.putAll(x.a(string));
            f2301e.putAll(x.a(string2));
            c.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g() {
        if (com.facebook.internal.instrument.e.a.c(i.class)) {
            return;
        }
        try {
            if (c.get()) {
                return;
            }
            f();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, i.class);
        }
    }

    private static String h(String str, String str2) {
        if (com.facebook.internal.instrument.e.a.c(i.class)) {
            return null;
        }
        try {
            String lowerCase = str2.trim().toLowerCase();
            if ("em".equals(str)) {
                if (Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                    return lowerCase;
                }
                Log.e(a, "Setting email failure: this is not a valid email address");
                return "";
            } else if ("ph".equals(str)) {
                return lowerCase.replaceAll("[^0-9]", "");
            } else {
                if ("ge".equals(str)) {
                    String substring = lowerCase.length() > 0 ? lowerCase.substring(0, 1) : "";
                    if (!"f".equals(substring) && !"m".equals(substring)) {
                        Log.e(a, "Setting gender failure: the supported value for gender is f or m");
                        return "";
                    }
                    return substring;
                }
                return lowerCase;
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, i.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Map<String, String> map) {
        if (com.facebook.internal.instrument.e.a.c(i.class)) {
            return;
        }
        try {
            if (!c.get()) {
                f();
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String v0 = x.v0(h(key, map.get(key).trim()));
                ConcurrentHashMap<String, String> concurrentHashMap = f2301e;
                if (concurrentHashMap.containsKey(key)) {
                    String str = concurrentHashMap.get(key);
                    String[] split = str != null ? str.split(",") : new String[0];
                    HashSet hashSet = new HashSet(Arrays.asList(split));
                    if (hashSet.contains(v0)) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    if (split.length == 0) {
                        sb.append(v0);
                    } else if (split.length < 5) {
                        sb.append(str);
                        sb.append(",");
                        sb.append(v0);
                    } else {
                        for (int i2 = 1; i2 < 5; i2++) {
                            sb.append(split[i2]);
                            sb.append(",");
                        }
                        sb.append(v0);
                        hashSet.remove(split[0]);
                    }
                    f2301e.put(key, sb.toString());
                } else {
                    concurrentHashMap.put(key, v0);
                }
            }
            j("com.facebook.appevents.UserDataStore.internalUserData", x.b0(f2301e));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, i.class);
        }
    }

    private static void j(String str, String str2) {
        if (com.facebook.internal.instrument.e.a.c(i.class)) {
            return;
        }
        try {
            com.facebook.f.p().execute(new a(str, str2));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, i.class);
        }
    }
}
