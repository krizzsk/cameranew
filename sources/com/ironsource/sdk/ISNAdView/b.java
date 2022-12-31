package com.ironsource.sdk.ISNAdView;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TapjoyAuctionFlags;
import d.e.d.a.f;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ISNAdViewLogic.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: i  reason: collision with root package name */
    private static Handler f5690i;
    private com.ironsource.sdk.ISNAdView.a b;

    /* renamed from: d  reason: collision with root package name */
    private WebView f5691d;

    /* renamed from: e  reason: collision with root package name */
    private String f5692e;
    private JSONObject a = null;

    /* renamed from: f  reason: collision with root package name */
    private String f5693f = b.class.getSimpleName();

    /* renamed from: g  reason: collision with root package name */
    private String[] f5694g = {"handleGetViewVisibility"};

    /* renamed from: h  reason: collision with root package name */
    private final String[] f5695h = {"loadWithUrl", "updateAd", "isExternalAdViewInitiated", "handleGetViewVisibility", "sendMessage"};
    private ViewVisibilityParameters c = new ViewVisibilityParameters();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ISNAdViewLogic.java */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ JSONObject f5696d;

        a(String str, String str2, String str3, JSONObject jSONObject) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.f5696d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!b.this.m(this.a)) {
                    String str = "ISNAdViewLogic | handleMessageFromController | cannot handle command: " + this.a;
                    Log.e(b.this.f5693f, str);
                    b.this.x(this.b, str);
                } else if (this.a.equalsIgnoreCase("isExternalAdViewInitiated")) {
                    b.this.A(this.c);
                } else if (this.a.equalsIgnoreCase("handleGetViewVisibility")) {
                    b.this.y(this.c);
                } else if (this.a.equalsIgnoreCase("sendMessage") || this.a.equalsIgnoreCase("updateAd")) {
                    b.this.B(this.f5696d.getString("params"), this.c, this.b);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                String str2 = "ISNAdViewLogic | handleMessageFromController | Error while trying handle message: " + this.a;
                Log.e(b.this.f5693f, str2);
                b.this.x(this.b, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ISNAdViewLogic.java */
    /* renamed from: com.ironsource.sdk.ISNAdView.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0211b extends JSONObject {
        C0211b() throws RuntimeException, Error {
            try {
                put("configs", b.this.o(b.this.a, b.this.c.c()));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ISNAdViewLogic.java */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.t(this.a);
        }
    }

    private boolean H(String str) {
        int i2 = 0;
        while (true) {
            String[] strArr = this.f5694g;
            if (i2 >= strArr.length) {
                return false;
            }
            if (strArr[i2].equalsIgnoreCase(str)) {
                return true;
            }
            i2++;
        }
    }

    private boolean I(String str) {
        if (Build.VERSION.SDK_INT <= 22) {
            return str.equalsIgnoreCase("isWindowVisible");
        }
        return str.equalsIgnoreCase("isVisible");
    }

    private String h(String str) {
        return String.format("window.ssa.onMessageReceived(%1$s)", str);
    }

    private JSONObject k() {
        return new C0211b();
    }

    private JSONObject l(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(TapjoyAuctionFlags.AUCTION_ID, jSONObject.getString(TapjoyAuctionFlags.AUCTION_ID));
            jSONObject2.put("data", this.c.c());
        } catch (Exception e2) {
            String str = this.f5693f;
            Log.e(str, "Error while trying execute method buildVisibilityMessageForAdunit | params: " + jSONObject);
            e2.printStackTrace();
        }
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(String str) {
        int i2 = 0;
        boolean z = false;
        while (true) {
            String[] strArr = this.f5695h;
            if (i2 >= strArr.length || z) {
                break;
            }
            if (strArr[i2].equalsIgnoreCase(str)) {
                z = true;
            }
            i2++;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject o(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
            jSONObject3.put("visibilityParams", jSONObject2);
            return jSONObject3;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    private Handler q() {
        try {
            if (f5690i == null) {
                f5690i = new Handler(Looper.getMainLooper());
            }
        } catch (Exception e2) {
            Log.e(this.f5693f, "Error while trying execute method getUIThreadHandler");
            e2.printStackTrace();
        }
        return f5690i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        try {
            String str2 = "javascript:try{" + str + "}catch(e){console.log(\"JS exception: \" + JSON.stringify(e));}";
            if (Build.VERSION.SDK_INT >= 19) {
                this.f5691d.evaluateJavascript(str2, null);
            } else {
                WebView webView = this.f5691d;
                webView.loadUrl(str2);
                VdsAgent.loadUrl(webView, str2);
            }
        } catch (Throwable th) {
            Log.e(this.f5693f, "injectJavaScriptIntoWebView | Error while trying inject JS into external adunit: " + str + "Android API level: " + Build.VERSION.SDK_INT);
            th.printStackTrace();
        }
    }

    private boolean u() {
        return this.a != null;
    }

    private void v() {
        if (this.b == null || this.c == null) {
            return;
        }
        C("containerIsVisible", k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str) throws JSONException {
        JSONObject c2 = this.c.c();
        c2.put("adViewId", this.f5692e);
        C(str, c2);
    }

    private void z(JSONObject jSONObject) throws JSONException {
        B(l(jSONObject).toString(), null, null);
    }

    public void A(String str) {
        try {
            WebView webView = this.f5691d;
            boolean z = (webView == null || webView.getUrl() == null) ? false : true;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isExternalAdViewInitiated", z);
            jSONObject.put("adViewId", this.f5692e);
            C(str, jSONObject);
        } catch (Exception e2) {
            Log.e(this.f5693f, "Error while trying execute method sendIsExternalAdViewInitiated");
            e2.printStackTrace();
        }
    }

    public void B(String str, String str2, String str3) throws JSONException {
        if (this.f5691d == null) {
            String str4 = "No external adunit attached to ISNAdView while trying to send message: " + str;
            Log.e(this.f5693f, str4);
            this.b.b(str3, str4, this.f5692e);
            return;
        }
        try {
            new JSONObject(str);
        } catch (JSONException unused) {
            str = "\"" + str + "\"";
        }
        q().post(new c(h(str)));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("adViewId", this.f5692e);
        C(str2, jSONObject);
    }

    public void C(String str, JSONObject jSONObject) {
        com.ironsource.sdk.ISNAdView.a aVar = this.b;
        if (aVar != null) {
            aVar.a(str, jSONObject);
        }
    }

    public void D(String str) {
        this.f5692e = str;
    }

    public void E(String str) {
        JSONObject jSONObject = new JSONObject();
        this.a = jSONObject;
        try {
            jSONObject.put("externalAdViewId", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void F(WebView webView) {
        this.f5691d = webView;
    }

    public void G(com.ironsource.sdk.ISNAdView.a aVar) {
        this.b = aVar;
    }

    public void J(String str, int i2, boolean z) {
        this.c.d(str, i2, z);
        if (I(str)) {
            v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject i(JSONObject jSONObject, String str) throws Exception {
        try {
            boolean u = u();
            if (this.a == null) {
                this.a = new JSONObject(jSONObject.toString());
            }
            this.a.put("externalAdViewId", str);
            this.a.put("isInReload", u);
            return this.a;
        } catch (Exception unused) {
            throw new Exception("ISNAdViewLogic | buildDataForLoadingAd | Could not build load parameters");
        }
    }

    public void j(Map<String, String> map, String str) throws Exception {
        boolean u = u();
        if (this.a == null) {
            this.a = new JSONObject(map);
        }
        this.a.put("externalAdViewId", str);
        this.a.put("isInReload", u);
    }

    public void n() {
        this.a = null;
        this.b = null;
        this.c = null;
        f5690i = null;
    }

    public String p() {
        return this.f5692e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(String str, JSONObject jSONObject, String str2, String str3) {
        if (this.b == null) {
            f.a aVar = f.s;
            d.e.d.a.a aVar2 = new d.e.d.a.a();
            aVar2.a("generalmessage", "mDelegate is null");
            d.e.d.a.d.d(aVar, aVar2.b());
            return;
        }
        q().post(new a(str, str3, str2, jSONObject));
    }

    public void s(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("method");
            if (!TextUtils.isEmpty(optString) && H(optString)) {
                if (optString.equalsIgnoreCase("handleGetViewVisibility")) {
                    z(jSONObject);
                }
            } else {
                C("containerSendMessage", jSONObject);
            }
        } catch (JSONException e2) {
            String str2 = this.f5693f;
            Log.e(str2, "ISNAdViewLogic | receiveMessageFromExternal | Error while trying handle message: " + str);
            e2.printStackTrace();
        }
    }

    public void w() {
        if (this.b == null || this.c == null) {
            return;
        }
        C("containerWasRemoved", k());
    }

    public void x(String str, String str2) {
        com.ironsource.sdk.ISNAdView.a aVar = this.b;
        if (aVar != null) {
            aVar.b(str, str2, this.f5692e);
        }
    }
}
