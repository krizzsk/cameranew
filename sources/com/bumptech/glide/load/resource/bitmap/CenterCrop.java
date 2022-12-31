package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class CenterCrop extends BitmapTransformation {
    public CenterCrop(Context context) {
        super(context);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap b(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, Bitmap bitmap, int i2, int i3) {
        Bitmap d2 = cVar.d(i2, i3, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        Bitmap a = k.a(d2, bitmap, i2, i3);
        if (d2 != null && d2 != a && !cVar.a(d2)) {
            d2.recycle();
        }
        return a;
    }

    @Override // com.bumptech.glide.load.f
    public String getId() {
        return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
    }

    public CenterCrop(com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        super(cVar);
    }
}
