package us.pinguo.bigdata.b;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.bigdata.config.BDConfigManager;
import us.pinguo.bigdata.config.BDServerConfig;
import us.pinguo.bigdata.task.CopyLegacyFilesTask;
import us.pinguo.bigdata.task.basic.IBDTask;
/* compiled from: BDDispatcher.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: l  reason: collision with root package name */
    private static volatile a f9109l;
    private IBDTask a;
    private IBDTask b;
    private IBDTask c;

    /* renamed from: d  reason: collision with root package name */
    private IBDTask f9110d;

    /* renamed from: e  reason: collision with root package name */
    private IBDTask f9111e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f9112f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f9113g;

    /* renamed from: h  reason: collision with root package name */
    private d f9114h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9115i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9116j = true;

    /* renamed from: k  reason: collision with root package name */
    private Map<String, Long> f9117k = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BDDispatcher.java */
    /* renamed from: us.pinguo.bigdata.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0360a implements Runnable {
        RunnableC0360a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BDDispatcher.java */
    /* loaded from: classes3.dex */
    public class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            us.pinguo.common.log.a.d("bdsdk2", "onActivityCreated ", new Object[0]);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            us.pinguo.common.log.a.d("bdsdk2", "onActivityPaused", new Object[0]);
            a.this.p(activity);
            if (a.this.a == null) {
                us.pinguo.common.log.a.e("error ---- onActivityPaused BDStatistics must be init before using it.", new Object[0]);
                return;
            }
            ((us.pinguo.bigdata.task.d) a.this.a.getOrigin()).j();
            if (a.this.f9113g == null || a.this.f9112f == null || !us.pinguo.bigdata.a.f9106e) {
                return;
            }
            a.this.f9113g.postDelayed(a.this.f9112f, 3000L);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            us.pinguo.common.log.a.d("bdsdk2", "onActivityResumed ", new Object[0]);
            a.this.q(activity);
            if (a.this.f9113g == null || a.this.f9112f == null) {
                return;
            }
            a.this.f9113g.removeCallbacks(a.this.f9112f);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            us.pinguo.common.log.a.d("bdsdk2", "onActivityStarted ", new Object[0]);
            us.pinguo.bigdata.e.a.a().c(false);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            us.pinguo.bigdata.e.a.a().c(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BDDispatcher.java */
    /* loaded from: classes3.dex */
    public class c implements us.pinguo.bigdata.task.e.a {
        c() {
        }

        @Override // us.pinguo.bigdata.task.e.a
        public void a(String str) {
            try {
                a.this.s(true);
            } catch (Exception unused) {
            }
        }

        @Override // us.pinguo.bigdata.task.e.a
        public void b(String str) {
            us.pinguo.common.log.a.m("bdsdk2", "completeFile：" + str, new Object[0]);
            try {
                BDServerConfig serverConfig = BDConfigManager.instance().getServerConfig();
                if (serverConfig == null) {
                    return;
                }
                if (BDServerConfig.UploadType.batchInQuantum.name().equals(serverConfig.getMechanism())) {
                    a.this.s(false);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // us.pinguo.bigdata.task.e.a
        public void c(us.pinguo.bigdata.task.d dVar) {
        }
    }

    /* compiled from: BDDispatcher.java */
    /* loaded from: classes3.dex */
    public interface d {
        void a(String str, long j2);
    }

    private void i() {
        this.f9113g = new Handler();
        this.f9112f = new RunnableC0360a();
    }

    private void j() {
        if (this.f9116j) {
            us.pinguo.common.log.a.m("bdsdk2", "initServerRequest", new Object[0]);
            BDServerConfig serverConfig = BDConfigManager.instance().getServerConfig();
            if (serverConfig == null) {
                return;
            }
            if (serverConfig.getPostPush()) {
                if (this.c == null) {
                    this.c = us.pinguo.bigdata.task.basic.a.a().proxy(new us.pinguo.bigdata.task.c());
                }
                this.c.execute();
            }
            if (this.f9110d == null) {
                this.f9110d = us.pinguo.bigdata.task.basic.a.a().proxy(new us.pinguo.bigdata.task.a());
            }
            this.f9110d.execute();
            BDConfigManager.instance().updateLocalConfig();
        }
    }

    private void k(Application application) {
        if (this.a == null) {
            this.a = us.pinguo.bigdata.task.basic.a.a().proxy(new us.pinguo.bigdata.task.d(application, new c()));
        }
        this.a.execute();
        if (this.b == null) {
            this.b = us.pinguo.bigdata.task.basic.a.a().proxy(new CopyLegacyFilesTask(application));
        }
        this.b.execute();
    }

    public static a l() {
        if (f9109l == null) {
            synchronized (a.class) {
                f9109l = new a();
            }
        }
        return f9109l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        BDServerConfig serverConfig;
        if (this.f9116j && (serverConfig = BDConfigManager.instance().getServerConfig()) != null && this.a != null && serverConfig.isOnExit()) {
            us.pinguo.common.log.a.d("bdsdk2", "upload on pause.", new Object[0]);
            ((us.pinguo.bigdata.task.d) this.a.getOrigin()).l();
        }
    }

    private void n(Application application) {
        if (application == null) {
            return;
        }
        application.registerActivityLifecycleCallbacks(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Activity activity) {
        Long l2;
        d dVar;
        if (activity != null) {
            String name = activity.getClass().getName();
            Map<String, Long> map = this.f9117k;
            if (map == null || !map.containsKey(name) || (l2 = this.f9117k.get(name)) == null || l2.longValue() <= 0) {
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - l2.longValue();
            if (elapsedRealtime > 0 && (dVar = this.f9114h) != null) {
                dVar.a(name, elapsedRealtime);
            }
            this.f9117k.remove(name);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Activity activity) {
        Map<String, Long> map;
        if (activity == null || (map = this.f9117k) == null) {
            return;
        }
        map.put(activity.getClass().getName(), Long.valueOf(SystemClock.elapsedRealtime()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z) {
        if (this.f9116j) {
            if (this.f9111e == null) {
                this.f9111e = us.pinguo.bigdata.task.basic.a.a().proxy(new us.pinguo.bigdata.task.b());
            }
            ((us.pinguo.bigdata.task.b) this.f9111e.getOrigin()).d(z);
            this.f9111e.execute();
        }
    }

    public void h(Application application) {
        us.pinguo.common.log.a.d("bdsdk2", "bdsdk init", new Object[0]);
        k(application);
        i();
        n(application);
    }

    public void o(boolean z) {
        this.f9116j = z;
    }

    public void r() {
        if (this.f9116j) {
            if (this.a == null) {
                us.pinguo.common.log.a.e("error ---- BDStatistics must be init before using it.", new Object[0]);
                return;
            }
            if (!this.f9115i) {
                j();
                this.f9115i = true;
            }
            BDServerConfig serverConfig = BDConfigManager.instance().getServerConfig();
            if (serverConfig == null) {
                return;
            }
            boolean onStartUp = serverConfig.getOnStartUp();
            String mechanism = serverConfig.getMechanism();
            if (onStartUp || BDServerConfig.UploadType.batchOnStartup.name().equals(mechanism)) {
                ((us.pinguo.bigdata.task.d) this.a.getOrigin()).l();
            }
        }
    }
}
