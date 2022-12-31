package com.facebook.imagepipeline.core;

import android.net.Uri;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.cache.r;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.producers.n0;
import com.facebook.imagepipeline.producers.u0;
import com.facebook.imagepipeline.producers.y0;
import com.facebook.imagepipeline.producers.z;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: ImagePipeline.java */
@ThreadSafe
/* loaded from: classes.dex */
public class h {
    private static final CancellationException m = new CancellationException("Prefetching is not enabled");
    private final o a;
    private final com.facebook.imagepipeline.e.e b;
    private final com.facebook.imagepipeline.e.d c;

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.common.internal.k<Boolean> f2731d;

    /* renamed from: e  reason: collision with root package name */
    private final r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> f2732e;

    /* renamed from: f  reason: collision with root package name */
    private final r<com.facebook.cache.common.b, PooledByteBuffer> f2733f;

    /* renamed from: g  reason: collision with root package name */
    private final com.facebook.imagepipeline.cache.f f2734g;

    /* renamed from: h  reason: collision with root package name */
    private final com.facebook.common.internal.k<Boolean> f2735h;

    /* renamed from: i  reason: collision with root package name */
    private AtomicLong f2736i = new AtomicLong();

    /* renamed from: j  reason: collision with root package name */
    private final com.facebook.common.internal.k<Boolean> f2737j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private final com.facebook.callercontext.a f2738k;

    /* renamed from: l  reason: collision with root package name */
    private final j f2739l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImagePipeline.java */
    /* loaded from: classes.dex */
    public class a implements com.facebook.common.internal.i<com.facebook.cache.common.b> {
        final /* synthetic */ Uri a;

        a(h hVar, Uri uri) {
            this.a = uri;
        }

        @Override // com.facebook.common.internal.i
        /* renamed from: a */
        public boolean apply(com.facebook.cache.common.b bVar) {
            return bVar.b(this.a);
        }
    }

    public h(o oVar, Set<com.facebook.imagepipeline.e.e> set, Set<com.facebook.imagepipeline.e.d> set2, com.facebook.common.internal.k<Boolean> kVar, r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> rVar, r<com.facebook.cache.common.b, PooledByteBuffer> rVar2, com.facebook.imagepipeline.cache.e eVar, com.facebook.imagepipeline.cache.e eVar2, com.facebook.imagepipeline.cache.f fVar, y0 y0Var, com.facebook.common.internal.k<Boolean> kVar2, com.facebook.common.internal.k<Boolean> kVar3, @Nullable com.facebook.callercontext.a aVar, j jVar) {
        this.a = oVar;
        this.b = new com.facebook.imagepipeline.e.c(set);
        this.c = new com.facebook.imagepipeline.e.b(set2);
        this.f2731d = kVar;
        this.f2732e = rVar;
        this.f2733f = rVar2;
        this.f2734g = fVar;
        this.f2735h = kVar2;
        this.f2737j = kVar3;
        this.f2738k = aVar;
        this.f2739l = jVar;
    }

    private com.facebook.common.internal.i<com.facebook.cache.common.b> j(Uri uri) {
        return new a(this, uri);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> n(com.facebook.imagepipeline.producers.n0<com.facebook.common.references.a<T>> r15, com.facebook.imagepipeline.request.ImageRequest r16, com.facebook.imagepipeline.request.ImageRequest.RequestLevel r17, java.lang.Object r18, @javax.annotation.Nullable com.facebook.imagepipeline.e.e r19, @javax.annotation.Nullable java.lang.String r20) {
        /*
            r14 = this;
            r1 = r14
            boolean r0 = com.facebook.imagepipeline.f.b.d()
            if (r0 == 0) goto Lc
            java.lang.String r0 = "ImagePipeline#submitFetchRequest"
            com.facebook.imagepipeline.f.b.a(r0)
        Lc:
            com.facebook.imagepipeline.producers.z r0 = new com.facebook.imagepipeline.producers.z
            r3 = r16
            r2 = r19
            com.facebook.imagepipeline.e.e r2 = r14.i(r3, r2)
            com.facebook.imagepipeline.e.d r4 = r1.c
            r0.<init>(r2, r4)
            com.facebook.callercontext.a r2 = r1.f2738k
            r4 = 0
            r7 = r18
            if (r2 == 0) goto L25
            r2.a(r7, r4)
        L25:
            com.facebook.imagepipeline.request.ImageRequest$RequestLevel r2 = r16.h()     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            r5 = r17
            com.facebook.imagepipeline.request.ImageRequest$RequestLevel r8 = com.facebook.imagepipeline.request.ImageRequest.RequestLevel.getMax(r2, r5)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            com.facebook.imagepipeline.producers.u0 r13 = new com.facebook.imagepipeline.producers.u0     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            java.lang.String r5 = r14.f()     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            r9 = 0
            boolean r2 = r16.m()     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            if (r2 != 0) goto L49
            android.net.Uri r2 = r16.s()     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            boolean r2 = com.facebook.common.util.d.m(r2)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            if (r2 != 0) goto L47
            goto L49
        L47:
            r10 = 0
            goto L4b
        L49:
            r2 = 1
            r10 = 1
        L4b:
            com.facebook.imagepipeline.common.Priority r11 = r16.l()     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            com.facebook.imagepipeline.core.j r12 = r1.f2739l     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            r2 = r13
            r3 = r16
            r4 = r5
            r5 = r20
            r6 = r0
            r7 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            r2 = r15
            com.facebook.datasource.b r0 = com.facebook.imagepipeline.a.c.G(r15, r13, r0)     // Catch: java.lang.Throwable -> L6c java.lang.Exception -> L6e
            boolean r2 = com.facebook.imagepipeline.f.b.d()
            if (r2 == 0) goto L6b
            com.facebook.imagepipeline.f.b.b()
        L6b:
            return r0
        L6c:
            r0 = move-exception
            goto L7d
        L6e:
            r0 = move-exception
            com.facebook.datasource.b r0 = com.facebook.datasource.c.b(r0)     // Catch: java.lang.Throwable -> L6c
            boolean r2 = com.facebook.imagepipeline.f.b.d()
            if (r2 == 0) goto L7c
            com.facebook.imagepipeline.f.b.b()
        L7c:
            return r0
        L7d:
            boolean r2 = com.facebook.imagepipeline.f.b.d()
            if (r2 == 0) goto L86
            com.facebook.imagepipeline.f.b.b()
        L86:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.core.h.n(com.facebook.imagepipeline.producers.n0, com.facebook.imagepipeline.request.ImageRequest, com.facebook.imagepipeline.request.ImageRequest$RequestLevel, java.lang.Object, com.facebook.imagepipeline.e.e, java.lang.String):com.facebook.datasource.b");
    }

    private com.facebook.datasource.b<Void> o(n0<Void> n0Var, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority, @Nullable com.facebook.imagepipeline.e.e eVar) {
        z zVar = new z(i(imageRequest, eVar), this.c);
        com.facebook.callercontext.a aVar = this.f2738k;
        if (aVar != null) {
            aVar.a(obj, true);
        }
        try {
            return com.facebook.imagepipeline.a.d.F(n0Var, new u0(imageRequest, f(), zVar, obj, ImageRequest.RequestLevel.getMax(imageRequest.h(), requestLevel), true, false, priority, this.f2739l), zVar);
        } catch (Exception e2) {
            return com.facebook.datasource.c.b(e2);
        }
    }

    public void a(Uri uri) {
        com.facebook.common.internal.i<com.facebook.cache.common.b> j2 = j(uri);
        this.f2732e.d(j2);
        this.f2733f.d(j2);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> b(ImageRequest imageRequest, Object obj) {
        return c(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> c(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel) {
        return d(imageRequest, obj, requestLevel, null);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> d(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, @Nullable com.facebook.imagepipeline.e.e eVar) {
        return e(imageRequest, obj, requestLevel, eVar, null);
    }

    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> e(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, @Nullable com.facebook.imagepipeline.e.e eVar, @Nullable String str) {
        try {
            return n(this.a.g(imageRequest), imageRequest, requestLevel, obj, eVar, str);
        } catch (Exception e2) {
            return com.facebook.datasource.c.b(e2);
        }
    }

    public String f() {
        return String.valueOf(this.f2736i.getAndIncrement());
    }

    public r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> g() {
        return this.f2732e;
    }

    public com.facebook.imagepipeline.cache.f h() {
        return this.f2734g;
    }

    public com.facebook.imagepipeline.e.e i(ImageRequest imageRequest, @Nullable com.facebook.imagepipeline.e.e eVar) {
        if (eVar == null) {
            if (imageRequest.n() == null) {
                return this.b;
            }
            return new com.facebook.imagepipeline.e.c(this.b, imageRequest.n());
        } else if (imageRequest.n() == null) {
            return new com.facebook.imagepipeline.e.c(this.b, eVar);
        } else {
            return new com.facebook.imagepipeline.e.c(this.b, eVar, imageRequest.n());
        }
    }

    public com.facebook.datasource.b<Void> k(ImageRequest imageRequest, Object obj) {
        return l(imageRequest, obj, Priority.MEDIUM);
    }

    public com.facebook.datasource.b<Void> l(ImageRequest imageRequest, Object obj, Priority priority) {
        return m(imageRequest, obj, priority, null);
    }

    public com.facebook.datasource.b<Void> m(ImageRequest imageRequest, Object obj, Priority priority, @Nullable com.facebook.imagepipeline.e.e eVar) {
        if (!this.f2731d.get().booleanValue()) {
            return com.facebook.datasource.c.b(m);
        }
        try {
            return o(this.a.i(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority, eVar);
        } catch (Exception e2) {
            return com.facebook.datasource.c.b(e2);
        }
    }
}
