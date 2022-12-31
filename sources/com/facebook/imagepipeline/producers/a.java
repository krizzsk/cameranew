package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
/* compiled from: AddImageTransformMetaDataProducer.java */
/* loaded from: classes.dex */
public class a implements n0<com.facebook.imagepipeline.image.e> {
    private final n0<com.facebook.imagepipeline.image.e> a;

    /* compiled from: AddImageTransformMetaDataProducer.java */
    /* loaded from: classes.dex */
    private static class b extends p<com.facebook.imagepipeline.image.e, com.facebook.imagepipeline.image.e> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: p */
        public void h(@Nullable com.facebook.imagepipeline.image.e eVar, int i2) {
            if (eVar == null) {
                o().c(null, i2);
                return;
            }
            if (!com.facebook.imagepipeline.image.e.X(eVar)) {
                eVar.a0();
            }
            o().c(eVar, i2);
        }

        private b(l<com.facebook.imagepipeline.image.e> lVar) {
            super(lVar);
        }
    }

    public a(n0<com.facebook.imagepipeline.image.e> n0Var) {
        this.a = n0Var;
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        this.a.b(new b(lVar), o0Var);
    }
}
