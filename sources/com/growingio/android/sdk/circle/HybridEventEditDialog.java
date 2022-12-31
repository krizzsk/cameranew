package com.growingio.android.sdk.circle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.growingio.android.sdk.base.event.HeatMapEvent;
import com.growingio.android.sdk.circle.CircleManager;
import com.growingio.android.sdk.circle.utils.CircleUtil;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.growingio.android.sdk.ipc.GrowingIOIPC;
import com.growingio.android.sdk.models.PageEvent;
import com.growingio.android.sdk.models.ViewNode;
import com.growingio.android.sdk.models.ViewTraveler;
import com.growingio.android.sdk.pending.PendingStatus;
import com.growingio.android.sdk.utils.GJSONStringer;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.ScreenshotHelper;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.WindowHelper;
import com.growingio.eventcenter.EventCenter;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
@TargetApi(11)
/* loaded from: classes2.dex */
public class HybridEventEditDialog extends DialogFragment implements CircleManager.SnapshotMessageListener {
    private static final String CONTENT_BUNDLE_KEY = "circle_content";
    public static final String DO_NOT_DRAW = "DO_NOT_DRAW";
    private static final String TAG = "GIO.HybridEvent";
    private static boolean hasEditDialog = false;
    private static HybridCircleContent mContent;
    @SuppressLint({"StaticFieldLeak"})
    private static WebView mWebView;
    private static WeakReference<HybridEventEditDialog> mWebViewAttachedDialog = new WeakReference<>(null);
    WebChromeClient mWebChromeClient = new WebChromeClient() { // from class: com.growingio.android.sdk.circle.HybridEventEditDialog.2
        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
            HybridEventEditDialog.this.dismiss();
        }
    };
    WebViewClient mWebViewClient = new WebViewClient() { // from class: com.growingio.android.sdk.circle.HybridEventEditDialog.3
        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            CircleManager circleManager = CircleManager.getInstance();
            circleManager.setSnapshotMessageListener(HybridEventEditDialog.this);
            circleManager.refreshSnapshotWithType("touch", null, null);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.equals("growing.internal://close-web-view")) {
                HybridEventEditDialog.this.dismiss();
                return true;
            }
            return false;
        }
    };

    public HybridEventEditDialog() {
        ScreenshotHelper.initial();
    }

    private void detachWebView() {
        if (mWebView == null || this != mWebViewAttachedDialog.get()) {
            return;
        }
        mWebView.loadUrl("javascript:hideBody();", null);
        ViewGroup viewGroup = (ViewGroup) mWebView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(mWebView);
        }
    }

    public static boolean hasEditDialog() {
        return hasEditDialog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface", "SetJavaScriptEnabled"})
    public static void prepareWebView(Context context) {
        if (mWebView == null) {
            WebView webView = new WebView(context.getApplicationContext());
            mWebView = webView;
            webView.getSettings().setJavaScriptEnabled(true);
            mWebView.getSettings().setDomStorageEnabled(true);
            if (Build.VERSION.SDK_INT >= 19) {
                WebView.setWebContentsDebuggingEnabled(GConfig.DEBUG);
            }
        }
        mWebView.clearHistory();
        mWebView.addJavascriptInterface(mContent, "_hybrid_circle_content");
        mWebView.loadUrl(NetworkConfig.getInstance().getCirclePageUrl());
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String string;
        PendingStatus.mCanShowCircleTag = false;
        setStyle(0, 16973837);
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.getWindow().setSoftInputMode(18);
        onCreateDialog.getWindow().getDecorView().setTag(DO_NOT_DRAW);
        prepareWebView(onCreateDialog.getContext());
        GrowingIO.ignoredView(onCreateDialog.getWindow().getDecorView());
        if (bundle != null && (string = bundle.getString(CONTENT_BUNDLE_KEY)) != null) {
            mContent = new HybridCircleContent(string);
        }
        onCreateDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.growingio.android.sdk.circle.HybridEventEditDialog.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                if (i2 == 4 && keyEvent.getAction() == 1) {
                    if (HybridEventEditDialog.mWebView.canGoBack()) {
                        HybridEventEditDialog.mWebView.goBack();
                    } else {
                        HybridEventEditDialog.this.dismiss();
                    }
                    return true;
                }
                return false;
            }
        });
        mWebView.setWebChromeClient(this.mWebChromeClient);
        mWebView.setWebViewClient(this.mWebViewClient);
        return onCreateDialog;
    }

    @Override // android.app.Fragment
    @Nullable
    @SuppressLint({"JavascriptInterface"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        hasEditDialog = true;
        EventCenter.getInstance().post(new HeatMapEvent(HeatMapEvent.EVENT_TYPE.HIDE));
        mWebViewAttachedDialog = new WeakReference<>(this);
        return mWebView;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        PendingStatus.mCanShowCircleTag = true;
        detachWebView();
        CircleManager circleManager = CircleManager.getInstance();
        circleManager.showCircleView(null);
        circleManager.setSnapshotMessageListener(null);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        PendingStatus.mCanShowCircleTag = true;
        EventCenter.getInstance().post(new HeatMapEvent(HeatMapEvent.EVENT_TYPE.SHOW));
        super.onDismiss(dialogInterface);
        detachWebView();
        hasEditDialog = false;
    }

    @Override // com.growingio.android.sdk.circle.CircleManager.SnapshotMessageListener
    public void onMessage(String str) {
        if (mWebView == null || Build.VERSION.SDK_INT < 19) {
            return;
        }
        WebView webView = mWebView;
        webView.evaluateJavascript("_setGrowingIOFullHybridCircleData(" + str + ")", null);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        String str;
        HybridCircleContent hybridCircleContent = mContent;
        if (hybridCircleContent == null || (str = hybridCircleContent.data) == null) {
            return;
        }
        bundle.putString(CONTENT_BUNDLE_KEY, str);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        CircleManager circleManager = CircleManager.getInstance();
        if (circleManager != null) {
            circleManager.removeFloatViews();
        }
    }

    public void setContent(Activity activity, List<ViewNode> list, String str, String str2, Runnable runnable) {
        mContent = new HybridCircleContent(list, activity, str, str2);
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class HybridCircleContent {
        CoreAppState coreAppState = CoreInitialize.coreAppState();
        String data;
        boolean haveWebNode;

        HybridCircleContent(String str) {
            this.data = str;
        }

        @JavascriptInterface
        public String getData() {
            LogUtil.d(HybridEventEditDialog.TAG, "Data:\n" + this.data);
            return this.data;
        }

        HybridCircleContent(List<ViewNode> list, Activity activity, String str, String str2) {
            JSONObject jSONObject;
            GrowingIOIPC growingIOIPC = CoreInitialize.growingIOIPC();
            JSONObject jSONObject2 = new JSONObject();
            try {
                PackageInfo packageInfo = this.coreAppState.getGlobalContext().getPackageManager().getPackageInfo(this.coreAppState.getGlobalContext().getPackageName(), 0);
                jSONObject2.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, GConfig.GROWING_VERSION);
                jSONObject2.put("projectId", this.coreAppState.getProjectId());
                jSONObject2.put(GuestProfileFragment.USER_ID, growingIOIPC.getGioUserId());
                jSONObject2.put("accessToken", growingIOIPC.getToken());
                jSONObject2.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, packageInfo.versionName);
                jSONObject2.put("platform", Constants.PLATFORM_ANDROID);
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("domain", str2);
                jSONObject3.put(PageEvent.TYPE_NAME, str);
                CharSequence title = activity.getTitle();
                jSONObject3.put("title", TextUtils.isEmpty(title) ? Util.getSimpleClassName(activity.getClass()) : title);
                jSONObject3.put("snapshot", "data:image/jpeg;base64," + Base64.encodeToString(ScreenshotHelper.captureAllWindows(WindowHelper.getSortedWindowViews(), null), 2));
                final JSONArray jSONArray2 = new JSONArray();
                final JSONArray jSONArray3 = new JSONArray();
                if (list.size() <= 0 || list.get(0).mWebElementInfo == null) {
                    jSONObject = null;
                } else {
                    ViewNode viewNode = list.get(0);
                    this.haveWebNode = true;
                    jSONObject = new JSONObject();
                    jSONObject.put("domain", str2 + Constants.WEB_PART_SEPARATOR + viewNode.mWebElementInfo.mHost);
                    jSONObject.put(PageEvent.TYPE_NAME, str + Constants.WEB_PART_SEPARATOR + viewNode.mWebElementInfo.mPath);
                    jSONObject.put("query", viewNode.mWebElementInfo.mQuery);
                }
                for (ViewNode viewNode2 : list) {
                    ViewTraveler viewTraveler = new ViewTraveler() { // from class: com.growingio.android.sdk.circle.HybridEventEditDialog.HybridCircleContent.1
                        @Override // com.growingio.android.sdk.models.ViewTraveler
                        public void traverseCallBack(ViewNode viewNode3) {
                            if (HybridCircleContent.this.haveWebNode) {
                                jSONArray3.put(CircleUtil.getImpressObj(viewNode3));
                            } else {
                                jSONArray2.put(CircleUtil.getImpressObj(viewNode3));
                            }
                        }
                    };
                    viewNode2.setViewTraveler(viewTraveler);
                    viewTraveler.traverseCallBack(viewNode2);
                    viewNode2.traverseChildren();
                }
                jSONObject3.put("e", jSONArray2);
                jSONArray.put(jSONObject3);
                if (jSONObject != null) {
                    jSONObject.put("e", jSONArray3);
                    jSONArray.put(jSONObject);
                }
                jSONObject2.put("pages", jSONArray);
                jSONObject2.put("zone", NetworkConfig.getInstance().zoneInfo());
                String gtaHost = NetworkConfig.getInstance().getGtaHost();
                if (!TextUtils.isEmpty(gtaHost)) {
                    jSONObject2.put("gtaHost", URLEncoder.encode(gtaHost, "UTF-8"));
                }
                this.data = new GJSONStringer().convertToString(jSONObject2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
