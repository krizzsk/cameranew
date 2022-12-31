package com.facebook.common.references;

import android.graphics.Bitmap;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes.dex */
public class SharedReference<T> {
    @GuardedBy("itself")

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Object, Integer> f2408d = new IdentityHashMap();
    @GuardedBy("this")
    @Nullable
    private T a;
    @GuardedBy("this")
    private int b;
    private final h<T> c;

    /* loaded from: classes.dex */
    public static class NullReferenceException extends RuntimeException {
        public NullReferenceException() {
            super("Null shared reference");
        }
    }

    public SharedReference(T t, h<T> hVar) {
        com.facebook.common.internal.h.g(t);
        this.a = t;
        com.facebook.common.internal.h.g(hVar);
        this.c = hVar;
        this.b = 1;
        a(t);
    }

    private static void a(Object obj) {
        if (a.X() && ((obj instanceof Bitmap) || (obj instanceof d))) {
            return;
        }
        Map<Object, Integer> map = f2408d;
        synchronized (map) {
            Integer num = map.get(obj);
            if (num == null) {
                map.put(obj, 1);
            } else {
                map.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    private synchronized int c() {
        int i2;
        e();
        com.facebook.common.internal.h.b(Boolean.valueOf(this.b > 0));
        i2 = this.b - 1;
        this.b = i2;
        return i2;
    }

    private void e() {
        if (!h(this)) {
            throw new NullReferenceException();
        }
    }

    public static boolean h(@Nullable SharedReference<?> sharedReference) {
        return sharedReference != null && sharedReference.g();
    }

    private static void i(Object obj) {
        Map<Object, Integer> map = f2408d;
        synchronized (map) {
            Integer num = map.get(obj);
            if (num == null) {
                com.facebook.common.logging.a.C("SharedReference", "No entry in sLiveObjects for value of type %s", obj.getClass());
            } else if (num.intValue() == 1) {
                map.remove(obj);
            } else {
                map.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public synchronized void b() {
        e();
        this.b++;
    }

    public void d() {
        T t;
        if (c() == 0) {
            synchronized (this) {
                t = this.a;
                this.a = null;
            }
            if (t != null) {
                this.c.release(t);
                i(t);
            }
        }
    }

    @Nullable
    public synchronized T f() {
        return this.a;
    }

    public synchronized boolean g() {
        return this.b > 0;
    }
}
