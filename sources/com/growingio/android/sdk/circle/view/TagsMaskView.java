package com.growingio.android.sdk.circle.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import com.growingio.android.sdk.autoburry.AutoBuryObservableInitialize;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.models.Tag;
import com.growingio.android.sdk.models.ViewNode;
import com.growingio.android.sdk.models.ViewTraveler;
import com.growingio.android.sdk.pending.PendingStatus;
import com.growingio.android.sdk.utils.FloatWindowManager;
import com.growingio.android.sdk.utils.LinkedString;
import com.growingio.android.sdk.utils.ScreenshotHelper;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.android.sdk.utils.WindowHelper;
import com.growingio.android.sdk.view.FloatViewContainer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class TagsMaskView extends FloatViewContainer {
    private int mAnimationOffset;
    private ViewTraveler mFindViewTraveler;
    private int mFloatType;
    private ViewNode mSameListItemNode;
    private List<ViewNode> mTagNodes;

    public TagsMaskView(Context context) {
        super(context);
        this.mAnimationOffset = 0;
        this.mFindViewTraveler = new ViewTraveler() { // from class: com.growingio.android.sdk.circle.view.TagsMaskView.1
            float radius;
            ShapeDrawable redBackground;
            ShapeDrawable yellowBackground;

            {
                this.radius = Util.dp2Px(TagsMaskView.this.getContext(), 3.0f);
                float f2 = this.radius;
                this.redBackground = new ShapeDrawable(new RoundRectShape(new float[]{f2, f2, f2, f2, f2, f2, f2, f2}, null, null));
                float f3 = this.radius;
                this.yellowBackground = new ShapeDrawable(new RoundRectShape(new float[]{f3, f3, f3, f3, f3, f3, f3, f3}, null, null));
                this.redBackground.getPaint().setColor(Constants.GROWINGIO_COLOR_LIGHT_RED);
                this.redBackground.getPaint().setStrokeWidth(Util.dp2Px(TagsMaskView.this.getContext(), 1.0f));
                this.redBackground.getPaint().setAntiAlias(true);
                this.yellowBackground.getPaint().setColor(Constants.GROWINGIO_COLOR_LIGHT_YELLOW);
                this.yellowBackground.getPaint().setStrokeWidth(Util.dp2Px(TagsMaskView.this.getContext(), 1.0f));
                this.yellowBackground.getPaint().setAntiAlias(true);
            }

            void addMask(ViewNode viewNode) {
                TagMask tagMask = new TagMask(TagsMaskView.this.getContext());
                tagMask.setBackgroundDrawable(TagsMaskView.this.mSameListItemNode != null ? this.redBackground : this.yellowBackground);
                TagsMaskView.this.addView(tagMask);
                Rect rect = new Rect();
                Util.getVisibleRectOnScreen(viewNode.mView, rect, viewNode.mFullScreen);
                tagMask.updatePosition(rect);
                if (TagsMaskView.this.mSameListItemNode != null) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(150L);
                    alphaAnimation.setStartOffset(TagsMaskView.access$208(TagsMaskView.this) * 30);
                    tagMask.startAnimation(alphaAnimation);
                }
            }

            boolean match(ViewNode viewNode, ViewNode viewNode2) {
                String str;
                int i2;
                LinkedString linkedString = viewNode.mParentXPath;
                String stringValue = linkedString == null ? "" : linkedString.toStringValue();
                LinkedString linkedString2 = viewNode2.mParentXPath;
                return Util.isIdentifyXPath(stringValue, linkedString2 != null ? linkedString2.toStringValue() : "") && ((str = viewNode.mViewContent) == null || str.equals(viewNode2.mViewContent)) && ((i2 = viewNode.mLastListPos) == -2 || i2 == viewNode2.mLastListPos);
            }

            @Override // com.growingio.android.sdk.models.ViewTraveler
            public void traverseCallBack(ViewNode viewNode) {
                if (TagsMaskView.this.mSameListItemNode != null) {
                    if (TagsMaskView.this.mSameListItemNode.mParentXPath == null || !TagsMaskView.this.mSameListItemNode.mParentXPath.equals(viewNode.mParentXPath)) {
                        return;
                    }
                    addMask(viewNode);
                    return;
                }
                for (ViewNode viewNode2 : TagsMaskView.this.mTagNodes) {
                    if (match(viewNode2, viewNode)) {
                        addMask(viewNode);
                    }
                }
            }
        };
        this.mTagNodes = new ArrayList();
    }

    static /* synthetic */ int access$208(TagsMaskView tagsMaskView) {
        int i2 = tagsMaskView.mAnimationOffset;
        tagsMaskView.mAnimationOffset = i2 + 1;
        return i2;
    }

    public void addTag(Tag tag) {
        Activity foregroundActivity = CoreInitialize.coreAppState().getForegroundActivity();
        if (foregroundActivity != null) {
            String pageName = AutoBuryObservableInitialize.autoBuryAppState().getPageName(foregroundActivity);
            String str = tag.filter.path;
            if (str == null || str.length() == 0 || tag.filter.path.equals(pageName)) {
                ViewNode viewNode = new ViewNode();
                if (!TextUtils.isEmpty(tag.filter.content)) {
                    viewNode.mViewContent = tag.filter.content;
                }
                boolean z = !TextUtils.isEmpty(tag.filter.index);
                viewNode.mHasListParent = z;
                if (z) {
                    try {
                        viewNode.mLastListPos = Integer.valueOf(tag.filter.index).intValue();
                    } catch (NumberFormatException unused) {
                        viewNode.mLastListPos = -2;
                    }
                } else {
                    viewNode.mLastListPos = -2;
                }
                viewNode.mParentXPath = LinkedString.fromString(tag.filter.xpath);
                this.mTagNodes.add(viewNode);
            }
        }
    }

    public void clearTags() {
        this.mTagNodes.clear();
        removeAllViews();
    }

    public void hideSameListItemNode() {
        setVisibility(8);
        this.mSameListItemNode = null;
        removeAllViews();
    }

    public void setFloatType(int i2) {
        this.mFloatType = i2;
    }

    public void setTags(List<Tag> list) {
        clearTags();
        if (list == null || list.size() == 0 || !PendingStatus.mCanShowCircleTag) {
            return;
        }
        String spn = CoreInitialize.coreAppState().getSPN();
        for (Tag tag : list) {
            if (tag.eventType.equals("elem") && spn.equals(tag.filter.domain)) {
                addTag(tag);
            }
        }
        if (this.mTagNodes.size() > 0) {
            ViewHelper.traverseWindows(WindowHelper.getWindowViews(), this.mFindViewTraveler);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void show() {
        if (getParent() != null) {
            setVisibility(0);
            return;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(ScreenshotHelper.getScreenShort(), ScreenshotHelper.getScreenLong(), this.mFloatType, 824, -3);
        layoutParams.gravity = 51;
        layoutParams.setTitle("TagsWindow:" + getContext().getPackageName());
        FloatWindowManager.getInstance().addView(this, layoutParams);
    }

    public void showSameListItemNode(ViewNode viewNode) {
        this.mSameListItemNode = viewNode;
        removeAllViews();
        setVisibility(0);
        this.mAnimationOffset = 0;
        ViewHelper.traverseWindows(WindowHelper.getWindowViews(), this.mFindViewTraveler);
    }
}
