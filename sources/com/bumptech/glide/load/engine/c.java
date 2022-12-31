package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.load.engine.EngineRunnable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
/* compiled from: EngineJob.java */
/* loaded from: classes.dex */
class c implements EngineRunnable.a {
    private static final b q = new b();
    private static final Handler r = new Handler(Looper.getMainLooper(), new C0030c());
    private final List<com.bumptech.glide.request.d> a;
    private final b b;
    private final d c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.load.b f737d;

    /* renamed from: e  reason: collision with root package name */
    private final ExecutorService f738e;

    /* renamed from: f  reason: collision with root package name */
    private final ExecutorService f739f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f740g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f741h;

    /* renamed from: i  reason: collision with root package name */
    private i<?> f742i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f743j;

    /* renamed from: k  reason: collision with root package name */
    private Exception f744k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f745l;
    private Set<com.bumptech.glide.request.d> m;
    private EngineRunnable n;
    private g<?> o;
    private volatile Future<?> p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EngineJob.java */
    /* loaded from: classes.dex */
    public static class b {
        b() {
        }

        public <R> g<R> a(i<R> iVar, boolean z) {
            return new g<>(iVar, z);
        }
    }

    /* compiled from: EngineJob.java */
    /* renamed from: com.bumptech.glide.load.engine.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0030c implements Handler.Callback {
        private C0030c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (1 == i2 || 2 == i2) {
                c cVar = (c) message.obj;
                if (1 == i2) {
                    cVar.i();
                } else {
                    cVar.h();
                }
                return true;
            }
            return false;
        }
    }

    public c(com.bumptech.glide.load.b bVar, ExecutorService executorService, ExecutorService executorService2, boolean z, d dVar) {
        this(bVar, executorService, executorService2, z, dVar, q);
    }

    private void f(com.bumptech.glide.request.d dVar) {
        if (this.m == null) {
            this.m = new HashSet();
        }
        this.m.add(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f741h) {
            return;
        }
        if (!this.a.isEmpty()) {
            this.f745l = true;
            this.c.b(this.f737d, null);
            for (com.bumptech.glide.request.d dVar : this.a) {
                if (!j(dVar)) {
                    dVar.onException(this.f744k);
                }
            }
            return;
        }
        throw new IllegalStateException("Received an exception without any callbacks to notify");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f741h) {
            this.f742i.recycle();
        } else if (!this.a.isEmpty()) {
            g<?> a2 = this.b.a(this.f742i, this.f740g);
            this.o = a2;
            this.f743j = true;
            a2.a();
            this.c.b(this.f737d, this.o);
            for (com.bumptech.glide.request.d dVar : this.a) {
                if (!j(dVar)) {
                    this.o.a();
                    dVar.a(this.o);
                }
            }
            this.o.c();
        } else {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        }
    }

    private boolean j(com.bumptech.glide.request.d dVar) {
        Set<com.bumptech.glide.request.d> set = this.m;
        return set != null && set.contains(dVar);
    }

    @Override // com.bumptech.glide.request.d
    public void a(i<?> iVar) {
        this.f742i = iVar;
        r.obtainMessage(1, this).sendToTarget();
    }

    @Override // com.bumptech.glide.load.engine.EngineRunnable.a
    public void d(EngineRunnable engineRunnable) {
        this.p = this.f739f.submit(engineRunnable);
    }

    public void e(com.bumptech.glide.request.d dVar) {
        com.bumptech.glide.l.h.a();
        if (this.f743j) {
            dVar.a(this.o);
        } else if (this.f745l) {
            dVar.onException(this.f744k);
        } else {
            this.a.add(dVar);
        }
    }

    void g() {
        if (this.f745l || this.f743j || this.f741h) {
            return;
        }
        this.n.a();
        Future<?> future = this.p;
        if (future != null) {
            future.cancel(true);
        }
        this.f741h = true;
        this.c.c(this, this.f737d);
    }

    public void k(com.bumptech.glide.request.d dVar) {
        com.bumptech.glide.l.h.a();
        if (!this.f743j && !this.f745l) {
            this.a.remove(dVar);
            if (this.a.isEmpty()) {
                g();
                return;
            }
            return;
        }
        f(dVar);
    }

    public void l(EngineRunnable engineRunnable) {
        this.n = engineRunnable;
        this.p = this.f738e.submit(engineRunnable);
    }

    @Override // com.bumptech.glide.request.d
    public void onException(Exception exc) {
        this.f744k = exc;
        r.obtainMessage(2, this).sendToTarget();
    }

    public c(com.bumptech.glide.load.b bVar, ExecutorService executorService, ExecutorService executorService2, boolean z, d dVar, b bVar2) {
        this.a = new ArrayList();
        this.f737d = bVar;
        this.f738e = executorService;
        this.f739f = executorService2;
        this.f740g = z;
        this.c = dVar;
        this.b = bVar2;
    }
}
