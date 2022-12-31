package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.api.BuildConfigApi;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.Locale;
/* renamed from: com.facebook.ads.redexgen.X.as  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1422as implements C5W {
    public static byte[] A02;
    public static final String A03;
    public final C5Z A00;
    public final C7J A01;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 112);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{50, 84, 71, 78, 81, 67, 70, 75, 80, 73, 2, 7, 70, 2, 67, 85, 85, 71, 86, 85, 58, 92, 79, 86, 89, 75, 78, 83, 88, 81, 10, 83, 87, 75, 81, 79, 36, 10, 15, 93, 35, 69, 56, 63, 66, 52, 55, 60, 65, 58, -13, 64, 52, 69, 62, 72, 67, Draft_75.CR, -13, -8, 70, 25, 59, 46, 53, 56, 42, 45, 50, 55, 48, -23, 63, 50, 45, 46, 56, 3, -23, -18, 60, -33, -82, -31, -31, -79, -78, -81, -81, -88, -35, -77, -82, -83, -88, -84, -84, -32, -76, -88, -36, -83, -36, -82, -88, -83, -36, -83, -36, -32, -83, -33, -35, -34, -34, -32, -81, 58, 60, 47, 48, 47, 62, 45, 50, 19, 12, 9, 12, Draft_75.CR, 21, 12};
    }

    static {
        A02();
        A03 = C1422as.class.getSimpleName();
    }

    public C1422as(C5Z c5z, XS xs) {
        this.A00 = c5z;
        this.A00.A3C(new C1424au(this));
        this.A01 = new C7J(xs);
        A01();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A01() {
        if (BuildConfigApi.isDebug()) {
            String.format(Locale.US, A00(0, 20, 114), Integer.valueOf(this.A00.A5g().size()));
        }
        for (InterfaceC06025c interfaceC06025c : this.A00.A5g()) {
            int i2 = C5Y.A00[interfaceC06025c.A7c().ordinal()];
            if (i2 == 1) {
                A04(interfaceC06025c.getUrl());
            } else if (i2 == 2) {
                A06(interfaceC06025c.getUrl());
            } else if (i2 == 3) {
                A05(interfaceC06025c.getUrl());
            }
        }
        this.A01.A0U(new C1423at(this), new C7C(A00(81, 36, 11), A00(125, 7, 46)));
    }

    private void A04(String str) {
        if (BuildConfigApi.isDebug()) {
            String.format(Locale.US, A00(20, 20, 122), str);
        }
        C7G c7g = new C7G(str, -1, -1, A00(81, 36, 11), A00(125, 7, 46));
        c7g.A01 = A00(117, 8, 90);
        this.A01.A0V(c7g);
    }

    private void A05(String str) {
        if (BuildConfigApi.isDebug()) {
            String.format(Locale.US, A00(40, 21, 99), str);
        }
        C7I c7i = new C7I(str, A00(81, 36, 11), A00(125, 7, 46));
        c7i.A04 = true;
        c7i.A02 = A00(117, 8, 90);
        this.A01.A0X(c7i);
    }

    private void A06(String str) {
        if (BuildConfigApi.isDebug()) {
            String.format(Locale.US, A00(61, 20, 89), str);
        }
        C7I c7i = new C7I(str, A00(81, 36, 11), A00(125, 7, 46));
        c7i.A04 = false;
        c7i.A02 = A00(117, 8, 90);
        this.A01.A0a(c7i);
    }
}
