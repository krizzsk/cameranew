package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeql<T> implements zzeqo<T> {
    private static final Object zzjby = new Object();
    private volatile Object zzegu = zzjby;
    private volatile zzeqo<T> zzjbz;

    private zzeql(zzeqo<T> zzeqoVar) {
        this.zzjbz = zzeqoVar;
    }

    public static <P extends zzeqo<T>, T> zzeqo<T> zzau(P p) {
        return ((p instanceof zzeql) || (p instanceof zzeqc)) ? p : new zzeql((zzeqo) zzeqh.checkNotNull(p));
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final T get() {
        T t = (T) this.zzegu;
        if (t == zzjby) {
            zzeqo<T> zzeqoVar = this.zzjbz;
            if (zzeqoVar == null) {
                return (T) this.zzegu;
            }
            T t2 = zzeqoVar.get();
            this.zzegu = t2;
            this.zzjbz = null;
            return t2;
        }
        return t;
    }
}
