package com.growingio.android.sdk.status;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.growingio.android.sdk.base.event.ActivityLifecycleEvent;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.status.ViewTreeStatusObservable;
import com.growingio.android.sdk.utils.SysTrace;
import com.growingio.eventcenter.EventCenter;
@TargetApi(14)
/* loaded from: classes2.dex */
public class ActivityLifecycleObservable implements Application.ActivityLifecycleCallbacks {
    private void monitorViewTreeChange(View view) {
        if (view.getTag(AbstractGrowingIO.GROWING_MONITORING_VIEWTREE_KEY) == null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(ViewTreeStatusObservable.getInstance());
            view.getViewTreeObserver().addOnScrollChangedListener(ViewTreeStatusObservable.getInstance());
            view.getViewTreeObserver().addOnGlobalFocusChangeListener(ViewTreeStatusObservable.getInstance());
            view.getViewTreeObserver().addOnDrawListener(ViewTreeStatusObservable.getInstance());
            view.setTag(AbstractGrowingIO.GROWING_MONITORING_VIEWTREE_KEY, Boolean.TRUE);
            if (Build.VERSION.SDK_INT >= 18) {
                view.getViewTreeObserver().addOnWindowFocusChangeListener(ViewTreeStatusObservable.FocusListener.getInstance());
            }
        }
    }

    @RequiresApi(api = 16)
    private void unRegisterViewTreeChange(View view) {
        if (view.getTag(AbstractGrowingIO.GROWING_MONITORING_VIEWTREE_KEY) != null) {
            ViewTreeStatusObservable viewTreeStatusObservable = ViewTreeStatusObservable.getInstance();
            view.getViewTreeObserver().removeOnGlobalLayoutListener(viewTreeStatusObservable);
            view.getViewTreeObserver().removeOnGlobalFocusChangeListener(viewTreeStatusObservable);
            view.getViewTreeObserver().removeOnScrollChangedListener(viewTreeStatusObservable);
            view.getViewTreeObserver().removeOnDrawListener(viewTreeStatusObservable);
            view.setTag(AbstractGrowingIO.GROWING_MONITORING_VIEWTREE_KEY, null);
            if (Build.VERSION.SDK_INT >= 18) {
                view.getViewTreeObserver().removeOnWindowFocusChangeListener(ViewTreeStatusObservable.FocusListener.getInstance());
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        SysTrace.beginSection("gio.ActivityOnCreate");
        CoreAppState coreAppState = CoreInitialize.coreAppState();
        if (coreAppState != null) {
            coreAppState.waitUntilInitComplete();
        }
        EventCenter.getInstance().post(ActivityLifecycleEvent.createOnCreatedEvent(activity, bundle));
        SysTrace.endSection();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        EventCenter.getInstance().post(ActivityLifecycleEvent.createOnDestroyedEvent(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @RequiresApi(api = 16)
    public void onActivityPaused(Activity activity) {
        SysTrace.beginSection("gio.onActivityPaused");
        unRegisterViewTreeChange(activity.getWindow().getDecorView());
        EventCenter.getInstance().post(ActivityLifecycleEvent.createOnPausedEvent(activity));
        SysTrace.endSection();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        SysTrace.beginSection("gio.onActivityResumed");
        monitorViewTreeChange(activity.getWindow().getDecorView());
        EventCenter.getInstance().post(ActivityLifecycleEvent.createOnResumedEvent(activity));
        SysTrace.endSection();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        EventCenter.getInstance().post(ActivityLifecycleEvent.createOnSaveInstanceStateEvent(activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        SysTrace.beginSection("gio.onActivityStart");
        EventCenter.getInstance().post(ActivityLifecycleEvent.createOnStartedEvent(activity));
        SysTrace.endSection();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        EventCenter.getInstance().post(ActivityLifecycleEvent.createOnStoppedEvent(activity));
    }
}
