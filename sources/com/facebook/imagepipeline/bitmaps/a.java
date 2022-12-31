package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.facebook.common.internal.h;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: ArtBitmapFactory.java */
@ThreadSafe
@TargetApi(21)
/* loaded from: classes.dex */
public class a extends f {
    private final com.facebook.imagepipeline.memory.d a;
    private final com.facebook.imagepipeline.core.a b;

    public a(com.facebook.imagepipeline.memory.d dVar, com.facebook.imagepipeline.core.a aVar) {
        this.a = dVar;
        this.b = aVar;
    }

    @Override // com.facebook.imagepipeline.bitmaps.f
    public com.facebook.common.references.a<Bitmap> d(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmap = this.a.get(com.facebook.imageutils.a.d(i2, i3, config));
        h.b(Boolean.valueOf(bitmap.getAllocationByteCount() >= (i2 * i3) * com.facebook.imageutils.a.c(config)));
        bitmap.reconfigure(i2, i3, config);
        return this.b.c(bitmap, this.a);
    }
}
