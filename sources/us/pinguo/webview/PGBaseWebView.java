package us.pinguo.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Map;
/* loaded from: classes6.dex */
public class PGBaseWebView extends WebView {
    public PGBaseWebView(Context context) {
        super(context);
    }

    @Override // android.webkit.WebView
    public boolean canGoBack() {
        try {
            return super.canGoBack();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.webkit.WebView
    public boolean canGoBackOrForward(int i2) {
        try {
            return super.canGoBackOrForward(i2);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.webkit.WebView
    public boolean canGoForward() {
        try {
            return super.canGoForward();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.webkit.WebView
    public void clearCache(boolean z) {
        try {
            super.clearCache(z);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void clearFormData() {
        try {
            super.clearFormData();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void clearHistory() {
        try {
            super.clearHistory();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void computeScroll() {
        try {
            super.computeScroll();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public int getContentHeight() {
        try {
            return super.getContentHeight();
        } catch (Exception unused) {
            return 1;
        }
    }

    @Override // android.webkit.WebView
    public String getOriginalUrl() {
        try {
            return super.getOriginalUrl();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.webkit.WebView
    public int getProgress() {
        try {
            return super.getProgress();
        } catch (Exception unused) {
            return 100;
        }
    }

    @Override // android.webkit.WebView
    public String getUrl() {
        try {
            return super.getUrl();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.webkit.WebView
    public void goBack() {
        try {
            super.goBack();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void goBackOrForward(int i2) {
        try {
            super.goBackOrForward(i2);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void goForward() {
        try {
            super.goForward();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void loadData(String str, String str2, String str3) {
        try {
            super.loadData(str, str2, str3);
            VdsAgent.loadData(this, str, str2, str3);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        try {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            VdsAgent.loadDataWithBaseURL(this, str, str2, str3, str4, str5);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        try {
            super.loadUrl(str, map);
            VdsAgent.loadUrl(this, str, map);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void postUrl(String str, byte[] bArr) {
        try {
            super.postUrl(str, bArr);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void reload() {
        try {
            super.reload();
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void setBackgroundColor(int i2) {
        try {
            super.setBackgroundColor(i2);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void setDownloadListener(DownloadListener downloadListener) {
        try {
            super.setDownloadListener(downloadListener);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void setNetworkAvailable(boolean z) {
        try {
            super.setNetworkAvailable(z);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        try {
            super.setWebChromeClient(webChromeClient);
            VdsAgent.setWebChromeClient(this, webChromeClient);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        try {
            super.setWebViewClient(webViewClient);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        try {
            super.stopLoading();
        } catch (Exception unused) {
        }
    }

    public PGBaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        try {
            super.loadUrl(str);
            VdsAgent.loadUrl(this, str);
        } catch (Exception unused) {
        }
    }

    public PGBaseWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
