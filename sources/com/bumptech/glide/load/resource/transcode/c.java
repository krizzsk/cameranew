package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.l.g;
import java.util.HashMap;
import java.util.Map;
/* compiled from: TranscoderRegistry.java */
/* loaded from: classes.dex */
public class c {
    private static final g b = new g();
    private final Map<g, b<?, ?>> a = new HashMap();

    public <Z, R> b<Z, R> a(Class<Z> cls, Class<R> cls2) {
        b<Z, R> bVar;
        if (cls.equals(cls2)) {
            return d.b();
        }
        g gVar = b;
        synchronized (gVar) {
            gVar.a(cls, cls2);
            bVar = (b<Z, R>) this.a.get(gVar);
        }
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalArgumentException("No transcoder registered for " + cls + " and " + cls2);
    }

    public <Z, R> void b(Class<Z> cls, Class<R> cls2, b<Z, R> bVar) {
        this.a.put(new g(cls, cls2), bVar);
    }
}
