package us.pinguo.svideo.recorder;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMuxer;
import android.view.Surface;
import java.io.File;
import java.io.IOException;
import java.lang.Thread;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import us.pinguo.svideo.c.f;
import us.pinguo.svideo.c.g;
import us.pinguo.svideo.c.h;
import us.pinguo.svideo.ending.VideoEnding;
import us.pinguo.svideo.utils.RecordSemaphore;
/* compiled from: SSurfaceRecorder.java */
/* loaded from: classes6.dex */
public class d extends us.pinguo.svideo.recorder.c implements g {
    public static boolean y = true;
    public static boolean z = false;
    protected us.pinguo.svideo.b.g x;

    /* compiled from: SSurfaceRecorder.java */
    /* loaded from: classes6.dex */
    class a implements VideoEnding.c {
        a() {
        }

        @Override // us.pinguo.svideo.ending.VideoEnding.c
        public void onComplete(boolean z) {
            us.pinguo.svideo.utils.b.i("片尾onComplete:" + z, new Object[0]);
            d.this.p();
            d.this.t();
            d.this.x.g();
            d dVar = d.this;
            dVar.q += dVar.x.n();
        }
    }

    /* compiled from: SSurfaceRecorder.java */
    /* loaded from: classes6.dex */
    class b implements VideoEnding.b {
        b() {
        }

        @Override // us.pinguo.svideo.ending.VideoEnding.b
        public void a() {
            us.pinguo.svideo.utils.b.i("onBitmapGot", new Object[0]);
            d.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SSurfaceRecorder.java */
    /* loaded from: classes6.dex */
    public class c implements h {
        c() {
        }

        @Override // us.pinguo.svideo.c.h
        public void a(f fVar) {
            d.this.x.v(fVar);
        }
    }

    public d(Context context, String str, us.pinguo.svideo.c.a aVar) {
        super(context, str, aVar);
    }

    @Override // us.pinguo.svideo.c.g
    public void e(boolean z2, Bitmap bitmap, Surface surface, long j2) {
        us.pinguo.svideo.b.g gVar = this.x;
        if (gVar != null) {
            if (!z2) {
                gVar.i();
                return;
            }
            gVar.w(surface);
            this.x.u(bitmap, j2);
        }
    }

    @Override // us.pinguo.svideo.c.c
    public void g() {
        this.f12047k = false;
        l();
        us.pinguo.svideo.b.g gVar = this.x;
        if (gVar != null && gVar.s()) {
            Thread.State o = this.x.o();
            if (o != null) {
                us.pinguo.svideo.utils.b.i("pre mRecorderThread,state:" + o, new Object[0]);
            }
            this.x.e();
        }
        this.s = false;
        if (v()) {
            w();
            this.x.x();
            this.f12044h = System.currentTimeMillis();
            this.a = true;
        }
    }

    @Override // us.pinguo.svideo.recorder.b
    protected void o() {
        if (this.a) {
            x();
            this.a = false;
            us.pinguo.svideo.b.a aVar = this.p;
            if (aVar != null) {
                aVar.o(true);
            }
            us.pinguo.svideo.utils.b.i("stopRecordNotCancel,开始制作片尾", new Object[0]);
            this.x.h(this.b, this.n, new a(), new b());
        }
    }

    @Override // us.pinguo.svideo.recorder.c
    protected void s() {
        if (this.a) {
            x();
            this.a = false;
            p();
            t();
            this.x.e();
            this.x.f();
            this.q += this.x.n();
        }
    }

    @Override // us.pinguo.svideo.recorder.c
    protected void u() {
        boolean z2;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = 1000;
        int i2 = -1;
        while (true) {
            try {
                z2 = !this.r.await(j2, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                z2 = false;
            }
            if (!z2) {
                if (this.f12047k) {
                    return;
                }
                return;
            } else if (!this.x.s()) {
                if (this.f12047k || this.x.t()) {
                    return;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                j(new RecordFailException("等待录制线程stop" + (currentTimeMillis2 - currentTimeMillis) + "ms,超时"), true);
                return;
            } else {
                int n = this.x.n();
                if (i2 < 0) {
                    i2 = n;
                } else if (i2 == n) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    Object o = this.x.o();
                    StringBuilder sb = new StringBuilder();
                    sb.append("等待录制线程stop");
                    sb.append(currentTimeMillis3 - currentTimeMillis);
                    sb.append("ms,已录制:");
                    sb.append(i2);
                    sb.append("帧，未变化,state:");
                    if (o == null) {
                        o = "null";
                    }
                    sb.append(o);
                    sb.append(",视为卡死");
                    j(new RecordFailException(sb.toString()), true);
                    return;
                }
                us.pinguo.svideo.utils.b.i("数据还没写完，继续等……，已录制:" + this.x.n(), new Object[0]);
                j2 = 3000L;
            }
        }
    }

    @TargetApi(18)
    protected boolean v() {
        String generate = this.o.generate();
        File file = new File(generate);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            this.f12041e.add(generate);
            int c2 = this.c.c();
            int b2 = this.c.b();
            us.pinguo.svideo.utils.b.i("previewSize:" + c2 + "," + b2, new Object[0]);
            RecordSemaphore recordSemaphore = new RecordSemaphore(2);
            us.pinguo.svideo.recorder.c.v = recordSemaphore;
            try {
                recordSemaphore.acquire(2);
            } catch (InterruptedException e2) {
                us.pinguo.svideo.utils.d.a().a(e2);
            }
            us.pinguo.svideo.recorder.c.t = false;
            us.pinguo.svideo.recorder.c.u = false;
            int a2 = this.c.a();
            try {
                MediaMuxer mediaMuxer = new MediaMuxer(generate, 0);
                mediaMuxer.setOrientationHint(a2);
                CountDownLatch countDownLatch = new CountDownLatch(3);
                this.r = countDownLatch;
                this.x = new us.pinguo.svideo.b.g(c2, b2, this.m, this.f12048l, 1, mediaMuxer, countDownLatch, this);
                r(mediaMuxer, this.r);
                this.f12046j.setVideoRotation(a2);
                this.f12046j.setVideoPath(generate);
                this.f12046j.setVideoWidth(c2);
                this.f12046j.setVideoHeight(b2);
                this.f12046j.setVideoBitRate(this.m);
                return true;
            } catch (IOException e3) {
                j(e3, true);
                return false;
            }
        } catch (IOException e4) {
            j(e4, false);
            return false;
        }
    }

    protected void w() {
        us.pinguo.svideo.c.a aVar = this.c;
        if (aVar != null) {
            aVar.e(this, new c());
        }
    }

    protected void x() {
        us.pinguo.svideo.c.a aVar = this.c;
        if (aVar != null) {
            aVar.d(this);
        }
    }
}
