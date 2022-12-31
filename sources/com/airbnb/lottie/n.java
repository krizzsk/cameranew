package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/* compiled from: LottieTask.java */
/* loaded from: classes.dex */
public class n<T> {

    /* renamed from: e  reason: collision with root package name */
    public static Executor f450e = Executors.newCachedThreadPool();
    private final Set<i<T>> a;
    private final Set<i<Throwable>> b;
    private final Handler c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private volatile m<T> f451d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieTask.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f451d == null) {
                return;
            }
            m mVar = n.this.f451d;
            if (mVar.b() != null) {
                n.this.i(mVar.b());
            } else {
                n.this.g(mVar.a());
            }
        }
    }

    /* compiled from: LottieTask.java */
    /* loaded from: classes.dex */
    private class b extends FutureTask<m<T>> {
        b(Callable<m<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                n.this.l(get());
            } catch (InterruptedException | ExecutionException e2) {
                n.this.l(new m(e2));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public n(Callable<m<T>> callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(Throwable th) {
        ArrayList<i> arrayList = new ArrayList(this.b);
        if (arrayList.isEmpty()) {
            com.airbnb.lottie.w.d.d("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        for (i iVar : arrayList) {
            iVar.onResult(th);
        }
    }

    private void h() {
        this.c.post(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i(T t) {
        for (i iVar : new ArrayList(this.a)) {
            iVar.onResult(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(@Nullable m<T> mVar) {
        if (this.f451d == null) {
            this.f451d = mVar;
            h();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized n<T> e(i<Throwable> iVar) {
        if (this.f451d != null && this.f451d.a() != null) {
            iVar.onResult(this.f451d.a());
        }
        this.b.add(iVar);
        return this;
    }

    public synchronized n<T> f(i<T> iVar) {
        if (this.f451d != null && this.f451d.b() != null) {
            iVar.onResult(this.f451d.b());
        }
        this.a.add(iVar);
        return this;
    }

    public synchronized n<T> j(i<Throwable> iVar) {
        this.b.remove(iVar);
        return this;
    }

    public synchronized n<T> k(i<T> iVar) {
        this.a.remove(iVar);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    n(Callable<m<T>> callable, boolean z) {
        this.a = new LinkedHashSet(1);
        this.b = new LinkedHashSet(1);
        this.c = new Handler(Looper.getMainLooper());
        this.f451d = null;
        if (z) {
            try {
                l(callable.call());
                return;
            } catch (Throwable th) {
                l(new m<>(th));
                return;
            }
        }
        f450e.execute(new b(callable));
    }
}
