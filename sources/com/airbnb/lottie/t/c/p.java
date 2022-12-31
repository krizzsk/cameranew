package com.airbnb.lottie.t.c;

import androidx.annotation.Nullable;
import java.util.Collections;
/* compiled from: ValueCallbackKeyframeAnimation.java */
/* loaded from: classes.dex */
public class p<K, A> extends a<K, A> {

    /* renamed from: i  reason: collision with root package name */
    private final A f565i;

    public p(com.airbnb.lottie.x.c<A> cVar) {
        this(cVar, null);
    }

    @Override // com.airbnb.lottie.t.c.a
    float c() {
        return 1.0f;
    }

    @Override // com.airbnb.lottie.t.c.a
    public A h() {
        com.airbnb.lottie.x.c<A> cVar = this.f539e;
        A a = this.f565i;
        return cVar.b(0.0f, 0.0f, a, a, f(), f(), f());
    }

    @Override // com.airbnb.lottie.t.c.a
    A i(com.airbnb.lottie.x.a<K> aVar, float f2) {
        return h();
    }

    @Override // com.airbnb.lottie.t.c.a
    public void j() {
        if (this.f539e != null) {
            super.j();
        }
    }

    @Override // com.airbnb.lottie.t.c.a
    public void l(float f2) {
        this.f538d = f2;
    }

    public p(com.airbnb.lottie.x.c<A> cVar, @Nullable A a) {
        super(Collections.emptyList());
        m(cVar);
        this.f565i = a;
    }
}
