package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdcn implements zzeqb<zzdch<zzdby>> {
    private final zzeqo<Clock> zzfsz;
    private final zzeqo<zzdcb> zzhbu;

    public zzdcn(zzeqo<zzdcb> zzeqoVar, zzeqo<Clock> zzeqoVar2) {
        this.zzhbu = zzeqoVar;
        this.zzfsz = zzeqoVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzdch) zzeqh.zza(new zzdch(this.zzhbu.get(), 10000L, this.zzfsz.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
