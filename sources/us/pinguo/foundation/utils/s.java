package us.pinguo.foundation.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import us.pinguo.foundation.base.ActivityRecorder;
/* compiled from: LifeCycleInjectUtil.java */
/* loaded from: classes4.dex */
public class s {
    private static HashMap<String, Application.ActivityLifecycleCallbacks> a = new HashMap<>();

    /* compiled from: LifeCycleInjectUtil.java */
    /* loaded from: classes4.dex */
    class a implements Application.ActivityLifecycleCallbacks {
        final /* synthetic */ WeakReference a;
        final /* synthetic */ e0 b;
        final /* synthetic */ Application c;

        a(WeakReference weakReference, e0 e0Var, Application application) {
            this.a = weakReference;
            this.b = e0Var;
            this.c = application;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            WeakReference weakReference = this.a;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.b.onActivityCreated(activity, bundle);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            WeakReference weakReference = this.a;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.b.onActivityDestroyed(activity);
            this.c.unregisterActivityLifecycleCallbacks(this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            WeakReference weakReference = this.a;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.b.onActivityPaused(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            WeakReference weakReference = this.a;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.b.onActivityResumed(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            WeakReference weakReference = this.a;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.b.onActivitySaveInstanceState(activity, bundle);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            WeakReference weakReference = this.a;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.b.onActivityStarted(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            WeakReference weakReference = this.a;
            if (weakReference == null || weakReference.get() != activity) {
                return;
            }
            this.b.onActivityStopped(activity);
        }
    }

    public static void a(Object obj, e0 e0Var) {
        Context b = us.pinguo.foundation.e.b();
        Activity d2 = ActivityRecorder.getInstance().d();
        WeakReference weakReference = new WeakReference(d2);
        if (e0Var == null || b == null || d2 == null || !(b instanceof Application)) {
            return;
        }
        Application application = (Application) b;
        if (a.get(obj.toString()) == null) {
            a aVar = new a(weakReference, e0Var, application);
            a.put(obj.toString(), aVar);
            application.registerActivityLifecycleCallbacks(aVar);
        }
    }

    public static void b(Object obj) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = a.get(obj.toString());
        Context b = us.pinguo.foundation.e.b();
        if (activityLifecycleCallbacks != null && (b instanceof Application)) {
            ((Application) b).unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        a.remove(obj.toString());
    }
}
