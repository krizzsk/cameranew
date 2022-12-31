package com.facebook.imagepipeline.cache;

import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import com.facebook.imagepipeline.cache.i;
import com.facebook.imagepipeline.cache.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: LruCountingMemoryCache.java */
@ThreadSafe
/* loaded from: classes.dex */
public class q<K, V> implements i<K, V>, r<K, V> {
    @Nullable
    private final i.b<K> a;
    @GuardedBy("this")
    @VisibleForTesting
    final h<K, i.a<K, V>> b;
    @GuardedBy("this")
    @VisibleForTesting
    final h<K, i.a<K, V>> c;

    /* renamed from: d  reason: collision with root package name */
    private final v<V> f2693d;

    /* renamed from: e  reason: collision with root package name */
    private final com.facebook.common.internal.k<s> f2694e;
    @GuardedBy("this")

    /* renamed from: f  reason: collision with root package name */
    protected s f2695f;
    @GuardedBy("this")

    /* renamed from: g  reason: collision with root package name */
    private long f2696g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LruCountingMemoryCache.java */
    /* loaded from: classes.dex */
    public class a implements v<i.a<K, V>> {
        final /* synthetic */ v a;

        a(q qVar, v vVar) {
            this.a = vVar;
        }

        @Override // com.facebook.imagepipeline.cache.v
        /* renamed from: b */
        public int a(i.a<K, V> aVar) {
            return this.a.a(aVar.b.A());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LruCountingMemoryCache.java */
    /* loaded from: classes.dex */
    public class b implements com.facebook.common.references.h<V> {
        final /* synthetic */ i.a a;

        b(i.a aVar) {
            this.a = aVar;
        }

        @Override // com.facebook.common.references.h
        public void release(V v) {
            q.this.w(this.a);
        }
    }

    public q(v<V> vVar, r.a aVar, com.facebook.common.internal.k<s> kVar, @Nullable i.b<K> bVar) {
        new WeakHashMap();
        this.f2693d = vVar;
        this.b = new h<>(y(vVar));
        this.c = new h<>(y(vVar));
        this.f2694e = kVar;
        s sVar = kVar.get();
        com.facebook.common.internal.h.h(sVar, "mMemoryCacheParamsSupplier returned null");
        this.f2695f = sVar;
        this.f2696g = SystemClock.uptimeMillis();
        this.a = bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (j() <= (r3.f2695f.a - r4)) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized boolean g(V r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.facebook.imagepipeline.cache.v<V> r0 = r3.f2693d     // Catch: java.lang.Throwable -> L28
            int r4 = r0.a(r4)     // Catch: java.lang.Throwable -> L28
            com.facebook.imagepipeline.cache.s r0 = r3.f2695f     // Catch: java.lang.Throwable -> L28
            int r0 = r0.f2698e     // Catch: java.lang.Throwable -> L28
            r1 = 1
            if (r4 > r0) goto L25
            int r0 = r3.i()     // Catch: java.lang.Throwable -> L28
            com.facebook.imagepipeline.cache.s r2 = r3.f2695f     // Catch: java.lang.Throwable -> L28
            int r2 = r2.b     // Catch: java.lang.Throwable -> L28
            int r2 = r2 - r1
            if (r0 > r2) goto L25
            int r0 = r3.j()     // Catch: java.lang.Throwable -> L28
            com.facebook.imagepipeline.cache.s r2 = r3.f2695f     // Catch: java.lang.Throwable -> L28
            int r2 = r2.a     // Catch: java.lang.Throwable -> L28
            int r2 = r2 - r4
            if (r0 > r2) goto L25
            goto L26
        L25:
            r1 = 0
        L26:
            monitor-exit(r3)
            return r1
        L28:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.cache.q.g(java.lang.Object):boolean");
    }

    private synchronized void h(i.a<K, V> aVar) {
        com.facebook.common.internal.h.g(aVar);
        com.facebook.common.internal.h.i(aVar.c > 0);
        aVar.c--;
    }

    private synchronized void k(i.a<K, V> aVar) {
        com.facebook.common.internal.h.g(aVar);
        com.facebook.common.internal.h.i(!aVar.f2691d);
        aVar.c++;
    }

    private synchronized void l(i.a<K, V> aVar) {
        com.facebook.common.internal.h.g(aVar);
        com.facebook.common.internal.h.i(!aVar.f2691d);
        aVar.f2691d = true;
    }

    private synchronized void m(@Nullable ArrayList<i.a<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<i.a<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                l(it.next());
            }
        }
    }

    private synchronized boolean n(i.a<K, V> aVar) {
        if (aVar.f2691d || aVar.c != 0) {
            return false;
        }
        this.b.g(aVar.a, aVar);
        return true;
    }

    private void o(@Nullable ArrayList<i.a<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<i.a<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                com.facebook.common.references.a.y(v(it.next()));
            }
        }
    }

    private static <K, V> void q(@Nullable i.a<K, V> aVar) {
        i.b<K> bVar;
        if (aVar == null || (bVar = aVar.f2692e) == null) {
            return;
        }
        bVar.a(aVar.a, true);
    }

    private static <K, V> void r(@Nullable i.a<K, V> aVar) {
        i.b<K> bVar;
        if (aVar == null || (bVar = aVar.f2692e) == null) {
            return;
        }
        bVar.a(aVar.a, false);
    }

    private void s(@Nullable ArrayList<i.a<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<i.a<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                r(it.next());
            }
        }
    }

    private synchronized void t() {
        if (this.f2696g + this.f2695f.f2699f > SystemClock.uptimeMillis()) {
            return;
        }
        this.f2696g = SystemClock.uptimeMillis();
        s sVar = this.f2694e.get();
        com.facebook.common.internal.h.h(sVar, "mMemoryCacheParamsSupplier returned null");
        this.f2695f = sVar;
    }

    private synchronized com.facebook.common.references.a<V> u(i.a<K, V> aVar) {
        k(aVar);
        return com.facebook.common.references.a.T(aVar.b.A(), new b(aVar));
    }

    @Nullable
    private synchronized com.facebook.common.references.a<V> v(i.a<K, V> aVar) {
        com.facebook.common.internal.h.g(aVar);
        return (aVar.f2691d && aVar.c == 0) ? aVar.b : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(i.a<K, V> aVar) {
        boolean n;
        com.facebook.common.references.a<V> v;
        com.facebook.common.internal.h.g(aVar);
        synchronized (this) {
            h(aVar);
            n = n(aVar);
            v = v(aVar);
        }
        com.facebook.common.references.a.y(v);
        if (!n) {
            aVar = null;
        }
        q(aVar);
        t();
        p();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
        throw new java.lang.IllegalStateException(java.lang.String.format("key is null, but exclusiveEntries count: %d, size: %d", java.lang.Integer.valueOf(r4.b.c()), java.lang.Integer.valueOf(r4.b.e())));
     */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized java.util.ArrayList<com.facebook.imagepipeline.cache.i.a<K, V>> x(int r5, int r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            int r5 = java.lang.Math.max(r5, r0)     // Catch: java.lang.Throwable -> L74
            int r6 = java.lang.Math.max(r6, r0)     // Catch: java.lang.Throwable -> L74
            com.facebook.imagepipeline.cache.h<K, com.facebook.imagepipeline.cache.i$a<K, V>> r1 = r4.b     // Catch: java.lang.Throwable -> L74
            int r1 = r1.c()     // Catch: java.lang.Throwable -> L74
            if (r1 > r5) goto L1d
            com.facebook.imagepipeline.cache.h<K, com.facebook.imagepipeline.cache.i$a<K, V>> r1 = r4.b     // Catch: java.lang.Throwable -> L74
            int r1 = r1.e()     // Catch: java.lang.Throwable -> L74
            if (r1 > r6) goto L1d
            r5 = 0
            monitor-exit(r4)
            return r5
        L1d:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L74
            r1.<init>()     // Catch: java.lang.Throwable -> L74
        L22:
            com.facebook.imagepipeline.cache.h<K, com.facebook.imagepipeline.cache.i$a<K, V>> r2 = r4.b     // Catch: java.lang.Throwable -> L74
            int r2 = r2.c()     // Catch: java.lang.Throwable -> L74
            if (r2 > r5) goto L35
            com.facebook.imagepipeline.cache.h<K, com.facebook.imagepipeline.cache.i$a<K, V>> r2 = r4.b     // Catch: java.lang.Throwable -> L74
            int r2 = r2.e()     // Catch: java.lang.Throwable -> L74
            if (r2 <= r6) goto L33
            goto L35
        L33:
            monitor-exit(r4)
            return r1
        L35:
            com.facebook.imagepipeline.cache.h<K, com.facebook.imagepipeline.cache.i$a<K, V>> r2 = r4.b     // Catch: java.lang.Throwable -> L74
            java.lang.Object r2 = r2.d()     // Catch: java.lang.Throwable -> L74
            if (r2 == 0) goto L4c
            com.facebook.imagepipeline.cache.h<K, com.facebook.imagepipeline.cache.i$a<K, V>> r3 = r4.b     // Catch: java.lang.Throwable -> L74
            r3.h(r2)     // Catch: java.lang.Throwable -> L74
            com.facebook.imagepipeline.cache.h<K, com.facebook.imagepipeline.cache.i$a<K, V>> r3 = r4.c     // Catch: java.lang.Throwable -> L74
            java.lang.Object r2 = r3.h(r2)     // Catch: java.lang.Throwable -> L74
            r1.add(r2)     // Catch: java.lang.Throwable -> L74
            goto L22
        L4c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L74
            java.lang.String r6 = "key is null, but exclusiveEntries count: %d, size: %d"
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L74
            com.facebook.imagepipeline.cache.h<K, com.facebook.imagepipeline.cache.i$a<K, V>> r2 = r4.b     // Catch: java.lang.Throwable -> L74
            int r2 = r2.c()     // Catch: java.lang.Throwable -> L74
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L74
            r1[r0] = r2     // Catch: java.lang.Throwable -> L74
            r0 = 1
            com.facebook.imagepipeline.cache.h<K, com.facebook.imagepipeline.cache.i$a<K, V>> r2 = r4.b     // Catch: java.lang.Throwable -> L74
            int r2 = r2.e()     // Catch: java.lang.Throwable -> L74
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L74
            r1[r0] = r2     // Catch: java.lang.Throwable -> L74
            java.lang.String r6 = java.lang.String.format(r6, r1)     // Catch: java.lang.Throwable -> L74
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L74
            throw r5     // Catch: java.lang.Throwable -> L74
        L74:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.cache.q.x(int, int):java.util.ArrayList");
    }

    private v<i.a<K, V>> y(v<V> vVar) {
        return new a(this, vVar);
    }

    @Override // com.facebook.imagepipeline.cache.r
    public void a(K k2) {
        com.facebook.common.internal.h.g(k2);
        synchronized (this) {
            i.a<K, V> h2 = this.b.h(k2);
            if (h2 != null) {
                this.b.g(k2, h2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.cache.r
    @Nullable
    public com.facebook.common.references.a<V> b(K k2, com.facebook.common.references.a<V> aVar) {
        return c(k2, aVar, this.a);
    }

    @Override // com.facebook.imagepipeline.cache.i
    @Nullable
    public com.facebook.common.references.a<V> c(K k2, com.facebook.common.references.a<V> aVar, @Nullable i.b<K> bVar) {
        i.a<K, V> h2;
        com.facebook.common.references.a<V> aVar2;
        com.facebook.common.references.a<V> aVar3;
        com.facebook.common.internal.h.g(k2);
        com.facebook.common.internal.h.g(aVar);
        t();
        synchronized (this) {
            h2 = this.b.h(k2);
            i.a<K, V> h3 = this.c.h(k2);
            aVar2 = null;
            if (h3 != null) {
                l(h3);
                aVar3 = v(h3);
            } else {
                aVar3 = null;
            }
            if (g(aVar.A())) {
                i.a<K, V> a2 = i.a.a(k2, aVar, bVar);
                this.c.g(k2, a2);
                aVar2 = u(a2);
            }
        }
        com.facebook.common.references.a.y(aVar3);
        r(h2);
        p();
        return aVar2;
    }

    @Override // com.facebook.imagepipeline.cache.r
    public synchronized boolean contains(K k2) {
        return this.c.a(k2);
    }

    @Override // com.facebook.imagepipeline.cache.r
    public int d(com.facebook.common.internal.i<K> iVar) {
        ArrayList<i.a<K, V>> i2;
        ArrayList<i.a<K, V>> i3;
        synchronized (this) {
            i2 = this.b.i(iVar);
            i3 = this.c.i(iVar);
            m(i3);
        }
        o(i3);
        s(i2);
        t();
        p();
        return i3.size();
    }

    @Override // com.facebook.imagepipeline.cache.i
    @Nullable
    public com.facebook.common.references.a<V> e(K k2) {
        i.a<K, V> h2;
        boolean z;
        com.facebook.common.references.a<V> aVar;
        com.facebook.common.internal.h.g(k2);
        synchronized (this) {
            h2 = this.b.h(k2);
            z = true;
            if (h2 != null) {
                i.a<K, V> h3 = this.c.h(k2);
                com.facebook.common.internal.h.g(h3);
                com.facebook.common.internal.h.i(h3.c == 0);
                aVar = h3.b;
            } else {
                aVar = null;
                z = false;
            }
        }
        if (z) {
            r(h2);
        }
        return aVar;
    }

    @Override // com.facebook.imagepipeline.cache.r
    @Nullable
    public com.facebook.common.references.a<V> get(K k2) {
        i.a<K, V> h2;
        com.facebook.common.references.a<V> u;
        com.facebook.common.internal.h.g(k2);
        synchronized (this) {
            h2 = this.b.h(k2);
            i.a<K, V> b2 = this.c.b(k2);
            u = b2 != null ? u(b2) : null;
        }
        r(h2);
        t();
        p();
        return u;
    }

    public synchronized int i() {
        return this.c.c() - this.b.c();
    }

    public synchronized int j() {
        return this.c.e() - this.b.e();
    }

    public void p() {
        ArrayList<i.a<K, V>> x;
        synchronized (this) {
            s sVar = this.f2695f;
            int min = Math.min(sVar.f2697d, sVar.b - i());
            s sVar2 = this.f2695f;
            x = x(min, Math.min(sVar2.c, sVar2.a - j()));
            m(x);
        }
        o(x);
        s(x);
    }
}
