package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.c;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzsz {
    @Nullable
    @GuardedBy("lock")
    private Context context;
    @Nullable
    @GuardedBy("lock")
    private zzte zzbve;
    @Nullable
    @GuardedBy("lock")
    private zzti zzbvf;
    private final Runnable zzbvd = new zzsy(this);
    private final Object lock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    public final void connect() {
        synchronized (this.lock) {
            if (this.context != null && this.zzbve == null) {
                zzte zza = zza(new zzta(this), new zztd(this));
                this.zzbve = zza;
                zza.checkAvailabilityAndConnect();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            zzte zzteVar = this.zzbve;
            if (zzteVar == null) {
                return;
            }
            if (zzteVar.isConnected() || this.zzbve.isConnecting()) {
                this.zzbve.disconnect();
            }
            this.zzbve = null;
            this.zzbvf = null;
            Binder.flushPendingCommands();
        }
    }

    public final void initialize(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.lock) {
            if (this.context != null) {
                return;
            }
            this.context = context.getApplicationContext();
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcud)).booleanValue()) {
                connect();
            } else {
                if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcuc)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzr.zzku().zza(new zztb(this));
                }
            }
        }
    }

    public final zztc zza(zzth zzthVar) {
        synchronized (this.lock) {
            if (this.zzbvf == null) {
                return new zztc();
            }
            try {
                if (this.zzbve.zzne()) {
                    return this.zzbvf.zzc(zzthVar);
                }
                return this.zzbvf.zza(zzthVar);
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to call into cache service.", e2);
                return new zztc();
            }
        }
    }

    public final long zzb(zzth zzthVar) {
        synchronized (this.lock) {
            if (this.zzbvf == null) {
                return -2L;
            }
            if (this.zzbve.zzne()) {
                try {
                    return this.zzbvf.zzb(zzthVar);
                } catch (RemoteException e2) {
                    zzazk.zzc("Unable to call into cache service.", e2);
                }
            }
            return -2L;
        }
    }

    public final void zzmv() {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcue)).booleanValue()) {
            synchronized (this.lock) {
                connect();
                zzdvl zzdvlVar = com.google.android.gms.ads.internal.util.zzj.zzeen;
                zzdvlVar.removeCallbacks(this.zzbvd);
                zzdvlVar.postDelayed(this.zzbvd, ((Long) zzwr.zzqr().zzd(zzabp.zzcuf)).longValue());
            }
        }
    }

    private final synchronized zzte zza(c.a aVar, c.b bVar) {
        return new zzte(this.context, com.google.android.gms.ads.internal.zzr.zzlf().zzzp(), aVar, bVar);
    }
}
