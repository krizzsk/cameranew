package com.bumptech.glide.load.model;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class GenericLoaderFactory {

    /* renamed from: d  reason: collision with root package name */
    private static final k f771d = new a();
    private final Map<Class, Map<Class, l>> a = new HashMap();
    private final Map<Class, Map<Class, k>> b = new HashMap();
    private final Context c;

    /* loaded from: classes.dex */
    static class a implements k {
        a() {
        }

        @Override // com.bumptech.glide.load.model.k
        public com.bumptech.glide.load.g.c a(Object obj, int i2, int i3) {
            throw new NoSuchMethodError("This should never be called!");
        }

        public String toString() {
            return "NULL_MODEL_LOADER";
        }
    }

    public GenericLoaderFactory(Context context) {
        this.c = context.getApplicationContext();
    }

    private <T, Y> void b(Class<T> cls, Class<Y> cls2, k<T, Y> kVar) {
        Map<Class, k> map = this.b.get(cls);
        if (map == null) {
            map = new HashMap<>();
            this.b.put(cls, map);
        }
        map.put(cls2, kVar);
    }

    private <T, Y> void c(Class<T> cls, Class<Y> cls2) {
        b(cls, cls2, f771d);
    }

    private <T, Y> k<T, Y> d(Class<T> cls, Class<Y> cls2) {
        Map<Class, k> map = this.b.get(cls);
        if (map != null) {
            return map.get(cls2);
        }
        return null;
    }

    private <T, Y> l<T, Y> e(Class<T> cls, Class<Y> cls2) {
        Map<Class, l> map;
        Map<Class, l> map2 = this.a.get(cls);
        l lVar = map2 != null ? map2.get(cls2) : null;
        if (lVar == null) {
            for (Class cls3 : this.a.keySet()) {
                if (cls3.isAssignableFrom(cls) && (map = this.a.get(cls3)) != null && (lVar = map.get(cls2)) != null) {
                    break;
                }
            }
        }
        return lVar;
    }

    public synchronized <T, Y> k<T, Y> a(Class<T> cls, Class<Y> cls2) {
        k<T, Y> d2 = d(cls, cls2);
        if (d2 != null) {
            if (f771d.equals(d2)) {
                return null;
            }
            return d2;
        }
        l<T, Y> e2 = e(cls, cls2);
        if (e2 != null) {
            d2 = e2.a(this.c, this);
            b(cls, cls2, d2);
        } else {
            c(cls, cls2);
        }
        return d2;
    }

    public synchronized <T, Y> l<T, Y> f(Class<T> cls, Class<Y> cls2, l<T, Y> lVar) {
        l<T, Y> put;
        this.b.clear();
        Map<Class, l> map = this.a.get(cls);
        if (map == null) {
            map = new HashMap<>();
            this.a.put(cls, map);
        }
        put = map.put(cls2, lVar);
        if (put != null) {
            Iterator<Map<Class, l>> it = this.a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().containsValue(put)) {
                    put = null;
                    break;
                }
            }
        }
        return put;
    }
}
