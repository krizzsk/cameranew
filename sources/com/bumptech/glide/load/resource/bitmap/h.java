package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: ImageVideoBitmapDecoder.java */
/* loaded from: classes.dex */
public class h implements com.bumptech.glide.load.d<com.bumptech.glide.load.model.f, Bitmap> {
    private final com.bumptech.glide.load.d<InputStream, Bitmap> a;
    private final com.bumptech.glide.load.d<ParcelFileDescriptor, Bitmap> b;

    public h(com.bumptech.glide.load.d<InputStream, Bitmap> dVar, com.bumptech.glide.load.d<ParcelFileDescriptor, Bitmap> dVar2) {
        this.a = dVar;
        this.b = dVar2;
    }

    @Override // com.bumptech.glide.load.d
    /* renamed from: b */
    public com.bumptech.glide.load.engine.i<Bitmap> a(com.bumptech.glide.load.model.f fVar, int i2, int i3) throws IOException {
        com.bumptech.glide.load.engine.i<Bitmap> a;
        ParcelFileDescriptor a2;
        InputStream b = fVar.b();
        if (b != null) {
            try {
                a = this.a.a(b, i2, i3);
            } catch (IOException e2) {
                if (Log.isLoggable("ImageVideoDecoder", 2)) {
                    Log.v("ImageVideoDecoder", "Failed to load image from stream, trying FileDescriptor", e2);
                }
            }
            return (a != null || (a2 = fVar.a()) == null) ? a : this.b.a(a2, i2, i3);
        }
        a = null;
        if (a != null) {
            return a;
        }
    }

    @Override // com.bumptech.glide.load.d
    public String getId() {
        return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
