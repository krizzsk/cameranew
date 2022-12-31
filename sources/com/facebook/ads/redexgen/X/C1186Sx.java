package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
/* renamed from: com.facebook.ads.redexgen.X.Sx  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1186Sx implements PN {
    public final /* synthetic */ C1185Sw A00;

    public C1186Sx(C1185Sw c1185Sw) {
        this.A00 = c1185Sw;
    }

    public /* synthetic */ C1186Sx(C1185Sw c1185Sw, T3 t3) {
        this(c1185Sw);
    }

    @Override // com.facebook.ads.redexgen.X.PN
    public final void AAE() {
        this.A00.A0X(true);
    }

    @Override // com.facebook.ads.redexgen.X.PN
    public final void AAk() {
        AnonymousClass16 anonymousClass16;
        MU mu;
        InterfaceC1031Mw interfaceC1031Mw;
        JT jt;
        AnonymousClass16 anonymousClass162;
        PP pp;
        PP pp2;
        AnonymousClass16 anonymousClass163;
        XT xt;
        anonymousClass16 = this.A00.A0D;
        if (!TextUtils.isEmpty(anonymousClass16.A0Q())) {
            jt = this.A00.A0H;
            anonymousClass162 = this.A00.A0D;
            String A0Q = anonymousClass162.A0Q();
            C1055Nu c1055Nu = new C1055Nu();
            pp = this.A00.A06;
            C1055Nu A03 = c1055Nu.A03(pp.getViewabilityChecker());
            pp2 = this.A00.A06;
            jt.A8v(A0Q, A03.A02(pp2.getTouchDataRecorder()).A05());
            anonymousClass163 = this.A00.A0D;
            AnonymousClass26.A00(anonymousClass163.A0S());
            xt = this.A00.A0G;
            xt.A0D().A2Y();
        }
        mu = this.A00.A0L;
        interfaceC1031Mw = this.A00.A0M;
        mu.A3q(interfaceC1031Mw.A6i());
    }

    @Override // com.facebook.ads.redexgen.X.PN
    public final void AB5() {
        MU mu;
        InterfaceC1031Mw interfaceC1031Mw;
        mu = this.A00.A0L;
        interfaceC1031Mw = this.A00.A0M;
        mu.A3q(interfaceC1031Mw.A6V());
    }

    @Override // com.facebook.ads.redexgen.X.PN
    public final void ACd() {
        MU mu;
        mu = this.A00.A0L;
        mu.AA3(15);
    }
}
