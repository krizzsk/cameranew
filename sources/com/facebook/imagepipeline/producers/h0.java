package com.facebook.imagepipeline.producers;

import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.facebook.common.util.TriState;
import com.facebook.imagepipeline.common.Priority;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: MultiplexProducer.java */
@ThreadSafe
/* loaded from: classes.dex */
public abstract class h0<K, T extends Closeable> implements n0<T> {
    @GuardedBy("this")
    @VisibleForTesting
    final Map<K, h0<K, T>.b> a;
    private final n0<T> b;
    private final boolean c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2908d;

    /* renamed from: e  reason: collision with root package name */
    private final String f2909e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Field signature parse error: a
    jadx.core.utils.exceptions.JadxRuntimeException: Can't parse type: TK at position 1 ('K'), unexpected: T
    	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:169)
    	at jadx.core.dex.visitors.SignatureProcessor.parseFieldSignature(SignatureProcessor.java:83)
    	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:33)
     */
    /* compiled from: MultiplexProducer.java */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public class b {
        private final Object a;
        private final CopyOnWriteArraySet<Pair<l<T>, o0>> b = com.facebook.common.internal.j.a();
        @GuardedBy("Multiplexer.this")
        @Nullable
        private T c;
        @GuardedBy("Multiplexer.this")

        /* renamed from: d  reason: collision with root package name */
        private float f2910d;
        @GuardedBy("Multiplexer.this")

        /* renamed from: e  reason: collision with root package name */
        private int f2911e;
        @GuardedBy("Multiplexer.this")
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private d f2912f;
        @GuardedBy("Multiplexer.this")
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private h0<K, T>.b.C0102b f2913g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MultiplexProducer.java */
        /* loaded from: classes.dex */
        public class a extends e {
            final /* synthetic */ Pair a;

            a(Pair pair) {
                this.a = pair;
            }

            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.p0
            public void a() {
                d.q(b.this.r());
            }

            @Override // com.facebook.imagepipeline.producers.p0
            public void b() {
                boolean remove;
                List list;
                d dVar;
                List list2;
                List list3;
                synchronized (b.this) {
                    remove = b.this.b.remove(this.a);
                    list = null;
                    if (!remove) {
                        dVar = null;
                        list2 = null;
                    } else if (b.this.b.isEmpty()) {
                        dVar = b.this.f2912f;
                        list2 = null;
                    } else {
                        List s = b.this.s();
                        list2 = b.this.t();
                        list3 = b.this.r();
                        dVar = null;
                        list = s;
                    }
                    list3 = list2;
                }
                d.r(list);
                d.s(list2);
                d.q(list3);
                if (dVar != null) {
                    if (h0.this.c && !dVar.m()) {
                        d.s(dVar.x(Priority.LOW));
                    } else {
                        dVar.t();
                    }
                }
                if (remove) {
                    ((l) this.a.first).a();
                }
            }

            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.p0
            public void c() {
                d.s(b.this.t());
            }

            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.p0
            public void d() {
                d.r(b.this.s());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: MultiplexProducer.java */
        /* renamed from: com.facebook.imagepipeline.producers.h0$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0102b extends com.facebook.imagepipeline.producers.b<T> {
            private C0102b() {
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void f() {
                try {
                    if (com.facebook.imagepipeline.f.b.d()) {
                        com.facebook.imagepipeline.f.b.a("MultiplexProducer#onCancellation");
                    }
                    b.this.m(this);
                } finally {
                    if (com.facebook.imagepipeline.f.b.d()) {
                        com.facebook.imagepipeline.f.b.b();
                    }
                }
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void g(Throwable th) {
                try {
                    if (com.facebook.imagepipeline.f.b.d()) {
                        com.facebook.imagepipeline.f.b.a("MultiplexProducer#onFailure");
                    }
                    b.this.n(this, th);
                } finally {
                    if (com.facebook.imagepipeline.f.b.d()) {
                        com.facebook.imagepipeline.f.b.b();
                    }
                }
            }

            @Override // com.facebook.imagepipeline.producers.b
            protected void i(float f2) {
                try {
                    if (com.facebook.imagepipeline.f.b.d()) {
                        com.facebook.imagepipeline.f.b.a("MultiplexProducer#onProgressUpdate");
                    }
                    b.this.p(this, f2);
                } finally {
                    if (com.facebook.imagepipeline.f.b.d()) {
                        com.facebook.imagepipeline.f.b.b();
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.b
            /* renamed from: o */
            public void h(@Nullable T t, int i2) {
                try {
                    if (com.facebook.imagepipeline.f.b.d()) {
                        com.facebook.imagepipeline.f.b.a("MultiplexProducer#onNewResult");
                    }
                    b.this.o(this, t, i2);
                } finally {
                    if (com.facebook.imagepipeline.f.b.d()) {
                        com.facebook.imagepipeline.f.b.b();
                    }
                }
            }
        }

        public b(K k2) {
            this.a = k2;
        }

        private void g(Pair<l<T>, o0> pair, o0 o0Var) {
            o0Var.c(new a(pair));
        }

        private void i(@Nullable Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }

        private synchronized boolean j() {
            Iterator<Pair<l<T>, o0>> it = this.b.iterator();
            while (it.hasNext()) {
                if (((o0) it.next().second).i()) {
                    return true;
                }
            }
            return false;
        }

        private synchronized boolean k() {
            Iterator<Pair<l<T>, o0>> it = this.b.iterator();
            while (it.hasNext()) {
                if (!((o0) it.next().second).m()) {
                    return false;
                }
            }
            return true;
        }

        private synchronized Priority l() {
            Priority priority;
            priority = Priority.LOW;
            Iterator<Pair<l<T>, o0>> it = this.b.iterator();
            while (it.hasNext()) {
                priority = Priority.getHigherPriority(priority, ((o0) it.next().second).getPriority());
            }
            return priority;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void q(TriState triState) {
            synchronized (this) {
                boolean z = true;
                com.facebook.common.internal.h.b(Boolean.valueOf(this.f2912f == null));
                if (this.f2913g != null) {
                    z = false;
                }
                com.facebook.common.internal.h.b(Boolean.valueOf(z));
                if (this.b.isEmpty()) {
                    h0.this.k(this.a, this);
                    return;
                }
                o0 o0Var = (o0) this.b.iterator().next().second;
                d dVar = new d(o0Var.j(), o0Var.getId(), o0Var.h(), o0Var.a(), o0Var.o(), k(), j(), l(), o0Var.d());
                this.f2912f = dVar;
                dVar.l(o0Var.getExtras());
                if (triState.isSet()) {
                    this.f2912f.b("started_as_prefetch", Boolean.valueOf(triState.asBoolean()));
                }
                h0<K, T>.b.C0102b c0102b = new C0102b();
                this.f2913g = c0102b;
                h0.this.b.b(c0102b, this.f2912f);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<p0> r() {
            d dVar = this.f2912f;
            if (dVar == null) {
                return null;
            }
            return dVar.v(j());
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<p0> s() {
            d dVar = this.f2912f;
            if (dVar == null) {
                return null;
            }
            return dVar.w(k());
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public synchronized List<p0> t() {
            d dVar = this.f2912f;
            if (dVar == null) {
                return null;
            }
            return dVar.x(l());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean h(l<T> lVar, o0 o0Var) {
            Pair<l<T>, o0> create = Pair.create(lVar, o0Var);
            synchronized (this) {
                if (h0.this.i(this.a) != this) {
                    return false;
                }
                this.b.add(create);
                List<p0> s = s();
                List<p0> t = t();
                List<p0> r = r();
                Closeable closeable = this.c;
                float f2 = this.f2910d;
                int i2 = this.f2911e;
                d.r(s);
                d.s(t);
                d.q(r);
                synchronized (create) {
                    synchronized (this) {
                        if (closeable != this.c) {
                            closeable = null;
                        } else if (closeable != null) {
                            closeable = h0.this.g(closeable);
                        }
                    }
                    if (closeable != null) {
                        if (f2 > 0.0f) {
                            lVar.b(f2);
                        }
                        lVar.c(closeable, i2);
                        i(closeable);
                    }
                }
                g(create, o0Var);
                return true;
            }
        }

        public void m(h0<K, T>.b.C0102b c0102b) {
            synchronized (this) {
                if (this.f2913g != c0102b) {
                    return;
                }
                this.f2913g = null;
                this.f2912f = null;
                i(this.c);
                this.c = null;
                q(TriState.UNSET);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void n(h0<K, T>.b.C0102b c0102b, Throwable th) {
            synchronized (this) {
                if (this.f2913g != c0102b) {
                    return;
                }
                Iterator<Pair<l<T>, o0>> it = this.b.iterator();
                this.b.clear();
                h0.this.k(this.a, this);
                i(this.c);
                this.c = null;
                while (it.hasNext()) {
                    Pair<l<T>, o0> next = it.next();
                    synchronized (next) {
                        ((o0) next.second).h().k((o0) next.second, h0.this.f2908d, th, null);
                        ((l) next.first).onFailure(th);
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void o(h0<K, T>.b.C0102b c0102b, @Nullable T t, int i2) {
            synchronized (this) {
                if (this.f2913g != c0102b) {
                    return;
                }
                i(this.c);
                this.c = null;
                Iterator<Pair<l<T>, o0>> it = this.b.iterator();
                int size = this.b.size();
                if (com.facebook.imagepipeline.producers.b.e(i2)) {
                    this.c = (T) h0.this.g(t);
                    this.f2911e = i2;
                } else {
                    this.b.clear();
                    h0.this.k(this.a, this);
                }
                while (it.hasNext()) {
                    Pair<l<T>, o0> next = it.next();
                    synchronized (next) {
                        if (com.facebook.imagepipeline.producers.b.d(i2)) {
                            ((o0) next.second).h().j((o0) next.second, h0.this.f2908d, null);
                            d dVar = this.f2912f;
                            if (dVar != null) {
                                ((o0) next.second).l(dVar.getExtras());
                            }
                            ((o0) next.second).b(h0.this.f2909e, Integer.valueOf(size));
                        }
                        ((l) next.first).c(t, i2);
                    }
                }
            }
        }

        public void p(h0<K, T>.b.C0102b c0102b, float f2) {
            synchronized (this) {
                if (this.f2913g != c0102b) {
                    return;
                }
                this.f2910d = f2;
                Iterator<Pair<l<T>, o0>> it = this.b.iterator();
                while (it.hasNext()) {
                    Pair<l<T>, o0> next = it.next();
                    synchronized (next) {
                        ((l) next.first).b(f2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h0(n0<T> n0Var, String str, String str2) {
        this(n0Var, str, str2, false);
    }

    private synchronized h0<K, T>.b h(K k2) {
        h0<K, T>.b bVar;
        bVar = new b(k2);
        this.a.put(k2, bVar);
        return bVar;
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<T> lVar, o0 o0Var) {
        boolean z;
        h0<K, T>.b i2;
        try {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("MultiplexProducer#produceResults");
            }
            o0Var.h().d(o0Var, this.f2908d);
            K j2 = j(o0Var);
            do {
                z = false;
                synchronized (this) {
                    i2 = i(j2);
                    if (i2 == null) {
                        i2 = h(j2);
                        z = true;
                    }
                }
            } while (!i2.h(lVar, o0Var));
            if (z) {
                i2.q(TriState.valueOf(o0Var.m()));
            }
        } finally {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
    }

    @Nullable
    protected abstract T g(@Nullable T t);

    @Nullable
    protected synchronized h0<K, T>.b i(K k2) {
        return this.a.get(k2);
    }

    protected abstract K j(o0 o0Var);

    protected synchronized void k(K k2, h0<K, T>.b bVar) {
        if (this.a.get(k2) == bVar) {
            this.a.remove(k2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h0(n0<T> n0Var, String str, String str2, boolean z) {
        this.b = n0Var;
        this.a = new HashMap();
        this.c = z;
        this.f2908d = str;
        this.f2909e = str2;
    }
}
