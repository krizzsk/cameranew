package com.facebook.appevents.ml;
/* compiled from: MTensor.java */
/* loaded from: classes.dex */
public class a {
    private float[] a;
    private int[] b;
    private int c;

    public a(int[] iArr) {
        this.b = iArr;
        int a = a(iArr);
        this.c = a;
        this.a = new float[a];
    }

    private static int a(int[] iArr) {
        int i2 = 1;
        for (int i3 : iArr) {
            i2 *= i3;
        }
        return i2;
    }

    public float[] b() {
        return this.a;
    }

    public int c(int i2) {
        return this.b[i2];
    }

    public int d() {
        return this.b.length;
    }

    public void e(int[] iArr) {
        this.b = iArr;
        int a = a(iArr);
        float[] fArr = new float[a];
        System.arraycopy(this.a, 0, fArr, 0, Math.min(this.c, a));
        this.a = fArr;
        this.c = a;
    }
}
