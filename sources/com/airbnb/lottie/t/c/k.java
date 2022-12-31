package com.airbnb.lottie.t.c;

import java.util.List;
/* compiled from: ScaleKeyframeAnimation.java */
/* loaded from: classes.dex */
public class k extends f<com.airbnb.lottie.x.d> {

    /* renamed from: i  reason: collision with root package name */
    private final com.airbnb.lottie.x.d f550i;

    public k(List<com.airbnb.lottie.x.a<com.airbnb.lottie.x.d>> list) {
        super(list);
        this.f550i = new com.airbnb.lottie.x.d();
    }

    @Override // com.airbnb.lottie.t.c.a
    /* renamed from: o */
    public com.airbnb.lottie.x.d i(com.airbnb.lottie.x.a<com.airbnb.lottie.x.d> aVar, float f2) {
        com.airbnb.lottie.x.d dVar;
        com.airbnb.lottie.x.d dVar2;
        com.airbnb.lottie.x.d dVar3 = aVar.b;
        if (dVar3 != null && (dVar = aVar.c) != null) {
            com.airbnb.lottie.x.d dVar4 = dVar3;
            com.airbnb.lottie.x.d dVar5 = dVar;
            com.airbnb.lottie.x.c<A> cVar = this.f539e;
            if (cVar == 0 || (dVar2 = (com.airbnb.lottie.x.d) cVar.b(aVar.f584e, aVar.f585f.floatValue(), dVar4, dVar5, f2, e(), f())) == null) {
                this.f550i.d(com.airbnb.lottie.w.g.j(dVar4.b(), dVar5.b(), f2), com.airbnb.lottie.w.g.j(dVar4.c(), dVar5.c(), f2));
                return this.f550i;
            }
            return dVar2;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
