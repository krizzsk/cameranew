package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.a.d;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.a;
import com.bytedance.sdk.openadsdk.core.widget.webview.c;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import d.a.a.a.a.a.b;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TTPlayableLandingPageActivity extends Activity implements d, ad.a {
    RelativeLayout a;
    ad b;
    private SSWebView c;

    /* renamed from: d  reason: collision with root package name */
    private SSWebView f1353d;

    /* renamed from: g  reason: collision with root package name */
    private Context f1356g;

    /* renamed from: h  reason: collision with root package name */
    private int f1357h;

    /* renamed from: i  reason: collision with root package name */
    private ProgressBar f1358i;

    /* renamed from: j  reason: collision with root package name */
    private String f1359j;

    /* renamed from: k  reason: collision with root package name */
    private String f1360k;

    /* renamed from: l  reason: collision with root package name */
    private v f1361l;
    private v m;
    private int n;
    private String o;
    private String p;
    private String q;
    private h r;
    private boolean s;
    private boolean t;
    private b u;
    private int w;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1354e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1355f = true;
    private AtomicBoolean v = new AtomicBoolean(false);

    private void f() {
        v vVar = new v(this);
        this.f1361l = vVar;
        vVar.a((WebView) this.c).a(this.r).a(this.f1359j).b(this.f1360k).b(this.n).a(this).c(ab.e(this.r));
        v vVar2 = new v(this);
        this.m = vVar2;
        vVar2.a((WebView) this.f1353d).a(this.r).a(this.f1359j).b(this.f1360k).a(this).b(this.n).c(false).c(ab.e(this.r));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (com.bytedance.sdk.openadsdk.core.h.b().l()) {
            getWindow().addFlags(2621440);
        }
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
            o.a(this);
        } catch (Throwable unused) {
        }
        a(bundle);
        setContentView(t.f(this, "tt_activity_ttlandingpage_playable"));
        a();
        this.f1356g = this;
        h hVar = this.r;
        if (hVar == null) {
            return;
        }
        this.w = hVar.N();
        f();
        this.c.setWebViewClient(new c(this.f1356g, this.f1361l, this.f1359j, null) { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTPlayableLandingPageActivity.this.f1358i != null && !TTPlayableLandingPageActivity.this.isFinishing()) {
                        ProgressBar progressBar = TTPlayableLandingPageActivity.this.f1358i;
                        progressBar.setVisibility(8);
                        VdsAgent.onSetViewVisibility(progressBar, 8);
                    }
                    if (TTPlayableLandingPageActivity.this.f1354e) {
                        TTPlayableLandingPageActivity.this.b();
                        TTPlayableLandingPageActivity.this.a("py_loading_success");
                    }
                } catch (Throwable unused2) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                TTPlayableLandingPageActivity.this.f1354e = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            @RequiresApi(api = 21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (TTPlayableLandingPageActivity.this.o != null && webResourceRequest != null && webResourceRequest.getUrl() != null && TTPlayableLandingPageActivity.this.o.equals(webResourceRequest.getUrl().toString())) {
                    TTPlayableLandingPageActivity.this.f1354e = false;
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                super.onReceivedError(webView, i2, str, str2);
                TTPlayableLandingPageActivity.this.f1354e = false;
            }
        });
        a(this.c);
        a(this.f1353d);
        c();
        this.c.loadUrl(this.o);
        this.c.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.f1361l, null) { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.b, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
                VdsAgent.onProgressChangedStart(webView, i2);
                super.onProgressChanged(webView, i2);
                if (TTPlayableLandingPageActivity.this.f1358i != null && !TTPlayableLandingPageActivity.this.isFinishing()) {
                    if (i2 != 100 || !TTPlayableLandingPageActivity.this.f1358i.isShown()) {
                        TTPlayableLandingPageActivity.this.f1358i.setProgress(i2);
                    } else {
                        ProgressBar progressBar = TTPlayableLandingPageActivity.this.f1358i;
                        progressBar.setVisibility(8);
                        VdsAgent.onSetViewVisibility(progressBar, 8);
                        TTPlayableLandingPageActivity.this.b();
                    }
                }
                VdsAgent.onProgressChangedEnd(webView, i2);
            }
        });
        this.b = new ad(Looper.getMainLooper(), this);
        if (this.r.x() == 4) {
            this.u = d.a.a.a.a.a.c.a(this.f1356g, this.r, this.q);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        y.a(this.f1356g, this.c);
        y.a(this.c);
        this.c = null;
        v vVar = this.f1361l;
        if (vVar != null) {
            vVar.g();
        }
        v vVar2 = this.m;
        if (vVar2 != null) {
            vVar2.g();
        }
        e();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        s.a().b(true);
        v vVar = this.f1361l;
        if (vVar != null) {
            vVar.f();
        }
        v vVar2 = this.m;
        if (vVar2 != null) {
            vVar2.f();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        v vVar = this.f1361l;
        if (vVar != null) {
            vVar.e();
        }
        v vVar2 = this.m;
        if (vVar2 != null) {
            vVar2.e();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            h hVar = this.r;
            bundle.putString("material_meta", hVar != null ? hVar.Z().toString() : null);
            bundle.putInt("sdk_version", this.f1357h);
            bundle.putString("adid", this.f1359j);
            bundle.putString("log_extra", this.f1360k);
            bundle.putInt("source", this.n);
            bundle.putBoolean("ad_pending_download", this.s);
            bundle.putString("url", this.o);
            bundle.putString("web_title", this.p);
            bundle.putString("event_tag", this.q);
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    private boolean c() {
        if (this.f1353d == null) {
            return false;
        }
        String d2 = d();
        if (TextUtils.isEmpty(d2)) {
            return false;
        }
        this.f1353d.setWebViewClient(new c(this.f1356g, this.m, this.f1359j, null) { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (TTPlayableLandingPageActivity.this.f1355f) {
                    TTPlayableLandingPageActivity.this.a("loading_h5_success");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                TTPlayableLandingPageActivity.this.f1355f = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                TTPlayableLandingPageActivity.this.f1355f = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i2, String str, String str2) {
                super.onReceivedError(webView, i2, str, str2);
                TTPlayableLandingPageActivity.this.f1355f = false;
            }
        });
        this.f1353d.loadUrl(d2);
        return true;
    }

    private String d() {
        h hVar;
        String k2 = o.h().k();
        if (TextUtils.isEmpty(k2) || (hVar = this.r) == null || hVar.K() == null) {
            return k2;
        }
        String b = this.r.K().b();
        int d2 = this.r.K().d();
        int e2 = this.r.K().e();
        String a = this.r.y().a();
        String J = this.r.J();
        String c = this.r.K().c();
        String a2 = this.r.K().a();
        String b2 = this.r.K().b();
        StringBuffer stringBuffer = new StringBuffer(k2);
        stringBuffer.append("?appname=");
        stringBuffer.append(b);
        stringBuffer.append("&stars=");
        stringBuffer.append(d2);
        stringBuffer.append("&comments=");
        stringBuffer.append(e2);
        stringBuffer.append("&icon=");
        stringBuffer.append(a);
        stringBuffer.append("&downloading=");
        stringBuffer.append(false);
        stringBuffer.append("&id=");
        stringBuffer.append(J);
        stringBuffer.append("&pkg_name=");
        stringBuffer.append(c);
        stringBuffer.append("&download_url=");
        stringBuffer.append(a2);
        stringBuffer.append("&name=");
        stringBuffer.append(b2);
        return stringBuffer.toString();
    }

    private void e() {
        b bVar;
        if (this.t || !this.s || (bVar = this.u) == null) {
            return;
        }
        bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        SSWebView sSWebView;
        if (this.v.getAndSet(true) || (sSWebView = this.c) == null || this.f1353d == null) {
            return;
        }
        ac.a((View) sSWebView, 0);
        ac.a((View) this.f1353d, 8);
        int i2 = o.h().r(String.valueOf(ab.d(this.r.M()))).s;
        if (i2 >= 0) {
            this.b.sendEmptyMessageDelayed(1, i2 * 1000);
        } else {
            ac.a((View) this.a, 0);
        }
    }

    private void a(Bundle bundle) {
        Intent intent = getIntent();
        this.f1357h = intent.getIntExtra("sdk_version", 1);
        this.f1359j = intent.getStringExtra("adid");
        this.f1360k = intent.getStringExtra("log_extra");
        this.n = intent.getIntExtra("source", -1);
        this.s = intent.getBooleanExtra("ad_pending_download", false);
        this.o = intent.getStringExtra("url");
        this.p = intent.getStringExtra("web_title");
        this.q = intent.getStringExtra("event_tag");
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
            if (stringExtra != null) {
                try {
                    this.r = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(stringExtra));
                } catch (Exception e2) {
                    com.bytedance.sdk.openadsdk.utils.o.c("TTPlayableLandingPageActivity", "TTPlayableLandingPageActivity - onCreate MultiGlobalInfo : ", e2);
                }
            }
        } else {
            this.r = s.a().c();
            s.a().g();
        }
        if (bundle != null) {
            try {
                this.f1357h = bundle.getInt("sdk_version", 1);
                this.f1359j = bundle.getString("adid");
                this.f1360k = bundle.getString("log_extra");
                this.n = bundle.getInt("source", -1);
                this.s = bundle.getBoolean("ad_pending_download", false);
                this.o = bundle.getString("url");
                this.p = bundle.getString("web_title");
                this.q = bundle.getString("event_tag");
                String string = bundle.getString("material_meta", null);
                if (!TextUtils.isEmpty(string)) {
                    this.r = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(string));
                }
            } catch (Throwable unused) {
            }
        }
        if (this.r == null) {
            com.bytedance.sdk.openadsdk.utils.o.e("TTPlayableLandingPageActivity", "material is null, no data to display");
            finish();
        }
    }

    private void a() {
        this.c = (SSWebView) findViewById(t.e(this, "tt_browser_webview"));
        this.f1353d = (SSWebView) findViewById(t.e(this, "tt_browser_webview_loading"));
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(t.e(this, "tt_playable_ad_close_layout"));
        this.a = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTPlayableLandingPageActivity.3
                @Override // android.view.View.OnClickListener
                @Instrumented
                public void onClick(View view) {
                    VdsAgent.onClick(this, view);
                    TTPlayableLandingPageActivity.this.a("playable_close");
                    TTPlayableLandingPageActivity.this.finish();
                }
            });
        }
        this.f1358i = (ProgressBar) findViewById(t.e(this, "tt_browser_progress"));
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        a.a(this.f1356g).a(false).b(false).a(sSWebView);
        sSWebView.getSettings().setUserAgentString(l.a(sSWebView, this.f1357h));
        if (Build.VERSION.SDK_INT >= 21) {
            sSWebView.getSettings().setMixedContentMode(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.bytedance.sdk.openadsdk.c.d.b(this, this.r, this.q, str, (JSONObject) null);
    }

    @Override // com.bytedance.sdk.openadsdk.utils.ad.a
    public void a(Message message) {
        if (message.what == 1) {
            ac.a((View) this.a, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.d
    public void a(boolean z) {
        b bVar;
        this.s = true;
        this.t = z;
        if (!z) {
            Toast makeText = Toast.makeText(this.f1356g, t.a(o.a(), "tt_toast_later_download"), 0);
            makeText.show();
            VdsAgent.showToast(makeText);
        }
        if (!this.t || (bVar = this.u) == null) {
            return;
        }
        bVar.a();
    }
}
