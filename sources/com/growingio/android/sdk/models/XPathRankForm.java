package com.growingio.android.sdk.models;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
/* loaded from: classes2.dex */
public class XPathRankForm {
    String domain;
    String path;
    String range;
    ArrayList<String> xpath;

    public XPathRankForm(String str, String str2, ArrayList<String> arrayList, String str3) {
        this.domain = str;
        this.path = str2;
        this.xpath = arrayList;
        this.range = str3;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("domain", this.domain);
            jSONObject.put(PGEditResultActivity2.PATH, this.path);
            jSONObject.put("xpath", new JSONArray((Collection) this.xpath));
            jSONObject.put("range", this.range);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
