package cn.sharesdk.framework.utils.QRCodeUtil.a;

import cn.sharesdk.framework.utils.QRCodeUtil.WriterException;
import cn.sharesdk.framework.utils.QRCodeUtil.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MatrixUtil.java */
/* loaded from: classes.dex */
public final class e {
    private static final int[][] a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f155d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    static void a(b bVar) {
        bVar.a((byte) -1);
    }

    static void b(n nVar, b bVar) throws WriterException {
        if (nVar.a() < 7) {
            return;
        }
        cn.sharesdk.framework.utils.QRCodeUtil.b bVar2 = new cn.sharesdk.framework.utils.QRCodeUtil.b();
        a(nVar, bVar2);
        int i2 = 17;
        for (int i3 = 0; i3 < 6; i3++) {
            for (int i4 = 0; i4 < 3; i4++) {
                boolean a2 = bVar2.a(i2);
                i2--;
                bVar.a(i3, (bVar.a() - 11) + i4, a2);
                bVar.a((bVar.a() - 11) + i4, i3, a2);
            }
        }
    }

    private static boolean b(int i2) {
        return i2 == -1;
    }

    private static void c(b bVar) throws WriterException {
        if (bVar.a(8, bVar.a() - 8) != 0) {
            bVar.a(8, bVar.a() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    private static void d(int i2, int i3, b bVar) {
        for (int i4 = 0; i4 < 7; i4++) {
            int[] iArr = a[i4];
            for (int i5 = 0; i5 < 7; i5++) {
                bVar.a(i2 + i5, i3 + i4, iArr[i5]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(cn.sharesdk.framework.utils.QRCodeUtil.b bVar, cn.sharesdk.framework.utils.QRCodeUtil.f fVar, n nVar, int i2, b bVar2) throws WriterException {
        a(bVar2);
        a(nVar, bVar2);
        a(fVar, i2, bVar2);
        b(nVar, bVar2);
        a(bVar, i2, bVar2);
    }

    private static void d(b bVar) throws WriterException {
        int length = a[0].length;
        d(0, 0, bVar);
        d(bVar.b() - length, 0, bVar);
        d(0, bVar.b() - length, bVar);
        a(0, 7, bVar);
        a(bVar.b() - 8, 7, bVar);
        a(0, bVar.b() - 8, bVar);
        b(7, 0, bVar);
        b((bVar.a() - 7) - 1, 0, bVar);
        b(7, bVar.a() - 7, bVar);
    }

    private static void c(int i2, int i3, b bVar) {
        for (int i4 = 0; i4 < 5; i4++) {
            int[] iArr = b[i4];
            for (int i5 = 0; i5 < 5; i5++) {
                bVar.a(i2 + i5, i3 + i4, iArr[i5]);
            }
        }
    }

    private static void c(n nVar, b bVar) {
        if (nVar.a() < 2) {
            return;
        }
        int[] iArr = c[nVar.a() - 1];
        for (int i2 : iArr) {
            if (i2 >= 0) {
                for (int i3 : iArr) {
                    if (i3 >= 0 && b(bVar.a(i3, i2))) {
                        c(i3 - 2, i2 - 2, bVar);
                    }
                }
            }
        }
    }

    static void a(n nVar, b bVar) throws WriterException {
        d(bVar);
        c(bVar);
        c(nVar, bVar);
        b(bVar);
    }

    private static void b(b bVar) {
        int i2 = 8;
        while (i2 < bVar.b() - 8) {
            int i3 = i2 + 1;
            int i4 = i3 % 2;
            if (b(bVar.a(i2, 6))) {
                bVar.a(i2, 6, i4);
            }
            if (b(bVar.a(6, i2))) {
                bVar.a(6, i2, i4);
            }
            i2 = i3;
        }
    }

    static void a(cn.sharesdk.framework.utils.QRCodeUtil.f fVar, int i2, b bVar) throws WriterException {
        cn.sharesdk.framework.utils.QRCodeUtil.b bVar2 = new cn.sharesdk.framework.utils.QRCodeUtil.b();
        a(fVar, i2, bVar2);
        for (int i3 = 0; i3 < bVar2.a(); i3++) {
            boolean a2 = bVar2.a((bVar2.a() - 1) - i3);
            int[] iArr = f155d[i3];
            bVar.a(iArr[0], iArr[1], a2);
            if (i3 < 8) {
                bVar.a((bVar.b() - i3) - 1, 8, a2);
            } else {
                bVar.a(8, (bVar.a() - 7) + (i3 - 8), a2);
            }
        }
    }

    private static void b(int i2, int i3, b bVar) throws WriterException {
        for (int i4 = 0; i4 < 7; i4++) {
            int i5 = i3 + i4;
            if (b(bVar.a(i2, i5))) {
                bVar.a(i2, i5, 0);
            } else {
                throw new WriterException();
            }
        }
    }

    static void a(cn.sharesdk.framework.utils.QRCodeUtil.b bVar, int i2, b bVar2) throws WriterException {
        boolean z;
        int b2 = bVar2.b() - 1;
        int a2 = bVar2.a() - 1;
        int i3 = 0;
        int i4 = -1;
        while (b2 > 0) {
            if (b2 == 6) {
                b2--;
            }
            while (a2 >= 0 && a2 < bVar2.a()) {
                for (int i5 = 0; i5 < 2; i5++) {
                    int i6 = b2 - i5;
                    if (b(bVar2.a(i6, a2))) {
                        if (i3 < bVar.a()) {
                            z = bVar.a(i3);
                            i3++;
                        } else {
                            z = false;
                        }
                        if (i2 != -1 && d.a(i2, i6, a2)) {
                            z = !z;
                        }
                        bVar2.a(i6, a2, z);
                    }
                }
                a2 += i4;
            }
            i4 = -i4;
            a2 += i4;
            b2 -= 2;
        }
        if (i3 == bVar.a()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i3 + '/' + bVar.a());
    }

    static int a(int i2) {
        return 32 - Integer.numberOfLeadingZeros(i2);
    }

    static int a(int i2, int i3) {
        if (i3 != 0) {
            int a2 = a(i3);
            int i4 = i2 << (a2 - 1);
            while (a(i4) >= a2) {
                i4 ^= i3 << (a(i4) - a2);
            }
            return i4;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    static void a(cn.sharesdk.framework.utils.QRCodeUtil.f fVar, int i2, cn.sharesdk.framework.utils.QRCodeUtil.b bVar) throws WriterException {
        if (f.b(i2)) {
            int a2 = (fVar.a() << 3) | i2;
            bVar.a(a2, 5);
            bVar.a(a(a2, 1335), 10);
            cn.sharesdk.framework.utils.QRCodeUtil.b bVar2 = new cn.sharesdk.framework.utils.QRCodeUtil.b();
            bVar2.a(21522, 15);
            bVar.b(bVar2);
            if (bVar.a() == 15) {
                return;
            }
            throw new WriterException("should not happen but we got: " + bVar.a());
        }
        throw new WriterException("Invalid mask pattern");
    }

    static void a(n nVar, cn.sharesdk.framework.utils.QRCodeUtil.b bVar) throws WriterException {
        bVar.a(nVar.a(), 6);
        bVar.a(a(nVar.a(), 7973), 12);
        if (bVar.a() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + bVar.a());
    }

    private static void a(int i2, int i3, b bVar) throws WriterException {
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = i2 + i4;
            if (b(bVar.a(i5, i3))) {
                bVar.a(i5, i3, 0);
            } else {
                throw new WriterException();
            }
        }
    }
}
