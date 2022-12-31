package com.growingio.android.sdk.circle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.util.Base64;
import android.view.View;
import com.growingio.android.sdk.autoburry.AutoBuryObservableInitialize;
import com.growingio.android.sdk.circle.utils.CircleUtil;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.models.PageEvent;
import com.growingio.android.sdk.models.ViewNode;
import com.growingio.android.sdk.models.ViewTraveler;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.ScreenshotHelper;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.android.sdk.utils.WindowHelper;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ScreenshotInfo {
    private WeakReference<Activity> activityWeakReference;
    private int currentZIndex;
    private String mEncodeScreenshot;
    private String mPageName;
    private String mSPN;
    private ViewNode mTarget;
    private JSONArray mTargetImp;
    private final String TAG = "GIO.ScreenshotInfo";
    private JSONArray mViewLayouts = new JSONArray();
    private ViewTraveler mTraverseCallBack = new ViewTraveler() { // from class: com.growingio.android.sdk.circle.ScreenshotInfo.2
        @Override // com.growingio.android.sdk.models.ViewTraveler
        public boolean needTraverse(ViewNode viewNode) {
            return super.needTraverse(viewNode) || Util.isIgnoredView(viewNode.mView);
        }

        @Override // com.growingio.android.sdk.models.ViewTraveler
        public void traverseCallBack(ViewNode viewNode) {
            JSONObject impressObj = CircleUtil.getImpressObj(viewNode);
            ScreenshotInfo.this.addDomainAndPageAndZIndex(impressObj, viewNode);
            if (impressObj != null) {
                ScreenshotInfo.this.mViewLayouts.put(impressObj);
            }
        }
    };

    public ScreenshotInfo(Activity activity, List<ViewNode> list, ViewNode viewNode) {
        this.activityWeakReference = null;
        this.activityWeakReference = new WeakReference<>(activity);
        this.mTarget = viewNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDomainAndPageAndZIndex(JSONObject jSONObject, ViewNode viewNode) {
        if (jSONObject == null) {
            return;
        }
        String str = this.mPageName;
        String str2 = this.mSPN;
        if (viewNode.mWebElementInfo != null) {
            str = this.mPageName + Constants.WEB_PART_SEPARATOR + viewNode.mWebElementInfo.mPath;
            str2 = this.mSPN + Constants.WEB_PART_SEPARATOR + viewNode.mWebElementInfo.mHost;
        }
        try {
            jSONObject.put("domain", str2);
            int i2 = this.currentZIndex;
            this.currentZIndex = i2 + 1;
            jSONObject.put("zLevel", i2);
            jSONObject.put(PageEvent.TYPE_NAME, str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private JSONArray getImpress(View[] viewArr) {
        this.mViewLayouts = new JSONArray();
        this.currentZIndex = 0;
        ViewHelper.traverseWindows(viewArr, this.mTraverseCallBack);
        return this.mViewLayouts;
    }

    @TargetApi(8)
    public JSONObject getScreenShotInfo() {
        Activity activity = this.activityWeakReference.get();
        JSONObject jSONObject = new JSONObject();
        if (activity != null) {
            View[] sortedWindowViews = WindowHelper.getSortedWindowViews();
            boolean z = activity.getResources().getConfiguration().orientation != 2;
            byte[] captureAllWindows = ScreenshotHelper.captureAllWindows(sortedWindowViews, null);
            try {
                this.mPageName = AutoBuryObservableInitialize.autoBuryAppState().getPageName(activity);
                this.mSPN = CoreInitialize.coreAppState().getSPN();
                jSONObject.put(PageEvent.TYPE_NAME, this.mPageName);
                jSONObject.put("screenshotWidth", z ? ScreenshotHelper.getScaledShort() : ScreenshotHelper.getScaledLong());
                jSONObject.put("screenshotHeight", z ? ScreenshotHelper.getScaledLong() : ScreenshotHelper.getScaledShort());
                jSONObject.put("scaled", ScreenshotHelper.getScaledFactor());
                jSONObject.put("title", activity.getTitle());
                this.mEncodeScreenshot = "data:image/jpeg;base64," + Base64.encodeToString(captureAllWindows, 2);
                jSONObject.put("impress", getImpress(sortedWindowViews));
                if (this.mTarget != null) {
                    this.mTargetImp = new JSONArray();
                    ViewTraveler viewTraveler = new ViewTraveler() { // from class: com.growingio.android.sdk.circle.ScreenshotInfo.1
                        @Override // com.growingio.android.sdk.models.ViewTraveler
                        public void traverseCallBack(ViewNode viewNode) {
                            JSONObject impressObj = CircleUtil.getImpressObj(viewNode);
                            if (impressObj != null) {
                                ScreenshotInfo.this.mTargetImp.put(impressObj);
                            }
                        }
                    };
                    viewTraveler.traverseCallBack(this.mTarget);
                    this.mTarget.setViewTraveler(viewTraveler);
                    this.mTarget.traverseChildren();
                    jSONObject.put("targets", this.mTargetImp);
                }
                jSONObject.put("screenshot", this.mEncodeScreenshot);
            } catch (JSONException e2) {
                LogUtil.d("GIO.ScreenshotInfo", "generate screenshot data error", e2);
            }
        }
        return jSONObject;
    }
}
