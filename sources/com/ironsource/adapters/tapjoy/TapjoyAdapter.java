package com.ironsource.adapters.tapjoy;

import android.app.Activity;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.AdjustConfig;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.b;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.metadata.a;
import com.ironsource.mediationsdk.n0.n;
import com.ironsource.mediationsdk.n0.u;
import com.ironsource.mediationsdk.o;
import com.ironsource.mediationsdk.s;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.f;
import com.tapjoy.TJActionRequest;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementVideoListener;
import com.tapjoy.TJPrivacyPolicy;
import com.tapjoy.Tapjoy;
import com.tapjoy.TapjoyAuctionFlags;
import com.tapjoy.TapjoyConnectFlag;
import com.tapjoy.TapjoyLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TapjoyAdapter extends b implements TJPlacementListener, TJPlacementVideoListener, o {
    private static final String GitHash = "cad8f7fbc";
    private static final String VERSION = "4.1.15";
    private final int LOAD_ERROR_NOT_AVAILABLE;
    private final String PLACEMENT_NAME;
    private final int PROG_LOAD_ERROR_GET_PLACEMENT;
    private final String SDK_KEY;
    private ConcurrentHashMap<String, TJPlacement> mInterstitialPlacementToAd;
    private ConcurrentHashMap<String, Boolean> mInterstitialPlacementToIsReady;
    private ConcurrentHashMap<String, n> mInterstitialPlacementToListener;
    private CopyOnWriteArraySet<String> mProgrammaticPlacements;
    private ConcurrentHashMap<String, TJPlacement> mRewardedVideoPlacementToAd;
    private ConcurrentHashMap<String, Boolean> mRewardedVideoPlacementToIsReady;
    private ConcurrentHashMap<String, u> mRewardedVideoPlacementToListener;
    private String userId;
    private static TJPrivacyPolicy tjPrivacyPolicy = Tapjoy.getPrivacyPolicy();
    private static ExecutorService mThreadPool = Executors.newSingleThreadExecutor();
    private static AtomicBoolean mWasInitCalled = new AtomicBoolean(false);
    private static InitState mInitState = InitState.INIT_STATE_NONE;
    private static HashSet<o> initCallbackListeners = new HashSet<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum InitState {
        INIT_STATE_NONE,
        INIT_STATE_IN_PROGRESS,
        INIT_STATE_SUCCESS,
        INIT_STATE_ERROR
    }

    private TapjoyAdapter(String str) {
        super(str);
        this.SDK_KEY = "sdkKey";
        this.PLACEMENT_NAME = "placementName";
        this.PROG_LOAD_ERROR_GET_PLACEMENT = 5000;
        this.LOAD_ERROR_NOT_AVAILABLE = 5001;
        IronLog.INTERNAL.verbose("");
        this.mInterstitialPlacementToAd = new ConcurrentHashMap<>();
        this.mInterstitialPlacementToListener = new ConcurrentHashMap<>();
        this.mInterstitialPlacementToIsReady = new ConcurrentHashMap<>();
        this.mRewardedVideoPlacementToListener = new ConcurrentHashMap<>();
        this.mRewardedVideoPlacementToAd = new ConcurrentHashMap<>();
        this.mRewardedVideoPlacementToIsReady = new ConcurrentHashMap<>();
        this.mProgrammaticPlacements = new CopyOnWriteArraySet<>();
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    public static String getAdapterSDKVersion() {
        try {
            return Tapjoy.getVersion();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TJPlacement getAuctionPlacement(String str, String str2) {
        try {
            TJPlacement placement = Tapjoy.getPlacement(str, this);
            placement.setMediationName(AdjustConfig.AD_REVENUE_IRONSOURCE);
            placement.setAdapterVersion("4.1.15");
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str2);
            hashMap.put(TapjoyAuctionFlags.AUCTION_ID, jSONObject.getString(TapjoyAuctionFlags.AUCTION_ID));
            hashMap.put(TapjoyAuctionFlags.AUCTION_DATA, jSONObject.getString(TapjoyAuctionFlags.AUCTION_DATA));
            placement.setAuctionData(hashMap);
            return placement;
        } catch (Exception e2) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("error - generateAuctionPlacement " + e2.getMessage());
            return null;
        }
    }

    private Map<String, Object> getBiddingData() {
        if (mInitState == InitState.INIT_STATE_ERROR) {
            IronLog.INTERNAL.error("returning null as token since init failed");
            return null;
        }
        String userToken = Tapjoy.getUserToken();
        if (TextUtils.isEmpty(userToken)) {
            userToken = "";
        }
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("token = " + userToken);
        HashMap hashMap = new HashMap();
        hashMap.put("token", userToken);
        return hashMap;
    }

    public static s getIntegrationData(Activity activity) {
        s sVar = new s("Tapjoy", "4.1.15");
        sVar.c = new String[]{"com.tapjoy.TJAdUnitActivity", "com.tapjoy.TJContentActivity"};
        return sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TJPlacement getPlacement(String str) {
        TJPlacement placement = Tapjoy.getPlacement(str, this);
        if (placement != null) {
            placement.setMediationName(AdjustConfig.AD_REVENUE_IRONSOURCE);
            placement.setAdapterVersion("4.1.15");
            return placement;
        }
        IronLog.INTERNAL.error("error - getPlacement - TJPlacement is null");
        return null;
    }

    private void initSDK(String str, String str2) {
        this.userId = str;
        if (mWasInitCalled.compareAndSet(false, true)) {
            mInitState = InitState.INIT_STATE_IN_PROGRESS;
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("initSDK - sdkKey = " + str2);
            Hashtable hashtable = new Hashtable();
            if (isAdaptersDebugEnabled()) {
                hashtable.put(TapjoyConnectFlag.ENABLE_LOGGING, "true");
                Tapjoy.setDebugEnabled(true);
                TapjoyLog.setDebugEnabled(true);
            } else {
                hashtable.put(TapjoyConnectFlag.ENABLE_LOGGING, "false");
                Tapjoy.setDebugEnabled(false);
                TapjoyLog.setDebugEnabled(false);
            }
            initCallbackListeners.add(this);
            Tapjoy.connect(ContextProvider.getInstance().a(), str2, hashtable, new TJConnectListener() { // from class: com.ironsource.adapters.tapjoy.TapjoyAdapter.1
                @Override // com.tapjoy.TJConnectListener
                public void onConnectFailure() {
                    IronLog.ADAPTER_CALLBACK.verbose("onConnectFailure");
                    InitState unused = TapjoyAdapter.mInitState = InitState.INIT_STATE_ERROR;
                    Iterator it = TapjoyAdapter.initCallbackListeners.iterator();
                    while (it.hasNext()) {
                        ((o) it.next()).onNetworkInitCallbackFailed(null);
                    }
                    TapjoyAdapter.initCallbackListeners.clear();
                }

                @Override // com.tapjoy.TJConnectListener
                public void onConnectSuccess() {
                    IronLog.ADAPTER_CALLBACK.verbose("onConnectSuccess");
                    InitState unused = TapjoyAdapter.mInitState = InitState.INIT_STATE_SUCCESS;
                    Iterator it = TapjoyAdapter.initCallbackListeners.iterator();
                    while (it.hasNext()) {
                        ((o) it.next()).onNetworkInitCallbackSuccess();
                    }
                    TapjoyAdapter.initCallbackListeners.clear();
                }
            });
        } else if (mInitState == InitState.INIT_STATE_IN_PROGRESS) {
            initCallbackListeners.add(this);
        }
    }

    private void loadVideo(final String str, final u uVar) {
        mThreadPool.execute(new Runnable() { // from class: com.ironsource.adapters.tapjoy.TapjoyAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                TJPlacement placement = TapjoyAdapter.this.getPlacement(str);
                placement.setVideoListener(TapjoyAdapter.this);
                if (placement != null) {
                    TapjoyAdapter.this.mRewardedVideoPlacementToAd.put(str, placement);
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose("loadVideo - requestContent - placementName = " + str);
                    placement.requestContent();
                    return;
                }
                IronLog.ADAPTER_API.verbose("loadVideo - onRewardedVideoAvailabilityChanged(false) - TJPlacement is null");
                uVar.i(false);
                try {
                    uVar.s(new com.ironsource.mediationsdk.logger.b(5000, "Load error"));
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void setCCPAValue(boolean z) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("value = " + z);
        tjPrivacyPolicy.setUSPrivacy(z ? "1YY-" : "1YN-");
    }

    public static TapjoyAdapter startAdapter(String str) {
        return new TapjoyAdapter(str);
    }

    @Override // com.ironsource.mediationsdk.n0.r
    public void fetchRewardedVideoForAutomaticLoad(JSONObject jSONObject, u uVar) {
        final String optString = jSONObject.optString("placementName");
        this.mRewardedVideoPlacementToIsReady.put(optString, Boolean.FALSE);
        mThreadPool.execute(new Runnable() { // from class: com.ironsource.adapters.tapjoy.TapjoyAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                if (!TapjoyAdapter.this.mRewardedVideoPlacementToAd.containsKey(optString)) {
                    if (TapjoyAdapter.this.mRewardedVideoPlacementToListener.containsKey(optString)) {
                        IronLog ironLog = IronLog.ADAPTER_API;
                        ironLog.verbose("fetchRewardedVideoForAutomaticLoad - onRewardedVideoAvailabilityChanged(false) - placementName = " + optString);
                        ((u) TapjoyAdapter.this.mRewardedVideoPlacementToListener.get(optString)).i(false);
                        return;
                    }
                    return;
                }
                IronLog ironLog2 = IronLog.ADAPTER_API;
                ironLog2.verbose("fetchRewardedVideoForAutomaticLoad - requestContent - placementName = " + optString);
                ((TJPlacement) TapjoyAdapter.this.mRewardedVideoPlacementToAd.get(optString)).requestContent();
            }
        });
    }

    @Override // com.ironsource.mediationsdk.b
    public String getCoreSDKVersion() {
        return Tapjoy.getVersion();
    }

    @Override // com.ironsource.mediationsdk.b
    public Map<String, Object> getInterstitialBiddingData(JSONObject jSONObject) {
        return getBiddingData();
    }

    @Override // com.ironsource.mediationsdk.b
    public Map<String, Object> getRewardedVideoBiddingData(JSONObject jSONObject) {
        return getBiddingData();
    }

    @Override // com.ironsource.mediationsdk.b
    public String getVersion() {
        return "4.1.15";
    }

    @Override // com.ironsource.mediationsdk.n0.k
    public void initInterstitial(String str, String str2, JSONObject jSONObject, n nVar) {
        String optString = jSONObject.optString("sdkKey");
        String optString2 = jSONObject.optString("placementName");
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("onInterstitialInitFailed - missing params: sdkKey is empty");
            nVar.w(f.c("Missing params", "Interstitial"));
        } else if (TextUtils.isEmpty(optString2)) {
            IronLog.INTERNAL.error("onInterstitialInitFailed - missing params: placementName is empty");
            nVar.w(f.c("Missing params", "Interstitial"));
        } else {
            this.mInterstitialPlacementToListener.put(optString2, nVar);
            initSDK(str2, optString);
            if (mInitState == InitState.INIT_STATE_SUCCESS) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("onInterstitialInitSuccess - placementName = " + optString2);
                nVar.onInterstitialInitSuccess();
            } else if (mInitState == InitState.INIT_STATE_ERROR) {
                IronLog ironLog2 = IronLog.INTERNAL;
                ironLog2.verbose("onInterstitialInitFailed - placementName = " + optString2);
                nVar.w(f.c("Init Failed", "Interstitial"));
            }
        }
    }

    @Override // com.ironsource.mediationsdk.b
    public void initInterstitialForBidding(String str, String str2, JSONObject jSONObject, n nVar) {
        initInterstitial(str, str2, jSONObject, nVar);
    }

    @Override // com.ironsource.mediationsdk.n0.r
    public void initRewardedVideo(String str, String str2, JSONObject jSONObject, u uVar) {
        String optString = jSONObject.optString("sdkKey");
        String optString2 = jSONObject.optString("placementName");
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("empty sdkKey");
            uVar.i(false);
        } else if (TextUtils.isEmpty(optString2)) {
            IronLog.INTERNAL.error("empty placementName");
            uVar.i(false);
        } else {
            this.mRewardedVideoPlacementToListener.put(optString2, uVar);
            this.mRewardedVideoPlacementToIsReady.put(optString2, Boolean.FALSE);
            initSDK(str2, optString);
            if (mInitState == InitState.INIT_STATE_SUCCESS) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("loadVideo - placementName = " + optString2);
                loadVideo(optString2, uVar);
            } else if (mInitState == InitState.INIT_STATE_ERROR) {
                IronLog.INTERNAL.verbose("onRewardedVideoAvailabilityChanged(false)");
                uVar.i(false);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.b
    public void initRewardedVideoForBidding(String str, String str2, JSONObject jSONObject, u uVar) {
        if (uVar == null) {
            IronLog.INTERNAL.error("listener == null");
            return;
        }
        String optString = jSONObject.optString("sdkKey");
        String optString2 = jSONObject.optString("placementName");
        if (TextUtils.isEmpty(optString)) {
            uVar.t(f.c("Missing sdkKey", "Rewarded Video"));
        } else if (TextUtils.isEmpty(optString2)) {
            uVar.t(f.c("Missing placementId", "Rewarded Video"));
        } else {
            this.mRewardedVideoPlacementToListener.put(optString2, uVar);
            this.mProgrammaticPlacements.add(optString2);
            initSDK(str2, optString);
            if (mInitState == InitState.INIT_STATE_SUCCESS) {
                IronLog.INTERNAL.verbose("onRewardedVideoInitSuccess");
                uVar.z();
            } else if (mInitState == InitState.INIT_STATE_ERROR) {
                IronLog.INTERNAL.verbose("onRewardedVideoInitFailed - SDK not connected");
                uVar.t(f.c("sdk not connected", "Rewarded Video"));
            }
        }
    }

    @Override // com.ironsource.mediationsdk.n0.k
    public boolean isInterstitialReady(JSONObject jSONObject) {
        String optString = jSONObject.optString("placementName");
        return this.mInterstitialPlacementToIsReady.containsKey(optString) && this.mInterstitialPlacementToIsReady.get(optString).booleanValue();
    }

    @Override // com.ironsource.mediationsdk.n0.r
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        String optString = jSONObject.optString("placementName");
        return this.mRewardedVideoPlacementToIsReady.containsKey(optString) && this.mRewardedVideoPlacementToIsReady.get(optString).booleanValue();
    }

    @Override // com.ironsource.mediationsdk.n0.k
    public void loadInterstitial(final JSONObject jSONObject, final n nVar) {
        this.mInterstitialPlacementToIsReady.put(jSONObject.optString("placementName"), Boolean.FALSE);
        mThreadPool.execute(new Runnable() { // from class: com.ironsource.adapters.tapjoy.TapjoyAdapter.7
            @Override // java.lang.Runnable
            public void run() {
                String optString = jSONObject.optString("placementName");
                TJPlacement placement = TapjoyAdapter.this.getPlacement(optString);
                placement.setVideoListener(TapjoyAdapter.this);
                if (placement != null) {
                    TapjoyAdapter.this.mInterstitialPlacementToAd.put(optString, placement);
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose("loadInterstitial - requestContent - placementName = " + optString);
                    placement.requestContent();
                    return;
                }
                IronLog ironLog2 = IronLog.ADAPTER_API;
                ironLog2.verbose("loadInterstitial - onInterstitialAdLoadFailed - TJPlacement is null for placementName = " + optString);
                nVar.a(new com.ironsource.mediationsdk.logger.b(TypedValues.PositionType.TYPE_POSITION_TYPE, "Load error"));
            }
        });
    }

    @Override // com.ironsource.mediationsdk.b
    public void loadInterstitialForBidding(final JSONObject jSONObject, final n nVar, final String str) {
        this.mInterstitialPlacementToIsReady.put(jSONObject.optString("placementName"), Boolean.FALSE);
        mThreadPool.execute(new Runnable() { // from class: com.ironsource.adapters.tapjoy.TapjoyAdapter.6
            @Override // java.lang.Runnable
            public void run() {
                String optString = jSONObject.optString("placementName");
                TJPlacement auctionPlacement = TapjoyAdapter.this.getAuctionPlacement(optString, str);
                auctionPlacement.setVideoListener(TapjoyAdapter.this);
                if (auctionPlacement != null) {
                    TapjoyAdapter.this.mInterstitialPlacementToAd.put(optString, auctionPlacement);
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose("loadInterstitialForBidding - requestContent - placementName = " + optString);
                    auctionPlacement.requestContent();
                    return;
                }
                IronLog ironLog2 = IronLog.ADAPTER_API;
                ironLog2.verbose("loadInterstitialForBidding - onInterstitialAdLoadFailed - TJPlacement is null for placementName = " + optString);
                nVar.a(new com.ironsource.mediationsdk.logger.b(5000, "Load error"));
            }
        });
    }

    @Override // com.ironsource.mediationsdk.b
    public void loadRewardedVideoForBidding(JSONObject jSONObject, final u uVar, final String str) {
        final String optString = jSONObject.optString("placementName");
        mThreadPool.execute(new Runnable() { // from class: com.ironsource.adapters.tapjoy.TapjoyAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                TJPlacement auctionPlacement = TapjoyAdapter.this.getAuctionPlacement(optString, str);
                auctionPlacement.setVideoListener(TapjoyAdapter.this);
                if (auctionPlacement != null) {
                    TapjoyAdapter.this.mRewardedVideoPlacementToAd.put(optString, auctionPlacement);
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose("loadRewardedVideoForBidding - requestContent - requestContent = " + optString);
                    auctionPlacement.requestContent();
                    return;
                }
                IronLog.ADAPTER_API.verbose("loadRewardedVideoForBidding - onRewardedVideoAvailabilityChanged(false) - TJPlacement is null");
                uVar.i(false);
                uVar.s(new com.ironsource.mediationsdk.logger.b(5000, "Load error"));
            }
        });
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onClick(TJPlacement tJPlacement) {
        IronLog.ADAPTER_CALLBACK.verbose(tJPlacement.getName());
        if (this.mRewardedVideoPlacementToListener.containsKey(tJPlacement.getName())) {
            this.mRewardedVideoPlacementToListener.get(tJPlacement.getName()).v();
        }
        if (this.mInterstitialPlacementToListener.containsKey(tJPlacement.getName())) {
            this.mInterstitialPlacementToListener.get(tJPlacement.getName()).g();
        }
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onContentDismiss(TJPlacement tJPlacement) {
        IronLog.ADAPTER_CALLBACK.verbose(tJPlacement.getName());
        if (this.mRewardedVideoPlacementToListener.containsKey(tJPlacement.getName())) {
            this.mRewardedVideoPlacementToListener.get(tJPlacement.getName()).onRewardedVideoAdClosed();
        }
        if (this.mInterstitialPlacementToListener.containsKey(tJPlacement.getName())) {
            this.mInterstitialPlacementToListener.get(tJPlacement.getName()).f();
        }
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onContentReady(TJPlacement tJPlacement) {
        String name = tJPlacement.getName();
        IronLog.ADAPTER_CALLBACK.verbose(name);
        if (this.mRewardedVideoPlacementToListener.containsKey(name)) {
            this.mRewardedVideoPlacementToListener.get(name).i(true);
            this.mRewardedVideoPlacementToIsReady.put(name, Boolean.TRUE);
        }
        if (this.mInterstitialPlacementToListener.containsKey(name)) {
            this.mInterstitialPlacementToListener.get(name).c();
            this.mInterstitialPlacementToIsReady.put(name, Boolean.TRUE);
        }
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onContentShow(TJPlacement tJPlacement) {
        IronLog.ADAPTER_CALLBACK.verbose(tJPlacement.getName());
    }

    @Override // com.ironsource.mediationsdk.o
    public void onNetworkInitCallbackFailed(String str) {
        for (n nVar : this.mInterstitialPlacementToListener.values()) {
            nVar.w(f.c("Tapjoy sdk init failed", "Interstitial"));
        }
        for (String str2 : this.mRewardedVideoPlacementToListener.keySet()) {
            u uVar = this.mRewardedVideoPlacementToListener.get(str2);
            if (this.mProgrammaticPlacements.contains(str2)) {
                uVar.t(f.c("Tapjoy sdk init failed", "Rewarded Video"));
            } else {
                uVar.i(false);
            }
        }
    }

    public void onNetworkInitCallbackLoadSuccess(String str) {
    }

    @Override // com.ironsource.mediationsdk.o
    public void onNetworkInitCallbackSuccess() {
        if (!TextUtils.isEmpty(this.userId)) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("setUserID to " + this.userId);
            Tapjoy.setUserID(this.userId);
        }
        Tapjoy.setActivity(ContextProvider.getInstance().b());
        for (n nVar : this.mInterstitialPlacementToListener.values()) {
            nVar.onInterstitialInitSuccess();
        }
        for (String str : this.mRewardedVideoPlacementToListener.keySet()) {
            u uVar = this.mRewardedVideoPlacementToListener.get(str);
            if (this.mProgrammaticPlacements.contains(str)) {
                uVar.z();
            } else {
                loadVideo(str, uVar);
            }
        }
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onPurchaseRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str) {
        IronLog.ADAPTER_CALLBACK.verbose(tJPlacement.getName());
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onRequestFailure(TJPlacement tJPlacement, TJError tJError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(tJPlacement.getName() + " " + tJError.message);
        if (this.mRewardedVideoPlacementToListener.containsKey(tJPlacement.getName())) {
            this.mRewardedVideoPlacementToListener.get(tJPlacement.getName()).i(false);
            try {
                this.mRewardedVideoPlacementToListener.get(tJPlacement.getName()).s(new com.ironsource.mediationsdk.logger.b(tJError.code, tJError.message + "( " + tJError + " )"));
            } catch (Throwable unused) {
            }
        }
        if (this.mInterstitialPlacementToListener.containsKey(tJPlacement.getName())) {
            this.mInterstitialPlacementToListener.get(tJPlacement.getName()).a(new com.ironsource.mediationsdk.logger.b(tJError.code, tJError.message));
        }
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onRequestSuccess(final TJPlacement tJPlacement) {
        IronLog.ADAPTER_CALLBACK.verbose(tJPlacement.getName());
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.tapjoy.TapjoyAdapter.9
            @Override // java.lang.Runnable
            public void run() {
                if (tJPlacement.isContentAvailable()) {
                    return;
                }
                TapjoyAdapter.mThreadPool.execute(new Runnable() { // from class: com.ironsource.adapters.tapjoy.TapjoyAdapter.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (TapjoyAdapter.this.mRewardedVideoPlacementToListener.containsKey(tJPlacement.getName())) {
                            ((u) TapjoyAdapter.this.mRewardedVideoPlacementToListener.get(tJPlacement.getName())).i(false);
                            try {
                                ((u) TapjoyAdapter.this.mRewardedVideoPlacementToListener.get(tJPlacement.getName())).s(new com.ironsource.mediationsdk.logger.b(509, "No content available"));
                            } catch (Throwable unused) {
                            }
                        }
                        if (TapjoyAdapter.this.mInterstitialPlacementToListener.containsKey(tJPlacement.getName())) {
                            ((n) TapjoyAdapter.this.mInterstitialPlacementToListener.get(tJPlacement.getName())).a(new com.ironsource.mediationsdk.logger.b(5001, "No content available"));
                        }
                    }
                });
            }
        });
    }

    @Override // com.tapjoy.TJPlacementListener
    public void onRewardRequest(TJPlacement tJPlacement, TJActionRequest tJActionRequest, String str, int i2) {
        IronLog.ADAPTER_CALLBACK.verbose(tJPlacement.getName());
    }

    @Override // com.tapjoy.TJPlacementVideoListener
    public void onVideoComplete(TJPlacement tJPlacement) {
        IronLog.ADAPTER_CALLBACK.verbose(tJPlacement.getName());
        if (this.mRewardedVideoPlacementToListener.containsKey(tJPlacement.getName())) {
            this.mRewardedVideoPlacementToListener.get(tJPlacement.getName()).d();
            this.mRewardedVideoPlacementToListener.get(tJPlacement.getName()).y();
        }
    }

    @Override // com.tapjoy.TJPlacementVideoListener
    public void onVideoError(TJPlacement tJPlacement, String str) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(tJPlacement.getName() + " " + str);
    }

    @Override // com.tapjoy.TJPlacementVideoListener
    public void onVideoStart(TJPlacement tJPlacement) {
        String name = tJPlacement.getName();
        IronLog.ADAPTER_CALLBACK.verbose(name);
        if (this.mRewardedVideoPlacementToListener.containsKey(name)) {
            this.mRewardedVideoPlacementToListener.get(name).onRewardedVideoAdOpened();
        }
        if (this.mInterstitialPlacementToListener.containsKey(name)) {
            this.mInterstitialPlacementToListener.get(name).h();
            this.mInterstitialPlacementToListener.get(name).j();
        }
        if (this.mRewardedVideoPlacementToListener.containsKey(tJPlacement.getName())) {
            this.mRewardedVideoPlacementToListener.get(tJPlacement.getName()).o();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ironsource.mediationsdk.b
    public void setConsent(boolean z) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("setUserConsent = " + z);
        tjPrivacyPolicy.setUserConsent(z ? "1" : "0");
    }

    @Override // com.ironsource.mediationsdk.b
    protected void setMetaData(String str, String str2) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("key = " + str + ", value = " + str2);
        if (a.c(str, str2)) {
            setCCPAValue(a.b(str2));
        }
    }

    @Override // com.ironsource.mediationsdk.n0.k
    public void showInterstitial(final JSONObject jSONObject, final n nVar) {
        this.mInterstitialPlacementToIsReady.put(jSONObject.optString("placementName"), Boolean.FALSE);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.tapjoy.TapjoyAdapter.8
            @Override // java.lang.Runnable
            public void run() {
                String optString = jSONObject.optString("placementName");
                if (TapjoyAdapter.this.mInterstitialPlacementToAd.containsKey(optString) && ((TJPlacement) TapjoyAdapter.this.mInterstitialPlacementToAd.get(optString)).isContentReady()) {
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose("showInterstitial - showContent - placementName = " + optString);
                    ((TJPlacement) TapjoyAdapter.this.mInterstitialPlacementToAd.get(optString)).showContent();
                    return;
                }
                IronLog ironLog2 = IronLog.ADAPTER_API;
                ironLog2.verbose("showInterstitial - onInterstitialAdShowFailed - placementName = " + optString);
                nVar.e(f.f("Interstitial"));
            }
        });
    }

    public void showRewardedVideo(final JSONObject jSONObject, final u uVar) {
        this.mRewardedVideoPlacementToIsReady.put(jSONObject.optString("placementName"), Boolean.FALSE);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.tapjoy.TapjoyAdapter.5
            @Override // java.lang.Runnable
            public void run() {
                String optString = jSONObject.optString("placementName");
                if (TapjoyAdapter.this.mRewardedVideoPlacementToAd.containsKey(optString) && ((TJPlacement) TapjoyAdapter.this.mRewardedVideoPlacementToAd.get(optString)).isContentReady()) {
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose("showRewardedVideo - showContent - placementName = " + optString);
                    ((TJPlacement) TapjoyAdapter.this.mRewardedVideoPlacementToAd.get(optString)).showContent();
                } else if (uVar != null) {
                    IronLog ironLog2 = IronLog.ADAPTER_API;
                    ironLog2.verbose("showRewardedVideo - onRewardedVideoAdShowFailed - placementName = " + optString);
                    uVar.k(f.f("Rewarded Video"));
                    uVar.i(false);
                }
            }
        });
    }
}
