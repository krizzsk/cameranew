package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.8x  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C06918x extends M3 {
    public static byte[] A01;
    public final /* synthetic */ C1066Oh A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 17);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-78, -65, -65, -68, -65};
    }

    public C06918x(C1066Oh c1066Oh) {
        this.A00 = c1066Oh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C9P
    /* renamed from: A02 */
    public final void A03(C1017Mh c1017Mh) {
        InterfaceC1065Og interfaceC1065Og;
        JSONObject A03;
        new Handler(Looper.getMainLooper()).post(new RunnableC1064Of(this));
        interfaceC1065Og = this.A00.A0B;
        A03 = this.A00.A03();
        interfaceC1065Og.ACS(A00(0, 5, 60), A03);
    }
}
