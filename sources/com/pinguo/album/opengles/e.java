package com.pinguo.album.opengles;
/* compiled from: ColorTexture.java */
/* loaded from: classes3.dex */
public class e implements u {
    private final int a;
    private int b = 1;
    private int c = 1;

    public e(int i2) {
        this.a = i2;
    }

    @Override // com.pinguo.album.opengles.u
    public void a(l lVar, int i2, int i3, int i4, int i5) {
        lVar.g(i2, i3, i4, i5, this.a);
    }

    @Override // com.pinguo.album.opengles.u
    public void c(l lVar, int i2, int i3) {
        a(lVar, i2, i3, this.b, this.c);
    }

    public void d(int i2, int i3) {
        this.b = i2;
        this.c = i3;
    }

    @Override // com.pinguo.album.opengles.u
    public int getHeight() {
        return this.c;
    }

    @Override // com.pinguo.album.opengles.u
    public int getWidth() {
        return this.b;
    }
}
