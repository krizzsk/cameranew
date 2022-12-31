package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
/* compiled from: BitMatrixParser.java */
/* loaded from: classes2.dex */
final class a {
    private final com.google.zxing.common.b a;
    private g b;
    private e c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5049d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.google.zxing.common.b bVar) throws FormatException {
        int g2 = bVar.g();
        if (g2 >= 21 && (g2 & 3) == 1) {
            this.a = bVar;
            return;
        }
        throw FormatException.getFormatInstance();
    }

    private int a(int i2, int i3, int i4) {
        return this.f5049d ? this.a.e(i3, i2) : this.a.e(i2, i3) ? (i4 << 1) | 1 : i4 << 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int i2 = 0;
        while (i2 < this.a.i()) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < this.a.g(); i4++) {
                if (this.a.e(i2, i4) != this.a.e(i4, i2)) {
                    this.a.d(i4, i2);
                    this.a.d(i2, i4);
                }
            }
            i2 = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] c() throws FormatException {
        e d2 = d();
        g e2 = e();
        DataMask dataMask = DataMask.values()[d2.c()];
        int g2 = this.a.g();
        dataMask.unmaskBitMatrix(this.a, g2);
        com.google.zxing.common.b a = e2.a();
        byte[] bArr = new byte[e2.h()];
        int i2 = g2 - 1;
        boolean z = true;
        int i3 = i2;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 > 0) {
            if (i3 == 6) {
                i3--;
            }
            for (int i7 = 0; i7 < g2; i7++) {
                int i8 = z ? i2 - i7 : i7;
                for (int i9 = 0; i9 < 2; i9++) {
                    int i10 = i3 - i9;
                    if (!a.e(i10, i8)) {
                        i5++;
                        i6 <<= 1;
                        if (this.a.e(i10, i8)) {
                            i6 |= 1;
                        }
                        if (i5 == 8) {
                            bArr[i4] = (byte) i6;
                            i4++;
                            i5 = 0;
                            i6 = 0;
                        }
                    }
                }
            }
            z = !z;
            i3 -= 2;
        }
        if (i4 == e2.h()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e d() throws FormatException {
        e eVar = this.c;
        if (eVar != null) {
            return eVar;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 6; i4++) {
            i3 = a(i4, 8, i3);
        }
        int a = a(8, 7, a(8, 8, a(7, 8, i3)));
        for (int i5 = 5; i5 >= 0; i5--) {
            a = a(8, i5, a);
        }
        int g2 = this.a.g();
        int i6 = g2 - 7;
        for (int i7 = g2 - 1; i7 >= i6; i7--) {
            i2 = a(8, i7, i2);
        }
        for (int i8 = g2 - 8; i8 < g2; i8++) {
            i2 = a(i8, 8, i2);
        }
        e a2 = e.a(a, i2);
        this.c = a2;
        if (a2 != null) {
            return a2;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g e() throws FormatException {
        g gVar = this.b;
        if (gVar != null) {
            return gVar;
        }
        int g2 = this.a.g();
        int i2 = (g2 - 17) / 4;
        if (i2 <= 6) {
            return g.i(i2);
        }
        int i3 = g2 - 11;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = g2 - 9; i7 >= i3; i7--) {
                i5 = a(i7, i6, i5);
            }
        }
        g c = g.c(i5);
        if (c != null && c.e() == g2) {
            this.b = c;
            return c;
        }
        for (int i8 = 5; i8 >= 0; i8--) {
            for (int i9 = g2 - 9; i9 >= i3; i9--) {
                i4 = a(i8, i9, i4);
            }
        }
        g c2 = g.c(i4);
        if (c2 != null && c2.e() == g2) {
            this.b = c2;
            return c2;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (this.c == null) {
            return;
        }
        DataMask.values()[this.c.c()].unmaskBitMatrix(this.a, this.a.g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(boolean z) {
        this.b = null;
        this.c = null;
        this.f5049d = z;
    }
}
