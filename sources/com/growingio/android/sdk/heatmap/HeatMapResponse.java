package com.growingio.android.sdk.heatmap;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.models.HeatMapData;
import com.growingio.android.sdk.utils.LogUtil;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class HeatMapResponse {
    private static String TAG = "GIO.HeatMapResponse";
    private HeatMapData[] data;
    private String reason;
    private boolean success;

    public HeatMapResponse(JSONObject jSONObject) {
        if (jSONObject != null) {
            LogUtil.d("HeatMapResponse", jSONObject.toString());
        }
        try {
            this.success = jSONObject.getBoolean(FirebaseAnalytics.Param.SUCCESS);
            if (jSONObject.has("reason")) {
                this.reason = jSONObject.getString("reason");
            }
            if (jSONObject.has("data")) {
                this.data = HeatMapData.parseArray(jSONObject.getJSONArray("data"));
            }
        } catch (Throwable th) {
            String str = TAG;
            LogUtil.e(str, "HeatMapResponse解析异常" + th);
        }
    }

    public HeatMapData[] getData() {
        return this.data;
    }

    public String getReason() {
        return this.reason;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setData(HeatMapData[] heatMapDataArr) {
        this.data = heatMapDataArr;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
