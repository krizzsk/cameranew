package us.pinguo.camera360.App;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import com.adjust.sdk.Adjust;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import com.mob.tools.log.MobUncaughtExceptionHandler;
import com.pinguo.camera360.save.processer.f;
import com.pinguo.lib.AppContextProvider;
import com.tapjoy.TJAdUnitConstants;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.trace.TracePlugin;
import com.tencent.matrix.trace.config.TraceConfig;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.advsdk.a.b;
import us.pinguo.advsdk.a.l;
import us.pinguo.advsdk.manager.LaunchScreenManager;
import us.pinguo.advstrategy.PgAdvStrategyManager;
import us.pinguo.advstrategy.strategybean.StrategyItem;
import us.pinguo.bigalbum.BigAlbumConfig;
import us.pinguo.bigalbum.BigAlbumManager;
import us.pinguo.foundation.base.ActivityRecorder;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.utils.AsyncTask;
import us.pinguo.foundation.utils.i;
import us.pinguo.foundation.utils.l0;
import us.pinguo.hawkeye.a;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.repository2020.database.EffectDbManager;
import us.pinguo.util.v;
import vStudio.Android.Camera360.Conditions;
import vStudio.Android.Camera360.activity.CameraActivity;
/* loaded from: classes3.dex */
public class PgCameraApplication extends BaseApplication {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends BigAlbumConfig {
        a(PgCameraApplication pgCameraApplication) {
        }

        @Override // us.pinguo.bigalbum.BigAlbumConfig
        public String getAppChannel() {
            return i.a();
        }

        @Override // us.pinguo.bigalbum.BigAlbumConfig
        public String getAppName() {
            return "camera360";
        }
    }

    /* loaded from: classes3.dex */
    private class b implements Application.ActivityLifecycleCallbacks {

        /* loaded from: classes3.dex */
        class a implements l {
            a(b bVar) {
            }

            @Override // us.pinguo.advsdk.a.l
            public void onAdDestroy(us.pinguo.advsdk.a.b bVar) {
            }

            @Override // us.pinguo.advsdk.a.l
            public void onPGNativeClick(us.pinguo.advsdk.a.b bVar) {
            }

            @Override // us.pinguo.advsdk.a.l
            public void onPGNativeFailed(int i2, String str) {
            }

            @Override // us.pinguo.advsdk.a.l
            public void onPGNativeSuccess(us.pinguo.advsdk.a.b bVar) {
                h.a.v(IADStatisticBase.UNIT_ID_SPLASH.toLowerCase(), TrackLoadSettingsAtom.TYPE);
            }

            @Override // us.pinguo.advsdk.a.l
            public void onPGRewardVideoClose(us.pinguo.advsdk.a.b bVar) {
            }

            @Override // us.pinguo.advsdk.a.l
            public void onPGRewardVideoFailed(us.pinguo.advsdk.a.b bVar) {
            }

            @Override // us.pinguo.advsdk.a.l
            public void onPGRewardVideoSuccess(us.pinguo.advsdk.a.b bVar) {
            }

            @Override // us.pinguo.advsdk.a.l
            public void onPreloadFailed(int i2, String str) {
            }

            @Override // us.pinguo.advsdk.a.l
            public void onPreloadSuccess(us.pinguo.advsdk.a.b bVar) {
            }
        }

        /* renamed from: us.pinguo.camera360.App.PgCameraApplication$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0369b implements b.InterfaceC0356b {
            C0369b(b bVar) {
            }

            @Override // us.pinguo.advsdk.a.b.InterfaceC0356b
            public void a() {
            }

            @Override // us.pinguo.advsdk.a.b.InterfaceC0356b
            public void b(String str) {
                us.pinguo.advsdk.utils.b.a("launchScreenError:" + str);
            }

            @Override // us.pinguo.advsdk.a.b.InterfaceC0356b
            public void c() {
                h.a.v(IADStatisticBase.UNIT_ID_SPLASH.toLowerCase(), "show");
            }
        }

        private b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            l0.c(activity);
            us.pinguo.foundation.utils.h.b(activity);
            us.pinguo.common.log.a.c("onActivityCreated:" + activity + ", savedInstanceState:" + bundle, new Object[0]);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            l0.b(activity);
            us.pinguo.foundation.utils.h.c(activity);
            us.pinguo.common.log.a.c("onActivityDestroyed:" + activity + ", isFinishing:" + activity.isFinishing(), new Object[0]);
            PgCameraApplication.q(PgCameraApplication.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Adjust.onPause();
            us.pinguo.common.log.a.c("onActivityPaused:" + activity, new Object[0]);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            l0.d(activity);
            Adjust.onResume();
            us.pinguo.common.log.a.c("onActivityResumed:" + activity, new Object[0]);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            us.pinguo.common.log.a.c("onActivitySaveInstanceState:" + activity + ", outState:" + bundle, new Object[0]);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            ActivityRecorder.getInstance().a(activity);
            us.pinguo.common.log.a.c("onActivityStarted:" + activity, new Object[0]);
            PgCameraApplication.k(PgCameraApplication.this);
            if (ActivityRecorder.getInstance().b() == 1) {
                if (((BaseApplication) PgCameraApplication.this).c != 1 || !BaseApplication.f11534f) {
                    if (((BaseApplication) PgCameraApplication.this).c > 1) {
                        PgCameraApplication.y(PgCameraApplication.this);
                        BaseApplication.f11534f = false;
                        if (!(activity instanceof CameraActivity)) {
                            StrategyItem strategyItem = PgAdvStrategyManager.getInstance().getStrategyKeeper(activity).getStrategyItem(IADStatisticBase.UNIT_ID_SPLASH);
                            if (strategyItem != null && strategyItem.realTimeLoad == 1 && TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON.equals(strategyItem.on_off) && strategyItem.waterfall.size() > 0) {
                                com.pinguo.camera360.adv.e.a aVar = new com.pinguo.camera360.adv.e.a(activity, IADStatisticBase.UNIT_ID_SPLASH, null);
                                h.a.v(IADStatisticBase.UNIT_ID_SPLASH.toLowerCase(), "preload");
                                aVar.d(new a(this));
                            }
                            if (LaunchScreenManager.getInstance().g(IADStatisticBase.UNIT_ID_SPLASH)) {
                                LaunchScreenManager.getInstance().f(activity, IADStatisticBase.UNIT_ID_SPLASH, new C0369b(this));
                            }
                            us.pinguo.common.log.a.c("热启动->启动次数:" + ((BaseApplication) PgCameraApplication.this).f11535d, new Object[0]);
                            us.pinguo.foundation.statistics.c cVar = h.a;
                            cVar.n("hot_startup", "" + ((BaseApplication) PgCameraApplication.this).f11535d);
                        }
                    }
                } else {
                    PgCameraApplication.s(PgCameraApplication.this);
                    BaseApplication.f11534f = true;
                    us.pinguo.common.log.a.c("冷启动->启动次数:" + ((BaseApplication) PgCameraApplication.this).f11535d, new Object[0]);
                    us.pinguo.common.log.a.c("热启动->启动次数:" + ((BaseApplication) PgCameraApplication.this).f11535d, new Object[0]);
                    us.pinguo.foundation.statistics.c cVar2 = h.a;
                    cVar2.n("cold_startup", "" + ((BaseApplication) PgCameraApplication.this).f11535d);
                    cVar2.n("hot_startup", "" + ((BaseApplication) PgCameraApplication.this).f11535d);
                }
                if (((BaseApplication) PgCameraApplication.this).f11535d == Integer.MAX_VALUE) {
                    ((BaseApplication) PgCameraApplication.this).f11535d = 1;
                }
                if (((BaseApplication) PgCameraApplication.this).c == Integer.MAX_VALUE) {
                    ((BaseApplication) PgCameraApplication.this).c = 1;
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            us.pinguo.common.log.a.c("onActivityStopped:" + activity, new Object[0]);
            ActivityRecorder.getInstance().e(activity);
        }

        /* synthetic */ b(PgCameraApplication pgCameraApplication, a aVar) {
            this();
        }
    }

    private static void A() {
        AppGoto appGoto = AppGoto.getInstance();
        appGoto.a(new us.pinguo.foundation.interaction.f.a());
        appGoto.a(new us.pinguo.foundation.interaction.f.c());
        appGoto.a(new us.pinguo.foundation.interaction.f.b());
    }

    private void B() {
        if (Conditions.b()) {
            us.pinguo.hawkeye.b bVar = us.pinguo.hawkeye.b.f11145f;
            a.C0397a c0397a = new a.C0397a();
            boolean z = us.pinguo.foundation.d.f10985d;
            c0397a.c(z);
            c0397a.b(false);
            c0397a.d(true);
            bVar.d(c0397a.a());
            if (z) {
                bVar.a(new j.a.b.a.a());
            }
        }
    }

    private void C() {
        Matrix.Builder builder = new Matrix.Builder(this);
        builder.pluginListener(new AnrListener(this));
        TracePlugin tracePlugin = new TracePlugin(new TraceConfig.Builder().enableFPS(false).enableAnrTrace(true).enableStartup(true).enableIdleHandlerTrace(true).enableMainThreadPriorityTrace(true).enableSignalAnrTrace(true).isDebug(false).isDevEnv(false).build());
        builder.plugin(tracePlugin);
        Matrix.init(builder.build());
        tracePlugin.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public /* synthetic */ void E() {
        if (v.j()) {
            z();
        }
        MobUncaughtExceptionHandler.disable();
        us.pinguo.common.log.a.k("init EffectDbManager", new Object[0]);
        EffectDbManager.a.a();
    }

    static /* synthetic */ int k(PgCameraApplication pgCameraApplication) {
        int i2 = pgCameraApplication.c;
        pgCameraApplication.c = i2 + 1;
        return i2;
    }

    static /* synthetic */ int q(PgCameraApplication pgCameraApplication) {
        int i2 = pgCameraApplication.c;
        pgCameraApplication.c = i2 - 1;
        return i2;
    }

    static /* synthetic */ int s(PgCameraApplication pgCameraApplication) {
        int i2 = pgCameraApplication.f11535d;
        pgCameraApplication.f11535d = i2 + 1;
        return i2;
    }

    static /* synthetic */ int y(PgCameraApplication pgCameraApplication) {
        int i2 = pgCameraApplication.f11535d;
        pgCameraApplication.f11535d = i2 + 1;
        return i2;
    }

    private void z() {
        BigAlbumManager.instance().init(this, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.librouter.application.BaseApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        com.google.android.play.core.splitcompat.a.i(this);
    }

    @Override // us.pinguo.librouter.application.BaseApplication
    protected void g(boolean z) {
        i.f(us.pinguo.admobvista.a.a(this));
        PGInitManager.initBeforeDex(this, z);
        us.pinguo.librouter.a.a(this, z);
        B();
    }

    @Override // us.pinguo.librouter.application.BaseApplication
    protected void h() {
        us.pinguo.librouter.a.b(this);
    }

    @Override // us.pinguo.librouter.application.BaseApplication
    protected void i() {
        new e().d(this);
        d.j.a.a.a(this);
        A();
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: us.pinguo.camera360.App.d
            @Override // java.lang.Runnable
            public final void run() {
                PgCameraApplication.this.E();
            }
        });
        registerActivityLifecycleCallbacks(new b(this, null));
        us.pinguo.webview.c.e(this, "us.pinguo.camera360.web.privider");
        us.pinguo.librouter.a.c(this);
        h.b.r("", "validity_period_active");
        C();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
    }

    @Override // us.pinguo.librouter.application.BaseApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        AppContextProvider.init(this);
        us.pinguo.processor.i.a.k(new f());
    }
}
