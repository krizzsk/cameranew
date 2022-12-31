package com.airbnb.lottie.t.c;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
/* compiled from: PathKeyframeAnimation.java */
/* loaded from: classes.dex */
public class i extends f<PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f545i;

    /* renamed from: j  reason: collision with root package name */
    private final float[] f546j;

    /* renamed from: k  reason: collision with root package name */
    private h f547k;

    /* renamed from: l  reason: collision with root package name */
    private PathMeasure f548l;

    public i(List<? extends com.airbnb.lottie.x.a<PointF>> list) {
        super(list);
        this.f545i = new PointF();
        this.f546j = new float[2];
        this.f548l = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.t.c.a
    /* renamed from: o */
    public PointF i(com.airbnb.lottie.x.a<PointF> aVar, float f2) {
        PointF pointF;
        h hVar = (h) aVar;
        Path j2 = hVar.j();
        if (j2 == null) {
            return aVar.b;
        }
        com.airbnb.lottie.x.c<A> cVar = this.f539e;
        if (cVar == 0 || (pointF = (PointF) cVar.b(hVar.f584e, hVar.f585f.floatValue(), hVar.b, hVar.c, e(), f2, f())) == null) {
            if (this.f547k != hVar) {
                this.f548l.setPath(j2, false);
                this.f547k = hVar;
            }
            PathMeasure pathMeasure = this.f548l;
            pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.f546j, null);
            PointF pointF2 = this.f545i;
            float[] fArr = this.f546j;
            pointF2.set(fArr[0], fArr[1]);
            return this.f545i;
        }
        return pointF;
    }
}
