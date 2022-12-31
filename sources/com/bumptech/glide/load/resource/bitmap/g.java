package com.bumptech.glide.load.resource.bitmap;
/* compiled from: GlideBitmapDrawableResource.java */
/* loaded from: classes.dex */
public class g extends com.bumptech.glide.load.h.e.a<f> {
    private final com.bumptech.glide.load.engine.bitmap_recycle.c b;

    public g(f fVar, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        super(fVar);
        this.b = cVar;
    }

    @Override // com.bumptech.glide.load.engine.i
    public int getSize() {
        return com.bumptech.glide.l.h.e(((f) this.a).d());
    }

    @Override // com.bumptech.glide.load.engine.i
    public void recycle() {
        this.b.a(((f) this.a).d());
    }
}
