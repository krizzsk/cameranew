package com.google.android.gms.common;

import java.lang.ref.WeakReference;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
abstract class j extends h {
    private static final WeakReference<byte[]> c = new WeakReference<>(null);
    private WeakReference<byte[]> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(byte[] bArr) {
        super(bArr);
        this.b = c;
    }

    protected abstract byte[] A0();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.h
    public final byte[] y0() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.b.get();
            if (bArr == null) {
                bArr = A0();
                this.b = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
