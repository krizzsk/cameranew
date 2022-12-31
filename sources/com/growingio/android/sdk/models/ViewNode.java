package com.growingio.android.sdk.models;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.ViewPager;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.LinkedString;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.android.sdk.utils.WindowHelper;
import java.util.List;
/* loaded from: classes2.dex */
public class ViewNode {
    public static final String ANONYMOUS_CLASS_NAME = "Anonymous";
    private static final String TAG = "GIO.ViewNode";
    public boolean hybridIsTrackingEditText;
    public String mBannerText;
    public LinkedString mClickableParentXPath;
    public Rect mClipRect;
    public boolean mFullScreen;
    public boolean mHasListParent;
    private int mHashCode;
    public String mImageViewDHashCode;
    public boolean mInClickableGroup;
    public String mInheritableGrowingInfo;
    public int mLastListPos;
    public LinkedString mOriginalParentXpath;
    public boolean mParentIdSettled;
    public LinkedString mParentXPath;
    public String mPatternXPath;
    public Screenshot mScreenshot;
    public View mView;
    public String mViewContent;
    private int mViewIndex;
    public String mViewName;
    public int mViewPosition;
    ViewTraveler mViewTraveler;
    public WebElementInfo mWebElementInfo;
    public String mWindowPrefix;

    /* loaded from: classes2.dex */
    public static class WebElementInfo {
        public String mHost;
        public String mHref;
        public String mNodeType;
        public String mPath;
        public String mQuery;
    }

    public ViewNode() {
        this.mLastListPos = -1;
        this.mParentIdSettled = false;
        this.hybridIsTrackingEditText = false;
        this.mHashCode = -1;
    }

    private void calcXPath() {
        String idName;
        ViewParent parent = this.mView.getParent();
        if (parent != null) {
            if (!WindowHelper.isDecorView(this.mView) || (parent instanceof View)) {
                Object tag = this.mView.getTag(AbstractGrowingIO.GROWING_VIEW_NAME_KEY);
                if (tag != null) {
                    this.mOriginalParentXpath = LinkedString.fromString("/").append(tag);
                    this.mParentXPath.append("/").append(tag);
                    return;
                }
                if (parent instanceof View) {
                    View view = (View) parent;
                    if (view instanceof ExpandableListView) {
                        ExpandableListView expandableListView = (ExpandableListView) view;
                        long expandableListPosition = ((ExpandableListView) this.mView.getParent()).getExpandableListPosition(this.mViewPosition);
                        if (ExpandableListView.getPackedPositionType(expandableListPosition) == 2) {
                            this.mHasListParent = false;
                            if (this.mViewPosition < expandableListView.getHeaderViewsCount()) {
                                this.mOriginalParentXpath.append("/ELH[").append(Integer.valueOf(this.mViewPosition)).append("]/").append(this.mViewName).append("[0]");
                                this.mParentXPath.append("/ELH[").append(Integer.valueOf(this.mViewPosition)).append("]/").append(this.mViewName).append("[0]");
                            } else {
                                int count = this.mViewPosition - (expandableListView.getCount() - expandableListView.getFooterViewsCount());
                                this.mOriginalParentXpath.append("/ELF[").append(Integer.valueOf(count)).append("]/").append(this.mViewName).append("[0]");
                                this.mParentXPath.append("/ELF[").append(Integer.valueOf(count)).append("]/").append(this.mViewName).append("[0]");
                            }
                        } else {
                            int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListPosition);
                            int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListPosition);
                            if (packedPositionChild != -1) {
                                this.mLastListPos = packedPositionChild;
                                this.mParentXPath = LinkedString.fromString(this.mOriginalParentXpath.toStringValue()).append("/ELVG[").append(Integer.valueOf(packedPositionGroup)).append("]/ELVC[-]/").append(this.mViewName).append("[0]");
                                this.mOriginalParentXpath.append("/ELVG[").append(Integer.valueOf(packedPositionGroup)).append("]/ELVC[").append(Integer.valueOf(packedPositionChild)).append("]/").append(this.mViewName).append("[0]");
                            } else {
                                this.mLastListPos = packedPositionGroup;
                                this.mParentXPath = LinkedString.fromString(this.mOriginalParentXpath.toStringValue()).append("/ELVG[-]/").append(this.mViewName).append("[0]");
                                this.mOriginalParentXpath.append("/ELVG[").append(Integer.valueOf(packedPositionGroup)).append("]/").append(this.mViewName).append("[0]");
                            }
                        }
                    } else if (Util.isListView(view)) {
                        Object tag2 = view.getTag(AbstractGrowingIO.GROWING_BANNER_KEY);
                        if (tag2 instanceof List) {
                            List list = (List) tag2;
                            if (list.size() > 0) {
                                int calcBannerItemPosition = Util.calcBannerItemPosition(list, this.mViewPosition);
                                this.mViewPosition = calcBannerItemPosition;
                                this.mBannerText = Util.truncateViewContent(String.valueOf(list.get(calcBannerItemPosition)));
                            }
                        }
                        this.mLastListPos = this.mViewPosition;
                        this.mParentXPath = LinkedString.fromString(this.mOriginalParentXpath.toStringValue()).append("/").append(this.mViewName).append("[-]");
                        this.mOriginalParentXpath.append("/").append(this.mViewName).append("[").append(Integer.valueOf(this.mLastListPos)).append("]");
                    } else if (!ClassExistHelper.instanceofAndroidXSwipeRefreshLayout(parent) && !ClassExistHelper.instanceOfSupportSwipeRefreshLayout(parent)) {
                        this.mOriginalParentXpath.append("/").append(this.mViewName).append("[").append(Integer.valueOf(this.mViewPosition)).append("]");
                        this.mParentXPath.append("/").append(this.mViewName).append("[").append(Integer.valueOf(this.mViewPosition)).append("]");
                    } else {
                        this.mOriginalParentXpath.append("/").append(this.mViewName).append("[0]");
                        this.mParentXPath.append("/").append(this.mViewName).append("[0]");
                    }
                } else {
                    this.mOriginalParentXpath.append("/").append(this.mViewName).append("[").append(Integer.valueOf(this.mViewPosition)).append("]");
                    this.mParentXPath.append("/").append(this.mViewName).append("[").append(Integer.valueOf(this.mViewPosition)).append("]");
                }
                if (!GConfig.USE_ID || (idName = Util.getIdName(this.mView, this.mParentIdSettled)) == null) {
                    return;
                }
                if (this.mView.getTag(AbstractGrowingIO.GROWING_VIEW_ID_KEY) != null) {
                    this.mParentIdSettled = true;
                }
                this.mOriginalParentXpath.append("#").append(idName);
                this.mParentXPath.append("#").append(idName);
            }
        }
    }

    private void identifyRNChangeablePath() {
        ViewParent parent = this.mView.getParent();
        if (parent instanceof View) {
            Object tag = this.mView.getTag(AbstractGrowingIO.GROWING_RN_PAGE_KEY);
            Object tag2 = ((View) parent).getTag(AbstractGrowingIO.GROWING_RN_PAGE_KEY);
            LogUtil.d("GIO.HandleRNView", "IdentifyRNChangeablePath: ", this.mView.getClass().getName());
            LogUtil.d("GIO.HandleRNView", "mParentXPath: ", this.mParentXPath);
            LogUtil.d("GIO.HandleRNView", "viewRNPage: ", tag);
            if (tag == null ? tag2 != null : !tag.equals(tag2)) {
                LogUtil.d("GIO.HandleRNView", "viewParentRNPage: ", tag2);
                removeRNChangeablePath();
            }
        }
    }

    private boolean needTrack() {
        ViewParent parent = this.mView.getParent();
        if (parent != null) {
            if (this.mView.isClickable()) {
                return true;
            }
            View view = this.mView;
            return (view instanceof TextView) || (view instanceof ImageView) || (view instanceof WebView) || (parent instanceof AdapterView) || (parent instanceof RadioGroup) || (view instanceof Spinner) || (view instanceof RatingBar) || (view instanceof SeekBar) || ClassExistHelper.instanceOfX5WebView(view);
        }
        return false;
    }

    private void removeRNChangeablePath() {
        this.mParentXPath = new LinkedString();
        this.mOriginalParentXpath = new LinkedString();
        this.mViewIndex = 0;
    }

    private void viewContent() {
        if (this.mView.getTag(AbstractGrowingIO.GROWING_INHERIT_INFO_KEY) != null) {
            this.mInheritableGrowingInfo = (String) this.mView.getTag(AbstractGrowingIO.GROWING_INHERIT_INFO_KEY);
        }
        this.mViewContent = Util.getViewContent(this.mView, this.mBannerText);
    }

    private void viewPosition() {
        int childAdapterPositionInRecyclerView;
        int i2 = this.mViewIndex;
        if (this.mView.getParent() != null && (this.mView.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.mView.getParent();
            if (ClassExistHelper.instanceOfAndroidXViewPager(viewGroup)) {
                i2 = ((ViewPager) viewGroup).getCurrentItem();
            } else if (ClassExistHelper.instanceOfSupportViewPager(viewGroup)) {
                i2 = ((ViewPager) viewGroup).getCurrentItem();
            } else if (viewGroup instanceof AdapterView) {
                i2 = ((AdapterView) viewGroup).getFirstVisiblePosition() + this.mViewIndex;
            } else if (ClassExistHelper.instanceOfRecyclerView(viewGroup) && (childAdapterPositionInRecyclerView = ViewHelper.getChildAdapterPositionInRecyclerView(this.mView, viewGroup)) >= 0) {
                i2 = childAdapterPositionInRecyclerView;
            }
        }
        this.mViewPosition = i2;
    }

    public ViewNode copyWithoutView() {
        return new ViewNode(null, this.mViewIndex, this.mLastListPos, this.mHasListParent, this.mFullScreen, this.mInClickableGroup, this.mParentIdSettled, LinkedString.fromString(this.mOriginalParentXpath.toStringValue()), LinkedString.fromString(this.mParentXPath.toStringValue()), this.mWindowPrefix, null);
    }

    public boolean equals(Object obj) {
        return (obj instanceof ViewNode) && obj.hashCode() == hashCode();
    }

    public void getVisibleRect(View view, Rect rect, boolean z) {
        if (z) {
            view.getGlobalVisibleRect(rect);
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        view.getLocalVisibleRect(rect);
        rect.offset(iArr[0], iArr[1]);
    }

    public int hashCode() {
        if (this.mHashCode == -1) {
            String str = this.mViewContent;
            int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            LinkedString linkedString = this.mParentXPath;
            int hashCode2 = (hashCode + (linkedString != null ? linkedString.hashCode() : 0)) * 31;
            String str2 = this.mInheritableGrowingInfo;
            this.mHashCode = ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.mLastListPos;
        }
        return this.mHashCode;
    }

    public boolean isIgnoreImp() {
        return this.mView.getTag(AbstractGrowingIO.GROWING_IGNORE_VIEW_IMP_KEY) != null;
    }

    @RequiresApi(api = 11)
    public boolean isNeedTrack() {
        return ViewHelper.isViewSelfVisible(this.mView) && !Util.isIgnoredView(this.mView);
    }

    public void setViewTraveler(ViewTraveler viewTraveler) {
        this.mViewTraveler = viewTraveler;
    }

    public void traverseChildren() {
        View view = this.mView;
        if (!(view instanceof ViewGroup) || (view instanceof Spinner)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            ViewNode viewNode = new ViewNode(viewGroup.getChildAt(i2), i2, this.mLastListPos, this.mHasListParent || Util.isListView(this.mView), this.mFullScreen, this.mInClickableGroup || Util.isViewClickable(this.mView), this.mParentIdSettled, LinkedString.copy(this.mOriginalParentXpath), LinkedString.copy(this.mParentXPath), this.mWindowPrefix, this.mViewTraveler);
            if (Util.isViewClickable(this.mView)) {
                viewNode.mClickableParentXPath = this.mParentXPath;
            } else {
                viewNode.mClickableParentXPath = this.mClickableParentXPath;
            }
            viewNode.mBannerText = this.mBannerText;
            viewNode.mInheritableGrowingInfo = this.mInheritableGrowingInfo;
            viewNode.traverseViewsRecur();
        }
    }

    public void traverseViewsRecur() {
        ViewTraveler viewTraveler = this.mViewTraveler;
        if (viewTraveler == null || !viewTraveler.needTraverse(this)) {
            return;
        }
        this.mViewName = Util.getSimpleClassName(this.mView.getClass());
        viewPosition();
        calcXPath();
        viewContent();
        if (needTrack()) {
            this.mViewTraveler.traverseCallBack(this);
        }
        if (ClassExistHelper.instanceOfX5WebView(this.mView)) {
            return;
        }
        traverseChildren();
    }

    public ViewNode(View view, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, LinkedString linkedString, LinkedString linkedString2, String str, ViewTraveler viewTraveler) {
        this.mLastListPos = -1;
        this.mParentIdSettled = false;
        this.hybridIsTrackingEditText = false;
        this.mHashCode = -1;
        this.mView = view;
        this.mLastListPos = i3;
        this.mFullScreen = z2;
        this.mViewIndex = i2;
        this.mHasListParent = z;
        this.mInClickableGroup = z3;
        this.mParentIdSettled = z4;
        this.mParentXPath = linkedString2;
        this.mOriginalParentXpath = linkedString;
        this.mWindowPrefix = str;
        this.mViewTraveler = viewTraveler;
        if (GConfig.ISRN() && GConfig.isUsingRNOptimizedPath() && this.mView != null) {
            identifyRNChangeablePath();
        }
    }
}
