package com.hw.photomovie.d;

import android.opengl.GLES20;
import javax.microedition.khronos.opengles.GL11;
/* compiled from: GLES20IdImpl.java */
/* loaded from: classes2.dex */
public class e implements g {
    private final int[] a = new int[1];

    @Override // com.hw.photomovie.d.g
    public void a(int i2, int[] iArr, int i3) {
        GLES20.glGenBuffers(i2, iArr, i3);
        d.r();
    }

    @Override // com.hw.photomovie.d.g
    public int b() {
        GLES20.glGenTextures(1, this.a, 0);
        d.r();
        return this.a[0];
    }

    @Override // com.hw.photomovie.d.g
    public void c(GL11 gl11, int i2, int[] iArr, int i3) {
        GLES20.glDeleteBuffers(i2, iArr, i3);
        d.r();
    }

    @Override // com.hw.photomovie.d.g
    public void d(GL11 gl11, int i2, int[] iArr, int i3) {
        GLES20.glDeleteTextures(i2, iArr, i3);
        d.r();
    }
}
