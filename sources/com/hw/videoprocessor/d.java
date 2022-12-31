package com.hw.videoprocessor;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import androidx.core.location.LocationRequestCompat;
import com.hw.videoprocessor.g.i;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* compiled from: VideoEncodeThread.java */
/* loaded from: classes2.dex */
public class d extends Thread implements b {
    private MediaCodec a;
    private MediaMuxer b;
    private AtomicBoolean c;

    /* renamed from: d  reason: collision with root package name */
    private CountDownLatch f5260d;

    /* renamed from: e  reason: collision with root package name */
    private Exception f5261e;

    /* renamed from: f  reason: collision with root package name */
    private int f5262f;

    /* renamed from: g  reason: collision with root package name */
    private int f5263g;

    /* renamed from: h  reason: collision with root package name */
    private int f5264h;

    /* renamed from: i  reason: collision with root package name */
    private int f5265i;

    /* renamed from: j  reason: collision with root package name */
    private int f5266j;

    /* renamed from: k  reason: collision with root package name */
    private MediaExtractor f5267k;

    /* renamed from: l  reason: collision with root package name */
    private int f5268l;
    private volatile CountDownLatch m;
    private volatile Surface n;
    private i o;

    public d(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i2, int i3, int i4, int i5, int i6, int i7, AtomicBoolean atomicBoolean, CountDownLatch countDownLatch) {
        super("VideoProcessEncodeThread");
        this.b = mediaMuxer;
        this.c = atomicBoolean;
        this.f5260d = countDownLatch;
        this.f5267k = mediaExtractor;
        this.f5262f = i2;
        this.f5264h = i4;
        this.f5263g = i3;
        this.f5265i = i5;
        this.f5268l = i7;
        this.f5266j = i6;
        this.m = new CountDownLatch(1);
    }

    private void c() throws IOException {
        boolean z;
        MediaFormat trackFormat = this.f5267k.getTrackFormat(this.f5268l);
        int i2 = this.f5266j;
        if (i2 <= 0) {
            i2 = trackFormat.containsKey("frame-rate") ? trackFormat.getInteger("frame-rate") : VideoProcessor.a;
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.f5263g, this.f5264h);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("frame-rate", i2);
        createVideoFormat.setInteger("i-frame-interval", this.f5265i);
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
        this.a = createEncoderByType;
        if (e.i(createEncoderByType, "video/avc", createVideoFormat, 8, 512)) {
            com.hw.videoprocessor.g.c.h("supportProfileHigh,enable ProfileHigh", new Object[0]);
        }
        int e2 = e.e(this.a, "video/avc");
        if (e2 > 0 && this.f5262f > e2) {
            com.hw.videoprocessor.g.c.c(this.f5262f + " bitrate too large,set to:" + e2, new Object[0]);
            this.f5262f = (int) (((float) e2) * 0.8f);
        }
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, this.f5262f);
        int i3 = 1;
        this.a.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.n = this.a.createInputSurface();
        this.a.start();
        this.m.countDown();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int i4 = (int) (1000000.0f / i2);
        int i5 = -5;
        boolean z2 = false;
        int i6 = 0;
        int i7 = -5;
        boolean z3 = false;
        long j2 = -1;
        while (true) {
            if (this.c.get() && !z2) {
                this.a.signalEndOfInputStream();
                z2 = true;
            }
            int dequeueOutputBuffer = this.a.dequeueOutputBuffer(bufferInfo, 2500L);
            com.hw.videoprocessor.g.c.h("encode outputBufferIndex = " + dequeueOutputBuffer, new Object[0]);
            if (z2 && dequeueOutputBuffer == -1) {
                i6 += i3;
                if (i6 > 10) {
                    com.hw.videoprocessor.g.c.c("INFO_TRY_AGAIN_LATER 10 times,force End!", new Object[0]);
                    return;
                }
            } else {
                i6 = 0;
            }
            if (dequeueOutputBuffer != -1) {
                if (dequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.a.getOutputFormat();
                    if (i7 == i5) {
                        i7 = this.b.addTrack(outputFormat);
                        this.b.start();
                        this.f5260d.countDown();
                    }
                    com.hw.videoprocessor.g.c.h("encode newFormat = " + outputFormat, new Object[0]);
                } else if (dequeueOutputBuffer < 0) {
                    com.hw.videoprocessor.g.c.c("unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer, new Object[0]);
                } else {
                    ByteBuffer outputBuffer = this.a.getOutputBuffer(dequeueOutputBuffer);
                    z = z2;
                    if (bufferInfo.flags == 4 && bufferInfo.presentationTimeUs < 0) {
                        bufferInfo.presentationTimeUs = 0L;
                    }
                    if (!z3 && j2 != -1 && bufferInfo.presentationTimeUs < (i4 / 2) + j2) {
                        com.hw.videoprocessor.g.c.c("video 时间戳错误，lastVideoFrameTimeUs:" + j2 + " info.presentationTimeUs:" + bufferInfo.presentationTimeUs + " VIDEO_FRAME_TIME_US:" + i4, new Object[0]);
                        z3 = true;
                    }
                    if (z3) {
                        bufferInfo.presentationTimeUs = i4 + j2;
                        com.hw.videoprocessor.g.c.c("video 时间戳错误，使用修正的时间戳:" + bufferInfo.presentationTimeUs, new Object[0]);
                        z3 = false;
                    }
                    if (bufferInfo.flags != 2) {
                        j2 = bufferInfo.presentationTimeUs;
                    }
                    com.hw.videoprocessor.g.c.h("writeSampleData,size:" + bufferInfo.size + " time:" + (bufferInfo.presentationTimeUs / 1000), new Object[0]);
                    this.b.writeSampleData(i7, outputBuffer, bufferInfo);
                    e(bufferInfo);
                    this.a.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if (bufferInfo.flags == 4) {
                        com.hw.videoprocessor.g.c.h("encoderDone", new Object[0]);
                        return;
                    }
                    z2 = z;
                    i3 = 1;
                    i5 = -5;
                }
                z = z2;
                z2 = z;
                i3 = 1;
                i5 = -5;
            }
        }
    }

    private void e(MediaCodec.BufferInfo bufferInfo) {
        i iVar = this.o;
        if (iVar == null) {
            return;
        }
        iVar.b((bufferInfo.flags & 4) > 0 ? LocationRequestCompat.PASSIVE_INTERVAL : bufferInfo.presentationTimeUs);
    }

    @Override // com.hw.videoprocessor.b
    public CountDownLatch a() {
        return this.m;
    }

    @Override // com.hw.videoprocessor.b
    public Surface b() {
        return this.n;
    }

    public Exception d() {
        return this.f5261e;
    }

    public void f(i iVar) {
        this.o = iVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
        if (r1 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0018, code lost:
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0019, code lost:
        r3.f5261e = r1;
        com.hw.videoprocessor.g.c.d(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
        if (r1 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r3 = this;
            super.run()
            r3.c()     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L21
            android.media.MediaCodec r0 = r3.a     // Catch: java.lang.Exception -> L13
            if (r0 == 0) goto L3c
            r0.stop()     // Catch: java.lang.Exception -> L13
            android.media.MediaCodec r0 = r3.a     // Catch: java.lang.Exception -> L13
            r0.release()     // Catch: java.lang.Exception -> L13
            goto L3c
        L13:
            r0 = move-exception
            java.lang.Exception r1 = r3.f5261e
            if (r1 != 0) goto L19
        L18:
            r1 = r0
        L19:
            r3.f5261e = r1
            com.hw.videoprocessor.g.c.d(r0)
            goto L3c
        L1f:
            r0 = move-exception
            goto L3d
        L21:
            r0 = move-exception
            com.hw.videoprocessor.g.c.d(r0)     // Catch: java.lang.Throwable -> L1f
            r3.f5261e = r0     // Catch: java.lang.Throwable -> L1f
            android.media.MediaCodec r0 = r3.a     // Catch: java.lang.Exception -> L36
            if (r0 == 0) goto L3c
            android.media.MediaCodec r0 = r3.a     // Catch: java.lang.Exception -> L36
            r0.stop()     // Catch: java.lang.Exception -> L36
            android.media.MediaCodec r0 = r3.a     // Catch: java.lang.Exception -> L36
            r0.release()     // Catch: java.lang.Exception -> L36
            goto L3c
        L36:
            r0 = move-exception
            java.lang.Exception r1 = r3.f5261e
            if (r1 != 0) goto L19
            goto L18
        L3c:
            return
        L3d:
            android.media.MediaCodec r1 = r3.a     // Catch: java.lang.Exception -> L4a
            if (r1 == 0) goto L55
            r1.stop()     // Catch: java.lang.Exception -> L4a
            android.media.MediaCodec r1 = r3.a     // Catch: java.lang.Exception -> L4a
            r1.release()     // Catch: java.lang.Exception -> L4a
            goto L55
        L4a:
            r1 = move-exception
            java.lang.Exception r2 = r3.f5261e
            if (r2 != 0) goto L50
            r2 = r1
        L50:
            r3.f5261e = r2
            com.hw.videoprocessor.g.c.d(r1)
        L55:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.d.run():void");
    }
}
