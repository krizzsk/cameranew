package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import com.bumptech.glide.load.model.n;
import java.io.File;
import java.io.InputStream;
/* compiled from: GifDrawableLoadProvider.java */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.j.b<InputStream, b> {
    private final GifResourceDecoder a;
    private final i b;
    private final n c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.load.h.f.c<b> f804d;

    public c(Context context, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        GifResourceDecoder gifResourceDecoder = new GifResourceDecoder(context, cVar);
        this.a = gifResourceDecoder;
        this.f804d = new com.bumptech.glide.load.h.f.c<>(gifResourceDecoder);
        this.b = new i(cVar);
        this.c = new n();
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.a<InputStream> b() {
        return this.c;
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.e<b> d() {
        return this.b;
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.d<InputStream, b> e() {
        return this.a;
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.d<File, b> f() {
        return this.f804d;
    }
}
