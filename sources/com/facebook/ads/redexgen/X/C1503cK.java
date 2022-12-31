package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.cK  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1503cK implements AnonymousClass12 {
    public static byte[] A02;
    public static String[] A03 = {"gOGPE1XGqnroAJihU7XGAfTAdWa21jWC", "Kcs30m2Uc1eFMAQARd2pOhOOSRswugkg", "xkwB", "vFLx4ryI8nKhSFQKGVnAMH5qObxMihWN", "NnwKyO2XMzRH0BXfVduboZ9DAJ5a5svW", "U3uRLxNZuwH", "U9y6Wp3Jad2LD1", "sOAhAPVwmiqriGnbgM61Uai8lTIQh97W"};
    public final /* synthetic */ F4 A00;
    public final /* synthetic */ Runnable A01;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 97);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{87, 82, 3, 82, 2, 83, 83, 112, 71, 85, 67, 80, 70, 71, 70, 2, 116, 75, 70, 71, 77, 2, 75, 79, 82, 80, 71, 81, 81, 75, 77, 76, 2, 68, 75, 80, 71, 70, 70, 71, 123, 76, 94, 72, 91, 77, 76, 77, Byte.MAX_VALUE, 64, 77, 76, 70, 104, 77, 101, 70, 78, 78, 64, 71, 78, 96, 68, 89, 91, 76, 90, 90, 64, 70, 71};
    }

    static {
        A01();
    }

    public C1503cK(F4 f4, Runnable runnable) {
        this.A00 = f4;
        this.A01 = runnable;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass12
    public final void ABu(AbstractC1533co abstractC1533co) {
        this.A00.A06.A06();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass12
    public final void ABv(AbstractC1533co abstractC1533co) {
        this.A00.A06.A07();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass12
    public final void ABw(AbstractC1533co abstractC1533co) {
        this.A00.A06.A0C();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass12
    public final void ABx(AbstractC1533co abstractC1533co) {
        this.A00.A0C().removeCallbacks(this.A01);
        F4 f4 = this.A00;
        f4.A01 = abstractC1533co;
        f4.A0F();
        this.A00.A06.A0F(abstractC1533co);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass12
    public final void ABy(AbstractC1533co abstractC1533co) {
        KI.A05(A00(38, 34, 72), A00(7, 31, 67), A00(0, 7, 7));
        this.A00.A06.A0D();
        this.A00.A0I();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass12
    public final void ABz(AbstractC1533co abstractC1533co) {
        this.A00.A06.A08();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass12
    public final void AC0(AbstractC1533co abstractC1533co, AdError adError) {
        this.A00.A0C().removeCallbacks(this.A01);
        this.A00.A0B.A0D().A4X(adError.getErrorCode(), adError.getErrorMessage());
        if (AdError.AD_PRESENTATION_ERROR.equals(adError) && JD.A1C(this.A00.A0B)) {
            this.A00.A06.A0G(K3.A00(AdErrorType.AD_PRESENTATION_ERROR));
        } else {
            F4 f4 = this.A00;
            if (A03[2].length() != 4) {
                throw new RuntimeException();
            }
            A03[2] = "s57s";
            f4.A06.A0G(K3.A00(AdErrorType.INTERNAL_ERROR));
        }
        this.A00.A0K(abstractC1533co);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass12
    public final void onRewardedVideoActivityDestroyed() {
        this.A00.A06.A09();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass12
    public final void onRewardedVideoClosed() {
        this.A00.A06.A0A();
    }
}
