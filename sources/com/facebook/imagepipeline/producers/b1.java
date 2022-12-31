package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
/* compiled from: ThumbnailBranchProducer.java */
/* loaded from: classes.dex */
public class b1 implements n0<com.facebook.imagepipeline.image.e> {
    private final c1<com.facebook.imagepipeline.image.e>[] a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ThumbnailBranchProducer.java */
    /* loaded from: classes.dex */
    public class a extends p<com.facebook.imagepipeline.image.e, com.facebook.imagepipeline.image.e> {
        private final o0 c;

        /* renamed from: d  reason: collision with root package name */
        private final int f2876d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private final com.facebook.imagepipeline.common.d f2877e;

        public a(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var, int i2) {
            super(lVar);
            this.c = o0Var;
            this.f2876d = i2;
            this.f2877e = o0Var.j().o();
        }

        @Override // com.facebook.imagepipeline.producers.p, com.facebook.imagepipeline.producers.b
        protected void g(Throwable th) {
            if (b1.this.e(this.f2876d + 1, o(), this.c)) {
                return;
            }
            o().onFailure(th);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: p */
        public void h(@Nullable com.facebook.imagepipeline.image.e eVar, int i2) {
            if (eVar != null && (b.e(i2) || d1.c(eVar, this.f2877e))) {
                o().c(eVar, i2);
            } else if (b.d(i2)) {
                com.facebook.imagepipeline.image.e.h(eVar);
                if (b1.this.e(this.f2876d + 1, o(), this.c)) {
                    return;
                }
                o().c(null, 1);
            }
        }
    }

    public b1(c1<com.facebook.imagepipeline.image.e>... c1VarArr) {
        com.facebook.common.internal.h.g(c1VarArr);
        c1<com.facebook.imagepipeline.image.e>[] c1VarArr2 = c1VarArr;
        this.a = c1VarArr2;
        com.facebook.common.internal.h.e(0, c1VarArr2.length);
    }

    private int d(int i2, @Nullable com.facebook.imagepipeline.common.d dVar) {
        while (true) {
            c1<com.facebook.imagepipeline.image.e>[] c1VarArr = this.a;
            if (i2 >= c1VarArr.length) {
                return -1;
            }
            if (c1VarArr[i2].a(dVar)) {
                return i2;
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(int i2, l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        int d2 = d(i2, o0Var.j().o());
        if (d2 == -1) {
            return false;
        }
        this.a[d2].b(new a(lVar, o0Var, d2), o0Var);
        return true;
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        if (o0Var.j().o() == null) {
            lVar.c(null, 1);
        } else if (e(0, lVar, o0Var)) {
        } else {
            lVar.c(null, 1);
        }
    }
}
