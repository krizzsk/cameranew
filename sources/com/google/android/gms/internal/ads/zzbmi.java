package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbmi implements zzeqb<zzbnu> {
    private final zzbmc zzfvc;

    public zzbmi(zzbmc zzbmcVar) {
        this.zzfvc = zzbmcVar;
    }

    public static zzbnu zzc(zzbmc zzbmcVar) {
        return (zzbnu) zzeqh.zza(zzbmcVar.zzakd(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zzc(this.zzfvc);
    }
}
