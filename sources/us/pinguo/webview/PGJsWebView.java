package us.pinguo.webview;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.webkit.JavascriptInterface;
import us.pinguo.webview.f.f;
import us.pinguo.webview.f.g;
/* loaded from: classes6.dex */
public class PGJsWebView extends PGBaseWebView {
    private us.pinguo.webview.g.a a;
    private Handler b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private us.pinguo.webview.f.c f12491d;

    @Deprecated
    /* loaded from: classes6.dex */
    private class OldJSCallback {

        /* loaded from: classes6.dex */
        class a implements Runnable {
            final /* synthetic */ String a;
            final /* synthetic */ String b;
            final /* synthetic */ String c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ String f12492d;

            a(String str, String str2, String str3, String str4) {
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.f12492d = str4;
            }

            @Override // java.lang.Runnable
            public void run() {
                PGJsWebView.this.a.y(this.a, this.b, this.c, this.f12492d);
            }
        }

        /* loaded from: classes6.dex */
        class b implements Runnable {
            final /* synthetic */ boolean a;

            b(boolean z) {
                this.a = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                PGJsWebView.this.a.J(this.a);
            }
        }

        private OldJSCallback() {
        }

        @JavascriptInterface
        public void pinguoJsCanShare(boolean z) {
            if (PGJsWebView.this.a != null) {
                PGJsWebView.this.b.post(new b(z));
            }
        }

        @JavascriptInterface
        public void pinguoJsShareBridge(String str, String str2, String str3, String str4) {
            if (PGJsWebView.this.a != null) {
                PGJsWebView.this.b.post(new a(str, str2, str3, str4));
            }
        }

        /* synthetic */ OldJSCallback(PGJsWebView pGJsWebView, a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    private class PGNewNative {
        private PGNewNative() {
        }

        @JavascriptInterface
        public void sendSignalToAdr() {
            if (PGJsWebView.this.f12491d != null) {
                us.pinguo.common.log.a.e("sendSignalToAdr", new Object[0]);
                f.a(PGJsWebView.this, "WebViewJavascriptBridge._fetchQueue", new g.b[0]);
            }
        }

        @JavascriptInterface
        public void setQueue(String str) {
            if (PGJsWebView.this.f12491d != null) {
                us.pinguo.common.log.a.e("queueMsg:" + str, new Object[0]);
                PGJsWebView.this.f12491d.j(str);
            }
        }

        /* synthetic */ PGNewNative(PGJsWebView pGJsWebView, a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    class a implements Runnable {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PGJsWebView.this.c) {
                PGJsWebView pGJsWebView = PGJsWebView.this;
                pGJsWebView.loadUrl("javascript:" + this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    class b implements Runnable {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PGJsWebView.this.c) {
                PGJsWebView pGJsWebView = PGJsWebView.this;
                pGJsWebView.loadUrl("javascript:" + this.a);
            }
        }
    }

    public PGJsWebView(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = true;
        this.f12491d = null;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.c = false;
        us.pinguo.webview.f.c cVar = this.f12491d;
        if (cVar != null) {
            cVar.g();
        }
        super.destroy();
    }

    public void e(String str) {
        f.c(this, str);
    }

    public void f() {
        us.pinguo.webview.b.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public us.pinguo.webview.g.a g() {
        return this.a;
    }

    public void h(us.pinguo.webview.a aVar, PGBaseWebSettings pGBaseWebSettings, us.pinguo.webview.g.b bVar) {
        this.b = new Handler(Looper.getMainLooper());
        if (pGBaseWebSettings != null) {
            pGBaseWebSettings.a(this);
        }
        this.c = true;
        if (aVar != null && bVar != null) {
            this.f12491d = new us.pinguo.webview.f.c(this, aVar, bVar);
            addJavascriptInterface(new PGNewNative(this, null), "PinguoNativeAdr");
            return;
        }
        this.f12491d = null;
    }

    public void i(String str, int i2) {
        this.b.postDelayed(new a(str), i2);
    }

    public void j(String str) {
        this.b.post(new b(str));
    }

    @Deprecated
    public void setSupportOldNativeShare(us.pinguo.webview.g.a aVar) {
        this.a = aVar;
        if (aVar != null) {
            addJavascriptInterface(new OldJSCallback(this, null), "NativeShare");
        }
    }

    @Override // android.view.View
    public ActionMode startActionMode(ActionMode.Callback callback) {
        try {
            return super.startActionMode(callback);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        try {
            return super.startActionModeForChild(view, callback);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public PGJsWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = null;
        this.c = true;
        this.f12491d = null;
    }

    public PGJsWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = null;
        this.b = null;
        this.c = true;
        this.f12491d = null;
    }
}
