package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.bitmaps.f;
import javax.annotation.Nullable;
/* compiled from: Postprocessor.java */
/* loaded from: classes.dex */
public interface a {
    @Nullable
    com.facebook.cache.common.b a();

    com.facebook.common.references.a<Bitmap> c(Bitmap bitmap, f fVar);

    String getName();
}
