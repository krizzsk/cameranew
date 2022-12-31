package com.facebook.imagepipeline.a;

import com.facebook.imagepipeline.producers.n0;
import com.facebook.imagepipeline.producers.o0;
import com.facebook.imagepipeline.producers.u0;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: CloseableProducerToDataSourceAdapter.java */
@ThreadSafe
/* loaded from: classes.dex */
public class c<T> extends a<com.facebook.common.references.a<T>> {
    private c(n0<com.facebook.common.references.a<T>> n0Var, u0 u0Var, com.facebook.imagepipeline.e.d dVar) {
        super(n0Var, u0Var, dVar);
    }

    public static <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> G(n0<com.facebook.common.references.a<T>> n0Var, u0 u0Var, com.facebook.imagepipeline.e.d dVar) {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("CloseableProducerToDataSourceAdapter#create");
        }
        c cVar = new c(n0Var, u0Var, dVar);
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.datasource.AbstractDataSource
    /* renamed from: F */
    public void f(com.facebook.common.references.a<T> aVar) {
        com.facebook.common.references.a.y(aVar);
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    @Nullable
    /* renamed from: H */
    public com.facebook.common.references.a<T> getResult() {
        return com.facebook.common.references.a.w((com.facebook.common.references.a) super.getResult());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.a.a
    /* renamed from: I */
    public void D(com.facebook.common.references.a<T> aVar, int i2, o0 o0Var) {
        super.D(com.facebook.common.references.a.w(aVar), i2, o0Var);
    }
}
