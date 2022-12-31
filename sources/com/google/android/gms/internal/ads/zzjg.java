package com.google.android.gms.internal.ads;

import com.tencent.matrix.trace.constants.Constants;
import java.nio.ShortBuffer;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzjg {
    private final int zzahp;
    private final int zzamx;
    private final int zzamy;
    private final int zzamz;
    private final int zzana;
    private final short[] zzanb;
    private int zzanc;
    private short[] zzand;
    private int zzane;
    private short[] zzanf;
    private int zzang;
    private short[] zzanh;
    private int zzank;
    private int zzanl;
    private int zzanm;
    private int zzann;
    private int zzanp;
    private int zzanq;
    private int zzanr;
    private int zzani = 0;
    private int zzanj = 0;
    private int zzano = 0;
    private float zzaib = 1.0f;
    private float zzaic = 1.0f;

    public zzjg(int i2, int i3) {
        this.zzahp = i2;
        this.zzamx = i3;
        this.zzamy = i2 / 400;
        int i4 = i2 / 65;
        this.zzamz = i4;
        int i5 = i4 * 2;
        this.zzana = i5;
        this.zzanb = new short[i5];
        this.zzanc = i5;
        this.zzand = new short[i5 * i3];
        this.zzane = i5;
        this.zzanf = new short[i5 * i3];
        this.zzang = i5;
        this.zzanh = new short[i5 * i3];
    }

    private final void zzgg() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = this.zzanl;
        float f2 = this.zzaib / this.zzaic;
        double d2 = f2;
        int i9 = 1;
        if (d2 <= 1.00001d && d2 >= 0.99999d) {
            zza(this.zzand, 0, this.zzank);
            this.zzank = 0;
        } else {
            int i10 = this.zzank;
            if (i10 >= this.zzana) {
                int i11 = 0;
                while (true) {
                    int i12 = this.zzann;
                    if (i12 > 0) {
                        int min = Math.min(this.zzana, i12);
                        zza(this.zzand, i11, min);
                        this.zzann -= min;
                        i11 += min;
                    } else {
                        short[] sArr = this.zzand;
                        int i13 = this.zzahp;
                        int i14 = i13 > 4000 ? i13 / Constants.DEFAULT_STARTUP_THRESHOLD_MS_WARM : 1;
                        if (this.zzamx == i9 && i14 == i9) {
                            i2 = zza(sArr, i11, this.zzamy, this.zzamz);
                        } else {
                            zzb(sArr, i11, i14);
                            int zza = zza(this.zzanb, 0, this.zzamy / i14, this.zzamz / i14);
                            if (i14 != i9) {
                                int i15 = zza * i14;
                                int i16 = i14 << 2;
                                int i17 = i15 - i16;
                                int i18 = i15 + i16;
                                int i19 = this.zzamy;
                                if (i17 < i19) {
                                    i17 = i19;
                                }
                                int i20 = this.zzamz;
                                if (i18 > i20) {
                                    i18 = i20;
                                }
                                if (this.zzamx == i9) {
                                    i2 = zza(sArr, i11, i17, i18);
                                } else {
                                    zzb(sArr, i11, i9);
                                    i2 = zza(this.zzanb, 0, i17, i18);
                                }
                            } else {
                                i2 = zza;
                            }
                        }
                        int i21 = this.zzanq;
                        int i22 = i21 != 0 && this.zzano != 0 && this.zzanr <= i21 * 3 && (i21 << 1) > this.zzanp * 3 ? this.zzano : i2;
                        this.zzanp = i21;
                        this.zzano = i2;
                        if (d2 > 1.0d) {
                            short[] sArr2 = this.zzand;
                            if (f2 >= 2.0f) {
                                i4 = (int) (i22 / (f2 - 1.0f));
                            } else {
                                this.zzann = (int) ((i22 * (2.0f - f2)) / (f2 - 1.0f));
                                i4 = i22;
                            }
                            zzy(i4);
                            int i23 = i4;
                            zza(i4, this.zzamx, this.zzanf, this.zzanl, sArr2, i11, sArr2, i11 + i22);
                            this.zzanl += i23;
                            i11 += i22 + i23;
                        } else {
                            int i24 = i22;
                            short[] sArr3 = this.zzand;
                            if (f2 < 0.5f) {
                                i3 = (int) ((i24 * f2) / (1.0f - f2));
                            } else {
                                this.zzann = (int) ((i24 * ((2.0f * f2) - 1.0f)) / (1.0f - f2));
                                i3 = i24;
                            }
                            int i25 = i24 + i3;
                            zzy(i25);
                            int i26 = this.zzamx;
                            System.arraycopy(sArr3, i11 * i26, this.zzanf, this.zzanl * i26, i26 * i24);
                            zza(i3, this.zzamx, this.zzanf, this.zzanl + i24, sArr3, i24 + i11, sArr3, i11);
                            this.zzanl += i25;
                            i11 += i3;
                        }
                    }
                    if (this.zzana + i11 > i10) {
                        break;
                    }
                    i9 = 1;
                }
                int i27 = this.zzank - i11;
                short[] sArr4 = this.zzand;
                int i28 = this.zzamx;
                System.arraycopy(sArr4, i11 * i28, sArr4, 0, i28 * i27);
                this.zzank = i27;
            }
        }
        float f3 = this.zzaic;
        if (f3 == 1.0f || this.zzanl == i8) {
            return;
        }
        int i29 = this.zzahp;
        int i30 = (int) (i29 / f3);
        while (true) {
            if (i30 <= 16384 && i29 <= 16384) {
                break;
            }
            i30 /= 2;
            i29 /= 2;
        }
        int i31 = this.zzanl - i8;
        int i32 = this.zzanm + i31;
        int i33 = this.zzang;
        if (i32 > i33) {
            int i34 = i33 + (i33 / 2) + i31;
            this.zzang = i34;
            this.zzanh = Arrays.copyOf(this.zzanh, i34 * this.zzamx);
        }
        short[] sArr5 = this.zzanf;
        int i35 = this.zzamx;
        System.arraycopy(sArr5, i8 * i35, this.zzanh, this.zzanm * i35, i35 * i31);
        this.zzanl = i8;
        this.zzanm += i31;
        int i36 = 0;
        while (true) {
            i5 = this.zzanm;
            if (i36 >= i5 - 1) {
                break;
            }
            while (true) {
                i6 = this.zzani;
                int i37 = (i6 + 1) * i30;
                i7 = this.zzanj;
                if (i37 <= i7 * i29) {
                    break;
                }
                zzy(1);
                int i38 = 0;
                while (true) {
                    int i39 = this.zzamx;
                    if (i38 < i39) {
                        short[] sArr6 = this.zzanh;
                        int i40 = (i36 * i39) + i38;
                        short s = sArr6[i40];
                        short s2 = sArr6[i40 + i39];
                        int i41 = this.zzani;
                        int i42 = i41 * i30;
                        int i43 = (i41 + 1) * i30;
                        int i44 = i43 - (this.zzanj * i29);
                        int i45 = i43 - i42;
                        this.zzanf[(this.zzanl * i39) + i38] = (short) (((s * i44) + ((i45 - i44) * s2)) / i45);
                        i38++;
                    }
                }
                this.zzanj++;
                this.zzanl++;
            }
            int i46 = i6 + 1;
            this.zzani = i46;
            if (i46 == i29) {
                this.zzani = 0;
                zzpg.checkState(i7 == i30);
                this.zzanj = 0;
            }
            i36++;
        }
        int i47 = i5 - 1;
        if (i47 != 0) {
            short[] sArr7 = this.zzanh;
            int i48 = this.zzamx;
            System.arraycopy(sArr7, i47 * i48, sArr7, 0, (i5 - i47) * i48);
            this.zzanm -= i47;
        }
    }

    private final void zzy(int i2) {
        int i3 = this.zzanl + i2;
        int i4 = this.zzane;
        if (i3 > i4) {
            int i5 = i4 + (i4 / 2) + i2;
            this.zzane = i5;
            this.zzanf = Arrays.copyOf(this.zzanf, i5 * this.zzamx);
        }
    }

    private final void zzz(int i2) {
        int i3 = this.zzank + i2;
        int i4 = this.zzanc;
        if (i3 > i4) {
            int i5 = i4 + (i4 / 2) + i2;
            this.zzanc = i5;
            this.zzand = Arrays.copyOf(this.zzand, i5 * this.zzamx);
        }
    }

    public final void setSpeed(float f2) {
        this.zzaib = f2;
    }

    public final void zza(float f2) {
        this.zzaic = f2;
    }

    public final void zzb(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.zzamx, this.zzanl);
        shortBuffer.put(this.zzanf, 0, this.zzamx * min);
        int i2 = this.zzanl - min;
        this.zzanl = i2;
        short[] sArr = this.zzanf;
        int i3 = this.zzamx;
        System.arraycopy(sArr, min * i3, sArr, 0, i2 * i3);
    }

    public final void zzfl() {
        int i2;
        int i3 = this.zzank;
        float f2 = this.zzaib;
        float f3 = this.zzaic;
        int i4 = this.zzanl + ((int) ((((i3 / (f2 / f3)) + this.zzanm) / f3) + 0.5f));
        zzz((this.zzana * 2) + i3);
        int i5 = 0;
        while (true) {
            i2 = this.zzana;
            int i6 = this.zzamx;
            if (i5 >= i2 * 2 * i6) {
                break;
            }
            this.zzand[(i6 * i3) + i5] = 0;
            i5++;
        }
        this.zzank += i2 * 2;
        zzgg();
        if (this.zzanl > i4) {
            this.zzanl = i4;
        }
        this.zzank = 0;
        this.zzann = 0;
        this.zzanm = 0;
    }

    public final int zzgf() {
        return this.zzanl;
    }

    public final void zza(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i2 = this.zzamx;
        int i3 = remaining / i2;
        zzz(i3);
        shortBuffer.get(this.zzand, this.zzank * this.zzamx, ((i2 * i3) << 1) / 2);
        this.zzank += i3;
        zzgg();
    }

    private final void zzb(short[] sArr, int i2, int i3) {
        int i4 = this.zzana / i3;
        int i5 = this.zzamx;
        int i6 = i3 * i5;
        int i7 = i2 * i5;
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                i9 += sArr[(i8 * i6) + i7 + i10];
            }
            this.zzanb[i8] = (short) (i9 / i6);
        }
    }

    private final void zza(short[] sArr, int i2, int i3) {
        zzy(i3);
        int i4 = this.zzamx;
        System.arraycopy(sArr, i2 * i4, this.zzanf, this.zzanl * i4, i4 * i3);
        this.zzanl += i3;
    }

    private final int zza(short[] sArr, int i2, int i3, int i4) {
        int i5 = i2 * this.zzamx;
        int i6 = 1;
        int i7 = 255;
        int i8 = 0;
        int i9 = 0;
        while (i3 <= i4) {
            int i10 = 0;
            for (int i11 = 0; i11 < i3; i11++) {
                short s = sArr[i5 + i11];
                short s2 = sArr[i5 + i3 + i11];
                i10 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i10 * i8 < i6 * i3) {
                i8 = i3;
                i6 = i10;
            }
            if (i10 * i7 > i9 * i3) {
                i7 = i3;
                i9 = i10;
            }
            i3++;
        }
        this.zzanq = i6 / i8;
        this.zzanr = i9 / i7;
        return i8;
    }

    private static void zza(int i2, int i3, short[] sArr, int i4, short[] sArr2, int i5, short[] sArr3, int i6) {
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = (i4 * i3) + i7;
            int i9 = (i6 * i3) + i7;
            int i10 = (i5 * i3) + i7;
            for (int i11 = 0; i11 < i2; i11++) {
                sArr[i8] = (short) (((sArr2[i10] * (i2 - i11)) + (sArr3[i9] * i11)) / i2);
                i8 += i3;
                i10 += i3;
                i9 += i3;
            }
        }
    }
}
