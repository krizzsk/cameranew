package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import javax.annotation.Nullable;
/* compiled from: PlatformDecoder.java */
/* loaded from: classes.dex */
public interface d {
    com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.image.e eVar, Bitmap.Config config, @Nullable Rect rect, int i2, @Nullable ColorSpace colorSpace);

    com.facebook.common.references.a<Bitmap> b(com.facebook.imagepipeline.image.e eVar, Bitmap.Config config, @Nullable Rect rect, @Nullable ColorSpace colorSpace);

    com.facebook.common.references.a<Bitmap> c(com.facebook.imagepipeline.image.e eVar, Bitmap.Config config, @Nullable Rect rect, int i2);
}
