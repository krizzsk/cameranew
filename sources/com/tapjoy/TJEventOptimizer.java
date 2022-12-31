package com.tapjoy;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TapjoyErrorMessage;
import java.util.concurrent.CountDownLatch;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes3.dex */
public class TJEventOptimizer extends WebView {
    private static String a = "TJEventOptimizer";
    private static TJEventOptimizer b;
    private static CountDownLatch c;

    /* renamed from: d  reason: collision with root package name */
    private Context f7232d;

    /* renamed from: e  reason: collision with root package name */
    private TJAdUnitJSBridge f7233e;

    /* loaded from: classes3.dex */
    class a extends WebChromeClient {
        private a() {
        }

        @Override // android.webkit.WebChromeClient
        @TargetApi(8)
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String str = TJEventOptimizer.a;
            TapjoyLog.d(str, "JS CONSOLE: " + consoleMessage.message() + " -- From line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            VdsAgent.onProgressChangedStart(webView, i2);
            super.onProgressChanged(webView, i2);
            VdsAgent.onProgressChangedEnd(webView, i2);
        }

        /* synthetic */ a(TJEventOptimizer tJEventOptimizer, byte b) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    class b extends WebViewClient {
        private b() {
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            TapjoyLog.d(TJEventOptimizer.a, "boostrap html loaded successfully");
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            TapjoyLog.e(TJEventOptimizer.a, new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Error encountered when instantiating a WebViewClient"));
        }

        /* synthetic */ b(TJEventOptimizer tJEventOptimizer, byte b) {
            this();
        }
    }

    /* synthetic */ TJEventOptimizer(Context context, byte b2) {
        this(context);
    }

    public static TJEventOptimizer getInstance() {
        return b;
    }

    public static void init(final Context context) {
        TapjoyLog.d(a, "Initializing event optimizer");
        c = new CountDownLatch(1);
        TapjoyUtil.runOnMainThread(new Runnable() { // from class: com.tapjoy.TJEventOptimizer.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    TJEventOptimizer unused = TJEventOptimizer.b = new TJEventOptimizer(context, (byte) 0);
                } catch (Exception e2) {
                    TapjoyLog.w(TJEventOptimizer.a, e2.getMessage());
                }
                TJEventOptimizer.c.countDown();
            }
        });
        c.await();
        if (b == null) {
            throw new RuntimeException("Failed to init TJEventOptimizer");
        }
    }

    private TJEventOptimizer(Context context) {
        super(context);
        this.f7232d = context;
        this.f7233e = new TJAdUnitJSBridge(context, this);
        getSettings().setJavaScriptEnabled(true);
        setWebViewClient(new b(this, (byte) 0));
        a aVar = new a(this, (byte) 0);
        setWebChromeClient(aVar);
        VdsAgent.setWebChromeClient(this, aVar);
        String str = TapjoyConnectCore.getHostURL() + TJAdUnitConstants.EVENTS_PROXY_PATH + TapjoyUtil.convertURLParams(TapjoyConnectCore.getGenericURLParams(), true);
        loadUrl(str);
        VdsAgent.loadUrl(this, str);
    }
}
