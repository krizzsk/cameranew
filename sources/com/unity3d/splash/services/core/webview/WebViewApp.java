package com.unity3d.splash.services.core.webview;

import android.os.Build;
import android.os.ConditionVariable;
import android.os.Looper;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebViewClient;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.unity3d.splash.services.core.log.DeviceLog;
import com.unity3d.splash.services.core.webview.bridge.CallbackStatus;
import com.unity3d.splash.services.core.webview.bridge.c;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* loaded from: classes3.dex */
public class WebViewApp extends WebViewClient {

    /* renamed from: e  reason: collision with root package name */
    private static WebViewApp f8475e;

    /* renamed from: f  reason: collision with root package name */
    private static ConditionVariable f8476f;
    private boolean a;
    private WebView b;
    private com.unity3d.splash.services.core.configuration.a c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f8477d;

    /* loaded from: classes3.dex */
    private class WebAppChromeClient extends WebChromeClient {
        private WebAppChromeClient() {
        }

        /* synthetic */ WebAppChromeClient(WebViewApp webViewApp, a aVar) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public void onConsoleMessage(String str, int i2, String str2) {
            File file;
            try {
                file = new File(str2);
            } catch (Exception e2) {
                DeviceLog.g("Could not handle sourceId", e2);
                file = null;
            }
            if (file != null) {
                str2 = file.getName();
            }
            if (Build.VERSION.SDK_INT < 19) {
                DeviceLog.c("JavaScript (sourceId=" + str2 + ", line=" + i2 + "): " + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        final /* synthetic */ com.unity3d.splash.services.core.configuration.a a;

        a(com.unity3d.splash.services.core.configuration.a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                WebViewApp webViewApp = new WebViewApp(this.a, null);
                String str = "?platform=android";
                try {
                    if (this.a.g() != null) {
                        str = "?platform=android&origin=" + URLEncoder.encode(this.a.g(), "UTF-8");
                    }
                } catch (UnsupportedEncodingException e2) {
                    DeviceLog.g("Unsupported charset when encoding origin url", e2);
                }
                try {
                    if (this.a.h() != null) {
                        str = str + "&version=" + URLEncoder.encode(this.a.h(), "UTF-8");
                    }
                } catch (UnsupportedEncodingException e3) {
                    DeviceLog.g("Unsupported charset when encoding webview version", e3);
                }
                WebView f2 = webViewApp.f();
                String str2 = InspirePublishFragment.FILE_HEADER + com.unity3d.splash.services.c.b.b.g() + str;
                String e4 = this.a.e();
                f2.loadDataWithBaseURL(str2, e4, "text/html", "UTF-8", null);
                VdsAgent.loadDataWithBaseURL(f2, str2, e4, "text/html", "UTF-8", null);
                WebViewApp.m(webViewApp);
            } catch (Exception unused) {
                DeviceLog.f("Couldn't construct WebViewApp");
                WebViewApp.f8476f.open();
            }
        }
    }

    /* loaded from: classes3.dex */
    private class b extends WebViewClient {
        private b(WebViewApp webViewApp) {
        }

        /* synthetic */ b(WebViewApp webViewApp, a aVar) {
            this(webViewApp);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView webView, String str) {
            super.onPageFinished(webView, str);
            DeviceLog.c("onPageFinished url: " + str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(android.webkit.WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (webView != null) {
                DeviceLog.f("WEBVIEW_ERROR: " + webView.toString());
            }
            if (webResourceRequest != null) {
                DeviceLog.f("WEBVIEW_ERROR: " + webResourceRequest.toString());
            }
            if (webResourceError != null) {
                DeviceLog.f("WEBVIEW_ERROR: " + webResourceError.toString());
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, String str) {
            DeviceLog.c("Trying to load url: " + str);
            return false;
        }
    }

    private WebViewApp(com.unity3d.splash.services.core.configuration.a aVar) {
        this.a = false;
        l(aVar);
        c.f(d().d());
        WebView webView = new WebView(com.unity3d.splash.services.c.b.a.b());
        this.b = webView;
        webView.setWebViewClient(new b(this, null));
        WebView webView2 = this.b;
        WebAppChromeClient webAppChromeClient = new WebAppChromeClient(this, null);
        webView2.setWebChromeClient(webAppChromeClient);
        VdsAgent.setWebChromeClient(webView2, webAppChromeClient);
    }

    /* synthetic */ WebViewApp(com.unity3d.splash.services.core.configuration.a aVar, a aVar2) {
        this(aVar);
    }

    public static boolean b(com.unity3d.splash.services.core.configuration.a aVar) {
        DeviceLog.e();
        if (Thread.currentThread().equals(Looper.getMainLooper().getThread())) {
            throw new IllegalThreadStateException("Cannot call create() from main thread!");
        }
        com.unity3d.splash.services.c.a.b.d(new a(aVar));
        ConditionVariable conditionVariable = new ConditionVariable();
        f8476f = conditionVariable;
        return conditionVariable.block(60000L) && e() != null;
    }

    public static WebViewApp e() {
        return f8475e;
    }

    private void h(String str, String str2, JSONArray jSONArray) {
        String jSONArray2 = jSONArray.toString();
        StringBuilder sb = new StringBuilder(str.length() + 22 + str2.length() + jSONArray2.length());
        sb.append("javascript:window.");
        sb.append(str);
        sb.append(".");
        sb.append(str2);
        sb.append("(");
        sb.append(jSONArray2);
        sb.append(");");
        String sb2 = sb.toString();
        DeviceLog.c("Invoking javascript: " + sb2);
        f().b(sb2);
    }

    public static void m(WebViewApp webViewApp) {
        f8475e = webViewApp;
    }

    public com.unity3d.splash.services.core.webview.bridge.b c(String str) {
        com.unity3d.splash.services.core.webview.bridge.b bVar;
        synchronized (this.f8477d) {
            bVar = (com.unity3d.splash.services.core.webview.bridge.b) this.f8477d.get(str);
        }
        return bVar;
    }

    public com.unity3d.splash.services.core.configuration.a d() {
        return this.c;
    }

    public WebView f() {
        return this.b;
    }

    public boolean g(com.unity3d.splash.services.core.webview.bridge.a aVar) {
        if (!i()) {
            DeviceLog.c("invokeBatchCallback ignored because web app is not loaded");
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        ArrayList d2 = aVar.d();
        if (d2 != null && !d2.isEmpty()) {
            Iterator it = d2.iterator();
            while (it.hasNext()) {
                ArrayList arrayList = (ArrayList) it.next();
                Enum r5 = (Enum) arrayList.get(1);
                Object[] objArr = (Object[]) arrayList.get(2);
                Object[] copyOfRange = Arrays.copyOfRange(objArr, 1, objArr.length);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add((String) objArr[0]);
                arrayList2.add(((CallbackStatus) arrayList.get(0)).toString());
                JSONArray jSONArray2 = new JSONArray();
                if (r5 != null) {
                    jSONArray2.put(r5.name());
                }
                for (Object obj : copyOfRange) {
                    jSONArray2.put(obj);
                }
                arrayList2.add(jSONArray2);
                JSONArray jSONArray3 = new JSONArray();
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    jSONArray3.put(it2.next());
                }
                jSONArray.put(jSONArray3);
            }
        }
        try {
            h("nativebridge", "handleCallback", jSONArray);
        } catch (Exception e2) {
            DeviceLog.g("Error while invoking batch response for WebView", e2);
        }
        return true;
    }

    public boolean i() {
        return this.a;
    }

    public void j(com.unity3d.splash.services.core.webview.bridge.b bVar) {
        HashMap hashMap = this.f8477d;
        if (hashMap == null) {
            return;
        }
        synchronized (hashMap) {
            this.f8477d.remove(bVar.a());
        }
    }

    public boolean k(Enum r4, Enum r5, Object... objArr) {
        if (!i()) {
            DeviceLog.c("sendEvent ignored because web app is not loaded");
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(r4.name());
        jSONArray.put(r5.name());
        for (Object obj : objArr) {
            jSONArray.put(obj);
        }
        try {
            h("nativebridge", "handleEvent", jSONArray);
            return true;
        } catch (Exception e2) {
            DeviceLog.g("Error while sending event to WebView", e2);
            return false;
        }
    }

    public void l(com.unity3d.splash.services.core.configuration.a aVar) {
        this.c = aVar;
    }

    public void n(boolean z) {
        f8476f.open();
    }

    public void o(boolean z) {
        this.a = z;
    }

    public void p(WebView webView) {
        this.b = webView;
    }
}
