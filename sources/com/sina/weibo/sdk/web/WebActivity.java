package com.sina.weibo.sdk.web;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.sina.weibo.sdk.c.e;
import com.sina.weibo.sdk.web.b.b;
import com.sina.weibo.sdk.web.b.c;
import com.sina.weibo.sdk.web.b.d;
/* loaded from: classes3.dex */
public class WebActivity extends Activity implements a {
    private LinearLayout ar;
    private TextView as;
    private TextView at;
    private WebView au;
    private ProgressBar av;
    private b aw;
    private com.sina.weibo.sdk.web.a.b ax;
    private String ay;

    static /* synthetic */ void d(WebActivity webActivity) {
        LinearLayout linearLayout = webActivity.ar;
        linearLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(linearLayout, 8);
        WebView webView = webActivity.au;
        webView.setVisibility(0);
        VdsAgent.onSetViewVisibility(webView, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("https://service.weibo.com/share/mobilesdk.php") || str.startsWith("https://open.weibo.cn/oauth2/authorize?");
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            getWindow().getDecorView().setSystemUiVisibility(8192);
        }
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(-1);
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        TextView textView = new TextView(this);
        this.as = textView;
        textView.setText("关闭");
        this.as.setTextSize(17.0f);
        this.as.setTextColor(-32256);
        this.as.setOnClickListener(new View.OnClickListener() { // from class: com.sina.weibo.sdk.web.WebActivity.2
            @Override // android.view.View.OnClickListener
            @Instrumented
            public final void onClick(View view) {
                VdsAgent.onClick(this, view);
                WebActivity.this.ax.t();
            }
        });
        TextView textView2 = new TextView(this);
        this.at = textView2;
        textView2.setTextSize(18.0f);
        this.at.setTextColor(-11382190);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        this.as.setPadding(e.a(10, this), 0, e.a(10, this), 0);
        layoutParams2.addRule(13);
        relativeLayout2.addView(this.as, layoutParams);
        relativeLayout2.addView(this.at, layoutParams2);
        relativeLayout.addView(relativeLayout2, new RelativeLayout.LayoutParams(-1, e.a(55, this)));
        this.au = new WebView(getApplicationContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.topMargin = e.a(55, this);
        relativeLayout.addView(this.au, layoutParams3);
        this.av = new ProgressBar(this);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, e.a(3, this));
        layoutParams4.topMargin = e.a(55, this);
        relativeLayout.addView(this.av, layoutParams4);
        View view = new View(this);
        view.setBackgroundResource(getResources().getIdentifier("weibosdk_common_shadow_top", "drawable", getPackageName()));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, e.a(3, this));
        layoutParams5.topMargin = e.a(55, this);
        relativeLayout.addView(view, layoutParams5);
        LinearLayout linearLayout = new LinearLayout(this);
        this.ar = linearLayout;
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(getResources().getIdentifier("weibosdk_empty_failed", "drawable", getPackageName()));
        this.ar.addView(imageView);
        TextView textView3 = new TextView(this);
        textView3.setTextSize(14.0f);
        textView3.setTextColor(-4342339);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = e.a(18, this);
        layoutParams6.bottomMargin = e.a(20, this);
        this.ar.addView(textView3, layoutParams6);
        textView3.setText("网络出错啦，请点击按钮重新加载");
        Button button = new Button(this);
        button.setTextSize(16.0f);
        button.setTextColor(-8882056);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(e.a(142, this), e.a(46, this));
        layoutParams7.gravity = 17;
        this.ar.addView(button, layoutParams7);
        button.setBackgroundResource(getResources().getIdentifier("retry_btn_selector", "drawable", getPackageName()));
        button.setText("重新加载");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.sina.weibo.sdk.web.WebActivity.3
            @Override // android.view.View.OnClickListener
            @Instrumented
            public final void onClick(View view2) {
                VdsAgent.onClick(this, view2);
                WebActivity.d(WebActivity.this);
                WebActivity.this.au.reload();
            }
        });
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(13);
        relativeLayout.addView(this.ar, layoutParams8);
        LinearLayout linearLayout2 = this.ar;
        linearLayout2.setVisibility(8);
        VdsAgent.onSetViewVisibility(linearLayout2, 8);
        WebView webView = this.au;
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: com.sina.weibo.sdk.web.WebActivity.4
            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView2, int i3) {
                VdsAgent.onProgressChangedStart(webView2, i3);
                super.onProgressChanged(webView2, i3);
                WebActivity.this.av.setProgress(i3);
                if (i3 == 100) {
                    ProgressBar progressBar = WebActivity.this.av;
                    progressBar.setVisibility(4);
                    VdsAgent.onSetViewVisibility(progressBar, 4);
                    VdsAgent.onProgressChangedEnd(webView2, i3);
                    return;
                }
                ProgressBar progressBar2 = WebActivity.this.av;
                progressBar2.setVisibility(0);
                VdsAgent.onSetViewVisibility(progressBar2, 0);
                VdsAgent.onProgressChangedEnd(webView2, i3);
            }

            @Override // android.webkit.WebChromeClient
            public final void onReceivedTitle(WebView webView2, String str) {
                super.onReceivedTitle(webView2, str);
            }
        };
        webView.setWebChromeClient(webChromeClient);
        VdsAgent.setWebChromeClient(webView, webChromeClient);
        setContentView(relativeLayout);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            finish();
            return;
        }
        int intExtra = intent.getIntExtra("web_type", -1);
        if (intExtra == -1) {
            finish();
            return;
        }
        if (intExtra == 1) {
            this.ay = "微博分享";
            this.aw = new d(this);
            this.ax = new com.sina.weibo.sdk.web.a.d(this, this, this.aw);
        } else if (intExtra == 2) {
            this.ay = "微博登录";
            this.aw = new com.sina.weibo.sdk.web.b.a();
            this.ax = new com.sina.weibo.sdk.web.a.a(this, this, this.aw);
        } else if (intExtra == 3) {
            this.aw = new c();
            this.ax = new com.sina.weibo.sdk.web.a.c(this, this.aw);
        }
        this.au.setWebViewClient(this.ax);
        this.aw.readFromBundle(extras);
        WebSettings settings = this.au.getSettings();
        settings.setSavePassword(false);
        settings.setAllowContentAccess(false);
        settings.setUserAgentString(e.r());
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setGeolocationEnabled(false);
        if (i2 >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        this.au.requestFocus();
        this.au.setScrollBarStyle(0);
        a(this.au, "searchBoxJavaBridge_");
        a(this.au, "accessibility");
        a(this.au, "accessibilityTraversal");
        if (i2 >= 21) {
            settings.setMixedContentMode(2);
        }
        if (this.aw.w()) {
            this.aw.a(new b.a() { // from class: com.sina.weibo.sdk.web.WebActivity.1
                @Override // com.sina.weibo.sdk.web.b.b.a
                public final void onComplete() {
                    String url = WebActivity.this.aw.getUrl();
                    if (TextUtils.isEmpty(url) || !WebActivity.j(url)) {
                        return;
                    }
                    WebView webView2 = WebActivity.this.au;
                    webView2.loadUrl(url);
                    VdsAgent.loadUrl(webView2, url);
                }

                @Override // com.sina.weibo.sdk.web.b.b.a
                public final void onError(String str) {
                    WebActivity.this.ax.p(str);
                }
            });
        } else {
            String url = this.aw.getUrl();
            if (!TextUtils.isEmpty(url) && j(url)) {
                WebView webView2 = this.au;
                webView2.loadUrl(url);
                VdsAgent.loadUrl(webView2, url);
            }
        }
        TextView textView4 = this.at;
        if (textView4 != null) {
            textView4.setText(this.ay);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (this.ax.v()) {
                return true;
            }
            if (this.au.canGoBack()) {
                this.au.goBack();
                return true;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.sina.weibo.sdk.web.a
    public final void s() {
        LinearLayout linearLayout = this.ar;
        linearLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(linearLayout, 0);
        WebView webView = this.au;
        webView.setVisibility(8);
        VdsAgent.onSetViewVisibility(webView, 8);
    }

    @Override // com.sina.weibo.sdk.web.a
    public final void t() {
        finish();
    }

    private static void a(WebView webView, String str) {
        try {
            WebView.class.getDeclaredMethod("removeJavascriptInterface", String.class).invoke(webView, str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
