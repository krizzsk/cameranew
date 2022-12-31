package com.growingio.android.sdk.autoburry;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.growingio.android.sdk.base.event.ActivityLifecycleEvent;
import com.growingio.android.sdk.base.event.ViewTreeDrawEvent;
import com.growingio.android.sdk.base.event.ViewTreeStatusChangeEvent;
import com.growingio.android.sdk.base.event.ViewTreeWindowFocusChangedEvent;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.ImpressionMark;
import com.growingio.android.sdk.utils.ActivityUtil;
import com.growingio.android.sdk.utils.JsonUtil;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.ObjectUtils;
import com.growingio.android.sdk.utils.SysTrace;
import com.growingio.android.sdk.utils.TimerToggler;
import com.growingio.android.sdk.utils.Util;
import com.growingio.android.sdk.utils.ViewHelper;
import com.growingio.android.sdk.utils.WeakSet;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.EventCenter;
import com.growingio.eventcenter.bus.EventBus;
import com.growingio.eventcenter.bus.SubscriberMethod;
import com.growingio.eventcenter.bus.ThreadMode;
import com.growingio.eventcenter.bus.meta.Subscriber;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ImpObserver implements Subscriber {
    private static final String GIO_CONTENT = "gio_v";
    private static final String TAG = "GIO.Imp";
    private final CoreAppState coreAppState;
    @VisibleForTesting
    WeakHashMap<Activity, ActivityScope> mActivityScopes;
    private Set<String> mTmpGlobalIds;
    private Rect mTmpRect;
    TimerToggler viewTreeChangeTimerToggler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ActivityScope {
        final WeakReference<Activity> activity;
        final WeakSet<ImpEvent> nextPassInvisible = new WeakSet<>();
        final List<TogglerWithViews> togglerWithViewsList = new ArrayList();
        final WeakHashMap<View, TogglerWithViews> viewToTogglerWithViews = new WeakHashMap<>();
        final HashMap<String, ImpEvent> globalIdToImpEvent = new HashMap<>();

        public ActivityScope(Activity activity) {
            this.activity = new WeakReference<>(activity);
        }

        public boolean containView(View view) {
            return this.viewToTogglerWithViews.containsKey(view);
        }

        public TogglerWithViews getFromDelay(long j2) {
            for (TogglerWithViews togglerWithViews : this.togglerWithViewsList) {
                if (togglerWithViews.delayTime == j2) {
                    return togglerWithViews;
                }
            }
            TogglerWithViews togglerWithViews2 = new TogglerWithViews(j2);
            this.togglerWithViewsList.add(togglerWithViews2);
            return togglerWithViews2;
        }

        public ImpEvent getImpEvent(View view) {
            TogglerWithViews togglerWithViews = this.viewToTogglerWithViews.get(view);
            if (togglerWithViews != null) {
                return togglerWithViews.getViewImpEvent(view);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ImpEvent {
        WeakReference<Activity> activity;
        boolean lastVisible;
        ImpressionMark mark;

        ImpEvent() {
        }

        public boolean equals(Object obj) {
            if (obj instanceof ImpEvent) {
                ImpEvent impEvent = (ImpEvent) obj;
                return ObjectUtils.equals(this.mark.getEventId(), impEvent.mark.getEventId()) && ObjectUtils.equals(this.mark.getGlobalId(), impEvent.mark.getGlobalId()) && ObjectUtils.equals(this.mark.getNum(), impEvent.mark.getNum()) && this.mark.getDelayTimeMills() == impEvent.mark.getDelayTimeMills() && JsonUtil.equal(this.mark.getVariable(), impEvent.mark.getVariable());
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class TogglerWithViews implements Runnable {
        long delayTime;
        TimerToggler timerToggler;
        WeakHashMap<View, ImpEvent> impViews = new WeakHashMap<>();
        ImpObserver impObserver = AutoBuryObservableInitialize.impObserver();

        public TogglerWithViews(long j2) {
            this.timerToggler = new TimerToggler.Builder(this).maxDelayTime(2000L).delayTime(j2).build();
            this.delayTime = j2;
        }

        public void addView(View view, ImpEvent impEvent, ActivityScope activityScope) {
            this.impViews.put(view, impEvent);
            activityScope.viewToTogglerWithViews.put(view, this);
        }

        public ImpEvent getViewImpEvent(View view) {
            WeakHashMap<View, ImpEvent> weakHashMap = this.impViews;
            if (weakHashMap == null) {
                return null;
            }
            return weakHashMap.get(view);
        }

        public void removeView(View view, ActivityScope activityScope) {
            WeakHashMap<View, ImpEvent> weakHashMap = this.impViews;
            if (weakHashMap != null) {
                weakHashMap.remove(view);
            }
            activityScope.viewToTogglerWithViews.remove(view);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SysTrace.beginSection("gio.imp");
                this.impObserver.checkImp(this, this.impViews);
            } finally {
                SysTrace.endSection();
            }
        }

        public void toggle() {
            this.timerToggler.toggle();
        }
    }

    public ImpObserver(CoreAppState coreAppState) {
        this.coreAppState = coreAppState;
    }

    private void checkAndSendViewTreeChange(Activity activity) {
        Activity resumedActivity = this.coreAppState.getResumedActivity();
        if (resumedActivity == null || activity != resumedActivity) {
            return;
        }
        this.viewTreeChangeTimerToggler.toggle();
    }

    private ActivityScope findActivityScopeByView(View view) {
        if (this.mActivityScopes != null && view != null) {
            Activity findActivity = ActivityUtil.findActivity(view.getContext());
            if (findActivity != null) {
                return this.mActivityScopes.get(findActivity);
            }
            for (ActivityScope activityScope : this.mActivityScopes.values()) {
                if (activityScope.viewToTogglerWithViews.containsKey(view)) {
                    return activityScope;
                }
            }
        }
        return null;
    }

    private void init() {
        if (this.mActivityScopes != null) {
            return;
        }
        this.mActivityScopes = new WeakHashMap<>();
        this.viewTreeChangeTimerToggler = new TimerToggler.Builder(new Runnable() { // from class: com.growingio.android.sdk.autoburry.ImpObserver.1
            @Override // java.lang.Runnable
            public void run() {
                LogUtil.d(ImpObserver.TAG, "stampViewImp after resume or re draw, force check");
                ImpObserver.this.onGlobalLayout(new ViewTreeStatusChangeEvent(ViewTreeStatusChangeEvent.StatusType.LayoutChanged));
            }
        }).delayTime(500L).maxDelayTime(5000L).firstTimeDelay(true).build();
        EventCenter.getInstance().register(this);
    }

    private void layoutActivity(Activity activity) {
        ActivityScope activityScope;
        WeakHashMap<Activity, ActivityScope> weakHashMap = this.mActivityScopes;
        if (weakHashMap == null || (activityScope = weakHashMap.get(activity)) == null) {
            return;
        }
        for (int size = activityScope.togglerWithViewsList.size() - 1; size >= 0; size--) {
            if (size < activityScope.togglerWithViewsList.size()) {
                activityScope.togglerWithViewsList.get(size).toggle();
            }
        }
    }

    private ImpEvent moveGlobalId(ActivityScope activityScope, View view, @NonNull ImpressionMark impressionMark, @NonNull ImpEvent impEvent) {
        if (!activityScope.globalIdToImpEvent.containsKey(impressionMark.getGlobalId())) {
            activityScope.globalIdToImpEvent.put(impressionMark.getGlobalId(), impEvent);
            return impEvent;
        }
        ImpEvent impEvent2 = activityScope.globalIdToImpEvent.get(impressionMark.getGlobalId());
        View view2 = impEvent2.mark.getView();
        ImpEvent impEvent3 = activityScope.getImpEvent(view);
        if (view2 != view) {
            if (impEvent3 != null && impEvent3 != impEvent2) {
                activityScope.nextPassInvisible.add(impEvent3);
            }
            stopStampViewImpInternal(activityScope, view);
            if (view2 == null) {
                impEvent2.lastVisible = false;
            }
        } else if (impEvent.equals(impEvent3)) {
            return null;
        }
        impEvent2.mark = impressionMark;
        impEvent2.activity = impEvent.activity;
        return impEvent2;
    }

    private void removeGlobalId(ActivityScope activityScope, ImpEvent impEvent) {
        if (impEvent == null || impEvent.mark.getGlobalId() == null) {
            return;
        }
        activityScope.globalIdToImpEvent.remove(impEvent.mark.getGlobalId());
    }

    private void removeOutDateGlobalId(ActivityScope activityScope) {
        if (this.mTmpGlobalIds == null) {
            this.mTmpGlobalIds = new HashSet();
        }
        this.mTmpGlobalIds.clear();
        for (String str : activityScope.globalIdToImpEvent.keySet()) {
            ImpEvent impEvent = activityScope.globalIdToImpEvent.get(str);
            View view = impEvent.mark.getView();
            if (view == null) {
                this.mTmpGlobalIds.add(str);
            } else if (activityScope.getImpEvent(view) != impEvent) {
                this.mTmpGlobalIds.add(str);
            }
        }
        if (this.mTmpGlobalIds.size() != 0) {
            for (String str2 : this.mTmpGlobalIds) {
                activityScope.globalIdToImpEvent.remove(str2);
            }
        }
    }

    private void saveImpEvent(ImpEvent impEvent) {
        JSONObject variable = impEvent.mark.getVariable();
        if (impEvent.mark.isCollectContent()) {
            String viewContent = Util.getViewContent(impEvent.mark.getView(), null);
            if (!TextUtils.isEmpty(viewContent)) {
                if (variable == null) {
                    variable = new JSONObject();
                }
                if (!variable.has(GIO_CONTENT)) {
                    try {
                        variable.put(GIO_CONTENT, viewContent);
                    } catch (JSONException e2) {
                        LogUtil.e(TAG, e2.getMessage(), e2);
                    }
                }
            }
        }
        if (variable != null) {
            if (impEvent.mark.getNum() == null) {
                AbstractGrowingIO.getInstance().track(impEvent.mark.getEventId(), variable);
            } else {
                AbstractGrowingIO.getInstance().track(impEvent.mark.getEventId(), impEvent.mark.getNum(), variable);
            }
        } else if (impEvent.mark.getNum() == null) {
            AbstractGrowingIO.getInstance().track(impEvent.mark.getEventId());
        } else {
            AbstractGrowingIO.getInstance().track(impEvent.mark.getEventId(), impEvent.mark.getNum());
        }
    }

    private ImpEvent stopStampViewImpInternal(ActivityScope activityScope, View view) {
        view.setTag(AbstractGrowingIO.GROWING_IMP_TAG_MARKED, Boolean.FALSE);
        TogglerWithViews togglerWithViews = activityScope.viewToTogglerWithViews.get(view);
        if (togglerWithViews != null) {
            ImpEvent viewImpEvent = togglerWithViews.getViewImpEvent(view);
            togglerWithViews.removeView(view, activityScope);
            return viewImpEvent;
        }
        return null;
    }

    void checkImp(TogglerWithViews togglerWithViews, WeakHashMap<View, ImpEvent> weakHashMap) {
        WeakHashMap<Activity, ActivityScope> weakHashMap2;
        Activity resumedActivity = this.coreAppState.getResumedActivity();
        if (resumedActivity == null || (weakHashMap2 = this.mActivityScopes) == null || !weakHashMap2.containsKey(resumedActivity)) {
            return;
        }
        ActivityScope activityScope = this.mActivityScopes.get(resumedActivity);
        removeOutDateGlobalId(activityScope);
        if (weakHashMap != null && !weakHashMap.isEmpty()) {
            this.viewTreeChangeTimerToggler.reset();
            LogUtil.d(TAG, "checkImp");
            ArrayList<View> arrayList = new ArrayList();
            try {
                for (View view : weakHashMap.keySet()) {
                    ImpEvent impEvent = weakHashMap.get(view);
                    if (impEvent != null) {
                        boolean z = impEvent.lastVisible;
                        boolean checkViewVisibility = checkViewVisibility(impEvent.mark);
                        if (impEvent.mark.getView() != view) {
                            arrayList.add(view);
                            LogUtil.e(TAG, "event's view is not same with current view, maybe globalId changed");
                        } else {
                            if (checkViewVisibility && !z) {
                                saveImpEvent(impEvent);
                            }
                            impEvent.lastVisible = checkViewVisibility;
                        }
                    }
                }
                Iterator<ImpEvent> it = activityScope.nextPassInvisible.iterator();
                while (it.hasNext()) {
                    ImpEvent next = it.next();
                    if (!activityScope.containView(next.mark.getView())) {
                        next.lastVisible = false;
                    }
                }
            } catch (ConcurrentModificationException unused) {
            }
            activityScope.nextPassInvisible.clear();
            for (View view2 : arrayList) {
                stopStampViewImpInternal(activityScope, view2);
            }
            return;
        }
        activityScope.togglerWithViewsList.remove(togglerWithViews);
    }

    boolean checkViewVisibility(ImpressionMark impressionMark) {
        View view = impressionMark.getView();
        if (ViewHelper.viewVisibilityInParents(view)) {
            if (impressionMark.getVisibleScale() == 0.0f) {
                return true;
            }
            if (this.mTmpRect == null) {
                this.mTmpRect = new Rect();
            }
            view.getLocalVisibleRect(this.mTmpRect);
            Rect rect = this.mTmpRect;
            return ((float) (rect.right * rect.bottom)) >= ((float) (view.getMeasuredHeight() * view.getMeasuredWidth())) * impressionMark.getVisibleScale();
        }
        return false;
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public void do$Action(String str, Object obj) {
        if (str.equals("#onActivityLifecycle(com.growingio.android.sdk.base.event.ActivityLifecycleEvent")) {
            onActivityLifecycle((ActivityLifecycleEvent) obj);
        } else if (str.equals("#onGlobalLayout(com.growingio.android.sdk.base.event.ViewTreeStatusChangeEvent")) {
            onGlobalLayout((ViewTreeStatusChangeEvent) obj);
        } else if (str.equals("#onGlobalWindowFocusChanged(com.growingio.android.sdk.base.event.ViewTreeWindowFocusChangedEvent")) {
            onGlobalWindowFocusChanged((ViewTreeWindowFocusChangedEvent) obj);
        } else if (str.equals("#onGlobalDraw(com.growingio.android.sdk.base.event.ViewTreeDrawEvent")) {
            onGlobalDraw((ViewTreeDrawEvent) obj);
        } else {
            System.out.println("No such method to delegate");
        }
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public SubscriberMethod[] get$SubscriberMethods() {
        ThreadMode threadMode = ThreadMode.POSTING;
        return new SubscriberMethod[]{new SubscriberMethod("onActivityLifecycle", ActivityLifecycleEvent.class, "#onActivityLifecycle(com.growingio.android.sdk.base.event.ActivityLifecycleEvent", threadMode, 0, false), new SubscriberMethod("onGlobalLayout", ViewTreeStatusChangeEvent.class, "#onGlobalLayout(com.growingio.android.sdk.base.event.ViewTreeStatusChangeEvent", threadMode, 0, false), new SubscriberMethod("onGlobalWindowFocusChanged", ViewTreeWindowFocusChangedEvent.class, "#onGlobalWindowFocusChanged(com.growingio.android.sdk.base.event.ViewTreeWindowFocusChangedEvent", threadMode, 0, false), new SubscriberMethod("onGlobalDraw", ViewTreeDrawEvent.class, "#onGlobalDraw(com.growingio.android.sdk.base.event.ViewTreeDrawEvent", threadMode, 0, false)};
    }

    public void markViewImpression(ImpressionMark impressionMark) {
        View view = impressionMark.getView();
        if (view == null) {
            return;
        }
        Activity findActivity = ActivityUtil.findActivity(view.getContext());
        if (findActivity == null) {
            findActivity = this.coreAppState.getForegroundActivity();
        }
        if (findActivity == null) {
            LogUtil.e(TAG, "can't find the activity of view: " + view);
            return;
        }
        LogUtil.d(TAG, "stampViewImp: ", impressionMark.getEventId());
        init();
        ActivityScope activityScope = this.mActivityScopes.get(findActivity);
        if (activityScope == null) {
            activityScope = new ActivityScope(findActivity);
            this.mActivityScopes.put(findActivity, activityScope);
        }
        ImpEvent impEvent = new ImpEvent();
        impEvent.mark = impressionMark;
        impEvent.activity = new WeakReference<>(findActivity);
        if (impressionMark.getGlobalId() != null) {
            impEvent = moveGlobalId(activityScope, view, impressionMark, impEvent);
            if (impEvent == null) {
                LogUtil.d(TAG, "stampViewImp, and nothing changed, globalId: ", impressionMark.getGlobalId());
                return;
            }
        } else if (activityScope.containView(view)) {
            ImpEvent impEvent2 = activityScope.getImpEvent(view);
            if (impEvent.equals(impEvent2)) {
                LogUtil.d(TAG, "stampViewImp, and nothing changed: ", impressionMark.getEventId());
                impEvent2.mark = impEvent.mark;
                return;
            }
            stopStampViewImpInternal(activityScope, view);
        }
        view.setTag(AbstractGrowingIO.GROWING_IMP_TAG_MARKED, Boolean.TRUE);
        activityScope.getFromDelay(impressionMark.getDelayTimeMills()).addView(view, impEvent, activityScope);
        checkAndSendViewTreeChange(findActivity);
    }

    @Subscribe
    public void onActivityLifecycle(ActivityLifecycleEvent activityLifecycleEvent) {
        ActivityScope activityScope;
        ActivityLifecycleEvent.EVENT_TYPE event_type = activityLifecycleEvent.event_type;
        if (event_type == ActivityLifecycleEvent.EVENT_TYPE.ON_DESTROYED) {
            this.mActivityScopes.remove(activityLifecycleEvent.getActivity());
            if (this.mActivityScopes.isEmpty()) {
                EventBus.getDefault().unregister(this);
                this.viewTreeChangeTimerToggler.reset();
                this.mActivityScopes = null;
            }
        } else if (event_type == ActivityLifecycleEvent.EVENT_TYPE.ON_RESUMED && (activityScope = this.mActivityScopes.get(activityLifecycleEvent.getActivity())) != null) {
            for (View view : activityScope.viewToTogglerWithViews.keySet()) {
                ImpEvent impEvent = activityScope.getImpEvent(view);
                if (impEvent != null) {
                    impEvent.lastVisible = false;
                }
            }
            layoutActivity(activityLifecycleEvent.getActivity());
        }
    }

    @Subscribe
    public void onGlobalDraw(ViewTreeDrawEvent viewTreeDrawEvent) {
        TimerToggler timerToggler = this.viewTreeChangeTimerToggler;
        if (timerToggler != null) {
            timerToggler.toggle();
        }
    }

    @Subscribe
    public void onGlobalLayout(ViewTreeStatusChangeEvent viewTreeStatusChangeEvent) {
        Activity resumedActivity = this.coreAppState.getResumedActivity();
        if (resumedActivity != null) {
            layoutActivity(resumedActivity);
        }
    }

    @Subscribe
    public void onGlobalWindowFocusChanged(ViewTreeWindowFocusChangedEvent viewTreeWindowFocusChangedEvent) {
        onGlobalLayout(null);
    }

    public void stopStampViewImp(View view) {
        ActivityScope findActivityScopeByView = findActivityScopeByView(view);
        if (findActivityScopeByView == null) {
            return;
        }
        stopStampViewImpInternal(findActivityScopeByView, view);
    }
}
