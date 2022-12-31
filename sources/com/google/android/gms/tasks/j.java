package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
public final class j {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
    /* loaded from: classes2.dex */
    public interface a extends com.google.android.gms.tasks.b, d, e<Object> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
    /* loaded from: classes2.dex */
    public static final class c implements a {
        private final Object a = new Object();
        private final int b;
        private final c0<Void> c;
        @GuardedBy("mLock")

        /* renamed from: d  reason: collision with root package name */
        private int f4027d;
        @GuardedBy("mLock")

        /* renamed from: e  reason: collision with root package name */
        private int f4028e;
        @GuardedBy("mLock")

        /* renamed from: f  reason: collision with root package name */
        private int f4029f;
        @GuardedBy("mLock")

        /* renamed from: g  reason: collision with root package name */
        private Exception f4030g;
        @GuardedBy("mLock")

        /* renamed from: h  reason: collision with root package name */
        private boolean f4031h;

        public c(int i2, c0<Void> c0Var) {
            this.b = i2;
            this.c = c0Var;
        }

        @GuardedBy("mLock")
        private final void a() {
            if (this.f4027d + this.f4028e + this.f4029f == this.b) {
                if (this.f4030g != null) {
                    c0<Void> c0Var = this.c;
                    int i2 = this.f4028e;
                    int i3 = this.b;
                    StringBuilder sb = new StringBuilder(54);
                    sb.append(i2);
                    sb.append(" out of ");
                    sb.append(i3);
                    sb.append(" underlying tasks failed");
                    c0Var.q(new ExecutionException(sb.toString(), this.f4030g));
                } else if (this.f4031h) {
                    this.c.s();
                } else {
                    this.c.r(null);
                }
            }
        }

        @Override // com.google.android.gms.tasks.b
        public final void onCanceled() {
            synchronized (this.a) {
                this.f4029f++;
                this.f4031h = true;
                a();
            }
        }

        @Override // com.google.android.gms.tasks.d
        public final void onFailure(@NonNull Exception exc) {
            synchronized (this.a) {
                this.f4028e++;
                this.f4030g = exc;
                a();
            }
        }

        @Override // com.google.android.gms.tasks.e
        public final void onSuccess(Object obj) {
            synchronized (this.a) {
                this.f4027d++;
                a();
            }
        }
    }

    public static <TResult> TResult a(@NonNull g<TResult> gVar) throws ExecutionException, InterruptedException {
        com.google.android.gms.common.internal.q.h();
        com.google.android.gms.common.internal.q.k(gVar, "Task must not be null");
        if (gVar.m()) {
            return (TResult) j(gVar);
        }
        b bVar = new b(null);
        k(gVar, bVar);
        bVar.a();
        return (TResult) j(gVar);
    }

    public static <TResult> TResult b(@NonNull g<TResult> gVar, long j2, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        com.google.android.gms.common.internal.q.h();
        com.google.android.gms.common.internal.q.k(gVar, "Task must not be null");
        com.google.android.gms.common.internal.q.k(timeUnit, "TimeUnit must not be null");
        if (gVar.m()) {
            return (TResult) j(gVar);
        }
        b bVar = new b(null);
        k(gVar, bVar);
        if (bVar.b(j2, timeUnit)) {
            return (TResult) j(gVar);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    @NonNull
    public static <TResult> g<TResult> c(@NonNull Executor executor, @NonNull Callable<TResult> callable) {
        com.google.android.gms.common.internal.q.k(executor, "Executor must not be null");
        com.google.android.gms.common.internal.q.k(callable, "Callback must not be null");
        c0 c0Var = new c0();
        executor.execute(new g0(c0Var, callable));
        return c0Var;
    }

    @NonNull
    public static <TResult> g<TResult> d(@NonNull Exception exc) {
        c0 c0Var = new c0();
        c0Var.q(exc);
        return c0Var;
    }

    @NonNull
    public static <TResult> g<TResult> e(TResult tresult) {
        c0 c0Var = new c0();
        c0Var.r(tresult);
        return c0Var;
    }

    @NonNull
    public static g<Void> f(@Nullable Collection<? extends g<?>> collection) {
        if (collection != null && !collection.isEmpty()) {
            for (g<?> gVar : collection) {
                Objects.requireNonNull(gVar, "null tasks are not accepted");
            }
            c0 c0Var = new c0();
            c cVar = new c(collection.size(), c0Var);
            for (g<?> gVar2 : collection) {
                k(gVar2, cVar);
            }
            return c0Var;
        }
        return e(null);
    }

    @NonNull
    public static g<Void> g(@Nullable g<?>... gVarArr) {
        if (gVarArr != null && gVarArr.length != 0) {
            return f(Arrays.asList(gVarArr));
        }
        return e(null);
    }

    @NonNull
    public static g<List<g<?>>> h(@Nullable Collection<? extends g<?>> collection) {
        if (collection != null && !collection.isEmpty()) {
            return f(collection).g(new h0(collection));
        }
        return e(Collections.emptyList());
    }

    @NonNull
    public static g<List<g<?>>> i(@Nullable g<?>... gVarArr) {
        if (gVarArr != null && gVarArr.length != 0) {
            return h(Arrays.asList(gVarArr));
        }
        return e(Collections.emptyList());
    }

    private static <TResult> TResult j(@NonNull g<TResult> gVar) throws ExecutionException {
        if (gVar.n()) {
            return gVar.j();
        }
        if (gVar.l()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(gVar.i());
    }

    private static void k(g<?> gVar, a aVar) {
        Executor executor = i.b;
        gVar.d(executor, aVar);
        gVar.c(executor, aVar);
        gVar.a(executor, aVar);
    }

    /* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
    /* loaded from: classes2.dex */
    private static final class b implements a {
        private final CountDownLatch a;

        private b() {
            this.a = new CountDownLatch(1);
        }

        public final void a() throws InterruptedException {
            this.a.await();
        }

        public final boolean b(long j2, TimeUnit timeUnit) throws InterruptedException {
            return this.a.await(j2, timeUnit);
        }

        @Override // com.google.android.gms.tasks.b
        public final void onCanceled() {
            this.a.countDown();
        }

        @Override // com.google.android.gms.tasks.d
        public final void onFailure(@NonNull Exception exc) {
            this.a.countDown();
        }

        @Override // com.google.android.gms.tasks.e
        public final void onSuccess(Object obj) {
            this.a.countDown();
        }

        /* synthetic */ b(g0 g0Var) {
            this();
        }
    }
}
