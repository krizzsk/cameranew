package us.pinguo.foundation.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
/* compiled from: SimpleLifeCycleCallbacks.java */
/* loaded from: classes4.dex */
public abstract class e0 implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public abstract void onActivityPaused(Activity activity);

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public abstract void onActivityResumed(Activity activity);

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
