package com.google.zxing.n;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.common.f;
import com.google.zxing.g;
import com.google.zxing.h;
import com.google.zxing.qrcode.decoder.d;
import com.google.zxing.qrcode.detector.c;
import java.util.List;
import java.util.Map;
/* compiled from: QRCodeReader.java */
/* loaded from: classes2.dex */
public class a {
    private static final h[] b = new h[0];
    private final d a = new d();

    private static com.google.zxing.common.b c(com.google.zxing.common.b bVar) throws NotFoundException {
        int[] h2 = bVar.h();
        int[] f2 = bVar.f();
        if (h2 != null && f2 != null) {
            float d2 = d(h2, bVar);
            int i2 = h2[1];
            int i3 = f2[1];
            int i4 = h2[0];
            int i5 = f2[0];
            if (i4 < i5 && i2 < i3) {
                int i6 = i3 - i2;
                if (i6 != i5 - i4 && (i5 = i4 + i6) >= bVar.i()) {
                    throw NotFoundException.getNotFoundInstance();
                }
                int round = Math.round(((i5 - i4) + 1) / d2);
                int round2 = Math.round((i6 + 1) / d2);
                if (round <= 0 || round2 <= 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (round2 == round) {
                    int i7 = (int) (d2 / 2.0f);
                    int i8 = i2 + i7;
                    int i9 = i4 + i7;
                    int i10 = (((int) ((round - 1) * d2)) + i9) - i5;
                    if (i10 > 0) {
                        if (i10 > i7) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        i9 -= i10;
                    }
                    int i11 = (((int) ((round2 - 1) * d2)) + i8) - i3;
                    if (i11 > 0) {
                        if (i11 > i7) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                        i8 -= i11;
                    }
                    com.google.zxing.common.b bVar2 = new com.google.zxing.common.b(round, round2);
                    for (int i12 = 0; i12 < round2; i12++) {
                        int i13 = ((int) (i12 * d2)) + i8;
                        for (int i14 = 0; i14 < round; i14++) {
                            if (bVar.e(((int) (i14 * d2)) + i9, i13)) {
                                bVar2.j(i14, i12);
                            }
                        }
                    }
                    return bVar2;
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static float d(int[] iArr, com.google.zxing.common.b bVar) throws NotFoundException {
        int g2 = bVar.g();
        int i2 = bVar.i();
        int i3 = iArr[0];
        boolean z = true;
        int i4 = iArr[1];
        int i5 = 0;
        while (i3 < i2 && i4 < g2) {
            if (z != bVar.e(i3, i4)) {
                i5++;
                if (i5 == 5) {
                    break;
                }
                z = !z;
            }
            i3++;
            i4++;
        }
        if (i3 != i2 && i4 != g2) {
            return (i3 - iArr[0]) / 7.0f;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public g a(com.google.zxing.b bVar) throws NotFoundException, ChecksumException, FormatException {
        return b(bVar, null);
    }

    public final g b(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        h[] b2;
        com.google.zxing.common.d dVar;
        if (map != null && map.containsKey(DecodeHintType.PURE_BARCODE)) {
            dVar = this.a.b(c(bVar.a()), map);
            b2 = b;
        } else {
            f e2 = new c(bVar.a()).e(map);
            com.google.zxing.common.d b3 = this.a.b(e2.a(), map);
            b2 = e2.b();
            dVar = b3;
        }
        if (dVar.c() instanceof com.google.zxing.qrcode.decoder.f) {
            ((com.google.zxing.qrcode.decoder.f) dVar.c()).a(b2);
        }
        g gVar = new g(dVar.g(), dVar.d(), b2, BarcodeFormat.QR_CODE);
        List<byte[]> a = dVar.a();
        if (a != null) {
            gVar.c(ResultMetadataType.BYTE_SEGMENTS, a);
        }
        String b4 = dVar.b();
        if (b4 != null) {
            gVar.c(ResultMetadataType.ERROR_CORRECTION_LEVEL, b4);
        }
        if (dVar.h()) {
            gVar.c(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(dVar.f()));
            gVar.c(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(dVar.e()));
        }
        return gVar;
    }
}
