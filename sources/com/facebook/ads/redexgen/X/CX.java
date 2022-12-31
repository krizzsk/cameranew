package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class CX {
    public static byte[] A02;
    public final CZ A00;
    public final CZ A01;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 78);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-54, -66, 1, 22};
    }

    public CX(CZ cz) {
        this(cz, cz);
    }

    public CX(CZ cz, CZ cz2) {
        this.A00 = (CZ) I6.A01(cz);
        this.A01 = (CZ) I6.A01(cz2);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CX cx = (CX) obj;
        return this.A00.equals(cx.A00) && this.A01.equals(cx.A01);
    }

    public final int hashCode() {
        return (this.A00.hashCode() * 31) + this.A01.hashCode();
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(A00(2, 1, 88));
        sb.append(this.A00);
        if (this.A00.equals(this.A01)) {
            str = A00(0, 0, 98);
        } else {
            str = A00(0, 2, 80) + this.A01;
        }
        sb.append(str);
        sb.append(A00(3, 1, 107));
        return sb.toString();
    }
}
