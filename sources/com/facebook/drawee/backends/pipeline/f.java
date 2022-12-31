package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.k;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.cache.r;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* compiled from: PipelineDraweeControllerFactory.java */
/* loaded from: classes.dex */
public class f {
    private Resources a;
    private DeferredReleaser b;
    private com.facebook.imagepipeline.c.a c;

    /* renamed from: d  reason: collision with root package name */
    private Executor f2454d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> f2455e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private ImmutableList<com.facebook.imagepipeline.c.a> f2456f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private k<Boolean> f2457g;

    public void a(Resources resources, DeferredReleaser deferredReleaser, com.facebook.imagepipeline.c.a aVar, Executor executor, r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> rVar, @Nullable ImmutableList<com.facebook.imagepipeline.c.a> immutableList, @Nullable k<Boolean> kVar) {
        this.a = resources;
        this.b = deferredReleaser;
        this.c = aVar;
        this.f2454d = executor;
        this.f2455e = rVar;
        this.f2456f = immutableList;
        this.f2457g = kVar;
    }

    protected d b(Resources resources, DeferredReleaser deferredReleaser, com.facebook.imagepipeline.c.a aVar, Executor executor, @Nullable r<com.facebook.cache.common.b, com.facebook.imagepipeline.image.c> rVar, @Nullable ImmutableList<com.facebook.imagepipeline.c.a> immutableList) {
        return new d(resources, deferredReleaser, aVar, executor, rVar, immutableList);
    }

    public d c() {
        d b = b(this.a, this.b, this.c, this.f2454d, this.f2455e, this.f2456f);
        k<Boolean> kVar = this.f2457g;
        if (kVar != null) {
            b.y0(kVar.get().booleanValue());
        }
        return b;
    }
}
