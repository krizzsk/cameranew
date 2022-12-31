package com.facebook.ads.redexgen.X;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* loaded from: assets/audience_network.dex */
public final class SR extends OJ {
    public static final int A01 = Resources.getSystem().getDisplayMetrics().widthPixels;
    public final OS A00;

    public SR(ON on, boolean z) {
        super(on, z);
        this.A00 = new OS(on.A05(), on.A02());
        this.A00.A01(getTitleDescContainer(), z);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.setMargins(OJ.A08, OJ.A08, OJ.A08, OJ.A08);
        getCtaButton().setLayoutParams(layoutParams);
        FrameLayout frameLayout = new FrameLayout(on.A05());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(2, getCtaButton().getId());
        frameLayout.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 17;
        layoutParams3.setMargins(OJ.A08, 0, OJ.A08, 0);
        frameLayout.addView(this.A00, layoutParams3);
        addView(frameLayout);
        addView(getCtaButton());
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final boolean A02() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final boolean A0B() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final void A0b(AnonymousClass19 anonymousClass19, String str, double d2, @Nullable Bundle bundle) {
        super.A0b(anonymousClass19, str, d2, bundle);
        if (d2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            this.A00.A00((int) ((A01 - (OJ.A08 * 2)) / d2));
        }
    }

    @Override // com.facebook.ads.redexgen.X.OJ
    public final boolean A0c() {
        return false;
    }
}
