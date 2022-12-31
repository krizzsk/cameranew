package com.facebook.ads.redexgen.X;

import android.content.DialogInterface;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Jn  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class DialogInterface$OnClickListenerC0949Jn implements DialogInterface.OnClickListener {
    public static byte[] A01;
    public final /* synthetic */ View$OnClickListenerC1200Tl A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 39);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{7, 17, -3, 18, 21, Draft_75.CR, -3, 17, 18, 3, 14, -12, -14, -11, -27};
    }

    public DialogInterface$OnClickListenerC0949Jn(View$OnClickListenerC1200Tl view$OnClickListenerC1200Tl) {
        this.A00 = view$OnClickListenerC1200Tl;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        Map A012;
        A012 = this.A00.A01();
        A012.put(A00(0, 11, 119), A00(11, 4, 89));
        this.A00.A05(A012);
    }
}
