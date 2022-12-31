package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
public final class c0<TResult> extends g<TResult> {
    private final Object a = new Object();
    private final z<TResult> b = new z<>();
    @GuardedBy("mLock")
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f4024d;
    @Nullable
    @GuardedBy("mLock")

    /* renamed from: e  reason: collision with root package name */
    private TResult f4025e;
    @GuardedBy("mLock")

    /* renamed from: f  reason: collision with root package name */
    private Exception f4026f;

    @GuardedBy("mLock")
    private final void t() {
        com.google.android.gms.common.internal.q.n(this.c, "Task is not yet complete");
    }

    @GuardedBy("mLock")
    private final void w() {
        if (this.c) {
            throw DuplicateTaskCompletionException.of(this);
        }
    }

    @GuardedBy("mLock")
    private final void x() {
        if (this.f4024d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void y() {
        synchronized (this.a) {
            if (this.c) {
                this.b.a(this);
            }
        }
    }

    @Override // com.google.android.gms.tasks.g
    @NonNull
    public final g<TResult> a(@NonNull Executor executor, @NonNull b bVar) {
        z<TResult> zVar = this.b;
        d0.a(executor);
        zVar.b(new p(executor, bVar));
        y();
        return this;
    }

    @Override // com.google.android.gms.tasks.g
    @NonNull
    public final g<TResult> b(@NonNull Executor executor, @NonNull c<TResult> cVar) {
        z<TResult> zVar = this.b;
        d0.a(executor);
        zVar.b(new q(executor, cVar));
        y();
        return this;
    }

    @Override // com.google.android.gms.tasks.g
    @NonNull
    public final g<TResult> c(@NonNull Executor executor, @NonNull d dVar) {
        z<TResult> zVar = this.b;
        d0.a(executor);
        zVar.b(new u(executor, dVar));
        y();
        return this;
    }

    @Override // com.google.android.gms.tasks.g
    @NonNull
    public final g<TResult> d(@NonNull Executor executor, @NonNull e<? super TResult> eVar) {
        z<TResult> zVar = this.b;
        d0.a(executor);
        zVar.b(new v(executor, eVar));
        y();
        return this;
    }

    @Override // com.google.android.gms.tasks.g
    @NonNull
    public final <TContinuationResult> g<TContinuationResult> e(@NonNull a<TResult, TContinuationResult> aVar) {
        return f(i.a, aVar);
    }

    @Override // com.google.android.gms.tasks.g
    @NonNull
    public final <TContinuationResult> g<TContinuationResult> f(@NonNull Executor executor, @NonNull a<TResult, TContinuationResult> aVar) {
        c0 c0Var = new c0();
        z<TResult> zVar = this.b;
        d0.a(executor);
        zVar.b(new k(executor, aVar, c0Var));
        y();
        return c0Var;
    }

    @Override // com.google.android.gms.tasks.g
    @NonNull
    public final <TContinuationResult> g<TContinuationResult> g(@NonNull a<TResult, g<TContinuationResult>> aVar) {
        return h(i.a, aVar);
    }

    @Override // com.google.android.gms.tasks.g
    @NonNull
    public final <TContinuationResult> g<TContinuationResult> h(@NonNull Executor executor, @NonNull a<TResult, g<TContinuationResult>> aVar) {
        c0 c0Var = new c0();
        z<TResult> zVar = this.b;
        d0.a(executor);
        zVar.b(new l(executor, aVar, c0Var));
        y();
        return c0Var;
    }

    @Override // com.google.android.gms.tasks.g
    @Nullable
    public final Exception i() {
        Exception exc;
        synchronized (this.a) {
            exc = this.f4026f;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.g
    public final TResult j() {
        TResult tresult;
        synchronized (this.a) {
            t();
            x();
            if (this.f4026f == null) {
                tresult = this.f4025e;
            } else {
                throw new RuntimeExecutionException(this.f4026f);
            }
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.g
    public final <X extends Throwable> TResult k(@NonNull Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.a) {
            t();
            x();
            if (!cls.isInstance(this.f4026f)) {
                if (this.f4026f == null) {
                    tresult = this.f4025e;
                } else {
                    throw new RuntimeExecutionException(this.f4026f);
                }
            } else {
                throw cls.cast(this.f4026f);
            }
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.g
    public final boolean l() {
        return this.f4024d;
    }

    @Override // com.google.android.gms.tasks.g
    public final boolean m() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.g
    public final boolean n() {
        boolean z;
        synchronized (this.a) {
            z = this.c && !this.f4024d && this.f4026f == null;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.g
    @NonNull
    public final <TContinuationResult> g<TContinuationResult> o(@NonNull f<TResult, TContinuationResult> fVar) {
        return p(i.a, fVar);
    }

    @Override // com.google.android.gms.tasks.g
    @NonNull
    public final <TContinuationResult> g<TContinuationResult> p(Executor executor, f<TResult, TContinuationResult> fVar) {
        c0 c0Var = new c0();
        z<TResult> zVar = this.b;
        d0.a(executor);
        zVar.b(new y(executor, fVar, c0Var));
        y();
        return c0Var;
    }

    public final void q(@NonNull Exception exc) {
        com.google.android.gms.common.internal.q.k(exc, "Exception must not be null");
        synchronized (this.a) {
            w();
            this.c = true;
            this.f4026f = exc;
        }
        this.b.a(this);
    }

    public final void r(@Nullable TResult tresult) {
        synchronized (this.a) {
            w();
            this.c = true;
            this.f4025e = tresult;
        }
        this.b.a(this);
    }

    public final boolean s() {
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.f4024d = true;
            this.b.a(this);
            return true;
        }
    }

    public final boolean u(@NonNull Exception exc) {
        com.google.android.gms.common.internal.q.k(exc, "Exception must not be null");
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.f4026f = exc;
            this.b.a(this);
            return true;
        }
    }

    public final boolean v(@Nullable TResult tresult) {
        synchronized (this.a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.f4025e = tresult;
            this.b.a(this);
            return true;
        }
    }
}
