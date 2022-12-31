package com.growingio.android.sdk.heatmap;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Toast;
import com.facebook.common.callercontext.ContextChain;
import com.growingio.android.sdk.autoburry.AutoBuryAppState;
import com.growingio.android.sdk.autoburry.AutoBuryObservableInitialize;
import com.growingio.android.sdk.autoburry.VdsJsBridgeManager;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.heatmap.HeatMapApi;
import com.growingio.android.sdk.ipc.GrowingIOIPC;
import com.growingio.android.sdk.models.HeatMapData;
import com.growingio.android.sdk.models.ViewNode;
import com.growingio.android.sdk.models.ViewTraveler;
import com.growingio.android.sdk.pending.PendingStatus;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.FloatWindowManager;
import com.growingio.android.sdk.utils.ObjectUtils;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class HeatMapManager {
    private static final String TAG = "GIO.HeatMapManager";
    private static HeatMapManager sInstance;
    private static final Object sInstanceObject = new Object();
    private HeatMapNodeTraveler heatMapNodeTraveler;
    private HeatMapView heatMapView;
    private boolean initHeatMapView = false;
    private ViewTraveler mWebHeatMapTraveler = new ViewTraveler() { // from class: com.growingio.android.sdk.heatmap.HeatMapManager.3
        @Override // com.growingio.android.sdk.models.ViewTraveler
        public void traverseCallBack(ViewNode viewNode) {
            View view = viewNode.mView;
            if ((view instanceof WebView) || ClassExistHelper.instanceOfX5WebView(view)) {
                View view2 = viewNode.mView;
                if (VdsJsBridgeManager.isWebViewHooked(view2)) {
                    if (PendingStatus.mIsHeatMapOn) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("ai", HeatMapManager.this.coreAppState.getProjectId());
                            jSONObject.put("d", HeatMapManager.this.coreAppState.getSPN());
                            jSONObject.put(ContextChain.TAG_PRODUCT, CoreInitialize.messageProcessor().getPageNameWithPending());
                            jSONObject.put("token", HeatMapManager.this.growingIOIPC.getToken());
                        } catch (JSONException e2) {
                            Log.d(HeatMapManager.TAG, "generate openHeatMapObject json error :" + e2);
                        }
                        Util.callJavaScript(view2, "_vds_hybrid.showHeatMap", jSONObject);
                        return;
                    }
                    Util.callJavaScript(view2, "_vds_hybrid.hideHeatMap", new Object[0]);
                }
            }
        }
    };
    private CoreAppState coreAppState = CoreInitialize.coreAppState();
    private AutoBuryAppState autoBuryAppState = AutoBuryObservableInitialize.autoBuryAppState();
    private GrowingIOIPC growingIOIPC = CoreInitialize.growingIOIPC();

    private HeatMapManager() {
    }

    private void callWebViewHeatMap() {
        ThreadUtils.postOnUiThread(new Runnable() { // from class: com.growingio.android.sdk.heatmap.HeatMapManager.2
            @Override // java.lang.Runnable
            public void run() {
                Activity resumedActivity = HeatMapManager.this.coreAppState.getResumedActivity();
                if (resumedActivity != null) {
                    ViewHelper.traverseWindow(resumedActivity.getWindow().getDecorView(), "", HeatMapManager.this.mWebHeatMapTraveler);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getHeatMapDataFail(String str) {
        Toast.makeText(this.coreAppState.getGlobalContext(), str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getHeatMapDataSuccess(HeatMapData[] heatMapDataArr, String str) {
        if (ObjectUtils.equals(this.autoBuryAppState.getPageName(), str)) {
            this.heatMapNodeTraveler.updateHeatMapDataArray(heatMapDataArr);
            this.heatMapView.updateData(heatMapDataArr);
        }
    }

    public static HeatMapManager getInstance() {
        synchronized (sInstanceObject) {
            if (sInstance == null) {
                sInstance = new HeatMapManager();
            }
        }
        return sInstance;
    }

    public void getHeatMapData() {
        this.heatMapView.clearData();
        this.heatMapNodeTraveler.clear();
        final String pageName = this.autoBuryAppState.getPageName();
        HeatMapApi.getHeatMapData(pageName, new HeatMapApi.HeatMapCallback() { // from class: com.growingio.android.sdk.heatmap.HeatMapManager.1
            @Override // com.growingio.android.sdk.heatmap.HeatMapApi.HeatMapCallback
            public void getHeatMapFinish(HeatMapResponse heatMapResponse) {
                if (heatMapResponse == null) {
                    HeatMapManager.this.getHeatMapDataFail("请求热图数据失败");
                } else if (heatMapResponse.isSuccess()) {
                    HeatMapManager.this.getHeatMapDataSuccess(heatMapResponse.getData(), pageName);
                } else {
                    HeatMapManager heatMapManager = HeatMapManager.this;
                    heatMapManager.getHeatMapDataFail("请求热图数据失败:" + heatMapResponse.getReason());
                }
            }
        });
        callWebViewHeatMap();
    }

    public void hideHeatMapView() {
        this.heatMapView.hide();
        HeatMapNodeTraveler heatMapNodeTraveler = this.heatMapNodeTraveler;
        if (heatMapNodeTraveler != null) {
            heatMapNodeTraveler.stopTraverse();
        }
    }

    @SuppressLint({"RtlHardcoded"})
    @TargetApi(8)
    public void initHeatMapView() {
        if (this.initHeatMapView) {
            return;
        }
        this.heatMapView = new HeatMapView(this.coreAppState.getGlobalContext());
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, PendingStatus.FLOAT_VIEW_TYPE, 1848, -3);
        layoutParams.gravity = 51;
        layoutParams.setTitle("HeatMapView");
        FloatWindowManager.getInstance().addView(this.heatMapView, layoutParams);
        this.heatMapView.setVisibility(8);
        this.heatMapNodeTraveler = new HeatMapNodeTraveler(this.heatMapView);
        this.initHeatMapView = true;
    }

    public boolean isHeatMapOn() {
        return PendingStatus.mIsHeatMapOn;
    }

    public void setHeatMapState(boolean z) {
        PendingStatus.mIsHeatMapOn = z;
        if (z) {
            getHeatMapData();
        } else {
            callWebViewHeatMap();
        }
    }

    public void showHeatMapView() {
        this.heatMapView.show();
        this.heatMapNodeTraveler.beginTraverseImmediately();
    }

    public void traverseNodeImmediately() {
        if (PendingStatus.mIsHeatMapOn) {
            this.heatMapNodeTraveler.beginTraverseImmediately();
        }
    }
}
