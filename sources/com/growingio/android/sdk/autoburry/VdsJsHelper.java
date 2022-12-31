package com.growingio.android.sdk.autoburry;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import com.facebook.common.callercontext.ContextChain;
import com.growingio.android.sdk.autoburry.events.InjectJsEvent;
import com.growingio.android.sdk.autoburry.events.WebCircleHybridReturnEvent;
import com.growingio.android.sdk.base.event.CircleGotWebSnapshotNodeEvent;
import com.growingio.android.sdk.base.event.ViewTreeStatusChangeEvent;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.CustomEvent;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.collection.MessageProcessor;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.growingio.android.sdk.ipc.GrowingIOIPC;
import com.growingio.android.sdk.models.ConversionEvent;
import com.growingio.android.sdk.models.PageEvent;
import com.growingio.android.sdk.models.PageVariableEvent;
import com.growingio.android.sdk.models.PatternServer;
import com.growingio.android.sdk.models.PeopleEvent;
import com.growingio.android.sdk.models.Screenshot;
import com.growingio.android.sdk.models.ViewNode;
import com.growingio.android.sdk.models.WebEvent;
import com.growingio.android.sdk.pending.PendingStatus;
import com.growingio.android.sdk.utils.ActivityUtil;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.LinkedString;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.ReflectUtil;
import com.growingio.android.sdk.utils.ScreenshotHelper;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.android.sdk.utils.WebViewUtil;
import com.growingio.eventcenter.EventCenter;
import com.growingio.eventcenter.bus.EventBus;
import com.tencent.smtt.sdk.WebView;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class VdsJsHelper extends WebChromeClient implements Runnable {
    private static final int HOOK_CIRCLE_DELY = 500;
    private static final int HOOK_DELAY = 1000;
    private static final String JS_INTERFACE_NAME = "_vds_bridge";
    private static final int MIN_PROGRESS_FOR_HOOK = 60;
    private static final String TAG = "GIO.VdsJsHelper";
    private String mPageName;
    private ViewNode mViewNode;
    private final WeakReference<View> mWebView;
    private Object mX5ChromeClient;
    private boolean mReturnedData = false;
    private int lastHostAndPortHash = -1;
    private CoreAppState mCoreAppState = CoreInitialize.coreAppState();
    private AutoBuryAppState mAutoBuryAppState = AutoBuryObservableInitialize.autoBuryAppState();
    private MessageProcessor mMsgProcessor = CoreInitialize.messageProcessor();
    private GrowingIOIPC growingIOIPC = CoreInitialize.growingIOIPC();
    private GConfig mConfig = CoreInitialize.config();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class VdsBridge {
        private VdsBridge() {
        }

        @JavascriptInterface
        public void clearUserId(String str) {
            try {
                AbstractGrowingIO.getInstance().clearUserId();
                LogUtil.d(VdsJsHelper.TAG, "clearUserId");
            } catch (Exception e2) {
                LogUtil.e(VdsJsHelper.TAG, e2.getMessage(), e2);
            }
        }

        @JavascriptInterface
        public void hoverNodes(final String str) {
            if (VdsJsHelper.this.mViewNode == null || VdsJsHelper.this.mWebView.get() == null) {
                return;
            }
            LogUtil.d(VdsJsHelper.TAG, str);
            ((View) VdsJsHelper.this.mWebView.get()).postDelayed(new Runnable() { // from class: com.growingio.android.sdk.autoburry.VdsJsHelper.VdsBridge.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.getString("t").equals("snap")) {
                            List webNodesFromEvent = VdsJsHelper.this.getWebNodesFromEvent(jSONObject);
                            if (webNodesFromEvent.size() > 0) {
                                ViewNode.WebElementInfo webElementInfo = ((ViewNode) webNodesFromEvent.get(0)).mWebElementInfo;
                                EventCenter.getInstance().post(new CircleGotWebSnapshotNodeEvent(webNodesFromEvent, webElementInfo.mHost, webElementInfo.mPath));
                            }
                        }
                    } catch (JSONException e2) {
                        LogUtil.d(VdsJsHelper.TAG, e2);
                    }
                }
            }, 100L);
        }

        @JavascriptInterface
        public void onDOMChanged() {
            EventCenter.getInstance().post(new ViewTreeStatusChangeEvent(ViewTreeStatusChangeEvent.StatusType.ScrollChanged));
        }

        @JavascriptInterface
        public void saveCustomEvent(String str) {
            LogUtil.d(VdsJsHelper.TAG, str);
            try {
                VdsJsHelper.this.mMsgProcessor.saveCustomEvent(new CustomEvent(new JSONObject(str)));
            } catch (Exception e2) {
                LogUtil.e(VdsJsHelper.TAG, e2.getMessage(), e2);
            }
        }

        @JavascriptInterface
        public void saveEvent(String str) {
            if (VdsJsHelper.this.handleUploadData(str)) {
                return;
            }
            String encryptWebContent = VdsJsHelper.this.encryptWebContent(str);
            if (VdsJsHelper.this.mViewNode != null) {
                VdsJsHelper.this.mReturnedData = true;
                LogUtil.d(VdsJsHelper.TAG, encryptWebContent);
                if (CoreInitialize.config().isEnabled()) {
                    if (VdsJsHelper.this.isPageEvent(encryptWebContent)) {
                        LogUtil.d(VdsJsHelper.TAG, "found hybrid page event, and update dom, update node");
                        onDOMChanged();
                        VdsJsHelper.this.updateViewNodeForce();
                    }
                    VdsJsHelper.this.mMsgProcessor.persistEvent(new WebEvent(encryptWebContent, VdsJsHelper.this.mViewNode, VdsJsHelper.this.mPageName));
                }
            }
        }

        @JavascriptInterface
        public void setUserId(String str) {
            try {
                AbstractGrowingIO.getInstance().setUserId(str);
                LogUtil.d(VdsJsHelper.TAG, str);
            } catch (Exception e2) {
                LogUtil.e(VdsJsHelper.TAG, e2.getMessage(), e2);
            }
        }

        @JavascriptInterface
        public void setVisitor(String str) {
            try {
                AbstractGrowingIO.getInstance().setVisitor(new JSONObject(str));
                LogUtil.d(VdsJsHelper.TAG, str);
            } catch (Exception unused) {
                LogUtil.e(VdsJsHelper.TAG, "setVisitor failed " + str);
            }
        }

        @JavascriptInterface
        public void webCircleHybridEvent(String str) {
            try {
                LogUtil.d(VdsJsHelper.TAG, "receive webCircleHybridEvent message: ", str);
                JSONObject jSONObject = new JSONObject(str);
                if (VdsJsHelper.this.mViewNode.mHasListParent && jSONObject.getInt("et") == 2) {
                    JSONArray jSONArray = jSONObject.getJSONArray("e");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        if (jSONObject2.has("idx")) {
                            String string = jSONObject2.getString("xpath");
                            String str2 = VdsJsHelper.this.mViewNode.mOriginalParentXpath + string.substring(string.indexOf(":"));
                            jSONObject2.put("xpath", str2);
                            JSONArray jSONArray2 = jSONObject.getJSONArray("patterns");
                            int i3 = 0;
                            while (true) {
                                if (i3 >= jSONArray2.length()) {
                                    break;
                                } else if (jSONArray2.getString(i2).equals(string)) {
                                    jSONArray2.put(i2, str2);
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                        }
                    }
                }
                EventBus.getDefault().post(new WebCircleHybridReturnEvent((View) VdsJsHelper.this.mWebView.get(), jSONObject));
            } catch (Throwable th) {
                LogUtil.e(VdsJsHelper.TAG, "webCircleHybridEvent: " + th.getMessage(), th);
            }
        }
    }

    public VdsJsHelper(View view) {
        this.mWebView = new WeakReference<>(view);
        wrapWebChromeClient(view);
    }

    private void checkAndResetState(String str) {
        if (str.hashCode() != this.lastHostAndPortHash) {
            this.lastHostAndPortHash = str.hashCode();
            LogUtil.d(TAG, "checkAndResetState, found url changed, reset Hook State");
            this.mReturnedData = false;
        }
    }

    private boolean checkClient() {
        WebView webView = (View) this.mWebView.get();
        if (webView != null) {
            if (webView.getTag(AbstractGrowingIO.GROWING_WEB_CLIENT_KEY) != null) {
                return false;
            }
            if (webView instanceof android.webkit.WebView) {
                try {
                    setWebChromeClient((android.webkit.WebView) webView, this, WebChromeClient.class);
                } catch (Throwable th) {
                    LogUtil.d(TAG, th.getMessage(), th);
                    return false;
                }
            } else if (ClassExistHelper.instanceOfX5WebView(webView)) {
                WebView webView2 = webView;
                com.tencent.smtt.sdk.WebChromeClient x5ChromeClient = getX5ChromeClient();
                this.mX5ChromeClient = x5ChromeClient;
                try {
                    webView2.setWebChromeClient(x5ChromeClient);
                } catch (Exception e2) {
                    LogUtil.d(TAG, e2.getMessage(), e2);
                    return false;
                }
            }
            webView.setTag(AbstractGrowingIO.GROWING_WEB_CLIENT_KEY, Boolean.TRUE);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String encryptWebContent(String str) {
        if (CoreInitialize.config().getEncryptEntity() == null) {
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("v");
            if (string != null) {
                jSONObject.put("v", Util.encryptContent(string));
            }
            str = jSONObject.toString();
        } catch (Exception unused) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            JSONArray jSONArray = jSONObject2.getJSONArray("e");
            if (jSONArray != null) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        String string2 = jSONArray.getJSONObject(i2).getString("v");
                        if (string2 != null) {
                            jSONArray.getJSONObject(i2).put("v", Util.encryptContent(string2));
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
            return jSONObject2.toString();
        } catch (Exception unused3) {
            return str;
        }
    }

    private String getCirclePluginSrc(Context context) {
        return injectScriptFile("_gio_circle_js", NetworkConfig.getInstance().getJS_CIRCLE_URL());
    }

    private String getInitPatternServer() {
        PatternServer patternServer = new PatternServer(this.mCoreAppState.getProjectId(), this.mCoreAppState.getSPN(), this.mAutoBuryAppState.getPageName(), this.growingIOIPC.getToken());
        LinkedString linkedString = this.mViewNode.mParentXPath;
        if (linkedString != null) {
            patternServer.setXpath(linkedString.toStringValue());
        }
        return String.format("javascript:(function(){try{%s}catch(e){}})()", "window._vds_hybrid_native_info = " + patternServer.toJson().toString() + ";");
    }

    private String getVdsHybridConfig() {
        return String.format("javascript:(function(){try{%s}catch(e){}})()", String.format("window._vds_hybrid_config = {\"enableHT\":%s,\"disableImp\":%s, \"protocolVersion\":1}", Boolean.valueOf(this.mConfig.isHashTagEnable()), Boolean.valueOf(!this.mConfig.shouldSendImp())));
    }

    private String getVdsHybridSrc(Context context) {
        return injectScriptFile("_gio_hybird_js", NetworkConfig.getInstance().getJS_HYBRID_URL());
    }

    private String getWebCirclePluginSrc() {
        return injectScriptFile("_gio_web_circle_js", NetworkConfig.getInstance().getJSWebCircleUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ViewNode> getWebNodesFromEvent(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("e");
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        View view = this.mWebView.get();
        String string = jSONObject.getString("d");
        String string2 = jSONObject.getString(ContextChain.TAG_PRODUCT);
        String optString = jSONObject.optString("q", null);
        int i2 = 0;
        boolean optBoolean = jSONObject.optBoolean("isTrackingEditText", false);
        double scaledFactor = ScreenshotHelper.getScaledFactor();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        while (i2 < length) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            JSONArray jSONArray2 = jSONArray;
            ViewNode copyWithoutView = this.mViewNode.copyWithoutView();
            int i3 = length;
            ViewNode.WebElementInfo webElementInfo = new ViewNode.WebElementInfo();
            webElementInfo.mHost = string;
            webElementInfo.mPath = string2;
            webElementInfo.mQuery = optString;
            String str = string;
            String str2 = string2;
            webElementInfo.mHref = jSONObject2.optString(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.H, null);
            webElementInfo.mNodeType = jSONObject2.optString("nodeType", null);
            copyWithoutView.mWebElementInfo = webElementInfo;
            copyWithoutView.mView = view;
            if (jSONObject2.has("isTrackingEditText")) {
                copyWithoutView.hybridIsTrackingEditText = jSONObject2.optBoolean("isTrackingEditText");
            } else {
                copyWithoutView.hybridIsTrackingEditText = optBoolean;
            }
            boolean z = optBoolean;
            View view2 = view;
            if (jSONObject2.opt("idx") != null) {
                copyWithoutView.mHasListParent = true;
                copyWithoutView.mLastListPos = jSONObject2.getInt("idx");
                copyWithoutView.mParentXPath = LinkedString.fromString(copyWithoutView.mOriginalParentXpath.toStringValue()).append(Constants.WEB_PART_SEPARATOR).append(jSONObject2.getString("x"));
            } else {
                copyWithoutView.mParentXPath.append(Constants.WEB_PART_SEPARATOR).append(jSONObject2.getString("x"));
            }
            copyWithoutView.mViewContent = jSONObject2.optString("v", "");
            int i4 = (int) jSONObject2.getDouble("ex");
            int i5 = (int) jSONObject2.getDouble("ey");
            int i6 = (int) jSONObject2.getDouble("ew");
            int i7 = (int) jSONObject2.getDouble("eh");
            JSONArray optJSONArray = jSONObject2.optJSONArray("patterns");
            if (optJSONArray != null) {
                copyWithoutView.mParentXPath = makePatternXPath(copyWithoutView.mOriginalParentXpath.toStringValue(), optJSONArray);
                LogUtil.i("GIO.PatternXPath", copyWithoutView.mPatternXPath);
            }
            Rect rect2 = new Rect(i4, i5, i6 + i4, i7 + i5);
            copyWithoutView.mClipRect = rect2;
            rect2.offset(iArr[0], iArr[1]);
            copyWithoutView.mClipRect.intersect(rect);
            Screenshot screenshot = new Screenshot();
            screenshot.x = String.valueOf((int) (copyWithoutView.mClipRect.left * scaledFactor));
            screenshot.y = String.valueOf((int) (copyWithoutView.mClipRect.top * scaledFactor));
            screenshot.w = String.valueOf((int) (copyWithoutView.mClipRect.width() * scaledFactor));
            screenshot.f5098h = String.valueOf((int) (copyWithoutView.mClipRect.height() * scaledFactor));
            copyWithoutView.mScreenshot = screenshot;
            arrayList.add(copyWithoutView);
            i2++;
            optBoolean = z;
            jSONArray = jSONArray2;
            length = i3;
            string = str;
            string2 = str2;
            view = view2;
        }
        return arrayList;
    }

    private com.tencent.smtt.sdk.WebChromeClient getX5ChromeClient() {
        if (this.mX5ChromeClient == null) {
            this.mX5ChromeClient = new com.tencent.smtt.sdk.WebChromeClient() { // from class: com.growingio.android.sdk.autoburry.VdsJsHelper.2
                public void onProgressChanged(WebView webView, int i2) {
                    VdsJsHelper.this.onX5ProgressChanged(webView, i2);
                }
            };
        }
        return (com.tencent.smtt.sdk.WebChromeClient) this.mX5ChromeClient;
    }

    private void handleCustomEvent(JSONObject jSONObject) {
        LogUtil.d(TAG, jSONObject);
        try {
            this.mMsgProcessor.saveCustomEvent(new CustomEvent(jSONObject));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void handleEvar(JSONObject jSONObject) {
        LogUtil.d(TAG, jSONObject);
        try {
            this.mMsgProcessor.persistEvent(new ConversionEvent(jSONObject));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void handlePageVariableEvent(JSONObject jSONObject) {
        LogUtil.d(TAG, jSONObject);
        try {
            this.mMsgProcessor.persistEvent(new PageVariableEvent(jSONObject));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void handlePeopleEvent(JSONObject jSONObject) {
        LogUtil.d(TAG, jSONObject);
        try {
            this.mMsgProcessor.persistEvent(new PeopleEvent(jSONObject));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleUploadData(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("t");
            if (string.equals(CustomEvent.TYPE_NAME)) {
                handleCustomEvent(jSONObject);
                return true;
            } else if (string.equals(PageVariableEvent.TYPE_NAME)) {
                handlePageVariableEvent(jSONObject);
                return true;
            } else if (string.equals(ConversionEvent.TYPE_NAME)) {
                handleEvar(jSONObject);
                return true;
            } else if (string.equals(PeopleEvent.TYPE_NAME)) {
                handlePeopleEvent(jSONObject);
                return true;
            } else {
                return false;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isDestroyed(View view) {
        if (view instanceof android.webkit.WebView) {
            return WebViewUtil.isDestroyed((android.webkit.WebView) view);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPageEvent(String str) {
        try {
            return PageEvent.TYPE_NAME.equals(new JSONObject(str).get("t"));
        } catch (JSONException unused) {
            return false;
        }
    }

    private void loadUrlWithCatch(View view, String... strArr) {
        if (isDestroyed(view)) {
            LogUtil.d(TAG, "loadUrlWithCatch, webView has destroyed.");
            return;
        }
        try {
            if (view instanceof android.webkit.WebView) {
                for (String str : strArr) {
                    ((android.webkit.WebView) view).loadUrl(str);
                }
            } else if (!ClassExistHelper.instanceOfX5WebView(view)) {
                throw new IllegalStateException("NOT SUPPORT THIS WEB VIEW");
            } else {
                for (String str2 : strArr) {
                    ((WebView) view).loadUrl(str2);
                }
            }
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message != null && message.contains("call on destroyed WebView")) {
                LogUtil.d(TAG, th);
            } else {
                LogUtil.e(TAG, message, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadUrlWithCheck(View view, String str) {
        if (ActivityUtil.isDestroy(view.getContext())) {
            return;
        }
        loadUrlWithCatch(view, str);
    }

    private LinkedString makePatternXPath(String str, JSONArray jSONArray) {
        if (str != null && str.length() != 0 && jSONArray != null && jSONArray.length() != 0) {
            LinkedString linkedString = new LinkedString();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    if (linkedString.length() > 0) {
                        linkedString.append(",");
                    }
                    try {
                        linkedString.append(str).append(Constants.WEB_PART_SEPARATOR).append(jSONArray.getString(i2));
                    } catch (Exception e2) {
                        LogUtil.e(TAG, e2.getMessage(), e2);
                    }
                } catch (Exception e3) {
                    LogUtil.e(TAG, "makePatternXPath failed: ", e3);
                }
            }
            return linkedString;
        }
        return LinkedString.fromString("");
    }

    private static void setWebChromeClient(android.webkit.WebView webView, WebChromeClient webChromeClient, Class<?> cls) {
        Object findFieldRecur = ReflectUtil.findFieldRecur(webView, "mProvider");
        if (findFieldRecur == null) {
            LogUtil.e(TAG, "setWebChromeClient: mProvider is null, WebView Hook 失败");
            webView.setWebChromeClient(webChromeClient);
            return;
        }
        Method method = ReflectUtil.getMethod(findFieldRecur.getClass(), "setWebChromeClient", cls);
        if (method != null) {
            try {
                method.invoke(findFieldRecur, webChromeClient);
            } catch (Exception e2) {
                webView.setWebChromeClient(webChromeClient);
                LogUtil.d(TAG, e2);
            }
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    private void wrapWebChromeClient(View view) {
        checkClient();
        if (view.getTag(AbstractGrowingIO.GROWING_ALREADY_SET_INTERFACE) == null) {
            view.setTag(AbstractGrowingIO.GROWING_ALREADY_SET_INTERFACE, Boolean.TRUE);
            if (view instanceof android.webkit.WebView) {
                android.webkit.WebView webView = (android.webkit.WebView) view;
                webView.getSettings().setJavaScriptEnabled(true);
                webView.addJavascriptInterface(new VdsBridge(), JS_INTERFACE_NAME);
            } else if (ClassExistHelper.instanceOfX5WebView(view)) {
                WebView webView2 = (WebView) view;
                webView2.getSettings().setJavaScriptEnabled(true);
                webView2.addJavascriptInterface(new VdsBridge(), JS_INTERFACE_NAME);
            }
        }
    }

    public void impressAllElements() {
        View view = this.mWebView.get();
        LogUtil.d(TAG, "impressAllElements: ", view);
        if (view == null || !this.mReturnedData) {
            return;
        }
        Util.callJavaScript(view, "_vds_hybrid.impressAllElements", Boolean.TRUE);
    }

    public String injectScriptFile(String str, String str2) {
        return String.format("javascript:(function(){try{var jsNode = document.getElementById('%s');\nif (jsNode==null) {\n    var p = document.createElement('script');\n    p.src = '%s';\n    p.id = '%s';\n    document.head.appendChild(p);\n}}catch(e){}})()", str, str2, str);
    }

    public boolean isReturnedData() {
        return this.mReturnedData;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(android.webkit.WebView webView, int i2) {
        webView.removeCallbacks(this);
        String url = webView.getUrl();
        if (url == null) {
            return;
        }
        if (i2 >= 60) {
            webView.postDelayed(this, 1000L);
            return;
        }
        checkAndResetState(url);
        webView.setTag(AbstractGrowingIO.GROWING_WEB_VIEW_URL, url);
    }

    public void onVdsAgentProgressChanged(View view, int i2) {
        if (view instanceof android.webkit.WebView) {
            onProgressChanged((android.webkit.WebView) view, i2);
        } else if (ClassExistHelper.instanceOfX5WebView(view)) {
            onX5ProgressChanged((WebView) view, i2);
        }
    }

    public void onX5ProgressChanged(WebView webView, int i2) {
        webView.removeCallbacks(this);
        String url = webView.getUrl();
        if (url == null) {
            return;
        }
        if (i2 >= 60) {
            webView.postDelayed(this, 1000L);
            return;
        }
        checkAndResetState(url);
        webView.setTag((int) AbstractGrowingIO.GROWING_WEB_VIEW_URL, url);
    }

    @Override // java.lang.Runnable
    public void run() {
        final String webCirclePluginSrc;
        final View view = this.mWebView.get();
        if (view != null) {
            if (ActivityUtil.isDestroy(view.getContext())) {
                return;
            }
            if (this.mViewNode == null) {
                updateViewNodeForce();
                if (this.mViewNode == null) {
                    return;
                }
            }
            LogUtil.d(TAG, "inject js into WebView");
            loadUrlWithCatch(view, getVdsHybridConfig(), getInitPatternServer(), getVdsHybridSrc(view.getContext()));
            if (PendingStatus.isAppCircleEnabled()) {
                webCirclePluginSrc = getCirclePluginSrc(view.getContext());
            } else {
                webCirclePluginSrc = PendingStatus.isWebCircleEnabled() ? getWebCirclePluginSrc() : null;
            }
            if (webCirclePluginSrc != null) {
                ThreadUtils.postOnUiThreadDelayed(new Runnable() { // from class: com.growingio.android.sdk.autoburry.VdsJsHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ActivityUtil.isDestroy(view.getContext())) {
                            return;
                        }
                        VdsJsHelper.this.loadUrlWithCheck(view, webCirclePluginSrc);
                    }
                }, 500L);
            }
            EventCenter.getInstance().post(new InjectJsEvent(view));
            return;
        }
        LogUtil.d(TAG, "null WebView, hook cancelled");
    }

    public void updateViewNodeForce() {
        View view = this.mWebView.get();
        if (view == null) {
            return;
        }
        Activity findActivity = ActivityUtil.findActivity(view.getContext());
        AutoBuryAppState autoBuryAppState = this.mAutoBuryAppState;
        if (findActivity == null) {
            findActivity = this.mCoreAppState.getForegroundActivity();
        }
        this.mPageName = autoBuryAppState.getPageName(findActivity);
        try {
            this.mViewNode = ViewHelper.getViewNode(view, null);
        } catch (Exception unused) {
            LogUtil.e(TAG, "mViewNode update failed");
        }
        checkClient();
    }
}
