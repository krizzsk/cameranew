package com.airbnb.lottie.t.c;

import java.util.List;
/* compiled from: GradientColorKeyframeAnimation.java */
/* loaded from: classes.dex */
public class d extends f<com.airbnb.lottie.model.content.c> {

    /* renamed from: i  reason: collision with root package name */
    private final com.airbnb.lottie.model.content.c f544i;

    public d(List<com.airbnb.lottie.x.a<com.airbnb.lottie.model.content.c>> list) {
        super(list);
        com.airbnb.lottie.model.content.c cVar = list.get(0).b;
        int c = cVar != null ? cVar.c() : 0;
        this.f544i = new com.airbnb.lottie.model.content.c(new float[c], new int[c]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.t.c.a
    /* renamed from: o */
    public com.airbnb.lottie.model.content.c i(com.airbnb.lottie.x.a<com.airbnb.lottie.model.content.c> aVar, float f2) {
        this.f544i.d(aVar.b, aVar.c, f2);
        return this.f544i;
    }
}
