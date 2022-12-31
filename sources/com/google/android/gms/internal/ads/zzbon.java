package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbon implements zzeqb<zzdnl> {
    private final zzboj zzfwt;

    private zzbon(zzboj zzbojVar) {
        this.zzfwt = zzbojVar;
    }

    public static zzbon zze(zzboj zzbojVar) {
        return new zzbon(zzbojVar);
    }

    public static zzdnl zzf(zzboj zzbojVar) {
        return (zzdnl) zzeqh.zza(zzbojVar.zzakw(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zzf(this.zzfwt);
    }
}
