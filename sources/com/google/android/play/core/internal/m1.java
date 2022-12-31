package com.google.android.play.core.internal;
/* loaded from: classes2.dex */
public final class m1<T> implements n1, k1 {
    private static final Object c = new Object();
    private volatile n1<T> a;
    private volatile Object b = c;

    private m1(n1<T> n1Var) {
        this.a = n1Var;
    }

    public static <P extends n1<T>, T> n1<T> a(P p) {
        t0.k(p);
        return p instanceof m1 ? p : new m1(p);
    }

    public static <P extends n1<T>, T> k1<T> b(P p) {
        if (p instanceof k1) {
            return (k1) p;
        }
        t0.k(p);
        return new m1(p);
    }

    @Override // com.google.android.play.core.internal.n1
    public final T a() {
        T t = (T) this.b;
        Object obj = c;
        if (t == obj) {
            synchronized (this) {
                t = this.b;
                if (t == obj) {
                    t = this.a.a();
                    Object obj2 = this.b;
                    if (obj2 != obj && obj2 != t) {
                        String valueOf = String.valueOf(obj2);
                        String valueOf2 = String.valueOf(t);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                        sb.append("Scoped provider was invoked recursively returning different results: ");
                        sb.append(valueOf);
                        sb.append(" & ");
                        sb.append(valueOf2);
                        sb.append(". This is likely due to a circular dependency.");
                        throw new IllegalStateException(sb.toString());
                    }
                    this.b = t;
                    this.a = null;
                }
            }
        }
        return t;
    }
}
