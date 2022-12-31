package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcbm implements zzeqb<zzccl> {
    private final zzcbi zzgdb;
    private final zzeqo<zzcbc> zzgdd;

    public zzcbm(zzcbi zzcbiVar, zzeqo<zzcbc> zzeqoVar) {
        this.zzgdb = zzcbiVar;
        this.zzgdd = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzccl) zzeqh.zza(this.zzgdd.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
