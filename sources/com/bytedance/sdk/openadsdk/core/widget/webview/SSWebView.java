package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.lang.reflect.Method;
import java.util.Map;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* loaded from: classes.dex */
public class SSWebView extends WebView {
    public SSWebView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        b(context);
    }

    private static void b(Context context) {
        if (Build.VERSION.SDK_INT != 17 || context == null) {
            return;
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("setState", Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(accessibilityManager, 0);
            }
        } catch (Throwable unused) {
        }
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
        String url;
        try {
            String originalUrl = super.getOriginalUrl();
            return (originalUrl == null || !originalUrl.startsWith("data:text/html") || (url = super.getUrl()) == null) ? originalUrl : url.startsWith(InspirePublishFragment.FILE_HEADER) ? url : originalUrl;
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
    @TargetApi(19)
    public void loadUrl(String str, Map<String, String> map) {
        try {
            super.loadUrl(str, map);
            VdsAgent.loadUrl(this, str, map);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Throwable unused) {
            return false;
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

    @Override // android.webkit.WebView, android.view.View
    public void setLayerType(int i2, Paint paint) {
        try {
            super.setLayerType(i2, paint);
        } catch (Throwable unused) {
        }
    }

    @Override // android.webkit.WebView
    public void setNetworkAvailable(boolean z) {
        try {
            super.setNetworkAvailable(z);
        } catch (Exception unused) {
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void setOverScrollMode(int i2) {
        try {
            super.setOverScrollMode(i2);
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

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        try {
            super.loadUrl(str);
            VdsAgent.loadUrl(this, str);
        } catch (Exception unused) {
        }
    }

    public SSWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public SSWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }
}
