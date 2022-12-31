package com.pinguo.album.opengles;

import android.graphics.Bitmap;
/* compiled from: BitmapTexture.java */
/* loaded from: classes3.dex */
public class c extends y {
    protected Bitmap t;
    protected boolean u;

    public c(Bitmap bitmap) {
        this(bitmap, false);
    }

    @Override // com.pinguo.album.opengles.y
    protected void A(Bitmap bitmap) {
    }

    @Override // com.pinguo.album.opengles.y
    protected Bitmap B() {
        return this.t;
    }

    @Override // com.pinguo.album.opengles.y
    public void F(l lVar) {
        if (this.u) {
            return;
        }
        super.F(lVar);
    }

    public boolean I() {
        return this.u;
    }

    @Override // com.pinguo.album.opengles.y, com.pinguo.album.opengles.a
    public void o() {
        this.u = true;
        super.o();
    }

    public Bitmap v() {
        return this.t;
    }

    public c(Bitmap bitmap, boolean z) {
        super(z);
        this.t = bitmap;
        this.u = false;
    }
}
