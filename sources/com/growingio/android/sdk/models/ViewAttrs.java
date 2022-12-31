package com.growingio.android.sdk.models;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
/* loaded from: classes2.dex */
public class ViewAttrs {
    private static final String illegalStr = "_!@#$%^&*()-=+|\\[]{},.<>/?";
    public String content;
    public String domain;
    public String href;
    public String index;
    public String nodeType;
    public String path;
    public String query;
    public boolean webElem = false;
    public String xpath;

    private static boolean isLegal(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.length() > 1) {
            return true;
        }
        char charAt = str.charAt(0);
        boolean z = charAt >= '0' && charAt <= '9';
        boolean z2 = (charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z');
        if (z || z2) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(charAt);
        sb.append("");
        return !illegalStr.contains(sb.toString());
    }

    public static ViewAttrs parse(JSONObject jSONObject) {
        ViewAttrs viewAttrs = new ViewAttrs();
        try {
            viewAttrs.domain = jSONObject.getString("domain");
            viewAttrs.xpath = jSONObject.optString("xpath");
            viewAttrs.path = jSONObject.optString(PGEditResultActivity2.PATH);
            viewAttrs.content = jSONObject.optString(FirebaseAnalytics.Param.CONTENT);
            viewAttrs.index = jSONObject.optString(FirebaseAnalytics.Param.INDEX);
            viewAttrs.query = jSONObject.optString("query");
            viewAttrs.href = jSONObject.optString("href");
            viewAttrs.nodeType = jSONObject.optString("nodeType");
        } catch (JSONException unused) {
        }
        return viewAttrs;
    }

    public ViewAttrs copy() {
        ViewAttrs viewAttrs = new ViewAttrs();
        viewAttrs.xpath = this.xpath;
        viewAttrs.path = this.path;
        viewAttrs.content = this.content;
        viewAttrs.domain = this.domain;
        viewAttrs.index = this.index;
        viewAttrs.query = this.query;
        viewAttrs.href = this.href;
        viewAttrs.nodeType = this.nodeType;
        return viewAttrs;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("domain", this.domain);
            jSONObject.put(PGEditResultActivity2.PATH, this.path);
            if (!TextUtils.isEmpty(this.xpath)) {
                jSONObject.put("xpath", this.xpath);
            }
            if (isLegal(this.content)) {
                jSONObject.put(FirebaseAnalytics.Param.CONTENT, this.content);
            }
            if (!TextUtils.isEmpty(this.index)) {
                jSONObject.put(FirebaseAnalytics.Param.INDEX, this.index);
            }
            if (!TextUtils.isEmpty(this.query)) {
                jSONObject.put("query", this.query);
            }
            if (!TextUtils.isEmpty("href")) {
                jSONObject.put("href", this.href);
            }
            if (!TextUtils.isEmpty(this.nodeType)) {
                jSONObject.put("nodeType", this.nodeType);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
