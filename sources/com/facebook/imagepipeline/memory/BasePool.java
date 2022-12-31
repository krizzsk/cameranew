package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.VisibleForTesting;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
/* loaded from: classes.dex */
public abstract class BasePool<V> implements com.facebook.common.memory.d<V> {
    private final Class<?> a;
    final com.facebook.common.memory.c b;
    final c0 c;
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    final SparseArray<f<V>> f2819d;
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    final Set<V> f2820e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2821f;
    @GuardedBy("this")
    @VisibleForTesting

    /* renamed from: g  reason: collision with root package name */
    final a f2822g;
    @GuardedBy("this")
    @VisibleForTesting

    /* renamed from: h  reason: collision with root package name */
    final a f2823h;

    /* renamed from: i  reason: collision with root package name */
    private final d0 f2824i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2825j;

    /* loaded from: classes.dex */
    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
        }
    }

    /* loaded from: classes.dex */
    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object obj) {
            super("Invalid value: " + obj.toString());
        }
    }

    /* loaded from: classes.dex */
    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i2, int i3, int i4, int i5) {
            super("Pool hard cap violation? Hard cap = " + i2 + " Used size = " + i3 + " Free size = " + i4 + " Request size = " + i5);
        }
    }

    /* loaded from: classes.dex */
    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NotThreadSafe
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class a {
        int a;
        int b;

        a() {
        }

        public void a(int i2) {
            int i3;
            int i4 = this.b;
            if (i4 >= i2 && (i3 = this.a) > 0) {
                this.a = i3 - 1;
                this.b = i4 - i2;
                return;
            }
            com.facebook.common.logging.a.C("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i2), Integer.valueOf(this.b), Integer.valueOf(this.a));
        }

        public void b(int i2) {
            this.a++;
            this.b += i2;
        }
    }

    public BasePool(com.facebook.common.memory.c cVar, c0 c0Var, d0 d0Var) {
        this.a = getClass();
        com.facebook.common.internal.h.g(cVar);
        this.b = cVar;
        com.facebook.common.internal.h.g(c0Var);
        c0 c0Var2 = c0Var;
        this.c = c0Var2;
        com.facebook.common.internal.h.g(d0Var);
        this.f2824i = d0Var;
        this.f2819d = new SparseArray<>();
        if (c0Var2.f2852d) {
            q();
        } else {
            u(new SparseIntArray(0));
        }
        this.f2820e = com.facebook.common.internal.j.b();
        this.f2823h = new a();
        this.f2822g = new a();
    }

    private synchronized void h() {
        boolean z;
        if (s() && this.f2823h.b != 0) {
            z = false;
            com.facebook.common.internal.h.i(z);
        }
        z = true;
        com.facebook.common.internal.h.i(z);
    }

    private void i(SparseIntArray sparseIntArray) {
        this.f2819d.clear();
        for (int i2 = 0; i2 < sparseIntArray.size(); i2++) {
            int keyAt = sparseIntArray.keyAt(i2);
            this.f2819d.put(keyAt, new f<>(o(keyAt), sparseIntArray.valueAt(i2), 0, this.c.f2852d));
        }
    }

    @Nullable
    private synchronized f<V> l(int i2) {
        return this.f2819d.get(i2);
    }

    private synchronized void q() {
        SparseIntArray sparseIntArray = this.c.c;
        if (sparseIntArray != null) {
            i(sparseIntArray);
            this.f2821f = false;
        } else {
            this.f2821f = true;
        }
    }

    private synchronized void u(SparseIntArray sparseIntArray) {
        com.facebook.common.internal.h.g(sparseIntArray);
        this.f2819d.clear();
        SparseIntArray sparseIntArray2 = this.c.c;
        if (sparseIntArray2 != null) {
            for (int i2 = 0; i2 < sparseIntArray2.size(); i2++) {
                int keyAt = sparseIntArray2.keyAt(i2);
                this.f2819d.put(keyAt, new f<>(o(keyAt), sparseIntArray2.valueAt(i2), sparseIntArray.get(keyAt, 0), this.c.f2852d));
            }
            this.f2821f = false;
        } else {
            this.f2821f = true;
        }
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void v() {
        if (com.facebook.common.logging.a.m(2)) {
            com.facebook.common.logging.a.s(this.a, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.f2822g.a), Integer.valueOf(this.f2822g.b), Integer.valueOf(this.f2823h.a), Integer.valueOf(this.f2823h.b));
        }
    }

    protected abstract V f(int i2);

    @VisibleForTesting
    synchronized boolean g(int i2) {
        if (this.f2825j) {
            return true;
        }
        c0 c0Var = this.c;
        int i3 = c0Var.a;
        int i4 = this.f2822g.b;
        if (i2 > i3 - i4) {
            this.f2824i.g();
            return false;
        }
        int i5 = c0Var.b;
        if (i2 > i5 - (i4 + this.f2823h.b)) {
            x(i5 - i2);
        }
        if (i2 > i3 - (this.f2822g.b + this.f2823h.b)) {
            this.f2824i.g();
            return false;
        }
        return true;
    }

    @Override // com.facebook.common.memory.d
    public V get(int i2) {
        V p;
        h();
        int m = m(i2);
        synchronized (this) {
            f<V> k2 = k(m);
            if (k2 != null && (p = p(k2)) != null) {
                com.facebook.common.internal.h.i(this.f2820e.add(p));
                int n = n(p);
                int o = o(n);
                this.f2822g.b(o);
                this.f2823h.a(o);
                this.f2824i.e(o);
                v();
                if (com.facebook.common.logging.a.m(2)) {
                    com.facebook.common.logging.a.q(this.a, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(p)), Integer.valueOf(n));
                }
                return p;
            }
            int o2 = o(m);
            if (g(o2)) {
                this.f2822g.b(o2);
                if (k2 != null) {
                    k2.e();
                }
                V v = null;
                try {
                    v = f(m);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f2822g.a(o2);
                        f<V> k3 = k(m);
                        if (k3 != null) {
                            k3.b();
                        }
                        com.facebook.common.internal.m.c(th);
                    }
                }
                synchronized (this) {
                    com.facebook.common.internal.h.i(this.f2820e.add(v));
                    y();
                    this.f2824i.d(o2);
                    v();
                    if (com.facebook.common.logging.a.m(2)) {
                        com.facebook.common.logging.a.q(this.a, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(m));
                    }
                }
                return v;
            }
            throw new PoolSizeViolationException(this.c.a, this.f2822g.b, this.f2823h.b, o2);
        }
    }

    @VisibleForTesting
    protected abstract void j(V v);

    @Nullable
    @VisibleForTesting
    synchronized f<V> k(int i2) {
        f<V> fVar = this.f2819d.get(i2);
        if (fVar == null && this.f2821f) {
            if (com.facebook.common.logging.a.m(2)) {
                com.facebook.common.logging.a.p(this.a, "creating new bucket %s", Integer.valueOf(i2));
            }
            f<V> w = w(i2);
            this.f2819d.put(i2, w);
            return w;
        }
        return fVar;
    }

    protected abstract int m(int i2);

    protected abstract int n(V v);

    protected abstract int o(int i2);

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public synchronized V p(f<V> fVar) {
        return fVar.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
        this.b.a(this);
        this.f2824i.f(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0080, code lost:
        r2.b();
     */
    @Override // com.facebook.common.memory.d, com.facebook.common.references.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void release(V r8) {
        /*
            r7 = this;
            com.facebook.common.internal.h.g(r8)
            int r0 = r7.n(r8)
            int r1 = r7.o(r0)
            monitor-enter(r7)
            com.facebook.imagepipeline.memory.f r2 = r7.l(r0)     // Catch: java.lang.Throwable -> Lae
            java.util.Set<V> r3 = r7.f2820e     // Catch: java.lang.Throwable -> Lae
            boolean r3 = r3.remove(r8)     // Catch: java.lang.Throwable -> Lae
            r4 = 2
            if (r3 != 0) goto L3d
            java.lang.Class<?> r2 = r7.a     // Catch: java.lang.Throwable -> Lae
            java.lang.String r3 = "release (free, value unrecognized) (object, size) = (%x, %s)"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> Lae
            r5 = 0
            int r6 = java.lang.System.identityHashCode(r8)     // Catch: java.lang.Throwable -> Lae
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> Lae
            r4[r5] = r6     // Catch: java.lang.Throwable -> Lae
            r5 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> Lae
            r4[r5] = r0     // Catch: java.lang.Throwable -> Lae
            com.facebook.common.logging.a.f(r2, r3, r4)     // Catch: java.lang.Throwable -> Lae
            r7.j(r8)     // Catch: java.lang.Throwable -> Lae
            com.facebook.imagepipeline.memory.d0 r8 = r7.f2824i     // Catch: java.lang.Throwable -> Lae
            r8.b(r1)     // Catch: java.lang.Throwable -> Lae
            goto La9
        L3d:
            if (r2 == 0) goto L7e
            boolean r3 = r2.f()     // Catch: java.lang.Throwable -> Lae
            if (r3 != 0) goto L7e
            boolean r3 = r7.s()     // Catch: java.lang.Throwable -> Lae
            if (r3 != 0) goto L7e
            boolean r3 = r7.t(r8)     // Catch: java.lang.Throwable -> Lae
            if (r3 != 0) goto L52
            goto L7e
        L52:
            r2.h(r8)     // Catch: java.lang.Throwable -> Lae
            com.facebook.imagepipeline.memory.BasePool$a r2 = r7.f2823h     // Catch: java.lang.Throwable -> Lae
            r2.b(r1)     // Catch: java.lang.Throwable -> Lae
            com.facebook.imagepipeline.memory.BasePool$a r2 = r7.f2822g     // Catch: java.lang.Throwable -> Lae
            r2.a(r1)     // Catch: java.lang.Throwable -> Lae
            com.facebook.imagepipeline.memory.d0 r2 = r7.f2824i     // Catch: java.lang.Throwable -> Lae
            r2.c(r1)     // Catch: java.lang.Throwable -> Lae
            boolean r1 = com.facebook.common.logging.a.m(r4)     // Catch: java.lang.Throwable -> Lae
            if (r1 == 0) goto La9
            java.lang.Class<?> r1 = r7.a     // Catch: java.lang.Throwable -> Lae
            java.lang.String r2 = "release (reuse) (object, size) = (%x, %s)"
            int r8 = java.lang.System.identityHashCode(r8)     // Catch: java.lang.Throwable -> Lae
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> Lae
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> Lae
            com.facebook.common.logging.a.q(r1, r2, r8, r0)     // Catch: java.lang.Throwable -> Lae
            goto La9
        L7e:
            if (r2 == 0) goto L83
            r2.b()     // Catch: java.lang.Throwable -> Lae
        L83:
            boolean r2 = com.facebook.common.logging.a.m(r4)     // Catch: java.lang.Throwable -> Lae
            if (r2 == 0) goto L9c
            java.lang.Class<?> r2 = r7.a     // Catch: java.lang.Throwable -> Lae
            java.lang.String r3 = "release (free) (object, size) = (%x, %s)"
            int r4 = java.lang.System.identityHashCode(r8)     // Catch: java.lang.Throwable -> Lae
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> Lae
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> Lae
            com.facebook.common.logging.a.q(r2, r3, r4, r0)     // Catch: java.lang.Throwable -> Lae
        L9c:
            r7.j(r8)     // Catch: java.lang.Throwable -> Lae
            com.facebook.imagepipeline.memory.BasePool$a r8 = r7.f2822g     // Catch: java.lang.Throwable -> Lae
            r8.a(r1)     // Catch: java.lang.Throwable -> Lae
            com.facebook.imagepipeline.memory.d0 r8 = r7.f2824i     // Catch: java.lang.Throwable -> Lae
            r8.b(r1)     // Catch: java.lang.Throwable -> Lae
        La9:
            r7.v()     // Catch: java.lang.Throwable -> Lae
            monitor-exit(r7)     // Catch: java.lang.Throwable -> Lae
            return
        Lae:
            r8 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> Lae
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.BasePool.release(java.lang.Object):void");
    }

    @VisibleForTesting
    synchronized boolean s() {
        boolean z;
        z = this.f2822g.b + this.f2823h.b > this.c.b;
        if (z) {
            this.f2824i.a();
        }
        return z;
    }

    protected boolean t(V v) {
        com.facebook.common.internal.h.g(v);
        return true;
    }

    f<V> w(int i2) {
        return new f<>(o(i2), Integer.MAX_VALUE, 0, this.c.f2852d);
    }

    @VisibleForTesting
    synchronized void x(int i2) {
        int i3 = this.f2822g.b;
        int i4 = this.f2823h.b;
        int min = Math.min((i3 + i4) - i2, i4);
        if (min <= 0) {
            return;
        }
        if (com.facebook.common.logging.a.m(2)) {
            com.facebook.common.logging.a.r(this.a, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i2), Integer.valueOf(this.f2822g.b + this.f2823h.b), Integer.valueOf(min));
        }
        v();
        for (int i5 = 0; i5 < this.f2819d.size() && min > 0; i5++) {
            f<V> valueAt = this.f2819d.valueAt(i5);
            com.facebook.common.internal.h.g(valueAt);
            f<V> fVar = valueAt;
            while (min > 0) {
                V g2 = fVar.g();
                if (g2 == null) {
                    break;
                }
                j(g2);
                int i6 = fVar.a;
                min -= i6;
                this.f2823h.a(i6);
            }
        }
        v();
        if (com.facebook.common.logging.a.m(2)) {
            com.facebook.common.logging.a.q(this.a, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i2), Integer.valueOf(this.f2822g.b + this.f2823h.b));
        }
    }

    @VisibleForTesting
    synchronized void y() {
        if (s()) {
            x(this.c.b);
        }
    }

    public BasePool(com.facebook.common.memory.c cVar, c0 c0Var, d0 d0Var, boolean z) {
        this(cVar, c0Var, d0Var);
        this.f2825j = z;
    }
}
