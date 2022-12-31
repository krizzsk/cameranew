package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.d.i;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.a;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.d.d;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import d.a.a.a.a.a.b;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TTLandingPageActivity extends Activity implements d {
    private static final String b = TTLandingPageActivity.class.getSimpleName();
    j a;
    private SSWebView c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f1344d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f1345e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f1346f;

    /* renamed from: g  reason: collision with root package name */
    private Context f1347g;

    /* renamed from: h  reason: collision with root package name */
    private int f1348h;

    /* renamed from: i  reason: collision with root package name */
    private ViewStub f1349i;

    /* renamed from: j  reason: collision with root package name */
    private ViewStub f1350j;

    /* renamed from: k  reason: collision with root package name */
    private ViewStub f1351k;

    /* renamed from: l  reason: collision with root package name */
    private Button f1352l;
    private ProgressBar m;
    private String n;
    private String o;
    private v p;
    private int q;
    private String r;
    private h s;
    private b t;
    private String u;
    private AtomicBoolean v = new AtomicBoolean(true);
    private JSONArray w = null;
    private String x = "ダウンロード";

    @Override // android.app.Activity
    public void onBackPressed() {
        if (e() && !this.v.getAndSet(true)) {
            a(true);
            a(0);
            return;
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a();
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (com.bytedance.sdk.openadsdk.core.h.b().l()) {
            getWindow().addFlags(2621440);
        }
        try {
            o.a(this);
        } catch (Throwable unused) {
        }
        setContentView(t.f(this, "tt_activity_ttlandingpage"));
        c();
        this.f1347g = this;
        a.a(this).a(false).b(false).a(this.c);
        Intent intent = getIntent();
        this.f1348h = intent.getIntExtra("sdk_version", 1);
        this.n = intent.getStringExtra("adid");
        this.o = intent.getStringExtra("log_extra");
        this.q = intent.getIntExtra("source", -1);
        String stringExtra = intent.getStringExtra("url");
        this.u = stringExtra;
        a(4);
        String stringExtra2 = intent.getStringExtra("web_title");
        intent.getStringExtra("icon_url");
        this.r = intent.getStringExtra("event_tag");
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
            if (stringExtra3 != null) {
                try {
                    this.s = c.a(new JSONObject(stringExtra3));
                } catch (Exception e2) {
                    com.bytedance.sdk.openadsdk.utils.o.c(b, "TTLandingPageActivity - onCreate MultiGlobalInfo : ", e2);
                }
            }
        } else {
            this.s = s.a().c();
            s.a().g();
        }
        h hVar = this.s;
        if (hVar == null) {
            finish();
            return;
        }
        this.a = new j(this, hVar, this.c).a(true);
        d();
        this.c.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.f1347g, this.p, this.n, this.a) { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTLandingPageActivity.this.m == null || TTLandingPageActivity.this.isFinishing()) {
                        return;
                    }
                    ProgressBar progressBar = TTLandingPageActivity.this.m;
                    progressBar.setVisibility(8);
                    VdsAgent.onSetViewVisibility(progressBar, 8);
                } catch (Throwable unused2) {
                }
            }
        });
        this.c.getSettings().setUserAgentString(l.a(this.c, this.f1348h));
        if (Build.VERSION.SDK_INT >= 21) {
            this.c.getSettings().setMixedContentMode(0);
        }
        this.c.loadUrl(stringExtra);
        this.c.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.p, this.a) { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.b, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i2) {
                VdsAgent.onProgressChangedStart(webView, i2);
                super.onProgressChanged(webView, i2);
                if (TTLandingPageActivity.this.m != null && !TTLandingPageActivity.this.isFinishing()) {
                    if (i2 != 100 || !TTLandingPageActivity.this.m.isShown()) {
                        TTLandingPageActivity.this.m.setProgress(i2);
                    } else {
                        ProgressBar progressBar = TTLandingPageActivity.this.m;
                        progressBar.setVisibility(8);
                        VdsAgent.onSetViewVisibility(progressBar, 8);
                    }
                }
                VdsAgent.onProgressChangedEnd(webView, i2);
            }
        });
        this.c.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.3
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                if (TTLandingPageActivity.this.t != null) {
                    TTLandingPageActivity.this.t.a();
                }
            }
        });
        TextView textView = this.f1346f;
        if (textView != null) {
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = t.a(this, "tt_web_title_default");
            }
            textView.setText(stringExtra2);
        }
        a();
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
        y.a(this.f1347g, this.c);
        y.a(this.c);
        this.c = null;
        v vVar = this.p;
        if (vVar != null) {
            vVar.g();
        }
        j jVar = this.a;
        if (jVar != null) {
            jVar.d();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        s.a().b(true);
        v vVar = this.p;
        if (vVar != null) {
            vVar.f();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        v vVar = this.p;
        if (vVar != null) {
            vVar.e();
        }
        j jVar = this.a;
        if (jVar != null) {
            jVar.b();
        }
        f();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        j jVar = this.a;
        if (jVar != null) {
            jVar.c();
        }
    }

    private String b() {
        h hVar = this.s;
        if (hVar != null && !TextUtils.isEmpty(hVar.I())) {
            this.x = this.s.I();
        }
        return this.x;
    }

    private void c() {
        this.c = (SSWebView) findViewById(t.e(this, "tt_browser_webview"));
        this.f1351k = (ViewStub) findViewById(t.e(this, "tt_browser_download_btn_stub"));
        this.f1349i = (ViewStub) findViewById(t.e(this, "tt_browser_titlebar_view_stub"));
        this.f1350j = (ViewStub) findViewById(t.e(this, "tt_browser_titlebar_dark_view_stub"));
        int k2 = com.bytedance.sdk.openadsdk.core.h.b().k();
        if (k2 == 0) {
            this.f1349i.setVisibility(0);
        } else if (k2 == 1) {
            this.f1350j.setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(t.e(this, "tt_titlebar_back"));
        this.f1344d = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.5
                @Override // android.view.View.OnClickListener
                @Instrumented
                public void onClick(View view) {
                    VdsAgent.onClick(this, view);
                    if (TTLandingPageActivity.this.c != null) {
                        if (TTLandingPageActivity.this.c.canGoBack()) {
                            TTLandingPageActivity.this.c.goBack();
                        } else if (TTLandingPageActivity.this.e()) {
                            TTLandingPageActivity.this.onBackPressed();
                        } else {
                            TTLandingPageActivity.this.finish();
                        }
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(t.e(this, "tt_titlebar_close"));
        this.f1345e = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.6
                @Override // android.view.View.OnClickListener
                @Instrumented
                public void onClick(View view) {
                    VdsAgent.onClick(this, view);
                    TTLandingPageActivity.this.finish();
                }
            });
        }
        this.f1346f = (TextView) findViewById(t.e(this, "tt_titlebar_title"));
        this.m = (ProgressBar) findViewById(t.e(this, "tt_browser_progress"));
    }

    private void d() {
        v vVar = new v(this);
        this.p = vVar;
        vVar.a((WebView) this.c).a(this.n).b(this.o).a(this.s).b(this.q).a(this.s.t()).c(ab.e(this.s)).a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        return !TextUtils.isEmpty(this.u) && this.u.contains("__luban_sdk");
    }

    private void f() {
        if (this.s == null) {
            return;
        }
        JSONArray b2 = b(this.u);
        int d2 = ab.d(this.o);
        int c = ab.c(this.o);
        p<com.bytedance.sdk.openadsdk.c.a> f2 = o.f();
        if (b2 == null || f2 == null || d2 <= 0 || c <= 0) {
            return;
        }
        i iVar = new i();
        iVar.f1601d = b2;
        AdSlot k2 = this.s.k();
        if (k2 == null) {
            return;
        }
        k2.setAdCount(6);
        f2.a(k2, iVar, c, new p.a() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(int i2, String str) {
                TTLandingPageActivity.this.a(0);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar != null) {
                    try {
                        TTLandingPageActivity.this.v.set(false);
                        TTLandingPageActivity.this.p.b(new JSONObject(aVar.d()));
                    } catch (Exception unused) {
                        TTLandingPageActivity.this.a(0);
                    }
                }
            }
        });
    }

    private void a() {
        h hVar = this.s;
        if (hVar == null || hVar.x() != 4) {
            return;
        }
        this.f1351k.setVisibility(0);
        Button button = (Button) findViewById(t.e(this, "tt_browser_download_btn"));
        this.f1352l = button;
        if (button != null) {
            a(b());
            if (this.t == null) {
                this.t = d.a.a.a.a.a.c.a(this, this.s, TextUtils.isEmpty(this.r) ? ab.a(this.q) : this.r);
            }
            com.bytedance.sdk.openadsdk.core.a.a aVar = new com.bytedance.sdk.openadsdk.core.a.a(this, this.s, this.r, this.q);
            aVar.a(false);
            this.f1352l.setOnClickListener(aVar);
            this.f1352l.setOnTouchListener(aVar);
            aVar.c(true);
            aVar.a(this.t);
        }
    }

    private JSONArray b(String str) {
        int i2;
        JSONArray jSONArray = this.w;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.w;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("?id=");
        int indexOf2 = str.indexOf("&");
        if (indexOf == -1 || indexOf2 == -1 || (i2 = indexOf + 4) >= indexOf2) {
            return null;
        }
        String substring = str.substring(i2, indexOf2);
        if (TextUtils.isEmpty(substring)) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(substring);
        return jSONArray2;
    }

    private void a(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.f1352l) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity.4
            @Override // java.lang.Runnable
            public void run() {
                if (TTLandingPageActivity.this.f1352l == null || TTLandingPageActivity.this.isFinishing()) {
                    return;
                }
                TTLandingPageActivity.this.f1352l.setText(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        if (this.f1345e == null || !e()) {
            return;
        }
        ac.a((View) this.f1345e, i2);
    }

    private void a(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isBackIntercept", z);
            this.p.a("temai_back_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.d
    public void a(boolean z, JSONArray jSONArray) {
        if (!z || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.w = jSONArray;
        f();
    }
}
