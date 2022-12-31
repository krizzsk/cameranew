package com.bytedance.sdk.a.a;

import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SegmentedByteString.java */
/* loaded from: classes.dex */
public final class q extends f {

    /* renamed from: f  reason: collision with root package name */
    final transient byte[][] f850f;

    /* renamed from: g  reason: collision with root package name */
    final transient int[] f851g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(c cVar, int i2) {
        super(null);
        u.a(cVar.b, 0L, i2);
        o oVar = cVar.a;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = oVar.c;
            int i7 = oVar.b;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                oVar = oVar.f848f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f850f = new byte[i5];
        this.f851g = new int[i5 * 2];
        o oVar2 = cVar.a;
        int i8 = 0;
        while (i3 < i2) {
            byte[][] bArr = this.f850f;
            bArr[i8] = oVar2.a;
            int i9 = oVar2.c;
            int i10 = oVar2.b;
            i3 += i9 - i10;
            if (i3 > i2) {
                i3 = i2;
            }
            int[] iArr = this.f851g;
            iArr[i8] = i3;
            iArr[bArr.length + i8] = i10;
            oVar2.f846d = true;
            i8++;
            oVar2 = oVar2.f848f;
        }
    }

    private f i() {
        return new f(h());
    }

    @Override // com.bytedance.sdk.a.a.f
    public String a() {
        return i().a();
    }

    @Override // com.bytedance.sdk.a.a.f
    public String b() {
        return i().b();
    }

    @Override // com.bytedance.sdk.a.a.f
    public f c() {
        return i().c();
    }

    @Override // com.bytedance.sdk.a.a.f
    public f d() {
        return i().d();
    }

    @Override // com.bytedance.sdk.a.a.f
    public String e() {
        return i().e();
    }

    @Override // com.bytedance.sdk.a.a.f
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.g() == g() && a(0, fVar, 0, g())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.a.a.f
    public f f() {
        return i().f();
    }

    @Override // com.bytedance.sdk.a.a.f
    public int g() {
        return this.f851g[this.f850f.length - 1];
    }

    @Override // com.bytedance.sdk.a.a.f
    public byte[] h() {
        int[] iArr = this.f851g;
        byte[][] bArr = this.f850f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr2 = this.f851g;
            int i4 = iArr2[length + i2];
            int i5 = iArr2[i2];
            System.arraycopy(this.f850f[i2], i4, bArr2, i3, i5 - i3);
            i2++;
            i3 = i5;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.a.a.f
    public int hashCode() {
        int i2 = this.f841d;
        if (i2 != 0) {
            return i2;
        }
        int length = this.f850f.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < length) {
            byte[] bArr = this.f850f[i3];
            int[] iArr = this.f851g;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            int i8 = (i7 - i4) + i6;
            while (i6 < i8) {
                i5 = (i5 * 31) + bArr[i6];
                i6++;
            }
            i3++;
            i4 = i7;
        }
        this.f841d = i5;
        return i5;
    }

    @Override // com.bytedance.sdk.a.a.f
    public String toString() {
        return i().toString();
    }

    private int b(int i2) {
        int binarySearch = Arrays.binarySearch(this.f851g, 0, this.f850f.length, i2 + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    @Override // com.bytedance.sdk.a.a.f
    public f a(int i2, int i3) {
        return i().a(i2, i3);
    }

    @Override // com.bytedance.sdk.a.a.f
    public byte a(int i2) {
        u.a(this.f851g[this.f850f.length - 1], i2, 1L);
        int b = b(i2);
        int i3 = b == 0 ? 0 : this.f851g[b - 1];
        int[] iArr = this.f851g;
        byte[][] bArr = this.f850f;
        return bArr[b][(i2 - i3) + iArr[bArr.length + b]];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.sdk.a.a.f
    public void a(c cVar) {
        int length = this.f850f.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.f851g;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            o oVar = new o(this.f850f[i2], i4, (i4 + i5) - i3, true, false);
            o oVar2 = cVar.a;
            if (oVar2 == null) {
                oVar.f849g = oVar;
                oVar.f848f = oVar;
                cVar.a = oVar;
            } else {
                oVar2.f849g.a(oVar);
            }
            i2++;
            i3 = i5;
        }
        cVar.b += i3;
    }

    @Override // com.bytedance.sdk.a.a.f
    public boolean a(int i2, f fVar, int i3, int i4) {
        if (i2 < 0 || i2 > g() - i4) {
            return false;
        }
        int b = b(i2);
        while (i4 > 0) {
            int i5 = b == 0 ? 0 : this.f851g[b - 1];
            int min = Math.min(i4, ((this.f851g[b] - i5) + i5) - i2);
            int[] iArr = this.f851g;
            byte[][] bArr = this.f850f;
            if (!fVar.a(i3, bArr[b], (i2 - i5) + iArr[bArr.length + b], min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            b++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.a.a.f
    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        if (i2 < 0 || i2 > g() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int b = b(i2);
        while (i4 > 0) {
            int i5 = b == 0 ? 0 : this.f851g[b - 1];
            int min = Math.min(i4, ((this.f851g[b] - i5) + i5) - i2);
            int[] iArr = this.f851g;
            byte[][] bArr2 = this.f850f;
            if (!u.a(bArr2[b], (i2 - i5) + iArr[bArr2.length + b], bArr, i3, min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            b++;
        }
        return true;
    }
}
