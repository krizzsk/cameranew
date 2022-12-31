package d.d.a.a.a.d;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.VisibleForTesting;
import com.growingio.android.sdk.autoburry.VdsAgent;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private static e a = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ WebView a;
        final /* synthetic */ String b;

        a(e eVar, WebView webView, String str) {
            this.a = webView;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView webView = this.a;
            String str = this.b;
            webView.loadUrl(str);
            VdsAgent.loadUrl(webView, str);
        }
    }

    private e() {
    }

    public static e a() {
        return a;
    }

    public void b(WebView webView) {
        f(webView, "finishSession", new Object[0]);
    }

    public void c(WebView webView, float f2) {
        f(webView, "setDeviceVolume", Float.valueOf(f2));
    }

    public void d(WebView webView, String str, String str2) {
        if (str == null || TextUtils.isEmpty(str2)) {
            return;
        }
        j(webView, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};this.omidVerificationProperties.injectionId = '%INJECTION_ID%';var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", str).replace("%INJECTION_ID%", str2));
    }

    public void e(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        f(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    @VisibleForTesting
    void f(WebView webView, String str, Object... objArr) {
        if (webView == null) {
            d.d.a.a.a.g.c.a("The WebView is null for " + str);
            return;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
        sb.append(str);
        sb.append("(");
        i(sb, objArr);
        sb.append(")}");
        g(webView, sb);
    }

    @VisibleForTesting
    void g(WebView webView, StringBuilder sb) {
        String sb2 = sb.toString();
        Handler handler = webView.getHandler();
        if (handler != null && Looper.myLooper() != handler.getLooper()) {
            handler.post(new a(this, webView, sb2));
            return;
        }
        webView.loadUrl(sb2);
        VdsAgent.loadUrl(webView, sb2);
    }

    public void h(WebView webView, JSONObject jSONObject) {
        f(webView, "init", jSONObject);
    }

    @VisibleForTesting
    void i(StringBuilder sb, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return;
        }
        for (Object obj : objArr) {
            if (obj == null) {
                sb.append('\"');
            } else {
                if (obj instanceof String) {
                    String obj2 = obj.toString();
                    if (obj2.startsWith("{")) {
                        sb.append(obj2);
                    } else {
                        sb.append('\"');
                        sb.append(obj2);
                    }
                } else {
                    sb.append(obj);
                }
                sb.append(",");
            }
            sb.append('\"');
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
    }

    public boolean j(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = "javascript: " + str;
        webView.loadUrl(str2);
        VdsAgent.loadUrl(webView, str2);
        return true;
    }

    public void k(WebView webView) {
        f(webView, "publishImpressionEvent", new Object[0]);
    }

    public void l(WebView webView, String str) {
        f(webView, "setNativeViewHierarchy", str);
    }

    public void m(WebView webView) {
        f(webView, "publishLoadedEvent", new Object[0]);
    }

    public void n(WebView webView, String str) {
        f(webView, "setState", str);
    }
}
