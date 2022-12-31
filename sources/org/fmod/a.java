package org.fmod;

import android.media.AudioRecord;
import android.util.Log;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class a implements Runnable {
    private final FMODAudioDevice a;
    private final ByteBuffer b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8960d;

    /* renamed from: e  reason: collision with root package name */
    private final int f8961e = 2;

    /* renamed from: f  reason: collision with root package name */
    private volatile Thread f8962f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f8963g;

    /* renamed from: h  reason: collision with root package name */
    private AudioRecord f8964h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f8965i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FMODAudioDevice fMODAudioDevice, int i2, int i3) {
        this.a = fMODAudioDevice;
        this.c = i2;
        this.f8960d = i3;
        this.b = ByteBuffer.allocateDirect(AudioRecord.getMinBufferSize(i2, i3, 2));
    }

    private void d() {
        AudioRecord audioRecord = this.f8964h;
        if (audioRecord != null) {
            if (audioRecord.getState() == 1) {
                this.f8964h.stop();
            }
            this.f8964h.release();
            this.f8964h = null;
        }
        this.b.position(0);
        this.f8965i = false;
    }

    public final int a() {
        return this.b.capacity();
    }

    public final void b() {
        if (this.f8962f != null) {
            c();
        }
        this.f8963g = true;
        this.f8962f = new Thread(this);
        this.f8962f.start();
    }

    public final void c() {
        while (this.f8962f != null) {
            this.f8963g = false;
            try {
                this.f8962f.join();
                this.f8962f = null;
            } catch (InterruptedException unused) {
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = 3;
        while (this.f8963g) {
            if (!this.f8965i && i2 > 0) {
                d();
                AudioRecord audioRecord = new AudioRecord(1, this.c, this.f8960d, this.f8961e, this.b.capacity());
                this.f8964h = audioRecord;
                boolean z = audioRecord.getState() == 1;
                this.f8965i = z;
                if (z) {
                    this.b.position(0);
                    this.f8964h.startRecording();
                    i2 = 3;
                } else {
                    Log.e("FMOD", "AudioRecord failed to initialize (status " + this.f8964h.getState() + ")");
                    i2 += -1;
                    d();
                }
            }
            if (this.f8965i && this.f8964h.getRecordingState() == 3) {
                AudioRecord audioRecord2 = this.f8964h;
                ByteBuffer byteBuffer = this.b;
                this.a.fmodProcessMicData(this.b, audioRecord2.read(byteBuffer, byteBuffer.capacity()));
                this.b.position(0);
            }
        }
        d();
    }
}
