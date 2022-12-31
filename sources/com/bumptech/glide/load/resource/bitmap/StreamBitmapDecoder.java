package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import java.io.InputStream;
/* loaded from: classes.dex */
public class StreamBitmapDecoder implements com.bumptech.glide.load.d<InputStream, Bitmap> {
    private final d a;
    private com.bumptech.glide.load.engine.bitmap_recycle.c b;
    private DecodeFormat c;

    /* renamed from: d  reason: collision with root package name */
    private String f777d;

    public StreamBitmapDecoder(Context context) {
        this(com.bumptech.glide.e.i(context).j());
    }

    @Override // com.bumptech.glide.load.d
    /* renamed from: b */
    public com.bumptech.glide.load.engine.i<Bitmap> a(InputStream inputStream, int i2, int i3) {
        return c.b(this.a.a(inputStream, this.b, i2, i3, this.c), this.b);
    }

    @Override // com.bumptech.glide.load.d
    public String getId() {
        if (this.f777d == null) {
            this.f777d = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap" + this.a.getId() + this.c.name();
        }
        return this.f777d;
    }

    public StreamBitmapDecoder(com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this(cVar, DecodeFormat.DEFAULT);
    }

    public StreamBitmapDecoder(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, DecodeFormat decodeFormat) {
        this(d.c, cVar, decodeFormat);
    }

    public StreamBitmapDecoder(d dVar, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, DecodeFormat decodeFormat) {
        this.a = dVar;
        this.b = cVar;
        this.c = decodeFormat;
    }
}
