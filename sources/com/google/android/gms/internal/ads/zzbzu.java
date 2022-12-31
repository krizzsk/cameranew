package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbzu implements zzeqb<zzbeb> {
    private final zzbyz zzgbk;

    private zzbzu(zzbyz zzbyzVar) {
        this.zzgbk = zzbyzVar;
    }

    public static zzbzu zzd(zzbyz zzbyzVar) {
        return new zzbzu(zzbyzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    @Nullable
    public final /* synthetic */ Object get() {
        return this.zzgbk.zzaje();
    }
}
