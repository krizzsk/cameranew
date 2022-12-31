package us.pinguo.svideo.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.tapjoy.TJAdUnitConstants;
import java.io.IOException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* compiled from: VideoSurfaceEncoder.java */
@TargetApi(18)
/* loaded from: classes6.dex */
public class d {
    protected int a;
    protected int b;
    protected MediaCodec c;

    /* renamed from: d  reason: collision with root package name */
    protected MediaMuxer f12003d;

    /* renamed from: f  reason: collision with root package name */
    protected int f12005f;

    /* renamed from: i  reason: collision with root package name */
    protected int f12008i;

    /* renamed from: j  reason: collision with root package name */
    protected c f12009j;

    /* renamed from: k  reason: collision with root package name */
    protected int f12010k;

    /* renamed from: l  reason: collision with root package name */
    protected int f12011l;
    protected MediaFormat m;
    protected boolean n;
    private Surface o;

    /* renamed from: e  reason: collision with root package name */
    protected MediaCodec.BufferInfo f12004e = new MediaCodec.BufferInfo();

    /* renamed from: g  reason: collision with root package name */
    protected boolean f12006g = false;

    /* renamed from: h  reason: collision with root package name */
    protected int f12007h = 0;

    @SuppressLint({"NewApi"})
    public d(int i2, int i3, int i4, int i5, int i6, MediaMuxer mediaMuxer) {
        this.f12005f = -1;
        this.a = i2;
        this.b = i3;
        this.f12010k = i4;
        this.f12011l = i6;
        this.f12008i = i5;
        byte[] bArr = new byte[((i2 * i3) * 3) / 2];
        this.f12003d = mediaMuxer;
        this.f12005f = -1;
    }

    protected void a() {
    }

    @SuppressLint({"NewApi"})
    public void b() {
        us.pinguo.svideo.utils.b.i(TJAdUnitConstants.String.CLOSE, new Object[0]);
        try {
            MediaCodec mediaCodec = this.c;
            if (mediaCodec != null && this.n) {
                this.n = false;
                mediaCodec.stop();
                this.c.release();
            }
        } catch (Exception e2) {
            us.pinguo.svideo.utils.d.a().a(e2);
        }
        if (this.f12003d != null) {
            try {
                try {
                    us.pinguo.svideo.recorder.c.w.release(1);
                    us.pinguo.svideo.recorder.c.w.acquire(2);
                    if (!us.pinguo.svideo.recorder.c.u) {
                        us.pinguo.svideo.recorder.c.u = true;
                        us.pinguo.svideo.utils.b.j("VideoMediaEncoderThread", "mMuxer.stop:", new Object[0]);
                        this.f12003d.stop();
                    }
                } catch (Exception e3) {
                    us.pinguo.svideo.utils.d.a().a(e3);
                }
                this.f12003d.release();
                us.pinguo.svideo.recorder.c.w.release(2);
                this.f12003d = null;
            } catch (Throwable th) {
                this.f12003d.release();
                us.pinguo.svideo.recorder.c.w.release(2);
                throw th;
            }
        }
    }

    public void c(boolean z, long j2) {
        us.pinguo.svideo.utils.b.c("drainEncoder(" + z + ")", new Object[0]);
        if (z) {
            us.pinguo.svideo.utils.b.c("sending EOS to encoder", new Object[0]);
            this.c.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.c.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.c.dequeueOutputBuffer(this.f12004e, 10000L);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
                us.pinguo.svideo.utils.b.c("no output available, spinning to await EOS", new Object[0]);
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.c.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                this.m = this.c.getOutputFormat();
                us.pinguo.svideo.utils.b.c("encoder output format changed: " + this.m, new Object[0]);
            } else if (dequeueOutputBuffer < 0) {
                us.pinguo.svideo.utils.b.m("unexpected result from encoder.dequeueOutputBuffer: " + dequeueOutputBuffer, new Object[0]);
            } else {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer != null) {
                    if ((this.f12004e.flags & 2) != 0) {
                        us.pinguo.svideo.utils.b.c("ignoring BUFFER_FLAG_CODEC_CONFIG", new Object[0]);
                        this.f12004e.size = 0;
                    }
                    if (this.f12004e.size != 0) {
                        if (!this.f12006g) {
                            this.f12005f = this.f12003d.addTrack(this.c.getOutputFormat());
                            us.pinguo.svideo.recorder.c.v.release(1);
                            try {
                                try {
                                    us.pinguo.svideo.recorder.c.v.acquire(2);
                                    if (!us.pinguo.svideo.recorder.c.t && !us.pinguo.svideo.recorder.c.t) {
                                        us.pinguo.svideo.recorder.c.t = true;
                                        this.f12003d.start();
                                    }
                                } catch (InterruptedException e2) {
                                    us.pinguo.svideo.utils.d.a().a(e2);
                                }
                                us.pinguo.svideo.recorder.c.v.release(2);
                                this.f12006g = true;
                            } catch (Throwable th) {
                                us.pinguo.svideo.recorder.c.v.release(2);
                                throw th;
                            }
                        }
                        byteBuffer.position(this.f12004e.offset);
                        MediaCodec.BufferInfo bufferInfo = this.f12004e;
                        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                        MediaCodec.BufferInfo bufferInfo2 = this.f12004e;
                        if (bufferInfo2.flags == 4 && bufferInfo2.presentationTimeUs < 0) {
                            bufferInfo2.presentationTimeUs = 0L;
                        }
                        this.f12003d.writeSampleData(this.f12005f, byteBuffer, bufferInfo2);
                        this.f12007h++;
                        us.pinguo.svideo.utils.b.c("sent " + this.f12004e.size + " bytes to muxer, ts=" + this.f12004e.presentationTimeUs, new Object[0]);
                    }
                    this.c.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.f12004e.flags & 4) != 0) {
                        if (!z) {
                            us.pinguo.svideo.utils.b.m("reached end of stream unexpectedly", new Object[0]);
                            return;
                        } else {
                            us.pinguo.svideo.utils.b.c("end of stream reached", new Object[0]);
                            return;
                        }
                    }
                } else {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
            }
        }
    }

    public Surface d() {
        return this.o;
    }

    public int e() {
        return this.f12007h;
    }

    public void f() {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.a, this.b);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, this.f12010k);
        createVideoFormat.setInteger("frame-rate", this.f12008i);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("i-frame-interval", this.f12011l);
        us.pinguo.svideo.utils.b.c("format: " + createVideoFormat, new Object[0]);
        try {
            try {
                this.c = MediaCodec.createEncoderByType("video/avc");
                a();
                this.c.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.o = this.c.createInputSurface();
                this.c.start();
            } catch (IOException e2) {
                us.pinguo.svideo.utils.d.a().a(e2);
            }
        } finally {
            this.n = true;
        }
    }
}
