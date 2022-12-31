package com.google.zxing.k.b;
/* compiled from: Encoder.java */
/* loaded from: classes2.dex */
public final class c {
    private static final int[] a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int[] a(com.google.zxing.common.a aVar, int i2, int i3) {
        int[] iArr = new int[i3];
        int g2 = aVar.g() / i2;
        for (int i4 = 0; i4 < g2; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 |= aVar.f((i4 * i2) + i6) ? 1 << ((i2 - i6) - 1) : 0;
            }
            iArr[i4] = i5;
        }
        return iArr;
    }

    private static void b(com.google.zxing.common.b bVar, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4 += 2) {
            int i5 = i2 - i4;
            int i6 = i5;
            while (true) {
                int i7 = i2 + i4;
                if (i6 <= i7) {
                    bVar.j(i6, i5);
                    bVar.j(i6, i7);
                    bVar.j(i5, i6);
                    bVar.j(i7, i6);
                    i6++;
                }
            }
        }
        int i8 = i2 - i3;
        bVar.j(i8, i8);
        int i9 = i8 + 1;
        bVar.j(i9, i8);
        bVar.j(i8, i9);
        int i10 = i2 + i3;
        bVar.j(i10, i8);
        bVar.j(i10, i9);
        bVar.j(i10, i10 - 1);
    }

    private static void c(com.google.zxing.common.b bVar, boolean z, int i2, com.google.zxing.common.a aVar) {
        int i3 = i2 / 2;
        int i4 = 0;
        if (z) {
            while (i4 < 7) {
                int i5 = (i3 - 3) + i4;
                if (aVar.f(i4)) {
                    bVar.j(i5, i3 - 5);
                }
                if (aVar.f(i4 + 7)) {
                    bVar.j(i3 + 5, i5);
                }
                if (aVar.f(20 - i4)) {
                    bVar.j(i5, i3 + 5);
                }
                if (aVar.f(27 - i4)) {
                    bVar.j(i3 - 5, i5);
                }
                i4++;
            }
            return;
        }
        while (i4 < 10) {
            int i6 = (i3 - 5) + i4 + (i4 / 5);
            if (aVar.f(i4)) {
                bVar.j(i6, i3 - 7);
            }
            if (aVar.f(i4 + 10)) {
                bVar.j(i3 + 7, i6);
            }
            if (aVar.f(29 - i4)) {
                bVar.j(i6, i3 + 7);
            }
            if (aVar.f(39 - i4)) {
                bVar.j(i3 - 7, i6);
            }
            i4++;
        }
    }

    public static a d(byte[] bArr, int i2, int i3) {
        com.google.zxing.common.a aVar;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        com.google.zxing.common.a a2 = new d(bArr).a();
        int g2 = ((a2.g() * i2) / 100) + 11;
        int g3 = a2.g() + g2;
        int i8 = 0;
        int i9 = 1;
        if (i3 != 0) {
            z = i3 < 0;
            i5 = Math.abs(i3);
            if (i5 <= (z ? 4 : 32)) {
                i6 = i(i5, z);
                i4 = a[i5];
                int i10 = i6 - (i6 % i4);
                aVar = h(a2, i4);
                if (aVar.g() + g2 <= i10) {
                    if (z && aVar.g() > (i4 << 6)) {
                        throw new IllegalArgumentException("Data to large for user specified layer");
                    }
                } else {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            } else {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i3)));
            }
        } else {
            com.google.zxing.common.a aVar2 = null;
            int i11 = 0;
            int i12 = 0;
            while (i11 <= 32) {
                boolean z2 = i11 <= 3;
                int i13 = z2 ? i11 + 1 : i11;
                int i14 = i(i13, z2);
                if (g3 <= i14) {
                    if (aVar2 == null || i12 != a[i13]) {
                        int i15 = a[i13];
                        i12 = i15;
                        aVar2 = h(a2, i15);
                    }
                    int i16 = i14 - (i14 % i12);
                    if ((!z2 || aVar2.g() <= (i12 << 6)) && aVar2.g() + g2 <= i16) {
                        aVar = aVar2;
                        i4 = i12;
                        z = z2;
                        i5 = i13;
                        i6 = i14;
                    }
                }
                i11++;
                i8 = 0;
                i9 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        com.google.zxing.common.a e2 = e(aVar, i6, i4);
        int g4 = aVar.g() / i4;
        com.google.zxing.common.a f2 = f(z, i5, g4);
        int i17 = (z ? 11 : 14) + (i5 << 2);
        int[] iArr = new int[i17];
        int i18 = 2;
        if (z) {
            for (int i19 = 0; i19 < i17; i19++) {
                iArr[i19] = i19;
            }
            i7 = i17;
        } else {
            int i20 = i17 / 2;
            i7 = i17 + 1 + (((i20 - 1) / 15) * 2);
            int i21 = i7 / 2;
            for (int i22 = 0; i22 < i20; i22++) {
                int i23 = (i22 / 15) + i22;
                iArr[(i20 - i22) - i9] = (i21 - i23) - 1;
                iArr[i20 + i22] = i23 + i21 + i9;
            }
        }
        com.google.zxing.common.b bVar = new com.google.zxing.common.b(i7);
        int i24 = 0;
        int i25 = 0;
        while (i24 < i5) {
            int i26 = ((i5 - i24) << i18) + (z ? 9 : 12);
            int i27 = 0;
            while (i27 < i26) {
                int i28 = i27 << 1;
                while (i8 < i18) {
                    if (e2.f(i25 + i28 + i8)) {
                        int i29 = i24 << 1;
                        bVar.j(iArr[i29 + i8], iArr[i29 + i27]);
                    }
                    if (e2.f((i26 << 1) + i25 + i28 + i8)) {
                        int i30 = i24 << 1;
                        bVar.j(iArr[i30 + i27], iArr[((i17 - 1) - i30) - i8]);
                    }
                    if (e2.f((i26 << 2) + i25 + i28 + i8)) {
                        int i31 = (i17 - 1) - (i24 << 1);
                        bVar.j(iArr[i31 - i8], iArr[i31 - i27]);
                    }
                    if (e2.f((i26 * 6) + i25 + i28 + i8)) {
                        int i32 = i24 << 1;
                        bVar.j(iArr[((i17 - 1) - i32) - i27], iArr[i32 + i8]);
                    }
                    i8++;
                    i18 = 2;
                }
                i27++;
                i8 = 0;
                i18 = 2;
            }
            i25 += i26 << 3;
            i24++;
            i8 = 0;
            i18 = 2;
        }
        c(bVar, z, i7, f2);
        if (z) {
            b(bVar, i7 / 2, 5);
        } else {
            int i33 = i7 / 2;
            b(bVar, i33, 7);
            int i34 = 0;
            int i35 = 0;
            while (i35 < (i17 / 2) - 1) {
                for (int i36 = i33 & 1; i36 < i7; i36 += 2) {
                    int i37 = i33 - i34;
                    bVar.j(i37, i36);
                    int i38 = i33 + i34;
                    bVar.j(i38, i36);
                    bVar.j(i36, i37);
                    bVar.j(i36, i38);
                }
                i35 += 15;
                i34 += 16;
            }
        }
        a aVar3 = new a();
        aVar3.c(z);
        aVar3.f(i7);
        aVar3.d(i5);
        aVar3.b(g4);
        aVar3.e(bVar);
        return aVar3;
    }

    private static com.google.zxing.common.a e(com.google.zxing.common.a aVar, int i2, int i3) {
        com.google.zxing.common.reedsolomon.d dVar = new com.google.zxing.common.reedsolomon.d(g(i3));
        int i4 = i2 / i3;
        int[] a2 = a(aVar, i3, i4);
        dVar.b(a2, i4 - (aVar.g() / i3));
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        aVar2.c(0, i2 % i3);
        for (int i5 : a2) {
            aVar2.c(i5, i3);
        }
        return aVar2;
    }

    static com.google.zxing.common.a f(boolean z, int i2, int i3) {
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        if (z) {
            aVar.c(i2 - 1, 2);
            aVar.c(i3 - 1, 6);
            return e(aVar, 28, 4);
        }
        aVar.c(i2 - 1, 5);
        aVar.c(i3 - 1, 11);
        return e(aVar, 40, 4);
    }

    private static com.google.zxing.common.reedsolomon.a g(int i2) {
        if (i2 != 4) {
            if (i2 != 6) {
                if (i2 != 8) {
                    if (i2 != 10) {
                        if (i2 == 12) {
                            return com.google.zxing.common.reedsolomon.a.f4998h;
                        }
                        throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i2)));
                    }
                    return com.google.zxing.common.reedsolomon.a.f4999i;
                }
                return com.google.zxing.common.reedsolomon.a.m;
            }
            return com.google.zxing.common.reedsolomon.a.f5000j;
        }
        return com.google.zxing.common.reedsolomon.a.f5001k;
    }

    static com.google.zxing.common.a h(com.google.zxing.common.a aVar, int i2) {
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        int g2 = aVar.g();
        int i3 = (1 << i2) - 2;
        int i4 = 0;
        while (i4 < g2) {
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = i4 + i6;
                if (i7 >= g2 || aVar.f(i7)) {
                    i5 |= 1 << ((i2 - 1) - i6);
                }
            }
            int i8 = i5 & i3;
            if (i8 == i3) {
                aVar2.c(i8, i2);
            } else if (i8 == 0) {
                aVar2.c(i5 | 1, i2);
            } else {
                aVar2.c(i5, i2);
                i4 += i2;
            }
            i4--;
            i4 += i2;
        }
        return aVar2;
    }

    private static int i(int i2, boolean z) {
        return ((z ? 88 : 112) + (i2 << 4)) * i2;
    }
}
