package com.google.android.play.core.assetpacks;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
/* loaded from: classes2.dex */
public class AssetPackExtractionService extends Service {
    private final com.google.android.play.core.internal.j a = new com.google.android.play.core.internal.j("AssetPackExtractionService");
    Context b;
    k3 c;

    /* renamed from: d  reason: collision with root package name */
    k0 f4694d;

    /* renamed from: e  reason: collision with root package name */
    private i0 f4695e;

    /* renamed from: f  reason: collision with root package name */
    private NotificationManager f4696f;

    private final synchronized void c(Bundle bundle) {
        String string = bundle.getString("notification_title");
        String string2 = bundle.getString("notification_subtext");
        long j2 = bundle.getLong("notification_timeout");
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("notification_on_click_intent");
        int i2 = Build.VERSION.SDK_INT;
        Notification.Builder timeoutAfter = i2 >= 26 ? new Notification.Builder(this.b, "playcore-assetpacks-service-notification-channel").setTimeoutAfter(j2) : new Notification.Builder(this.b).setPriority(-2);
        if (pendingIntent != null) {
            timeoutAfter.setContentIntent(pendingIntent);
        }
        timeoutAfter.setSmallIcon(17301633).setOngoing(false).setContentTitle(string).setSubText(string2);
        if (i2 >= 21) {
            timeoutAfter.setColor(bundle.getInt("notification_color")).setVisibility(-1);
        }
        Notification build = timeoutAfter.build();
        this.a.f("Starting foreground service.", new Object[0]);
        this.c.n(true);
        if (i2 >= 26) {
            this.f4696f.createNotificationChannel(new NotificationChannel("playcore-assetpacks-service-notification-channel", bundle.getString("notification_channel_name"), 2));
        }
        startForeground(-1883842196, build);
    }

    public final synchronized Bundle a(Bundle bundle) {
        int i2 = bundle.getInt("action_type");
        com.google.android.play.core.internal.j jVar = this.a;
        Integer valueOf = Integer.valueOf(i2);
        jVar.c("updateServiceState: %d", valueOf);
        if (i2 == 1) {
            c(bundle);
        } else if (i2 == 2) {
            b();
        } else {
            this.a.e("Unknown action type received: %d", valueOf);
        }
        return new Bundle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void b() {
        this.a.f("Stopping service.", new Object[0]);
        this.c.n(false);
        stopForeground(true);
        stopSelf();
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f4695e;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.a.c("onCreate", new Object[0]);
        j2.a(getApplicationContext()).a(this);
        this.f4695e = new i0(this.b, this, this.f4694d);
        this.f4696f = (NotificationManager) this.b.getSystemService("notification");
    }
}
