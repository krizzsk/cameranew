package com.tencent.stat;
/* loaded from: classes3.dex */
class m implements c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
    }

    @Override // com.tencent.stat.c
    public void a() {
        if (n.b().a() >= StatConfig.getMaxBatchReportCount()) {
            n.b().a(StatConfig.getMaxBatchReportCount());
        }
    }

    @Override // com.tencent.stat.c
    public void b() {
    }
}
