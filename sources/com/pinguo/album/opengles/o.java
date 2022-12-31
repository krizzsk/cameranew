package com.pinguo.album.opengles;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* compiled from: NinePatchTexture.java */
/* loaded from: classes3.dex */
class o {
    private FloatBuffer a;
    private FloatBuffer b;
    private ByteBuffer c;

    /* renamed from: d  reason: collision with root package name */
    private int f6084d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f6085e;

    /* renamed from: f  reason: collision with root package name */
    private int f6086f;

    /* renamed from: g  reason: collision with root package name */
    private int f6087g;

    public o(p pVar, int i2, int i3) {
        n J = pVar.J();
        if (i2 > 0 && i3 > 0) {
            int[] iArr = J.b;
            if (iArr.length == 2 && J.c.length == 2) {
                float[] fArr = new float[4];
                float[] fArr2 = new float[4];
                float[] fArr3 = new float[4];
                float[] fArr4 = new float[4];
                d(fArr, fArr2, fArr3, fArr4, f(fArr, fArr3, iArr, pVar.getWidth(), i2), f(fArr2, fArr4, J.c, pVar.getHeight(), i3), J.f6083d);
                return;
            }
            throw new RuntimeException("unsupported nine patch");
        }
        throw new RuntimeException("invalid dimension");
    }

    private static ByteBuffer a(int i2) {
        return ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
    }

    private void c(l lVar) {
        this.f6084d = lVar.r(this.a);
        this.f6085e = lVar.r(this.b);
        this.f6086f = lVar.h(this.c);
        this.a = null;
        this.b = null;
        this.c = null;
    }

    private void d(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, int i2, int i3, int[] iArr) {
        int i4;
        int i5;
        int i6 = i3;
        float[] fArr5 = new float[32];
        float[] fArr6 = new float[32];
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            int i9 = 0;
            while (i9 < i2) {
                int i10 = i7 + 1;
                int i11 = i7 << 1;
                int i12 = i11 + 1;
                fArr5[i11] = fArr[i9];
                fArr5[i12] = fArr2[i8];
                fArr6[i11] = fArr3[i9];
                fArr6[i12] = fArr4[i8];
                i9++;
                i7 = i10;
            }
        }
        byte[] bArr = new byte[24];
        boolean z = true;
        int i13 = 0;
        int i14 = 1;
        boolean z2 = false;
        while (i13 < i6 - 1) {
            i14--;
            z2 ^= z;
            int i15 = -1;
            if (z2) {
                i15 = i2;
                i5 = 1;
                i4 = 0;
            } else {
                i4 = i2 - 1;
                i5 = -1;
            }
            for (int i16 = i4; i16 != i15; i16 += i5) {
                int i17 = (i13 * i2) + i16;
                if (i16 != i4) {
                    int i18 = ((i2 - 1) * i13) + i16;
                    if (z2) {
                        i18--;
                    }
                    if (iArr[i18] == 0) {
                        bArr[i14] = bArr[i14 - 1];
                        int i19 = i14 + 1;
                        bArr[i19] = (byte) i17;
                        i14 = i19 + 1;
                    }
                }
                int i20 = i14 + 1;
                bArr[i14] = (byte) i17;
                i14 = i20 + 1;
                bArr[i20] = (byte) (i17 + i2);
            }
            i13++;
            i6 = i3;
            z = true;
        }
        this.f6087g = i14;
        int i21 = i7 * 2;
        int i22 = i21 * 4;
        this.a = a(i22).asFloatBuffer();
        this.b = a(i22).asFloatBuffer();
        this.c = a(this.f6087g);
        this.a.put(fArr5, 0, i21).position(0);
        this.b.put(fArr6, 0, i21).position(0);
        this.c.put(bArr, 0, i14).position(0);
    }

    private static int f(float[] fArr, float[] fArr2, int[] iArr, int i2, int i3) {
        float p = com.pinguo.album.j.a.p(i2);
        float f2 = i2 / p;
        int i4 = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        for (int i5 = 0; i5 < iArr.length; i5 += 2) {
            f4 += iArr[i5 + 1] - iArr[i5];
        }
        float f5 = (i3 - i2) + f4;
        fArr[0] = 0.0f;
        fArr2[0] = 0.0f;
        int length = iArr.length;
        float f6 = 0.0f;
        int i6 = 0;
        while (i6 < length) {
            int i7 = i6 + 1;
            fArr[i7] = f3 + (iArr[i6] - f6) + 0.5f;
            fArr2[i7] = Math.min((iArr[i6] + 0.5f) / p, f2);
            float f7 = iArr[i7] - iArr[i6];
            float f8 = (f5 * f7) / f4;
            f5 -= f8;
            f4 -= f7;
            f3 = fArr[i7] + f8;
            float f9 = iArr[i7];
            i6 += 2;
            fArr[i6] = f3 - 0.5f;
            fArr2[i6] = Math.min((f9 - 0.5f) / p, f2);
            f6 = f9;
        }
        fArr[iArr.length + 1] = i3;
        fArr2[iArr.length + 1] = f2;
        int length2 = iArr.length + 2;
        for (int i8 = 1; i8 < length2; i8++) {
            if (fArr[i8] - fArr[i4] >= 1.0f) {
                i4++;
                fArr[i4] = fArr[i8];
                fArr2[i4] = fArr2[i8];
            }
        }
        return i4 + 1;
    }

    public void b(l lVar, p pVar, int i2, int i3) {
        if (this.f6084d == -1) {
            c(lVar);
        }
        lVar.A(pVar, i2, i3, this.f6084d, this.f6085e, this.f6086f, this.f6087g);
    }

    public void e(l lVar) {
        if (this.a == null) {
            lVar.n(this.f6084d);
            lVar.n(this.f6085e);
            lVar.n(this.f6086f);
            this.f6084d = -1;
        }
    }
}
