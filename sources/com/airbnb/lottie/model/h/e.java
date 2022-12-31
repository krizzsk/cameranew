package com.airbnb.lottie.model.h;

import android.graphics.PointF;
import java.util.List;
/* compiled from: AnimatablePathValue.java */
/* loaded from: classes.dex */
public class e implements m<PointF, PointF> {
    private final List<com.airbnb.lottie.x.a<PointF>> a;

    public e(List<com.airbnb.lottie.x.a<PointF>> list) {
        this.a = list;
    }

    @Override // com.airbnb.lottie.model.h.m
    public com.airbnb.lottie.t.c.a<PointF, PointF> a() {
        if (this.a.get(0).h()) {
            return new com.airbnb.lottie.t.c.j(this.a);
        }
        return new com.airbnb.lottie.t.c.i(this.a);
    }

    @Override // com.airbnb.lottie.model.h.m
    public List<com.airbnb.lottie.x.a<PointF>> b() {
        return this.a;
    }

    @Override // com.airbnb.lottie.model.h.m
    public boolean isStatic() {
        return this.a.size() == 1 && this.a.get(0).h();
    }
}
