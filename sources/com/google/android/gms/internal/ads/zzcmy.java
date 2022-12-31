package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcmy implements zzeqb<zzdsa> {
    private final zzeqo<String> zzgle;

    private zzcmy(zzeqo<String> zzeqoVar) {
        this.zzgle = zzeqoVar;
    }

    public static zzcmy zzae(zzeqo<String> zzeqoVar) {
        return new zzcmy(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzdsa) zzeqh.zza(zzdsa.zzgy(this.zzgle.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
