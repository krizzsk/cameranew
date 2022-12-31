package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import java.util.Map;
/* compiled from: EAN13Writer.java */
/* loaded from: classes2.dex */
public final class i extends p {
    @Override // com.google.zxing.oned.m, com.google.zxing.j
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_13) {
            return super.a(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.m
    public boolean[] c(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + o.b(str);
            } catch (FormatException e2) {
                throw new IllegalArgumentException(e2);
            }
        } else if (length == 13) {
            try {
                if (!o.a(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got ".concat(String.valueOf(length)));
        }
        int i2 = h.f5035f[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int b = m.b(zArr, 0, o.a, true) + 0;
        for (int i3 = 1; i3 <= 6; i3++) {
            int digit = Character.digit(str.charAt(i3), 10);
            if (((i2 >> (6 - i3)) & 1) == 1) {
                digit += 10;
            }
            b += m.b(zArr, b, o.f5037e[digit], false);
        }
        int b2 = b + m.b(zArr, b, o.b, false);
        for (int i4 = 7; i4 <= 12; i4++) {
            b2 += m.b(zArr, b2, o.f5036d[Character.digit(str.charAt(i4), 10)], true);
        }
        m.b(zArr, b2, o.a, true);
        return zArr;
    }
}
