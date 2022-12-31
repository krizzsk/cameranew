package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;
/* compiled from: ITFWriter.java */
/* loaded from: classes2.dex */
public final class k extends m {
    private static final int[] a = {1, 1, 1, 1};
    private static final int[] b = {3, 1, 1};
    private static final int[][] c = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override // com.google.zxing.oned.m, com.google.zxing.j
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.ITF) {
            return super.a(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.m
    public boolean[] c(String str) {
        int length = str.length();
        if (length % 2 == 0) {
            if (length <= 80) {
                boolean[] zArr = new boolean[(length * 9) + 9];
                int b2 = m.b(zArr, 0, a, true);
                for (int i2 = 0; i2 < length; i2 += 2) {
                    int digit = Character.digit(str.charAt(i2), 10);
                    int digit2 = Character.digit(str.charAt(i2 + 1), 10);
                    int[] iArr = new int[10];
                    for (int i3 = 0; i3 < 5; i3++) {
                        int i4 = i3 * 2;
                        int[][] iArr2 = c;
                        iArr[i4] = iArr2[digit][i3];
                        iArr[i4 + 1] = iArr2[digit2][i3];
                    }
                    b2 += m.b(zArr, b2, iArr, true);
                }
                m.b(zArr, b2, b, true);
                return zArr;
            }
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
        throw new IllegalArgumentException("The length of the input should be even");
    }
}
