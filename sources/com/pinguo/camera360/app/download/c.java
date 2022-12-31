package com.pinguo.camera360.app.download;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.lib.download.Config;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.util.i;
import vStudio.Android.Camera360.R;
/* compiled from: AppDownloadNotify.java */
/* loaded from: classes3.dex */
public class c {
    private Context a;
    private NotificationManager b = null;
    private NotificationCompat.Builder c = null;

    /* renamed from: d  reason: collision with root package name */
    private Notification f6194d = null;

    /* renamed from: e  reason: collision with root package name */
    private int f6195e = 360604;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, Integer> f6196f = new HashMap();

    public c() {
        this.a = null;
        this.a = BaseApplication.d();
        c();
    }

    private void c() {
        if (this.b == null) {
            this.b = (NotificationManager) this.a.getSystemService("notification");
            if (Build.VERSION.SDK_INT >= 26) {
                this.b.createNotificationChannel(new NotificationChannel("channel_id_btn", "channel_id_btn", 3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        Integer num;
        if (this.b == null || str == null || (num = this.f6196f.get(str)) == null) {
            return;
        }
        this.b.cancel(num.intValue());
        this.f6196f.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(String str) {
        return this.f6196f.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str, String str2) {
        c();
        if (this.b == null || str == null) {
            return;
        }
        int b = ((int) (i.b(str.getBytes()) & 1342177279)) + 360603 + 10000;
        this.f6196f.put(str, Integer.valueOf(b));
        Context context = this.a;
        Intent intent = new Intent();
        VdsAgent.onPendingIntentGetActivityShortBefore(context, b, intent, 134217728);
        PendingIntent activity = PendingIntent.getActivity(context, b, intent, 134217728);
        VdsAgent.onPendingIntentGetActivityShortAfter(context, b, intent, 134217728, activity);
        if (us.pinguo.util.c.b) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this.a, "channel_id_btn");
            this.c = builder;
            builder.setSmallIcon(R.drawable.image_download);
            this.c.setContentTitle(str);
            this.c.setContentText(str2);
            this.c.setProgress(100, 0, false);
            this.c.setContentIntent(activity);
            NotificationManager notificationManager = this.b;
            Notification build = this.c.build();
            notificationManager.notify(b, build);
            VdsAgent.onNotify(notificationManager, b, build);
            return;
        }
        Notification notification = new Notification();
        this.f6194d = notification;
        notification.icon = R.drawable.image_download;
        notification.tickerText = str;
        notification.contentIntent = activity;
        notification.contentView = new RemoteViews(this.a.getPackageName(), (int) R.layout.push_update_notify);
        this.f6194d.contentView.setTextColor(R.id.tv_push_noti_update, -9408400);
        this.f6194d.contentView.setTextViewText(R.id.tv_push_noti_update, str2);
        Notification notification2 = this.f6194d;
        notification2.flags = 16;
        NotificationManager notificationManager2 = this.b;
        notificationManager2.notify(b, notification2);
        VdsAgent.onNotify(notificationManager2, b, notification2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(String str, Config config, int i2) {
        Context d2 = BaseApplication.d();
        c();
        this.f6195e++;
        String string = BaseApplication.d().getResources().getString(i2);
        Intent intent = new Intent("us.pinguo.camera360.app.download.RETRY_SERVICE");
        intent.putExtra("download_config", config);
        intent.putExtra("download_title", str);
        intent.putExtra("finish_action", 1);
        intent.setPackage(BaseApplication.d().getPackageName());
        int i3 = this.f6195e;
        VdsAgent.onPendingIntentGetServiceBefore(d2, i3, intent, 134217728);
        PendingIntent service = PendingIntent.getService(d2, i3, intent, 134217728);
        VdsAgent.onPendingIntentGetServiceAfter(d2, i3, intent, 134217728, service);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(d2, "channel_id_btn");
        this.c = builder;
        builder.setSmallIcon(R.drawable.image_download);
        this.c.setContentTitle(str);
        this.c.setContentText(string);
        this.c.setContentIntent(service);
        this.c.setAutoCancel(true);
        NotificationManager notificationManager = this.b;
        int i4 = this.f6195e;
        Notification build = this.c.build();
        notificationManager.notify(i4, build);
        VdsAgent.onNotify(notificationManager, i4, build);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(String str, String str2, int i2) {
        Integer num;
        if (this.b == null || str == null || (num = this.f6196f.get(str)) == null) {
            return;
        }
        if (us.pinguo.util.c.b) {
            NotificationCompat.Builder builder = this.c;
            if (builder == null) {
                return;
            }
            builder.setContentTitle(str);
            this.c.setContentText(str2);
            this.c.setSmallIcon(R.drawable.image_download);
            this.c.setProgress(100, i2, false);
            NotificationManager notificationManager = this.b;
            int intValue = num.intValue();
            Notification build = this.c.build();
            notificationManager.notify(intValue, build);
            VdsAgent.onNotify(notificationManager, intValue, build);
            return;
        }
        Notification notification = this.f6194d;
        if (notification == null) {
            return;
        }
        notification.contentView.setTextViewText(R.id.tv_push_noti_update, str2);
        Notification notification2 = this.f6194d;
        notification2.icon = R.drawable.image_download;
        notification2.contentView.setProgressBar(R.id.pb_push_noti_update, 100, i2, false);
        this.f6194d.flags = 16;
        NotificationManager notificationManager2 = this.b;
        int intValue2 = num.intValue();
        Notification notification3 = this.f6194d;
        notificationManager2.notify(intValue2, notification3);
        VdsAgent.onNotify(notificationManager2, intValue2, notification3);
    }
}
