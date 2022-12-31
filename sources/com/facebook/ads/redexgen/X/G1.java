package com.facebook.ads.redexgen.X;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class G1 extends AbstractC1566dL {
    public static byte[] A01;
    public static String[] A02 = {"rUhg5nWIULCK5t0gW05eAQLFFSPSWMvZ", "IWlot4Qxgt9kC5cL8sfJp7UuHzQVcIMi", "pyGO9NZUXO3VfNbPYY8A9lbBjy3aVFuI", "BR2eyutWjUUloqp0GJ1CKmWpDC9ci7iC", "R8", "7OIMX1dy42ob61A4JIfUI17XWGQLX3ws", "f7SraaJMsc9s0A0ZVYKOMxYCK6pogew2", "N778iUAZTctb3pJ5Cpi07oq2oMO9GnTO"};
    public final long A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A02;
            if (strArr[1].charAt(11) == strArr[7].charAt(11)) {
                throw new RuntimeException();
            }
            A02[2] = "gnOcZLWDvxdPQhFZXDuJbQjlKnJrGFNK";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 84);
            i5++;
        }
    }

    public static void A01() {
        A01 = new byte[]{-71, -51, -28, -116, -33, -43, -26, -47, -116, -39, -31, -33, -32, -116, -50, -47, -116, -36, -37, -33, -43, -32, -43, -30, -47, -116, -38, -31, -39, -50, -47, -34, -115};
    }

    static {
        A01();
    }

    public G1(long j2) {
        if (j2 > 0) {
            this.A00 = j2;
            return;
        }
        throw new IllegalArgumentException(A00(0, 33, 24));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1566dL
    public final boolean A08(File file, long j2, int i2) {
        return j2 <= this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1566dL, com.facebook.ads.redexgen.X.C0B
    public final /* bridge */ /* synthetic */ void AF0(File file) throws IOException {
        super.AF0(file);
    }
}
