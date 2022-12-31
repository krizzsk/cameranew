package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.R;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* compiled from: PrivacyProtectDialog.java */
/* loaded from: classes.dex */
public class b extends Dialog {
    private Context a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private c f1879d;

    /* renamed from: e  reason: collision with root package name */
    private InterfaceC0058b f1880e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f1881f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PrivacyProtectDialog.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            int id = view.getId();
            if (id == R.id.tt_privacy_accept_btn) {
                if (b.this.f1879d != null) {
                    b.this.f1879d.a();
                }
                b.this.dismiss();
            } else if (id == R.id.tt_privacy_reject_btn) {
                if (b.this.f1880e != null) {
                    b.this.f1880e.a();
                }
                b.this.dismiss();
            }
        }
    }

    /* compiled from: PrivacyProtectDialog.java */
    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0058b {
        void a();
    }

    /* compiled from: PrivacyProtectDialog.java */
    /* loaded from: classes.dex */
    public interface c {
        void a();
    }

    public b(@NonNull Context context) {
        super(context, t.g(context, "tt_privacy_dialogTheme"));
        this.a = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        b();
    }

    private void b() {
        WindowManager.LayoutParams attributes;
        setCancelable(false);
        Window window = getWindow();
        if (window == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        attributes.dimAmount = 0.5f;
        attributes.width = (int) (this.a.getResources().getDisplayMetrics().widthPixels * 0.8d);
        window.setAttributes(attributes);
    }

    public b a(String str, c cVar) {
        this.b = str;
        this.f1879d = cVar;
        return this;
    }

    public b a(String str, InterfaceC0058b interfaceC0058b) {
        this.c = str;
        this.f1880e = interfaceC0058b;
        return this;
    }

    private void a() {
        View inflate = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_privacy_dialog"), (ViewGroup) null);
        setContentView(inflate);
        final TTCornersWebView tTCornersWebView = (TTCornersWebView) inflate.findViewById(t.e(this.a, "tt_privacy_webview"));
        Button button = (Button) inflate.findViewById(t.e(this.a, "tt_privacy_accept_btn"));
        TextView textView = (TextView) inflate.findViewById(t.e(this.a, "tt_privacy_reject_btn"));
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(t.e(this.a, "tt_privacy_back_layout"));
        this.f1881f = relativeLayout;
        ac.a((View) relativeLayout, 8);
        textView.getPaint().setFlags(8);
        a(tTCornersWebView);
        if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c)) {
            button.setText(this.b);
            textView.setText(this.c);
        }
        button.setOnClickListener(new a());
        textView.setOnClickListener(new a());
        this.f1881f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.b.1
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view) {
                VdsAgent.onClick(this, view);
                TTCornersWebView tTCornersWebView2 = tTCornersWebView;
                if (tTCornersWebView2 == null || !tTCornersWebView2.canGoBack()) {
                    return;
                }
                tTCornersWebView.goBack();
                if (tTCornersWebView.canGoBack()) {
                    return;
                }
                ac.a((View) b.this.f1881f, 8);
            }
        });
    }

    private void a(final TTCornersWebView tTCornersWebView) {
        String r = o.h().r();
        if (r != null) {
            try {
                tTCornersWebView.getSettings().setJavaScriptEnabled(true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            tTCornersWebView.loadUrl(r);
            VdsAgent.loadUrl(tTCornersWebView, r);
            if (Build.VERSION.SDK_INT >= 21) {
                tTCornersWebView.getSettings().setMixedContentMode(0);
            }
            tTCornersWebView.setWebViewClient(new WebViewClient() { // from class: com.bytedance.sdk.openadsdk.core.widget.b.2
                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    TTCornersWebView tTCornersWebView2 = tTCornersWebView;
                    if (tTCornersWebView2 == null || !tTCornersWebView2.canGoBack()) {
                        return;
                    }
                    ac.a((View) b.this.f1881f, 0);
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                    if (webView == null || webResourceRequest == null) {
                        return false;
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        String uri = webResourceRequest.getUrl().toString();
                        webView.loadUrl(uri);
                        VdsAgent.loadUrl(webView, uri);
                        return true;
                    }
                    String obj = webResourceRequest.toString();
                    webView.loadUrl(obj);
                    VdsAgent.loadUrl(webView, obj);
                    return true;
                }
            });
        }
    }
}
