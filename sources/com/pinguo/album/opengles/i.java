package com.pinguo.album.opengles;

import javax.microedition.khronos.opengles.GL11;
/* compiled from: GLES11IdImpl.java */
/* loaded from: classes3.dex */
public class i implements m {
    private static int a = 1;
    private static Object b = new Object();

    @Override // com.pinguo.album.opengles.m
    public void a(int i2, int[] iArr, int i3) {
        synchronized (b) {
            while (true) {
                int i4 = i2 - 1;
                if (i2 > 0) {
                    int i5 = i3 + i4;
                    int i6 = a;
                    a = i6 + 1;
                    iArr[i5] = i6;
                    i2 = i4;
                }
            }
        }
    }

    @Override // com.pinguo.album.opengles.m
    public int b() {
        int i2;
        synchronized (b) {
            i2 = a;
            a = i2 + 1;
        }
        return i2;
    }

    @Override // com.pinguo.album.opengles.m
    public void c(GL11 gl11, int i2, int[] iArr, int i3) {
        synchronized (b) {
            gl11.glDeleteBuffers(i2, iArr, i3);
        }
    }

    @Override // com.pinguo.album.opengles.m
    public void d(GL11 gl11, int i2, int[] iArr, int i3) {
        synchronized (b) {
            gl11.glDeleteTextures(i2, iArr, i3);
        }
    }
}
