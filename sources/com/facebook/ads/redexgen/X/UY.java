package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class UY implements IX<String> {
    public static byte[] A00;
    public static String[] A01 = {"u8G08HFxhQG7mlQK0N08J24LskAFk0Fz", "MT2vKhidsLEKISovOxHKhqO4VFEbCdVt", "JUZDuoVTBw7gjm", "iOPubIquN8qe", "0M6TS0Q", "HZwTTDt8MowEsM3lUInYTfNVGUxvh7Fx", "C1UIBnl28yc1uc0E2ccxntR095C7RYBw", "f1f0cNh4gPGC00wb8Jrm0MnwGgNgR"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 41);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-51, -39, -46, -47, 14, -1, 18, 14, -60, -75, -56, -60, Byte.MAX_VALUE, -58, -60, -60, -87, -98, -99};
    }

    static {
        A01();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.IX
    /* renamed from: A02 */
    public final boolean A5D(String str) {
        String A0M = C0923Il.A0M(str);
        if (!TextUtils.isEmpty(A0M)) {
            if (A01[7].length() == 5) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[5] = "QIxKUOjxUFjuFXd3UTFt4bedwIhosxNy";
            strArr[0] = "KyBHe82bx80nGeQY27WRdJvWIWXouYTm";
            if ((!A0M.contains(A00(4, 4, 113)) || A0M.contains(A00(8, 8, 39))) && !A0M.contains(A00(0, 4, 60)) && !A0M.contains(A00(16, 3, 8))) {
                return true;
            }
        }
        return false;
    }
}
