package com.facebook.ads.redexgen.X;

import androidx.annotation.RequiresApi;
/* loaded from: assets/audience_network.dex */
public class SM implements InterfaceC1039Ne {
    public final /* synthetic */ SK A00;

    public SM(SK sk) {
        this.A00 = sk;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1039Ne
    public final void ABR(String str) {
        NX nx;
        NX nx2;
        this.A00.A0I = false;
        nx = this.A00.A0C;
        nx.setProgress(100);
        nx2 = this.A00.A0C;
        M5.A0N(nx2, 8);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1039Ne
    public final void ABT(String str) {
        NX nx;
        NW nw;
        this.A00.A0I = true;
        nx = this.A00.A0C;
        M5.A0N(nx, 0);
        nw = this.A00.A0B;
        nw.setUrl(str);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1039Ne
    public final void ABk(int i2) {
        boolean z;
        NX nx;
        z = this.A00.A0I;
        if (z) {
            nx = this.A00.A0C;
            nx.setProgress(i2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1039Ne
    public final void ABp(String str) {
        NW nw;
        nw = this.A00.A0B;
        nw.setTitle(str);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1039Ne
    @RequiresApi(api = 26)
    public final void ABr() {
        ON on;
        on = this.A00.A0E;
        on.A09().AA3(14);
    }
}
