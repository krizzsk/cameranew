package com.facebook.ads.redexgen.X;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
/* loaded from: assets/audience_network.dex */
public final class OK {
    public static OJ A00(final ON on, @Nullable Bundle bundle, boolean z) {
        OJ sr;
        AnonymousClass19 A0K = on.A04().A0K();
        double A00 = OI.A00(A0K);
        boolean isWatchAndBrowse = on.A04().A0K().A0M();
        final boolean isVideo = OI.A05(on.A00(), on.A01(), A00);
        AbstractC04770f A002 = C04780g.A00(on.A05(), on.A06(), "", Uri.parse(on.A04().A0K().A0F().A05()), new HashMap());
        boolean z2 = !TextUtils.isEmpty(A0K.A0D().A08());
        if (JD.A1D(on.A05())) {
            on.A05().A09().AFC(on.A02(), on.A04().A0Q(), z2);
        }
        if (isWatchAndBrowse && (A002 instanceof FK)) {
            sr = new SK(on);
        } else if (z2) {
            sr = new C07139t(on);
        } else if (!z2 && JD.A1h(on.A05())) {
            sr = new SU(on, isVideo) { // from class: com.facebook.ads.redexgen.X.9u
                public static final int A02 = Resources.getSystem().getDisplayMetrics().widthPixels;
                public final View A00;
                public final boolean A01;

                {
                    super(on, true);
                    this.A01 = isVideo;
                    this.A00 = on.A02();
                    A0f();
                    if (this.A01) {
                        addView(on.A02(), new RelativeLayout.LayoutParams(-1, -1));
                    } else {
                        FrameLayout frameLayout = new FrameLayout(on.A05());
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        layoutParams.addRule(2, getAdDetailsView().getId());
                        frameLayout.setLayoutParams(layoutParams);
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                        layoutParams2.gravity = 17;
                        layoutParams2.setMargins(OJ.A08, 0, OJ.A08, 0);
                        frameLayout.addView(this.A00, layoutParams2);
                        addView(frameLayout);
                    }
                    getAdDetailsView().bringToFront();
                }

                @Override // com.facebook.ads.redexgen.X.OJ
                public final boolean A02() {
                    return this.A01 && super.A02();
                }

                @Override // com.facebook.ads.redexgen.X.OJ
                public final boolean A0B() {
                    return this.A01 && super.A02();
                }

                @Override // com.facebook.ads.redexgen.X.SU, com.facebook.ads.redexgen.X.OJ
                public final void A0b(AnonymousClass19 anonymousClass19, String str, double d2, @Nullable Bundle bundle2) {
                    super.A0b(anonymousClass19, str, d2, bundle2);
                    if (!this.A01 && d2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) ((A02 - (OJ.A08 * 2)) / d2));
                        layoutParams.gravity = 17;
                        layoutParams.setMargins(OJ.A08, 0, OJ.A08, 0);
                        this.A00.setLayoutParams(layoutParams);
                    }
                }

                @Override // com.facebook.ads.redexgen.X.OJ
                public final boolean A0c() {
                    return this.A01;
                }
            };
        } else if (isVideo) {
            sr = new ST(on, on.A00() == 2);
        } else {
            sr = new SR(on, OI.A03(A00));
        }
        if (z) {
            sr.A0b(A0K, on.A04().A0Q(), A00, bundle);
        }
        return sr;
    }
}
