package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzcsn implements zzbnu {
    private final zzdog zzgts;

    private zzcsn(zzdog zzdogVar) {
        this.zzgts = zzdogVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbnu zza(zzdog zzdogVar) {
        return new zzcsn(zzdogVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbnu
    public final zzzc getVideoController() {
        return this.zzgts.getVideoController();
    }
}
