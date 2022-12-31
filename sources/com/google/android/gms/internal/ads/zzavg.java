package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzavg implements MediationRewardedVideoAdListener {
    private final zzavf zzdzj;

    public zzavg(zzavf zzavfVar) {
        this.zzdzj = zzavfVar;
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdClicked(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called onAdClicked.");
        try {
            this.zzdzj.zzak(d.z0(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdClosed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called onAdClosed.");
        try {
            this.zzdzj.zzaj(d.z0(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdFailedToLoad(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i2) {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called onAdFailedToLoad.");
        try {
            this.zzdzj.zze(d.z0(mediationRewardedVideoAdAdapter), i2);
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdLeftApplication(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called onAdLeftApplication.");
        try {
            this.zzdzj.zzal(d.z0(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdLoaded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called onAdLoaded.");
        try {
            this.zzdzj.zzag(d.z0(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdOpened(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called onAdOpened.");
        try {
            this.zzdzj.zzah(d.z0(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onInitializationFailed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i2) {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called onInitializationFailed.");
        try {
            this.zzdzj.zzd(d.z0(mediationRewardedVideoAdAdapter), i2);
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onInitializationSucceeded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called onInitializationSucceeded.");
        try {
            this.zzdzj.zzaf(d.z0(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onRewarded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, RewardItem rewardItem) {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called onRewarded.");
        try {
            if (rewardItem != null) {
                this.zzdzj.zza(d.z0(mediationRewardedVideoAdAdapter), new zzavj(rewardItem));
            } else {
                this.zzdzj.zza(d.z0(mediationRewardedVideoAdAdapter), new zzavj("", 1));
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onVideoCompleted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called onVideoCompleted.");
        try {
            this.zzdzj.zzam(d.z0(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onVideoStarted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called onVideoStarted.");
        try {
            this.zzdzj.zzai(d.z0(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void zzb(Bundle bundle) {
        q.e("#008 Must be called on the main UI thread.");
        zzazk.zzdy("Adapter called onAdMetadataChanged.");
        try {
            this.zzdzj.zzb(bundle);
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }
}
