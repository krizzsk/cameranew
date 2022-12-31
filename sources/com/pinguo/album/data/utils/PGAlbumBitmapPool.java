package com.pinguo.album.data.utils;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.pinguo.album.data.utils.f;
/* loaded from: classes3.dex */
public class PGAlbumBitmapPool {
    private static final Point[] c = {new Point(5, 3), new Point(4, 3), new Point(3, 2), new Point(16, 9)};

    /* renamed from: d  reason: collision with root package name */
    private static PGAlbumBitmapPool f6027d = new PGAlbumBitmapPool();
    private f[] a;
    private com.pinguo.album.j.d<f.a> b = new com.pinguo.album.j.f(128);

    private PGAlbumBitmapPool() {
        f[] fVarArr = new f[3];
        this.a = fVarArr;
        int c2 = e.c();
        com.pinguo.album.j.d<f.a> dVar = this.b;
        boolean z = com.pinguo.album.common.a.a;
        fVarArr[0] = new f(c2, dVar, "squarePool", z);
        this.a[1] = new f(e.b(), this.b, "photoPool", z);
        this.a[2] = new f(e.a(), this.b, "miscPool", z);
    }

    private f c(int i2, int i3) {
        int d2 = d(i2, i3);
        if (d2 == -1) {
            return null;
        }
        return this.a[d2];
    }

    private int d(int i2, int i3) {
        Point[] pointArr;
        if (i2 <= 0 || i3 <= 0) {
            return -1;
        }
        if (i2 == i3) {
            return 0;
        }
        if (i2 > i3) {
            i3 = i2;
            i2 = i3;
        }
        for (Point point : c) {
            if (point.x * i2 == point.y * i3) {
                return 1;
            }
        }
        return 2;
    }

    public static PGAlbumBitmapPool getInstance() {
        return f6027d;
    }

    public void a() {
        for (f fVar : this.a) {
            fVar.a();
        }
    }

    public Bitmap b(int i2, int i3) {
        f c2 = c(i2, i3);
        if (c2 == null) {
            return null;
        }
        return c2.c(i2, i3);
    }

    public boolean e(Bitmap bitmap) {
        if (bitmap == null || bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            return false;
        }
        f c2 = c(bitmap.getWidth(), bitmap.getHeight());
        if (c2 == null) {
            bitmap.recycle();
            return false;
        }
        return c2.e(bitmap);
    }

    public boolean f(Bitmap bitmap) {
        if (bitmap != null && bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
            f c2 = c(bitmap.getWidth(), bitmap.getHeight());
            if (c2 != null && c2.d()) {
                return c2.e(bitmap);
            }
            bitmap.recycle();
        }
        return false;
    }
}
