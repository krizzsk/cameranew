package com.facebook.imagepipeline.producers;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: ThrottlingProducer.java */
/* loaded from: classes.dex */
public class a1<T> implements n0<T> {
    private final n0<T> a;
    private final int b;
    @GuardedBy("this")
    private int c;
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    private final ConcurrentLinkedQueue<Pair<l<T>, o0>> f2874d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f2875e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ThrottlingProducer.java */
    /* loaded from: classes.dex */
    public class b extends p<T, T> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ThrottlingProducer.java */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            final /* synthetic */ Pair a;

            a(Pair pair) {
                this.a = pair;
            }

            @Override // java.lang.Runnable
            public void run() {
                a1 a1Var = a1.this;
                Pair pair = this.a;
                a1Var.f((l) pair.first, (o0) pair.second);
            }
        }

        private void p() {
            Pair pair;
            synchronized (a1.this) {
                pair = (Pair) a1.this.f2874d.poll();
                if (pair == null) {
                    a1.d(a1.this);
                }
            }
            if (pair != null) {
                a1.this.f2875e.execute(new a(pair));
            }
        }

        @Override // com.facebook.imagepipeline.producers.p, com.facebook.imagepipeline.producers.b
        protected void f() {
            o().a();
            p();
        }

        @Override // com.facebook.imagepipeline.producers.p, com.facebook.imagepipeline.producers.b
        protected void g(Throwable th) {
            o().onFailure(th);
            p();
        }

        @Override // com.facebook.imagepipeline.producers.b
        protected void h(@Nullable T t, int i2) {
            o().c(t, i2);
            if (com.facebook.imagepipeline.producers.b.d(i2)) {
                p();
            }
        }

        private b(l<T> lVar) {
            super(lVar);
        }
    }

    public a1(int i2, Executor executor, n0<T> n0Var) {
        this.b = i2;
        com.facebook.common.internal.h.g(executor);
        this.f2875e = executor;
        com.facebook.common.internal.h.g(n0Var);
        this.a = n0Var;
        this.f2874d = new ConcurrentLinkedQueue<>();
        this.c = 0;
    }

    static /* synthetic */ int d(a1 a1Var) {
        int i2 = a1Var.c;
        a1Var.c = i2 - 1;
        return i2;
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<T> lVar, o0 o0Var) {
        boolean z;
        o0Var.h().d(o0Var, "ThrottlingProducer");
        synchronized (this) {
            int i2 = this.c;
            z = true;
            if (i2 >= this.b) {
                this.f2874d.add(Pair.create(lVar, o0Var));
            } else {
                this.c = i2 + 1;
                z = false;
            }
        }
        if (z) {
            return;
        }
        f(lVar, o0Var);
    }

    void f(l<T> lVar, o0 o0Var) {
        o0Var.h().j(o0Var, "ThrottlingProducer", null);
        this.a.b(new b(lVar), o0Var);
    }
}
