package com.airbnb.lottie.t.c;

import android.graphics.PointF;
import java.util.List;
/* compiled from: PointKeyframeAnimation.java */
/* loaded from: classes.dex */
public class j extends f<PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f549i;

    public j(List<com.airbnb.lottie.x.a<PointF>> list) {
        super(list);
        this.f549i = new PointF();
    }

    @Override // com.airbnb.lottie.t.c.a
    /* renamed from: o */
    public PointF i(com.airbnb.lottie.x.a<PointF> aVar, float f2) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = aVar.b;
        if (pointF3 != null && (pointF = aVar.c) != null) {
            PointF pointF4 = pointF3;
            PointF pointF5 = pointF;
            com.airbnb.lottie.x.c<A> cVar = this.f539e;
            if (cVar == 0 || (pointF2 = (PointF) cVar.b(aVar.f584e, aVar.f585f.floatValue(), pointF4, pointF5, f2, e(), f())) == null) {
                PointF pointF6 = this.f549i;
                float f3 = pointF4.x;
                float f4 = pointF4.y;
                pointF6.set(f3 + ((pointF5.x - f3) * f2), f4 + (f2 * (pointF5.y - f4)));
                return this.f549i;
            }
            return pointF2;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
