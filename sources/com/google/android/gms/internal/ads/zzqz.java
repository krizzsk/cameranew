package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzqz implements Application.ActivityLifecycleCallbacks {
    private final Application zzyd;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzye;
    private boolean zzyf = false;

    public zzqz(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzye = new WeakReference<>(activityLifecycleCallbacks);
        this.zzyd = application;
    }

    private final void zza(zzrh zzrhVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.zzye.get();
            if (activityLifecycleCallbacks != null) {
                zzrhVar.zza(activityLifecycleCallbacks);
            } else if (this.zzyf) {
            } else {
                this.zzyd.unregisterActivityLifecycleCallbacks(this);
                this.zzyf = true;
            }
        } catch (Exception e2) {
            zzazk.zzc("Error while dispatching lifecycle callback.", e2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzqy(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zza(new zzre(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zza(new zzrd(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zza(new zzra(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzrf(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zza(new zzrb(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zza(new zzrc(this, activity));
    }
}
