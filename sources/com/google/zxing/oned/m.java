package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;
/* compiled from: OneDimensionalCodeWriter.java */
/* loaded from: classes2.dex */
public abstract class m implements com.google.zxing.j {
    /* JADX INFO: Access modifiers changed from: protected */
    public static int b(boolean[] zArr, int i2, int[] iArr, boolean z) {
        int i3 = 0;
        for (int i4 : iArr) {
            int i5 = 0;
            while (i5 < i4) {
                zArr[i2] = z;
                i5++;
                i2++;
            }
            i3 += i4;
            z = !z;
        }
        return i3;
    }

    private static com.google.zxing.common.b e(boolean[] zArr, int i2, int i3, int i4) {
        int length = zArr.length;
        int i5 = i4 + length;
        int max = Math.max(i2, i5);
        int max2 = Math.max(1, i3);
        int i6 = max / i5;
        int i7 = (max - (length * i6)) / 2;
        com.google.zxing.common.b bVar = new com.google.zxing.common.b(max, max2);
        int i8 = 0;
        while (i8 < length) {
            if (zArr[i8]) {
                bVar.k(i7, 0, i6, max2);
            }
            i8++;
            i7 += i6;
        }
        return bVar;
    }

    @Override // com.google.zxing.j
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i2 >= 0 && i3 >= 0) {
            int d2 = d();
            if (map != null) {
                EncodeHintType encodeHintType = EncodeHintType.MARGIN;
                if (map.containsKey(encodeHintType)) {
                    d2 = Integer.parseInt(map.get(encodeHintType).toString());
                }
            }
            return e(c(str), i2, i3, d2);
        }
        throw new IllegalArgumentException("Negative size is not allowed. Input: " + i2 + 'x' + i3);
    }

    public abstract boolean[] c(String str);

    public int d() {
        return 10;
    }
}
