package us.pinguo.advsdk.manager;

import java.util.List;
import us.pinguo.advsdk.a.m;
import us.pinguo.advsdk.a.p;
import us.pinguo.advsdk.a.q;
/* compiled from: BackInitSdkThread.java */
/* loaded from: classes3.dex */
class b extends Thread {
    private List<m> a;
    private p b;
    private q c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(List<m> list, p pVar, q qVar) {
        this.a = list;
        this.b = pVar;
        this.c = qVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        this.c.i();
        List<m> list = this.a;
        if (list != null && !list.isEmpty() && this.b != null) {
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                this.a.get(i2).d(this.b);
            }
            this.c.h();
            return;
        }
        us.pinguo.advsdk.utils.b.a("callback or sdklist is null");
        this.c.h();
    }
}
