package com.growingio.android.sdk.circle.webcircle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.VisibleForTesting;
import com.growingio.android.sdk.autoburry.events.InjectJsEvent;
import com.growingio.android.sdk.autoburry.events.WebCircleHybridReturnEvent;
import com.growingio.android.sdk.base.event.CircleEvent;
import com.growingio.android.sdk.base.event.HttpCallBack;
import com.growingio.android.sdk.base.event.HttpEvent;
import com.growingio.android.sdk.base.event.SocketEvent;
import com.growingio.android.sdk.base.event.SocketStatusEvent;
import com.growingio.android.sdk.base.event.ViewTreeStatusChangeEvent;
import com.growingio.android.sdk.base.event.net.NetWorkChangedEvent;
import com.growingio.android.sdk.circle.CircleManager;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.growingio.android.sdk.debugger.AbstractSocketAdapter;
import com.growingio.android.sdk.debugger.DebuggerManager;
import com.growingio.android.sdk.debugger.view.CircleTipView;
import com.growingio.android.sdk.debugger.view.WebCircleTipView;
import com.growingio.android.sdk.java_websocket.GioProtocol;
import com.growingio.android.sdk.java_websocket.WebCircleSocketMain;
import com.growingio.android.sdk.utils.ActivityUtil;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.NetworkUtil;
import com.growingio.android.sdk.utils.ObjectUtils;
import com.growingio.android.sdk.utils.ScreenshotHelper;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.android.sdk.utils.WeakSet;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.EventCenter;
import com.growingio.eventcenter.bus.SubscriberMethod;
import com.growingio.eventcenter.bus.ThreadMode;
import com.growingio.eventcenter.bus.meta.Subscriber;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class WebCircleMain extends AbstractSocketAdapter implements Subscriber {
    private static final String TAG = "GIO.WebCircleMain";
    private WeakReference<View> currentWebView;
    private WeakSet<View> injectJsWebViews;
    private String pairKey;
    private Runnable timeoutRunnable;
    private String wsUrl;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class TargetWebView {
        int screenX;
        int screenY;
        View webView;

        public TargetWebView(View view, int i2, int i3) {
            this.webView = view;
            this.screenX = i2;
            this.screenY = i3;
        }
    }

    public WebCircleMain(DebuggerManager debuggerManager) {
        super(debuggerManager);
        this.wsUrl = null;
        this.pairKey = null;
        this.injectJsWebViews = new WeakSet<>();
        this.timeoutRunnable = new Runnable() { // from class: com.growingio.android.sdk.circle.webcircle.WebCircleMain.1
            @Override // java.lang.Runnable
            public void run() {
                LogUtil.d(WebCircleMain.TAG, "waiting for web's connection, but timeout");
                if (((AbstractSocketAdapter) WebCircleMain.this).mCircleTipView != null) {
                    ((AbstractSocketAdapter) WebCircleMain.this).mCircleTipView.setError(true);
                    ((AbstractSocketAdapter) WebCircleMain.this).mCircleTipView.setContent("电脑端连接超时，请再次扫码圈选");
                }
            }
        };
    }

    private void afterLoginAndServerStarted() {
        LogUtil.d(TAG, "after login and server started");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wsUrl", this.wsUrl);
            jSONObject.put("pairKey", this.pairKey);
        } catch (JSONException e2) {
            LogUtil.d(TAG, e2);
        }
        HttpEvent createCircleHttpEvent = HttpEvent.createCircleHttpEvent(NetworkConfig.getInstance().getMobileLinkUrl(), jSONObject, false);
        createCircleHttpEvent.setCallBack(new HttpCallBack() { // from class: com.growingio.android.sdk.circle.webcircle.WebCircleMain.2
            @Override // com.growingio.android.sdk.base.event.HttpCallBack
            public void afterRequest(Integer num, byte[] bArr, long j2, Map<String, List<String>> map) {
                String str = null;
                try {
                    if (num.intValue() == 200) {
                        str = new String(bArr);
                        if ("ok".equals(new JSONObject(str).getString("status"))) {
                            LogUtil.d(WebCircleMain.TAG, "post wsUrl to server success");
                            return;
                        }
                    }
                    LogUtil.e(WebCircleMain.TAG, "post wsUrl to server, status code not ok: " + num + ", and result: " + str);
                    ThreadUtils.runOnUiThread(new Runnable() { // from class: com.growingio.android.sdk.circle.webcircle.WebCircleMain.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((AbstractSocketAdapter) WebCircleMain.this).debuggerManager.exit();
                            Toast.makeText(((AbstractSocketAdapter) WebCircleMain.this).coreAppState.getGlobalContext(), "打开WebCircle失败， 请重新扫码连接", 1).show();
                        }
                    });
                } catch (Exception e3) {
                    LogUtil.d(WebCircleMain.TAG, e3);
                }
            }
        });
        EventCenter.getInstance().post(createCircleHttpEvent);
    }

    private boolean checkWebViewInActivity(Activity activity, View view) {
        Activity findActivity = ActivityUtil.findActivity(view.getContext());
        return findActivity == null || activity == findActivity;
    }

    private void startServer() {
        try {
            WebCircleSocketMain webCircleSocketMain = new WebCircleSocketMain();
            this.socketInterface = webCircleSocketMain;
            webCircleSocketMain.setGioProtocol(new GioProtocol());
            this.socketInterface.start();
        } catch (Exception e2) {
            LogUtil.e(TAG, e2.getMessage(), e2);
            onConnectFailed();
        }
    }

    static void transformCoordinates(JSONObject jSONObject, int i2, int i3, double d2) throws JSONException {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof Number) {
                float floatValue = ((Number) obj).floatValue();
                if ("x".equals(next)) {
                    jSONObject.put("x", ((int) (floatValue / d2)) - i2);
                } else if ("y".equals(next)) {
                    jSONObject.put("y", ((int) (floatValue / d2)) - i3);
                } else if ("ex".equals(next)) {
                    jSONObject.put("ex", ((int) (floatValue / d2)) - i2);
                } else if ("ey".equals(next)) {
                    jSONObject.put("ey", ((int) (floatValue / d2)) - i3);
                } else if ("ew".equals(next)) {
                    jSONObject.put("ew", (int) (floatValue / d2));
                } else if ("eh".equals(next)) {
                    jSONObject.put("eh", (int) (floatValue / d2));
                }
            } else if (obj instanceof JSONObject) {
                transformCoordinates((JSONObject) obj, i2, i3, d2);
            } else if (obj instanceof JSONArray) {
                transformCoordinatesJsonArray((JSONArray) obj, i2, i3, d2);
            }
        }
    }

    static void transformCoordinatesJsonArray(JSONArray jSONArray, int i2, int i3, double d2) throws JSONException {
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            Object obj = jSONArray.get(i4);
            if (obj instanceof JSONObject) {
                transformCoordinates((JSONObject) obj, i2, i3, d2);
            } else if (obj instanceof JSONArray) {
                transformCoordinatesJsonArray((JSONArray) obj, i2, i3, d2);
            }
        }
    }

    @Override // com.growingio.android.sdk.debugger.AbstractSocketAdapter
    public void addTipView(Context context) {
        this.mCircleTipView = new WebCircleTipView(context);
    }

    @TargetApi(11)
    void dealHybridMessageInCatch(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("x")) {
            int i2 = jSONObject.getInt("x");
            int i3 = jSONObject.getInt("y");
            String string = jSONObject.getString("sk");
            if (!ObjectUtils.equals(string, CircleManager.getInstance().getCurrentSnapShotKey())) {
                LogUtil.d(TAG, "dealHybridMessageInCatch, and sskey not same: ", string, CircleManager.getInstance().getCurrentSnapShotKey());
                return;
            }
            double scaledFactor = ScreenshotHelper.getScaledFactor();
            int i4 = (int) (i2 / scaledFactor);
            int i5 = (int) (i3 / scaledFactor);
            TargetWebView lookupTargetWebView = lookupTargetWebView(i4, i5);
            if (lookupTargetWebView == null) {
                LogUtil.d(TAG, "dealHybridMessageWithCatch, and not found valid webView: ", Integer.valueOf(i4), ", ", Integer.valueOf(i5));
                return;
            }
            transformCoordinates(jSONObject, lookupTargetWebView.screenX, lookupTargetWebView.screenY, scaledFactor);
            Util.callJavaScript(lookupTargetWebView.webView, "_vds_hybrid.handleWebEvent", jSONObject);
            return;
        }
        Activity foregroundActivity = this.coreAppState.getForegroundActivity();
        if (foregroundActivity == null) {
            LogUtil.d(TAG, "not found activity, return");
            return;
        }
        Iterator<View> it = this.injectJsWebViews.iterator();
        while (it.hasNext()) {
            View next = it.next();
            if (checkWebViewInActivity(foregroundActivity, next) && ViewHelper.viewVisibilityInParents(next)) {
                Util.callJavaScript(next, "_vds_hybrid.handleWebEvent", jSONObject);
            }
        }
    }

    void dealHybridReturnMessage(View view, JSONObject jSONObject) throws JSONException {
        if (view == null) {
            LogUtil.d(TAG, "dealHybridReturnMessage and found webView null, return");
        } else if (!checkWebViewInActivity(this.coreAppState.getForegroundActivity(), view)) {
            LogUtil.d(TAG, "deal with hybrid return message, but activity is not same as current activity, just return");
        } else {
            int[] iArr = new int[2];
            jSONObject.put("msgId", "hybridEvent");
            view.getLocationOnScreen(iArr);
            double scaledFactor = ScreenshotHelper.getScaledFactor();
            transformCoordinates(jSONObject, (int) ((-iArr[0]) * scaledFactor), (int) ((-iArr[1]) * scaledFactor), 1.0d / scaledFactor);
            sendMessage(jSONObject.toString());
        }
    }

    @Override // com.growingio.android.sdk.debugger.AbstractSocketAdapter, com.growingio.eventcenter.bus.meta.Subscriber
    public void do$Action(String str, Object obj) {
        if (str.equals("#onRejectJsEvent(com.growingio.android.sdk.autoburry.events.InjectJsEvent")) {
            onRejectJsEvent((InjectJsEvent) obj);
        } else if (str.equals("#onHybridEventReturn(com.growingio.android.sdk.autoburry.events.WebCircleHybridReturnEvent")) {
            onHybridEventReturn((WebCircleHybridReturnEvent) obj);
        } else if (str.equals("#onSocketEvent(com.growingio.android.sdk.base.event.SocketEvent")) {
            onSocketEvent((SocketEvent) obj);
        } else if (str.equals("#onNetChanged(com.growingio.android.sdk.base.event.net.NetWorkChangedEvent")) {
            onNetChanged((NetWorkChangedEvent) obj);
        } else if (str.equals("#onSocketStatusEvent(com.growingio.android.sdk.base.event.SocketStatusEvent")) {
            onSocketStatusEvent((SocketStatusEvent) obj);
        } else {
            System.out.println("No such method to delegate");
        }
    }

    @Override // com.growingio.android.sdk.debugger.AbstractSocketAdapter, com.growingio.eventcenter.bus.meta.Subscriber
    public SubscriberMethod[] get$SubscriberMethods() {
        ThreadMode threadMode = ThreadMode.MAIN;
        return new SubscriberMethod[]{new SubscriberMethod("onRejectJsEvent", InjectJsEvent.class, "#onRejectJsEvent(com.growingio.android.sdk.autoburry.events.InjectJsEvent", threadMode, 0, false), new SubscriberMethod("onHybridEventReturn", WebCircleHybridReturnEvent.class, "#onHybridEventReturn(com.growingio.android.sdk.autoburry.events.WebCircleHybridReturnEvent", threadMode, 0, false), new SubscriberMethod("onSocketEvent", SocketEvent.class, "#onSocketEvent(com.growingio.android.sdk.base.event.SocketEvent", ThreadMode.BACKGROUND, 0, false), new SubscriberMethod("onNetChanged", NetWorkChangedEvent.class, "#onNetChanged(com.growingio.android.sdk.base.event.net.NetWorkChangedEvent", threadMode, 0, false), new SubscriberMethod("onSocketStatusEvent", SocketStatusEvent.class, "#onSocketStatusEvent(com.growingio.android.sdk.base.event.SocketStatusEvent", threadMode, 0, false)};
    }

    @VisibleForTesting
    TargetWebView lookupTargetWebView(int i2, int i3) {
        Activity foregroundActivity = this.coreAppState.getForegroundActivity();
        if (foregroundActivity == null) {
            LogUtil.d(TAG, "currentActivity is null, and return");
            return null;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        WeakReference<View> weakReference = this.currentWebView;
        if (weakReference != null && weakReference.get() != null) {
            View view = this.currentWebView.get();
            if (checkWebViewInActivity(foregroundActivity, view)) {
                view.getLocationOnScreen(iArr);
                rect.set(0, 0, view.getWidth(), view.getHeight());
                rect.offset(iArr[0], iArr[1]);
                if (rect.contains(i2, i3)) {
                    LogUtil.d(TAG, "lookupTargetWebView, found valid webView(From cache): ", view);
                    return new TargetWebView(view, iArr[0], iArr[1]);
                }
            }
        }
        Iterator<View> it = this.injectJsWebViews.iterator();
        while (it.hasNext()) {
            View next = it.next();
            if (checkWebViewInActivity(foregroundActivity, next)) {
                next.getLocationOnScreen(iArr);
                rect.set(0, 0, next.getWidth(), next.getHeight());
                rect.offset(iArr[0], iArr[1]);
                if (rect.contains(i2, i3)) {
                    LogUtil.d(TAG, "lookupTargetWebView, found valid webView: ", next);
                    this.currentWebView = new WeakReference<>(next);
                    return new TargetWebView(next, iArr[0], iArr[1]);
                }
            }
        }
        return null;
    }

    @Override // com.growingio.android.sdk.debugger.AbstractSocketAdapter
    protected void onConnected() {
        super.onConnected();
        ThreadUtils.cancelTaskOnUiThread(this.timeoutRunnable);
        CircleTipView circleTipView = this.mCircleTipView;
        if (circleTipView != null) {
            circleTipView.doing();
        }
        EventCenter.getInstance().post(new ViewTreeStatusChangeEvent(ViewTreeStatusChangeEvent.StatusType.ScrollChanged));
    }

    @Override // com.growingio.android.sdk.debugger.AbstractSocketAdapter, com.growingio.android.sdk.debugger.DebuggerEventListener
    public void onExit() {
        super.onExit();
        this.wsUrl = null;
        this.currentWebView = null;
        this.injectJsWebViews.clear();
    }

    @Override // com.growingio.android.sdk.debugger.AbstractSocketAdapter, com.growingio.android.sdk.debugger.DebuggerEventListener
    public void onFirstLaunch(Uri uri) {
        super.onFirstLaunch(uri);
        onWebCircleFirstLaunch(uri);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onHybridEventReturn(WebCircleHybridReturnEvent webCircleHybridReturnEvent) {
        try {
            dealHybridReturnMessage(webCircleHybridReturnEvent.getWebView(), webCircleHybridReturnEvent.getMessage());
        } catch (JSONException e2) {
            LogUtil.d(TAG, e2.getMessage(), e2);
        }
    }

    @Override // com.growingio.android.sdk.debugger.AbstractSocketAdapter
    protected void onHybridMessageFromWeb(JSONObject jSONObject) {
        super.onHybridMessageFromWeb(jSONObject);
        try {
            dealHybridMessageInCatch(jSONObject);
        } catch (JSONException e2) {
            LogUtil.d(TAG, e2.getMessage(), e2);
        }
    }

    @Override // com.growingio.android.sdk.debugger.AbstractSocketAdapter, com.growingio.android.sdk.debugger.DebuggerEventListener
    public void onLoginSuccess() {
        if (this.wsUrl != null) {
            afterLoginAndServerStarted();
        }
    }

    @Override // com.growingio.android.sdk.debugger.AbstractSocketAdapter
    public void onPluginReady() {
        super.onPluginReady();
        onWebCirclePluginReady();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRejectJsEvent(InjectJsEvent injectJsEvent) {
        this.injectJsWebViews.add(injectJsEvent.getWebView());
    }

    @Override // com.growingio.android.sdk.debugger.AbstractSocketAdapter
    protected void onServerStarted(String str) {
        this.wsUrl = str;
        if (this.debuggerManager.isLoginDone()) {
            afterLoginAndServerStarted();
        }
        ThreadUtils.cancelTaskOnUiThread(this.timeoutRunnable);
        ThreadUtils.postOnUiThreadDelayed(this.timeoutRunnable, 10000L);
    }

    protected void onWebCircleFirstLaunch(Uri uri) {
        this.pairKey = uri.getQueryParameter("pairKey");
        if (NetworkUtil.getWifiIp(this.coreAppState.getGlobalContext()) == null) {
            Log.e(TAG, "cannot find wifi ip, and exit");
            Toast.makeText(this.coreAppState.getGlobalContext(), "没有检测到wifi网络， 请确保网络连接后从扫码唤起", 1).show();
            this.debuggerManager.exit();
            return;
        }
        this.mCircleTipView.setContent("正在准备Web圈选(初始化)....");
        EventCenter.getInstance().post(new CircleEvent("defaultListener"));
        this.debuggerManager.login();
    }

    protected void onWebCirclePluginReady() {
        startServer();
    }
}
