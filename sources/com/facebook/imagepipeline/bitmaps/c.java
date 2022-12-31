package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
/* compiled from: GingerbreadBitmapFactory.java */
/* loaded from: classes.dex */
public class c extends f {
    @Override // com.facebook.imagepipeline.bitmaps.f
    public com.facebook.common.references.a<Bitmap> d(int i2, int i3, Bitmap.Config config) {
        return com.facebook.common.references.a.T(Bitmap.createBitmap(i2, i3, config), SimpleBitmapReleaser.getInstance());
    }
}
