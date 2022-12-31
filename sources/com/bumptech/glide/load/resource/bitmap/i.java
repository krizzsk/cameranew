package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.InputStream;
/* compiled from: ImageVideoDataLoadProvider.java */
/* loaded from: classes.dex */
public class i implements com.bumptech.glide.j.b<com.bumptech.glide.load.model.f, Bitmap> {
    private final h a;
    private final com.bumptech.glide.load.d<File, Bitmap> b;
    private final com.bumptech.glide.load.e<Bitmap> c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.load.model.g f783d;

    public i(com.bumptech.glide.j.b<InputStream, Bitmap> bVar, com.bumptech.glide.j.b<ParcelFileDescriptor, Bitmap> bVar2) {
        this.c = bVar.d();
        this.f783d = new com.bumptech.glide.load.model.g(bVar.b(), bVar2.b());
        this.b = bVar.f();
        this.a = new h(bVar.e(), bVar2.e());
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.a<com.bumptech.glide.load.model.f> b() {
        return this.f783d;
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.e<Bitmap> d() {
        return this.c;
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.d<com.bumptech.glide.load.model.f, Bitmap> e() {
        return this.a;
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.d<File, Bitmap> f() {
        return this.b;
    }
}
