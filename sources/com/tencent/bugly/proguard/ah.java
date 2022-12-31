package com.tencent.bugly.proguard;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class ah extends k implements Cloneable {
    public String a = "";

    /* renamed from: d  reason: collision with root package name */
    private String f7924d = "";
    public String b = "";

    /* renamed from: e  reason: collision with root package name */
    private String f7925e = "";
    public String c = "";

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.a, 0);
        String str = this.f7924d;
        if (str != null) {
            jVar.a(str, 1);
        }
        String str2 = this.b;
        if (str2 != null) {
            jVar.a(str2, 2);
        }
        String str3 = this.f7925e;
        if (str3 != null) {
            jVar.a(str3, 3);
        }
        String str4 = this.c;
        if (str4 != null) {
            jVar.a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.a = iVar.b(0, true);
        this.f7924d = iVar.b(1, false);
        this.b = iVar.b(2, false);
        this.f7925e = iVar.b(3, false);
        this.c = iVar.b(4, false);
    }
}
