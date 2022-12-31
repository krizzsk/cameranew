package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzals implements zzbac {
    private final /* synthetic */ zzalm zzdki;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzals(zzalq zzalqVar, zzalm zzalmVar) {
        this.zzdki = zzalmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbac
    public final void run() {
        com.google.android.gms.ads.internal.util.zzd.zzeb("Rejecting reference for JS Engine.");
        this.zzdki.reject();
    }
}
