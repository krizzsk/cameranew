package com.ironsource.sdk.WPAD;

import android.webkit.WebView;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ISNAdViewProtocol.java */
/* loaded from: classes2.dex */
public interface b {

    /* compiled from: ISNAdViewProtocol.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(String str);

        void b(String str);
    }

    void a(String str, String str2);

    void b(JSONObject jSONObject, String str, String str2) throws JSONException;

    WebView c();

    void d(String str);
}
