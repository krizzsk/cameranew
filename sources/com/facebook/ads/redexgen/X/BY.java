package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.nio.ByteBuffer;
import java.util.Arrays;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
import us.pinguo.paylibcenter.bean.PayResult;
/* loaded from: assets/audience_network.dex */
public final class BY {
    public static byte[] A00;
    public static String[] A01 = {"LkGuYUivH3Ie1Im5DPbpjiI8Q8YTXvDH", "1PwPqA1AQPAmdWryNsV6sN6X26rPkCjW", "ZqXwAcmmJts9Z3eghrFogO2ZvZ2KPTjy", "VVFX", "itVzmaW23y4JHLkTkKw9c3", "4is91i25oXLwO1hEL45hwpUW49QZoS4h", "3tDKTkvCK0hS9Fm4lJL5mZYVdrHZzDGh", "0qkAcrqD1J7f8hfbi9Oz77lQGDa0et74"};
    public static final int[] A02;
    public static final int[] A03;
    public static final int[] A04;

    public static String A05(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 23);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{119, 99, 114, Byte.MAX_VALUE, 121, 57, 96, 120, 114, 56, 114, 98, 101};
    }

    static {
        A06();
        A02 = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
        A03 = new int[]{-1, PayResult.PAY_RESULT_ALIPAY_CHECK_IN, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
        A04 = new int[]{64, 112, 128, 192, 224, 256, 384, 448, 512, VideoEdit2Activity.MIN_SCALED_SIZE, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};
    }

    public static int A00(ByteBuffer byteBuffer) {
        int i2;
        int nblks = byteBuffer.position();
        byte b = byteBuffer.get(nblks);
        if (b == -2) {
            i2 = ((byteBuffer.get(nblks + 5) & 1) << 6) | ((byteBuffer.get(nblks + 4) & 252) >> 2);
        } else if (b == -1) {
            i2 = ((byteBuffer.get(nblks + 4) & 7) << 4) | ((byteBuffer.get(nblks + 7) & 60) >> 2);
        } else if (b != 31) {
            i2 = ((byteBuffer.get(nblks + 4) & 1) << 6) | ((byteBuffer.get(nblks + 5) & 252) >> 2);
        } else {
            i2 = ((byteBuffer.get(nblks + 5) & 7) << 4) | ((byteBuffer.get(nblks + 6) & 60) >> 2);
        }
        return (i2 + 1) * 32;
    }

    public static int A01(byte[] bArr) {
        int i2;
        int fsize = 0;
        byte b = bArr[0];
        if (b == -2) {
            i2 = (((bArr[4] & 3) << 12) | ((bArr[7] & Draft_75.END_OF_FRAME) << 4) | ((bArr[6] & 240) >> 4)) + 1;
        } else if (b == -1) {
            i2 = (((bArr[7] & 3) << 12) | ((bArr[6] & Draft_75.END_OF_FRAME) << 4) | ((bArr[9] & 60) >> 2)) + 1;
            fsize = 1;
        } else if (b != 31) {
            i2 = (((bArr[5] & 3) << 12) | ((bArr[6] & Draft_75.END_OF_FRAME) << 4) | ((bArr[7] & 240) >> 4)) + 1;
        } else {
            i2 = (((bArr[6] & 3) << 12) | ((bArr[7] & Draft_75.END_OF_FRAME) << 4) | ((bArr[8] & 60) >> 2)) + 1;
            fsize = 1;
        }
        return fsize != 0 ? (i2 * 16) / 14 : i2;
    }

    public static int A02(byte[] bArr) {
        int i2;
        byte b = bArr[0];
        if (b == -2) {
            i2 = ((bArr[5] & 1) << 6) | ((bArr[4] & 252) >> 2);
        } else if (A01[4].length() == 20) {
            throw new RuntimeException();
        } else {
            String[] strArr = A01;
            strArr[2] = "EqLnRlbAIvqb7JmhHHjyb9MWmtPppsRr";
            strArr[7] = "wqmF86kNtSHy9CpxzvQffLVgP6PIYafb";
            if (b == -1) {
                i2 = ((bArr[4] & 7) << 4) | ((bArr[7] & 60) >> 2);
            } else if (b != 31) {
                i2 = ((bArr[4] & 1) << 6) | ((bArr[5] & 252) >> 2);
            } else {
                i2 = ((bArr[5] & 7) << 4) | ((bArr[6] & 60) >> 2);
            }
        }
        int i3 = (i2 + 1) * 32;
        String[] strArr2 = A01;
        if (strArr2[2].charAt(1) != strArr2[7].charAt(1)) {
            return i3;
        }
        String[] strArr3 = A01;
        strArr3[1] = "0BUMWBHFUBXEmf7IWFiBpaLqqarBLbVJ";
        strArr3[6] = "IXHZH24RcLqKyQXeo23FKYJCWT4dHCob";
        return i3;
    }

    public static Format A03(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        int i2;
        IU A042 = A04(bArr);
        A042.A08(60);
        int i3 = A02[A042.A04(6)];
        int i4 = A03[A042.A04(4)];
        int rate = A042.A04(5);
        int[] iArr = A04;
        if (rate >= iArr.length) {
            i2 = -1;
        } else {
            int bitrate = iArr[rate];
            i2 = (bitrate * 1000) / 2;
        }
        A042.A08(10);
        int bitrate2 = A042.A04(2);
        int bitrate3 = bitrate2 > 0 ? 1 : 0;
        return Format.A07(str, A05(0, 13, 1), null, i2, -1, i3 + bitrate3, i4, null, drmInitData, 0, str2);
    }

    public static IU A04(byte[] bArr) {
        if (bArr[0] == Byte.MAX_VALUE) {
            return new IU(bArr);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        if (A08(copyOf)) {
            for (int i2 = 0; i2 < copyOf.length - 1; i2 += 2) {
                byte temp = copyOf[i2];
                copyOf[i2] = copyOf[i2 + 1];
                copyOf[i2 + 1] = temp;
            }
        }
        IU iu = new IU(copyOf);
        if (copyOf[0] == 31) {
            IU iu2 = new IU(copyOf);
            while (true) {
                int A012 = iu2.A01();
                if (A01[5].charAt(2) == 'T') {
                    throw new RuntimeException();
                }
                A01[4] = "1c365Ndi9m7qeJPJDL";
                if (A012 < 16) {
                    break;
                }
                iu2.A08(2);
                iu.A0A(iu2.A04(14), 14);
            }
        }
        iu.A0B(copyOf);
        return iu;
    }

    public static boolean A07(int i2) {
        return i2 == 2147385345 || i2 == -25230976 || i2 == 536864768 || i2 == -14745368;
    }

    public static boolean A08(byte[] bArr) {
        return bArr[0] == -2 || bArr[0] == -1;
    }
}
