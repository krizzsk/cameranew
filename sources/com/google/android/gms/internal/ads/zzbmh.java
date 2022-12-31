package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbmh implements zzeqb<zzblv> {
    private final zzeqo<zzblx> zzfnb;
    private final zzbmc zzfvc;

    public zzbmh(zzbmc zzbmcVar, zzeqo<zzblx> zzeqoVar) {
        this.zzfvc = zzbmcVar;
        this.zzfnb = zzeqoVar;
    }

    public static zzblv zza(zzbmc zzbmcVar, Object obj) {
        return (zzblv) zzeqh.zza((zzblx) obj, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zza(this.zzfvc, this.zzfnb.get());
    }
}
