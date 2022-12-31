package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
/* loaded from: assets/audience_network.dex */
public final class MJ {
    @Nullable
    public static MJ A02;
    public final TF A00;
    public final ML A01;

    public MJ(XT xt, Executor executor, AnonymousClass94 anonymousClass94) {
        this.A01 = new ML(xt);
        this.A00 = new TF(executor, anonymousClass94, xt);
    }

    private void A00() {
        this.A01.A03(this.A00);
    }

    public static void A01(XT xt, Executor executor, AnonymousClass94 anonymousClass94) {
        if (!JD.A0y(xt)) {
            return;
        }
        MJ mj = A02;
        if (mj == null) {
            A02 = new MJ(xt, executor, anonymousClass94);
            A02.A00();
            return;
        }
        mj.A02(anonymousClass94);
    }

    private void A02(AnonymousClass94 anonymousClass94) {
        this.A00.A07(anonymousClass94);
    }
}
