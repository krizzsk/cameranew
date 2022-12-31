package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class TD implements InterfaceC1039Ne {
    public final /* synthetic */ MU A00;
    public final /* synthetic */ TB A01;

    public TD(TB tb, MU mu) {
        this.A01 = tb;
        this.A00 = mu;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1039Ne
    public final void ABR(String str) {
        NX nx;
        nx = this.A01.A0A;
        nx.setProgress(100);
        this.A01.A05 = false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1039Ne
    public final void ABT(String str) {
        NW nw;
        this.A01.A05 = true;
        nw = this.A01.A09;
        nw.setUrl(str);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1039Ne
    public final void ABk(int i2) {
        boolean z;
        NX nx;
        z = this.A01.A05;
        if (z) {
            nx = this.A01.A0A;
            nx.setProgress(i2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1039Ne
    public final void ABp(String str) {
        NW nw;
        nw = this.A01.A09;
        nw.setTitle(str);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1039Ne
    public final void ABr() {
        this.A00.AA3(14);
    }
}
