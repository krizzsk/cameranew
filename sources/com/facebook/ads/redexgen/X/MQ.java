package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
/* loaded from: assets/audience_network.dex */
public class MQ implements View.OnClickListener {
    public final /* synthetic */ C1S A00;
    public final /* synthetic */ C0937Jb A01;
    public final /* synthetic */ MR A02;
    public final /* synthetic */ MU A03;
    public final /* synthetic */ String A04;

    public MQ(MR mr, C0937Jb c0937Jb, MU mu, String str, C1S c1s) {
        this.A02 = mr;
        this.A01 = c0937Jb;
        this.A03 = mu;
        this.A04 = str;
        this.A00 = c1s;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        XT xt;
        XT xt2;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A01.A02(EnumC0936Ja.A0A, null);
            xt = this.A02.A02;
            if (C2A.A0P(xt.A00(), true)) {
                this.A03.A8a(this.A04, this.A00);
            } else if (!TextUtils.isEmpty(this.A00.A00())) {
                LI li = new LI();
                xt2 = this.A02.A02;
                LI.A08(li, xt2, Uri.parse(this.A00.A00()), this.A04);
            }
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
