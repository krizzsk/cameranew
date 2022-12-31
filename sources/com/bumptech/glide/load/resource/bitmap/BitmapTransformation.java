package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
/* loaded from: classes.dex */
public abstract class BitmapTransformation implements com.bumptech.glide.load.f<Bitmap> {
    private com.bumptech.glide.load.engine.bitmap_recycle.c a;

    public BitmapTransformation(Context context) {
        this(com.bumptech.glide.e.i(context).j());
    }

    @Override // com.bumptech.glide.load.f
    public final com.bumptech.glide.load.engine.i<Bitmap> a(com.bumptech.glide.load.engine.i<Bitmap> iVar, int i2, int i3) {
        if (com.bumptech.glide.l.h.k(i2, i3)) {
            Bitmap bitmap = iVar.get();
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getWidth();
            }
            if (i3 == Integer.MIN_VALUE) {
                i3 = bitmap.getHeight();
            }
            Bitmap b = b(this.a, bitmap, i2, i3);
            return bitmap.equals(b) ? iVar : c.b(b, this.a);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i2 + " or height: " + i3 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    protected abstract Bitmap b(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, Bitmap bitmap, int i2, int i3);

    public BitmapTransformation(com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this.a = cVar;
    }
}
