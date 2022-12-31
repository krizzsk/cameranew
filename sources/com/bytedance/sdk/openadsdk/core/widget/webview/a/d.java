package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.i;
import com.bytedance.sdk.adnet.b.j;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ab;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;
/* compiled from: TmplDiffManager.java */
/* loaded from: classes.dex */
public class d {
    private static volatile d a;
    private AtomicLong b;
    private ScheduledFuture<?> c;

    /* renamed from: d  reason: collision with root package name */
    private AtomicBoolean f1923d;

    /* renamed from: e  reason: collision with root package name */
    private AtomicBoolean f1924e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private CopyOnWriteArrayList<j> f1925f = new CopyOnWriteArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private CopyOnWriteArrayList<i> f1926g = new CopyOnWriteArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TmplDiffManager.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private int b;

        public a(int i2) {
            this.b = 0;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b == 1) {
                d.this.g();
                com.bytedance.sdk.openadsdk.i.a.a().a(new a(1), d.this.b.get());
            }
        }
    }

    private d() {
        f();
    }

    private void f() {
        this.b = new AtomicLong(o.h().j() * 1000);
        this.f1923d = new AtomicBoolean(false);
        this.c = com.bytedance.sdk.openadsdk.i.a.a().a((Runnable) new a(1), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        JSONObject a2;
        List<l> b = c.a().b();
        if (b.isEmpty()) {
            return;
        }
        for (l lVar : b) {
            if (this.f1924e.get()) {
                return;
            }
            if (!TextUtils.isEmpty(lVar.d()) && (a2 = a(lVar.d(), true)) != null) {
                String optString = a2.optString("md5");
                String optString2 = a2.optString("version");
                String optString3 = a2.optString("data");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && !optString.equals(lVar.c())) {
                    lVar.c(optString).e(optString3);
                    if (f.b(optString2)) {
                        lVar.f(optString2);
                        b.a().a(true);
                    }
                    c.a().a(lVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        int b;
        com.bytedance.sdk.openadsdk.utils.o.b("TmplDiffManager", "start doCheckAndDeleteTask");
        if (o.h() != null && (b = o.h().b() * 3) > 0) {
            List<l> b2 = c.a().b();
            if (!b2.isEmpty() && b < b2.size()) {
                int size = (int) (b2.size() - (b * 0.75f));
                com.bytedance.sdk.openadsdk.utils.o.b("TmplDiffManager", "doCheckAndDeleteTask maxTplCnt,local size,deleteCnt:" + b + "," + b2.size() + "," + size);
                HashSet hashSet = new HashSet();
                for (int i2 = 0; i2 < size; i2++) {
                    hashSet.add(b2.get(i2).b());
                }
                a(hashSet);
                com.bytedance.sdk.openadsdk.utils.o.b("TmplDiffManager", "end doCheckAndDeleteTask");
                this.f1923d.set(false);
                return;
            }
            com.bytedance.sdk.openadsdk.utils.o.b("TmplDiffManager", "end doCheckAndDeleteTask maxTplCnt,local size" + b + "," + b2.size());
        }
    }

    private void i() {
        CopyOnWriteArrayList<j> copyOnWriteArrayList = this.f1925f;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        CopyOnWriteArrayList<i> copyOnWriteArrayList2 = this.f1926g;
        if (copyOnWriteArrayList2 != null) {
            copyOnWriteArrayList2.clear();
        }
    }

    public void d() {
        if (this.f1923d.getAndSet(true)) {
            return;
        }
        com.bytedance.sdk.openadsdk.i.a.a().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.h();
            }
        }, 60000L);
    }

    public void e() {
        this.f1924e.set(true);
        CopyOnWriteArrayList<i> copyOnWriteArrayList = this.f1926g;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            Iterator<i> it = this.f1926g.iterator();
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
        CopyOnWriteArrayList<j> copyOnWriteArrayList2 = this.f1925f;
        if (copyOnWriteArrayList2 != null && copyOnWriteArrayList2.size() > 0) {
            Iterator<j> it2 = this.f1925f.iterator();
            while (it2.hasNext()) {
                j next2 = it2.next();
                if (next2 != null) {
                    next2.cancel();
                }
            }
        }
        i();
    }

    public void b() {
        f();
    }

    public void c() {
        long j2 = o.h().j() * 1000;
        if (this.b.get() != j2) {
            ScheduledFuture<?> scheduledFuture = this.c;
            if (scheduledFuture != null && scheduledFuture.isCancelled()) {
                this.c.cancel(true);
            }
            this.b.set(j2);
            this.c = com.bytedance.sdk.openadsdk.i.a.a().a((Runnable) new a(1), 0L);
        }
    }

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    public l a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c.a().a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(String str, boolean z) {
        if (this.f1924e.get()) {
            return null;
        }
        i a2 = i.a();
        j jVar = new j(0, str, a2);
        jVar.setResponseOnMain(false).setShouldCache(false).build(com.bytedance.sdk.openadsdk.g.d.a(o.a()).d());
        if (z) {
            this.f1925f.add(jVar);
            this.f1926g.add(a2);
        }
        try {
            m mVar = a2.get();
            if (mVar != null && mVar.a() && mVar.a != 0) {
                return new JSONObject((String) mVar.a);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public void a(h hVar) {
        if (hVar == null || hVar.u() == null) {
            return;
        }
        String b = hVar.u().b();
        String d2 = hVar.u().d();
        String c = hVar.u().c();
        int d3 = ab.d(hVar.M());
        com.bytedance.sdk.openadsdk.core.g.j c2 = com.bytedance.sdk.openadsdk.core.g.j.a().a(b).b(c).c(d2);
        a(c2, d3 + "");
    }

    public synchronized void a(com.bytedance.sdk.openadsdk.core.g.j jVar, String str) {
        if (jVar == null) {
            return;
        }
        final String str2 = jVar.a;
        final String str3 = jVar.c;
        final String str4 = jVar.b;
        if (TextUtils.isEmpty(str)) {
            str = com.bytedance.sdk.openadsdk.core.h.b().c();
        }
        final String str5 = str;
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str2)) {
            com.bytedance.sdk.openadsdk.i.a.a().b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.d.2
                @Override // java.lang.Runnable
                public void run() {
                    l a2 = d.this.a(str2);
                    if (a2 == null || !str4.equals(a2.c())) {
                        JSONObject a3 = d.this.a(str3, false);
                        if (a3 != null) {
                            String optString = a3.optString("md5");
                            String optString2 = a3.optString("version");
                            String optString3 = a3.optString("data");
                            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                                return;
                            }
                            l f2 = new l().a(str5).b(str2).c(optString).d(str3).e(optString3).f(optString2);
                            c.a().a(f2);
                            if (f.b(optString2)) {
                                f2.f(optString2);
                                b.a().a(true);
                            }
                        }
                    } else if (com.bytedance.sdk.openadsdk.core.widget.webview.a.a.g()) {
                    } else {
                        b.a().a(true);
                    }
                }
            }, 10);
        }
    }

    public void a(Set<String> set) {
        try {
            c.a().a(set);
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z) {
        this.f1924e.set(z);
    }
}
