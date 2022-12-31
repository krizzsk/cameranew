package com.unity3d.splash.services.core.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.unity3d.splash.services.core.log.DeviceLog;
import com.unity3d.splash.services.core.webview.WebViewApp;
import com.unity3d.splash.services.core.webview.WebViewEventCategory;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BroadcastEventReceiver extends BroadcastReceiver {
    private String a;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        String dataString = intent.getDataString() != null ? intent.getDataString() : "";
        JSONObject jSONObject = new JSONObject();
        try {
            if (intent.getExtras() != null) {
                Bundle extras = intent.getExtras();
                for (String str : extras.keySet()) {
                    jSONObject.put(str, extras.get(str));
                }
            }
        } catch (JSONException e2) {
            DeviceLog.c("JSONException when composing extras for broadcast action " + action + ": " + e2.getMessage());
        }
        WebViewApp e3 = WebViewApp.e();
        if (e3 == null || !e3.i()) {
            return;
        }
        e3.k(WebViewEventCategory.BROADCAST, BroadcastEvent.ACTION, this.a, action, dataString, jSONObject);
    }
}
