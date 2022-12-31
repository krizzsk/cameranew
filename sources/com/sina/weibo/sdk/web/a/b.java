package com.sina.weibo.sdk.web.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.share.ShareResultActivity;
/* loaded from: classes3.dex */
public abstract class b extends WebViewClient {
    protected com.sina.weibo.sdk.auth.b aC = com.sina.weibo.sdk.auth.b.f();
    protected Activity aD;
    protected com.sina.weibo.sdk.web.a aE;
    protected com.sina.weibo.sdk.web.b.b aF;
    protected WbAuthListener aG;

    public b(Activity activity, com.sina.weibo.sdk.web.a aVar, com.sina.weibo.sdk.web.b.b bVar) {
        this.aD = activity;
        this.aE = aVar;
        this.aF = bVar;
    }

    private void b(int i2, String str) {
        Bundle extras = this.aD.getIntent().getExtras();
        if (extras == null) {
            return;
        }
        Intent intent = new Intent(this.aD, ShareResultActivity.class);
        intent.setAction("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY");
        intent.putExtras(extras);
        intent.putExtra("_weibo_resp_errcode", i2);
        intent.putExtra("_weibo_resp_errstr", str);
        this.aD.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void m(String str) {
        b(0, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n(String str) {
        b(2, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o(String str) {
        b(1, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        com.sina.weibo.sdk.web.a aVar = this.aE;
        if (aVar != null) {
            webResourceError.getErrorCode();
            webResourceError.getDescription().toString();
            webResourceRequest.getUrl().toString();
            aVar.s();
        }
    }

    public void p(String str) {
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public void t() {
    }

    public boolean v() {
        return false;
    }
}
