package com.google.zxing.k.b;
/* compiled from: SimpleToken.java */
/* loaded from: classes2.dex */
final class e extends g {
    private final short c;

    /* renamed from: d  reason: collision with root package name */
    private final short f5028d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(g gVar, int i2, int i3) {
        super(gVar);
        this.c = (short) i2;
        this.f5028d = (short) i3;
    }

    @Override // com.google.zxing.k.b.g
    void c(com.google.zxing.common.a aVar, byte[] bArr) {
        aVar.c(this.c, this.f5028d);
    }

    public String toString() {
        short s = this.c;
        short s2 = this.f5028d;
        int i2 = (s & ((1 << s2) - 1)) | (1 << s2);
        return "<" + Integer.toBinaryString(i2 | (1 << this.f5028d)).substring(1) + '>';
    }
}
