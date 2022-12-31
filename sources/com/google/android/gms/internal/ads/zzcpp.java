package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcpp implements zzeqb<zzcpn> {
    private final zzeqo<Set<zzcpq>> zzglz;
    private final zzeqo<zzdsa> zzgqg;

    private zzcpp(zzeqo<Set<zzcpq>> zzeqoVar, zzeqo<zzdsa> zzeqoVar2) {
        this.zzglz = zzeqoVar;
        this.zzgqg = zzeqoVar2;
    }

    public static zzcpp zzam(zzeqo<Set<zzcpq>> zzeqoVar, zzeqo<zzdsa> zzeqoVar2) {
        return new zzcpp(zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcpn(this.zzglz.get(), this.zzgqg.get());
    }
}
