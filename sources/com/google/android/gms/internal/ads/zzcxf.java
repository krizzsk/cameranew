package com.google.android.gms.internal.ads;

import android.view.View;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzcxf implements com.google.android.gms.ads.internal.zzg {
    private final /* synthetic */ zzbza zzgxg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcxf(zzcxe zzcxeVar, zzbza zzbzaVar) {
        this.zzgxg = zzbzaVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzh(View view) {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzkc() {
        this.zzgxg.zzagp().onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzkd() {
        this.zzgxg.zzagq().onAdImpression();
        this.zzgxg.zzagr().zzamr();
    }
}
