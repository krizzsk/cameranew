package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: LandingPageLog.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: f  reason: collision with root package name */
    private String f1406f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f1407g;

    /* renamed from: h  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.d.h f1408h;
    private WebView p;
    private p s;
    private int a = 1;
    private boolean b = false;
    private boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1404d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f1405e = -1;

    /* renamed from: i  reason: collision with root package name */
    private String f1409i = "landingpage";

    /* renamed from: j  reason: collision with root package name */
    private long f1410j = 0;

    /* renamed from: k  reason: collision with root package name */
    private long f1411k = 0;

    /* renamed from: l  reason: collision with root package name */
    private long f1412l = 0;
    private long m = 0;
    private boolean n = false;
    private AtomicInteger o = new AtomicInteger(0);
    private boolean q = false;
    private String r = "";

    /* compiled from: LandingPageLog.java */
    /* loaded from: classes.dex */
    private class a {
        private a() {
        }

        @JavascriptInterface
        public String getUrl() {
            return j.this.r;
        }

        @JavascriptInterface
        public void readPercent(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("measure height: ");
            int i2 = 0;
            sb.append(j.this.p == null ? 0 : j.this.p.getMeasuredHeight());
            com.bytedance.sdk.openadsdk.utils.o.b("LandingPageLog", sb.toString());
            com.bytedance.sdk.openadsdk.utils.o.b("LandingPageLog", "read percent: " + String.valueOf(str));
            try {
                int intValue = Float.valueOf(str).intValue();
                if (intValue > 100) {
                    i2 = 100;
                } else if (intValue >= 0) {
                    i2 = intValue;
                }
            } catch (Throwable unused) {
            }
            j.this.o.set(i2);
        }
    }

    public j(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, WebView webView) {
        this.f1407g = context;
        this.f1408h = hVar;
        this.p = webView;
        if (Build.VERSION.SDK_INT >= 19) {
            webView.addJavascriptInterface(new a(), "JS_LANDING_PAGE_LOG_OBJ");
        }
    }

    public void d() {
        com.bytedance.sdk.openadsdk.utils.o.b("LandingPageLog", "onDestroy");
        this.p = null;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f1409i = str;
    }

    public void b() {
        com.bytedance.sdk.openadsdk.utils.o.b("LandingPageLog", "onResume");
        this.f1410j = System.currentTimeMillis();
    }

    public void c() {
        com.bytedance.sdk.openadsdk.utils.o.b("LandingPageLog", "onStop");
        boolean z = this.a == 2;
        long currentTimeMillis = System.currentTimeMillis();
        this.f1411k = currentTimeMillis;
        long j2 = currentTimeMillis - this.f1410j;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_status", this.a);
            jSONObject.put("stay_page_duration", j2);
            jSONObject.put("max_scroll_percent", z ? this.o.get() : 0);
        } catch (JSONException unused) {
        }
        a("landing_close", jSONObject);
    }

    public p a() {
        return this.s;
    }

    public void a(p pVar) {
        this.s = pVar;
    }

    public j a(boolean z) {
        this.q = z;
        return this;
    }

    public void a(WebView webView, int i2) {
        com.bytedance.sdk.openadsdk.utils.o.b("LandingPageLog", "onWebProgress: " + i2);
        if (this.f1412l == 0 && i2 > 0) {
            this.f1412l = System.currentTimeMillis();
        } else if (this.m == 0 && i2 == 100) {
            this.m = System.currentTimeMillis();
        }
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        com.bytedance.sdk.openadsdk.utils.o.b("LandingPageLog", "onWebStarted: " + String.valueOf(str));
        p pVar = this.s;
        if (pVar != null) {
            pVar.e();
        }
        if (this.b) {
            return;
        }
        this.b = true;
        a("load_start", new JSONObject());
    }

    public void a(WebView webView, String str) {
        com.bytedance.sdk.openadsdk.utils.o.b("LandingPageLog", "onWebFinished: " + String.valueOf(str));
        p pVar = this.s;
        if (pVar != null) {
            pVar.f();
        }
        if (webView != null && !this.n) {
            this.n = true;
            com.bytedance.sdk.openadsdk.utils.n.a(webView, "javascript:\nfunction sendScroll(){\n   var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n   var clientH = window.innerHeight || document.documentElement.clientHeight;\n   var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n   var validH = scrollH + clientH;\n   var result = (validH/totalH*100).toFixed(2);\n   console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n   window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n}\nsendScroll();\nwindow.addEventListener('scroll', function(e){\n    sendScroll();\n});");
        }
        if (this.a != 3) {
            this.a = 2;
        }
        if (this.a == 2) {
            long j2 = this.m - this.f1412l;
            if (this.c) {
                return;
            }
            this.c = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("load_duration", j2);
            } catch (Exception unused) {
            }
            a("load_finish", jSONObject);
        } else if (this.f1404d) {
        } else {
            this.f1404d = true;
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("error_code", this.f1405e);
                jSONObject2.put("error_msg", this.f1406f);
            } catch (Exception unused2) {
            }
            a("load_fail", jSONObject2);
        }
    }

    public void a(WebView webView, int i2, String str, String str2) {
        com.bytedance.sdk.openadsdk.utils.o.b("LandingPageLog", "onWebError: " + i2 + ", " + String.valueOf(str) + ", " + String.valueOf(str2));
        p pVar = this.s;
        if (pVar != null) {
            pVar.g();
        }
        this.a = 3;
        this.f1405e = i2;
        this.f1406f = str;
    }

    @RequiresApi(api = 21)
    public void a(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || TextUtils.isEmpty(webResourceRequest.getUrl().toString())) {
        }
    }

    private void a(String str, JSONObject jSONObject) {
        if (!this.q || this.f1408h == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                int i2 = 1;
                jSONObject.put("is_playable", this.f1408h.r() ? 1 : 0);
                if (!com.bytedance.sdk.openadsdk.core.video.c.a.a().a(this.f1408h)) {
                    i2 = 0;
                }
                jSONObject.put("usecache", i2);
            } catch (JSONException unused) {
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("ad_extra_data", jSONObject.toString());
                } catch (JSONException unused2) {
                }
                jSONObject2 = jSONObject3;
            } catch (JSONException unused3) {
            }
        }
        com.bytedance.sdk.openadsdk.utils.o.b("LandingPageLog", "sendEvent: " + String.valueOf(this.f1409i) + ", " + String.valueOf(str) + ", ext=" + String.valueOf(jSONObject2));
        d.b(this.f1407g, this.f1408h, this.f1409i, str, jSONObject2);
    }
}
