package com.airbnb.lottie.t.c;

import android.graphics.Path;
import java.util.List;
/* compiled from: ShapeKeyframeAnimation.java */
/* loaded from: classes.dex */
public class l extends a<com.airbnb.lottie.model.content.h, Path> {

    /* renamed from: i  reason: collision with root package name */
    private final com.airbnb.lottie.model.content.h f551i;

    /* renamed from: j  reason: collision with root package name */
    private final Path f552j;

    public l(List<com.airbnb.lottie.x.a<com.airbnb.lottie.model.content.h>> list) {
        super(list);
        this.f551i = new com.airbnb.lottie.model.content.h();
        this.f552j = new Path();
    }

    @Override // com.airbnb.lottie.t.c.a
    /* renamed from: o */
    public Path i(com.airbnb.lottie.x.a<com.airbnb.lottie.model.content.h> aVar, float f2) {
        this.f551i.c(aVar.b, aVar.c, f2);
        com.airbnb.lottie.w.g.h(this.f551i, this.f552j);
        return this.f552j;
    }
}
