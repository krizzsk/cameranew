package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: WebViewPool.java */
/* loaded from: classes.dex */
public class d {
    private static final byte[] c = new byte[0];

    /* renamed from: d  reason: collision with root package name */
    private static int f1936d = 10;

    /* renamed from: e  reason: collision with root package name */
    private static int f1937e = 3;

    /* renamed from: g  reason: collision with root package name */
    private static volatile d f1938g;
    private List<WeakReference<SSWebView>> a;
    private List<WeakReference<SSWebView>> b;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f1939f = new AtomicBoolean(false);

    private d() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        for (int i2 = 0; i2 < f1937e; i2++) {
            SSWebView sSWebView = new SSWebView(o.a());
            sSWebView.loadUrl("about:blank");
            this.a.add(new WeakReference<>(sSWebView));
        }
    }

    public void b() {
        if (this.f1939f.getAndSet(true)) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            d();
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.d();
                }
            });
        }
    }

    public WeakReference<SSWebView> c() {
        WeakReference<SSWebView> weakReference;
        WeakReference<SSWebView> weakReference2;
        com.bytedance.sdk.openadsdk.utils.o.e("webviewpool", "===start getWebView available:" + this.a.size() + " ,inuse:" + this.b.size());
        synchronized (c) {
            try {
            } catch (Exception unused) {
                WeakReference<SSWebView> weakReference3 = new WeakReference<>(new SSWebView(o.a()));
                this.b.add(weakReference3);
                weakReference = weakReference3;
            }
            if (this.a.size() > 0 && this.a.get(0) != null) {
                weakReference = this.a.get(0);
                if (weakReference.get() != null) {
                    this.a.remove(0);
                    this.b.add(weakReference);
                    com.bytedance.sdk.openadsdk.utils.o.e("webviewpool", "===end getWebView available:" + this.a.size() + " ,inuse:" + this.b.size());
                    weakReference.get().loadUrl("about:blank");
                } else {
                    this.a.remove(0);
                    weakReference2 = new WeakReference<>(new SSWebView(o.a()));
                    this.b.add(weakReference2);
                }
            } else {
                weakReference2 = new WeakReference<>(new SSWebView(o.a()));
                this.b.add(weakReference2);
            }
            weakReference = weakReference2;
            com.bytedance.sdk.openadsdk.utils.o.e("webviewpool", "===end getWebView available:" + this.a.size() + " ,inuse:" + this.b.size());
            weakReference.get().loadUrl("about:blank");
        }
        return weakReference;
    }

    public static d a() {
        if (f1938g == null) {
            synchronized (d.class) {
                if (f1938g == null) {
                    f1938g = new d();
                }
            }
        }
        return f1938g;
    }

    public void a(ViewGroup viewGroup, WeakReference<SSWebView> weakReference, boolean z) {
        com.bytedance.sdk.openadsdk.utils.o.e("webviewpool", "===start removeWebView available:" + this.a.size() + " ,inuse:" + this.b.size());
        if (!z || weakReference == null || weakReference.get() == null) {
            return;
        }
        try {
            SSWebView sSWebView = weakReference.get();
            viewGroup.removeView(sSWebView);
            sSWebView.loadUrl("");
            sSWebView.stopLoading();
            sSWebView.setWebChromeClient(null);
            sSWebView.setWebViewClient(null);
            sSWebView.clearCache(true);
            sSWebView.clearHistory();
            sSWebView.getSettings().setJavaScriptEnabled(true);
            sSWebView.getSettings().setCacheMode(2);
            sSWebView.getSettings().setAppCacheEnabled(false);
            sSWebView.getSettings().setSupportZoom(false);
            sSWebView.getSettings().setUseWideViewPort(true);
            sSWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            sSWebView.getSettings().setDomStorageEnabled(true);
            sSWebView.getSettings().setBuiltInZoomControls(false);
            sSWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
            sSWebView.getSettings().setLoadWithOverviewMode(false);
            sSWebView.getSettings().setUserAgentString("android_client");
            sSWebView.getSettings().setDefaultTextEncodingName("UTF-8");
            sSWebView.getSettings().setDefaultFontSize(16);
            y.a(o.a(), sSWebView);
            y.a(sSWebView);
            synchronized (c) {
                this.b.remove(weakReference);
                if (this.a.size() < f1937e) {
                    SSWebView sSWebView2 = new SSWebView(o.a());
                    sSWebView2.loadUrl("about:blank");
                    this.a.add(new WeakReference<>(sSWebView2));
                }
            }
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.utils.o.e("webviewpool", "===end removeWebView available:" + this.a.size() + " ,inuse:" + this.b.size());
    }
}
