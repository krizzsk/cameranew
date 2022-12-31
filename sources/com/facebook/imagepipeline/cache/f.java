package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* compiled from: CacheKeyFactory.java */
/* loaded from: classes.dex */
public interface f {
    com.facebook.cache.common.b a(ImageRequest imageRequest, @Nullable Object obj);

    com.facebook.cache.common.b b(ImageRequest imageRequest, Uri uri, @Nullable Object obj);

    com.facebook.cache.common.b c(ImageRequest imageRequest, @Nullable Object obj);

    com.facebook.cache.common.b d(ImageRequest imageRequest, @Nullable Object obj);
}
