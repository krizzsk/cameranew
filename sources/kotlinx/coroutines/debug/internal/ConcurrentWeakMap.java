package kotlinx.coroutines.debug.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.collections.g;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.z.j;
import kotlinx.coroutines.internal.c0;
/* compiled from: ConcurrentWeakMap.kt */
/* loaded from: classes3.dex */
public final class ConcurrentWeakMap<K, V> extends kotlin.collections.f<K, V> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");
    private volatile /* synthetic */ int _size;
    private final ReferenceQueue<K> a;
    volatile /* synthetic */ Object core;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConcurrentWeakMap.kt */
    /* loaded from: classes3.dex */
    public final class a {

        /* renamed from: g  reason: collision with root package name */
        private static final /* synthetic */ AtomicIntegerFieldUpdater f8736g = AtomicIntegerFieldUpdater.newUpdater(a.class, TrackLoadSettingsAtom.TYPE);
        private final int a;
        private final int b;
        private final int c;

        /* renamed from: d  reason: collision with root package name */
        /* synthetic */ AtomicReferenceArray f8737d;

        /* renamed from: e  reason: collision with root package name */
        /* synthetic */ AtomicReferenceArray f8738e;
        private volatile /* synthetic */ int load = 0;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ConcurrentWeakMap.kt */
        /* renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C0323a<E> implements Iterator<E>, Object {
            private final p<K, V, E> a;
            private int b = -1;
            private K c;

            /* renamed from: d  reason: collision with root package name */
            private V f8740d;

            /* JADX WARN: Multi-variable type inference failed */
            public C0323a(p<? super K, ? super V, ? extends E> pVar) {
                this.a = pVar;
                a();
            }

            private final void a() {
                while (true) {
                    int i2 = this.b + 1;
                    this.b = i2;
                    if (i2 >= ((a) a.this).a) {
                        return;
                    }
                    d dVar = (d) a.this.f8737d.get(this.b);
                    K k2 = dVar == null ? null : (K) dVar.get();
                    if (k2 != null) {
                        this.c = k2;
                        V v = (V) a.this.f8738e.get(this.b);
                        if (v instanceof e) {
                            v = (V) ((e) v).a;
                        }
                        if (v != null) {
                            this.f8740d = v;
                            return;
                        }
                    }
                }
            }

            public Void b() {
                kotlinx.coroutines.debug.internal.a.c();
                throw null;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b < ((a) a.this).a;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.b < ((a) a.this).a) {
                    p<K, V, E> pVar = this.a;
                    K k2 = this.c;
                    if (k2 == null) {
                        s.z("key");
                        throw null;
                    }
                    V v = this.f8740d;
                    if (v == null) {
                        s.z(FirebaseAnalytics.Param.VALUE);
                        throw null;
                    }
                    E invoke = pVar.invoke(k2, v);
                    a();
                    return invoke;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public /* bridge */ /* synthetic */ void remove() {
                b();
                throw null;
            }
        }

        public a(int i2) {
            this.a = i2;
            this.b = Integer.numberOfLeadingZeros(i2) + 1;
            this.c = (i2 * 2) / 3;
            this.f8737d = new AtomicReferenceArray(i2);
            this.f8738e = new AtomicReferenceArray(i2);
        }

        private final int d(int i2) {
            return (i2 * (-1640531527)) >>> this.b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object g(a aVar, Object obj, Object obj2, d dVar, int i2, Object obj3) {
            if ((i2 & 4) != 0) {
                dVar = null;
            }
            return aVar.f(obj, obj2, dVar);
        }

        private final void i(int i2) {
            Object obj;
            do {
                obj = this.f8738e.get(i2);
                if (obj == null || (obj instanceof e)) {
                    return;
                }
            } while (!this.f8738e.compareAndSet(i2, obj, null));
            ConcurrentWeakMap.this.h();
        }

        public final void b(d<?> dVar) {
            int d2 = d(dVar.a);
            while (true) {
                d<?> dVar2 = (d) this.f8737d.get(d2);
                if (dVar2 == null) {
                    return;
                }
                if (dVar2 == dVar) {
                    i(d2);
                    return;
                }
                if (d2 == 0) {
                    d2 = this.a;
                }
                d2--;
            }
        }

        public final V c(K k2) {
            int d2 = d(k2.hashCode());
            while (true) {
                d dVar = (d) this.f8737d.get(d2);
                if (dVar == null) {
                    return null;
                }
                T t = dVar.get();
                if (s.c(k2, t)) {
                    V v = (V) this.f8738e.get(d2);
                    return v instanceof e ? (V) ((e) v).a : v;
                }
                if (t == 0) {
                    i(d2);
                }
                if (d2 == 0) {
                    d2 = this.a;
                }
                d2--;
            }
        }

        public final <E> Iterator<E> e(p<? super K, ? super V, ? extends E> pVar) {
            return new C0323a(pVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
            r6 = r5.f8738e.get(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
            if ((r6 instanceof kotlinx.coroutines.debug.internal.e) == false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
            r6 = kotlinx.coroutines.debug.internal.a.a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x006b, code lost:
            if (r5.f8738e.compareAndSet(r0, r6, r7) == false) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
            return r6;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object f(K r6, V r7, kotlinx.coroutines.debug.internal.d<K> r8) {
            /*
                r5 = this;
                int r0 = r6.hashCode()
                int r0 = r5.d(r0)
                r1 = 0
            L9:
                java.util.concurrent.atomic.AtomicReferenceArray r2 = r5.f8737d
                java.lang.Object r2 = r2.get(r0)
                kotlinx.coroutines.debug.internal.d r2 = (kotlinx.coroutines.debug.internal.d) r2
                if (r2 != 0) goto L45
                r2 = 0
                if (r7 != 0) goto L17
                return r2
            L17:
                if (r1 != 0) goto L2f
            L19:
                int r1 = r5.load
                int r3 = r5.c
                if (r1 < r3) goto L24
                kotlinx.coroutines.internal.c0 r6 = kotlinx.coroutines.debug.internal.a.a()
                return r6
            L24:
                int r3 = r1 + 1
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r4 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.a.f8736g
                boolean r1 = r4.compareAndSet(r5, r1, r3)
                if (r1 == 0) goto L19
                r1 = 1
            L2f:
                if (r8 != 0) goto L3c
                kotlinx.coroutines.debug.internal.d r8 = new kotlinx.coroutines.debug.internal.d
                kotlinx.coroutines.debug.internal.ConcurrentWeakMap<K, V> r3 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.this
                java.lang.ref.ReferenceQueue r3 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.f(r3)
                r8.<init>(r6, r3)
            L3c:
                java.util.concurrent.atomic.AtomicReferenceArray r3 = r5.f8737d
                boolean r2 = r3.compareAndSet(r0, r2, r8)
                if (r2 == 0) goto L9
                goto L56
            L45:
                java.lang.Object r2 = r2.get()
                boolean r3 = kotlin.jvm.internal.s.c(r6, r2)
                if (r3 == 0) goto L6e
                if (r1 == 0) goto L56
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r6 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.a.f8736g
                r6.decrementAndGet(r5)
            L56:
                java.util.concurrent.atomic.AtomicReferenceArray r6 = r5.f8738e
                java.lang.Object r6 = r6.get(r0)
                boolean r8 = r6 instanceof kotlinx.coroutines.debug.internal.e
                if (r8 == 0) goto L65
                kotlinx.coroutines.internal.c0 r6 = kotlinx.coroutines.debug.internal.a.a()
                return r6
            L65:
                java.util.concurrent.atomic.AtomicReferenceArray r8 = r5.f8738e
                boolean r8 = r8.compareAndSet(r0, r6, r7)
                if (r8 == 0) goto L56
                return r6
            L6e:
                if (r2 != 0) goto L73
                r5.i(r0)
            L73:
                if (r0 != 0) goto L77
                int r0 = r5.a
            L77:
                int r0 = r0 + (-1)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.ConcurrentWeakMap.a.f(java.lang.Object, java.lang.Object, kotlinx.coroutines.debug.internal.d):java.lang.Object");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final ConcurrentWeakMap<K, V>.a h() {
            int a;
            ConcurrentWeakMap<K, V>.a aVar;
            Object obj;
            c0 c0Var;
            e d2;
            loop0: while (true) {
                a = j.a(ConcurrentWeakMap.this.size(), 4);
                aVar = (ConcurrentWeakMap<K, V>.a) new a(Integer.highestOneBit(a) * 4);
                int i2 = 0;
                int i3 = this.a;
                if (i3 <= 0) {
                    break;
                }
                while (true) {
                    int i4 = i2 + 1;
                    d dVar = (d) this.f8737d.get(i2);
                    Object obj2 = dVar == null ? null : dVar.get();
                    if (dVar != null && obj2 == null) {
                        i(i2);
                    }
                    while (true) {
                        obj = this.f8738e.get(i2);
                        if (obj instanceof e) {
                            obj = ((e) obj).a;
                            break;
                        }
                        AtomicReferenceArray atomicReferenceArray = this.f8738e;
                        d2 = kotlinx.coroutines.debug.internal.a.d(obj);
                        if (atomicReferenceArray.compareAndSet(i2, obj, d2)) {
                            break;
                        }
                    }
                    if (obj2 != null && obj != null) {
                        Object f2 = aVar.f(obj2, obj, dVar);
                        c0Var = kotlinx.coroutines.debug.internal.a.a;
                        if (f2 == c0Var) {
                            break;
                        }
                    }
                    if (i4 >= i3) {
                        break loop0;
                    }
                    i2 = i4;
                }
            }
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConcurrentWeakMap.kt */
    /* loaded from: classes3.dex */
    public static final class b<K, V> implements Map.Entry<K, V>, Object {
        private final K a;
        private final V b;

        public b(K k2, V v) {
            this.a = k2;
            this.b = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            kotlinx.coroutines.debug.internal.a.c();
            throw null;
        }
    }

    /* compiled from: ConcurrentWeakMap.kt */
    /* loaded from: classes3.dex */
    private final class c<E> extends g<E> {
        private final p<K, V, E> a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(p<? super K, ? super V, ? extends E> pVar) {
            this.a = pVar;
        }

        @Override // kotlin.collections.g, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e2) {
            kotlinx.coroutines.debug.internal.a.c();
            throw null;
        }

        @Override // kotlin.collections.g
        public int getSize() {
            return ConcurrentWeakMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return ((a) ConcurrentWeakMap.this.core).e(this.a);
        }
    }

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    public /* synthetic */ ConcurrentWeakMap(boolean z, int i2, o oVar) {
        this((i2 & 1) != 0 ? false : z);
    }

    private final void g(d<?> dVar) {
        ((a) this.core).b(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        b.decrementAndGet(this);
    }

    private final synchronized V i(K k2, V v) {
        V v2;
        c0 c0Var;
        a aVar = (a) this.core;
        while (true) {
            v2 = (V) a.g(aVar, k2, v, null, 4, null);
            c0Var = kotlinx.coroutines.debug.internal.a.a;
            if (v2 == c0Var) {
                aVar = aVar.h();
                this.core = aVar;
            }
        }
        return v2;
    }

    @Override // kotlin.collections.f
    public Set<Map.Entry<K, V>> a() {
        return new c(ConcurrentWeakMap$entries$1.INSTANCE);
    }

    @Override // kotlin.collections.f
    public Set<K> b() {
        return new c(ConcurrentWeakMap$keys$1.INSTANCE);
    }

    @Override // kotlin.collections.f
    public int c() {
        return this._size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (K k2 : keySet()) {
            remove(k2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        return (V) ((a) this.core).c(obj);
    }

    public final void j() {
        if (!(this.a != null)) {
            throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
        while (true) {
            try {
                Reference<? extends K> remove = this.a.remove();
                if (remove == null) {
                    break;
                }
                g((d) remove);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v) {
        c0 c0Var;
        V v2 = (V) a.g((a) this.core, k2, v, null, 4, null);
        c0Var = kotlinx.coroutines.debug.internal.a.a;
        if (v2 == c0Var) {
            v2 = i(k2, v);
        }
        if (v2 == null) {
            b.incrementAndGet(this);
        }
        return v2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        c0 c0Var;
        if (obj == 0) {
            return null;
        }
        V v = (V) a.g((a) this.core, obj, null, null, 4, null);
        c0Var = kotlinx.coroutines.debug.internal.a.a;
        if (v == c0Var) {
            v = i(obj, null);
        }
        if (v != null) {
            b.decrementAndGet(this);
        }
        return v;
    }

    public ConcurrentWeakMap(boolean z) {
        this._size = 0;
        this.core = new a(16);
        this.a = z ? new ReferenceQueue<>() : null;
    }
}
