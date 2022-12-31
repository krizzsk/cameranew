package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import androidx.annotation.RecentlyNonNull;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.l8;
import com.google.android.gms.measurement.internal.zzjh;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class AppMeasurementService extends Service implements l8 {
    private zzjh<AppMeasurementService> a;

    private final zzjh<AppMeasurementService> b() {
        if (this.a == null) {
            this.a = new zzjh<>(this);
        }
        return this.a;
    }

    @Override // com.google.android.gms.measurement.internal.l8
    public final void a(@RecentlyNonNull JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    @RecentlyNonNull
    @MainThread
    public IBinder onBind(@RecentlyNonNull Intent intent) {
        return b().e(intent);
    }

    @Override // android.app.Service
    @MainThread
    public void onCreate() {
        super.onCreate();
        b().a();
    }

    @Override // android.app.Service
    @MainThread
    public void onDestroy() {
        b().b();
        super.onDestroy();
    }

    @Override // android.app.Service
    @MainThread
    public void onRebind(@RecentlyNonNull Intent intent) {
        b().h(intent);
    }

    @Override // android.app.Service
    @MainThread
    public int onStartCommand(@RecentlyNonNull Intent intent, int i2, int i3) {
        VdsAgent.onServiceStartCommand(this, intent, i2, i3);
        b().c(intent, i2, i3);
        return 2;
    }

    @Override // android.app.Service
    @MainThread
    public boolean onUnbind(@RecentlyNonNull Intent intent) {
        b().f(intent);
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.l8
    public final boolean zza(int i2) {
        return stopSelfResult(i2);
    }

    @Override // com.google.android.gms.measurement.internal.l8
    public final void zzc(@RecentlyNonNull Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }
}
