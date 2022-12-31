package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeqc<T> implements zzepv<T>, zzeqo<T> {
    private static final Object zzjby = new Object();
    private volatile Object zzegu = zzjby;
    private volatile zzeqo<T> zzjbz;

    private zzeqc(zzeqo<T> zzeqoVar) {
        this.zzjbz = zzeqoVar;
    }

    public static <P extends zzeqo<T>, T> zzeqo<T> zzau(P p) {
        zzeqh.checkNotNull(p);
        return p instanceof zzeqc ? p : new zzeqc(p);
    }

    public static <P extends zzeqo<T>, T> zzepv<T> zzav(P p) {
        if (p instanceof zzepv) {
            return (zzepv) p;
        }
        return new zzeqc((zzeqo) zzeqh.checkNotNull(p));
    }

    @Override // com.google.android.gms.internal.ads.zzepv, com.google.android.gms.internal.ads.zzeqo
    public final T get() {
        T t = (T) this.zzegu;
        Object obj = zzjby;
        if (t == obj) {
            synchronized (this) {
                t = this.zzegu;
                if (t == obj) {
                    t = this.zzjbz.get();
                    Object obj2 = this.zzegu;
                    if (((obj2 == obj || (obj2 instanceof zzeqi)) ? false : true) && obj2 != t) {
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
                    this.zzegu = t;
                    this.zzjbz = null;
                }
            }
        }
        return t;
    }
}
