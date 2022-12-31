package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.internal.measurement.zzg;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tencent.tauth.AuthActivity;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class x8 extends z8 {

    /* renamed from: d  reason: collision with root package name */
    private final AlarmManager f3983d;

    /* renamed from: e  reason: collision with root package name */
    private l f3984e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f3985f;

    /* JADX INFO: Access modifiers changed from: protected */
    public x8(i9 i9Var) {
        super(i9Var);
        this.f3983d = (AlarmManager) this.a.zzaw().getSystemService(NotificationCompat.CATEGORY_ALARM);
    }

    private final l m() {
        if (this.f3984e == null) {
            this.f3984e = new w8(this, this.b.u());
        }
        return this.f3984e;
    }

    @TargetApi(24)
    private final void n() {
        JobScheduler jobScheduler = (JobScheduler) this.a.zzaw().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(o());
        }
    }

    private final int o() {
        if (this.f3985f == null) {
            String valueOf = String.valueOf(this.a.zzaw().getPackageName());
            this.f3985f = Integer.valueOf((valueOf.length() != 0 ? "measurement".concat(valueOf) : new String("measurement")).hashCode());
        }
        return this.f3985f.intValue();
    }

    private final PendingIntent p() {
        Context zzaw = this.a.zzaw();
        Intent action = new Intent().setClassName(zzaw, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD");
        VdsAgent.onPendingIntentGetBroadcastBefore(zzaw, 0, action, 0);
        PendingIntent broadcast = PendingIntent.getBroadcast(zzaw, 0, action, 0);
        VdsAgent.onPendingIntentGetBroadcastAfter(zzaw, 0, action, 0, broadcast);
        return broadcast;
    }

    @Override // com.google.android.gms.measurement.internal.z8
    protected final boolean j() {
        AlarmManager alarmManager = this.f3983d;
        if (alarmManager != null) {
            alarmManager.cancel(p());
        }
        if (Build.VERSION.SDK_INT >= 24) {
            n();
            return false;
        }
        return false;
    }

    public final void k(long j2) {
        h();
        this.a.d();
        Context zzaw = this.a.zzaw();
        if (!f4.a(zzaw)) {
            this.a.a().t().a("Receiver not registered/enabled");
        }
        if (!n9.B(zzaw, false)) {
            this.a.a().t().a("Service not registered/enabled");
        }
        l();
        this.a.a().u().b("Scheduling upload, millis", Long.valueOf(j2));
        long a = this.a.zzax().a() + j2;
        this.a.x();
        if (j2 < Math.max(0L, x2.x.b(null).longValue()) && !m().c()) {
            m().b(j2);
        }
        this.a.d();
        if (Build.VERSION.SDK_INT < 24) {
            AlarmManager alarmManager = this.f3983d;
            if (alarmManager != null) {
                this.a.x();
                alarmManager.setInexactRepeating(2, a, Math.max(x2.s.b(null).longValue(), j2), p());
                return;
            }
            return;
        }
        Context zzaw2 = this.a.zzaw();
        ComponentName componentName = new ComponentName(zzaw2, "com.google.android.gms.measurement.AppMeasurementJobService");
        int o = o();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(AuthActivity.ACTION_KEY, "com.google.android.gms.measurement.UPLOAD");
        zzg.zza(zzaw2, new JobInfo.Builder(o, componentName).setMinimumLatency(j2).setOverrideDeadline(j2 + j2).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
    }

    public final void l() {
        h();
        this.a.a().u().a("Unscheduling upload");
        AlarmManager alarmManager = this.f3983d;
        if (alarmManager != null) {
            alarmManager.cancel(p());
        }
        m().d();
        if (Build.VERSION.SDK_INT >= 24) {
            n();
        }
    }
}
