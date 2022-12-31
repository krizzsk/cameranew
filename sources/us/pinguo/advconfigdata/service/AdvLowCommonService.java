package us.pinguo.advconfigdata.service;

import android.app.AlarmManager;
import android.app.Application;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.advconfigdata.Utils.AdvConstants;
import us.pinguo.advconfigdata.Utils.SPUtils;
import us.pinguo.advconfigdata.service.lockscreen.BroadcastListener;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: classes3.dex */
public class AdvLowCommonService extends Service {
    private static int c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static AdvLowCommonService f9026d;
    private List<us.pinguo.advconfigdata.service.b> a;
    private BroadcastListener b;

    /* loaded from: classes3.dex */
    public static class InnerService extends Service {
        @Override // android.app.Service
        @Nullable
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i2, int i3) {
            VdsAgent.onServiceStartCommand(this, intent, i2, i3);
            AdvLowCommonService.d(this);
            return super.onStartCommand(intent, i2, i3);
        }
    }

    /* loaded from: classes3.dex */
    class a implements Runnable {
        a(AdvLowCommonService advLowCommonService) {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    Log.i(TJAdUnitConstants.String.VIDEO_INFO, "=========serviceAlive233!");
                    Thread.sleep(1000L);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements BroadcastListener.d {
        b() {
        }

        @Override // us.pinguo.advconfigdata.service.lockscreen.BroadcastListener.d
        public void a() {
            KeepLiveActivity.a();
        }

        @Override // us.pinguo.advconfigdata.service.lockscreen.BroadcastListener.d
        public void b() {
        }

        @Override // us.pinguo.advconfigdata.service.lockscreen.BroadcastListener.d
        public void c() {
            Intent intent = new Intent(AdvLowCommonService.this, KeepLiveActivity.class);
            intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
            AdvLowCommonService.this.startActivity(intent);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends us.pinguo.advconfigdata.service.a {
        public c() {
        }

        @Override // us.pinguo.advconfigdata.service.a
        public Application a() {
            return AdvLowCommonService.this.getApplication();
        }
    }

    private void b() {
        if (this.b == null) {
            BroadcastListener broadcastListener = new BroadcastListener(this);
            this.b = broadcastListener;
            broadcastListener.i(new b());
        }
    }

    private void c() {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        if (TextUtils.isEmpty((String) SPUtils.getMultiProcess(this, AdvConstants.KEY_LOCK_SCREEN_ACTION, ""))) {
            return;
        }
        this.a.add(new us.pinguo.advconfigdata.service.lockscreen.a(new c()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(InnerService innerService) {
        AdvLowCommonService advLowCommonService;
        if (Build.VERSION.SDK_INT < 18 || innerService == null || (advLowCommonService = f9026d) == null) {
            return;
        }
        advLowCommonService.startForeground(c, new Notification());
        innerService.startForeground(c, new Notification());
        innerService.stopSelf();
    }

    private void e() {
        Intent intent = new Intent("checkAdvServiceAlive");
        VdsAgent.onPendingIntentGetBroadcastBefore(this, 0, intent, 0);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, 0, intent, 0);
        VdsAgent.onPendingIntentGetBroadcastAfter(this, 0, intent, 0, broadcast);
        ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).setRepeating(0, System.currentTimeMillis(), 2000L, broadcast);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        for (us.pinguo.advconfigdata.service.b bVar : this.a) {
            bVar.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f9026d = this;
        c();
        b();
        e();
        for (us.pinguo.advconfigdata.service.b bVar : this.a) {
            bVar.onCreate();
        }
        new Thread(new a(this)).start();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        for (us.pinguo.advconfigdata.service.b bVar : this.a) {
            bVar.onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        for (us.pinguo.advconfigdata.service.b bVar : this.a) {
            bVar.onLowMemory();
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        VdsAgent.onServiceStart(this, intent, i2);
        super.onStart(intent, i2);
        for (us.pinguo.advconfigdata.service.b bVar : this.a) {
            bVar.a(intent, i2);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        VdsAgent.onServiceStartCommand(this, intent, i2, i3);
        for (us.pinguo.advconfigdata.service.b bVar : this.a) {
            bVar.d(intent, i2, i3);
        }
        if (Build.VERSION.SDK_INT < 18) {
            startForeground(c, new Notification());
        }
        return super.onStartCommand(intent, i2, i3);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        for (us.pinguo.advconfigdata.service.b bVar : this.a) {
            bVar.b(intent);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        for (us.pinguo.advconfigdata.service.b bVar : this.a) {
            bVar.onTrimMemory(i2);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        for (us.pinguo.advconfigdata.service.b bVar : this.a) {
            bVar.c(intent);
        }
        return super.onUnbind(intent);
    }
}
