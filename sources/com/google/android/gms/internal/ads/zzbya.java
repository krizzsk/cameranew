package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbya<T> {
    public Executor executor;
    public T zzgba;

    public zzbya(T t, Executor executor) {
        this.zzgba = t;
        this.executor = executor;
    }

    public static <T> zzbya<T> zzb(T t, Executor executor) {
        return new zzbya<>(t, executor);
    }
}
