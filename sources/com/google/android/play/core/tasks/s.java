package com.google.android.play.core.tasks;

import androidx.annotation.Nullable;
import com.google.android.play.core.internal.y;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
final class s<ResultT> extends d<ResultT> {
    private final Object a = new Object();
    private final o<ResultT> b = new o<>();
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private ResultT f4917d;

    /* renamed from: e  reason: collision with root package name */
    private Exception f4918e;

    private final void j() {
        y.d(this.c, "Task is not yet complete");
    }

    private final void m() {
        y.d(!this.c, "Task is already complete");
    }

    private final void p() {
        synchronized (this.a) {
            if (this.c) {
                this.b.a(this);
            }
        }
    }

    @Override // com.google.android.play.core.tasks.d
    public final d<ResultT> a(a<ResultT> aVar) {
        this.b.b(new h(e.a, aVar));
        p();
        return this;
    }

    @Override // com.google.android.play.core.tasks.d
    public final d<ResultT> b(b bVar) {
        c(e.a, bVar);
        return this;
    }

    @Override // com.google.android.play.core.tasks.d
    public final d<ResultT> c(Executor executor, b bVar) {
        this.b.b(new k(executor, bVar));
        p();
        return this;
    }

    @Override // com.google.android.play.core.tasks.d
    public final d<ResultT> d(c<? super ResultT> cVar) {
        e(e.a, cVar);
        return this;
    }

    @Override // com.google.android.play.core.tasks.d
    public final d<ResultT> e(Executor executor, c<? super ResultT> cVar) {
        this.b.b(new m(executor, cVar));
        p();
        return this;
    }

    @Override // com.google.android.play.core.tasks.d
    @Nullable
    public final Exception f() {
        Exception exc;
        synchronized (this.a) {
            exc = this.f4918e;
        }
        return exc;
    }

    @Override // com.google.android.play.core.tasks.d
    public final ResultT g() {
        ResultT resultt;
        synchronized (this.a) {
            j();
            Exception exc = this.f4918e;
            if (exc != null) {
                throw new RuntimeExecutionException(exc);
            }
            resultt = this.f4917d;
        }
        return resultt;
    }

    @Override // com.google.android.play.core.tasks.d
    public final boolean h() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    @Override // com.google.android.play.core.tasks.d
    public final boolean i() {
        boolean z;
        synchronized (this.a) {
            z = false;
            if (this.c && this.f4918e == null) {
                z = true;
            }
        }
        return z;
    }

    public final void k(Exception exc) {
        synchronized (this.a) {
            m();
            this.c = true;
            this.f4918e = exc;
        }
        this.b.a(this);
    }

    public final void l(ResultT resultt) {
        synchronized (this.a) {
            m();
            this.c = true;
            this.f4917d = resultt;
        }
        this.b.a(this);
    }

    public final boolean n(Exception exc) {
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.f4918e = exc;
            this.b.a(this);
            return true;
        }
    }

    public final boolean o(ResultT resultt) {
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.f4917d = resultt;
            this.b.a(this);
            return true;
        }
    }
}
