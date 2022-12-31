package com.bumptech.glide.load.h.g;

import com.bumptech.glide.load.engine.i;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: GifBitmapWrapperStreamResourceDecoder.java */
/* loaded from: classes.dex */
public class e implements com.bumptech.glide.load.d<InputStream, a> {
    private final com.bumptech.glide.load.d<com.bumptech.glide.load.model.f, a> a;

    public e(com.bumptech.glide.load.d<com.bumptech.glide.load.model.f, a> dVar) {
        this.a = dVar;
    }

    @Override // com.bumptech.glide.load.d
    /* renamed from: b */
    public i<a> a(InputStream inputStream, int i2, int i3) throws IOException {
        return this.a.a(new com.bumptech.glide.load.model.f(inputStream, null), i2, i3);
    }

    @Override // com.bumptech.glide.load.d
    public String getId() {
        return this.a.getId();
    }
}
