package com.google.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes.dex */
final class g extends AdMetadataListener {
    private final /* synthetic */ AbstractAdViewAdapter a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.a = abstractAdViewAdapter;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        InterstitialAd interstitialAd;
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener;
        InterstitialAd interstitialAd2;
        MediationRewardedVideoAdListener mediationRewardedVideoAdListener2;
        interstitialAd = this.a.zzmn;
        if (interstitialAd != null) {
            mediationRewardedVideoAdListener = this.a.zzmo;
            if (mediationRewardedVideoAdListener != null) {
                interstitialAd2 = this.a.zzmn;
                Bundle adMetadata = interstitialAd2.getAdMetadata();
                mediationRewardedVideoAdListener2 = this.a.zzmo;
                mediationRewardedVideoAdListener2.zzb(adMetadata);
            }
        }
    }
}
