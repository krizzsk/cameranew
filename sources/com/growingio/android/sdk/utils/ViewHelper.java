package com.growingio.android.sdk.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.base.event.DiagnoseEvent;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.collection.MessageProcessor;
import com.growingio.android.sdk.models.ActionEvent;
import com.growingio.android.sdk.models.ActionStruct;
import com.growingio.android.sdk.models.ViewNode;
import com.growingio.android.sdk.models.ViewTraveler;
import com.growingio.android.sdk.view.FloatViewContainer;
import com.growingio.eventcenter.bus.EventBus;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ViewHelper {
    private static final String TAG = "GIO.ViewHelper";
    private static ViewNodeTraveler changeTraveler = new ViewNodeTraveler();
    private static ViewNodeTraveler sClickTraveler = new ViewNodeTraveler() { // from class: com.growingio.android.sdk.utils.ViewHelper.1
        @Override // com.growingio.android.sdk.models.ViewTraveler
        public boolean needTraverse(ViewNode viewNode) {
            return super.needTraverse(viewNode) && !Util.isViewClickable(viewNode.mView);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ViewNodeTraveler extends ViewTraveler {
        private ArrayList<ActionStruct> actionStructList;
        private long currentTime;

        private ViewNodeTraveler() {
            this.actionStructList = new ArrayList<>();
        }

        public void resetActionStructList() {
            this.currentTime = System.currentTimeMillis();
            this.actionStructList.clear();
        }

        @Override // com.growingio.android.sdk.models.ViewTraveler
        public void traverseCallBack(ViewNode viewNode) {
            if (this.actionStructList != null) {
                ActionStruct actionStruct = new ActionStruct();
                actionStruct.xpath = viewNode.mParentXPath;
                actionStruct.content = viewNode.mViewContent;
                actionStruct.index = viewNode.mLastListPos;
                actionStruct.time = this.currentTime;
                actionStruct.obj = viewNode.mInheritableGrowingInfo;
                this.actionStructList.add(actionStruct);
            }
        }
    }

    public static void changeOn(View view) {
        ViewNode viewNode;
        if (!GConfig.sCanHook || !CoreInitialize.config().isEnabled() || ActivityUtil.findActivity(view.getContext()) == null || Util.isIgnoredView(view) || (viewNode = getViewNode(view, changeTraveler)) == null || !shouldChangeOn(view, viewNode)) {
            return;
        }
        changeTraveler.resetActionStructList();
        changeTraveler.traverseCallBack(viewNode);
        ActionEvent makeChangeEvent = ActionEvent.makeChangeEvent();
        makeChangeEvent.mPageName = CoreInitialize.messageProcessor().getPageNameWithPending();
        makeChangeEvent.elems = changeTraveler.actionStructList;
        makeChangeEvent.setPageTime(CoreInitialize.messageProcessor().getPTMWithPending());
        EventBus.getDefault().post(makeChangeEvent);
    }

    private static View findMenuItemView(View view, MenuItem menuItem) throws InvocationTargetException, IllegalAccessException {
        if (WindowHelper.getMenuItemData(view) == menuItem) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        int i2 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i2 >= viewGroup.getChildCount()) {
                return null;
            }
            View findMenuItemView = findMenuItemView(viewGroup.getChildAt(i2), menuItem);
            if (findMenuItemView != null) {
                return findMenuItemView;
            }
            i2++;
        }
    }

    public static int getChildAdapterPositionInRecyclerView(View view, ViewGroup viewGroup) {
        if (ClassExistHelper.instanceOfAndroidXRecyclerView(viewGroup)) {
            return ((RecyclerView) viewGroup).getChildAdapterPosition(view);
        }
        if (ClassExistHelper.instanceOfSupportRecyclerView(viewGroup)) {
            try {
                return ((RecyclerView) viewGroup).getChildAdapterPosition(view);
            } catch (Throwable unused) {
                return ((RecyclerView) viewGroup).getChildPosition(view);
            }
        } else if (ClassExistHelper.sHasCustomRecyclerView) {
            return ClassExistHelper.invokeCRVGetChildAdapterPositionMethod(viewGroup, view);
        } else {
            return -1;
        }
    }

    public static ActionEvent getClickActionEvent(ViewNode viewNode) {
        if (viewNode == null || viewNode.mView == null || !CoreInitialize.config().isEnabled() || CoreInitialize.coreAppState().getForegroundActivity() == null || Util.isIgnoredView(viewNode.mView)) {
            return null;
        }
        ActionEvent makeClickEvent = ActionEvent.makeClickEvent();
        MessageProcessor messageProcessor = CoreInitialize.messageProcessor();
        makeClickEvent.mPageName = messageProcessor.getPageNameWithPending();
        makeClickEvent.elems = sClickTraveler.actionStructList;
        makeClickEvent.setPageTime(messageProcessor.getPTMWithPending());
        return makeClickEvent;
    }

    public static ViewNode getClickViewNode(MenuItem menuItem) {
        View findMenuItemView;
        View findMenuItemView2;
        if (menuItem == null) {
            return null;
        }
        WindowHelper.init();
        View[] windowViews = WindowHelper.getWindowViews();
        try {
            for (View view : windowViews) {
                if (view.getClass() == WindowHelper.sPopupWindowClazz && (findMenuItemView2 = findMenuItemView(view, menuItem)) != null) {
                    return getClickViewNode(findMenuItemView2);
                }
            }
            for (View view2 : windowViews) {
                if (view2.getClass() != WindowHelper.sPopupWindowClazz && (findMenuItemView = findMenuItemView(view2, menuItem)) != null) {
                    return getClickViewNode(findMenuItemView);
                }
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
        return null;
    }

    public static int getMainWindowCount(View[] viewArr) {
        WindowHelper.init();
        int i2 = 0;
        for (View view : viewArr) {
            if (view != null) {
                i2 += WindowHelper.getWindowPrefix(view).equals(WindowHelper.getMainWindowPrefix()) ? 1 : 0;
            }
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x037b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.growingio.android.sdk.models.ViewNode getViewNode(android.view.View r26, @androidx.annotation.Nullable com.growingio.android.sdk.models.ViewTraveler r27) {
        /*
            Method dump skipped, instructions count: 1118
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.utils.ViewHelper.getViewNode(android.view.View, com.growingio.android.sdk.models.ViewTraveler):com.growingio.android.sdk.models.ViewNode");
    }

    public static boolean isContentView(Activity activity, View view) {
        return (activity == null || view == null || view.getContext() == null || ActivityUtil.findActivity(view.getContext()) != activity) ? false : true;
    }

    @RequiresApi(api = 11)
    public static boolean isViewSelfVisible(View view) {
        if (view == null || view.getWindowVisibility() == 8) {
            return false;
        }
        if (WindowHelper.isDecorView(view)) {
            return true;
        }
        if (view.getWidth() <= 0 || view.getHeight() <= 0 || view.getAlpha() <= 0.0f || !view.getLocalVisibleRect(new Rect())) {
            return false;
        }
        return !(view.getVisibility() == 0 || view.getAnimation() == null || !view.getAnimation().getFillAfter()) || view.getVisibility() == 0;
    }

    public static boolean isWindowNeedTraverse(View view, String str, boolean z) {
        if (view.hashCode() == CoreInitialize.coreAppState().getCurrentRootWindowsHashCode()) {
            return true;
        }
        if (!(view instanceof FloatViewContainer) && (view instanceof ViewGroup)) {
            if (!z) {
                return true;
            }
            if (view.getWindowVisibility() != 8 && view.getVisibility() == 0 && !TextUtils.equals(str, WindowHelper.getMainWindowPrefix()) && view.getWidth() != 0 && view.getHeight() != 0) {
                return true;
            }
        }
        return false;
    }

    public static void persistClickEvent(ActionEvent actionEvent, ViewNode viewNode) {
        EventBus.getDefault().post(actionEvent);
    }

    private static boolean shouldChangeOn(View view, ViewNode viewNode) {
        if (view instanceof EditText) {
            Object tag = view.getTag(AbstractGrowingIO.GROWING_MONITORING_FOCUS_KEY);
            String obj = tag == null ? "" : tag.toString();
            String obj2 = ((EditText) view).getText().toString();
            if ((TextUtils.isEmpty(obj2) && TextUtils.isEmpty(obj)) || obj.equals(obj2)) {
                return false;
            }
            view.setTag(AbstractGrowingIO.GROWING_MONITORING_FOCUS_KEY, obj2);
            return true;
        }
        return false;
    }

    public static void traverseWindow(View view, String str, ViewTraveler viewTraveler) {
        if (view == null) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        ViewNode viewNode = new ViewNode(view, 0, -1, Util.isListView(view), iArr[0] == 0 && iArr[1] == 0, false, false, LinkedString.fromString(str), LinkedString.fromString(str), str, viewTraveler);
        Object tag = view.getTag(AbstractGrowingIO.GROWING_INHERIT_INFO_KEY);
        if (tag instanceof String) {
            viewNode.mInheritableGrowingInfo = (String) tag;
        }
        if (viewNode.isNeedTrack()) {
            if (!WindowHelper.isDecorView(view)) {
                viewNode.traverseViewsRecur();
            } else {
                viewNode.traverseChildren();
            }
        }
    }

    public static void traverseWindows(View[] viewArr, ViewTraveler viewTraveler) {
        boolean z = getMainWindowCount(viewArr) > 1;
        WindowHelper.init();
        try {
            for (View view : viewArr) {
                String windowPrefix = WindowHelper.getWindowPrefix(view);
                if (isWindowNeedTraverse(view, windowPrefix, z)) {
                    traverseWindow(view, windowPrefix, viewTraveler);
                }
            }
        } catch (OutOfMemoryError unused) {
            EventBus.getDefault().post(new DiagnoseEvent("oomt"));
        }
    }

    @RequiresApi(api = 11)
    public static boolean viewVisibilityInParents(View view) {
        if (view != null && isViewSelfVisible(view)) {
            ViewParent parent = view.getParent();
            while (parent instanceof View) {
                if (isViewSelfVisible((View) parent)) {
                    parent = parent.getParent();
                    if (parent == null) {
                        LogUtil.d(TAG, "Hit detached view: ", parent);
                    }
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public static ViewNode getClickViewNode(View view) {
        ViewNode viewNode;
        if (!CoreInitialize.config().isEnabled() || view == null || CoreInitialize.coreAppState().getForegroundActivity() == null || Util.isIgnoredView(view) || (viewNode = getViewNode(view, sClickTraveler)) == null) {
            return null;
        }
        sClickTraveler.resetActionStructList();
        sClickTraveler.traverseCallBack(viewNode);
        viewNode.traverseChildren();
        return viewNode;
    }
}
