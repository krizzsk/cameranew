package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.measurement.internal.l8;
import com.google.android.gms.measurement.internal.zzjh;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
@TargetApi(24)
/* loaded from: classes2.dex */
public final class AppMeasurementJobService extends JobService implements l8 {
    private zzjh<AppMeasurementJobService> a;

    private final zzjh<AppMeasurementJobService> b() {
        if (this.a == null) {
            this.a = new zzjh<>(this);
        }
        return this.a;
    }

    @Override // com.google.android.gms.measurement.internal.l8
    @TargetApi(24)
    public final void a(@RecentlyNonNull JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
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

    @Override // android.app.job.JobService
    public boolean onStartJob(@RecentlyNonNull JobParameters jobParameters) {
        b().g(jobParameters);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(@RecentlyNonNull JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    @MainThread
    public boolean onUnbind(@RecentlyNonNull Intent intent) {
        b().f(intent);
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.l8
    public final boolean zza(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.l8
    public final void zzc(@RecentlyNonNull Intent intent) {
    }
}
