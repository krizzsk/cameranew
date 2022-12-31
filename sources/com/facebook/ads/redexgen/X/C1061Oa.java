package com.facebook.ads.redexgen.X;

import android.graphics.drawable.ColorDrawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
/* renamed from: com.facebook.ads.redexgen.X.Oa  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1061Oa {
    public static AbstractC07069m A00(final ON on, int i2, final String str, final C1144Rh c1144Rh) {
        if (i2 == 1) {
            return new AbstractC07069m(on, str, c1144Rh) { // from class: com.facebook.ads.redexgen.X.1g
                public static final int A00 = (int) (LY.A00 * 20.0f);
                public static final int A01 = (int) (LY.A00 * 16.0f);

                @Override // com.facebook.ads.redexgen.X.OJ
                public final boolean A01() {
                    return false;
                }

                @Override // com.facebook.ads.redexgen.X.AbstractC07069m
                public final void A0j(XT xt) {
                    OG titleDescContainer = getTitleDescContainer();
                    titleDescContainer.setAlignment(3);
                    titleDescContainer.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                    titleDescContainer.setPadding(0, 0, 0, A00);
                    getCtaButton().setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                    LinearLayout linearLayout = new LinearLayout(xt);
                    M5.A0S(linearLayout, new ColorDrawable(-1));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(3, getMediaContainer().getId());
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setOrientation(1);
                    int i3 = A01;
                    linearLayout.setPadding(i3, i3, i3, i3);
                    linearLayout.addView(titleDescContainer);
                    linearLayout.addView(getCtaButton());
                    addView(getMediaContainer());
                    addView(linearLayout);
                }
            };
        }
        return new AbstractC07069m(on, str, c1144Rh) { // from class: com.facebook.ads.redexgen.X.23
            public static final int A00 = (int) (LY.A00 * 12.0f);

            @Override // com.facebook.ads.redexgen.X.OJ
            public final boolean A00() {
                return false;
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC07069m, com.facebook.ads.redexgen.X.OJ
            public final boolean A0B() {
                return false;
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC07069m
            public final void A0j(XT xt) {
                OG titleDescContainer = getTitleDescContainer();
                titleDescContainer.setAlignment(3);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(8, getMediaContainer().getId());
                titleDescContainer.setLayoutParams(layoutParams);
                int i3 = A00;
                titleDescContainer.setPadding(i3, i3, i3, i3);
                M5.A0R(titleDescContainer, getAdContextWrapper());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(3, getMediaContainer().getId());
                getCtaButton().setLayoutParams(layoutParams2);
                addView(getMediaContainer());
                addView(titleDescContainer);
                addView(getCtaButton());
            }
        };
    }
}
