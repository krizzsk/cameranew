package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.model.n;
import java.io.File;
import java.io.InputStream;
/* compiled from: StreamBitmapDataLoadProvider.java */
/* loaded from: classes.dex */
public class j implements com.bumptech.glide.j.b<InputStream, Bitmap> {
    private final StreamBitmapDecoder a;
    private final b b;
    private final n c = new n();

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.load.h.f.c<Bitmap> f784d;

    public j(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, DecodeFormat decodeFormat) {
        StreamBitmapDecoder streamBitmapDecoder = new StreamBitmapDecoder(cVar, decodeFormat);
        this.a = streamBitmapDecoder;
        this.b = new b();
        this.f784d = new com.bumptech.glide.load.h.f.c<>(streamBitmapDecoder);
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.a<InputStream> b() {
        return this.c;
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.e<Bitmap> d() {
        return this.b;
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.d<InputStream, Bitmap> e() {
        return this.a;
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.d<File, Bitmap> f() {
        return this.f784d;
    }
}
