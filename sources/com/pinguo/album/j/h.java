package com.pinguo.album.j;
/* compiled from: RangeIntArray.java */
/* loaded from: classes3.dex */
public class h {
    private int[] a;
    private int b;

    public h(int[] iArr, int i2, int i3) {
        this.a = iArr;
        this.b = i2;
    }

    public int a(int i2) {
        return this.a[i2 - this.b];
    }
}
