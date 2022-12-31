package com.hw.videoprocessor;

import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import androidx.annotation.Nullable;
import com.hw.videoprocessor.g.i;
import com.hw.videoprocessor.g.j;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;
/* compiled from: AudioProcessThread.java */
/* loaded from: classes2.dex */
public class a extends Thread implements j {
    private String a;
    private Integer b;
    private Integer c;

    /* renamed from: d  reason: collision with root package name */
    private Float f5243d;

    /* renamed from: e  reason: collision with root package name */
    private Context f5244e;

    /* renamed from: f  reason: collision with root package name */
    private Exception f5245f;

    /* renamed from: g  reason: collision with root package name */
    private MediaMuxer f5246g;

    /* renamed from: h  reason: collision with root package name */
    private int f5247h;

    /* renamed from: i  reason: collision with root package name */
    private MediaExtractor f5248i;

    /* renamed from: j  reason: collision with root package name */
    private CountDownLatch f5249j;

    /* renamed from: k  reason: collision with root package name */
    private i f5250k;

    public a(Context context, String str, MediaMuxer mediaMuxer, @Nullable Integer num, @Nullable Integer num2, @Nullable Float f2, int i2, CountDownLatch countDownLatch) {
        super("VideoProcessDecodeThread");
        this.a = str;
        this.b = num;
        this.c = num2;
        this.f5243d = f2;
        this.f5246g = mediaMuxer;
        this.f5244e = context;
        this.f5247h = i2;
        this.f5248i = new MediaExtractor();
        this.f5249j = countDownLatch;
    }

    private void a() throws Exception {
        this.f5248i.setDataSource(this.a);
        int h2 = e.h(this.f5248i, true);
        if (h2 >= 0) {
            this.f5248i.selectTrack(h2);
            MediaFormat trackFormat = this.f5248i.getTrackFormat(h2);
            String string = trackFormat.containsKey(IMediaFormat.KEY_MIME) ? trackFormat.getString(IMediaFormat.KEY_MIME) : "audio/mp4a-latm";
            Integer num = this.b;
            Integer valueOf = num == null ? null : Integer.valueOf(num.intValue() * 1000);
            Integer num2 = this.c;
            Integer valueOf2 = num2 != null ? Integer.valueOf(num2.intValue() * 1000) : null;
            if (this.f5249j.await(3L, TimeUnit.SECONDS)) {
                if (this.f5243d == null && string.equals("audio/mp4a-latm")) {
                    com.hw.videoprocessor.g.b.p(this.f5248i, this.f5246g, this.f5247h, valueOf, valueOf2, this);
                } else {
                    Context context = this.f5244e;
                    MediaExtractor mediaExtractor = this.f5248i;
                    MediaMuxer mediaMuxer = this.f5246g;
                    int i2 = this.f5247h;
                    Float f2 = this.f5243d;
                    com.hw.videoprocessor.g.b.q(context, mediaExtractor, mediaMuxer, i2, valueOf, valueOf2, Float.valueOf(f2 == null ? 1.0f : f2.floatValue()), this);
                }
            } else {
                throw new TimeoutException("wait muxerStartLatch timeout!");
            }
        }
        i iVar = this.f5250k;
        if (iVar != null) {
            iVar.a(1.0f);
        }
    }

    public Exception b() {
        return this.f5245f;
    }

    public void c(i iVar) {
        this.f5250k = iVar;
    }

    @Override // com.hw.videoprocessor.g.j
    public void onProgress(float f2) {
        i iVar = this.f5250k;
        if (iVar != null) {
            iVar.a(f2);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        try {
            try {
                a();
            } catch (Exception e2) {
                this.f5245f = e2;
                com.hw.videoprocessor.g.c.d(e2);
            }
        } finally {
            this.f5248i.release();
        }
    }
}
