package com.tencent.stat;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class u implements c {
    final /* synthetic */ List a;
    final /* synthetic */ int b;
    final /* synthetic */ n c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(n nVar, List list, int i2) {
        this.c = nVar;
        this.a = list;
        this.b = i2;
    }

    @Override // com.tencent.stat.c
    public void a() {
        this.c.a(this.a);
    }

    @Override // com.tencent.stat.c
    public void b() {
        this.c.a(this.a, 1);
        this.c.b += this.b;
    }
}
