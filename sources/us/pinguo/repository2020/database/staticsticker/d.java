package us.pinguo.repository2020.database.staticsticker;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.s;
import us.pinguo.common.pgdownloader.download.DownloadListener;
import us.pinguo.common.pgdownloader.download.IDownloadTask;
/* compiled from: MultiFileDownloadTask.kt */
/* loaded from: classes6.dex */
public final class d {
    private final List<l> a;
    private final AtomicInteger b;
    private volatile c c;

    /* compiled from: MultiFileDownloadTask.kt */
    /* loaded from: classes6.dex */
    public static final class a implements DownloadListener {
        a() {
        }

        @Override // us.pinguo.common.pgdownloader.download.DownloadListener
        public void onComplete(IDownloadTask task) {
            s.h(task, "task");
            int incrementAndGet = d.this.b.incrementAndGet();
            int size = d.this.a.size();
            if (incrementAndGet == size) {
                c cVar = d.this.c;
                if (cVar != null) {
                    cVar.onProgress(100);
                }
                c cVar2 = d.this.c;
                if (cVar2 != null) {
                    cVar2.a(d.this.a);
                }
                d.this.c = null;
                return;
            }
            float f2 = incrementAndGet / size;
            c cVar3 = d.this.c;
            if (cVar3 == null) {
                return;
            }
            cVar3.onProgress((int) (f2 * 100));
        }

        @Override // us.pinguo.common.pgdownloader.download.DownloadListener
        public void onError(IDownloadTask task, int i2) {
            s.h(task, "task");
            c cVar = d.this.c;
            if (cVar != null) {
                cVar.b(task.getUrl(), i2);
            }
            d.this.c = null;
        }

        @Override // us.pinguo.common.pgdownloader.download.DownloadListener
        public void onPause(IDownloadTask task) {
            s.h(task, "task");
        }

        @Override // us.pinguo.common.pgdownloader.download.DownloadListener
        public void onProgress(IDownloadTask task, int i2, int i3, int i4) {
            s.h(task, "task");
        }
    }

    public d(List<l> taskList) {
        s.h(taskList, "taskList");
        this.a = taskList;
        this.b = new AtomicInteger();
        for (l lVar : taskList) {
            lVar.b().setListener(new a());
        }
    }

    public final void e(c cb) {
        s.h(cb, "cb");
        this.c = cb;
    }

    public final void f() {
        for (l lVar : this.a) {
            lVar.b().start();
        }
    }
}
