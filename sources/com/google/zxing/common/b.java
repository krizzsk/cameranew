package com.google.zxing.common;

import java.util.Arrays;
/* compiled from: BitMatrix.java */
/* loaded from: classes2.dex */
public final class b implements Cloneable {
    private final int a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f4985d;

    public b(int i2) {
        this(i2, i2);
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.b * (this.a + 1));
        for (int i2 = 0; i2 < this.b; i2++) {
            for (int i3 = 0; i3 < this.a; i3++) {
                sb.append(e(i3, i2) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public void b() {
        int length = this.f4985d.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f4985d[i2] = 0;
        }
    }

    /* renamed from: c */
    public b clone() {
        return new b(this.a, this.b, this.c, (int[]) this.f4985d.clone());
    }

    public void d(int i2, int i3) {
        int i4 = (i3 * this.c) + (i2 / 32);
        int[] iArr = this.f4985d;
        iArr[i4] = (1 << (i2 & 31)) ^ iArr[i4];
    }

    public boolean e(int i2, int i3) {
        return ((this.f4985d[(i3 * this.c) + (i2 / 32)] >>> (i2 & 31)) & 1) != 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && Arrays.equals(this.f4985d, bVar.f4985d);
        }
        return false;
    }

    public int[] f() {
        int length = this.f4985d.length - 1;
        while (length >= 0 && this.f4985d[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i2 = this.c;
        int i3 = length / i2;
        int i4 = (length % i2) << 5;
        int i5 = 31;
        while ((this.f4985d[length] >>> i5) == 0) {
            i5--;
        }
        return new int[]{i4 + i5, i3};
    }

    public int g() {
        return this.b;
    }

    public int[] h() {
        int[] iArr;
        int i2 = 0;
        while (true) {
            iArr = this.f4985d;
            if (i2 >= iArr.length || iArr[i2] != 0) {
                break;
            }
            i2++;
        }
        if (i2 == iArr.length) {
            return null;
        }
        int i3 = this.c;
        int i4 = i2 / i3;
        int i5 = (i2 % i3) << 5;
        int i6 = iArr[i2];
        int i7 = 0;
        while ((i6 << (31 - i7)) == 0) {
            i7++;
        }
        return new int[]{i5 + i7, i4};
    }

    public int hashCode() {
        int i2 = this.a;
        return (((((((i2 * 31) + i2) * 31) + this.b) * 31) + this.c) * 31) + Arrays.hashCode(this.f4985d);
    }

    public int i() {
        return this.a;
    }

    public void j(int i2, int i3) {
        int i4 = (i3 * this.c) + (i2 / 32);
        int[] iArr = this.f4985d;
        iArr[i4] = (1 << (i2 & 31)) | iArr[i4];
    }

    public void k(int i2, int i3, int i4, int i5) {
        if (i3 < 0 || i2 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i5 > 0 && i4 > 0) {
            int i6 = i4 + i2;
            int i7 = i5 + i3;
            if (i7 > this.b || i6 > this.a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i3 < i7) {
                int i8 = this.c * i3;
                for (int i9 = i2; i9 < i6; i9++) {
                    int[] iArr = this.f4985d;
                    int i10 = (i9 / 32) + i8;
                    iArr[i10] = iArr[i10] | (1 << (i9 & 31));
                }
                i3++;
            }
            return;
        }
        throw new IllegalArgumentException("Height and width must be at least 1");
    }

    public String l(String str, String str2) {
        return a(str, str2, "\n");
    }

    public String toString() {
        return l("X ", "  ");
    }

    public b(int i2, int i3) {
        if (i2 > 0 && i3 > 0) {
            this.a = i2;
            this.b = i3;
            int i4 = (i2 + 31) / 32;
            this.c = i4;
            this.f4985d = new int[i4 * i3];
            return;
        }
        throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }

    private b(int i2, int i3, int i4, int[] iArr) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.f4985d = iArr;
    }
}
