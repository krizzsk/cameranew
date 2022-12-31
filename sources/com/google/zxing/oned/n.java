package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;
/* compiled from: UPCAWriter.java */
/* loaded from: classes2.dex */
public final class n implements com.google.zxing.j {
    private final i a = new i();

    @Override // com.google.zxing.j
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.UPC_A) {
            return this.a.a("0".concat(String.valueOf(str)), BarcodeFormat.EAN_13, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(barcodeFormat)));
    }
}
