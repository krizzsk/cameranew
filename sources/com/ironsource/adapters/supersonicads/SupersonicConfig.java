package com.ironsource.adapters.supersonicads;

import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.c;
import com.ironsource.mediationsdk.model.l;
import com.ironsource.mediationsdk.model.r;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public class SupersonicConfig {
    private static SupersonicConfig mInstance;
    private Map<String, String> mOfferwallCustomParams;
    private Map<String, String> mRewardedVideoCustomParams;
    private final String CUSTOM_PARAM_PREFIX = "custom_";
    private final String CLIENT_SIDE_CALLBACKS = "useClientSideCallbacks";
    private final String MAX_VIDEO_LENGTH = "maxVideoLength";
    private final String DYNAMIC_CONTROLLER_URL = "controllerUrl";
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE = "debugMode";
    private final String CAMPAIGN_ID = Constants.FirelogAnalytics.PARAM_CAMPAIGN_ID;
    private final String LANGUAGE = IjkMediaMeta.IJKM_KEY_LANGUAGE;
    private final String APPLICATION_PRIVATE_KEY = "privateKey";
    private final String ITEM_NAME = "itemName";
    private final String ITEM_COUNT = "itemCount";
    l mProviderSettings = new l(r.e().d("Mediation"));

    private SupersonicConfig() {
    }

    private Map<String, String> convertCustomParams(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            try {
                Set<String> keySet = map.keySet();
                if (keySet != null) {
                    for (String str : keySet) {
                        if (!TextUtils.isEmpty(str)) {
                            String str2 = map.get(str);
                            if (!TextUtils.isEmpty(str2)) {
                                hashMap.put("custom_" + str, str2);
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                c.i().e(IronSourceLogger.IronSourceTag.NATIVE, ":convertCustomParams()", e2);
            }
        }
        return hashMap;
    }

    public static SupersonicConfig getConfigObj() {
        if (mInstance == null) {
            mInstance = new SupersonicConfig();
        }
        return mInstance;
    }

    public boolean getClientSideCallbacks() {
        l lVar = this.mProviderSettings;
        if (lVar == null || lVar.o() == null || !this.mProviderSettings.o().has("useClientSideCallbacks")) {
            return false;
        }
        return this.mProviderSettings.o().optBoolean("useClientSideCallbacks", false);
    }

    public Map<String, String> getOfferwallCustomParams() {
        return this.mOfferwallCustomParams;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> getRewardedVideoCustomParams() {
        return this.mRewardedVideoCustomParams;
    }

    public void setCampaignId(String str) {
        this.mProviderSettings.E(Constants.FirelogAnalytics.PARAM_CAMPAIGN_ID, str);
    }

    public void setClientSideCallbacks(boolean z) {
        this.mProviderSettings.E("useClientSideCallbacks", String.valueOf(z));
    }

    public void setCustomControllerUrl(String str) {
        this.mProviderSettings.E("controllerUrl", str);
        this.mProviderSettings.A("controllerUrl", str);
        this.mProviderSettings.x("controllerUrl", str);
    }

    public void setDebugMode(int i2) {
        this.mProviderSettings.E("debugMode", Integer.valueOf(i2));
        this.mProviderSettings.A("debugMode", Integer.valueOf(i2));
        this.mProviderSettings.x("debugMode", Integer.valueOf(i2));
    }

    public void setLanguage(String str) {
        this.mProviderSettings.E(IjkMediaMeta.IJKM_KEY_LANGUAGE, str);
        this.mProviderSettings.A(IjkMediaMeta.IJKM_KEY_LANGUAGE, str);
    }

    public void setOfferwallCustomParams(Map<String, String> map) {
        this.mOfferwallCustomParams = convertCustomParams(map);
    }

    public void setRewardedVideoCustomParams(Map<String, String> map) {
        this.mRewardedVideoCustomParams = convertCustomParams(map);
    }
}
