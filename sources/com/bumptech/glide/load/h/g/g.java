package com.bumptech.glide.load.h.g;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;
/* compiled from: ImageVideoGifDrawableLoadProvider.java */
/* loaded from: classes.dex */
public class g implements com.bumptech.glide.j.b<com.bumptech.glide.load.model.f, a> {
    private final com.bumptech.glide.load.d<File, a> a;
    private final com.bumptech.glide.load.d<com.bumptech.glide.load.model.f, a> b;
    private final com.bumptech.glide.load.e<a> c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.load.a<com.bumptech.glide.load.model.f> f770d;

    public g(com.bumptech.glide.j.b<com.bumptech.glide.load.model.f, Bitmap> bVar, com.bumptech.glide.j.b<InputStream, com.bumptech.glide.load.resource.gif.b> bVar2, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        c cVar2 = new c(bVar.e(), bVar2.e(), cVar);
        this.a = new com.bumptech.glide.load.h.f.c(new e(cVar2));
        this.b = cVar2;
        this.c = new d(bVar.d(), bVar2.d());
        this.f770d = bVar.b();
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.a<com.bumptech.glide.load.model.f> b() {
        return this.f770d;
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.e<a> d() {
        return this.c;
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.d<com.bumptech.glide.load.model.f, a> e() {
        return this.b;
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.d<File, a> f() {
        return this.a;
    }
}
