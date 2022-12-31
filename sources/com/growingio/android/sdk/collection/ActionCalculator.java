package com.growingio.android.sdk.collection;

import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.autoburry.VdsJsBridgeManager;
import com.growingio.android.sdk.models.ActionEvent;
import com.growingio.android.sdk.models.ActionStruct;
import com.growingio.android.sdk.models.ViewNode;
import com.growingio.android.sdk.models.ViewTraveler;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.ImplEventAsyncExecutor;
import com.growingio.android.sdk.utils.SysTrace;
import com.growingio.android.sdk.utils.ViewHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class ActionCalculator {
    static final String TAG = "GIO.ActionCalculator";
    List<ActionStruct> mNewImpressViews;
    private String mPage;
    private long mPtm;
    private WeakReference<View> mRootView;
    private final String mWindowPrefix;
    private SparseBooleanArray mImpressedViews = new SparseBooleanArray();
    private List<WeakReference<View>> mImpressedWebView = new ArrayList();
    private List<ViewNode> mTodoViewNode = new ArrayList();
    private ViewTraveler mViewTraveler = new ViewTraveler() { // from class: com.growingio.android.sdk.collection.ActionCalculator.1
        @Override // com.growingio.android.sdk.models.ViewTraveler
        public boolean needTraverse(ViewNode viewNode) {
            return super.needTraverse(viewNode) && !viewNode.isIgnoreImp();
        }

        @Override // com.growingio.android.sdk.models.ViewTraveler
        public void traverseCallBack(ViewNode viewNode) {
            if (!ActionCalculator.this.mConfig.isImageViewCollectionEnable() || !(viewNode.mView instanceof ImageView) || !TextUtils.isEmpty(viewNode.mViewContent)) {
                boolean z = true;
                boolean z2 = false;
                if (ActionCalculator.this.mImpressedViews.get(viewNode.hashCode())) {
                    z = false;
                } else {
                    ActionStruct genActionStruct = ActionCalculator.genActionStruct(viewNode);
                    ActionCalculator.this.mImpressedViews.put(viewNode.hashCode(), true);
                    ActionCalculator.this.mNewImpressViews.add(genActionStruct);
                }
                View view = viewNode.mView;
                if ((view instanceof WebView) || ClassExistHelper.instanceOfX5WebView(view)) {
                    Iterator it = ActionCalculator.this.mImpressedWebView.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = z;
                            break;
                        } else if (((WeakReference) it.next()).get() == viewNode.mView) {
                            break;
                        }
                    }
                    if (z2) {
                        ActionCalculator.this.mImpressedWebView.add(new WeakReference(viewNode.mView));
                        VdsJsBridgeManager.refreshImpressionForce(viewNode.mView);
                        return;
                    }
                    return;
                }
                return;
            }
            ActionCalculator.this.mTodoViewNode.add(viewNode);
        }
    };
    private GConfig mConfig = CoreInitialize.config();

    public ActionCalculator(String str, long j2, View view, String str2) {
        this.mPtm = j2;
        this.mRootView = new WeakReference<>(view);
        this.mPage = str;
        this.mWindowPrefix = str2;
    }

    public static ActionStruct genActionStruct(ViewNode viewNode) {
        ActionStruct actionStruct = new ActionStruct();
        actionStruct.xpath = viewNode.mParentXPath;
        actionStruct.time = System.currentTimeMillis();
        actionStruct.index = viewNode.mLastListPos;
        actionStruct.content = viewNode.mViewContent;
        actionStruct.obj = viewNode.mInheritableGrowingInfo;
        actionStruct.imgHashcode = viewNode.mImageViewDHashCode;
        return actionStruct;
    }

    public String getPage() {
        return this.mPage;
    }

    public long getPtm() {
        return this.mPtm;
    }

    ActionEvent makeActionEvent(List<ActionEvent> list) {
        int size = this.mNewImpressViews.size();
        ActionEvent actionEvent = null;
        if (size <= 0) {
            return null;
        }
        int i2 = 0;
        while (i2 < size) {
            int min = Math.min(i2 + 100, size);
            List<ActionStruct> subList = this.mNewImpressViews.subList(i2, min);
            ActionEvent makeImpEvent = ActionEvent.makeImpEvent();
            makeImpEvent.elems = subList;
            makeImpEvent.setPageTime(this.mPtm);
            makeImpEvent.mPageName = this.mPage;
            list.add(makeImpEvent);
            i2 = min;
            actionEvent = makeImpEvent;
        }
        return actionEvent;
    }

    @Nullable
    public List<ActionEvent> obtainImpress() {
        SysTrace.beginSection("gio.obtainImpress");
        GConfig gConfig = this.mConfig;
        ArrayList arrayList = null;
        if (gConfig != null && gConfig.shouldSendImp()) {
            this.mNewImpressViews = new ArrayList();
            WeakReference<View> weakReference = this.mRootView;
            if (weakReference != null && weakReference.get() != null && this.mRootView.get().getTag(AbstractGrowingIO.GROWING_IGNORE_VIEW_IMP_KEY) == null) {
                ViewHelper.traverseWindow(this.mRootView.get(), this.mWindowPrefix, this.mViewTraveler);
            }
            ArrayList arrayList2 = new ArrayList(2);
            ActionEvent makeActionEvent = makeActionEvent(arrayList2);
            this.mNewImpressViews = null;
            if (this.mTodoViewNode.size() > 0) {
                if (makeActionEvent == null) {
                    makeActionEvent = ActionEvent.makeImpEvent();
                    makeActionEvent.setPageTime(this.mPtm);
                    makeActionEvent.mPageName = this.mPage;
                }
                ImplEventAsyncExecutor.getInstance().execute(makeActionEvent, this.mTodoViewNode);
                this.mTodoViewNode = new ArrayList();
                SysTrace.endSection();
                return null;
            }
            arrayList = arrayList2;
        }
        SysTrace.endSection();
        return arrayList;
    }
}
