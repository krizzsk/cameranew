package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.util.Arrays;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class FV extends AbstractC1554d9 {
    public static byte[] A02;
    public static String[] A03 = {"OXbCEMjwdPN5xvU2NT0kKgep5UeL1Sqr", "SX0ygsPxRN6KiRybC8JMsMv996SDI", "L77PzfY5dGd9ppcaJeqEYdg5mL", "qaE4mxmFDXDzve4pMTR5s0xQhV", "rrEUCxltihDw1phZ7LTyezPpJ6vgfWBl", "FdpTQfSalwXKw6iuOYHl49ZbqEAaQDuv", "IFg4N7XoM6S2Rxr", "IzcF2xeWDVSzXIhxKqlgaOjlVHZ1W1Z3"};
    public Map<String, String> A00;
    public final Uri A01;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 16);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {104, 109, 106, 111};
        if (A03[5].charAt(30) != 'u') {
            throw new RuntimeException();
        }
        A03[5] = "82m81CO1d0OwjHPL38rD7xdABiLQ6kup";
        A02 = bArr;
    }

    static {
        A01();
    }

    public FV(XT xt, JT jt, String str, Uri uri, Map<String, String> map) {
        super(xt, jt, str, null, true);
        this.A01 = uri;
        this.A00 = map;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1554d9
    public final void A0C() {
        A0D(this.A00, null);
    }

    public final Uri A0E() {
        return Uri.parse(this.A01.getQueryParameter(A00(0, 4, 20)));
    }
}
