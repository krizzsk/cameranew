package com.huawei.hianalytics.v2.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import androidx.work.WorkRequest;
import com.coremedia.iso.boxes.UserBox;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes2.dex */
public final class h implements m {
    private static volatile boolean a = false;
    @SuppressLint({"StaticFieldLeak"})
    private static h b = new h();
    private static Context c = null;

    /* renamed from: d  reason: collision with root package name */
    private static com.huawei.hianalytics.a.c f5141d;

    public static m a() {
        return f();
    }

    public static void a(int i2, String str, String str2) {
        com.huawei.hianalytics.a.c cVar = f5141d;
        if (cVar == null) {
            com.huawei.hianalytics.b.b.c("AnalyticsImpl", "checkCollectURL() SDK is not init!");
            return;
        }
        String str3 = i2 == 1 ? "maint" : "oper";
        String str4 = cVar.y().get(str3);
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str2)) {
            com.huawei.hianalytics.b.b.c("AnalyticsImpl", "The URLs are different,URL will set to empty ,SDK stop to collect and report this kind data!");
            f5141d.a(str3, str, "");
            return;
        }
        String trim = str4.trim();
        if (trim.endsWith("/") || trim.endsWith("\\")) {
            trim = trim.substring(0, trim.length() - 1);
        }
        String trim2 = str2.trim();
        if (trim2.endsWith("/") || trim2.endsWith("\\")) {
            trim2 = trim2.substring(0, trim2.length() - 1);
        }
        if (trim.compareToIgnoreCase(trim2) != 0) {
            com.huawei.hianalytics.b.b.c("AnalyticsImpl", "The URLs are different,URL will set to empty ,SDK stop to collect and report this kind data!");
            f5141d.a(str3, str, "");
        }
    }

    private static void a(Context context, com.huawei.hianalytics.a.b bVar) {
        c = context.getApplicationContext();
        f5141d = new com.huawei.hianalytics.a.c();
        a(bVar);
        i.a(context, f5141d);
    }

    public static synchronized void a(com.huawei.hianalytics.a.b bVar, Context context) {
        synchronized (h.class) {
            if (!a) {
                com.huawei.hianalytics.b.b.b("HiAnalytics", "HiAnalyticsImpl.init() is execute.");
                if (bVar != null && context != null) {
                    a(context, bVar);
                    a = true;
                }
                com.huawei.hianalytics.b.b.c("AnalyticsImpl", "init() HiAnalyticsConf is null");
            }
        }
    }

    public static synchronized void a(com.huawei.hianalytics.a.b bVar, boolean z) {
        synchronized (h.class) {
            if (a) {
                com.huawei.hianalytics.b.b.b("HiAnalytics", "Builder.refresh(boolean enableCleanData) is execute.");
                if (f5141d == null) {
                    com.huawei.hianalytics.b.b.c("AnalyticsImpl", "refresh() HiAnalyticsConf is null");
                    return;
                }
                if (z) {
                    com.huawei.hianalytics.util.f.a(c);
                }
                a(bVar);
            } else {
                com.huawei.hianalytics.b.b.b("HiAnalytics", "Please execute Builder.create()");
            }
        }
    }

    public static void a(String str) {
        com.huawei.hianalytics.a.c cVar = f5141d;
        if (cVar == null) {
            com.huawei.hianalytics.b.b.c("AnalyticsImpl", "SDK was not init!");
        } else {
            cVar.l(com.huawei.hianalytics.util.g.a(str));
        }
    }

    private static void a(Map<Object, String> map, String str) {
        String str2 = map.get(str);
        if (TextUtils.isEmpty(str2) || !com.huawei.hianalytics.util.g.a(str2, "(https://)[\\w-]+\\.[\\w-]+(\\.hicloud\\.com:)[\\d]{2,5}(\\\\|\\/)?")) {
            com.huawei.hianalytics.b.b.d("AnalyticsImpl", "collectURL Parameter error!");
            map.remove(str);
        }
    }

    public static void a(boolean z) {
        com.huawei.hianalytics.a.c cVar = f5141d;
        if (cVar == null) {
            com.huawei.hianalytics.b.b.c("AnalyticsImpl", "SDK was not init!");
        } else {
            cVar.a(z ? "true" : "false");
        }
    }

    private static boolean a(com.huawei.hianalytics.a.b bVar) {
        f5141d.w();
        com.huawei.hianalytics.util.g.a(f5141d, bVar, c);
        f5141d.b(com.huawei.hianalytics.util.o.b());
        f5141d.e(com.huawei.hianalytics.util.o.a(c));
        f5141d.f(com.huawei.hianalytics.util.o.b(c));
        Pair<String, String> e2 = com.huawei.hianalytics.util.o.e(c);
        f5141d.c((String) e2.first);
        f5141d.d((String) e2.second);
        b(bVar);
        String s = f5141d.s();
        if (TextUtils.isEmpty(s)) {
            f5141d.p(com.huawei.hianalytics.util.e.c(c));
            return true;
        }
        f5141d.p(s);
        return true;
    }

    private static void b(com.huawei.hianalytics.a.b bVar) {
        com.huawei.hianalytics.a.c cVar;
        boolean z;
        HashMap<Object, String> e2 = bVar.e();
        SharedPreferences a2 = com.huawei.hianalytics.util.k.a(c, "global_v2");
        if (a2 != null) {
            String a3 = com.huawei.hianalytics.util.k.a(a2, "upload_url", "");
            if (TextUtils.isEmpty(a3)) {
                cVar = f5141d;
                z = true;
            } else {
                e2.put("preins", a3);
                cVar = f5141d;
                z = false;
            }
            cVar.e(z);
            String a4 = com.huawei.hianalytics.util.k.a(a2, UserBox.TYPE, "");
            if (TextUtils.isEmpty(a4)) {
                String replace = UUID.randomUUID().toString().replace(PGTransHeader.CONNECTOR, "");
                f5141d.q(replace);
                a2.edit().putString(UserBox.TYPE, replace).apply();
            } else {
                f5141d.q(a4);
            }
        }
        a(e2, "oper");
        a(e2, "maint");
        f5141d.x();
        f5141d.a(e2);
    }

    public static void b(String str) {
        com.huawei.hianalytics.a.c cVar = f5141d;
        if (cVar == null) {
            com.huawei.hianalytics.b.b.c("AnalyticsImpl", "SDK was not init!");
        } else {
            cVar.m(com.huawei.hianalytics.util.g.a(str));
        }
    }

    public static synchronized boolean b() {
        boolean z;
        synchronized (h.class) {
            z = a;
        }
        return z;
    }

    public static void e() {
        com.huawei.hianalytics.util.f.a(c);
    }

    private static synchronized h f() {
        h hVar;
        synchronized (h.class) {
            hVar = b;
        }
        return hVar;
    }

    @Override // com.huawei.hianalytics.v2.a.b.m
    public void c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - com.huawei.hianalytics.a.a.a() > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
            com.huawei.hianalytics.b.b.b("AnalyticsImpl", "begin to call onReport!");
            com.huawei.hianalytics.a.a.a(currentTimeMillis);
            i.a();
        }
    }

    @Override // com.huawei.hianalytics.v2.a.b.m
    public com.huawei.hianalytics.a.c d() {
        return f5141d;
    }
}
