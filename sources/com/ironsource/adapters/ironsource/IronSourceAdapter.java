package com.ironsource.adapters.ironsource;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ironsource.adapters.supersonicads.SupersonicConfig;
import com.ironsource.mediationsdk.AuctionDataUtils;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.b;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.metadata.a;
import com.ironsource.mediationsdk.n0.c;
import com.ironsource.mediationsdk.n0.j;
import com.ironsource.mediationsdk.n0.n;
import com.ironsource.mediationsdk.n0.p;
import com.ironsource.mediationsdk.n0.u;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import com.ironsource.mediationsdk.utils.f;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.data.ISNEnums$ProductType;
import d.e.d.d;
import d.e.d.n.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class IronSourceAdapter extends b implements p, e, ContextProvider.a {
    private static final int IS_LOAD_EXCEPTION = 1000;
    private static final int IS_SHOW_EXCEPTION = 1001;
    private static final int RV_LOAD_EXCEPTION = 1002;
    private static final int RV_SHOW_EXCEPTION = 1003;
    private static final String VERSION = "7.1.6.1";
    private static AtomicBoolean mDidInitSdk = new AtomicBoolean(false);
    private static ISNAdView mIsnAdView;
    private static String mediationSegment;
    private final String ADM_KEY;
    private final String CUSTOM_SEGMENT;
    private final String DEMAND_SOURCE_NAME;
    private final String DYNAMIC_CONTROLLER_CONFIG;
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE;
    private final String DYNAMIC_CONTROLLER_URL;
    private final String IN_APP_BIDDING_KEY;
    private final String IN_APP_BIDDING_VALUE;
    private final String LWS_SUPPORT_STATE;
    private final String OW_CLIENT_SIDE_CALLBACKS;
    private final String OW_PLACEMENT_ID;
    private final String SDK_PLUGIN_TYPE;
    private final String SESSION_ID;
    private ConcurrentHashMap<String, c> mDemandSourceToBNSmash;
    private ConcurrentHashMap<String, d.e.d.c> mDemandSourceToISAd;
    private ConcurrentHashMap<String, n> mDemandSourceToISSmash;
    private ConcurrentHashMap<String, d.e.d.c> mDemandSourceToRvAd;
    private ConcurrentHashMap<String, u> mDemandSourceToRvSmash;
    private boolean mIsAlreadyShowing;
    private j mOfferwallListener;

    /* loaded from: classes2.dex */
    private class IronSourceBannerListener implements d.e.d.n.b {
        private String mDemandSourceName;
        private c mListener;

        IronSourceBannerListener(c cVar, String str) {
            this.mDemandSourceName = str;
            this.mListener = cVar;
        }

        @Override // d.e.d.n.b
        public void onBannerClick() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " bannerListener");
            this.mListener.l();
        }

        @Override // d.e.d.n.b
        public void onBannerInitFailed(String str) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " bannerListener");
            this.mListener.q(new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID, str));
        }

        @Override // d.e.d.n.b
        public void onBannerInitSuccess() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " bannerListener");
            this.mListener.onBannerInitSuccess();
        }

        @Override // d.e.d.n.b
        public void onBannerLoadFail(String str) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " bannerListener");
            c cVar = this.mListener;
            cVar.b(f.e(IronSourceAdapter.this.getProviderName() + " load failed - error = " + str));
        }

        @Override // d.e.d.n.b
        public void onBannerLoadSuccess() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " bannerListener");
            IronSourceAdapter.this.mIsAlreadyShowing = true;
            if (IronSourceAdapter.mIsnAdView == null || IronSourceAdapter.mIsnAdView.l() == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(IronSourceAdapter.mIsnAdView.l().b(), IronSourceAdapter.mIsnAdView.l().a());
            layoutParams.gravity = 17;
            this.mListener.r(IronSourceAdapter.mIsnAdView, layoutParams);
            this.mListener.C();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class IronSourceInterstitialListener implements d.e.d.n.c {
        private String mDemandSourceName;
        private n mListener;

        IronSourceInterstitialListener(n nVar, String str) {
            this.mDemandSourceName = str;
            this.mListener = nVar;
        }

        @Override // d.e.d.n.c
        public void onInterstitialAdRewarded(String str, int i2) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener demandSourceId=" + str + " amount=" + i2);
        }

        @Override // d.e.d.n.c
        public void onInterstitialClick() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener");
            this.mListener.g();
        }

        @Override // d.e.d.n.c
        public void onInterstitialClose() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener");
            this.mListener.f();
        }

        @Override // d.e.d.n.c
        public void onInterstitialEventNotificationReceived(String str, JSONObject jSONObject) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener eventName=" + str);
            this.mListener.p();
        }

        @Override // d.e.d.n.c
        public void onInterstitialInitFailed(String str) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener");
        }

        @Override // d.e.d.n.c
        public void onInterstitialInitSuccess() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener");
        }

        @Override // d.e.d.n.c
        public void onInterstitialLoadFailed(String str) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener " + str);
            this.mListener.a(f.e(str));
        }

        @Override // d.e.d.n.c
        public void onInterstitialLoadSuccess() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener");
            this.mListener.c();
        }

        @Override // d.e.d.n.c
        public void onInterstitialOpen() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener");
            this.mListener.h();
        }

        @Override // d.e.d.n.c
        public void onInterstitialShowFailed(String str) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener " + str);
            this.mListener.e(f.i("Interstitial", str));
        }

        @Override // d.e.d.n.c
        public void onInterstitialShowSuccess() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener");
            this.mListener.j();
        }
    }

    private IronSourceAdapter(String str) {
        super(str);
        this.DYNAMIC_CONTROLLER_URL = "controllerUrl";
        this.DYNAMIC_CONTROLLER_DEBUG_MODE = "debugMode";
        this.DYNAMIC_CONTROLLER_CONFIG = "controllerConfig";
        this.SESSION_ID = "sessionid";
        this.SDK_PLUGIN_TYPE = "SDKPluginType";
        this.CUSTOM_SEGMENT = "custom_Segment";
        this.ADM_KEY = "adm";
        this.IN_APP_BIDDING_KEY = "inAppBidding";
        this.IN_APP_BIDDING_VALUE = "true";
        this.DEMAND_SOURCE_NAME = "demandSourceName";
        this.OW_PLACEMENT_ID = "placementId";
        this.OW_CLIENT_SIDE_CALLBACKS = "useClientSideCallbacks";
        this.LWS_SUPPORT_STATE = "isSupportedLWS";
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(str + ": new instance");
        this.mDemandSourceToRvAd = new ConcurrentHashMap<>();
        this.mDemandSourceToRvSmash = new ConcurrentHashMap<>();
        this.mDemandSourceToISAd = new ConcurrentHashMap<>();
        this.mDemandSourceToISSmash = new ConcurrentHashMap<>();
        this.mDemandSourceToBNSmash = new ConcurrentHashMap<>();
        mediationSegment = null;
        ContextProvider.getInstance().d(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0081, code lost:
        if (r11 != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.ironsource.sdk.ISNAdView.ISNAdView createBanner(android.app.Activity r10, com.ironsource.mediationsdk.r r11, com.ironsource.mediationsdk.n0.c r12) {
        /*
            r9 = this;
            java.lang.String r0 = r11.a()
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
            r7 = 0
            r8 = 320(0x140, float:4.48E-43)
            if (r1 == 0) goto L84
            if (r1 == r4) goto L86
            if (r1 == r3) goto L77
            if (r1 == r2) goto L5f
            if (r12 == 0) goto L5e
            java.lang.String r10 = r9.getProviderName()
            com.ironsource.mediationsdk.logger.b r10 = com.ironsource.mediationsdk.utils.f.k(r10)
            r12.b(r10)
        L5e:
            return r7
        L5f:
            int r11 = r11.b()
            if (r11 == r6) goto L75
            if (r11 == r5) goto L75
            if (r12 == 0) goto L74
            java.lang.String r10 = r9.getProviderName()
            com.ironsource.mediationsdk.logger.b r10 = com.ironsource.mediationsdk.utils.f.k(r10)
            r12.b(r10)
        L74:
            return r7
        L75:
            r5 = r11
            goto L86
        L77:
            boolean r11 = com.ironsource.mediationsdk.c.b(r10)
            if (r11 == 0) goto L81
            r1 = 728(0x2d8, float:1.02E-42)
            r8 = 728(0x2d8, float:1.02E-42)
        L81:
            if (r11 == 0) goto L84
            goto L86
        L84:
            r5 = 50
        L86:
            int r11 = com.ironsource.mediationsdk.c.a(r10, r8)
            int r1 = com.ironsource.mediationsdk.c.a(r10, r5)
            d.e.d.b r2 = new d.e.d.b
            r2.<init>(r11, r1, r0)
            com.ironsource.sdk.ISNAdView.ISNAdView r7 = d.e.d.e.b(r10, r2)     // Catch: java.lang.Exception -> L98
            goto Lc1
        L98:
            r10 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Banner Load Fail, "
            r11.append(r0)
            java.lang.String r0 = r9.getProviderName()
            r11.append(r0)
            java.lang.String r0 = " - "
            r11.append(r0)
            java.lang.String r10 = r10.getMessage()
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            com.ironsource.mediationsdk.logger.b r10 = com.ironsource.mediationsdk.utils.f.e(r10)
            r12.b(r10)
        Lc1:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.ironsource.IronSourceAdapter.createBanner(android.app.Activity, com.ironsource.mediationsdk.r, com.ironsource.mediationsdk.n0.c):com.ironsource.sdk.ISNAdView.ISNAdView");
    }

    private void destroyBannerInternal() {
        if (mIsnAdView != null) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(getProviderName() + " bannerView.performCleanup");
            mIsnAdView.p();
            mIsnAdView = null;
        }
    }

    private d.e.d.c getAdInstance(String str, boolean z, boolean z2, boolean z3) {
        d.e.d.c cVar;
        d dVar;
        if (z3) {
            cVar = this.mDemandSourceToRvAd.get(str);
        } else {
            cVar = this.mDemandSourceToISAd.get(str);
        }
        if (cVar == null) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("creating ad instance for " + str + " isDemandOnlyForRv=" + z + " isBidder=" + z2 + " isRewarded=" + z3);
            if (z3) {
                dVar = new d(str, new IronSourceRewardedVideoListener(this.mDemandSourceToRvSmash.get(str), str, z));
                dVar.b(getInitParams());
                dVar.d();
            } else {
                dVar = new d(str, new IronSourceInterstitialListener(this.mDemandSourceToISSmash.get(str), str));
                dVar.b(getInitParams());
            }
            if (z2) {
                dVar.c();
            }
            cVar = dVar.a();
            if (z3) {
                this.mDemandSourceToRvAd.put(str, cVar);
            } else {
                this.mDemandSourceToISAd.put(str, cVar);
            }
        }
        return cVar;
    }

    private String getDemandSourceName(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(jSONObject.optString("demandSourceName"))) {
            return jSONObject.optString("demandSourceName");
        }
        return getProviderName();
    }

    private HashMap<String, String> getInitParams() {
        HashMap<String, String> hashMap = new HashMap<>();
        String pluginType = getPluginType();
        if (!TextUtils.isEmpty(pluginType)) {
            hashMap.put("SDKPluginType", pluginType);
        }
        if (!TextUtils.isEmpty(mediationSegment)) {
            hashMap.put("custom_Segment", mediationSegment);
        }
        if (!TextUtils.isEmpty(IronSourceObject.getInstance().B())) {
            hashMap.put("sessionid", IronSourceObject.getInstance().B());
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> getOfferwallExtraParams() {
        HashMap<String, String> initParams = getInitParams();
        initParams.put("useClientSideCallbacks", String.valueOf(SupersonicConfig.getConfigObj().getClientSideCallbacks()));
        Map<String, String> offerwallCustomParams = SupersonicConfig.getConfigObj().getOfferwallCustomParams();
        if (offerwallCustomParams != null && !offerwallCustomParams.isEmpty()) {
            initParams.putAll(offerwallCustomParams);
        }
        return initParams;
    }

    private void initInterstitialInternal(String str, JSONObject jSONObject, n nVar, String str2) {
        initSDK(str, jSONObject);
        this.mDemandSourceToISSmash.put(str2, nVar);
        nVar.onInterstitialInitSuccess();
    }

    private void initRewardedVideoInternal(String str, JSONObject jSONObject, u uVar, String str2) {
        initSDK(str, jSONObject);
        this.mDemandSourceToRvSmash.put(str2, uVar);
    }

    private void initSDK(String str, JSONObject jSONObject) {
        if (mDidInitSdk.compareAndSet(false, true)) {
            String F = IronSourceUtils.F();
            int optInt = jSONObject.optInt("debugMode", 0);
            if (isAdaptersDebugEnabled()) {
                optInt = 3;
            }
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("setting debug mode to " + optInt);
            com.ironsource.sdk.utils.f.G(optInt);
            com.ironsource.sdk.utils.f.F(jSONObject.optString("controllerUrl"));
            ironLog.verbose("IronSourceNetwork setting controller url to  " + jSONObject.optString("controllerUrl"));
            com.ironsource.sdk.utils.f.E(jSONObject.optString("controllerConfig"));
            ironLog.verbose("IronSourceNetwork setting controller config to  " + jSONObject.optString("controllerConfig"));
            HashMap<String, String> initParams = getInitParams();
            String u = IronSourceObject.getInstance().u();
            ironLog.verbose("with appKey=" + u + " userId=" + F + " parameters " + initParams);
            d.e.d.e.o(new d.e.d.n.d() { // from class: com.ironsource.adapters.ironsource.IronSourceAdapter.1
                @Override // d.e.d.n.d
                public void onFail(com.ironsource.sdk.data.c cVar) {
                    IronLog ironLog2 = IronLog.ADAPTER_API;
                    ironLog2.verbose("OnNetworkSDKInitListener fail - code:" + cVar.a() + " message:" + cVar.b());
                }

                @Override // d.e.d.n.d
                public void onSuccess() {
                    IronLog.ADAPTER_API.verbose("OnNetworkSDKInitListener success");
                }
            });
            d.e.d.e.i(ContextProvider.getInstance().a(), u, F, initParams);
        }
    }

    private boolean isValidMetaData(String str, String str2) {
        if (str.equals("do_not_sell")) {
            return a.c(str, str2);
        }
        return true;
    }

    private void loadAdInternal(String str, String str2, boolean z, boolean z2, boolean z3) throws Exception {
        HashMap hashMap = new HashMap();
        if (str2 != null) {
            hashMap.put("adm", AuctionDataUtils.getInstance().e(str2));
            hashMap.putAll(AuctionDataUtils.getInstance().h(str2));
        }
        d.e.d.c adInstance = getAdInstance(str, z, z2, z3);
        printInstanceExtraParams(hashMap);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("demandSourceName=" + adInstance.d());
        d.e.d.e.l(ContextProvider.getInstance().b(), adInstance, hashMap);
    }

    private void loadBannerInternal(ISNAdView iSNAdView, c cVar, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            Map<String, String> hashMap = new HashMap<>();
            jSONObject.put("demandSourceName", str2);
            ISNEnums$ProductType iSNEnums$ProductType = ISNEnums$ProductType.Banner;
            jSONObject.put("productType", iSNEnums$ProductType);
            hashMap.put("demandSourceName", str2);
            hashMap.put("productType", iSNEnums$ProductType.toString());
            if (str != null) {
                hashMap.put("adm", AuctionDataUtils.getInstance().e(str));
                hashMap.put("inAppBidding", "true");
                Map<? extends String, ? extends String> h2 = AuctionDataUtils.getInstance().h(str);
                new JSONObject(h2);
                hashMap.putAll(h2);
            }
            if (iSNAdView != null) {
                try {
                    IronLog.ADAPTER_API.verbose("bannerView.loadAd");
                    if (str != null) {
                        iSNAdView.n(hashMap);
                    } else {
                        iSNAdView.m(jSONObject);
                    }
                } catch (Exception e2) {
                    cVar.b(f.e("Banner Load Fail, " + getProviderName() + " - " + e2.getMessage()));
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void printInstanceExtraParams(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        IronLog.ADAPTER_API.verbose("instance extra params:");
        for (String str : map.keySet()) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose(str + "=" + map.get(str));
        }
    }

    private void showAdInternal(d.e.d.c cVar, int i2) throws Exception {
        int b = SessionDepthManager.getInstance().b(i2);
        HashMap hashMap = new HashMap();
        hashMap.put("sessionDepth", String.valueOf(b));
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("demandSourceName=" + cVar.d() + " showParams=" + hashMap);
        d.e.d.e.p(cVar, hashMap);
    }

    public static IronSourceAdapter startAdapter(String str) {
        return new IronSourceAdapter(str);
    }

    @Override // com.ironsource.mediationsdk.b
    public void destroyBanner(JSONObject jSONObject) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        this.mIsAlreadyShowing = false;
        destroyBannerInternal();
    }

    @Override // com.ironsource.mediationsdk.b
    public void earlyInit(String str, String str2, JSONObject jSONObject) {
        if (IronSourceObject.getInstance().u() != null) {
            IronSourceUtils.j0(getDemandSourceName(jSONObject) + ": earlyInit");
            initSDK(IronSourceObject.getInstance().u(), jSONObject);
            return;
        }
        IronLog.ADAPTER_API.error("Appkey is null for early init");
    }

    @Override // com.ironsource.mediationsdk.n0.r
    public void fetchRewardedVideoForAutomaticLoad(JSONObject jSONObject, u uVar) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.ADAPTER_API.verbose(demandSourceName);
        try {
            loadAdInternal(demandSourceName, null, false, false, true);
        } catch (Exception e2) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e2.getMessage());
            u uVar2 = this.mDemandSourceToRvSmash.get(demandSourceName);
            if (uVar2 != null) {
                IronLog ironLog2 = IronLog.ADAPTER_API;
                ironLog2.error("exception " + e2.getMessage());
                uVar2.s(new com.ironsource.mediationsdk.logger.b(1002, e2.getMessage()));
                uVar2.i(false);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.b
    public Map<String, Object> getBannerBiddingData(JSONObject jSONObject) {
        return getBiddingData();
    }

    Map<String, Object> getBiddingData() {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("");
        HashMap hashMap = new HashMap();
        String f2 = d.e.d.e.f(ContextProvider.getInstance().a());
        if (f2 != null) {
            hashMap.put("token", f2);
        } else {
            ironLog.error("bidding token is null");
            hashMap.put("token", "");
        }
        return hashMap;
    }

    @Override // com.ironsource.mediationsdk.b
    public String getCoreSDKVersion() {
        return com.ironsource.sdk.utils.f.t();
    }

    @Override // com.ironsource.mediationsdk.b
    public Map<String, Object> getInterstitialBiddingData(JSONObject jSONObject) {
        return getBiddingData();
    }

    @Override // com.ironsource.mediationsdk.b
    public LoadWhileShowSupportState getLoadWhileShowSupportState(JSONObject jSONObject) {
        LoadWhileShowSupportState loadWhileShowSupportState = this.mLWSSupportState;
        return (jSONObject == null || !jSONObject.optBoolean("isSupportedLWS")) ? loadWhileShowSupportState : LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    public void getOfferwallCredits() {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(getProviderName() + " getOfferwallCredits");
        try {
            d.e.d.e.d(this);
        } catch (Exception e2) {
            IronLog ironLog2 = IronLog.ADAPTER_API;
            ironLog2.error("exception " + e2.getMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.b
    public JSONObject getPlayerBiddingData() {
        JSONObject jSONObject;
        IronLog.ADAPTER_API.verbose("");
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = d.e.d.e.e(ContextProvider.getInstance().a());
        } catch (Exception e2) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("getRawToken exception: " + e2.getLocalizedMessage());
            jSONObject = null;
        }
        if (jSONObject != null) {
            return jSONObject;
        }
        IronLog.ADAPTER_API.error("Player's bidding token is null");
        return jSONObject2;
    }

    @Override // com.ironsource.mediationsdk.b
    public Map<String, Object> getRewardedVideoBiddingData(JSONObject jSONObject) {
        return getBiddingData();
    }

    @Override // com.ironsource.mediationsdk.b
    public String getVersion() {
        return VERSION;
    }

    @Override // com.ironsource.mediationsdk.b
    public void initBannerForBidding(String str, String str2, JSONObject jSONObject, c cVar) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initSDK(str, jSONObject);
        this.mDemandSourceToBNSmash.put(demandSourceName, cVar);
        cVar.onBannerInitSuccess();
    }

    @Override // com.ironsource.mediationsdk.b
    public void initBanners(String str, String str2, JSONObject jSONObject, c cVar) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initSDK(str, jSONObject);
        this.mDemandSourceToBNSmash.put(demandSourceName, cVar);
        try {
            d.e.d.e.g(demandSourceName, getInitParams(), new IronSourceBannerListener(cVar, demandSourceName));
        } catch (Exception e2) {
            cVar.q(f.c(e2.getMessage(), "Banner"));
        }
    }

    @Override // com.ironsource.mediationsdk.n0.k
    public void initInterstitial(String str, String str2, JSONObject jSONObject, n nVar) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initInterstitialInternal(str, jSONObject, nVar, demandSourceName);
    }

    @Override // com.ironsource.mediationsdk.b
    public void initInterstitialForBidding(String str, String str2, JSONObject jSONObject, n nVar) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initInterstitialInternal(str, jSONObject, nVar, demandSourceName);
    }

    @Override // com.ironsource.mediationsdk.n0.p
    public void initOfferwall(String str, String str2, JSONObject jSONObject) {
        initSDK(str, jSONObject);
        IronLog.ADAPTER_API.verbose(":initOfferwall");
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.ironsource.IronSourceAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    d.e.d.e.h(IronSourceAdapter.this.getOfferwallExtraParams(), IronSourceAdapter.this);
                } catch (Exception e2) {
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.error(IronSourceAdapter.this.getProviderName() + ":initOfferwall " + e2);
                    j jVar = IronSourceAdapter.this.mOfferwallListener;
                    jVar.q(false, f.c("Adapter initialization failure - " + IronSourceAdapter.this.getProviderName() + " - " + e2.getMessage(), "Offerwall"));
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.n0.r
    public void initRewardedVideo(String str, String str2, JSONObject jSONObject, u uVar) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initRewardedVideoInternal(str, jSONObject, uVar, demandSourceName);
        fetchRewardedVideoForAutomaticLoad(jSONObject, uVar);
    }

    @Override // com.ironsource.mediationsdk.b
    public void initRewardedVideoForBidding(String str, String str2, JSONObject jSONObject, u uVar) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initRewardedVideoInternal(str, jSONObject, uVar, demandSourceName);
        uVar.z();
    }

    @Override // com.ironsource.mediationsdk.b
    public void initRewardedVideoForDemandOnly(String str, String str2, JSONObject jSONObject, u uVar) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initRewardedVideoInternal(str, jSONObject, uVar, demandSourceName);
    }

    @Override // com.ironsource.mediationsdk.n0.k
    public boolean isInterstitialReady(JSONObject jSONObject) {
        d.e.d.c cVar = this.mDemandSourceToISAd.get(getDemandSourceName(jSONObject));
        return cVar != null && d.e.d.e.k(cVar);
    }

    public boolean isOfferwallAvailable() {
        return true;
    }

    @Override // com.ironsource.mediationsdk.n0.r
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        d.e.d.c cVar = this.mDemandSourceToRvAd.get(getDemandSourceName(jSONObject));
        return cVar != null && d.e.d.e.k(cVar);
    }

    @Override // com.ironsource.mediationsdk.b
    public void loadBanner(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, c cVar) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        if (!this.mIsAlreadyShowing) {
            destroyBannerInternal();
            mIsnAdView = createBanner(ironSourceBannerLayout.f(), ironSourceBannerLayout.g(), cVar);
        }
        try {
            loadBannerInternal(mIsnAdView, cVar, null, demandSourceName);
        } catch (Exception e2) {
            cVar.b(f.e("Banner Load Fail, " + getProviderName() + " - " + e2.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.b
    public void loadBannerForBidding(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, c cVar, String str) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        try {
            if (!this.mIsAlreadyShowing) {
                destroyBannerInternal();
                mIsnAdView = createBanner(ironSourceBannerLayout.f(), ironSourceBannerLayout.g(), cVar);
            }
            HashMap<String, String> initParams = getInitParams();
            initParams.put("inAppBidding", "true");
            d.e.d.e.g(demandSourceName, initParams, new IronSourceBannerListener(cVar, demandSourceName));
            loadBannerInternal(mIsnAdView, cVar, str, demandSourceName);
        } catch (Exception e2) {
            cVar.b(f.e("Banner Load Fail, " + getProviderName() + " - " + e2.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.n0.k
    public void loadInterstitial(JSONObject jSONObject, n nVar) {
        IronLog.ADAPTER_API.verbose(getDemandSourceName(jSONObject));
        try {
            loadAdInternal(getDemandSourceName(jSONObject), null, false, false, false);
        } catch (Exception e2) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e2.getMessage());
            nVar.a(new com.ironsource.mediationsdk.logger.b(1000, e2.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.b
    public void loadInterstitialForBidding(JSONObject jSONObject, n nVar, String str) {
        IronLog.ADAPTER_API.verbose(getDemandSourceName(jSONObject));
        try {
            loadAdInternal(getDemandSourceName(jSONObject), str, false, true, false);
        } catch (Exception e2) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("for bidding exception " + e2.getMessage());
            nVar.a(new com.ironsource.mediationsdk.logger.b(1000, e2.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.b
    public void loadRewardedVideoForBidding(JSONObject jSONObject, u uVar, String str) {
        IronLog.ADAPTER_API.verbose(getDemandSourceName(jSONObject));
        try {
            loadAdInternal(getDemandSourceName(jSONObject), str, false, true, true);
        } catch (Exception e2) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e2.getMessage());
            uVar.s(new com.ironsource.mediationsdk.logger.b(1002, e2.getMessage()));
            uVar.i(false);
        }
    }

    @Override // com.ironsource.mediationsdk.b
    public void loadRewardedVideoForDemandOnly(JSONObject jSONObject, u uVar) {
        IronLog.ADAPTER_API.verbose(getDemandSourceName(jSONObject));
        try {
            loadAdInternal(getDemandSourceName(jSONObject), null, true, false, true);
        } catch (Exception e2) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e2.getMessage());
            uVar.s(new com.ironsource.mediationsdk.logger.b(1002, e2.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.b
    public void loadRewardedVideoForDemandOnlyForBidding(JSONObject jSONObject, u uVar, String str) {
        IronLog.ADAPTER_API.verbose(getDemandSourceName(jSONObject));
        try {
            loadAdInternal(getDemandSourceName(jSONObject), str, true, true, true);
        } catch (Exception e2) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e2.getMessage());
            uVar.s(new com.ironsource.mediationsdk.logger.b(1002, e2.getMessage()));
        }
    }

    @Override // d.e.d.n.e
    public void onGetOWCreditsFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mOfferwallListener != null) {
            this.mOfferwallListener.m(f.b(str));
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
            this.mOfferwallListener.r(f.b(str));
        }
    }

    @Override // d.e.d.n.e
    public void onOWShowSuccess(String str) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(getProviderName() + ":onOWShowSuccess(placementId:" + str + ")");
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
            this.mOfferwallListener.q(false, f.b(str));
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
        IronLog.ADAPTER_API.verbose("IronSourceNetwork.onPause");
        d.e.d.e.m(activity);
    }

    public void onResume(Activity activity) {
        IronLog.ADAPTER_API.verbose("IronSourceNetwork.onResume");
        d.e.d.e.n(activity);
    }

    @Override // com.ironsource.mediationsdk.b
    public void reloadBanner(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, c cVar) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        loadBannerInternal(mIsnAdView, cVar, null, demandSourceName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.b
    public void setConsent(boolean z) {
        IronLog ironLog = IronLog.ADAPTER_API;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(z ? "true" : "false");
        sb.append(")");
        ironLog.verbose(sb.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("consent", z ? "1" : "0");
            d.e.d.e.r(jSONObject);
        } catch (JSONException e2) {
            IronLog ironLog2 = IronLog.ADAPTER_API;
            ironLog2.error("exception " + e2.getMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.n0.p
    public void setInternalOfferwallListener(j jVar) {
        this.mOfferwallListener = jVar;
    }

    @Override // com.ironsource.mediationsdk.b
    public void setMediationSegment(String str) {
        mediationSegment = str;
    }

    @Override // com.ironsource.mediationsdk.b
    protected void setMetaData(String str, String str2) {
        if (mDidInitSdk.get()) {
            return;
        }
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("key=" + str + ", value=" + str2);
        if (!isValidMetaData(str, str2)) {
            ironLog.verbose("MetaData not valid");
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

    @Override // com.ironsource.mediationsdk.b
    public boolean shouldBindBannerViewOnReload() {
        return true;
    }

    @Override // com.ironsource.mediationsdk.n0.k
    public void showInterstitial(JSONObject jSONObject, n nVar) {
        IronLog.ADAPTER_API.verbose(getDemandSourceName(jSONObject));
        try {
            showAdInternal(this.mDemandSourceToISAd.get(getDemandSourceName(jSONObject)), 2);
        } catch (Exception e2) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e2.getMessage());
            nVar.e(new com.ironsource.mediationsdk.logger.b(1001, e2.getMessage()));
        }
    }

    public void showOfferwall(String str, JSONObject jSONObject) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(getProviderName() + " showOfferWall");
        try {
            HashMap<String, String> offerwallExtraParams = getOfferwallExtraParams();
            offerwallExtraParams.put("placementId", str);
            d.e.d.e.q(ContextProvider.getInstance().b(), offerwallExtraParams);
        } catch (Exception e2) {
            IronLog ironLog2 = IronLog.ADAPTER_API;
            ironLog2.error("exception " + e2.getMessage());
        }
    }

    public void showRewardedVideo(JSONObject jSONObject, u uVar) {
        try {
            showAdInternal(this.mDemandSourceToRvAd.get(getDemandSourceName(jSONObject)), 1);
        } catch (Exception e2) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e2.getMessage());
            uVar.k(new com.ironsource.mediationsdk.logger.b(1003, e2.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class IronSourceRewardedVideoListener implements d.e.d.n.c {
        private String mDemandSourceName;
        boolean mIsRvDemandOnly;
        u mListener;

        IronSourceRewardedVideoListener(u uVar, String str) {
            this.mDemandSourceName = str;
            this.mListener = uVar;
            this.mIsRvDemandOnly = false;
        }

        @Override // d.e.d.n.c
        public void onInterstitialAdRewarded(String str, int i2) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener demandSourceId=" + str + " amount=" + i2);
            this.mListener.y();
        }

        @Override // d.e.d.n.c
        public void onInterstitialClick() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
            this.mListener.v();
        }

        @Override // d.e.d.n.c
        public void onInterstitialClose() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
            this.mListener.onRewardedVideoAdClosed();
        }

        @Override // d.e.d.n.c
        public void onInterstitialEventNotificationReceived(String str, JSONObject jSONObject) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener eventName=" + str);
            this.mListener.u();
        }

        @Override // d.e.d.n.c
        public void onInterstitialInitFailed(String str) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
        }

        @Override // d.e.d.n.c
        public void onInterstitialInitSuccess() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
        }

        @Override // d.e.d.n.c
        public void onInterstitialLoadFailed(String str) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener " + str);
            this.mListener.s(f.e(str));
            if (this.mIsRvDemandOnly) {
                return;
            }
            this.mListener.i(false);
        }

        @Override // d.e.d.n.c
        public void onInterstitialLoadSuccess() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
            if (this.mIsRvDemandOnly) {
                this.mListener.A();
            } else {
                this.mListener.i(true);
            }
        }

        @Override // d.e.d.n.c
        public void onInterstitialOpen() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
            this.mListener.onRewardedVideoAdOpened();
        }

        @Override // d.e.d.n.c
        public void onInterstitialShowFailed(String str) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + "rewardedVideoListener " + str);
            this.mListener.k(f.i("Rewarded Video", str));
        }

        @Override // d.e.d.n.c
        public void onInterstitialShowSuccess() {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
            if (this.mIsRvDemandOnly) {
                return;
            }
            this.mListener.i(false);
        }

        IronSourceRewardedVideoListener(u uVar, String str, boolean z) {
            this.mDemandSourceName = str;
            this.mListener = uVar;
            this.mIsRvDemandOnly = z;
        }
    }
}
