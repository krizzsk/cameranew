package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbtq implements zzeqb<zzbto> {
    private final zzeqo<zzdmw> zzfrs;
    private final zzeqo<Set<zzbya<zzbtt>>> zzfvd;

    private zzbtq(zzeqo<Set<zzbya<zzbtt>>> zzeqoVar, zzeqo<zzdmw> zzeqoVar2) {
        this.zzfvd = zzeqoVar;
        this.zzfrs = zzeqoVar2;
    }

    public static zzbtq zzr(zzeqo<Set<zzbya<zzbtt>>> zzeqoVar, zzeqo<zzdmw> zzeqoVar2) {
        return new zzbtq(zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzbto(this.zzfvd.get(), this.zzfrs.get());
    }
}
