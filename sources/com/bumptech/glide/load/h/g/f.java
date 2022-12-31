package com.bumptech.glide.load.h.g;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.i;
/* compiled from: GifBitmapWrapperTransformation.java */
/* loaded from: classes.dex */
public class f implements com.bumptech.glide.load.f<a> {
    private final com.bumptech.glide.load.f<Bitmap> a;
    private final com.bumptech.glide.load.f<com.bumptech.glide.load.resource.gif.b> b;

    public f(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, com.bumptech.glide.load.f<Bitmap> fVar) {
        this(fVar, new com.bumptech.glide.load.resource.gif.e(fVar, cVar));
    }

    @Override // com.bumptech.glide.load.f
    public i<a> a(i<a> iVar, int i2, int i3) {
        com.bumptech.glide.load.f<com.bumptech.glide.load.resource.gif.b> fVar;
        com.bumptech.glide.load.f<Bitmap> fVar2;
        i<Bitmap> a = iVar.get().a();
        i<com.bumptech.glide.load.resource.gif.b> b = iVar.get().b();
        if (a != null && (fVar2 = this.a) != null) {
            i<Bitmap> a2 = fVar2.a(a, i2, i3);
            return !a.equals(a2) ? new b(new a(a2, iVar.get().b())) : iVar;
        } else if (b == null || (fVar = this.b) == null) {
            return iVar;
        } else {
            i<com.bumptech.glide.load.resource.gif.b> a3 = fVar.a(b, i2, i3);
            return !b.equals(a3) ? new b(new a(iVar.get().a(), a3)) : iVar;
        }
    }

    @Override // com.bumptech.glide.load.f
    public String getId() {
        return this.a.getId();
    }

    f(com.bumptech.glide.load.f<Bitmap> fVar, com.bumptech.glide.load.f<com.bumptech.glide.load.resource.gif.b> fVar2) {
        this.a = fVar;
        this.b = fVar2;
    }
}
