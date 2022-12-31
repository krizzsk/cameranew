package com.bytedance.sdk.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Segment.java */
/* loaded from: classes.dex */
public final class o {
    final byte[] a;
    int b;
    int c;

    /* renamed from: d  reason: collision with root package name */
    boolean f846d;

    /* renamed from: e  reason: collision with root package name */
    boolean f847e;

    /* renamed from: f  reason: collision with root package name */
    o f848f;

    /* renamed from: g  reason: collision with root package name */
    o f849g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o() {
        this.a = new byte[8192];
        this.f847e = true;
        this.f846d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o a() {
        this.f846d = true;
        return new o(this.a, this.b, this.c, true, false);
    }

    public final o b() {
        o oVar = this.f848f;
        o oVar2 = oVar != this ? oVar : null;
        o oVar3 = this.f849g;
        oVar3.f848f = oVar;
        this.f848f.f849g = oVar3;
        this.f848f = null;
        this.f849g = null;
        return oVar2;
    }

    public final void c() {
        o oVar = this.f849g;
        if (oVar != this) {
            if (oVar.f847e) {
                int i2 = this.c - this.b;
                if (i2 > (8192 - oVar.c) + (oVar.f846d ? 0 : oVar.b)) {
                    return;
                }
                a(oVar, i2);
                b();
                p.a(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public final o a(o oVar) {
        oVar.f849g = this;
        oVar.f848f = this.f848f;
        this.f848f.f849g = oVar;
        this.f848f = oVar;
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.a = bArr;
        this.b = i2;
        this.c = i3;
        this.f846d = z;
        this.f847e = z2;
    }

    public final o a(int i2) {
        o a;
        if (i2 > 0 && i2 <= this.c - this.b) {
            if (i2 >= 1024) {
                a = a();
            } else {
                a = p.a();
                System.arraycopy(this.a, this.b, a.a, 0, i2);
            }
            a.c = a.b + i2;
            this.b += i2;
            this.f849g.a(a);
            return a;
        }
        throw new IllegalArgumentException();
    }

    public final void a(o oVar, int i2) {
        if (oVar.f847e) {
            int i3 = oVar.c;
            if (i3 + i2 > 8192) {
                if (!oVar.f846d) {
                    int i4 = oVar.b;
                    if ((i3 + i2) - i4 <= 8192) {
                        byte[] bArr = oVar.a;
                        System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
                        oVar.c -= oVar.b;
                        oVar.b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.a, this.b, oVar.a, oVar.c, i2);
            oVar.c += i2;
            this.b += i2;
            return;
        }
        throw new IllegalArgumentException();
    }
}
