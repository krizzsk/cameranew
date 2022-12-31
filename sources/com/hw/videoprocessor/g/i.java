package com.hw.videoprocessor.g;
/* compiled from: VideoProgressAve.java */
/* loaded from: classes2.dex */
public class i {
    private j a;
    private float b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private int f5297d;

    /* renamed from: e  reason: collision with root package name */
    private int f5298e;

    /* renamed from: f  reason: collision with root package name */
    private Float f5299f;

    public i(j jVar) {
        this.a = jVar;
    }

    public void a(float f2) {
        this.c = f2;
        j jVar = this.a;
        if (jVar != null) {
            jVar.onProgress((this.b + f2) / 2.0f);
        }
        c.h("mAudioProgress:" + this.c, new Object[0]);
    }

    public void b(long j2) {
        int i2;
        if (this.a == null) {
            return;
        }
        Float f2 = this.f5299f;
        if (f2 != null) {
            j2 = ((float) j2) * f2.floatValue();
        }
        float f3 = ((((float) j2) / 1000.0f) - this.f5297d) / (this.f5298e - i2);
        this.b = f3;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        this.b = f3;
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        this.b = f3;
        this.a.onProgress((f3 + this.c) / 2.0f);
        c.h("mEncodeProgress:" + this.b, new Object[0]);
    }

    public void c(int i2) {
        this.f5298e = i2;
    }

    public void d(Float f2) {
        this.f5299f = f2;
    }

    public void e(int i2) {
        this.f5297d = i2;
    }
}
