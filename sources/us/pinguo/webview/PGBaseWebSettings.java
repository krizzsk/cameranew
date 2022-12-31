package us.pinguo.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class PGBaseWebSettings {
    private WeakReference<Context> a;
    private boolean b = true;
    private boolean c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12487d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12488e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12489f = true;

    /* renamed from: g  reason: collision with root package name */
    private View.OnLongClickListener f12490g = null;

    public PGBaseWebSettings(Context context) {
        this.a = new WeakReference<>(context);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void a(WebView webView) {
        WebSettings settings;
        if (webView == null || this.a.get() == null || (settings = webView.getSettings()) == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(this.b);
        } catch (Exception unused) {
            us.pinguo.common.log.a.u("WebSettings", "setJavaScriptEnabled failed", new Object[0]);
        }
        if (this.c) {
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
        } else {
            settings.setSupportZoom(false);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(this.f12487d);
        settings.setAllowFileAccess(this.f12488e);
        settings.setBlockNetworkImage(!this.f12489f);
        if (Build.VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(true);
        }
        View.OnLongClickListener onLongClickListener = this.f12490g;
        if (onLongClickListener == null) {
            webView.setOnLongClickListener(null);
            webView.setLongClickable(false);
            return;
        }
        webView.setOnLongClickListener(onLongClickListener);
        webView.setLongClickable(true);
    }

    public PGBaseWebSettings b(View.OnLongClickListener onLongClickListener) {
        this.f12490g = onLongClickListener;
        return this;
    }
}
