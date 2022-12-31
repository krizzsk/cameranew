package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Objects;
import java.util.UUID;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GifFrameLoader.java */
/* loaded from: classes.dex */
public class f {
    private final c a;
    private final com.bumptech.glide.h.a b;
    private final Handler c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f805d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f806e;

    /* renamed from: f  reason: collision with root package name */
    private com.bumptech.glide.c<com.bumptech.glide.h.a, com.bumptech.glide.h.a, Bitmap, Bitmap> f807f;

    /* renamed from: g  reason: collision with root package name */
    private b f808g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f809h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public static class b extends com.bumptech.glide.request.g.g<Bitmap> {

        /* renamed from: d  reason: collision with root package name */
        private final Handler f810d;

        /* renamed from: e  reason: collision with root package name */
        private final int f811e;

        /* renamed from: f  reason: collision with root package name */
        private final long f812f;

        /* renamed from: g  reason: collision with root package name */
        private Bitmap f813g;

        public b(Handler handler, int i2, long j2) {
            this.f810d = handler;
            this.f811e = i2;
            this.f812f = j2;
        }

        public Bitmap k() {
            return this.f813g;
        }

        @Override // com.bumptech.glide.request.g.j
        /* renamed from: l */
        public void b(Bitmap bitmap, com.bumptech.glide.request.f.c<? super Bitmap> cVar) {
            this.f813g = bitmap;
            this.f810d.sendMessageAtTime(this.f810d.obtainMessage(1, this), this.f812f);
        }
    }

    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public interface c {
        void a(int i2);
    }

    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    private class d implements Handler.Callback {
        private d() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                f.this.e((b) message.obj);
                return true;
            } else if (i2 == 2) {
                com.bumptech.glide.e.g((b) message.obj);
                return false;
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GifFrameLoader.java */
    /* loaded from: classes.dex */
    public static class e implements com.bumptech.glide.load.b {
        private final UUID a;

        public e() {
            this(UUID.randomUUID());
        }

        @Override // com.bumptech.glide.load.b
        public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
            throw new UnsupportedOperationException("Not implemented");
        }

        public boolean equals(Object obj) {
            if (obj instanceof e) {
                return ((e) obj).a.equals(this.a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        e(UUID uuid) {
            this.a = uuid;
        }
    }

    public f(Context context, c cVar, com.bumptech.glide.h.a aVar, int i2, int i3) {
        this(cVar, aVar, null, c(context, aVar, i2, i3, com.bumptech.glide.e.i(context).j()));
    }

    private static com.bumptech.glide.c<com.bumptech.glide.h.a, com.bumptech.glide.h.a, Bitmap, Bitmap> c(Context context, com.bumptech.glide.h.a aVar, int i2, int i3, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        h hVar = new h(cVar);
        g gVar = new g();
        com.bumptech.glide.load.a b2 = com.bumptech.glide.load.h.a.b();
        com.bumptech.glide.d a2 = com.bumptech.glide.e.q(context).w(gVar, com.bumptech.glide.h.a.class).c(aVar).a(Bitmap.class);
        a2.r(b2);
        a2.g(hVar);
        a2.q(true);
        a2.h(DiskCacheStrategy.NONE);
        a2.o(i2, i3);
        return a2;
    }

    private void d() {
        if (!this.f805d || this.f806e) {
            return;
        }
        this.f806e = true;
        this.b.a();
        this.f807f.p(new e()).k(new b(this.c, this.b.d(), SystemClock.uptimeMillis() + this.b.i()));
    }

    public void a() {
        h();
        b bVar = this.f808g;
        if (bVar != null) {
            com.bumptech.glide.e.g(bVar);
            this.f808g = null;
        }
        this.f809h = true;
    }

    public Bitmap b() {
        b bVar = this.f808g;
        if (bVar != null) {
            return bVar.k();
        }
        return null;
    }

    void e(b bVar) {
        if (this.f809h) {
            this.c.obtainMessage(2, bVar).sendToTarget();
            return;
        }
        b bVar2 = this.f808g;
        this.f808g = bVar;
        this.a.a(bVar.f811e);
        if (bVar2 != null) {
            this.c.obtainMessage(2, bVar2).sendToTarget();
        }
        this.f806e = false;
        d();
    }

    public void f(com.bumptech.glide.load.f<Bitmap> fVar) {
        Objects.requireNonNull(fVar, "Transformation must not be null");
        this.f807f = this.f807f.s(fVar);
    }

    public void g() {
        if (this.f805d) {
            return;
        }
        this.f805d = true;
        this.f809h = false;
        d();
    }

    public void h() {
        this.f805d = false;
    }

    f(c cVar, com.bumptech.glide.h.a aVar, Handler handler, com.bumptech.glide.c<com.bumptech.glide.h.a, com.bumptech.glide.h.a, Bitmap, Bitmap> cVar2) {
        this.f805d = false;
        this.f806e = false;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new d()) : handler;
        this.a = cVar;
        this.b = aVar;
        this.c = handler;
        this.f807f = cVar2;
    }
}
