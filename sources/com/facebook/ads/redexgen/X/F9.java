package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class F9 extends AbstractC1530cl {
    public final XT A00;

    public F9(AnonymousClass18 anonymousClass18, List<C1198Tj> list, XT xt) {
        super(anonymousClass18, list, xt);
        this.A00 = xt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C4A
    /* renamed from: A01 */
    public final TA A0C(ViewGroup viewGroup, int i2) {
        return new TA(new C1010Ma(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1530cl, com.facebook.ads.redexgen.X.C4A
    /* renamed from: A0H */
    public final void A0E(TA ta, int i2) {
        super.A0E(ta, i2);
        C1010Ma c1010Ma = (C1010Ma) ta.A0l();
        C1022Mm c1022Mm = (C1022Mm) c1010Ma.getImageCardView();
        c1022Mm.setImageDrawable(null);
        A0F(c1022Mm, i2);
        C1198Tj c1198Tj = ((AbstractC1530cl) this).A01.get(i2);
        c1198Tj.A10().A0F(this.A00);
        c1198Tj.A1M(c1010Ma, c1010Ma);
    }
}
