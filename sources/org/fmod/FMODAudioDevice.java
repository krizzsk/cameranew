package org.fmod;

import android.media.AudioTrack;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class FMODAudioDevice implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    private static int f8952h = 0;

    /* renamed from: i  reason: collision with root package name */
    private static int f8953i = 1;

    /* renamed from: j  reason: collision with root package name */
    private static int f8954j = 2;

    /* renamed from: k  reason: collision with root package name */
    private static int f8955k = 3;
    private volatile Thread a = null;
    private volatile boolean b = false;
    private AudioTrack c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8956d = false;

    /* renamed from: e  reason: collision with root package name */
    private ByteBuffer f8957e = null;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f8958f = null;

    /* renamed from: g  reason: collision with root package name */
    private volatile a f8959g;

    private native int fmodGetInfo(int i2);

    private native int fmodProcess(ByteBuffer byteBuffer);

    private void releaseAudioTrack() {
        AudioTrack audioTrack = this.c;
        if (audioTrack != null) {
            if (audioTrack.getState() == 1) {
                this.c.stop();
            }
            this.c.release();
            this.c = null;
        }
        this.f8957e = null;
        this.f8958f = null;
        this.f8956d = false;
    }

    public synchronized void close() {
        stop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int fmodProcessMicData(ByteBuffer byteBuffer, int i2);

    public boolean isRunning() {
        return this.a != null && this.a.isAlive();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = 3;
        while (this.b) {
            if (!this.f8956d && i2 > 0) {
                releaseAudioTrack();
                int fmodGetInfo = fmodGetInfo(f8952h);
                int round = Math.round(AudioTrack.getMinBufferSize(fmodGetInfo, 3, 2) * 1.1f) & (-4);
                int fmodGetInfo2 = fmodGetInfo(f8953i);
                int fmodGetInfo3 = fmodGetInfo(f8954j) * fmodGetInfo2 * 4;
                AudioTrack audioTrack = new AudioTrack(3, fmodGetInfo, 3, 2, fmodGetInfo3 > round ? fmodGetInfo3 : round, 1);
                this.c = audioTrack;
                boolean z = audioTrack.getState() == 1;
                this.f8956d = z;
                if (z) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fmodGetInfo2 * 2 * 2);
                    this.f8957e = allocateDirect;
                    this.f8958f = new byte[allocateDirect.capacity()];
                    this.c.play();
                    i2 = 3;
                } else {
                    Log.e("FMOD", "AudioTrack failed to initialize (status " + this.c.getState() + ")");
                    releaseAudioTrack();
                    i2 += -1;
                }
            }
            if (this.f8956d) {
                if (fmodGetInfo(f8955k) == 1) {
                    fmodProcess(this.f8957e);
                    ByteBuffer byteBuffer = this.f8957e;
                    byteBuffer.get(this.f8958f, 0, byteBuffer.capacity());
                    this.c.write(this.f8958f, 0, this.f8957e.capacity());
                    this.f8957e.position(0);
                } else {
                    releaseAudioTrack();
                }
            }
        }
        releaseAudioTrack();
    }

    public synchronized void start() {
        if (this.a != null) {
            stop();
        }
        this.a = new Thread(this, "FMODAudioDevice");
        this.a.setPriority(10);
        this.b = true;
        this.a.start();
        if (this.f8959g != null) {
            this.f8959g.b();
        }
    }

    public synchronized int startAudioRecord(int i2, int i3, int i4) {
        if (this.f8959g == null) {
            this.f8959g = new a(this, i2, i3);
            this.f8959g.b();
        }
        return this.f8959g.a();
    }

    public synchronized void stop() {
        while (this.a != null) {
            this.b = false;
            try {
                this.a.join();
                this.a = null;
            } catch (InterruptedException unused) {
            }
        }
        if (this.f8959g != null) {
            this.f8959g.c();
        }
    }

    public synchronized void stopAudioRecord() {
        if (this.f8959g != null) {
            this.f8959g.c();
            this.f8959g = null;
        }
    }
}
