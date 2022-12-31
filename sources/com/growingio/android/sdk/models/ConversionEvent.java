package com.growingio.android.sdk.models;

import android.text.TextUtils;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.collection.CoreInitialize;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ConversionEvent extends VPAEvent {
    public static final String TYPE_NAME = "evar";
    private JSONObject mVariable;
    protected JSONObject mWebEvent;

    public ConversionEvent(JSONObject jSONObject, long j2) {
        super(j2);
        this.mVariable = jSONObject;
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public String getType() {
        return TYPE_NAME;
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public JSONObject toJson() {
        try {
            JSONObject jSONObject = this.mWebEvent;
            if (jSONObject != null) {
                return jSONObject;
            }
            JSONObject commonProperty = getCommonProperty();
            try {
                commonProperty.put("var", this.mVariable);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return commonProperty;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public ConversionEvent(JSONObject jSONObject) throws Throwable {
        super(jSONObject.optLong("tm") != 0 ? jSONObject.optLong("tm") : System.currentTimeMillis());
        jSONObject.put("s", CoreInitialize.sessionManager().getSessionIdInner());
        String string = jSONObject.getString("d");
        jSONObject.put("d", getAPPState().getSPN() + Constants.WEB_PART_SEPARATOR + string);
        String appUserId = getConfig().getAppUserId();
        if (!TextUtils.isEmpty(appUserId)) {
            jSONObject.put("cs1", appUserId);
        }
        this.mWebEvent = jSONObject;
    }
}
