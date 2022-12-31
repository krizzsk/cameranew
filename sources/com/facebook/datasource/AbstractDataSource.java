package com.facebook.datasource;

import android.util.Pair;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes.dex */
public abstract class AbstractDataSource<T> implements com.facebook.datasource.b<T> {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static volatile c f2427h;
    @Nullable
    private Map<String, Object> a;
    @GuardedBy("this")
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private T f2428d = null;
    @GuardedBy("this")
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Throwable f2429e = null;
    @GuardedBy("this")

    /* renamed from: f  reason: collision with root package name */
    private float f2430f = 0.0f;
    @GuardedBy("this")
    private boolean c = false;
    @GuardedBy("this")
    private DataSourceStatus b = DataSourceStatus.IN_PROGRESS;

    /* renamed from: g  reason: collision with root package name */
    private final ConcurrentLinkedQueue<Pair<d<T>, Executor>> f2431g = new ConcurrentLinkedQueue<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ d b;
        final /* synthetic */ boolean c;

        a(boolean z, d dVar, boolean z2) {
            this.a = z;
            this.b = dVar;
            this.c = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a) {
                this.b.b(AbstractDataSource.this);
            } else if (this.c) {
                this.b.a(AbstractDataSource.this);
            } else {
                this.b.c(AbstractDataSource.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        final /* synthetic */ d a;

        b(d dVar) {
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.d(AbstractDataSource.this);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        Runnable a(Runnable runnable, String str);
    }

    @Nullable
    public static c g() {
        return f2427h;
    }

    private void k() {
        boolean h2 = h();
        boolean u = u();
        Iterator<Pair<d<T>, Executor>> it = this.f2431g.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            j((d) next.first, (Executor) next.second, h2, u);
        }
    }

    private synchronized boolean p(Throwable th, @Nullable Map<String, Object> map) {
        if (!this.c && this.b == DataSourceStatus.IN_PROGRESS) {
            this.b = DataSourceStatus.FAILURE;
            this.f2429e = th;
            this.a = map;
            return true;
        }
        return false;
    }

    private synchronized boolean r(float f2) {
        if (!this.c && this.b == DataSourceStatus.IN_PROGRESS) {
            if (f2 < this.f2430f) {
                return false;
            }
            this.f2430f = f2;
            return true;
        }
        return false;
    }

    private boolean t(@Nullable T t, boolean z) {
        T t2;
        T t3 = null;
        try {
            synchronized (this) {
                try {
                    try {
                        if (!this.c && this.b == DataSourceStatus.IN_PROGRESS) {
                            if (z) {
                                this.b = DataSourceStatus.SUCCESS;
                                this.f2430f = 1.0f;
                            }
                            T t4 = this.f2428d;
                            if (t4 != t) {
                                try {
                                    this.f2428d = t;
                                    t2 = t4;
                                } catch (Throwable th) {
                                    th = th;
                                    t3 = t4;
                                    throw th;
                                }
                            } else {
                                t2 = null;
                            }
                            return true;
                        }
                        if (t != null) {
                            f(t);
                        }
                        return false;
                    } catch (Throwable th2) {
                        t3 = t;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } finally {
            if (t3 != null) {
                f(t3);
            }
        }
    }

    private synchronized boolean u() {
        boolean z;
        if (i()) {
            z = b() ? false : true;
        }
        return z;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean a() {
        return this.f2428d != null;
    }

    @Override // com.facebook.datasource.b
    public synchronized boolean b() {
        return this.b != DataSourceStatus.IN_PROGRESS;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized Throwable c() {
        return this.f2429e;
    }

    @Override // com.facebook.datasource.b
    public boolean close() {
        synchronized (this) {
            if (this.c) {
                return false;
            }
            this.c = true;
            T t = this.f2428d;
            this.f2428d = null;
            if (t != null) {
                f(t);
            }
            if (!b()) {
                k();
            }
            synchronized (this) {
                this.f2431g.clear();
            }
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // com.facebook.datasource.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(com.facebook.datasource.d<T> r3, java.util.concurrent.Executor r4) {
        /*
            r2 = this;
            com.facebook.common.internal.h.g(r3)
            com.facebook.common.internal.h.g(r4)
            monitor-enter(r2)
            boolean r0 = r2.c     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto Ld
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L41
            return
        Ld:
            com.facebook.datasource.AbstractDataSource$DataSourceStatus r0 = r2.b     // Catch: java.lang.Throwable -> L41
            com.facebook.datasource.AbstractDataSource$DataSourceStatus r1 = com.facebook.datasource.AbstractDataSource.DataSourceStatus.IN_PROGRESS     // Catch: java.lang.Throwable -> L41
            if (r0 != r1) goto L1c
            java.util.concurrent.ConcurrentLinkedQueue<android.util.Pair<com.facebook.datasource.d<T>, java.util.concurrent.Executor>> r0 = r2.f2431g     // Catch: java.lang.Throwable -> L41
            android.util.Pair r1 = android.util.Pair.create(r3, r4)     // Catch: java.lang.Throwable -> L41
            r0.add(r1)     // Catch: java.lang.Throwable -> L41
        L1c:
            boolean r0 = r2.a()     // Catch: java.lang.Throwable -> L41
            if (r0 != 0) goto L31
            boolean r0 = r2.b()     // Catch: java.lang.Throwable -> L41
            if (r0 != 0) goto L31
            boolean r0 = r2.u()     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L2f
            goto L31
        L2f:
            r0 = 0
            goto L32
        L31:
            r0 = 1
        L32:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L40
            boolean r0 = r2.h()
            boolean r1 = r2.u()
            r2.j(r3, r4, r0, r1)
        L40:
            return
        L41:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L41
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.AbstractDataSource.d(com.facebook.datasource.d, java.util.concurrent.Executor):void");
    }

    @Override // com.facebook.datasource.b
    public boolean e() {
        return false;
    }

    protected void f(@Nullable T t) {
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public Map<String, Object> getExtras() {
        return this.a;
    }

    @Override // com.facebook.datasource.b
    public synchronized float getProgress() {
        return this.f2430f;
    }

    @Override // com.facebook.datasource.b
    @Nullable
    public synchronized T getResult() {
        return this.f2428d;
    }

    public synchronized boolean h() {
        return this.b == DataSourceStatus.FAILURE;
    }

    public synchronized boolean i() {
        return this.c;
    }

    protected void j(d<T> dVar, Executor executor, boolean z, boolean z2) {
        Runnable aVar = new a(z, dVar, z2);
        c g2 = g();
        if (g2 != null) {
            aVar = g2.a(aVar, "AbstractDataSource_notifyDataSubscriber");
        }
        executor.execute(aVar);
    }

    protected void l() {
        Iterator<Pair<d<T>, Executor>> it = this.f2431g.iterator();
        while (it.hasNext()) {
            Pair<d<T>, Executor> next = it.next();
            ((Executor) next.second).execute(new b((d) next.first));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(@Nullable Map<String, Object> map) {
        this.a = map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean n(Throwable th) {
        return o(th, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean o(Throwable th, @Nullable Map<String, Object> map) {
        boolean p = p(th, map);
        if (p) {
            k();
        }
        return p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean q(float f2) {
        boolean r = r(f2);
        if (r) {
            l();
        }
        return r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean s(@Nullable T t, boolean z, @Nullable Map<String, Object> map) {
        m(map);
        boolean t2 = t(t, z);
        if (t2) {
            k();
        }
        return t2;
    }
}
