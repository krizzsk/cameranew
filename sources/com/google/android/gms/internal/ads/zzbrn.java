package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbrn implements zzeqb<zzbrl> {
    private final zzeqo<Set<zzbya<zzvc>>> zzfvd;

    private zzbrn(zzeqo<Set<zzbya<zzvc>>> zzeqoVar) {
        this.zzfvd = zzeqoVar;
    }

    public static zzbrn zzg(zzeqo<Set<zzbya<zzvc>>> zzeqoVar) {
        return new zzbrn(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzbrl(this.zzfvd.get());
    }
}
