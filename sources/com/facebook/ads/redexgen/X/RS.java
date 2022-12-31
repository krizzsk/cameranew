package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class RS extends C4A<C1113Qc> {
    public final int A00;
    public final XT A01;
    public final List<String> A02;

    public RS(XT xt, List<String> screenshotUrls, int i2) {
        this.A02 = screenshotUrls;
        this.A00 = i2;
        this.A01 = xt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C4A
    /* renamed from: A01 */
    public final C1113Qc A0C(ViewGroup viewGroup, int i2) {
        return new C1113Qc(new RO(this.A01));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C4A
    /* renamed from: A02 */
    public final void A0E(C1113Qc c1113Qc, int leftMargin) {
        int i2;
        String str = this.A02.get(leftMargin);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        int i3 = this.A00;
        int startSpacing = i3 * 4;
        if (leftMargin == 0) {
            i3 = startSpacing;
        }
        int startSpacing2 = A0D();
        if (leftMargin >= startSpacing2 - 1) {
            int startSpacing3 = this.A00;
            i2 = startSpacing3 * 4;
        } else {
            i2 = this.A00;
        }
        marginLayoutParams.setMargins(i3, 0, i2, 0);
        c1113Qc.A0l().setLayoutParams(marginLayoutParams);
        c1113Qc.A0l().A00(str);
    }

    @Override // com.facebook.ads.redexgen.X.C4A
    public final int A0D() {
        return this.A02.size();
    }
}
