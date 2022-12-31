package com.hw.photomovie.d;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import junit.framework.Assert;
/* compiled from: BitmapTexture.java */
/* loaded from: classes2.dex */
public class b extends j {
    protected Bitmap s;
    protected boolean t;
    protected boolean u;

    public b(Bitmap bitmap) {
        this(bitmap, false);
    }

    @Override // com.hw.photomovie.d.j, com.hw.photomovie.d.a
    public void m() {
        int i2;
        this.t = true;
        if (this.u && (i2 = this.a) != -1 && GLES20.glIsTexture(i2)) {
            GLES20.glDeleteTextures(1, new int[]{this.a}, 0);
            this.a = -1;
        }
        super.m();
    }

    @Override // com.hw.photomovie.d.j
    protected void u(Bitmap bitmap) {
    }

    @Override // com.hw.photomovie.d.j
    protected Bitmap v() {
        return this.s;
    }

    @Override // com.hw.photomovie.d.j
    public void w(f fVar) {
        if (this.t) {
            return;
        }
        super.w(fVar);
    }

    public b(Bitmap bitmap, boolean z) {
        super(z);
        boolean z2 = true;
        this.u = true;
        Assert.assertTrue((bitmap == null || bitmap.isRecycled()) ? false : false);
        this.s = bitmap;
        this.t = false;
    }
}
