package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public class zzbad<T> {
    private final zzbaa<T> zzeio;
    private final AtomicInteger zzeip;

    public zzbad() {
        zzbaa<T> zzbaaVar = new zzbaa<>();
        this.zzeio = zzbaaVar;
        this.zzeip = new AtomicInteger(0);
        zzdzk.zza(zzbaaVar, new zzbag(this), zzazp.zzeih);
    }

    @Deprecated
    public final int getStatus() {
        return this.zzeip.get();
    }

    @Deprecated
    public final void reject() {
        this.zzeio.setException(new Exception());
    }

    @Deprecated
    public final void zza(zzbae<T> zzbaeVar, zzbac zzbacVar) {
        zzdzk.zza(this.zzeio, new zzbaf(this, zzbaeVar, zzbacVar), zzazp.zzeih);
    }

    @Deprecated
    public final void zzl(T t) {
        this.zzeio.set(t);
    }
}
