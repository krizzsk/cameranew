package com.bumptech.glide.j;

import com.bumptech.glide.l.g;
import java.util.HashMap;
import java.util.Map;
/* compiled from: DataLoadProviderRegistry.java */
/* loaded from: classes.dex */
public class c {
    private static final g b = new g();
    private final Map<g, b<?, ?>> a = new HashMap();

    public <T, Z> b<T, Z> a(Class<T> cls, Class<Z> cls2) {
        b<T, Z> bVar;
        g gVar = b;
        synchronized (gVar) {
            gVar.a(cls, cls2);
            bVar = (b<T, Z>) this.a.get(gVar);
        }
        return bVar == null ? d.a() : bVar;
    }

    public <T, Z> void b(Class<T> cls, Class<Z> cls2, b<T, Z> bVar) {
        this.a.put(new g(cls, cls2), bVar);
    }
}
