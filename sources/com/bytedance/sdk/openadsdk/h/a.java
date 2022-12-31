package com.bytedance.sdk.openadsdk.h;

import androidx.annotation.NonNull;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.openadsdk.h.i;
import com.bytedance.sdk.openadsdk.h.l;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import us.pinguo.common.network.HttpRequest;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbsTask.java */
/* loaded from: classes.dex */
public abstract class a implements k {
    private static final AtomicLong m = new AtomicLong();
    protected volatile com.bytedance.sdk.openadsdk.h.a.a a;
    protected final com.bytedance.sdk.openadsdk.h.b.c b;

    /* renamed from: e  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.h.d.a f1993e;

    /* renamed from: f  reason: collision with root package name */
    protected volatile List<i.b> f1994f;

    /* renamed from: g  reason: collision with root package name */
    protected volatile String f1995g;

    /* renamed from: h  reason: collision with root package name */
    protected volatile String f1996h;

    /* renamed from: i  reason: collision with root package name */
    protected volatile i f1997i;

    /* renamed from: j  reason: collision with root package name */
    protected volatile l f1998j;
    protected final AtomicInteger c = new AtomicInteger();

    /* renamed from: d  reason: collision with root package name */
    protected final AtomicLong f1992d = new AtomicLong();

    /* renamed from: k  reason: collision with root package name */
    protected volatile boolean f1999k = false;

    /* renamed from: l  reason: collision with root package name */
    public final long f2000l = m.incrementAndGet();
    private final AtomicInteger n = new AtomicInteger(0);
    private int o = -1;

    public a(com.bytedance.sdk.openadsdk.h.a.a aVar, com.bytedance.sdk.openadsdk.h.b.c cVar) {
        this.a = aVar;
        this.b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Boolean bool, String str, @NonNull Throwable th) {
    }

    public boolean b() {
        return this.n.get() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.n.compareAndSet(0, 2);
    }

    public boolean d() {
        return this.n.get() == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() throws com.bytedance.sdk.openadsdk.h.c.a {
        if (b()) {
            throw new com.bytedance.sdk.openadsdk.h.c.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int f() {
        if (this.f1997i != null) {
            return this.f1997i.c.a;
        }
        return this.a instanceof com.bytedance.sdk.openadsdk.h.a.b ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g() {
        return f() == 1;
    }

    public void a() {
        this.n.compareAndSet(0, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.bytedance.sdk.openadsdk.h.e.a a(l.a aVar, int i2, int i3, String str) throws IOException, VAdError {
        com.bytedance.sdk.openadsdk.h.e.b b = com.bytedance.sdk.openadsdk.h.e.c.a().b();
        com.bytedance.sdk.openadsdk.h.e.f fVar = new com.bytedance.sdk.openadsdk.h.e.f();
        HashMap hashMap = new HashMap();
        fVar.b = aVar.a;
        fVar.a = 0;
        if ("HEAD".equalsIgnoreCase(str)) {
            fVar.a = 4;
        }
        List<i.b> list = this.f1994f;
        if (list != null && !list.isEmpty()) {
            for (i.b bVar : list) {
                if (!"Range".equalsIgnoreCase(bVar.a) && !"Connection".equalsIgnoreCase(bVar.a) && !"Proxy-Connection".equalsIgnoreCase(bVar.a) && !"Host".equalsIgnoreCase(bVar.a)) {
                    hashMap.put(bVar.a, bVar.b);
                }
            }
        }
        String a = com.bytedance.sdk.openadsdk.h.g.d.a(i2, i3);
        if (a != null) {
            hashMap.put("Range", a);
        }
        if (e.f2036f) {
            hashMap.put(HttpRequest.HEADER_CACHE_CONTROL, "no-cache");
        }
        d c = d.c();
        f a2 = f.a();
        boolean z = this.f1997i == null;
        c a3 = z ? c.a() : a2.b();
        c b2 = z ? c.b() : a2.c();
        if (a3 != null || b2 != null) {
            if (a3 != null) {
                fVar.c = a3.a(aVar.b);
            }
            if (b2 != null) {
                fVar.f2042d = b2.a(aVar.b);
            }
        }
        fVar.f2043e = hashMap;
        if (this.f1999k) {
            this.f1999k = false;
            return null;
        }
        return b.a(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2, int i3) {
        if (i2 <= 0 || i3 < 0) {
            return;
        }
        int i4 = e.f2037g;
        int f2 = f();
        if (i4 == 1 || (i4 == 2 && f2 == 1)) {
            int i5 = (int) ((i3 / i2) * 100.0f);
            if (i5 > 100) {
                i5 = 100;
            }
            synchronized (this) {
                if (i5 <= this.o) {
                    return;
                }
                this.o = i5;
                com.bytedance.sdk.openadsdk.h.g.d.b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a aVar = a.this;
                        com.bytedance.sdk.openadsdk.h.d.a aVar2 = aVar.f1993e;
                        if (aVar2 != null) {
                            aVar2.a(aVar.f1998j, a.this.o);
                        }
                    }
                });
            }
        }
    }
}
