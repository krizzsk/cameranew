package com.tencent.bugly.proguard;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class ao extends k implements Cloneable {
    public String a = "";
    private String b = "";

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.a, 0);
        jVar.a(this.b, 1);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.a = iVar.b(0, true);
        this.b = iVar.b(1, true);
    }
}
