package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.lang.Thread;
import java.util.HashMap;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class e implements Thread.UncaughtExceptionHandler {

    /* renamed from: h  reason: collision with root package name */
    private static String f7890h;

    /* renamed from: i  reason: collision with root package name */
    private static final Object f7891i = new Object();
    private Context a;
    private b b;
    private com.tencent.bugly.crashreport.common.strategy.a c;

    /* renamed from: d  reason: collision with root package name */
    private com.tencent.bugly.crashreport.common.info.a f7892d;

    /* renamed from: e  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f7893e;

    /* renamed from: f  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f7894f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7895g = false;

    /* renamed from: j  reason: collision with root package name */
    private int f7896j;

    public e(Context context, b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar, com.tencent.bugly.crashreport.common.info.a aVar2) {
        this.a = context;
        this.b = bVar;
        this.c = aVar;
        this.f7892d = aVar2;
    }

    public final synchronized void a() {
        if (this.f7896j >= 10) {
            x.a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f7895g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (getClass().getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                x.a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f7894f = defaultUncaughtExceptionHandler;
                this.f7893e = defaultUncaughtExceptionHandler;
            } else {
                x.a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f7893e = defaultUncaughtExceptionHandler;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f7896j++;
        x.a("registered java monitor: %s", toString());
    }

    public final synchronized void b() {
        this.f7895g = false;
        x.a("close java monitor!", new Object[0]);
        if (Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains("bugly")) {
            x.a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f7893e);
            this.f7896j--;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (f7891i) {
            a(thread, th, true, null, null);
        }
    }

    private CrashDetailBean b(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        String a;
        if (th == null) {
            x.d("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        boolean m = c.a().m();
        String str2 = (m && z) ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        if (m && z) {
            x.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.g();
        crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
        crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.i();
        crashDetailBean.F = this.f7892d.k();
        crashDetailBean.G = this.f7892d.j();
        crashDetailBean.H = this.f7892d.l();
        crashDetailBean.w = z.a(this.a, c.f7873e, (String) null);
        byte[] a2 = y.a();
        crashDetailBean.y = a2;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(a2 == null ? 0 : a2.length);
        x.a("user log size:%d", objArr);
        crashDetailBean.b = z ? 0 : 2;
        crashDetailBean.f7843e = this.f7892d.h();
        com.tencent.bugly.crashreport.common.info.a aVar = this.f7892d;
        crashDetailBean.f7844f = aVar.f7824k;
        crashDetailBean.f7845g = aVar.q();
        crashDetailBean.m = this.f7892d.g();
        String name = th.getClass().getName();
        String b = b(th, 1000);
        if (b == null) {
            b = "";
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = Boolean.valueOf(th.getCause() != null);
        x.e("stack frame :%d, has cause %b", objArr2);
        String stackTraceElement = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable th2 = th;
        while (th2 != null && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 != null && th2 != th) {
            crashDetailBean.n = th2.getClass().getName();
            String b2 = b(th2, 1000);
            crashDetailBean.o = b2;
            if (b2 == null) {
                crashDetailBean.o = "";
            }
            if (th2.getStackTrace().length > 0) {
                crashDetailBean.p = th2.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(":");
            sb.append(b);
            sb.append("\n");
            sb.append(stackTraceElement);
            sb.append("\n......");
            sb.append("\nCaused by:\n");
            sb.append(crashDetailBean.n);
            sb.append(":");
            sb.append(crashDetailBean.o);
            sb.append("\n");
            a = a(th2, c.f7874f);
            sb.append(a);
            crashDetailBean.q = sb.toString();
        } else {
            crashDetailBean.n = name;
            String str3 = b + str2;
            crashDetailBean.o = str3;
            if (str3 == null) {
                crashDetailBean.o = "";
            }
            crashDetailBean.p = stackTraceElement;
            a = a(th, c.f7874f);
            crashDetailBean.q = a;
        }
        crashDetailBean.r = System.currentTimeMillis();
        crashDetailBean.u = z.a(crashDetailBean.q.getBytes());
        try {
            crashDetailBean.z = z.a(c.f7874f, false);
            crashDetailBean.A = this.f7892d.f7817d;
            String str4 = thread.getName() + "(" + thread.getId() + ")";
            crashDetailBean.B = str4;
            crashDetailBean.z.put(str4, a);
            crashDetailBean.I = this.f7892d.s();
            crashDetailBean.f7846h = this.f7892d.p();
            crashDetailBean.f7847i = this.f7892d.B();
            com.tencent.bugly.crashreport.common.info.a aVar2 = this.f7892d;
            crashDetailBean.M = aVar2.a;
            crashDetailBean.N = aVar2.a();
            if (z) {
                this.b.d(crashDetailBean);
            } else {
                boolean z2 = str != null && str.length() > 0;
                boolean z3 = bArr != null && bArr.length > 0;
                if (z2) {
                    HashMap hashMap = new HashMap(1);
                    crashDetailBean.O = hashMap;
                    hashMap.put("UserData", str);
                }
                if (z3) {
                    crashDetailBean.U = bArr;
                }
            }
            crashDetailBean.Q = this.f7892d.z();
            crashDetailBean.R = this.f7892d.A();
            crashDetailBean.S = this.f7892d.t();
            crashDetailBean.T = this.f7892d.y();
        } catch (Throwable th3) {
            x.e("handle crash error %s", th3.toString());
        }
        return crashDetailBean;
    }

    private static boolean a(Thread thread) {
        synchronized (f7891i) {
            if (f7890h == null || !thread.getName().equals(f7890h)) {
                f7890h = thread.getName();
                return false;
            }
            return true;
        }
    }

    public final void a(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        if (z) {
            x.e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (a(thread)) {
                x.a("this class has handled this exception", new Object[0]);
                if (this.f7894f != null) {
                    x.a("call system handler", new Object[0]);
                    this.f7894f.uncaughtException(thread, th);
                } else {
                    x.e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                }
            }
        } else {
            x.e("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.f7895g) {
                x.c("Java crash handler is disable. Just return.", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f7893e;
                    if (uncaughtExceptionHandler != null && a(uncaughtExceptionHandler)) {
                        x.e("sys default last handle start!", new Object[0]);
                        this.f7893e.uncaughtException(thread, th);
                        x.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f7894f != null) {
                        x.e("system handle start!", new Object[0]);
                        this.f7894f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        x.e("crashreport last handle start!", new Object[0]);
                        x.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!this.c.b()) {
                x.d("no remote but still store!", new Object[0]);
            }
            if (!this.c.c().f7827e && this.c.b()) {
                x.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                b.a(z ? "JAVA_CRASH" : "JAVA_CATCH", z.a(), this.f7892d.f7817d, thread.getName(), z.a(th), null);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f7893e;
                    if (uncaughtExceptionHandler2 != null && a(uncaughtExceptionHandler2)) {
                        x.e("sys default last handle start!", new Object[0]);
                        this.f7893e.uncaughtException(thread, th);
                        x.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f7894f != null) {
                        x.e("system handle start!", new Object[0]);
                        this.f7894f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        x.e("crashreport last handle start!", new Object[0]);
                        x.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            CrashDetailBean b = b(thread, th, z, str, bArr);
            if (b == null) {
                x.e("pkg crash datas fail!", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f7893e;
                    if (uncaughtExceptionHandler3 != null && a(uncaughtExceptionHandler3)) {
                        x.e("sys default last handle start!", new Object[0]);
                        this.f7893e.uncaughtException(thread, th);
                        x.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f7894f != null) {
                        x.e("system handle start!", new Object[0]);
                        this.f7894f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        x.e("crashreport last handle start!", new Object[0]);
                        x.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            b.a(z ? "JAVA_CRASH" : "JAVA_CATCH", z.a(), this.f7892d.f7817d, thread.getName(), z.a(th), b);
            if (!this.b.a(b)) {
                this.b.a(b, 3000L, z);
            }
            if (z) {
                this.b.c(b);
            }
            if (z) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f7893e;
                if (uncaughtExceptionHandler4 != null && a(uncaughtExceptionHandler4)) {
                    x.e("sys default last handle start!", new Object[0]);
                    this.f7893e.uncaughtException(thread, th);
                    x.e("sys default last handle end!", new Object[0]);
                } else if (this.f7894f != null) {
                    x.e("system handle start!", new Object[0]);
                    this.f7894f.uncaughtException(thread, th);
                    x.e("system handle end!", new Object[0]);
                } else {
                    x.e("crashreport last handle start!", new Object[0]);
                    x.e("current process die", new Object[0]);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                    x.e("crashreport last handle end!", new Object[0]);
                }
            }
        } catch (Throwable th2) {
            try {
                if (!x.a(th2)) {
                    th2.printStackTrace();
                }
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f7893e;
                    if (uncaughtExceptionHandler5 != null && a(uncaughtExceptionHandler5)) {
                        x.e("sys default last handle start!", new Object[0]);
                        this.f7893e.uncaughtException(thread, th);
                        x.e("sys default last handle end!", new Object[0]);
                    } else if (this.f7894f != null) {
                        x.e("system handle start!", new Object[0]);
                        this.f7894f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[0]);
                    } else {
                        x.e("crashreport last handle start!", new Object[0]);
                        x.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e("crashreport last handle end!", new Object[0]);
                    }
                }
            } catch (Throwable th3) {
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.f7893e;
                    if (uncaughtExceptionHandler6 != null && a(uncaughtExceptionHandler6)) {
                        x.e("sys default last handle start!", new Object[0]);
                        this.f7893e.uncaughtException(thread, th);
                        x.e("sys default last handle end!", new Object[0]);
                    } else if (this.f7894f != null) {
                        x.e("system handle start!", new Object[0]);
                        this.f7894f.uncaughtException(thread, th);
                        x.e("system handle end!", new Object[0]);
                    } else {
                        x.e("crashreport last handle start!", new Object[0]);
                        x.e("current process die", new Object[0]);
                        Process.killProcess(Process.myPid());
                        System.exit(1);
                        x.e("crashreport last handle end!", new Object[0]);
                    }
                }
                throw th3;
            }
        }
    }

    private static String b(Throwable th, int i2) {
        if (th.getMessage() == null) {
            return "";
        }
        if (th.getMessage().length() <= 1000) {
            return th.getMessage();
        }
        return th.getMessage().substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
    }

    private static boolean a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        StackTraceElement[] stackTrace;
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    public final synchronized void a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z = strategyBean.f7827e;
            if (z != this.f7895g) {
                x.a("java changed to %b", Boolean.valueOf(z));
                if (strategyBean.f7827e) {
                    a();
                    return;
                }
                b();
            }
        }
    }

    private static String a(Throwable th, int i2) {
        StackTraceElement[] stackTrace;
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i2 > 0 && sb.length() >= i2) {
                        sb.append("\n[Stack over limit size :" + i2 + " , has been cutted !]");
                        return sb.toString();
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
        } catch (Throwable th2) {
            x.e("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }
}
