package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
/* compiled from: ThreadHandoffProducer.java */
/* loaded from: classes.dex */
public class x0<T> implements n0<T> {
    private final n0<T> a;
    private final y0 b;

    /* compiled from: ThreadHandoffProducer.java */
    /* loaded from: classes.dex */
    class a extends v0<T> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ q0 f2999f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ o0 f3000g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ l f3001h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(l lVar, q0 q0Var, o0 o0Var, String str, q0 q0Var2, o0 o0Var2, l lVar2) {
            super(lVar, q0Var, o0Var, str);
            this.f2999f = q0Var2;
            this.f3000g = o0Var2;
            this.f3001h = lVar2;
        }

        @Override // com.facebook.common.executors.f
        protected void b(@Nullable T t) {
        }

        @Override // com.facebook.common.executors.f
        @Nullable
        protected T c() throws Exception {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.v0, com.facebook.common.executors.f
        public void f(@Nullable T t) {
            this.f2999f.j(this.f3000g, "BackgroundThreadHandoffProducer", null);
            x0.this.a.b(this.f3001h, this.f3000g);
        }
    }

    /* compiled from: ThreadHandoffProducer.java */
    /* loaded from: classes.dex */
    class b extends e {
        final /* synthetic */ v0 a;

        b(v0 v0Var) {
            this.a = v0Var;
        }

        @Override // com.facebook.imagepipeline.producers.p0
        public void b() {
            this.a.a();
            x0.this.b.a(this.a);
        }
    }

    public x0(n0<T> n0Var, y0 y0Var) {
        com.facebook.common.internal.h.g(n0Var);
        this.a = n0Var;
        this.b = y0Var;
    }

    @Nullable
    private static String e(o0 o0Var) {
        if (com.facebook.imagepipeline.d.a.b()) {
            return "ThreadHandoffProducer_produceResults_" + o0Var.getId();
        }
        return null;
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<T> lVar, o0 o0Var) {
        try {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("ThreadHandoffProducer#produceResults");
            }
            q0 h2 = o0Var.h();
            a aVar = new a(lVar, h2, o0Var, "BackgroundThreadHandoffProducer", h2, o0Var, lVar);
            o0Var.c(new b(aVar));
            this.b.b(com.facebook.imagepipeline.d.a.a(aVar, e(o0Var)));
        } finally {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
    }
}
