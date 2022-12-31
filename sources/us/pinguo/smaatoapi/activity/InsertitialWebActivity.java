package us.pinguo.smaatoapi.activity;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.smaatoapi.R;
import us.pinguo.smaatoapi.network.InsertitialLoader;
/* loaded from: classes6.dex */
public class InsertitialWebActivity extends AppCompatActivity {
    private WebView a;
    private ImageView b;
    private ProgressBar c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11976d = false;

    /* loaded from: classes6.dex */
    class a extends WebViewClient {
        final /* synthetic */ us.pinguo.smaatoapi.c.a a;

        /* renamed from: us.pinguo.smaatoapi.activity.InsertitialWebActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class RunnableC0446a implements Runnable {
            RunnableC0446a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                us.pinguo.smaatoapi.network.a.b(InsertitialWebActivity.this, aVar.a.c().get(0), null);
            }
        }

        a(us.pinguo.smaatoapi.c.a aVar) {
            this.a = aVar;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            us.pinguo.smaatoapi.network.b.e(InsertitialWebActivity.this, webView.getUrl(), sslErrorHandler);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (this.a.c().size() > 0) {
                new Thread(new RunnableC0446a()).start();
            }
            this.a.h().f(InsertitialLoader.b(InsertitialWebActivity.this).f11991d);
            this.a.h().onInterstitialDismissed();
            if (!str.startsWith("http:") && !str.startsWith("https:")) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
                    InsertitialWebActivity.this.startActivity(intent);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                Intent intent2 = new Intent(InsertitialWebActivity.this, WebViewActivity.class);
                intent2.putExtra("url", str);
                InsertitialWebActivity.this.startActivity(intent2);
            }
            InsertitialWebActivity.this.finish();
            return true;
        }
    }

    /* loaded from: classes6.dex */
    class b implements View.OnClickListener {
        final /* synthetic */ us.pinguo.smaatoapi.c.a a;

        b(us.pinguo.smaatoapi.c.a aVar) {
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            this.a.h().onInterstitialDismissed();
            InsertitialWebActivity.this.finish();
        }
    }

    private String p0(String str) {
        return "<html><head></head><body style=\"margin: 0; padding: 0;\" >" + str + "</body></html>";
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_insertitial_web);
        this.a = (WebView) findViewById(R.id.webView);
        this.b = (ImageView) findViewById(R.id.closeBtn);
        this.c = (ProgressBar) findViewById(R.id.progressBar);
        final us.pinguo.smaatoapi.c.a a2 = InsertitialLoader.b(this).f11991d.a();
        if (a2 == null) {
            finish();
            return;
        }
        a2.h().b(InsertitialLoader.b(this).f11991d);
        int a3 = us.pinguo.smaatoapi.d.a.a(this, a2.i());
        int a4 = us.pinguo.smaatoapi.d.a.a(this, a2.d());
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.a.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = a4;
        ((ViewGroup.MarginLayoutParams) layoutParams).width = a3;
        this.a.setLayoutParams(layoutParams);
        this.a.getSettings().setJavaScriptEnabled(true);
        this.a.getSettings().setBlockNetworkImage(false);
        this.a.setHorizontalScrollBarEnabled(false);
        this.a.setVerticalScrollBarEnabled(false);
        this.a.setOverScrollMode(2);
        if (Build.VERSION.SDK_INT >= 21) {
            this.a.getSettings().setMixedContentMode(0);
        }
        this.a.setWebViewClient(new a(a2));
        WebView webView = this.a;
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: us.pinguo.smaatoapi.activity.InsertitialWebActivity.2

            /* renamed from: us.pinguo.smaatoapi.activity.InsertitialWebActivity$2$a */
            /* loaded from: classes6.dex */
            class a implements Runnable {
                a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (a2.g() == null || a2.g().size() <= 0) {
                        return;
                    }
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    us.pinguo.smaatoapi.network.a.b(InsertitialWebActivity.this, a2.g().get(0), null);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i2) {
                VdsAgent.onProgressChangedStart(webView2, i2);
                if (i2 > 80 && !InsertitialWebActivity.this.f11976d) {
                    InsertitialWebActivity.this.f11976d = true;
                    if (a2.g().size() > 0) {
                        new Thread(new a()).start();
                    }
                    ProgressBar progressBar = InsertitialWebActivity.this.c;
                    progressBar.setVisibility(8);
                    VdsAgent.onSetViewVisibility(progressBar, 8);
                }
                VdsAgent.onProgressChangedEnd(webView2, i2);
            }
        };
        webView.setWebChromeClient(webChromeClient);
        VdsAgent.setWebChromeClient(webView, webChromeClient);
        WebView webView2 = this.a;
        String p0 = p0(a2.e());
        webView2.loadDataWithBaseURL(null, p0, "text/html", "utf-8", null);
        VdsAgent.loadDataWithBaseURL(webView2, null, p0, "text/html", "utf-8", null);
        this.b.setOnClickListener(new b(a2));
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
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }
}
