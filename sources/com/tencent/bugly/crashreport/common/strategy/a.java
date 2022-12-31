package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import com.tapjoy.TapjoyConstants;
import com.tencent.bugly.crashreport.biz.b;
import com.tencent.bugly.proguard.ao;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.List;
import java.util.Map;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class a {
    public static int a = 1000;
    private static a b;

    /* renamed from: h  reason: collision with root package name */
    private static String f7835h;
    private final List<com.tencent.bugly.a> c;

    /* renamed from: d  reason: collision with root package name */
    private final w f7836d;

    /* renamed from: e  reason: collision with root package name */
    private final StrategyBean f7837e;

    /* renamed from: f  reason: collision with root package name */
    private StrategyBean f7838f = null;

    /* renamed from: g  reason: collision with root package name */
    private Context f7839g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.common.strategy.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public final class C0263a extends Thread {
        C0263a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                Map<String, byte[]> a = p.a().a(a.a, (o) null, true);
                if (a != null) {
                    byte[] bArr = a.get(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX);
                    byte[] bArr2 = a.get("gateway");
                    if (bArr != null) {
                        com.tencent.bugly.crashreport.common.info.a.a(a.this.f7839g).e(new String(bArr));
                    }
                    if (bArr2 != null) {
                        com.tencent.bugly.crashreport.common.info.a.a(a.this.f7839g).d(new String(bArr2));
                    }
                }
                a.this.f7838f = a.d();
                if (a.this.f7838f != null) {
                    if (z.a(a.f7835h) || !z.c(a.f7835h)) {
                        a.this.f7838f.p = StrategyBean.a;
                        a.this.f7838f.q = StrategyBean.b;
                    } else {
                        a.this.f7838f.p = a.f7835h;
                        a.this.f7838f.q = a.f7835h;
                    }
                }
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
            a aVar = a.this;
            aVar.a(aVar.f7838f, false);
        }
    }

    private a(Context context, List<com.tencent.bugly.a> list) {
        String str;
        this.f7839g = context;
        if (com.tencent.bugly.crashreport.common.info.a.a(context) != null) {
            String str2 = com.tencent.bugly.crashreport.common.info.a.a(context).z;
            if ("oversea".equals(str2)) {
                str = "https://astat.bugly.qcloud.com/rqd/async";
            } else {
                str = "na_https".equals(str2) ? "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async" : "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
            }
            StrategyBean.a = str;
            StrategyBean.b = str;
        }
        this.f7837e = new StrategyBean();
        this.c = list;
        this.f7836d = w.a();
    }

    public static StrategyBean d() {
        byte[] bArr;
        List<r> a2 = p.a().a(2);
        if (a2 == null || a2.size() <= 0 || (bArr = a2.get(0).f8006g) == null) {
            return null;
        }
        return (StrategyBean) z.a(bArr, StrategyBean.CREATOR);
    }

    public final StrategyBean c() {
        StrategyBean strategyBean = this.f7838f;
        if (strategyBean != null) {
            if (!z.c(strategyBean.p)) {
                this.f7838f.p = StrategyBean.a;
            }
            if (!z.c(this.f7838f.q)) {
                this.f7838f.q = StrategyBean.b;
            }
            return this.f7838f;
        }
        if (!z.a(f7835h) && z.c(f7835h)) {
            StrategyBean strategyBean2 = this.f7837e;
            String str = f7835h;
            strategyBean2.p = str;
            strategyBean2.q = str;
        }
        return this.f7837e;
    }

    public final synchronized boolean b() {
        return this.f7838f != null;
    }

    public static synchronized a a(Context context, List<com.tencent.bugly.a> list) {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a(context, list);
            }
            aVar = b;
        }
        return aVar;
    }

    public final void a(long j2) {
        this.f7836d.a(new C0263a(), j2);
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            aVar = b;
        }
        return aVar;
    }

    protected final void a(StrategyBean strategyBean, boolean z) {
        x.c("[Strategy] Notify %s", b.class.getName());
        b.a(strategyBean, z);
        for (com.tencent.bugly.a aVar : this.c) {
            try {
                x.c("[Strategy] Notify %s", aVar.getClass().getName());
                aVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(String str) {
        if (!z.a(str) && z.c(str)) {
            f7835h = str;
        } else {
            x.d("URL user set is invalid.", new Object[0]);
        }
    }

    public final void a(ap apVar) {
        if (apVar == null) {
            return;
        }
        StrategyBean strategyBean = this.f7838f;
        if (strategyBean == null || apVar.f7956h != strategyBean.n) {
            StrategyBean strategyBean2 = new StrategyBean();
            strategyBean2.f7827e = apVar.a;
            strategyBean2.f7829g = apVar.c;
            strategyBean2.f7828f = apVar.b;
            if (z.a(f7835h) || !z.c(f7835h)) {
                if (z.c(apVar.f7952d)) {
                    x.c("[Strategy] Upload url changes to %s", apVar.f7952d);
                    strategyBean2.p = apVar.f7952d;
                }
                if (z.c(apVar.f7953e)) {
                    x.c("[Strategy] Exception upload url changes to %s", apVar.f7953e);
                    strategyBean2.q = apVar.f7953e;
                }
            }
            ao aoVar = apVar.f7954f;
            if (aoVar != null && !z.a(aoVar.a)) {
                strategyBean2.r = apVar.f7954f.a;
            }
            long j2 = apVar.f7956h;
            if (j2 != 0) {
                strategyBean2.n = j2;
            }
            Map<String, String> map = apVar.f7955g;
            if (map != null && map.size() > 0) {
                Map<String, String> map2 = apVar.f7955g;
                strategyBean2.s = map2;
                String str = map2.get("B11");
                if (str != null && str.equals("1")) {
                    strategyBean2.f7830h = true;
                } else {
                    strategyBean2.f7830h = false;
                }
                String str2 = apVar.f7955g.get("B3");
                if (str2 != null) {
                    strategyBean2.v = Long.valueOf(str2).longValue();
                }
                int i2 = apVar.f7957i;
                strategyBean2.o = i2;
                strategyBean2.u = i2;
                String str3 = apVar.f7955g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > 0) {
                            strategyBean2.t = parseInt;
                        }
                    } catch (Exception e2) {
                        if (!x.a(e2)) {
                            e2.printStackTrace();
                        }
                    }
                }
                String str4 = apVar.f7955g.get("B25");
                if (str4 != null && str4.equals("1")) {
                    strategyBean2.f7832j = true;
                } else {
                    strategyBean2.f7832j = false;
                }
            }
            x.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f7827e), Boolean.valueOf(strategyBean2.f7829g), Boolean.valueOf(strategyBean2.f7828f), Boolean.valueOf(strategyBean2.f7830h), Boolean.valueOf(strategyBean2.f7831i), Boolean.valueOf(strategyBean2.f7834l), Boolean.valueOf(strategyBean2.m), Long.valueOf(strategyBean2.o), Boolean.valueOf(strategyBean2.f7832j), Long.valueOf(strategyBean2.n));
            this.f7838f = strategyBean2;
            if (!z.c(apVar.f7952d)) {
                x.c("[Strategy] download url is null", new Object[0]);
                this.f7838f.p = "";
            }
            if (!z.c(apVar.f7953e)) {
                x.c("[Strategy] download crashurl is null", new Object[0]);
                this.f7838f.q = "";
            }
            p.a().b(2);
            r rVar = new r();
            rVar.b = 2;
            rVar.a = strategyBean2.c;
            rVar.f8004e = strategyBean2.f7826d;
            rVar.f8006g = z.a(strategyBean2);
            p.a().a(rVar);
            a(strategyBean2, true);
        }
    }
}
