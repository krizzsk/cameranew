package com.google.android.gms.ads.rewarded;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.ads.zzawb;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class RewardedAd {
    private zzawb zzhsd;

    @Deprecated
    public RewardedAd(Context context, String str) {
        this.zzhsd = null;
        q.k(context, "context cannot be null");
        q.k(str, "adUnitID cannot be null");
        this.zzhsd = new zzawb(context, str);
    }

    public static void load(@NonNull Context context, @NonNull String str, @NonNull AdRequest adRequest, @NonNull RewardedAdLoadCallback rewardedAdLoadCallback) {
        q.k(context, "Context cannot be null.");
        q.k(str, "AdUnitId cannot be null.");
        q.k(adRequest, "AdRequest cannot be null.");
        q.k(rewardedAdLoadCallback, "LoadCallback cannot be null.");
        new zzawb(context, str).zza(adRequest.zzds(), rewardedAdLoadCallback);
    }

    public Bundle getAdMetadata() {
        zzawb zzawbVar = this.zzhsd;
        if (zzawbVar != null) {
            return zzawbVar.getAdMetadata();
        }
        return new Bundle();
    }

    @NonNull
    public String getAdUnitId() {
        zzawb zzawbVar = this.zzhsd;
        return zzawbVar != null ? zzawbVar.getAdUnitId() : "";
    }

    @Nullable
    public FullScreenContentCallback getFullScreenContentCallback() {
        zzawb zzawbVar = this.zzhsd;
        if (zzawbVar != null) {
            zzawbVar.getFullScreenContentCallback();
            return null;
        }
        return null;
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        zzawb zzawbVar = this.zzhsd;
        if (zzawbVar != null) {
            return zzawbVar.getMediationAdapterClassName();
        }
        return null;
    }

    @Nullable
    public OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        zzawb zzawbVar = this.zzhsd;
        if (zzawbVar != null) {
            return zzawbVar.getOnAdMetadataChangedListener();
        }
        return null;
    }

    @Nullable
    public OnPaidEventListener getOnPaidEventListener() {
        zzawb zzawbVar = this.zzhsd;
        if (zzawbVar != null) {
            zzawbVar.getOnPaidEventListener();
            return null;
        }
        return null;
    }

    @Nullable
    public ResponseInfo getResponseInfo() {
        zzawb zzawbVar = this.zzhsd;
        if (zzawbVar != null) {
            return zzawbVar.getResponseInfo();
        }
        return null;
    }

    @Nullable
    public RewardItem getRewardItem() {
        zzawb zzawbVar = this.zzhsd;
        if (zzawbVar != null) {
            return zzawbVar.getRewardItem();
        }
        return null;
    }

    @Deprecated
    public boolean isLoaded() {
        zzawb zzawbVar = this.zzhsd;
        if (zzawbVar != null) {
            return zzawbVar.isLoaded();
        }
        return false;
    }

    @RequiresPermission("android.permission.INTERNET")
    @Deprecated
    public void loadAd(AdRequest adRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        zzawb zzawbVar = this.zzhsd;
        if (zzawbVar != null) {
            zzawbVar.zza(adRequest.zzds(), rewardedAdLoadCallback);
        }
    }

    public void setFullScreenContentCallback(@Nullable FullScreenContentCallback fullScreenContentCallback) {
        zzawb zzawbVar = this.zzhsd;
        if (zzawbVar != null) {
            zzawbVar.setFullScreenContentCallback(fullScreenContentCallback);
        }
    }

    public void setImmersiveMode(boolean z) {
        zzawb zzawbVar = this.zzhsd;
        if (zzawbVar != null) {
            zzawbVar.setImmersiveMode(z);
        }
    }

    public void setOnAdMetadataChangedListener(@Nullable OnAdMetadataChangedListener onAdMetadataChangedListener) {
        zzawb zzawbVar = this.zzhsd;
        if (zzawbVar != null) {
            zzawbVar.setOnAdMetadataChangedListener(onAdMetadataChangedListener);
        }
    }

    public void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        zzawb zzawbVar = this.zzhsd;
        if (zzawbVar != null) {
            zzawbVar.setOnPaidEventListener(onPaidEventListener);
        }
    }

    public void setServerSideVerificationOptions(@Nullable ServerSideVerificationOptions serverSideVerificationOptions) {
        zzawb zzawbVar = this.zzhsd;
        if (zzawbVar != null) {
            zzawbVar.setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    @Deprecated
    public void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        zzawb zzawbVar = this.zzhsd;
        if (zzawbVar != null) {
            zzawbVar.show(activity, rewardedAdCallback);
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    @Deprecated
    public void loadAd(PublisherAdRequest publisherAdRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        zzawb zzawbVar = this.zzhsd;
        if (zzawbVar != null) {
            zzawbVar.zza(publisherAdRequest.zzds(), rewardedAdLoadCallback);
        }
    }

    @Deprecated
    public void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        zzawb zzawbVar = this.zzhsd;
        if (zzawbVar != null) {
            zzawbVar.show(activity, rewardedAdCallback, z);
        }
    }

    public void show(@NonNull Activity activity, @NonNull OnUserEarnedRewardListener onUserEarnedRewardListener) {
        zzawb zzawbVar = this.zzhsd;
        if (zzawbVar != null) {
            zzawbVar.show(activity, onUserEarnedRewardListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RewardedAd() {
        this.zzhsd = null;
    }

    public static void load(@NonNull Context context, @NonNull String str, @NonNull AdManagerAdRequest adManagerAdRequest, @NonNull RewardedAdLoadCallback rewardedAdLoadCallback) {
        q.k(context, "Context cannot be null.");
        q.k(str, "AdUnitId cannot be null.");
        q.k(adManagerAdRequest, "AdManagerAdRequest cannot be null.");
        q.k(rewardedAdLoadCallback, "LoadCallback cannot be null.");
        new zzawb(context, str).zza(adManagerAdRequest.zzds(), rewardedAdLoadCallback);
    }
}
