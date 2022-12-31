package com.hw.photomovie.segment;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
/* compiled from: MoveTransitionSegment.java */
/* loaded from: classes2.dex */
public class d extends TransitionSegment<b, b> {
    public static int s = 0;
    public static int t = 1;
    private int q;
    private float o = 1.0f;
    private float p = 0.7f;
    private TimeInterpolator r = new DecelerateInterpolator(1.0f);

    public d(int i2, int i3) {
        this.q = i2;
        t(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hw.photomovie.segment.e
    public void n() {
        ((b) this.n).n();
    }

    @Override // com.hw.photomovie.segment.TransitionSegment, com.hw.photomovie.segment.e
    public void o() {
        super.o();
    }

    @Override // com.hw.photomovie.segment.f, com.hw.photomovie.segment.e
    public void w(int i2, int i3, int i4, int i5) {
        super.w(i2, i3, i4, i5);
    }

    @Override // com.hw.photomovie.segment.e
    /* renamed from: z */
    public void h(com.hw.photomovie.d.f fVar, float f2) {
        float interpolation = this.r.getInterpolation(f2);
        fVar.g(0.0f, 0.0f, this.f5221f.width(), this.f5221f.height(), ((b) this.m).C());
        fVar.d();
        float f3 = 1.0f - interpolation;
        fVar.setAlpha(f3);
        float f4 = this.o;
        ((b) this.m).A(fVar, f4 + ((this.p - f4) * interpolation));
        fVar.b();
        if (this.q == t) {
            fVar.d();
            fVar.a(0.0f, f3 * this.f5221f.height());
            ((b) this.n).A(fVar, 1.0f);
            fVar.b();
            return;
        }
        fVar.d();
        fVar.a(f3 * this.f5221f.width(), 0.0f);
        ((b) this.n).A(fVar, 1.0f);
        fVar.b();
    }
}
