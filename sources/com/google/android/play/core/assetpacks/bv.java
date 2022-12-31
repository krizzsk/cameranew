package com.google.android.play.core.assetpacks;
/* loaded from: classes2.dex */
final class bv extends RuntimeException {
    final int a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(String str) {
        super(str);
        this.a = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(String str, int i2) {
        super(str);
        this.a = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(String str, Exception exc) {
        super(str, exc);
        this.a = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(String str, Exception exc, int i2) {
        super(str, exc);
        this.a = i2;
    }
}
