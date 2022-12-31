package com.facebook.ads.redexgen.X;

import android.util.Log;
import android.util.Pair;
import com.facebook.ads.internal.exoplayer2.Format;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.Collections;
/* loaded from: assets/audience_network.dex */
public final class Vk implements DV {
    public static byte[] A0H;
    public static String[] A0I = {"wge6vcbYVd2LlwU9IzXxO7y1yc7Npjql", "e4ah1", "HxlECSCujzZIBhcakhB8llOPpIPg4jPi", "c3jgZ7razfwrLoite54T", "YnWTxT53I9VC0eKuEFoJi1GxqSMOrSIM", "mGJBSiyG9M2YGViPKeXmqCjoZalx0YC5", "VtpTHv8dn8NrwXo7ikKBEmVWKD8j4YCX", "dqOZRsMzwGVkln1A4hbisIXuNnIWGGSy"};
    public static final byte[] A0J;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public long A05;
    public long A06;
    public InterfaceC0771Cb A07;
    public InterfaceC0771Cb A08;
    public InterfaceC0771Cb A09;
    public String A0A;
    public boolean A0B;
    public boolean A0C;
    public final IU A0D;
    public final IV A0E;
    public final String A0F;
    public final boolean A0G;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0H, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            byte b = (byte) ((copyOfRange[i5] - i4) - 49);
            if (A0I[4].charAt(1) != 'n') {
                throw new RuntimeException();
            }
            A0I[4] = "bnluMaXE1Uw3b3JGoNOZfy6HcCqjlXqz";
            copyOfRange[i5] = b;
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A0H = new byte[]{-120, 124, -66, -47, -48, 124, -67, -49, -49, -47, -55, -59, -54, -61, 124, -99, -99, -97, 124, -88, -97, -118, -118, -83, -67, -68, -101, -82, -86, -83, -82, -69, -18, 15, 30, 15, Draft_75.CR, 30, 15, 14, -54, 11, 31, 14, 19, 25, -54, 25, 12, 20, 15, Draft_75.CR, 30, -54, 30, 35, 26, 15, -28, -54, -26, -11, -11, -15, -18, -24, -26, -7, -18, -12, -13, -76, -18, -23, -72, 16, 36, 19, 24, 30, -34, 28, 31, -29, 16, -36, 27, 16, 35, 28};
    }

    static {
        A06();
        A0J = new byte[]{73, 68, 51};
    }

    public Vk(boolean z) {
        this(z, null);
    }

    public Vk(boolean z, String str) {
        this.A0D = new IU(new byte[7]);
        this.A0E = new IV(Arrays.copyOf(A0J, 10));
        A03();
        this.A0G = z;
        this.A0F = str;
    }

    private void A01() throws AS {
        this.A0D.A07(0);
        if (!this.A0C) {
            int A04 = this.A0D.A04(2) + 1;
            if (A04 != 2) {
                Log.w(A00(22, 10, 24), A00(32, 28, 121) + A04 + A00(0, 22, 43));
                A04 = 2;
            }
            int A042 = this.A0D.A04(4);
            this.A0D.A08(1);
            int sampleRateIndex = this.A0D.A04(3);
            byte[] A07 = IA.A07(A04, A042, sampleRateIndex);
            Pair<Integer, Integer> A03 = IA.A03(A07);
            Format A072 = Format.A07(this.A0A, A00(75, 15, 126), null, -1, -1, ((Integer) A03.second).intValue(), ((Integer) A03.first).intValue(), Collections.singletonList(A07), null, 0, this.A0F);
            this.A05 = 1024000000 / A072.A0C;
            this.A09.A5S(A072);
            this.A0C = true;
        } else {
            IU iu = this.A0D;
            String[] strArr = A0I;
            String str = strArr[3];
            String str2 = strArr[1];
            int length = str.length();
            int sampleSize = str2.length();
            if (length == sampleSize) {
                throw new RuntimeException();
            }
            A0I[4] = "gnfbeCT7ETb0BF6eGTwxRLZIMNoo6eBq";
            iu.A08(10);
        }
        this.A0D.A08(4);
        int A043 = (this.A0D.A04(13) - 2) - 5;
        if (this.A0B) {
            A043 -= 2;
        }
        InterfaceC0771Cb interfaceC0771Cb = this.A09;
        long j2 = this.A05;
        if (A0I[0].charAt(1) != 'g') {
            throw new RuntimeException();
        }
        String[] strArr2 = A0I;
        strArr2[5] = "DPeEZCdjnoP4QwMjUw7HIDON5EObNWtY";
        strArr2[6] = "TWt76gMmW2EkEQM2OhdsBT8X6vSrq3Ij";
        A07(interfaceC0771Cb, j2, 0, A043);
    }

    private void A02() {
        this.A08.AE4(this.A0E, 10);
        this.A0E.A0Y(6);
        A07(this.A08, 0L, 10, this.A0E.A0D() + 10);
    }

    private void A03() {
        this.A03 = 0;
        this.A00 = 0;
        this.A01 = 256;
    }

    private void A04() {
        this.A03 = 2;
        this.A00 = 0;
    }

    private void A05() {
        this.A03 = 1;
        this.A00 = A0J.length;
        this.A02 = 0;
        this.A0E.A0Y(0);
    }

    private void A07(InterfaceC0771Cb interfaceC0771Cb, long j2, int i2, int i3) {
        this.A03 = 3;
        this.A00 = i2;
        this.A07 = interfaceC0771Cb;
        this.A04 = j2;
        this.A02 = i3;
    }

    private void A08(IV iv) {
        byte[] bArr = iv.A00;
        int position = iv.A06();
        int A07 = iv.A07();
        while (position < A07) {
            int i2 = position + 1;
            int i3 = bArr[position] & Draft_75.END_OF_FRAME;
            int position2 = this.A01;
            if (position2 == 512 && i3 >= 240 && i3 != 255) {
                int position3 = i3 & 1;
                this.A0B = position3 == 0;
                A04();
                iv.A0Y(i2);
                return;
            }
            int i4 = this.A01;
            int i5 = i4 | i3;
            if (i5 == 329) {
                this.A01 = 768;
            } else if (i5 == 511) {
                this.A01 = 512;
            } else if (i5 == 836) {
                this.A01 = 1024;
            } else if (i5 != 1075) {
                if (i4 != 256) {
                    this.A01 = 256;
                    position = i2 - 1;
                }
            } else {
                A05();
                iv.A0Y(i2);
                return;
            }
            position = i2;
        }
        iv.A0Y(position);
    }

    private void A09(IV iv) {
        int min = Math.min(iv.A04(), this.A02 - this.A00);
        this.A07.AE4(iv, min);
        this.A00 += min;
        int i2 = this.A00;
        int i3 = this.A02;
        if (i2 == i3) {
            this.A07.AE5(this.A06, 1, i3, 0, null);
            this.A06 += this.A04;
            A03();
        }
    }

    private boolean A0A(IV iv, byte[] bArr, int i2) {
        int min = Math.min(iv.A04(), i2 - this.A00);
        iv.A0c(bArr, this.A00, min);
        this.A00 += min;
        return this.A00 == i2;
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void A46(IV iv) throws AS {
        while (iv.A04() > 0) {
            int i2 = this.A03;
            if (i2 == 0) {
                A08(iv);
            } else if (i2 != 1) {
                String[] strArr = A0I;
                if (strArr[5].charAt(25) == strArr[6].charAt(25)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0I;
                strArr2[5] = "9CqnxzaEQimEcBf5cSINZxdBysafSxdF";
                strArr2[6] = "zLp55t2V8ycwykcXwXcmLQHdTFNUXCiS";
                if (i2 == 2) {
                    boolean A0A = A0A(iv, this.A0D.A00, this.A0B ? 7 : 5);
                    if (A0I[0].charAt(1) == 'g') {
                        String[] strArr3 = A0I;
                        strArr3[3] = "PBSyuwIG2tPzzgRnoBM9";
                        strArr3[1] = "owzwp";
                        if (A0A) {
                            A01();
                        }
                    } else if (A0A) {
                        A01();
                    }
                } else if (i2 == 3) {
                    A09(iv);
                }
            } else if (A0A(iv, this.A0E.A00, 10)) {
                A02();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void A4T(CR cr, C0795Dj c0795Dj) {
        c0795Dj.A05();
        this.A0A = c0795Dj.A04();
        this.A09 = cr.AF1(c0795Dj.A03(), 1);
        if (this.A0G) {
            c0795Dj.A05();
            this.A08 = cr.AF1(c0795Dj.A03(), 4);
            this.A08.A5S(Format.A0B(c0795Dj.A04(), A00(60, 15, 84), null, -1, null));
            return;
        }
        this.A08 = new WP();
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void ACl() {
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void ACm(long j2, boolean z) {
        this.A06 = j2;
    }

    @Override // com.facebook.ads.redexgen.X.DV
    public final void AE8() {
        A03();
    }
}
