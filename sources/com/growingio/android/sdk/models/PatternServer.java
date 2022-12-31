package com.growingio.android.sdk.models;

import com.facebook.common.callercontext.ContextChain;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.NetworkConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PatternServer {
    private String ai;
    private String domain;
    private String page;
    private String token;
    private String xpath;

    public PatternServer(String str, String str2, String str3, String str4) {
        this.ai = str;
        this.domain = str2;
        this.page = str3;
        this.token = str4;
    }

    public void setXpath(String str) {
        this.xpath = str;
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ai", this.ai);
            jSONObject.put("cs1", CoreInitialize.config().getAppUserId());
            jSONObject.put("d", this.domain);
            jSONObject.put(ContextChain.TAG_PRODUCT, this.page);
            jSONObject.put("gtaHost", NetworkConfig.getInstance().getGtaHost());
            jSONObject.put("x", this.xpath);
            jSONObject.put("s", CoreInitialize.sessionManager().getSessionIdInner());
            jSONObject.put("token", this.token);
            jSONObject.put("u", AbstractGrowingIO.getInstance().getDeviceId());
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
