package us.pinguo.user.ui;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import us.pinguo.user.R;
import us.pinguo.user.User;
import us.pinguo.user.event.LoginEvent$LoginResultEvent;
/* loaded from: classes6.dex */
public class PGLoginWebActivity extends PGLoginBaseActivity {

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f12409d;

    /* renamed from: e  reason: collision with root package name */
    private WebView f12410e;

    /* renamed from: f  reason: collision with root package name */
    private String f12411f;

    /* renamed from: i  reason: collision with root package name */
    private String f12414i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12415j;

    /* renamed from: g  reason: collision with root package name */
    private String f12412g = null;

    /* renamed from: h  reason: collision with root package name */
    private AtomicBoolean f12413h = new AtomicBoolean(false);

    /* renamed from: k  reason: collision with root package name */
    private boolean f12416k = false;

    /* loaded from: classes6.dex */
    class a implements View.OnTouchListener {
        a(PGLoginWebActivity pGLoginWebActivity) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if ((action == 0 || action == 1) && !view.hasFocus()) {
                view.requestFocus();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes6.dex */
    class b extends WebViewClient {
        b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            WebView webView2 = PGLoginWebActivity.this.f12410e;
            webView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(webView2, 0);
            LinearLayout linearLayout = PGLoginWebActivity.this.f12409d;
            linearLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(linearLayout, 8);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            LoginEvent$LoginResultEvent loginEvent$LoginResultEvent;
            if (str.contains(PGLoginWebActivity.this.f12412g) && !PGLoginWebActivity.this.f12413h.get()) {
                String[] split = str.substring(str.indexOf("?") + 1).split("&");
                HashMap hashMap = new HashMap();
                for (String str2 : split) {
                    String[] split2 = str2.split("=");
                    if (split2.length >= 2) {
                        hashMap.put(split2[0], split2[1]);
                    }
                }
                String str3 = (String) hashMap.get("status");
                String str4 = (String) hashMap.get("userInfo");
                String str5 = null;
                try {
                    str5 = URLDecoder.decode(str4, "utf-8");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                us.pinguo.common.log.a.m("test", "userInfo=" + str5, new Object[0]);
                if (!TextUtils.isEmpty(str3) && str3.equals("200")) {
                    com.google.gson.e eVar = new com.google.gson.e();
                    if (PGLoginWebActivity.this.f12415j) {
                        User.Info h2 = User.d().h();
                        h2.third = ((User.Info) eVar.j(str5, User.Info.class)).third;
                        User.v(h2);
                    } else {
                        User.Info info = (User.Info) eVar.j(str5, User.Info.class);
                        info.loginmode = PGLoginWebActivity.this.f12414i;
                        User.v(info);
                    }
                    PGLoginWebActivity.this.finish();
                    de.greenrobot.event.c.d().g(new LoginEvent$LoginResultEvent(200, "ok"));
                } else if (!TextUtils.isEmpty(str3) && str3.equals("10002")) {
                    com.google.gson.e eVar2 = new com.google.gson.e();
                    if (PGLoginWebActivity.this.f12415j) {
                        User.Info h3 = User.d().h();
                        h3.third = ((User.Info) eVar2.j(str5, User.Info.class)).third;
                        User.v(h3);
                    } else {
                        User.Info info2 = (User.Info) eVar2.j(str5, User.Info.class);
                        info2.loginmode = PGLoginWebActivity.this.f12414i;
                        User.v(info2);
                    }
                    PGLoginWebActivity.this.finish();
                    de.greenrobot.event.c.d().g(new LoginEvent$LoginResultEvent(200, "ok"));
                } else {
                    if ("420".equals(str3)) {
                        User.E();
                    }
                    PGLoginWebActivity.this.finish();
                    try {
                        int parseInt = Integer.parseInt(str3);
                        String a = us.pinguo.user.api.f0.a(PGLoginWebActivity.this, parseInt);
                        if (TextUtils.isEmpty(a)) {
                            a = PGLoginWebActivity.this.getString(R.string.pg_login_fail);
                        }
                        if (parseInt == 420) {
                            a = PGLoginWebActivity.this.getString(R.string.user_expired);
                        }
                        if (parseInt == 10548) {
                            a = PGLoginWebActivity.this.getString(R.string.error_tips_10548);
                        }
                        if (parseInt == 10549) {
                            a = PGLoginWebActivity.this.getString(R.string.error_tips_10549);
                        }
                        if (parseInt == 10547) {
                            a = PGLoginWebActivity.this.getString(R.string.error_tips_10547);
                        }
                        loginEvent$LoginResultEvent = new LoginEvent$LoginResultEvent(parseInt, a);
                    } catch (Exception unused) {
                        loginEvent$LoginResultEvent = new LoginEvent$LoginResultEvent(-1, PGLoginWebActivity.this.getString(R.string.pg_login_fail));
                    }
                    de.greenrobot.event.c.d().g(loginEvent$LoginResultEvent);
                }
            }
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            us.pinguo.foundation.ui.h.b(webView);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (PGLoginWebActivity.this.f12416k) {
                return;
            }
            us.pinguo.foundation.ui.f.d(PGLoginWebActivity.this, webView.getUrl(), sslErrorHandler);
        }
    }

    public void initView() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.pg_login_head_title_text);
        this.f12409d = (LinearLayout) findViewById(R.id.id_login_loading_page);
        WebView webView = (WebView) findViewById(R.id.id_login_webview);
        this.f12410e = webView;
        WebSettings settings = webView.getSettings();
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.user.ui.PGLoginBaseActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_pg_login_webview);
        initView();
        this.f12411f = getIntent().getStringExtra("WEB_PATH");
        this.f12412g = getIntent().getStringExtra("success_url");
        this.f12414i = getIntent().getStringExtra("loginmode");
        this.f12415j = getIntent().getBooleanExtra("bind_account", false);
        if (this.f12412g == null) {
            this.f12412g = "http://success.callback.html";
        }
        this.f12416k = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f12413h.set(true);
        this.f12410e.clearCache(true);
        this.f12410e.clearHistory();
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
        CookieManager.getInstance().removeSessionCookie();
        super.onDestroy();
        this.f12416k = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onStart() {
        super.onStart();
        this.f12410e.clearCache(true);
        this.f12410e.clearFormData();
        this.f12410e.clearHistory();
        this.f12410e.getSettings().setJavaScriptEnabled(true);
        this.f12410e.getSettings().setSupportZoom(true);
        this.f12410e.requestFocusFromTouch();
        this.f12410e.getSettings().setBuiltInZoomControls(true);
        this.f12410e.setOnTouchListener(new a(this));
        WebView webView = this.f12410e;
        String str = this.f12411f;
        webView.loadUrl(str);
        VdsAgent.loadUrl(webView, str);
        this.f12410e.setWebViewClient(new b());
    }
}
