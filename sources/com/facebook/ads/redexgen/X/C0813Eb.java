package com.facebook.ads.redexgen.X;

import com.facebook.ads.MediaViewVideoRenderer;
/* renamed from: com.facebook.ads.redexgen.X.Eb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0813Eb extends AbstractC0976Kq {
    public final /* synthetic */ C5E A00;

    public C0813Eb(C5E c5e) {
        this.A00 = c5e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C9P
    /* renamed from: A00 */
    public final void A03(C0977Kr c0977Kr) {
        MediaViewVideoRenderer mediaViewVideoRenderer;
        if (this.A00.A08 != null) {
            C1198Tj.A0J(this.A00.A08.getInternalNativeAd()).A1a(true, true);
        }
        mediaViewVideoRenderer = this.A00.A00;
        mediaViewVideoRenderer.onPlayed();
    }
}
