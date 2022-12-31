package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaoe extends zzann {
    private final zzavf zzdnn;
    private final Adapter zzdnv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaoe(Adapter adapter, zzavf zzavfVar) {
        this.zzdnv = adapter;
        this.zzdnn = zzavfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void onAdClicked() throws RemoteException {
        zzavf zzavfVar = this.zzdnn;
        if (zzavfVar != null) {
            zzavfVar.zzak(d.z0(this.zzdnv));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void onAdClosed() throws RemoteException {
        zzavf zzavfVar = this.zzdnn;
        if (zzavfVar != null) {
            zzavfVar.zzaj(d.z0(this.zzdnv));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void onAdFailedToLoad(int i2) throws RemoteException {
        zzavf zzavfVar = this.zzdnn;
        if (zzavfVar != null) {
            zzavfVar.zze(d.z0(this.zzdnv), i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void onAdImpression() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void onAdLeftApplication() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void onAdLoaded() throws RemoteException {
        zzavf zzavfVar = this.zzdnn;
        if (zzavfVar != null) {
            zzavfVar.zzag(d.z0(this.zzdnv));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void onAdOpened() throws RemoteException {
        zzavf zzavfVar = this.zzdnn;
        if (zzavfVar != null) {
            zzavfVar.zzah(d.z0(this.zzdnv));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void onAppEvent(String str, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void onVideoEnd() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void onVideoPause() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void onVideoPlay() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void zza(zzafn zzafnVar, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void zza(zzanp zzanpVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void zza(zzavl zzavlVar) throws RemoteException {
        zzavf zzavfVar = this.zzdnn;
        if (zzavfVar != null) {
            zzavfVar.zza(d.z0(this.zzdnv), new zzavj(zzavlVar.getType(), zzavlVar.getAmount()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void zzb(Bundle bundle) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void zzb(zzavj zzavjVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void zzc(int i2, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void zzd(zzvg zzvgVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void zzdb(int i2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void zzdi(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void zzdj(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void zzf(zzvg zzvgVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void zzve() throws RemoteException {
        zzavf zzavfVar = this.zzdnn;
        if (zzavfVar != null) {
            zzavfVar.zzai(d.z0(this.zzdnv));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzank
    public final void zzvf() throws RemoteException {
        zzavf zzavfVar = this.zzdnn;
        if (zzavfVar != null) {
            zzavfVar.zzam(d.z0(this.zzdnv));
        }
    }
}
