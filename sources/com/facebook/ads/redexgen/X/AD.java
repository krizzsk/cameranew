package com.facebook.ads.redexgen.X;

import java.util.Iterator;
import java.util.Set;
/* loaded from: assets/audience_network.dex */
public final class AD {
    public static String[] A0C = {"WV1wdoH9jrQVDigahBrbrXyjnekpmiiE", "mIVo7Cnr72P7RKesjBWLJYV7ajvYF70D", "pH5vi4Kbi5SdF2Ft8jCp0yyfmrwCNJ93", "VAiIhwzGtJV", "mutijWrtbdTsRUOKFhZTpXzdiINxdKbV", "iAqM", "YM6GPYhzTMlO14HNxrpVvdDRlTI", "SmN7PcN3RYN"};
    public final int A00;
    public final int A01;
    public final AT A02;
    public final HG A03;
    public final Set<AX> A04;
    public final boolean A05;
    public final boolean A06;
    public final boolean A07;
    public final boolean A08;
    public final boolean A09;
    public final boolean A0A;
    public final boolean A0B;

    public AD(AT at, AT at2, Set<AX> set, HG hg, boolean z, int i2, int i3, boolean z2, boolean z3, boolean z4) {
        this.A02 = at;
        this.A04 = set;
        this.A03 = hg;
        this.A08 = z;
        this.A00 = i2;
        this.A01 = i3;
        this.A09 = z2;
        this.A06 = z3;
        this.A07 = z4 || at2.A00 != at.A00;
        this.A0A = (at2.A03 == at.A03 && at2.A07 == at.A07) ? false : true;
        this.A05 = at2.A08 != at.A08;
        this.A0B = at2.A06 != at.A06;
    }

    public final void A00() {
        if (this.A0A || this.A01 == 0) {
            for (AX ax : this.A04) {
                ax.ACG(this.A02.A03, this.A02.A07, this.A01);
            }
        }
        boolean z = this.A08;
        String[] strArr = A0C;
        if (strArr[1].charAt(12) == strArr[4].charAt(12)) {
            String[] strArr2 = A0C;
            strArr2[3] = "CSJCqnrxZvV";
            strArr2[7] = "Hkj5q7ot6VH";
            if (z) {
                Iterator<AX> it = this.A04.iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    String[] strArr3 = A0C;
                    if (strArr3[0].charAt(22) == strArr3[2].charAt(22)) {
                        String[] strArr4 = A0C;
                        strArr4[1] = "CqJcwx9zuxyuReRUn3Ztwbm9rESV0hnU";
                        strArr4[4] = "BsXcrNWYLVI0RgolRvCIuekTJNQNO1r0";
                        if (!hasNext) {
                            break;
                        }
                        it.next().ABf(this.A00);
                    } else if (!hasNext) {
                        break;
                    } else {
                        it.next().ABf(this.A00);
                    }
                }
            }
            if (this.A0B) {
                this.A03.A0U(this.A02.A06.A02);
                for (AX ax2 : this.A04) {
                    ax2.ACH(this.A02.A05, this.A02.A06.A01);
                }
            }
            boolean z2 = this.A05;
            String[] strArr5 = A0C;
            if (strArr5[1].charAt(12) == strArr5[4].charAt(12)) {
                String[] strArr6 = A0C;
                strArr6[6] = "ZmCtUBpIkW4VOgBlZsMYRrBehzT";
                strArr6[5] = "Qd2F";
                if (z2) {
                    for (AX ax3 : this.A04) {
                        ax3.AB8(this.A02.A08);
                    }
                }
                if (this.A07) {
                    for (AX ax4 : this.A04) {
                        ax4.ABd(this.A06, this.A02.A00);
                    }
                }
                if (this.A09) {
                    for (AX listener : this.A04) {
                        listener.AC2();
                    }
                    return;
                }
                return;
            }
        }
        throw new RuntimeException();
    }
}
