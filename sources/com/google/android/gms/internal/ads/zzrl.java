package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzrl {
    private final Object zzbtc = new Object();
    @GuardedBy("activityTrackerLock")
    private zzrk zzbtd = null;
    @GuardedBy("activityTrackerLock")
    private boolean zzbte = false;

    @Nullable
    public final Activity getActivity() {
        synchronized (this.zzbtc) {
            zzrk zzrkVar = this.zzbtd;
            if (zzrkVar != null) {
                return zzrkVar.getActivity();
            }
            return null;
        }
    }

    @Nullable
    public final Context getContext() {
        synchronized (this.zzbtc) {
            zzrk zzrkVar = this.zzbtd;
            if (zzrkVar != null) {
                return zzrkVar.getContext();
            }
            return null;
        }
    }

    public final void initialize(Context context) {
        synchronized (this.zzbtc) {
            if (!this.zzbte) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                if (application == null) {
                    zzazk.zzex("Can not cast Context to Application");
                    return;
                }
                if (this.zzbtd == null) {
                    this.zzbtd = new zzrk();
                }
                this.zzbtd.zza(application, context);
                this.zzbte = true;
            }
        }
    }

    public final void zza(zzrm zzrmVar) {
        synchronized (this.zzbtc) {
            if (this.zzbtd == null) {
                this.zzbtd = new zzrk();
            }
            this.zzbtd.zza(zzrmVar);
        }
    }

    public final void zzb(zzrm zzrmVar) {
        synchronized (this.zzbtc) {
            zzrk zzrkVar = this.zzbtd;
            if (zzrkVar == null) {
                return;
            }
            zzrkVar.zzb(zzrmVar);
        }
    }
}
