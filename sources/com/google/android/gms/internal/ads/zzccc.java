package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzccc {
    @Nullable
    private zzaem zzclh;

    public zzccc(zzcbs zzcbsVar) {
        this.zzclh = zzcbsVar;
    }

    public final synchronized void zza(@Nullable zzaem zzaemVar) {
        this.zzclh = zzaemVar;
    }

    @Nullable
    public final synchronized zzaem zzty() {
        return this.zzclh;
    }
}
