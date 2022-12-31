package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.utils.l;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: TTWebChromeClient.java */
/* loaded from: classes.dex */
public class b extends WebChromeClient {
    private static final String a = WebChromeClient.class.getSimpleName();
    private final v b;
    private j c;

    public b(v vVar, j jVar) {
        this.b = vVar;
        this.c = jVar;
    }

    private boolean a(@NonNull String str) {
        try {
            Uri parse = Uri.parse(str);
            if ("bytedance".equals(parse.getScheme().toLowerCase())) {
                l.a(parse, this.b);
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i2, String str2) {
        if (!TextUtils.isEmpty(str)) {
            a(str);
        }
        super.onConsoleMessage(str, i2, str2);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i2) {
        VdsAgent.onProgressChangedStart(webView, i2);
        super.onProgressChanged(webView, i2);
        j jVar = this.c;
        if (jVar != null) {
            jVar.a(webView, i2);
        }
        VdsAgent.onProgressChangedEnd(webView, i2);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage == null || TextUtils.isEmpty(consoleMessage.message()) || !a(consoleMessage.message())) {
            return super.onConsoleMessage(consoleMessage);
        }
        return true;
    }
}
