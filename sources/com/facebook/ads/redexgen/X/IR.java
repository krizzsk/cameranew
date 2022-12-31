package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class IR {
    public static byte[] A00;
    public static int[] A01;
    public static String[] A02 = {"Oi30oJFxUMFG0gOFP1qEoKnGUzBDTsvx", "3WD4gW2GQkEI5AwBfxSAXddooip3O", "Ouz028YKvSlJVOERB46zGmLFjnusBt99", "zuSd86snyfkH6Kt688AXpDWJmpjjYjYh", "jm5obH6VrXyDYReHZwz8l0mhz55kc4yf", "71eZjkBm8iWWJxdGvDt2NXp", "W8ZvrObejWqz7a9mktO8s2uWHHxOtI0w", "Nv5C13AVolnSAeqab8n4y7TwRlreXIzh"};
    public static final byte[] A03;
    public static final float[] A04;
    public static final Object A05;

    public static String A07(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 77);
        }
        return new String(copyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{-4, 15, 26, 3, 28, 23, 34, 3, 34, 23, 26, -41, -16, -25, -6, -14, -25, -27, -10, -25, -26, -94, -29, -11, -14, -25, -27, -10, -31, -12, -29, -10, -21, -15, -31, -21, -26, -27, -94, -8, -29, -18, -9, -25, -68, -94, -9, -22, -27, -26, -16, -80, -30, -9, -28, 7, -6, -11, -10, 0, -64, -7, -10, 7, -12};
    }

    static {
        A08();
        A03 = new byte[]{0, 0, 0, 1};
        A04 = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
        A05 = new Object();
        A01 = new int[10];
    }

    public static int A00(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 126) >> 1;
    }

    public static int A01(byte[] bArr, int i2) {
        return bArr[i2 + 3] & 31;
    }

    public static int A02(byte[] bArr, int position) {
        int position2;
        synchronized (A05) {
            int i2 = 0;
            int scratchEscapeCount = 0;
            while (i2 < position) {
                i2 = A03(bArr, i2, position);
                if (i2 < position) {
                    if (A01.length <= scratchEscapeCount) {
                        A01 = Arrays.copyOf(A01, A01.length * 2);
                    }
                    A01[scratchEscapeCount] = i2;
                    i2 += 3;
                    scratchEscapeCount++;
                }
            }
            position2 = position - scratchEscapeCount;
            String[] strArr = A02;
            if (strArr[0].charAt(3) != strArr[2].charAt(3)) {
                throw new RuntimeException();
            }
            A02[1] = "ghc1n9RTDSO0Z4i69kgOEipuot9Zj";
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < scratchEscapeCount; i5++) {
                int unescapedPosition = A01[i5] - i3;
                System.arraycopy(bArr, i3, bArr, i4, unescapedPosition);
                int i6 = i4 + unescapedPosition;
                int copyLength = i6 + 1;
                bArr[i6] = 0;
                i4 = copyLength + 1;
                bArr[copyLength] = 0;
                i3 += unescapedPosition + 3;
            }
            int remainingLength = position2 - i4;
            System.arraycopy(bArr, i3, bArr, i4, remainingLength);
        }
        return position2;
    }

    public static int A03(byte[] bArr, int i2, int i3) {
        while (i2 < i3 - 2) {
            if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 3) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0169, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x016b, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x016f, code lost:
        if (r11[1] == false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0175, code lost:
        if (r8[r10 - 1] != 1) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0177, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0179, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        if (r11 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
        r6 = r11[0];
        r5 = com.facebook.ads.redexgen.X.IR.A02;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
        if (r5[7].charAt(7) == r5[4].charAt(7)) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0063, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0064, code lost:
        if (r11 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
        r5 = com.facebook.ads.redexgen.X.IR.A02;
        r5[6] = "55fmxhOEMutKpKC77r4Md8gvEpVf5AJr";
        r5[3] = "C8cbl0pwE6ZZ2ZiTcRq9FxMeDjV9Xwky";
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
        if (r6 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0075, code lost:
        A0B(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007a, code lost:
        return r9 - 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007b, code lost:
        if (r3 <= 1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007f, code lost:
        if (r11[1] == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0083, code lost:
        if (r8[r9] != 1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
        A0B(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008a, code lost:
        return r9 - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008b, code lost:
        if (r3 <= 2) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008f, code lost:
        if (r11[2] == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0093, code lost:
        if (r8[r9] != 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0099, code lost:
        if (r8[r9 + 1] != 1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009b, code lost:
        A0B(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a0, code lost:
        return r9 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a1, code lost:
        r5 = r10 - 1;
        r6 = com.facebook.ads.redexgen.X.IR.A02;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b5, code lost:
        if (r6[6].charAt(21) == r6[3].charAt(21)) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b7, code lost:
        r6 = com.facebook.ads.redexgen.X.IR.A02;
        r6[6] = "uktgRDQdtpFh8EbCos18fWUkW81B3r6L";
        r6[3] = "mrDteKziaJnLJGchN7K4iHB0p5nXZEGM";
        r4 = r9 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c5, code lost:
        if (r4 >= r5) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00cb, code lost:
        if ((r8[r4] & 254) == 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00cd, code lost:
        r4 = r4 + 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d4, code lost:
        if (r8[r4 - 2] != 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00da, code lost:
        if (r8[r4 - 1] != 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00de, code lost:
        if (r8[r4] != 1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00e0, code lost:
        if (r11 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e2, code lost:
        A0B(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00e5, code lost:
        r3 = r4 - 2;
        r2 = com.facebook.ads.redexgen.X.IR.A02;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f9, code lost:
        if (r2[6].charAt(21) == r2[3].charAt(21)) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00fb, code lost:
        r2 = com.facebook.ads.redexgen.X.IR.A02;
        r2[7] = "R0jBdFAV67GondLg32AWi8zsE1yw1KkW";
        r2[4] = "2wkvt5tVRPNRTL1bJFfqOEJwxkS69Blm";
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0107, code lost:
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0108, code lost:
        r4 = r4 - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x010b, code lost:
        r4 = r9 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0111, code lost:
        if (r11 == null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0113, code lost:
        if (r3 <= 2) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0119, code lost:
        if (r8[r10 - 3] != 0) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x011f, code lost:
        if (r8[r10 - 2] != 0) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0125, code lost:
        if (r8[r10 - 1] != 1) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0127, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0128, code lost:
        r11[0] = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x012a, code lost:
        if (r3 <= 1) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0130, code lost:
        if (r8[r10 - 2] != 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0136, code lost:
        if (r8[r10 - 1] != 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0138, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0139, code lost:
        r11[1] = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x013f, code lost:
        if (r8[r10 - 1] != 0) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0141, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0142, code lost:
        r11[2] = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0144, code lost:
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0145, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0149, code lost:
        if (r11[2] == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x014f, code lost:
        if (r8[r10 - 1] != 0) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0151, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0153, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0155, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0157, code lost:
        if (r3 != 2) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x015b, code lost:
        if (r11[2] == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0161, code lost:
        if (r8[r10 - 2] != 0) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0167, code lost:
        if (r8[r10 - 1] != 1) goto L101;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int A04(byte[] r8, int r9, int r10, boolean[] r11) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.IR.A04(byte[], int, int, boolean[]):int");
    }

    public static IP A05(byte[] bArr, int i2, int i3) {
        IW iw = new IW(bArr, i2, i3);
        iw.A07(8);
        int picParameterSetId = iw.A04();
        int A042 = iw.A04();
        iw.A06();
        boolean bottomFieldPicOrderInFramePresentFlag = iw.A0A();
        return new IP(picParameterSetId, A042, bottomFieldPicOrderInFramePresentFlag);
    }

    public static IQ A06(byte[] bArr, int i2, int i3) {
        int frameCropBottomOffset;
        int cropUnitX;
        IW iw = new IW(bArr, i2, i3);
        iw.A07(8);
        int A052 = iw.A05(8);
        iw.A07(16);
        int sarWidth = iw.A04();
        int frameHeight = 1;
        boolean z = false;
        if (A052 == 100 || A052 == 110 || A052 == 122 || A052 == 244 || A052 == 44 || A052 == 83 || A052 == 86 || A052 == 118 || A052 == 128 || A052 == 138) {
            frameHeight = iw.A04();
            if (frameHeight == 3) {
                z = iw.A0A();
            }
            iw.A04();
            iw.A04();
            iw.A06();
            if (iw.A0A()) {
                int i4 = frameHeight != 3 ? 8 : 12;
                int i5 = 0;
                while (i5 < i4) {
                    if (iw.A0A()) {
                        int seqParameterSetId = i5 < 6 ? 16 : 64;
                        A09(iw, seqParameterSetId);
                    }
                    i5++;
                }
            }
        }
        int seqParameterSetId2 = iw.A04();
        int i6 = seqParameterSetId2 + 4;
        int A042 = iw.A04();
        int i7 = 0;
        boolean z2 = false;
        if (A042 == 0) {
            int picOrderCntType = iw.A04();
            i7 = picOrderCntType + 4;
        } else if (A042 == 1) {
            z2 = iw.A0A();
            iw.A03();
            iw.A03();
            int cropUnitX2 = iw.A04();
            long j2 = cropUnitX2;
            for (int i8 = 0; i8 < j2; i8++) {
                iw.A04();
            }
        } else {
            int frameWidth = A02[1].length();
            if (frameWidth != 29) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[0] = "gg30aCps8xaKqlQpqNwqV8MpUTOLFqGh";
            strArr[2] = "6dq0Mx0u8Kgv53YJdcFQMlotDlRuazjf";
        }
        iw.A04();
        iw.A06();
        int A043 = iw.A04() + 1;
        int picWidthInMbs = iw.A04();
        int i9 = picWidthInMbs + 1;
        boolean A0A = iw.A0A();
        int picHeightInMapUnits = 2 - (A0A ? 1 : 0);
        int frameHeightInMbs = picHeightInMapUnits * i9;
        if (!A0A) {
            iw.A06();
        }
        iw.A06();
        int i10 = A043 * 16;
        int i11 = frameHeightInMbs * 16;
        if (iw.A0A()) {
            int A044 = iw.A04();
            int A045 = iw.A04();
            int A046 = iw.A04();
            int A047 = iw.A04();
            if (frameHeight == 0) {
                frameCropBottomOffset = 1;
                cropUnitX = 2 - (A0A ? 1 : 0);
            } else {
                frameCropBottomOffset = frameHeight == 3 ? 1 : 2;
                int i12 = frameHeight == 1 ? 2 : 1;
                int cropUnitX3 = 2 - (A0A ? 1 : 0);
                cropUnitX = cropUnitX3 * i12;
            }
            i10 -= (A044 + A045) * frameCropBottomOffset;
            i11 -= (A046 + A047) * cropUnitX;
        }
        float f2 = 1.0f;
        boolean A0A2 = iw.A0A();
        String[] strArr2 = A02;
        String str = strArr2[0];
        String str2 = strArr2[2];
        int frameWidth2 = str.charAt(3);
        int frameHeight2 = str2.charAt(3);
        if (frameWidth2 == frameHeight2) {
            String[] strArr3 = A02;
            strArr3[6] = "jcRzMhbBY3Dw1JTLjGKCGc6YaVOjENSo";
            strArr3[3] = "o4pmI9swvtrYdLR0BRHjmVJPNciV1YNp";
            if (A0A2) {
                boolean A0A3 = iw.A0A();
                String[] strArr4 = A02;
                String str3 = strArr4[0];
                String str4 = strArr4[2];
                int frameWidth3 = str3.charAt(3);
                if (frameWidth3 == str4.charAt(3)) {
                    String[] strArr5 = A02;
                    strArr5[0] = "nxo01JuHYgIdSih3CNMvKr0vsuD4ByKM";
                    strArr5[2] = "Ktm0TZ4NHFdoOw88agihQWJn0ILc0Ki9";
                    if (A0A3) {
                        int A053 = iw.A05(8);
                        if (A053 == 255) {
                            int aspectRatioIdc = iw.A05(16);
                            int picOrderCntLsbLength = iw.A05(16);
                            if (aspectRatioIdc != 0 && picOrderCntLsbLength != 0) {
                                f2 = aspectRatioIdc / picOrderCntLsbLength;
                            }
                        } else {
                            float[] fArr = A04;
                            int sarHeight = fArr.length;
                            if (A053 < sarHeight) {
                                f2 = fArr[A053];
                            } else {
                                Log.w(A07(0, 11, 97), A07(11, 35, 53) + A053);
                            }
                        }
                    }
                }
            }
            return new IQ(sarWidth, i10, i11, f2, z, A0A, i6, A042, i7, z2);
        }
        throw new RuntimeException();
    }

    public static void A09(IW iw, int nextScale) {
        int i2 = 8;
        int deltaScale = 8;
        for (int i3 = 0; i3 < nextScale; i3++) {
            if (deltaScale != 0) {
                int deltaScale2 = iw.A03();
                deltaScale = ((deltaScale2 + i2) + 256) % 256;
            }
            if (deltaScale != 0) {
                i2 = deltaScale;
            }
        }
    }

    public static void A0A(ByteBuffer byteBuffer) {
        int consecutiveZeros = byteBuffer.position();
        int offset = 0;
        for (int value = 0; value + 1 < consecutiveZeros; value++) {
            int i2 = byteBuffer.get(value) & Draft_75.END_OF_FRAME;
            if (offset == 3) {
                if (i2 == 1 && (byteBuffer.get(value + 1) & 31) == 7) {
                    ByteBuffer duplicate = byteBuffer.duplicate();
                    duplicate.position(value - 3);
                    duplicate.limit(consecutiveZeros);
                    byteBuffer.position(0);
                    byteBuffer.put(duplicate);
                    return;
                }
            } else if (i2 == 0) {
                offset++;
            }
            if (i2 != 0) {
                offset = 0;
            }
        }
        byteBuffer.clear();
        if (A02[1].length() != 29) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[7] = "LhexrLoV7v0KAfJEyFTOZZKZaNSS1gs0";
        strArr[4] = "gpIVcqUVkpQz0S61taD9WNDesiV6owqm";
    }

    public static void A0B(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static boolean A0C(String str, byte b) {
        if (A07(46, 9, 52).equals(str) && (b & 31) == 6) {
            return true;
        }
        return A07(55, 10, 68).equals(str) && ((b & 126) >> 1) == 39;
    }
}
