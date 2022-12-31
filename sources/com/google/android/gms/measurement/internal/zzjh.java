package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import com.google.android.gms.measurement.internal.l8;
import com.tencent.tauth.AuthActivity;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzjh<T extends Context & l8> {
    private final T a;

    public zzjh(T t) {
        com.google.android.gms.common.internal.q.j(t);
        this.a = t;
    }

    private final k3 k() {
        return o4.f(this.a, null, null).a();
    }

    @MainThread
    public final void a() {
        o4 f2 = o4.f(this.a, null, null);
        k3 a = f2.a();
        f2.d();
        a.u().a("Local AppMeasurementService is starting up");
    }

    @MainThread
    public final void b() {
        o4 f2 = o4.f(this.a, null, null);
        k3 a = f2.a();
        f2.d();
        a.u().a("Local AppMeasurementService is shutting down");
    }

    @MainThread
    public final int c(final Intent intent, int i2, final int i3) {
        o4 f2 = o4.f(this.a, null, null);
        final k3 a = f2.a();
        if (intent == null) {
            a.p().a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        f2.d();
        a.u().c("Local AppMeasurementService called. startId, action", Integer.valueOf(i3), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            d(new Runnable(this, i3, a, intent) { // from class: com.google.android.gms.measurement.internal.i8
                private final zzjh a;
                private final int b;
                private final k3 c;

                /* renamed from: d  reason: collision with root package name */
                private final Intent f3835d;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                    this.b = i3;
                    this.c = a;
                    this.f3835d = intent;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.j(this.b, this.c, this.f3835d);
                }
            });
        }
        return 2;
    }

    public final void d(Runnable runnable) {
        i9 D = i9.D(this.a);
        D.c().p(new k8(this, D, runnable));
    }

    @MainThread
    public final IBinder e(Intent intent) {
        if (intent == null) {
            k().m().a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new h5(i9.D(this.a), null);
        }
        k().p().b("onBind received unknown action", action);
        return null;
    }

    @MainThread
    public final boolean f(Intent intent) {
        if (intent == null) {
            k().m().a("onUnbind called with null intent");
            return true;
        }
        k().u().b("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    @TargetApi(24)
    @MainThread
    public final boolean g(final JobParameters jobParameters) {
        o4 f2 = o4.f(this.a, null, null);
        final k3 a = f2.a();
        String string = jobParameters.getExtras().getString(AuthActivity.ACTION_KEY);
        f2.d();
        a.u().b("Local AppMeasurementJobService called. action", string);
        if ("com.google.android.gms.measurement.UPLOAD".equals(string)) {
            d(new Runnable(this, a, jobParameters) { // from class: com.google.android.gms.measurement.internal.j8
                private final zzjh a;
                private final k3 b;
                private final JobParameters c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                    this.b = a;
                    this.c = jobParameters;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.i(this.b, this.c);
                }
            });
            return true;
        }
        return true;
    }

    @MainThread
    public final void h(Intent intent) {
        if (intent == null) {
            k().m().a("onRebind called with null intent");
            return;
        }
        k().u().b("onRebind called. action", intent.getAction());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void i(k3 k3Var, JobParameters jobParameters) {
        k3Var.u().a("AppMeasurementJobService processed last upload request.");
        this.a.a(jobParameters, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void j(int i2, k3 k3Var, Intent intent) {
        if (this.a.zza(i2)) {
            k3Var.u().b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i2));
            k().u().a("Completed wakeful intent.");
            this.a.zzc(intent);
        }
    }
}
