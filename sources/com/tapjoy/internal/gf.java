package com.tapjoy.internal;

import android.os.SystemClock;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public abstract class gf {
    private static gf c;
    private static final ThreadLocal b = new ThreadLocal() { // from class: com.tapjoy.internal.gf.1
        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ Object initialValue() {
            return new HashMap();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f7571d = false;
    @Nullable
    static Set a = null;

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, @Nullable String str2, @Nullable Map map) {
        gf gfVar;
        Set set = a;
        if ((set == null || !set.contains(str)) && f7571d && (gfVar = c) != null) {
            gfVar.a(v.b(), str, str2, map);
        }
    }

    public static a c(String str) {
        return (a) ((Map) b.get()).get(str);
    }

    public static a d(String str) {
        return (a) ((Map) b.get()).remove(str);
    }

    public static a e(String str) {
        return new a(str);
    }

    protected abstract void a();

    protected abstract void a(long j2);

    protected abstract void a(long j2, String str, @Nullable String str2, @Nullable Map map);

    /* loaded from: classes3.dex */
    public static final class a {
        final String a;
        private final TreeMap b = new TreeMap();
        private final Map c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        private volatile long f7572d;

        a(String str) {
            this.a = str;
        }

        public final a a() {
            try {
                this.f7572d = SystemClock.elapsedRealtime();
            } catch (NullPointerException unused) {
                this.f7572d = -1L;
            }
            return this;
        }

        public final a b() {
            long j2 = this.f7572d;
            if (j2 != -1) {
                try {
                    a("spent_time", SystemClock.elapsedRealtime() - j2);
                } catch (NullPointerException unused) {
                }
            }
            return this;
        }

        public final void c() {
            gf.b(this.a, this.b.size() > 0 ? bh.a((Object) this.b) : null, this.c.size() > 0 ? this.c : null);
        }

        public final a a(String str, Object obj) {
            this.b.put(str, obj);
            return this;
        }

        public final a b(String str) {
            this.b.put("misuse", str);
            return this;
        }

        public final a a(Map map) {
            if (map != null) {
                this.b.putAll(map);
            }
            return this;
        }

        public final a b(Map map) {
            if (map != null) {
                this.c.putAll(map);
            }
            return this;
        }

        public final a a(String str) {
            this.b.put("failure", str);
            return this;
        }

        public final a a(String str, long j2) {
            this.c.put(str, Long.valueOf(j2));
            return this;
        }
    }

    public static void a(gh ghVar) {
        if (c == null) {
            c = ghVar;
            if (f7571d) {
                ghVar.a(v.b());
            }
        }
    }

    public static a b(String str) {
        a aVar = (a) ((Map) b.get()).remove(str);
        return aVar != null ? aVar.b() : new a(str);
    }

    public static void a(boolean z) {
        if (f7571d != z) {
            f7571d = z;
            gf gfVar = c;
            if (gfVar != null) {
                if (z) {
                    gfVar.a(v.b());
                } else {
                    gfVar.a();
                }
            }
        }
    }

    public static void a(Collection collection) {
        if (collection != null && !collection.isEmpty()) {
            a = new HashSet(collection);
        } else {
            a = null;
        }
    }

    public static void a(String str, @Nullable TreeMap treeMap, @Nullable Map map) {
        b(str, treeMap != null ? bh.a((Object) treeMap) : null, map);
    }

    public static a a(String str) {
        a a2 = new a(str).a();
        ((Map) b.get()).put(str, a2);
        return a2;
    }

    public static void a(String str, a aVar) {
        if (aVar != null) {
            if (str.equals(aVar.a)) {
                ((Map) b.get()).put(str, aVar);
            } else {
                String str2 = aVar.a;
            }
        }
    }
}
