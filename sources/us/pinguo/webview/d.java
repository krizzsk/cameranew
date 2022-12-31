package us.pinguo.webview;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* compiled from: PGWebViewClient.java */
/* loaded from: classes6.dex */
public class d extends WebViewClient {
    private WeakReference<PGJsWebView> a;

    public d(PGJsWebView pGJsWebView) {
        this.a = null;
        this.a = new WeakReference<>(pGJsWebView);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        PGJsWebView pGJsWebView = this.a.get();
        if (pGJsWebView == null || pGJsWebView.g() == null) {
            return;
        }
        pGJsWebView.i("    try {\n         if (typeof(pinguoJSShare) == \"function\") {\n                window.NativeShare.pinguoJsCanShare(true);\n         } else {\n     \t    window.NativeShare.pinguoJsCanShare(false);\n         }\n     } catch (e) {\n     \twindow.NativeShare.pinguoJsCanShare(false);\n     }", 1000);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        String str2;
        if (str.startsWith(c.d())) {
            String j2 = b.j();
            if (j2 == null) {
                return null;
            }
            String path = Uri.parse(str).getPath();
            if (path.contains("..")) {
                return super.shouldInterceptRequest(webView, str);
            }
            if (path.charAt(0) == '/') {
                str2 = j2 + path;
            } else {
                str2 = j2 + File.separator + path;
            }
            try {
                return new WebResourceResponse("application/javascript", "UTF8", new FileInputStream(str2));
            } catch (IOException e2) {
                us.pinguo.common.log.a.f(e2);
                return null;
            }
        }
        return super.shouldInterceptRequest(webView, str);
    }
}
