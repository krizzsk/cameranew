package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Db  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0787Db {
    public static String[] A05 = {"SH4mzQnZtPKxPlKf", "URF6REnbmZYIKb79", "Y3z4Uu6uKYSt14bgOMkrNryWU1I8M7pC", "Oh4OE6e6dWqkqVraEiAcCMLeCTfZ04Gm", "v1ACOKrY4UH7FiVMLirmPA2shyqDqR5U", "uDUzXgp2odpdT3Hcc9VruLfFOAigPhBZ", "x4DnKz5Y", "xW65fi46BSoc5ty04RtWZW7HfzdvAXLT"};
    public int A00;
    public byte[] A01;
    public boolean A02;
    public boolean A03;
    public final int A04;

    public C0787Db(int i2, int i3) {
        this.A04 = i2;
        this.A01 = new byte[i3 + 3];
        this.A01[2] = 1;
    }

    public final void A00() {
        this.A03 = false;
        this.A02 = false;
    }

    public final void A01(int i2) {
        I6.A04(!this.A03);
        this.A03 = i2 == this.A04;
        boolean z = this.A03;
        String[] strArr = A05;
        if (strArr[6].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        A05[3] = "eOpOrWRcfGMpq7bOUIBYRy63hHYmgzQm";
        if (z) {
            this.A00 = 3;
            this.A02 = false;
        }
    }

    public final void A02(byte[] bArr, int i2, int i3) {
        if (!this.A03) {
            return;
        }
        int i4 = i3 - i2;
        byte[] bArr2 = this.A01;
        int length = bArr2.length;
        int i5 = this.A00;
        if (length < i5 + i4) {
            this.A01 = Arrays.copyOf(bArr2, (i5 + i4) * 2);
        }
        System.arraycopy(bArr, i2, this.A01, this.A00, i4);
        this.A00 += i4;
    }

    public final boolean A03() {
        return this.A02;
    }

    public final boolean A04(int i2) {
        if (this.A03) {
            this.A00 -= i2;
            this.A03 = false;
            this.A02 = true;
            return true;
        }
        return false;
    }
}
