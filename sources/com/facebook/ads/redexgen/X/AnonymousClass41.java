package com.facebook.ads.redexgen.X;

import android.view.View;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.41  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class AnonymousClass41 {
    public int A00;
    public int A01;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public boolean A09;
    public boolean A0B = true;
    public int A02 = 0;
    public boolean A0A = false;
    public List<AbstractC05784e> A08 = null;

    private View A00() {
        int size = this.A08.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.A08.get(i2).A0H;
            C4N c4n = (C4N) view.getLayoutParams();
            if (!c4n.A02()) {
                int i3 = this.A01;
                int i4 = c4n.A00();
                if (i3 == i4) {
                    A02(view);
                    return view;
                }
            }
        }
        return null;
    }

    private final View A01(View closest) {
        int i2 = this.A08.size();
        View view = null;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < i2; i4++) {
            View view2 = this.A08.get(i4).A0H;
            C4N c4n = (C4N) view2.getLayoutParams();
            if (view2 != closest && !c4n.A02()) {
                int A00 = c4n.A00();
                int closestDistance = this.A01;
                int i5 = A00 - closestDistance;
                int closestDistance2 = this.A03;
                int i6 = i5 * closestDistance2;
                if (i6 >= 0 && i6 < i3) {
                    view = view2;
                    i3 = i6;
                    if (i6 == 0) {
                        break;
                    }
                }
            }
        }
        return view;
    }

    private final void A02(View view) {
        View A01 = A01(view);
        if (A01 == null) {
            this.A01 = -1;
        } else {
            this.A01 = ((C4N) A01.getLayoutParams()).A00();
        }
    }

    public final View A03(C4U c4u) {
        if (this.A08 != null) {
            return A00();
        }
        View A0G = c4u.A0G(this.A01);
        this.A01 += this.A03;
        return A0G;
    }

    public final void A04() {
        A02(null);
    }

    public final boolean A05(C05754b c05754b) {
        int i2 = this.A01;
        return i2 >= 0 && i2 < c05754b.A03();
    }
}
