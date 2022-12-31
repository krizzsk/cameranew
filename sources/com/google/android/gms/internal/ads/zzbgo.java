package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbgo implements zzeqb<zzdof<zzcgk>> {
    private final zzeqo<zzdzv> zzewf;
    private final zzeqo<zzcgt> zzewh;

    public zzbgo(zzeqo<zzcgt> zzeqoVar, zzeqo<zzdzv> zzeqoVar2) {
        this.zzewh = zzeqoVar;
        this.zzewf = zzeqoVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzdof) zzeqh.zza(new zzdof(this.zzewh.get(), this.zzewf.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
