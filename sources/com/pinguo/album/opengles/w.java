package com.pinguo.album.opengles;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.pinguo.album.data.utils.PGAlbumBitmapPool;
/* compiled from: TiledScreenNail.java */
/* loaded from: classes3.dex */
public class w implements s {

    /* renamed from: g  reason: collision with root package name */
    private static int f6091g = -14540254;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f6092h = true;
    private int a;
    private int b;
    private long c;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f6093d;

    /* renamed from: e  reason: collision with root package name */
    private x f6094e;

    /* renamed from: f  reason: collision with root package name */
    private t f6095f;

    @Override // com.pinguo.album.opengles.s
    public void a(l lVar, int i2, int i3, int i4, int i5) {
        x xVar = this.f6094e;
        if (xVar == null) {
            if (this.c == -1) {
                this.c = -2L;
            }
            if (f6092h) {
                lVar.g(i2, i3, i4, i5, f6091g);
                t tVar = this.f6095f;
                if (tVar != null) {
                    this.f6095f.c(lVar, i2 + ((i4 - tVar.getWidth()) / 2), i3 + ((i5 - this.f6095f.getHeight()) / 2));
                    return;
                }
                return;
            }
            return;
        }
        xVar.d();
        throw null;
    }

    @Override // com.pinguo.album.opengles.s
    public void b() {
    }

    @Override // com.pinguo.album.opengles.s
    public void c(l lVar, RectF rectF, RectF rectF2) {
        x xVar = this.f6094e;
        if (xVar == null) {
            lVar.g(rectF2.left, rectF2.top, rectF2.width(), rectF2.height(), f6091g);
        } else {
            xVar.d();
            throw null;
        }
    }

    public boolean d() {
        x xVar = this.f6094e;
        if (xVar == null) {
            return true;
        }
        xVar.d();
        throw null;
    }

    @Override // com.pinguo.album.opengles.s
    public int getHeight() {
        return this.b;
    }

    @Override // com.pinguo.album.opengles.s
    public int getWidth() {
        return this.a;
    }

    @Override // com.pinguo.album.opengles.s
    public void recycle() {
        x xVar = this.f6094e;
        if (xVar == null) {
            if (this.f6093d != null) {
                PGAlbumBitmapPool.getInstance().f(this.f6093d);
                this.f6093d = null;
                return;
            }
            return;
        }
        xVar.e();
        throw null;
    }
}
