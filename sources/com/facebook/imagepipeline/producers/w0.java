package com.facebook.imagepipeline.producers;

import javax.annotation.Nullable;
/* compiled from: SwallowResultProducer.java */
/* loaded from: classes.dex */
public class w0<T> implements n0<Void> {
    private final n0<T> a;

    /* compiled from: SwallowResultProducer.java */
    /* loaded from: classes.dex */
    class a extends p<T, Void> {
        a(w0 w0Var, l lVar) {
            super(lVar);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void h(@Nullable T t, int i2) {
            if (b.d(i2)) {
                o().c(null, i2);
            }
        }
    }

    public w0(n0<T> n0Var) {
        this.a = n0Var;
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<Void> lVar, o0 o0Var) {
        this.a.b(new a(this, lVar), o0Var);
    }
}
