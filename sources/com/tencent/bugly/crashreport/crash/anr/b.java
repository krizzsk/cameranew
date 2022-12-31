package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class b implements ac {
    private static b m;
    private final Context c;

    /* renamed from: d  reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f7859d;

    /* renamed from: e  reason: collision with root package name */
    private final w f7860e;

    /* renamed from: f  reason: collision with root package name */
    private String f7861f;

    /* renamed from: g  reason: collision with root package name */
    private final com.tencent.bugly.crashreport.crash.b f7862g;

    /* renamed from: h  reason: collision with root package name */
    private FileObserver f7863h;

    /* renamed from: j  reason: collision with root package name */
    private ab f7865j;

    /* renamed from: k  reason: collision with root package name */
    private int f7866k;
    private AtomicInteger a = new AtomicInteger(0);
    private long b = -1;

    /* renamed from: i  reason: collision with root package name */
    private boolean f7864i = true;

    /* renamed from: l  reason: collision with root package name */
    private ActivityManager.ProcessErrorStateInfo f7867l = new ActivityManager.ProcessErrorStateInfo();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public final class a extends FileObserver {

        /* compiled from: BUGLY */
        /* renamed from: com.tencent.bugly.crashreport.crash.anr.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class RunnableC0264a implements Runnable {
            private /* synthetic */ String a;

            RunnableC0264a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                b.this.a(this.a);
            }
        }

        a(String str, int i2) {
            super(str, 8);
        }

        @Override // android.os.FileObserver
        public final void onEvent(int i2, String str) {
            if (str == null) {
                return;
            }
            String str2 = "/data/anr/" + str;
            x.d("watching file %s", str2);
            if (str2.contains("trace")) {
                b.this.f7860e.a(new RunnableC0264a(str2));
            } else {
                x.d("not anr file %s", str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.crash.anr.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public final class RunnableC0265b implements Runnable {
        RunnableC0265b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public final class d extends FileObserver {
        d(String str, int i2) {
            super(str, 256);
        }

        @Override // android.os.FileObserver
        public final void onEvent(int i2, String str) {
            if (str == null) {
                return;
            }
            x.d("startWatchingPrivateAnrDir %s", str);
            b bVar = b.this;
            if (str.startsWith("bugly_trace_")) {
                if (b.this.f7865j != null) {
                    b.this.f7865j.a(true);
                    return;
                }
                return;
            }
            x.c("trace file not caused by sigquit , ignore ", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public final class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.b();
        }
    }

    private b(Context context, com.tencent.bugly.crashreport.common.strategy.a aVar, com.tencent.bugly.crashreport.common.info.a aVar2, w wVar, com.tencent.bugly.crashreport.crash.b bVar) {
        this.c = z.a(context);
        this.f7861f = context.getDir("bugly", 0).getAbsolutePath();
        this.f7859d = aVar2;
        this.f7860e = wVar;
        this.f7862g = bVar;
    }

    private synchronized void c(boolean z) {
        if (this.f7864i != z) {
            x.a("user change anr %b", Boolean.valueOf(z));
            this.f7864i = z;
        }
    }

    private synchronized void d() {
        if (f()) {
            x.d("start when started!", new Object[0]);
            return;
        }
        a aVar = new a("/data/anr/", 8);
        this.f7863h = aVar;
        aVar.startWatching();
        x.a("start anr monitor!", new Object[0]);
        this.f7860e.a(new RunnableC0265b());
    }

    private synchronized void e() {
        if (!f()) {
            x.d("close when closed!", new Object[0]);
            return;
        }
        this.f7863h.stopWatching();
        this.f7863h = null;
        x.d("close anr monitor!", new Object[0]);
    }

    private synchronized boolean f() {
        return this.f7863h != null;
    }

    private synchronized boolean g() {
        return this.f7864i;
    }

    private File h() {
        int indexOf;
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(this.f7861f);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i2 = 24;
                    int length = listFiles.length;
                    int i3 = 0;
                    while (i3 < length) {
                        File file2 = listFiles[i3];
                        String name = file2.getName();
                        if (name.startsWith("jni_mannual_bugly_trace_") && (indexOf = name.indexOf(".txt")) > 0) {
                            long parseLong = Long.parseLong(name.substring(i2, indexOf));
                            long j2 = (currentTimeMillis - parseLong) / 1000;
                            x.c("current time %d trace time is %d s", Long.valueOf(currentTimeMillis), Long.valueOf(parseLong));
                            x.c("current time minus trace time is %d s", Long.valueOf(j2));
                            if (j2 < 30) {
                                return file2;
                            }
                        }
                        i3++;
                        i2 = 24;
                    }
                }
                return null;
            } catch (Throwable th) {
                x.a(th);
                return null;
            }
        }
        return null;
    }

    private synchronized void i() {
        if (f()) {
            x.d("start when started!", new Object[0]);
        } else if (TextUtils.isEmpty(this.f7861f)) {
        } else {
            ab abVar = this.f7865j;
            if (abVar == null || !abVar.isAlive()) {
                ab abVar2 = new ab();
                this.f7865j = abVar2;
                StringBuilder sb = new StringBuilder("Bugly-ThreadMonitor");
                int i2 = this.f7866k;
                this.f7866k = i2 + 1;
                sb.append(i2);
                abVar2.setName(sb.toString());
                this.f7865j.a();
                this.f7865j.a(this);
                this.f7865j.d();
                this.f7860e.a(new c());
            }
            d dVar = new d(this.f7861f, 256);
            this.f7863h = dVar;
            dVar.startWatching();
            x.a("startWatchingPrivateAnrDir! dumFilePath is %s", this.f7861f);
            this.f7860e.a(new e());
        }
    }

    private synchronized void j() {
        if (!f()) {
            x.d("close when closed!", new Object[0]);
            return;
        }
        ab abVar = this.f7865j;
        if (abVar != null) {
            abVar.c();
            this.f7865j.b();
            this.f7865j.b(this);
            this.f7865j = null;
        }
        x.a("stopWatchingPrivateAnrDir", new Object[0]);
        this.f7863h.stopWatching();
        this.f7863h = null;
        x.d("close anr monitor!", new Object[0]);
    }

    private synchronized void b(boolean z) {
        if (Build.VERSION.SDK_INT <= 19) {
            if (z) {
                d();
            } else {
                e();
            }
        } else if (z) {
            i();
        } else {
            j();
        }
    }

    public static b a(Context context, com.tencent.bugly.crashreport.common.strategy.a aVar, com.tencent.bugly.crashreport.common.info.a aVar2, w wVar, p pVar, com.tencent.bugly.crashreport.crash.b bVar, BuglyStrategy.a aVar3) {
        if (m == null) {
            m = new b(context, aVar, aVar2, wVar, bVar);
        }
        return m;
    }

    public final synchronized void c() {
        x.d("customer decides whether to open or close.", new Object[0]);
    }

    private ActivityManager.ProcessErrorStateInfo a(Context context, long j2) {
        try {
            x.c("to find!", new Object[0]);
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int i2 = 0;
            while (true) {
                x.c("waiting!", new Object[0]);
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.condition == 2) {
                            x.c("found!", new Object[0]);
                            return processErrorStateInfo;
                        }
                    }
                }
                z.b(500L);
                int i3 = i2 + 1;
                if (i2 >= 40) {
                    x.c("end!", new Object[0]);
                    return null;
                }
                i2 = i3;
            }
        } catch (Exception e2) {
            x.b(e2);
            return null;
        } catch (OutOfMemoryError e3) {
            this.f7867l.pid = Process.myPid();
            ActivityManager.ProcessErrorStateInfo processErrorStateInfo2 = this.f7867l;
            processErrorStateInfo2.shortMsg = "bugly sdk waitForAnrProcessStateChanged encount error:" + e3.getMessage();
            return this.f7867l;
        }
    }

    protected final void b() {
        int indexOf;
        long b = z.b() - com.tencent.bugly.crashreport.crash.c.f7875g;
        File file = new File(this.f7861f);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i2 = 0;
                    int i3 = 0;
                    for (File file2 : listFiles) {
                        String name = file2.getName();
                        boolean z = true;
                        if (!name.startsWith("bugly_trace_") && !name.startsWith("bugly_trace_")) {
                            z = false;
                            x.c("Number Trace file : " + name, new Object[0]);
                            if (z && (((indexOf = name.indexOf(".txt")) <= 0 || Long.parseLong(name.substring(i3, indexOf)) < b) && file2.delete())) {
                                i2++;
                            }
                        }
                        i3 = 12;
                        x.c("Number Trace file : " + name, new Object[0]);
                        if (z) {
                            i2++;
                        }
                    }
                    x.c("Number of overdue trace files that has deleted: " + i2, new Object[0]);
                }
            } catch (Throwable th) {
                x.a(th);
            }
        }
    }

    private CrashDetailBean a(com.tencent.bugly.crashreport.crash.anr.a aVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.i();
            crashDetailBean.F = this.f7859d.k();
            crashDetailBean.G = this.f7859d.j();
            crashDetailBean.H = this.f7859d.l();
            if (!com.tencent.bugly.crashreport.common.info.b.m()) {
                crashDetailBean.w = z.a(this.c, com.tencent.bugly.crashreport.crash.c.f7873e, (String) null);
            }
            crashDetailBean.b = 3;
            crashDetailBean.f7843e = this.f7859d.h();
            com.tencent.bugly.crashreport.common.info.a aVar2 = this.f7859d;
            crashDetailBean.f7844f = aVar2.f7824k;
            crashDetailBean.f7845g = aVar2.q();
            crashDetailBean.m = this.f7859d.g();
            crashDetailBean.n = "ANR_EXCEPTION";
            crashDetailBean.o = aVar.f7857f;
            crashDetailBean.q = aVar.f7858g;
            HashMap hashMap = new HashMap();
            crashDetailBean.P = hashMap;
            hashMap.put("BUGLY_CR_01", aVar.f7856e);
            String str = crashDetailBean.q;
            int indexOf = str != null ? str.indexOf("\n") : -1;
            crashDetailBean.p = indexOf > 0 ? crashDetailBean.q.substring(0, indexOf) : "GET_FAIL";
            crashDetailBean.r = aVar.c;
            String str2 = crashDetailBean.q;
            if (str2 != null) {
                crashDetailBean.u = z.a(str2.getBytes());
            }
            crashDetailBean.z = aVar.b;
            crashDetailBean.A = aVar.a;
            crashDetailBean.B = "main(1)";
            crashDetailBean.I = this.f7859d.s();
            crashDetailBean.f7846h = this.f7859d.p();
            crashDetailBean.f7847i = this.f7859d.B();
            crashDetailBean.v = aVar.f7855d;
            com.tencent.bugly.crashreport.common.info.a aVar3 = this.f7859d;
            crashDetailBean.L = aVar3.o;
            crashDetailBean.M = aVar3.a;
            crashDetailBean.N = aVar3.a();
            if (!com.tencent.bugly.crashreport.common.info.b.m()) {
                this.f7862g.d(crashDetailBean);
            }
            crashDetailBean.Q = this.f7859d.z();
            crashDetailBean.R = this.f7859d.A();
            crashDetailBean.S = this.f7859d.t();
            crashDetailBean.T = this.f7859d.y();
            crashDetailBean.y = y.a();
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    private static boolean a(String str, String str2, String str3) {
        Map<String, String[]> map;
        Throwable th;
        BufferedWriter bufferedWriter;
        TraceFileHelper.a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo != null && (map = readTargetDumpInfo.f7854d) != null && map.size() > 0) {
            File file = new File(str2);
            try {
                if (!file.exists()) {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                if (file.exists() && file.canWrite()) {
                    BufferedWriter bufferedWriter2 = null;
                    try {
                        try {
                            bufferedWriter = new BufferedWriter(new FileWriter(file, false));
                        } catch (IOException e2) {
                            e = e2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        String[] strArr = readTargetDumpInfo.f7854d.get("main");
                        int i2 = 3;
                        if (strArr != null && strArr.length >= 3) {
                            String str4 = strArr[0];
                            String str5 = strArr[1];
                            String str6 = strArr[2];
                            bufferedWriter.write("\"main\" tid=" + str6 + " :\n" + str4 + "\n" + str5 + "\n\n");
                            bufferedWriter.flush();
                        }
                        for (Map.Entry<String, String[]> entry : readTargetDumpInfo.f7854d.entrySet()) {
                            if (!entry.getKey().equals("main")) {
                                if (entry.getValue() != null && entry.getValue().length >= i2) {
                                    String str7 = entry.getValue()[0];
                                    String str8 = entry.getValue()[1];
                                    String str9 = entry.getValue()[2];
                                    bufferedWriter.write("\"" + entry.getKey() + "\" tid=" + str9 + " :\n" + str7 + "\n" + str8 + "\n\n");
                                    bufferedWriter.flush();
                                }
                                i2 = 3;
                            }
                        }
                        try {
                            bufferedWriter.close();
                        } catch (IOException e3) {
                            if (!x.a(e3)) {
                                e3.printStackTrace();
                            }
                        }
                        return true;
                    } catch (IOException e4) {
                        e = e4;
                        bufferedWriter2 = bufferedWriter;
                        if (!x.a(e)) {
                            e.printStackTrace();
                        }
                        x.e("dump trace fail %s", e.getClass().getName() + ":" + e.getMessage());
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e5) {
                                if (!x.a(e5)) {
                                    e5.printStackTrace();
                                }
                            }
                        }
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedWriter2 = bufferedWriter;
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e6) {
                                if (!x.a(e6)) {
                                    e6.printStackTrace();
                                }
                            }
                        }
                        throw th;
                    }
                }
                x.e("backup file create fail %s", str2);
                return false;
            } catch (Exception e7) {
                if (!x.a(e7)) {
                    e7.printStackTrace();
                }
                x.e("backup file create error! %s  %s", e7.getClass().getName() + ":" + e7.getMessage(), str2);
                return false;
            }
        }
        x.e("not found trace dump for %s", str3);
        return false;
    }

    public final boolean a() {
        return this.a.get() != 0;
    }

    private boolean a(Context context, String str, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j2, Map<String, String> map) {
        com.tencent.bugly.crashreport.crash.anr.a aVar = new com.tencent.bugly.crashreport.crash.anr.a();
        aVar.c = j2;
        aVar.a = processErrorStateInfo != null ? processErrorStateInfo.processName : AppInfo.a(Process.myPid());
        aVar.f7857f = processErrorStateInfo != null ? processErrorStateInfo.shortMsg : "";
        aVar.f7856e = processErrorStateInfo != null ? processErrorStateInfo.longMsg : "";
        aVar.b = map;
        Thread thread = Looper.getMainLooper().getThread();
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (next.startsWith(thread.getName())) {
                    aVar.f7858g = map.get(next);
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(aVar.f7858g)) {
            aVar.f7858g = "main stack is null , some error may be encountered.";
        }
        Object[] objArr = new Object[7];
        objArr[0] = Long.valueOf(aVar.c);
        objArr[1] = aVar.f7855d;
        objArr[2] = aVar.a;
        objArr[3] = aVar.f7858g;
        objArr[4] = aVar.f7857f;
        objArr[5] = aVar.f7856e;
        Map<String, String> map2 = aVar.b;
        objArr[6] = Integer.valueOf(map2 == null ? 0 : map2.size());
        x.c("anr tm:%d\ntr:%s\nproc:%s\nmain stack:%s\nsMsg:%s\n lMsg:%s\n threads:%d", objArr);
        x.a("found visiable anr , start to upload!", new Object[0]);
        CrashDetailBean a2 = a(aVar);
        if (a2 == null) {
            x.e("pack anr fail!", new Object[0]);
            return false;
        }
        com.tencent.bugly.crashreport.crash.c.a().a(a2);
        if (a2.a >= 0) {
            x.a("backup anr record success!", new Object[0]);
        } else {
            x.d("backup anr record fail!", new Object[0]);
        }
        if (str != null && new File(str).exists()) {
            String str2 = this.f7861f;
            aVar.f7855d = new File(str2, "bugly_trace_" + j2 + ".txt").getAbsolutePath();
            this.a.set(3);
            if (a(str, aVar.f7855d, aVar.a)) {
                x.a("backup trace success", new Object[0]);
            }
        } else {
            File h2 = h();
            x.a("traceFile is %s", h2);
            if (h2 != null) {
                a2.v = h2.getAbsolutePath();
            }
        }
        com.tencent.bugly.crashreport.crash.b.a("ANR", z.a(), aVar.a, "main", aVar.f7858g, a2);
        if (!this.f7862g.a(a2)) {
            this.f7862g.a(a2, 3000L, true);
        }
        this.f7862g.c(a2);
        return true;
    }

    public final void a(String str) {
        synchronized (this) {
            if (this.a.get() != 0) {
                x.c("trace started return ", new Object[0]);
                return;
            }
            this.a.set(1);
            try {
                x.c("read trace first dump for create time!", new Object[0]);
                TraceFileHelper.a readFirstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
                long j2 = readFirstDumpInfo != null ? readFirstDumpInfo.c : -1L;
                if (j2 == -1) {
                    x.d("trace dump fail could not get time!", new Object[0]);
                    j2 = System.currentTimeMillis();
                }
                long j3 = j2;
                if (Math.abs(j3 - this.b) < 10000) {
                    x.d("should not process ANR too Fre in %d", 10000);
                } else {
                    this.b = j3;
                    this.a.set(1);
                    Map<String, String> a2 = z.a(com.tencent.bugly.crashreport.crash.c.f7874f, false);
                    if (a2 != null && a2.size() > 0) {
                        ActivityManager.ProcessErrorStateInfo a3 = a(this.c, 20000L);
                        this.f7867l = a3;
                        if (a3 == null) {
                            x.c("proc state is unvisiable!", new Object[0]);
                        } else if (a3.pid != Process.myPid()) {
                            x.c("not mind proc!", this.f7867l.processName);
                        } else {
                            x.a("found visiable anr , start to process!", new Object[0]);
                            a(this.c, str, this.f7867l, j3, a2);
                        }
                    }
                    x.d("can't get all thread skip this anr", new Object[0]);
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public final void a(boolean z) {
        c(z);
        boolean g2 = g();
        com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a2 != null) {
            g2 = g2 && a2.c().f7827e;
        }
        if (g2 != f()) {
            x.a("anr changed to %b", Boolean.valueOf(g2));
            b(g2);
        }
    }

    @Override // com.tencent.bugly.proguard.ac
    public final boolean a(aa aaVar) {
        Map<String, String> hashMap = new HashMap<>();
        if (aaVar.e().equals(Looper.getMainLooper())) {
            try {
                hashMap = z.a(200000, false);
            } catch (Throwable th) {
                x.b(th);
                hashMap.put("main", th.getMessage());
            }
            Map<String, String> map = hashMap;
            x.c("onThreadBlock found visiable anr , start to process!", new Object[0]);
            String c2 = com.tencent.bugly.crashreport.common.info.b.c(this.c);
            if (!TextUtils.isEmpty(c2) && (c2.contains("XiaoMi") || c2.contains("samsung"))) {
                this.f7867l = a(this.c, 20000L);
            }
            a(this.c, "", this.f7867l, System.currentTimeMillis(), map);
        } else {
            x.c("anr handler onThreadBlock only care main thread ,current thread is: %s", aaVar.d());
        }
        return true;
    }
}
