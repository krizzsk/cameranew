package com.google.zxing.qrcode.decoder;

import com.google.zxing.h;
/* compiled from: QRCodeDecoderMetaData.java */
/* loaded from: classes2.dex */
public final class f {
    private final boolean a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(boolean z) {
        this.a = z;
    }

    public void a(h[] hVarArr) {
        if (!this.a || hVarArr == null || hVarArr.length < 3) {
            return;
        }
        h hVar = hVarArr[0];
        hVarArr[0] = hVarArr[2];
        hVarArr[2] = hVar;
    }
}
