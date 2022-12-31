package com.facebook.ads.redexgen.X;

import com.facebook.ads.AudienceNetworkAds;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class XG extends AbstractRunnableC0981Kv {
    public static byte[] A02;
    public final /* synthetic */ AudienceNetworkAds.InitListener A00;
    public final /* synthetic */ AudienceNetworkAds.InitResult A01;

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 70);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{17, 27, 21, 65, 17, 27, 64, 65, 94, 73, 70, 45, 100, 99, 100, 121, 100, 108, 97, 100, 119, 108, 121, 100, 98, 99, 45, 110, 98, 96, 125, 97, 104, 121, 104, 69, 66, 89, 100, 86, 81, 82};
    }

    public XG(AudienceNetworkAds.InitListener initListener, AudienceNetworkAds.InitResult initResult) {
        this.A00 = initListener;
        this.A01 = initResult;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        KI.A05(A00(35, 7, 113), A00(8, 27, 75), A00(0, 8, 100));
        this.A00.onInitialized(this.A01);
    }
}
