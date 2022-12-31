package com.facebook.ads.redexgen.X;

import android.view.View;
/* loaded from: assets/audience_network.dex */
public class NC implements View.OnClickListener {
    public static String[] A02 = {"Oq", "EvGClE7if1wWI664DgGuGJMVxIj5MmF8", "WEj5b", "ZnP49bXAxkKFgNqp8", "Y2wBPaH57L9Gttlp", "AMrJJ9So27w7KiYttAq3AFMsZzT3RVfH", "8te6O8WI5P7ERWBX", "5xXH0hCktOzz8vKUWRcLVJoUpm5lTBxe"};
    public final /* synthetic */ N5 A00;
    public final /* synthetic */ C1178Sp A01;

    public NC(C1178Sp c1178Sp, N5 n5) {
        this.A01 = c1178Sp;
        this.A00 = n5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A00.A01();
            this.A01.A0A.ABH(C2B.A05);
        } catch (Throwable th) {
            if (A02[5].charAt(20) == 'D') {
                throw new RuntimeException();
            }
            A02[2] = "snOHg";
            C0974Kn.A00(th, this);
        }
    }
}
