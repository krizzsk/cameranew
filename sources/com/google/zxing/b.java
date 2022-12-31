package com.google.zxing;
/* compiled from: BinaryBitmap.java */
/* loaded from: classes2.dex */
public final class b {
    private final a a;
    private com.google.zxing.common.b b;

    public b(a aVar) {
        if (aVar != null) {
            this.a = aVar;
            return;
        }
        throw new IllegalArgumentException("Binarizer must be non-null.");
    }

    public com.google.zxing.common.b a() throws NotFoundException {
        if (this.b == null) {
            this.b = this.a.a();
        }
        return this.b;
    }

    public String toString() {
        try {
            return a().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
