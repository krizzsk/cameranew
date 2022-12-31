package com.google.android.gms.common;

import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
final class k extends h {
    private final byte[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.b = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.h
    public final byte[] y0() {
        return this.b;
    }
}
