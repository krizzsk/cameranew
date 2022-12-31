package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Fp  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0851Fp extends AbstractC1556dB<EnumC04740c> {
    public static byte[] A00;
    public static String[] A01 = {"nfOmdPRKy6dJXhDeozy3bec4eprLIoSQ", "SpNSu", "KnwtHm0RppTzgOMyhwsp1PpmZykcOlps", "rm2Q4", "VxhbZsLUCIIY3eK9iwu", "VDpaDUxovSHskE3K7Rzj9CiAPD6OjiUH", "VHZOT7bXdVoDaPP", "SrW2lLCi4fFkH4TY8LZz6iOiSZQwKo1F"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A01;
            if (strArr[1].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            A01[5] = "VLAsB6FpgF6HHUeMgZV0uCFNDiYuOANh";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 46);
            i5++;
        }
    }

    public static void A01() {
        A00 = new byte[]{19, 26, 17, 17};
    }

    static {
        A01();
    }

    public C0851Fp(String str) {
        super(str);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1556dB
    /* renamed from: A06 */
    public final C0W A05(@Nullable EnumC04740c enumC04740c) {
        String A02;
        if (enumC04740c != null) {
            A02 = enumC04740c.A02();
        } else if (A01[0].charAt(24) == 'c') {
            throw new RuntimeException();
        } else {
            A01[2] = "FtIMifYPiEAUkOQozBm9Vw11LGuuRK56";
            A02 = A00(0, 4, 119);
        }
        return new C0W(this, A02);
    }
}
