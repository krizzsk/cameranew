package com.unity3d.splash.services.core.webview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.unity3d.splash.services.c.a.b;
import com.unity3d.splash.services.c.a.c;
import com.unity3d.splash.services.core.log.DeviceLog;
import com.unity3d.splash.services.core.webview.bridge.d;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class WebView extends android.webkit.WebView {
    private static Method a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        private String a;
        private android.webkit.WebView b;

        public a(String str, android.webkit.WebView webView) {
            this.a = null;
            this.b = null;
            this.a = str;
            this.b = webView;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.a;
            if (str == null) {
                DeviceLog.f("Could not process JavaScript, the string is NULL");
                return;
            }
            try {
                if (Build.VERSION.SDK_INT >= 19) {
                    WebView.a.invoke(this.b, this.a, null);
                } else {
                    WebView.this.loadUrl(str);
                }
            } catch (Exception e2) {
                DeviceLog.g("Error while processing JavaScriptString", e2);
            }
        }
    }

    public WebView(Context context) {
        super(context);
        WebSettings settings = getSettings();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 16) {
            settings.setAllowFileAccessFromFileURLs(true);
            settings.setAllowUniversalAccessFromFileURLs(true);
        }
        if (i2 >= 19) {
            try {
                a = android.webkit.WebView.class.getMethod("evaluateJavascript", String.class, ValueCallback.class);
            } catch (NoSuchMethodException e2) {
                DeviceLog.g("Method evaluateJavascript not found", e2);
                a = null;
            }
        }
        settings.setAppCacheEnabled(false);
        settings.setBlockNetworkImage(false);
        settings.setBlockNetworkLoads(false);
        settings.setBuiltInZoomControls(false);
        settings.setCacheMode(2);
        settings.setDatabaseEnabled(false);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 11) {
            settings.setDisplayZoomControls(false);
        }
        settings.setDomStorageEnabled(false);
        if (i3 >= 11) {
            settings.setEnableSmoothTransition(false);
        }
        settings.setGeolocationEnabled(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(false);
        settings.setJavaScriptEnabled(true);
        settings.setLightTouchEnabled(false);
        settings.setLoadWithOverviewMode(false);
        settings.setLoadsImagesAutomatically(true);
        if (i3 >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        if (i3 >= 21) {
            settings.setMixedContentMode(1);
        }
        settings.setNeedInitialFocus(true);
        settings.setPluginState(WebSettings.PluginState.OFF);
        settings.setRenderPriority(WebSettings.RenderPriority.NORMAL);
        settings.setSaveFormData(false);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(false);
        settings.setSupportZoom(false);
        settings.setUseWideViewPort(true);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setInitialScale(0);
        setBackgroundColor(0);
        c.b(this, new ColorDrawable(0));
        setBackgroundResource(0);
        addJavascriptInterface(new d(), "webviewbridge");
    }

    public void b(String str) {
        b.d(new a(str, this));
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        DeviceLog.c("Loading url: " + str);
        super.loadUrl(str);
        VdsAgent.loadUrl(this, str);
    }
}
