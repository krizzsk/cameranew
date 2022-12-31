package com.google.zxing.multi.qrcode;

import com.google.zxing.ResultMetadataType;
import com.google.zxing.g;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
/* loaded from: classes2.dex */
final class QRCodeMultiReader$SAComparator implements Serializable, Comparator<g> {
    private QRCodeMultiReader$SAComparator() {
    }

    @Override // java.util.Comparator
    public int compare(g gVar, g gVar2) {
        Map<ResultMetadataType, Object> a = gVar.a();
        ResultMetadataType resultMetadataType = ResultMetadataType.STRUCTURED_APPEND_SEQUENCE;
        return Integer.compare(((Integer) a.get(resultMetadataType)).intValue(), ((Integer) gVar2.a().get(resultMetadataType)).intValue());
    }
}
