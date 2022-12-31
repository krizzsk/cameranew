package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzapw implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzank zzdon;
    private final /* synthetic */ zzapt zzdot;
    private final /* synthetic */ zzapj zzdou;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapw(zzapt zzaptVar, zzapj zzapjVar, zzank zzankVar) {
        this.zzdot = zzaptVar;
        this.zzdou = zzapjVar;
        this.zzdon = zzankVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* renamed from: zza */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        if (mediationRewardedAd == null) {
            zzazk.zzex("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdou.zzdl("Adapter returned null.");
                return null;
            } catch (RemoteException e2) {
                zzazk.zzc("", e2);
                return null;
            }
        }
        try {
            this.zzdot.zzdnp = mediationRewardedAd;
            this.zzdou.zzvn();
        } catch (RemoteException e3) {
            zzazk.zzc("", e3);
        }
        return new zzapz(this.zzdon);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.zzdou.zzdl(str);
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(AdError adError) {
        try {
            this.zzdou.zzg(adError.zzdq());
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }
}
