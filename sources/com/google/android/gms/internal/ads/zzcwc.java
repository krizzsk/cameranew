package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzcwc extends zzave {
    private final /* synthetic */ zzbtj zzgvz;
    private final /* synthetic */ zzbrl zzgwa;
    private final /* synthetic */ zzbsm zzgwb;
    private final /* synthetic */ zzbyk zzgwc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcwc(zzcvy zzcvyVar, zzbtj zzbtjVar, zzbrl zzbrlVar, zzbsm zzbsmVar, zzbyk zzbykVar) {
        this.zzgvz = zzbtjVar;
        this.zzgwa = zzbrlVar;
        this.zzgwb = zzbsmVar;
        this.zzgwc = zzbykVar;
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zza(b bVar, zzavj zzavjVar) {
        this.zzgwc.zza(zzavjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zzaf(b bVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zzag(b bVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zzah(b bVar) {
        this.zzgvz.zzvo();
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zzai(b bVar) {
        this.zzgwc.zzuc();
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zzaj(b bVar) {
        this.zzgvz.zza(com.google.android.gms.ads.internal.overlay.zzn.OTHER);
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zzak(b bVar) {
        this.zzgwa.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zzal(b bVar) {
        this.zzgwb.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zzam(b bVar) throws RemoteException {
        this.zzgwb.onRewardedVideoCompleted();
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zzb(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zzd(b bVar, int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzavf
    public final void zze(b bVar, int i2) {
    }
}
