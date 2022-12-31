package com.growingio.android.sdk.models;

import android.text.TextUtils;
import com.facebook.common.callercontext.ContextChain;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.collection.CoreInitialize;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PageVariableEvent extends VPAEvent {
    public static final String TYPE_NAME = "pvar";
    private JSONObject mPVar;
    private PageEvent mPage;
    private JSONObject mWebEvent;

    public PageVariableEvent(PageEvent pageEvent, JSONObject jSONObject) {
        super(pageEvent.time);
        this.mPage = pageEvent;
        this.mPVar = jSONObject;
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
            commonProperty.put(ContextChain.TAG_PRODUCT, this.mPage.mPageName);
            commonProperty.put("ptm", this.mPage.time);
            commonProperty.put("var", this.mPVar);
            return commonProperty;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public PageVariableEvent(JSONObject jSONObject) throws Throwable {
        super(jSONObject.optLong("tm") != 0 ? jSONObject.optLong("tm") : System.currentTimeMillis());
        jSONObject.put("s", CoreInitialize.sessionManager().getSessionIdInner());
        String string = jSONObject.getString("d");
        jSONObject.put("d", getAPPState().getSPN() + Constants.WEB_PART_SEPARATOR + string);
        String optString = jSONObject.optString(ContextChain.TAG_PRODUCT);
        jSONObject.put(ContextChain.TAG_PRODUCT, CoreInitialize.messageProcessor().getPageNameWithPending() + Constants.WEB_PART_SEPARATOR + optString);
        String appUserId = getConfig().getAppUserId();
        if (!TextUtils.isEmpty(appUserId)) {
            jSONObject.put("cs1", appUserId);
        }
        this.mWebEvent = jSONObject;
    }
}
