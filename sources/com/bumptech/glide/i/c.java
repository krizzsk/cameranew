package com.bumptech.glide.i;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
/* compiled from: NeuQuant.java */
/* loaded from: classes.dex */
class c {
    protected int a;
    protected byte[] b;
    protected int c;

    /* renamed from: d  reason: collision with root package name */
    protected int f699d;

    /* renamed from: f  reason: collision with root package name */
    protected int[] f701f = new int[256];

    /* renamed from: g  reason: collision with root package name */
    protected int[] f702g = new int[256];

    /* renamed from: h  reason: collision with root package name */
    protected int[] f703h = new int[256];

    /* renamed from: i  reason: collision with root package name */
    protected int[] f704i = new int[32];

    /* renamed from: e  reason: collision with root package name */
    protected int[][] f700e = new int[256];

    public c(byte[] bArr, int i2, int i3) {
        this.b = bArr;
        this.c = i2;
        this.f699d = i3;
        for (int i4 = 0; i4 < 256; i4++) {
            int[][] iArr = this.f700e;
            iArr[i4] = new int[4];
            int[] iArr2 = iArr[i4];
            int i5 = (i4 << 12) / 256;
            iArr2[2] = i5;
            iArr2[1] = i5;
            iArr2[0] = i5;
            this.f703h[i4] = 256;
            this.f702g[i4] = 0;
        }
    }

    protected void a(int i2, int i3, int i4, int i5, int i6) {
        int i7 = i3 - i2;
        if (i7 < -1) {
            i7 = -1;
        }
        int i8 = i3 + i2;
        if (i8 > 256) {
            i8 = 256;
        }
        int i9 = i3 + 1;
        int i10 = i3 - 1;
        int i11 = 1;
        while (true) {
            if (i9 >= i8 && i10 <= i7) {
                return;
            }
            int i12 = i11 + 1;
            int i13 = this.f704i[i11];
            if (i9 < i8) {
                int i14 = i9 + 1;
                int[] iArr = this.f700e[i9];
                try {
                    iArr[0] = iArr[0] - (((iArr[0] - i4) * i13) / 262144);
                    iArr[1] = iArr[1] - (((iArr[1] - i5) * i13) / 262144);
                    iArr[2] = iArr[2] - (((iArr[2] - i6) * i13) / 262144);
                } catch (Exception unused) {
                }
                i9 = i14;
            }
            if (i10 > i7) {
                int i15 = i10 - 1;
                int[] iArr2 = this.f700e[i10];
                try {
                    iArr2[0] = iArr2[0] - (((iArr2[0] - i4) * i13) / 262144);
                    iArr2[1] = iArr2[1] - (((iArr2[1] - i5) * i13) / 262144);
                    iArr2[2] = iArr2[2] - ((i13 * (iArr2[2] - i6)) / 262144);
                } catch (Exception unused2) {
                }
                i11 = i12;
                i10 = i15;
            } else {
                i11 = i12;
            }
        }
    }

    protected void b(int i2, int i3, int i4, int i5, int i6) {
        int[] iArr = this.f700e[i3];
        iArr[0] = iArr[0] - (((iArr[0] - i4) * i2) / 1024);
        iArr[1] = iArr[1] - (((iArr[1] - i5) * i2) / 1024);
        iArr[2] = iArr[2] - ((i2 * (iArr[2] - i6)) / 1024);
    }

    public byte[] c() {
        byte[] bArr = new byte[768];
        int[] iArr = new int[256];
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[this.f700e[i2][3]] = i2;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < 256) {
            int i5 = iArr[i3];
            int i6 = i4 + 1;
            int[][] iArr2 = this.f700e;
            bArr[i4] = (byte) iArr2[i5][0];
            int i7 = i6 + 1;
            bArr[i6] = (byte) iArr2[i5][1];
            bArr[i7] = (byte) iArr2[i5][2];
            i3++;
            i4 = i7 + 1;
        }
        return bArr;
    }

    protected int d(int i2, int i3, int i4) {
        int i5 = Integer.MAX_VALUE;
        int i6 = Integer.MAX_VALUE;
        int i7 = -1;
        int i8 = -1;
        for (int i9 = 0; i9 < 256; i9++) {
            int[] iArr = this.f700e[i9];
            int i10 = iArr[0] - i2;
            if (i10 < 0) {
                i10 = -i10;
            }
            int i11 = iArr[1] - i3;
            if (i11 < 0) {
                i11 = -i11;
            }
            int i12 = i10 + i11;
            int i13 = iArr[2] - i4;
            if (i13 < 0) {
                i13 = -i13;
            }
            int i14 = i12 + i13;
            if (i14 < i5) {
                i7 = i9;
                i5 = i14;
            }
            int[] iArr2 = this.f702g;
            int i15 = i14 - (iArr2[i9] >> 12);
            if (i15 < i6) {
                i8 = i9;
                i6 = i15;
            }
            int[] iArr3 = this.f703h;
            int i16 = iArr3[i9] >> 10;
            iArr3[i9] = iArr3[i9] - i16;
            iArr2[i9] = iArr2[i9] + (i16 << 10);
        }
        int[] iArr4 = this.f703h;
        iArr4[i7] = iArr4[i7] + 64;
        int[] iArr5 = this.f702g;
        iArr5[i7] = iArr5[i7] - 65536;
        return i8;
    }

    public void e() {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < 256) {
            int[] iArr = this.f700e[i2];
            int i5 = iArr[1];
            int i6 = i2 + 1;
            int i7 = i2;
            for (int i8 = i6; i8 < 256; i8++) {
                int[] iArr2 = this.f700e[i8];
                if (iArr2[1] < i5) {
                    i5 = iArr2[1];
                    i7 = i8;
                }
            }
            int[] iArr3 = this.f700e[i7];
            if (i2 != i7) {
                int i9 = iArr3[0];
                iArr3[0] = iArr[0];
                iArr[0] = i9;
                int i10 = iArr3[1];
                iArr3[1] = iArr[1];
                iArr[1] = i10;
                int i11 = iArr3[2];
                iArr3[2] = iArr[2];
                iArr[2] = i11;
                int i12 = iArr3[3];
                iArr3[3] = iArr[3];
                iArr[3] = i12;
            }
            if (i5 != i3) {
                this.f701f[i3] = (i4 + i2) >> 1;
                while (true) {
                    i3++;
                    if (i3 >= i5) {
                        break;
                    }
                    this.f701f[i3] = i2;
                }
                i4 = i2;
                i3 = i5;
            }
            i2 = i6;
        }
        this.f701f[i3] = (i4 + 255) >> 1;
        for (int i13 = i3 + 1; i13 < 256; i13++) {
            this.f701f[i13] = 255;
        }
    }

    public void f() {
        int i2;
        int i3 = this.c;
        if (i3 < 1509) {
            this.f699d = 1;
        }
        int i4 = this.f699d;
        this.a = ((i4 - 1) / 3) + 30;
        byte[] bArr = this.b;
        int i5 = i3 / (i4 * 3);
        int i6 = i5 / 100;
        for (int i7 = 0; i7 < 32; i7++) {
            this.f704i[i7] = 1024 * (((1024 - (i7 * i7)) * 256) / 1024);
        }
        int i8 = this.c;
        if (i8 < 1509) {
            i2 = 3;
        } else if (i8 % 499 != 0) {
            i2 = 1497;
        } else if (i8 % 491 != 0) {
            i2 = 1473;
        } else {
            i2 = i8 % 487 != 0 ? 1461 : 1509;
        }
        int i9 = i6;
        int i10 = 0;
        int i11 = 2048;
        int i12 = 32;
        int i13 = 1024;
        int i14 = 0;
        while (i10 < i5) {
            int i15 = (bArr[i14 + 0] & Draft_75.END_OF_FRAME) << 4;
            int i16 = (bArr[i14 + 1] & Draft_75.END_OF_FRAME) << 4;
            int i17 = (bArr[i14 + 2] & Draft_75.END_OF_FRAME) << 4;
            int d2 = d(i15, i16, i17);
            int i18 = i10;
            b(i13, d2, i15, i16, i17);
            if (i12 != 0) {
                a(i12, d2, i15, i16, i17);
            }
            int i19 = i14 + i2;
            if (i19 >= i3) {
                i19 -= this.c;
            }
            i14 = i19;
            i10 = i18 + 1;
            if (i9 == 0) {
                i9 = 1;
            }
            if (i10 % i9 == 0) {
                i13 -= i13 / this.a;
                i11 -= i11 / 30;
                int i20 = i11 >> 6;
                i12 = i20 <= 1 ? 0 : i20;
                for (int i21 = 0; i21 < i12; i21++) {
                    int i22 = i12 * i12;
                    this.f704i[i21] = (((i22 - (i21 * i21)) * 256) / i22) * i13;
                }
            }
        }
    }

    public int g(int i2, int i3, int i4) {
        int i5 = this.f701f[i3];
        int i6 = i5 - 1;
        int i7 = 1000;
        int i8 = -1;
        while (true) {
            if (i5 >= 256 && i6 < 0) {
                return i8;
            }
            if (i5 < 256) {
                int[] iArr = this.f700e[i5];
                int i9 = iArr[1] - i3;
                if (i9 >= i7) {
                    i5 = 256;
                } else {
                    i5++;
                    if (i9 < 0) {
                        i9 = -i9;
                    }
                    int i10 = iArr[0] - i2;
                    if (i10 < 0) {
                        i10 = -i10;
                    }
                    int i11 = i9 + i10;
                    if (i11 < i7) {
                        int i12 = iArr[2] - i4;
                        if (i12 < 0) {
                            i12 = -i12;
                        }
                        int i13 = i11 + i12;
                        if (i13 < i7) {
                            i8 = iArr[3];
                            i7 = i13;
                        }
                    }
                }
            }
            if (i6 >= 0) {
                int[] iArr2 = this.f700e[i6];
                int i14 = i3 - iArr2[1];
                if (i14 >= i7) {
                    i6 = -1;
                } else {
                    i6--;
                    if (i14 < 0) {
                        i14 = -i14;
                    }
                    int i15 = iArr2[0] - i2;
                    if (i15 < 0) {
                        i15 = -i15;
                    }
                    int i16 = i14 + i15;
                    if (i16 < i7) {
                        int i17 = iArr2[2] - i4;
                        if (i17 < 0) {
                            i17 = -i17;
                        }
                        int i18 = i17 + i16;
                        if (i18 < i7) {
                            i8 = iArr2[3];
                            i7 = i18;
                        }
                    }
                }
            }
        }
    }

    public byte[] h() {
        f();
        i();
        e();
        return c();
    }

    public void i() {
        for (int i2 = 0; i2 < 256; i2++) {
            int[][] iArr = this.f700e;
            int[] iArr2 = iArr[i2];
            iArr2[0] = iArr2[0] >> 4;
            int[] iArr3 = iArr[i2];
            iArr3[1] = iArr3[1] >> 4;
            int[] iArr4 = iArr[i2];
            iArr4[2] = iArr4[2] >> 4;
            iArr[i2][3] = i2;
        }
    }
}
