package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.Constants;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: AlarmManagerScheduler.java */
/* loaded from: classes2.dex */
public class a implements r {
    private final Context a;
    private final com.google.android.datatransport.runtime.w.j.c b;
    private AlarmManager c;

    /* renamed from: d  reason: collision with root package name */
    private final SchedulerConfig f3399d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.x.a f3400e;

    public a(Context context, com.google.android.datatransport.runtime.w.j.c cVar, com.google.android.datatransport.runtime.x.a aVar, SchedulerConfig schedulerConfig) {
        this(context, cVar, (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM), aVar, schedulerConfig);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.r
    public void a(com.google.android.datatransport.runtime.m mVar, int i2) {
        b(mVar, i2, false);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.r
    public void b(com.google.android.datatransport.runtime.m mVar, int i2, boolean z) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", mVar.b());
        builder.appendQueryParameter(Constants.FirelogAnalytics.PARAM_PRIORITY, String.valueOf(com.google.android.datatransport.runtime.y.a.a(mVar.d())));
        if (mVar.c() != null) {
            builder.appendQueryParameter("extras", Base64.encodeToString(mVar.c(), 0));
        }
        Intent intent = new Intent(this.a, AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i2);
        if (!z && c(intent)) {
            com.google.android.datatransport.runtime.u.a.a("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", mVar);
            return;
        }
        long I = this.b.I(mVar);
        long g2 = this.f3399d.g(mVar.d(), I, i2);
        com.google.android.datatransport.runtime.u.a.b("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", mVar, Long.valueOf(g2), Long.valueOf(I), Integer.valueOf(i2));
        Context context = this.a;
        VdsAgent.onPendingIntentGetBroadcastBefore(context, 0, intent, 0);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 0);
        VdsAgent.onPendingIntentGetBroadcastAfter(context, 0, intent, 0, broadcast);
        this.c.set(3, this.f3400e.a() + g2, broadcast);
    }

    @VisibleForTesting
    boolean c(Intent intent) {
        Context context = this.a;
        VdsAgent.onPendingIntentGetBroadcastBefore(context, 0, intent, 536870912);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 536870912);
        VdsAgent.onPendingIntentGetBroadcastAfter(context, 0, intent, 536870912, broadcast);
        return broadcast != null;
    }

    @VisibleForTesting
    a(Context context, com.google.android.datatransport.runtime.w.j.c cVar, AlarmManager alarmManager, com.google.android.datatransport.runtime.x.a aVar, SchedulerConfig schedulerConfig) {
        this.a = context;
        this.b = cVar;
        this.c = alarmManager;
        this.f3400e = aVar;
        this.f3399d = schedulerConfig;
    }
}
