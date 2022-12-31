package com.ironsource.sdk.WPAD;

import android.app.Activity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.ironsource.sdk.WPAD.b;
import com.ironsource.sdk.utils.h;
import d.e.d.a.f;
import d.e.d.n.g;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* compiled from: ISNAdunitWebView.java */
/* loaded from: classes2.dex */
public class c implements com.ironsource.sdk.WPAD.b {

    /* renamed from: g  reason: collision with root package name */
    private static final String f5698g = "c";
    private final String a;
    private final String b;
    private g c;

    /* renamed from: d  reason: collision with root package name */
    private WebView f5699d;

    /* renamed from: e  reason: collision with root package name */
    private com.ironsource.sdk.ISNAdView.b f5700e;

    /* renamed from: f  reason: collision with root package name */
    private Activity f5701f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ISNAdunitWebView.java */
    /* loaded from: classes2.dex */
    public class a implements b.a {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.ironsource.sdk.WPAD.b.a
        public void a(String str) {
            com.ironsource.sdk.utils.d.d(c.f5698g, "createWebView failed!");
            c.this.f5700e.x(this.a, str);
        }

        @Override // com.ironsource.sdk.WPAD.b.a
        public void b(String str) {
            String str2 = c.f5698g;
            com.ironsource.sdk.utils.d.d(str2, "onRenderProcessGone, message: " + str);
        }
    }

    /* compiled from: ISNAdunitWebView.java */
    /* loaded from: classes2.dex */
    class b implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ JSONObject b;
        final /* synthetic */ String c;

        b(String str, JSONObject jSONObject, String str2) {
            this.a = str;
            this.b = jSONObject;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f5699d != null) {
                f.a aVar = f.o;
                d.e.d.a.a aVar2 = new d.e.d.a.a();
                aVar2.a("callfailreason", "loadWithUrl | webView is not null");
                d.e.d.a.d.d(aVar, aVar2.b());
            }
            try {
                c.this.o(this.a);
                String n = c.this.n(this.b.getString("urlForWebView"));
                WebView webView = c.this.f5699d;
                webView.loadUrl(n);
                VdsAgent.loadUrl(webView, n);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adViewId", c.this.a);
                c.this.f5700e.C(this.c, jSONObject);
            } catch (Exception e2) {
                c.this.f5700e.x(this.a, e2.getMessage());
                f.a aVar3 = f.o;
                d.e.d.a.a aVar4 = new d.e.d.a.a();
                aVar4.a("callfailreason", e2.getMessage());
                d.e.d.a.d.d(aVar3, aVar4.b());
            }
        }
    }

    /* compiled from: ISNAdunitWebView.java */
    /* renamed from: com.ironsource.sdk.WPAD.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class RunnableC0212c implements Runnable {
        final /* synthetic */ String a;

        RunnableC0212c(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f5700e.A(this.a);
        }
    }

    /* compiled from: ISNAdunitWebView.java */
    /* loaded from: classes2.dex */
    class d implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        d(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.utils.d.d(c.f5698g, "perforemCleanup");
            try {
                if (c.this.f5699d != null) {
                    c.this.f5699d.destroy();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adViewId", c.this.a);
                c.this.f5700e.C(this.a, jSONObject);
                c.this.f5700e.n();
                c.this.f5700e = null;
                c.this.c = null;
                c.this.f5701f = null;
            } catch (Exception e2) {
                String str = c.f5698g;
                Log.e(str, "performCleanup | could not destroy ISNAdView webView ID: " + c.this.a);
                f.a aVar = f.p;
                d.e.d.a.a aVar2 = new d.e.d.a.a();
                aVar2.a("callfailreason", e2.getMessage());
                d.e.d.a.d.d(aVar, aVar2.b());
                if (c.this.f5700e != null) {
                    c.this.f5700e.x(this.b, e2.getMessage());
                }
            }
        }
    }

    public c(com.ironsource.sdk.ISNAdView.a aVar, Activity activity, String str) {
        this.f5701f = activity;
        com.ironsource.sdk.ISNAdView.b bVar = new com.ironsource.sdk.ISNAdView.b();
        this.f5700e = bVar;
        bVar.D(str);
        this.b = com.ironsource.sdk.utils.c.p(activity.getApplicationContext());
        this.a = str;
        this.f5700e.G(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String n(String str) {
        if (p(str)) {
            return InspirePublishFragment.FILE_HEADER + this.b + r(str);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str) {
        com.ironsource.sdk.utils.d.d(f5698g, "createWebView");
        WebView webView = new WebView(this.f5701f);
        this.f5699d = webView;
        webView.addJavascriptInterface(new com.ironsource.sdk.WPAD.a(this), "containerMsgHandler");
        this.f5699d.setWebViewClient(new com.ironsource.sdk.ISNAdView.c(new a(str)));
        h.d(this.f5699d);
        this.f5700e.F(this.f5699d);
        this.f5700e.E(this.a);
    }

    private boolean p(String str) {
        return str.startsWith(".");
    }

    private String r(String str) {
        String substring = str.substring(str.indexOf("/") + 1);
        return substring.substring(substring.indexOf("/"));
    }

    @Override // com.ironsource.sdk.WPAD.b
    public synchronized void a(String str, String str2) {
        Activity activity = this.f5701f;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new d(str, str2));
    }

    @Override // com.ironsource.sdk.WPAD.b
    public void b(JSONObject jSONObject, String str, String str2) throws JSONException {
        try {
            this.f5700e.B(jSONObject.getString("params"), str, str2);
        } catch (Exception e2) {
            String str3 = f5698g;
            com.ironsource.sdk.utils.d.d(str3, "sendMessageToAd fail message: " + e2.getMessage());
            throw e2;
        }
    }

    @Override // com.ironsource.sdk.WPAD.b
    public WebView c() {
        return this.f5699d;
    }

    @Override // com.ironsource.sdk.WPAD.b
    public void d(String str) {
        try {
            this.f5699d.post(new RunnableC0212c(str));
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JavascriptInterface
    public void handleMessageFromAd(String str) {
        try {
            this.f5700e.s(str);
        } catch (Exception e2) {
            throw e2;
        }
    }

    public void q(JSONObject jSONObject, String str, String str2) {
        this.f5701f.runOnUiThread(new b(str2, jSONObject, str));
    }
}
