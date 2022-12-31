package us.pinguo.foundation.o;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.c;
import com.google.android.play.core.splitinstall.d;
import com.tencent.bugly.crashreport.CrashReport;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.Conditions;
import us.pinguo.foundation.R;
import us.pinguo.foundation.e;
import us.pinguo.foundation.o.c;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.utils.k0;
import us.pinguo.util.q;
/* compiled from: DynamicFeatureManager.kt */
/* loaded from: classes4.dex */
public final class c {
    public static final c a = new c();
    private static final com.google.android.play.core.splitinstall.a b;
    private static boolean c;

    /* renamed from: d  reason: collision with root package name */
    private static int f11038d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile String f11039e;

    /* compiled from: DynamicFeatureManager.kt */
    /* loaded from: classes4.dex */
    public interface a {

        /* compiled from: DynamicFeatureManager.kt */
        /* renamed from: us.pinguo.foundation.o.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C0395a {
            public static void a(a aVar) {
                s.h(aVar, "this");
            }
        }

        void a();

        void b();

        void c();

        void d();

        void e();

        void f(int i2);

        void g();
    }

    static {
        ApplicationInfo applicationInfo;
        com.google.android.play.core.splitinstall.a a2 = com.google.android.play.core.splitinstall.b.a(e.b());
        s.g(a2, "create(Foundation.getAppContext())");
        b = a2;
        try {
            applicationInfo = e.b().getPackageManager().getApplicationInfo("com.android.vending", 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            c = true;
        }
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Finally extract failed */
    public static final void b(a installListener, String featureName, String googleService, d state) {
        s.h(installListener, "$installListener");
        s.h(featureName, "$featureName");
        s.h(googleService, "$googleService");
        s.h(state, "state");
        if (f11038d != state.l()) {
            f11038d = state.l();
        }
        int m = state.m();
        if (m == 0) {
            installListener.b();
            f11039e = null;
            h.a.D(featureName, googleService, "install_feature_unknown");
        } else if (m == 2) {
            int d2 = (int) ((((float) state.d()) / ((float) state.n())) * 100.0f);
            installListener.f(d2);
            us.pinguo.common.log.a.k(featureName + " download progress:" + d2 + '%', new Object[0]);
        } else if (m != 4) {
            try {
                if (m != 5) {
                    if (m == 6) {
                        installListener.g();
                        f11039e = null;
                        h.a.D(featureName, googleService, "install_feature_failed");
                        return;
                    } else if (m != 7) {
                        return;
                    } else {
                        installListener.d();
                        f11039e = null;
                        h.a.D(featureName, googleService, "install_feature_canceled");
                        return;
                    }
                }
                try {
                    installListener.a();
                    h.a.D(featureName, googleService, "install_feature_success");
                } catch (Exception e2) {
                    installListener.g();
                    h.a.D(featureName, googleService, "install_feature_error");
                    CrashReport.postCatchedException(new RuntimeException("load dynamic feature " + featureName + " failed", e2));
                    e2.printStackTrace();
                }
                f11039e = null;
            } catch (Throwable th) {
                f11039e = null;
                throw th;
            }
        } else {
            f11038d = 0;
            installListener.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String googleService, String featureName, a installListener, Exception exc) {
        String simpleName;
        s.h(googleService, "$googleService");
        s.h(featureName, "$featureName");
        s.h(installListener, "$installListener");
        f11039e = null;
        if (exc instanceof SplitInstallException) {
            simpleName = s.q("_", Integer.valueOf(((SplitInstallException) exc).getErrorCode()));
        } else {
            simpleName = exc.getClass().getSimpleName();
        }
        h.a.D(featureName, s.q(googleService, simpleName), "install_feature_task_error");
        CrashReport.postCatchedException(new RuntimeException("load dynamic feature " + featureName + " failed", exc));
        installListener.g();
    }

    public final void a(final String featureName, final a installListener) {
        s.h(featureName, "featureName");
        s.h(installListener, "installListener");
        Context b2 = e.b();
        if (!Conditions.d() && !Conditions.c()) {
            installListener.a();
            f11039e = null;
        } else if (!q.e(b2)) {
            k0 k0Var = k0.a;
            String string = b2.getString(R.string.network_error);
            s.g(string, "context.getString(R.string.network_error)");
            k0Var.b(string);
            installListener.g();
        } else {
            boolean z = c;
            final String str = z ? "has_google_service" : "no_google_service";
            if (z) {
                com.google.android.play.core.splitinstall.a aVar = b;
                if (!aVar.b().contains(featureName)) {
                    if (f11039e == null) {
                        f11039e = featureName;
                        installListener.c();
                        h.a.D(featureName, str, "download_feature_start");
                        aVar.c(new com.google.android.play.core.splitinstall.e() { // from class: us.pinguo.foundation.o.a
                            @Override // d.c.a.d.a.a.a
                            public final void onStateUpdate(d dVar) {
                                c.b(c.a.this, featureName, str, dVar);
                            }
                        });
                        try {
                            c.a c2 = com.google.android.play.core.splitinstall.c.c();
                            c2.b(featureName);
                            aVar.a(c2.d()).b(new com.google.android.play.core.tasks.b() { // from class: us.pinguo.foundation.o.b
                                @Override // com.google.android.play.core.tasks.b
                                public final void onFailure(Exception exc) {
                                    c.c(str, featureName, installListener, exc);
                                }
                            });
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            installListener.g();
                            f11039e = null;
                            return;
                        }
                    }
                    k0 k0Var2 = k0.a;
                    String string2 = b2.getString(R.string.downloading_other_module_please_wait);
                    s.g(string2, "context.getString(R.stri…other_module_please_wait)");
                    k0Var2.b(string2);
                    installListener.g();
                    return;
                }
                installListener.a();
                f11039e = null;
                return;
            }
            installListener.g();
            f11039e = null;
            k0 k0Var3 = k0.a;
            String string3 = b2.getString(R.string.please_redownload_from_play_store);
            s.g(string3, "context.getString(R.stri…download_from_play_store)");
            k0Var3.b(string3);
        }
    }
}
