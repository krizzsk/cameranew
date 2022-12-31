package com.facebook.ads.redexgen.X;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Arrays;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: assets/audience_network.dex */
public final class CV {
    public static byte[] A07;
    public static String[] A08 = {"nifcRfbON53gzILOru2Jo77QmnI", "", "YclbigHQdqatdiMMFtmKc8uyfonoIz5d", "Fd6hY4xBxF4WCtFqE3EitLo6QTPCTd6g", "7NOpBqgVdvht54TmD9wxn6mxDDhXMYkr", "z0qKCLYmn7ETA7vnAfdm8yGWNV", "FyibQKYxxp5WU6WV5DKbmcaitux", "b6Jzn18op"};
    public static final int[] A09;
    public static final int[] A0A;
    public static final int[] A0B;
    public static final int[] A0C;
    public static final int[] A0D;
    public static final int[] A0E;
    public static final String[] A0F;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public String A06;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 101);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A07 = new byte[]{-25, -5, -22, -17, -11, -75, -13, -10, -21, -19, 20, 40, 23, 28, 34, -30, 32, 35, 24, 26, -32, -1, -28, 0, 20, 3, 8, 14, -50, 12, 15, 4, 6, -52, -21, -47};
    }

    static {
        A02();
        A0F = new String[]{A01(10, 13, 78), A01(23, 13, 58), A01(0, 10, 33)};
        A0E = new int[]{44100, 48000, 32000};
        A09 = new int[]{32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, TypedValues.CycleType.TYPE_PATH_ROTATE, 448};
        A0D = new int[]{32, 48, 56, 64, 80, 96, 112, 128, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 160, 176, 192, 224, 256};
        A0A = new int[]{32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384};
        A0B = new int[]{32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320};
        A0C = new int[]{8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 160};
    }

    public static int A00(int version) {
        int samplingRateIndex;
        int padding;
        int i2;
        int i3;
        int samplingRate;
        if ((version & (-2097152)) != -2097152 || (samplingRateIndex = (version >>> 19) & 3) == 1 || (padding = (version >>> 17) & 3) == 0) {
            return -1;
        }
        int i4 = version >>> 12;
        if (A08[1].length() == 0) {
            A08[3] = "b2l2aaEsQdCjJRobZM3AI6pzp0fCTcXg";
            int i5 = i4 & 15;
            if (i5 == 0 || i5 == 15 || (i2 = (version >>> 10) & 3) == 3) {
                return -1;
            }
            int i6 = A0E[i2];
            if (samplingRateIndex == 2) {
                i6 /= 2;
            } else if (samplingRateIndex == 0) {
                i6 /= 4;
            }
            int i7 = (version >>> 9) & 1;
            if (padding == 3) {
                if (samplingRateIndex == 3) {
                    int samplingRate2 = i5 - 1;
                    samplingRate = A09[samplingRate2];
                } else {
                    int samplingRate3 = i5 - 1;
                    samplingRate = A0D[samplingRate3];
                }
                int padding2 = samplingRate * 12000;
                String[] strArr = A08;
                String str = strArr[6];
                String str2 = strArr[0];
                int bitrate = str.length();
                int samplingRate4 = str2.length();
                if (bitrate != samplingRate4) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A08;
                strArr2[4] = "oe92MVCyaQQCtYlB63NB1CxE35U7HQE5";
                strArr2[2] = "cgh7vNrWE365WSGkm1qsPTYGoGRnPBar";
                int samplingRate5 = ((padding2 / i6) + i7) * 4;
                return samplingRate5;
            }
            if (samplingRateIndex == 3) {
                if (padding == 2) {
                    int samplingRate6 = i5 - 1;
                    i3 = A0A[samplingRate6];
                } else {
                    int samplingRate7 = i5 - 1;
                    i3 = A0B[samplingRate7];
                }
            } else {
                int[] iArr = A0C;
                String[] strArr3 = A08;
                String str3 = strArr3[6];
                String str4 = strArr3[0];
                int length = str3.length();
                int samplingRate8 = str4.length();
                if (length != samplingRate8) {
                    String[] strArr4 = A08;
                    strArr4[7] = "UFIEXEz4g";
                    strArr4[5] = "u6DSTaNAwdJldo1ZeFLEjMNQPO";
                    int samplingRate9 = i5 - 1;
                    i3 = iArr[samplingRate9];
                } else {
                    A08[3] = "uh43YA7kDZkFV42L4FFbPgJOsOuCYlNO";
                    int samplingRate10 = i5 - 1;
                    i3 = iArr[samplingRate10];
                }
            }
            String[] strArr5 = A08;
            String str5 = strArr5[4];
            String str6 = strArr5[2];
            int charAt = str5.charAt(29);
            int samplingRate11 = str6.charAt(29);
            if (charAt != samplingRate11) {
                String[] strArr6 = A08;
                strArr6[7] = "EFM751Hfm";
                strArr6[5] = "lrmHfueLLigjg4doS9Ay4icuU4";
                if (samplingRateIndex == 3) {
                    return ((144000 * i3) / i6) + i7;
                }
                return (((padding == 1 ? 72000 : 144000) * i3) / i6) + i7;
            }
        }
        throw new RuntimeException();
    }

    private void A03(int i2, String str, int i3, int i4, int i5, int i6, int i7) {
        this.A05 = i2;
        this.A06 = str;
        this.A02 = i3;
        this.A03 = i4;
        this.A01 = i5;
        this.A00 = i6;
        this.A04 = i7;
    }

    public static boolean A04(int version, CV cv) {
        int i2;
        int bitrate;
        int bitrateIndex;
        int i3;
        int bitrateIndex2;
        int i4;
        int i5;
        if ((version & (-2097152)) != -2097152 || (i2 = (version >>> 19) & 3) == 1 || (bitrate = (version >>> 17) & 3) == 0 || (bitrateIndex = (version >>> 12) & 15) == 0 || bitrateIndex == 15 || (i3 = (version >>> 10) & 3) == 3) {
            return false;
        }
        int samplesPerFrame = A0E[i3];
        if (i2 == 2) {
            samplesPerFrame /= 2;
        } else if (i2 == 0) {
            samplesPerFrame /= 4;
        }
        int samplingRateIndex = version >>> 9;
        int i6 = samplingRateIndex & 1;
        if (bitrate == 3) {
            if (i2 == 3) {
                int[] iArr = A09;
                int i7 = bitrateIndex - 1;
                int padding = A08[1].length();
                if (padding != 0) {
                    throw new RuntimeException();
                }
                A08[1] = "";
                bitrateIndex2 = iArr[i7];
            } else {
                int samplingRateIndex2 = bitrateIndex - 1;
                bitrateIndex2 = A0D[samplingRateIndex2];
            }
            int samplingRateIndex3 = bitrateIndex2 * 12000;
            i5 = ((samplingRateIndex3 / samplesPerFrame) + i6) * 4;
            i4 = 384;
        } else {
            if (i2 == 3) {
                if (bitrate == 2) {
                    int samplingRateIndex4 = bitrateIndex - 1;
                    bitrateIndex2 = A0A[samplingRateIndex4];
                } else {
                    int samplingRateIndex5 = bitrateIndex - 1;
                    bitrateIndex2 = A0B[samplingRateIndex5];
                }
                i4 = 1152;
                i5 = ((144000 * bitrateIndex2) / samplesPerFrame) + i6;
            } else {
                int samplingRateIndex6 = bitrateIndex - 1;
                bitrateIndex2 = A0C[samplingRateIndex6];
                i4 = bitrate == 1 ? 576 : 1152;
                i5 = (((bitrate == 1 ? 72000 : 144000) * bitrateIndex2) / samplesPerFrame) + i6;
            }
        }
        int frameSize = 3 - bitrate;
        String str = A0F[frameSize];
        int frameSize2 = version >> 6;
        cv.A03(i2, str, i5, samplesPerFrame, (frameSize2 & 3) == 3 ? 1 : 2, bitrateIndex2 * 1000, i4);
        return true;
    }
}
