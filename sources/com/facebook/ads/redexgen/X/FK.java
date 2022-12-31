package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class FK extends AbstractC1554d9 {
    public static byte[] A02;
    public static String[] A03 = {"EO73VH", "Qgz5bq7vpM6wgaeZrwJ0N", "K0RixItTLV229tIQ9volfY9Fr2yfBG4Z", "0XJd0xzB9RaoqzSBbOWrwbmO5Qd7B1Hm", "", "cDFQfUnzrKwrnb1BC8KnyL9IHyRAK9fC", "Q7Q0M0vYffDRrtcuJmKxnq", "hygqtGcON2Cep"};
    public static final String A04;
    public final Uri A00;
    public final Map<String, String> A01;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 99);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {14, 41, 49, 52, 45, 44, -24, 60, 55, -24, 55, 56, 45, 54, -24, 52, 49, 54, 51, -24, 61, 58, 52, 2, -24, -14, -17, -12, -15};
        if (A03[0].length() == 23) {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[3] = "z2LBMWL3UZ6mgEOfq1wT6wdWGhdUBaxY";
        strArr[2] = "LNV6u0tAGiEAXpu6l5ZCQkq7c5KJBKxy";
        A02 = bArr;
    }

    static {
        A01();
        A04 = FK.class.getSimpleName();
    }

    public FK(XT xt, JT jt, String str, Uri uri, Map<String, String> map, C04830m c04830m, boolean z) {
        super(xt, jt, str, c04830m, z);
        this.A00 = uri;
        this.A01 = map;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04770f
    @Nullable
    public final EnumC04760e A09() {
        try {
            LI.A08(new LI(), ((AbstractC04770f) this).A00, Uri.parse(this.A00.getQueryParameter(A00(25, 4, 35))), this.A02);
            return null;
        } catch (Exception unused) {
            String str = A00(0, 25, 101) + this.A00.toString();
            return EnumC04760e.A02;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1554d9
    public final void A0C() {
        EnumC04760e enumC04760e = null;
        if (((AbstractC1554d9) this).A01) {
            enumC04760e = A09();
        }
        A0D(this.A01, enumC04760e);
    }
}
