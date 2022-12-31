package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.h.a;
import java.io.IOException;
import java.io.OutputStream;
/* compiled from: GifResourceEncoder.java */
/* loaded from: classes.dex */
public class i implements com.bumptech.glide.load.e<b> {

    /* renamed from: d  reason: collision with root package name */
    private static final a f814d = new a();
    private final a.InterfaceC0026a a;
    private final com.bumptech.glide.load.engine.bitmap_recycle.c b;
    private final a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifResourceEncoder.java */
    /* loaded from: classes.dex */
    public static class a {
        a() {
        }

        public com.bumptech.glide.h.a a(a.InterfaceC0026a interfaceC0026a) {
            return new com.bumptech.glide.h.a(interfaceC0026a);
        }

        public com.bumptech.glide.i.a b() {
            return new com.bumptech.glide.i.a();
        }

        public com.bumptech.glide.load.engine.i<Bitmap> c(Bitmap bitmap, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
            return new com.bumptech.glide.load.resource.bitmap.c(bitmap, cVar);
        }

        public com.bumptech.glide.h.d d() {
            return new com.bumptech.glide.h.d();
        }
    }

    public i(com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this(cVar, f814d);
    }

    private com.bumptech.glide.h.a b(byte[] bArr) {
        com.bumptech.glide.h.d d2 = this.c.d();
        d2.o(bArr);
        com.bumptech.glide.h.c c = d2.c();
        com.bumptech.glide.h.a a2 = this.c.a(this.a);
        a2.n(c, bArr);
        a2.a();
        return a2;
    }

    private com.bumptech.glide.load.engine.i<Bitmap> d(Bitmap bitmap, com.bumptech.glide.load.f<Bitmap> fVar, b bVar) {
        com.bumptech.glide.load.engine.i<Bitmap> c = this.c.c(bitmap, this.b);
        com.bumptech.glide.load.engine.i<Bitmap> a2 = fVar.a(c, bVar.getIntrinsicWidth(), bVar.getIntrinsicHeight());
        if (!c.equals(a2)) {
            c.recycle();
        }
        return a2;
    }

    private boolean e(byte[] bArr, OutputStream outputStream) {
        try {
            outputStream.write(bArr);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable("GifEncoder", 3)) {
                Log.d("GifEncoder", "Failed to write data to output stream in GifResourceEncoder", e2);
            }
            return false;
        }
    }

    @Override // com.bumptech.glide.load.a
    /* renamed from: c */
    public boolean a(com.bumptech.glide.load.engine.i<b> iVar, OutputStream outputStream) {
        long b = com.bumptech.glide.l.d.b();
        b bVar = iVar.get();
        com.bumptech.glide.load.f<Bitmap> g2 = bVar.g();
        if (g2 instanceof com.bumptech.glide.load.h.d) {
            return e(bVar.d(), outputStream);
        }
        com.bumptech.glide.h.a b2 = b(bVar.d());
        com.bumptech.glide.i.a b3 = this.c.b();
        if (b3.h(outputStream)) {
            for (int i2 = 0; i2 < b2.f(); i2++) {
                com.bumptech.glide.load.engine.i<Bitmap> d2 = d(b2.j(), g2, bVar);
                try {
                    if (!b3.a(d2.get())) {
                        return false;
                    }
                    b3.f(b2.e(b2.d()));
                    b2.a();
                    d2.recycle();
                } finally {
                    d2.recycle();
                }
            }
            boolean d3 = b3.d();
            if (Log.isLoggable("GifEncoder", 2)) {
                Log.v("GifEncoder", "Encoded gif with " + b2.f() + " frames and " + bVar.d().length + " bytes in " + com.bumptech.glide.l.d.a(b) + " ms");
            }
            return d3;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.a
    public String getId() {
        return "";
    }

    i(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, a aVar) {
        this.b = cVar;
        this.a = new com.bumptech.glide.load.resource.gif.a(cVar);
        this.c = aVar;
    }
}
