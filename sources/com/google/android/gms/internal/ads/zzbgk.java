package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbgk implements zzeqb<zzbjd> {
    private final zzbgb zzewc;
    private final zzeqo<zzbgc> zzewg;

    public zzbgk(zzbgb zzbgbVar, zzeqo<zzbgc> zzeqoVar) {
        this.zzewc = zzbgbVar;
        this.zzewg = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzbjd) zzeqh.zza(this.zzewg.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
