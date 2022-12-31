package com.tencent.stat;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class p implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ int b;
    final /* synthetic */ n c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar, List list, int i2) {
        this.c = nVar;
        this.a = list;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.b(this.a, this.b);
    }
}
