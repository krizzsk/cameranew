package com.google.zxing.common;

import java.util.Arrays;
/* compiled from: BitArray.java */
/* loaded from: classes2.dex */
public final class a implements Cloneable {
    private int[] a;
    private int b;

    public a() {
        this.b = 0;
        this.a = new int[1];
    }

    private void e(int i2) {
        if (i2 > (this.a.length << 5)) {
            int[] i3 = i(i2);
            int[] iArr = this.a;
            System.arraycopy(iArr, 0, i3, 0, iArr.length);
            this.a = i3;
        }
    }

    private static int[] i(int i2) {
        return new int[(i2 + 31) / 32];
    }

    public void a(boolean z) {
        e(this.b + 1);
        if (z) {
            int[] iArr = this.a;
            int i2 = this.b;
            int i3 = i2 / 32;
            iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
        }
        this.b++;
    }

    public void b(a aVar) {
        int i2 = aVar.b;
        e(this.b + i2);
        for (int i3 = 0; i3 < i2; i3++) {
            a(aVar.f(i3));
        }
    }

    public void c(int i2, int i3) {
        if (i3 >= 0 && i3 <= 32) {
            e(this.b + i3);
            while (i3 > 0) {
                boolean z = true;
                if (((i2 >> (i3 - 1)) & 1) != 1) {
                    z = false;
                }
                a(z);
                i3--;
            }
            return;
        }
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }

    /* renamed from: d */
    public a clone() {
        return new a((int[]) this.a.clone(), this.b);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.b == aVar.b && Arrays.equals(this.a, aVar.a);
        }
        return false;
    }

    public boolean f(int i2) {
        return ((1 << (i2 & 31)) & this.a[i2 / 32]) != 0;
    }

    public int g() {
        return this.b;
    }

    public int h() {
        return (this.b + 7) / 8;
    }

    public int hashCode() {
        return (this.b * 31) + Arrays.hashCode(this.a);
    }

    public void j(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (f(i2)) {
                    i6 |= 1 << (7 - i7);
                }
                i2++;
            }
            bArr[i3 + i5] = (byte) i6;
        }
    }

    public void k(a aVar) {
        if (this.b != aVar.b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = iArr[i2] ^ aVar.a[i2];
            i2++;
        }
    }

    public String toString() {
        int i2 = this.b;
        StringBuilder sb = new StringBuilder(i2 + (i2 / 8) + 1);
        for (int i3 = 0; i3 < this.b; i3++) {
            if ((i3 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(f(i3) ? 'X' : '.');
        }
        return sb.toString();
    }

    a(int[] iArr, int i2) {
        this.a = iArr;
        this.b = i2;
    }
}
