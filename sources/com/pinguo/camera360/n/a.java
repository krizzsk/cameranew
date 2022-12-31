package com.pinguo.camera360.n;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.foundation.e;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.push.d;
import us.pinguo.push.h;
import vStudio.Android.Camera360.R;
/* compiled from: NotificationUtils.java */
/* loaded from: classes3.dex */
public class a {
    public static void a(NotificationManager notificationManager, NotificationCompat.Builder builder, String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel(str, str, 4));
            builder.setChannelId(str);
        }
    }

    private static void b(Context context, int i2, Intent intent, String str, boolean z, RemoteViews remoteViews, String str2, String str3) {
        NotificationManager notificationManager = (NotificationManager) e.b().getSystemService("notification");
        if (z) {
            intent.setFlags(603979776);
        }
        VdsAgent.onPendingIntentGetActivityShortBefore(context, i2, intent, 134217728);
        PendingIntent activity = PendingIntent.getActivity(context, i2, intent, 134217728);
        VdsAgent.onPendingIntentGetActivityShortAfter(context, i2, intent, 134217728, activity);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "channel_id_btn");
        if (Build.VERSION.SDK_INT >= 21) {
            builder.setSmallIcon(R.mipmap.ic_md_push);
        } else {
            builder.setSmallIcon(R.mipmap.ic_launcher);
        }
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher));
        a(notificationManager, builder, str);
        if (remoteViews != null) {
            builder.setCustomContentView(remoteViews);
        }
        if (!TextUtils.isEmpty(str2)) {
            builder.setContentTitle(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            builder.setContentText(str3);
        }
        builder.setContentIntent(activity);
        Notification build = builder.build();
        build.flags = 16;
        build.defaults = 1;
        notificationManager.notify(i2, build);
        VdsAgent.onNotify(notificationManager, i2, build);
    }

    public static void c(Context context, int i2, Bitmap bitmap, Intent intent, boolean z, h hVar) {
        if (bitmap != null) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.custom_notification);
            remoteViews.setImageViewBitmap(R.id.big_imageview, bitmap);
            b(context, i2, intent, "channel_id_banner", z, remoteViews, null, null);
            return;
        }
        b(context, i2, intent, "channel_normal", z, null, hVar.b(), hVar.a());
    }

    public static void d(Context context, int i2, Intent intent, boolean z, String str, String str2, Bitmap bitmap, com.pinguo.camera360.n.b.a aVar) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), (int) R.layout.notification_layout);
        if (Build.MANUFACTURER.contains("Xiaomi")) {
            remoteViews.setViewPadding(R.id.notification_layout_root, 0, 0, 0, 0);
        }
        remoteViews.setTextViewText(R.id.tv_title_push, str);
        remoteViews.setTextViewText(R.id.tv_msg_push, str2);
        String str3 = aVar.c;
        if (TextUtils.isEmpty(str3) || "null".equals(str3)) {
            str3 = BaseApplication.d().getResources().getString(R.string.push_btn_str);
        }
        remoteViews.setTextViewText(R.id.tv_push_btn, str3);
        if (bitmap == null) {
            remoteViews.setImageViewResource(R.id.iv_icon_push, R.mipmap.ic_launcher);
        } else {
            remoteViews.setImageViewBitmap(R.id.iv_icon_push, bitmap);
        }
        String str4 = aVar.b;
        if (!TextUtils.isEmpty(str4)) {
            if (str4.charAt(0) != '#') {
                str4 = "#" + str4;
            }
            try {
                remoteViews.setInt(R.id.tv_push_btn, "setBackgroundColor", Color.parseColor(str4));
            } catch (Exception unused) {
            }
        }
        b(context, i2, intent, "channel_id_btn", z, remoteViews, null, null);
    }

    public static void e(Context context, int i2, boolean z, Intent intent, Bitmap bitmap, h hVar, com.pinguo.camera360.n.b.a aVar) {
        if (aVar != null && aVar.a == 1) {
            d(context, i2, intent, z, hVar.b(), hVar.a(), bitmap, aVar);
            return;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (z) {
            intent.setFlags(603979776);
        }
        VdsAgent.onPendingIntentGetActivityShortBefore(context, i2, intent, 134217728);
        PendingIntent activity = PendingIntent.getActivity(context, i2, intent, 134217728);
        VdsAgent.onPendingIntentGetActivityShortAfter(context, i2, intent, 134217728, activity);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "channel_id_btn");
        builder.setLargeIcon(bitmap == null ? BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher) : bitmap);
        if (Build.VERSION.SDK_INT >= 21) {
            builder.setSmallIcon(R.mipmap.ic_md_push);
        } else {
            builder.setSmallIcon(R.mipmap.ic_launcher);
        }
        builder.setContentIntent(activity);
        String b = hVar.b();
        if (!TextUtils.isEmpty(b)) {
            builder.setContentTitle(b);
        }
        String a = hVar.a();
        if (!TextUtils.isEmpty(a)) {
            builder.setContentText(a);
        }
        a(notificationManager, builder, "channel_id_icon");
        Notification build = builder.build();
        build.flags = 16;
        build.defaults = 1;
        notificationManager.notify(i2, build);
        VdsAgent.onNotify(notificationManager, i2, build);
    }

    public static void f(Context context, int i2, boolean z, Intent intent, h hVar, com.pinguo.camera360.n.b.a aVar) {
        if (aVar != null && aVar.a == 1) {
            d(context, i2, intent, z, hVar.b(), hVar.a(), null, aVar);
        } else {
            b(context, i2, intent, "channel_normal", z, null, hVar.b(), hVar.a());
        }
    }

    public static boolean g(Context context, d dVar, boolean z) {
        if (context == null) {
            return false;
        }
        try {
            String f2 = dVar.f();
            b(context, dVar.e(), dVar.c(), "channel_normal", z, null, f2, dVar.d() + "\n\n");
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
