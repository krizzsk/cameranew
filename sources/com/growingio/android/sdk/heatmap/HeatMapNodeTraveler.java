package com.growingio.android.sdk.heatmap;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.models.HeatMapData;
import com.growingio.android.sdk.models.ViewNode;
import com.growingio.android.sdk.models.ViewTraveler;
import com.growingio.android.sdk.utils.LinkedString;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.android.sdk.utils.WindowHelper;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class HeatMapNodeTraveler extends ViewTraveler {
    private HeatMapData[] heatMapDataArray;
    private int heatMapDataArrayLength;
    private HeatMapView heatMapView;
    private final String TAG = "GIO.HeatMapNodeTraveler";
    private boolean isImmediateTraverse = false;
    private final int AUTO_UPDATE_DURATION = 1000;
    private final int IMMEDIATE_UPDATE_DURATION = 50;
    private Runnable traverseRunnable = new Runnable() { // from class: com.growingio.android.sdk.heatmap.HeatMapNodeTraveler.1
        @Override // java.lang.Runnable
        public void run() {
            HeatMapNodeTraveler.this.traverse();
        }
    };
    private ArrayList<HeatMapNode> heatMapNodeList = new ArrayList<>();
    private HashMap<View, HeatMapNode> cacheHeatNodeMap = new HashMap<>();

    public HeatMapNodeTraveler(HeatMapView heatMapView) {
        this.heatMapView = heatMapView;
    }

    private void addHeatMapNode(ViewNode viewNode, HeatMapData.ItemBean itemBean) {
        HeatMapNode heatMapNode = new HeatMapNode(viewNode, itemBean);
        this.heatMapNodeList.add(heatMapNode);
        this.cacheHeatNodeMap.put(viewNode.mView, heatMapNode);
    }

    private void addHeatMapNodeFromCache(HeatMapNode heatMapNode) {
        heatMapNode.reset();
        this.heatMapNodeList.add(heatMapNode);
    }

    @Nullable
    private HeatMapData findBestMatch(ViewNode viewNode) {
        HeatMapData heatMapData = null;
        Boolean bool = null;
        for (int i2 = 0; i2 < this.heatMapDataArrayLength; i2++) {
            HeatMapData heatMapData2 = this.heatMapDataArray[i2];
            if (matchXpath(viewNode, heatMapData2)) {
                if (heatMapData == null) {
                    heatMapData = heatMapData2;
                } else if (bool == null && Boolean.valueOf(isValueMatch(viewNode, heatMapData)).booleanValue()) {
                    return heatMapData;
                } else {
                    bool = Boolean.valueOf(isValueMatch(viewNode, heatMapData2));
                    if (bool.booleanValue()) {
                        return heatMapData2;
                    }
                }
            }
        }
        return heatMapData;
    }

    private boolean generateHeatMapNode(ViewNode viewNode, HeatMapData heatMapData, boolean z) {
        HeatMapData.ItemBean matchIndex = matchIndex(viewNode, heatMapData.getItems());
        if (matchIndex == null) {
            return false;
        }
        HeatMapNode cacheHeatMapNode = getCacheHeatMapNode(viewNode, matchIndex);
        if (cacheHeatMapNode == null) {
            addHeatMapNode(viewNode, matchIndex);
        } else {
            addHeatMapNodeFromCache(cacheHeatMapNode);
        }
        return !z;
    }

    private HeatMapNode getCacheHeatMapNode(ViewNode viewNode, HeatMapData.ItemBean itemBean) {
        boolean isInListView = isInListView(viewNode);
        if (itemBean == null) {
            if (isInListView) {
                return null;
            }
            return this.cacheHeatNodeMap.get(viewNode.mView);
        } else if (isInListView) {
            HeatMapNode heatMapNode = this.cacheHeatNodeMap.get(viewNode.mView);
            if (heatMapNode == null || heatMapNode.idx == itemBean.getIdx()) {
                return heatMapNode;
            }
            return null;
        } else {
            return null;
        }
    }

    private boolean isInListView(ViewNode viewNode) {
        return viewNode.mLastListPos != -1;
    }

    private boolean isSpecialView(View view) {
        return (view instanceof Spinner) || (view instanceof RadioGroup);
    }

    private boolean isValueMatch(ViewNode viewNode, HeatMapData heatMapData) {
        String v = heatMapData.getV();
        String str = viewNode.mViewContent;
        return v == str || (v != null && v.equals(str));
    }

    private HeatMapData.ItemBean matchIndex(ViewNode viewNode, HeatMapData.ItemBean[] itemBeanArr) {
        if (itemBeanArr.length != 1 || isInListView(viewNode)) {
            for (HeatMapData.ItemBean itemBean : itemBeanArr) {
                if (itemBean.getIdx() == viewNode.mLastListPos) {
                    return itemBean;
                }
            }
            return null;
        }
        return itemBeanArr[0];
    }

    private void matchNode(ViewNode viewNode) {
        if (Util.isViewClickable(viewNode.mView)) {
            HeatMapNode cacheHeatMapNode = getCacheHeatMapNode(viewNode, null);
            if (cacheHeatMapNode != null) {
                addHeatMapNodeFromCache(cacheHeatMapNode);
                return;
            }
            boolean isSpecialView = isSpecialView(viewNode.mView);
            HeatMapData findBestMatch = findBestMatch(viewNode);
            if (findBestMatch != null) {
                if (isSpecialView) {
                    ViewNode specialViewChildMatchNode = specialViewChildMatchNode(viewNode, findBestMatch);
                    if (specialViewChildMatchNode != null) {
                        generateHeatMapNode(specialViewChildMatchNode, findBestMatch, true);
                        return;
                    }
                    return;
                }
                generateHeatMapNode(viewNode, findBestMatch, false);
            }
        }
    }

    private HeatMapData.ItemBean[] matchValue(ViewNode viewNode, HeatMapData heatMapData) {
        if (heatMapData.getV().equals(viewNode.mViewContent)) {
            return heatMapData.getItems();
        }
        return null;
    }

    private boolean matchXpath(ViewNode viewNode, HeatMapData heatMapData) {
        String x = heatMapData.getX();
        if (x.startsWith("#")) {
            if (GConfig.USE_ID && viewNode.mParentXPath.endsWith(x)) {
                return true;
            }
        } else if (LinkedString.fromString(x).equals(viewNode.mParentXPath)) {
            return true;
        }
        return false;
    }

    private ViewNode specialViewChildMatchNode(ViewNode viewNode, HeatMapData heatMapData) {
        ViewGroup viewGroup = (ViewGroup) viewNode.mView;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ViewNode viewNode2 = ViewHelper.getViewNode(viewGroup.getChildAt(i2), null);
            if (viewNode2.mViewContent.equals(heatMapData.getV())) {
                return viewNode2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void traverse() {
        this.heatMapNodeList.clear();
        ViewHelper.traverseWindows(WindowHelper.getWindowViews(), this);
        this.heatMapView.updateHeatMapNode(this.heatMapNodeList);
        this.isImmediateTraverse = false;
        ThreadUtils.postOnUiThreadDelayed(this.traverseRunnable, 1000L);
    }

    public void beginTraverseImmediately() {
        if (this.isImmediateTraverse) {
            return;
        }
        this.isImmediateTraverse = true;
        ThreadUtils.cancelTaskOnUiThread(this.traverseRunnable);
        ThreadUtils.postOnUiThreadDelayed(this.traverseRunnable, 50L);
    }

    public void clear() {
        this.cacheHeatNodeMap.clear();
        this.heatMapDataArray = new HeatMapData[0];
        this.heatMapDataArrayLength = 0;
        stopTraverse();
    }

    public void stopTraverse() {
        this.isImmediateTraverse = false;
        ThreadUtils.cancelTaskOnUiThread(this.traverseRunnable);
    }

    @Override // com.growingio.android.sdk.models.ViewTraveler
    public void traverseCallBack(ViewNode viewNode) {
        matchNode(viewNode);
    }

    public void updateHeatMapDataArray(HeatMapData[] heatMapDataArr) {
        if (heatMapDataArr == null) {
            return;
        }
        this.heatMapDataArray = heatMapDataArr;
        this.heatMapDataArrayLength = heatMapDataArr.length;
        beginTraverseImmediately();
    }
}
