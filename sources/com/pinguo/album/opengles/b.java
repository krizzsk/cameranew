package com.pinguo.album.opengles;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.pinguo.album.data.utils.PGAlbumBitmapPool;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
/* compiled from: BitmapScreenNail.java */
/* loaded from: classes3.dex */
public class b implements s {
    private int a;
    private int b;
    private Bitmap c;

    /* renamed from: d  reason: collision with root package name */
    private c f6056d;

    /* renamed from: e  reason: collision with root package name */
    private u f6057e;

    /* renamed from: f  reason: collision with root package name */
    private long f6058f = -1;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f6059g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f6060h;

    public b(c cVar) {
        this.f6056d = cVar;
        Bitmap v = cVar.v();
        this.c = v;
        this.a = v.getWidth();
        this.b = this.c.getHeight();
    }

    private static long h() {
        return com.pinguo.album.animations.c.a();
    }

    private void i(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            i2 = VideoEdit2Activity.MIN_SCALED_SIZE;
            i3 = 480;
        }
        float min = Math.min(1.0f, 640.0f / Math.max(i2, i3));
        this.a = Math.round(i2 * min);
        this.b = Math.round(min * i3);
    }

    @Override // com.pinguo.album.opengles.s
    public void a(l lVar, int i2, int i3, int i4, int i5) {
        if (this.f6059g) {
            return;
        }
        Bitmap bitmap = this.c;
        if (bitmap != null && !bitmap.isRecycled()) {
            if (this.f6056d == null) {
                this.f6056d = new c(this.c);
            }
            if (this.f6058f == -2) {
                this.f6058f = h();
            }
            this.f6056d.a(lVar, i2, i3, i4, i5);
            return;
        }
        u uVar = this.f6057e;
        if (uVar != null) {
            if (this.f6058f == -1) {
                this.f6058f = -2L;
            }
            if (i4 >= uVar.getWidth() && i5 >= this.f6057e.getHeight()) {
                lVar.g(i2, i3, i4, i5, 861954144);
            }
            this.f6057e.c(lVar, i2 + ((i4 - this.f6057e.getWidth()) / 2), i3 + ((i5 - this.f6057e.getHeight()) / 2));
        }
    }

    @Override // com.pinguo.album.opengles.s
    public void b() {
    }

    @Override // com.pinguo.album.opengles.s
    public void c(l lVar, RectF rectF, RectF rectF2) {
        if (this.c == null) {
            lVar.g(rectF2.left, rectF2.top, rectF2.width(), rectF2.height(), -14540254);
            return;
        }
        if (this.f6056d == null) {
            this.f6056d = new c(this.c);
        }
        lVar.i(this.f6056d, rectF, rectF2);
    }

    public s d(s sVar) {
        if (sVar == null) {
            return this;
        }
        if (!(sVar instanceof b)) {
            recycle();
            return sVar;
        }
        b bVar = (b) sVar;
        this.a = bVar.a;
        this.b = bVar.b;
        if (bVar.c != null) {
            if (this.c != null) {
                PGAlbumBitmapPool.getInstance().f(this.c);
            }
            this.c = bVar.c;
            bVar.c = null;
            c cVar = this.f6056d;
            if (cVar != null) {
                cVar.o();
                this.f6056d = null;
            }
        }
        this.f6059g = false;
        this.f6060h = false;
        bVar.recycle();
        return this;
    }

    public boolean e() {
        if (this.f6058f < 0) {
            return false;
        }
        if (h() - this.f6058f >= 180) {
            this.f6058f = -3L;
            return false;
        }
        return true;
    }

    public boolean f() {
        return this.c == null || e();
    }

    public boolean g() {
        return this.f6060h;
    }

    @Override // com.pinguo.album.opengles.s
    public int getHeight() {
        return this.b;
    }

    @Override // com.pinguo.album.opengles.s
    public int getWidth() {
        return this.a;
    }

    public void j(boolean z) {
        this.f6060h = z;
    }

    public void k(int i2, int i3) {
        if (this.c != null || i2 == 0 || i3 == 0) {
            return;
        }
        i(i2, i3);
    }

    @Override // com.pinguo.album.opengles.s
    public void recycle() {
        this.f6059g = true;
        c cVar = this.f6056d;
        if (cVar != null) {
            cVar.o();
            this.f6056d = null;
        }
        if (this.c != null) {
            PGAlbumBitmapPool.getInstance().f(this.c);
            this.c = null;
        }
    }

    public b(Bitmap bitmap) {
        this.a = bitmap.getWidth();
        this.b = bitmap.getHeight();
        this.c = bitmap;
    }

    public b(int i2, int i3, u uVar) {
        this.f6057e = uVar;
        i(i2, i3);
    }
}
