package com.facebook.ads.redexgen.X;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.source.TrackGroup;
/* renamed from: com.facebook.ads.redexgen.X.Uk  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC1225Uk extends HG {
    public static String[] A01 = {"26JblF4b6dorFS8jU2vwriUxZ0G71mwq", "Xnpi2o2sUEOze", "R71e3dTOAhzB09tZHggtqRTS0V3by", "x11tshWAsx1g8", "baPvwG8wSWpB2aFi4", "NgcUJ4cAOsbj9", "II", "FdNrM275eXYBmZtzCUl1db95x7ONP"};
    @Nullable
    public HB A00;

    public abstract Pair<C0728Ai[], HD[]> A0V(HB hb, int[][][] iArr, int[] iArr2) throws A9;

    public static int A0Q(InterfaceC0727Ah[] interfaceC0727AhArr, TrackGroup trackGroup) throws A9 {
        int rendererIndex = interfaceC0727AhArr.length;
        int i2 = 0;
        for (int trackIndex = 0; trackIndex < interfaceC0727AhArr.length; trackIndex++) {
            InterfaceC0727Ah interfaceC0727Ah = interfaceC0727AhArr[trackIndex];
            for (int i3 = 0; i3 < trackGroup.A01; i3++) {
                int formatSupportLevel = interfaceC0727Ah.AEv(trackGroup.A01(i3)) & 7;
                if (formatSupportLevel > i2) {
                    rendererIndex = trackIndex;
                    i2 = formatSupportLevel;
                    if (i2 == 4) {
                        return rendererIndex;
                    }
                }
            }
        }
        return rendererIndex;
    }

    public static int[] A0R(InterfaceC0727Ah interfaceC0727Ah, TrackGroup trackGroup) throws A9 {
        int[] iArr = new int[trackGroup.A01];
        for (int i2 = 0; i2 < trackGroup.A01; i2++) {
            iArr[i2] = interfaceC0727Ah.AEv(trackGroup.A01(i2));
        }
        return iArr;
    }

    public static int[] A0S(InterfaceC0727Ah[] interfaceC0727AhArr) throws A9 {
        int[] iArr = new int[interfaceC0727AhArr.length];
        int i2 = 0;
        while (true) {
            int length = iArr.length;
            String[] strArr = A01;
            String str = strArr[4];
            String str2 = strArr[5];
            int length2 = str.length();
            int i3 = str2.length();
            if (length2 == i3) {
                throw new RuntimeException();
            }
            A01[0] = "xB4ZDOqJN2K9OUw5kZCJNg4ll7dteaQM";
            if (i2 < length) {
                int i4 = interfaceC0727AhArr[i2].AEx();
                iArr[i2] = i4;
                i2++;
            } else {
                return iArr;
            }
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:16:0x005c */
    /* JADX WARN: Incorrect condition in loop: B:4:0x0011 */
    /* JADX WARN: Incorrect condition in loop: B:8:0x0029 */
    @Override // com.facebook.ads.redexgen.X.HG
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.facebook.ads.redexgen.X.HH A0T(com.facebook.ads.redexgen.X.InterfaceC0727Ah[] r12, com.facebook.ads.internal.exoplayer2.source.TrackGroupArray r13) throws com.facebook.ads.redexgen.X.A9 {
        /*
            r11 = this;
            int r0 = r12.length
            int r0 = r0 + 1
            int[] r4 = new int[r0]
            int r0 = r12.length
            int r0 = r0 + 1
            com.facebook.ads.internal.exoplayer2.source.TrackGroup[][] r3 = new com.facebook.ads.internal.exoplayer2.source.TrackGroup[r0]
            int r0 = r12.length
            int r0 = r0 + 1
            int[][][] r9 = new int[r0][]
            r1 = 0
        L10:
            int r0 = r3.length
            if (r1 >= r0) goto L22
            int r0 = r13.A01
            com.facebook.ads.internal.exoplayer2.source.TrackGroup[] r0 = new com.facebook.ads.internal.exoplayer2.source.TrackGroup[r0]
            r3[r1] = r0
            int r0 = r13.A01
            int[][] r0 = new int[r0]
            r9[r1] = r0
            int r1 = r1 + 1
            goto L10
        L22:
            int[] r8 = A0S(r12)
            r7 = 0
        L27:
            int r0 = r13.A01
            if (r7 >= r0) goto L54
            com.facebook.ads.internal.exoplayer2.source.TrackGroup r6 = r13.A01(r7)
            int r5 = A0Q(r12, r6)
            int r0 = r12.length
            if (r5 != r0) goto L4d
            int r0 = r6.A01
            int[] r2 = new int[r0]
        L3a:
            r1 = r4[r5]
            r0 = r3[r5]
            r0[r1] = r6
            r0 = r9[r5]
            r0[r1] = r2
            r0 = r4[r5]
            int r0 = r0 + 1
            r4[r5] = r0
            int r7 = r7 + 1
            goto L27
        L4d:
            r0 = r12[r5]
            int[] r2 = A0R(r0, r6)
            goto L3a
        L54:
            int r0 = r12.length
            com.facebook.ads.internal.exoplayer2.source.TrackGroupArray[] r7 = new com.facebook.ads.internal.exoplayer2.source.TrackGroupArray[r0]
            int r0 = r12.length
            int[] r6 = new int[r0]
            r5 = 0
        L5b:
            int r0 = r12.length
            if (r5 >= r0) goto L84
            r2 = r4[r5]
            r0 = r3[r5]
            java.lang.Object[] r1 = com.facebook.ads.redexgen.X.C0923Il.A0k(r0, r2)
            com.facebook.ads.internal.exoplayer2.source.TrackGroup[] r1 = (com.facebook.ads.internal.exoplayer2.source.TrackGroup[]) r1
            com.facebook.ads.internal.exoplayer2.source.TrackGroupArray r0 = new com.facebook.ads.internal.exoplayer2.source.TrackGroupArray
            r0.<init>(r1)
            r7[r5] = r0
            r0 = r9[r5]
            java.lang.Object[] r0 = com.facebook.ads.redexgen.X.C0923Il.A0k(r0, r2)
            int[][] r0 = (int[][]) r0
            r9[r5] = r0
            r0 = r12[r5]
            int r0 = r0.A7b()
            r6[r5] = r0
            int r5 = r5 + 1
            goto L5b
        L84:
            int r0 = r12.length
            r1 = r4[r0]
            int r0 = r12.length
            r0 = r3[r0]
            java.lang.Object[] r0 = com.facebook.ads.redexgen.X.C0923Il.A0k(r0, r1)
            com.facebook.ads.internal.exoplayer2.source.TrackGroup[] r0 = (com.facebook.ads.internal.exoplayer2.source.TrackGroup[]) r0
            com.facebook.ads.internal.exoplayer2.source.TrackGroupArray r10 = new com.facebook.ads.internal.exoplayer2.source.TrackGroupArray
            r10.<init>(r0)
            com.facebook.ads.redexgen.X.HB r5 = new com.facebook.ads.redexgen.X.HB
            r5.<init>(r6, r7, r8, r9, r10)
            r0 = r11
            android.util.Pair r0 = r0.A0V(r5, r9, r8)
            java.lang.Object r2 = r0.first
            com.facebook.ads.redexgen.X.Ai[] r2 = (com.facebook.ads.redexgen.X.C0728Ai[]) r2
            java.lang.Object r1 = r0.second
            com.facebook.ads.redexgen.X.HD[] r1 = (com.facebook.ads.redexgen.X.HD[]) r1
            com.facebook.ads.redexgen.X.HH r0 = new com.facebook.ads.redexgen.X.HH
            r0.<init>(r2, r1, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AbstractC1225Uk.A0T(com.facebook.ads.redexgen.X.Ah[], com.facebook.ads.internal.exoplayer2.source.TrackGroupArray):com.facebook.ads.redexgen.X.HH");
    }

    @Override // com.facebook.ads.redexgen.X.HG
    public final void A0U(Object obj) {
        this.A00 = (HB) obj;
    }
}
