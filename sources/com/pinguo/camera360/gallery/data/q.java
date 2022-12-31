package com.pinguo.camera360.gallery.data;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.pinguo.album.a;
import com.pinguo.album.data.utils.d;
import us.pinguo.foundation.utils.n0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageCacheRequest.java */
/* loaded from: classes3.dex */
public abstract class q implements a.b<Bitmap> {
    protected String a;
    protected int b;
    protected int c;

    /* renamed from: e  reason: collision with root package name */
    protected int f6374e = 0;

    /* renamed from: d  reason: collision with root package name */
    protected float f6373d = w.f6388g / n0.i();

    public q(Application application, String str, int i2, int i3) {
        this.a = str;
        this.b = i2;
        this.c = i3;
    }

    protected Bitmap b(Bitmap bitmap, a.c cVar, LocalBlobCacheService localBlobCacheService) {
        Bitmap j2;
        int i2 = this.b;
        if (i2 == 2) {
            j2 = com.pinguo.album.data.utils.b.h(bitmap, this.c, true);
        } else if (i2 == 3) {
            int i3 = this.c;
            float f2 = this.f6373d;
            j2 = com.pinguo.album.data.utils.b.k(bitmap, i3, (int) (i3 * f2), f2, this.f6374e, true);
            us.pinguo.common.log.a.s("resizeSameRadioAndCropCenter decode orig bitmap " + j2.getWidth() + "/" + j2.getHeight(), new Object[0]);
        } else {
            j2 = com.pinguo.album.data.utils.b.j(bitmap, this.c, true);
        }
        if (cVar.isCancelled()) {
            return null;
        }
        byte[] a = com.pinguo.album.data.utils.b.a(j2);
        if (cVar.isCancelled()) {
            return null;
        }
        localBlobCacheService.d(this.a, this.b, a);
        return j2;
    }

    public abstract Bitmap c(a.c cVar, int i2);

    @Override // com.pinguo.album.a.b
    /* renamed from: d */
    public Bitmap a(a.c cVar) {
        boolean a;
        Bitmap b;
        if (cVar.isCancelled()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(",");
        int i2 = this.b;
        sb.append(i2 == 1 ? "THUMB" : i2 == 2 ? "MICROTHUMB" : "?");
        String sb2 = sb.toString();
        LocalBlobCacheService c = com.pinguo.album.e.e().c();
        d.b b2 = w.m().b();
        try {
            int i3 = this.b;
            if (i3 == 5) {
                a = c.a(this.a, 1, b2);
                if (a) {
                    this.b = 1;
                    this.c = w.v(1);
                } else {
                    boolean a2 = c.a(this.a, 4, b2);
                    this.b = 4;
                    this.c = w.v(4);
                    a = a2;
                }
            } else {
                a = c.a(this.a, i3, b2);
            }
            if (cVar.isCancelled()) {
                return null;
            }
            if (a) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                if (com.pinguo.album.common.a.a) {
                    b = com.pinguo.album.data.utils.a.f(cVar, b2.a, b2.b, b2.c, options);
                } else {
                    b = com.pinguo.album.data.utils.a.b(cVar, b2.a, b2.b, b2.c, options);
                }
                if (b == null && !cVar.isCancelled()) {
                    us.pinguo.common.log.a.s("decode cached failed " + sb2, new Object[0]);
                }
                return b;
            }
            w.m().c(b2);
            Bitmap c2 = c(cVar, this.b);
            if (cVar.isCancelled()) {
                return null;
            }
            if (c2 == null) {
                us.pinguo.common.log.a.s("decode orig failed " + sb2, new Object[0]);
                return null;
            }
            return b(c2, cVar, c);
        } finally {
            w.m().c(b2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i2) {
        this.f6374e = i2;
    }
}
