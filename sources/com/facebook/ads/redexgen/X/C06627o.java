package com.facebook.ads.redexgen.X;

import android.os.Handler;
/* renamed from: com.facebook.ads.redexgen.X.7o  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C06627o extends KO {
    public final /* synthetic */ KF A00;

    public C06627o(KF kf) {
        this.A00 = kf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C9P
    /* renamed from: A00 */
    public final void A03(KP kp) {
        C1099Po c1099Po;
        boolean z;
        Handler handler;
        boolean A0D;
        boolean z2;
        Handler handler2;
        int i2;
        c1099Po = this.A00.A01;
        if (c1099Po == null) {
            return;
        }
        z = this.A00.A03;
        if (z || kp.A00().getAction() != 0) {
            return;
        }
        handler = this.A00.A05;
        handler.removeCallbacksAndMessages(null);
        A0D = this.A00.A0D(Q5.A05);
        if (A0D) {
            this.A00.A03();
            this.A00.A06(true, false);
        }
        z2 = this.A00.A02;
        if (!z2) {
            return;
        }
        handler2 = this.A00.A05;
        KG kg = new KG(this);
        i2 = this.A00.A00;
        handler2.postDelayed(kg, i2);
    }
}
