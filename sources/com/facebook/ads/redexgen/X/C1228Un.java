package com.facebook.ads.redexgen.X;

import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Un  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1228Un implements GL {
    public static byte[] A04;
    public final int A00;
    public final List<C1229Uo> A01;
    public final long[] A02;
    public final long[] A03;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 125);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{5};
    }

    public C1228Un(List<C1229Uo> list) {
        this.A01 = list;
        this.A00 = list.size();
        this.A02 = new long[this.A00 * 2];
        for (int i2 = 0; i2 < this.A00; i2++) {
            C1229Uo c1229Uo = list.get(i2);
            int i3 = i2 * 2;
            this.A02[i3] = c1229Uo.A01;
            this.A02[i3 + 1] = c1229Uo.A00;
        }
        long[] jArr = this.A02;
        this.A03 = Arrays.copyOf(jArr, jArr.length);
        Arrays.sort(this.A03);
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final List<GK> A67(long j2) {
        ArrayList arrayList = null;
        C1229Uo cue = null;
        SpannableStringBuilder normalCueTextBuilder = null;
        for (int i2 = 0; i2 < this.A00; i2++) {
            long[] jArr = this.A02;
            if (jArr[i2 * 2] <= j2 && j2 < jArr[(i2 * 2) + 1]) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                C1229Uo c1229Uo = this.A01.get(i2);
                if (c1229Uo.A00()) {
                    if (cue == null) {
                        cue = c1229Uo;
                    } else {
                        String A00 = A00(0, 1, 126);
                        if (normalCueTextBuilder == null) {
                            normalCueTextBuilder = new SpannableStringBuilder();
                            normalCueTextBuilder.append(cue.A0C).append((CharSequence) A00).append(c1229Uo.A0C);
                        } else {
                            normalCueTextBuilder.append((CharSequence) A00).append(c1229Uo.A0C);
                        }
                    }
                } else {
                    arrayList.add(c1229Uo);
                }
            }
        }
        if (normalCueTextBuilder != null) {
            arrayList.add(new C1229Uo(normalCueTextBuilder));
        } else if (cue != null) {
            arrayList.add(cue);
        }
        if (arrayList != null) {
            return arrayList;
        }
        return Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final long A6X(int i2) {
        boolean z = true;
        I6.A03(i2 >= 0);
        if (i2 >= this.A03.length) {
            z = false;
        }
        I6.A03(z);
        return this.A03[i2];
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final int A6Y() {
        return this.A03.length;
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final int A6v(long j2) {
        int A0A = C0923Il.A0A(this.A03, j2, false, false);
        if (A0A < this.A03.length) {
            return A0A;
        }
        return -1;
    }
}
