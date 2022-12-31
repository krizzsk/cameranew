package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.l;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.imagepipeline.core.h;
import com.facebook.imagepipeline.image.g;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Set;
import javax.annotation.Nullable;
/* compiled from: PipelineDraweeControllerBuilder.java */
/* loaded from: classes.dex */
public class e extends AbstractDraweeControllerBuilder<e, ImageRequest, com.facebook.common.references.a<com.facebook.imagepipeline.image.c>, g> {
    private final h t;
    private final f u;
    @Nullable
    private ImmutableList<com.facebook.imagepipeline.c.a> v;
    @Nullable
    private com.facebook.drawee.backends.pipeline.h.b w;
    @Nullable
    private com.facebook.drawee.backends.pipeline.h.f x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PipelineDraweeControllerBuilder.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AbstractDraweeControllerBuilder.CacheLevel.values().length];
            a = iArr;
            try {
                iArr[AbstractDraweeControllerBuilder.CacheLevel.FULL_FETCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AbstractDraweeControllerBuilder.CacheLevel.DISK_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AbstractDraweeControllerBuilder.CacheLevel.BITMAP_MEMORY_CACHE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public e(Context context, f fVar, h hVar, Set<com.facebook.drawee.controller.c> set, Set<com.facebook.fresco.ui.common.b> set2) {
        super(context, set, set2);
        this.t = hVar;
        this.u = fVar;
    }

    public static ImageRequest.RequestLevel E(AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        int i2 = a.a[cacheLevel.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE;
                }
                throw new RuntimeException("Cache level" + cacheLevel + "is not supported. ");
            }
            return ImageRequest.RequestLevel.DISK_CACHE;
        }
        return ImageRequest.RequestLevel.FULL_FETCH;
    }

    @Nullable
    private com.facebook.cache.common.b F() {
        ImageRequest n = n();
        com.facebook.imagepipeline.cache.f h2 = this.t.h();
        if (h2 == null || n == null) {
            return null;
        }
        if (n.i() != null) {
            return h2.c(n, f());
        }
        return h2.a(n, f());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: G */
    public com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> i(com.facebook.drawee.b.a aVar, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.CacheLevel cacheLevel) {
        return this.t.e(imageRequest, obj, E(cacheLevel), H(aVar), str);
    }

    @Nullable
    protected com.facebook.imagepipeline.e.e H(com.facebook.drawee.b.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).m0();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: I */
    public d w() {
        d c;
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("PipelineDraweeControllerBuilder#obtainController");
        }
        try {
            com.facebook.drawee.b.a p = p();
            String e2 = AbstractDraweeControllerBuilder.e();
            if (p instanceof d) {
                c = (d) p;
            } else {
                c = this.u.c();
            }
            c.o0(x(c, e2), e2, F(), f(), this.v, this.w);
            c.p0(this.x, this, l.a);
            return c;
        } finally {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
    }

    public e J(@Nullable com.facebook.drawee.backends.pipeline.h.f fVar) {
        this.x = fVar;
        r();
        return this;
    }

    @Override // com.facebook.drawee.b.d
    /* renamed from: K */
    public e a(@Nullable Uri uri) {
        if (uri == null) {
            super.B(null);
            return this;
        }
        ImageRequestBuilder s = ImageRequestBuilder.s(uri);
        s.E(com.facebook.imagepipeline.common.e.b());
        super.B(s.a());
        return this;
    }

    public e L(@Nullable String str) {
        if (str != null && !str.isEmpty()) {
            return a(Uri.parse(str));
        }
        super.B(ImageRequest.b(str));
        return this;
    }
}
