package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.cO  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1507cO implements AnonymousClass11 {
    public static byte[] A07;
    public static String[] A08 = {"NdU3dTBV9vpPy6YybD2Qky8Xp9oiymUK", "iGXlqhzjj4re98AW13mRmUxQt0ip7heY", "i4JUsV98mtHDxTx4GI", "uX4rqc35PVKyGMlab4Ievks4AeXTKuCR", "rLO13ppjW7wMy", "YX8F9O1K3gbo5OniWABn3Un2bmHHQded", "vQnjhTu4uDmsPPd6tCmWM2PRV3nZ7tVA", "6doRqStA7fW6oocsKlayDSgQ6jqa5ScM"};
    public final /* synthetic */ long A03;
    public final /* synthetic */ F6 A04;
    public final /* synthetic */ AnonymousClass92 A05;
    public final /* synthetic */ Runnable A06;
    public boolean A02 = false;
    public boolean A01 = false;
    public boolean A00 = false;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 102);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{57, 46, 46, 51, 46, 67, 93, 73};
    }

    static {
        A01();
    }

    public C1507cO(F6 f6, Runnable runnable, long j2, AnonymousClass92 anonymousClass92) {
        this.A04 = f6;
        this.A06 = runnable;
        this.A03 = j2;
        this.A05 = anonymousClass92;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass11
    public final void ABL(C1543cy c1543cy) {
        if (!this.A00) {
            this.A00 = true;
            this.A04.A05(this.A05.A03(AnonymousClass96.A03), null);
        }
        if (this.A04.A06 != null) {
            this.A04.A06.A0C();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass11
    public final void ABM(C1543cy c1543cy) {
        Map A01;
        if (c1543cy != this.A04.A00) {
            return;
        }
        this.A04.A0C().removeCallbacks(this.A06);
        F6 f6 = this.A04;
        f6.A01 = c1543cy;
        f6.A06.A0F(c1543cy);
        if (!this.A02) {
            this.A02 = true;
            A01 = this.A04.A01(this.A03);
            this.A04.A05(this.A05.A03(AnonymousClass96.A05), A01);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass11
    public final void ABN(C1543cy c1543cy) {
        if (!this.A01) {
            this.A01 = true;
            F6 f6 = this.A04;
            AnonymousClass92 anonymousClass92 = this.A05;
            AnonymousClass96 anonymousClass96 = AnonymousClass96.A04;
            String[] strArr = A08;
            if (strArr[3].charAt(16) != strArr[0].charAt(16)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[3] = "w5hMaJohNUScvyTMb6YchiksjKW7iU2S";
            strArr2[0] = "lwejxTPFHVjkcDrib15s3w6szJ9sWeR6";
            f6.A05(anonymousClass92.A03(anonymousClass96), null);
        }
        this.A04.A0I();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass11
    public final void ABP(C1543cy c1543cy, K3 k3) {
        Map A01;
        if (c1543cy != this.A04.A00) {
            return;
        }
        this.A04.A0C().removeCallbacks(this.A06);
        this.A04.A0K(c1543cy);
        if (!this.A02) {
            this.A02 = true;
            A01 = this.A04.A01(this.A03);
            A01.put(A00(0, 5, 58), String.valueOf(k3.A03().getErrorCode()));
            A01.put(A00(5, 3, 72), String.valueOf(k3.A04()));
            this.A04.A05(this.A05.A03(AnonymousClass96.A05), A01);
        }
        this.A04.AAW(k3);
    }
}
