package cn.sharesdk.framework.authorize;

import android.webkit.WebView;
/* compiled from: AuthorizeWebviewClient.java */
/* loaded from: classes.dex */
public abstract class c extends cn.sharesdk.framework.g {
    protected g activity;
    protected AuthorizeListener listener;
    protected String redirectUri;

    public c(g gVar) {
        this.activity = gVar;
        AuthorizeHelper a = gVar.a();
        this.redirectUri = a.getRedirectUri();
        this.listener = a.getAuthorizeListener();
    }

    protected abstract void onComplete(String str);

    @Override // cn.sharesdk.framework.g, android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i2, String str, String str2) {
        webView.stopLoading();
        AuthorizeListener authorizeListener = this.activity.a().getAuthorizeListener();
        this.activity.finish();
        if (authorizeListener != null) {
            authorizeListener.onError(new Throwable(str + " (" + i2 + "): " + str2));
        }
    }
}
