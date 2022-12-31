package com.google.android.gms.internal.ads;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcas implements zzeqb<zzcaq> {
    private final zzcaq zzgbx;

    private zzcas(zzcaq zzcaqVar) {
        this.zzgbx = zzcaqVar;
    }

    public static zzcas zze(zzcaq zzcaqVar) {
        return new zzcas(zzcaqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        zzcaq zzcaqVar = this.zzgbx;
        Objects.requireNonNull(zzcaqVar);
        return (zzcaq) zzeqh.zza(zzcaqVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
