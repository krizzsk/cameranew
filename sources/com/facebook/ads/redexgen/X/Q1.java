package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class Q1 implements View.OnClickListener {
    public final /* synthetic */ C06296e A00;

    public Q1(C06296e c06296e) {
        this.A00 = c06296e;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View v;
        C0937Jb c0937Jb;
        XT xt;
        C1099Po videoView;
        C1099Po videoView2;
        C1099Po videoView3;
        C0937Jb c0937Jb2;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            v = this.A00.getVideoView();
            if (v != null) {
                c0937Jb = this.A00.A02;
                if (c0937Jb != null) {
                    c0937Jb2 = this.A00.A02;
                    c0937Jb2.A02(EnumC0936Ja.A0n, null);
                }
                xt = this.A00.A01;
                xt.A0D().A2s();
                int[] iArr = Q2.A00;
                videoView = this.A00.getVideoView();
                int i2 = iArr[videoView.getState().ordinal()];
                if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
                    videoView2 = this.A00.getVideoView();
                    videoView2.A0b(EnumC1094Pj.A05, 12);
                } else if (i2 == 5) {
                    videoView3 = this.A00.getVideoView();
                    videoView3.A0e(true, 8);
                }
            }
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
