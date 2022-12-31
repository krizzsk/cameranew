package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbgl implements zzeqb<zzcro<zzdog, zzctg>> {
    private final zzbgb zzewc;
    private final zzeqo<zzcin> zzewd;

    public zzbgl(zzbgb zzbgbVar, zzeqo<zzcin> zzeqoVar) {
        this.zzewc = zzbgbVar;
        this.zzewd = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzcro) zzeqh.zza(new zzcvl(this.zzewd.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
