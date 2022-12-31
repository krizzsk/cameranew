package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import com.facebook.ads.NativeAdBase;
import java.util.Arrays;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.b1  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1431b1 implements InterfaceC05141r {
    public static byte[] A03;
    public C5J A00;
    public XT A01;
    public final NativeAdBase.MediaCacheFlag A02;

    static {
        A03();
    }

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 87);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{59, 52, 33, 60, 35, 48, 100, Byte.MAX_VALUE, 122, Byte.MAX_VALUE, 126, 102, Byte.MAX_VALUE};
    }

    public C1431b1(C5J c5j, XT xt, NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        this.A00 = c5j;
        this.A01 = xt;
        this.A02 = mediaCacheFlag;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05141r
    public final void AAW(K3 k3) {
        C0973Km.A00(new C1434b4(this, k3));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC05141r
    public final void ABO(List<C1543cy> list) {
        C7J c7j = new C7J(this.A01);
        String A02 = A02(6, 7, 70);
        for (C1543cy c1543cy : list) {
            if (A02(6, 7, 70).equals(A02)) {
                A02 = c1543cy.A0S();
            }
            if (this.A02.equals(NativeAdBase.MediaCacheFlag.ALL)) {
                if (c1543cy.A0L() != null) {
                    c7j.A0V(new C7G(c1543cy.A0L().getUrl(), c1543cy.A0L().getHeight(), c1543cy.A0L().getWidth(), c1543cy.A0S(), A02(0, 6, 2)));
                }
                if (c1543cy.A0K() != null) {
                    c7j.A0V(new C7G(c1543cy.A0K().getUrl(), c1543cy.A0K().getHeight(), c1543cy.A0K().getWidth(), c1543cy.A0S(), A02(0, 6, 2)));
                }
                if (!TextUtils.isEmpty(c1543cy.A0U())) {
                    c7j.A0a(new C7I(c1543cy.A0U(), c1543cy.A0S(), A02(0, 6, 2), c1543cy.A0O().longValue()));
                }
            }
        }
        c7j.A0U(new C1432b2(this, list), new C7C(A02, A02(0, 6, 2)));
    }
}
