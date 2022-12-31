package d.e.d.m;

import com.ironsource.sdk.data.ISNEnums$ProductType;
/* compiled from: Constants.java */
/* loaded from: classes2.dex */
public class a {
    public String a;
    public String b;
    public String c;

    public static a a(ISNEnums$ProductType iSNEnums$ProductType) {
        a aVar = new a();
        if (iSNEnums$ProductType == ISNEnums$ProductType.RewardedVideo) {
            aVar.a = "initRewardedVideo";
            aVar.b = "onInitRewardedVideoSuccess";
            aVar.c = "onInitRewardedVideoFail";
        } else if (iSNEnums$ProductType == ISNEnums$ProductType.Interstitial) {
            aVar.a = "initInterstitial";
            aVar.b = "onInitInterstitialSuccess";
            aVar.c = "onInitInterstitialFail";
        } else if (iSNEnums$ProductType == ISNEnums$ProductType.OfferWall) {
            aVar.a = "initOfferWall";
            aVar.b = "onInitOfferWallSuccess";
            aVar.c = "onInitOfferWallFail";
        } else if (iSNEnums$ProductType == ISNEnums$ProductType.Banner) {
            aVar.a = "initBanner";
            aVar.b = "onInitBannerSuccess";
            aVar.c = "onInitBannerFail";
        }
        return aVar;
    }

    public static a b(ISNEnums$ProductType iSNEnums$ProductType) {
        a aVar = new a();
        if (iSNEnums$ProductType == ISNEnums$ProductType.RewardedVideo) {
            aVar.a = "showRewardedVideo";
            aVar.b = "onShowRewardedVideoSuccess";
            aVar.c = "onShowRewardedVideoFail";
        } else if (iSNEnums$ProductType == ISNEnums$ProductType.Interstitial) {
            aVar.a = "showInterstitial";
            aVar.b = "onShowInterstitialSuccess";
            aVar.c = "onShowInterstitialFail";
        } else if (iSNEnums$ProductType == ISNEnums$ProductType.OfferWall) {
            aVar.a = "showOfferWall";
            aVar.b = "onShowOfferWallSuccess";
            aVar.c = "onInitOfferWallFail";
        }
        return aVar;
    }
}
