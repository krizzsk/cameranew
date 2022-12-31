package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbmm implements zzeqb<zzbya<zzbse>> {
    private final zzeqo<zzbnm> zzftr;
    private final zzbmc zzfvc;

    public zzbmm(zzbmc zzbmcVar, zzeqo<zzbnm> zzeqoVar) {
        this.zzfvc = zzbmcVar;
        this.zzftr = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzbya) zzeqh.zza(new zzbya(this.zzftr.get(), zzazp.zzeig), "Cannot return null from a non-@Nullable @Provides method");
    }
}
