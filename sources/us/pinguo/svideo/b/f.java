package us.pinguo.svideo.b;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.nio.ByteBuffer;
/* compiled from: VideoSurfaceEncoderAsyncApi21.java */
@TargetApi(21)
/* loaded from: classes6.dex */
public class f extends d {
    private MediaCodec.Callback p;

    /* compiled from: VideoSurfaceEncoderAsyncApi21.java */
    /* loaded from: classes6.dex */
    class a extends MediaCodec.Callback {
        a() {
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            us.pinguo.svideo.utils.b.e(codecException);
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
            us.pinguo.svideo.utils.b.i("onInputBufferAvailable", new Object[0]);
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(MediaCodec mediaCodec, int i2, MediaCodec.BufferInfo bufferInfo) {
            f fVar;
            if (bufferInfo.flags == 2) {
                us.pinguo.svideo.utils.b.i("BUFFER_FLAG_CODEC_CONFIG.return.", new Object[0]);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ByteBuffer outputBuffer = f.this.c.getOutputBuffer(i2);
            f fVar2 = f.this;
            if (!fVar2.f12006g) {
                MediaFormat outputFormat = fVar2.c.getOutputFormat();
                f fVar3 = f.this;
                fVar3.f12005f = fVar3.f12003d.addTrack(outputFormat);
                us.pinguo.svideo.recorder.c.v.release(1);
                try {
                    try {
                        us.pinguo.svideo.recorder.c.v.acquire(2);
                        if (!us.pinguo.svideo.recorder.c.t && !us.pinguo.svideo.recorder.c.t) {
                            us.pinguo.svideo.recorder.c.t = true;
                            f.this.f12003d.start();
                        }
                    } catch (InterruptedException e2) {
                        us.pinguo.svideo.utils.d.a().a(e2);
                    }
                } finally {
                    us.pinguo.svideo.recorder.c.v.release(2);
                    f.this.f12006g = true;
                }
            }
            us.pinguo.svideo.utils.b.i("info,flags:" + bufferInfo.flags + " offset" + bufferInfo.offset + " presentationTimeUs：" + bufferInfo.presentationTimeUs + " size:" + bufferInfo.size, new Object[0]);
            f fVar4 = f.this;
            MediaCodec.BufferInfo bufferInfo2 = fVar4.f12004e;
            if (bufferInfo2.flags == 4 && bufferInfo2.presentationTimeUs < 0) {
                bufferInfo2.presentationTimeUs = 0L;
            }
            fVar4.f12003d.writeSampleData(fVar4.f12005f, outputBuffer, bufferInfo);
            f.this.f12007h++;
            us.pinguo.svideo.utils.b.c("sent " + bufferInfo.size + " bytes to muxer", new Object[0]);
            f.this.c.releaseOutputBuffer(i2, false);
            c cVar = f.this.f12009j;
            if (cVar != null) {
                cVar.a((int) ((1000.0f / fVar.f12008i) * fVar.f12007h));
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            us.pinguo.svideo.utils.b.i("耗时:" + (currentTimeMillis2 - currentTimeMillis) + "ms", new Object[0]);
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            MediaFormat outputFormat = f.this.c.getOutputFormat();
            us.pinguo.svideo.utils.b.i("INFO_OUTPUT_FORMAT_CHANGED:" + outputFormat, new Object[0]);
        }
    }

    public f(int i2, int i3, int i4, int i5, int i6, MediaMuxer mediaMuxer) {
        super(i2, i3, i4, i5, i6, mediaMuxer);
        this.p = new a();
    }

    @Override // us.pinguo.svideo.b.d
    protected void a() {
        this.c.setCallback(this.p);
    }

    @Override // us.pinguo.svideo.b.d
    public void c(boolean z, long j2) {
        if (z) {
            us.pinguo.svideo.utils.b.c("sending EOS to encoder", new Object[0]);
            this.c.signalEndOfInputStream();
        }
    }
}
