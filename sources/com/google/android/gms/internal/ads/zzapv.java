package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final class zzapv implements MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> {
    private final /* synthetic */ zzank zzdon;
    private final /* synthetic */ zzapd zzdos;
    private final /* synthetic */ zzapt zzdot;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapv(zzapt zzaptVar, zzapd zzapdVar, zzank zzankVar) {
        this.zzdot = zzaptVar;
        this.zzdos = zzapdVar;
        this.zzdon = zzankVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* renamed from: zza */
    public final MediationInterstitialAdCallback onSuccess(MediationInterstitialAd mediationInterstitialAd) {
        if (mediationInterstitialAd == null) {
            zzazk.zzex("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdos.zzdl("Adapter returned null.");
                return null;
            } catch (RemoteException e2) {
                zzazk.zzc("", e2);
                return null;
            }
        }
        try {
            this.zzdot.zzdop = mediationInterstitialAd;
            this.zzdos.zzvn();
        } catch (RemoteException e3) {
            zzazk.zzc("", e3);
        }
        return new zzapz(this.zzdon);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.zzdos.zzdl(str);
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(AdError adError) {
        try {
            this.zzdos.zzg(adError.zzdq());
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }
}
