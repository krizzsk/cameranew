package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import java.util.Map;
/* compiled from: EAN8Writer.java */
/* loaded from: classes2.dex */
public final class j extends p {
    @Override // com.google.zxing.oned.m, com.google.zxing.j
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_8) {
            return super.a(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.m
    public boolean[] c(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + o.b(str);
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
        boolean[] zArr = new boolean[67];
        int b = m.b(zArr, 0, o.a, true) + 0;
        for (int i2 = 0; i2 <= 3; i2++) {
            b += m.b(zArr, b, o.f5036d[Character.digit(str.charAt(i2), 10)], false);
        }
        int b2 = b + m.b(zArr, b, o.b, false);
        for (int i3 = 4; i3 <= 7; i3++) {
            b2 += m.b(zArr, b2, o.f5036d[Character.digit(str.charAt(i3), 10)], true);
        }
        m.b(zArr, b2, o.a, true);
        return zArr;
    }
}
