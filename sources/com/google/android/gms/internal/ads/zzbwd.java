package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbwd implements zzeqb<zzbvu> {
    private final zzeqo<Set<zzbya<zzbwc>>> zzfvd;

    private zzbwd(zzeqo<Set<zzbya<zzbwc>>> zzeqoVar) {
        this.zzfvd = zzeqoVar;
    }

    public static zzbwd zzs(zzeqo<Set<zzbya<zzbwc>>> zzeqoVar) {
        return new zzbwd(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzbvu(this.zzfvd.get());
    }
}
