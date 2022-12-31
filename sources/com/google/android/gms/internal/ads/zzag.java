package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzag<T> {
    @Nullable
    public final T result;
    @Nullable
    public final zzn zzbq;
    @Nullable
    public final zzap zzbr;
    public boolean zzbs;

    private zzag(@Nullable T t, @Nullable zzn zznVar) {
        this.zzbs = false;
        this.result = t;
        this.zzbq = zznVar;
        this.zzbr = null;
    }

    public static <T> zzag<T> zza(@Nullable T t, @Nullable zzn zznVar) {
        return new zzag<>(t, zznVar);
    }

    public static <T> zzag<T> zzc(zzap zzapVar) {
        return new zzag<>(zzapVar);
    }

    public final boolean isSuccess() {
        return this.zzbr == null;
    }

    private zzag(zzap zzapVar) {
        this.zzbs = false;
        this.result = null;
        this.zzbq = null;
        this.zzbr = zzapVar;
    }
}
