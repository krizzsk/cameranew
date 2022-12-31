package com.google.zxing.n.c;
/* compiled from: MaskUtil.java */
/* loaded from: classes2.dex */
final class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(b bVar) {
        return b(bVar, true) + b(bVar, false);
    }

    private static int b(b bVar, boolean z) {
        int d2 = z ? bVar.d() : bVar.e();
        int e2 = z ? bVar.e() : bVar.d();
        byte[][] c = bVar.c();
        int i2 = 0;
        for (int i3 = 0; i3 < d2; i3++) {
            byte b = -1;
            int i4 = 0;
            for (int i5 = 0; i5 < e2; i5++) {
                byte b2 = z ? c[i3][i5] : c[i5][i3];
                if (b2 == b) {
                    i4++;
                } else {
                    if (i4 >= 5) {
                        i2 += (i4 - 5) + 3;
                    }
                    b = b2;
                    i4 = 1;
                }
            }
            if (i4 >= 5) {
                i2 += (i4 - 5) + 3;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(b bVar) {
        byte[][] c = bVar.c();
        int e2 = bVar.e();
        int d2 = bVar.d();
        int i2 = 0;
        for (int i3 = 0; i3 < d2 - 1; i3++) {
            byte[] bArr = c[i3];
            int i4 = 0;
            while (i4 < e2 - 1) {
                byte b = bArr[i4];
                int i5 = i4 + 1;
                if (b == bArr[i5]) {
                    int i6 = i3 + 1;
                    if (b == c[i6][i4] && b == c[i6][i5]) {
                        i2++;
                    }
                }
                i4 = i5;
            }
        }
        return i2 * 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(b bVar) {
        byte[][] c = bVar.c();
        int e2 = bVar.e();
        int d2 = bVar.d();
        int i2 = 0;
        for (int i3 = 0; i3 < d2; i3++) {
            for (int i4 = 0; i4 < e2; i4++) {
                byte[] bArr = c[i3];
                int i5 = i4 + 6;
                if (i5 < e2 && bArr[i4] == 1 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 1 && bArr[i4 + 3] == 1 && bArr[i4 + 4] == 1 && bArr[i4 + 5] == 0 && bArr[i5] == 1 && (g(bArr, i4 - 4, i4) || g(bArr, i4 + 7, i4 + 11))) {
                    i2++;
                }
                int i6 = i3 + 6;
                if (i6 < d2 && c[i3][i4] == 1 && c[i3 + 1][i4] == 0 && c[i3 + 2][i4] == 1 && c[i3 + 3][i4] == 1 && c[i3 + 4][i4] == 1 && c[i3 + 5][i4] == 0 && c[i6][i4] == 1 && (h(c, i4, i3 - 4, i3) || h(c, i4, i3 + 7, i3 + 11))) {
                    i2++;
                }
            }
        }
        return i2 * 40;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(b bVar) {
        byte[][] c = bVar.c();
        int e2 = bVar.e();
        int d2 = bVar.d();
        int i2 = 0;
        for (int i3 = 0; i3 < d2; i3++) {
            byte[] bArr = c[i3];
            for (int i4 = 0; i4 < e2; i4++) {
                if (bArr[i4] == 1) {
                    i2++;
                }
            }
        }
        int d3 = bVar.d() * bVar.e();
        return ((Math.abs((i2 << 1) - d3) * 10) / d3) * 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean f(int i2, int i3, int i4) {
        int i5;
        int i6;
        switch (i2) {
            case 0:
                i4 += i3;
                i5 = i4 & 1;
                break;
            case 1:
                i5 = i4 & 1;
                break;
            case 2:
                i5 = i3 % 3;
                break;
            case 3:
                i5 = (i4 + i3) % 3;
                break;
            case 4:
                i4 /= 2;
                i3 /= 3;
                i4 += i3;
                i5 = i4 & 1;
                break;
            case 5:
                int i7 = i4 * i3;
                i5 = (i7 & 1) + (i7 % 3);
                break;
            case 6:
                int i8 = i4 * i3;
                i6 = (i8 & 1) + (i8 % 3);
                i5 = i6 & 1;
                break;
            case 7:
                i6 = ((i4 * i3) % 3) + ((i4 + i3) & 1);
                i5 = i6 & 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid mask pattern: ".concat(String.valueOf(i2)));
        }
        return i5 == 0;
    }

    private static boolean g(byte[] bArr, int i2, int i3) {
        int min = Math.min(i3, bArr.length);
        for (int max = Math.max(i2, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean h(byte[][] bArr, int i2, int i3, int i4) {
        int min = Math.min(i4, bArr.length);
        for (int max = Math.max(i3, 0); max < min; max++) {
            if (bArr[max][i2] == 1) {
                return false;
            }
        }
        return true;
    }
}
