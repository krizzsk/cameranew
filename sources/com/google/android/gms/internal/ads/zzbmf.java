package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbmf implements zzeqb<zzdmz> {
    private final zzbmc zzfvc;

    public zzbmf(zzbmc zzbmcVar) {
        this.zzfvc = zzbmcVar;
    }

    public static zzdmz zza(zzbmc zzbmcVar) {
        return (zzdmz) zzeqh.zza(zzbmcVar.zzake(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zza(this.zzfvc);
    }
}
