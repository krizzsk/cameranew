package cn.sharesdk.framework.utils.QRCodeUtil;

import java.util.Arrays;
/* compiled from: BitArray.java */
/* loaded from: classes.dex */
public final class b implements Cloneable {
    private int[] a;
    private int b;

    public b() {
        this.b = 0;
        this.a = new int[1];
    }

    private static int[] c(int i2) {
        return new int[(i2 + 31) / 32];
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return (this.b + 7) / 8;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.b == bVar.b && Arrays.equals(this.a, bVar.a);
        }
        return false;
    }

    public int hashCode() {
        return (this.b * 31) + Arrays.hashCode(this.a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.b);
        for (int i2 = 0; i2 < this.b; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(a(i2) ? 'X' : '.');
        }
        return sb.toString();
    }

    private void b(int i2) {
        if (i2 > this.a.length * 32) {
            int[] c = c(i2);
            int[] iArr = this.a;
            System.arraycopy(iArr, 0, c, 0, iArr.length);
            this.a = c;
        }
    }

    public boolean a(int i2) {
        return ((1 << (i2 & 31)) & this.a[i2 / 32]) != 0;
    }

    /* renamed from: c */
    public b clone() {
        return new b((int[]) this.a.clone(), this.b);
    }

    public void a(boolean z) {
        b(this.b + 1);
        if (z) {
            int[] iArr = this.a;
            int i2 = this.b;
            int i3 = i2 / 32;
            iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
        }
        this.b++;
    }

    b(int[] iArr, int i2) {
        this.a = iArr;
        this.b = i2;
    }

    public void a(int i2, int i3) {
        if (i3 >= 0 && i3 <= 32) {
            b(this.b + i3);
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

    public void b(b bVar) {
        if (this.a.length != bVar.a.length) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = iArr[i2] ^ bVar.a[i2];
            i2++;
        }
    }

    public void a(b bVar) {
        int i2 = bVar.b;
        b(this.b + i2);
        for (int i3 = 0; i3 < i2; i3++) {
            a(bVar.a(i3));
        }
    }

    public void a(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (a(i2)) {
                    i6 |= 1 << (7 - i7);
                }
                i2++;
            }
            bArr[i3 + i5] = (byte) i6;
        }
    }
}
