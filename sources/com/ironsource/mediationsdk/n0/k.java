package com.ironsource.mediationsdk.n0;

import org.json.JSONObject;
/* compiled from: InterstitialAdapterApi.java */
/* loaded from: classes2.dex */
public interface k {
    void initInterstitial(String str, String str2, JSONObject jSONObject, n nVar);

    boolean isInterstitialReady(JSONObject jSONObject);

    void loadInterstitial(JSONObject jSONObject, n nVar);

    void showInterstitial(JSONObject jSONObject, n nVar);
}
