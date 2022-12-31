package com.facebook.ads.redexgen.X;

import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.Tx  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1212Tx implements InterfaceC1054Nt {
    public static String[] A01 = {"PnhhxO44eyGR", "6RYeLXmAClA1SiGKn201px", "WqNcg2MFF", "kFMGwY5yNNV", "mQRpAL1oxGJgw", "Eqf6jMIzeI3tCjJb", "9imsVe3tjkVzhTosgYrmf1lKW7QE2MSM", "NRYl8cTHkwcGHXULnCD2cakkWnkUWd4e"};
    public final /* synthetic */ C1209Tu A00;

    public C1212Tx(C1209Tu c1209Tu) {
        this.A00 = c1209Tu;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1054Nt
    public final void AAi(boolean z) {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        InterfaceC0946Jk interfaceC0946Jk;
        InterfaceC0946Jk interfaceC0946Jk2;
        atomicBoolean = this.A00.A0D;
        atomicBoolean.set(z);
        atomicBoolean2 = this.A00.A0E;
        if (atomicBoolean2.get()) {
            interfaceC0946Jk = this.A00.A02;
            if (interfaceC0946Jk != null) {
                C1209Tu c1209Tu = this.A00;
                String[] strArr = A01;
                if (strArr[5].length() == strArr[3].length()) {
                    throw new RuntimeException();
                }
                A01[2] = "moHDWw2Q1";
                interfaceC0946Jk2 = c1209Tu.A02;
                interfaceC0946Jk2.ABV(z);
            }
        }
    }
}
