package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbsf implements zzeqb<zzbsd> {
    private final zzeqo<Set<zzbya<zzbse>>> zzfvd;

    private zzbsf(zzeqo<Set<zzbya<zzbse>>> zzeqoVar) {
        this.zzfvd = zzeqoVar;
    }

    public static zzbsf zzi(zzeqo<Set<zzbya<zzbse>>> zzeqoVar) {
        return new zzbsf(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzbsd(this.zzfvd.get());
    }
}
