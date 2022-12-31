package com.bumptech.glide.load.engine;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.a;
import com.bumptech.glide.load.engine.cache.a;
import com.bumptech.glide.load.engine.cache.g;
import com.bumptech.glide.load.engine.g;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
/* compiled from: Engine.java */
/* loaded from: classes.dex */
public class b implements com.bumptech.glide.load.engine.d, g.a, g.a {
    private final Map<com.bumptech.glide.load.b, com.bumptech.glide.load.engine.c> a;
    private final f b;
    private final com.bumptech.glide.load.engine.cache.g c;

    /* renamed from: d  reason: collision with root package name */
    private final a f719d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<com.bumptech.glide.load.b, WeakReference<g<?>>> f720e;

    /* renamed from: f  reason: collision with root package name */
    private final j f721f;

    /* renamed from: g  reason: collision with root package name */
    private final C0028b f722g;

    /* renamed from: h  reason: collision with root package name */
    private ReferenceQueue<g<?>> f723h;

    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    static class a {
        private final ExecutorService a;
        private final ExecutorService b;
        private final com.bumptech.glide.load.engine.d c;

        public a(ExecutorService executorService, ExecutorService executorService2, com.bumptech.glide.load.engine.d dVar) {
            this.a = executorService;
            this.b = executorService2;
            this.c = dVar;
        }

        public com.bumptech.glide.load.engine.c a(com.bumptech.glide.load.b bVar, boolean z) {
            return new com.bumptech.glide.load.engine.c(bVar, this.a, this.b, z, this.c);
        }
    }

    /* compiled from: Engine.java */
    /* renamed from: com.bumptech.glide.load.engine.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0028b implements a.InterfaceC0027a {
        private final a.InterfaceC0031a a;
        private volatile com.bumptech.glide.load.engine.cache.a b;

        public C0028b(a.InterfaceC0031a interfaceC0031a) {
            this.a = interfaceC0031a;
        }

        @Override // com.bumptech.glide.load.engine.a.InterfaceC0027a
        public com.bumptech.glide.load.engine.cache.a a() {
            if (this.b == null) {
                synchronized (this) {
                    if (this.b == null) {
                        this.b = this.a.build();
                    }
                    if (this.b == null) {
                        this.b = new com.bumptech.glide.load.engine.cache.b();
                    }
                }
            }
            return this.b;
        }
    }

    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public static class c {
        private final com.bumptech.glide.load.engine.c a;
        private final com.bumptech.glide.request.d b;

        public c(com.bumptech.glide.request.d dVar, com.bumptech.glide.load.engine.c cVar) {
            this.b = dVar;
            this.a = cVar;
        }

        public void a() {
            this.a.k(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public static class d implements MessageQueue.IdleHandler {
        private final Map<com.bumptech.glide.load.b, WeakReference<g<?>>> a;
        private final ReferenceQueue<g<?>> b;

        public d(Map<com.bumptech.glide.load.b, WeakReference<g<?>>> map, ReferenceQueue<g<?>> referenceQueue) {
            this.a = map;
            this.b = referenceQueue;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            e eVar = (e) this.b.poll();
            if (eVar != null) {
                this.a.remove(eVar.a);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Engine.java */
    /* loaded from: classes.dex */
    public static class e extends WeakReference<g<?>> {
        private final com.bumptech.glide.load.b a;

        public e(com.bumptech.glide.load.b bVar, g<?> gVar, ReferenceQueue<? super g<?>> referenceQueue) {
            super(gVar, referenceQueue);
            this.a = bVar;
        }
    }

    public b(com.bumptech.glide.load.engine.cache.g gVar, a.InterfaceC0031a interfaceC0031a, ExecutorService executorService, ExecutorService executorService2) {
        this(gVar, interfaceC0031a, executorService, executorService2, null, null, null, null, null);
    }

    private g<?> e(com.bumptech.glide.load.b bVar) {
        i<?> d2 = this.c.d(bVar);
        if (d2 == null) {
            return null;
        }
        if (d2 instanceof g) {
            return (g) d2;
        }
        return new g<>(d2, true);
    }

    private ReferenceQueue<g<?>> f() {
        if (this.f723h == null) {
            this.f723h = new ReferenceQueue<>();
            Looper.myQueue().addIdleHandler(new d(this.f720e, this.f723h));
        }
        return this.f723h;
    }

    private g<?> h(com.bumptech.glide.load.b bVar, boolean z) {
        g<?> gVar = null;
        if (z) {
            WeakReference<g<?>> weakReference = this.f720e.get(bVar);
            if (weakReference != null) {
                gVar = weakReference.get();
                if (gVar != null) {
                    gVar.a();
                } else {
                    this.f720e.remove(bVar);
                }
            }
            return gVar;
        }
        return null;
    }

    private g<?> i(com.bumptech.glide.load.b bVar, boolean z) {
        if (z) {
            g<?> e2 = e(bVar);
            if (e2 != null) {
                e2.a();
                this.f720e.put(bVar, new e(bVar, e2, f()));
            }
            return e2;
        }
        return null;
    }

    private static void j(String str, long j2, com.bumptech.glide.load.b bVar) {
        Log.v("Engine", str + " in " + com.bumptech.glide.l.d.a(j2) + "ms, key: " + bVar);
    }

    @Override // com.bumptech.glide.load.engine.cache.g.a
    public void a(i<?> iVar) {
        com.bumptech.glide.l.h.a();
        this.f721f.a(iVar);
    }

    @Override // com.bumptech.glide.load.engine.d
    public void b(com.bumptech.glide.load.b bVar, g<?> gVar) {
        com.bumptech.glide.l.h.a();
        if (gVar != null) {
            gVar.d(bVar, this);
            if (gVar.b()) {
                this.f720e.put(bVar, new e(bVar, gVar, f()));
            }
        }
        this.a.remove(bVar);
    }

    @Override // com.bumptech.glide.load.engine.d
    public void c(com.bumptech.glide.load.engine.c cVar, com.bumptech.glide.load.b bVar) {
        com.bumptech.glide.l.h.a();
        if (cVar.equals(this.a.get(bVar))) {
            this.a.remove(bVar);
        }
    }

    @Override // com.bumptech.glide.load.engine.g.a
    public void d(com.bumptech.glide.load.b bVar, g gVar) {
        com.bumptech.glide.l.h.a();
        this.f720e.remove(bVar);
        if (gVar.b()) {
            this.c.a(bVar, gVar);
        } else {
            this.f721f.a(gVar);
        }
    }

    public <T, Z, R> c g(com.bumptech.glide.load.b bVar, int i2, int i3, com.bumptech.glide.load.g.c<T> cVar, com.bumptech.glide.j.b<T, Z> bVar2, com.bumptech.glide.load.f<Z> fVar, com.bumptech.glide.load.resource.transcode.b<Z, R> bVar3, Priority priority, boolean z, DiskCacheStrategy diskCacheStrategy, com.bumptech.glide.request.d dVar) {
        com.bumptech.glide.l.h.a();
        long b = com.bumptech.glide.l.d.b();
        com.bumptech.glide.load.engine.e a2 = this.b.a(cVar.getId(), bVar, i2, i3, bVar2.f(), bVar2.e(), fVar, bVar2.d(), bVar3, bVar2.b());
        g<?> i4 = i(a2, z);
        if (i4 != null) {
            dVar.a(i4);
            if (Log.isLoggable("Engine", 2)) {
                j("Loaded resource from cache", b, a2);
            }
            return null;
        }
        g<?> h2 = h(a2, z);
        if (h2 != null) {
            dVar.a(h2);
            if (Log.isLoggable("Engine", 2)) {
                j("Loaded resource from active resources", b, a2);
            }
            return null;
        }
        com.bumptech.glide.load.engine.c cVar2 = this.a.get(a2);
        if (cVar2 != null) {
            cVar2.e(dVar);
            if (Log.isLoggable("Engine", 2)) {
                j("Added to existing load", b, a2);
            }
            return new c(dVar, cVar2);
        }
        com.bumptech.glide.load.engine.c a3 = this.f719d.a(a2, z);
        EngineRunnable engineRunnable = new EngineRunnable(a3, new com.bumptech.glide.load.engine.a(a2, i2, i3, cVar, bVar2, fVar, bVar3, this.f722g, diskCacheStrategy, priority), priority);
        this.a.put(a2, a3);
        a3.e(dVar);
        a3.l(engineRunnable);
        if (Log.isLoggable("Engine", 2)) {
            j("Started new load", b, a2);
        }
        return new c(dVar, a3);
    }

    public void k(i iVar) {
        com.bumptech.glide.l.h.a();
        if (iVar instanceof g) {
            ((g) iVar).c();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    b(com.bumptech.glide.load.engine.cache.g gVar, a.InterfaceC0031a interfaceC0031a, ExecutorService executorService, ExecutorService executorService2, Map<com.bumptech.glide.load.b, com.bumptech.glide.load.engine.c> map, f fVar, Map<com.bumptech.glide.load.b, WeakReference<g<?>>> map2, a aVar, j jVar) {
        this.c = gVar;
        this.f722g = new C0028b(interfaceC0031a);
        this.f720e = map2 == null ? new HashMap<>() : map2;
        this.b = fVar == null ? new f() : fVar;
        this.a = map == null ? new HashMap<>() : map;
        this.f719d = aVar == null ? new a(executorService, executorService2, this) : aVar;
        this.f721f = jVar == null ? new j() : jVar;
        gVar.e(this);
    }
}
