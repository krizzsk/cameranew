package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class c {
    public static int a = 0;
    public static boolean b = false;
    public static int c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f7872d = true;

    /* renamed from: e  reason: collision with root package name */
    public static int f7873e = 20480;

    /* renamed from: f  reason: collision with root package name */
    public static int f7874f = 20480;

    /* renamed from: g  reason: collision with root package name */
    public static long f7875g = 604800000;

    /* renamed from: h  reason: collision with root package name */
    public static String f7876h = null;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f7877i = false;

    /* renamed from: j  reason: collision with root package name */
    public static String f7878j = null;

    /* renamed from: k  reason: collision with root package name */
    public static int f7879k = 5000;

    /* renamed from: l  reason: collision with root package name */
    public static boolean f7880l = true;
    public static boolean m = false;
    public static String n;
    public static String o;
    private static c r;
    public final com.tencent.bugly.crashreport.crash.b p;
    private final Context q;
    private final e s;
    private final NativeCrashHandler t;
    private com.tencent.bugly.crashreport.common.strategy.a u;
    private w v;
    private final com.tencent.bugly.crashreport.crash.anr.b w;
    private Boolean x;
    private int y = 31;
    private boolean z = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public final class a implements Runnable {
        private /* synthetic */ boolean a;
        private /* synthetic */ Thread b;
        private /* synthetic */ Throwable c;

        /* renamed from: d  reason: collision with root package name */
        private /* synthetic */ String f7881d;

        /* renamed from: e  reason: collision with root package name */
        private /* synthetic */ byte[] f7882e;

        /* renamed from: f  reason: collision with root package name */
        private /* synthetic */ boolean f7883f;

        a(boolean z, Thread thread, Throwable th, String str, byte[] bArr, boolean z2) {
            this.a = z;
            this.b = thread;
            this.c = th;
            this.f7881d = str;
            this.f7882e = bArr;
            this.f7883f = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                x.c("post a throwable %b", Boolean.valueOf(this.a));
                c.this.s.a(this.b, this.c, false, this.f7881d, this.f7882e);
                if (this.f7883f) {
                    x.a("clear user datas", new Object[0]);
                    com.tencent.bugly.crashreport.common.info.a.a(c.this.q).u();
                }
            } catch (Throwable th) {
                if (!x.b(th)) {
                    th.printStackTrace();
                }
                x.e("java catch error: %s", this.c.toString());
            }
        }
    }

    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    final class b extends Thread {
        b() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            ArrayList arrayList;
            if (z.a(c.this.q, "local_crash_lock", 10000L)) {
                List<CrashDetailBean> a = c.this.p.a();
                if (a != null && a.size() > 0) {
                    x.c("Size of crash list: %s", Integer.valueOf(a.size()));
                    int size = a.size();
                    if (size > 20) {
                        ArrayList arrayList2 = new ArrayList();
                        Collections.sort(a);
                        for (int i2 = 0; i2 < 20; i2++) {
                            arrayList2.add(a.get((size - 1) - i2));
                        }
                        arrayList = arrayList2;
                    } else {
                        arrayList = a;
                    }
                    c.this.p.a(arrayList, 0L, false, false, false);
                }
                z.b(c.this.q, "local_crash_lock");
            }
        }
    }

    private c(int i2, Context context, w wVar, boolean z, BuglyStrategy.a aVar, o oVar, String str) {
        a = i2;
        Context a2 = z.a(context);
        this.q = a2;
        this.u = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.v = wVar;
        u a3 = u.a();
        p a4 = p.a();
        com.tencent.bugly.crashreport.crash.b bVar = new com.tencent.bugly.crashreport.crash.b(i2, a2, a3, a4, this.u, aVar, oVar);
        this.p = bVar;
        com.tencent.bugly.crashreport.common.info.a a5 = com.tencent.bugly.crashreport.common.info.a.a(a2);
        this.s = new e(a2, bVar, this.u, a5);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance(a2, a5, bVar, this.u, wVar, z, str);
        this.t = nativeCrashHandler;
        a5.E = nativeCrashHandler;
        this.w = com.tencent.bugly.crashreport.crash.anr.b.a(a2, this.u, a5, wVar, a4, bVar, aVar);
    }

    public final synchronized void c() {
        this.s.a();
        this.t.setUserOpened(true);
        this.w.a(true);
    }

    public final synchronized void d() {
        this.s.b();
        this.t.setUserOpened(false);
        this.w.a(false);
    }

    public final void e() {
        this.s.b();
    }

    public final void f() {
        this.s.a();
    }

    public final void g() {
        this.t.setUserOpened(false);
    }

    public final void h() {
        this.t.setUserOpened(true);
    }

    public final void i() {
        this.w.a(true);
    }

    public final void j() {
        this.w.a(false);
    }

    public final void k() {
        this.t.enableCatchAnrTrace();
    }

    public final synchronized void l() {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 < 30) {
                try {
                    x.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i3));
                    z.b(5000L);
                    i2 = i3;
                } catch (Throwable th) {
                    if (x.a(th)) {
                        return;
                    }
                    th.printStackTrace();
                    return;
                }
            }
        }
    }

    public final boolean m() {
        return this.w.a();
    }

    public final void n() {
        this.t.checkUploadRecordCrash();
    }

    public final void o() {
        if (com.tencent.bugly.crashreport.common.info.a.b().f7817d.equals(AppInfo.a(this.q))) {
            this.t.removeEmptyNativeRecordFiles();
        }
    }

    public final boolean p() {
        return this.z;
    }

    public final boolean q() {
        return (this.y & 16) > 0;
    }

    public final boolean r() {
        return (this.y & 8) > 0;
    }

    public final boolean s() {
        return (this.y & 4) > 0;
    }

    public final boolean t() {
        return (this.y & 2) > 0;
    }

    public final boolean u() {
        return (this.y & 1) > 0;
    }

    public static synchronized c a(int i2, Context context, boolean z, BuglyStrategy.a aVar, o oVar, String str) {
        c cVar;
        synchronized (c.class) {
            if (r == null) {
                r = new c(1004, context, w.a(), z, aVar, null, null);
            }
            cVar = r;
        }
        return cVar;
    }

    public final boolean b() {
        Boolean bool = this.x;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = com.tencent.bugly.crashreport.common.info.a.b().f7817d;
        List<r> a2 = p.a().a(1);
        ArrayList arrayList = new ArrayList();
        if (a2 != null && a2.size() > 0) {
            for (r rVar : a2) {
                if (str.equals(rVar.c)) {
                    this.x = Boolean.TRUE;
                    arrayList.add(rVar);
                }
            }
            if (arrayList.size() > 0) {
                p.a().a(arrayList);
            }
            return true;
        }
        this.x = Boolean.FALSE;
        return false;
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            cVar = r;
        }
        return cVar;
    }

    public final void a(StrategyBean strategyBean) {
        this.s.a(strategyBean);
        this.t.onStrategyChanged(strategyBean);
        this.w.c();
        w.a().a(new b(), 3000L);
    }

    public final synchronized void a(boolean z, boolean z2, boolean z3) {
        this.t.testNativeCrash(z, z2, z3);
    }

    public final void a(Thread thread, Throwable th, boolean z, String str, byte[] bArr, boolean z2) {
        this.v.a(new a(false, thread, th, null, null, z2));
    }

    public final void a(CrashDetailBean crashDetailBean) {
        this.p.e(crashDetailBean);
    }

    public final void a(long j2) {
        w.a().a(new b(), j2);
    }

    public final void a(int i2) {
        this.y = i2;
    }

    public final void a(boolean z) {
        this.z = z;
    }
}
