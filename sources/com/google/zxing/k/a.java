package com.google.zxing.k;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.b;
import com.google.zxing.j;
import com.google.zxing.k.b.c;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
/* compiled from: AztecWriter.java */
/* loaded from: classes2.dex */
public final class a implements j {
    private static b b(String str, BarcodeFormat barcodeFormat, int i2, int i3, Charset charset, int i4, int i5) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return c(c.d(str.getBytes(charset), i4, i5), i2, i3);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(barcodeFormat)));
    }

    private static b c(com.google.zxing.k.b.a aVar, int i2, int i3) {
        b a = aVar.a();
        if (a != null) {
            int i4 = a.i();
            int g2 = a.g();
            int max = Math.max(i2, i4);
            int max2 = Math.max(i3, g2);
            int min = Math.min(max / i4, max2 / g2);
            int i5 = (max - (i4 * min)) / 2;
            int i6 = (max2 - (g2 * min)) / 2;
            b bVar = new b(max, max2);
            int i7 = 0;
            while (i7 < g2) {
                int i8 = i5;
                int i9 = 0;
                while (i9 < i4) {
                    if (a.e(i9, i7)) {
                        bVar.k(i8, i6, min, min);
                    }
                    i9++;
                    i8 += min;
                }
                i7++;
                i6 += min;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.zxing.j
    public b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) {
        Charset charset;
        int i4;
        int i5;
        Charset charset2 = StandardCharsets.ISO_8859_1;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType)) {
                charset2 = Charset.forName(map.get(encodeHintType).toString());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.ERROR_CORRECTION;
            int parseInt = map.containsKey(encodeHintType2) ? Integer.parseInt(map.get(encodeHintType2).toString()) : 33;
            EncodeHintType encodeHintType3 = EncodeHintType.AZTEC_LAYERS;
            if (map.containsKey(encodeHintType3)) {
                charset = charset2;
                i4 = parseInt;
                i5 = Integer.parseInt(map.get(encodeHintType3).toString());
                return b(str, barcodeFormat, i2, i3, charset, i4, i5);
            }
            charset = charset2;
            i4 = parseInt;
        } else {
            charset = charset2;
            i4 = 33;
        }
        i5 = 0;
        return b(str, barcodeFormat, i2, i3, charset, i4, i5);
    }
}
