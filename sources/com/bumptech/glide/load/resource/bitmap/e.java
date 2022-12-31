package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;
/* compiled from: FileDescriptorBitmapDataLoadProvider.java */
/* loaded from: classes.dex */
public class e implements com.bumptech.glide.j.b<ParcelFileDescriptor, Bitmap> {
    private final com.bumptech.glide.load.d<File, Bitmap> a;
    private final FileDescriptorBitmapDecoder b;
    private final b c = new b();

    /* renamed from: d  reason: collision with root package name */
    private final com.bumptech.glide.load.a<ParcelFileDescriptor> f778d = com.bumptech.glide.load.h.a.b();

    public e(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, DecodeFormat decodeFormat) {
        this.a = new com.bumptech.glide.load.h.f.c(new StreamBitmapDecoder(cVar, decodeFormat));
        this.b = new FileDescriptorBitmapDecoder(cVar, decodeFormat);
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.a<ParcelFileDescriptor> b() {
        return this.f778d;
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.e<Bitmap> d() {
        return this.c;
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.d<ParcelFileDescriptor, Bitmap> e() {
        return this.b;
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.d<File, Bitmap> f() {
        return this.a;
    }
}
