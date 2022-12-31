package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
/* loaded from: assets/audience_network.dex */
public final class UA implements JI {
    public static String[] A02 = {"AMQNzlG2eGPOJo74lPpddO6twtMEce", "8uZuLGh3CZSzV4eSaK74M9a8aAW81o1g", "CYs8BZmCr6kO5jRRUq4laItl384RlovT", "PO4hUmmCpilEicL1R3sLdD9hI0Kiey5Z", "WmgRsP13YsLJamj9MMjVCco3tjnpIVCq", "0ErvOAeoLZJf3MJzf6jF5Cw5BrHPqp", "S0kgbIpbc64QMPj8XCJtTK8zDrzNpUnW", "MO6xPizLQkqntlkNHRrNVg7dZ2stU5UP"};
    public final Rect A00 = new Rect();
    public final Rect A01 = new Rect();

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.dj != com.instagram.common.viewpoint.core.ViewpointData<com.facebook.ads.internal.impressionsecondchannel.model.Impression, com.facebook.ads.internal.impressionsecondchannel.state.ImpressionState> */
    public static boolean A00(C1589dj<JJ, JO> c1589dj) {
        if (c1589dj.A01.A05()) {
            return c1589dj.A02.A07();
        }
        if (!c1589dj.A01.A06()) {
            return true;
        }
        JO jo = c1589dj.A02;
        String[] strArr = A02;
        if (strArr[3].charAt(7) != strArr[2].charAt(7)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[3] = "8O0EOVeCMdEJdeSbYPFIeNjJXhTUSITs";
        strArr2[2] = "Km62DwbCV8Ma1ecjtuIU72b1y8KakI9d";
        return jo.A06();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.dj != com.instagram.common.viewpoint.core.ViewpointData<com.facebook.ads.internal.impressionsecondchannel.model.Impression, com.facebook.ads.internal.impressionsecondchannel.state.ImpressionState> */
    private boolean A01(C1589dj<JJ, JO> c1589dj, InterfaceC1578dY interfaceC1578dY) {
        float f2 = -1.0f;
        try {
            f2 = interfaceC1578dY.A7i(c1589dj);
        } catch (IllegalStateException unused) {
        }
        if (f2 <= 0.0f || !A00(c1589dj)) {
            if (c1589dj.A01.A00().getGlobalVisibleRect(this.A01) && this.A01.bottom - this.A01.top > 0 && A00(c1589dj)) {
                return true;
            }
            interfaceC1578dY.A7h(this.A00);
            interfaceC1578dY.A6f(c1589dj, this.A01);
            return (this.A00.bottom - this.A00.top > 0 && this.A01.bottom - this.A00.top > 0) && A00(c1589dj);
        }
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.dj != com.instagram.common.viewpoint.core.ViewpointData<com.facebook.ads.internal.impressionsecondchannel.model.Impression, com.facebook.ads.internal.impressionsecondchannel.state.ImpressionState> */
    public final void A02(C1589dj<JJ, JO> c1589dj, InterfaceC1578dY interfaceC1578dY) {
        if (c1589dj.A02.A04() && A01(c1589dj, interfaceC1578dY)) {
            c1589dj.A02.A01();
            c1589dj.A01.A02().A97(c1589dj.A01.A03(), c1589dj.A01.A04());
        }
        if (c1589dj.A02.A05() && JD.A13(c1589dj.A01.A01())) {
            c1589dj.A02.A02();
            c1589dj.A01.A02().A8x(c1589dj.A01.A03(), c1589dj.A01.A04());
        }
    }
}
