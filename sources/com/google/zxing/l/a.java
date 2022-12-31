package com.google.zxing.l;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.c;
import com.google.zxing.common.b;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.datamatrix.encoder.e;
import com.google.zxing.datamatrix.encoder.i;
import com.google.zxing.datamatrix.encoder.k;
import com.google.zxing.j;
import java.util.Map;
/* compiled from: DataMatrixWriter.java */
/* loaded from: classes2.dex */
public final class a implements j {
    private static b b(com.google.zxing.n.c.b bVar, int i2, int i3) {
        b bVar2;
        int e2 = bVar.e();
        int d2 = bVar.d();
        int max = Math.max(i2, e2);
        int max2 = Math.max(i3, d2);
        int min = Math.min(max / e2, max2 / d2);
        int i4 = (max - (e2 * min)) / 2;
        int i5 = (max2 - (d2 * min)) / 2;
        if (i3 >= d2 && i2 >= e2) {
            bVar2 = new b(i2, i3);
        } else {
            bVar2 = new b(e2, d2);
            i4 = 0;
            i5 = 0;
        }
        bVar2.b();
        int i6 = 0;
        while (i6 < d2) {
            int i7 = i4;
            int i8 = 0;
            while (i8 < e2) {
                if (bVar.b(i8, i6) == 1) {
                    bVar2.k(i7, i5, min, min);
                }
                i8++;
                i7 += min;
            }
            i6++;
            i5 += min;
        }
        return bVar2;
    }

    private static b c(e eVar, k kVar, int i2, int i3) {
        int h2 = kVar.h();
        int g2 = kVar.g();
        com.google.zxing.n.c.b bVar = new com.google.zxing.n.c.b(kVar.j(), kVar.i());
        int i4 = 0;
        for (int i5 = 0; i5 < g2; i5++) {
            if (i5 % kVar.f5017e == 0) {
                int i6 = 0;
                for (int i7 = 0; i7 < kVar.j(); i7++) {
                    bVar.g(i6, i4, i7 % 2 == 0);
                    i6++;
                }
                i4++;
            }
            int i8 = 0;
            for (int i9 = 0; i9 < h2; i9++) {
                if (i9 % kVar.f5016d == 0) {
                    bVar.g(i8, i4, true);
                    i8++;
                }
                bVar.g(i8, i4, eVar.e(i9, i5));
                i8++;
                int i10 = kVar.f5016d;
                if (i9 % i10 == i10 - 1) {
                    bVar.g(i8, i4, i5 % 2 == 0);
                    i8++;
                }
            }
            i4++;
            int i11 = kVar.f5017e;
            if (i5 % i11 == i11 - 1) {
                int i12 = 0;
                for (int i13 = 0; i13 < kVar.j(); i13++) {
                    bVar.g(i12, i4, true);
                    i12++;
                }
                i4++;
            }
        }
        return b(bVar, i2, i3);
    }

    @Override // com.google.zxing.j
    public b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) {
        c cVar;
        if (!str.isEmpty()) {
            if (barcodeFormat == BarcodeFormat.DATA_MATRIX) {
                if (i2 >= 0 && i3 >= 0) {
                    SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
                    c cVar2 = null;
                    if (map != null) {
                        SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
                        if (symbolShapeHint2 != null) {
                            symbolShapeHint = symbolShapeHint2;
                        }
                        c cVar3 = (c) map.get(EncodeHintType.MIN_SIZE);
                        if (cVar3 == null) {
                            cVar3 = null;
                        }
                        cVar = (c) map.get(EncodeHintType.MAX_SIZE);
                        if (cVar == null) {
                            cVar = null;
                        }
                        cVar2 = cVar3;
                    } else {
                        cVar = null;
                    }
                    String b = com.google.zxing.datamatrix.encoder.j.b(str, symbolShapeHint, cVar2, cVar);
                    k l2 = k.l(b.length(), symbolShapeHint, cVar2, cVar, true);
                    e eVar = new e(i.c(b, l2), l2.h(), l2.g());
                    eVar.h();
                    return c(eVar, l2, i2, i3);
                }
                throw new IllegalArgumentException("Requested dimensions can't be negative: " + i2 + 'x' + i3);
            }
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(barcodeFormat)));
        }
        throw new IllegalArgumentException("Found empty contents");
    }
}
