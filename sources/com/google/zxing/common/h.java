package com.google.zxing.common;

import com.google.zxing.NotFoundException;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.lang.reflect.Array;
/* compiled from: HybridBinarizer.java */
/* loaded from: classes2.dex */
public final class h extends g {

    /* renamed from: e  reason: collision with root package name */
    private b f4991e;

    public h(com.google.zxing.d dVar) {
        super(dVar);
    }

    private static int[][] e(byte[] bArr, int i2, int i3, int i4, int i5) {
        int i6 = 8;
        int i7 = i5 - 8;
        int i8 = i4 - 8;
        int[][] iArr = (int[][]) Array.newInstance(int.class, i3, i2);
        int i9 = 0;
        while (i9 < i3) {
            int i10 = i9 << 3;
            if (i10 > i7) {
                i10 = i7;
            }
            int i11 = 0;
            while (i11 < i2) {
                int i12 = i11 << 3;
                if (i12 > i8) {
                    i12 = i8;
                }
                int i13 = (i10 * i4) + i12;
                int i14 = 255;
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                while (i15 < i6) {
                    int i18 = i17;
                    int i19 = 0;
                    while (i19 < i6) {
                        int i20 = bArr[i13 + i19] & Draft_75.END_OF_FRAME;
                        i16 += i20;
                        if (i20 < i14) {
                            i14 = i20;
                        }
                        if (i20 > i18) {
                            i18 = i20;
                        }
                        i19++;
                        i6 = 8;
                    }
                    if (i18 - i14 <= 24) {
                        i15++;
                        i13 += i4;
                        i17 = i18;
                        i6 = 8;
                    }
                    while (true) {
                        i15++;
                        i13 += i4;
                        if (i15 < 8) {
                            int i21 = 0;
                            for (int i22 = 8; i21 < i22; i22 = 8) {
                                i16 += bArr[i13 + i21] & Draft_75.END_OF_FRAME;
                                i21++;
                            }
                        }
                    }
                    i15++;
                    i13 += i4;
                    i17 = i18;
                    i6 = 8;
                }
                int i23 = i16 >> 6;
                if (i17 - i14 <= 24) {
                    i23 = i14 / 2;
                    if (i9 > 0 && i11 > 0) {
                        int i24 = i9 - 1;
                        int i25 = i11 - 1;
                        int i26 = ((iArr[i24][i11] + (iArr[i9][i25] * 2)) + iArr[i24][i25]) / 4;
                        if (i14 < i26) {
                            i23 = i26;
                        }
                        iArr[i9][i11] = i23;
                        i11++;
                        i6 = 8;
                    }
                }
                iArr[i9][i11] = i23;
                i11++;
                i6 = 8;
            }
            i9++;
            i6 = 8;
        }
        return iArr;
    }

    private static void f(byte[] bArr, int i2, int i3, int i4, int i5, int[][] iArr, b bVar) {
        int i6 = i5 - 8;
        int i7 = i4 - 8;
        for (int i8 = 0; i8 < i3; i8++) {
            int i9 = i8 << 3;
            int i10 = i9 > i6 ? i6 : i9;
            int g2 = g(i8, 2, i3 - 3);
            for (int i11 = 0; i11 < i2; i11++) {
                int i12 = i11 << 3;
                int i13 = i12 > i7 ? i7 : i12;
                int g3 = g(i11, 2, i2 - 3);
                int i14 = 0;
                for (int i15 = -2; i15 <= 2; i15++) {
                    int[] iArr2 = iArr[g2 + i15];
                    i14 += iArr2[g3 - 2] + iArr2[g3 - 1] + iArr2[g3] + iArr2[g3 + 1] + iArr2[g3 + 2];
                }
                h(bArr, i13, i10, i14 / 25, i4, bVar);
            }
        }
    }

    private static int g(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    private static void h(byte[] bArr, int i2, int i3, int i4, int i5, b bVar) {
        int i6 = (i3 * i5) + i2;
        int i7 = 0;
        while (i7 < 8) {
            for (int i8 = 0; i8 < 8; i8++) {
                if ((bArr[i6 + i8] & 255) <= i4) {
                    bVar.j(i2 + i8, i3 + i7);
                }
            }
            i7++;
            i6 += i5;
        }
    }

    @Override // com.google.zxing.common.g, com.google.zxing.a
    public b a() throws NotFoundException {
        b bVar = this.f4991e;
        if (bVar != null) {
            return bVar;
        }
        com.google.zxing.d b = b();
        int d2 = b.d();
        int a = b.a();
        if (d2 >= 40 && a >= 40) {
            byte[] b2 = b.b();
            int i2 = d2 >> 3;
            if ((d2 & 7) != 0) {
                i2++;
            }
            int i3 = i2;
            int i4 = a >> 3;
            if ((a & 7) != 0) {
                i4++;
            }
            int i5 = i4;
            int[][] e2 = e(b2, i3, i5, d2, a);
            b bVar2 = new b(d2, a);
            f(b2, i3, i5, d2, a, e2, bVar2);
            this.f4991e = bVar2;
        } else {
            this.f4991e = super.a();
        }
        return this.f4991e;
    }
}
