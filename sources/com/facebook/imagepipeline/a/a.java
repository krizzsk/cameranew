package com.facebook.imagepipeline.a;

import com.facebook.common.internal.h;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.producers.l;
import com.facebook.imagepipeline.producers.n0;
import com.facebook.imagepipeline.producers.o0;
import com.facebook.imagepipeline.producers.u0;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: AbstractProducerToDataSourceAdapter.java */
@ThreadSafe
/* loaded from: classes.dex */
public abstract class a<T> extends AbstractDataSource<T> {

    /* renamed from: i  reason: collision with root package name */
    private final u0 f2660i;

    /* renamed from: j  reason: collision with root package name */
    private final com.facebook.imagepipeline.e.d f2661j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractProducerToDataSourceAdapter.java */
    /* renamed from: com.facebook.imagepipeline.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0097a extends com.facebook.imagepipeline.producers.b<T> {
        C0097a() {
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void f() {
            a.this.B();
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void g(Throwable th) {
            a.this.C(th);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void h(@Nullable T t, int i2) {
            a aVar = a.this;
            aVar.D(t, i2, aVar.f2660i);
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void i(float f2) {
            a.this.q(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(n0<T> n0Var, u0 u0Var, com.facebook.imagepipeline.e.d dVar) {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("AbstractProducerToDataSourceAdapter()");
        }
        this.f2660i = u0Var;
        this.f2661j = dVar;
        E();
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("AbstractProducerToDataSourceAdapter()->onRequestStart");
        }
        dVar.a(u0Var);
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("AbstractProducerToDataSourceAdapter()->produceResult");
        }
        n0Var.b(z(), u0Var);
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void B() {
        h.i(i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Throwable th) {
        if (super.o(th, A(this.f2660i))) {
            this.f2661j.i(this.f2660i, th);
        }
    }

    private void E() {
        m(this.f2660i.getExtras());
    }

    private l<T> z() {
        return new C0097a();
    }

    protected Map<String, Object> A(o0 o0Var) {
        return o0Var.getExtras();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(@Nullable T t, int i2, o0 o0Var) {
        boolean d2 = com.facebook.imagepipeline.producers.b.d(i2);
        if (super.s(t, d2, A(o0Var)) && d2) {
            this.f2661j.e(this.f2660i);
        }
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    public boolean close() {
        if (super.close()) {
            if (super.b()) {
                return true;
            }
            this.f2661j.g(this.f2660i);
            this.f2660i.t();
            return true;
        }
        return false;
    }
}
