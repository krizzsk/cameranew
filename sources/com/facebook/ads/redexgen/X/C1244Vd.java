package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Vd  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1244Vd implements DV {
    public static byte[] A06;
    public int A00;
    public int A01;
    public long A02;
    public InterfaceC0771Cb A03;
    public boolean A04;
    public final IV A05 = new IV(10);

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 123);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{25, 62, 72, 56, 54, 71, 57, 62, 67, 60, -11, 62, 67, 75, 54, 65, 62, 57, -11, 30, 25, 8, -11, 73, 54, 60, -16, 11, -38, -7, 12, 8, 11, 12, 25, 89, 104, 104, 100, 97, 91, 89, 108, 97, 103, 102, 39, 97, 92, 43};
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void A46(IV iv) {
        if (!this.A04) {
            return;
        }
        int A04 = iv.A04();
        int i2 = this.A00;
        if (i2 < 10) {
            int min = Math.min(A04, 10 - i2);
            System.arraycopy(iv.A00, iv.A06(), this.A05.A00, this.A00, min);
            if (this.A00 + min == 10) {
                this.A05.A0Y(0);
                if (73 != this.A05.A0E() || 68 != this.A05.A0E() || 51 != this.A05.A0E()) {
                    Log.w(A00(26, 9, 44), A00(0, 26, 90));
                    this.A04 = false;
                    return;
                }
                this.A05.A0Z(3);
                this.A01 = this.A05.A0D() + 10;
            }
        }
        int min2 = Math.min(A04, this.A01 - this.A00);
        this.A03.AE4(iv, min2);
        this.A00 += min2;
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void A4T(CR cr, C0795Dj c0795Dj) {
        c0795Dj.A05();
        this.A03 = cr.AF1(c0795Dj.A03(), 4);
        this.A03.A5S(Format.A0B(c0795Dj.A04(), A00(35, 15, 125), null, -1, null));
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void ACl() {
        int i2;
        if (!this.A04 || (i2 = this.A01) == 0 || this.A00 != i2) {
            return;
        }
        this.A03.AE5(this.A02, 1, i2, 0, null);
        this.A04 = false;
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void ACm(long j2, boolean z) {
        if (!z) {
            return;
        }
        this.A04 = true;
        this.A02 = j2;
        this.A01 = 0;
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void AE8() {
        this.A04 = false;
    }
}
