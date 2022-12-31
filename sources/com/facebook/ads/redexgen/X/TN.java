package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class TN implements InterfaceC0997Ln {
    public static byte[] A03;
    public static String[] A04 = {"3JpGgMVfhEKs4h1tr8RMzDA7DOHokops", "dXqQ9QAcXKU8whF3kmnzOWjNbVMrrIOv", "otwaAvusvekoag06qMT5pISHPHVrRcMV", "WpvUEDFnYdSXMC7RGaJnlQQN5lPpeUoV", "uIVwlH6eBNHvEYk4kE6nlnhEt8muXj04", "pYVE6LchgLxW1usH7NIdAbU6pOe1Iyyx", "cgHZB3wyyqxQlT2ShG9pTXiCyg", "w9qB75SnMFWvoXL9CpdnGLUKrWLPOybN"};
    public int A00;
    @Nullable
    public String A01;
    public final InterfaceC0997Ln A02;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            byte b = copyOfRange[i5];
            String[] strArr = A04;
            if (strArr[5].charAt(25) == strArr[3].charAt(25)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[5] = "Ai5XpAh7M4hRkPfPQf54GYnUnAkHicBv";
            strArr2[3] = "aIcIWiLMc3Hy2WApHOm5eO35KvTaoUWD";
            copyOfRange[i5] = (byte) ((b - i4) - 83);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{-117, -117, 125, Byte.MIN_VALUE};
    }

    static {
        A02();
    }

    public TN(InterfaceC0997Ln interfaceC0997Ln) {
        this.A02 = interfaceC0997Ln;
    }

    private void A01() {
        if (this.A01 != null) {
            InterfaceC0997Ln interfaceC0997Ln = this.A02;
            interfaceC0997Ln.AD2(this.A01 + A00(0, 4, 10) + this.A00);
            this.A01 = null;
            this.A00 = 0;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0997Ln
    public final void AD2(String str) {
        boolean A0A;
        String A042;
        A0A = C0999Lp.A0A(str);
        if (!A0A) {
            A042 = C0999Lp.A04(str);
            if (A042.equals(this.A01)) {
                this.A00++;
                return;
            }
            A01();
            this.A01 = A042;
            this.A00 = 1;
            return;
        }
        A01();
        this.A02.AD2(str);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0997Ln
    public final void flush() {
        A01();
        this.A02.flush();
    }
}
