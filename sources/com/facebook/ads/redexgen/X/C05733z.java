package com.facebook.ads.redexgen.X;

import android.view.View;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.3z  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C05733z {
    public static byte[] A05;
    public int A00;
    public int A01;
    public boolean A02;
    public boolean A03;
    public final /* synthetic */ C1469be A04;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 124);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{Draft_75.CR, 1, 76, 98, 78, 78, 83, 69, 72, 79, 64, 85, 68, 28, 111, 99, 46, 15, 34, 58, 44, 54, 55, 5, 49, 44, 46, 6, 45, 39, 126, 91, 87, 26, 33, 22, 27, 30, 19, 74, 116, 91, 86, 93, 90, 71, 124, 91, 83, 90, 78, 88, 101, 90, 70, 92, 65, 92, 90, 91, 8};
    }

    public C05733z(C1469be c1469be) {
        this.A04 = c1469be;
        A03();
    }

    public final void A02() {
        int A0A;
        if (this.A02) {
            A0A = this.A04.A04.A07();
        } else {
            A0A = this.A04.A04.A0A();
        }
        this.A00 = A0A;
    }

    public final void A03() {
        this.A01 = -1;
        this.A00 = Integer.MIN_VALUE;
        this.A02 = false;
        this.A03 = false;
    }

    public final void A04(View view) {
        if (this.A02) {
            this.A00 = this.A04.A04.A0C(view) + this.A04.A04.A05();
        } else {
            this.A00 = this.A04.A04.A0F(view);
        }
        this.A01 = this.A04.A0p(view);
    }

    public final void A05(View view) {
        int estimatedEnd = this.A04.A04.A05();
        if (estimatedEnd >= 0) {
            A04(view);
            return;
        }
        this.A01 = this.A04.A0p(view);
        if (this.A02) {
            int childEnd = this.A04.A04.A0C(view);
            int A07 = (this.A04.A04.A07() - estimatedEnd) - childEnd;
            int childEnd2 = this.A04.A04.A07();
            this.A00 = childEnd2 - A07;
            if (A07 > 0) {
                int childEnd3 = this.A04.A04.A0D(view);
                int previousEndMargin = this.A00;
                int previousEndMargin2 = previousEndMargin - childEnd3;
                int A0A = this.A04.A04.A0A();
                int layoutStart = this.A04.A04.A0F(view);
                int startReference = Math.min(layoutStart - A0A, 0) + A0A;
                int previousEndMargin3 = previousEndMargin2 - startReference;
                if (previousEndMargin3 < 0) {
                    int startMargin = -previousEndMargin3;
                    this.A00 += Math.min(A07, startMargin);
                    return;
                }
                return;
            }
            return;
        }
        int A0F = this.A04.A04.A0F(view);
        int A0A2 = A0F - this.A04.A04.A0A();
        this.A00 = A0F;
        if (A0A2 <= 0) {
            return;
        }
        int A0D = this.A04.A04.A0D(view) + A0F;
        int previousLayoutEnd = this.A04.A04.A0C(view);
        int A072 = (this.A04.A04.A07() - estimatedEnd) - previousLayoutEnd;
        int estimatedEnd2 = this.A04.A04.A07();
        int previousEndMargin4 = Math.min(0, A072);
        int estimatedEnd3 = (estimatedEnd2 - previousEndMargin4) - A0D;
        if (estimatedEnd3 >= 0) {
            return;
        }
        int endMargin = -estimatedEnd3;
        this.A00 -= Math.min(A0A2, endMargin);
    }

    public final boolean A06(View view, C05754b c05754b) {
        C4N c4n = (C4N) view.getLayoutParams();
        return !c4n.A02() && c4n.A00() >= 0 && c4n.A00() < c05754b.A03();
    }

    public final String toString() {
        return A00(40, 21, 73) + this.A01 + A00(0, 14, 93) + this.A00 + A00(14, 17, 63) + this.A02 + A00(31, 9, 11) + this.A03 + '}';
    }
}
