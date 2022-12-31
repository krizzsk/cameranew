package com.airbnb.lottie.x;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
/* compiled from: LottieValueCallback.java */
/* loaded from: classes.dex */
public class c<T> {
    private final b<T> a = new b<>();
    @Nullable
    protected T b;

    public c(@Nullable T t) {
        this.b = null;
        this.b = t;
    }

    @Nullable
    public T a(b<T> bVar) {
        return this.b;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final T b(float f2, float f3, T t, T t2, float f4, float f5, float f6) {
        b<T> bVar = this.a;
        bVar.a(f2, f3, t, t2, f4, f5, f6);
        return a(bVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void c(@Nullable com.airbnb.lottie.t.c.a<?, ?> aVar) {
    }
}
