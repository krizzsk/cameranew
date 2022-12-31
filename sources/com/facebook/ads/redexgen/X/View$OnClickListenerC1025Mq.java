package com.facebook.ads.redexgen.X;

import android.view.View;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Mq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnClickListenerC1025Mq implements View.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ C1183Su A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 108);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-27, -38, -25, -37, -28, -25, -30, -72, -23, -42, -72, -31, -34, -40, -32};
    }

    public View$OnClickListenerC1025Mq(C1183Su c1183Su) {
        this.A00 = c1183Su;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MU mu;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            mu = this.A00.A04;
            mu.A3q(A00(0, 15, 9));
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
