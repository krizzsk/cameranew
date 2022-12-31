package com.facebook.ads.redexgen.X;

import com.facebook.ads.S2SRewardedVideoAdExtendedListener;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.cA  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1495cA extends AbstractC04850o {
    public static byte[] A01;
    public static String[] A02 = {"7kSkrPID5YMo1WnvaMIgpKB6WIhQPZTc", "kYnVnFR0h3Yv", "", "4OZGrpocgzJPR2XOpe36kiptmUtlR1IY", "AELVZqmE3v", "ezzX0t3o6v3ClFiCUOYeN27kq8G", "mBbxV2ZqaJcWXY", "eL94qTtIFL"};
    public final /* synthetic */ C1493c8 A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 61);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-28, -13, -20, -53, -41, -42, -36, -38, -41, -44, -44, -51, -38, -120, -47, -37, -120, -42, -35, -44, -44};
    }

    static {
        A01();
    }

    public C1495cA(C1493c8 c1493c8) {
        this.A00 = c1493c8;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A06() {
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        s2SRewardedVideoAdExtendedListener = this.A00.A09;
        s2SRewardedVideoAdExtendedListener.onRewardServerFailed();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A07() {
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        s2SRewardedVideoAdExtendedListener = this.A00.A09;
        s2SRewardedVideoAdExtendedListener.onRewardServerSuccess();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A08() {
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        s2SRewardedVideoAdExtendedListener = this.A00.A09;
        s2SRewardedVideoAdExtendedListener.onRewardedVideoCompleted();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A09() {
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        s2SRewardedVideoAdExtendedListener = this.A00.A09;
        s2SRewardedVideoAdExtendedListener.onRewardedVideoActivityDestroyed();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A0A() {
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        C1009Lz c1009Lz;
        s2SRewardedVideoAdExtendedListener = this.A00.A09;
        s2SRewardedVideoAdExtendedListener.onRewardedVideoClosed();
        c1009Lz = this.A00.A05;
        c1009Lz.A05();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A0C() {
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        AnonymousClass21 anonymousClass21;
        s2SRewardedVideoAdExtendedListener = this.A00.A09;
        anonymousClass21 = this.A00.A0A;
        s2SRewardedVideoAdExtendedListener.onAdClicked(anonymousClass21.A00());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A0D() {
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        AnonymousClass21 anonymousClass21;
        s2SRewardedVideoAdExtendedListener = this.A00.A09;
        anonymousClass21 = this.A00.A0A;
        s2SRewardedVideoAdExtendedListener.onLoggingImpression(anonymousClass21.A00());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A0F(InterfaceC04840n interfaceC04840n) {
        F4 f4;
        F4 f42;
        AnonymousClass21 anonymousClass21;
        AnonymousClass21 anonymousClass212;
        F4 f43;
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        AnonymousClass21 anonymousClass213;
        AnonymousClass21 anonymousClass214;
        f4 = this.A00.A03;
        if (f4 == null) {
            this.A00.A08.A06().A8q(A00(0, 3, 70), C06808m.A0F, new C06818n(A00(3, 18, 43)));
            return;
        }
        C1493c8 c1493c8 = this.A00;
        f42 = c1493c8.A03;
        c1493c8.A06 = f42.A0E();
        AbstractC1533co abstractC1533co = (AbstractC1533co) interfaceC04840n;
        anonymousClass21 = this.A00.A0A;
        if (anonymousClass21.A03 != null) {
            anonymousClass214 = this.A00.A0A;
            abstractC1533co.A01(anonymousClass214.A03);
        }
        anonymousClass212 = this.A00.A0A;
        int A0D = abstractC1533co.A0D();
        String[] strArr = A02;
        if (strArr[4].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[4] = "61YjDYRNNN";
        strArr2[7] = "vT3ubuaNP5";
        anonymousClass212.A00 = A0D;
        this.A00.A07 = true;
        C1493c8 c1493c82 = this.A00;
        f43 = c1493c82.A03;
        c1493c82.A02 = f43.A0T();
        s2SRewardedVideoAdExtendedListener = this.A00.A09;
        anonymousClass213 = this.A00.A0A;
        s2SRewardedVideoAdExtendedListener.onAdLoaded(anonymousClass213.A00());
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04850o
    public final void A0G(K3 k3) {
        AnonymousClass21 anonymousClass21;
        long j2;
        S2SRewardedVideoAdExtendedListener s2SRewardedVideoAdExtendedListener;
        AnonymousClass21 anonymousClass212;
        this.A00.A0B(true);
        anonymousClass21 = this.A00.A0A;
        C0R A0D = anonymousClass21.A0B.A0D();
        j2 = this.A00.A01;
        A0D.A2a(C1008Ly.A01(j2), k3.A03().getErrorCode(), k3.A04());
        s2SRewardedVideoAdExtendedListener = this.A00.A09;
        anonymousClass212 = this.A00.A0A;
        s2SRewardedVideoAdExtendedListener.onError(anonymousClass212.A00(), LK.A00(k3));
    }
}
