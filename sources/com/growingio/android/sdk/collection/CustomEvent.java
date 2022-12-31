package com.growingio.android.sdk.collection;

import android.text.TextUtils;
import com.facebook.common.callercontext.ContextChain;
import com.growingio.android.sdk.models.VPAEvent;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CustomEvent extends VPAEvent {
    public static final String TYPE_NAME = "cstm";
    String name;
    Number num;
    private long ptm;
    JSONObject variable;
    JSONObject webEvent;

    public CustomEvent(JSONObject jSONObject) {
        super(System.currentTimeMillis());
        this.webEvent = jSONObject;
        try {
            jSONObject.put("s", CoreInitialize.sessionManager().getSessionIdInner());
            String string = jSONObject.getString("d");
            jSONObject.put("d", getAPPState().getSPN() + Constants.WEB_PART_SEPARATOR + string);
            String optString = jSONObject.optString(ContextChain.TAG_PRODUCT);
            jSONObject.put(ContextChain.TAG_PRODUCT, CoreInitialize.messageProcessor().getPageNameWithPending() + Constants.WEB_PART_SEPARATOR + optString);
            String appUserId = getConfig().getAppUserId();
            if (TextUtils.isEmpty(appUserId)) {
                return;
            }
            jSONObject.put("cs1", appUserId);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public boolean fromWebView() {
        return this.webEvent != null;
    }

    public String getName() {
        return this.name;
    }

    public Number getNum() {
        return this.num;
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public String getType() {
        return TYPE_NAME;
    }

    public JSONObject getVariable() {
        return this.variable;
    }

    public JSONObject getWebEvent() {
        return this.webEvent;
    }

    public void setPageTime(long j2) {
        this.ptm = j2;
    }

    @Override // com.growingio.android.sdk.models.VPAEvent
    public JSONObject toJson() {
        try {
            JSONObject jSONObject = this.webEvent;
            if (jSONObject != null) {
                return jSONObject;
            }
            JSONObject commonProperty = getCommonProperty();
            commonProperty.put("n", this.name);
            commonProperty.put("var", this.variable);
            commonProperty.put("ptm", this.ptm);
            commonProperty.put("num", this.num);
            return commonProperty;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public CustomEvent(String str, Number number, JSONObject jSONObject) {
        super(System.currentTimeMillis());
        this.name = str;
        this.variable = jSONObject;
        this.num = number;
    }

    public CustomEvent(String str) {
        super(System.currentTimeMillis());
        this.name = str;
    }

    public CustomEvent(String str, Number number) {
        this(str, number, null);
    }

    public CustomEvent(String str, JSONObject jSONObject) {
        this(str, null, jSONObject);
    }
}
