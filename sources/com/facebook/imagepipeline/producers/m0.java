package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: PostprocessorProducer.java */
/* loaded from: classes.dex */
public class m0 implements n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> {
    private final n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> a;
    private final com.facebook.imagepipeline.bitmaps.f b;
    private final Executor c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PostprocessorProducer.java */
    /* loaded from: classes.dex */
    public class b extends p<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>, com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> {
        private final q0 c;

        /* renamed from: d  reason: collision with root package name */
        private final o0 f2939d;

        /* renamed from: e  reason: collision with root package name */
        private final com.facebook.imagepipeline.request.a f2940e;
        @GuardedBy("PostprocessorConsumer.this")

        /* renamed from: f  reason: collision with root package name */
        private boolean f2941f;
        @GuardedBy("PostprocessorConsumer.this")
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private com.facebook.common.references.a<com.facebook.imagepipeline.image.c> f2942g;
        @GuardedBy("PostprocessorConsumer.this")

        /* renamed from: h  reason: collision with root package name */
        private int f2943h;
        @GuardedBy("PostprocessorConsumer.this")

        /* renamed from: i  reason: collision with root package name */
        private boolean f2944i;
        @GuardedBy("PostprocessorConsumer.this")

        /* renamed from: j  reason: collision with root package name */
        private boolean f2945j;

        /* compiled from: PostprocessorProducer.java */
        /* loaded from: classes.dex */
        class a extends e {
            a(m0 m0Var) {
            }

            @Override // com.facebook.imagepipeline.producers.p0
            public void b() {
                b.this.B();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PostprocessorProducer.java */
        /* renamed from: com.facebook.imagepipeline.producers.m0$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0103b implements Runnable {
            RunnableC0103b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.facebook.common.references.a aVar;
                int i2;
                synchronized (b.this) {
                    aVar = b.this.f2942g;
                    i2 = b.this.f2943h;
                    b.this.f2942g = null;
                    b.this.f2944i = false;
                }
                if (com.facebook.common.references.a.Q(aVar)) {
                    try {
                        b.this.y(aVar, i2);
                    } finally {
                        com.facebook.common.references.a.y(aVar);
                    }
                }
                b.this.w();
            }
        }

        public b(l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> lVar, q0 q0Var, com.facebook.imagepipeline.request.a aVar, o0 o0Var) {
            super(lVar);
            this.f2942g = null;
            this.f2943h = 0;
            this.f2944i = false;
            this.f2945j = false;
            this.c = q0Var;
            this.f2940e = aVar;
            this.f2939d = o0Var;
            o0Var.c(new a(m0.this));
        }

        private synchronized boolean A() {
            return this.f2941f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B() {
            if (x()) {
                o().a();
            }
        }

        private void C(Throwable th) {
            if (x()) {
                o().onFailure(th);
            }
        }

        private void D(com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar, int i2) {
            boolean d2 = com.facebook.imagepipeline.producers.b.d(i2);
            if ((d2 || A()) && !(d2 && x())) {
                return;
            }
            o().c(aVar, i2);
        }

        private com.facebook.common.references.a<com.facebook.imagepipeline.image.c> F(com.facebook.imagepipeline.image.c cVar) {
            com.facebook.imagepipeline.image.d dVar = (com.facebook.imagepipeline.image.d) cVar;
            com.facebook.common.references.a<Bitmap> c = this.f2940e.c(dVar.y(), m0.this.b);
            try {
                com.facebook.imagepipeline.image.d dVar2 = new com.facebook.imagepipeline.image.d(c, cVar.d(), dVar.R(), dVar.Q());
                dVar2.x(dVar.getExtras());
                return com.facebook.common.references.a.R(dVar2);
            } finally {
                com.facebook.common.references.a.y(c);
            }
        }

        private synchronized boolean G() {
            if (this.f2941f || !this.f2944i || this.f2945j || !com.facebook.common.references.a.Q(this.f2942g)) {
                return false;
            }
            this.f2945j = true;
            return true;
        }

        private boolean H(com.facebook.imagepipeline.image.c cVar) {
            return cVar instanceof com.facebook.imagepipeline.image.d;
        }

        private void I() {
            m0.this.c.execute(new RunnableC0103b());
        }

        private void J(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar, int i2) {
            synchronized (this) {
                if (this.f2941f) {
                    return;
                }
                com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar2 = this.f2942g;
                this.f2942g = com.facebook.common.references.a.w(aVar);
                this.f2943h = i2;
                this.f2944i = true;
                boolean G = G();
                com.facebook.common.references.a.y(aVar2);
                if (G) {
                    I();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w() {
            boolean G;
            synchronized (this) {
                this.f2945j = false;
                G = G();
            }
            if (G) {
                I();
            }
        }

        private boolean x() {
            synchronized (this) {
                if (this.f2941f) {
                    return false;
                }
                com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar = this.f2942g;
                this.f2942g = null;
                this.f2941f = true;
                com.facebook.common.references.a.y(aVar);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y(com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar, int i2) {
            com.facebook.common.internal.h.b(Boolean.valueOf(com.facebook.common.references.a.Q(aVar)));
            if (!H(aVar.A())) {
                D(aVar, i2);
                return;
            }
            this.c.d(this.f2939d, "PostprocessorProducer");
            try {
                try {
                    com.facebook.common.references.a<com.facebook.imagepipeline.image.c> F = F(aVar.A());
                    q0 q0Var = this.c;
                    o0 o0Var = this.f2939d;
                    q0Var.j(o0Var, "PostprocessorProducer", z(q0Var, o0Var, this.f2940e));
                    D(F, i2);
                    com.facebook.common.references.a.y(F);
                } catch (Exception e2) {
                    q0 q0Var2 = this.c;
                    o0 o0Var2 = this.f2939d;
                    q0Var2.k(o0Var2, "PostprocessorProducer", e2, z(q0Var2, o0Var2, this.f2940e));
                    C(e2);
                    com.facebook.common.references.a.y(null);
                }
            } catch (Throwable th) {
                com.facebook.common.references.a.y(null);
                throw th;
            }
        }

        @Nullable
        private Map<String, String> z(q0 q0Var, o0 o0Var, com.facebook.imagepipeline.request.a aVar) {
            if (q0Var.f(o0Var, "PostprocessorProducer")) {
                return ImmutableMap.of("Postprocessor", aVar.getName());
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: E */
        public void h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar, int i2) {
            if (!com.facebook.common.references.a.Q(aVar)) {
                if (com.facebook.imagepipeline.producers.b.d(i2)) {
                    D(null, i2);
                    return;
                }
                return;
            }
            J(aVar, i2);
        }

        @Override // com.facebook.imagepipeline.producers.p, com.facebook.imagepipeline.producers.b
        protected void f() {
            B();
        }

        @Override // com.facebook.imagepipeline.producers.p, com.facebook.imagepipeline.producers.b
        protected void g(Throwable th) {
            C(th);
        }
    }

    /* compiled from: PostprocessorProducer.java */
    /* loaded from: classes.dex */
    class c extends p<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>, com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> implements com.facebook.imagepipeline.request.c {
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        private boolean c;
        @GuardedBy("RepeatedPostprocessorConsumer.this")
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private com.facebook.common.references.a<com.facebook.imagepipeline.image.c> f2947d;

        /* compiled from: PostprocessorProducer.java */
        /* loaded from: classes.dex */
        class a extends e {
            a(m0 m0Var) {
            }

            @Override // com.facebook.imagepipeline.producers.p0
            public void b() {
                if (c.this.q()) {
                    c.this.o().a();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean q() {
            synchronized (this) {
                if (this.c) {
                    return false;
                }
                com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar = this.f2947d;
                this.f2947d = null;
                this.c = true;
                com.facebook.common.references.a.y(aVar);
                return true;
            }
        }

        private void s(com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar) {
            synchronized (this) {
                if (this.c) {
                    return;
                }
                com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar2 = this.f2947d;
                this.f2947d = com.facebook.common.references.a.w(aVar);
                com.facebook.common.references.a.y(aVar2);
            }
        }

        private void t() {
            synchronized (this) {
                if (this.c) {
                    return;
                }
                com.facebook.common.references.a<com.facebook.imagepipeline.image.c> w = com.facebook.common.references.a.w(this.f2947d);
                try {
                    o().c(w, 0);
                } finally {
                    com.facebook.common.references.a.y(w);
                }
            }
        }

        @Override // com.facebook.imagepipeline.producers.p, com.facebook.imagepipeline.producers.b
        protected void f() {
            if (q()) {
                o().a();
            }
        }

        @Override // com.facebook.imagepipeline.producers.p, com.facebook.imagepipeline.producers.b
        protected void g(Throwable th) {
            if (q()) {
                o().onFailure(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: r */
        public void h(com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar, int i2) {
            if (com.facebook.imagepipeline.producers.b.e(i2)) {
                return;
            }
            s(aVar);
            t();
        }

        private c(m0 m0Var, b bVar, com.facebook.imagepipeline.request.b bVar2, o0 o0Var) {
            super(bVar);
            this.c = false;
            this.f2947d = null;
            bVar2.b(this);
            o0Var.c(new a(m0Var));
        }
    }

    /* compiled from: PostprocessorProducer.java */
    /* loaded from: classes.dex */
    class d extends p<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>, com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: p */
        public void h(com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar, int i2) {
            if (com.facebook.imagepipeline.producers.b.e(i2)) {
                return;
            }
            o().c(aVar, i2);
        }

        private d(m0 m0Var, b bVar) {
            super(bVar);
        }
    }

    public m0(n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var, com.facebook.imagepipeline.bitmaps.f fVar, Executor executor) {
        com.facebook.common.internal.h.g(n0Var);
        this.a = n0Var;
        this.b = fVar;
        com.facebook.common.internal.h.g(executor);
        this.c = executor;
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> lVar, o0 o0Var) {
        l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> dVar;
        q0 h2 = o0Var.h();
        com.facebook.imagepipeline.request.a i2 = o0Var.j().i();
        b bVar = new b(lVar, h2, i2, o0Var);
        if (i2 instanceof com.facebook.imagepipeline.request.b) {
            dVar = new c(bVar, (com.facebook.imagepipeline.request.b) i2, o0Var);
        } else {
            dVar = new d(bVar);
        }
        this.a.b(dVar, o0Var);
    }
}
