package com.bumptech.glide.load.h.g;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: GifBitmapWrapperResourceDecoder.java */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.load.d<com.bumptech.glide.load.model.f, com.bumptech.glide.load.h.g.a> {

    /* renamed from: g  reason: collision with root package name */
    private static final b f765g = new b();

    /* renamed from: h  reason: collision with root package name */
    private static final a f766h = new a();
    private final com.bumptech.glide.load.d<com.bumptech.glide.load.model.f, Bitmap> a;
    private final com.bumptech.glide.load.d<InputStream, com.bumptech.glide.load.resource.gif.b> b;
    private final com.bumptech.glide.load.engine.bitmap_recycle.c c;

    /* renamed from: d  reason: collision with root package name */
    private final b f767d;

    /* renamed from: e  reason: collision with root package name */
    private final a f768e;

    /* renamed from: f  reason: collision with root package name */
    private String f769f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifBitmapWrapperResourceDecoder.java */
    /* loaded from: classes.dex */
    public static class a {
        a() {
        }

        public InputStream a(InputStream inputStream, byte[] bArr) {
            return new RecyclableBufferedInputStream(inputStream, bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifBitmapWrapperResourceDecoder.java */
    /* loaded from: classes.dex */
    public static class b {
        b() {
        }

        public ImageHeaderParser.ImageType a(InputStream inputStream) throws IOException {
            return new ImageHeaderParser(inputStream).d();
        }
    }

    public c(com.bumptech.glide.load.d<com.bumptech.glide.load.model.f, Bitmap> dVar, com.bumptech.glide.load.d<InputStream, com.bumptech.glide.load.resource.gif.b> dVar2, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this(dVar, dVar2, cVar, f765g, f766h);
    }

    private com.bumptech.glide.load.h.g.a c(com.bumptech.glide.load.model.f fVar, int i2, int i3, byte[] bArr) throws IOException {
        if (fVar.b() != null) {
            return f(fVar, i2, i3, bArr);
        }
        return d(fVar, i2, i3);
    }

    private com.bumptech.glide.load.h.g.a d(com.bumptech.glide.load.model.f fVar, int i2, int i3) throws IOException {
        i<Bitmap> a2 = this.a.a(fVar, i2, i3);
        if (a2 != null) {
            return new com.bumptech.glide.load.h.g.a(a2, null);
        }
        return null;
    }

    private com.bumptech.glide.load.h.g.a e(InputStream inputStream, int i2, int i3) throws IOException {
        com.bumptech.glide.load.h.g.a aVar;
        i<com.bumptech.glide.load.resource.gif.b> a2 = this.b.a(inputStream, i2, i3);
        if (a2 != null) {
            com.bumptech.glide.load.resource.gif.b bVar = a2.get();
            if (bVar.f() > 1) {
                aVar = new com.bumptech.glide.load.h.g.a(null, a2);
            } else {
                aVar = new com.bumptech.glide.load.h.g.a(new com.bumptech.glide.load.resource.bitmap.c(bVar.e(), this.c), null);
            }
            return aVar;
        }
        return null;
    }

    private com.bumptech.glide.load.h.g.a f(com.bumptech.glide.load.model.f fVar, int i2, int i3, byte[] bArr) throws IOException {
        InputStream a2 = this.f768e.a(fVar.b(), bArr);
        a2.mark(2048);
        ImageHeaderParser.ImageType a3 = this.f767d.a(a2);
        a2.reset();
        com.bumptech.glide.load.h.g.a e2 = a3 == ImageHeaderParser.ImageType.GIF ? e(a2, i2, i3) : null;
        return e2 == null ? d(new com.bumptech.glide.load.model.f(a2, fVar.a()), i2, i3) : e2;
    }

    @Override // com.bumptech.glide.load.d
    /* renamed from: b */
    public i<com.bumptech.glide.load.h.g.a> a(com.bumptech.glide.load.model.f fVar, int i2, int i3) throws IOException {
        com.bumptech.glide.l.a a2 = com.bumptech.glide.l.a.a();
        byte[] b2 = a2.b();
        try {
            com.bumptech.glide.load.h.g.a c = c(fVar, i2, i3, b2);
            if (c != null) {
                return new com.bumptech.glide.load.h.g.b(c);
            }
            return null;
        } finally {
            a2.c(b2);
        }
    }

    @Override // com.bumptech.glide.load.d
    public String getId() {
        if (this.f769f == null) {
            this.f769f = this.b.getId() + this.a.getId();
        }
        return this.f769f;
    }

    c(com.bumptech.glide.load.d<com.bumptech.glide.load.model.f, Bitmap> dVar, com.bumptech.glide.load.d<InputStream, com.bumptech.glide.load.resource.gif.b> dVar2, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, b bVar, a aVar) {
        this.a = dVar;
        this.b = dVar2;
        this.c = cVar;
        this.f767d = bVar;
        this.f768e = aVar;
    }
}
