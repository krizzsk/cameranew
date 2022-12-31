package com.growingio.android.sdk.autoburry.events;

import android.view.View;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class WebCircleHybridReturnEvent {
    private final JSONObject message;
    private final View webView;

    public WebCircleHybridReturnEvent(View view, JSONObject jSONObject) {
        this.webView = view;
        this.message = jSONObject;
    }

    public JSONObject getMessage() {
        return this.message;
    }

    public View getWebView() {
        return this.webView;
    }
}
