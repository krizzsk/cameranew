package us.pinguo.svideo.recorder;

import android.content.Context;
import android.media.MediaMuxer;
import android.util.Log;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import us.pinguo.svideo.b.b;
import us.pinguo.svideo.utils.RecordSemaphore;
import us.pinguo.svideo.utils.SVideoUtil;
/* compiled from: SMediaCodecRecorder.java */
/* loaded from: classes6.dex */
public class c extends us.pinguo.svideo.recorder.b {
    public static volatile boolean t = false;
    public static volatile boolean u = false;
    public static Semaphore v;
    public static Semaphore w;
    protected us.pinguo.svideo.b.a p;
    protected int q;
    protected CountDownLatch r;
    protected boolean s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SMediaCodecRecorder.java */
    /* loaded from: classes6.dex */
    public class a implements b.a {
        a(c cVar) {
        }

        @Override // us.pinguo.svideo.b.b.a
        public void a(us.pinguo.svideo.b.b bVar) {
        }

        @Override // us.pinguo.svideo.b.b.a
        public void b(us.pinguo.svideo.b.b bVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SMediaCodecRecorder.java */
    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* compiled from: SMediaCodecRecorder.java */
        /* loaded from: classes6.dex */
        class a implements Runnable {
            final /* synthetic */ long a;

            a(long j2) {
                this.a = j2;
            }

            @Override // java.lang.Runnable
            public void run() {
                us.pinguo.svideo.utils.b.i("已录制视频长度（视频时间）:" + this.a + "ms", new Object[0]);
                c cVar = c.this;
                cVar.n(cVar.f12046j);
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.u();
            long e2 = SVideoUtil.e(c.this.f12041e.get(0));
            c.this.f12045i = System.currentTimeMillis();
            if (e2 > 0) {
                us.pinguo.svideo.c.b a2 = us.pinguo.svideo.utils.d.a();
                c cVar = c.this;
                a2.b(cVar.b, (int) ((((float) (cVar.f12045i - cVar.f12044h)) / ((float) e2)) * 1000.0f));
            }
            c.this.f12046j.setDuration(e2);
            c cVar2 = c.this;
            cVar2.f12046j.setFrameCount(cVar2.q);
            c cVar3 = c.this;
            cVar3.f12046j.setFrameRate(cVar3.q / (((float) e2) / 1000.0f));
            c cVar4 = c.this;
            cVar4.q = 0;
            cVar4.f12041e.clear();
            c.this.f12042f.post(new a(e2));
        }
    }

    public c(Context context, String str, us.pinguo.svideo.c.a aVar) {
        super(context, str, aVar);
    }

    @Override // us.pinguo.svideo.recorder.a
    public void a(Throwable th) {
        this.s = true;
    }

    @Override // us.pinguo.svideo.c.c
    public void h() {
        if (this.f12047k) {
            return;
        }
        q();
    }

    @Override // us.pinguo.svideo.recorder.a
    public void j(Throwable th, boolean z) {
        if (this.f12047k) {
            return;
        }
        us.pinguo.svideo.utils.b.i("onVideoRecordFail", new Object[0]);
        synchronized (this) {
            if (this.f12047k) {
                return;
            }
            this.f12047k = true;
            k(th);
            if (th != null) {
                us.pinguo.svideo.utils.b.d(Log.getStackTraceString(th), new Object[0]);
                us.pinguo.svideo.utils.d.a().a(th);
            }
            if (this.a) {
                us.pinguo.svideo.utils.b.i("stopRecordAndCancel", new Object[0]);
                s();
            }
            SVideoUtil.b(this.f12041e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
        RecordSemaphore recordSemaphore = new RecordSemaphore(2);
        w = recordSemaphore;
        recordSemaphore.tryAcquire(2);
        if (this.s) {
            w.release(1);
        }
    }

    protected void q() {
        this.f12043g.submit(new b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(MediaMuxer mediaMuxer, CountDownLatch countDownLatch) {
        us.pinguo.svideo.b.a aVar = new us.pinguo.svideo.b.a(mediaMuxer, new a(this), countDownLatch);
        this.p = aVar;
        aVar.g(this);
        this.p.i();
    }

    protected void s() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        this.p.j();
    }

    protected void u() {
        throw null;
    }
}
