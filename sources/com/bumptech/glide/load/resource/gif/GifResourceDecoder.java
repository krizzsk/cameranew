package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.h.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
/* loaded from: classes.dex */
public class GifResourceDecoder implements com.bumptech.glide.load.d<InputStream, com.bumptech.glide.load.resource.gif.b> {

    /* renamed from: f  reason: collision with root package name */
    private static final b f785f = new b();

    /* renamed from: g  reason: collision with root package name */
    private static final a f786g = new a();
    private final Context a;
    private final b b;
    private final com.bumptech.glide.load.engine.bitmap_recycle.c c;

    /* renamed from: d  reason: collision with root package name */
    private final a f787d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bumptech.glide.load.resource.gif.a f788e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private final Queue<com.bumptech.glide.h.a> a = com.bumptech.glide.l.h.c(0);

        a() {
        }

        public synchronized com.bumptech.glide.h.a a(a.InterfaceC0026a interfaceC0026a) {
            com.bumptech.glide.h.a poll;
            poll = this.a.poll();
            if (poll == null) {
                poll = new com.bumptech.glide.h.a(interfaceC0026a);
            }
            return poll;
        }

        public synchronized void b(com.bumptech.glide.h.a aVar) {
            aVar.b();
            this.a.offer(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        private final Queue<com.bumptech.glide.h.d> a = com.bumptech.glide.l.h.c(0);

        b() {
        }

        public synchronized com.bumptech.glide.h.d a(byte[] bArr) {
            com.bumptech.glide.h.d poll;
            poll = this.a.poll();
            if (poll == null) {
                poll = new com.bumptech.glide.h.d();
            }
            poll.o(bArr);
            return poll;
        }

        public synchronized void b(com.bumptech.glide.h.d dVar) {
            dVar.a();
            this.a.offer(dVar);
        }
    }

    public GifResourceDecoder(Context context) {
        this(context, com.bumptech.glide.e.i(context).j());
    }

    private d c(byte[] bArr, int i2, int i3, com.bumptech.glide.h.d dVar, com.bumptech.glide.h.a aVar) {
        Bitmap d2;
        com.bumptech.glide.h.c c = dVar.c();
        if (c.a() <= 0 || c.b() != 0 || (d2 = d(aVar, c, bArr)) == null) {
            return null;
        }
        return new d(new com.bumptech.glide.load.resource.gif.b(this.a, this.f788e, this.c, com.bumptech.glide.load.h.d.b(), i2, i3, c, bArr, d2));
    }

    private Bitmap d(com.bumptech.glide.h.a aVar, com.bumptech.glide.h.c cVar, byte[] bArr) {
        aVar.n(cVar, bArr);
        aVar.a();
        return aVar.j();
    }

    private static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
        } catch (IOException e2) {
            Log.w("GifResourceDecoder", "Error reading data from stream", e2);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.bumptech.glide.load.d
    /* renamed from: b */
    public d a(InputStream inputStream, int i2, int i3) {
        byte[] e2 = e(inputStream);
        com.bumptech.glide.h.d a2 = this.b.a(e2);
        com.bumptech.glide.h.a a3 = this.f787d.a(this.f788e);
        try {
            return c(e2, i2, i3, a2, a3);
        } finally {
            this.b.b(a2);
            this.f787d.b(a3);
        }
    }

    @Override // com.bumptech.glide.load.d
    public String getId() {
        return "";
    }

    public GifResourceDecoder(Context context, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this(context, cVar, f785f, f786g);
    }

    GifResourceDecoder(Context context, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, b bVar, a aVar) {
        this.a = context;
        this.c = cVar;
        this.f787d = aVar;
        this.f788e = new com.bumptech.glide.load.resource.gif.a(cVar);
        this.b = bVar;
    }
}
