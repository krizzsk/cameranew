package com.huawei.hianalytics.v2.a.b;
/* loaded from: classes2.dex */
public class d implements c {
    private com.huawei.hianalytics.v2.a.a.e a;

    public d(com.huawei.hianalytics.v2.a.a.e eVar) {
        this.a = eVar;
    }

    @Override // com.huawei.hianalytics.v2.a.b.c
    public com.huawei.hianalytics.v2.a.a.a a(String str) {
        com.huawei.hianalytics.v2.a.a.a aVar = new com.huawei.hianalytics.v2.a.a.a();
        aVar.b(this.a.c());
        aVar.d(this.a.e());
        aVar.a(this.a.b());
        aVar.c(this.a.d());
        return aVar;
    }

    @Override // com.huawei.hianalytics.v2.a.b.c
    public boolean a(long j2) {
        return com.huawei.hianalytics.util.e.a(this.a.b(), j2);
    }
}
