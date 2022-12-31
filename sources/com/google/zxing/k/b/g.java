package com.google.zxing.k.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Token.java */
/* loaded from: classes2.dex */
public abstract class g {
    static final g b = new e(null, 0, 0);
    private final g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(g gVar) {
        this.a = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final g a(int i2, int i3) {
        return new e(this, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final g b(int i2, int i3) {
        return new b(this, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(com.google.zxing.common.a aVar, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final g d() {
        return this.a;
    }
}
