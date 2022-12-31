package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import com.facebook.imageformat.ImageFormatChecker;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* compiled from: WebpTranscodeProducer.java */
/* loaded from: classes.dex */
public class e1 implements n0<com.facebook.imagepipeline.image.e> {
    private final Executor a;
    private final com.facebook.common.memory.f b;
    private final n0<com.facebook.imagepipeline.image.e> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WebpTranscodeProducer.java */
    /* loaded from: classes.dex */
    public class a extends v0<com.facebook.imagepipeline.image.e> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ com.facebook.imagepipeline.image.e f2897f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(l lVar, q0 q0Var, o0 o0Var, String str, com.facebook.imagepipeline.image.e eVar) {
            super(lVar, q0Var, o0Var, str);
            this.f2897f = eVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.v0, com.facebook.common.executors.f
        public void d() {
            com.facebook.imagepipeline.image.e.h(this.f2897f);
            super.d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.v0, com.facebook.common.executors.f
        public void e(Exception exc) {
            com.facebook.imagepipeline.image.e.h(this.f2897f);
            super.e(exc);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.common.executors.f
        /* renamed from: j */
        public void b(com.facebook.imagepipeline.image.e eVar) {
            com.facebook.imagepipeline.image.e.h(eVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.common.executors.f
        /* renamed from: k */
        public com.facebook.imagepipeline.image.e c() throws Exception {
            com.facebook.common.memory.h c = e1.this.b.c();
            try {
                e1.g(this.f2897f, c);
                com.facebook.common.references.a R = com.facebook.common.references.a.R(c.d());
                com.facebook.imagepipeline.image.e eVar = new com.facebook.imagepipeline.image.e(R);
                eVar.i(this.f2897f);
                com.facebook.common.references.a.y(R);
                return eVar;
            } finally {
                c.close();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.v0, com.facebook.common.executors.f
        /* renamed from: l */
        public void f(com.facebook.imagepipeline.image.e eVar) {
            com.facebook.imagepipeline.image.e.h(this.f2897f);
            super.f(eVar);
        }
    }

    /* compiled from: WebpTranscodeProducer.java */
    /* loaded from: classes.dex */
    private class b extends p<com.facebook.imagepipeline.image.e, com.facebook.imagepipeline.image.e> {
        private final o0 c;

        /* renamed from: d  reason: collision with root package name */
        private TriState f2899d;

        public b(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
            super(lVar);
            this.c = o0Var;
            this.f2899d = TriState.UNSET;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: p */
        public void h(@Nullable com.facebook.imagepipeline.image.e eVar, int i2) {
            if (this.f2899d == TriState.UNSET && eVar != null) {
                this.f2899d = e1.h(eVar);
            }
            if (this.f2899d == TriState.NO) {
                o().c(eVar, i2);
            } else if (com.facebook.imagepipeline.producers.b.d(i2)) {
                if (this.f2899d == TriState.YES && eVar != null) {
                    e1.this.i(eVar, o(), this.c);
                } else {
                    o().c(eVar, i2);
                }
            }
        }
    }

    public e1(Executor executor, com.facebook.common.memory.f fVar, n0<com.facebook.imagepipeline.image.e> n0Var) {
        com.facebook.common.internal.h.g(executor);
        this.a = executor;
        com.facebook.common.internal.h.g(fVar);
        this.b = fVar;
        com.facebook.common.internal.h.g(n0Var);
        this.c = n0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(com.facebook.imagepipeline.image.e eVar, com.facebook.common.memory.h hVar) throws Exception {
        InputStream N = eVar.N();
        com.facebook.common.internal.h.g(N);
        InputStream inputStream = N;
        com.facebook.imageformat.c c = ImageFormatChecker.c(inputStream);
        if (c != com.facebook.imageformat.b.f2653f && c != com.facebook.imageformat.b.f2655h) {
            if (c != com.facebook.imageformat.b.f2654g && c != com.facebook.imageformat.b.f2656i) {
                throw new IllegalArgumentException("Wrong image format");
            }
            com.facebook.imagepipeline.nativecode.g.a().a(inputStream, hVar);
            eVar.h0(com.facebook.imageformat.b.b);
            return;
        }
        com.facebook.imagepipeline.nativecode.g.a().c(inputStream, hVar, 80);
        eVar.h0(com.facebook.imageformat.b.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState h(com.facebook.imagepipeline.image.e eVar) {
        com.facebook.common.internal.h.g(eVar);
        InputStream N = eVar.N();
        com.facebook.common.internal.h.g(N);
        com.facebook.imageformat.c c = ImageFormatChecker.c(N);
        if (com.facebook.imageformat.b.a(c)) {
            com.facebook.imagepipeline.nativecode.f a2 = com.facebook.imagepipeline.nativecode.g.a();
            if (a2 == null) {
                return TriState.NO;
            }
            return TriState.valueOf(!a2.b(c));
        } else if (c == com.facebook.imageformat.c.b) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.facebook.imagepipeline.image.e eVar, l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        com.facebook.common.internal.h.g(eVar);
        this.a.execute(new a(lVar, o0Var.h(), o0Var, "WebpTranscodeProducer", com.facebook.imagepipeline.image.e.e(eVar)));
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        this.c.b(new b(lVar, o0Var), o0Var);
    }
}
