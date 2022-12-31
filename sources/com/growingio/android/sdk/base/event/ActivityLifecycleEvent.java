package com.growingio.android.sdk.base.event;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class ActivityLifecycleEvent {
    private WeakReference<Activity> activityWeakReference;
    private WeakReference<Bundle> bundleWeakReference;
    public EVENT_TYPE event_type;
    private WeakReference<Intent> intentWeakReference;

    /* loaded from: classes2.dex */
    public enum EVENT_TYPE {
        ON_CREATED,
        ON_STARTED,
        ON_RESUMED,
        ON_NEW_INTENT,
        ON_PAUSED,
        ON_SAVE_INSTANCE_STATE,
        ON_STOPPED,
        ON_DESTROYED
    }

    private ActivityLifecycleEvent(Activity activity, EVENT_TYPE event_type) {
        this.activityWeakReference = new WeakReference<>(activity);
        this.event_type = event_type;
    }

    public static ActivityLifecycleEvent createOnCreatedEvent(Activity activity, Bundle bundle) {
        return new ActivityLifecycleEvent(activity, EVENT_TYPE.ON_CREATED, bundle);
    }

    public static ActivityLifecycleEvent createOnDestroyedEvent(Activity activity) {
        return new ActivityLifecycleEvent(activity, EVENT_TYPE.ON_DESTROYED);
    }

    public static ActivityLifecycleEvent createOnNewIntentEvent(Activity activity, Intent intent) {
        return new ActivityLifecycleEvent(activity, EVENT_TYPE.ON_NEW_INTENT, intent);
    }

    public static ActivityLifecycleEvent createOnPausedEvent(Activity activity) {
        return new ActivityLifecycleEvent(activity, EVENT_TYPE.ON_PAUSED);
    }

    public static ActivityLifecycleEvent createOnResumedEvent(Activity activity) {
        return new ActivityLifecycleEvent(activity, EVENT_TYPE.ON_RESUMED);
    }

    public static ActivityLifecycleEvent createOnSaveInstanceStateEvent(Activity activity, Bundle bundle) {
        return new ActivityLifecycleEvent(activity, EVENT_TYPE.ON_SAVE_INSTANCE_STATE, bundle);
    }

    public static ActivityLifecycleEvent createOnStartedEvent(Activity activity) {
        return new ActivityLifecycleEvent(activity, EVENT_TYPE.ON_STARTED);
    }

    public static ActivityLifecycleEvent createOnStoppedEvent(Activity activity) {
        return new ActivityLifecycleEvent(activity, EVENT_TYPE.ON_STOPPED);
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.activityWeakReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Bundle getBundle() {
        WeakReference<Bundle> weakReference = this.bundleWeakReference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public Intent getIntent() {
        WeakReference<Intent> weakReference = this.intentWeakReference;
        if (weakReference != null && weakReference.get() != null) {
            return this.intentWeakReference.get();
        }
        Activity activity = getActivity();
        if (activity != null) {
            return activity.getIntent();
        }
        return null;
    }

    private ActivityLifecycleEvent(Activity activity, EVENT_TYPE event_type, Bundle bundle) {
        this.activityWeakReference = new WeakReference<>(activity);
        this.bundleWeakReference = new WeakReference<>(bundle);
        this.event_type = event_type;
    }

    private ActivityLifecycleEvent(Activity activity, EVENT_TYPE event_type, Intent intent) {
        this.activityWeakReference = new WeakReference<>(activity);
        this.intentWeakReference = new WeakReference<>(intent);
        this.event_type = event_type;
    }
}
