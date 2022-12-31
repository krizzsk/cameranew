package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbgp implements zzeqb<zzazn> {
    private final zzbgb zzewc;

    public zzbgp(zzbgb zzbgbVar) {
        this.zzewc = zzbgbVar;
    }

    public static zzazn zzb(zzbgb zzbgbVar) {
        return (zzazn) zzeqh.zza(zzbgbVar.zzaew(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zzb(this.zzewc);
    }
}
