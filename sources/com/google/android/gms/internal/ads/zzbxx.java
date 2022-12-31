package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbxx implements zzeqb<zzbxw> {
    private final zzeqo<Set<zzbya<zzbxt>>> zzfvd;

    private zzbxx(zzeqo<Set<zzbya<zzbxt>>> zzeqoVar) {
        this.zzfvd = zzeqoVar;
    }

    public static zzbxx zzt(zzeqo<Set<zzbya<zzbxt>>> zzeqoVar) {
        return new zzbxx(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzbxw(this.zzfvd.get());
    }
}
