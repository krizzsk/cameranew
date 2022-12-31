package com.growingio.android.sdk.models;

import android.text.TextUtils;
import com.facebook.common.callercontext.ContextChain;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.ThreadUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class VPAEvent {
    public static final String EACH_TYPE_EVENT_SEQUENCE_ID = "esid";
    public static final String GLOBAL_EVENT_SEQUENCE_ID = "gesid";
    public static final String TAG = "GIO.VPAEvent";
    public String mPageName;
    long time;

    public VPAEvent(long j2) {
        this.time = j2;
    }

    public void backgroundWorker() {
        if (ThreadUtils.runningOnUiThread()) {
            throw new IllegalStateException("backgroundWorker don't allow run on UI Thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CoreAppState getAPPState() {
        return CoreInitialize.coreAppState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject getCommonProperty() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s", CoreInitialize.sessionManager().getSessionIdInner());
            jSONObject.put("t", getType());
            jSONObject.put("tm", this.time);
            jSONObject.put("d", getAPPState().getSPN());
            String str = this.mPageName;
            if (str != null) {
                jSONObject.put(ContextChain.TAG_PRODUCT, str);
            }
            String appUserId = getConfig().getAppUserId();
            if (!TextUtils.isEmpty(appUserId)) {
                jSONObject.put("cs1", appUserId);
            }
        } catch (JSONException e2) {
            LogUtil.d(TAG, "generate common event property error", e2);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GConfig getConfig() {
        return CoreInitialize.config();
    }

    public String getFullType() {
        return getType();
    }

    public long getTime() {
        return this.time;
    }

    public abstract String getType();

    /* JADX INFO: Access modifiers changed from: protected */
    public void patchAndroidId(JSONObject jSONObject) {
        try {
            jSONObject.put("adrid", CoreInitialize.deviceUUIDFactory().getAndroidId());
        } catch (Exception e2) {
            LogUtil.d(TAG, "patch androidId value error: ", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void patchIMEI(JSONObject jSONObject) {
        try {
            jSONObject.put("imei", CoreInitialize.deviceUUIDFactory().getIMEI());
        } catch (Exception e2) {
            LogUtil.d(TAG, "patch imei value error: ", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void patchLocation(JSONObject jSONObject) {
        try {
            jSONObject.put("lat", getAPPState().getLatitude());
            jSONObject.put("lng", getAPPState().getLongitude());
        } catch (Exception e2) {
            LogUtil.d(TAG, "patch location error ", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void patchNetworkState(JSONObject jSONObject) {
        try {
            jSONObject.put("r", getAPPState().getNetworkStateName());
        } catch (Exception e2) {
            LogUtil.d(TAG, "patch NetWorkState value error: ", e2);
        }
    }

    public int size() {
        return 1;
    }

    public abstract JSONObject toJson();
}
