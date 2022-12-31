package com.google.zxing;

import androidx.constraintlayout.core.motion.utils.TypedValues;
/* compiled from: RGBLuminanceSource.java */
/* loaded from: classes2.dex */
public final class f extends d {
    private final byte[] c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5021d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5022e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5023f;

    /* renamed from: g  reason: collision with root package name */
    private final int f5024g;

    public f(int i2, int i3, int[] iArr) {
        super(i2, i3);
        this.f5021d = i2;
        this.f5022e = i3;
        this.f5023f = 0;
        this.f5024g = 0;
        int i4 = i2 * i3;
        this.c = new byte[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = iArr[i5];
            this.c[i5] = (byte) (((((i6 >> 16) & 255) + ((i6 >> 7) & TypedValues.PositionType.TYPE_POSITION_TYPE)) + (i6 & 255)) / 4);
        }
    }

    @Override // com.google.zxing.d
    public byte[] b() {
        int d2 = d();
        int a = a();
        int i2 = this.f5021d;
        if (d2 == i2 && a == this.f5022e) {
            return this.c;
        }
        int i3 = d2 * a;
        byte[] bArr = new byte[i3];
        int i4 = (this.f5024g * i2) + this.f5023f;
        if (d2 == i2) {
            System.arraycopy(this.c, i4, bArr, 0, i3);
            return bArr;
        }
        for (int i5 = 0; i5 < a; i5++) {
            System.arraycopy(this.c, i4, bArr, i5 * d2, d2);
            i4 += this.f5021d;
        }
        return bArr;
    }

    @Override // com.google.zxing.d
    public byte[] c(int i2, byte[] bArr) {
        if (i2 >= 0 && i2 < a()) {
            int d2 = d();
            if (bArr == null || bArr.length < d2) {
                bArr = new byte[d2];
            }
            System.arraycopy(this.c, ((i2 + this.f5024g) * this.f5021d) + this.f5023f, bArr, 0, d2);
            return bArr;
        }
        throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i2)));
    }
}
