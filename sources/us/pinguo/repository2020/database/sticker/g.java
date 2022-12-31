package us.pinguo.repository2020.database.sticker;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.s;
import us.pinguo.common.pgdownloader.download.DownloadListener;
import us.pinguo.common.pgdownloader.download.IDownloadTask;
/* compiled from: UnityMaterialDownloadTask.kt */
/* loaded from: classes6.dex */
public final class g {
    private final String a;
    private final IDownloadTask b;
    private final IDownloadTask c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicInteger f11866d;

    /* renamed from: e  reason: collision with root package name */
    private volatile us.pinguo.repository2020.database.sticker.a f11867e;

    /* compiled from: UnityMaterialDownloadTask.kt */
    /* loaded from: classes6.dex */
    public static final class a implements DownloadListener {
        a() {
        }

        @Override // us.pinguo.common.pgdownloader.download.DownloadListener
        public void onComplete(IDownloadTask task) {
            us.pinguo.repository2020.database.sticker.a aVar;
            s.h(task, "task");
            if (2 != g.this.f11866d.incrementAndGet() || (aVar = g.this.f11867e) == null) {
                return;
            }
            aVar.a(g.this.f(), g.this.b, g.this.c);
        }

        @Override // us.pinguo.common.pgdownloader.download.DownloadListener
        public void onError(IDownloadTask task, int i2) {
            s.h(task, "task");
            us.pinguo.repository2020.database.sticker.a aVar = g.this.f11867e;
            if (aVar != null) {
                aVar.c(g.this.f(), task, i2);
            }
            g.this.f11867e = null;
        }

        @Override // us.pinguo.common.pgdownloader.download.DownloadListener
        public void onPause(IDownloadTask task) {
            s.h(task, "task");
        }

        @Override // us.pinguo.common.pgdownloader.download.DownloadListener
        public void onProgress(IDownloadTask task, int i2, int i3, int i4) {
            s.h(task, "task");
            us.pinguo.repository2020.database.sticker.a aVar = g.this.f11867e;
            if (aVar == null) {
                return;
            }
            aVar.b(g.this.f(), task, g.this.c);
        }
    }

    /* compiled from: UnityMaterialDownloadTask.kt */
    /* loaded from: classes6.dex */
    public static final class b implements DownloadListener {
        b() {
        }

        @Override // us.pinguo.common.pgdownloader.download.DownloadListener
        public void onComplete(IDownloadTask task) {
            us.pinguo.repository2020.database.sticker.a aVar;
            s.h(task, "task");
            if (2 != g.this.f11866d.incrementAndGet() || (aVar = g.this.f11867e) == null) {
                return;
            }
            aVar.a(g.this.f(), g.this.b, g.this.c);
        }

        @Override // us.pinguo.common.pgdownloader.download.DownloadListener
        public void onError(IDownloadTask task, int i2) {
            s.h(task, "task");
            us.pinguo.repository2020.database.sticker.a aVar = g.this.f11867e;
            if (aVar != null) {
                aVar.c(g.this.f(), task, i2);
            }
            g.this.f11867e = null;
        }

        @Override // us.pinguo.common.pgdownloader.download.DownloadListener
        public void onPause(IDownloadTask task) {
            s.h(task, "task");
        }

        @Override // us.pinguo.common.pgdownloader.download.DownloadListener
        public void onProgress(IDownloadTask task, int i2, int i3, int i4) {
            s.h(task, "task");
            us.pinguo.repository2020.database.sticker.a aVar = g.this.f11867e;
            if (aVar == null) {
                return;
            }
            aVar.b(g.this.f(), g.this.b, task);
        }
    }

    public g(String id, IDownloadTask displayTask, IDownloadTask packageTask) {
        s.h(id, "id");
        s.h(displayTask, "displayTask");
        s.h(packageTask, "packageTask");
        this.a = id;
        this.b = displayTask;
        this.c = packageTask;
        this.f11866d = new AtomicInteger();
        displayTask.setListener(new a());
        packageTask.setListener(new b());
    }

    public final String f() {
        return this.a;
    }

    public final void g(us.pinguo.repository2020.database.sticker.a cb) {
        s.h(cb, "cb");
        this.f11867e = cb;
    }

    public final void h() {
        this.b.start();
        this.c.start();
    }
}
