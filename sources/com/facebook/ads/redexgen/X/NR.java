package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class NR implements View.OnClickListener {
    public final /* synthetic */ NW A00;

    public NR(NW nw) {
        this.A00 = nw;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        NV nv;
        NV nv2;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            nv = this.A00.A04;
            if (nv == null) {
                return;
            }
            nv2 = this.A00.A04;
            nv2.AA8();
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
