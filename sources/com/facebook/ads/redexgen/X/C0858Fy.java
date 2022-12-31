package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdSize;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Fy  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0858Fy extends AbstractC1556dB<AdSize> {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 16);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{99, -95, -88, -97, -97};
    }

    public C0858Fy(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC1556dB
    /* renamed from: A00 */
    public final C0W A05(AdSize adSize) {
        String str;
        if (adSize == null) {
            str = A01(1, 4, 35);
        } else {
            str = adSize.getWidth() + A01(0, 1, 25) + adSize.getHeight();
        }
        return new C0W(this, str);
    }
}
