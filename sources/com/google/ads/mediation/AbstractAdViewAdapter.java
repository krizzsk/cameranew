package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAdViewHolder;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzbga;
import com.google.android.gms.internal.ads.zzvc;
import com.google.android.gms.internal.ads.zzwr;
import com.google.android.gms.internal.ads.zzzc;
import java.util.Date;
import java.util.Map;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes.dex */
public abstract class AbstractAdViewAdapter implements com.google.android.gms.ads.mediation.MediationBannerAdapter, MediationNativeAdapter, OnImmersiveModeUpdatedListener, zza, MediationRewardedVideoAdAdapter, zzbga {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdView zzmj;
    private InterstitialAd zzmk;
    private AdLoader zzml;
    private Context zzmm;
    private InterstitialAd zzmn;
    private MediationRewardedVideoAdListener zzmo;
    private final RewardedVideoAdListener zzmp = new com.google.ads.mediation.f(this);

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes.dex */
    static class a extends NativeAppInstallAdMapper {
        private final NativeAppInstallAd p;

        public a(NativeAppInstallAd nativeAppInstallAd) {
            this.p = nativeAppInstallAd;
            setHeadline(nativeAppInstallAd.getHeadline().toString());
            setImages(nativeAppInstallAd.getImages());
            setBody(nativeAppInstallAd.getBody().toString());
            setIcon(nativeAppInstallAd.getIcon());
            setCallToAction(nativeAppInstallAd.getCallToAction().toString());
            if (nativeAppInstallAd.getStarRating() != null) {
                setStarRating(nativeAppInstallAd.getStarRating().doubleValue());
            }
            if (nativeAppInstallAd.getStore() != null) {
                setStore(nativeAppInstallAd.getStore().toString());
            }
            if (nativeAppInstallAd.getPrice() != null) {
                setPrice(nativeAppInstallAd.getPrice().toString());
            }
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeAppInstallAd.getVideoController());
        }

        @Override // com.google.android.gms.ads.mediation.NativeAdMapper
        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.p);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbob.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd(this.p);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes.dex */
    private static class b extends UnifiedNativeAdMapper {
        private final UnifiedNativeAd s;

        public b(UnifiedNativeAd unifiedNativeAd) {
            this.s = unifiedNativeAd;
            setHeadline(unifiedNativeAd.getHeadline());
            setImages(unifiedNativeAd.getImages());
            setBody(unifiedNativeAd.getBody());
            setIcon(unifiedNativeAd.getIcon());
            setCallToAction(unifiedNativeAd.getCallToAction());
            setAdvertiser(unifiedNativeAd.getAdvertiser());
            setStarRating(unifiedNativeAd.getStarRating());
            setStore(unifiedNativeAd.getStore());
            setPrice(unifiedNativeAd.getPrice());
            zzm(unifiedNativeAd.zzjw());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(unifiedNativeAd.getVideoController());
        }

        @Override // com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
        public final void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
            if (view instanceof UnifiedNativeAdView) {
                ((UnifiedNativeAdView) view).setNativeAd(this.s);
                return;
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbob.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd(this.s);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes.dex */
    static class c extends NativeContentAdMapper {
        private final NativeContentAd n;

        public c(NativeContentAd nativeContentAd) {
            this.n = nativeContentAd;
            setHeadline(nativeContentAd.getHeadline().toString());
            setImages(nativeContentAd.getImages());
            setBody(nativeContentAd.getBody().toString());
            if (nativeContentAd.getLogo() != null) {
                setLogo(nativeContentAd.getLogo());
            }
            setCallToAction(nativeContentAd.getCallToAction().toString());
            setAdvertiser(nativeContentAd.getAdvertiser().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeContentAd.getVideoController());
        }

        @Override // com.google.android.gms.ads.mediation.NativeAdMapper
        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.n);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbob.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd(this.n);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes.dex */
    static final class d extends AdListener implements zzvc {
        private final AbstractAdViewAdapter a;
        private final MediationInterstitialListener b;

        public d(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.a = abstractAdViewAdapter;
            this.b = mediationInterstitialListener;
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.ads.zzvc
        public final void onAdClicked() {
            this.b.onAdClicked(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdClosed() {
            this.b.onAdClosed(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdFailedToLoad(int i2) {
            this.b.onAdFailedToLoad(this.a, i2);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLeftApplication() {
            this.b.onAdLeftApplication(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLoaded() {
            this.b.onAdLoaded(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdOpened() {
            this.b.onAdOpened(this.a);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes.dex */
    static final class e extends AdListener implements AppEventListener, zzvc {
        private final AbstractAdViewAdapter a;
        private final MediationBannerListener b;

        public e(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
            this.a = abstractAdViewAdapter;
            this.b = mediationBannerListener;
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.ads.zzvc
        public final void onAdClicked() {
            this.b.onAdClicked(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdClosed() {
            this.b.onAdClosed(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdFailedToLoad(int i2) {
            this.b.onAdFailedToLoad(this.a, i2);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLeftApplication() {
            this.b.onAdLeftApplication(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLoaded() {
            this.b.onAdLoaded(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdOpened() {
            this.b.onAdOpened(this.a);
        }

        @Override // com.google.android.gms.ads.doubleclick.AppEventListener
        public final void onAppEvent(String str, String str2) {
            this.b.zza(this.a, str, str2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes.dex */
    static final class f extends AdListener implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener, UnifiedNativeAd.OnUnifiedNativeAdLoadedListener {
        private final AbstractAdViewAdapter a;
        private final MediationNativeListener b;

        public f(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.a = abstractAdViewAdapter;
            this.b = mediationNativeListener;
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.ads.zzvc
        public final void onAdClicked() {
            this.b.onAdClicked(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdClosed() {
            this.b.onAdClosed(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdFailedToLoad(int i2) {
            this.b.onAdFailedToLoad(this.a, i2);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdImpression() {
            this.b.onAdImpression(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLeftApplication() {
            this.b.onAdLeftApplication(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLoaded() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdOpened() {
            this.b.onAdOpened(this.a);
        }

        @Override // com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener
        public final void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            this.b.onAdLoaded(this.a, new a(nativeAppInstallAd));
        }

        @Override // com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener
        public final void onContentAdLoaded(NativeContentAd nativeContentAd) {
            this.b.onAdLoaded(this.a, new c(nativeContentAd));
        }

        @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener
        public final void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
            this.b.zza(this.a, nativeCustomTemplateAd, str);
        }

        @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener
        public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
            this.b.zza(this.a, nativeCustomTemplateAd);
        }

        @Override // com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener
        public final void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
            this.b.onAdLoaded(this.a, new b(unifiedNativeAd));
        }
    }

    private final AdRequest zza(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String str : keywords) {
                builder.addKeyword(str);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            zzwr.zzqn();
            builder.addTestDevice(zzaza.zzbm(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            builder.tagForChildDirectedTreatment(mediationAdRequest.taggedForChildDirectedTreatment() == 1);
        }
        builder.setIsDesignedForFamilies(mediationAdRequest.isDesignedForFamilies());
        builder.addNetworkExtrasBundle(AdMobAdapter.class, zza(bundle, bundle2));
        return builder.build();
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public View getBannerView() {
        return this.zzmj;
    }

    @Override // com.google.android.gms.internal.ads.zzbga
    public Bundle getInterstitialAdapterInfo() {
        return new MediationAdapter.zza().zzdv(1).zzaes();
    }

    @Override // com.google.android.gms.ads.mediation.zza
    public zzzc getVideoController() {
        VideoController videoController;
        AdView adView = this.zzmj;
        if (adView == null || (videoController = adView.getVideoController()) == null) {
            return null;
        }
        return videoController.zzdw();
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void initialize(Context context, MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        this.zzmm = context.getApplicationContext();
        this.zzmo = mediationRewardedVideoAdListener;
        mediationRewardedVideoAdListener.onInitializationSucceeded(this);
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public boolean isInitialized() {
        return this.zzmo != null;
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void loadAd(MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Context context = this.zzmm;
        if (context != null && this.zzmo != null) {
            InterstitialAd interstitialAd = new InterstitialAd(context);
            this.zzmn = interstitialAd;
            interstitialAd.zzd(true);
            this.zzmn.setAdUnitId(getAdUnitId(bundle));
            this.zzmn.setRewardedVideoAdListener(this.zzmp);
            this.zzmn.setAdMetadataListener(new g(this));
            this.zzmn.loadAd(zza(this.zzmm, mediationAdRequest, bundle2, bundle));
            return;
        }
        zzazk.zzev("AdMobAdapter.loadAd called before initialize.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onDestroy() {
        AdView adView = this.zzmj;
        if (adView != null) {
            adView.destroy();
            this.zzmj = null;
        }
        if (this.zzmk != null) {
            this.zzmk = null;
        }
        if (this.zzml != null) {
            this.zzml = null;
        }
        if (this.zzmn != null) {
            this.zzmn = null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener
    public void onImmersiveModeUpdated(boolean z) {
        InterstitialAd interstitialAd = this.zzmk;
        if (interstitialAd != null) {
            interstitialAd.setImmersiveMode(z);
        }
        InterstitialAd interstitialAd2 = this.zzmn;
        if (interstitialAd2 != null) {
            interstitialAd2.setImmersiveMode(z);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onPause() {
        AdView adView = this.zzmj;
        if (adView != null) {
            adView.pause();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onResume() {
        AdView adView = this.zzmj;
        if (adView != null) {
            adView.resume();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        AdView adView = new AdView(context);
        this.zzmj = adView;
        adView.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.zzmj.setAdUnitId(getAdUnitId(bundle));
        this.zzmj.setAdListener(new e(this, mediationBannerListener));
        this.zzmj.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        InterstitialAd interstitialAd = new InterstitialAd(context);
        this.zzmk = interstitialAd;
        interstitialAd.setAdUnitId(getAdUnitId(bundle));
        this.zzmk.setAdListener(new d(this, mediationInterstitialListener));
        this.zzmk.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        f fVar = new f(this, mediationNativeListener);
        AdLoader.Builder withAdListener = new AdLoader.Builder(context, bundle.getString(AD_UNIT_ID_PARAMETER)).withAdListener(fVar);
        withAdListener.withNativeAdOptions(nativeMediationAdRequest.getNativeAdOptions());
        withAdListener.withNativeAdOptions(nativeMediationAdRequest.getNativeAdRequestOptions());
        if (nativeMediationAdRequest.isUnifiedNativeAdRequested()) {
            withAdListener.forUnifiedNativeAd(fVar);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            withAdListener.forAppInstallAd(fVar);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            withAdListener.forContentAd(fVar);
        }
        if (nativeMediationAdRequest.zzvl()) {
            for (String str : nativeMediationAdRequest.zzvm().keySet()) {
                withAdListener.forCustomTemplateAd(str, fVar, nativeMediationAdRequest.zzvm().get(str).booleanValue() ? fVar : null);
            }
        }
        AdLoader build = withAdListener.build();
        this.zzml = build;
        build.loadAd(zza(context, nativeMediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        this.zzmk.show();
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void showVideo() {
        this.zzmn.show();
    }

    protected abstract Bundle zza(Bundle bundle, Bundle bundle2);
}
