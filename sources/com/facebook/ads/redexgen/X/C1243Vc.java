package com.facebook.ads.redexgen.X;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Arrays;
import java.util.Collections;
/* renamed from: com.facebook.ads.redexgen.X.Vc  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1243Vc implements DV {
    public static byte[] A0K;
    public static String[] A0L = {"hgUALiBHRBx3rc9PT3qyJLJuKriNjQIA", "JcSPF8dLSzFIe8gapkYyYGiPDe1iVZ7T", "a8IrrF5hi8IFjeZ2lIy6xY1armnYmb5o", "dI536DedIqR9AIwKwKzHAZoNzdw0gd0o", "spoCU0rWYssiPe95xKAIpCDVtAt9VbvV", "ZT5oGWr6FGwuE", "k3I4LHvMKlhfRum43HVkkWOAjRBPWhRl", "GOwjxx90kdElmS0"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public long A09;
    public long A0A;
    public long A0B;
    public Format A0C;
    public InterfaceC0771Cb A0D;
    public String A0E;
    public boolean A0F;
    public boolean A0G;
    public final String A0J;
    public final IV A0I = new IV(1024);
    public final IU A0H = new IU(this.A0I.A00);

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0K, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            int i6 = (copyOfRange[i5] - i4) - 35;
            String[] strArr = A0L;
            if (strArr[1].charAt(19) != strArr[0].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0L;
            strArr2[3] = "gooppkWHFs0OH8ZO7KHmI5JoYki0niEb";
            strArr2[4] = "gQ32BKgMXcn7uGYeyK4g8BO1uII782R4";
            copyOfRange[i5] = (byte) i6;
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0K = new byte[]{-87, -67, -84, -79, -73, 119, -75, -72, 124, -87, 117, -76, -87, -68, -75};
    }

    static {
        A04();
    }

    public C1243Vc(@Nullable String str) {
        this.A0J = str;
    }

    private int A00(IU iu) throws AS {
        int A01 = iu.A01();
        Pair<Integer, Integer> A02 = IA.A02(iu, true);
        this.A05 = ((Integer) A02.first).intValue();
        this.A02 = ((Integer) A02.second).intValue();
        return A01 - iu.A01();
    }

    private int A01(IU iu) throws AS {
        int A04;
        int i2 = 0;
        if (this.A03 == 0) {
            do {
                A04 = iu.A04(8);
                i2 += A04;
            } while (A04 == 255);
            return i2;
        }
        throw new AS();
    }

    public static long A02(IU iu) {
        return iu.A04((iu.A04(2) + 1) * 8);
    }

    private void A05(int i2) {
        this.A0I.A0W(i2);
        this.A0H.A0B(this.A0I.A00);
    }

    private void A06(IU iu) throws AS {
        if (!iu.A0F()) {
            this.A0G = true;
            A08(iu);
        } else if (!this.A0G) {
            return;
        }
        if (this.A00 == 0) {
            if (this.A04 == 0) {
                A09(iu, A01(iu));
                if (this.A0F) {
                    iu.A08((int) this.A09);
                    return;
                }
                return;
            }
            throw new AS();
        }
        throw new AS();
    }

    private void A07(IU iu) {
        this.A03 = iu.A04(3);
        int i2 = this.A03;
        if (i2 == 0) {
            iu.A08(8);
        } else if (i2 != 1) {
            if (i2 != 3 && i2 != 4 && i2 != 5) {
                if (i2 != 6) {
                    if (A0L[7].length() != 15) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0L;
                    strArr[1] = "QJhjenmrzPYVr6mrKS1ywIZfks2sEqmv";
                    strArr[0] = "rtM7Stfru76sVtn814uyI2mxrEEn9Ydu";
                    if (i2 != 7) {
                        return;
                    }
                }
                iu.A08(1);
                return;
            }
            iu.A08(6);
        } else {
            iu.A08(9);
        }
    }

    private void A08(IU iu) throws AS {
        boolean A0F;
        int numProgram = iu.A04(1);
        int bitsRead = numProgram == 1 ? iu.A04(1) : 0;
        this.A00 = bitsRead;
        if (this.A00 == 0) {
            if (numProgram == 1) {
                A02(iu);
            }
            if (iu.A0F()) {
                this.A04 = iu.A04(6);
                int A04 = iu.A04(4);
                int A042 = iu.A04(3);
                if (A04 == 0 && A042 == 0) {
                    if (numProgram == 0) {
                        int readBits = iu.A03();
                        int A00 = A00(iu);
                        iu.A07(readBits);
                        int readBits2 = A00 + 7;
                        byte[] initData = new byte[readBits2 / 8];
                        iu.A0D(initData, 0, A00);
                        Format A07 = Format.A07(this.A0E, A03(0, 15, 37), null, -1, -1, this.A02, this.A05, Collections.singletonList(initData), null, 0, this.A0J);
                        if (!A07.equals(this.A0C)) {
                            this.A0C = A07;
                            this.A0A = 1024000000 / A07.A0C;
                            this.A0D.A5S(A07);
                        }
                    } else {
                        int A02 = (int) A02(iu);
                        int bitsRead2 = A00(iu);
                        iu.A08(A02 - bitsRead2);
                    }
                    A07(iu);
                    this.A0F = iu.A0F();
                    this.A09 = 0L;
                    if (this.A0F) {
                        if (numProgram == 1) {
                            this.A09 = A02(iu);
                        } else {
                            do {
                                A0F = iu.A0F();
                                this.A09 = (this.A09 << 8) + iu.A04(8);
                            } while (A0F);
                        }
                    }
                    if (iu.A0F()) {
                        iu.A08(8);
                        return;
                    }
                    return;
                }
                throw new AS();
            }
            throw new AS();
        }
        throw new AS();
    }

    private void A09(IU iu, int i2) {
        int A03 = iu.A03();
        if ((A03 & 7) == 0) {
            this.A0I.A0Y(A03 >> 3);
        } else {
            iu.A0D(this.A0I.A00, 0, i2 * 8);
            this.A0I.A0Y(0);
        }
        this.A0D.AE4(this.A0I, i2);
        this.A0D.AE5(this.A0B, 1, i2, 0, null);
        this.A0B += this.A0A;
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void A46(IV iv) throws AS {
        while (iv.A04() > 0) {
            int i2 = this.A08;
            if (i2 != 0) {
                if (i2 == 1) {
                    int A0E = iv.A0E();
                    if ((A0E & 224) == 224) {
                        this.A07 = A0E;
                        this.A08 = 2;
                    } else if (A0E != 86) {
                        this.A08 = 0;
                    }
                } else if (A0L[7].length() != 15) {
                    throw new RuntimeException();
                } else {
                    String[] strArr = A0L;
                    strArr[3] = "eXMY6UfuU8mptnxKZK3KjbCMiU1pAKNs";
                    strArr[4] = "BrFOrdIatggcu5HdAKqvOHyOVIidANWA";
                    if (i2 == 2) {
                        this.A06 = ((this.A07 & (-225)) << 8) | iv.A0E();
                        if (this.A06 > this.A0I.A00.length) {
                            A05(this.A06);
                        }
                        this.A01 = 0;
                        this.A08 = 3;
                    } else if (i2 == 3) {
                        int min = Math.min(iv.A04(), this.A06 - this.A01);
                        iv.A0c(this.A0H.A00, this.A01, min);
                        this.A01 += min;
                        if (this.A01 == this.A06) {
                            this.A0H.A07(0);
                            A06(this.A0H);
                            this.A08 = 0;
                        }
                    }
                }
            } else if (iv.A0E() == 86) {
                this.A08 = 1;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void A4T(CR cr, C0795Dj c0795Dj) {
        c0795Dj.A05();
        this.A0D = cr.AF1(c0795Dj.A03(), 1);
        this.A0E = c0795Dj.A04();
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void ACl() {
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void ACm(long j2, boolean z) {
        this.A0B = j2;
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void AE8() {
        this.A08 = 0;
        this.A0G = false;
    }
}
