package com.pinguo.camera360.member;

import android.content.DialogInterface;
import android.net.http.SslError;
import android.os.Build;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.webview.PGBaseWebSettings;
import us.pinguo.webview.PGBaseWebView;
import vStudio.Android.Camera360.R;
/* compiled from: PayChinaMobileActivity.kt */
/* loaded from: classes3.dex */
public final class PayChinaMobileWebViewActivity extends BaseToolbarActivity {

    /* renamed from: g  reason: collision with root package name */
    private boolean f6899g;

    /* renamed from: f  reason: collision with root package name */
    public Map<Integer, View> f6898f = new LinkedHashMap();

    /* renamed from: h  reason: collision with root package name */
    private String f6900h = "";

    /* compiled from: PayChinaMobileActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends WebViewClient {
        private us.pinguo.permissionlib.b.a a;
        private AlertDialog b;

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(PayChinaMobileWebViewActivity this$0, DialogInterface dialogInterface, int i2) {
            VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
            kotlin.jvm.internal.s.h(this$0, "this$0");
            kotlin.jvm.internal.s.h(dialogInterface, "dialogInterface");
            dialogInterface.dismiss();
            this$0.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(DialogInterface dialogInterface, int i2) {
            VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
            kotlin.jvm.internal.s.h(dialogInterface, "dialogInterface");
            dialogInterface.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(PayChinaMobileWebViewActivity this$0, DialogInterface dialogInterface, int i2) {
            VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
            kotlin.jvm.internal.s.h(this$0, "this$0");
            kotlin.jvm.internal.s.h(dialogInterface, "dialogInterface");
            dialogInterface.dismiss();
            this$0.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(DialogInterface dialogInterface, int i2) {
            VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
            kotlin.jvm.internal.s.h(dialogInterface, "dialogInterface");
            dialogInterface.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(PayChinaMobileWebViewActivity this$0, DialogInterface dialogInterface, int i2) {
            VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
            kotlin.jvm.internal.s.h(this$0, "this$0");
            kotlin.jvm.internal.s.h(dialogInterface, "dialogInterface");
            dialogInterface.dismiss();
            this$0.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(DialogInterface dialogInterface, int i2) {
            VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
            kotlin.jvm.internal.s.h(dialogInterface, "dialogInterface");
            dialogInterface.dismiss();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int i2, String desc, String url) {
            kotlin.jvm.internal.s.h(view, "view");
            kotlin.jvm.internal.s.h(desc, "desc");
            kotlin.jvm.internal.s.h(url, "url");
            if (PayChinaMobileWebViewActivity.this.f6899g) {
                return;
            }
            com.pinguo.camera360.lib.ui.u.b(view);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            kotlin.jvm.internal.s.h(view, "view");
            kotlin.jvm.internal.s.h(handler, "handler");
            kotlin.jvm.internal.s.h(error, "error");
            if (PayChinaMobileWebViewActivity.this.f6899g) {
                return;
            }
            handler.cancel();
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0047, code lost:
            if (r5 == false) goto L78;
         */
        /* JADX WARN: Removed duplicated region for block: B:82:0x02ff  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x01f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:88:0x014d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.webkit.WebViewClient
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean shouldOverrideUrlLoading(android.webkit.WebView r19, java.lang.String r20) {
            /*
                Method dump skipped, instructions count: 774
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.member.PayChinaMobileWebViewActivity.a.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
        }
    }

    private final void A0() {
        PGBaseWebSettings pGBaseWebSettings = new PGBaseWebSettings(this);
        int i2 = R.id.china_mobile_pay_web;
        pGBaseWebSettings.a((PGBaseWebView) _$_findCachedViewById(i2));
        WebSettings settings = ((PGBaseWebView) _$_findCachedViewById(i2)).getSettings();
        kotlin.jvm.internal.s.g(settings, "china_mobile_pay_web.settings");
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setDefaultTextEncodingName("utf-8");
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        try {
            String userAgentString = settings.getUserAgentString();
            if (userAgentString == null) {
                userAgentString = "";
            }
            settings.setUserAgentString(kotlin.jvm.internal.s.q(userAgentString, " Camera360/9.9.27"));
        } catch (Throwable unused) {
        }
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        int i3 = R.id.china_mobile_pay_web;
        ((PGBaseWebView) _$_findCachedViewById(i3)).setWebViewClient(new a());
        ((PGBaseWebView) _$_findCachedViewById(i3)).loadUrl("file:///android_asset/www/blank.html");
    }

    @Override // com.pinguo.camera360.member.BaseToolbarActivity
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.f6898f;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
        if (r2 == true) goto L14;
     */
    @Override // com.pinguo.camera360.member.BaseToolbarActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onCreate(android.os.Bundle r9) {
        /*
            r8 = this;
            super.onCreate(r9)
            android.widget.TextView r9 = r8.t0()
            if (r9 != 0) goto La
            goto L10
        La:
            r0 = 2131821304(0x7f1102f8, float:1.9275347E38)
            r9.setText(r0)
        L10:
            r8.A0()
            android.content.Intent r9 = r8.getIntent()
            java.lang.String r0 = "url"
            java.lang.String r9 = r9.getStringExtra(r0)
            java.lang.String r0 = ""
            if (r9 != 0) goto L22
            r9 = r0
        L22:
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            if (r1 != 0) goto L6f
            android.net.Uri r1 = android.net.Uri.parse(r9)
            java.lang.String r2 = r1.getPath()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L63
            r3 = 1
            r4 = 0
            r5 = 2
            r6 = 0
            if (r2 != 0) goto L3e
        L3c:
            r3 = 0
            goto L46
        L3e:
            java.lang.String r7 = "/feegate/third/migu_music/wap"
            boolean r2 = kotlin.text.l.C(r2, r7, r6, r5, r4)
            if (r2 != r3) goto L3c
        L46:
            if (r3 == 0) goto L4f
            java.lang.String r0 = "orderid"
            java.lang.String r0 = r1.getQueryParameter(r0)
            goto L63
        L4f:
            java.lang.String r2 = "ibsbjstar.ccb.com.cn/CCBIS/ccbMain"
            boolean r2 = kotlin.text.l.C(r9, r2, r6, r5, r4)
            if (r2 == 0) goto L63
            java.lang.String r2 = "REMARK1"
            java.lang.String r1 = r1.getQueryParameter(r2)
            if (r1 != 0) goto L60
            goto L61
        L60:
            r0 = r1
        L61:
            r8.f6900h = r0
        L63:
            int r0 = vStudio.Android.Camera360.R.id.china_mobile_pay_web
            android.view.View r0 = r8._$_findCachedViewById(r0)
            us.pinguo.webview.PGBaseWebView r0 = (us.pinguo.webview.PGBaseWebView) r0
            r0.loadUrl(r9)
            goto L7a
        L6f:
            int r9 = vStudio.Android.Camera360.R.id.china_mobile_pay_web
            android.view.View r9 = r8._$_findCachedViewById(r9)
            us.pinguo.webview.PGBaseWebView r9 = (us.pinguo.webview.PGBaseWebView) r9
            com.pinguo.camera360.lib.ui.u.b(r9)
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.member.PayChinaMobileWebViewActivity.onCreate(android.os.Bundle):void");
    }

    @Override // com.pinguo.camera360.member.BaseToolbarActivity, us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        PayHelp.getInstance().t();
    }

    @Override // com.pinguo.camera360.member.BaseToolbarActivity
    protected int q0() {
        return R.layout.activity_pay_chinamobile_layout;
    }

    @Override // com.pinguo.camera360.member.BaseToolbarActivity
    public void w0() {
        super.w0();
        Toolbar r0 = r0();
        if (r0 != null) {
            r0.setNavigationIcon(R.drawable.ic_black_color);
        }
        TextView t0 = t0();
        if (t0 != null) {
            t0.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        Toolbar r02 = r0();
        if (r02 == null) {
            return;
        }
        r02.setBackgroundColor(getResources().getColor(R.color.toolbar_bg));
    }
}
