package com.facebook.internal;

import java.util.concurrent.Executor;
/* compiled from: WorkQueue.java */
/* loaded from: classes.dex */
public class z {
    private final Object a;
    private c b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f3096d;

    /* renamed from: e  reason: collision with root package name */
    private c f3097e;

    /* renamed from: f  reason: collision with root package name */
    private int f3098f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WorkQueue.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ c a;

        a(c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                this.a.b().run();
                z.this.e(this.a);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* compiled from: WorkQueue.java */
    /* loaded from: classes.dex */
    public interface b {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WorkQueue.java */
    /* loaded from: classes.dex */
    public class c implements b {
        private final Runnable a;
        private c b;
        private c c;

        c(z zVar, Runnable runnable) {
            this.a = runnable;
        }

        c a(c cVar, boolean z) {
            if (cVar == null) {
                this.c = this;
                this.b = this;
                cVar = this;
            } else {
                this.b = cVar;
                c cVar2 = cVar.c;
                this.c = cVar2;
                cVar2.b = this;
                cVar.c = this;
            }
            return z ? this : cVar;
        }

        Runnable b() {
            return this.a;
        }

        c c(c cVar) {
            if (cVar == this && (cVar = this.b) == this) {
                cVar = null;
            }
            c cVar2 = this.b;
            cVar2.c = this.c;
            this.c.b = cVar2;
            this.c = null;
            this.b = null;
            return cVar;
        }

        void d(boolean z) {
        }
    }

    public z(int i2) {
        this(i2, com.facebook.f.p());
    }

    private void d(c cVar) {
        this.f3096d.execute(new a(cVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(c cVar) {
        c cVar2;
        synchronized (this.a) {
            if (cVar != null) {
                this.f3097e = cVar.c(this.f3097e);
                this.f3098f--;
            }
            if (this.f3098f < this.c) {
                cVar2 = this.b;
                if (cVar2 != null) {
                    this.b = cVar2.c(cVar2);
                    this.f3097e = cVar2.a(this.f3097e, false);
                    this.f3098f++;
                    cVar2.d(true);
                }
            } else {
                cVar2 = null;
            }
        }
        if (cVar2 != null) {
            d(cVar2);
        }
    }

    private void f() {
        e(null);
    }

    public b b(Runnable runnable) {
        return c(runnable, true);
    }

    public b c(Runnable runnable, boolean z) {
        c cVar = new c(this, runnable);
        synchronized (this.a) {
            this.b = cVar.a(this.b, z);
        }
        f();
        return cVar;
    }

    public z(int i2, Executor executor) {
        this.a = new Object();
        this.f3097e = null;
        this.f3098f = 0;
        this.c = i2;
        this.f3096d = executor;
    }
}
