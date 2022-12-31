package com.airbnb.lottie.t.c;

import android.graphics.PointF;
import java.util.Collections;
/* compiled from: SplitDimensionPathKeyframeAnimation.java */
/* loaded from: classes.dex */
public class m extends a<PointF, PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f553i;

    /* renamed from: j  reason: collision with root package name */
    private final a<Float, Float> f554j;

    /* renamed from: k  reason: collision with root package name */
    private final a<Float, Float> f555k;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f553i = new PointF();
        this.f554j = aVar;
        this.f555k = aVar2;
        l(f());
    }

    @Override // com.airbnb.lottie.t.c.a
    public void l(float f2) {
        this.f554j.l(f2);
        this.f555k.l(f2);
        this.f553i.set(this.f554j.h().floatValue(), this.f555k.h().floatValue());
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).a();
        }
    }

    @Override // com.airbnb.lottie.t.c.a
    /* renamed from: o */
    public PointF h() {
        return i(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.t.c.a
    /* renamed from: p */
    public PointF i(com.airbnb.lottie.x.a<PointF> aVar, float f2) {
        return this.f553i;
    }
}
