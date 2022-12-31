package com.ironsource.adapters.admob;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.b;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.metadata.MetaData$MetaDataValueTypes;
import com.ironsource.mediationsdk.metadata.a;
import com.ironsource.mediationsdk.n0.c;
import com.ironsource.mediationsdk.n0.n;
import com.ironsource.mediationsdk.n0.u;
import com.ironsource.mediationsdk.o;
import com.ironsource.mediationsdk.r;
import com.ironsource.mediationsdk.s;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AdMobAdapter extends b implements o {
    public static int BN_FAILED_TO_RELOAD_ERROR_CODE = 103;
    private static final String CORE_SDK_VERSION = "20.1.0";
    private static final String GitHash = "a18b04a69";
    public static int IS_NOT_READY_ERROR_CODE = 104;
    public static int RV_NOT_READY_ERROR_CODE = 101;
    private static final String VERSION = "4.3.20";
    private static Boolean mCCPAValue;
    private static Boolean mConsent;
    private static Integer mCoppaValue;
    private static Integer mEuValue;
    private final String ADMOB_TFCD_KEY;
    private final String ADMOB_TFUA_KEY;
    private final String AD_UNIT_ID;
    private final String INIT_RESPONSE_REQUIRED;
    private final String IRONSOURCE_REQUEST_AGENT;
    private final String NETWORK_ONLY_INIT;
    private ConcurrentHashMap<String, AdView> mAdIdToBannerAd;
    private ConcurrentHashMap<String, InterstitialAd> mAdIdToInterstitialAd;
    private ConcurrentHashMap<String, RewardedAd> mAdIdToRewardedVideoAd;
    private ConcurrentHashMap<String, c> mAdUnitIdToBannerListener;
    private ConcurrentHashMap<String, n> mAdUnitIdToInterstitialListener;
    private ConcurrentHashMap<String, u> mAdUnitIdToRewardedVideoListener;
    private ConcurrentHashMap<String, Boolean> mInterstitialAdsAvailability;
    private ConcurrentHashMap<String, Boolean> mRewardedVideoAdsAvailability;
    private static AtomicBoolean mWasInitCalled = new AtomicBoolean(false);
    private static HashSet<o> initCallbackListeners = new HashSet<>();
    private static InitState mInitState = InitState.INIT_STATE_NONE;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum InitState {
        INIT_STATE_NONE,
        INIT_STATE_IN_PROGRESS,
        INIT_STATE_SUCCESS,
        INIT_STATE_FAILED
    }

    private AdMobAdapter(String str) {
        super(str);
        this.IRONSOURCE_REQUEST_AGENT = "ironSource";
        this.AD_UNIT_ID = "adUnitId";
        this.NETWORK_ONLY_INIT = "networkOnlyInit";
        this.INIT_RESPONSE_REQUIRED = "initResponseRequired";
        this.ADMOB_TFCD_KEY = "admob_tfcd";
        this.ADMOB_TFUA_KEY = "admob_tfua";
        IronLog.INTERNAL.verbose("");
        this.mAllBannerSmashes = new CopyOnWriteArrayList<>();
        this.mAdIdToInterstitialAd = new ConcurrentHashMap<>();
        this.mInterstitialAdsAvailability = new ConcurrentHashMap<>();
        this.mAdIdToBannerAd = new ConcurrentHashMap<>();
        this.mAdUnitIdToRewardedVideoListener = new ConcurrentHashMap<>();
        this.mAdIdToRewardedVideoAd = new ConcurrentHashMap<>();
        this.mRewardedVideoAdsAvailability = new ConcurrentHashMap<>();
        this.mAdUnitIdToInterstitialListener = new ConcurrentHashMap<>();
        this.mAdUnitIdToBannerListener = new ConcurrentHashMap<>();
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdRequest createAdRequest() {
        AdRequest.Builder builder = new AdRequest.Builder();
        builder.setRequestAgent("ironSource");
        setRequestConfiguration();
        if (mConsent != null || mCCPAValue != null) {
            Bundle bundle = new Bundle();
            Boolean bool = mConsent;
            if (bool != null && !bool.booleanValue()) {
                IronLog ironLog = IronLog.ADAPTER_API;
                ironLog.verbose("mConsent = " + mConsent);
                bundle.putString("npa", "1");
            }
            if (mCCPAValue != null) {
                IronLog ironLog2 = IronLog.ADAPTER_API;
                ironLog2.verbose("mCCPAValue = " + mCCPAValue);
                bundle.putInt("rdp", mCCPAValue.booleanValue() ? 1 : 0);
            }
            builder.addNetworkExtrasBundle(com.google.ads.mediation.admob.AdMobAdapter.class, bundle);
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdListener createBannerAdListener(final AdView adView, final String str) {
        return new AdListener() { // from class: com.ironsource.adapters.admob.AdMobAdapter.15
            @Override // com.google.android.gms.ads.AdListener
            public void onAdClosed() {
                super.onAdClosed();
                IronLog ironLog = IronLog.ADAPTER_CALLBACK;
                ironLog.verbose("adUnitId = " + str);
                if (AdMobAdapter.this.mAdUnitIdToBannerListener.containsKey(str)) {
                    ((c) AdMobAdapter.this.mAdUnitIdToBannerListener.get(str)).m();
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                String str2;
                com.ironsource.mediationsdk.logger.b e2;
                super.onAdFailedToLoad(loadAdError);
                IronLog ironLog = IronLog.ADAPTER_CALLBACK;
                ironLog.verbose("adUnitId = " + str);
                if (loadAdError != null) {
                    str2 = loadAdError.getMessage() + "( " + loadAdError.getCode() + " ) ";
                    if (loadAdError.getCause() != null) {
                        str2 = str2 + " Caused by - " + loadAdError.getCause();
                    }
                    e2 = AdMobAdapter.this.isNoFillError(loadAdError.getCode()) ? new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO, str2) : f.e(str2);
                } else {
                    str2 = "Banner failed to load (loadAdError is null)";
                    e2 = f.e("Banner failed to load (loadAdError is null)");
                }
                ironLog.error(str2 + str2);
                if (AdMobAdapter.this.mAdUnitIdToBannerListener.containsKey(str)) {
                    ((c) AdMobAdapter.this.mAdUnitIdToBannerListener.get(str)).b(e2);
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdImpression() {
                super.onAdImpression();
                IronLog ironLog = IronLog.ADAPTER_CALLBACK;
                ironLog.verbose("adUnitId = " + str);
                if (AdMobAdapter.this.mAdUnitIdToBannerListener.containsKey(str)) {
                    try {
                        ((c) AdMobAdapter.this.mAdUnitIdToBannerListener.get(str)).C();
                    } catch (Exception unused) {
                        IronLog.ADAPTER_CALLBACK.error("onBannerAdShown: method isn't supported on current mediation version");
                    }
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                super.onAdLoaded();
                IronLog ironLog = IronLog.ADAPTER_CALLBACK;
                ironLog.verbose("adUnitId = " + str);
                if (AdMobAdapter.this.mAdUnitIdToBannerListener.containsKey(str)) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    ((c) AdMobAdapter.this.mAdUnitIdToBannerListener.get(str)).r(adView, layoutParams);
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdOpened() {
                super.onAdOpened();
                IronLog ironLog = IronLog.ADAPTER_CALLBACK;
                ironLog.verbose("adUnitId = " + str);
                if (AdMobAdapter.this.mAdUnitIdToBannerListener.containsKey(str)) {
                    ((c) AdMobAdapter.this.mAdUnitIdToBannerListener.get(str)).l();
                    ((c) AdMobAdapter.this.mAdUnitIdToBannerListener.get(str)).n();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FullScreenContentCallback createISFullScreenCallback(final String str) {
        return new FullScreenContentCallback() { // from class: com.ironsource.adapters.admob.AdMobAdapter.10
            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdDismissedFullScreenContent() {
                IronLog ironLog = IronLog.ADAPTER_CALLBACK;
                ironLog.verbose("adUnitId = " + str);
                if (AdMobAdapter.this.mAdUnitIdToInterstitialListener.containsKey(str)) {
                    ((n) AdMobAdapter.this.mAdUnitIdToInterstitialListener.get(str)).f();
                }
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                IronLog ironLog = IronLog.ADAPTER_CALLBACK;
                ironLog.verbose("adUnitId = " + str);
                int code = adError.getCode();
                String str2 = adError.getMessage() + "( " + code + " )";
                if (adError.getCause() != null) {
                    str2 = str2 + " Caused by - " + adError.getCause();
                }
                ironLog.error("adapterError = " + str2);
                if (AdMobAdapter.this.mAdUnitIdToInterstitialListener.containsKey(str)) {
                    ((n) AdMobAdapter.this.mAdUnitIdToInterstitialListener.get(str)).e(new com.ironsource.mediationsdk.logger.b(code, AdMobAdapter.this.getProviderName() + "onInterstitialAdShowFailed " + str + " " + str2));
                }
            }

            public void onAdImpression() {
                IronLog.ADAPTER_CALLBACK.verbose("");
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdShowedFullScreenContent() {
                IronLog ironLog = IronLog.ADAPTER_CALLBACK;
                ironLog.verbose("adUnitId = " + str);
                if (AdMobAdapter.this.mAdUnitIdToInterstitialListener.containsKey(str)) {
                    ((n) AdMobAdapter.this.mAdUnitIdToInterstitialListener.get(str)).h();
                    ((n) AdMobAdapter.this.mAdUnitIdToInterstitialListener.get(str)).j();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FullScreenContentCallback createRVFullScreenCallback(final String str) {
        return new FullScreenContentCallback() { // from class: com.ironsource.adapters.admob.AdMobAdapter.6
            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdDismissedFullScreenContent() {
                IronLog ironLog = IronLog.ADAPTER_CALLBACK;
                ironLog.verbose("adUnitId = " + str);
                if (AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.containsKey(str)) {
                    ((u) AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.get(str)).onRewardedVideoAdClosed();
                }
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                IronLog ironLog = IronLog.ADAPTER_CALLBACK;
                ironLog.verbose("adUnitId = " + str);
                int code = adError.getCode();
                String str2 = adError.getMessage() + "( " + code + " )";
                if (adError.getCause() != null) {
                    str2 = str2 + " Caused by - " + adError.getCause();
                }
                ironLog.error("adapterError = " + str2);
                if (AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.containsKey(str)) {
                    ((u) AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.get(str)).k(new com.ironsource.mediationsdk.logger.b(code, AdMobAdapter.this.getProviderName() + "onRewardedAdFailedToShow " + str + " " + str2));
                }
            }

            public void onAdImpression() {
                IronLog ironLog = IronLog.ADAPTER_CALLBACK;
                ironLog.verbose("adUnitId = " + str);
            }

            @Override // com.google.android.gms.ads.FullScreenContentCallback
            public void onAdShowedFullScreenContent() {
                IronLog ironLog = IronLog.ADAPTER_CALLBACK;
                ironLog.verbose("adUnitId = " + str);
                if (AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.containsKey(str)) {
                    ((u) AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.get(str)).onRewardedVideoAdOpened();
                }
            }
        };
    }

    private int getAdMobCoppaValue(String str) {
        return a.b(str) ? 1 : 0;
    }

    private int getAdMobEuValue(String str) {
        return a.b(str) ? 1 : 0;
    }

    private AdSize getAdSize(r rVar, boolean z) {
        String a = rVar.a();
        a.hashCode();
        char c = 65535;
        switch (a.hashCode()) {
            case -387072689:
                if (a.equals("RECTANGLE")) {
                    c = 0;
                    break;
                }
                break;
            case 72205083:
                if (a.equals("LARGE")) {
                    c = 1;
                    break;
                }
                break;
            case 79011241:
                if (a.equals("SMART")) {
                    c = 2;
                    break;
                }
                break;
            case 1951953708:
                if (a.equals("BANNER")) {
                    c = 3;
                    break;
                }
                break;
            case 1999208305:
                if (a.equals("CUSTOM")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return AdSize.MEDIUM_RECTANGLE;
            case 1:
                return AdSize.LARGE_BANNER;
            case 2:
                return z ? AdSize.LEADERBOARD : AdSize.BANNER;
            case 3:
                return AdSize.BANNER;
            case 4:
                return new AdSize(rVar.c(), rVar.b());
            default:
                return null;
        }
    }

    public static s getIntegrationData(Activity activity) {
        s sVar = new s("AdMob", "4.3.20");
        sVar.c = new String[]{AdActivity.CLASS_NAME};
        return sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InterstitialAd getInterstitialAd(String str) {
        if (TextUtils.isEmpty(str) || !this.mAdIdToInterstitialAd.containsKey(str)) {
            return null;
        }
        return this.mAdIdToInterstitialAd.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSDK(JSONObject jSONObject) {
        if (mInitState == InitState.INIT_STATE_NONE || mInitState == InitState.INIT_STATE_IN_PROGRESS) {
            initCallbackListeners.add(this);
        }
        if (mWasInitCalled.compareAndSet(false, true)) {
            mInitState = InitState.INIT_STATE_IN_PROGRESS;
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("");
            if (jSONObject.optBoolean("networkOnlyInit", true)) {
                ironLog.verbose("disableMediationAdapterInitialization");
                MobileAds.disableMediationAdapterInitialization(ContextProvider.getInstance().b());
            }
            if (jSONObject.optBoolean("initResponseRequired", false)) {
                ironLog.verbose("init and wait for callback");
                MobileAds.initialize(ContextProvider.getInstance().a(), new OnInitializationCompleteListener() { // from class: com.ironsource.adapters.admob.AdMobAdapter.1
                    @Override // com.google.android.gms.ads.initialization.OnInitializationCompleteListener
                    public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
                        AdapterStatus adapterStatus = initializationStatus.getAdapterStatusMap().get("com.google.android.gms.ads.MobileAds");
                        if ((adapterStatus != null ? adapterStatus.getInitializationState() : null) == AdapterStatus.State.READY) {
                            IronLog.ADAPTER_API.verbose("initializationStatus = READY");
                            AdMobAdapter.this.initializationSuccess();
                            return;
                        }
                        IronLog.ADAPTER_API.verbose("initializationStatus = NOT READY");
                        AdMobAdapter.this.initializationFailure();
                    }
                });
                return;
            }
            ironLog.verbose("init without callback");
            MobileAds.initialize(ContextProvider.getInstance().a());
            initializationSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializationFailure() {
        mInitState = InitState.INIT_STATE_FAILED;
        Iterator<o> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkInitCallbackFailed(null);
        }
        initCallbackListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializationSuccess() {
        mInitState = InitState.INIT_STATE_SUCCESS;
        Iterator<o> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkInitCallbackSuccess();
        }
        initCallbackListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isInterstitialReadyForAdUnitId(String str) {
        if (this.mInterstitialAdsAvailability.get(str) != null) {
            return this.mInterstitialAdsAvailability.get(str).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNoFillError(int i2) {
        return i2 == 3 || i2 == 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isRewardedVideoAvailableForAdUnitId(String str) {
        return this.mRewardedVideoAdsAvailability.containsKey(str) && this.mRewardedVideoAdsAvailability.get(str).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadRewardedVideoAdFromAdMob(final String str) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("adUnitId = " + str);
        this.mRewardedVideoAdsAvailability.put(str, Boolean.FALSE);
        RewardedAd.load(ContextProvider.getInstance().a(), str, createAdRequest(), new RewardedAdLoadCallback() { // from class: com.ironsource.adapters.admob.AdMobAdapter.5
            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                IronLog ironLog2 = IronLog.ADAPTER_CALLBACK;
                ironLog2.error("adUnitId = " + str);
                int code = loadAdError.getCode();
                String str2 = loadAdError.getMessage() + "( " + code + " )";
                if (AdMobAdapter.this.isNoFillError(code)) {
                    code = 1058;
                    str2 = "No Fill";
                }
                if (loadAdError.getCause() != null) {
                    str2 = str2 + "Caused by " + loadAdError.getCause();
                }
                ironLog2.error("adapterError = " + str2);
                if (AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.containsKey(str)) {
                    ((u) AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.get(str)).i(false);
                    ((u) AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.get(str)).s(new com.ironsource.mediationsdk.logger.b(code, str2));
                }
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                AdMobAdapter.this.mAdIdToRewardedVideoAd.put(str, rewardedAd);
                AdMobAdapter.this.mRewardedVideoAdsAvailability.put(str, Boolean.TRUE);
                IronLog ironLog2 = IronLog.ADAPTER_CALLBACK;
                ironLog2.verbose("adUnitId = " + str);
                if (AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.containsKey(str)) {
                    ((u) AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.get(str)).i(true);
                }
            }
        });
    }

    private void setAdMobMetaDataValue(String str, String str2) {
        String a = a.a(str2, MetaData$MetaDataValueTypes.META_DATA_VALUE_BOOLEAN);
        if (TextUtils.isEmpty(a)) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("MetaData value for key " + str + " is invalid " + str2);
            return;
        }
        str.hashCode();
        if (str.equals("admob_tfcd")) {
            mCoppaValue = Integer.valueOf(getAdMobCoppaValue(a));
            IronLog ironLog2 = IronLog.ADAPTER_API;
            ironLog2.verbose("key = " + str + ", coppaValue = " + mCoppaValue);
        } else if (str.equals("admob_tfua")) {
            mEuValue = Integer.valueOf(getAdMobEuValue(a));
            IronLog ironLog3 = IronLog.ADAPTER_API;
            ironLog3.verbose("key = " + str + ", euValue = " + mEuValue);
        }
        setRequestConfiguration();
    }

    private void setCCPAValue(boolean z) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("value = " + z);
        mCCPAValue = Boolean.valueOf(z);
    }

    private void setRequestConfiguration() {
        RequestConfiguration.Builder builder = MobileAds.getRequestConfiguration().toBuilder();
        Integer num = mCoppaValue;
        RequestConfiguration build = num != null ? builder.setTagForChildDirectedTreatment(num.intValue()).build() : null;
        Integer num2 = mEuValue;
        if (num2 != null) {
            build = builder.setTagForUnderAgeOfConsent(num2.intValue()).build();
        }
        if (build != null) {
            MobileAds.setRequestConfiguration(build);
        }
    }

    public static AdMobAdapter startAdapter(String str) {
        return new AdMobAdapter(str);
    }

    @Override // com.ironsource.mediationsdk.b
    public void destroyBanner(final JSONObject jSONObject) {
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.AdMobAdapter.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String optString = jSONObject.optString("adUnitId");
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose("adUnitId = " + optString);
                    if (AdMobAdapter.this.mAdIdToBannerAd.containsKey(optString)) {
                        ((AdView) AdMobAdapter.this.mAdIdToBannerAd.get(optString)).destroy();
                        AdMobAdapter.this.mAdIdToBannerAd.remove(optString);
                    }
                } catch (Exception e2) {
                    IronLog ironLog2 = IronLog.ADAPTER_API;
                    ironLog2.error("e = " + e2);
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.n0.r
    public void fetchRewardedVideoForAutomaticLoad(final JSONObject jSONObject, u uVar) {
        IronLog.ADAPTER_API.verbose("");
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.AdMobAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                AdMobAdapter.this.loadRewardedVideoAdFromAdMob(jSONObject.optString("adUnitId"));
            }
        });
    }

    @Override // com.ironsource.mediationsdk.b
    public String getCoreSDKVersion() {
        return CORE_SDK_VERSION;
    }

    @Override // com.ironsource.mediationsdk.b
    public String getVersion() {
        return "4.3.20";
    }

    @Override // com.ironsource.mediationsdk.b
    public void initBanners(String str, String str2, final JSONObject jSONObject, final c cVar) {
        final String optString = jSONObject.optString("adUnitId");
        if (TextUtils.isEmpty(optString)) {
            cVar.q(f.c("AdMobAdapter loadBanner adUnitId is empty", "Banner"));
            return;
        }
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("adUnitId = " + optString);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.AdMobAdapter.11
            @Override // java.lang.Runnable
            public void run() {
                AdMobAdapter.this.mAdUnitIdToBannerListener.put(optString, cVar);
                if (AdMobAdapter.mInitState != InitState.INIT_STATE_SUCCESS) {
                    if (AdMobAdapter.mInitState != InitState.INIT_STATE_FAILED) {
                        AdMobAdapter.this.initSDK(jSONObject);
                        return;
                    }
                    IronLog ironLog2 = IronLog.INTERNAL;
                    ironLog2.verbose("onBannerInitFailed - placementName = " + optString);
                    cVar.q(f.c("AdMob sdk init failed", "Banner"));
                    return;
                }
                IronLog ironLog3 = IronLog.INTERNAL;
                ironLog3.verbose("onBannerInitSuccess - placementName = " + optString);
                cVar.onBannerInitSuccess();
            }
        });
    }

    @Override // com.ironsource.mediationsdk.n0.k
    public void initInterstitial(String str, String str2, final JSONObject jSONObject, final n nVar) {
        final String optString = jSONObject.optString("adUnitId");
        if (TextUtils.isEmpty(optString)) {
            nVar.w(f.c("Missing params: 'adUnitId' ", "Interstitial"));
            return;
        }
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("adUnitId = " + optString);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.AdMobAdapter.7
            @Override // java.lang.Runnable
            public void run() {
                AdMobAdapter.this.mAdUnitIdToInterstitialListener.put(optString, nVar);
                if (AdMobAdapter.mInitState != InitState.INIT_STATE_SUCCESS) {
                    if (AdMobAdapter.mInitState != InitState.INIT_STATE_FAILED) {
                        AdMobAdapter.this.initSDK(jSONObject);
                        return;
                    }
                    IronLog ironLog2 = IronLog.INTERNAL;
                    ironLog2.verbose("onInterstitialInitFailed - placementName = " + optString);
                    nVar.w(f.c("AdMob sdk init failed", "Interstitial"));
                    return;
                }
                IronLog ironLog3 = IronLog.INTERNAL;
                ironLog3.verbose("onInterstitialInitSuccess - placementName = " + optString);
                nVar.onInterstitialInitSuccess();
            }
        });
    }

    @Override // com.ironsource.mediationsdk.n0.r
    public void initRewardedVideo(String str, String str2, final JSONObject jSONObject, final u uVar) {
        final String optString = jSONObject.optString("adUnitId");
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("adUnitId = " + optString);
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("adUnitId is empty");
            uVar.i(false);
            return;
        }
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.AdMobAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.put(optString, uVar);
                if (AdMobAdapter.mInitState != InitState.INIT_STATE_SUCCESS) {
                    if (AdMobAdapter.mInitState != InitState.INIT_STATE_FAILED) {
                        AdMobAdapter.this.initSDK(jSONObject);
                        return;
                    }
                    IronLog ironLog2 = IronLog.INTERNAL;
                    ironLog2.verbose("onRewardedVideoAvailabilityChanged(false) - placementName = " + optString);
                    uVar.i(false);
                    return;
                }
                IronLog ironLog3 = IronLog.INTERNAL;
                ironLog3.verbose("loadVideo - placementName = " + optString);
                AdMobAdapter.this.loadRewardedVideoAdFromAdMob(optString);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.n0.k
    public final boolean isInterstitialReady(JSONObject jSONObject) {
        return isInterstitialReadyForAdUnitId(jSONObject.optString("adUnitId"));
    }

    @Override // com.ironsource.mediationsdk.n0.r
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        return isRewardedVideoAvailableForAdUnitId(jSONObject.optString("adUnitId"));
    }

    @Override // com.ironsource.mediationsdk.b
    public void loadBanner(final IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, final c cVar) {
        if (ironSourceBannerLayout == null) {
            IronLog.ADAPTER_API.error("banner == null");
            return;
        }
        final String optString = jSONObject.optString("adUnitId");
        final AdSize adSize = getAdSize(ironSourceBannerLayout.g(), com.ironsource.mediationsdk.c.b(ironSourceBannerLayout.f()));
        if (adSize == null) {
            cVar.b(f.k("AdMob"));
            return;
        }
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("adUnitId = " + optString);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.AdMobAdapter.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AdView adView = new AdView(ironSourceBannerLayout.f());
                    adView.setAdSize(adSize);
                    adView.setAdUnitId(optString);
                    adView.setAdListener(AdMobAdapter.this.createBannerAdListener(adView, optString));
                    AdMobAdapter.this.mAdIdToBannerAd.put(optString, adView);
                    AdRequest createAdRequest = AdMobAdapter.this.createAdRequest();
                    IronLog.ADAPTER_API.verbose("loadAd");
                    adView.loadAd(createAdRequest);
                } catch (Exception e2) {
                    cVar.b(f.e("AdMobAdapter loadBanner exception " + e2.getMessage()));
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.n0.k
    public void loadInterstitial(final JSONObject jSONObject, n nVar) {
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.AdMobAdapter.8
            @Override // java.lang.Runnable
            public void run() {
                final String optString = jSONObject.optString("adUnitId");
                IronLog ironLog = IronLog.ADAPTER_API;
                ironLog.verbose("adUnitId = " + optString);
                AdMobAdapter.this.mInterstitialAdsAvailability.put(optString, Boolean.FALSE);
                InterstitialAd.load(ContextProvider.getInstance().a(), optString, AdMobAdapter.this.createAdRequest(), new InterstitialAdLoadCallback() { // from class: com.ironsource.adapters.admob.AdMobAdapter.8.1
                    @Override // com.google.android.gms.ads.AdLoadCallback
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        IronLog ironLog2 = IronLog.ADAPTER_CALLBACK;
                        ironLog2.verbose("adUnitId = " + optString);
                        int code = loadAdError.getCode();
                        String str = loadAdError.getMessage() + "( " + code + " ) ";
                        if (AdMobAdapter.this.isNoFillError(code)) {
                            code = 1158;
                            str = "No Fill";
                        }
                        if (loadAdError.getCause() != null) {
                            str = str + " Caused by - " + loadAdError.getCause();
                        }
                        ironLog2.error("adapterError = " + str);
                        if (AdMobAdapter.this.mAdUnitIdToInterstitialListener.containsKey(optString)) {
                            ((n) AdMobAdapter.this.mAdUnitIdToInterstitialListener.get(optString)).a(new com.ironsource.mediationsdk.logger.b(code, str));
                        }
                    }

                    @Override // com.google.android.gms.ads.AdLoadCallback
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        String adUnitId = interstitialAd.getAdUnitId();
                        IronLog ironLog2 = IronLog.ADAPTER_CALLBACK;
                        ironLog2.verbose("adUnitId = " + adUnitId);
                        AdMobAdapter.this.mAdIdToInterstitialAd.put(optString, interstitialAd);
                        AdMobAdapter.this.mInterstitialAdsAvailability.put(adUnitId, Boolean.TRUE);
                        interstitialAd.setFullScreenContentCallback(AdMobAdapter.this.createISFullScreenCallback(optString));
                        if (AdMobAdapter.this.mAdUnitIdToInterstitialListener.containsKey(adUnitId)) {
                            ((n) AdMobAdapter.this.mAdUnitIdToInterstitialListener.get(adUnitId)).c();
                        }
                    }
                });
            }
        });
    }

    @Override // com.ironsource.mediationsdk.o
    public void onNetworkInitCallbackFailed(String str) {
        for (n nVar : this.mAdUnitIdToInterstitialListener.values()) {
            nVar.w(f.c("AdMob sdk init failed", "Interstitial"));
        }
        for (c cVar : this.mAdUnitIdToBannerListener.values()) {
            cVar.q(f.c("AdMob sdk init failed", "Banner"));
        }
        for (String str2 : this.mAdUnitIdToRewardedVideoListener.keySet()) {
            this.mAdUnitIdToRewardedVideoListener.get(str2).i(false);
        }
    }

    public void onNetworkInitCallbackLoadSuccess(String str) {
    }

    @Override // com.ironsource.mediationsdk.o
    public void onNetworkInitCallbackSuccess() {
        for (n nVar : this.mAdUnitIdToInterstitialListener.values()) {
            nVar.onInterstitialInitSuccess();
        }
        for (c cVar : this.mAdUnitIdToBannerListener.values()) {
            cVar.onBannerInitSuccess();
        }
        for (String str : this.mAdUnitIdToRewardedVideoListener.keySet()) {
            loadRewardedVideoAdFromAdMob(str);
        }
    }

    @Override // com.ironsource.mediationsdk.b
    public void reloadBanner(IronSourceBannerLayout ironSourceBannerLayout, final JSONObject jSONObject, c cVar) {
        final String optString = jSONObject.optString("adUnitId");
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("adUnitId = " + optString);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.AdMobAdapter.13
            @Override // java.lang.Runnable
            public void run() {
                if (AdMobAdapter.this.mAdIdToBannerAd.get(jSONObject.optString("adUnitId")) != null) {
                    AdRequest createAdRequest = AdMobAdapter.this.createAdRequest();
                    AdView adView = (AdView) AdMobAdapter.this.mAdIdToBannerAd.get(jSONObject.optString("adUnitId"));
                    if (adView == null) {
                        if (AdMobAdapter.this.mAdUnitIdToBannerListener.containsKey(optString)) {
                            int i2 = AdMobAdapter.BN_FAILED_TO_RELOAD_ERROR_CODE;
                            ((c) AdMobAdapter.this.mAdUnitIdToBannerListener.get(optString)).b(new com.ironsource.mediationsdk.logger.b(i2, AdMobAdapter.this.getProviderName() + "reloadBanner missing banner " + optString));
                            return;
                        }
                        return;
                    }
                    adView.loadAd(createAdRequest);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.b
    public void setConsent(boolean z) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("consent = " + z);
        mConsent = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.b
    public void setMetaData(String str, List<String> list) {
        if (list.isEmpty()) {
            return;
        }
        String str2 = list.get(0);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("key = " + str + ", value = " + str2);
        if (a.c(str, str2)) {
            setCCPAValue(a.b(str2));
            return;
        }
        Locale locale = Locale.ENGLISH;
        setAdMobMetaDataValue(str.toLowerCase(locale), str2.toLowerCase(locale));
    }

    @Override // com.ironsource.mediationsdk.n0.k
    public void showInterstitial(final JSONObject jSONObject, final n nVar) {
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.AdMobAdapter.9
            @Override // java.lang.Runnable
            public void run() {
                String optString = jSONObject.optString("adUnitId");
                InterstitialAd interstitialAd = AdMobAdapter.this.getInterstitialAd(optString);
                IronLog ironLog = IronLog.ADAPTER_API;
                ironLog.verbose("adUnitId = " + optString);
                AdMobAdapter.this.mAdIdToInterstitialAd.remove(optString);
                if (interstitialAd != null && AdMobAdapter.this.isInterstitialReadyForAdUnitId(optString)) {
                    ironLog.verbose("show");
                    interstitialAd.show(ContextProvider.getInstance().b());
                } else {
                    n nVar2 = nVar;
                    int i2 = AdMobAdapter.IS_NOT_READY_ERROR_CODE;
                    nVar2.e(new com.ironsource.mediationsdk.logger.b(i2, AdMobAdapter.this.getProviderName() + "showInterstitial is not ready " + optString));
                }
                AdMobAdapter.this.mInterstitialAdsAvailability.put(optString, Boolean.FALSE);
            }
        });
    }

    public void showRewardedVideo(final JSONObject jSONObject, final u uVar) {
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.AdMobAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                final String optString = jSONObject.optString("adUnitId");
                RewardedAd rewardedAd = (RewardedAd) AdMobAdapter.this.mAdIdToRewardedVideoAd.get(optString);
                IronLog ironLog = IronLog.ADAPTER_API;
                ironLog.verbose("adUnitId = " + optString);
                if (rewardedAd != null && AdMobAdapter.this.isRewardedVideoAvailableForAdUnitId(optString)) {
                    AdMobAdapter.this.mAdIdToRewardedVideoAd.remove(optString);
                    rewardedAd.setFullScreenContentCallback(AdMobAdapter.this.createRVFullScreenCallback(optString));
                    rewardedAd.show(ContextProvider.getInstance().b(), new OnUserEarnedRewardListener() { // from class: com.ironsource.adapters.admob.AdMobAdapter.4.1
                        @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
                        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                            IronLog ironLog2 = IronLog.ADAPTER_CALLBACK;
                            ironLog2.verbose("adUnitId = " + optString);
                            if (AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.containsKey(optString)) {
                                ((u) AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.get(optString)).y();
                            }
                        }
                    });
                } else {
                    u uVar2 = uVar;
                    int i2 = AdMobAdapter.RV_NOT_READY_ERROR_CODE;
                    uVar2.k(new com.ironsource.mediationsdk.logger.b(i2, AdMobAdapter.this.getProviderName() + "showRewardedVideo rv not ready " + optString));
                }
                AdMobAdapter.this.mRewardedVideoAdsAvailability.put(optString, Boolean.FALSE);
                uVar.i(false);
            }
        });
    }
}
