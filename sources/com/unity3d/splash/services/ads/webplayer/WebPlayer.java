package com.unity3d.splash.services.ads.webplayer;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.unity3d.splash.services.core.log.DeviceLog;
import com.unity3d.splash.services.core.webview.WebViewApp;
import com.unity3d.splash.services.core.webview.WebViewEventCategory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class WebPlayer extends WebView {
    private Map a;
    private JSONObject b;
    private String c;

    @TargetApi(21)
    /* loaded from: classes3.dex */
    private class WebPlayerChromeClient extends WebChromeClient {
        private WebPlayerChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
            if (WebPlayer.this.m("onCloseWindow")) {
                super.onCloseWindow(webView);
            }
            if (WebPlayer.this.n("onCloseWindow")) {
                WebViewApp.e().k(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.CLOSE_WINDOW, WebPlayer.this.c);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            Boolean bool = Boolean.FALSE;
            if (WebPlayer.this.m("onConsoleMessage")) {
                bool = Boolean.valueOf(super.onConsoleMessage(consoleMessage));
            }
            if (WebPlayer.this.n("onConsoleMessage")) {
                WebViewApp.e().k(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.CONSOLE_MESSAGE, consoleMessage != null ? consoleMessage.message() : "", WebPlayer.this.c);
            }
            if (WebPlayer.this.k("onConsoleMessage")) {
                bool = (Boolean) WebPlayer.this.h("onConsoleMessage", Boolean.class, Boolean.TRUE);
            }
            return bool.booleanValue();
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            Boolean bool = Boolean.FALSE;
            Boolean valueOf = WebPlayer.this.m("onCreateWindow") ? Boolean.valueOf(super.onCreateWindow(webView, z, z2, message)) : bool;
            if (WebPlayer.this.n("onCreateWindow")) {
                WebViewApp.e().k(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.CREATE_WINDOW, Boolean.valueOf(z), Boolean.valueOf(z2), message, WebPlayer.this.c);
            }
            if (WebPlayer.this.k("onCreateWindow")) {
                valueOf = (Boolean) WebPlayer.this.h("onCreateWindow", Boolean.class, bool);
            }
            return valueOf.booleanValue();
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            if (WebPlayer.this.m("onGeolocationPermissionsShowPrompt")) {
                super.onGeolocationPermissionsShowPrompt(str, callback);
            }
            if (WebPlayer.this.n("onGeolocationPermissionsShowPrompt")) {
                WebViewApp.e().k(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.GEOLOCATION_PERMISSIONS_SHOW, str, WebPlayer.this.c);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            if (WebPlayer.this.m("onHideCustomView")) {
                super.onHideCustomView();
            }
            if (WebPlayer.this.n("onHideCustomView")) {
                WebViewApp.e().k(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.HIDE_CUSTOM_VIEW, WebPlayer.this.c);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            Boolean bool = Boolean.FALSE;
            if (WebPlayer.this.m("onJsAlert")) {
                bool = Boolean.valueOf(super.onJsAlert(webView, str, str2, jsResult));
            }
            if (WebPlayer.this.n("onJsAlert")) {
                WebViewApp.e().k(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.JS_ALERT, str, str2, jsResult, WebPlayer.this.c);
            }
            if (WebPlayer.this.k("onJsAlert")) {
                bool = (Boolean) WebPlayer.this.h("onJsAlert", Boolean.class, Boolean.TRUE);
            }
            return bool.booleanValue();
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            Boolean bool = Boolean.FALSE;
            if (WebPlayer.this.m("onJsConfirm")) {
                bool = Boolean.valueOf(super.onJsConfirm(webView, str, str2, jsResult));
            }
            if (WebPlayer.this.n("onJsConfirm")) {
                WebViewApp.e().k(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.JS_CONFIRM, str, str2, WebPlayer.this.c);
            }
            if (WebPlayer.this.k("onJsConfirm")) {
                bool = (Boolean) WebPlayer.this.h("onJsConfirm", Boolean.class, Boolean.TRUE);
            }
            return bool.booleanValue();
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            Boolean bool = Boolean.FALSE;
            if (WebPlayer.this.m("onJsPrompt")) {
                bool = Boolean.valueOf(super.onJsPrompt(webView, str, str2, str3, jsPromptResult));
            }
            if (WebPlayer.this.n("onJsPrompt")) {
                WebViewApp.e().k(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.JS_PROMPT, str, str2, str3, WebPlayer.this.c);
            }
            if (WebPlayer.this.k("onJsPrompt")) {
                bool = (Boolean) WebPlayer.this.h("onJsPrompt", Boolean.class, Boolean.TRUE);
            }
            return bool.booleanValue();
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            if (WebPlayer.this.m("onPermissionRequest")) {
                super.onPermissionRequest(permissionRequest);
            }
            if (WebPlayer.this.n("onPermissionRequest")) {
                WebViewApp.e().k(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PERMISSION_REQUEST, (permissionRequest == null || permissionRequest.getOrigin() == null) ? "" : permissionRequest.getOrigin().toString(), WebPlayer.this.c);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            VdsAgent.onProgressChangedStart(webView, i2);
            if (WebPlayer.this.m("onProgressChanged")) {
                super.onProgressChanged(webView, i2);
            }
            if (WebPlayer.this.n("onProgressChanged")) {
                WebViewApp.e().k(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.PROGRESS_CHANGED, Integer.valueOf(i2), WebPlayer.this.c);
            }
            VdsAgent.onProgressChangedEnd(webView, i2);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            if (WebPlayer.this.m("onReceivedIcon")) {
                super.onReceivedIcon(webView, bitmap);
            }
            if (WebPlayer.this.n("onReceivedIcon")) {
                WebViewApp.e().k(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.RECEIVED_ICON, WebPlayer.this.c);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (WebPlayer.this.m("onReceivedTitle")) {
                super.onReceivedTitle(webView, str);
            }
            if (WebPlayer.this.n("onReceivedTitle")) {
                WebViewApp.e().k(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.RECEIVED_TITLE, str, WebPlayer.this.c);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
            if (WebPlayer.this.m("onReceivedTouchIconUrl")) {
                super.onReceivedTouchIconUrl(webView, str, z);
            }
            if (WebPlayer.this.n("onReceivedTouchIconUrl")) {
                WebViewApp.e().k(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.RECEIVED_TOUCH_ICON_URL, str, Boolean.valueOf(z), WebPlayer.this.c);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onRequestFocus(WebView webView) {
            if (WebPlayer.this.m("onRequestFocus")) {
                super.onRequestFocus(webView);
            }
            if (WebPlayer.this.n("onRequestFocus")) {
                WebViewApp.e().k(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.REQUEST_FOCUS, WebPlayer.this.c);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            if (WebPlayer.this.m("onShowCustomView")) {
                super.onShowCustomView(view, customViewCallback);
            }
            if (WebPlayer.this.n("onShowCustomView")) {
                WebViewApp.e().k(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOW_CUSTOM_VIEW, WebPlayer.this.c);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            Boolean bool = Boolean.FALSE;
            if (WebPlayer.this.m("onShowFileChooser")) {
                bool = Boolean.valueOf(super.onShowFileChooser(webView, valueCallback, fileChooserParams));
            }
            if (WebPlayer.this.n("onShowFileChooser")) {
                WebViewApp.e().k(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.SHOW_FILE_CHOOSER, WebPlayer.this.c);
            }
            if (WebPlayer.this.k("onShowFileChooser")) {
                bool = (Boolean) WebPlayer.this.h("onShowFileChooser", Boolean.class, Boolean.TRUE);
                if (bool.booleanValue()) {
                    valueCallback.onReceiveValue(null);
                }
            }
            return bool.booleanValue();
        }
    }

    private void f(String str, String str2) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object h(String str, Class cls, Object obj) {
        try {
            JSONObject jSONObject = this.b;
            if (jSONObject != null && jSONObject.has(str) && this.b.getJSONObject(str).has("returnValue")) {
                return cls.cast(this.b.getJSONObject(str).get("returnValue"));
            }
        } catch (Exception e2) {
            DeviceLog.g("Error getting default return value", e2);
        }
        return obj;
    }

    private Class[] i(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        Class[] clsArr = new Class[jSONArray.length()];
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (jSONArray.get(i2) instanceof JSONObject) {
                    Class<?> cls = Class.forName(((JSONObject) jSONArray.get(i2)).getString("className"));
                    if (cls != null) {
                        clsArr[i2] = cls;
                    }
                } else {
                    clsArr[i2] = g(jSONArray.get(i2).getClass());
                }
            }
        }
        return clsArr;
    }

    private Object[] j(JSONArray jSONArray) {
        Class<?> cls;
        if (jSONArray == null) {
            return null;
        }
        Object[] objArr = new Object[jSONArray.length()];
        Object[] objArr2 = new Object[jSONArray.length()];
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (jSONArray.get(i2) instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                Object obj = jSONObject.get(FirebaseAnalytics.Param.VALUE);
                String string = jSONObject.getString("type");
                String string2 = jSONObject.has("className") ? jSONObject.getString("className") : null;
                if (string2 != null && string.equals("Enum") && (cls = Class.forName(string2)) != null) {
                    objArr2[i2] = Enum.valueOf(cls, (String) obj);
                }
            } else {
                objArr2[i2] = jSONArray.get(i2);
            }
        }
        if (jSONArray != null) {
            System.arraycopy(objArr2, 0, objArr, 0, jSONArray.length());
        }
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(String str) {
        try {
            JSONObject jSONObject = this.b;
            if (jSONObject == null || !jSONObject.has(str)) {
                return false;
            }
            return this.b.getJSONObject(str).has("returnValue");
        } catch (Exception e2) {
            DeviceLog.g("Error getting default return value", e2);
            return false;
        }
    }

    private Object l(Object obj, JSONObject jSONObject) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(next);
                    obj.getClass().getMethod(next, i(jSONArray)).invoke(obj, j(jSONArray));
                } catch (Exception e2) {
                    f(next, e2.getMessage());
                    DeviceLog.g("Setting errored", e2);
                }
            }
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(String str) {
        try {
            JSONObject jSONObject = this.b;
            if (jSONObject != null && jSONObject.has(str) && this.b.getJSONObject(str).has("callSuper")) {
                return this.b.getJSONObject(str).getBoolean("callSuper");
            }
            return true;
        } catch (Exception e2) {
            DeviceLog.g("Error getting super call status", e2);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(String str) {
        try {
            JSONObject jSONObject = this.b;
            if (jSONObject != null && jSONObject.has(str) && this.b.getJSONObject(str).has("sendEvent")) {
                return this.b.getJSONObject(str).getBoolean("sendEvent");
            }
            return false;
        } catch (Exception e2) {
            DeviceLog.g("Error getting send event status", e2);
            return false;
        }
    }

    public Class g(Class cls) {
        String name = cls.getName();
        return name.equals("java.lang.Byte") ? Byte.TYPE : name.equals("java.lang.Short") ? Short.TYPE : name.equals("java.lang.Integer") ? Integer.TYPE : name.equals("java.lang.Long") ? Long.TYPE : name.equals("java.lang.Character") ? Character.TYPE : name.equals("java.lang.Float") ? Float.TYPE : name.equals("java.lang.Double") ? Double.TYPE : name.equals("java.lang.Boolean") ? Boolean.TYPE : name.equals("java.lang.Void") ? Void.TYPE : cls;
    }

    public void setEventSettings(JSONObject jSONObject) {
        this.b = jSONObject;
    }

    public void setSettings(JSONObject jSONObject, JSONObject jSONObject2) {
        Map map = this.a;
        if (map != null) {
            map.clear();
        }
        l(getSettings(), jSONObject);
        l(this, jSONObject2);
    }
}
