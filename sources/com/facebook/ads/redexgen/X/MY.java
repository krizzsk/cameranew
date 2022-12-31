package com.facebook.ads.redexgen.X;

import android.view.View;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
/* loaded from: assets/audience_network.dex */
public class MY implements View.OnClickListener {
    public final /* synthetic */ FullScreenAdToolbar A00;

    public MY(FullScreenAdToolbar fullScreenAdToolbar) {
        this.A00 = fullScreenAdToolbar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MS ms;
        C1023Mo c1023Mo;
        MS ms2;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            ms = this.A00.A00;
            if (ms != null) {
                c1023Mo = this.A00.A05;
                if (c1023Mo.A03()) {
                    ms2 = this.A00.A00;
                    ms2.AA8();
                }
            }
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
