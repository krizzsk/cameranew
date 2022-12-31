package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.LinkedHashMap;
import java.util.Map;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class d {
    private static d a;
    private com.tencent.bugly.crashreport.common.strategy.a b;
    private com.tencent.bugly.crashreport.common.info.a c;

    /* renamed from: d  reason: collision with root package name */
    private com.tencent.bugly.crashreport.crash.b f7885d;

    /* renamed from: e  reason: collision with root package name */
    private Context f7886e;

    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.a(d.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        private /* synthetic */ Thread a;
        private /* synthetic */ int b;
        private /* synthetic */ String c;

        /* renamed from: d  reason: collision with root package name */
        private /* synthetic */ String f7887d;

        /* renamed from: e  reason: collision with root package name */
        private /* synthetic */ String f7888e;

        /* renamed from: f  reason: collision with root package name */
        private /* synthetic */ Map f7889f;

        b(Thread thread, int i2, String str, String str2, String str3, Map map) {
            this.a = thread;
            this.b = i2;
            this.c = str;
            this.f7887d = str2;
            this.f7888e = str3;
            this.f7889f = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (d.a != null) {
                    d.a(d.a, this.a, this.b, this.c, this.f7887d, this.f7888e, this.f7889f);
                } else {
                    x.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                }
            } catch (Throwable th) {
                if (!x.b(th)) {
                    th.printStackTrace();
                }
                x.e("[ExtraCrashManager] Crash error %s %s %s", this.c, this.f7887d, this.f7888e);
            }
        }
    }

    private d(Context context) {
        c a2 = c.a();
        if (a2 == null) {
            return;
        }
        this.b = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.c = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.f7885d = a2.p;
        this.f7886e = context;
        w.a().a(new a());
    }

    static /* synthetic */ void a(d dVar) {
        x.c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.agent.GameAgent");
            dVar.c.getClass();
            z.a(cls, "sdkPackageName", "com.tencent.bugly", null);
            x.c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            x.a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    static /* synthetic */ void a(d dVar, Thread thread, int i2, String str, String str2, String str3, Map map) {
        String str4;
        String str5;
        String str6;
        Thread currentThread = thread == null ? Thread.currentThread() : thread;
        if (i2 == 4) {
            str4 = CrashlyticsReport.DEVELOPMENT_PLATFORM_UNITY;
        } else if (i2 == 5 || i2 == 6) {
            str4 = "Cocos";
        } else if (i2 != 8) {
            x.d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i2));
            return;
        } else {
            str4 = "H5";
        }
        x.e("[ExtraCrashManager] %s Crash Happen", str4);
        try {
            if (!dVar.b.b()) {
                x.d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean c = dVar.b.c();
            if (!c.f7827e && dVar.b.b()) {
                x.e("[ExtraCrashManager] Crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                String a2 = z.a();
                String str7 = dVar.c.f7817d;
                String name = currentThread.getName();
                com.tencent.bugly.crashreport.crash.b.a(str4, a2, str7, name, str + "\n" + str2 + "\n" + str3, null);
                x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i2 == 5 || i2 == 6) {
                if (!c.f7832j) {
                    x.e("[ExtraCrashManager] %s report is disabled.", str4);
                    x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            } else if (i2 == 8 && !c.f7833k) {
                x.e("[ExtraCrashManager] %s report is disabled.", str4);
                x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            int i3 = i2 != 8 ? i2 : 5;
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.i();
            crashDetailBean.F = dVar.c.k();
            crashDetailBean.G = dVar.c.j();
            crashDetailBean.H = dVar.c.l();
            crashDetailBean.w = z.a(dVar.f7886e, c.f7873e, (String) null);
            crashDetailBean.b = i3;
            crashDetailBean.f7843e = dVar.c.h();
            com.tencent.bugly.crashreport.common.info.a aVar = dVar.c;
            crashDetailBean.f7844f = aVar.f7824k;
            crashDetailBean.f7845g = aVar.q();
            crashDetailBean.m = dVar.c.g();
            crashDetailBean.n = str;
            crashDetailBean.o = str2;
            str5 = "";
            if (str3 != null) {
                String[] split = str3.split("\n");
                str5 = split.length > 0 ? split[0] : "";
                str6 = str3;
            } else {
                str6 = "";
            }
            crashDetailBean.p = str5;
            crashDetailBean.q = str6;
            crashDetailBean.r = System.currentTimeMillis();
            crashDetailBean.u = z.a(crashDetailBean.q.getBytes());
            crashDetailBean.z = z.a(c.f7874f, false);
            crashDetailBean.A = dVar.c.f7817d;
            crashDetailBean.B = currentThread.getName() + "(" + currentThread.getId() + ")";
            crashDetailBean.I = dVar.c.s();
            crashDetailBean.f7846h = dVar.c.p();
            com.tencent.bugly.crashreport.common.info.a aVar2 = dVar.c;
            crashDetailBean.M = aVar2.a;
            crashDetailBean.N = aVar2.a();
            if (!c.a().p()) {
                dVar.f7885d.d(crashDetailBean);
            }
            crashDetailBean.Q = dVar.c.z();
            crashDetailBean.R = dVar.c.A();
            crashDetailBean.S = dVar.c.t();
            crashDetailBean.T = dVar.c.y();
            crashDetailBean.y = y.a();
            if (crashDetailBean.O == null) {
                crashDetailBean.O = new LinkedHashMap();
            }
            if (map != null) {
                crashDetailBean.O.putAll(map);
            }
            String a3 = z.a();
            String str8 = dVar.c.f7817d;
            String name2 = currentThread.getName();
            com.tencent.bugly.crashreport.crash.b.a(str4, a3, str8, name2, str + "\n" + str2 + "\n" + str3, crashDetailBean);
            if (!dVar.f7885d.a(crashDetailBean)) {
                dVar.f7885d.a(crashDetailBean, 3000L, false);
            }
            x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                x.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }

    public static d a(Context context) {
        if (a == null) {
            a = new d(context);
        }
        return a;
    }

    public static void a(Thread thread, int i2, String str, String str2, String str3, Map<String, String> map) {
        w.a().a(new b(thread, i2, str, str2, str3, map));
    }
}
