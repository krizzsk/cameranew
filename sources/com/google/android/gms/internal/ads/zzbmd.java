package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbmd implements zzeqb<zzbsw> {
    private final zzbmc zzfvc;
    private final zzeqo<Set<zzbya<zzbtb>>> zzfvd;

    public zzbmd(zzbmc zzbmcVar, zzeqo<Set<zzbya<zzbtb>>> zzeqoVar) {
        this.zzfvc = zzbmcVar;
        this.zzfvd = zzeqoVar;
    }

    public static zzbsw zza(zzbmc zzbmcVar, Set<zzbya<zzbtb>> set) {
        return (zzbsw) zzeqh.zza(zzbmcVar.zza(set), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zza(this.zzfvc, this.zzfvd.get());
    }
}
