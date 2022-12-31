package d.e.d.k;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.ironsource.sdk.utils.f;
/* compiled from: ActivityLifeCycleListener.java */
/* loaded from: classes2.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    private c a;

    public a(c cVar) {
        this.a = cVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (f.x(activity)) {
            return;
        }
        this.a.K(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (f.x(activity)) {
            return;
        }
        this.a.p(activity);
    }

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
