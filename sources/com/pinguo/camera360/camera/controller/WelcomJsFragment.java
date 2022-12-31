package com.pinguo.camera360.camera.controller;

import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.Timer;
import java.util.TimerTask;
import us.pinguo.foundation.base.BaseFragment;
import vStudio.Android.Camera360.R;
import vStudio.Android.Camera360.a;
/* loaded from: classes3.dex */
public class WelcomJsFragment extends BaseFragment {
    private TextView a;
    private ImageView b;

    /* renamed from: d  reason: collision with root package name */
    private WebView f6211d;
    private a.InterfaceC0470a c = null;

    /* renamed from: e  reason: collision with root package name */
    private Timer f6212e = null;

    /* renamed from: f  reason: collision with root package name */
    private TimerTask f6213f = null;

    /* renamed from: g  reason: collision with root package name */
    private int f6214g = PathInterpolatorCompat.MAX_NUM_POINTS;

    /* renamed from: h  reason: collision with root package name */
    private int f6215h = 2;

    /* renamed from: i  reason: collision with root package name */
    private Handler f6216i = new d();

    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            if (WelcomJsFragment.this.f6216i.hasMessages(1)) {
                WelcomJsFragment.this.f6216i.removeMessages(1);
                WelcomJsFragment.this.f6216i.sendEmptyMessage(1);
                return;
            }
            WelcomJsFragment.this.f6216i.sendEmptyMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends TimerTask {
        final /* synthetic */ Timer a;

        b(Timer timer) {
            this.a = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            WelcomJsFragment.c0(WelcomJsFragment.this);
            if (WelcomJsFragment.this.f6215h == 0) {
                WelcomJsFragment.this.f6216i.sendEmptyMessage(1000);
                this.a.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c extends WebViewClient {
        c() {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (WelcomJsFragment.this.getActivity() != null && !WelcomJsFragment.this.getActivity().isFinishing()) {
                us.pinguo.foundation.ui.f.d(WelcomJsFragment.this.getActivity(), webView.getUrl(), sslErrorHandler);
            } else {
                sslErrorHandler.cancel();
            }
        }
    }

    /* loaded from: classes3.dex */
    class d extends Handler {
        d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            FragmentActivity activity;
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 1) {
                if (WelcomJsFragment.this.c != null) {
                    WelcomJsFragment.this.c.n(1, null);
                }
                WelcomJsFragment.this.l0();
                if (WelcomJsFragment.this.b != null && (activity = WelcomJsFragment.this.getActivity()) != null && activity.isFinishing()) {
                }
            } else if (i2 == 3) {
                if (WelcomJsFragment.this.f6214g > 0) {
                    TextView textView = WelcomJsFragment.this.a;
                    textView.setText((WelcomJsFragment.this.f6214g / 1000) + " " + WelcomJsFragment.this.getResources().getString(R.string.guide_page_jump_text));
                    return;
                }
                WelcomJsFragment.this.f6216i.sendEmptyMessage(1);
            } else if (i2 != 1000) {
            } else {
                WelcomJsFragment.this.b.setVisibility(8);
                WebView webView = WelcomJsFragment.this.f6211d;
                webView.setVisibility(0);
                VdsAgent.onSetViewVisibility(webView, 0);
                TextView textView2 = WelcomJsFragment.this.a;
                textView2.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView2, 0);
                WelcomJsFragment.this.n0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e extends TimerTask {
        e() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            WelcomJsFragment.h0(WelcomJsFragment.this, 1000);
            Message message = new Message();
            message.what = 3;
            message.arg1 = WelcomJsFragment.this.f6214g;
            WelcomJsFragment.this.f6216i.sendMessage(message);
        }
    }

    static /* synthetic */ int c0(WelcomJsFragment welcomJsFragment) {
        int i2 = welcomJsFragment.f6215h;
        welcomJsFragment.f6215h = i2 - 1;
        return i2;
    }

    static /* synthetic */ int h0(WelcomJsFragment welcomJsFragment, int i2) {
        int i3 = welcomJsFragment.f6214g - i2;
        welcomJsFragment.f6214g = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        Timer timer = this.f6212e;
        if (timer != null) {
            timer.cancel();
            this.f6213f.cancel();
            this.f6212e = null;
            this.f6213f = null;
        }
    }

    private void m0() {
        this.b.setVisibility(0);
        this.b.setImageResource(R.drawable.guide_background_bitmap);
        WebView webView = this.f6211d;
        webView.setVisibility(4);
        VdsAgent.onSetViewVisibility(webView, 4);
        TextView textView = this.a;
        textView.setVisibility(4);
        VdsAgent.onSetViewVisibility(textView, 4);
        Timer timer = new Timer();
        timer.schedule(new b(timer), 1000L, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        this.f6212e = null;
        this.f6213f = null;
        this.f6212e = new Timer();
        e eVar = new e();
        this.f6213f = eVar;
        this.f6212e.schedule(eVar, 1000L, 1000L);
    }

    private void o0() {
        WebSettings settings = this.f6211d.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setCacheMode(2);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setAppCacheEnabled(false);
        settings.setDomStorageEnabled(true);
        this.f6211d.setWebViewClient(new c());
        WebView webView = this.f6211d;
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: com.pinguo.camera360.camera.controller.WelcomJsFragment.4
            @Override // android.webkit.WebChromeClient
            public boolean onCreateWindow(WebView webView2, boolean z, boolean z2, Message message) {
                if (WelcomJsFragment.this.getActivity() == null) {
                    return super.onCreateWindow(webView2, z, z2, message);
                }
                WebView webView3 = new WebView(WelcomJsFragment.this.getActivity());
                webView3.getSettings().setJavaScriptEnabled(true);
                webView3.setWebChromeClient(this);
                VdsAgent.setWebChromeClient(webView3, this);
                ((WebView.WebViewTransport) message.obj).setWebView(webView3);
                message.sendToTarget();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i2) {
                VdsAgent.onProgressChangedStart(webView2, i2);
                super.onProgressChanged(webView2, i2);
                VdsAgent.onProgressChangedEnd(webView2, i2);
            }
        };
        webView.setWebChromeClient(webChromeClient);
        VdsAgent.setWebChromeClient(webView, webChromeClient);
        String string = getArguments().getString("html_content_key");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        WebView webView2 = this.f6211d;
        webView2.loadDataWithBaseURL(null, string, "text/html", "UTF-8", null);
        VdsAgent.loadDataWithBaseURL(webView2, null, string, "text/html", "UTF-8", null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (activity instanceof a.InterfaceC0470a) {
            this.c = (a.InterfaceC0470a) activity;
        }
        this.f6214g = getArguments().getInt("mAdsDuration", PathInterpolatorCompat.MAX_NUM_POINTS);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_welcom_js, (ViewGroup) null);
        this.b = (ImageView) inflate.findViewById(R.id.welcome_ad_image_view);
        this.a = (TextView) inflate.findViewById(R.id.skip);
        this.f6211d = (WebView) inflate.findViewById(R.id.js_webview);
        this.a.setOnClickListener(new a());
        m0();
        o0();
        return inflate;
    }
}
