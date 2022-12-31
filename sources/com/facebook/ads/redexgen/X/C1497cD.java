package com.facebook.ads.redexgen.X;

import android.view.View;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.cD  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1497cD extends AbstractC04850o {
    public static byte[] A01;
    public static String[] A02 = {"", "lR4UvBki6PSdVcLREjEHAbqRd1OmLUQf", "DjKPGQUWmMf7x", "ODfaPUPPzX7KhktdCz15RADFZIjUcUTH", "SOtQhTlfKwNvvZXzwoqU2I3z2iEV30z7", "BHtVd6ktyCMEATMZK8J5wjGrCvXYI9tG", "P8UTzFKpwpJ94", "IxNcf87J3g"};
    public final /* synthetic */ C1496cB A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 126);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{99, 114, 107, 29, 17, 16, 10, 12, 17, 18, 18, 27, 12, 94, 23, Draft_75.CR, 94, 16, 11, 18, 18};
    }

    static {
        A01();
    }

    public C1497cD(C1496cB c1496cB) {
        this.A00 = c1496cB;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A02() {
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        this.A00.A05 = false;
        interstitialAdExtendedListener = this.A00.A08;
        interstitialAdExtendedListener.onInterstitialActivityDestroyed();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A04() {
        F7 f7;
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        C05201x c05201x;
        C1009Lz c1009Lz;
        F7 f72;
        F7 f73;
        this.A00.A05 = false;
        f7 = this.A00.A02;
        if (f7 != null) {
            f72 = this.A00.A02;
            f72.A0M(new C1498cE(this));
            f73 = this.A00.A02;
            f73.A0H();
            this.A00.A02 = null;
        }
        interstitialAdExtendedListener = this.A00.A08;
        c05201x = this.A00.A09;
        interstitialAdExtendedListener.onInterstitialDismissed(c05201x.A01());
        c1009Lz = this.A00.A04;
        c1009Lz.A05();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A05() {
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        C05201x c05201x;
        interstitialAdExtendedListener = this.A00.A08;
        c05201x = this.A00.A09;
        interstitialAdExtendedListener.onInterstitialDisplayed(c05201x.A01());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A06() {
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        interstitialAdExtendedListener = this.A00.A08;
        interstitialAdExtendedListener.onRewardedAdServerFailed();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A07() {
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        interstitialAdExtendedListener = this.A00.A08;
        interstitialAdExtendedListener.onRewardedAdServerSucceeded();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A08() {
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        interstitialAdExtendedListener = this.A00.A08;
        interstitialAdExtendedListener.onRewardedAdCompleted();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A0C() {
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        C05201x c05201x;
        this.A00.A07.A0D().A2X();
        interstitialAdExtendedListener = this.A00.A08;
        c05201x = this.A00.A09;
        interstitialAdExtendedListener.onAdClicked(c05201x.A01());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A0D() {
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        C05201x c05201x;
        interstitialAdExtendedListener = this.A00.A08;
        c05201x = this.A00.A09;
        interstitialAdExtendedListener.onLoggingImpression(c05201x.A01());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A0E(View view) {
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A0F(InterfaceC04840n interfaceC04840n) {
        F7 f7;
        F7 f72;
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        C05201x c05201x;
        f7 = this.A00.A02;
        if (f7 != null) {
            this.A00.A06 = true;
            C1496cB c1496cB = this.A00;
            f72 = c1496cB.A02;
            c1496cB.A01 = f72.A0T();
            interstitialAdExtendedListener = this.A00.A08;
            c05201x = this.A00.A09;
            InterstitialAd A012 = c05201x.A01();
            String[] strArr = A02;
            if (strArr[6].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[1] = "VeASnUkJuhfeOmGjJqk9CbDFf3FFhRFx";
            strArr2[5] = "TZLIDWk0RuIbUDThQePy8NEYvQ7OtG1H";
            interstitialAdExtendedListener.onAdLoaded(A012);
            return;
        }
        this.A00.A07.A06().A8q(A00(0, 3, 124), C06808m.A0F, new C06818n(A00(3, 18, 0)));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A0G(K3 k3) {
        long j2;
        InterstitialAdExtendedListener interstitialAdExtendedListener;
        C05201x c05201x;
        C0R A0D = this.A00.A07.A0D();
        j2 = this.A00.A00;
        A0D.A2a(C1008Ly.A01(j2), k3.A03().getErrorCode(), k3.A04());
        interstitialAdExtendedListener = this.A00.A08;
        c05201x = this.A00.A09;
        interstitialAdExtendedListener.onError(c05201x.A01(), LK.A00(k3));
    }
}
