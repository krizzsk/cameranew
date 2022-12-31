package com.airbnb.lottie.t.c;

import java.util.List;
/* compiled from: FloatKeyframeAnimation.java */
/* loaded from: classes.dex */
public class c extends f<Float> {
    public c(List<com.airbnb.lottie.x.a<Float>> list) {
        super(list);
    }

    public float o() {
        return p(b(), d());
    }

    float p(com.airbnb.lottie.x.a<Float> aVar, float f2) {
        Float f3;
        if (aVar.b != null && aVar.c != null) {
            com.airbnb.lottie.x.c<A> cVar = this.f539e;
            if (cVar != 0 && (f3 = (Float) cVar.b(aVar.f584e, aVar.f585f.floatValue(), aVar.b, aVar.c, f2, e(), f())) != null) {
                return f3.floatValue();
            }
            return com.airbnb.lottie.w.g.j(aVar.f(), aVar.c(), f2);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.t.c.a
    /* renamed from: q */
    public Float i(com.airbnb.lottie.x.a<Float> aVar, float f2) {
        return Float.valueOf(p(aVar, f2));
    }
}
