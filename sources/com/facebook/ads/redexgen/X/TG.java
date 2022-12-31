package com.facebook.ads.redexgen.X;

import android.content.DialogInterface;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public class TG extends AbstractRunnableC0981Kv {
    public static String[] A02 = {"r", "tRYI", "7UJuVMqBcP2QEoAe5I9ReZPElv0qEy55", "leQvAr8Bdm", "IrxDcEzjLLQBxw", "x58zC904VQqUCNnuzCjkyAfM", "58DZzAqOGTGaE", "1xO3"};
    public final /* synthetic */ DialogInterface A00;
    public final /* synthetic */ MI A01;

    public TG(MI mi, DialogInterface dialogInterface) {
        this.A01 = mi;
        this.A00 = dialogInterface;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        InterfaceC1116Qf interfaceC1116Qf;
        InterfaceC1116Qf interfaceC1116Qf2;
        XS xs;
        Map<? extends String, ? extends String> A04;
        interfaceC1116Qf = this.A01.A01.A02;
        if (interfaceC1116Qf != null) {
            interfaceC1116Qf2 = this.A01.A01.A02;
            xs = this.A01.A01.A00;
            String A03 = C0963Kb.A03(xs);
            C1130Qt c1130Qt = new C1130Qt();
            A04 = this.A01.A01.A04(this.A01.A00.getText().toString());
            interfaceC1116Qf2.ACt(A03, c1130Qt.A05(A04).A08());
        }
        DialogInterface dialogInterface = this.A00;
        if (A02[6].length() != 13) {
            throw new RuntimeException();
        }
        A02[6] = "1hADnGgCLejuT";
        dialogInterface.cancel();
    }
}
