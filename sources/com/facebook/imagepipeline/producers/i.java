package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
/* compiled from: BitmapPrepareProducer.java */
/* loaded from: classes.dex */
public class i implements n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> {
    private final n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2915d;

    /* compiled from: BitmapPrepareProducer.java */
    /* loaded from: classes.dex */
    private static class a extends p<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>, com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> {
        private final int c;

        /* renamed from: d  reason: collision with root package name */
        private final int f2916d;

        a(l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> lVar, int i2, int i3) {
            super(lVar);
            this.c = i2;
            this.f2916d = i3;
        }

        private void p(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar) {
            com.facebook.imagepipeline.image.c A;
            Bitmap y;
            int rowBytes;
            if (aVar == null || !aVar.O() || (A = aVar.A()) == null || A.isClosed() || !(A instanceof com.facebook.imagepipeline.image.d) || (y = ((com.facebook.imagepipeline.image.d) A).y()) == null || (rowBytes = y.getRowBytes() * y.getHeight()) < this.c || rowBytes > this.f2916d) {
                return;
            }
            y.prepareToDraw();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: q */
        public void h(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar, int i2) {
            p(aVar);
            o().c(aVar, i2);
        }
    }

    public i(n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var, int i2, int i3, boolean z) {
        com.facebook.common.internal.h.b(Boolean.valueOf(i2 <= i3));
        com.facebook.common.internal.h.g(n0Var);
        this.a = n0Var;
        this.b = i2;
        this.c = i3;
        this.f2915d = z;
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> lVar, o0 o0Var) {
        if (o0Var.m() && !this.f2915d) {
            this.a.b(lVar, o0Var);
        } else {
            this.a.b(new a(lVar, this.b, this.c), o0Var);
        }
    }
}
