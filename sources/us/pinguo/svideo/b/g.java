package us.pinguo.svideo.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMuxer;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import us.pinguo.svideo.ending.VideoEnding;
/* compiled from: VideoSurfaceEncoderController.java */
/* loaded from: classes6.dex */
public class g implements Runnable, Thread.UncaughtExceptionHandler {
    private d a;
    private volatile c b;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12012d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12013e;

    /* renamed from: f  reason: collision with root package name */
    protected us.pinguo.svideo.recorder.a f12014f;

    /* renamed from: g  reason: collision with root package name */
    private CountDownLatch f12015g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f12016h;

    /* renamed from: i  reason: collision with root package name */
    private Thread f12017i;

    /* renamed from: j  reason: collision with root package name */
    private us.pinguo.svideo.c.f f12018j;

    /* renamed from: k  reason: collision with root package name */
    private int f12019k;

    /* renamed from: l  reason: collision with root package name */
    private int f12020l;
    private volatile Bitmap m;
    private volatile long n;
    private Surface o;
    private volatile Looper q;
    private Object c = new Object();
    private Object p = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoSurfaceEncoderController.java */
    /* loaded from: classes6.dex */
    public class a implements VideoEnding.d {
        final /* synthetic */ VideoEnding.b a;

        a(VideoEnding.b bVar) {
            this.a = bVar;
        }

        @Override // us.pinguo.svideo.ending.VideoEnding.d
        public g a() {
            if (g.this.m != null) {
                this.a.a();
                return g.this;
            }
            long currentTimeMillis = System.currentTimeMillis();
            while (g.this.m == null) {
                synchronized (g.this.p) {
                    try {
                        g.this.p.wait();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            us.pinguo.svideo.utils.b.i("wait last frame bitmap:" + (currentTimeMillis2 - currentTimeMillis) + "ms", new Object[0]);
            this.a.a();
            return g.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoSurfaceEncoderController.java */
    /* loaded from: classes6.dex */
    public class b implements VideoEnding.e {
        b() {
        }

        @Override // us.pinguo.svideo.ending.VideoEnding.e
        public void a(byte[] bArr, long j2) {
            g.this.j(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoSurfaceEncoderController.java */
    /* loaded from: classes6.dex */
    public static class c extends Handler {
        private WeakReference<g> a;

        public c(g gVar) {
            this.a = new WeakReference<>(gVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            Object obj = message.obj;
            g gVar = this.a.get();
            if (gVar == null) {
                us.pinguo.svideo.utils.b.m("EncoderHandler.handleMessage: encoder is null", new Object[0]);
            } else if (i2 == 1) {
                gVar.r();
                Looper.myLooper().quit();
            } else if (i2 == 2) {
                gVar.q(((Long) obj).longValue());
            } else {
                throw new RuntimeException("Unhandled msg what=" + i2);
            }
        }
    }

    public g(int i2, int i3, int i4, int i5, int i6, MediaMuxer mediaMuxer, CountDownLatch countDownLatch, us.pinguo.svideo.recorder.a aVar) {
        this.f12019k = i2;
        this.f12020l = i3;
        this.f12014f = aVar;
        this.f12015g = countDownLatch;
        boolean z = Build.VERSION.SDK_INT >= 21;
        if (z && us.pinguo.svideo.recorder.d.y) {
            this.a = new e(i2, i3, i4, i5, i6, mediaMuxer);
        } else if (z && us.pinguo.svideo.recorder.d.z) {
            this.a = new f(i2, i3, i4, i5, i6, mediaMuxer);
        } else {
            this.a = new d(i2, i3, i4, i5, i6, mediaMuxer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(long j2) {
        us.pinguo.svideo.utils.b.c("handleFrameAvailable", new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        this.a.c(false, j2);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (this.a instanceof f) {
            return;
        }
        us.pinguo.svideo.utils.b.i("drainEncoder:" + (currentTimeMillis2 - currentTimeMillis) + "ms thread:" + Thread.currentThread(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        us.pinguo.svideo.utils.b.c("handleStopRecording", new Object[0]);
        this.a.c(true, -1L);
        this.a.b();
    }

    public void e() {
        if (this.f12017i == null || this.c == null || this.q == null) {
            return;
        }
        synchronized (this.c) {
            this.c.notifyAll();
        }
    }

    public void f() {
        y();
    }

    public void g() {
        y();
        us.pinguo.svideo.utils.b.i("finishAndWait 1", new Object[0]);
        synchronized (this.c) {
            while (this.f12013e) {
                try {
                    this.c.wait();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        us.pinguo.svideo.utils.b.i("finishAndWait 2", new Object[0]);
    }

    public void h(Context context, String str, VideoEnding.c cVar, VideoEnding.b bVar) {
        VideoEnding.a(context, str, this.f12019k, this.f12020l, new a(bVar), cVar, bVar, new b());
    }

    public void i() {
        j(-1L);
    }

    public void j(long j2) {
        us.pinguo.svideo.utils.b.i("frameAvailableSoon:" + j2, new Object[0]);
        synchronized (this.c) {
            us.pinguo.svideo.utils.b.i("synchronized (mReadyFence):" + this.f12012d, new Object[0]);
            if (this.f12012d) {
                this.b.sendMessage(this.b.obtainMessage(2, Long.valueOf(j2)));
            }
        }
    }

    public Surface k() {
        return this.a.d();
    }

    public Bitmap l() {
        Bitmap bitmap = this.m;
        this.m = null;
        return bitmap;
    }

    public long m() {
        long j2 = this.n;
        this.n = 0L;
        return j2;
    }

    public int n() {
        return this.a.e();
    }

    public Thread.State o() {
        Thread thread = this.f12017i;
        if (thread == null) {
            return null;
        }
        return thread.getState();
    }

    public Surface p() {
        Surface surface = this.o;
        this.o = null;
        return surface;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(this);
        Looper.prepare();
        synchronized (this.c) {
            this.b = new c(this);
            this.a.f();
            this.f12018j.a(k());
            this.f12012d = true;
            this.c.notify();
        }
        this.q = Looper.myLooper();
        Looper.loop();
        us.pinguo.svideo.utils.b.c("Encoder thread exiting", new Object[0]);
        synchronized (this.c) {
            this.f12013e = false;
            this.f12012d = false;
            this.b = null;
            this.f12016h = true;
            this.c.notify();
        }
    }

    public boolean s() {
        return this.f12017i.isAlive();
    }

    public boolean t() {
        return this.f12016h;
    }

    public void u(Bitmap bitmap, long j2) {
        synchronized (this.p) {
            this.n = j2;
            this.m = bitmap;
            this.p.notifyAll();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        this.f12015g.countDown();
        z(th);
    }

    public void v(us.pinguo.svideo.c.f fVar) {
        this.f12018j = fVar;
    }

    public void w(Surface surface) {
        this.o = surface;
    }

    public void x() {
        synchronized (this.c) {
            if (this.f12013e) {
                us.pinguo.svideo.utils.b.m("Encoder thread already running", new Object[0]);
                return;
            }
            this.f12013e = true;
            us.pinguo.svideo.utils.c cVar = new us.pinguo.svideo.utils.c(this, "VideoSurfaceEncoderController", this.f12015g);
            this.f12017i = cVar;
            cVar.start();
        }
    }

    public void y() {
        this.b.sendMessage(this.b.obtainMessage(1));
    }

    public void z(Throwable th) {
        us.pinguo.svideo.recorder.a aVar = this.f12014f;
        if (aVar != null) {
            aVar.j(th, true);
        }
        us.pinguo.svideo.utils.b.e(th);
        d dVar = this.a;
        if (dVar != null) {
            dVar.b();
        }
    }
}
