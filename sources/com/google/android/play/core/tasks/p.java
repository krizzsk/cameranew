package com.google.android.play.core.tasks;
/* loaded from: classes2.dex */
public final class p<ResultT> {
    private final s<ResultT> a = new s<>();

    public final d<ResultT> a() {
        return this.a;
    }

    public final void b(Exception exc) {
        this.a.k(exc);
    }

    public final void c(ResultT resultt) {
        this.a.l(resultt);
    }

    public final void d(Exception exc) {
        this.a.n(exc);
    }

    public final void e(ResultT resultt) {
        this.a.o(resultt);
    }
}
