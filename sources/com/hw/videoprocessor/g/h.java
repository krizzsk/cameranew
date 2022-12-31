package com.hw.videoprocessor.g;
/* compiled from: VideoMultiStepProgress.java */
/* loaded from: classes2.dex */
public class h implements j {
    private float[] a;
    private int b;
    private j c;

    /* renamed from: d  reason: collision with root package name */
    private float f5296d;

    public h(float[] fArr, j jVar) {
        this.a = fArr;
        this.c = jVar;
    }

    public void a(int i2) {
        this.b = i2;
        this.f5296d = 0.0f;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f5296d += this.a[i3];
        }
    }

    public void b(j jVar) {
        this.c = jVar;
    }

    @Override // com.hw.videoprocessor.g.j
    public void onProgress(float f2) {
        j jVar = this.c;
        if (jVar != null) {
            jVar.onProgress((f2 * this.a[this.b]) + this.f5296d);
        }
    }
}
