package cn.sharesdk.framework.utils.QRCodeUtil;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GenericGFPoly.java */
/* loaded from: classes.dex */
public final class h {
    private final g a;
    private final int[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, int[] iArr) {
        if (iArr.length != 0) {
            this.a = gVar;
            int length = iArr.length;
            if (length > 1 && iArr[0] == 0) {
                int i2 = 1;
                while (i2 < length && iArr[i2] == 0) {
                    i2++;
                }
                if (i2 == length) {
                    this.b = new int[]{0};
                    return;
                }
                int[] iArr2 = new int[length - i2];
                this.b = iArr2;
                System.arraycopy(iArr, i2, iArr2, 0, iArr2.length);
                return;
            }
            this.b = iArr;
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a() {
        return this.b;
    }

    int b() {
        return this.b.length - 1;
    }

    boolean c() {
        return this.b[0] == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(b() * 8);
        for (int b = b(); b >= 0; b--) {
            int a = a(b);
            if (a != 0) {
                if (a < 0) {
                    sb.append(" - ");
                    a = -a;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (b == 0 || a != 1) {
                    int b2 = this.a.b(a);
                    if (b2 == 0) {
                        sb.append('1');
                    } else if (b2 == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(b2);
                    }
                }
                if (b != 0) {
                    if (b == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(b);
                    }
                }
            }
        }
        return sb.toString();
    }

    int a(int i2) {
        int[] iArr = this.b;
        return iArr[(iArr.length - 1) - i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h b(h hVar) {
        if (this.a.equals(hVar.a)) {
            if (!c() && !hVar.c()) {
                int[] iArr = this.b;
                int length = iArr.length;
                int[] iArr2 = hVar.b;
                int length2 = iArr2.length;
                int[] iArr3 = new int[(length + length2) - 1];
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = iArr[i2];
                    for (int i4 = 0; i4 < length2; i4++) {
                        int i5 = i2 + i4;
                        iArr3[i5] = g.b(iArr3[i5], this.a.c(i3, iArr2[i4]));
                    }
                }
                return new h(this.a, iArr3);
            }
            return this.a.a();
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h[] c(h hVar) {
        if (this.a.equals(hVar.a)) {
            if (!hVar.c()) {
                h a = this.a.a();
                int c = this.a.c(hVar.a(hVar.b()));
                h hVar2 = this;
                while (hVar2.b() >= hVar.b() && !hVar2.c()) {
                    int b = hVar2.b() - hVar.b();
                    int c2 = this.a.c(hVar2.a(hVar2.b()), c);
                    h a2 = hVar.a(b, c2);
                    a = a.a(this.a.a(b, c2));
                    hVar2 = hVar2.a(a2);
                }
                return new h[]{a, hVar2};
            }
            throw new IllegalArgumentException("Divide by 0");
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    h a(h hVar) {
        if (this.a.equals(hVar.a)) {
            if (c()) {
                return hVar;
            }
            if (hVar.c()) {
                return this;
            }
            int[] iArr = this.b;
            int[] iArr2 = hVar.b;
            if (iArr.length <= iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr.length];
            int length = iArr.length - iArr2.length;
            System.arraycopy(iArr, 0, iArr3, 0, length);
            for (int i2 = length; i2 < iArr.length; i2++) {
                iArr3[i2] = g.b(iArr2[i2 - length], iArr[i2]);
            }
            return new h(this.a, iArr3);
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h a(int i2, int i3) {
        if (i2 >= 0) {
            if (i3 == 0) {
                return this.a.a();
            }
            int length = this.b.length;
            int[] iArr = new int[i2 + length];
            for (int i4 = 0; i4 < length; i4++) {
                iArr[i4] = this.a.c(this.b[i4], i3);
            }
            return new h(this.a, iArr);
        }
        throw new IllegalArgumentException();
    }
}
