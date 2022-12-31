package com.airbnb.lottie.t.c;

import java.util.List;
/* compiled from: ColorKeyframeAnimation.java */
/* loaded from: classes.dex */
public class b extends f<Integer> {
    public b(List<com.airbnb.lottie.x.a<Integer>> list) {
        super(list);
    }

    public int o() {
        return p(b(), d());
    }

    public int p(com.airbnb.lottie.x.a<Integer> aVar, float f2) {
        Integer num;
        Integer num2 = aVar.b;
        if (num2 != null && aVar.c != null) {
            int intValue = num2.intValue();
            int intValue2 = aVar.c.intValue();
            com.airbnb.lottie.x.c<A> cVar = this.f539e;
            if (cVar != 0 && (num = (Integer) cVar.b(aVar.f584e, aVar.f585f.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f2, e(), f())) != null) {
                return num.intValue();
            }
            return com.airbnb.lottie.w.b.c(com.airbnb.lottie.w.g.b(f2, 0.0f, 1.0f), intValue, intValue2);
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
