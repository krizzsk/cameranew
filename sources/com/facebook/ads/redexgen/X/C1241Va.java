package com.facebook.ads.redexgen.X;

import android.util.Log;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Va  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1241Va implements InterfaceC0796Dk {
    public static byte[] A0C;
    public static String[] A0D = {"yUSRg3C4669fvLzuOHW1XSLd3PantLKL", "TfD3AbKeF9VAaUscqyzwwU3jFt7tVTiq", "g0WIbq4DK90SLCQEiKu8stzXkqWEOBgJ", "mQ9LzXZ", "LtvBgOfO2pmZDU6uCsowjLyYxKVOoB", "Sd9ouEoM5pzgzW5N1jQmDkMiOeFHRcqL", "5alPEFiVNlXDBdXEKmvVdaMyQKz58nOe", "TNFmsx2lI6S26ML"};
    public int A00;
    public int A01;
    public int A02;
    public long A04;
    public C0919Ih A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public final DV A0A;
    public final IU A0B = new IU(new byte[10]);
    public int A03 = 0;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 72);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0C = new byte[]{-29, 48, 50, 53, 40, -29, 37, 60, 55, 40, 54, -58, -37, -23, -56, -37, -41, -38, -37, -24, -28, -3, -12, 7, -1, -12, -14, 3, -12, -13, -81, 2, 3, -16, 1, 3, -81, -14, -2, -13, -12, -81, -1, 1, -12, -11, -8, 7, -55, -81, -20, 5, -4, 15, 7, -4, -6, 11, -4, -5, -73, 10, 11, -8, 9, 11, -73, 0, 5, -5, 0, -6, -8, 11, 6, 9, -73, 9, -4, -8, -5, 0, 5, -2, -73, -4, 15, 11, -4, 5, -5, -4, -5, -73, -1, -4, -8, -5, -4, 9, -47, -22, -31, -12, -20, -31, -33, -16, -31, -32, -100, -17, -16, -35, -18, -16, -100, -27, -22, -32, -27, -33, -35, -16, -21, -18, -74, -100, -31, -12, -20, -31, -33, -16, -31, -32, -100};
    }

    static {
        A02();
    }

    public C1241Va(DV dv) {
        this.A0A = dv;
    }

    private void A01() {
        this.A0B.A07(0);
        this.A04 = -9223372036854775807L;
        if (this.A08) {
            this.A0B.A08(4);
            this.A0B.A08(1);
            this.A0B.A08(1);
            long A04 = (this.A0B.A04(3) << 30) | (this.A0B.A04(15) << 15) | this.A0B.A04(15);
            this.A0B.A08(1);
            if (!this.A09 && this.A07) {
                this.A0B.A08(4);
                this.A0B.A08(1);
                this.A0B.A08(1);
                this.A0B.A08(1);
                this.A05.A07((this.A0B.A04(3) << 30) | (this.A0B.A04(15) << 15) | this.A0B.A04(15));
                this.A09 = true;
            }
            long pts = this.A05.A07(A04);
            this.A04 = pts;
        }
    }

    private void A03(int i2) {
        this.A03 = i2;
        this.A00 = 0;
    }

    private boolean A04() {
        this.A0B.A07(0);
        int A04 = this.A0B.A04(24);
        if (A04 != 1) {
            Log.w(A00(11, 9, 46), A00(20, 30, 71) + A04);
            this.A02 = -1;
            return false;
        }
        this.A0B.A08(8);
        int A042 = this.A0B.A04(16);
        this.A0B.A08(5);
        this.A06 = this.A0B.A0F();
        this.A0B.A08(2);
        this.A08 = this.A0B.A0F();
        this.A07 = this.A0B.A0F();
        this.A0B.A08(6);
        int packetLength = this.A0B.A04(8);
        this.A01 = packetLength;
        if (A042 == 0) {
            this.A02 = -1;
        } else {
            int packetLength2 = A042 + 6;
            int i2 = packetLength2 - 9;
            int packetLength3 = this.A01;
            int i3 = i2 - packetLength3;
            String[] strArr = A0D;
            String str = strArr[1];
            String str2 = strArr[5];
            int charAt = str.charAt(17);
            int packetLength4 = str2.charAt(17);
            if (charAt == packetLength4) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0D;
            strArr2[1] = "TxtnMsOUgyy3Igc1MGFXcQorbec0OOLJ";
            strArr2[5] = "FqrtTSnP7VIKT9cq1hMIyK6Edo6EUePi";
            this.A02 = i3;
        }
        return true;
    }

    private boolean A05(IV iv, byte[] bArr, int i2) {
        int min = Math.min(iv.A04(), i2 - this.A00);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            iv.A0Z(min);
        } else {
            int i3 = this.A00;
            if (A0D[0].charAt(8) != '6') {
                String[] strArr = A0D;
                strArr[6] = "H8KMS8SQgkToBAcEgsGMIMEmcDOAfjD3";
                strArr[2] = "pG8ynHzO3ynvgwiEM6LVA0Wbsu12g974";
                iv.A0c(bArr, i3, min);
            } else {
                String[] strArr2 = A0D;
                strArr2[1] = "SlJVAlpzWDTlfjZlG24yfuiEgxBIsDod";
                strArr2[5] = "YxSVdBM1mtROHF0F5NUzvc6S3n3WzSYI";
                iv.A0c(bArr, i3, min);
            }
        }
        this.A00 += min;
        if (A0D[4].length() != 4) {
            String[] strArr3 = A0D;
            strArr3[1] = "9iVHE5UHbJVR9dQ85oXJ8gpCzJ6PDaiT";
            strArr3[5] = "Vd59evKFs4P6sMun7tv1zskusbuvsqU9";
            return this.A00 == i2;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0796Dk
    public final void A47(IV iv, boolean z) throws AS {
        if (z) {
            int i2 = this.A03;
            if (i2 != 0 && i2 != 1) {
                String A00 = A00(11, 9, 46);
                if (i2 == 2) {
                    Log.w(A00, A00(50, 50, 79));
                } else if (i2 == 3) {
                    if (this.A02 != -1) {
                        Log.w(A00, A00(100, 37, 52) + this.A02 + A00(0, 11, 123));
                    }
                    this.A0A.ACl();
                }
            }
            A03(1);
        }
        while (iv.A04() > 0) {
            int i3 = this.A03;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (A05(iv, this.A0B.A00, Math.min(10, this.A01)) && A05(iv, null, this.A01)) {
                            A01();
                            this.A0A.ACm(this.A04, this.A06);
                            A03(3);
                        }
                    } else if (i3 != 3) {
                        continue;
                    } else {
                        int A04 = iv.A04();
                        int i4 = this.A02;
                        int i5 = i4 != -1 ? A04 - i4 : 0;
                        if (i5 > 0) {
                            A04 -= i5;
                            iv.A0X(iv.A06() + A04);
                        }
                        this.A0A.A46(iv);
                        int i6 = this.A02;
                        if (i6 != -1) {
                            this.A02 = i6 - A04;
                            if (this.A02 == 0) {
                                DV dv = this.A0A;
                                if (A0D[0].charAt(8) != '6') {
                                    throw new RuntimeException();
                                }
                                String[] strArr = A0D;
                                strArr[6] = "x0jdU4oJLyfE062EEYlQTVcdLSkaU5Sb";
                                strArr[2] = "VBdeZUL1F1jcYz7E9oLJeT0FLHfAjfLP";
                                dv.ACl();
                                A03(1);
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                } else if (A05(iv, this.A0B.A00, 9)) {
                    A03(A04() ? 2 : 0);
                }
            } else {
                iv.A0Z(iv.A04());
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0796Dk
    public final void A8C(C0919Ih c0919Ih, CR cr, C0795Dj c0795Dj) {
        this.A05 = c0919Ih;
        this.A0A.A4T(cr, c0795Dj);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0796Dk
    public final void AE8() {
        this.A03 = 0;
        this.A00 = 0;
        this.A09 = false;
        this.A0A.AE8();
    }
}
