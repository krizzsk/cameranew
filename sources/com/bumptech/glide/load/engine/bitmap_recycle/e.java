package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: GroupedLinkedMap.java */
/* loaded from: classes.dex */
class e<K extends h, V> {
    private final a<K, V> a = new a<>();
    private final Map<K, a<K, V>> b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GroupedLinkedMap.java */
    /* loaded from: classes.dex */
    public static class a<K, V> {
        private final K a;
        private List<V> b;
        a<K, V> c;

        /* renamed from: d  reason: collision with root package name */
        a<K, V> f725d;

        public a() {
            this(null);
        }

        public void b(V v) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            this.b.add(v);
        }

        public V c() {
            int d2 = d();
            if (d2 > 0) {
                return this.b.remove(d2 - 1);
            }
            return null;
        }

        public int d() {
            List<V> list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public a(K k2) {
            this.f725d = this;
            this.c = this;
            this.a = k2;
        }
    }

    private void b(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.a;
        aVar.f725d = aVar2;
        aVar.c = aVar2.c;
        g(aVar);
    }

    private void c(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.a;
        aVar.f725d = aVar2.f725d;
        aVar.c = aVar2;
        g(aVar);
    }

    private static <K, V> void e(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f725d;
        aVar2.c = aVar.c;
        aVar.c.f725d = aVar2;
    }

    private static <K, V> void g(a<K, V> aVar) {
        aVar.c.f725d = aVar;
        aVar.f725d.c = aVar;
    }

    public V a(K k2) {
        a<K, V> aVar = this.b.get(k2);
        if (aVar == null) {
            aVar = new a<>(k2);
            this.b.put(k2, aVar);
        } else {
            k2.a();
        }
        b(aVar);
        return aVar.c();
    }

    public void d(K k2, V v) {
        a<K, V> aVar = this.b.get(k2);
        if (aVar == null) {
            aVar = new a<>(k2);
            c(aVar);
            this.b.put(k2, aVar);
        } else {
            k2.a();
        }
        aVar.b(v);
    }

    public V f() {
        for (a aVar = this.a.f725d; !aVar.equals(this.a); aVar = aVar.f725d) {
            V v = (V) aVar.c();
            if (v != null) {
                return v;
            }
            e(aVar);
            this.b.remove(aVar.a);
            ((h) aVar.a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.a.c; !aVar.equals(this.a); aVar = aVar.c) {
            z = true;
            sb.append('{');
            sb.append(aVar.a);
            sb.append(':');
            sb.append(aVar.d());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
