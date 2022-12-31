package com.facebook.ads.redexgen.X;

import android.content.DialogInterface;
import java.util.Arrays;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Ny  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class DialogInterface$OnClickListenerC1059Ny implements DialogInterface.OnClickListener {
    public static byte[] A04;
    public final /* synthetic */ O1 A00;
    public final /* synthetic */ String A01;
    public final /* synthetic */ String A02;
    public final /* synthetic */ Map A03;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 67);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-84, -74, -94, -73, -70, -78, -94, -74, -73, -88, -77, -7, -9, -6, -22};
    }

    public DialogInterface$OnClickListenerC1059Ny(O1 o1, Map map, String str, String str2) {
        this.A00 = o1;
        this.A03 = map;
        this.A01 = str;
        this.A02 = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        this.A03.put(A00(0, 11, 0), A00(11, 4, 66));
        this.A00.A06(this.A01, this.A02, this.A03);
    }
}
