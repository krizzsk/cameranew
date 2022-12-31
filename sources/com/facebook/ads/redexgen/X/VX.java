package com.facebook.ads.redexgen.X;

import androidx.core.view.InputDeviceCompat;
/* loaded from: assets/audience_network.dex */
public final class VX implements InterfaceC0796Dk {
    public static String[] A06 = {"kFQyFzcAtW9h", "T9w", "fQaNjl3SJX3d9bVQ", "oZJ95vdSt2TTHBWCj0JXn5a7ndpZ8Bju", "u9yp8kydrxa7", "6VdIrZzllDHdfU7GHzHok5zrzcn9yZKG", "C5", "TRfT7Vv0"};
    public int A00;
    public int A01;
    public boolean A02;
    public boolean A03;
    public final InterfaceC0789Dd A04;
    public final IV A05 = new IV(32);

    public VX(InterfaceC0789Dd interfaceC0789Dd) {
        this.A04 = interfaceC0789Dd;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0796Dk
    public final void A47(IV iv, boolean z) {
        int i2 = -1;
        if (z) {
            i2 = iv.A06() + iv.A0E();
        }
        boolean z2 = this.A03;
        if (A06[1].length() == 27) {
            throw new RuntimeException();
        }
        A06[7] = "Nc9T8xtu";
        if (z2) {
            if (!z) {
                return;
            }
            this.A03 = false;
            iv.A0Y(i2);
            this.A00 = 0;
        }
        while (iv.A04() > 0) {
            int i3 = this.A00;
            if (i3 < 3) {
                if (i3 == 0) {
                    int A0E = iv.A0E();
                    iv.A0Y(iv.A06() - 1);
                    if (A06[7].length() != 8) {
                        throw new RuntimeException();
                    }
                    A06[2] = "aJNwIS78aN3JetqFlJ8G";
                    if (A0E == 255) {
                        this.A03 = true;
                        return;
                    }
                }
                int min = Math.min(iv.A04(), 3 - this.A00);
                iv.A0c(this.A05.A00, this.A00, min);
                this.A00 += min;
                if (this.A00 == 3) {
                    this.A05.A0W(3);
                    this.A05.A0Z(1);
                    int A0E2 = this.A05.A0E();
                    int A0E3 = this.A05.A0E();
                    this.A02 = (A0E2 & 128) != 0;
                    this.A01 = (((A0E2 & 15) << 8) | A0E3) + 3;
                    if (this.A05.A05() < this.A01) {
                        byte[] bytes = this.A05.A00;
                        this.A05.A0W(Math.min((int) InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(this.A01, bytes.length * 2)));
                        System.arraycopy(bytes, 0, this.A05.A00, 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(iv.A04(), this.A01 - this.A00);
                iv.A0c(this.A05.A00, this.A00, min2);
                this.A00 += min2;
                int i4 = this.A00;
                int i5 = this.A01;
                if (i4 == i5) {
                    boolean z3 = this.A02;
                    if (A06[7].length() != 8) {
                        throw new RuntimeException();
                    }
                    A06[1] = "WscUDiyP9zB";
                    if (z3) {
                        if (C0923Il.A09(this.A05.A00, 0, this.A01, -1) != 0) {
                            this.A03 = true;
                            return;
                        }
                        IV iv2 = this.A05;
                        int thirdHeaderByte = this.A01 - 4;
                        if (A06[2].length() != 29) {
                            String[] strArr = A06;
                            strArr[3] = "nNiCCranccCPI0NRpeExr6ylwZyZykwG";
                            strArr[5] = "pfAdcnCCuWORkUPhfNuwqkYYK2fT2IOL";
                            iv2.A0W(thirdHeaderByte);
                        } else {
                            A06[2] = "0kjAgxStX";
                            iv2.A0W(thirdHeaderByte);
                        }
                    } else {
                        this.A05.A0W(i5);
                    }
                    this.A04.A46(this.A05);
                    this.A00 = 0;
                } else {
                    continue;
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0796Dk
    public final void A8C(C0919Ih c0919Ih, CR cr, C0795Dj c0795Dj) {
        this.A04.A8C(c0919Ih, cr, c0795Dj);
        this.A03 = true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0796Dk
    public final void AE8() {
        this.A03 = true;
    }
}
