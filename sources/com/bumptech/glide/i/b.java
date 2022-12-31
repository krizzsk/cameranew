package com.bumptech.glide.i;

import androidx.core.app.FrameMetricsAggregator;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.io.OutputStream;
/* compiled from: LZWEncoder.java */
/* loaded from: classes.dex */
class b {
    private int a;
    private int b;
    private byte[] c;

    /* renamed from: d  reason: collision with root package name */
    private int f690d;

    /* renamed from: e  reason: collision with root package name */
    private int f691e;

    /* renamed from: f  reason: collision with root package name */
    private int f692f;

    /* renamed from: g  reason: collision with root package name */
    int f693g;

    /* renamed from: i  reason: collision with root package name */
    int f695i;
    int p;
    int q;
    int r;
    int v;

    /* renamed from: h  reason: collision with root package name */
    int f694h = 12;

    /* renamed from: j  reason: collision with root package name */
    int f696j = 4096;

    /* renamed from: k  reason: collision with root package name */
    int[] f697k = new int[5003];

    /* renamed from: l  reason: collision with root package name */
    int[] f698l = new int[5003];
    int m = 5003;
    int n = 0;
    boolean o = false;
    int s = 0;
    int t = 0;
    int[] u = {0, 1, 3, 7, 15, 31, 63, 127, 255, FrameMetricsAggregator.EVERY_DURATION, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] w = new byte[256];

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i2, int i3, byte[] bArr, int i4) {
        this.a = i2;
        this.b = i3;
        this.c = bArr;
        this.f690d = Math.max(2, i4);
    }

    private int h() {
        int i2 = this.f691e;
        if (i2 == 0) {
            return -1;
        }
        this.f691e = i2 - 1;
        byte[] bArr = this.c;
        int i3 = this.f692f;
        this.f692f = i3 + 1;
        return bArr[i3] & Draft_75.END_OF_FRAME;
    }

    final int a(int i2) {
        return (1 << i2) - 1;
    }

    void b(byte b, OutputStream outputStream) throws IOException {
        byte[] bArr = this.w;
        int i2 = this.v;
        int i3 = i2 + 1;
        this.v = i3;
        bArr[i2] = b;
        if (i3 >= 254) {
            g(outputStream);
        }
    }

    void c(OutputStream outputStream) throws IOException {
        d(this.m);
        int i2 = this.q;
        this.n = i2 + 2;
        this.o = true;
        i(i2, outputStream);
    }

    void d(int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            this.f697k[i3] = -1;
        }
    }

    void e(int i2, OutputStream outputStream) throws IOException {
        int[] iArr;
        this.p = i2;
        int i3 = 0;
        this.o = false;
        this.f693g = i2;
        this.f695i = a(i2);
        int i4 = 1 << (i2 - 1);
        this.q = i4;
        this.r = i4 + 1;
        this.n = i4 + 2;
        this.v = 0;
        int h2 = h();
        for (int i5 = this.m; i5 < 65536; i5 *= 2) {
            i3++;
        }
        int i6 = 8 - i3;
        int i7 = this.m;
        d(i7);
        i(this.q, outputStream);
        while (true) {
            int h3 = h();
            if (h3 != -1) {
                int i8 = (h3 << this.f694h) + h2;
                int i9 = (h3 << i6) ^ h2;
                int[] iArr2 = this.f697k;
                if (iArr2[i9] == i8) {
                    h2 = this.f698l[i9];
                } else {
                    if (iArr2[i9] >= 0) {
                        int i10 = i7 - i9;
                        if (i9 == 0) {
                            i10 = 1;
                        }
                        do {
                            i9 -= i10;
                            if (i9 < 0) {
                                i9 += i7;
                            }
                            iArr = this.f697k;
                            if (iArr[i9] == i8) {
                                h2 = this.f698l[i9];
                                break;
                            }
                        } while (iArr[i9] >= 0);
                    }
                    i(h2, outputStream);
                    int i11 = this.n;
                    if (i11 < this.f696j) {
                        int[] iArr3 = this.f698l;
                        this.n = i11 + 1;
                        iArr3[i9] = i11;
                        this.f697k[i9] = i8;
                    } else {
                        c(outputStream);
                    }
                    h2 = h3;
                }
            } else {
                i(h2, outputStream);
                i(this.r, outputStream);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(OutputStream outputStream) throws IOException {
        outputStream.write(this.f690d);
        this.f691e = this.a * this.b;
        this.f692f = 0;
        e(this.f690d + 1, outputStream);
        outputStream.write(0);
    }

    void g(OutputStream outputStream) throws IOException {
        int i2 = this.v;
        if (i2 > 0) {
            outputStream.write(i2);
            outputStream.write(this.w, 0, this.v);
            this.v = 0;
        }
    }

    void i(int i2, OutputStream outputStream) throws IOException {
        int i3 = this.s;
        int[] iArr = this.u;
        int i4 = this.t;
        int i5 = i3 & iArr[i4];
        this.s = i5;
        if (i4 > 0) {
            this.s = i5 | (i2 << i4);
        } else {
            this.s = i2;
        }
        this.t = i4 + this.f693g;
        while (this.t >= 8) {
            b((byte) (this.s & 255), outputStream);
            this.s >>= 8;
            this.t -= 8;
        }
        if (this.n > this.f695i || this.o) {
            if (this.o) {
                int i6 = this.p;
                this.f693g = i6;
                this.f695i = a(i6);
                this.o = false;
            } else {
                int i7 = this.f693g + 1;
                this.f693g = i7;
                if (i7 == this.f694h) {
                    this.f695i = this.f696j;
                } else {
                    this.f695i = a(i7);
                }
            }
        }
        if (i2 == this.r) {
            while (this.t > 0) {
                b((byte) (this.s & 255), outputStream);
                this.s >>= 8;
                this.t -= 8;
            }
            g(outputStream);
        }
    }
}
