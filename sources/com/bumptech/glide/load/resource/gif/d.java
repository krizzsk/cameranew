package com.bumptech.glide.load.resource.gif;
/* compiled from: GifDrawableResource.java */
/* loaded from: classes.dex */
public class d extends com.bumptech.glide.load.h.e.a<b> {
    public d(b bVar) {
        super(bVar);
    }

    @Override // com.bumptech.glide.load.engine.i
    public int getSize() {
        return ((b) this.a).d().length + com.bumptech.glide.l.h.e(((b) this.a).e());
    }

    @Override // com.bumptech.glide.load.engine.i
    public void recycle() {
        ((b) this.a).stop();
        ((b) this.a).h();
    }
}
