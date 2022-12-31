package com.hw.photomovie.util;
/* compiled from: IntArray.java */
/* loaded from: classes2.dex */
public class a {
    private int[] a = new int[8];
    private int b = 0;

    public void a(int i2) {
        int[] iArr = this.a;
        int length = iArr.length;
        int i3 = this.b;
        if (length == i3) {
            int[] iArr2 = new int[i3 + i3];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.a = iArr2;
        }
        int[] iArr3 = this.a;
        int i4 = this.b;
        this.b = i4 + 1;
        iArr3[i4] = i2;
    }

    public void b() {
        this.b = 0;
        if (this.a.length != 8) {
            this.a = new int[8];
        }
    }

    public int[] c() {
        return this.a;
    }

    public int d() {
        int i2 = this.b - 1;
        this.b = i2;
        return this.a[i2];
    }

    public int e() {
        return this.b;
    }
}
