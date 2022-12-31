package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.google.android.gms.dynamic.d;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzawn extends RewardedInterstitialAd {
    private final Context zzaad;
    private final String zzbut;
    @Nullable
    private FullScreenContentCallback zzbuw;
    @Nullable
    private OnPaidEventListener zzckr;
    private final zzavm zzdzl;
    @Nullable
    private OnAdMetadataChangedListener zzdzo;
    private final zzawl zzeag = new zzawl();

    public zzawn(Context context, String str) {
        this.zzbut = str;
        this.zzaad = context.getApplicationContext();
        this.zzdzl = zzwr.zzqo().zzc(context, str, new zzanf());
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final Bundle getAdMetadata() {
        try {
            return this.zzdzl.getAdMetadata();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            return new Bundle();
        }
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final String getAdUnitId() {
        return this.zzbut;
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    @Nullable
    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzbuw;
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    @Nullable
    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zzdzo;
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    @Nullable
    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzckr;
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    @Nullable
    public final ResponseInfo getResponseInfo() {
        zzyx zzyxVar;
        try {
            zzyxVar = this.zzdzl.zzki();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            zzyxVar = null;
        }
        return ResponseInfo.zza(zzyxVar);
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    @NonNull
    public final RewardItem getRewardItem() {
        try {
            zzavl zzrv = this.zzdzl.zzrv();
            if (zzrv != null) {
                return new zzawa(zzrv);
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
        return RewardItem.DEFAULT_REWARD;
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void setFullScreenContentCallback(@Nullable FullScreenContentCallback fullScreenContentCallback) {
        this.zzbuw = fullScreenContentCallback;
        this.zzeag.setFullScreenContentCallback(fullScreenContentCallback);
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void setImmersiveMode(boolean z) {
        try {
            this.zzdzl.setImmersiveMode(z);
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzdzo = onAdMetadataChangedListener;
        try {
            this.zzdzl.zza(new zzaam(onAdMetadataChangedListener));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        this.zzckr = onPaidEventListener;
        try {
            this.zzdzl.zza(new zzaap(onPaidEventListener));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            this.zzdzl.zza(new zzawh(serverSideVerificationOptions));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void show(@Nullable Activity activity, @NonNull OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzeag.zza(onUserEarnedRewardListener);
        try {
            this.zzdzl.zza(this.zzeag);
            this.zzdzl.zze(d.z0(activity));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void zza(zzzk zzzkVar, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        try {
            this.zzdzl.zzb(zzvq.zza(this.zzaad, zzzkVar), new zzawk(rewardedInterstitialAdLoadCallback, this));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }
}
