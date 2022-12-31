package com.pinguo.album.opengles;

import android.graphics.Bitmap;
import android.graphics.Canvas;
/* compiled from: CanvasTexture.java */
/* loaded from: classes3.dex */
public abstract class d extends y {
    protected Canvas t;
    private final Bitmap.Config u = Bitmap.Config.ARGB_8888;

    public d(int i2, int i3) {
        r(i2, i3);
        E(false);
    }

    @Override // com.pinguo.album.opengles.y
    protected void A(Bitmap bitmap) {
        if (a.j()) {
            return;
        }
        bitmap.recycle();
    }

    @Override // com.pinguo.album.opengles.y
    protected Bitmap B() {
        Bitmap createBitmap = Bitmap.createBitmap(this.c, this.f6051d, this.u);
        Canvas canvas = new Canvas(createBitmap);
        this.t = canvas;
        I(canvas, createBitmap);
        return createBitmap;
    }

    protected abstract void I(Canvas canvas, Bitmap bitmap);
}
