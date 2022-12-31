package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.view.View;
/* loaded from: assets/audience_network.dex */
public class XF implements InterfaceC0972Kl {
    @Override // com.facebook.ads.redexgen.X.InterfaceC0972Kl
    public final void ADg(Throwable th, Object obj) {
        if (obj instanceof C8H) {
            XT A5Y = ((C8H) obj).A5Y();
            if (A5Y != null) {
                A5Y.A0H(th);
            }
        } else if (!(obj instanceof View)) {
        } else {
            Context context = ((View) obj).getContext();
            if (!(context instanceof XT)) {
                return;
            }
            ((XT) context).A0H(th);
        }
    }
}
