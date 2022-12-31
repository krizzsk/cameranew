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
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.d;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzawb extends RewardedAd {
    private final Context zzaad;
    private final String zzbut;
    private FullScreenContentCallback zzbuw;
    private OnPaidEventListener zzckr;
    private final zzavm zzdzl;
    private final zzawl zzdzm = new zzawl();
    private final zzawd zzdzn = new zzawd();
    private OnAdMetadataChangedListener zzdzo;

    public zzawb(Context context, String str) {
        this.zzaad = context.getApplicationContext();
        this.zzbut = str;
        this.zzdzl = zzwr.zzqo().zzc(context, str, new zzanf());
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final Bundle getAdMetadata() {
        try {
            return this.zzdzl.getAdMetadata();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            return new Bundle();
        }
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    @NonNull
    public final String getAdUnitId() {
        return this.zzbut;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    @Nullable
    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzbuw;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final String getMediationAdapterClassName() {
        try {
            return this.zzdzl.getMediationAdapterClassName();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            return "";
        }
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    @Nullable
    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zzdzo;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    @Nullable
    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzckr;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
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

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    @Nullable
    public final RewardItem getRewardItem() {
        try {
            zzavl zzrv = this.zzdzl.zzrv();
            if (zzrv == null) {
                return null;
            }
            return new zzawa(zzrv);
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final boolean isLoaded() {
        try {
            return this.zzdzl.isLoaded();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final void setFullScreenContentCallback(@Nullable FullScreenContentCallback fullScreenContentCallback) {
        this.zzbuw = fullScreenContentCallback;
        this.zzdzm.setFullScreenContentCallback(fullScreenContentCallback);
        this.zzdzn.setFullScreenContentCallback(fullScreenContentCallback);
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final void setImmersiveMode(boolean z) {
        try {
            this.zzdzl.setImmersiveMode(z);
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final void setOnAdMetadataChangedListener(@Nullable OnAdMetadataChangedListener onAdMetadataChangedListener) {
        try {
            this.zzdzo = onAdMetadataChangedListener;
            this.zzdzl.zza(new zzaam(onAdMetadataChangedListener));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        try {
            this.zzckr = onPaidEventListener;
            this.zzdzl.zza(new zzaap(onPaidEventListener));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            this.zzdzl.zza(new zzawh(serverSideVerificationOptions));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        this.zzdzn.zza(rewardedAdCallback);
        try {
            this.zzdzl.zza(this.zzdzn);
            this.zzdzl.zze(d.z0(activity));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void zza(zzzk zzzkVar, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            this.zzdzl.zza(zzvq.zza(this.zzaad, zzzkVar), new zzawe(rewardedAdLoadCallback, this));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        this.zzdzn.zza(rewardedAdCallback);
        try {
            this.zzdzl.zza(this.zzdzn);
            this.zzdzl.zza(d.z0(activity), z);
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.rewarded.RewardedAd
    public final void show(@NonNull Activity activity, @NonNull OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzdzm.zza(onUserEarnedRewardListener);
        if (activity == null) {
            zzazk.zzex("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            this.zzdzl.zza(this.zzdzm);
            this.zzdzl.zze(d.z0(activity));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }
}
