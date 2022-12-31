package com.google.zxing.m;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.b;
import com.google.zxing.j;
import com.google.zxing.pdf417.encoder.Compaction;
import com.google.zxing.pdf417.encoder.c;
import com.google.zxing.pdf417.encoder.d;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;
/* compiled from: PDF417Writer.java */
/* loaded from: classes2.dex */
public final class a implements j {
    private static b b(byte[][] bArr, int i2) {
        int i3 = i2 * 2;
        b bVar = new b(bArr[0].length + i3, bArr.length + i3);
        bVar.b();
        int g2 = (bVar.g() - i2) - 1;
        int i4 = 0;
        while (i4 < bArr.length) {
            byte[] bArr2 = bArr[i4];
            for (int i5 = 0; i5 < bArr[0].length; i5++) {
                if (bArr2[i5] == 1) {
                    bVar.j(i5 + i2, g2);
                }
            }
            i4++;
            g2--;
        }
        return bVar;
    }

    private static b c(d dVar, String str, int i2, int i3, int i4, int i5) throws WriterException {
        boolean z;
        dVar.e(str, i2);
        byte[][] b = dVar.f().b(1, 4);
        if ((i4 > i3) != (b[0].length < b.length)) {
            b = d(b);
            z = true;
        } else {
            z = false;
        }
        int length = i3 / b[0].length;
        int length2 = i4 / b.length;
        if (length >= length2) {
            length = length2;
        }
        if (length > 1) {
            byte[][] b2 = dVar.f().b(length, length << 2);
            if (z) {
                b2 = d(b2);
            }
            return b(b2, i5);
        }
        return b(b, i5);
    }

    private static byte[][] d(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance(byte.class, bArr[0].length, bArr.length);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int length = (bArr.length - i2) - 1;
            for (int i3 = 0; i3 < bArr[0].length; i3++) {
                bArr2[i3][length] = bArr[i2][i3];
            }
        }
        return bArr2;
    }

    @Override // com.google.zxing.j
    public b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        int i4;
        int i5;
        if (barcodeFormat == BarcodeFormat.PDF_417) {
            d dVar = new d();
            if (map != null) {
                EncodeHintType encodeHintType = EncodeHintType.PDF417_COMPACT;
                if (map.containsKey(encodeHintType)) {
                    dVar.h(Boolean.valueOf(map.get(encodeHintType).toString()).booleanValue());
                }
                EncodeHintType encodeHintType2 = EncodeHintType.PDF417_COMPACTION;
                if (map.containsKey(encodeHintType2)) {
                    dVar.i(Compaction.valueOf(map.get(encodeHintType2).toString()));
                }
                EncodeHintType encodeHintType3 = EncodeHintType.PDF417_DIMENSIONS;
                if (map.containsKey(encodeHintType3)) {
                    c cVar = (c) map.get(encodeHintType3);
                    dVar.j(cVar.a(), cVar.c(), cVar.b(), cVar.d());
                }
                EncodeHintType encodeHintType4 = EncodeHintType.MARGIN;
                int parseInt = map.containsKey(encodeHintType4) ? Integer.parseInt(map.get(encodeHintType4).toString()) : 30;
                EncodeHintType encodeHintType5 = EncodeHintType.ERROR_CORRECTION;
                int parseInt2 = map.containsKey(encodeHintType5) ? Integer.parseInt(map.get(encodeHintType5).toString()) : 2;
                EncodeHintType encodeHintType6 = EncodeHintType.CHARACTER_SET;
                if (map.containsKey(encodeHintType6)) {
                    dVar.k(Charset.forName(map.get(encodeHintType6).toString()));
                }
                i5 = parseInt;
                i4 = parseInt2;
            } else {
                i4 = 2;
                i5 = 30;
            }
            return c(dVar, str, i4, i2, i3, i5);
        }
        throw new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(barcodeFormat)));
    }
}
