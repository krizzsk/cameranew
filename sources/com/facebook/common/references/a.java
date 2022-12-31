package com.facebook.common.references;

import android.graphics.Bitmap;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: CloseableReference.java */
/* loaded from: classes.dex */
public abstract class a<T> implements Cloneable, Closeable {

    /* renamed from: e  reason: collision with root package name */
    private static Class<a> f2409e = a.class;

    /* renamed from: f  reason: collision with root package name */
    private static int f2410f = 0;

    /* renamed from: g  reason: collision with root package name */
    private static final h<Closeable> f2411g = new C0088a();

    /* renamed from: h  reason: collision with root package name */
    private static final c f2412h = new b();
    @GuardedBy("this")
    protected boolean a = false;
    protected final SharedReference<T> b;
    protected final c c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    protected final Throwable f2413d;

    /* compiled from: CloseableReference.java */
    /* renamed from: com.facebook.common.references.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0088a implements h<Closeable> {
        C0088a() {
        }

        @Override // com.facebook.common.references.h
        /* renamed from: a */
        public void release(Closeable closeable) {
            try {
                com.facebook.common.internal.b.a(closeable, true);
            } catch (IOException unused) {
            }
        }
    }

    /* compiled from: CloseableReference.java */
    /* loaded from: classes.dex */
    static class b implements c {
        b() {
        }

        @Override // com.facebook.common.references.a.c
        public void a(SharedReference<Object> sharedReference, @Nullable Throwable th) {
            Object f2 = sharedReference.f();
            Class cls = a.f2409e;
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(System.identityHashCode(this));
            objArr[1] = Integer.valueOf(System.identityHashCode(sharedReference));
            objArr[2] = f2 == null ? null : f2.getClass().getName();
            com.facebook.common.logging.a.x(cls, "Finalized without closing: %x %x (type = %s)", objArr);
        }

        @Override // com.facebook.common.references.a.c
        public boolean b() {
            return false;
        }
    }

    /* compiled from: CloseableReference.java */
    /* loaded from: classes.dex */
    public interface c {
        void a(SharedReference<Object> sharedReference, @Nullable Throwable th);

        boolean b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(SharedReference<T> sharedReference, c cVar, @Nullable Throwable th) {
        com.facebook.common.internal.h.g(sharedReference);
        this.b = sharedReference;
        sharedReference.b();
        this.c = cVar;
        this.f2413d = th;
    }

    public static boolean Q(@Nullable a<?> aVar) {
        return aVar != null && aVar.O();
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Lcom/facebook/common/references/a<TT;>; */
    public static a R(Closeable closeable) {
        return T(closeable, f2411g);
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;Lcom/facebook/common/references/a$c;)Lcom/facebook/common/references/a<TT;>; */
    public static a S(Closeable closeable, c cVar) {
        if (closeable == null) {
            return null;
        }
        return V(closeable, f2411g, cVar, cVar.b() ? new Throwable() : null);
    }

    public static <T> a<T> T(T t, h<T> hVar) {
        return U(t, hVar, f2412h);
    }

    public static <T> a<T> U(T t, h<T> hVar, c cVar) {
        if (t == null) {
            return null;
        }
        return V(t, hVar, cVar, cVar.b() ? new Throwable() : null);
    }

    public static <T> a<T> V(T t, h<T> hVar, c cVar, @Nullable Throwable th) {
        if (t == null) {
            return null;
        }
        if ((t instanceof Bitmap) || (t instanceof d)) {
            int i2 = f2410f;
            if (i2 == 1) {
                return new com.facebook.common.references.c(t, hVar, cVar, th);
            }
            if (i2 == 2) {
                return new g(t, hVar, cVar, th);
            }
            if (i2 == 3) {
                return new e(t, hVar, cVar, th);
            }
        }
        return new com.facebook.common.references.b(t, hVar, cVar, th);
    }

    public static void W(int i2) {
        f2410f = i2;
    }

    public static boolean X() {
        return f2410f == 3;
    }

    @Nullable
    public static <T> a<T> w(@Nullable a<T> aVar) {
        if (aVar != null) {
            return aVar.v();
        }
        return null;
    }

    public static <T> List<a<T>> x(Collection<a<T>> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (a<T> aVar : collection) {
            arrayList.add(w(aVar));
        }
        return arrayList;
    }

    public static void y(@Nullable a<?> aVar) {
        if (aVar != null) {
            aVar.close();
        }
    }

    public static void z(@Nullable Iterable<? extends a<?>> iterable) {
        if (iterable != null) {
            for (a<?> aVar : iterable) {
                y(aVar);
            }
        }
    }

    public synchronized T A() {
        T f2;
        com.facebook.common.internal.h.i(!this.a);
        f2 = this.b.f();
        com.facebook.common.internal.h.g(f2);
        return f2;
    }

    public int N() {
        if (O()) {
            return System.identityHashCode(this.b.f());
        }
        return 0;
    }

    public synchronized boolean O() {
        return !this.a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            if (this.a) {
                return;
            }
            this.a = true;
            this.b.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (this.a) {
                    return;
                }
                this.c.a(this.b, this.f2413d);
                close();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // 
    /* renamed from: t */
    public abstract a<T> clone();

    @Nullable
    public synchronized a<T> v() {
        if (O()) {
            return clone();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(T t, h<T> hVar, c cVar, @Nullable Throwable th) {
        this.b = new SharedReference<>(t, hVar);
        this.c = cVar;
        this.f2413d = th;
    }
}
