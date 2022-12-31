package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GifFrameResourceDecoder.java */
/* loaded from: classes.dex */
public class h implements com.bumptech.glide.load.d<com.bumptech.glide.h.a, Bitmap> {
    private final com.bumptech.glide.load.engine.bitmap_recycle.c a;

    public h(com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this.a = cVar;
    }

    @Override // com.bumptech.glide.load.d
    /* renamed from: b */
    public com.bumptech.glide.load.engine.i<Bitmap> a(com.bumptech.glide.h.a aVar, int i2, int i3) {
        return com.bumptech.glide.load.resource.bitmap.c.b(aVar.j(), this.a);
    }

    @Override // com.bumptech.glide.load.d
    public String getId() {
        return "GifFrameResourceDecoder.com.bumptech.glide.load.resource.gif";
    }
}
