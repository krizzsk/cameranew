package cn.sharesdk.framework.utils.QRCodeUtil;

import java.util.Arrays;
/* compiled from: BitMatrix.java */
/* loaded from: classes.dex */
public final class c implements Cloneable {
    private final int a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f158d;

    public c(int i2, int i3) {
        if (i2 >= 1 && i3 >= 1) {
            this.a = i2;
            this.b = i3;
            int i4 = (i2 + 31) / 32;
            this.c = i4;
            this.f158d = new int[i4 * i3];
            return;
        }
        throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }

    public boolean a(int i2, int i3) {
        return ((this.f158d[(i3 * this.c) + (i2 / 32)] >>> (i2 & 31)) & 1) != 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.a == cVar.a && this.b == cVar.b && this.c == cVar.c && Arrays.equals(this.f158d, cVar.f158d);
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.a;
        return (((((((i2 * 31) + i2) * 31) + this.b) * 31) + this.c) * 31) + Arrays.hashCode(this.f158d);
    }

    public String toString() {
        return a("X ", "\t");
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (i3 < 0 || i2 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i5 >= 1 && i4 >= 1) {
            int i6 = i4 + i2;
            int i7 = i5 + i3;
            if (i7 > this.b || i6 > this.a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i3 < i7) {
                int i8 = this.c * i3;
                for (int i9 = i2; i9 < i6; i9++) {
                    int[] iArr = this.f158d;
                    int i10 = (i9 / 32) + i8;
                    iArr[i10] = iArr[i10] | (1 << (i9 & 31));
                }
                i3++;
            }
            return;
        }
        throw new IllegalArgumentException("Height and width must be at least 1");
    }

    private c(int i2, int i3, int i4, int[] iArr) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.f158d = iArr;
    }

    public String a(String str, String str2) {
        return a(str, str2, "\n");
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.b * (this.a + 1));
        for (int i2 = 0; i2 < this.b; i2++) {
            for (int i3 = 0; i3 < this.a; i3++) {
                sb.append(a(i3, i2) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public c clone() {
        return new c(this.a, this.b, this.c, (int[]) this.f158d.clone());
    }
}
