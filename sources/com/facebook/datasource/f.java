package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.g;
import com.facebook.common.internal.h;
import com.facebook.common.internal.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: IncreasingQualityDataSourceSupplier.java */
@ThreadSafe
/* loaded from: classes.dex */
public class f<T> implements k<b<T>> {
    private final List<k<b<T>>> a;
    private final boolean b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IncreasingQualityDataSourceSupplier.java */
    @ThreadSafe
    /* loaded from: classes.dex */
    public class a extends AbstractDataSource<T> {
        @GuardedBy("IncreasingQualityDataSource.this")
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        private ArrayList<b<T>> f2437i;
        @GuardedBy("IncreasingQualityDataSource.this")

        /* renamed from: j  reason: collision with root package name */
        private int f2438j;

        /* renamed from: k  reason: collision with root package name */
        private int f2439k;

        /* renamed from: l  reason: collision with root package name */
        private AtomicInteger f2440l;
        @Nullable
        private Throwable m;
        @Nullable
        private Map<String, Object> n;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: IncreasingQualityDataSourceSupplier.java */
        /* renamed from: com.facebook.datasource.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0090a implements d<T> {
            private int a;

            public C0090a(int i2) {
                this.a = i2;
            }

            @Override // com.facebook.datasource.d
            public void a(b<T> bVar) {
            }

            @Override // com.facebook.datasource.d
            public void b(b<T> bVar) {
                a.this.E(this.a, bVar);
            }

            @Override // com.facebook.datasource.d
            public void c(b<T> bVar) {
                if (bVar.a()) {
                    a.this.F(this.a, bVar);
                } else if (bVar.b()) {
                    a.this.E(this.a, bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void d(b<T> bVar) {
                if (this.a == 0) {
                    a.this.q(bVar.getProgress());
                }
            }
        }

        public a() {
            if (f.this.b) {
                return;
            }
            y();
        }

        @Nullable
        private synchronized b<T> A(int i2) {
            ArrayList<b<T>> arrayList;
            arrayList = this.f2437i;
            return (arrayList == null || i2 >= arrayList.size()) ? null : this.f2437i.get(i2);
        }

        @Nullable
        private synchronized b<T> B() {
            return A(this.f2438j);
        }

        private void C() {
            Throwable th;
            if (this.f2440l.incrementAndGet() != this.f2439k || (th = this.m) == null) {
                return;
            }
            o(th, this.n);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0022 A[LOOP:0: B:17:0x0020->B:18:0x0022, LOOP_END] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void D(int r3, com.facebook.datasource.b<T> r4, boolean r5) {
            /*
                r2 = this;
                monitor-enter(r2)
                int r0 = r2.f2438j     // Catch: java.lang.Throwable -> L2f
                com.facebook.datasource.b r1 = r2.A(r3)     // Catch: java.lang.Throwable -> L2f
                if (r4 != r1) goto L2d
                int r4 = r2.f2438j     // Catch: java.lang.Throwable -> L2f
                if (r3 != r4) goto Le
                goto L2d
            Le:
                com.facebook.datasource.b r4 = r2.B()     // Catch: java.lang.Throwable -> L2f
                if (r4 == 0) goto L1d
                if (r5 == 0) goto L1b
                int r4 = r2.f2438j     // Catch: java.lang.Throwable -> L2f
                if (r3 >= r4) goto L1b
                goto L1d
            L1b:
                r3 = r0
                goto L1f
            L1d:
                r2.f2438j = r3     // Catch: java.lang.Throwable -> L2f
            L1f:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2f
            L20:
                if (r0 <= r3) goto L2c
                com.facebook.datasource.b r4 = r2.z(r0)
                r2.x(r4)
                int r0 = r0 + (-1)
                goto L20
            L2c:
                return
            L2d:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2f
                return
            L2f:
                r3 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2f
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.f.a.D(int, com.facebook.datasource.b, boolean):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E(int i2, b<T> bVar) {
            x(G(i2, bVar));
            if (i2 == 0) {
                this.m = bVar.c();
                this.n = bVar.getExtras();
            }
            C();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void F(int i2, b<T> bVar) {
            D(i2, bVar, bVar.b());
            if (bVar == B()) {
                s(null, i2 == 0 && bVar.b(), bVar.getExtras());
            }
            C();
        }

        @Nullable
        private synchronized b<T> G(int i2, b<T> bVar) {
            if (bVar == B()) {
                return null;
            }
            if (bVar == A(i2)) {
                return z(i2);
            }
            return bVar;
        }

        private void x(b<T> bVar) {
            if (bVar != null) {
                bVar.close();
            }
        }

        private void y() {
            if (this.f2440l != null) {
                return;
            }
            synchronized (this) {
                if (this.f2440l == null) {
                    this.f2440l = new AtomicInteger(0);
                    int size = f.this.a.size();
                    this.f2439k = size;
                    this.f2438j = size;
                    this.f2437i = new ArrayList<>(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        b<T> bVar = (b) ((k) f.this.a.get(i2)).get();
                        this.f2437i.add(bVar);
                        bVar.d(new C0090a(i2), CallerThreadExecutor.getInstance());
                        if (bVar.a()) {
                            break;
                        }
                    }
                }
            }
        }

        @Nullable
        private synchronized b<T> z(int i2) {
            b<T> bVar;
            ArrayList<b<T>> arrayList = this.f2437i;
            bVar = null;
            if (arrayList != null && i2 < arrayList.size()) {
                bVar = this.f2437i.set(i2, null);
            }
            return bVar;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean a() {
            boolean z;
            if (f.this.b) {
                y();
            }
            b<T> B = B();
            if (B != null) {
                z = B.a();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean close() {
            if (f.this.b) {
                y();
            }
            synchronized (this) {
                if (super.close()) {
                    ArrayList<b<T>> arrayList = this.f2437i;
                    this.f2437i = null;
                    if (arrayList != null) {
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            x(arrayList.get(i2));
                        }
                        return true;
                    }
                    return true;
                }
                return false;
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            b<T> B;
            if (f.this.b) {
                y();
            }
            B = B();
            return B != null ? B.getResult() : null;
        }
    }

    private f(List<k<b<T>>> list, boolean z) {
        h.c(!list.isEmpty(), "List of suppliers is empty!");
        this.a = list;
        this.b = z;
    }

    public static <T> f<T> c(List<k<b<T>>> list, boolean z) {
        return new f<>(list, z);
    }

    @Override // com.facebook.common.internal.k
    /* renamed from: d */
    public b<T> get() {
        return new a();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            return com.facebook.common.internal.g.a(this.a, ((f) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        g.b c = com.facebook.common.internal.g.c(this);
        c.b("list", this.a);
        return c.toString();
    }
}
