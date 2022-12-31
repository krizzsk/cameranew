package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbsn implements zzeqb<zzbsg> {
    private final zzeqo<Set<zzbya<zzbsh>>> zzfvd;

    private zzbsn(zzeqo<Set<zzbya<zzbsh>>> zzeqoVar) {
        this.zzfvd = zzeqoVar;
    }

    public static zzbsn zzj(zzeqo<Set<zzbya<zzbsh>>> zzeqoVar) {
        return new zzbsn(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzbsg(this.zzfvd.get());
    }
}
