package us.pinguo.push;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.appcompat.app.NotificationCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: PushNotify.java */
/* loaded from: classes6.dex */
public class g {
    public static boolean a(d dVar, boolean z) {
        Context a = f.a();
        if (a == null) {
            return false;
        }
        try {
            String f2 = dVar.f();
            String str = dVar.d() + "\n\n";
            int e2 = dVar.e();
            int a2 = dVar.a();
            int b = dVar.b();
            Intent c = dVar.c();
            NotificationManager notificationManager = (NotificationManager) a.getSystemService("notification");
            if (z) {
                c.setFlags(603979776);
            }
            VdsAgent.onPendingIntentGetActivityShortBefore(a, e2, c, 134217728);
            PendingIntent activity = PendingIntent.getActivity(a, e2, c, 134217728);
            VdsAgent.onPendingIntentGetActivityShortAfter(a, e2, c, 134217728, activity);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(a);
            if (Build.VERSION.SDK_INT >= 21) {
                builder.setLargeIcon(BitmapFactory.decodeResource(a.getResources(), a2));
                builder.setSmallIcon(b);
            } else {
                builder.setSmallIcon(a2);
            }
            builder.setContentTitle(f2);
            builder.setContentText(str);
            builder.setContentIntent(activity);
            Notification build = builder.build();
            build.flags = 16;
            build.defaults = 1;
            notificationManager.notify(e2, build);
            VdsAgent.onNotify(notificationManager, e2, build);
            return true;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }
}
