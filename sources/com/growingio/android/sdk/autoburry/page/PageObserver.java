package com.growingio.android.sdk.autoburry.page;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.viewpager.widget.ViewPager;
import com.growingio.android.sdk.autoburry.AutoBuryAppState;
import com.growingio.android.sdk.autoburry.AutoBuryMessageProcessor;
import com.growingio.android.sdk.autoburry.AutoBuryObservableInitialize;
import com.growingio.android.sdk.autoburry.SuperFragment;
import com.growingio.android.sdk.autoburry.SuperViewPager;
import com.growingio.android.sdk.autoburry.page.visitor.ListenerInfoVisitor;
import com.growingio.android.sdk.base.event.ActivityLifecycleEvent;
import com.growingio.android.sdk.base.event.ViewTreeStatusChangeEvent;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.ImpressionMark;
import com.growingio.android.sdk.collection.MessageProcessor;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.SysTrace;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.bus.SubscriberMethod;
import com.growingio.eventcenter.bus.ThreadMode;
import com.growingio.eventcenter.bus.meta.Subscriber;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class PageObserver implements Subscriber {
    private static final String TAG = "GIO.PageObserver";
    private static Callback callback;
    private static final Handler mHander = new Handler(Looper.getMainLooper());
    private CoreAppState coreAppState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class Callback implements Runnable {
        private AutoBuryAppState autoBuryAppState;
        private int currentHeight;
        private Object currentPageObj;
        private int currentWidth;
        private WeakReference<Activity> mActivity;
        private long nextForceRefreshTimeMill = -1;
        private ListenerInfoVisitor onlickListenerVisitor = new ListenerInfoVisitor();
        private Rect mRectBuff = new Rect();
        private int[] mPointBuff = new int[2];

        public Callback(AutoBuryAppState autoBuryAppState) {
            this.autoBuryAppState = autoBuryAppState;
        }

        private void checkAndSendPage(Activity activity) {
            MessageProcessor messageProcessor = CoreInitialize.messageProcessor();
            AutoBuryMessageProcessor autoBuryMessageProcessor = AutoBuryObservableInitialize.autoBuryMessageProcessor();
            Object foregroundFragment = this.autoBuryAppState.getForegroundFragment();
            Object obj = this.currentPageObj;
            if (obj != null) {
                if (foregroundFragment != obj) {
                    LogUtil.d(PageObserver.TAG, "found different special page, and send page: ", obj);
                    if (foregroundFragment != null) {
                        this.autoBuryAppState.onPageFragmentInvisible(SuperFragment.createSuperFragment(foregroundFragment));
                    }
                    this.autoBuryAppState.onPageFragmentVisible(SuperFragment.createSuperFragment(this.currentPageObj));
                    return;
                }
                return;
            }
            boolean z = messageProcessor.isLastEventPage(activity) || messageProcessor.isPendingPage(activity);
            this.autoBuryAppState.clearForegroundFragment(activity);
            if (z) {
                return;
            }
            LogUtil.d(PageObserver.TAG, "checkAndSendPage, no special page, and send activity page");
            autoBuryMessageProcessor.savePageForPureActivity(activity);
        }

        private void choiceBestPage(LinkedList<Pair<View, Object>> linkedList) {
            if (linkedList.size() == 0) {
                return;
            }
            Object obj = null;
            if (linkedList.size() == 1) {
                obj = linkedList.getFirst().second;
            } else {
                Iterator<Pair<View, Object>> it = linkedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Pair<View, Object> next = it.next();
                    View view = (View) next.first;
                    if (view.getWidth() * 3 >= this.currentWidth && view.getHeight() * 3 >= this.currentHeight) {
                        obj = next.second;
                        break;
                    }
                    LogUtil.d(PageObserver.TAG, "choiceBestPage, found pageView's height or width not valid: ", next.second);
                }
                if (obj == null) {
                    obj = linkedList.getFirst().second;
                }
            }
            LogUtil.d(PageObserver.TAG, "choiceBestPage, and special page size: ", Integer.valueOf(linkedList.size()), ", and choice best page: ", obj);
            this.currentPageObj = obj;
        }

        private Pair<View, Object> findLargerVisiblePage(Pair<View, Object> pair, Pair<View, Object> pair2) {
            if (pair2 == null) {
                return pair;
            }
            if (pair == null) {
                return pair2;
            }
            ((View) pair.first).getGlobalVisibleRect(this.mRectBuff);
            int width = this.mRectBuff.width() * this.mRectBuff.height();
            ((View) pair2.first).getGlobalVisibleRect(this.mRectBuff);
            return width >= this.mRectBuff.width() * this.mRectBuff.height() ? pair : pair2;
        }

        private Pair<View, Object> findPageView(Activity activity, View view, ViewParent viewParent) {
            Object isPageView;
            Pair<View, Object> pair = null;
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (ViewHelper.isViewSelfVisible(childAt)) {
                        pair = findLargerVisiblePage(pair, findPageView(activity, childAt, viewGroup));
                    }
                }
            }
            return (pair != null || viewParent == null || (isPageView = isPageView(activity, view, viewParent)) == null) ? pair : Pair.create(view, isPageView);
        }

        private void focusListenerAndImp(View view) {
            if (view instanceof ViewGroup) {
                LinkedList linkedList = new LinkedList();
                linkedList.add((ViewGroup) view);
                while (!linkedList.isEmpty()) {
                    ViewGroup viewGroup = (ViewGroup) linkedList.pop();
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        Object tag = childAt.getTag();
                        if (tag instanceof String) {
                            String str = (String) tag;
                            if (str.startsWith("gio-tag-") && childAt.getTag(AbstractGrowingIO.GROWING_IMP_TAG_MARKED) == null) {
                                String substring = str.substring(8);
                                if (!TextUtils.isEmpty(substring)) {
                                    LogUtil.d(PageObserver.TAG, "found impView with eventId: ", substring);
                                    AutoBuryObservableInitialize.impObserver().markViewImpression(new ImpressionMark(childAt, substring));
                                }
                            }
                        }
                        if (childAt instanceof ViewGroup) {
                            linkedList.add((ViewGroup) childAt);
                        } else if (childAt instanceof EditText) {
                            this.onlickListenerVisitor.handle(childAt);
                        }
                    }
                }
            }
        }

        private Object isPageView(Activity activity, View view, ViewParent viewParent) {
            SuperViewPager v4ViewPager;
            if (ClassExistHelper.instanceOfAndroidXViewPager(viewParent)) {
                v4ViewPager = new SuperViewPager.AndroidXViewPager((ViewPager) viewParent);
            } else {
                v4ViewPager = ClassExistHelper.instanceOfSupportViewPager(viewParent) ? new SuperViewPager.V4ViewPager((ViewPager) viewParent) : null;
            }
            if (v4ViewPager != null) {
                if (view != v4ViewPager.getCurrentView()) {
                    return null;
                }
                if (v4ViewPager.isFragmentViewPager()) {
                    Object currentItemObj = v4ViewPager.getCurrentItemObj();
                    if (this.autoBuryAppState.shouldTrackFragment(SuperFragment.createSuperFragment(currentItemObj))) {
                        LogUtil.d(PageObserver.TAG, "isPageView, found fragment needed track: ", currentItemObj);
                        return currentItemObj;
                    } else if (this.autoBuryAppState.isTrackCustomFragment(activity, (ViewGroup) viewParent)) {
                        LogUtil.d(PageObserver.TAG, "isPageView, found custom fragment needed track: ", viewParent);
                        return view;
                    }
                } else if (this.autoBuryAppState.isTrackCustomFragment(activity, (ViewGroup) viewParent)) {
                    LogUtil.d(PageObserver.TAG, "isPageView, found custom fragment(not fragment PageAdapter)", viewParent);
                    return view;
                }
            }
            return this.autoBuryAppState.getFragmentByView(activity, view);
        }

        private void resolveCenterPageObj(Activity activity, View view) {
            this.currentWidth = view.getWidth();
            int height = view.getHeight();
            this.currentHeight = height;
            int i2 = this.currentWidth / 2;
            int i3 = (height * 3) / 5;
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            linkedList2.add((ViewGroup) view);
            while (!linkedList2.isEmpty()) {
                ViewGroup viewGroup = (ViewGroup) linkedList2.pop();
                if (ViewHelper.isViewSelfVisible(viewGroup)) {
                    int childCount = viewGroup.getChildCount();
                    boolean z = false;
                    for (int i4 = 0; i4 < childCount; i4++) {
                        View childAt = viewGroup.getChildAt(i4);
                        Util.getVisibleRectOnScreen(childAt, this.mRectBuff, false, this.mPointBuff);
                        if (this.mRectBuff.contains(i2, i3)) {
                            if (childAt instanceof ViewGroup) {
                                linkedList2.add((ViewGroup) childAt);
                            } else {
                                linkedList.add(childAt);
                            }
                            z = true;
                        }
                    }
                    if (!z) {
                        linkedList.add(viewGroup);
                    }
                }
            }
            HashSet hashSet = new HashSet();
            LinkedList<Pair<View, Object>> linkedList3 = new LinkedList<>();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                View view2 = (View) it.next();
                while (view2 != null && view2 != view) {
                    ViewParent parent = view2.getParent();
                    Object isPageView = isPageView(activity, view2, parent);
                    if (isPageView != null) {
                        LogUtil.d(PageObserver.TAG, "found page view: ", view2, ", and pageObj: ", isPageView);
                        linkedList3.add(Pair.create(view2, isPageView));
                        break;
                    } else if (parent == view) {
                        break;
                    } else {
                        view2 = (View) parent;
                        if (hashSet.contains(view2)) {
                            break;
                        }
                        hashSet.add(view2);
                    }
                }
            }
            choiceBestPage(linkedList3);
        }

        private void resolveLargerChildPage(Activity activity, View view) {
            Pair<View, Object> findPageView = findPageView(activity, view, null);
            this.currentPageObj = findPageView != null ? findPageView.second : null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activity;
            try {
                SysTrace.beginSection("gio.PageRun");
                activity = this.mActivity.get();
            } finally {
                try {
                } finally {
                }
            }
            if (activity == null) {
                LogUtil.e(PageObserver.TAG, "mActivity == null");
                return;
            }
            if (!this.autoBuryAppState.isPageManualModel(activity)) {
                this.currentPageObj = null;
                resolveLargerChildPage(activity, activity.getWindow().getDecorView());
                checkAndSendPage(activity);
                this.currentPageObj = null;
            }
            focusListenerAndImp(activity.getWindow().getDecorView());
        }

        public void setActivity(Activity activity) {
            this.mActivity = new WeakReference<>(activity);
        }
    }

    public PageObserver(CoreAppState coreAppState, AutoBuryAppState autoBuryAppState) {
        this.coreAppState = coreAppState;
        callback = new Callback(autoBuryAppState);
    }

    private static void post(Activity activity) {
        Handler handler = mHander;
        handler.removeCallbacks(callback);
        callback.setActivity(activity);
        if (System.currentTimeMillis() >= callback.nextForceRefreshTimeMill) {
            LogUtil.d(TAG, "last callback time over three seconds, and force refresh page");
            callback.run();
            return;
        }
        handler.postDelayed(callback, 200L);
    }

    public static void scheduleViewPageDetectByFragmentChange(Activity activity) {
        Callback callback2 = callback;
        if (callback2 == null) {
            return;
        }
        callback2.nextForceRefreshTimeMill = System.currentTimeMillis() + 200;
        if (activity != null) {
            post(activity);
        }
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public void do$Action(String str, Object obj) {
        if (str.equals("#onActivityLifecycle(com.growingio.android.sdk.base.event.ActivityLifecycleEvent")) {
            onActivityLifecycle((ActivityLifecycleEvent) obj);
        } else if (str.equals("#onViewTreeChanged(com.growingio.android.sdk.base.event.ViewTreeStatusChangeEvent")) {
            onViewTreeChanged((ViewTreeStatusChangeEvent) obj);
        } else {
            System.out.println("No such method to delegate");
        }
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public SubscriberMethod[] get$SubscriberMethods() {
        ThreadMode threadMode = ThreadMode.POSTING;
        return new SubscriberMethod[]{new SubscriberMethod("onActivityLifecycle", ActivityLifecycleEvent.class, "#onActivityLifecycle(com.growingio.android.sdk.base.event.ActivityLifecycleEvent", threadMode, 0, false), new SubscriberMethod("onViewTreeChanged", ViewTreeStatusChangeEvent.class, "#onViewTreeChanged(com.growingio.android.sdk.base.event.ViewTreeStatusChangeEvent", threadMode, 0, false)};
    }

    @Subscribe
    public void onActivityLifecycle(ActivityLifecycleEvent activityLifecycleEvent) {
        Activity activity = activityLifecycleEvent.getActivity();
        if (activity == null) {
            return;
        }
        ActivityLifecycleEvent.EVENT_TYPE event_type = activityLifecycleEvent.event_type;
        if (event_type == ActivityLifecycleEvent.EVENT_TYPE.ON_RESUMED) {
            callback.nextForceRefreshTimeMill = System.currentTimeMillis() + 200;
            post(activity);
        } else if (event_type == ActivityLifecycleEvent.EVENT_TYPE.ON_PAUSED) {
            mHander.removeCallbacks(callback);
        }
    }

    @Subscribe
    public void onViewTreeChanged(ViewTreeStatusChangeEvent viewTreeStatusChangeEvent) {
        Activity resumedActivity = this.coreAppState.getResumedActivity();
        if (resumedActivity != null) {
            post(resumedActivity);
        }
    }
}
