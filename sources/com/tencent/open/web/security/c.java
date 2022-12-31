package com.tencent.open.web.security;

import android.webkit.WebView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tencent.open.a;
import com.tencent.open.log.SLog;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class c extends a.C0279a {

    /* renamed from: d  reason: collision with root package name */
    private String f8217d;

    public c(WebView webView, long j2, String str, String str2) {
        super(webView, j2, str);
        this.f8217d = str2;
    }

    private void b(String str) {
        WebView webView = this.a.get();
        if (webView != null) {
            StringBuffer stringBuffer = new StringBuffer("javascript:");
            stringBuffer.append("if(!!");
            stringBuffer.append(this.f8217d);
            stringBuffer.append("){");
            stringBuffer.append(this.f8217d);
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append(")}");
            String stringBuffer2 = stringBuffer.toString();
            SLog.v("openSDK_LOG.SecureJsListener", "-->callback, callback: " + stringBuffer2);
            webView.loadUrl(stringBuffer2);
            VdsAgent.loadUrl(webView, stringBuffer2);
        }
    }

    @Override // com.tencent.open.a.C0279a
    public void a(Object obj) {
        SLog.v("openSDK_LOG.SecureJsListener", "-->onComplete, result: " + obj);
    }

    @Override // com.tencent.open.a.C0279a
    public void a() {
        SLog.d("openSDK_LOG.SecureJsListener", "-->onNoMatchMethod...");
    }

    @Override // com.tencent.open.a.C0279a
    public void a(String str) {
        SLog.v("openSDK_LOG.SecureJsListener", "-->onCustomCallback, js: " + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", !com.tencent.open.b.c.a ? -4 : 0);
            jSONObject.put("sn", this.b);
            jSONObject.put("data", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        b(jSONObject.toString());
    }
}
