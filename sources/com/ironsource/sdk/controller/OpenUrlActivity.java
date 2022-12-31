package com.ironsource.sdk.controller;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.List;
/* loaded from: classes2.dex */
public class OpenUrlActivity extends Activity {

    /* renamed from: j  reason: collision with root package name */
    private static final int f5717j = com.ironsource.sdk.utils.f.g();

    /* renamed from: k  reason: collision with root package name */
    private static final int f5718k = com.ironsource.sdk.utils.f.g();
    private WebController b;
    private ProgressBar c;

    /* renamed from: d  reason: collision with root package name */
    boolean f5719d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f5720e;

    /* renamed from: f  reason: collision with root package name */
    private String f5721f;
    private WebView a = null;

    /* renamed from: g  reason: collision with root package name */
    private Handler f5722g = new Handler();

    /* renamed from: h  reason: collision with root package name */
    private boolean f5723h = false;

    /* renamed from: i  reason: collision with root package name */
    private final Runnable f5724i = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnSystemUiVisibilityChangeListener {
        a() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i2) {
            if ((i2 & InputDeviceCompat.SOURCE_TOUCHSCREEN) == 0) {
                OpenUrlActivity.this.f5722g.removeCallbacks(OpenUrlActivity.this.f5724i);
                OpenUrlActivity.this.f5722g.postDelayed(OpenUrlActivity.this.f5724i, 500L);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OpenUrlActivity.this.getWindow().getDecorView().setSystemUiVisibility(com.ironsource.sdk.utils.f.i(OpenUrlActivity.this.f5723h));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends WebViewClient {
        private c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            ProgressBar progressBar = OpenUrlActivity.this.c;
            progressBar.setVisibility(4);
            VdsAgent.onSetViewVisibility(progressBar, 4);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            ProgressBar progressBar = OpenUrlActivity.this.c;
            progressBar.setVisibility(0);
            VdsAgent.onSetViewVisibility(progressBar, 0);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(26)
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            com.ironsource.sdk.utils.d.b("OpenUrlActivity", "Chromium process crashed - detail.didCrash():" + renderProcessGoneDetail.didCrash());
            OpenUrlActivity.this.finish();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            List<String> d2 = com.ironsource.sdk.utils.b.e().d();
            if (d2 != null && !d2.isEmpty()) {
                for (String str2 : d2) {
                    if (str.contains(str2)) {
                        try {
                            OpenUrlActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            OpenUrlActivity.this.b.L1();
                        } catch (Exception e2) {
                            StringBuilder sb = new StringBuilder();
                            if (e2 instanceof ActivityNotFoundException) {
                                sb.append("no activity to handle url");
                            } else {
                                sb.append("activity failed to open with unspecified reason");
                            }
                            if (OpenUrlActivity.this.b != null) {
                                OpenUrlActivity.this.b.j1(sb.toString(), str);
                            }
                        }
                        OpenUrlActivity.this.finish();
                        return true;
                    }
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        /* synthetic */ c(OpenUrlActivity openUrlActivity, a aVar) {
            this();
        }
    }

    private void f() {
        if (this.c == null) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.c = new ProgressBar(new ContextThemeWrapper(this, 16973939));
            } else {
                this.c = new ProgressBar(this);
            }
            this.c.setId(f5718k);
        }
        if (findViewById(f5718k) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.c.setLayoutParams(layoutParams);
            ProgressBar progressBar = this.c;
            progressBar.setVisibility(4);
            VdsAgent.onSetViewVisibility(progressBar, 4);
            this.f5720e.addView(this.c);
        }
    }

    private void g() {
        if (this.a == null) {
            WebView webView = new WebView(getApplicationContext());
            this.a = webView;
            webView.setId(f5717j);
            this.a.getSettings().setJavaScriptEnabled(true);
            this.a.setWebViewClient(new c(this, null));
            k(this.f5721f);
        }
        if (findViewById(f5717j) == null) {
            this.f5720e.addView(this.a, new RelativeLayout.LayoutParams(-1, -1));
        }
        f();
        WebController webController = this.b;
        if (webController != null) {
            webController.m2(true, "secondary");
        }
    }

    private void h() {
        WebView webView = this.a;
        if (webView != null) {
            webView.destroy();
        }
    }

    private void i() {
        requestWindowFeature(1);
    }

    private void j() {
        getWindow().setFlags(1024, 1024);
    }

    private void l() {
        ViewGroup viewGroup;
        WebController webController = this.b;
        if (webController != null) {
            webController.m2(false, "secondary");
            if (this.f5720e == null || (viewGroup = (ViewGroup) this.a.getParent()) == null) {
                return;
            }
            if (viewGroup.findViewById(f5717j) != null) {
                viewGroup.removeView(this.a);
            }
            if (viewGroup.findViewById(f5718k) != null) {
                viewGroup.removeView(this.c);
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        WebController webController;
        if (this.f5719d && (webController = this.b) != null) {
            webController.f1("secondaryClose");
        }
        super.finish();
    }

    public void k(String str) {
        this.a.stopLoading();
        this.a.clearHistory();
        try {
            WebView webView = this.a;
            webView.loadUrl(str);
            VdsAgent.loadUrl(webView, str);
        } catch (Throwable th) {
            com.ironsource.sdk.utils.d.b("OpenUrlActivity", "OpenUrlActivity:: loadUrl: " + th.toString());
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.a.canGoBack()) {
            this.a.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.ironsource.sdk.utils.d.d("OpenUrlActivity", "onCreate()");
        try {
            this.b = (WebController) d.e.d.k.b.b0(this).Y().M();
            i();
            j();
            Bundle extras = getIntent().getExtras();
            this.f5721f = extras.getString(WebController.W);
            this.f5719d = extras.getBoolean(WebController.d0);
            boolean booleanExtra = getIntent().getBooleanExtra("immersive", false);
            this.f5723h = booleanExtra;
            if (booleanExtra) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new a());
                runOnUiThread(this.f5724i);
            }
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.f5720e = relativeLayout;
            setContentView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        } catch (Exception e2) {
            e2.printStackTrace();
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        h();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.f5723h && (i2 == 25 || i2 == 24)) {
            this.f5722g.postDelayed(this.f5724i, 500L);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        l();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        g();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f5723h && z) {
            runOnUiThread(this.f5724i);
        }
    }
}
