package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.x;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: Dispatcher.java */
/* loaded from: classes.dex */
public final class n {
    private Runnable c;

    /* renamed from: d  reason: collision with root package name */
    private ExecutorService f1106d;
    private int a = 64;
    private int b = 5;

    /* renamed from: e  reason: collision with root package name */
    private final Deque<x.a> f1107e = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    private final Deque<x.a> f1108f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    private final Deque<x> f1109g = new ArrayDeque();

    private int b(x.a aVar) {
        int i2 = 0;
        for (x.a aVar2 : this.f1108f) {
            if (aVar2.a().equals(aVar.a())) {
                i2++;
            }
        }
        return i2;
    }

    private void c() {
        if (this.f1108f.size() < this.a && !this.f1107e.isEmpty()) {
            Iterator<x.a> it = this.f1107e.iterator();
            while (it.hasNext()) {
                x.a next = it.next();
                if (b(next) < this.b) {
                    it.remove();
                    this.f1108f.add(next);
                    a().execute(next);
                }
                if (this.f1108f.size() >= this.a) {
                    return;
                }
            }
        }
    }

    public synchronized ExecutorService a() {
        if (this.f1106d == null) {
            this.f1106d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.a.b.a.c.a("OkHttp Dispatcher", false));
        }
        return this.f1106d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(x xVar) {
        a(this.f1109g, xVar, false);
    }

    public synchronized int b() {
        return this.f1108f.size() + this.f1109g.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(x xVar) {
        this.f1109g.add(xVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(x.a aVar) {
        a(this.f1108f, aVar, true);
    }

    private <T> void a(Deque<T> deque, T t, boolean z) {
        int b;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    c();
                }
                b = b();
                runnable = this.c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (b != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }
}
