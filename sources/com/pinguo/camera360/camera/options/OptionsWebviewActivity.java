package com.pinguo.camera360.camera.options;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.pinguo.camera360.camera.controller.VipHalfScreenController;
import com.pinguo.camera360.member.MemberRightsActivity;
import com.pinguo.camera360.ui.TitleBarLayout;
import us.pinguo.common.network.request.EncryptUtils;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.ui.widget.FixedJsWebView;
import us.pinguo.user.User;
import us.pinguo.webview.PGBaseWebSettings;
import us.pinguo.webview.PGJsWebView;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class OptionsWebviewActivity extends BaseActivity implements us.pinguo.foundation.statistics.e {
    private FixedJsWebView b;
    private String a = null;
    private boolean c = false;

    /* loaded from: classes3.dex */
    class a extends us.pinguo.webview.d {
        a(PGJsWebView pGJsWebView) {
            super(pGJsWebView);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str == null) {
                return false;
            }
            OptionsWebviewActivity.this.A0(str);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    private class b {
        private b() {
        }

        @JavascriptInterface
        public String decrypt(String str, String str2) {
            return new String(EncryptUtils.decryptForExternal(str2, str));
        }

        @JavascriptInterface
        public String encrypt(String str) {
            Object[] encryptForExternal = EncryptUtils.encryptForExternal(str.getBytes());
            return Base64.encodeToString((byte[]) encryptForExternal[0], 0) + Base64.encodeToString((byte[]) encryptForExternal[1], 0);
        }

        @JavascriptInterface
        public void goAppHome() {
            OptionsWebviewActivity.this.v0();
        }

        @JavascriptInterface
        public void unregister(String str) {
            OptionsWebviewActivity.this.B0("true".equals(str));
        }

        /* synthetic */ b(OptionsWebviewActivity optionsWebviewActivity, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("app://camera360.unitedmember".equals(str)) {
            Intent intent = new Intent(this, MemberRightsActivity.class);
            intent.putExtra("is_from_notice", true);
            startActivity(intent);
            return;
        }
        this.b.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(final boolean z) {
        runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.camera.options.j0
            @Override // java.lang.Runnable
            public final void run() {
                OptionsWebviewActivity.this.z0(z);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bc, code lost:
        if ("license".equals(r17.a) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x010c, code lost:
        if ("license".equals(r17.a) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0155, code lost:
        if ("license".equals(r17.a) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x015a, code lost:
        return "https://www.camera360.com/disclaimer.html";
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:?, code lost:
        return "https://www.camera360.com/license/index.html";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String t0() {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.camera.options.OptionsWebviewActivity.t0():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0073 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String u0() {
        /*
            r5 = this;
            us.pinguo.user.User r0 = us.pinguo.user.User.d()
            us.pinguo.user.User$Info r0 = r0.h()
            java.lang.String r1 = ""
            if (r0 == 0) goto L28
            java.lang.String r2 = r0.userId
            java.lang.String r3 = r0.token
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L28
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L28
            java.lang.String r0 = r0.mobile
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L25
            goto L26
        L25:
            r0 = r1
        L26:
            r1 = r2
            goto L2a
        L28:
            r0 = r1
            r3 = r0
        L2a:
            boolean r2 = us.pinguo.foundation.d.f10985d
            if (r2 == 0) goto L31
            java.lang.String r2 = "http://activitytest.camera360.com/logout/index.html"
            goto L33
        L31:
            java.lang.String r2 = "https://activity-h5.camera360.com/logout/index.html"
        L33:
            us.pinguo.user.User r4 = us.pinguo.user.User.d()
            boolean r4 = r4.n()
            if (r4 == 0) goto L73
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r2 = "?userId="
            r4.append(r2)
            java.lang.String r1 = us.pinguo.foundation.utils.p.a(r1)
            r4.append(r1)
            java.lang.String r1 = "&token="
            r4.append(r1)
            java.lang.String r1 = us.pinguo.foundation.utils.p.a(r3)
            r4.append(r1)
            java.lang.String r1 = "&mobile="
            r4.append(r1)
            java.lang.String r0 = us.pinguo.foundation.utils.p.a(r0)
            r4.append(r0)
            java.lang.String r0 = "&appName=camera360"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            return r0
        L73:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.camera.options.OptionsWebviewActivity.u0():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        runOnUiThread(new Runnable() { // from class: com.pinguo.camera360.camera.options.k0
            @Override // java.lang.Runnable
            public final void run() {
                OptionsWebviewActivity.this.x0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public /* synthetic */ void x0() {
        if (this.pgDistroy) {
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public /* synthetic */ void z0(boolean z) {
        if (this.pgDistroy) {
            return;
        }
        if (z) {
            setResult(-1);
            User.s();
            return;
        }
        setResult(0);
        finish();
    }

    @Override // us.pinguo.foundation.statistics.e
    public String C() {
        return VipHalfScreenController.URL_SERVICE_PROTOCOL.equals(this.a) ? "vip_sub_notice_page" : getClass().getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.options_cloud_service);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.a = extras.getString("towhere");
        }
        this.c = "unregister".equals(this.a);
        final TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.title_bar_layout_res_0x7f090781);
        titleBarLayout.e();
        titleBarLayout.f();
        String u0 = this.c ? u0() : t0();
        FixedJsWebView fixedJsWebView = (FixedJsWebView) findViewById(R.id.options_disclaimer);
        this.b = fixedJsWebView;
        fixedJsWebView.h(null, new PGBaseWebSettings(this), null);
        WebSettings settings = this.b.getSettings();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (i2 >= 21) {
            settings.setMixedContentMode(2);
        }
        this.b.setWebViewClient(new a(this.b));
        this.b.setWebChromeClient(new WebChromeClient() { // from class: com.pinguo.camera360.camera.options.OptionsWebviewActivity.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i3) {
                VdsAgent.onProgressChangedStart(webView, i3);
                super.onProgressChanged(webView, i3);
                VdsAgent.onProgressChangedEnd(webView, i3);
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                titleBarLayout.setTiTleText(str);
            }
        });
        this.b.addJavascriptInterface(new b(this, null), "appInterface");
        this.b.loadUrl(u0);
    }

    @Override // android.app.Activity
    @Instrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        VdsAgent.onOptionsItemSelected(this, menuItem);
        if (menuItem.getItemId() != 16908332) {
            boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
            VdsAgent.handleClickResult(new Boolean(onOptionsItemSelected));
            return onOptionsItemSelected;
        }
        finish();
        VdsAgent.handleClickResult(new Boolean(true));
        return true;
    }
}
