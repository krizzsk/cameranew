package com.facebook.ads.redexgen.X;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: assets/audience_network.dex */
public class U0 implements InterfaceC1091Pg {
    public static String[] A01 = {"T9VzL8fHxpfySiwwlXedeY7mX", "guyVlBlOMcVDAIfN1wPFopCO0r0Zk0gq", "ttKJ4peW2WPtu1OROjgTykJGR", "A5J8ePX4fIk14ZpUSfaCkLGHXqqMAYt6", "kQp8myZeu", "7L0NbJj9RoUIRUZ", "UhNplE17b8XX", "zMftdbZDucx4tcPG97oOAYZ8vQU5TBbw"};
    public final /* synthetic */ C1209Tu A00;

    public U0(C1209Tu c1209Tu) {
        this.A00 = c1209Tu;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1091Pg
    public final void ACT() {
        AtomicBoolean atomicBoolean;
        InterfaceC0946Jk interfaceC0946Jk;
        InterfaceC0946Jk interfaceC0946Jk2;
        AtomicBoolean atomicBoolean2;
        atomicBoolean = this.A00.A0E;
        atomicBoolean.set(true);
        interfaceC0946Jk = this.A00.A02;
        if (interfaceC0946Jk != null) {
            interfaceC0946Jk2 = this.A00.A02;
            atomicBoolean2 = this.A00.A0D;
            boolean z = atomicBoolean2.get();
            if (A01[1].charAt(3) == 'h') {
                throw new RuntimeException();
            }
            A01[3] = "0cRb1Hjpfivo5OpVdykyl3dtou8RqpBl";
            interfaceC0946Jk2.ABV(z);
        }
    }
}
