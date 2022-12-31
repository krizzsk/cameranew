package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.common.internal.q;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzawj implements MediationRewardedAdCallback {
    private final zzank zzdnw;

    public zzawj(zzank zzankVar) {
        this.zzdnw = zzankVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void onAdClosed() {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called onAdClosed.");
        try {
            this.zzdnw.onAdClosed();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onAdFailedToShow(String str) {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called onAdFailedToShow.");
        String valueOf = String.valueOf(str);
        zzazk.zzex(valueOf.length() != 0 ? "Mediation ad failed to show: ".concat(valueOf) : new String("Mediation ad failed to show: "));
        try {
            this.zzdnw.zzdj(str);
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void onAdOpened() {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called onAdOpened.");
        try {
            this.zzdnw.onAdOpened();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onUserEarnedReward(RewardItem rewardItem) {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called onUserEarnedReward.");
        try {
            this.zzdnw.zza(new zzawi(rewardItem));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onVideoComplete() {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called onVideoComplete.");
        try {
            this.zzdnw.zzvf();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onVideoStart() {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called onVideoStart.");
        try {
            this.zzdnw.zzve();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void reportAdClicked() {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called reportAdClicked.");
        try {
            this.zzdnw.onAdClicked();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdCallback
    public final void reportAdImpression() {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called reportAdImpression.");
        try {
            this.zzdnw.onAdImpression();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAdCallback
    public final void onAdFailedToShow(AdError adError) {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called onAdFailedToShow.");
        int code = adError.getCode();
        String message = adError.getMessage();
        String domain = adError.getDomain();
        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 87 + String.valueOf(domain).length());
        sb.append("Mediation ad failed to show: Error Code = ");
        sb.append(code);
        sb.append(". Error Message = ");
        sb.append(message);
        sb.append(" Error Domain = ");
        sb.append(domain);
        zzazk.zzex(sb.toString());
        try {
            this.zzdnw.zzf(adError.zzdq());
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }
}
