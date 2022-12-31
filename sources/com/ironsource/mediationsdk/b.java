package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.utils.ContextProvider;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* compiled from: AbstractAdapter.java */
/* loaded from: classes2.dex */
public abstract class b implements com.ironsource.mediationsdk.n0.k, com.ironsource.mediationsdk.n0.r {
    private static Boolean mAdapterDebug;
    protected com.ironsource.mediationsdk.n0.c mActiveBannerSmash;
    protected com.ironsource.mediationsdk.n0.n mActiveInterstitialSmash;
    protected com.ironsource.mediationsdk.n0.u mActiveRewardedVideoSmash;
    private String mPluginFrameworkVersion;
    private String mPluginType;
    private String mProviderName;
    protected LoadWhileShowSupportState mLWSSupportState = LoadWhileShowSupportState.NONE;
    private com.ironsource.mediationsdk.logger.c mLoggerManager = com.ironsource.mediationsdk.logger.c.i();
    protected CopyOnWriteArrayList<com.ironsource.mediationsdk.n0.u> mAllRewardedVideoSmashes = new CopyOnWriteArrayList<>();
    protected CopyOnWriteArrayList<com.ironsource.mediationsdk.n0.n> mAllInterstitialSmashes = new CopyOnWriteArrayList<>();
    protected CopyOnWriteArrayList<com.ironsource.mediationsdk.n0.c> mAllBannerSmashes = new CopyOnWriteArrayList<>();
    protected ConcurrentHashMap<String, com.ironsource.mediationsdk.n0.u> mRewardedVideoPlacementToListenerMap = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<String, com.ironsource.mediationsdk.n0.n> mInterstitialPlacementToListenerMap = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<String, com.ironsource.mediationsdk.n0.c> mBannerPlacementToListenerMap = new ConcurrentHashMap<>();

    public b(String str) {
        this.mProviderName = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addBannerListener(com.ironsource.mediationsdk.n0.c cVar) {
    }

    public void addInterstitialListener(com.ironsource.mediationsdk.n0.n nVar) {
        this.mAllInterstitialSmashes.add(nVar);
    }

    public void addRewardedVideoListener(com.ironsource.mediationsdk.n0.u uVar) {
        this.mAllRewardedVideoSmashes.add(uVar);
    }

    public void destroyBanner(JSONObject jSONObject) {
    }

    public void earlyInit(String str, String str2, JSONObject jSONObject) {
    }

    public Map<String, Object> getBannerBiddingData(JSONObject jSONObject) {
        return null;
    }

    public abstract String getCoreSDKVersion();

    protected String getDynamicUserId() {
        return IronSourceObject.getInstance().q();
    }

    public Map<String, Object> getInterstitialBiddingData(JSONObject jSONObject) {
        return null;
    }

    public LoadWhileShowSupportState getLoadWhileShowSupportState(JSONObject jSONObject) {
        return this.mLWSSupportState;
    }

    public JSONObject getPlayerBiddingData() {
        return null;
    }

    public String getPluginFrameworkVersion() {
        return this.mPluginFrameworkVersion;
    }

    public String getPluginType() {
        return this.mPluginType;
    }

    public String getProviderName() {
        return this.mProviderName;
    }

    public Map<String, Object> getRewardedVideoBiddingData(JSONObject jSONObject) {
        return null;
    }

    public abstract String getVersion();

    public void initBannerForBidding(String str, String str2, JSONObject jSONObject, com.ironsource.mediationsdk.n0.c cVar) {
    }

    public void initBanners(String str, String str2, JSONObject jSONObject, com.ironsource.mediationsdk.n0.c cVar) {
    }

    public void initInterstitialForBidding(String str, String str2, JSONObject jSONObject, com.ironsource.mediationsdk.n0.n nVar) {
    }

    public void initRewardedVideoForBidding(String str, String str2, JSONObject jSONObject, com.ironsource.mediationsdk.n0.u uVar) {
    }

    public void initRewardedVideoForDemandOnly(String str, String str2, JSONObject jSONObject, com.ironsource.mediationsdk.n0.u uVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAdaptersDebugEnabled() {
        Boolean bool = mAdapterDebug;
        return bool != null && bool.booleanValue();
    }

    public void loadBanner(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, com.ironsource.mediationsdk.n0.c cVar) {
    }

    public void loadBannerForBidding(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, com.ironsource.mediationsdk.n0.c cVar, String str) {
    }

    public void loadInterstitialForBidding(JSONObject jSONObject, com.ironsource.mediationsdk.n0.n nVar, String str) {
    }

    public void loadRewardedVideoForBidding(JSONObject jSONObject, com.ironsource.mediationsdk.n0.u uVar, String str) {
    }

    public void loadRewardedVideoForDemandOnly(JSONObject jSONObject, com.ironsource.mediationsdk.n0.u uVar) {
    }

    public void loadRewardedVideoForDemandOnlyForBidding(JSONObject jSONObject, com.ironsource.mediationsdk.n0.u uVar, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void postOnUIThread(Runnable runnable) {
        ContextProvider.getInstance().c(runnable);
    }

    public void reloadBanner(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, com.ironsource.mediationsdk.n0.c cVar) {
    }

    protected void removeBannerListener(com.ironsource.mediationsdk.n0.c cVar) {
    }

    public void removeInterstitialListener(com.ironsource.mediationsdk.n0.n nVar) {
        this.mAllInterstitialSmashes.remove(nVar);
    }

    public void removeRewardedVideoListener(com.ironsource.mediationsdk.n0.u uVar) {
        this.mAllRewardedVideoSmashes.remove(uVar);
    }

    protected void runOnUIThread(Runnable runnable) {
        ContextProvider.getInstance().e(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdapterDebug(Boolean bool) {
        mAdapterDebug = bool;
    }

    public void setAge(int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setConsent(boolean z) {
    }

    public void setGender(String str) {
    }

    public void setLogListener(com.ironsource.mediationsdk.logger.d dVar) {
    }

    public void setMediationSegment(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMediationState(AbstractSmash.MEDIATION_STATE mediation_state, String str) {
    }

    protected void setMetaData(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMetaData(String str, List<String> list) {
        for (String str2 : list) {
            setMetaData(str, str2);
        }
    }

    public void setPluginData(String str, String str2) {
        this.mPluginType = str;
        this.mPluginFrameworkVersion = str2;
    }

    public boolean shouldBindBannerViewOnReload() {
        return false;
    }

    public void updateRewardedVideoListener(com.ironsource.mediationsdk.n0.u uVar) {
        this.mAllRewardedVideoSmashes.clear();
        this.mAllRewardedVideoSmashes.add(uVar);
    }
}
