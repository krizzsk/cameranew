package us.pinguo.push;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: PushQueueManager.java */
/* loaded from: classes6.dex */
public class i {
    private ExecutorService a = Executors.newSingleThreadExecutor();

    /* compiled from: PushQueueManager.java */
    /* loaded from: classes6.dex */
    public interface a {
        void a(int i2);
    }

    /* compiled from: PushQueueManager.java */
    /* loaded from: classes6.dex */
    private class b implements Runnable {
        private c a;
        private a b;

        b(i iVar, c cVar, a aVar) {
            this.a = cVar;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = this.a;
            if (cVar == null) {
                return;
            }
            try {
                PushResult j2 = cVar.j();
                a aVar = this.b;
                if (aVar != null && j2 != null) {
                    aVar.a(j2.getValue());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar, a aVar) {
        if (cVar != null) {
            this.a.execute(new b(this, cVar, aVar));
        }
    }
}
