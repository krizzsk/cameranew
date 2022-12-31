package us.pinguo.smaatoapi.activity;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.smaatoapi.R;
/* loaded from: classes6.dex */
public class WebViewActivity extends AppCompatActivity {
    WebView a;
    ProgressBar b;
    Toolbar c;

    /* loaded from: classes6.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (WebViewActivity.this.a.canGoBack()) {
                WebViewActivity.this.a.goBack();
            } else {
                WebViewActivity.this.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    class b extends WebViewClient {
        b() {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            us.pinguo.smaatoapi.network.b.e(WebViewActivity.this, webView.getUrl(), sslErrorHandler);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            ProgressBar progressBar = WebViewActivity.this.b;
            progressBar.setVisibility(0);
            VdsAgent.onSetViewVisibility(progressBar, 0);
            WebViewActivity.this.b.setProgress(0);
            WebViewActivity.this.c.setTitle(str);
            if (str.startsWith("http:") || str.startsWith("https:")) {
                return false;
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
                WebViewActivity.this.startActivity(intent);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return true;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_web_view);
        this.c = (Toolbar) findViewById(R.id.toolbar);
        this.b = (ProgressBar) findViewById(R.id.progress);
        this.a = (WebView) findViewById(R.id.webView);
        this.b.setMax(100);
        setSupportActionBar(this.c);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String stringExtra = getIntent().getStringExtra("url");
        if (stringExtra == null) {
            finish();
            return;
        }
        this.c.setNavigationOnClickListener(new a());
        this.a.getSettings().setJavaScriptEnabled(true);
        this.a.getSettings().setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= 21) {
            this.a.getSettings().setMixedContentMode(0);
        }
        this.a.setWebViewClient(new b());
        WebView webView = this.a;
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: us.pinguo.smaatoapi.activity.WebViewActivity.3
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i2) {
                VdsAgent.onProgressChangedStart(webView2, i2);
                WebViewActivity.this.b.setProgress(i2);
                if (i2 == 100) {
                    ProgressBar progressBar = WebViewActivity.this.b;
                    progressBar.setVisibility(8);
                    VdsAgent.onSetViewVisibility(progressBar, 8);
                }
                VdsAgent.onProgressChangedEnd(webView2, i2);
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView2, String str) {
                super.onReceivedTitle(webView2, str);
                WebViewActivity.this.c.setTitle(str);
            }
        };
        webView.setWebChromeClient(webChromeClient);
        VdsAgent.setWebChromeClient(webView, webChromeClient);
        WebView webView2 = this.a;
        webView2.loadUrl(stringExtra);
        VdsAgent.loadUrl(webView2, stringExtra);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        WebView webView = this.a;
        if (webView != null) {
            webView.removeAllViews();
            this.a.destroy();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (this.a.canGoBack()) {
                this.a.goBack();
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }
}
