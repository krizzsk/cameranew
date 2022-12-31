package com.facebook.ads.redexgen.X;

import com.tencent.matrix.trace.constants.Constants;
import java.nio.ShortBuffer;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Bd  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0748Bd {
    public static String[] A0M = {"ohCL8W0", "KQz7BMIeF4Z94D8gT8Jgt17pY9ay2sPb", "WHqc", "zdEVbBlbYLVxAkbZHAQvOg0x6UERU0KV", "RqBqTDSsJG3NS", "FmAwfgCi2dLCVzfY4ysR6r9BF", "Bq6occebnHk", "mWE0rLrmKK4IIqcH7c7itMEBPX65A8Us"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public short[] A0A;
    public short[] A0B;
    public short[] A0C;
    public final float A0D;
    public final float A0E;
    public final float A0F;
    public final int A0G;
    public final int A0H;
    public final int A0I;
    public final int A0J;
    public final int A0K;
    public final short[] A0L;

    public C0748Bd(int i2, int i3, float f2, float f3, int i4) {
        this.A0H = i2;
        this.A0G = i3;
        this.A0F = f2;
        this.A0D = f3;
        this.A0E = i2 / i4;
        this.A0K = i2 / 400;
        this.A0I = i2 / 65;
        this.A0J = this.A0I * 2;
        int i5 = this.A0J;
        this.A0L = new short[i5];
        this.A0A = new short[i5 * i3];
        this.A0B = new short[i5 * i3];
        this.A0C = new short[i5 * i3];
    }

    private int A00(int i2) {
        int min = Math.min(this.A0J, this.A09);
        A0D(this.A0A, i2, min);
        this.A09 -= min;
        return min;
    }

    private int A01(short[] sArr, int i2) {
        int A04;
        int i3;
        int i4 = this.A0H;
        int minP = i4 > 4000 ? i4 / Constants.DEFAULT_STARTUP_THRESHOLD_MS_WARM : 1;
        if (this.A0G == 1 && minP == 1) {
            A04 = A04(sArr, i2, this.A0K, this.A0I);
        } else {
            A0E(sArr, i2, minP);
            A04 = A04(this.A0L, 0, this.A0K / minP, this.A0I / minP);
            if (minP != 1) {
                int i5 = A04 * minP;
                int i6 = i5 - (minP * 4);
                int minP2 = (minP * 4) + i5;
                int maxP = this.A0K;
                if (i6 < maxP) {
                    i6 = this.A0K;
                }
                int maxP2 = this.A0I;
                if (minP2 > maxP2) {
                    minP2 = this.A0I;
                }
                int i7 = this.A0G;
                if (A0M[2].length() != 4) {
                    throw new RuntimeException();
                }
                String[] strArr = A0M;
                strArr[7] = "JAo85nDeN7hM6ugSVwGhvUnreF2qbK1o";
                strArr[1] = "l4YUjJfL7ivyphsQmVZd9dZE6KXUcfPo";
                if (i7 == 1) {
                    A04 = A04(sArr, i2, i6, minP2);
                } else {
                    A0E(sArr, i2, 1);
                    if (A0M[2].length() != 4) {
                        A04 = A04(this.A0L, 0, i6, minP2);
                    } else {
                        String[] strArr2 = A0M;
                        strArr2[6] = "Av8EYvFT4XF";
                        strArr2[5] = "OBBgqqBYNHA95X1QZrayaR0nl";
                        A04 = A04(this.A0L, 0, i6, minP2);
                    }
                }
            }
        }
        if (A0F(this.A02, this.A01)) {
            i3 = this.A08;
        } else {
            i3 = A04;
        }
        this.A07 = this.A02;
        this.A08 = A04;
        return i3;
    }

    private int A02(short[] sArr, int i2, float f2, int i3) {
        int i4;
        if (f2 < 0.5f) {
            i4 = (int) ((i3 * f2) / (1.0f - f2));
        } else {
            this.A09 = (int) ((i3 * ((2.0f * f2) - 1.0f)) / (1.0f - f2));
            i4 = i3;
        }
        this.A0B = A0G(this.A0B, this.A05, i3 + i4);
        int i5 = this.A0G;
        System.arraycopy(sArr, i2 * i5, this.A0B, this.A05 * i5, i5 * i3);
        A0C(i4, this.A0G, this.A0B, this.A05 + i3, sArr, i2 + i3, sArr, i2);
        this.A05 += i3 + i4;
        return i4;
    }

    private int A03(short[] sArr, int i2, float f2, int i3) {
        int i4;
        if (f2 >= 2.0f) {
            i4 = (int) (i3 / (f2 - 1.0f));
        } else {
            this.A09 = (int) ((i3 * (2.0f - f2)) / (f2 - 1.0f));
            i4 = i3;
        }
        this.A0B = A0G(this.A0B, this.A05, i4);
        A0C(i4, this.A0G, this.A0B, this.A05, sArr, i2, sArr, i2 + i3);
        this.A05 += i4;
        return i4;
    }

    private int A04(short[] sArr, int minDiff, int maxDiff, int period) {
        int diff = 0;
        int i2 = 255;
        int i3 = 1;
        int i4 = 0;
        int minDiff2 = minDiff * this.A0G;
        while (maxDiff <= period) {
            int i5 = 0;
            for (int i6 = 0; i6 < maxDiff; i6++) {
                i5 += Math.abs(sArr[minDiff2 + i6] - sArr[(minDiff2 + maxDiff) + i6]);
            }
            if (i5 * diff < i3 * maxDiff) {
                i3 = i5;
                diff = maxDiff;
            }
            if (i5 * i2 > i4 * maxDiff) {
                i4 = i5;
                i2 = maxDiff;
            }
            maxDiff++;
        }
        this.A02 = i3 / diff;
        this.A01 = i4 / i2;
        return diff;
    }

    private short A05(short[] sArr, int i2, int i3, int leftPosition) {
        short s = sArr[i2];
        short s2 = sArr[this.A0G + i2];
        int i4 = this.A04;
        int i5 = i4 * leftPosition;
        int i6 = (i4 + 1) * leftPosition;
        int width = i6 - (this.A03 * i3);
        int i7 = i6 - i5;
        return (short) (((width * s) + ((i7 - width) * s2)) / i7);
    }

    private void A06() {
        int i2 = this.A05;
        float f2 = this.A0F;
        float f3 = this.A0D;
        float f4 = f2 / f3;
        float f5 = this.A0E * f3;
        if (f4 > 1.00001d || f4 < 0.99999d) {
            A07(f4);
        } else {
            A0D(this.A0A, 0, this.A00);
            this.A00 = 0;
        }
        if (f5 != 1.0f) {
            A08(f5, i2);
        }
    }

    private void A07(float f2) {
        if (this.A00 < this.A0J) {
            return;
        }
        int i2 = this.A00;
        int i3 = 0;
        do {
            if (this.A09 > 0) {
                i3 += A00(i3);
            } else {
                int A01 = A01(this.A0A, i3);
                if (f2 > 1.0d) {
                    i3 += A03(this.A0A, i3, f2, A01) + A01;
                } else {
                    i3 += A02(this.A0A, i3, f2, A01);
                }
            }
        } while (this.A0J + i3 <= i2);
        A0B(i3);
    }

    private void A08(float f2, int i2) {
        int i3;
        int i4;
        if (this.A05 == i2) {
            return;
        }
        int i5 = (int) (this.A0H / f2);
        int i6 = this.A0H;
        while (true) {
            if (i5 > 16384 || i6 > 16384) {
                i5 /= 2;
                if (A0M[0].length() != 7) {
                    break;
                }
                A0M[0] = "V4vENqc";
                i6 /= 2;
            } else {
                A09(i2);
                int i7 = 0;
                while (true) {
                    int i8 = this.A06;
                    int i9 = i8 - 1;
                    String[] strArr = A0M;
                    if (strArr[7].charAt(13) == strArr[1].charAt(13)) {
                        break;
                    }
                    String[] strArr2 = A0M;
                    strArr2[7] = "S0FZlq4hqR1MtwM4zltGGLcwqbHHLsP7";
                    strArr2[1] = "aAsnKYirvcv97dya3O8NjUmjHgDgPMP0";
                    if (i7 < i9) {
                        while (true) {
                            i3 = this.A04;
                            int i10 = (i3 + 1) * i5;
                            i4 = this.A03;
                            if (i10 <= i4 * i6) {
                                break;
                            }
                            this.A0B = A0G(this.A0B, this.A05, 1);
                            int i11 = 0;
                            while (true) {
                                int i12 = this.A0G;
                                if (i11 < i12) {
                                    this.A0B[(this.A05 * i12) + i11] = A05(this.A0C, (i12 * i7) + i11, i6, i5);
                                    i11++;
                                }
                            }
                            int i13 = this.A03;
                            this.A03 = i13 + 1;
                            this.A05++;
                        }
                        this.A04 = i3 + 1;
                        if (this.A04 == i6) {
                            this.A04 = 0;
                            I6.A04(i4 == i5);
                            this.A03 = 0;
                        }
                        i7++;
                    } else {
                        A0A(i8 - 1);
                        return;
                    }
                }
            }
        }
        throw new RuntimeException();
    }

    private void A09(int i2) {
        int i3 = this.A05 - i2;
        this.A0C = A0G(this.A0C, this.A06, i3);
        short[] sArr = this.A0B;
        int i4 = this.A0G;
        System.arraycopy(sArr, i2 * i4, this.A0C, this.A06 * i4, i4 * i3);
        this.A05 = i2;
        this.A06 += i3;
    }

    private void A0A(int i2) {
        if (i2 == 0) {
            return;
        }
        short[] sArr = this.A0C;
        int i3 = this.A0G;
        System.arraycopy(sArr, i2 * i3, sArr, 0, (this.A06 - i2) * i3);
        this.A06 -= i2;
    }

    private void A0B(int i2) {
        int i3 = this.A00 - i2;
        short[] sArr = this.A0A;
        int i4 = this.A0G;
        System.arraycopy(sArr, i2 * i4, sArr, 0, i4 * i3);
        this.A00 = i3;
    }

    public static void A0C(int i2, int o, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < o; i6++) {
            int i7 = (i3 * o) + i6;
            int i8 = (i5 * o) + i6;
            int i9 = (i4 * o) + i6;
            for (int i10 = 0; i10 < i2; i10++) {
                sArr[i7] = (short) (((sArr2[i9] * (i2 - i10)) + (sArr3[i8] * i10)) / i2);
                i7 += o;
                i9 += o;
                i8 += o;
            }
        }
    }

    private void A0D(short[] sArr, int i2, int i3) {
        this.A0B = A0G(this.A0B, this.A05, i3);
        int i4 = this.A0G;
        System.arraycopy(sArr, i2 * i4, this.A0B, this.A05 * i4, i4 * i3);
        this.A05 += i3;
    }

    private void A0E(short[] sArr, int samplesPerValue, int i2) {
        int i3 = this.A0J / i2;
        int i4 = this.A0G;
        int i5 = i4 * i2;
        int samplesPerValue2 = samplesPerValue * i4;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i5; i8++) {
                i7 += sArr[(i6 * i5) + samplesPerValue2 + i8];
            }
            this.A0L[i6] = (short) (i7 / i5);
        }
    }

    private boolean A0F(int i2, int i3) {
        if (i2 == 0 || this.A08 == 0 || i3 > i2 * 3 || i2 * 2 <= this.A07 * 3) {
            return false;
        }
        return true;
    }

    private short[] A0G(short[] sArr, int i2, int i3) {
        int length = sArr.length;
        int i4 = this.A0G;
        int i5 = length / i4;
        if (i2 + i3 <= i5) {
            return sArr;
        }
        return Arrays.copyOf(sArr, i4 * (((i5 * 3) / 2) + i3));
    }

    public final int A0H() {
        return this.A05;
    }

    public final void A0I() {
        this.A00 = 0;
        this.A05 = 0;
        this.A06 = 0;
        this.A04 = 0;
        this.A03 = 0;
        this.A09 = 0;
        this.A08 = 0;
        this.A07 = 0;
        this.A02 = 0;
        this.A01 = 0;
    }

    public final void A0J() {
        int i2 = this.A00;
        float f2 = this.A0F;
        float f3 = this.A0D;
        float f4 = this.A0E * f3;
        float r = this.A06;
        int i3 = this.A05 + ((int) ((((i2 / (f2 / f3)) + r) / f4) + 0.5f));
        this.A0A = A0G(this.A0A, this.A00, (this.A0J * 2) + i2);
        int i4 = 0;
        while (true) {
            int i5 = this.A0J;
            int i6 = this.A0G;
            if (i4 < i5 * 2 * i6) {
                short[] sArr = this.A0A;
                String[] strArr = A0M;
                if (strArr[7].charAt(13) == strArr[1].charAt(13)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0M;
                strArr2[6] = "8uqTwc5xmM3";
                strArr2[5] = "8QSOBZmBR7CYVXHwBaCnC4p1f";
                sArr[(i6 * i2) + i4] = 0;
                i4++;
            } else {
                this.A00 += i5 * 2;
                A06();
                if (this.A05 > i3) {
                    this.A05 = i3;
                }
                this.A00 = 0;
                this.A09 = 0;
                this.A06 = 0;
                return;
            }
        }
    }

    public final void A0K(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.A0G, this.A05);
        shortBuffer.put(this.A0B, 0, this.A0G * min);
        this.A05 -= min;
        short[] sArr = this.A0B;
        int i2 = this.A0G;
        System.arraycopy(sArr, min * i2, sArr, 0, this.A05 * i2);
    }

    public final void A0L(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i2 = this.A0G;
        int i3 = remaining / i2;
        this.A0A = A0G(this.A0A, this.A00, i3);
        shortBuffer.get(this.A0A, this.A00 * this.A0G, ((i2 * i3) * 2) / 2);
        this.A00 += i3;
        A06();
    }
}
