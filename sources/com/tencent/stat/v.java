package com.tencent.stat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class v implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ n b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(n nVar, int i2) {
        this.b = nVar;
        this.a = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        int a = StatConfig.a();
        int i2 = this.a;
        if (i2 == -1) {
            i2 = this.b.b;
        }
        int i3 = i2 / a;
        int i4 = i2 % a;
        for (int i5 = 0; i5 < i3 + 1; i5++) {
            this.b.b(a);
        }
        if (i4 > 0) {
            this.b.b(i4);
        }
    }
}
