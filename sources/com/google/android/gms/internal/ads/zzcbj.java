package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcbj implements zzeqb<zzcch> {
    private final zzeqo<zzcck> zzfiz;
    private final zzcbi zzgdb;

    public zzcbj(zzcbi zzcbiVar, zzeqo<zzcck> zzeqoVar) {
        this.zzgdb = zzcbiVar;
        this.zzfiz = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzcch) zzeqh.zza(this.zzfiz.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
