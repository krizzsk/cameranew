package com.growingio.android.sdk.models.ad;

import android.os.Build;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.models.VPAEvent;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.NetworkUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
abstract class BaseAdEvent extends VPAEvent {
    private static final String TAG = "BaseAdEvent";

    public BaseAdEvent() {
        this(System.currentTimeMillis());
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", CoreInitialize.deviceUUIDFactory().getIMEI());
            jSONObject.put("adrid", CoreInitialize.deviceUUIDFactory().getAndroidId());
            jSONObject.put("ua", CoreInitialize.deviceUUIDFactory().getUserAgent());
            String str = Build.MODEL;
            String str2 = NetworkUtil.NETWORK_UNKNOWN;
            if (str == null) {
                str = NetworkUtil.NETWORK_UNKNOWN;
            }
            jSONObject.put("dm", str);
            String str3 = Build.VERSION.RELEASE;
            if (str3 != null) {
                str2 = str3;
            }
            jSONObject.put("osv", str2);
            jSONObject.put("d", getAPPState().getSPN());
            jSONObject.put("t", getType());
            jSONObject.put("tm", getTime());
        } catch (JSONException e2) {
            LogUtil.d(TAG, "generation the AD Event error", e2);
        }
        return jSONObject;
    }

    private BaseAdEvent(long j2) {
        super(j2);
    }
}
