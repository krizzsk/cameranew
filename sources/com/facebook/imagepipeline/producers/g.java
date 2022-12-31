package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* compiled from: BitmapMemoryCacheKeyMultiplexProducer.java */
/* loaded from: classes.dex */
public class g extends h0<Pair<com.facebook.cache.common.b, ImageRequest.RequestLevel>, com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> {

    /* renamed from: f  reason: collision with root package name */
    private final com.facebook.imagepipeline.cache.f f2901f;

    public g(com.facebook.imagepipeline.cache.f fVar, n0 n0Var) {
        super(n0Var, "BitmapMemoryCacheKeyMultiplexProducer", "multiplex_bmp_cnt");
        this.f2901f = fVar;
    }

    @Override // com.facebook.imagepipeline.producers.h0
    @Nullable
    /* renamed from: l */
    public com.facebook.common.references.a<com.facebook.imagepipeline.image.c> g(@Nullable com.facebook.common.references.a<com.facebook.imagepipeline.image.c> aVar) {
        return com.facebook.common.references.a.w(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.h0
    /* renamed from: m */
    public Pair<com.facebook.cache.common.b, ImageRequest.RequestLevel> j(o0 o0Var) {
        return Pair.create(this.f2901f.a(o0Var.j(), o0Var.a()), o0Var.o());
    }
}
