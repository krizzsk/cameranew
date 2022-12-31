package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqx;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbre implements zzeqb<zzbqx.zza> {
    private final zzbqx zzfyz;

    private zzbre(zzbqx zzbqxVar) {
        this.zzfyz = zzbqxVar;
    }

    public static zzbre zzk(zzbqx zzbqxVar) {
        return new zzbre(zzbqxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzbqx.zza) zzeqh.zza(this.zzfyz.zzalk(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
