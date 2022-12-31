package us.pinguo.svideo.b;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
/* compiled from: MediaEncoder.java */
@TargetApi(18)
/* loaded from: classes6.dex */
public abstract class b implements Runnable {
    protected final Object a;
    protected volatile boolean b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    protected volatile boolean f11994d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f11995e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f11996f;

    /* renamed from: g  reason: collision with root package name */
    protected int f11997g;

    /* renamed from: h  reason: collision with root package name */
    protected MediaCodec f11998h;

    /* renamed from: i  reason: collision with root package name */
    private MediaCodec.BufferInfo f11999i;

    /* renamed from: j  reason: collision with root package name */
    protected final a f12000j;

    /* renamed from: k  reason: collision with root package name */
    private Thread f12001k;

    /* renamed from: l  reason: collision with root package name */
    private MediaMuxer f12002l;
    private us.pinguo.svideo.recorder.a m;
    private MediaFormat n;
    protected CountDownLatch o;
    protected boolean p;
    private long q;
    private long r;

    /* compiled from: MediaEncoder.java */
    /* loaded from: classes6.dex */
    public interface a {
        void a(b bVar);

        void b(b bVar);
    }

    public b(MediaMuxer mediaMuxer, a aVar, CountDownLatch countDownLatch) {
        Object obj = new Object();
        this.a = obj;
        this.p = false;
        this.q = 0L;
        this.r = 0L;
        Objects.requireNonNull(aVar, "MediaEncoderListener is null");
        Objects.requireNonNull(mediaMuxer, "MediaMuxerWrapper is null");
        this.o = countDownLatch;
        this.f12002l = mediaMuxer;
        this.f12000j = aVar;
        synchronized (obj) {
            this.f11999i = new MediaCodec.BufferInfo();
            us.pinguo.svideo.utils.c cVar = new us.pinguo.svideo.utils.c(this, getClass().getSimpleName(), this.o);
            this.f12001k = cVar;
            cVar.start();
            try {
                obj.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    protected void a() {
        MediaCodec mediaCodec = this.f11998h;
        if (mediaCodec == null) {
            return;
        }
        ByteBuffer[] outputBuffers = mediaCodec.getOutputBuffers();
        if (this.f12002l == null) {
            Log.w("MediaEncoder", "muxer is unexpectedly null");
            return;
        }
        int i2 = 0;
        while (this.b) {
            int dequeueOutputBuffer = this.f11998h.dequeueOutputBuffer(this.f11999i, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!this.f11995e && (i2 = i2 + 1) > 5) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f11998h.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (!this.f11996f) {
                    this.n = this.f11998h.getOutputFormat();
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer >= 0) {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer != null) {
                    MediaCodec.BufferInfo bufferInfo = this.f11999i;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    if (bufferInfo.size != 0) {
                        if (!this.f11996f) {
                            this.f11997g = this.f12002l.addTrack(this.n);
                            this.f11996f = true;
                            us.pinguo.svideo.recorder.c.v.release(1);
                            try {
                                try {
                                    us.pinguo.svideo.recorder.c.v.acquire(2);
                                    if (!us.pinguo.svideo.recorder.c.t && !us.pinguo.svideo.recorder.c.t) {
                                        us.pinguo.svideo.recorder.c.t = true;
                                        this.f12002l.start();
                                    }
                                } catch (InterruptedException e2) {
                                    us.pinguo.svideo.utils.d.a().a(e2);
                                }
                            } finally {
                                us.pinguo.svideo.recorder.c.v.release(2);
                            }
                        }
                        this.f12002l.writeSampleData(this.f11997g, byteBuffer, this.f11999i);
                        this.r = this.f11999i.presentationTimeUs;
                        i2 = 0;
                    }
                    this.f11998h.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.f11999i.flags & 4) != 0) {
                        this.b = false;
                        return;
                    }
                } else {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
            } else {
                continue;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(ByteBuffer byteBuffer, int i2, long j2) {
        if (this.b) {
            ByteBuffer[] inputBuffers = this.f11998h.getInputBuffers();
            while (this.b) {
                int dequeueInputBuffer = this.f11998h.dequeueInputBuffer(10000L);
                if (dequeueInputBuffer >= 0) {
                    ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
                    byteBuffer2.clear();
                    if (byteBuffer != null) {
                        byteBuffer2.put(byteBuffer);
                    }
                    if (i2 <= 0) {
                        this.f11995e = true;
                        this.f11998h.queueInputBuffer(dequeueInputBuffer, 0, 0, j2, 4);
                        return;
                    }
                    this.f11998h.queueInputBuffer(dequeueInputBuffer, 0, i2, j2, 0);
                    return;
                }
            }
        }
    }

    public boolean c() {
        synchronized (this.a) {
            if (this.b && !this.f11994d) {
                this.c++;
                this.a.notifyAll();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long d() {
        long nanoTime = (long) (((System.nanoTime() / 1000) - this.q) * us.pinguo.svideo.utils.e.b());
        long j2 = this.r;
        return nanoTime < j2 ? nanoTime + (j2 - nanoTime) : nanoTime;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(boolean z) {
        try {
            this.f12000j.b(this);
        } catch (Exception e2) {
            Log.e("MediaEncoder", "failed onStopped", e2);
        }
        this.b = false;
        MediaCodec mediaCodec = this.f11998h;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                this.f11998h.release();
                this.f11998h = null;
            } catch (Exception e3) {
                Log.e("MediaEncoder", "failed releasing MediaCodec", e3);
            }
        }
        if (this.f11996f) {
            us.pinguo.svideo.utils.b.i("releaseMuxer:" + z, new Object[0]);
            if (!z) {
                us.pinguo.svideo.recorder.c.w.release(1);
            } else if (this.f12002l != null) {
                try {
                    try {
                        us.pinguo.svideo.recorder.c.w.release(1);
                        us.pinguo.svideo.recorder.c.w.acquire(2);
                        if (!us.pinguo.svideo.recorder.c.u) {
                            us.pinguo.svideo.recorder.c.u = true;
                            us.pinguo.svideo.utils.b.i("MediaEncoder,stop", new Object[0]);
                            this.f12002l.stop();
                        }
                    } catch (Exception e4) {
                        Log.e("MediaEncoder", "failed stopping muxer", e4);
                    }
                } finally {
                    this.f12002l.release();
                    us.pinguo.svideo.recorder.c.w.release(2);
                }
            }
        } else if (!z) {
            us.pinguo.svideo.recorder.c.v.release(1);
        }
        this.f11999i = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(long j2) {
        this.q = j2;
    }

    public void g(us.pinguo.svideo.recorder.a aVar) {
        this.m = aVar;
    }

    protected void h() {
        b(null, 0, d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        synchronized (this.a) {
            this.b = true;
            this.f11994d = false;
            this.a.notifyAll();
        }
    }

    public void j() {
        synchronized (this.a) {
            if (this.b && !this.f11994d) {
                this.f11994d = true;
                this.a.notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(Exception exc) {
        us.pinguo.svideo.recorder.a aVar = this.m;
        if (aVar != null) {
            aVar.a(exc);
        }
        us.pinguo.svideo.utils.b.e(exc);
        e(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.a
            monitor-enter(r0)
            r1 = 0
            r6.f11994d = r1     // Catch: java.lang.Throwable -> L5a
            r6.c = r1     // Catch: java.lang.Throwable -> L5a
            java.lang.Object r2 = r6.a     // Catch: java.lang.Throwable -> L5a
            r2.notify()     // Catch: java.lang.Throwable -> L5a
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5a
        Le:
            r0 = 1
            java.lang.Object r2 = r6.a     // Catch: java.lang.Exception -> L4a
            monitor-enter(r2)     // Catch: java.lang.Exception -> L4a
            boolean r3 = r6.f11994d     // Catch: java.lang.Throwable -> L47
            int r4 = r6.c     // Catch: java.lang.Throwable -> L47
            if (r4 <= 0) goto L1a
            r5 = 1
            goto L1b
        L1a:
            r5 = 0
        L1b:
            if (r5 == 0) goto L21
            int r4 = r4 + (-1)
            r6.c = r4     // Catch: java.lang.Throwable -> L47
        L21:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L47
            if (r3 == 0) goto L31
            r6.a()     // Catch: java.lang.Exception -> L4a
            r6.h()     // Catch: java.lang.Exception -> L4a
            r6.a()     // Catch: java.lang.Exception -> L4a
            r6.e(r0)     // Catch: java.lang.Exception -> L4a
            goto L4e
        L31:
            if (r5 == 0) goto L37
            r6.a()     // Catch: java.lang.Exception -> L4a
            goto Le
        L37:
            java.lang.Object r2 = r6.a     // Catch: java.lang.Exception -> L4a
            monitor-enter(r2)     // Catch: java.lang.Exception -> L4a
            java.lang.Object r3 = r6.a     // Catch: java.lang.Throwable -> L41 java.lang.InterruptedException -> L43
            r3.wait()     // Catch: java.lang.Throwable -> L41 java.lang.InterruptedException -> L43
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L41
            goto Le
        L41:
            r3 = move-exception
            goto L45
        L43:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L41
            goto L4e
        L45:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L41
            throw r3     // Catch: java.lang.Exception -> L4a
        L47:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L47
            throw r3     // Catch: java.lang.Exception -> L4a
        L4a:
            r2 = move-exception
            r6.k(r2)
        L4e:
            java.lang.Object r2 = r6.a
            monitor-enter(r2)
            r6.f11994d = r0     // Catch: java.lang.Throwable -> L57
            r6.b = r1     // Catch: java.lang.Throwable -> L57
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L57
            return
        L57:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L57
            throw r0
        L5a:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5a
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.svideo.b.b.run():void");
    }
}
