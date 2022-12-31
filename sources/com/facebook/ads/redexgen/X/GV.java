package com.facebook.ads.redexgen.X;

import android.util.Log;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class GV {
    public static byte[] A00;
    public static String[] A01 = {"ijZd2SvY", "Ph5fJqf6OowbUT2cqzgcB298kDhnW2OX", "wB5WDB4JU6krUWdN", "eBmlwoifn7sQacvwvpCdDN7mM49lFTV9", "8TaUd8AxspPDe4hMAHd3njvqxnnZalZZ", "my8xvAbSAhbAvtjE", "sCujs14tvAISPjVlxjJqhwIZMpV4htIn", "ZuHVfppKLGIB3c7uxsgIg35bH7izaigq"};
    public static final int A02;
    public static final int A03;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 12);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-52, -18, -22, -34, -3, -14, -11, 113, -127, 116, 94, -71, -77, -85, -90, -99, -75, -77, -70, -70, -77, -72, -79, 106, -68, -81, -73, -85, -77, -72, -82, -81, -68, 106, -71, -80, 106, -73, -85, -74, -80, -71, -68, -73, -81, -82, 106, -99, -113, -109, 106, -104, -117, -106, 106, -65, -72, -77, -66, 120};
    }

    static {
        A02();
        A03 = C0923Il.A08(A01(11, 4, 102));
        A02 = C0923Il.A08(A01(7, 4, 33));
    }

    public static int A00(IV iv) {
        int b = 0;
        while (iv.A04() != 0) {
            int A0E = iv.A0E();
            String[] strArr = A01;
            if (strArr[2].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[2] = "2iVFcVRayhlXICIL";
            strArr2[5] = "cB88SmkuRLYvydLN";
            b += A0E;
            if (A0E != 255) {
                return b;
            }
        }
        return -1;
    }

    public static void A03(long j2, IV iv, InterfaceC0771Cb[] interfaceC0771CbArr) {
        int countryCode;
        while (iv.A04() > 1) {
            int A002 = A00(iv);
            int A003 = A00(iv);
            int A06 = iv.A06() + A003;
            if (A003 == -1 || A003 > iv.A04()) {
                Log.w(A01(0, 7, 125), A01(15, 45, 62));
                A06 = iv.A07();
            } else if (A002 == 4 && A003 >= 8) {
                int A0E = iv.A0E();
                int A0I = iv.A0I();
                int i2 = 0;
                if (A0I == 49) {
                    i2 = iv.A08();
                }
                int A0E2 = iv.A0E();
                if (A0I == 47) {
                    iv.A0Z(1);
                }
                int ccCount = (A0E == 181 && (A0I == 49 || A0I == 47) && A0E2 == 3) ? 1 : 0;
                if (A0I == 49) {
                    int countryCode2 = A03;
                    if (i2 != countryCode2) {
                        int countryCode3 = A02;
                        if (i2 != countryCode3) {
                            countryCode = 0;
                            ccCount &= countryCode;
                        }
                    }
                    countryCode = 1;
                    ccCount &= countryCode;
                }
                if (ccCount != 0) {
                    int countryCode4 = iv.A0E();
                    iv.A0Z(1);
                    int i3 = (countryCode4 & 31) * 3;
                    int ccCount2 = iv.A06();
                    for (InterfaceC0771Cb interfaceC0771Cb : interfaceC0771CbArr) {
                        iv.A0Y(ccCount2);
                        interfaceC0771Cb.AE4(iv, i3);
                        interfaceC0771Cb.AE5(j2, 1, i3, 0, null);
                    }
                }
            }
            iv.A0Y(A06);
        }
    }
}
