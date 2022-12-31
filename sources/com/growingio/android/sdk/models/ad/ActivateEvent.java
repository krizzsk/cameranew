package com.growingio.android.sdk.models.ad;

import android.text.TextUtils;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.deeplink.DeeplinkInfo;
import com.growingio.android.sdk.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ActivateEvent extends BaseAdEvent {
    private static final String TAG = "ActivateEvent";
    public static final String TYPE_NAME = "activate";
    private DeeplinkInfo mDeeplinkInfo;
    private String mGoogleId;
    private String mOaid;

    public ActivateEvent() {
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public void backgroundWorker() {
        super.backgroundWorker();
        this.mGoogleId = CoreInitialize.deviceUUIDFactory().getGoogleAdId();
        this.mOaid = CoreInitialize.deviceUUIDFactory().getOaid();
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public String getType() {
        return "activate";
    }

    @Override // com.growingio.android.sdk.models.ad.BaseAdEvent, com.growingio.android.sdk.models.VPAEvent
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        try {
            if (!TextUtils.isEmpty(this.mGoogleId)) {
                json.put("gaid", this.mGoogleId);
            }
            if (!TextUtils.isEmpty(this.mOaid)) {
                json.put("oaid", this.mOaid);
            }
            DeeplinkInfo deeplinkInfo = this.mDeeplinkInfo;
            if (deeplinkInfo != null) {
                json.put("link_id", deeplinkInfo.linkID);
                json.put("click_id", this.mDeeplinkInfo.clickID);
                json.put("tm_click", this.mDeeplinkInfo.clickTM);
                json.put("cl", "defer");
            }
        } catch (JSONException e2) {
            LogUtil.d(TAG, "generation the Activate Event error", e2);
        }
        return json;
    }

    public ActivateEvent(DeeplinkInfo deeplinkInfo) {
        this.mDeeplinkInfo = deeplinkInfo;
    }
}
