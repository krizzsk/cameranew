package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbth implements zzeqb<zzbtf> {
    private final zzeqo<Set<zzbya<zzbtg>>> zzfvd;

    private zzbth(zzeqo<Set<zzbya<zzbtg>>> zzeqoVar) {
        this.zzfvd = zzeqoVar;
    }

    public static zzbth zzn(zzeqo<Set<zzbya<zzbtg>>> zzeqoVar) {
        return new zzbth(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzbtf(this.zzfvd.get());
    }
}
