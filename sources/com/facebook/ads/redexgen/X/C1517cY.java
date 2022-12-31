package com.facebook.ads.redexgen.X;

import android.webkit.WebView;
import com.facebook.ads.AdError;
/* renamed from: com.facebook.ads.redexgen.X.cY  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1517cY implements C7B {
    public final C1U A00;
    public final InterfaceC05061j A01;
    public final C7J A02;
    public final XT A03;
    public final boolean A04;

    public C1517cY(XT xt, InterfaceC05061j interfaceC05061j, C7J c7j, C1U c1u, boolean z) {
        this.A03 = xt;
        this.A01 = interfaceC05061j;
        this.A02 = c7j;
        this.A00 = c1u;
        this.A04 = z;
    }

    private final void A00() {
        WebView webView = new WebView(this.A03);
        webView.getSettings().setCacheMode(1);
        webView.setWebViewClient(new C05071k(this.A00, this.A01, this.A04));
        webView.loadUrl(this.A00.A0E());
    }

    private void A01(boolean z) {
        if (this.A00.A09() == C1V.A05) {
            A00();
            return;
        }
        String A0E = this.A00.A0E();
        if (z) {
            A0E = this.A02.A0P(this.A00.A0E());
        }
        this.A00.A0H(A0E);
        this.A01.ABY();
    }

    @Override // com.facebook.ads.redexgen.X.C7B
    public final void AA5() {
        if (this.A04) {
            this.A01.ABX(AdError.CACHE_ERROR);
        } else {
            A01(false);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C7B
    public final void AAC() {
        A01(true);
    }
}
