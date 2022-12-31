package com.tapjoy.internal;

import java.util.Arrays;
/* loaded from: classes3.dex */
final class ja extends iu {

    /* renamed from: f  reason: collision with root package name */
    final transient byte[][] f7737f;

    /* renamed from: g  reason: collision with root package name */
    final transient int[] f7738g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ja(ir irVar, int i2) {
        super(null);
        je.a(irVar.b, 0L, i2);
        iy iyVar = irVar.a;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = iyVar.c;
            int i7 = iyVar.b;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                iyVar = iyVar.f7735f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f7737f = new byte[i5];
        this.f7738g = new int[i5 * 2];
        iy iyVar2 = irVar.a;
        int i8 = 0;
        while (i3 < i2) {
            byte[][] bArr = this.f7737f;
            bArr[i8] = iyVar2.a;
            int i9 = iyVar2.c;
            int i10 = iyVar2.b;
            i3 += i9 - i10;
            if (i3 > i2) {
                i3 = i2;
            }
            int[] iArr = this.f7738g;
            iArr[i8] = i3;
            iArr[bArr.length + i8] = i10;
            iyVar2.f7733d = true;
            i8++;
            iyVar2 = iyVar2.f7735f;
        }
    }

    private iu e() {
        return new iu(d());
    }

    @Override // com.tapjoy.internal.iu
    public final String a() {
        return e().a();
    }

    @Override // com.tapjoy.internal.iu
    public final String b() {
        return e().b();
    }

    @Override // com.tapjoy.internal.iu
    public final int c() {
        return this.f7738g[this.f7737f.length - 1];
    }

    @Override // com.tapjoy.internal.iu
    public final byte[] d() {
        int[] iArr = this.f7738g;
        byte[][] bArr = this.f7737f;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr2 = this.f7738g;
            int i4 = iArr2[length + i2];
            int i5 = iArr2[i2];
            System.arraycopy(this.f7737f[i2], i4, bArr2, i3, i5 - i3);
            i2++;
            i3 = i5;
        }
        return bArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005c A[RETURN] */
    @Override // com.tapjoy.internal.iu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r12) {
        /*
            r11 = this;
            r0 = 1
            if (r12 != r11) goto L4
            return r0
        L4:
            boolean r1 = r12 instanceof com.tapjoy.internal.iu
            r2 = 0
            if (r1 == 0) goto L5d
            com.tapjoy.internal.iu r12 = (com.tapjoy.internal.iu) r12
            int r1 = r12.c()
            int r3 = r11.c()
            if (r1 != r3) goto L5d
            int r1 = r11.c()
            int r3 = r11.c()
            int r3 = r3 - r1
            if (r3 >= 0) goto L22
        L20:
            r12 = 0
            goto L5a
        L22:
            int r3 = r11.b(r2)
            r4 = 0
            r5 = 0
        L28:
            if (r1 <= 0) goto L59
            if (r3 != 0) goto L2e
            r6 = 0
            goto L34
        L2e:
            int[] r6 = r11.f7738g
            int r7 = r3 + (-1)
            r6 = r6[r7]
        L34:
            int[] r7 = r11.f7738g
            r7 = r7[r3]
            int r7 = r7 - r6
            int r7 = r7 + r6
            int r7 = r7 - r4
            int r7 = java.lang.Math.min(r1, r7)
            int[] r8 = r11.f7738g
            byte[][] r9 = r11.f7737f
            int r10 = r9.length
            int r10 = r10 + r3
            r8 = r8[r10]
            int r6 = r4 - r6
            int r6 = r6 + r8
            r8 = r9[r3]
            boolean r6 = r12.a(r5, r8, r6, r7)
            if (r6 != 0) goto L53
            goto L20
        L53:
            int r4 = r4 + r7
            int r5 = r5 + r7
            int r1 = r1 - r7
            int r3 = r3 + 1
            goto L28
        L59:
            r12 = 1
        L5a:
            if (r12 == 0) goto L5d
            return r0
        L5d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.ja.equals(java.lang.Object):boolean");
    }

    @Override // com.tapjoy.internal.iu
    public final int hashCode() {
        int i2 = this.f7731d;
        if (i2 != 0) {
            return i2;
        }
        int length = this.f7737f.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < length) {
            byte[] bArr = this.f7737f[i3];
            int[] iArr = this.f7738g;
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
        this.f7731d = i5;
        return i5;
    }

    @Override // com.tapjoy.internal.iu
    public final String toString() {
        return e().toString();
    }

    private int b(int i2) {
        int binarySearch = Arrays.binarySearch(this.f7738g, 0, this.f7737f.length, i2 + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    @Override // com.tapjoy.internal.iu
    public final iu a(int i2, int i3) {
        return e().a(i2, i3);
    }

    @Override // com.tapjoy.internal.iu
    public final byte a(int i2) {
        je.a(this.f7738g[this.f7737f.length - 1], i2, 1L);
        int b = b(i2);
        int i3 = b == 0 ? 0 : this.f7738g[b - 1];
        int[] iArr = this.f7738g;
        byte[][] bArr = this.f7737f;
        return bArr[b][(i2 - i3) + iArr[bArr.length + b]];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tapjoy.internal.iu
    public final void a(ir irVar) {
        int length = this.f7737f.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.f7738g;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            iy iyVar = new iy(this.f7737f[i2], i4, (i4 + i5) - i3);
            iy iyVar2 = irVar.a;
            if (iyVar2 == null) {
                iyVar.f7736g = iyVar;
                iyVar.f7735f = iyVar;
                irVar.a = iyVar;
            } else {
                iyVar2.f7736g.a(iyVar);
            }
            i2++;
            i3 = i5;
        }
        irVar.b += i3;
    }

    @Override // com.tapjoy.internal.iu
    public final boolean a(int i2, byte[] bArr, int i3, int i4) {
        if (i2 < 0 || i2 > c() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int b = b(i2);
        while (i4 > 0) {
            int i5 = b == 0 ? 0 : this.f7738g[b - 1];
            int min = Math.min(i4, ((this.f7738g[b] - i5) + i5) - i2);
            int[] iArr = this.f7738g;
            byte[][] bArr2 = this.f7737f;
            if (!je.a(bArr2[b], (i2 - i5) + iArr[bArr2.length + b], bArr, i3, min)) {
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
