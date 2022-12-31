package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class FH {
    public static byte[] A03;
    public static String[] A04 = {"bxXiKI", "1uDei3qzNnKNtNYr8Y2Djp0HGajvtEV5", "mOXymc7srnaPPj6rkYKERyI3NxuvjHfL", "eLJeQSRGsG8qXjpz5HdRmaYCfpHE06ps", "tIHnpnFG5Gy9TDLwgByCKCMlkPhTptnY", "feqrkYPgdz0GJjq4", "3AbGJoGZCQZs42EqNNbBdZ7jf", "CWkuEW"};
    public CP A00;
    public final CR A01;
    public final CP[] A02;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            byte b = (byte) ((copyOfRange[i5] ^ i4) ^ 114);
            String[] strArr = A04;
            if (strArr[1].charAt(6) == strArr[3].charAt(6)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[4] = "mNEvNMISV2TsjErCZLDNSt4mIeKbSMWU";
            strArr2[2] = "pkwADRIgEHU8NI8rqtSVQew0tEayD06s";
            copyOfRange[i5] = b;
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{94, 87, 20, 24, 2, 27, 19, 87, 5, 18, 22, 19, 87, 3, 31, 18, 87, 4, 3, 5, 18, 22, 26, 89, 65, 96, 97, 106, 47, 96, 105, 47, 123, 103, 106, 47, 110, 121, 110, 102, 99, 110, 109, 99, 106, 47, 106, 119, 123, 125, 110, 108, 123, 96, 125, 124, 47, 39};
    }

    static {
        A01();
    }

    public FH(CP[] cpArr, CR cr) {
        this.A02 = cpArr;
        this.A01 = cr;
    }

    public final CP A02(CQ cq, Uri uri) throws IOException, InterruptedException {
        CP cp = this.A00;
        if (cp != null) {
            return cp;
        }
        CP[] cpArr = this.A02;
        int length = cpArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            CP cp2 = cpArr[i2];
            try {
            } catch (EOFException unused) {
            } catch (Throwable th) {
                cq.ADr();
                throw th;
            }
            if (cp2.AEj(cq)) {
                this.A00 = cp2;
                cq.ADr();
                break;
            }
            continue;
            cq.ADr();
            i2++;
        }
        CP cp3 = this.A00;
        if (A04[6].length() != 13) {
            String[] strArr = A04;
            strArr[0] = "fQ5Ua6";
            strArr[7] = "HZXGBz";
            if (cp3 != null) {
                cp3.A8A(this.A01);
                return this.A00;
            }
            throw new V0(A00(24, 34, 125) + C0923Il.A0S(this.A02) + A00(0, 24, 5), uri);
        }
        throw new RuntimeException();
    }

    public final void A03() {
        if (this.A00 != null) {
            this.A00 = null;
        }
    }
}
