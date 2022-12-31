package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;
/* compiled from: Code93Writer.java */
/* loaded from: classes2.dex */
public class g extends m {
    private static int f(boolean[] zArr, int i2, int[] iArr) {
        int length = iArr.length;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i2 + 1;
            zArr[i2] = iArr[i3] != 0;
            i3++;
            i2 = i4;
        }
        return 9;
    }

    private static int g(String str, int i2) {
        int i3 = 0;
        int i4 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i3 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i4;
            i4++;
            if (i4 > i2) {
                i4 = 1;
            }
        }
        return i3 % 47;
    }

    private static void h(int i2, int[] iArr) {
        for (int i3 = 0; i3 < 9; i3++) {
            int i4 = 1;
            if (((1 << (8 - i3)) & i2) == 0) {
                i4 = 0;
            }
            iArr[i3] = i4;
        }
    }

    @Override // com.google.zxing.oned.m, com.google.zxing.j
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_93) {
            return super.a(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.m
    public boolean[] c(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            h(f.a[47], iArr);
            boolean[] zArr = new boolean[((str.length() + 2 + 2) * 9) + 1];
            int f2 = f(zArr, 0, iArr);
            for (int i2 = 0; i2 < length; i2++) {
                h(f.a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i2))], iArr);
                f2 += f(zArr, f2, iArr);
            }
            int g2 = g(str, 20);
            int[] iArr2 = f.a;
            h(iArr2[g2], iArr);
            int f3 = f2 + f(zArr, f2, iArr);
            h(iArr2[g(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(g2), 15)], iArr);
            int f4 = f3 + f(zArr, f3, iArr);
            h(iArr2[47], iArr);
            zArr[f4 + f(zArr, f4, iArr)] = true;
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
    }
}
