package com.growingio.android.sdk.circle.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.AdapterView;
import com.growingio.android.sdk.api.TagStore;
import com.growingio.android.sdk.autoburry.AutoBuryAppState;
import com.growingio.android.sdk.autoburry.AutoBuryObservableInitialize;
import com.growingio.android.sdk.circle.CircleManager;
import com.growingio.android.sdk.circle.HybridEventEditDialog;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.models.Screenshot;
import com.growingio.android.sdk.models.Tag;
import com.growingio.android.sdk.models.ViewNode;
import com.growingio.android.sdk.models.ViewTraveler;
import com.growingio.android.sdk.pending.PendingStatus;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.FloatWindowManager;
import com.growingio.android.sdk.utils.ScreenshotHelper;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.android.sdk.view.FloatViewContainer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
@TargetApi(15)
/* loaded from: classes2.dex */
public class CircleAnchorView extends FloatViewContainer {
    static int ANCHOR_VIEW_SIZE = 0;
    static final String TAG = "GrowingIO.FloatView";
    private final int MAX_OVERLAP_EDGE_DISTANCE;
    private final int UPDATE_CIRCLED_RECORD_DELAYED_TIME;
    private AutoBuryAppState autoBuryAppState;
    private CircleTipMask mCircleTipMaskView;
    private GConfig mConfig;
    private CoreAppState mCoreAppState;
    private Rect mHitRect;
    private List<ViewNode> mHitViewNodes;
    private boolean mIsInTouch;
    private Point mLastMovePoint;
    private CircleMagnifierView mMagnifierView;
    private FloatViewContainer mMaskView;
    private int mMinMoveDistance;
    private View mShowingMaskInWebView;
    private TagsMaskView mTagsView;
    private ViewNode mTopsideHitView;
    private ViewTraveler mTraverseHover;
    private ViewTraveler mTraverseMask;
    private Comparator<ViewNode> mViewNodeComparator;
    private Rect mVisibleRectBuffer;
    private View[] mWindowRootViews;
    private Runnable updateLatestCircledRecordThread;
    private float xDownInScreen;
    private float xInScreen;
    private float xInView;
    private float yDownInScreen;
    private float yInScreen;
    private float yInView;

    public CircleAnchorView(Context context) {
        super(context);
        this.MAX_OVERLAP_EDGE_DISTANCE = 10;
        this.UPDATE_CIRCLED_RECORD_DELAYED_TIME = 20000;
        this.mIsInTouch = false;
        this.mLastMovePoint = null;
        this.mVisibleRectBuffer = new Rect();
        this.mHitViewNodes = new ArrayList();
        this.updateLatestCircledRecordThread = new Runnable() { // from class: com.growingio.android.sdk.circle.view.CircleAnchorView.2
            @Override // java.lang.Runnable
            public void run() {
                TagStore.getInstance().initial();
            }
        };
        this.mViewNodeComparator = new Comparator<ViewNode>() { // from class: com.growingio.android.sdk.circle.view.CircleAnchorView.5
            @Override // java.util.Comparator
            public int compare(ViewNode viewNode, ViewNode viewNode2) {
                return (viewNode2.mView instanceof AdapterView ? -1 : 1) - (viewNode.mView instanceof AdapterView ? -1 : 1);
            }
        };
        this.mTraverseHover = new ViewTraveler() { // from class: com.growingio.android.sdk.circle.view.CircleAnchorView.6
            @Override // com.growingio.android.sdk.models.ViewTraveler
            public boolean needTraverse(ViewNode viewNode) {
                if (ViewHelper.isViewSelfVisible(viewNode.mView)) {
                    Util.getVisibleRectOnScreen(viewNode.mView, CircleAnchorView.this.mVisibleRectBuffer, viewNode.mFullScreen);
                    return CircleAnchorView.this.mVisibleRectBuffer.contains(CircleAnchorView.this.mLastMovePoint.x, CircleAnchorView.this.mLastMovePoint.y);
                }
                return false;
            }

            @Override // com.growingio.android.sdk.models.ViewTraveler
            public void traverseCallBack(ViewNode viewNode) {
                if (Util.isViewClickable(viewNode.mView) || !(viewNode.mInClickableGroup || TextUtils.isEmpty(viewNode.mViewContent))) {
                    CircleAnchorView.this.mHitViewNodes.add(0, viewNode);
                }
            }
        };
        this.mTraverseMask = new ViewTraveler() { // from class: com.growingio.android.sdk.circle.view.CircleAnchorView.7
            @Override // com.growingio.android.sdk.models.ViewTraveler
            public void traverseCallBack(ViewNode viewNode) {
                if (Util.isViewClickable(viewNode.mView) || !(viewNode.mInClickableGroup || TextUtils.isEmpty(viewNode.mViewContent))) {
                    Util.getVisibleRectOnScreen(viewNode.mView, CircleAnchorView.this.mVisibleRectBuffer, viewNode.mFullScreen);
                    CircleAnchorView circleAnchorView = CircleAnchorView.this;
                    if (circleAnchorView.isFuzzyContainRect(circleAnchorView.mHitRect, CircleAnchorView.this.mVisibleRectBuffer)) {
                        double scaledFactor = ScreenshotHelper.getScaledFactor();
                        Screenshot screenshot = new Screenshot();
                        screenshot.x = String.valueOf((int) (CircleAnchorView.this.mVisibleRectBuffer.left * scaledFactor));
                        screenshot.y = String.valueOf((int) (CircleAnchorView.this.mVisibleRectBuffer.top * scaledFactor));
                        screenshot.w = String.valueOf((int) (CircleAnchorView.this.mVisibleRectBuffer.width() * scaledFactor));
                        screenshot.f5098h = String.valueOf((int) (CircleAnchorView.this.mVisibleRectBuffer.height() * scaledFactor));
                        viewNode.mScreenshot = screenshot;
                        CircleAnchorView.this.mHitViewNodes.add(0, viewNode);
                    }
                }
            }
        };
        init();
    }

    private void findTopsideHitView() {
        this.mTopsideHitView = null;
        this.mHitRect = null;
        this.mHitViewNodes.clear();
        ViewHelper.traverseWindows(this.mWindowRootViews, this.mTraverseHover);
        updateMaskViewPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCircleTipMask() {
        FloatWindowManager.getInstance().removeView(this.mCircleTipMaskView);
        this.mCircleTipMaskView = null;
        this.mConfig.setShowCircleTip(false);
    }

    @SuppressLint({"RtlHardcoded"})
    private void initMaskView() {
        this.mMaskView = new FloatViewContainer(getContext());
        float dp2Px = Util.dp2Px(getContext(), 3.0f);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{dp2Px, dp2Px, dp2Px, dp2Px, dp2Px, dp2Px, dp2Px, dp2Px}, null, null));
        shapeDrawable.getPaint().setColor(Constants.GROWINGIO_COLOR_LIGHT_RED);
        shapeDrawable.getPaint().setStrokeWidth(Util.dp2Px(getContext(), 1.0f));
        shapeDrawable.getPaint().setAntiAlias(true);
        this.mMaskView.setBackgroundDrawable(shapeDrawable);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(0, 0, PendingStatus.FLOAT_VIEW_TYPE, 312, -3);
        layoutParams.gravity = 51;
        layoutParams.setTitle("MaskWindow:" + getContext().getPackageName());
        FloatWindowManager.getInstance().addView(this.mMaskView, layoutParams);
        TagsMaskView tagsMaskView = new TagsMaskView(getContext());
        this.mTagsView = tagsMaskView;
        tagsMaskView.setFloatType(PendingStatus.FLOAT_VIEW_TYPE);
        this.mTagsView.show();
        if (this.mConfig.shouldShowTags()) {
            this.mTagsView.setTags(TagStore.getInstance().getTags());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFuzzyContainRect(Rect rect, Rect rect2) {
        return rect.contains(rect2) && rect.width() - rect2.width() < 10 && rect.height() - rect2.height() < 10;
    }

    private void reverseArray(Object[] objArr) {
        if (objArr == null || objArr.length <= 1) {
            return;
        }
        for (int i2 = 0; i2 < objArr.length / 2; i2++) {
            Object obj = objArr[i2];
            objArr[i2] = objArr[(objArr.length - i2) - 1];
            objArr[(objArr.length - i2) - 1] = obj;
        }
    }

    @SuppressLint({"RtlHardcoded"})
    private void showCircleTipIfNeeded() {
        if (this.mConfig.shouldShowCircleTip()) {
            if (this.mCircleTipMaskView == null) {
                this.mCircleTipMaskView = new CircleTipMask(getContext());
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, PendingStatus.FLOAT_VIEW_TYPE, 296, -3);
                layoutParams.gravity = 51;
                layoutParams.setTitle("CircleTipWindow:" + getContext().getPackageName());
                this.mCircleTipMaskView.setLayoutParams(layoutParams);
                this.mCircleTipMaskView.setOnClickListener(new View.OnClickListener() { // from class: com.growingio.android.sdk.circle.view.CircleAnchorView.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        CircleAnchorView.this.hideCircleTipMask();
                    }
                });
            }
            if (this.mCircleTipMaskView.getParent() == null) {
                FloatWindowManager floatWindowManager = FloatWindowManager.getInstance();
                CircleTipMask circleTipMask = this.mCircleTipMaskView;
                floatWindowManager.addView(circleTipMask, (WindowManager.LayoutParams) circleTipMask.getLayoutParams());
                bringToFront();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(DialogFragment dialogFragment, String str) {
        getCircleManager().showDialog(dialogFragment, str);
    }

    private void showEventDetailDialog(String str, List<ViewNode> list) {
        setVisibility(8);
        final HybridEventEditDialog hybridEventEditDialog = new HybridEventEditDialog();
        hybridEventEditDialog.setContent(this.mCoreAppState.getForegroundActivity(), list, this.autoBuryAppState.getPageName(), this.mCoreAppState.getSPN(), new Runnable() { // from class: com.growingio.android.sdk.circle.view.CircleAnchorView.4
            @Override // java.lang.Runnable
            public void run() {
                CircleAnchorView.this.showDialog(hybridEventEditDialog, HybridEventEditDialog.class.getName());
            }
        });
    }

    private void updateLatestCircledRecord() {
        ThreadUtils.cancelTaskOnUiThread(this.updateLatestCircledRecordThread);
        ThreadUtils.postOnUiThreadDelayed(this.updateLatestCircledRecordThread, 20000L);
    }

    private void updateMaskViewPosition() {
        if (this.mHitViewNodes.size() > 0) {
            this.mTopsideHitView = this.mHitViewNodes.get(0);
            Rect rect = new Rect();
            this.mHitRect = rect;
            ViewNode viewNode = this.mTopsideHitView;
            Util.getVisibleRectOnScreen(viewNode.mView, rect, viewNode.mFullScreen);
            View view = this.mTopsideHitView.mView;
            if (!(view instanceof WebView) && !ClassExistHelper.instanceOfX5WebView(view)) {
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.mMaskView.getLayoutParams();
                this.mMaskView.setVisibility(0);
                Rect rect2 = this.mHitRect;
                if (rect2.left != layoutParams.x || rect2.top != layoutParams.y || rect2.width() != layoutParams.width || this.mHitRect.height() != layoutParams.height) {
                    layoutParams.width = this.mHitRect.width();
                    layoutParams.height = this.mHitRect.height();
                    Rect rect3 = this.mHitRect;
                    layoutParams.x = rect3.left;
                    layoutParams.y = rect3.top;
                    FloatWindowManager.getInstance().removeView(this.mMaskView);
                    FloatWindowManager.getInstance().addView(this.mMaskView, layoutParams);
                }
                CircleMagnifierView circleMagnifierView = this.mMagnifierView;
                Rect rect4 = this.mHitRect;
                float f2 = this.xInScreen - this.xInView;
                int i2 = ANCHOR_VIEW_SIZE;
                circleMagnifierView.showIfNeed(rect4, (int) (f2 + (i2 / 2)), (int) ((this.yInScreen - this.yInView) + (i2 / 2)));
                return;
            }
            this.mMaskView.setVisibility(8);
            this.mMagnifierView.setVisibility(8);
            int[] iArr = new int[2];
            this.mTopsideHitView.mView.getLocationOnScreen(iArr);
            hoverOn(this.mTopsideHitView.mView, this.xInScreen - iArr[0], this.yInScreen - iArr[1]);
            this.mShowingMaskInWebView = this.mTopsideHitView.mView;
            return;
        }
        this.mMaskView.setVisibility(8);
        this.mMaskView.getLayoutParams().width = 0;
        this.mMagnifierView.setVisibility(8);
        hideMaskInWebView();
    }

    private void updateViewPosition() {
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
        int i2 = (int) (this.xInScreen - this.xInView);
        int i3 = (int) (this.yInScreen - this.yInView);
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        boolean z = getContext().getResources().getConfiguration().orientation == 1;
        int screenShort = (z ? ScreenshotHelper.getScreenShort() : ScreenshotHelper.getScreenLong()) - getWidth();
        int screenLong = (z ? ScreenshotHelper.getScreenLong() : ScreenshotHelper.getScreenShort()) - getHeight();
        if (i2 > screenShort) {
            i2 = screenShort;
        }
        if (i3 > screenLong) {
            i3 = screenLong;
        }
        int i4 = i3 >= 0 ? i3 : 0;
        layoutParams.x = i2;
        layoutParams.y = i4;
        FloatWindowManager.getInstance().updateViewLayout(this, layoutParams);
    }

    public void findElementAt(View view) {
        Util.callJavaScript(view, "_vds_hybrid.findElementAtPoint", new Object[0]);
        this.mShowingMaskInWebView = view;
    }

    CircleManager getCircleManager() {
        return CircleManager.getInstance();
    }

    public void hideMaskInWebView() {
        View view = this.mShowingMaskInWebView;
        if (view != null) {
            Util.callJavaScript(view, "_vds_hybrid.cancelHover", new Object[0]);
            this.mShowingMaskInWebView = null;
        }
    }

    public void hoverOn(View view, float f2, float f3) {
        Util.callJavaScript(view, "_vds_hybrid.hoverOn", Float.valueOf(f2), Float.valueOf(f3));
    }

    public void init() {
        ANCHOR_VIEW_SIZE = Util.dp2Px(getContext(), 48.0f);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        int i2 = ANCHOR_VIEW_SIZE;
        shapeDrawable.setShape(new RoundRectShape(new float[]{i2 / 2.0f, i2 / 2.0f, i2 / 2.0f, i2 / 2.0f, i2 / 2.0f, i2 / 2.0f, i2 / 2.0f, i2 / 2.0f}, null, null));
        this.mConfig = CoreInitialize.config();
        this.mCoreAppState = CoreInitialize.coreAppState();
        this.autoBuryAppState = AutoBuryObservableInitialize.autoBuryAppState();
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        shapeDrawable.getPaint().setColor(Constants.GROWINGIO_COLOR_RED);
        shapeDrawable.getPaint().setAntiAlias(true);
        setBackgroundDrawable(shapeDrawable);
        this.mMinMoveDistance = Util.dp2Px(getContext(), 4.0f);
        initMaskView();
        this.mMagnifierView = new CircleMagnifierView(getContext());
        setOnClickListener(new View.OnClickListener() { // from class: com.growingio.android.sdk.circle.view.CircleAnchorView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CircleAnchorView.this.getCircleManager().showCircleModeDialog();
                CircleAnchorView.this.setVisibility(8);
                CircleAnchorView.this.mMaskView.setVisibility(8);
                CircleAnchorView.this.mTagsView.setVisibility(8);
                CircleAnchorView.this.hideCircleTipMask();
            }
        });
    }

    public boolean isMoving() {
        return this.mIsInTouch;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0010, code lost:
        if (r0 != 3) goto L9;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r6) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.circle.view.CircleAnchorView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void remove() {
        FloatWindowManager.getInstance().removeView(this);
        FloatWindowManager.getInstance().removeView(this.mMaskView);
        CircleMagnifierView circleMagnifierView = this.mMagnifierView;
        if (circleMagnifierView != null) {
            circleMagnifierView.remove();
        }
        FloatWindowManager.getInstance().removeView(this.mCircleTipMaskView);
        TagsMaskView tagsMaskView = this.mTagsView;
        if (tagsMaskView != null) {
            tagsMaskView.clearTags();
            FloatWindowManager.getInstance().removeView(this.mTagsView);
        }
    }

    public void setTags(List<Tag> list) {
        this.mTagsView.setTags(list);
    }

    @SuppressLint({"RtlHardcoded"})
    public void show() {
        if (this.mConfig.shouldShowTags()) {
            updateLatestCircledRecord();
        }
        showCircleTipIfNeeded();
        if (getParent() == null) {
            Point floatPosition = this.mConfig.getFloatPosition();
            boolean z = getContext().getResources().getConfiguration().orientation == 1;
            if (this.mConfig.shouldShowCircleTip()) {
                floatPosition.x = (ScreenshotHelper.getScreenShort() - ANCHOR_VIEW_SIZE) / 2;
                floatPosition.y = (ScreenshotHelper.getScreenLong() - ANCHOR_VIEW_SIZE) / 2;
            }
            int i2 = ANCHOR_VIEW_SIZE;
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(i2, i2, PendingStatus.FLOAT_VIEW_TYPE, 296, -3);
            layoutParams.gravity = 51;
            layoutParams.x = z ? floatPosition.x : floatPosition.y;
            layoutParams.y = z ? floatPosition.y : floatPosition.x;
            layoutParams.setTitle("AnchorWindow:" + getContext().getPackageName());
            FloatWindowManager.getInstance().addView(this, layoutParams);
            this.mMagnifierView.attachToWindow();
            return;
        }
        setVisibility(0);
        this.mTagsView.setVisibility(0);
        bringToFront();
    }
}
