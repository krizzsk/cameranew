package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbpc implements zzeqb<zzbya<zzbrm>> {
    private final zzbpa zzfxl;
    private final zzeqo<zzbpf> zzfxm;

    private zzbpc(zzbpa zzbpaVar, zzeqo<zzbpf> zzeqoVar) {
        this.zzfxl = zzbpaVar;
        this.zzfxm = zzeqoVar;
    }

    public static zzbpc zzc(zzbpa zzbpaVar, zzeqo<zzbpf> zzeqoVar) {
        return new zzbpc(zzbpaVar, zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzbya) zzeqh.zza(new zzbya(this.zzfxm.get(), zzazp.zzeih), "Cannot return null from a non-@Nullable @Provides method");
    }
}
