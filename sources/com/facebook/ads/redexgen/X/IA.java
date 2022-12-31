package com.facebook.ads.redexgen.X;

import android.util.Pair;
import java.util.Arrays;
import us.pinguo.paylibcenter.bean.PayResult;
/* loaded from: assets/audience_network.dex */
public final class IA {
    public static byte[] A00;
    public static String[] A01 = {"7xLJJJjcPic97znxr7jYyKVhMaeA1j2E", "qlBokwmGez00tGn8Zoa7EPfSBX4wK2nd", "lNuywCj9LEYUa8avgu1fHofmnBtqXXwP", "QFj1OU4oR8zs4ROIl6ex9DnIWth", "MldRCxmPSCf85WqtCY5KHjt0bBRgqPbR", "RjpHJdGRFnKrV", "xTxTizoIhxSZQJal7HagUNUTtmhMrgov", "oiVBLQsg82rzAXMmQswhUJYEb9MEhzaa"};
    public static final byte[] A02;
    public static final int[] A03;
    public static final int[] A04;

    public static String A04(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 42);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{5, 62, 35, 37, 32, 32, 63, 34, 36, 53, 52, 112, 49, 37, 52, 57, 63, 112, 63, 50, 58, 53, 51, 36, 112, 36, 41, 32, 53, 106, 112, 116, 79, 82, 84, 81, 81, 78, 83, 85, 68, 69, 1, 68, 81, 98, 78, 79, 71, 72, 70, 27, 1};
    }

    static {
        A05();
        A02 = new byte[]{0, 0, 0, 1};
        A04 = new int[]{96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, PayResult.PAY_RESULT_ALIPAY_CHECK_IN, 7350};
        A03 = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};
    }

    public static int A00(IU iu) {
        int A042 = iu.A04(5);
        if (A042 == 31) {
            return iu.A04(6) + 32;
        }
        return A042;
    }

    public static int A01(IU iu) {
        int A042 = iu.A04(4);
        if (A042 == 15) {
            int samplingFrequency = iu.A04(24);
            return samplingFrequency;
        } else if (A01[3].length() != 27) {
            throw new RuntimeException();
        } else {
            A01[5] = "Rl706moC1hxTN";
            I6.A03(A042 < 13);
            int samplingFrequency2 = A04[A042];
            return samplingFrequency2;
        }
    }

    public static Pair<Integer, Integer> A02(IU iu, boolean z) throws AS {
        int A002 = A00(iu);
        int channelConfiguration = A01(iu);
        int A042 = iu.A04(4);
        if (A002 == 5 || A002 == 29) {
            channelConfiguration = A01(iu);
            A002 = A00(iu);
            if (A002 == 22) {
                A042 = iu.A04(4);
            }
        }
        boolean z2 = true;
        if (z) {
            if (A002 != 1 && A002 != 2 && A002 != 3 && A002 != 4 && A002 != 6 && A002 != 7 && A002 != 17) {
                switch (A002) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw new AS(A04(0, 31, 122) + A002);
                }
            }
            A06(iu, A002, A042);
            if (A01[4].charAt(0) == 'c') {
                throw new RuntimeException();
            }
            A01[7] = "vV2yfuq3D8MlByvyd0FSsWmE07MYRaiH";
            switch (A002) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int channelCount = iu.A04(2);
                    if (channelCount == 2 || channelCount == 3) {
                        throw new AS(A04(31, 22, 11) + channelCount);
                    }
            }
        }
        int i2 = A03[A042];
        if (i2 == -1) {
            z2 = false;
        }
        I6.A03(z2);
        return Pair.create(Integer.valueOf(channelConfiguration), Integer.valueOf(i2));
    }

    public static Pair<Integer, Integer> A03(byte[] bArr) throws AS {
        return A02(new IU(bArr), false);
    }

    public static void A06(IU iu, int i2, int i3) {
        iu.A08(1);
        if (iu.A0F()) {
            if (A01[5].length() != 13) {
                throw new RuntimeException();
            }
            A01[6] = "9ZbgWIK1Tjah9N2o7wCOkUZOiekVuClG";
            iu.A08(14);
        }
        boolean A0F = iu.A0F();
        if (i3 != 0) {
            if (i2 == 6 || i2 == 20) {
                iu.A08(3);
            }
            if (A0F) {
                if (i2 == 22) {
                    iu.A08(16);
                }
                if (i2 == 17 || i2 == 19 || i2 == 20 || i2 == 23) {
                    iu.A08(3);
                }
                iu.A08(1);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException();
    }

    public static byte[] A07(int i2, int i3, int i4) {
        return new byte[]{(byte) (((i2 << 3) & 248) | ((i3 >> 1) & 7)), (byte) (((i3 << 7) & 128) | ((i4 << 3) & 120))};
    }

    public static byte[] A08(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = A02;
        byte[] bArr3 = new byte[bArr2.length + i3];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i2, bArr3, A02.length, i3);
        return bArr3;
    }
}
