package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class DefaultCacheKeyFactory implements f {
    @Nullable
    private static DefaultCacheKeyFactory a;

    protected DefaultCacheKeyFactory() {
    }

    public static synchronized DefaultCacheKeyFactory getInstance() {
        DefaultCacheKeyFactory defaultCacheKeyFactory;
        synchronized (DefaultCacheKeyFactory.class) {
            if (a == null) {
                a = new DefaultCacheKeyFactory();
            }
            defaultCacheKeyFactory = a;
        }
        return defaultCacheKeyFactory;
    }

    @Override // com.facebook.imagepipeline.cache.f
    public com.facebook.cache.common.b a(ImageRequest imageRequest, @Nullable Object obj) {
        Uri s = imageRequest.s();
        e(s);
        return new b(s.toString(), imageRequest.o(), imageRequest.q(), imageRequest.f(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.cache.f
    public com.facebook.cache.common.b b(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        e(uri);
        return new com.facebook.cache.common.e(uri.toString());
    }

    @Override // com.facebook.imagepipeline.cache.f
    public com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj) {
        com.facebook.cache.common.b bVar;
        String str;
        com.facebook.imagepipeline.request.a i2 = imageRequest.i();
        if (i2 != null) {
            com.facebook.cache.common.b a2 = i2.a();
            str = i2.getClass().getName();
            bVar = a2;
        } else {
            bVar = null;
            str = null;
        }
        Uri s = imageRequest.s();
        e(s);
        return new b(s.toString(), imageRequest.o(), imageRequest.q(), imageRequest.f(), bVar, str, obj);
    }

    @Override // com.facebook.imagepipeline.cache.f
    public com.facebook.cache.common.b d(ImageRequest imageRequest, @Nullable Object obj) {
        return b(imageRequest, imageRequest.s(), obj);
    }

    protected Uri e(Uri uri) {
        return uri;
    }
}
