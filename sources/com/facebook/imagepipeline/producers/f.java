package com.facebook.imagepipeline.producers;
/* compiled from: BitmapMemoryCacheGetProducer.java */
/* loaded from: classes.dex */
public class f extends h {
    public f(com.facebook.imagepipeline.cache.r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> rVar, com.facebook.imagepipeline.cache.f fVar, n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var) {
        super(rVar, fVar, n0Var);
    }

    @Override // com.facebook.imagepipeline.producers.h
    protected String d() {
        return "pipe_ui";
    }

    @Override // com.facebook.imagepipeline.producers.h
    protected String e() {
        return "BitmapMemoryCacheGetProducer";
    }

    @Override // com.facebook.imagepipeline.producers.h
    protected l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> g(l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> lVar, com.facebook.cache.common.b bVar, boolean z) {
        return lVar;
    }
}
