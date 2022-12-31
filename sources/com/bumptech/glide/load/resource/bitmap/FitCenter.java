package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class FitCenter extends BitmapTransformation {
    public FitCenter(Context context) {
        super(context);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap b(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, Bitmap bitmap, int i2, int i3) {
        return k.b(bitmap, cVar, i2, i3);
    }

    @Override // com.bumptech.glide.load.f
    public String getId() {
        return "FitCenter.com.bumptech.glide.load.resource.bitmap";
    }

    public FitCenter(com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        super(cVar);
    }
}
