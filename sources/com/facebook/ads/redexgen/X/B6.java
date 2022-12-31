package com.facebook.ads.redexgen.X;

import android.graphics.Point;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.source.TrackGroup;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
import com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: assets/audience_network.dex */
public final class B6 extends AbstractC1225Uk {
    public static byte[] A02;
    public static String[] A03 = {"1W0E1A", "gmqFy6ZQaP5ka1WITOse6lKCqSKhRNov", "yPEYbIXQTZij2dUvfHyn6qa5Z66I89l5", "Xhoxo0MeXbgag07m9diWTgmUhgioDUlF", "BIkkp", "x2Y7ova5yP2MY4Z3NAONKiEwX", "ON8", "BctZyAj3hw00k98sEs0CoZ2k5"};
    public static final int[] A04;
    @Nullable
    public final HC A00;
    public final AtomicReference<DefaultTrackSelector$Parameters> A01;

    public static String A0C(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 92);
        }
        return new String(copyOfRange);
    }

    public static void A0E() {
        if (A03[6].length() != 3) {
            throw new RuntimeException();
        }
        A03[6] = "oTI";
        A02 = new byte[]{-26, -33, -43};
    }

    static {
        A0E();
        A04 = new int[0];
    }

    public B6() {
        this(null);
    }

    public B6(@Nullable HC hc) {
        this.A00 = hc;
        this.A01 = new AtomicReference<>(DefaultTrackSelector$Parameters.A0J);
    }

    public static int A00(int i2, int i3) {
        if (i2 == -1) {
            return i3 == -1 ? 0 : -1;
        } else if (i3 == -1) {
            return 1;
        } else {
            return i2 - i3;
        }
    }

    public static int A01(int i2, int i3) {
        if (i2 > i3) {
            return 1;
        }
        return i3 > i2 ? -1 : 0;
    }

    public static int A03(TrackGroup trackGroup, int[] iArr, int i2, @Nullable String str, int i3, int i4, int i5, List<Integer> list) {
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            Integer num = list.get(i7);
            if (A03[2].charAt(31) == 'o') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[7] = "3Iv8b3o73oRbqkF65Z5c5dFgz";
            strArr[5] = "e7BsWd0zc9qEfvrmMSkcTfHGf";
            int intValue = num.intValue();
            if (A0L(trackGroup.A01(intValue), str, iArr[intValue], i2, i3, i4, i5)) {
                i6++;
            }
        }
        return i6;
    }

    public static int A04(TrackGroup trackGroup, int[] iArr, H3 h3) {
        int i2 = 0;
        for (int i3 = 0; i3 < trackGroup.A01; i3++) {
            if (A0J(trackGroup.A01(i3), iArr[i3], h3)) {
                i2++;
            }
        }
        return i2;
    }

    public static Point A05(boolean z, int i2, int i3, int i4, int i5) {
        if (z) {
            if ((i4 > i5) != (i2 > i3)) {
                i2 = i3;
                i3 = i2;
            }
        }
        int tempViewportWidth = i4 * i3;
        int i6 = i5 * i2;
        if (A03[2].charAt(31) != 'o') {
            A03[6] = "nfw";
            if (tempViewportWidth >= i6) {
                return new Point(i2, C0923Il.A04(i2 * i5, i4));
            }
            return new Point(C0923Il.A04(i3 * i4, i5), i3);
        }
        throw new RuntimeException();
    }

    @Nullable
    private final HD A06(int i2, TrackGroupArray trackGroupArray, int[][] iArr, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) throws A9 {
        TrackGroup trackGroup = null;
        int trackIndex = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = trackGroupArray.A01;
            if (A03[3].charAt(2) == 'E') {
                throw new RuntimeException();
            }
            A03[3] = "VerUiBJDpf251zcJKkmQW7r5SVlKN9oM";
            if (i4 < i5) {
                TrackGroup A01 = trackGroupArray.A01(i4);
                int[] iArr2 = iArr[i4];
                for (int i6 = 0; i6 < A01.A01; i6++) {
                    if (A0H(iArr2[i6], defaultTrackSelector$Parameters.A0B)) {
                        int i7 = (A01.A01(i6).A0D & 1) != 0 ? 2 : 1;
                        if (A0H(iArr2[i6], false)) {
                            i7 += 1000;
                        }
                        if (i7 > i3) {
                            trackGroup = A01;
                            trackIndex = i6;
                            i3 = i7;
                        }
                    }
                }
                i4++;
            } else if (trackGroup == null) {
                return null;
            } else {
                return new B5(trackGroup, trackIndex);
            }
        }
    }

    @Nullable
    public static HD A07(TrackGroupArray trackGroupArray, int[][] iArr, int requiredAdaptiveSupport, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, HC hc) throws A9 {
        int i2;
        if (defaultTrackSelector$Parameters.A0A) {
            i2 = 24;
        } else {
            i2 = 16;
        }
        boolean z = defaultTrackSelector$Parameters.A09 && (requiredAdaptiveSupport & i2) != 0;
        for (int i3 = 0; i3 < trackGroupArray.A01; i3++) {
            TrackGroup A01 = trackGroupArray.A01(i3);
            int[] A0O = A0O(A01, iArr[i3], z, i2, defaultTrackSelector$Parameters.A03, defaultTrackSelector$Parameters.A02, defaultTrackSelector$Parameters.A01, defaultTrackSelector$Parameters.A06, defaultTrackSelector$Parameters.A05, defaultTrackSelector$Parameters.A0F);
            if (A0O.length > 0) {
                return ((HC) I6.A01(hc)).A4S(A01, A0O);
            }
        }
        return null;
    }

    @Nullable
    private final HD A08(TrackGroupArray trackGroupArray, int[][] iArr, int i2, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, @Nullable HC hc) throws A9 {
        int trackIndex = -1;
        int i3 = -1;
        H4 trackScore = null;
        for (int i4 = 0; i4 < trackGroupArray.A01; i4++) {
            TrackGroup A01 = trackGroupArray.A01(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < A01.A01; i5++) {
                if (A0H(iArr2[i5], defaultTrackSelector$Parameters.A0B)) {
                    H4 h4 = new H4(A01.A01(i5), defaultTrackSelector$Parameters, iArr2[i5]);
                    if (trackScore == null || h4.A00(trackScore) > 0) {
                        i3 = i4;
                        trackIndex = i5;
                        trackScore = h4;
                    }
                }
            }
        }
        if (i3 == -1) {
            return null;
        }
        TrackGroup A012 = trackGroupArray.A01(i3);
        if (!defaultTrackSelector$Parameters.A0D && hc != null) {
            int[] A0N = A0N(A012, iArr[i3], defaultTrackSelector$Parameters.A09);
            if (A0N.length > 0) {
                return hc.A4S(A012, A0N);
            }
        }
        return new B5(A012, trackIndex);
    }

    @Nullable
    private final HD A09(TrackGroupArray trackGroupArray, int[][] iArr, int i2, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, @Nullable HC hc) throws A9 {
        HD hd = null;
        if (!defaultTrackSelector$Parameters.A0D && hc != null) {
            hd = A07(trackGroupArray, iArr, i2, defaultTrackSelector$Parameters, hc);
        }
        if (hd == null) {
            return A0A(trackGroupArray, iArr, defaultTrackSelector$Parameters);
        }
        return hd;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0063, code lost:
        if (r1 <= r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0082, code lost:
        if (r3 <= r2) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c5, code lost:
        if (r1 <= r0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x013f, code lost:
        if (r1 <= r21.A01) goto L37;
     */
    /* JADX WARN: Incorrect condition in loop: B:7:0x0021 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00cf A[SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.facebook.ads.redexgen.X.HD A0A(com.facebook.ads.internal.exoplayer2.source.TrackGroupArray r19, int[][] r20, com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$Parameters r21) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.B6.A0A(com.facebook.ads.internal.exoplayer2.source.TrackGroupArray, int[][], com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$Parameters):com.facebook.ads.redexgen.X.HD");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
        if (r0 != false) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0090 A[SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.facebook.ads.redexgen.X.HD A0B(com.facebook.ads.internal.exoplayer2.source.TrackGroupArray r15, int[][] r16, com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$Parameters r17) throws com.facebook.ads.redexgen.X.A9 {
        /*
            r14 = this;
            r6 = 0
            r5 = 0
            r2 = 0
            r7 = 0
        L4:
            int r0 = r15.A01
            if (r7 >= r0) goto L98
            com.facebook.ads.internal.exoplayer2.source.TrackGroup r4 = r15.A01(r7)
            r13 = r16[r7]
            r3 = 0
        Lf:
            int r0 = r4.A01
            if (r3 >= r0) goto L94
            r1 = r13[r3]
            r10 = r17
            boolean r0 = r10.A0B
            boolean r0 = A0H(r1, r0)
            if (r0 == 0) goto L90
            com.facebook.ads.internal.exoplayer2.Format r8 = r4.A01(r3)
            int r1 = r8.A0D
            int r0 = r10.A00
            r0 = r0 ^ (-1)
            r1 = r1 & r0
            r0 = r1 & 1
            r9 = 0
            r12 = 1
            if (r0 == 0) goto L86
            r11 = 1
        L31:
            r0 = r1 & 2
            if (r0 == 0) goto L84
        L35:
            java.lang.String r0 = r10.A08
            boolean r1 = A0K(r8, r0)
            if (r1 != 0) goto L47
            boolean r0 = r10.A0E
            if (r0 == 0) goto L72
            boolean r0 = A0I(r8)
            if (r0 == 0) goto L72
        L47:
            if (r11 == 0) goto L6c
            r8 = 8
        L4b:
            int r8 = r8 + r1
        L4c:
            r0 = r13[r3]
            boolean r0 = A0H(r0, r9)
            if (r0 == 0) goto L56
            int r8 = r8 + 1000
        L56:
            if (r8 <= r2) goto L90
            r6 = r4
            r5 = r3
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.B6.A03
            r0 = 6
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 3
            if (r1 == r0) goto L88
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L6c:
            if (r12 != 0) goto L70
            r8 = 6
            goto L4b
        L70:
            r8 = 4
            goto L4b
        L72:
            if (r11 == 0) goto L76
            r8 = 3
            goto L4c
        L76:
            if (r12 == 0) goto L90
            java.lang.String r0 = r10.A07
            boolean r0 = A0K(r8, r0)
            if (r0 == 0) goto L82
            r8 = 2
            goto L4c
        L82:
            r8 = 1
            goto L4c
        L84:
            r12 = 0
            goto L35
        L86:
            r11 = 0
            goto L31
        L88:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.B6.A03
            java.lang.String r1 = "ytO6VNlSXI4nyu5127ZVkMBSWij4cMOM"
            r0 = 2
            r2[r0] = r1
            r2 = r8
        L90:
            int r3 = r3 + 1
            goto Lf
        L94:
            int r7 = r7 + 1
            goto L4
        L98:
            if (r6 != 0) goto L9c
            r0 = 0
        L9b:
            return r0
        L9c:
            com.facebook.ads.redexgen.X.B5 r0 = new com.facebook.ads.redexgen.X.B5
            r0.<init>(r6, r5)
            goto L9b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.B6.A0B(com.facebook.ads.internal.exoplayer2.source.TrackGroupArray, int[][], com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$Parameters):com.facebook.ads.redexgen.X.HD");
    }

    public static List<Integer> A0D(TrackGroup trackGroup, int i2, int maxVideoPixelsToRetain, boolean z) {
        ArrayList arrayList = new ArrayList(trackGroup.A01);
        for (int i3 = 0; i3 < trackGroup.A01; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (i2 == Integer.MAX_VALUE || maxVideoPixelsToRetain == Integer.MAX_VALUE) {
            return arrayList;
        }
        int i4 = Integer.MAX_VALUE;
        for (int i5 = 0; i5 < trackGroup.A01; i5++) {
            Format A01 = trackGroup.A01(i5);
            if (A01.A0F > 0) {
                int i6 = A01.A08;
                if (A03[3].charAt(2) == 'E') {
                    throw new RuntimeException();
                }
                A03[2] = "kSz4FX5ZHsEkHeXGD1Cn3cbmsF2hLdtD";
                if (i6 > 0) {
                    Point A05 = A05(z, i2, maxVideoPixelsToRetain, A01.A0F, A01.A08);
                    int i7 = A01.A0F * A01.A08;
                    int videoPixels = A01.A0F;
                    if (videoPixels >= ((int) (A05.x * 0.98f))) {
                        int videoPixels2 = A01.A08;
                        if (videoPixels2 >= ((int) (A05.y * 0.98f)) && i7 < i4) {
                            i4 = i7;
                        }
                    }
                }
            }
        }
        if (i4 != Integer.MAX_VALUE) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                int A0E = trackGroup.A01(((Integer) arrayList.get(size)).intValue()).A0E();
                if (A0E == -1 || A0E > i4) {
                    arrayList.remove(size);
                }
            }
        }
        return arrayList;
    }

    public static void A0F(TrackGroup trackGroup, int[] iArr, int trackIndex, @Nullable String str, int i2, int i3, int i4, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list.get(size).intValue();
            if (!A0L(trackGroup.A01(intValue), str, iArr[intValue], trackIndex, i2, i3, i4)) {
                list.remove(size);
            }
        }
    }

    public static void A0G(HB hb, int[][][] iArr, C0728Ai[] c0728AiArr, HD[] hdArr, int rendererType) {
        if (rendererType == 0) {
            return;
        }
        int i2 = -1;
        int i3 = -1;
        if (A03[1].charAt(3) != 'F') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[4] = "rTjwD";
        strArr[0] = "uX38vm";
        boolean z = true;
        int i4 = 0;
        while (true) {
            boolean z2 = true;
            if (i4 >= hb.A00()) {
                break;
            }
            int A01 = hb.A01(i4);
            HD hd = hdArr[i4];
            if ((A01 == 1 || A01 == 2) && hd != null && A0M(iArr[i4], hb.A02(i4), hd)) {
                if (A01 == 1) {
                    if (i2 != -1) {
                        z = false;
                        break;
                    }
                    i2 = i4;
                } else if (i3 != -1) {
                    z = false;
                    break;
                } else {
                    i3 = i4;
                }
            }
            i4++;
        }
        boolean z3 = z & ((i2 == -1 || i3 == -1) ? false : false);
        if (A03[3].charAt(2) != 'E') {
            String[] strArr2 = A03;
            strArr2[4] = "aY4hR";
            strArr2[0] = "2v7HMH";
            if (!z3) {
                return;
            }
        } else if (!z3) {
            return;
        }
        C0728Ai c0728Ai = new C0728Ai(rendererType);
        c0728AiArr[i2] = c0728Ai;
        c0728AiArr[i3] = c0728Ai;
    }

    public static boolean A0H(int i2, boolean z) {
        int maskedSupport = i2 & 7;
        return maskedSupport == 4 || (z && maskedSupport == 3);
    }

    public static boolean A0I(Format format) {
        return TextUtils.isEmpty(format.A0N) || A0K(format, A0C(0, 3, 21));
    }

    public static boolean A0J(Format format, int i2, H3 h3) {
        if (A0H(i2, false) && format.A05 == h3.A00 && format.A0C == h3.A01) {
            return h3.A02 == null || TextUtils.equals(h3.A02, format.A0O);
        }
        return false;
    }

    public static boolean A0K(Format format, @Nullable String str) {
        return str != null && TextUtils.equals(str, C0923Il.A0L(format.A0N));
    }

    public static boolean A0L(Format format, @Nullable String str, int i2, int i3, int i4, int i5, int i6) {
        if (!A0H(i2, false) || (i2 & i3) == 0) {
            return false;
        }
        if (str == null || C0923Il.A0g(format.A0O, str)) {
            if (format.A0F == -1 || format.A0F <= i4) {
                if (format.A08 == -1 || format.A08 <= i5) {
                    if (format.A04 != -1) {
                        int i7 = format.A04;
                        if (A03[2].charAt(31) == 'o') {
                            throw new RuntimeException();
                        }
                        A03[2] = "FNCbzyr7QyRP3SA06TqNXuxS80zpa9Bi";
                        if (i7 > i6) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean A0M(int[][] iArr, TrackGroupArray trackGroupArray, HD hd) {
        if (hd == null) {
            return false;
        }
        int A00 = trackGroupArray.A00(hd.A7Z());
        if (A03[2].charAt(31) != 'o') {
            A03[1] = "tyUFTMgWRFIbU9oMa0yVOFtav5LFL8C4";
            for (int i2 = 0; i2 < hd.length(); i2++) {
                if ((iArr[A00][hd.A6j(i2)] & 32) != 32) {
                    return false;
                }
            }
            if (A03[2].charAt(31) != 'o') {
                String[] strArr = A03;
                strArr[4] = "AvWfp";
                strArr[0] = "jnm8oH";
                return true;
            }
            A03[3] = "hBflC2WcQfSqXI4XtpzFNLmvHBtesKLi";
            return true;
        }
        throw new RuntimeException();
    }

    public static int[] A0N(TrackGroup trackGroup, int[] iArr, boolean z) {
        int A042;
        int i2 = 0;
        H3 h3 = null;
        HashSet hashSet = new HashSet();
        int configurationCount = 0;
        while (true) {
            if (configurationCount < trackGroup.A01) {
                Format A01 = trackGroup.A01(configurationCount);
                H3 h32 = new H3(A01.A05, A01.A0C, z ? null : A01.A0O);
                String[] strArr = A03;
                if (strArr[4].length() == strArr[0].length()) {
                    break;
                }
                A03[6] = "SWl";
                if (hashSet.add(h32) && (A042 = A04(trackGroup, iArr, h32)) > i2) {
                    h3 = h32;
                    i2 = A042;
                }
                configurationCount++;
            } else if (i2 > 1) {
                int[] adaptiveIndices = new int[i2];
                if (A03[1].charAt(3) == 'F') {
                    A03[2] = "ndqJYBN4kzCrcISGfJ6gLQAVvTseYRAq";
                    int index = 0;
                    for (int i3 = 0; i3 < trackGroup.A01; i3++) {
                        if (A0J(trackGroup.A01(i3), iArr[i3], (H3) I6.A01(h3))) {
                            adaptiveIndices[index] = i3;
                            index++;
                        }
                    }
                    return adaptiveIndices;
                }
            } else {
                return A04;
            }
        }
        throw new RuntimeException();
    }

    public static int[] A0O(TrackGroup trackGroup, int[] iArr, boolean z, int i2, int i3, int i4, int trackIndex, int i5, int i6, boolean z2) {
        int A032;
        if (trackGroup.A01 >= 2) {
            List<Integer> A0D = A0D(trackGroup, i5, i6, z2);
            if (A0D.size() < 2) {
                return A04;
            }
            String str = null;
            if (!z) {
                HashSet hashSet = new HashSet();
                int i7 = 0;
                for (int selectedMimeTypeTrackCount = 0; selectedMimeTypeTrackCount < A0D.size(); selectedMimeTypeTrackCount++) {
                    String str2 = trackGroup.A01(A0D.get(selectedMimeTypeTrackCount).intValue()).A0O;
                    if (hashSet.add(str2) && (A032 = A03(trackGroup, iArr, i2, str2, i3, i4, trackIndex, A0D)) > i7) {
                        if (A03[3].charAt(2) == 'E') {
                            throw new RuntimeException();
                        }
                        String[] strArr = A03;
                        strArr[7] = "YYn4Z0UW1tJYYEwj5MQ7L1Rhi";
                        strArr[5] = "BvRHCOG0R11gnbm1vcetrlVSM";
                        str = str2;
                        i7 = A032;
                    }
                }
            }
            A0F(trackGroup, iArr, i2, str, i3, i4, trackIndex, A0D);
            return A0D.size() < 2 ? A04 : C0923Il.A0j(A0D);
        }
        return A04;
    }

    private final HD[] A0P(HB hb, int[][][] iArr, int[] iArr2, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) throws A9 {
        boolean z;
        int A00 = hb.A00();
        HD[] hdArr = new HD[A00];
        boolean seenVideoRendererWithMappedTracks = false;
        int i2 = 0;
        for (int i3 = 0; i3 < A00; i3++) {
            int A01 = hb.A01(i3);
            if (A03[2].charAt(31) == 'o') {
                throw new RuntimeException();
            }
            A03[2] = "HeTTodjeOHNf6YJV3Oi2xZW4zDR7myJi";
            if (2 == A01) {
                if (i2 == 0) {
                    z = true;
                    hdArr[i3] = A09(hb.A02(i3), iArr[i3], iArr2[i3], defaultTrackSelector$Parameters, this.A00);
                    i2 = hdArr[i3] != null ? 1 : 0;
                } else {
                    z = true;
                }
                if (hb.A02(i3).A01 <= 0) {
                    z = false;
                }
                seenVideoRendererWithMappedTracks |= z;
            }
        }
        boolean z2 = false;
        int i4 = 0;
        if (A03[3].charAt(2) != 'E') {
            A03[2] = "aVwUyHxCeGesw16VUIJPDtFnHPxsnnXC";
            for (int i5 = 0; i5 < A00; i5++) {
                int A012 = hb.A01(i5);
                if (A012 != 1) {
                    if (A012 != 2) {
                        if (A012 != 3) {
                            hdArr[i5] = A06(A012, hb.A02(i5), iArr[i5], defaultTrackSelector$Parameters);
                        } else if (i4 == 0) {
                            hdArr[i5] = A0B(hb.A02(i5), iArr[i5], defaultTrackSelector$Parameters);
                            i4 = hdArr[i5] != null ? 1 : 0;
                        }
                    }
                } else if (!z2) {
                    hdArr[i5] = A08(hb.A02(i5), iArr[i5], iArr2[i5], defaultTrackSelector$Parameters, seenVideoRendererWithMappedTracks ? null : this.A00);
                    z2 = hdArr[i5] != null;
                }
            }
            return hdArr;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1225Uk
    public final Pair<C0728Ai[], HD[]> A0V(HB hb, int[][][] iArr, int[] iArr2) throws A9 {
        DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = this.A01.get();
        int i2 = hb.A00();
        HD[] A0P = A0P(hb, iArr, iArr2, defaultTrackSelector$Parameters);
        for (int i3 = 0; i3 < i2; i3++) {
            if (defaultTrackSelector$Parameters.A06(i3)) {
                A0P[i3] = null;
            } else {
                TrackGroupArray A022 = hb.A02(i3);
                if (defaultTrackSelector$Parameters.A07(i3, A022)) {
                    DefaultTrackSelector$SelectionOverride A05 = defaultTrackSelector$Parameters.A05(i3, A022);
                    if (A05 == null) {
                        A0P[i3] = null;
                    } else if (A05.A01 == 1) {
                        A0P[i3] = new B5(A022.A01(A05.A00), A05.A02[0]);
                    } else {
                        A0P[i3] = ((HC) I6.A01(this.A00)).A4S(A022.A01(A05.A00), A05.A02);
                    }
                }
            }
        }
        C0728Ai[] c0728AiArr = new C0728Ai[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            c0728AiArr[i4] = !defaultTrackSelector$Parameters.A06(i4) && (hb.A01(i4) == 5 || A0P[i4] != null) ? C0728Ai.A01 : null;
        }
        A0G(hb, iArr, c0728AiArr, A0P, defaultTrackSelector$Parameters.A04);
        return Pair.create(c0728AiArr, A0P);
    }
}
