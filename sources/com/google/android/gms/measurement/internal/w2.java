package com.google.android.gms.measurement.internal;

import androidx.annotation.GuardedBy;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class w2<V> {

    /* renamed from: h  reason: collision with root package name */
    private static final Object f3954h = new Object();
    private final String a;
    private final u2<V> b;
    private final V c;

    /* renamed from: d  reason: collision with root package name */
    private final V f3955d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f3956e = new Object();
    @GuardedBy("overrideLock")

    /* renamed from: f  reason: collision with root package name */
    private volatile V f3957f = null;
    @GuardedBy("cachingLock")

    /* renamed from: g  reason: collision with root package name */
    private volatile V f3958g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ w2(String str, Object obj, Object obj2, u2 u2Var, t2 t2Var) {
        this.a = str;
        this.c = obj;
        this.f3955d = obj2;
        this.b = u2Var;
    }

    public final String a() {
        return this.a;
    }

    public final V b(V v) {
        synchronized (this.f3956e) {
        }
        if (v != null) {
            return v;
        }
        if (v2.a != null) {
            synchronized (f3954h) {
                if (da.a()) {
                    return this.f3958g == null ? this.c : this.f3958g;
                }
                try {
                    for (w2 w2Var : x2.c()) {
                        if (!da.a()) {
                            V v2 = null;
                            try {
                                u2<V> u2Var = w2Var.b;
                                if (u2Var != null) {
                                    v2 = u2Var.zza();
                                }
                            } catch (IllegalStateException unused) {
                            }
                            synchronized (f3954h) {
                                w2Var.f3958g = v2;
                            }
                        } else {
                            throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                        }
                    }
                } catch (SecurityException unused2) {
                }
                u2<V> u2Var2 = this.b;
                if (u2Var2 == null) {
                    return this.c;
                }
                try {
                    return u2Var2.zza();
                } catch (IllegalStateException unused3) {
                    return this.c;
                } catch (SecurityException unused4) {
                    return this.c;
                }
            }
        }
        return this.c;
    }
}
