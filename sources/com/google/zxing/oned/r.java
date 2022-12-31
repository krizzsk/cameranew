package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import java.util.Map;
/* compiled from: UPCEWriter.java */
/* loaded from: classes2.dex */
public final class r extends p {
    @Override // com.google.zxing.oned.m, com.google.zxing.j
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.UPC_E) {
            return super.a(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode UPC_E, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.m
    public boolean[] c(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + o.b(q.c(str));
            } catch (FormatException e2) {
                throw new IllegalArgumentException(e2);
            }
        } else if (length == 8) {
            try {
                if (!o.a(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length)));
        }
        int digit = Character.digit(str.charAt(0), 10);
        if (digit != 0 && digit != 1) {
            throw new IllegalArgumentException("Number system must be 0 or 1");
        }
        int i2 = q.f5038f[digit][Character.digit(str.charAt(7), 10)];
        boolean[] zArr = new boolean[51];
        int b = m.b(zArr, 0, o.a, true) + 0;
        for (int i3 = 1; i3 <= 6; i3++) {
            int digit2 = Character.digit(str.charAt(i3), 10);
            if (((i2 >> (6 - i3)) & 1) == 1) {
                digit2 += 10;
            }
            b += m.b(zArr, b, o.f5037e[digit2], false);
        }
        m.b(zArr, b, o.c, false);
        return zArr;
    }
}
