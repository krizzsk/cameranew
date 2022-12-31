package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.cH  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1501cH extends AbstractRunnableC0981Kv {
    public static byte[] A01;
    public final /* synthetic */ AbstractC1500cG A00;

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 19);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{109, -114, -100, -99, -101, -104, -94, 73, -96, -118, -100, 73, -105, -104, -99, 73, -116, -118, -107, -107, -114, -115, 87, -46, -50, -51, 1, -16, -11, -15, -6, -17, -15, -38, -15, 0, 3, -5, -2, -9, -22, 0, 6, -79, -11, -6, -11, -1, -72, 5, -79, -12, -14, -3, -3, -79, -11, -10, 4, 5, 3, 0, 10, -71, -70, -79, -9, 0, 3, -79, -46, -11, -79, -32, -13, -5, -10, -12, 5, -65, -79, -27, -7, -6, 4, -79, -2, -14, 10, -79, -3, -10, -14, -11, -79, 5, 0, -79, -3, -10, -14, -4, -6, -1, -8, -79, -2, -10, -2, 0, 3, 10, -65, -79, -31, -3, -10, -14, 4, -10, -67, -79, -14, -3, 8, -14, 10, 4, -79, -12, -14, -3, -3, -79, -11, -10, 4, 5, 3, 0, 10, -71, -70, -79, 8, -7, -10, -1, -79, 10, 0, 6, -79, -11, 0, -1, -72, 5, -79, -1, -10, -10, -11, -79, 5, -7, -6, 4, -79, -46, -11, -79, -32, -13, -5, -10, -12, 5, -79, -14, -1, 10, -79, -2, 0, 3, -10, -65, -34, -19, -26};
    }

    public C1501cH(AbstractC1500cG abstractC1500cG) {
        this.A00 = abstractC1500cG;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        this.A00.A01.A0D().A2i();
        if (this.A00.A00.A5a() == EnumC05161t.A04) {
            return;
        }
        if (!BuildConfigApi.isDebug()) {
            this.A00.A01.A06().A98(A00(188, 3, 106), C06808m.A0Q, new C06818n(A00(0, 23, 22)));
        }
        Log.e(A00(23, 17, 121), A00(40, 148, 126));
        this.A00.A05();
    }
}
