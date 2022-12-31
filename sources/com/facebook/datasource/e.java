package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.g;
import com.facebook.common.internal.h;
import com.facebook.common.internal.k;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: FirstAvailableDataSourceSupplier.java */
@ThreadSafe
/* loaded from: classes.dex */
public class e<T> implements k<com.facebook.datasource.b<T>> {
    private final List<k<com.facebook.datasource.b<T>>> a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FirstAvailableDataSourceSupplier.java */
    @ThreadSafe
    /* loaded from: classes.dex */
    public class b extends AbstractDataSource<T> {

        /* renamed from: i  reason: collision with root package name */
        private int f2433i = 0;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        private com.facebook.datasource.b<T> f2434j = null;
        @Nullable

        /* renamed from: k  reason: collision with root package name */
        private com.facebook.datasource.b<T> f2435k = null;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: FirstAvailableDataSourceSupplier.java */
        /* loaded from: classes.dex */
        public class a implements d<T> {
            private a() {
            }

            @Override // com.facebook.datasource.d
            public void a(com.facebook.datasource.b<T> bVar) {
            }

            @Override // com.facebook.datasource.d
            public void b(com.facebook.datasource.b<T> bVar) {
                b.this.C(bVar);
            }

            @Override // com.facebook.datasource.d
            public void c(com.facebook.datasource.b<T> bVar) {
                if (bVar.a()) {
                    b.this.D(bVar);
                } else if (bVar.b()) {
                    b.this.C(bVar);
                }
            }

            @Override // com.facebook.datasource.d
            public void d(com.facebook.datasource.b<T> bVar) {
                b.this.q(Math.max(b.this.getProgress(), bVar.getProgress()));
            }
        }

        public b() {
            if (F()) {
                return;
            }
            n(new RuntimeException("No data source supplier or supplier returned null."));
        }

        @Nullable
        private synchronized k<com.facebook.datasource.b<T>> A() {
            if (i() || this.f2433i >= e.this.a.size()) {
                return null;
            }
            List list = e.this.a;
            int i2 = this.f2433i;
            this.f2433i = i2 + 1;
            return (k) list.get(i2);
        }

        private void B(com.facebook.datasource.b<T> bVar, boolean z) {
            com.facebook.datasource.b<T> bVar2;
            synchronized (this) {
                if (bVar == this.f2434j && bVar != (bVar2 = this.f2435k)) {
                    if (bVar2 != null && !z) {
                        bVar2 = null;
                        y(bVar2);
                    }
                    this.f2435k = bVar;
                    y(bVar2);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C(com.facebook.datasource.b<T> bVar) {
            if (x(bVar)) {
                if (bVar != z()) {
                    y(bVar);
                }
                if (F()) {
                    return;
                }
                o(bVar.c(), bVar.getExtras());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D(com.facebook.datasource.b<T> bVar) {
            B(bVar, bVar.b());
            if (bVar == z()) {
                s(null, bVar.b(), bVar.getExtras());
            }
        }

        private synchronized boolean E(com.facebook.datasource.b<T> bVar) {
            if (i()) {
                return false;
            }
            this.f2434j = bVar;
            return true;
        }

        private boolean F() {
            k<com.facebook.datasource.b<T>> A = A();
            com.facebook.datasource.b<T> bVar = A != null ? A.get() : null;
            if (E(bVar) && bVar != null) {
                bVar.d(new a(), CallerThreadExecutor.getInstance());
                return true;
            }
            y(bVar);
            return false;
        }

        private synchronized boolean x(com.facebook.datasource.b<T> bVar) {
            if (!i() && bVar == this.f2434j) {
                this.f2434j = null;
                return true;
            }
            return false;
        }

        private void y(@Nullable com.facebook.datasource.b<T> bVar) {
            if (bVar != null) {
                bVar.close();
            }
        }

        @Nullable
        private synchronized com.facebook.datasource.b<T> z() {
            return this.f2435k;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public synchronized boolean a() {
            boolean z;
            com.facebook.datasource.b<T> z2 = z();
            if (z2 != null) {
                z = z2.a();
            }
            return z;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        public boolean close() {
            synchronized (this) {
                if (super.close()) {
                    com.facebook.datasource.b<T> bVar = this.f2434j;
                    this.f2434j = null;
                    com.facebook.datasource.b<T> bVar2 = this.f2435k;
                    this.f2435k = null;
                    y(bVar2);
                    y(bVar);
                    return true;
                }
                return false;
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
        @Nullable
        public synchronized T getResult() {
            com.facebook.datasource.b<T> z;
            z = z();
            return z != null ? z.getResult() : null;
        }
    }

    private e(List<k<com.facebook.datasource.b<T>>> list) {
        h.c(!list.isEmpty(), "List of suppliers is empty!");
        this.a = list;
    }

    public static <T> e<T> b(List<k<com.facebook.datasource.b<T>>> list) {
        return new e<>(list);
    }

    @Override // com.facebook.common.internal.k
    /* renamed from: c */
    public com.facebook.datasource.b<T> get() {
        return new b();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            return com.facebook.common.internal.g.a(this.a, ((e) obj).a);
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
