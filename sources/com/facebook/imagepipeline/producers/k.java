package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* compiled from: BranchOnSeparateImagesProducer.java */
/* loaded from: classes.dex */
public class k implements n0<com.facebook.imagepipeline.image.e> {
    private final n0<com.facebook.imagepipeline.image.e> a;
    private final n0<com.facebook.imagepipeline.image.e> b;

    /* compiled from: BranchOnSeparateImagesProducer.java */
    /* loaded from: classes.dex */
    private class b extends p<com.facebook.imagepipeline.image.e, com.facebook.imagepipeline.image.e> {
        private o0 c;

        @Override // com.facebook.imagepipeline.producers.p, com.facebook.imagepipeline.producers.b
        protected void g(Throwable th) {
            k.this.b.b(o(), this.c);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: p */
        public void h(@Nullable com.facebook.imagepipeline.image.e eVar, int i2) {
            ImageRequest j2 = this.c.j();
            boolean d2 = com.facebook.imagepipeline.producers.b.d(i2);
            boolean c = d1.c(eVar, j2.o());
            if (eVar != null && (c || j2.g())) {
                if (d2 && c) {
                    o().c(eVar, i2);
                } else {
                    o().c(eVar, com.facebook.imagepipeline.producers.b.n(i2, 1));
                }
            }
            if (!d2 || c) {
                return;
            }
            com.facebook.imagepipeline.image.e.h(eVar);
            k.this.b.b(o(), this.c);
        }

        private b(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
            super(lVar);
            this.c = o0Var;
        }
    }

    public k(n0<com.facebook.imagepipeline.image.e> n0Var, n0<com.facebook.imagepipeline.image.e> n0Var2) {
        this.a = n0Var;
        this.b = n0Var2;
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        this.a.b(new b(lVar, o0Var), o0Var);
    }
}
