package com.hw.videoprocessor;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: VideoDecodeThread.java */
/* loaded from: classes2.dex */
public class c extends Thread {
    private MediaExtractor a;
    private MediaCodec b;
    private Integer c;

    /* renamed from: d  reason: collision with root package name */
    private Integer f5251d;

    /* renamed from: e  reason: collision with root package name */
    private Float f5252e;

    /* renamed from: f  reason: collision with root package name */
    private AtomicBoolean f5253f;

    /* renamed from: g  reason: collision with root package name */
    private Exception f5254g;

    /* renamed from: h  reason: collision with root package name */
    private int f5255h;

    /* renamed from: i  reason: collision with root package name */
    private b f5256i;

    /* renamed from: j  reason: collision with root package name */
    private com.hw.videoprocessor.g.d f5257j;

    /* renamed from: k  reason: collision with root package name */
    private com.hw.videoprocessor.g.e f5258k;

    /* renamed from: l  reason: collision with root package name */
    private Integer f5259l;
    private Integer m;
    private boolean n;

    public c(b bVar, MediaExtractor mediaExtractor, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Float f2, boolean z, int i2, AtomicBoolean atomicBoolean) {
        super("VideoProcessDecodeThread");
        this.a = mediaExtractor;
        this.c = num;
        this.f5251d = num2;
        this.f5252e = f2;
        this.f5255h = i2;
        this.f5253f = atomicBoolean;
        this.f5256i = bVar;
        this.f5259l = num4;
        this.m = num3;
        this.n = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0275 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x028d  */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 857
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.c.a():void");
    }

    public Exception b() {
        return this.f5254g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0024, code lost:
        if (r1 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0026, code lost:
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
        r3.f5254g = r1;
        com.hw.videoprocessor.g.c.d(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0055, code lost:
        if (r1 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
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
            r3.a()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            com.hw.videoprocessor.g.d r0 = r3.f5257j
            if (r0 == 0) goto Ld
            r0.d()
        Ld:
            com.hw.videoprocessor.g.e r0 = r3.f5258k
            if (r0 == 0) goto L14
            r0.d()
        L14:
            android.media.MediaCodec r0 = r3.b     // Catch: java.lang.Exception -> L21
            if (r0 == 0) goto L58
            r0.stop()     // Catch: java.lang.Exception -> L21
            android.media.MediaCodec r0 = r3.b     // Catch: java.lang.Exception -> L21
            r0.release()     // Catch: java.lang.Exception -> L21
            goto L58
        L21:
            r0 = move-exception
            java.lang.Exception r1 = r3.f5254g
            if (r1 != 0) goto L27
        L26:
            r1 = r0
        L27:
            r3.f5254g = r1
            com.hw.videoprocessor.g.c.d(r0)
            goto L58
        L2d:
            r0 = move-exception
            goto L59
        L2f:
            r0 = move-exception
            r3.f5254g = r0     // Catch: java.lang.Throwable -> L2d
            com.hw.videoprocessor.g.c.d(r0)     // Catch: java.lang.Throwable -> L2d
            com.hw.videoprocessor.g.d r0 = r3.f5257j
            if (r0 == 0) goto L3e
            com.hw.videoprocessor.g.d r0 = r3.f5257j
            r0.d()
        L3e:
            com.hw.videoprocessor.g.e r0 = r3.f5258k
            if (r0 == 0) goto L45
            r0.d()
        L45:
            android.media.MediaCodec r0 = r3.b     // Catch: java.lang.Exception -> L52
            if (r0 == 0) goto L58
            r0.stop()     // Catch: java.lang.Exception -> L52
            android.media.MediaCodec r0 = r3.b     // Catch: java.lang.Exception -> L52
            r0.release()     // Catch: java.lang.Exception -> L52
            goto L58
        L52:
            r0 = move-exception
            java.lang.Exception r1 = r3.f5254g
            if (r1 != 0) goto L27
            goto L26
        L58:
            return
        L59:
            com.hw.videoprocessor.g.d r1 = r3.f5257j
            if (r1 == 0) goto L60
            r1.d()
        L60:
            com.hw.videoprocessor.g.e r1 = r3.f5258k
            if (r1 == 0) goto L67
            r1.d()
        L67:
            android.media.MediaCodec r1 = r3.b     // Catch: java.lang.Exception -> L74
            if (r1 == 0) goto L7f
            r1.stop()     // Catch: java.lang.Exception -> L74
            android.media.MediaCodec r1 = r3.b     // Catch: java.lang.Exception -> L74
            r1.release()     // Catch: java.lang.Exception -> L74
            goto L7f
        L74:
            r1 = move-exception
            java.lang.Exception r2 = r3.f5254g
            if (r2 != 0) goto L7a
            r2 = r1
        L7a:
            r3.f5254g = r2
            com.hw.videoprocessor.g.c.d(r1)
        L7f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hw.videoprocessor.c.run():void");
    }
}
