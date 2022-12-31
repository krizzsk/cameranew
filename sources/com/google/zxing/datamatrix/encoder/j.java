package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;
/* compiled from: HighLevelEncoder.java */
/* loaded from: classes2.dex */
public final class j {
    public static int a(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        if (i2 < length) {
            char charAt = charSequence.charAt(i2);
            while (f(charAt) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    charAt = charSequence.charAt(i2);
                }
            }
        }
        return i3;
    }

    public static String b(String str, SymbolShapeHint symbolShapeHint, com.google.zxing.c cVar, com.google.zxing.c cVar2) {
        int i2 = 0;
        g[] gVarArr = {new a(), new c(), new l(), new m(), new f(), new b()};
        h hVar = new h(str);
        hVar.n(symbolShapeHint);
        hVar.l(cVar, cVar2);
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            hVar.r((char) 236);
            hVar.m(2);
            hVar.f5010f += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            hVar.r((char) 237);
            hVar.m(2);
            hVar.f5010f += 7;
        }
        while (hVar.i()) {
            gVarArr[i2].a(hVar);
            if (hVar.e() >= 0) {
                i2 = hVar.e();
                hVar.j();
            }
        }
        int a = hVar.a();
        hVar.p();
        int a2 = hVar.g().a();
        if (a < a2 && i2 != 0 && i2 != 5 && i2 != 4) {
            hVar.r((char) 254);
        }
        StringBuilder b = hVar.b();
        if (b.length() < a2) {
            b.append((char) 129);
        }
        while (b.length() < a2) {
            b.append(o((char) 129, b.length() + 1));
        }
        return hVar.b().toString();
    }

    private static int c(float[] fArr, int[] iArr, int i2, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i3 = 0; i3 < 6; i3++) {
            iArr[i3] = (int) Math.ceil(fArr[i3]);
            int i4 = iArr[i3];
            if (i2 > i4) {
                Arrays.fill(bArr, (byte) 0);
                i2 = i4;
            }
            if (i2 == i4) {
                bArr[i3] = (byte) (bArr[i3] + 1);
            }
        }
        return i2;
    }

    private static int d(byte[] bArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 += bArr[i3];
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(char c) {
        String hexString;
        throw new IllegalArgumentException("Illegal character: " + c + " (0x" + ("0000".substring(0, 4 - hexString.length()) + Integer.toHexString(c)) + ')');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(char c) {
        return c >= '0' && c <= '9';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(char c) {
        return c >= 128 && c <= 255;
    }

    private static boolean h(char c) {
        if (c != ' ') {
            if (c < '0' || c > '9') {
                return c >= 'A' && c <= 'Z';
            }
            return true;
        }
        return true;
    }

    private static boolean i(char c) {
        return c >= ' ' && c <= '^';
    }

    private static boolean j(char c) {
        if (c != ' ') {
            if (c < '0' || c > '9') {
                return c >= 'a' && c <= 'z';
            }
            return true;
        }
        return true;
    }

    private static boolean k(char c) {
        if (m(c) || c == ' ') {
            return true;
        }
        if (c < '0' || c > '9') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }

    private static boolean l(char c) {
        return false;
    }

    private static boolean m(char c) {
        return c == '\r' || c == '*' || c == '>';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(CharSequence charSequence, int i2, int i3) {
        float[] fArr;
        char c;
        if (i2 >= charSequence.length()) {
            return i3;
        }
        if (i3 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i3] = 0.0f;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 + i4;
            if (i5 == charSequence.length()) {
                byte[] bArr = new byte[6];
                int[] iArr = new int[6];
                int c2 = c(fArr, iArr, Integer.MAX_VALUE, bArr);
                int d2 = d(bArr);
                if (iArr[0] == c2) {
                    return 0;
                }
                if (d2 != 1 || bArr[5] <= 0) {
                    if (d2 != 1 || bArr[4] <= 0) {
                        if (d2 != 1 || bArr[2] <= 0) {
                            return (d2 != 1 || bArr[3] <= 0) ? 1 : 3;
                        }
                        return 2;
                    }
                    return 4;
                }
                return 5;
            }
            char charAt = charSequence.charAt(i5);
            i4++;
            if (f(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (g(charAt)) {
                fArr[0] = (float) Math.ceil(fArr[0]);
                fArr[0] = fArr[0] + 2.0f;
            } else {
                fArr[0] = (float) Math.ceil(fArr[0]);
                fArr[0] = fArr[0] + 1.0f;
            }
            if (h(charAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (g(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (j(charAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (g(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (k(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (g(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (i(charAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (g(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (l(charAt)) {
                c = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                c = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i4 >= 4) {
                int[] iArr2 = new int[6];
                byte[] bArr2 = new byte[6];
                c(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                int d3 = d(bArr2);
                if (iArr2[0] < iArr2[c] && iArr2[0] < iArr2[1] && iArr2[0] < iArr2[2] && iArr2[0] < iArr2[3] && iArr2[0] < iArr2[4]) {
                    return 0;
                }
                if (iArr2[5] < iArr2[0] || bArr2[1] + bArr2[2] + bArr2[3] + bArr2[4] == 0) {
                    return 5;
                }
                if (d3 == 1 && bArr2[4] > 0) {
                    return 4;
                }
                if (d3 == 1 && bArr2[2] > 0) {
                    return 2;
                }
                if (d3 == 1 && bArr2[3] > 0) {
                    return 3;
                }
                if (iArr2[1] + 1 < iArr2[0] && iArr2[1] + 1 < iArr2[5] && iArr2[1] + 1 < iArr2[4] && iArr2[1] + 1 < iArr2[2]) {
                    if (iArr2[1] < iArr2[3]) {
                        return 1;
                    }
                    if (iArr2[1] == iArr2[3]) {
                        for (int i6 = i2 + i4 + 1; i6 < charSequence.length(); i6++) {
                            char charAt2 = charSequence.charAt(i6);
                            if (m(charAt2)) {
                                return 3;
                            }
                            if (!k(charAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                }
            }
        }
    }

    private static char o(char c, int i2) {
        int i3 = c + ((i2 * 149) % 253) + 1;
        if (i3 > 254) {
            i3 -= 254;
        }
        return (char) i3;
    }
}
