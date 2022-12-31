package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
/* compiled from: GifDrawableTransformation.java */
/* loaded from: classes.dex */
public class e implements com.bumptech.glide.load.f<b> {
    private final com.bumptech.glide.load.f<Bitmap> a;
    private final com.bumptech.glide.load.engine.bitmap_recycle.c b;

    public e(com.bumptech.glide.load.f<Bitmap> fVar, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this.a = fVar;
        this.b = cVar;
    }

    @Override // com.bumptech.glide.load.f
    public com.bumptech.glide.load.engine.i<b> a(com.bumptech.glide.load.engine.i<b> iVar, int i2, int i3) {
        b bVar = iVar.get();
        Bitmap e2 = iVar.get().e();
        Bitmap bitmap = this.a.a(new com.bumptech.glide.load.resource.bitmap.c(e2, this.b), i2, i3).get();
        return !bitmap.equals(e2) ? new d(new b(bVar, bitmap, this.a)) : iVar;
    }

    @Override // com.bumptech.glide.load.f
    public String getId() {
        return this.a.getId();
    }
}
