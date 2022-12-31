package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public final class ST extends OJ {
    public ST(ON on, boolean z) {
        super(on, true);
        RelativeLayout relativeLayout = new RelativeLayout(on.A05());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        M5.A0R(relativeLayout, getAdContextWrapper());
        LinearLayout linearLayout = new LinearLayout(on.A05());
        linearLayout.setOrientation(!z ? 1 : 0);
        linearLayout.setGravity(80);
        M5.A0K(linearLayout);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(OJ.A08, 0, OJ.A08, OJ.A08);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(z ? -2 : -1, -2);
        layoutParams3.setMargins(z ? OJ.A08 : 0, z ? 0 : OJ.A08, 0, 0);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(z ? 0 : -1, -2);
        layoutParams4.setMargins(0, 0, 0, 0);
        layoutParams4.weight = 1.0f;
        LinearLayout auxContainer = getTitleDescContainer();
        linearLayout.addView(auxContainer, layoutParams4);
        linearLayout.addView(getCtaButton(), layoutParams3);
        relativeLayout.addView(linearLayout, layoutParams2);
        addView(on.A02(), new RelativeLayout.LayoutParams(-1, -1));
        addView(relativeLayout, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final void A0b(AnonymousClass19 anonymousClass19, String str, double d2, @Nullable Bundle bundle) {
        super.A0b(anonymousClass19, str, d2, bundle);
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final boolean A0c() {
        return true;
    }
}
