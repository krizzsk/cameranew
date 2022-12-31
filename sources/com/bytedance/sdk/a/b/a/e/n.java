package com.bytedance.sdk.a.b.a.e;

import java.util.Arrays;
/* compiled from: Settings.java */
/* loaded from: classes.dex */
public final class n {
    private int a;
    private final int[] b = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.a = 0;
        Arrays.fill(this.b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i2) {
        return this.b[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        if ((this.a & 2) != 0) {
            return this.b[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(int i2) {
        return (this.a & 32) != 0 ? this.b[5] : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return Integer.bitCount(this.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i2) {
        return (this.a & 16) != 0 ? this.b[4] : i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        if ((this.a & 128) != 0) {
            return this.b[7];
        }
        return 65535;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n a(int i2, int i3) {
        if (i2 >= 0) {
            int[] iArr = this.b;
            if (i2 < iArr.length) {
                this.a = (1 << i2) | this.a;
                iArr[i2] = i3;
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i2) {
        return ((1 << i2) & this.a) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (nVar.a(i2)) {
                a(i2, nVar.b(i2));
            }
        }
    }
}
