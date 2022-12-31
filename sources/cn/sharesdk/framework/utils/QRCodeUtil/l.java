package cn.sharesdk.framework.utils.QRCodeUtil;

import java.util.Map;
/* compiled from: QRCodeWriter.java */
/* loaded from: classes.dex */
public final class l implements Writer {
    private static c a(cn.sharesdk.framework.utils.QRCodeUtil.a.f fVar, int i2, int i3, int i4) {
        cn.sharesdk.framework.utils.QRCodeUtil.a.b a = fVar.a();
        if (a != null) {
            int b = a.b();
            int a2 = a.a();
            int i5 = i4 * 2;
            int i6 = b + i5;
            int i7 = i5 + a2;
            int max = Math.max(i2, i6);
            int max2 = Math.max(i3, i7);
            int min = Math.min(max / i6, max2 / i7);
            int i8 = (max - (b * min)) / 2;
            int i9 = (max2 - (a2 * min)) / 2;
            c cVar = new c(max, max2);
            int i10 = 0;
            while (i10 < a2) {
                int i11 = i8;
                int i12 = 0;
                while (i12 < b) {
                    if (a.a(i12, i10) == 1) {
                        cVar.a(i11, i9, min, min);
                    }
                    i12++;
                    i11 += min;
                }
                i10++;
                i9 += min;
            }
            return cVar;
        }
        throw new IllegalStateException();
    }

    @Override // cn.sharesdk.framework.utils.QRCodeUtil.Writer
    public c encode(String str, a aVar, int i2, int i3) throws WriterException {
        return encode(str, aVar, i2, i3, null);
    }

    @Override // cn.sharesdk.framework.utils.QRCodeUtil.Writer
    public c encode(String str, a aVar, int i2, int i3, Map<e, ?> map) throws WriterException {
        if (!str.isEmpty()) {
            if (aVar != a.QR_CODE) {
                throw new IllegalArgumentException("Can only encode QR_CODE, but got " + aVar);
            } else if (i2 >= 0 && i3 >= 0) {
                f fVar = f.L;
                int i4 = 4;
                if (map != null) {
                    e eVar = e.ERROR_CORRECTION;
                    if (map.containsKey(eVar)) {
                        fVar = f.valueOf(map.get(eVar).toString());
                    }
                    e eVar2 = e.MARGIN;
                    if (map.containsKey(eVar2)) {
                        i4 = Integer.parseInt(map.get(eVar2).toString());
                    }
                }
                return a(cn.sharesdk.framework.utils.QRCodeUtil.a.c.a(str, fVar, map), i2, i3, i4);
            } else {
                throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
            }
        }
        throw new IllegalArgumentException("Found empty contents");
    }
}
