package com.tencent.stat.common;
/* loaded from: classes3.dex */
public class g {
    static final /* synthetic */ boolean a = true;

    private g() {
    }

    public static byte[] a(byte[] bArr, int i2) {
        return a(bArr, 0, bArr.length, i2);
    }

    public static byte[] a(byte[] bArr, int i2, int i3, int i4) {
        i iVar = new i(i4, new byte[(i3 * 3) / 4]);
        if (iVar.a(bArr, i2, i3, true)) {
            int i5 = iVar.b;
            byte[] bArr2 = iVar.a;
            if (i5 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i5];
            System.arraycopy(bArr2, 0, bArr3, 0, i5);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static byte[] b(byte[] bArr, int i2) {
        return b(bArr, 0, bArr.length, i2);
    }

    public static byte[] b(byte[] bArr, int i2, int i3, int i4) {
        j jVar = new j(i4, null);
        int i5 = (i3 / 3) * 4;
        if (!jVar.f8294f) {
            int i6 = i3 % 3;
            if (i6 == 1) {
                i5 += 2;
            } else if (i6 == 2) {
                i5 += 3;
            }
        } else if (i3 % 3 > 0) {
            i5 += 4;
        }
        if (jVar.f8295g && i3 > 0) {
            i5 += (((i3 - 1) / 57) + 1) * (jVar.f8296h ? 2 : 1);
        }
        jVar.a = new byte[i5];
        jVar.a(bArr, i2, i3, true);
        if (a || jVar.b == i5) {
            return jVar.a;
        }
        throw new AssertionError();
    }
}
