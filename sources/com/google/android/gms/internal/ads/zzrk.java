package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.MobileAds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzrk implements Application.ActivityLifecycleCallbacks {
    private Context context;
    @Nullable
    private Activity zzaas;
    private Runnable zzbta;
    private long zzbtb;
    private final Object lock = new Object();
    private boolean foreground = true;
    private boolean zzbsx = false;
    @GuardedBy("lock")
    private final List<zzrm> zzbsy = new ArrayList();
    @GuardedBy("lock")
    private final List<zzsb> zzbsz = new ArrayList();
    private boolean zzzl = false;

    private final void setActivity(Activity activity) {
        synchronized (this.lock) {
            if (!activity.getClass().getName().startsWith(MobileAds.ERROR_DOMAIN)) {
                this.zzaas = activity;
            }
        }
    }

    @Nullable
    public final Activity getActivity() {
        return this.zzaas;
    }

    @Nullable
    public final Context getContext() {
        return this.context;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.lock) {
            Activity activity2 = this.zzaas;
            if (activity2 == null) {
                return;
            }
            if (activity2.equals(activity)) {
                this.zzaas = null;
            }
            Iterator<zzsb> it = this.zzbsz.iterator();
            while (it.hasNext()) {
                try {
                    if (it.next().zza(activity)) {
                        it.remove();
                    }
                } catch (Exception e2) {
                    com.google.android.gms.ads.internal.zzr.zzkv().zza(e2, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                    zzazk.zzc("", e2);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        setActivity(activity);
        synchronized (this.lock) {
            for (zzsb zzsbVar : this.zzbsz) {
                try {
                    zzsbVar.onActivityPaused(activity);
                } catch (Exception e2) {
                    com.google.android.gms.ads.internal.zzr.zzkv().zza(e2, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzazk.zzc("", e2);
                }
            }
        }
        this.zzbsx = true;
        Runnable runnable = this.zzbta;
        if (runnable != null) {
            com.google.android.gms.ads.internal.util.zzj.zzeen.removeCallbacks(runnable);
        }
        zzdvl zzdvlVar = com.google.android.gms.ads.internal.util.zzj.zzeen;
        zzrn zzrnVar = new zzrn(this);
        this.zzbta = zzrnVar;
        zzdvlVar.postDelayed(zzrnVar, this.zzbtb);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        setActivity(activity);
        this.zzbsx = false;
        boolean z = !this.foreground;
        this.foreground = true;
        Runnable runnable = this.zzbta;
        if (runnable != null) {
            com.google.android.gms.ads.internal.util.zzj.zzeen.removeCallbacks(runnable);
        }
        synchronized (this.lock) {
            for (zzsb zzsbVar : this.zzbsz) {
                try {
                    zzsbVar.onActivityResumed(activity);
                } catch (Exception e2) {
                    com.google.android.gms.ads.internal.zzr.zzkv().zza(e2, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzazk.zzc("", e2);
                }
            }
            if (z) {
                for (zzrm zzrmVar : this.zzbsy) {
                    try {
                        zzrmVar.zzp(true);
                    } catch (Exception e3) {
                        zzazk.zzc("", e3);
                    }
                }
            } else {
                zzazk.zzdy("App is still foreground.");
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        setActivity(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    public final void zza(Application application, Context context) {
        if (this.zzzl) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this);
        if (context instanceof Activity) {
            setActivity((Activity) context);
        }
        this.context = application;
        this.zzbtb = ((Long) zzwr.zzqr().zzd(zzabp.zzcpl)).longValue();
        this.zzzl = true;
    }

    public final void zzb(zzrm zzrmVar) {
        synchronized (this.lock) {
            this.zzbsy.remove(zzrmVar);
        }
    }

    public final void zza(zzrm zzrmVar) {
        synchronized (this.lock) {
            this.zzbsy.add(zzrmVar);
        }
    }
}
