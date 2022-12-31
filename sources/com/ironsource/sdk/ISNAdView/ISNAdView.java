package com.ironsource.sdk.ISNAdView;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.ironsource.sdk.WPAD.b;
import d.e.d.a.f;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ISNAdView extends FrameLayout {
    private WebView a;
    private Activity b;
    private d.e.d.b c;

    /* renamed from: d  reason: collision with root package name */
    private String f5686d;

    /* renamed from: e  reason: collision with root package name */
    private com.ironsource.sdk.ISNAdView.b f5687e;

    /* renamed from: f  reason: collision with root package name */
    private String f5688f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ISNAdView.this.f5687e.w();
                if (ISNAdView.this.a != null) {
                    ISNAdView.this.a.destroy();
                }
                ISNAdView.this.b = null;
                ISNAdView.this.c = null;
                ISNAdView.this.f5686d = null;
                ISNAdView.this.f5687e.n();
                ISNAdView.this.f5687e = null;
            } catch (Exception e2) {
                Log.e(ISNAdView.this.f5688f, "performCleanup | could not destroy ISNAdView");
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        b(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (ISNAdView.this.a == null) {
                    ISNAdView.this.k(this.a, this.b);
                }
                ISNAdView iSNAdView = ISNAdView.this;
                iSNAdView.addView(iSNAdView.a);
                WebView webView = ISNAdView.this.a;
                String str = this.c;
                webView.loadUrl(str);
                VdsAgent.loadUrl(webView, str);
            } catch (Exception e2) {
                e2.printStackTrace();
                ISNAdView.this.s(this.b, e2.getMessage());
                f.a aVar = f.r;
                d.e.d.a.a aVar2 = new d.e.d.a.a();
                aVar2.a("callfailreason", e2.getMessage());
                d.e.d.a.d.d(aVar, aVar2.b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements b.a {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // com.ironsource.sdk.WPAD.b.a
        public void a(String str) {
            ISNAdView.this.s(this.a, str);
        }

        @Override // com.ironsource.sdk.WPAD.b.a
        public void b(String str) {
            try {
                ((ViewGroup) ISNAdView.this.a.getParent()).removeView(ISNAdView.this.a);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            ISNAdView.this.p();
        }
    }

    public ISNAdView(Activity activity, String str, d.e.d.b bVar) {
        super(activity);
        this.f5688f = ISNAdView.class.getSimpleName();
        this.b = activity;
        this.c = bVar;
        this.f5686d = str;
        this.f5687e = new com.ironsource.sdk.ISNAdView.b();
    }

    private String j(String str, String str2, JSONObject jSONObject) {
        Object[] objArr = new Object[2];
        objArr[0] = str2;
        objArr[1] = jSONObject != null ? jSONObject.toString() : " null";
        return String.format(str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, String str2) throws JSONException {
        WebView webView = new WebView(this.b);
        this.a = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.a.addJavascriptInterface(new d(this), "containerMsgHandler");
        this.a.setWebViewClient(new com.ironsource.sdk.ISNAdView.c(new c(str2)));
        this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f5687e.F(this.a);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("adViewId", this.f5687e.p());
        this.f5687e.C(str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, String str2) {
        com.ironsource.sdk.ISNAdView.b bVar = this.f5687e;
        if (bVar != null) {
            bVar.x(str, str2);
        }
    }

    public d.e.d.b l() {
        return this.c;
    }

    public void m(JSONObject jSONObject) throws Exception {
        try {
            try {
                d.e.d.k.b.b0(this.b).e0(this.f5687e.i(jSONObject, this.f5686d));
            } catch (Exception unused) {
                throw new Exception("ISNAdView | Failed to instantiate IronSourceAdsPublisherAgent");
            }
        } catch (Exception unused2) {
            throw new Exception("ISNAdView | loadAd | Failed to build load parameters");
        }
    }

    public void n(Map<String, String> map) throws Exception {
        try {
            this.f5687e.j(map, this.f5686d);
            try {
                d.e.d.k.b.b0(this.b).f0(map, this.b);
            } catch (Exception unused) {
                throw new Exception("ISNAdView | Failed to instantiate IronSourceAdsPublisherAgent");
            }
        } catch (Exception unused2) {
            throw new Exception("ISNAdView | loadAd | Failed to build load parameters");
        }
    }

    public void o(String str, String str2, String str3) {
        this.b.runOnUiThread(new b(str2, str3, str));
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        com.ironsource.sdk.ISNAdView.b bVar = this.f5687e;
        if (bVar != null) {
            bVar.J("isVisible", i2, isShown());
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        com.ironsource.sdk.ISNAdView.b bVar = this.f5687e;
        if (bVar != null) {
            bVar.J("isWindowVisible", i2, isShown());
        }
    }

    public void p() {
        Activity activity = this.b;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new a());
    }

    public void q(String str, JSONObject jSONObject, String str2, String str3) {
        if (this.f5687e == null) {
            d.e.d.a.a aVar = new d.e.d.a.a();
            aVar.a("generalmessage", j("ISNAdViewLogic is NULL and method name %s and function parameters %s", str, jSONObject));
            d.e.d.a.d.d(f.s, aVar.b());
            return;
        }
        try {
            if (str.equalsIgnoreCase("loadWithUrl")) {
                String string = jSONObject.getString("urlForWebView");
                this.f5687e.D(jSONObject.getString("adViewId"));
                o(string, str2, str3);
                return;
            }
            this.f5687e.r(str, jSONObject, str2, str3);
        } catch (Exception e2) {
            e2.printStackTrace();
            s(str3, j("Could not handle message from controller: %s  with params: %s", str, jSONObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(String str) {
        this.f5687e.s(str);
    }

    public void setControllerDelegate(com.ironsource.sdk.ISNAdView.a aVar) {
        this.f5687e.G(aVar);
    }
}
