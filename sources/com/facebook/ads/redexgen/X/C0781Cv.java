package com.facebook.ads.redexgen.X;

import android.util.Pair;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
/* renamed from: com.facebook.ads.redexgen.X.Cv  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0781Cv {
    public static byte[] A00;
    public static String[] A01 = {"vNU1Clptty9spXV3rmNWKqfECA0GCDno", "yQl7wYGB6utTXxK398wXXYrAeYZNPLId", "BVcq1q5Q", "NihUY4HxpsM0GkJJgFchlTfxDOIJFYzw", "lx4TwpHGLs68", "XI1Xq2FkjwcQfgB5bw70GFmYpaxAyyjl", "uRZmXRdJsodI", "Cygx2J1H2ENb6XLRYlHXnR1vUW4XHHOP"};
    public static final int A02;
    public static final int A03;
    public static final int A04;
    public static final int A05;
    public static final int A06;
    public static final int A07;
    public static final int A08;

    public static String A0I(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 2);
        }
        return new String(copyOfRange);
    }

    public static void A0J() {
        A00 = new byte[]{49, 37, 119, 106, 114, 102, 110, 115, 110, 115, 108, 88, 102, 114, 117, 113, 106, 120, 70, 121, 89, 110, 114, 106, 120, 121, 102, 114, 117, 73, 106, 113, 121, 102, 37, -112, -124, -42, -55, -47, -59, -51, -46, -51, -46, -53, -73, -59, -47, -44, -48, -55, -41, -83, -46, -89, -52, -39, -46, -49, -124, 71, 59, -115, Byte.MIN_VALUE, -120, 124, -124, -119, -124, -119, -126, 111, -124, -120, Byte.MIN_VALUE, -114, -113, 124, -120, -117, 95, Byte.MIN_VALUE, -121, -113, 124, 94, -125, 124, -119, -126, Byte.MIN_VALUE, -114, 59, -110, 120, -54, -67, -59, -71, -63, -58, -63, -58, -65, -85, -47, -58, -69, -64, -54, -57, -58, -63, -46, -71, -52, -63, -57, -58, -85, -71, -59, -56, -60, -67, -53, 120, 100, -105, -110, -112, 115, -124, -107, -106, -120, -107, -106, -76, -46, -39, -38, -35, -44, -39, -46, -117, -48, -49, -44, -33, -117, -41, -44, -34, -33, -91, -117, -48, -49, -44, -33, -117, -49, -38, -48, -34, -117, -39, -38, -33, -117, -34, -33, -52, -35, -33, -117, -30, -44, -33, -45, -117, -52, -117, -34, -28, -39, -50, -117, -34, -52, -40, -37, -41, -48, -103, -110, -73, -84, -72, -73, -68, -78, -68, -67, -82, -73, -67, 105, -68, -67, -85, -75, 105, -85, -72, -63, 105, -81, -72, -69, 105, -67, -69, -86, -84, -76, 105, 117, -109, -126, -124, -116, 65, -119, -126, -108, 65, -113, -112, 65, -108, -126, -114, -111, -115, -122, 65, -107, -126, -125, -115, -122, 65, -108, -118, -101, -122, 65, -118, -113, -121, -112, -109, -114, -126, -107, -118, -112, -113, -120, -95, -90, -88, -93, -93, -94, -91, -89, -104, -105, 83, -96, -104, -105, -100, -108, 83, -91, -108, -89, -104, 97, -32, -17, -17, -21, -24, -30, -32, -13, -24, -18, -19, -82, -13, -13, -20, -21, -86, -9, -20, -21, -90, -75, -75, -79, -82, -88, -90, -71, -82, -76, -77, 116, -67, 114, -88, -90, -78, -86, -73, -90, 114, -78, -76, -71, -82, -76, -77, -78, -63, -63, -67, -70, -76, -78, -59, -70, -64, -65, Byte.MIN_VALUE, -55, 126, -66, -63, -123, 126, -76, -74, -78, 126, -121, -127, -119, -89, -74, -74, -78, -81, -87, -89, -70, -81, -75, -76, 117, -66, 115, -77, -74, 122, 115, -68, -70, -70, -101, -86, -86, -90, -93, -99, -101, -82, -93, -87, -88, 105, -78, 103, -85, -81, -93, -99, -91, -82, -93, -89, -97, 103, -82, -78, 109, -95, 124, -112, Byte.MAX_VALUE, -124, -118, 74, 78, -126, -117, -117, -126, -106, -123, -118, -112, 80, -126, -124, 84, -69, -49, -66, -61, -55, -119, -69, -58, -69, -67, -33, -13, -30, -25, -19, -83, -33, -21, -16, -85, -11, -32, 107, Byte.MAX_VALUE, 110, 115, 121, 57, 111, 107, 109, 61, -109, -89, -106, -101, -95, 97, -97, -94, 102, -109, 95, -98, -109, -90, -97, -65, -45, -62, -57, -51, -115, -53, -50, -61, -59, -68, -48, -65, -60, -54, -118, -51, -68, -46, -94, -74, -91, -86, -80, 112, -73, -81, -91, 111, -91, -75, -76, -87, -67, -84, -79, -73, 119, -66, -74, -84, 118, -84, -68, -69, 118, -80, -84, 109, -127, 112, 117, 123, 59, -126, 122, 112, 58, 112, Byte.MIN_VALUE, Byte.MAX_VALUE, 58, 116, 112, 71, 124, 126, 123, 114, 117, 120, 113, 73, 120, 110, 126, -119, -120, -119, 87, -32, -33, -32, -16, -124, -122, -113, -124, -43, -41, -32, -27, -110, -105, -104, -101, -109, 112, -93, -98, -100, -126, -104, -87, -108, 79, -94, -105, -98, -92, -101, -109, 79, -111, -108, 79, -97, -98, -94, -104, -93, -104, -91, -108, 101, 110, 101, 114, -119, -107, -112, -124, 67, -124, -105, -110, -112, 67, -116, -106, 67, -112, -124, -111, -121, -124, -105, -110, -107, -100, -50, -58, -43, -62, -100, -117, -99, -107, -99, -115, -110, -109, 74, -117, -98, -103, -105, 74, -109, -99, 74, -105, -117, -104, -114, -117, -98, -103, -100, -93, -51, -55, -49, -56, -108, -106, -125, -107, -59, -74, -65, -76, 113, -78, -59, -64, -66, 113, -70, -60, 113, -66, -78, -65, -75, -78, -59, -64, -61, -54, -48, -63, -44, -48, -39, -52, -57, -56, -77, -90, -95, -94, -84, 108, 112, -92, -83, -83, -52, -65, -70, -69, -59, -123, -73, -52, -71, -14, -27, -32, -31, -21, -85, -28, -31, -14, -33, -109, -122, -127, -126, -116, 76, -107, 74, -109, -117, -127, 75, -116, -117, 79, 75, -109, -115, 85, -86, -99, -104, -103, -93, 99, -84, 97, -86, -94, -104, 98, -93, -94, 102, 98, -86, -92, 109};
    }

    static {
        A0J();
        A08 = C0923Il.A08(A0I(696, 4, 97));
        A05 = C0923Il.A08(A0I(662, 4, 88));
        A07 = C0923Il.A08(A0I(692, 4, 90));
        A04 = C0923Il.A08(A0I(636, 4, 39));
        A06 = C0923Il.A08(A0I(666, 4, 31));
        A02 = C0923Il.A08(A0I(TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO, 4, 0));
        A03 = C0923Il.A08(A0I(632, 4, 95));
    }

    public static float A00(IV iv, int i2) {
        iv.A0Y(i2 + 8);
        return iv.A0H() / iv.A0H();
    }

    public static int A01(IV iv) {
        int size = iv.A0E();
        int i2 = size & 127;
        while ((size & 128) == 128) {
            size = iv.A0E();
            i2 = (i2 << 7) | (size & 127);
        }
        return i2;
    }

    public static int A02(IV iv) {
        iv.A0Y(16);
        int A082 = iv.A08();
        if (A082 == A05) {
            return 1;
        }
        int trackType = A08;
        if (A01[2].length() != 8) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[0] = "sACqbdB9h4ZaSOP8RBXRhKf5pkODD9Ze";
        strArr[5] = "nfjFHkgcUdXk9ZZxpn0R0spMdbOfBjgH";
        if (A082 == trackType) {
            return 2;
        }
        if (A082 != A07 && A082 != A04 && A082 != A06 && A082 != A02) {
            if (A082 == A03) {
                return 4;
            }
            return -1;
        }
        String[] strArr2 = A01;
        if (strArr2[4].length() != strArr2[6].length()) {
            return 3;
        }
        String[] strArr3 = A01;
        strArr3[0] = "HjSYihfmO4Fjwo0SJsN86rpcIq24412o";
        strArr3[5] = "nDlBCf5sAdyqWE5fn1qZlgrWKnIrwKiA";
        return 3;
    }

    public static int A03(IV iv, int i2, int i3) {
        int A062 = iv.A06();
        while (A062 - i2 < i3) {
            iv.A0Y(A062);
            int A082 = iv.A08();
            I6.A05(A082 > 0, A0I(574, 32, 45));
            if (iv.A08() == AbstractC0776Cq.A0S) {
                return A062;
            }
            A062 += A082;
        }
        return -1;
    }

    public static long A04(IV iv) {
        int fullAtom = 8;
        iv.A0Y(8);
        int version = AbstractC0776Cq.A01(iv.A08());
        if (version != 0) {
            fullAtom = 16;
        }
        iv.A0Z(fullAtom);
        return iv.A0M();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
        throw new java.lang.RuntimeException();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair<long[], long[]> A05(com.facebook.ads.redexgen.X.W7 r9) {
        /*
            if (r9 == 0) goto La
            int r0 = com.facebook.ads.redexgen.X.AbstractC0776Cq.A0O
            com.facebook.ads.redexgen.X.W6 r0 = r9.A07(r0)
            if (r0 != 0) goto L10
        La:
            r0 = 0
            android.util.Pair r0 = android.util.Pair.create(r0, r0)
            return r0
        L10:
            com.facebook.ads.redexgen.X.IV r8 = r0.A00
            r0 = 8
            r8.A0Y(r0)
            int r0 = r8.A08()
            int r7 = com.facebook.ads.redexgen.X.AbstractC0776Cq.A01(r0)
            int r6 = r8.A0H()
            long[] r5 = new long[r6]
            long[] r4 = new long[r6]
            r3 = 0
        L28:
            if (r3 >= r6) goto L6d
            r9 = 1
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C0781Cv.A01
            r0 = 2
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 8
            if (r1 == r0) goto L3e
        L38:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L3e:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0781Cv.A01
            java.lang.String r1 = "n2Qu2qSRpGNWmL1w1m0Jsgn90j2APzEn"
            r0 = 3
            r2[r0] = r1
            if (r7 != r9) goto L68
            long r0 = r8.A0N()
        L4b:
            r5[r3] = r0
            if (r7 != r9) goto L62
            long r0 = r8.A0L()
        L53:
            r4[r3] = r0
            short r0 = r8.A0U()
            if (r0 != r9) goto L86
            r0 = 2
            r8.A0Z(r0)
            int r3 = r3 + 1
            goto L28
        L62:
            int r0 = r8.A08()
            long r0 = (long) r0
            goto L53
        L68:
            long r0 = r8.A0M()
            goto L4b
        L6d:
            android.util.Pair r3 = android.util.Pair.create(r5, r4)
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0781Cv.A01
            r0 = 1
            r1 = r2[r0]
            r0 = 7
            r2 = r2[r0]
            r0 = 19
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L96
            goto L38
        L86:
            r2 = 272(0x110, float:3.81E-43)
            r1 = 23
            r0 = 49
            java.lang.String r1 = A0I(r2, r1, r0)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r1)
            throw r0
        L96:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C0781Cv.A01
            java.lang.String r1 = "0OgbcJvER11tVuU6ktzS5zcploLwLpnU"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "Fpvfvil3v0kwqlJSCQAnqVBmdIeuMsHJ"
            r0 = 5
            r2[r0] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0781Cv.A05(com.facebook.ads.redexgen.X.W7):android.util.Pair");
    }

    public static Pair<Long, String> A06(IV iv) {
        iv.A0Y(8);
        int A012 = AbstractC0776Cq.A01(iv.A08());
        int version = A012 == 0 ? 8 : 16;
        iv.A0Z(version);
        long A0M = iv.A0M();
        int fullAtom = A012 == 0 ? 4 : 8;
        iv.A0Z(fullAtom);
        int A0I = iv.A0I();
        StringBuilder sb = new StringBuilder();
        sb.append(A0I(0, 0, 122));
        int version2 = A0I >> 10;
        sb.append((char) ((version2 & 31) + 96));
        int version3 = A0I >> 5;
        sb.append((char) ((version3 & 31) + 96));
        int version4 = A0I & 31;
        sb.append((char) (version4 + 96));
        return Pair.create(Long.valueOf(A0M), sb.toString());
    }

    public static Pair<String, byte[]> A07(IV iv, int i2) {
        iv.A0Y(i2 + 8 + 4);
        iv.A0Z(1);
        A01(iv);
        iv.A0Z(2);
        int A0E = iv.A0E();
        int flags = A0E & 128;
        if (flags != 0) {
            iv.A0Z(2);
        }
        int flags2 = A0E & 64;
        if (flags2 != 0) {
            int flags3 = iv.A0I();
            iv.A0Z(flags3);
        }
        int flags4 = A0E & 32;
        if (flags4 != 0) {
            iv.A0Z(2);
        }
        iv.A0Z(1);
        A01(iv);
        int A0E2 = iv.A0E();
        String[] strArr = A01;
        String str = strArr[0];
        String str2 = strArr[5];
        int charAt = str.charAt(2);
        int flags5 = str2.charAt(2);
        if (charAt != flags5) {
            String[] strArr2 = A01;
            strArr2[4] = "ipSJ7rerSzX8";
            strArr2[6] = "rVXKHnYgOQNY";
            String A032 = IO.A03(A0E2);
            String mimeType = A0I(482, 10, 92);
            if (!mimeType.equals(A032)) {
                String mimeType2 = A0I(TypedValues.PositionType.TYPE_TRANSITION_EASING, 13, 63);
                if (!mimeType2.equals(A032)) {
                    String mimeType3 = A0I(514, 16, 70);
                    if (!mimeType3.equals(A032)) {
                        iv.A0Z(12);
                        iv.A0Z(1);
                        int A012 = A01(iv);
                        byte[] bArr = new byte[A012];
                        iv.A0c(bArr, 0, A012);
                        return Pair.create(A032, bArr);
                    }
                }
            }
            Pair<String, byte[]> create = Pair.create(A032, null);
            if (A01[3].charAt(8) != 'p') {
                return create;
            }
            String[] strArr3 = A01;
            strArr3[1] = "09LVPMUcXpQFix5jag1XMCG3MLP6JHGE";
            strArr3[7] = "l6DCOVwnZaQMuPJJN9SXx5QHr45WFHuE";
            return create;
        }
        throw new RuntimeException();
    }

    public static Pair<Integer, DC> A08(IV iv, int schemeInformationBoxPosition, int schemeInformationBoxSize) {
        int i2 = schemeInformationBoxPosition + 8;
        int i3 = -1;
        int childAtomSize = 0;
        String str = null;
        Integer num = null;
        while (true) {
            int i4 = i2 - schemeInformationBoxPosition;
            if (A01[3].charAt(8) != 'p') {
                throw new RuntimeException();
            }
            A01[2] = "AMwqROlZ";
            if (i4 < schemeInformationBoxSize) {
                iv.A0Y(i2);
                int A082 = iv.A08();
                int A083 = iv.A08();
                if (A083 == AbstractC0776Cq.A0T) {
                    num = Integer.valueOf(iv.A08());
                } else if (A083 == AbstractC0776Cq.A0z) {
                    iv.A0Z(4);
                    str = iv.A0S(4);
                } else if (A083 == AbstractC0776Cq.A0y) {
                    i3 = i2;
                    childAtomSize = A082;
                }
                i2 += A082;
            } else if (A0I(566, 4, 31).equals(str) || A0I(558, 4, 36).equals(str) || A0I(570, 4, 112).equals(str) || A0I(562, 4, 123).equals(str)) {
                boolean z = true;
                I6.A05(num != null, A0I(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 22, 33));
                I6.A05(i3 != -1, A0I(VideoEdit2Activity.MIN_SCALED_SIZE, 22, 40));
                DC A0D = A0D(iv, i3, childAtomSize, str);
                if (A0D == null) {
                    z = false;
                }
                I6.A05(z, A0I(670, 22, 79));
                return Pair.create(num, A0D);
            } else {
                return null;
            }
        }
    }

    public static Pair<Integer, DC> A09(IV iv, int i2, int i3) {
        Pair<Integer, DC> A082;
        int A062 = iv.A06();
        while (A062 - i2 < i3) {
            iv.A0Y(A062);
            int A083 = iv.A08();
            I6.A05(A083 > 0, A0I(574, 32, 45));
            if (iv.A08() == AbstractC0776Cq.A13 && (A082 = A08(iv, A062, A083)) != null) {
                return A082;
            }
            A062 += A083;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d7, code lost:
        if (r7 != r3) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00db, code lost:
        if (r7 == com.facebook.ads.redexgen.X.AbstractC0776Cq.A0v) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00df, code lost:
        if (r7 == com.facebook.ads.redexgen.X.AbstractC0776Cq.A0w) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e3, code lost:
        if (r7 == com.facebook.ads.redexgen.X.AbstractC0776Cq.A0a) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e7, code lost:
        if (r7 == com.facebook.ads.redexgen.X.AbstractC0776Cq.A14) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00eb, code lost:
        if (r7 == com.facebook.ads.redexgen.X.AbstractC0776Cq.A03) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ed, code lost:
        r3 = com.facebook.ads.redexgen.X.AbstractC0776Cq.A05;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00fc, code lost:
        if (com.facebook.ads.redexgen.X.C0781Cv.A01[3].charAt(8) == 'p') goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00fe, code lost:
        com.facebook.ads.redexgen.X.C0781Cv.A01[2] = "qFwSWgIL";
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0105, code lost:
        if (r7 != r3) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x010f, code lost:
        com.facebook.ads.redexgen.X.C0781Cv.A01[3] = "CalJSZVBpFQrcbMBJJxLaxIn8rHUlaUl";
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0116, code lost:
        if (r7 != r3) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0125, code lost:
        if (r7 != r3) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0128, code lost:
        r3 = com.facebook.ads.redexgen.X.AbstractC0776Cq.A02;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0135, code lost:
        if (com.facebook.ads.redexgen.X.C0781Cv.A01[2].length() == 8) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0139, code lost:
        r2 = com.facebook.ads.redexgen.X.C0781Cv.A01;
        r2[0] = "Ao0TD4kH2iK3OLyPM25FC6RmFi2h7I9b";
        r2[5] = "OuNutSfPZXXgacWVKzm9oLRb1otwM5q4";
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0145, code lost:
        if (r7 == r3) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0147, code lost:
        r3 = com.facebook.ads.redexgen.X.AbstractC0776Cq.A1O;
        r2 = com.facebook.ads.redexgen.X.C0781Cv.A01;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x015b, code lost:
        if (r2[1].charAt(19) == r2[7].charAt(19)) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0162, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0163, code lost:
        r2 = com.facebook.ads.redexgen.X.C0781Cv.A01;
        r2[0] = "AIk7lRaJ8E5MijNPplfsCP53DjqDD31L";
        r2[5] = "UZtf95QrnIyEi2GPpmv3pYGFcGVBr3II";
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x016f, code lost:
        if (r7 == r3) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0173, code lost:
        if (r7 == com.facebook.ads.redexgen.X.AbstractC0776Cq.A1W) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0177, code lost:
        if (r7 == com.facebook.ads.redexgen.X.AbstractC0776Cq.A18) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x017b, code lost:
        if (r7 != com.facebook.ads.redexgen.X.AbstractC0776Cq.A09) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x017d, code lost:
        r6 = r6;
        r8 = r8;
        r9 = r9;
        A0L(r6, r7, r8, r9, r25, r27, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x018b, code lost:
        if (r7 != com.facebook.ads.redexgen.X.AbstractC0776Cq.A0A) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x018d, code lost:
        r7 = java.lang.Integer.toString(r25);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x019c, code lost:
        if (com.facebook.ads.redexgen.X.C0781Cv.A01[2].length() == 8) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x019e, code lost:
        r14.A02 = com.facebook.ads.internal.exoplayer2.Format.A0B(r7, A0I(315, 27, 67), null, -1, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01b2, code lost:
        r2 = com.facebook.ads.redexgen.X.C0781Cv.A01;
        r2[4] = "I4VfvCwCFlYX";
        r2[6] = "JqrGNuQTdpXg";
        r14.A02 = com.facebook.ads.internal.exoplayer2.Format.A0B(r7, A0I(315, 27, 67), null, -1, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.facebook.ads.redexgen.X.C0779Ct A0A(com.facebook.ads.redexgen.X.IV r24, int r25, int r26, java.lang.String r27, com.facebook.ads.internal.exoplayer2.drm.DrmInitData r28, boolean r29) throws com.facebook.ads.redexgen.X.AS {
        /*
            Method dump skipped, instructions count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0781Cv.A0A(com.facebook.ads.redexgen.X.IV, int, int, java.lang.String, com.facebook.ads.internal.exoplayer2.drm.DrmInitData, boolean):com.facebook.ads.redexgen.X.Ct");
    }

    public static C0780Cu A0B(IV iv) {
        long A0M;
        int a11;
        iv.A0Y(8);
        int a00 = AbstractC0776Cq.A01(iv.A08());
        int version = a00 == 0 ? 8 : 16;
        iv.A0Z(version);
        int A082 = iv.A08();
        iv.A0Z(4);
        int i2 = 1;
        int A062 = iv.A06();
        int fullAtom = a00 == 0 ? 4 : 8;
        int a01 = 0;
        while (true) {
            if (a01 >= fullAtom) {
                break;
            }
            int version2 = A062 + a01;
            if (iv.A00[version2] != -1) {
                i2 = 0;
                break;
            }
            a01++;
        }
        if (i2 != 0) {
            iv.A0Z(fullAtom);
            A0M = -9223372036854775807L;
        } else {
            A0M = a00 == 0 ? iv.A0M() : iv.A0N();
            int fixedOne = (A0M > 0L ? 1 : (A0M == 0L ? 0 : -1));
            if (fixedOne == 0) {
                A0M = -9223372036854775807L;
            }
        }
        iv.A0Z(16);
        int fullAtom2 = iv.A08();
        int a002 = iv.A08();
        iv.A0Z(4);
        int trackId = iv.A08();
        int durationPosition = iv.A08();
        if (fullAtom2 == 0 && a002 == 65536) {
            int fixedOne2 = -65536;
            if (trackId == fixedOne2 && durationPosition == 0) {
                a11 = 90;
                return new C0780Cu(A082, A0M, a11);
            }
        }
        if (fullAtom2 == 0) {
            int durationByteCount = -65536;
            String[] strArr = A01;
            String str = strArr[4];
            String str2 = strArr[6];
            int length = str.length();
            int fixedOne3 = str2.length();
            if (length != fixedOne3) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "i5DrkfhddIOc";
            strArr2[6] = "TqiRE9mqRyND";
            if (a002 == durationByteCount && trackId == 65536 && durationPosition == 0) {
                a11 = BaseBlurEffect.ROTATION_270;
                return new C0780Cu(A082, A0M, a11);
            }
        }
        int fixedOne4 = -65536;
        if (fullAtom2 == fixedOne4 && a002 == 0 && trackId == 0) {
            int fixedOne5 = -65536;
            if (durationPosition == fixedOne5) {
                a11 = BaseBlurEffect.ROTATION_180;
                return new C0780Cu(A082, A0M, a11);
            }
        }
        a11 = 0;
        return new C0780Cu(A082, A0M, a11);
    }

    public static DB A0C(W7 w7, W6 w6, long j2, DrmInitData drmInitData, boolean z, boolean z2) throws AS {
        long A0F;
        int i2;
        int i3;
        int i4;
        long j3 = j2;
        W7 A062 = w7.A06(AbstractC0776Cq.A0d);
        int A022 = A02(A062.A07(AbstractC0776Cq.A0V).A00);
        if (A022 == -1) {
            return null;
        }
        W6 A072 = w7.A07(AbstractC0776Cq.A1J);
        if (A01[3].charAt(8) != 'p') {
            throw new RuntimeException();
        }
        A01[2] = "QWUsjPBg";
        C0780Cu A0B = A0B(A072.A00);
        if (j3 == -9223372036854775807L) {
            j3 = A0B.A02;
        }
        long A042 = A04(w6.A00);
        if (j3 == -9223372036854775807L) {
            A0F = -9223372036854775807L;
        } else {
            A0F = C0923Il.A0F(j3, 1000000L, A042);
        }
        W7 A063 = A062.A06(AbstractC0776Cq.A0h).A06(AbstractC0776Cq.A16);
        Pair<Long, String> A064 = A06(A062.A07(AbstractC0776Cq.A0c).A00);
        IV iv = A063.A07(AbstractC0776Cq.A1A).A00;
        i2 = A0B.A00;
        i3 = A0B.A01;
        C0779Ct A0A = A0A(iv, i2, i3, (String) A064.second, drmInitData, z2);
        long[] editListDurations = null;
        long[] jArr = null;
        if (!z) {
            Pair<long[], long[]> A052 = A05(w7.A06(AbstractC0776Cq.A0N));
            editListDurations = (long[]) A052.first;
            jArr = (long[]) A052.second;
        }
        if (A0A.A02 != null) {
            i4 = A0B.A00;
            return new DB(i4, A022, ((Long) A064.first).longValue(), A042, A0F, A0A.A02, A0A.A01, A0A.A03, A0A.A00, editListDurations, jArr);
        }
        return null;
    }

    public static DC A0D(IV iv, int childPosition, int i2, String str) {
        int constantIvSize = childPosition + 8;
        while (constantIvSize - childPosition < i2) {
            iv.A0Y(constantIvSize);
            int defaultCryptByteBlock = iv.A08();
            if (iv.A08() == AbstractC0776Cq.A1G) {
                int version = AbstractC0776Cq.A01(iv.A08());
                boolean z = true;
                iv.A0Z(1);
                int i3 = 0;
                int i4 = 0;
                if (version == 0) {
                    iv.A0Z(1);
                } else {
                    int defaultSkipByteBlock = iv.A0E();
                    int patternByte = defaultSkipByteBlock & 240;
                    i3 = patternByte >> 4;
                    i4 = defaultSkipByteBlock & 15;
                }
                int version2 = iv.A0E();
                if (version2 != 1) {
                    z = false;
                }
                int A0E = iv.A0E();
                byte[] bArr = new byte[16];
                int defaultPerSampleIvSize = bArr.length;
                iv.A0c(bArr, 0, defaultPerSampleIvSize);
                byte[] bArr2 = null;
                if (z && A0E == 0) {
                    int A0E2 = iv.A0E();
                    bArr2 = new byte[A0E2];
                    iv.A0c(bArr2, 0, A0E2);
                    if (A01[2].length() != 8) {
                        throw new RuntimeException();
                    }
                    A01[2] = "N18HcU44";
                }
                return new DC(z, str, A0E, bArr, i3, i4, bArr2);
            }
            constantIvSize += defaultCryptByteBlock;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x0385, code lost:
        if (r11 != 0) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x03a6, code lost:
        if (r11 <= 0) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x03aa, code lost:
        if (r5 > 2147483647L) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x03ac, code lost:
        r1 = (int) r3;
        r44.A00 = r1;
        r1 = (int) r5;
        r44.A01 = r1;
        com.facebook.ads.redexgen.X.C0923Il.A0a(r13, 1000000, r0.A06);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x03cb, code lost:
        return new com.facebook.ads.redexgen.X.DE(r42, r19, r20, r18, r13, r21, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x03d3, code lost:
        if (r11 <= 0) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x03e2, code lost:
        if (r11 != 0) goto L121;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0209  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.facebook.ads.redexgen.X.DE A0E(com.facebook.ads.redexgen.X.DB r42, com.facebook.ads.redexgen.X.W7 r43, com.facebook.ads.redexgen.X.CT r44) throws com.facebook.ads.redexgen.X.AS {
        /*
            Method dump skipped, instructions count: 1443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0781Cv.A0E(com.facebook.ads.redexgen.X.DB, com.facebook.ads.redexgen.X.W7, com.facebook.ads.redexgen.X.CT):com.facebook.ads.redexgen.X.DE");
    }

    public static Metadata A0F(W6 w6, boolean z) {
        if (z) {
            return null;
        }
        IV iv = w6.A00;
        iv.A0Y(8);
        while (iv.A04() >= 8) {
            int A062 = iv.A06();
            int A082 = iv.A08();
            int A083 = iv.A08();
            int atomType = AbstractC0776Cq.A0g;
            if (A083 == atomType) {
                iv.A0Y(A062);
                return A0H(iv, A062 + A082);
            }
            int atomType2 = A082 - 8;
            iv.A0Z(atomType2);
        }
        return null;
    }

    public static Metadata A0G(IV iv, int i2) {
        iv.A0Z(8);
        ArrayList arrayList = new ArrayList();
        while (iv.A06() < i2) {
            Metadata.Entry A012 = D3.A01(iv);
            if (A012 != null) {
                arrayList.add(A012);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static Metadata A0H(IV iv, int i2) {
        iv.A0Z(12);
        while (iv.A06() < i2) {
            int A062 = iv.A06();
            int A082 = iv.A08();
            int A083 = iv.A08();
            int atomType = AbstractC0776Cq.A0Z;
            if (A083 == atomType) {
                iv.A0Y(A062);
                return A0G(iv, A062 + A082);
            }
            int atomType2 = A082 - 8;
            iv.A0Z(atomType2);
        }
        return null;
    }

    public static void A0K(IV iv, int i2, int i3, int i4, int i5, int width, DrmInitData drmInitData, C0779Ct c0779Ct, int childPosition) throws AS {
        DrmInitData drmInitData2 = drmInitData;
        int stereoMode = i2;
        iv.A0Y(i3 + 8 + 8);
        iv.A0Z(16);
        int A0I = iv.A0I();
        int A0I2 = iv.A0I();
        boolean z = false;
        float f2 = 1.0f;
        iv.A0Z(50);
        int A062 = iv.A06();
        int height = AbstractC0776Cq.A0R;
        if (stereoMode == height) {
            Pair<Integer, DC> A09 = A09(iv, i3, i4);
            if (A09 != null) {
                stereoMode = ((Integer) A09.first).intValue();
                if (drmInitData2 == null) {
                    drmInitData2 = null;
                } else {
                    drmInitData2 = drmInitData2.A02(((DC) A09.second).A02);
                }
                c0779Ct.A03[childPosition] = (DC) A09.second;
            }
            iv.A0Y(A062);
        }
        List<byte[]> list = null;
        String str = null;
        byte[] bArr = null;
        if (A01[2].length() != 8) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[4] = "nt1AbbZdLf7H";
        strArr[6] = "te59XVvfeUPr";
        int i6 = -1;
        while (A062 - i3 < i4) {
            iv.A0Y(A062);
            int A063 = iv.A06();
            int A082 = iv.A08();
            if (A082 == 0 && iv.A06() - i3 == i4) {
                break;
            }
            I6.A05(A082 > 0, A0I(574, 32, 45));
            int A083 = iv.A08();
            if (A083 == AbstractC0776Cq.A08) {
                I6.A04(str == null);
                str = A0I(710, 9, 84);
                iv.A0Y(A063 + 8);
                C0925In A002 = C0925In.A00(iv);
                list = A002.A04;
                c0779Ct.A00 = A002.A02;
                if (!z) {
                    f2 = A002.A00;
                }
            } else if (A083 == AbstractC0776Cq.A0Y) {
                I6.A04(str == null);
                str = A0I(719, 10, 122);
                iv.A0Y(A063 + 8);
                C0929It A003 = C0929It.A00(iv);
                list = A003.A01;
                c0779Ct.A00 = A003.A00;
            } else if (A083 == AbstractC0776Cq.A1U) {
                I6.A04(str == null);
                str = stereoMode == AbstractC0776Cq.A1S ? A0I(729, 19, 27) : A0I(748, 19, 50);
            } else if (A083 == AbstractC0776Cq.A0D) {
                I6.A04(str == null);
                if (A01[3].charAt(8) != 'p') {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[4] = "qKPn33WXRD1J";
                strArr2[6] = "UtAkzKHIBavs";
                str = A0I(700, 10, 59);
            } else if (A083 == AbstractC0776Cq.A0S) {
                I6.A04(str == null);
                Pair<String, byte[]> A072 = A07(iv, A063);
                str = (String) A072.first;
                list = Collections.singletonList(A072.second);
            } else if (A083 == AbstractC0776Cq.A0p) {
                f2 = A00(iv, A063);
                z = true;
            } else if (A083 == AbstractC0776Cq.A1F) {
                bArr = A0O(iv, A063, A082);
            } else if (A083 == AbstractC0776Cq.A15) {
                int A0E = iv.A0E();
                iv.A0Z(3);
                if (A0E == 0) {
                    int A0E2 = iv.A0E();
                    if (A0E2 == 0) {
                        i6 = 0;
                    } else if (A0E2 == 1) {
                        i6 = 1;
                    } else if (A0E2 != 2) {
                        if (A0E2 == 3) {
                            i6 = 3;
                        }
                    } else {
                        i6 = 2;
                    }
                }
            }
            A062 += A082;
        }
        if (str == null) {
            return;
        }
        c0779Ct.A02 = Format.A04(Integer.toString(i5), str, null, -1, -1, A0I, A0I2, -1.0f, list, width, f2, bArr, i6, null, drmInitData2);
    }

    public static void A0L(IV iv, int i2, int i3, int i4, int i5, String str, C0779Ct c0779Ct) throws AS {
        String A0I;
        iv.A0Y(i3 + 8 + 8);
        List list = null;
        long j2 = LocationRequestCompat.PASSIVE_INTERVAL;
        if (i2 == AbstractC0776Cq.A02) {
            A0I = A0I(295, 20, 125);
        } else if (i2 == AbstractC0776Cq.A1O) {
            A0I = A0I(388, 28, 56);
            int i6 = (i4 - 8) - 8;
            byte[] bArr = new byte[i6];
            iv.A0c(bArr, 0, i6);
            list = Collections.singletonList(bArr);
        } else if (i2 == AbstractC0776Cq.A1W) {
            A0I = A0I(367, 21, 68);
        } else if (i2 == AbstractC0776Cq.A18) {
            A0I = A0I(295, 20, 125);
            j2 = 0;
        } else if (i2 == AbstractC0776Cq.A09) {
            A0I = A0I(342, 25, 79);
            c0779Ct.A01 = 1;
        } else {
            throw new IllegalStateException();
        }
        c0779Ct.A02 = Format.A09(Integer.toString(i5), A0I, null, -1, 0, str, -1, null, j2, list);
    }

    public static void A0M(IV iv, int i2, int i3, int i4, int channelCount, String str, boolean z, DrmInitData drmInitData, C0779Ct c0779Ct, int i5) throws AS {
        int childAtomType;
        int childPosition;
        int A032;
        DrmInitData drmInitData2 = drmInitData;
        int i6 = i2;
        iv.A0Y(i3 + 8 + 8);
        int i7 = 0;
        if (z) {
            i7 = iv.A0I();
            iv.A0Z(6);
        } else {
            iv.A0Z(8);
        }
        if (i7 == 0 || i7 == 1) {
            childAtomType = iv.A0I();
            iv.A0Z(6);
            childPosition = iv.A0F();
            if (i7 == 1) {
                iv.A0Z(16);
            }
        } else if (i7 == 2) {
            iv.A0Z(16);
            childPosition = (int) Math.round(iv.A03());
            childAtomType = iv.A0H();
            iv.A0Z(20);
        } else {
            return;
        }
        int atomType = iv.A06();
        if (i6 == AbstractC0776Cq.A0Q) {
            Pair<Integer, DC> A09 = A09(iv, i3, i4);
            if (A09 != null) {
                i6 = ((Integer) A09.first).intValue();
                if (drmInitData2 == null) {
                    drmInitData2 = null;
                } else {
                    Object obj = A09.second;
                    String[] strArr = A01;
                    String str2 = strArr[1];
                    String str3 = strArr[7];
                    int sampleRate = str2.charAt(19);
                    if (sampleRate == str3.charAt(19)) {
                        A01[3] = "pOqul1QRpDZUg5bU2yQQaQp61y123VtO";
                        drmInitData2 = drmInitData2.A02(((DC) obj).A02);
                    }
                    throw new RuntimeException();
                }
                c0779Ct.A03[i5] = (DC) A09.second;
            }
            iv.A0Y(atomType);
        }
        String str4 = null;
        if (i6 == AbstractC0776Cq.A04) {
            str4 = A0I(426, 9, 31);
        } else {
            int sampleRate2 = AbstractC0776Cq.A0M;
            if (i6 == sampleRate2) {
                str4 = A0I(457, 10, 8);
            } else {
                int sampleRate3 = AbstractC0776Cq.A0I;
                if (i6 == sampleRate3) {
                    str4 = A0I(TypedValues.PositionType.TYPE_TRANSITION_EASING, 13, 63);
                } else {
                    int sampleRate4 = AbstractC0776Cq.A0K;
                    if (i6 != sampleRate4) {
                        int sampleRate5 = AbstractC0776Cq.A0L;
                        if (i6 != sampleRate5) {
                            int sampleRate6 = AbstractC0776Cq.A0J;
                            if (i6 == sampleRate6) {
                                str4 = A0I(530, 28, 10);
                            } else {
                                int sampleRate7 = AbstractC0776Cq.A0v;
                                if (i6 == sampleRate7) {
                                    str4 = A0I(TypedValues.CycleType.TYPE_PATH_ROTATE, 10, 25);
                                } else {
                                    int sampleRate8 = AbstractC0776Cq.A0w;
                                    if (i6 == sampleRate8) {
                                        str4 = A0I(445, 12, 124);
                                    } else {
                                        int sampleRate9 = AbstractC0776Cq.A0a;
                                        if (i6 != sampleRate9) {
                                            int sampleRate10 = AbstractC0776Cq.A14;
                                            if (i6 != sampleRate10) {
                                                int sampleRate11 = AbstractC0776Cq.A03;
                                                if (i6 == sampleRate11) {
                                                    str4 = A0I(482, 10, 92);
                                                } else {
                                                    int sampleRate12 = AbstractC0776Cq.A05;
                                                    if (i6 == sampleRate12) {
                                                        str4 = A0I(435, 10, 88);
                                                    }
                                                }
                                            }
                                        }
                                        str4 = A0I(492, 9, 89);
                                    }
                                }
                            }
                        }
                    }
                    str4 = A0I(514, 16, 70);
                }
            }
        }
        byte[] bArr = null;
        while (atomType - i3 < i4) {
            iv.A0Y(atomType);
            int A082 = iv.A08();
            I6.A05(A082 > 0, A0I(574, 32, 45));
            int A083 = iv.A08();
            if (A083 == AbstractC0776Cq.A0S || (z && A083 == AbstractC0776Cq.A1V)) {
                if (A083 == AbstractC0776Cq.A0S) {
                    A032 = atomType;
                } else {
                    A032 = A03(iv, atomType, A082);
                }
                if (A032 != -1) {
                    Pair<String, byte[]> A072 = A07(iv, A032);
                    str4 = (String) A072.first;
                    bArr = (byte[]) A072.second;
                    if (A0I(467, 15, 48).equals(str4)) {
                        Pair<Integer, Integer> A033 = IA.A03(bArr);
                        childPosition = ((Integer) A033.first).intValue();
                        childAtomType = ((Integer) A033.second).intValue();
                    }
                }
            } else if (A083 == AbstractC0776Cq.A0E) {
                int i8 = atomType + 8;
                if (A01[3].charAt(8) != 'p') {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[0] = "HYOwJoQ2L6umAwimTza29CMlFS3ISf2h";
                strArr2[5] = "FglgDO1LYQ1bVlWfctdCtrgF4dzfBOT4";
                iv.A0Y(i8);
                c0779Ct.A02 = C0742Ax.A07(iv, Integer.toString(channelCount), str, drmInitData2);
            } else if (A083 == AbstractC0776Cq.A0H) {
                iv.A0Y(atomType + 8);
                c0779Ct.A02 = C0742Ax.A08(iv, Integer.toString(channelCount), str, drmInitData2);
            } else if (A083 == AbstractC0776Cq.A0G) {
                c0779Ct.A02 = Format.A07(Integer.toString(channelCount), str4, null, -1, -1, childAtomType, childPosition, null, drmInitData2, 0, str);
            } else if (A083 == AbstractC0776Cq.A05) {
                bArr = new byte[A082];
                iv.A0Y(atomType);
                iv.A0c(bArr, 0, A082);
            }
            atomType += A082;
        }
        if (c0779Ct.A02 != null || str4 == null) {
            return;
        }
        int i9 = A0I(492, 9, 89).equals(str4) ? 2 : -1;
        String mimeType = Integer.toString(channelCount);
        c0779Ct.A02 = Format.A06(mimeType, str4, null, -1, -1, childAtomType, childPosition, i9, bArr != null ? Collections.singletonList(bArr) : null, drmInitData2, 0, str);
    }

    public static boolean A0N(long[] jArr, long j2, long j3, long j4) {
        int length = jArr.length - 1;
        int latestDelayIndex = C0923Il.A06(3, 0, length);
        return jArr[0] <= j3 && j3 < jArr[latestDelayIndex] && jArr[C0923Il.A06(jArr.length - 3, 0, length)] < j4 && j4 <= j2;
    }

    public static byte[] A0O(IV iv, int i2, int i3) {
        int i4 = i2 + 8;
        while (i4 - i2 < i3) {
            iv.A0Y(i4);
            int A082 = iv.A08();
            if (iv.A08() == AbstractC0776Cq.A0q) {
                return Arrays.copyOfRange(iv.A00, i4, i4 + A082);
            }
            i4 += A082;
        }
        return null;
    }
}
