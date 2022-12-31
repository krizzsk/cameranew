package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class VW implements InterfaceC0789Dd {
    public static byte[] A03;
    public static String[] A04 = {"9dIhF2X5qYPGZcPrMQjFeU2FMq4Icb5t", "C7lZKzl2OzNugbLE4QJixcZrlcSgCGI7", "v7kvgcbsYqtq4Ou8B7XlURjv8wkzUozH", "8BzUB2zJ4MAZsKVthH28T9QXZJlG29jD", "wOgdV6BnuyxARX3Rbc0CvFDDXWIKfgjM", "mpBmZ", "f47n1mRwiFyOsV4myeWB5UC2YKJiwKop", "3tKYH9iJUyIyPmbH9Trftcv4NWgUsp5b"};
    public InterfaceC0771Cb A00;
    public C0919Ih A01;
    public boolean A02;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 96);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{11, 26, 26, 22, 19, Draft_75.CR, 11, 30, 19, 25, 24, -39, 34, -41, 29, Draft_75.CR, 30, 15, -35, -33};
    }

    static {
        A01();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0789Dd
    public final void A46(IV iv) {
        if (!this.A02) {
            if (this.A01.A05() == -9223372036854775807L) {
                return;
            }
            this.A00.A5S(Format.A02(null, A00(0, 20, 74), this.A01.A05()));
            this.A02 = true;
        }
        int A042 = iv.A04();
        this.A00.AE4(iv, A042);
        InterfaceC0771Cb interfaceC0771Cb = this.A00;
        if (A04[0].charAt(13) != 'c') {
            throw new RuntimeException();
        }
        A04[0] = "M4wOXnroCREOIcf8T96EgrMDUu9ExHmM";
        interfaceC0771Cb.AE5(this.A01.A04(), 1, A042, 0, null);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0789Dd
    public final void A8C(C0919Ih c0919Ih, CR cr, C0795Dj c0795Dj) {
        this.A01 = c0919Ih;
        c0795Dj.A05();
        this.A00 = cr.AF1(c0795Dj.A03(), 4);
        this.A00.A5S(Format.A0B(c0795Dj.A04(), A00(0, 20, 74), null, -1, null));
    }
}
