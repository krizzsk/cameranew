package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.a.b.g;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: ConnectionPool.java */
/* loaded from: classes.dex */
public final class j {
    static final /* synthetic */ boolean c = true;

    /* renamed from: d  reason: collision with root package name */
    private static final Executor f1086d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.a.b.a.c.a("OkHttp ConnectionPool", true));
    final com.bytedance.sdk.a.b.a.b.d a;
    boolean b;

    /* renamed from: e  reason: collision with root package name */
    private final int f1087e;

    /* renamed from: f  reason: collision with root package name */
    private final long f1088f;

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f1089g;

    /* renamed from: h  reason: collision with root package name */
    private final Deque<com.bytedance.sdk.a.b.a.b.c> f1090h;

    public j() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.a.b.a.b.c a(a aVar, com.bytedance.sdk.a.b.a.b.g gVar, ac acVar) {
        if (c || Thread.holdsLock(this)) {
            for (com.bytedance.sdk.a.b.a.b.c cVar : this.f1090h) {
                if (cVar.a(aVar, acVar)) {
                    gVar.a(cVar, true);
                    return cVar;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(com.bytedance.sdk.a.b.a.b.c cVar) {
        if (c || Thread.holdsLock(this)) {
            if (!cVar.a && this.f1087e != 0) {
                notifyAll();
                return false;
            }
            this.f1090h.remove(cVar);
            return true;
        }
        throw new AssertionError();
    }

    public j(int i2, long j2, TimeUnit timeUnit) {
        this.f1089g = new Runnable() { // from class: com.bytedance.sdk.a.b.j.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long a = j.this.a(System.nanoTime());
                    if (a == -1) {
                        return;
                    }
                    if (a > 0) {
                        long j3 = a / 1000000;
                        long j4 = a - (1000000 * j3);
                        synchronized (j.this) {
                            try {
                                j.this.wait(j3, (int) j4);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.f1090h = new ArrayDeque();
        this.a = new com.bytedance.sdk.a.b.a.b.d();
        this.f1087e = i2;
        this.f1088f = timeUnit.toNanos(j2);
        if (j2 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Socket a(a aVar, com.bytedance.sdk.a.b.a.b.g gVar) {
        if (c || Thread.holdsLock(this)) {
            for (com.bytedance.sdk.a.b.a.b.c cVar : this.f1090h) {
                if (cVar.a(aVar, null) && cVar.d() && cVar != gVar.b()) {
                    return gVar.a(cVar);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.a.b.a.b.c cVar) {
        if (!c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.b) {
            this.b = true;
            f1086d.execute(this.f1089g);
        }
        this.f1090h.add(cVar);
    }

    long a(long j2) {
        synchronized (this) {
            com.bytedance.sdk.a.b.a.b.c cVar = null;
            long j3 = Long.MIN_VALUE;
            int i2 = 0;
            int i3 = 0;
            for (com.bytedance.sdk.a.b.a.b.c cVar2 : this.f1090h) {
                if (a(cVar2, j2) > 0) {
                    i3++;
                } else {
                    i2++;
                    long j4 = j2 - cVar2.f888e;
                    if (j4 > j3) {
                        cVar = cVar2;
                        j3 = j4;
                    }
                }
            }
            long j5 = this.f1088f;
            if (j3 < j5 && i2 <= this.f1087e) {
                if (i2 > 0) {
                    return j5 - j3;
                } else if (i3 > 0) {
                    return j5;
                } else {
                    this.b = false;
                    return -1L;
                }
            }
            this.f1090h.remove(cVar);
            com.bytedance.sdk.a.b.a.c.a(cVar.b());
            return 0L;
        }
    }

    private int a(com.bytedance.sdk.a.b.a.b.c cVar, long j2) {
        List<Reference<com.bytedance.sdk.a.b.a.b.g>> list = cVar.f887d;
        int i2 = 0;
        while (i2 < list.size()) {
            Reference<com.bytedance.sdk.a.b.a.b.g> reference = list.get(i2);
            if (reference.get() != null) {
                i2++;
            } else {
                com.bytedance.sdk.a.b.a.g.e.b().a("A connection to " + cVar.a().a().a() + " was leaked. Did you forget to close a response body?", ((g.a) reference).a);
                list.remove(i2);
                cVar.a = true;
                if (list.isEmpty()) {
                    cVar.f888e = j2 - this.f1088f;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
