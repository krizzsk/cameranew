package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import java.io.IOException;
/* loaded from: classes.dex */
public class FileDescriptorBitmapDecoder implements com.bumptech.glide.load.d<ParcelFileDescriptor, Bitmap> {
    private final l a;
    private final com.bumptech.glide.load.engine.bitmap_recycle.c b;
    private DecodeFormat c;

    public FileDescriptorBitmapDecoder(Context context) {
        this(com.bumptech.glide.e.i(context).j(), DecodeFormat.DEFAULT);
    }

    @Override // com.bumptech.glide.load.d
    /* renamed from: b */
    public com.bumptech.glide.load.engine.i<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3) throws IOException {
        return c.b(this.a.a(parcelFileDescriptor, this.b, i2, i3, this.c), this.b);
    }

    @Override // com.bumptech.glide.load.d
    public String getId() {
        return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
    }

    public FileDescriptorBitmapDecoder(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, DecodeFormat decodeFormat) {
        this(new l(), cVar, decodeFormat);
    }

    public FileDescriptorBitmapDecoder(l lVar, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, DecodeFormat decodeFormat) {
        this.a = lVar;
        this.b = cVar;
        this.c = decodeFormat;
    }
}
