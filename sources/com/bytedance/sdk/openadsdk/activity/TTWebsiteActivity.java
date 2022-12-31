package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes.dex */
public class TTWebsiteActivity extends Activity {
    private String a = null;

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.f(this, "tt_activity_website"));
        WebView webView = (WebView) findViewById(t.e(this, "tt_ad_website"));
        if (o.h() != null) {
            this.a = o.h().q();
        }
        com.bytedance.sdk.openadsdk.utils.o.e("TTWebsiteActivity", "mWebsiteUrl=" + this.a);
        if (this.a != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                webView.getSettings().setMixedContentMode(0);
            }
            try {
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setDomStorageEnabled(true);
            } catch (Throwable unused) {
            }
            String str = this.a;
            webView.loadUrl(str);
            VdsAgent.loadUrl(webView, str);
            webView.setWebViewClient(new WebViewClient() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.1
                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView2, String str2) {
                    super.onPageFinished(webView2, str2);
                    com.bytedance.sdk.openadsdk.utils.o.e("TTWebsiteActivity", "onPageFinished invoke....url=" + str2);
                }

                @Override // android.webkit.WebViewClient
                @RequiresApi(api = 23)
                public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                    super.onReceivedError(webView2, webResourceRequest, webResourceError);
                    com.bytedance.sdk.openadsdk.utils.o.e("TTWebsiteActivity", "onReceivedError invoke....onReceivedError=" + webResourceError.getErrorCode());
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedHttpError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                    super.onReceivedHttpError(webView2, webResourceRequest, webResourceResponse);
                    com.bytedance.sdk.openadsdk.utils.o.e("TTWebsiteActivity", "onReceivedHttpError invoke....errorResponse=" + webResourceResponse);
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                    com.bytedance.sdk.openadsdk.utils.o.e("TTWebsiteActivity", "shouldOverrideUrlLoading invoke....view=" + webView2 + ",request=" + webResourceRequest);
                    if (webView2 == null || webResourceRequest == null) {
                        return false;
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        String uri = webResourceRequest.getUrl().toString();
                        webView2.loadUrl(uri);
                        VdsAgent.loadUrl(webView2, uri);
                        com.bytedance.sdk.openadsdk.utils.o.e("TTWebsiteActivity", "shouldOverrideUrlLoading invoke....url1=" + webResourceRequest.getUrl().toString());
                        return true;
                    }
                    String obj = webResourceRequest.toString();
                    webView2.loadUrl(obj);
                    VdsAgent.loadUrl(webView2, obj);
                    com.bytedance.sdk.openadsdk.utils.o.e("TTWebsiteActivity", "shouldOverrideUrlLoading invoke....url2=" + webResourceRequest.toString());
                    return true;
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedError(WebView webView2, int i2, String str2, String str3) {
                    super.onReceivedError(webView2, i2, str2, str3);
                    com.bytedance.sdk.openadsdk.utils.o.e("TTWebsiteActivity", "onReceivedError invoke....description=" + str2 + ",failingUrl=" + str3);
                }
            });
            return;
        }
        finish();
    }
}
