package us.pinguo.foundation.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import us.pinguo.advconfigdata.AdvConfigManager;
/* compiled from: FrescoUtil.kt */
/* loaded from: classes4.dex */
public final class n {
    public static final n a = new n();

    /* compiled from: FrescoUtil.kt */
    /* loaded from: classes4.dex */
    public static final class a extends com.facebook.imagepipeline.a.b {
        final /* synthetic */ kotlin.jvm.b.l<Bitmap, kotlin.u> a;
        final /* synthetic */ com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> b;

        /* JADX WARN: Multi-variable type inference failed */
        a(kotlin.jvm.b.l<? super Bitmap, kotlin.u> lVar, com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> bVar) {
            this.a = lVar;
            this.b = bVar;
        }

        @Override // com.facebook.datasource.a
        protected void e(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> dataSource) {
            kotlin.jvm.internal.s.h(dataSource, "dataSource");
            this.a.invoke(null);
            dataSource.close();
        }

        @Override // com.facebook.imagepipeline.a.b
        protected void g(Bitmap bitmap) {
            this.a.invoke(bitmap);
            this.b.close();
        }
    }

    private n() {
    }

    public final void a(String url, com.facebook.imagepipeline.common.d dVar, kotlin.jvm.b.l<? super Bitmap, kotlin.u> onResult) {
        kotlin.jvm.internal.s.h(url, "url");
        kotlin.jvm.internal.s.h(onResult, "onResult");
        Uri parse = Uri.parse(url);
        Context a2 = us.pinguo.util.v.a();
        ImageRequestBuilder s = ImageRequestBuilder.s(parse);
        if (dVar != null) {
            s.D(dVar);
        }
        com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> b = com.facebook.drawee.backends.pipeline.c.a().b(s.a(), a2);
        if (b == null) {
            return;
        }
        b.d(new a(onResult, b), UiThreadImmediateExecutorService.getInstance());
    }

    public final File b(Uri uri) {
        com.facebook.binaryresource.a b;
        kotlin.jvm.internal.s.h(uri, "uri");
        com.facebook.cache.common.b d2 = DefaultCacheKeyFactory.getInstance().d(ImageRequest.a(uri), us.pinguo.foundation.e.b());
        if (ImagePipelineFactory.getInstance().m().e(d2)) {
            com.facebook.binaryresource.a b2 = ImagePipelineFactory.getInstance().m().b(d2);
            if (b2 == null) {
                return null;
            }
            return ((com.facebook.binaryresource.b) b2).d();
        } else if (!ImagePipelineFactory.getInstance().l().i(d2) || (b = ImagePipelineFactory.getInstance().s().b(d2)) == null) {
            return null;
        } else {
            return ((com.facebook.binaryresource.b) b).d();
        }
    }

    public final boolean c(Uri uri) {
        kotlin.jvm.internal.s.h(uri, "uri");
        com.facebook.cache.common.b d2 = DefaultCacheKeyFactory.getInstance().d(ImageRequest.a(uri), us.pinguo.foundation.e.b());
        return ImagePipelineFactory.getInstance().m().e(d2) || ImagePipelineFactory.getInstance().s().e(d2);
    }

    public final void d(Uri uri) {
        kotlin.jvm.internal.s.h(uri, "uri");
        com.facebook.imagepipeline.core.h a2 = com.facebook.drawee.backends.pipeline.c.a();
        kotlin.jvm.internal.s.g(a2, "getImagePipeline()");
        a2.k(ImageRequest.a(uri), AdvConfigManager.getInstance().getContext());
    }
}
