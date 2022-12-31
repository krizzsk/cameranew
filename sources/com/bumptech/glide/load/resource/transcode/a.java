package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.resource.bitmap.f;
/* compiled from: GifBitmapWrapperDrawableTranscoder.java */
/* loaded from: classes.dex */
public class a implements b<com.bumptech.glide.load.h.g.a, com.bumptech.glide.load.h.e.b> {
    private final b<Bitmap, f> a;

    public a(b<Bitmap, f> bVar) {
        this.a = bVar;
    }

    @Override // com.bumptech.glide.load.resource.transcode.b
    public i<com.bumptech.glide.load.h.e.b> a(i<com.bumptech.glide.load.h.g.a> iVar) {
        com.bumptech.glide.load.h.g.a aVar = iVar.get();
        i<Bitmap> a = aVar.a();
        if (a != null) {
            return this.a.a(a);
        }
        return aVar.b();
    }

    @Override // com.bumptech.glide.load.resource.transcode.b
    public String getId() {
        return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
