package us.pinguo.svideo.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Process;
import android.util.Log;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.svideo.b.b;
import us.pinguo.svideo.recorder.RecordFailException;
/* compiled from: MediaAudioEncoder.java */
@TargetApi(18)
/* loaded from: classes6.dex */
public class a extends b {
    private static final int[] u = {5, 1, 0, 7, 6};
    private boolean s;
    private C0450a t;

    /* compiled from: MediaAudioEncoder.java */
    /* renamed from: us.pinguo.svideo.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0450a extends us.pinguo.svideo.utils.c {
        public C0450a(CountDownLatch countDownLatch) {
            super(countDownLatch);
        }

        @Override // us.pinguo.svideo.utils.c, java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            try {
                int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
                int i2 = 25600 < minBufferSize ? ((minBufferSize / 1024) + 1) * 1024 * 2 : 25600;
                AudioRecord audioRecord = null;
                int[] iArr = a.u;
                if (iArr.length > 0) {
                    try {
                        audioRecord = new AudioRecord(iArr[0], 44100, 16, 2, i2);
                        if (audioRecord.getState() != 1) {
                            throw new RuntimeException("failed to initialize AudioRecord,maybe no permission");
                        }
                    } catch (Exception e2) {
                        a.this.k(e2);
                        this.a.countDown();
                        return;
                    }
                }
                if (audioRecord != null) {
                    if (a.this.b) {
                        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1024);
                        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(1024);
                        audioRecord.startRecording();
                        a.this.p = true;
                        ByteBuffer.allocateDirect(1024);
                        boolean z = false;
                        while (true) {
                            if (a.this.b && !a.this.f11994d && !a.this.f11995e) {
                                allocateDirect.clear();
                                int read = audioRecord.read(allocateDirect, 1024);
                                long d2 = a.this.d();
                                a aVar = a.this;
                                if (aVar.p) {
                                    aVar.p = false;
                                    aVar.f(System.nanoTime() / 1000);
                                    d2 = 0;
                                }
                                if (!z) {
                                    try {
                                        a.this.n();
                                        z = true;
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                        a.this.k(e3);
                                        audioRecord.stop();
                                        audioRecord.release();
                                        return;
                                    }
                                }
                                if (read > 0) {
                                    allocateDirect.position(read);
                                    allocateDirect.flip();
                                    if (a.this.s) {
                                        allocateDirect2.position(read);
                                        allocateDirect2.flip();
                                        a.this.b(allocateDirect2, read, d2);
                                    } else {
                                        byte[] bArr = new byte[read];
                                        allocateDirect.get(bArr, 0, read);
                                        us.pinguo.svideo.utils.e.c(bArr);
                                        a.this.b(ByteBuffer.wrap(bArr), read, d2);
                                    }
                                    a.this.c();
                                } else {
                                    us.pinguo.svideo.recorder.c.v.release();
                                    a aVar2 = a.this;
                                    aVar2.k(new RecordFailException("AudioRecord.read return err:" + read + " 停止录音"));
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        a.this.c();
                        audioRecord.stop();
                    }
                    audioRecord.release();
                } else {
                    us.pinguo.svideo.utils.b.f("MediaAudioEncoder", "failed to initialize AudioRecord", new Object[0]);
                }
            } catch (Exception e4) {
                us.pinguo.svideo.utils.b.f("MediaAudioEncoder", "AudioThread#run", e4);
                a.this.k(e4);
            }
            this.a.countDown();
        }
    }

    public a(MediaMuxer mediaMuxer, b.a aVar, CountDownLatch countDownLatch) {
        super(mediaMuxer, aVar, countDownLatch);
        this.s = false;
        this.t = null;
    }

    @Override // us.pinguo.svideo.b.b
    protected void e(boolean z) {
        this.t = null;
        super.e(z);
    }

    @Override // us.pinguo.svideo.b.b
    public void i() {
        super.i();
        if (this.t == null) {
            C0450a c0450a = new C0450a(this.o);
            this.t = c0450a;
            c0450a.start();
        }
    }

    @TargetApi(16)
    public void n() throws IOException {
        this.f11997g = -1;
        this.f11995e = false;
        this.f11996f = false;
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", 44100, 1);
        createAudioFormat.setInteger("aac-profile", 2);
        createAudioFormat.setInteger("channel-mask", 16);
        createAudioFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, 64000);
        createAudioFormat.setInteger("channel-count", 1);
        try {
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType("audio/mp4a-latm");
            this.f11998h = createEncoderByType;
            createEncoderByType.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 1);
            this.f11998h.start();
        } catch (Exception e2) {
            k(e2);
        }
        b.a aVar = this.f12000j;
        if (aVar != null) {
            try {
                aVar.a(this);
            } catch (Exception e3) {
                Log.e("MediaAudioEncoder", "prepare:", e3);
            }
        }
    }

    public void o(boolean z) {
        this.s = z;
    }
}
