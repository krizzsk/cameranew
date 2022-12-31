package com.facebook.imagepipeline.cache;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
/* compiled from: BufferedDiskCache.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: h  reason: collision with root package name */
    private static final Class<?> f2684h = e.class;
    private final com.facebook.cache.disk.h a;
    private final com.facebook.common.memory.f b;
    private final com.facebook.common.memory.i c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f2685d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f2686e;

    /* renamed from: f  reason: collision with root package name */
    private final StagingArea f2687f = StagingArea.getInstance();

    /* renamed from: g  reason: collision with root package name */
    private final n f2688g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BufferedDiskCache.java */
    /* loaded from: classes.dex */
    public class a implements Callable<com.facebook.imagepipeline.image.e> {
        final /* synthetic */ Object a;
        final /* synthetic */ AtomicBoolean b;
        final /* synthetic */ com.facebook.cache.common.b c;

        a(Object obj, AtomicBoolean atomicBoolean, com.facebook.cache.common.b bVar) {
            this.a = obj;
            this.b = atomicBoolean;
            this.c = bVar;
        }

        @Override // java.util.concurrent.Callable
        @Nullable
        /* renamed from: a */
        public com.facebook.imagepipeline.image.e call() throws Exception {
            Object e2 = com.facebook.imagepipeline.d.a.e(this.a, null);
            try {
                if (!this.b.get()) {
                    com.facebook.imagepipeline.image.e b = e.this.f2687f.b(this.c);
                    if (b != null) {
                        com.facebook.common.logging.a.p(e.f2684h, "Found image for %s in staging area", this.c.a());
                        e.this.f2688g.f(this.c);
                    } else {
                        com.facebook.common.logging.a.p(e.f2684h, "Did not find image for %s in staging area", this.c.a());
                        e.this.f2688g.l(this.c);
                        try {
                            PooledByteBuffer n = e.this.n(this.c);
                            if (n == null) {
                                return null;
                            }
                            com.facebook.common.references.a R = com.facebook.common.references.a.R(n);
                            try {
                                b = new com.facebook.imagepipeline.image.e(R);
                            } finally {
                                com.facebook.common.references.a.y(R);
                            }
                        } catch (Exception unused) {
                            return null;
                        }
                    }
                    if (Thread.interrupted()) {
                        com.facebook.common.logging.a.o(e.f2684h, "Host thread was interrupted, decreasing reference count");
                        if (b != null) {
                            b.close();
                        }
                        throw new InterruptedException();
                    }
                    return b;
                }
                throw new CancellationException();
            } catch (Throwable th) {
                try {
                    com.facebook.imagepipeline.d.a.c(this.a, th);
                    throw th;
                } finally {
                    com.facebook.imagepipeline.d.a.f(e2);
                }
            }
        }
    }

    /* compiled from: BufferedDiskCache.java */
    /* loaded from: classes.dex */
    class b implements Runnable {
        final /* synthetic */ Object a;
        final /* synthetic */ com.facebook.cache.common.b b;
        final /* synthetic */ com.facebook.imagepipeline.image.e c;

        b(Object obj, com.facebook.cache.common.b bVar, com.facebook.imagepipeline.image.e eVar) {
            this.a = obj;
            this.b = bVar;
            this.c = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object e2 = com.facebook.imagepipeline.d.a.e(this.a, null);
            try {
                e.this.p(this.b, this.c);
            } finally {
            }
        }
    }

    /* compiled from: BufferedDiskCache.java */
    /* loaded from: classes.dex */
    class c implements Callable<Void> {
        final /* synthetic */ Object a;
        final /* synthetic */ com.facebook.cache.common.b b;

        c(Object obj, com.facebook.cache.common.b bVar) {
            this.a = obj;
            this.b = bVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            Object e2 = com.facebook.imagepipeline.d.a.e(this.a, null);
            try {
                e.this.f2687f.e(this.b);
                e.this.a.d(this.b);
                return null;
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BufferedDiskCache.java */
    /* loaded from: classes.dex */
    public class d implements com.facebook.cache.common.f {
        final /* synthetic */ com.facebook.imagepipeline.image.e a;

        d(com.facebook.imagepipeline.image.e eVar) {
            this.a = eVar;
        }

        @Override // com.facebook.cache.common.f
        public void a(OutputStream outputStream) throws IOException {
            InputStream N = this.a.N();
            com.facebook.common.internal.h.g(N);
            e.this.c.a(N, outputStream);
        }
    }

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.f fVar, com.facebook.common.memory.i iVar, Executor executor, Executor executor2, n nVar) {
        this.a = hVar;
        this.b = fVar;
        this.c = iVar;
        this.f2685d = executor;
        this.f2686e = executor2;
        this.f2688g = nVar;
    }

    private bolts.e<com.facebook.imagepipeline.image.e> j(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.image.e eVar) {
        com.facebook.common.logging.a.p(f2684h, "Found image for %s in staging area", bVar.a());
        this.f2688g.f(bVar);
        return bolts.e.h(eVar);
    }

    private bolts.e<com.facebook.imagepipeline.image.e> l(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        try {
            return bolts.e.b(new a(com.facebook.imagepipeline.d.a.d("BufferedDiskCache_getAsync"), atomicBoolean, bVar), this.f2685d);
        } catch (Exception e2) {
            com.facebook.common.logging.a.y(f2684h, e2, "Failed to schedule disk-cache read for %s", bVar.a());
            return bolts.e.g(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public PooledByteBuffer n(com.facebook.cache.common.b bVar) throws IOException {
        try {
            Class<?> cls = f2684h;
            com.facebook.common.logging.a.p(cls, "Disk cache read for %s", bVar.a());
            com.facebook.binaryresource.a b2 = this.a.b(bVar);
            if (b2 == null) {
                com.facebook.common.logging.a.p(cls, "Disk cache miss for %s", bVar.a());
                this.f2688g.c(bVar);
                return null;
            }
            com.facebook.common.logging.a.p(cls, "Found entry in disk cache for %s", bVar.a());
            this.f2688g.i(bVar);
            InputStream a2 = b2.a();
            PooledByteBuffer b3 = this.b.b(a2, (int) b2.size());
            a2.close();
            com.facebook.common.logging.a.p(cls, "Successful read from disk cache for %s", bVar.a());
            return b3;
        } catch (IOException e2) {
            com.facebook.common.logging.a.y(f2684h, e2, "Exception reading from cache for %s", bVar.a());
            this.f2688g.n(bVar);
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.image.e eVar) {
        Class<?> cls = f2684h;
        com.facebook.common.logging.a.p(cls, "About to write to disk-cache for key %s", bVar.a());
        try {
            this.a.f(bVar, new d(eVar));
            this.f2688g.d(bVar);
            com.facebook.common.logging.a.p(cls, "Successful disk-cache write for key %s", bVar.a());
        } catch (IOException e2) {
            com.facebook.common.logging.a.y(f2684h, e2, "Failed to write to disk-cache for key %s", bVar.a());
        }
    }

    public void h(com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.h.g(bVar);
        this.a.a(bVar);
    }

    public boolean i(com.facebook.cache.common.b bVar) {
        return this.f2687f.a(bVar) || this.a.c(bVar);
    }

    public bolts.e<com.facebook.imagepipeline.image.e> k(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        try {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("BufferedDiskCache#get");
            }
            com.facebook.imagepipeline.image.e b2 = this.f2687f.b(bVar);
            if (b2 != null) {
                return j(bVar, b2);
            }
            bolts.e<com.facebook.imagepipeline.image.e> l2 = l(bVar, atomicBoolean);
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
            return l2;
        } finally {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
    }

    public void m(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.image.e eVar) {
        try {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("BufferedDiskCache#put");
            }
            com.facebook.common.internal.h.g(bVar);
            com.facebook.common.internal.h.b(Boolean.valueOf(com.facebook.imagepipeline.image.e.Z(eVar)));
            this.f2687f.d(bVar, eVar);
            com.facebook.imagepipeline.image.e e2 = com.facebook.imagepipeline.image.e.e(eVar);
            try {
                this.f2686e.execute(new b(com.facebook.imagepipeline.d.a.d("BufferedDiskCache_putAsync"), bVar, e2));
            } catch (Exception e3) {
                com.facebook.common.logging.a.y(f2684h, e3, "Failed to schedule disk-cache write for %s", bVar.a());
                this.f2687f.f(bVar, eVar);
                com.facebook.imagepipeline.image.e.h(e2);
            }
        } finally {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
    }

    public bolts.e<Void> o(com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.h.g(bVar);
        this.f2687f.e(bVar);
        try {
            return bolts.e.b(new c(com.facebook.imagepipeline.d.a.d("BufferedDiskCache_remove"), bVar), this.f2686e);
        } catch (Exception e2) {
            com.facebook.common.logging.a.y(f2684h, e2, "Failed to schedule disk-cache remove for %s", bVar.a());
            return bolts.e.g(e2);
        }
    }
}
