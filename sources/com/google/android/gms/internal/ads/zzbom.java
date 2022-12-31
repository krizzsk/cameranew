package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbom implements zzeqb<zzdmw> {
    private final zzboj zzfwt;

    private zzbom(zzboj zzbojVar) {
        this.zzfwt = zzbojVar;
    }

    public static zzbom zzc(zzboj zzbojVar) {
        return new zzbom(zzbojVar);
    }

    public static zzdmw zzd(zzboj zzbojVar) {
        return (zzdmw) zzeqh.zza(zzbojVar.zzakx(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zzd(this.zzfwt);
    }
}
