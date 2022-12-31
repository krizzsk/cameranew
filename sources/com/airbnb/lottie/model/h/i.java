package com.airbnb.lottie.model.h;

import android.graphics.PointF;
import java.util.List;
/* compiled from: AnimatableSplitDimensionPathValue.java */
/* loaded from: classes.dex */
public class i implements m<PointF, PointF> {
    private final b a;
    private final b b;

    public i(b bVar, b bVar2) {
        this.a = bVar;
        this.b = bVar2;
    }

    @Override // com.airbnb.lottie.model.h.m
    public com.airbnb.lottie.t.c.a<PointF, PointF> a() {
        return new com.airbnb.lottie.t.c.m(this.a.a(), this.b.a());
    }

    @Override // com.airbnb.lottie.model.h.m
    public List<com.airbnb.lottie.x.a<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.airbnb.lottie.model.h.m
    public boolean isStatic() {
        return this.a.isStatic() && this.b.isStatic();
    }
}
