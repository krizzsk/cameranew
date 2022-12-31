package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import com.bytedance.sdk.adnet.b.i;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.h;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: TemplateManager.java */
/* loaded from: classes.dex */
public class b {
    private static File a;
    private static volatile b b;
    private AtomicBoolean c = new AtomicBoolean(true);

    /* renamed from: d  reason: collision with root package name */
    private AtomicBoolean f1916d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    private boolean f1917e = false;

    /* renamed from: f  reason: collision with root package name */
    private CopyOnWriteArrayList<com.bytedance.sdk.adnet.b.c> f1918f = new CopyOnWriteArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private CopyOnWriteArrayList<i> f1919g = new CopyOnWriteArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private AtomicBoolean f1920h = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    private AtomicInteger f1921i = new AtomicInteger(0);

    /* renamed from: j  reason: collision with root package name */
    private AtomicLong f1922j = new AtomicLong();

    private b() {
        h();
    }

    public static File f() {
        if (a == null) {
            try {
                File file = new File(new File(o.a().getCacheDir(), "tt_tmpl_pkg"), "template");
                file.mkdirs();
                a = file;
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.c("TemplateManager", "getTemplateDir error", th);
            }
        }
        return a;
    }

    private void h() {
        com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "init......1");
        com.bytedance.sdk.openadsdk.i.a.a().b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                f.a();
                b.this.c.set(false);
                com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "init......2");
                b.this.i();
                b.this.e();
                com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "init......3");
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i() {
        /*
            r8 = this;
            java.lang.String r0 = "TemplateManager"
            java.lang.String r1 = "check template usable1"
            com.bytedance.sdk.openadsdk.utils.o.b(r0, r1)
            com.bytedance.sdk.openadsdk.core.d.k r1 = com.bytedance.sdk.openadsdk.core.widget.webview.a.f.b()
            if (r1 == 0) goto L98
            boolean r2 = r1.e()
            if (r2 != 0) goto L15
            goto L98
        L15:
            r2 = 1
            java.util.List r1 = r1.d()
            java.util.Iterator r1 = r1.iterator()
        L1e:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L7c
            java.lang.Object r3 = r1.next()
            com.bytedance.sdk.openadsdk.core.d.k$a r3 = (com.bytedance.sdk.openadsdk.core.d.k.a) r3
            java.lang.String r4 = r3.a()
            java.lang.String r5 = com.bytedance.sdk.openadsdk.utils.h.a(r4)
            java.io.File r6 = new java.io.File
            java.io.File r7 = f()
            r6.<init>(r7, r5)
            java.lang.String r5 = com.bytedance.sdk.openadsdk.utils.h.a(r6)
            boolean r7 = r6.exists()
            if (r7 == 0) goto L5b
            boolean r7 = r6.isFile()
            if (r7 == 0) goto L5b
            java.lang.String r7 = r3.b()
            if (r7 == 0) goto L5b
            java.lang.String r3 = r3.b()
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L1e
        L5b:
            r2 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "check template usable3: "
            r1.append(r3)
            r1.append(r4)
            java.lang.String r3 = ","
            r1.append(r3)
            java.lang.String r3 = r6.getAbsolutePath()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.bytedance.sdk.openadsdk.utils.o.b(r0, r1)
        L7c:
            if (r2 != 0) goto L81
            com.bytedance.sdk.openadsdk.core.widget.webview.a.f.d()
        L81:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "check template usable4: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.bytedance.sdk.openadsdk.utils.o.b(r0, r1)
            r8.f1917e = r2
            return
        L98:
            java.lang.String r1 = "check template usable2"
            com.bytedance.sdk.openadsdk.utils.o.b(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.widget.webview.a.b.i():void");
    }

    private void j() {
        com.bytedance.sdk.openadsdk.utils.o.e("TemplateManager", "任务执行完，，，clearCurrentExecuteTaskList");
        CopyOnWriteArrayList<com.bytedance.sdk.adnet.b.c> copyOnWriteArrayList = this.f1918f;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        CopyOnWriteArrayList<i> copyOnWriteArrayList2 = this.f1919g;
        if (copyOnWriteArrayList2 != null) {
            copyOnWriteArrayList2.clear();
        }
    }

    private void k() {
        if (this.f1921i.getAndSet(0) <= 0 || System.currentTimeMillis() - this.f1922j.get() <= 600000) {
            return;
        }
        e();
    }

    public boolean c() {
        return this.f1917e;
    }

    public k d() {
        return f.b();
    }

    public void e() {
        a(false);
    }

    public void g() {
        this.f1920h.set(true);
        CopyOnWriteArrayList<i> copyOnWriteArrayList = this.f1919g;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<i> it = this.f1919g.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (next != null) {
                    try {
                        if (!next.isDone() || !next.isCancelled()) {
                            next.cancel(true);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        CopyOnWriteArrayList<com.bytedance.sdk.adnet.b.c> copyOnWriteArrayList2 = this.f1918f;
        if (copyOnWriteArrayList2 != null && copyOnWriteArrayList2.size() > 0) {
            Iterator<com.bytedance.sdk.adnet.b.c> it2 = this.f1918f.iterator();
            while (it2.hasNext()) {
                com.bytedance.sdk.adnet.b.c next2 = it2.next();
                if (next2 != null) {
                    next2.cancel();
                }
            }
        }
        j();
        this.f1917e = false;
        this.f1916d.set(false);
    }

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    public void b() {
        h();
    }

    public void b(boolean z) {
        this.f1920h.set(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x01c7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137 A[Catch: all -> 0x0271, TRY_ENTER, TryCatch #0 {all -> 0x0271, blocks: (B:6:0x0010, B:9:0x001a, B:10:0x001f, B:12:0x0034, B:14:0x004e, B:17:0x0056, B:19:0x0065, B:21:0x0079, B:23:0x008a, B:26:0x0096, B:28:0x00a0, B:50:0x0126, B:51:0x012f, B:54:0x0137, B:56:0x0145, B:58:0x014b, B:61:0x0179, B:64:0x0182, B:69:0x01b0, B:71:0x01b6, B:73:0x01c7, B:74:0x01ce, B:76:0x01d4, B:78:0x01e2, B:80:0x01e8, B:83:0x0216, B:87:0x0220, B:89:0x0228, B:91:0x022e, B:29:0x00ae, B:30:0x00b6, B:32:0x00bc, B:34:0x00cc, B:35:0x00d0, B:37:0x00da, B:39:0x00e0, B:41:0x00ee, B:42:0x00f2, B:43:0x00fa, B:45:0x0100, B:47:0x0110, B:48:0x0114, B:49:0x011a, B:92:0x0261), top: B:101:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r11) {
        /*
            Method dump skipped, instructions count: 632
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.widget.webview.a.b.a(boolean):void");
    }

    private void a(int i2) {
        com.bytedance.sdk.openadsdk.f.a.a().c(com.bytedance.sdk.openadsdk.f.a.c.b().b(i2).f(g.a(i2)));
    }

    private void a(List<k.a> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (k.a aVar : list) {
            File file = new File(f(), h.a(aVar.a()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }
}
