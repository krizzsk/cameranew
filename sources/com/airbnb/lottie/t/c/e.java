package com.airbnb.lottie.t.c;

import java.util.List;
/* compiled from: IntegerKeyframeAnimation.java */
/* loaded from: classes.dex */
public class e extends f<Integer> {
    public e(List<com.airbnb.lottie.x.a<Integer>> list) {
        super(list);
    }

    public int o() {
        return p(b(), d());
    }

    int p(com.airbnb.lottie.x.a<Integer> aVar, float f2) {
        Integer num;
        if (aVar.b != null && aVar.c != null) {
            com.airbnb.lottie.x.c<A> cVar = this.f539e;
            if (cVar != 0 && (num = (Integer) cVar.b(aVar.f584e, aVar.f585f.floatValue(), aVar.b, aVar.c, f2, e(), f())) != null) {
                return num.intValue();
            }
            return com.airbnb.lottie.w.g.k(aVar.g(), aVar.d(), f2);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.t.c.a
    /* renamed from: q */
    public Integer i(com.airbnb.lottie.x.a<Integer> aVar, float f2) {
        return Integer.valueOf(p(aVar, f2));
    }
}
