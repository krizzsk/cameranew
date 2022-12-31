package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbtp implements zzeqb<zzbtj> {
    private final zzeqo<Set<zzbya<com.google.android.gms.ads.internal.overlay.zzq>>> zzfvd;

    private zzbtp(zzeqo<Set<zzbya<com.google.android.gms.ads.internal.overlay.zzq>>> zzeqoVar) {
        this.zzfvd = zzeqoVar;
    }

    public static zzbtp zzo(zzeqo<Set<zzbya<com.google.android.gms.ads.internal.overlay.zzq>>> zzeqoVar) {
        return new zzbtp(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzbtj(this.zzfvd.get());
    }
}
