package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbgi implements zzeqb<zzcro<zzdog, zzctd>> {
    private final zzbgb zzewc;
    private final zzeqo<zzcin> zzewd;

    public zzbgi(zzbgb zzbgbVar, zzeqo<zzcin> zzeqoVar) {
        this.zzewc = zzbgbVar;
        this.zzewd = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzcro) zzeqh.zza(new zzctv(this.zzewd.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
