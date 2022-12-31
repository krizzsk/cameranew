package com.ironsource.adapters.supersonicads;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.google.firebase.messaging.Constants;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.b;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.metadata.a;
import com.ironsource.mediationsdk.n0.j;
import com.ironsource.mediationsdk.n0.n;
import com.ironsource.mediationsdk.n0.p;
import com.ironsource.mediationsdk.n0.u;
import com.ironsource.mediationsdk.s;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.data.ISNEnums$ProductType;
import d.e.d.i;
import d.e.d.n.c;
import d.e.d.n.e;
import d.e.d.n.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
class SupersonicAdsAdapter extends b implements p, e, c, f, d.e.d.n.b, ContextProvider.a {
    private static final String VERSION = "7.1.6.1";
    private final String AD_VISIBLE_EVENT_NAME;
    private final String APPLICATION_PRIVATE_KEY;
    private final String CAMPAIGN_ID;
    private final String CLIENT_SIDE_CALLBACKS;
    private final String CUSTOM_PARAM_PREFIX;
    private final String CUSTOM_SEGMENT;
    private final String DYNAMIC_CONTROLLER_CONFIG;
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE;
    private final String DYNAMIC_CONTROLLER_URL;
    private final String ITEM_COUNT;
    private final String ITEM_NAME;
    private final String ITEM_SIGNATURE;
    private final String LANGUAGE;
    private final String MAX_VIDEO_LENGTH;
    private final String OW_PLACEMENT_ID;
    private final String SDK_PLUGIN_TYPE;
    private final String SESSION_ID;
    private final String SUPERSONIC_ADS;
    private final String TIMESTAMP;
    private AtomicBoolean isRVInitiated;
    private boolean mConsent;
    private boolean mDidSetConsent;
    private boolean mIsAlreadyShowing;
    private boolean mIsRVAvailable;
    private ISNAdView mIsnAdView;
    private String mMediationSegment;
    private j mOfferwallListener;
    private d.e.d.j mSSAPublisher;
    private static AtomicBoolean mDidSetInitParams = new AtomicBoolean(false);
    private static AtomicBoolean mDidInitSdk = new AtomicBoolean(false);

    private SupersonicAdsAdapter(String str) {
        super(str);
        this.TIMESTAMP = "timestamp";
        this.ITEM_SIGNATURE = "itemSignature";
        this.SDK_PLUGIN_TYPE = "SDKPluginType";
        this.OW_PLACEMENT_ID = "placementId";
        this.SESSION_ID = "sessionid";
        this.mIsRVAvailable = false;
        this.SUPERSONIC_ADS = "SupersonicAds";
        this.DYNAMIC_CONTROLLER_URL = "controllerUrl";
        this.DYNAMIC_CONTROLLER_DEBUG_MODE = "debugMode";
        this.DYNAMIC_CONTROLLER_CONFIG = "controllerConfig";
        this.LANGUAGE = IjkMediaMeta.IJKM_KEY_LANGUAGE;
        this.MAX_VIDEO_LENGTH = "maxVideoLength";
        this.CAMPAIGN_ID = Constants.FirelogAnalytics.PARAM_CAMPAIGN_ID;
        this.CUSTOM_PARAM_PREFIX = "custom_";
        this.CUSTOM_SEGMENT = "custom_Segment";
        this.ITEM_NAME = "itemName";
        this.ITEM_COUNT = "itemCount";
        this.APPLICATION_PRIVATE_KEY = "privateKey";
        this.CLIENT_SIDE_CALLBACKS = "useClientSideCallbacks";
        this.AD_VISIBLE_EVENT_NAME = "impressions";
        IronLog.INTERNAL.verbose("");
        this.isRVInitiated = new AtomicBoolean(false);
        ContextProvider.getInstance().d(this);
        this.mIsAlreadyShowing = false;
    }

    private void addItemNameCountSignature(HashMap<String, String> hashMap, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("itemName");
            int optInt = jSONObject.optInt("itemCount", -1);
            String optString2 = jSONObject.optString("privateKey");
            boolean z = true;
            boolean z2 = false;
            if (TextUtils.isEmpty(optString)) {
                z = false;
            } else {
                hashMap.put("itemName", optString);
            }
            if (TextUtils.isEmpty(optString2)) {
                z = false;
            }
            if (optInt != -1) {
                hashMap.put("itemCount", String.valueOf(optInt));
                z2 = z;
            }
            if (z2) {
                int i2 = IronSourceUtils.i();
                hashMap.put("timestamp", String.valueOf(i2));
                hashMap.put("itemSignature", createItemSig(i2, optString, optInt, optString2));
            }
        } catch (Exception e2) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error(" addItemNameCountSignature" + e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyConsent(boolean z) {
        if (this.mSSAPublisher == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("gdprConsentStatus", String.valueOf(z));
            jSONObject.put("demandSourceName", getProviderName());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.mSSAPublisher.b(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007b, code lost:
        if (r10 != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.ironsource.sdk.ISNAdView.ISNAdView createBanner(android.app.Activity r9, com.ironsource.mediationsdk.r r10, com.ironsource.mediationsdk.n0.c r11) {
        /*
            r8 = this;
            java.lang.String r0 = r10.a()
            int r1 = r0.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r1) {
                case -387072689: goto L37;
                case 72205083: goto L2d;
                case 79011241: goto L23;
                case 1951953708: goto L19;
                case 1999208305: goto Lf;
                default: goto Le;
            }
        Le:
            goto L41
        Lf:
            java.lang.String r1 = "CUSTOM"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L41
            r1 = 3
            goto L42
        L19:
            java.lang.String r1 = "BANNER"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L41
            r1 = 0
            goto L42
        L23:
            java.lang.String r1 = "SMART"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L41
            r1 = 2
            goto L42
        L2d:
            java.lang.String r1 = "LARGE"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L41
            r1 = 1
            goto L42
        L37:
            java.lang.String r1 = "RECTANGLE"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L41
            r1 = 4
            goto L42
        L41:
            r1 = -1
        L42:
            r5 = 90
            r6 = 50
            r7 = 320(0x140, float:4.48E-43)
            if (r1 == 0) goto L7e
            if (r1 == r4) goto L80
            if (r1 == r3) goto L71
            java.lang.String r3 = "SupersonicAds"
            r4 = 0
            if (r1 == r2) goto L5d
            if (r11 == 0) goto L5c
            com.ironsource.mediationsdk.logger.b r9 = com.ironsource.mediationsdk.utils.f.k(r3)
            r11.b(r9)
        L5c:
            return r4
        L5d:
            int r10 = r10.b()
            if (r10 == r6) goto L6f
            if (r10 == r5) goto L6f
            if (r11 == 0) goto L6e
            com.ironsource.mediationsdk.logger.b r9 = com.ironsource.mediationsdk.utils.f.k(r3)
            r11.b(r9)
        L6e:
            return r4
        L6f:
            r5 = r10
            goto L80
        L71:
            boolean r10 = com.ironsource.mediationsdk.c.b(r9)
            if (r10 == 0) goto L7b
            r11 = 728(0x2d8, float:1.02E-42)
            r7 = 728(0x2d8, float:1.02E-42)
        L7b:
            if (r10 == 0) goto L7e
            goto L80
        L7e:
            r5 = 50
        L80:
            int r10 = com.ironsource.mediationsdk.c.a(r9, r7)
            int r11 = com.ironsource.mediationsdk.c.a(r9, r5)
            d.e.d.b r1 = new d.e.d.b
            r1.<init>(r10, r11, r0)
            d.e.d.j r10 = r8.mSSAPublisher
            com.ironsource.sdk.ISNAdView.ISNAdView r9 = r10.g(r9, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.supersonicads.SupersonicAdsAdapter.createBanner(android.app.Activity, com.ironsource.mediationsdk.r, com.ironsource.mediationsdk.n0.c):com.ironsource.sdk.ISNAdView.ISNAdView");
    }

    private String createItemSig(int i2, String str, int i3, String str2) {
        return IronSourceUtils.C(i2 + str + i3 + str2);
    }

    private String createMinimumOfferCommissionSig(double d2, String str) {
        return IronSourceUtils.C(d2 + str);
    }

    private String createUserCreationDateSig(String str, String str2, String str3) {
        return IronSourceUtils.C(str + str2 + str3);
    }

    public static String getAdapterSDKVersion() {
        return com.ironsource.sdk.utils.f.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> getBannerExtraParams(JSONObject jSONObject) {
        return getGenenralExtraParams();
    }

    private HashMap<String, String> getGenenralExtraParams() {
        HashMap<String, String> hashMap = new HashMap<>();
        String pluginType = getPluginType();
        if (!TextUtils.isEmpty(pluginType)) {
            hashMap.put("SDKPluginType", pluginType);
        }
        return hashMap;
    }

    private HashMap<String, String> getInitParams() {
        HashMap<String, String> hashMap = new HashMap<>();
        String pluginType = getPluginType();
        if (!TextUtils.isEmpty(pluginType)) {
            hashMap.put("SDKPluginType", pluginType);
        }
        if (!TextUtils.isEmpty(this.mMediationSegment)) {
            hashMap.put("custom_Segment", this.mMediationSegment);
        }
        if (!TextUtils.isEmpty(IronSourceObject.getInstance().B())) {
            hashMap.put("sessionid", IronSourceObject.getInstance().B());
        }
        return hashMap;
    }

    public static s getIntegrationData(Activity activity) {
        s sVar = new s("SupersonicAds", VERSION);
        sVar.c = new String[]{"com.ironsource.sdk.controller.ControllerActivity", "com.ironsource.sdk.controller.InterstitialActivity", "com.ironsource.sdk.controller.OpenUrlActivity"};
        sVar.f5647d = new String[]{"com.ironsource.lifecycle.IronsourceLifecycleProvider"};
        return sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> getInterstitialExtraParams() {
        return getGenenralExtraParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> getOfferwallExtraParams(JSONObject jSONObject) {
        HashMap<String, String> genenralExtraParams = getGenenralExtraParams();
        String optString = jSONObject.optString(IjkMediaMeta.IJKM_KEY_LANGUAGE);
        if (!TextUtils.isEmpty(optString)) {
            genenralExtraParams.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, optString);
        }
        genenralExtraParams.put("useClientSideCallbacks", String.valueOf(SupersonicConfig.getConfigObj().getClientSideCallbacks()));
        Map<String, String> offerwallCustomParams = SupersonicConfig.getConfigObj().getOfferwallCustomParams();
        if (offerwallCustomParams != null && !offerwallCustomParams.isEmpty()) {
            genenralExtraParams.putAll(offerwallCustomParams);
        }
        addItemNameCountSignature(genenralExtraParams, jSONObject);
        return genenralExtraParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> getRewardedVideoExtraParams(JSONObject jSONObject) {
        HashMap<String, String> genenralExtraParams = getGenenralExtraParams();
        String optString = jSONObject.optString(IjkMediaMeta.IJKM_KEY_LANGUAGE);
        if (!TextUtils.isEmpty(optString)) {
            genenralExtraParams.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, optString);
        }
        String optString2 = jSONObject.optString("maxVideoLength");
        if (!TextUtils.isEmpty(optString2)) {
            genenralExtraParams.put("maxVideoLength", optString2);
        }
        String optString3 = jSONObject.optString(Constants.FirelogAnalytics.PARAM_CAMPAIGN_ID);
        if (!TextUtils.isEmpty(optString3)) {
            genenralExtraParams.put(Constants.FirelogAnalytics.PARAM_CAMPAIGN_ID, optString3);
        }
        if (!TextUtils.isEmpty(this.mMediationSegment)) {
            genenralExtraParams.put("custom_Segment", this.mMediationSegment);
        }
        addItemNameCountSignature(genenralExtraParams, jSONObject);
        Map<String, String> rewardedVideoCustomParams = SupersonicConfig.getConfigObj().getRewardedVideoCustomParams();
        if (rewardedVideoCustomParams != null && !rewardedVideoCustomParams.isEmpty()) {
            genenralExtraParams.putAll(rewardedVideoCustomParams);
        }
        return genenralExtraParams;
    }

    private boolean isValidMetaData(String str, String str2) {
        if (str.equals("do_not_sell")) {
            return a.c(str, str2);
        }
        return true;
    }

    private void setParamsBeforeInit(JSONObject jSONObject) {
        if (mDidSetInitParams.compareAndSet(false, true)) {
            com.ironsource.sdk.utils.f.F(jSONObject.optString("controllerUrl"));
            int optInt = jSONObject.optInt("debugMode", 0);
            if (isAdaptersDebugEnabled()) {
                optInt = 3;
            }
            com.ironsource.sdk.utils.f.G(optInt);
            com.ironsource.sdk.utils.f.E(jSONObject.optString("controllerConfig", ""));
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + "setting controller url to  " + jSONObject.optString("controllerUrl"));
            ironLog.verbose(getProviderName() + "setting controller config to  " + jSONObject.optString("controllerConfig"));
            ironLog.verbose(getProviderName() + "setting debug mode to " + optInt);
        }
    }

    public static SupersonicAdsAdapter startAdapter(String str) {
        return new SupersonicAdsAdapter(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.b
    public void addBannerListener(com.ironsource.mediationsdk.n0.c cVar) {
        this.mAllBannerSmashes.add(cVar);
    }

    @Override // com.ironsource.mediationsdk.b
    public void destroyBanner(JSONObject jSONObject) {
        this.mIsAlreadyShowing = false;
        if (this.mIsnAdView != null) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " mIsnAdView.performCleanup");
            this.mIsnAdView.p();
            this.mIsnAdView = null;
        }
    }

    @Override // com.ironsource.mediationsdk.b
    public void earlyInit(String str, String str2, JSONObject jSONObject) {
        IronSourceUtils.j0(getProviderName() + ": earlyInit");
        if (mDidInitSdk.compareAndSet(false, true)) {
            if (isAdaptersDebugEnabled()) {
                com.ironsource.sdk.utils.f.G(3);
            } else {
                com.ironsource.sdk.utils.f.G(jSONObject.optInt("debugMode", 0));
            }
            com.ironsource.sdk.utils.f.F(jSONObject.optString("controllerUrl"));
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " IronSourceNetwork setting controller url to  " + jSONObject.optString("controllerUrl"));
            com.ironsource.sdk.utils.f.E(jSONObject.optString("controllerConfig", ""));
            ironLog.verbose(getProviderName() + " IronSourceNetwork setting controller config to  " + jSONObject.optString("controllerConfig"));
            HashMap<String, String> initParams = getInitParams();
            d.e.d.e.i(ContextProvider.getInstance().b(), IronSourceObject.getInstance().u(), str2, initParams);
            ironLog.verbose("initSDK with appKey=" + IronSourceObject.getInstance().u() + " userId=" + str2 + " parameters " + initParams);
        }
    }

    @Override // com.ironsource.mediationsdk.n0.r
    public void fetchRewardedVideoForAutomaticLoad(JSONObject jSONObject, u uVar) {
        IronLog.ADAPTER_API.verbose(getProviderName());
        Iterator<u> it = this.mAllRewardedVideoSmashes.iterator();
        while (it.hasNext()) {
            u next = it.next();
            if (next != null) {
                next.i(this.mIsRVAvailable);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.b
    public String getCoreSDKVersion() {
        return com.ironsource.sdk.utils.f.t();
    }

    public void getOfferwallCredits() {
        if (this.mSSAPublisher != null) {
            IronSourceObject.getInstance().u();
            String v = IronSourceObject.getInstance().v();
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " mSSAPublisher.getOfferWallCredits userId=" + v);
            this.mSSAPublisher.e(IronSourceObject.getInstance().u(), v, this);
            return;
        }
        IronLog.INTERNAL.error("Please call init before calling getOfferwallCredits");
    }

    @Override // com.ironsource.mediationsdk.b
    public String getVersion() {
        return VERSION;
    }

    @Override // com.ironsource.mediationsdk.b
    public void initBanners(String str, String str2, final JSONObject jSONObject, com.ironsource.mediationsdk.n0.c cVar) {
        IronLog.ADAPTER_API.verbose(getProviderName());
        setParamsBeforeInit(jSONObject);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.supersonicads.SupersonicAdsAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String F = IronSourceUtils.F();
                    HashMap bannerExtraParams = SupersonicAdsAdapter.this.getBannerExtraParams(jSONObject);
                    SupersonicAdsAdapter.this.mSSAPublisher = i.a(ContextProvider.getInstance().b());
                    if (SupersonicAdsAdapter.this.mDidSetConsent) {
                        SupersonicAdsAdapter supersonicAdsAdapter = SupersonicAdsAdapter.this;
                        supersonicAdsAdapter.applyConsent(supersonicAdsAdapter.mConsent);
                    }
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose(SupersonicAdsAdapter.this.getProviderName() + " mSSAPublisher.initBanner userId=" + F);
                    SupersonicAdsAdapter.this.mSSAPublisher.v(IronSourceObject.getInstance().u(), F, SupersonicAdsAdapter.this.getProviderName(), bannerExtraParams, SupersonicAdsAdapter.this);
                    SupersonicAdsAdapter.mDidInitSdk.set(true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    SupersonicAdsAdapter.this.onBannerInitFailed(e2.getMessage());
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.n0.k
    public void initInterstitial(String str, String str2, JSONObject jSONObject, n nVar) {
        setParamsBeforeInit(jSONObject);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.supersonicads.SupersonicAdsAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String F = IronSourceUtils.F();
                    SupersonicAdsAdapter.this.mSSAPublisher = i.a(ContextProvider.getInstance().b());
                    HashMap interstitialExtraParams = SupersonicAdsAdapter.this.getInterstitialExtraParams();
                    if (SupersonicAdsAdapter.this.mDidSetConsent) {
                        SupersonicAdsAdapter supersonicAdsAdapter = SupersonicAdsAdapter.this;
                        supersonicAdsAdapter.applyConsent(supersonicAdsAdapter.mConsent);
                    }
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose(SupersonicAdsAdapter.this.getProviderName() + " mSSAPublisher.initInterstitial userId=" + F);
                    SupersonicAdsAdapter.this.mSSAPublisher.E(IronSourceObject.getInstance().u(), F, SupersonicAdsAdapter.this.getProviderName(), interstitialExtraParams, SupersonicAdsAdapter.this);
                    SupersonicAdsAdapter.mDidInitSdk.set(true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    SupersonicAdsAdapter.this.onInterstitialInitFailed(e2.getMessage());
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.n0.p
    public void initOfferwall(String str, final String str2, final JSONObject jSONObject) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(getProviderName() + " userId=" + str2);
        setParamsBeforeInit(jSONObject);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.supersonicads.SupersonicAdsAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HashMap offerwallExtraParams = SupersonicAdsAdapter.this.getOfferwallExtraParams(jSONObject);
                    SupersonicAdsAdapter.this.mSSAPublisher = i.a(ContextProvider.getInstance().b());
                    if (SupersonicAdsAdapter.this.mDidSetConsent) {
                        SupersonicAdsAdapter supersonicAdsAdapter = SupersonicAdsAdapter.this;
                        supersonicAdsAdapter.applyConsent(supersonicAdsAdapter.mConsent);
                    }
                    IronLog ironLog2 = IronLog.ADAPTER_API;
                    ironLog2.verbose(SupersonicAdsAdapter.this.getProviderName() + " mSSAPublisher.initOfferWall");
                    SupersonicAdsAdapter.this.mSSAPublisher.d(IronSourceObject.getInstance().u(), str2, offerwallExtraParams, SupersonicAdsAdapter.this);
                    SupersonicAdsAdapter.mDidInitSdk.set(true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    IronLog ironLog3 = IronLog.ADAPTER_API;
                    ironLog3.error(SupersonicAdsAdapter.this.getProviderName() + ":initOfferwall(userId:" + str2 + ")" + e2);
                    j jVar = SupersonicAdsAdapter.this.mOfferwallListener;
                    jVar.q(false, com.ironsource.mediationsdk.utils.f.c("Adapter initialization failure - " + SupersonicAdsAdapter.this.getProviderName() + " - " + e2.getMessage(), "Offerwall"));
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.n0.r
    public void initRewardedVideo(String str, String str2, final JSONObject jSONObject, u uVar) {
        if (this.isRVInitiated.compareAndSet(false, true)) {
            setParamsBeforeInit(jSONObject);
            postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.supersonicads.SupersonicAdsAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String F = IronSourceUtils.F();
                        SupersonicAdsAdapter.this.mSSAPublisher = i.a(ContextProvider.getInstance().b());
                        HashMap rewardedVideoExtraParams = SupersonicAdsAdapter.this.getRewardedVideoExtraParams(jSONObject);
                        if (SupersonicAdsAdapter.this.mDidSetConsent) {
                            SupersonicAdsAdapter supersonicAdsAdapter = SupersonicAdsAdapter.this;
                            supersonicAdsAdapter.applyConsent(supersonicAdsAdapter.mConsent);
                        }
                        IronLog ironLog = IronLog.ADAPTER_API;
                        ironLog.verbose(SupersonicAdsAdapter.this.getProviderName() + " mSSAPublisher.initRewardedVideo userId=" + F);
                        SupersonicAdsAdapter.this.mSSAPublisher.q(IronSourceObject.getInstance().u(), F, SupersonicAdsAdapter.this.getProviderName(), rewardedVideoExtraParams, SupersonicAdsAdapter.this);
                        SupersonicAdsAdapter.mDidInitSdk.set(true);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        SupersonicAdsAdapter.this.onRVInitFail("initRewardedVideo");
                    }
                }
            });
            return;
        }
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(getProviderName() + " adapter already initiated");
        fetchRewardedVideoForAutomaticLoad(jSONObject, uVar);
    }

    @Override // com.ironsource.mediationsdk.n0.k
    public boolean isInterstitialReady(JSONObject jSONObject) {
        d.e.d.j jVar = this.mSSAPublisher;
        return jVar != null && jVar.h(getProviderName());
    }

    public boolean isOfferwallAvailable() {
        return true;
    }

    @Override // com.ironsource.mediationsdk.n0.r
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        return this.mIsRVAvailable;
    }

    @Override // com.ironsource.mediationsdk.b
    public void loadBanner(final IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, com.ironsource.mediationsdk.n0.c cVar) {
        try {
            if (this.mSSAPublisher == null) {
                IronLog.INTERNAL.error("Please call initBanner before calling loadBanner");
                Iterator<com.ironsource.mediationsdk.n0.c> it = this.mAllBannerSmashes.iterator();
                while (it.hasNext()) {
                    com.ironsource.mediationsdk.n0.c next = it.next();
                    if (next != null) {
                        next.b(com.ironsource.mediationsdk.utils.f.e("Load was called before Init"));
                    }
                }
            }
            this.mActiveBannerSmash = cVar;
            ISNAdView iSNAdView = this.mIsnAdView;
            if (iSNAdView != null && !this.mIsAlreadyShowing) {
                iSNAdView.p();
                this.mIsnAdView = null;
            }
            final JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("demandSourceName", getProviderName());
            jSONObject2.put("productType", ISNEnums$ProductType.Banner);
            postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.supersonicads.SupersonicAdsAdapter.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (!SupersonicAdsAdapter.this.mIsAlreadyShowing) {
                            SupersonicAdsAdapter supersonicAdsAdapter = SupersonicAdsAdapter.this;
                            supersonicAdsAdapter.mIsnAdView = supersonicAdsAdapter.createBanner(ironSourceBannerLayout.f(), ironSourceBannerLayout.g(), ((b) SupersonicAdsAdapter.this).mActiveBannerSmash);
                        }
                        if (SupersonicAdsAdapter.this.mIsnAdView != null) {
                            IronLog.ADAPTER_API.verbose("mIsnAdView.loadAd");
                            SupersonicAdsAdapter.this.mIsnAdView.m(jSONObject2);
                        }
                    } catch (Exception e2) {
                        com.ironsource.mediationsdk.logger.b e3 = com.ironsource.mediationsdk.utils.f.e("Banner Load Fail, " + SupersonicAdsAdapter.this.getProviderName() + " - " + e2.getMessage());
                        if (((b) SupersonicAdsAdapter.this).mActiveBannerSmash != null) {
                            ((b) SupersonicAdsAdapter.this).mActiveBannerSmash.b(e3);
                        }
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ironsource.mediationsdk.n0.k
    public void loadInterstitial(JSONObject jSONObject, n nVar) {
        if (this.mSSAPublisher != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("demandSourceName", getProviderName());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " mSSAPublisher.loadInterstitial");
            this.mSSAPublisher.t(jSONObject2);
            return;
        }
        IronLog.INTERNAL.error("Please call initInterstitial before calling loadInterstitial");
        Iterator<n> it = this.mAllInterstitialSmashes.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next != null) {
                next.a(com.ironsource.mediationsdk.utils.f.e("Load was called before Init"));
            }
        }
    }

    @Override // d.e.d.n.b
    public void onBannerClick() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        com.ironsource.mediationsdk.n0.c cVar = this.mActiveBannerSmash;
        if (cVar != null) {
            cVar.l();
        }
    }

    @Override // d.e.d.n.b
    public void onBannerInitFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        Iterator<com.ironsource.mediationsdk.n0.c> it = this.mAllBannerSmashes.iterator();
        while (it.hasNext()) {
            com.ironsource.mediationsdk.n0.c next = it.next();
            if (next != null) {
                next.q(com.ironsource.mediationsdk.utils.f.c(str, "Banner"));
            }
        }
    }

    @Override // d.e.d.n.b
    public void onBannerInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        Iterator<com.ironsource.mediationsdk.n0.c> it = this.mAllBannerSmashes.iterator();
        while (it.hasNext()) {
            com.ironsource.mediationsdk.n0.c next = it.next();
            if (next != null) {
                next.onBannerInitSuccess();
            }
        }
    }

    @Override // d.e.d.n.b
    public void onBannerLoadFail(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        Iterator<com.ironsource.mediationsdk.n0.c> it = this.mAllBannerSmashes.iterator();
        while (it.hasNext()) {
            com.ironsource.mediationsdk.n0.c next = it.next();
            if (next != null) {
                next.b(com.ironsource.mediationsdk.utils.f.c(str, "Banner"));
            }
        }
    }

    @Override // d.e.d.n.b
    public void onBannerLoadSuccess() {
        ISNAdView iSNAdView;
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        this.mIsAlreadyShowing = true;
        Iterator<com.ironsource.mediationsdk.n0.c> it = this.mAllBannerSmashes.iterator();
        while (it.hasNext()) {
            com.ironsource.mediationsdk.n0.c next = it.next();
            if (next != null && (iSNAdView = this.mIsnAdView) != null && iSNAdView.l() != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mIsnAdView.l().b(), this.mIsnAdView.l().a());
                layoutParams.gravity = 17;
                next.r(this.mIsnAdView, layoutParams);
            }
        }
        com.ironsource.mediationsdk.n0.c cVar = this.mActiveBannerSmash;
        if (cVar != null) {
            cVar.C();
        }
    }

    @Override // d.e.d.n.e
    public void onGetOWCreditsFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mOfferwallListener != null) {
            this.mOfferwallListener.m(com.ironsource.mediationsdk.utils.f.b(str));
        }
    }

    @Override // d.e.d.n.c
    public void onInterstitialAdRewarded(String str, int i2) {
    }

    @Override // d.e.d.n.c
    public void onInterstitialClick() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        n nVar = this.mActiveInterstitialSmash;
        if (nVar != null) {
            nVar.g();
        }
    }

    @Override // d.e.d.n.c
    public void onInterstitialClose() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        n nVar = this.mActiveInterstitialSmash;
        if (nVar != null) {
            nVar.f();
        }
    }

    @Override // d.e.d.n.c
    public void onInterstitialEventNotificationReceived(String str, JSONObject jSONObject) {
        n nVar;
        if (jSONObject != null) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(getProviderName() + " " + str + " extData: " + jSONObject.toString());
            if (TextUtils.isEmpty(str) || !"impressions".equals(str) || (nVar = this.mActiveInterstitialSmash) == null) {
                return;
            }
            nVar.p();
        }
    }

    @Override // d.e.d.n.c
    public void onInterstitialInitFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        Iterator<n> it = this.mAllInterstitialSmashes.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next != null) {
                next.w(com.ironsource.mediationsdk.utils.f.c(str, "Interstitial"));
            }
        }
    }

    @Override // d.e.d.n.c
    public void onInterstitialInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        Iterator<n> it = this.mAllInterstitialSmashes.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next != null) {
                next.onInterstitialInitSuccess();
            }
        }
    }

    @Override // d.e.d.n.c
    public void onInterstitialLoadFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        Iterator<n> it = this.mAllInterstitialSmashes.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next != null) {
                next.a(com.ironsource.mediationsdk.utils.f.e(str));
            }
        }
    }

    @Override // d.e.d.n.c
    public void onInterstitialLoadSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        Iterator<n> it = this.mAllInterstitialSmashes.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next != null) {
                next.c();
            }
        }
    }

    @Override // d.e.d.n.c
    public void onInterstitialOpen() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        n nVar = this.mActiveInterstitialSmash;
        if (nVar != null) {
            nVar.h();
        }
    }

    @Override // d.e.d.n.c
    public void onInterstitialShowFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        n nVar = this.mActiveInterstitialSmash;
        if (nVar != null) {
            nVar.e(com.ironsource.mediationsdk.utils.f.i("Interstitial", str));
        }
    }

    @Override // d.e.d.n.c
    public void onInterstitialShowSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        n nVar = this.mActiveInterstitialSmash;
        if (nVar != null) {
            nVar.j();
        }
    }

    @Override // d.e.d.n.e
    public void onOWAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        j jVar = this.mOfferwallListener;
        if (jVar != null) {
            jVar.s();
        }
    }

    @Override // d.e.d.n.e
    public boolean onOWAdCredited(int i2, int i3, boolean z) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        j jVar = this.mOfferwallListener;
        return jVar != null && jVar.u(i2, i3, z);
    }

    @Override // d.e.d.n.e
    public void onOWShowFail(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mOfferwallListener != null) {
            this.mOfferwallListener.r(com.ironsource.mediationsdk.utils.f.b(str));
        }
    }

    @Override // d.e.d.n.e
    public void onOWShowSuccess(String str) {
        if (TextUtils.isEmpty(str)) {
            IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        } else {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(getProviderName() + ":onOWShowSuccess(placementId:" + str + ")");
        }
        j jVar = this.mOfferwallListener;
        if (jVar != null) {
            jVar.l();
        }
    }

    @Override // d.e.d.n.e
    public void onOfferwallEventNotificationReceived(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        }
    }

    @Override // d.e.d.n.e
    public void onOfferwallInitFail(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mOfferwallListener != null) {
            this.mOfferwallListener.q(false, com.ironsource.mediationsdk.utils.f.b(str));
        }
    }

    @Override // d.e.d.n.e
    public void onOfferwallInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        j jVar = this.mOfferwallListener;
        if (jVar != null) {
            jVar.n(true);
        }
    }

    public void onPause(Activity activity) {
        if (this.mSSAPublisher != null) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " mSSAPublisher.onPause");
            this.mSSAPublisher.c(activity);
        }
    }

    @Override // d.e.d.n.f
    public void onRVAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        u uVar = this.mActiveRewardedVideoSmash;
        if (uVar != null) {
            uVar.v();
        }
    }

    @Override // d.e.d.n.f
    public void onRVAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        u uVar = this.mActiveRewardedVideoSmash;
        if (uVar != null) {
            uVar.onRewardedVideoAdClosed();
        }
    }

    @Override // d.e.d.n.f
    public void onRVAdCredited(int i2) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        u uVar = this.mActiveRewardedVideoSmash;
        if (uVar != null) {
            uVar.y();
        }
    }

    @Override // d.e.d.n.f
    public void onRVAdOpened() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        u uVar = this.mActiveRewardedVideoSmash;
        if (uVar != null) {
            uVar.onRewardedVideoAdOpened();
        }
    }

    @Override // d.e.d.n.f
    public void onRVEventNotificationReceived(String str, JSONObject jSONObject) {
        u uVar;
        if (jSONObject != null) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(getProviderName() + " " + str + " extData: " + jSONObject.toString());
        }
        if (TextUtils.isEmpty(str) || !"impressions".equals(str) || (uVar = this.mActiveRewardedVideoSmash) == null) {
            return;
        }
        uVar.u();
    }

    @Override // d.e.d.n.f
    public void onRVInitFail(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        Iterator<u> it = this.mAllRewardedVideoSmashes.iterator();
        while (it.hasNext()) {
            u next = it.next();
            if (next != null) {
                next.i(false);
            }
        }
    }

    @Override // d.e.d.n.f
    public void onRVInitSuccess(com.ironsource.sdk.data.a aVar) {
        int i2;
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        try {
            i2 = Integer.parseInt(aVar.m());
        } catch (NumberFormatException e2) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("parseInt()" + e2);
            i2 = 0;
        }
        boolean z = i2 > 0;
        this.mIsRVAvailable = z;
        Iterator<u> it = this.mAllRewardedVideoSmashes.iterator();
        while (it.hasNext()) {
            u next = it.next();
            if (next != null) {
                next.i(z);
            }
        }
    }

    @Override // d.e.d.n.f
    public void onRVNoMoreOffers() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        this.mIsRVAvailable = false;
        Iterator<u> it = this.mAllRewardedVideoSmashes.iterator();
        while (it.hasNext()) {
            u next = it.next();
            if (next != null) {
                next.i(false);
            }
        }
    }

    @Override // d.e.d.n.f
    public void onRVShowFail(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        u uVar = this.mActiveRewardedVideoSmash;
        if (uVar != null) {
            uVar.k(new com.ironsource.mediationsdk.logger.b(509, str));
        }
    }

    public void onResume(Activity activity) {
        if (this.mSSAPublisher != null) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " mSSAPublisher.onResume");
            this.mSSAPublisher.a(activity);
        }
    }

    @Override // com.ironsource.mediationsdk.b
    public void reloadBanner(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, com.ironsource.mediationsdk.n0.c cVar) {
        try {
            if (this.mIsnAdView != null) {
                IronLog.ADAPTER_API.verbose("mIsnAdView.loadAd");
                this.mIsnAdView.m(jSONObject);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error(getProviderName() + " reloadBanner Failed to reload banner ad");
        }
    }

    @Override // com.ironsource.mediationsdk.b
    protected void removeBannerListener(com.ironsource.mediationsdk.n0.c cVar) {
        this.mAllBannerSmashes.remove(cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.b
    public void setConsent(boolean z) {
        IronLog ironLog = IronLog.ADAPTER_API;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(": setConsent (");
        sb.append(z ? "true" : "false");
        sb.append(")");
        ironLog.verbose(sb.toString());
        this.mDidSetConsent = true;
        this.mConsent = z;
        applyConsent(z);
    }

    @Override // com.ironsource.mediationsdk.n0.p
    public void setInternalOfferwallListener(j jVar) {
        this.mOfferwallListener = jVar;
    }

    @Override // com.ironsource.mediationsdk.b
    public void setMediationSegment(String str) {
        this.mMediationSegment = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.b
    public void setMediationState(AbstractSmash.MEDIATION_STATE mediation_state, String str) {
        if (this.mSSAPublisher != null) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + ": setMediationState(" + str + " , " + getProviderName() + " , " + mediation_state.getValue() + ")");
            this.mSSAPublisher.H(str, getProviderName(), mediation_state.getValue());
        }
    }

    @Override // com.ironsource.mediationsdk.b
    protected void setMetaData(String str, String str2) {
        if (mDidInitSdk.get()) {
            return;
        }
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("key=" + str + ", value=" + str2);
        if (!isValidMetaData(str, str2)) {
            ironLog.verbose("not valid");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, str2);
            d.e.d.e.r(jSONObject);
        } catch (JSONException e2) {
            IronLog ironLog2 = IronLog.ADAPTER_API;
            ironLog2.error("error - " + e2);
            e2.printStackTrace();
        }
    }

    @Override // com.ironsource.mediationsdk.n0.k
    public void showInterstitial(JSONObject jSONObject, n nVar) {
        this.mActiveInterstitialSmash = nVar;
        if (this.mSSAPublisher != null) {
            int b = SessionDepthManager.getInstance().b(2);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("demandSourceName", getProviderName());
                jSONObject2.put("sessionDepth", b);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " mSSAPublisher.showInterstitial");
            this.mSSAPublisher.o(jSONObject2);
            return;
        }
        IronLog.INTERNAL.error("Please call loadInterstitialForBidding before calling showInterstitial");
        n nVar2 = this.mActiveInterstitialSmash;
        if (nVar2 != null) {
            nVar2.e(com.ironsource.mediationsdk.utils.f.f("Interstitial"));
        }
    }

    public void showOfferwall(String str, JSONObject jSONObject) {
        HashMap<String, String> offerwallExtraParams = getOfferwallExtraParams(jSONObject);
        if (offerwallExtraParams != null) {
            offerwallExtraParams.put("placementId", str);
        }
        if (this.mSSAPublisher != null) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " mSSAPublisher.showOfferWall");
            this.mSSAPublisher.f(ContextProvider.getInstance().b(), offerwallExtraParams);
            return;
        }
        IronLog.INTERNAL.error("Please call init before calling showOfferwall");
    }

    public void showRewardedVideo(JSONObject jSONObject, u uVar) {
        this.mActiveRewardedVideoSmash = uVar;
        if (this.mSSAPublisher != null) {
            int b = SessionDepthManager.getInstance().b(1);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("demandSourceName", getProviderName());
                jSONObject2.put("sessionDepth", b);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " mSSAPublisher.showRewardedVideo");
            this.mSSAPublisher.x(jSONObject2);
            return;
        }
        this.mIsRVAvailable = false;
        if (uVar != null) {
            uVar.k(com.ironsource.mediationsdk.utils.f.f("Rewarded Video"));
        }
        Iterator<u> it = this.mAllRewardedVideoSmashes.iterator();
        while (it.hasNext()) {
            u next = it.next();
            if (next != null) {
                next.i(false);
            }
        }
    }
}
