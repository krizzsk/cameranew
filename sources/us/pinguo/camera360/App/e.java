package us.pinguo.camera360.App;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Looper;
import android.os.MessageQueue;
import androidx.core.content.ContextCompat;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.bun.miitmdid.core.JLibrary;
import com.huawei.HuaweiAgent;
import com.pinguo.camera360.adv.oaid.MiitHelper;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.tencent.bugly.crashreport.CrashReport;
import j.a.f.i;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.camera360.module.CameraModuleInit;
import us.pinguo.common.pgdownloader.download.PGDownloadManger;
import us.pinguo.foundation.Conditions;
import us.pinguo.foundation.statistics.h;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.push.PushPgReceiver;
import us.pinguo.share.core.PGShareManager;
import us.pinguo.user.User;
import us.pinguo.user.u0;
import us.pinguo.user.util.n;
import us.pinguo.user.x0;
import vStudio.Android.Camera360.activity.CameraActivity;
import vStudio.Android.Camera360.activity.f;
/* compiled from: InitManagerPrivacyUnsafe.kt */
/* loaded from: classes3.dex */
public final class e {
    private final void a(Context context) {
        Adjust.onCreate(new AdjustConfig(context, "eq83z4pn2vb4", Conditions.b() ? AdjustConfig.ENVIRONMENT_SANDBOX : AdjustConfig.ENVIRONMENT_PRODUCTION));
    }

    private final void b(Context context) {
        PushPgReceiver pushPgReceiver = new PushPgReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(pushPgReceiver, intentFilter);
    }

    private final void c() {
        com.pinguo.camera360.adv.d.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(Application application) {
        s.h(application, "$application");
        if (ContextCompat.checkSelfPermission(application.getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            CameraModuleInit.initPushSDK(application.getApplicationContext());
            f.a();
        }
        User.C(new x0());
        new CameraActivity.d().execute(new Void[0]);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String g(Application application) {
        s.h(application, "$application");
        return us.pinguo.bigdata.f.a.e(application);
    }

    private final void h(Context context) {
        String b;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (us.pinguo.foundation.d.f10985d) {
                us.pinguo.common.log.a.c("Share init, load share_test", new Object[0]);
                b = us.pinguo.foundation.utils.e.b(context, "share_test.json");
                s.g(b, "{\n                L.d(\"S…test.json\")\n            }");
            } else {
                us.pinguo.common.log.a.c("Share init, load share release", new Object[0]);
                b = us.pinguo.foundation.utils.e.b(context, "share_release.json");
                s.g(b, "{\n                L.d(\"S…ease.json\")\n            }");
            }
            PGShareManager.getInstance().init(context, b);
        } catch (IOException e2) {
            e2.printStackTrace();
            throw new RuntimeException("Read share param config fail!");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        us.pinguo.common.log.a.c(s.q("Share init:", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)), new Object[0]);
    }

    public final void d(Application application) {
        s.h(application, "application");
        if (vStudio.Android.Camera360.guide.f.a.a.a()) {
            e(application);
        }
    }

    public final void e(final Application application) {
        s.h(application, "application");
        a(application);
        c();
        i iVar = i.a;
        iVar.b(application);
        iVar.c(vStudio.Android.Camera360.Conditions.a());
        if (com.pinguo.camera360.d.a) {
            us.pinguo.bigdata.a.m(false);
            iVar.c(false);
            iVar.d(false);
            us.pinguo.foundation.statistics.b.c(false);
        } else {
            us.pinguo.foundation.statistics.b.c(vStudio.Android.Camera360.Conditions.a());
        }
        us.pinguo.bigdata.a.f(application);
        us.pinguo.bigdata.a.f9106e = us.pinguo.foundation.utils.i.c();
        us.pinguo.bigdata.a.f9107f = us.pinguo.foundation.base.e.a(application, "enable_bigdata_session", true);
        String e2 = us.pinguo.bigdata.a.e();
        us.pinguo.common.log.a.c(s.q("BDStatisticsEid=", e2), new Object[0]);
        Adjust.addSessionCallbackParameter("BDStatisticsEid", e2);
        HuaweiAgent.get().init(application);
        com.pinguo.camera360.d.d(application);
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: us.pinguo.camera360.App.b
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean f2;
                f2 = e.f(application);
                return f2;
            }
        });
        us.pinguo.librouter.b.b.b().init(application);
        us.pinguo.librouter.b.b.b().getInterface().d(CameraBusinessSettingModel.v().l());
        u0.g(new u0.b() { // from class: us.pinguo.camera360.App.a
            @Override // us.pinguo.user.u0.b
            public final String a() {
                String g2;
                g2 = e.g(application);
                return g2;
            }
        });
        CameraModuleInit.initBigData(application);
        CameraModuleInit.initCrashHandler(true, application);
        h(application);
        if (vStudio.Android.Camera360.Conditions.d() || vStudio.Android.Camera360.Conditions.e() || vStudio.Android.Camera360.Conditions.c()) {
            try {
                Method declaredMethod = Class.forName("com.google.firebase.FirebaseApp").getDeclaredMethod("initializeApp", Context.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, application);
                Class<?> cls = Class.forName("us.pinguo.libgponly.remoteconfig.RemoteConfig");
                Field declaredField = cls.getDeclaredField("INSTANCE");
                declaredField.setAccessible(true);
                Method declaredMethod2 = cls.getDeclaredMethod("init", new Class[0]);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(declaredField.get(null), new Object[0]);
            } catch (Exception e3) {
                CrashReport.postCatchedException(e3);
            }
        }
        try {
            JLibrary.InitEntry(application);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        MiitHelper.getInstance().b(application);
        us.pinguo.librouter.c.d.b().initAdvModule(BaseApplication.e());
        PGInitManager.initNetworkSDK(application, Boolean.FALSE);
        PGDownloadManger.Companion.getInstance().init(application, us.pinguo.foundation.d.f10985d, true);
        n.a.h(null);
        b(application);
        Object systemService = application.getSystemService("activity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        h.b.F("total_ram", String.valueOf((((float) memoryInfo.totalMem) / 1024.0f) / 1024.0f));
    }
}
