package com.facebook.ads.redexgen.X;

import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import java.util.HashMap;
/* loaded from: assets/audience_network.dex */
public final class O2 {
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.2E] */
    public static C2E A00(final ON on, final C1198Tj c1198Tj, final String str, final A1 a1) {
        return new C07159v(on, c1198Tj, true, str, a1) { // from class: com.facebook.ads.redexgen.X.2E
            @Nullable
            public SZ A00;
            @Nullable
            public PE A01;
            public final JT A02 = this.A0I.A05().A00().A08();
            public final C1198Tj A03;
            public final A1 A04;
            public final String A05;
            public static final int A07 = (int) (LY.A00 * (-4.0f));
            public static final int A06 = (int) (LY.A00 * 6.0f);

            {
                this.A03 = c1198Tj;
                this.A05 = str;
                this.A04 = a1;
                this.A03.A1J(this);
            }

            @Override // com.facebook.ads.redexgen.X.SJ
            public void setupNativeCtaExtension(PE pe) {
                this.A01 = pe;
                int A0K = JD.A0K(this.A0I.A05());
                C1I A01 = this.A03.A0y().A0J().A01();
                this.A00 = new SZ(this.A0I.A05(), this.A03.A0y().A0P(), A01, this.A02, C1043Ni.getDummyListener(), this.A04.A0c(), this.A03.A17());
                this.A00.setCta(pe.A03().A0F(), this.A05, new HashMap());
                this.A03.A1J(this.A00);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (A0K == 1) {
                    layoutParams.addRule(12);
                    M5.A0P(this.A00, A06, 5, A01.A09(false));
                    ((C07159v) this).A06.addView(this.A00, layoutParams);
                } else if (A0K != 2) {
                } else {
                    layoutParams.addRule(3, ((C07159v) this).A06.getId());
                    layoutParams.setMargins(0, A07, 0, 0);
                    addView(this.A00, 0, layoutParams);
                    ((C07159v) this).A06.bringToFront();
                }
            }
        };
    }

    public static C07159v A01(ON on, String str, C1144Rh c1144Rh) {
        return new C07159v(on, true, str, c1144Rh);
    }
}
