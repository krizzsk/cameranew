package com.growingio.android.sdk.models.ad;

import android.text.TextUtils;
import com.growingio.android.sdk.deeplink.DeeplinkInfo;
import com.growingio.android.sdk.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ReengageEvent extends BaseAdEvent {
    private static final String TAG = "ReengageEvent";
    public static final String TYPE_NAME = "reengage";
    private final DeeplinkInfo mDeeplinkInfo;

    public ReengageEvent(DeeplinkInfo deeplinkInfo) {
        this.mDeeplinkInfo = deeplinkInfo;
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public String getType() {
        return TYPE_NAME;
    }

    @Override // com.growingio.android.sdk.models.ad.BaseAdEvent, com.growingio.android.sdk.models.VPAEvent
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        try {
            json.put("link_id", this.mDeeplinkInfo.linkID);
            json.put("click_id", this.mDeeplinkInfo.clickID);
            json.put("tm_click", this.mDeeplinkInfo.clickTM);
            json.put("var", this.mDeeplinkInfo.customParams);
            String appUserId = getConfig().getAppUserId();
            if (!TextUtils.isEmpty(appUserId)) {
                json.put("cs1", appUserId);
            }
        } catch (JSONException e2) {
            LogUtil.d(TAG, "generation the Reengage Event error", e2);
        }
        return json;
    }
}
