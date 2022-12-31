package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* compiled from: EncodedCacheKeyMultiplexProducer.java */
/* loaded from: classes.dex */
public class s extends h0<Pair<com.facebook.cache.common.b, ImageRequest.RequestLevel>, com.facebook.imagepipeline.image.e> {

    /* renamed from: f  reason: collision with root package name */
    private final com.facebook.imagepipeline.cache.f f2971f;

    public s(com.facebook.imagepipeline.cache.f fVar, boolean z, n0 n0Var) {
        super(n0Var, "EncodedCacheKeyMultiplexProducer", "multiplex_enc_cnt", z);
        this.f2971f = fVar;
    }

    @Override // com.facebook.imagepipeline.producers.h0
    @Nullable
    /* renamed from: l */
    public com.facebook.imagepipeline.image.e g(@Nullable com.facebook.imagepipeline.image.e eVar) {
        return com.facebook.imagepipeline.image.e.e(eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.h0
    /* renamed from: m */
    public Pair<com.facebook.cache.common.b, ImageRequest.RequestLevel> j(o0 o0Var) {
        return Pair.create(this.f2971f.d(o0Var.j(), o0Var.a()), o0Var.o());
    }
}
