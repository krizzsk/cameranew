package com.pinguo.album.h;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.pinguo.album.data.utils.PGAlbumBitmapPool;
import com.pinguo.album.opengles.s;
import com.pinguo.album.views.c;
/* compiled from: TileImageViewAdapter.java */
/* loaded from: classes3.dex */
public class a implements c.e {
    protected s a;
    protected BitmapRegionDecoder b;
    protected int c;

    /* renamed from: d  reason: collision with root package name */
    protected int f6037d;

    /* renamed from: e  reason: collision with root package name */
    protected int f6038e;

    private int q() {
        return Math.max(0, com.pinguo.album.j.a.b(this.c / this.a.getWidth()));
    }

    @SuppressLint({"NewApi"})
    private Bitmap s(int i2, int i3, int i4, int i5) {
        Bitmap decodeRegion;
        int i6 = i5 << i2;
        Rect rect = new Rect(i3, i4, i3 + i6, i6 + i4);
        synchronized (this) {
            BitmapRegionDecoder bitmapRegionDecoder = this.b;
            if (bitmapRegionDecoder == null) {
                return null;
            }
            Rect rect2 = new Rect(0, 0, this.c, this.f6037d);
            com.pinguo.album.j.a.a(rect2.intersect(rect));
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inPreferQualityOverSpeed = true;
            options.inSampleSize = 1 << i2;
            synchronized (bitmapRegionDecoder) {
                decodeRegion = bitmapRegionDecoder.decodeRegion(rect2, options);
            }
            if (decodeRegion == null) {
                us.pinguo.common.log.a.s("fail in decoding region", new Object[0]);
            }
            if (rect.equals(rect2)) {
                return decodeRegion;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i5, i5, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(decodeRegion, (rect2.left - rect.left) >> i2, (rect2.top - rect.top) >> i2, (Paint) null);
            return createBitmap;
        }
    }

    @Override // com.pinguo.album.views.c.e
    public int b() {
        return this.f6038e;
    }

    @Override // com.pinguo.album.views.c.e
    public int h() {
        return this.f6037d;
    }

    @Override // com.pinguo.album.views.c.e
    public s j() {
        return this.a;
    }

    @Override // com.pinguo.album.views.c.e
    public int k() {
        return this.c;
    }

    /* JADX WARN: Finally extract failed */
    @Override // com.pinguo.album.views.c.e
    @TargetApi(11)
    public Bitmap l(int i2, int i3, int i4, int i5) {
        if (!com.pinguo.album.common.a.c) {
            return s(i2, i3, i4, i5);
        }
        int i6 = i5 << i2;
        Rect rect = new Rect(i3, i4, i3 + i6, i6 + i4);
        synchronized (this) {
            BitmapRegionDecoder bitmapRegionDecoder = this.b;
            if (bitmapRegionDecoder == null) {
                return null;
            }
            boolean z = !new Rect(0, 0, this.c, this.f6037d).contains(rect);
            Bitmap b = PGAlbumBitmapPool.getInstance().b(i5, i5);
            if (b == null) {
                b = Bitmap.createBitmap(i5, i5, Bitmap.Config.ARGB_8888);
            } else if (z) {
                b.eraseColor(0);
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inPreferQualityOverSpeed = true;
            options.inSampleSize = 1 << i2;
            options.inBitmap = b;
            try {
                synchronized (bitmapRegionDecoder) {
                    b = bitmapRegionDecoder.decodeRegion(rect, options);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap != b && bitmap != null) {
                    PGAlbumBitmapPool.getInstance().e(options.inBitmap);
                    options.inBitmap = null;
                }
                if (b == null) {
                    us.pinguo.common.log.a.s("fail in decoding region", new Object[0]);
                }
                return b;
            } catch (Throwable th) {
                Bitmap bitmap2 = options.inBitmap;
                if (bitmap2 != b && bitmap2 != null) {
                    PGAlbumBitmapPool.getInstance().e(options.inBitmap);
                    options.inBitmap = null;
                }
                throw th;
            }
        }
    }

    public synchronized void r() {
        this.a = null;
        this.c = 0;
        this.f6037d = 0;
        this.f6038e = 0;
        this.b = null;
    }

    @SuppressLint({"NewApi"})
    public synchronized void t(BitmapRegionDecoder bitmapRegionDecoder) {
        com.pinguo.album.j.a.c(bitmapRegionDecoder);
        this.b = bitmapRegionDecoder;
        this.c = bitmapRegionDecoder.getWidth();
        this.f6037d = bitmapRegionDecoder.getHeight();
        this.f6038e = q();
    }

    public synchronized void u(s sVar, int i2, int i3) {
        com.pinguo.album.j.a.c(sVar);
        this.a = sVar;
        this.c = i2;
        this.f6037d = i3;
        this.b = null;
        this.f6038e = 0;
    }
}
