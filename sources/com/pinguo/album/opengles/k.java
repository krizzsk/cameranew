package com.pinguo.album.opengles;

import android.opengl.GLES20;
import javax.microedition.khronos.opengles.GL11;
/* compiled from: GLES20IdImpl.java */
/* loaded from: classes3.dex */
public class k implements m {
    private final int[] a = new int[1];

    @Override // com.pinguo.album.opengles.m
    public void a(int i2, int[] iArr, int i3) {
        GLES20.glGenBuffers(i2, iArr, i3);
        j.D();
    }

    @Override // com.pinguo.album.opengles.m
    public int b() {
        GLES20.glGenTextures(1, this.a, 0);
        j.D();
        return this.a[0];
    }

    @Override // com.pinguo.album.opengles.m
    public void c(GL11 gl11, int i2, int[] iArr, int i3) {
        GLES20.glDeleteBuffers(i2, iArr, i3);
        j.D();
    }

    @Override // com.pinguo.album.opengles.m
    public void d(GL11 gl11, int i2, int[] iArr, int i3) {
        GLES20.glDeleteTextures(i2, iArr, i3);
        j.D();
    }
}
