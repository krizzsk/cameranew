package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class NL implements View.OnClickListener {
    public static String[] A02 = {"0jbDV4SqpRnuIwDLdLhaSwFsy", "4CrQo2YdoWcqlYT3QJHt1izZuISw0o1a", "L1hOW0A7sRjLAVrGrG7yuKVrDUUFxwrZ", "r8z", "jBR", "EADx", "Dw2r3KoKizw7HI548vOXrftmgV6TcaYT", "JzZVJSkZeh7kJVI6l2oDTz"};
    public final /* synthetic */ N5 A00;
    public final /* synthetic */ C1177So A01;

    public NL(C1177So c1177So, N5 n5) {
        this.A01 = c1177So;
        this.A00 = n5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A00.A01();
            this.A01.A0A.ABH(C2B.A03);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
            if (A02[7].length() == 1) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[4] = "wzs";
            strArr[0] = "95EfxSbyIArn9raLN6CoppC7A";
        }
    }
}
