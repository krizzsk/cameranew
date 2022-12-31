package com.growingio.android.sdk.circle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.graphics.Point;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.common.callercontext.ContextChain;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.growingio.android.sdk.api.TagStore;
import com.growingio.android.sdk.autoburry.AutoBuryAppState;
import com.growingio.android.sdk.autoburry.AutoBuryObservableInitialize;
import com.growingio.android.sdk.autoburry.VdsJsBridgeManager;
import com.growingio.android.sdk.base.event.HeatMapEvent;
import com.growingio.android.sdk.base.event.SocketEvent;
import com.growingio.android.sdk.circle.view.CircleAnchorView;
import com.growingio.android.sdk.circle.view.CircleModeChooserDialog;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.debugger.DebuggerInitialize;
import com.growingio.android.sdk.debugger.DebuggerManager;
import com.growingio.android.sdk.models.PageEvent;
import com.growingio.android.sdk.models.Tag;
import com.growingio.android.sdk.models.VPAEvent;
import com.growingio.android.sdk.models.ViewNode;
import com.growingio.android.sdk.models.ViewTraveler;
import com.growingio.android.sdk.models.WebEvent;
import com.growingio.android.sdk.pending.PendingStatus;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.GJSONStringer;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.eventcenter.EventCenter;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.common.network.common.header.PGTransHeader;
@TargetApi(15)
/* loaded from: classes2.dex */
public class CircleManager {
    private static final long DELAY_FOR_REQUEST_HEAT_MAP = 100;
    private static final int PAGE_SNAPSHOT_DELAY = 200;
    private static final String TAG = "GIO.CircleManager";
    private static CircleManager sInstance;
    private static final Object sInstanceLocker = new Object();
    private String currentSnapShotKey;
    private long lastLayoutSnapShotTime;
    private CircleAnchorView mCircleAnchorView;
    private String mMaxSizeText;
    private SnapshotMessageListener mMessageListener;
    private List<ViewNode> mPendingWebNodes;
    private int mWaitingWebImpressionCount;
    private Runnable mWebViewSnapshotTimeout;
    private int snapshotKey;
    private SnapshotMessageListener circleMessageListener = new SnapshotMessageListener() { // from class: com.growingio.android.sdk.circle.CircleManager.1
        @Override // com.growingio.android.sdk.circle.CircleManager.SnapshotMessageListener
        public void onMessage(String str) {
            EventCenter.getInstance().post(new SocketEvent(SocketEvent.EVENT_TYPE.SEND, str));
        }
    };
    private Runnable mRefreshSnapshotTask = new Runnable() { // from class: com.growingio.android.sdk.circle.CircleManager.5
        @Override // java.lang.Runnable
        public void run() {
            CircleManager.this.lastLayoutSnapShotTime = System.currentTimeMillis();
            CircleManager.this.refreshSnapshotWithType("touch", null, null);
        }
    };
    private VdsJsBridgeManager.SnapshotCallback mSnapshotCallback = new VdsJsBridgeManager.SnapshotCallback() { // from class: com.growingio.android.sdk.circle.CircleManager.6
        @Override // com.growingio.android.sdk.autoburry.VdsJsBridgeManager.SnapshotCallback
        public void onSnapshotFinished(List<ViewNode> list) {
            CircleManager.this.refreshSnapshotWithType(PageEvent.TYPE_NAME, null, null);
        }
    };
    private ViewTraveler mWebViewChecker = new ViewTraveler() { // from class: com.growingio.android.sdk.circle.CircleManager.7
        @Override // com.growingio.android.sdk.models.ViewTraveler
        public void traverseCallBack(ViewNode viewNode) {
            View view = viewNode.mView;
            if (view instanceof WebView) {
                WebView webView = (WebView) view;
                if (VdsJsBridgeManager.isWebViewHooked(webView)) {
                    CircleManager.access$408(CircleManager.this);
                    Util.callJavaScript(webView, "_vds_hybrid.snapshotAllElements", new Object[0]);
                }
            }
        }
    };
    private ViewTraveler mWebTagsTraveler = new ViewTraveler() { // from class: com.growingio.android.sdk.circle.CircleManager.8
        @Override // com.growingio.android.sdk.models.ViewTraveler
        public void traverseCallBack(ViewNode viewNode) {
            View view = viewNode.mView;
            if ((view instanceof WebView) || ClassExistHelper.instanceOfX5WebView(view)) {
                View view2 = viewNode.mView;
                JSONArray jSONArray = new JSONArray();
                for (Tag tag : CircleManager.this.getTagStore().getWebTags()) {
                    jSONArray.put(tag.toJson());
                }
                boolean shouldShowTags = CircleManager.this.getConfig().shouldShowTags();
                if (VdsJsBridgeManager.isWebViewHooked(view2)) {
                    if (shouldShowTags) {
                        Util.callJavaScript(view2, "_vds_hybrid.setTags", TagStore.getInstance().getWebTags());
                        Util.callJavaScript(view2, "_vds_hybrid.setShowCircledTags", Boolean.TRUE);
                        return;
                    }
                    Util.callJavaScript(view2, "_vds_hybrid.setTags", new Object[0]);
                    Util.callJavaScript(view2, "_vds_hybrid.setShowCircledTags", Boolean.FALSE);
                }
            }
        }
    };
    private Runnable mDelayedSetWebViewTags = new Runnable() { // from class: com.growingio.android.sdk.circle.CircleManager.9
        @Override // java.lang.Runnable
        public void run() {
            if (PendingStatus.isAppCircleEnabled() && CircleManager.this.getConfig().shouldShowTags()) {
                if (CircleManager.this.mCircleAnchorView != null && CircleManager.this.mCircleAnchorView.getVisibility() == 0 && !CircleManager.this.mCircleAnchorView.isMoving()) {
                    CircleManager.this.mCircleAnchorView.setTags(CircleManager.this.getTagStore().getTags());
                    if (CircleManager.this.getCurrentActivity() != null) {
                        ViewHelper.traverseWindow(CircleManager.this.getCurrentActivity().getWindow().getDecorView(), "", CircleManager.this.mWebTagsTraveler);
                    }
                }
                ThreadUtils.postOnUiThreadDelayed(this, 200L);
            }
        }
    };
    private Runnable delayForRequestHeatMapRunnable = new Runnable() { // from class: com.growingio.android.sdk.circle.CircleManager.11
        @Override // java.lang.Runnable
        public void run() {
            EventCenter.getInstance().post(new HeatMapEvent(HeatMapEvent.EVENT_TYPE.UPDATE));
        }
    };
    private AutoBuryAppState autoBuryAppState = AutoBuryObservableInitialize.autoBuryAppState();
    private CoreAppState coreAppState = CoreInitialize.coreAppState();
    private DebuggerManager debuggerManager = DebuggerInitialize.debuggerManager();

    /* loaded from: classes2.dex */
    public interface SnapshotMessageListener {
        void onMessage(String str);
    }

    private CircleManager() {
    }

    static /* synthetic */ int access$408(CircleManager circleManager) {
        int i2 = circleManager.mWaitingWebImpressionCount;
        circleManager.mWaitingWebImpressionCount = i2 + 1;
        return i2;
    }

    private CoreAppState getAppState() {
        return this.coreAppState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GConfig getConfig() {
        return CoreInitialize.config();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity getCurrentActivity() {
        return getAppState().getForegroundActivity();
    }

    public static CircleManager getInstance() {
        synchronized (sInstanceLocker) {
            if (sInstance == null) {
                sInstance = new CircleManager();
            }
        }
        return sInstance;
    }

    private String getMaxSizeText(final ViewNode viewNode) {
        if (viewNode == null) {
            return "按钮";
        }
        if (!TextUtils.isEmpty(viewNode.mViewContent)) {
            return viewNode.mViewContent;
        }
        this.mMaxSizeText = null;
        View view = viewNode.mView;
        if ((view instanceof ViewGroup) && !(view instanceof WebView) && !ClassExistHelper.instanceOfX5WebView(view)) {
            viewNode.setViewTraveler(new ViewTraveler() { // from class: com.growingio.android.sdk.circle.CircleManager.10
                float mMaxTextSize = 0.0f;

                @Override // com.growingio.android.sdk.models.ViewTraveler
                public boolean needTraverse(ViewNode viewNode2) {
                    return viewNode2 == viewNode || (super.needTraverse(viewNode2) && !Util.isViewClickable(viewNode2.mView));
                }

                @Override // com.growingio.android.sdk.models.ViewTraveler
                public void traverseCallBack(ViewNode viewNode2) {
                    if (TextUtils.isEmpty(viewNode2.mViewContent) || !TextUtils.isGraphic(viewNode2.mViewContent)) {
                        return;
                    }
                    View view2 = viewNode2.mView;
                    float textSize = view2 instanceof TextView ? ((TextView) view2).getTextSize() : 0.0f;
                    if (textSize > this.mMaxTextSize) {
                        this.mMaxTextSize = textSize;
                        CircleManager.this.mMaxSizeText = viewNode2.mViewContent;
                    }
                }
            });
            viewNode.traverseChildren();
        } else {
            this.mMaxSizeText = viewNode.mViewContent;
        }
        return TextUtils.isEmpty(this.mMaxSizeText) ? "按钮" : this.mMaxSizeText;
    }

    private JSONObject getSDKConfig() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, GConfig.GROWING_VERSION);
            jSONObject.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, getConfig().getAppVersion());
            jSONObject.put("isUseId", GConfig.USE_ID);
            jSONObject.put("isTrackingAllFragments", getConfig().shouldTrackAllFragment());
            jSONObject.put("isTrackWebView", getConfig().shouldTrackWebView());
            jSONObject.put("schema", GConfig.sGrowingScheme);
            jSONObject.put("channel", getConfig().getChannel());
        } catch (JSONException e2) {
            LogUtil.d("GIO", e2.getMessage());
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TagStore getTagStore() {
        return TagStore.getInstance();
    }

    private String mergeNodes(String str, String str2, ViewNode viewNode, List<ViewNode> list, VPAEvent vPAEvent) {
        String str3;
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return str;
        }
        if (str.equals(PageEvent.TYPE_NAME)) {
            if (vPAEvent instanceof PageEvent) {
                str3 = ((PageEvent) vPAEvent).getTitle();
                if (TextUtils.isEmpty(str3)) {
                    str3 = vPAEvent.mPageName;
                }
            } else if (vPAEvent instanceof WebEvent) {
                try {
                    str3 = vPAEvent.toJson().getString("tl");
                } catch (Exception e2) {
                    e = e2;
                    str3 = "";
                }
                try {
                    if (TextUtils.isEmpty(str3)) {
                        str3 = vPAEvent.toJson().getString(ContextChain.TAG_PRODUCT);
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    str2 = "进入了" + str3;
                    JSONObject screenShotInfo = new ScreenshotInfo(currentActivity, list, viewNode).getScreenShotInfo();
                    screenShotInfo.put("msgId", "user_action");
                    StringBuilder sb = new StringBuilder();
                    sb.append(Process.myPid());
                    sb.append(PGTransHeader.CONNECTOR);
                    int i2 = this.snapshotKey;
                    this.snapshotKey = i2 + 1;
                    sb.append(i2);
                    String sb2 = sb.toString();
                    this.currentSnapShotKey = sb2;
                    screenShotInfo.put("sk", sb2);
                    screenShotInfo.put("userAction", str);
                    screenShotInfo.put("actionDesc", str2);
                    screenShotInfo.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, GConfig.GROWING_VERSION);
                    screenShotInfo.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, getConfig().getAppVersion());
                    screenShotInfo.put("sdkConfig", getSDKConfig());
                    screenShotInfo.put("domain", getAppState().getSPN());
                    screenShotInfo.put(PageEvent.TYPE_NAME, this.autoBuryAppState.getPageName(currentActivity));
                    return new GJSONStringer().convertToString(screenShotInfo);
                }
            } else {
                str3 = "";
            }
            str2 = "进入了" + str3;
        }
        JSONObject screenShotInfo2 = new ScreenshotInfo(currentActivity, list, viewNode).getScreenShotInfo();
        try {
            screenShotInfo2.put("msgId", "user_action");
            StringBuilder sb3 = new StringBuilder();
            sb3.append(Process.myPid());
            sb3.append(PGTransHeader.CONNECTOR);
            int i22 = this.snapshotKey;
            this.snapshotKey = i22 + 1;
            sb3.append(i22);
            String sb22 = sb3.toString();
            this.currentSnapShotKey = sb22;
            screenShotInfo2.put("sk", sb22);
            screenShotInfo2.put("userAction", str);
            screenShotInfo2.put("actionDesc", str2);
            screenShotInfo2.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, GConfig.GROWING_VERSION);
            screenShotInfo2.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, getConfig().getAppVersion());
            screenShotInfo2.put("sdkConfig", getSDKConfig());
            screenShotInfo2.put("domain", getAppState().getSPN());
            screenShotInfo2.put(PageEvent.TYPE_NAME, this.autoBuryAppState.getPageName(currentActivity));
            return new GJSONStringer().convertToString(screenShotInfo2);
        } catch (Exception e4) {
            Log.e("WebSocketProxy", "send screenshot info message error", e4);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUserActionMessage(String str, ViewNode viewNode, VPAEvent vPAEvent) {
        String str2;
        ThreadUtils.cancelTaskOnUiThread(this.mWebViewSnapshotTimeout);
        if ("click".equals(str)) {
            str2 = "点击了" + getMaxSizeText(viewNode);
        } else if ("touch".equals(str)) {
            str2 = "更新截图";
        } else {
            str2 = PageEvent.TYPE_NAME.equals(str) ? "进入了" : "";
        }
        String str3 = str2;
        if (this.mMessageListener != null && PendingStatus.isWebCircleEnabled()) {
            this.mMessageListener.onMessage(mergeNodes(str, str3, viewNode, this.mPendingWebNodes, vPAEvent));
        } else if (this.mMessageListener == null || !PendingStatus.isDebuggerEnabled()) {
        } else {
            EventCenter.getInstance().post(new SocketEvent(SocketEvent.EVENT_TYPE.SCREEN_UPDATE));
        }
    }

    private void showWebEventEditDialog(List<ViewNode> list, String str, String str2) {
        CircleAnchorView circleAnchorView = this.mCircleAnchorView;
        if (circleAnchorView != null) {
            circleAnchorView.setVisibility(8);
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            String pageName = this.autoBuryAppState.getPageName(currentActivity);
            final HybridEventEditDialog hybridEventEditDialog = new HybridEventEditDialog();
            hybridEventEditDialog.setContent(currentActivity, list, pageName, getAppState().getSPN(), new Runnable() { // from class: com.growingio.android.sdk.circle.CircleManager.3
                @Override // java.lang.Runnable
                public void run() {
                    CircleManager.this.showDialog(hybridEventEditDialog, HybridEventEditDialog.class.getName());
                }
            });
        }
    }

    @SuppressLint({"RtlHardcoded"})
    public boolean addCircleView() {
        LogUtil.d(TAG, "addCircleView()");
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null && !PendingStatus.isProjection()) {
            if (this.debuggerManager.checkWindowPermission(currentActivity)) {
                if (this.mCircleAnchorView == null) {
                    EventCenter.getInstance().post(new HeatMapEvent(HeatMapEvent.EVENT_TYPE.INIT));
                    this.mCircleAnchorView = new CircleAnchorView(currentActivity.getApplicationContext());
                }
                this.mCircleAnchorView.show();
                return true;
            }
            return false;
        }
        LogUtil.d(TAG, "addCircleView() 半途 return");
        return false;
    }

    public void defaultListener() {
        setSnapshotMessageListener(this.circleMessageListener);
    }

    public String getCurrentSnapShotKey() {
        return this.currentSnapShotKey;
    }

    public void gotWebSnapshotNodes(List<ViewNode> list, String str, String str2) {
        if (PendingStatus.isProjection()) {
            VdsJsBridgeManager.getInstance().onSnapshotFinished(null, list);
        } else if (PendingStatus.isAppCircleEnabled()) {
            showWebEventEditDialog(list, str, str2);
        }
    }

    public void launchAppCircle() {
        LogUtil.d(TAG, "launchAppCircle()");
        if (getCurrentActivity() == null) {
            LogUtil.d(TAG, "launchAppCircle() getCurrentActivity() == null return");
        } else if (!getTagStore().isTagsReady()) {
            if (getTagStore().isLoading()) {
                LogUtil.d(TAG, "launchAppCircle() getTagStore().isLoading() return");
                return;
            }
            Activity currentActivity = getCurrentActivity();
            final ProgressDialog progressDialog = new ProgressDialog(currentActivity);
            getTagStore().setInitSuccess(new TagStore.InitSuccess() { // from class: com.growingio.android.sdk.circle.CircleManager.2
                @Override // com.growingio.android.sdk.api.TagStore.InitSuccess
                public void initSuccess() {
                    try {
                        LogUtil.d(CircleManager.TAG, "launchAppCircle()->initSuccess()");
                        CircleManager.this.launchAppCircle();
                        if (progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }
                    } catch (IllegalArgumentException unused) {
                    }
                }
            });
            try {
                progressDialog.requestWindowFeature(1);
                progressDialog.setMessage("正在加载历史标签");
                progressDialog.show();
                this.coreAppState.onGIODialogShow(currentActivity, progressDialog);
            } catch (WindowManager.BadTokenException unused) {
                Toast.makeText(getCurrentActivity(), "正在加载历史标签", 1).show();
            }
            getTagStore().initial();
        } else {
            LogUtil.d(TAG, "launchAppCircle() -> addCircleView()");
            if (addCircleView()) {
                HybridEventEditDialog.prepareWebView(getCurrentActivity());
            }
        }
    }

    public void onResumed(Activity activity) {
        LogUtil.d(TAG, "onResumed, should show circleView and check heatMap");
        showCircleView(activity);
        updateHeatMap();
    }

    public void refreshSnapshotWithType(final String str, final ViewNode viewNode, final VPAEvent vPAEvent) {
        if (getCurrentActivity() == null) {
            return;
        }
        this.mPendingWebNodes = null;
        this.mWaitingWebImpressionCount = 0;
        VdsJsBridgeManager.getInstance().registerSnapshotCallback(this.mSnapshotCallback);
        ViewHelper.traverseWindow(getCurrentActivity().getWindow().getDecorView(), "", this.mWebViewChecker);
        Runnable runnable = new Runnable() { // from class: com.growingio.android.sdk.circle.CircleManager.4
            @Override // java.lang.Runnable
            public void run() {
                ThreadUtils.cancelTaskOnUiThread(CircleManager.this.mRefreshSnapshotTask);
                CircleManager.this.sendUserActionMessage(str, viewNode, vPAEvent);
                CircleManager.this.mPendingWebNodes = null;
            }
        };
        this.mWebViewSnapshotTimeout = runnable;
        if (this.mWaitingWebImpressionCount > 0) {
            ThreadUtils.postOnUiThreadDelayed(runnable, 200L);
        } else {
            ThreadUtils.postOnUiThread(runnable);
        }
    }

    public void refreshWebCircleTasks() {
        if (PendingStatus.isProjection()) {
            long j2 = System.currentTimeMillis() - this.lastLayoutSnapShotTime >= 2000 ? 200L : 2000L;
            ThreadUtils.cancelTaskOnUiThread(this.mRefreshSnapshotTask);
            ThreadUtils.postOnUiThreadDelayed(this.mRefreshSnapshotTask, j2);
        }
    }

    public void removeFloatViews() {
        CircleAnchorView circleAnchorView = this.mCircleAnchorView;
        if (circleAnchorView != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) circleAnchorView.getLayoutParams();
            Point point = new Point();
            point.x = layoutParams.x;
            point.y = layoutParams.y;
            getConfig().saveFloatPosition(point.x, point.y);
            this.mCircleAnchorView.remove();
            this.mCircleAnchorView = null;
        }
        EventCenter.getInstance().post(new HeatMapEvent(HeatMapEvent.EVENT_TYPE.HIDE));
    }

    public void setShowTags(boolean z) {
        if (this.mCircleAnchorView != null && PendingStatus.isEnable() && PendingStatus.isAppCircleEnabled()) {
            if (z) {
                this.mCircleAnchorView.setTags(getTagStore().getTags());
            } else {
                this.mCircleAnchorView.setTags(null);
            }
            getConfig().setShowTags(z);
            if (getCurrentActivity() != null) {
                ViewHelper.traverseWindow(getCurrentActivity().getWindow().getDecorView(), "", this.mWebTagsTraveler);
            }
        }
    }

    public void setSnapshotMessageListener(SnapshotMessageListener snapshotMessageListener) {
        this.mMessageListener = snapshotMessageListener;
    }

    public void showCircleModeDialog() {
        showDialog(new CircleModeChooserDialog(), CircleModeChooserDialog.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showCircleView(Activity activity) {
        LogUtil.d(TAG, "showCircleView() -> isAppCircleEnabled():true");
        if (activity == null) {
            activity = this.coreAppState.getForegroundActivity();
        }
        addCircleView();
        FragmentManager fragmentManager = activity.getFragmentManager();
        if ((fragmentManager.findFragmentByTag(HybridEventEditDialog.class.getName()) == null || fragmentManager.findFragmentByTag(HybridEventEditDialog.class.getName()).isRemoving()) && (fragmentManager.findFragmentByTag(CircleModeChooserDialog.class.getName()) == null || fragmentManager.findFragmentByTag(CircleModeChooserDialog.class.getName()).isRemoving())) {
            return;
        }
        this.mCircleAnchorView.setVisibility(8);
        LogUtil.d(TAG, "showCircleView() -> addCircleView()");
    }

    public void showDialog(DialogFragment dialogFragment, String str) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        Field field = null;
        while (true) {
            Activity parent = currentActivity.getParent();
            if (parent != null) {
                FragmentManager fragmentManager = parent.getFragmentManager();
                if (field == null) {
                    try {
                        field = fragmentManager.getClass().getDeclaredField("mStateSaved");
                        field.setAccessible(true);
                    } catch (NoSuchFieldException e2) {
                        Log.d(TAG, e2.getMessage(), e2);
                    }
                }
                if (field != null) {
                    try {
                        if (!((Boolean) field.get(fragmentManager)).booleanValue()) {
                        }
                    } catch (IllegalAccessException e3) {
                        Log.d(TAG, e3.getMessage(), e3);
                    }
                }
                currentActivity = parent;
            }
            try {
                if (!dialogFragment.isAdded() && currentActivity.getFragmentManager().findFragmentByTag(str) == null) {
                    dialogFragment.show(currentActivity.getFragmentManager(), str);
                    return;
                }
                return;
            } catch (IllegalStateException e4) {
                e4.printStackTrace();
                return;
            }
        }
    }

    void updateHeatMap() {
        ThreadUtils.cancelTaskOnUiThread(this.delayForRequestHeatMapRunnable);
        if (HybridEventEditDialog.hasEditDialog()) {
            return;
        }
        ThreadUtils.postOnUiThreadDelayed(this.delayForRequestHeatMapRunnable, DELAY_FOR_REQUEST_HEAT_MAP);
    }

    public void updateTagsIfNeeded() {
        if (this.mCircleAnchorView != null && PendingStatus.isEnable() && PendingStatus.isAppCircleEnabled() && getConfig().shouldShowTags()) {
            this.mCircleAnchorView.setTags(getTagStore().getTags());
            ThreadUtils.cancelTaskOnUiThread(this.mDelayedSetWebViewTags);
            ThreadUtils.postOnUiThreadDelayed(this.mDelayedSetWebViewTags, 200L);
        }
    }
}
