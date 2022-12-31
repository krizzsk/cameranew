package com.ironsource.sdk.WPAD;

import android.app.Activity;
import android.webkit.WebView;
import com.ironsource.sdk.utils.d;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AdViewsManager {
    private static final String b = "AdViewsManager";
    private static AdViewsManager c;
    Map<String, b> a = Collections.synchronizedMap(new HashMap());

    public static synchronized AdViewsManager getInstance() {
        AdViewsManager adViewsManager;
        synchronized (AdViewsManager.class) {
            if (c == null) {
                c = new AdViewsManager();
            }
            adViewsManager = c;
        }
        return adViewsManager;
    }

    public WebView a(String str) {
        if (str.isEmpty() || !this.a.containsKey(str)) {
            return null;
        }
        return this.a.get(str).c();
    }

    public String b(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !jSONObject.has("adViewId")) {
            return (jSONObject == null || !jSONObject.has("params")) ? "" : new JSONObject(jSONObject.getString("params")).getString("adViewId");
        }
        return jSONObject.getString("adViewId");
    }

    public void c(com.ironsource.sdk.ISNAdView.a aVar, JSONObject jSONObject, Activity activity, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (!string.isEmpty()) {
            if (!this.a.containsKey(string)) {
                c cVar = new c(aVar, activity, string);
                this.a.put(string, cVar);
                cVar.q(jSONObject, str, str2);
                return;
            }
            d.d(b, "sendMessageToAd fail - collection already contain adViewId");
            throw new Exception("collection already contain adViewId");
        }
        d.d(b, "loadWithUrl fail - adViewId is empty");
        throw new Exception("adViewId is empty");
    }

    public void d(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (!string.isEmpty()) {
            if (this.a.containsKey(string)) {
                this.a.remove(string);
                this.a.get(string).a(str, str2);
                return;
            }
            d.d(b, "removeAdView fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
        d.d(b, "removeAdView fail - adViewId is empty");
        throw new Exception("adViewId is empty");
    }

    public void e(JSONObject jSONObject, String str) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (!string.isEmpty()) {
            if (this.a.containsKey(string)) {
                this.a.get(string).d(str);
                return;
            } else {
                d.d(b, "sendIsExternalAdViewInitiated fail - collection does not contain adViewId");
                throw new Exception("collection does not contain adViewId");
            }
        }
        d.d(b, "sendIsExternalAdViewInitiated fail - adViewId is empty");
        throw new Exception("adViewId is empty");
    }

    public void f(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = new JSONObject(jSONObject.getString("params")).getString("adViewId");
        if (!string.isEmpty()) {
            if (this.a.containsKey(string)) {
                this.a.get(string).b(jSONObject, str, str2);
                return;
            } else {
                d.d(b, "sendMessageToAd fail - collection does not contain adViewId");
                throw new Exception("collection does not contain adViewId");
            }
        }
        d.d(b, "sendMessageToAd fail - adViewId is empty");
        throw new Exception("adViewId is empty");
    }
}
