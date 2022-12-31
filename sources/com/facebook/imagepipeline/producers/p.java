package com.facebook.imagepipeline.producers;
/* compiled from: DelegatingConsumer.java */
/* loaded from: classes.dex */
public abstract class p<I, O> extends b<I> {
    private final l<O> b;

    public p(l<O> lVar) {
        this.b = lVar;
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void f() {
        this.b.a();
    }

    @Override // com.facebook.imagepipeline.producers.b
    protected void g(Throwable th) {
        this.b.onFailure(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.producers.b
    public void i(float f2) {
        this.b.b(f2);
    }

    public l<O> o() {
        return this.b;
    }
}
