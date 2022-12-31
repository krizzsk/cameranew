package com.tapjoy;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyErrorMessage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TJWebViewJSInterface {
    WebView a;
    TJWebViewJSInterfaceListener b;
    private final ConcurrentLinkedQueue c = new ConcurrentLinkedQueue();

    /* renamed from: d  reason: collision with root package name */
    private boolean f7258d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(19)
    /* loaded from: classes3.dex */
    public class a extends AsyncTask {
        WebView a;

        public a(WebView webView) {
            this.a = webView;
        }

        @Override // android.os.AsyncTask
        protected final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
            return ((String[]) objArr)[0];
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            if (this.a != null) {
                if (str.startsWith("javascript:") && Build.VERSION.SDK_INT >= 19) {
                    try {
                        this.a.evaluateJavascript(str.replaceFirst("javascript:", ""), null);
                        return;
                    } catch (Exception e2) {
                        TapjoyErrorMessage.ErrorType errorType = TapjoyErrorMessage.ErrorType.INTERNAL_ERROR;
                        TapjoyLog.e("TJWebViewJSInterface", new TapjoyErrorMessage(errorType, "Exception in evaluateJavascript. Device not supported. " + e2.toString()));
                        return;
                    }
                }
                try {
                    WebView webView = this.a;
                    webView.loadUrl(str);
                    VdsAgent.loadUrl(webView, str);
                } catch (Exception e3) {
                    TapjoyErrorMessage.ErrorType errorType2 = TapjoyErrorMessage.ErrorType.INTERNAL_ERROR;
                    TapjoyLog.e("TJWebViewJSInterface", new TapjoyErrorMessage(errorType2, "Exception in loadUrl. Device not supported. " + e3.toString()));
                }
            }
        }
    }

    public TJWebViewJSInterface(WebView webView, TJWebViewJSInterfaceListener tJWebViewJSInterfaceListener) {
        this.a = webView;
        this.b = tJWebViewJSInterfaceListener;
    }

    public void callback(ArrayList arrayList, String str, String str2) {
        try {
            callbackToJavaScript(new JSONArray((Collection) arrayList), str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void callbackToJavaScript(Object obj, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TJAdUnitConstants.String.ARGUMENTS, obj);
            if (str != null && str.length() > 0) {
                jSONObject.put("method", str);
            }
            JSONObject jSONObject2 = new JSONObject();
            if (str2 != null && str2.length() > 0) {
                jSONObject2.put(TJAdUnitConstants.String.CALLBACK_ID, str2);
            }
            jSONObject2.put("data", jSONObject);
            String str3 = "javascript:if(window.AndroidWebViewJavascriptBridge) AndroidWebViewJavascriptBridge._handleMessageFromAndroid('" + jSONObject2 + "');";
            if (!this.f7258d) {
                this.c.add(str3);
            } else {
                new a(this.a).execute(str3);
            }
        } catch (Exception e2) {
            TapjoyLog.e("TJWebViewJSInterface", "Exception in callback to JS: " + e2.toString());
            e2.printStackTrace();
        }
    }

    @JavascriptInterface
    public void dispatchMethod(String str) {
        TapjoyLog.d("TJWebViewJSInterface", "dispatchMethod params: " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getJSONObject("data").getString("method");
            TapjoyLog.d("TJWebViewJSInterface", "method: " + string);
            TJWebViewJSInterfaceListener tJWebViewJSInterfaceListener = this.b;
            if (tJWebViewJSInterfaceListener != null) {
                tJWebViewJSInterfaceListener.onDispatchMethod(string, jSONObject);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void flushMessageQueue() {
        if (this.f7258d) {
            return;
        }
        while (true) {
            String str = (String) this.c.poll();
            if (str != null) {
                new a(this.a).execute(str);
            } else {
                this.f7258d = true;
                return;
            }
        }
    }

    public void callback(Map map, String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject(map));
            callbackToJavaScript(jSONArray, str, str2);
        } catch (Exception e2) {
            TapjoyLog.e("TJWebViewJSInterface", "Exception in callback to JS: " + e2.toString());
            e2.printStackTrace();
        }
    }
}
