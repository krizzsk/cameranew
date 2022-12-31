package com.nostra13.universalimageloader.core;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageLoaderEngine.java */
/* loaded from: classes3.dex */
public class d {
    final ImageLoaderConfiguration a;
    private Executor b;
    private Executor c;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Integer, String> f5952e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, ReentrantLock> f5953f = new WeakHashMap();

    /* renamed from: g  reason: collision with root package name */
    private final AtomicBoolean f5954g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    private final AtomicBoolean f5955h = new AtomicBoolean(false);

    /* renamed from: i  reason: collision with root package name */
    private final AtomicBoolean f5956i = new AtomicBoolean(false);

    /* renamed from: j  reason: collision with root package name */
    private final Object f5957j = new Object();

    /* renamed from: d  reason: collision with root package name */
    private Executor f5951d = com.nostra13.universalimageloader.core.a.i();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImageLoaderEngine.java */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        final /* synthetic */ LoadAndDisplayImageTask a;

        a(LoadAndDisplayImageTask loadAndDisplayImageTask) {
            this.a = loadAndDisplayImageTask;
        }

        @Override // java.lang.Runnable
        public void run() {
            File file = d.this.a.o.get(this.a.n());
            boolean z = file != null && file.exists();
            d.this.l();
            if (z) {
                d.this.c.execute(this.a);
            } else {
                d.this.b.execute(this.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ImageLoaderConfiguration imageLoaderConfiguration) {
        this.a = imageLoaderConfiguration;
        this.b = imageLoaderConfiguration.f5899g;
        this.c = imageLoaderConfiguration.f5900h;
    }

    private Executor e() {
        ImageLoaderConfiguration imageLoaderConfiguration = this.a;
        return com.nostra13.universalimageloader.core.a.c(imageLoaderConfiguration.f5903k, imageLoaderConfiguration.f5904l, imageLoaderConfiguration.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (!this.a.f5901i && ((ExecutorService) this.b).isShutdown()) {
            this.b = e();
        }
        if (this.a.f5902j || !((ExecutorService) this.c).isShutdown()) {
            return;
        }
        this.c = e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(com.nostra13.universalimageloader.core.j.a aVar) {
        this.f5952e.remove(Integer.valueOf(aVar.getId()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Runnable runnable) {
        this.f5951d.execute(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g(com.nostra13.universalimageloader.core.j.a aVar) {
        return this.f5952e.get(Integer.valueOf(aVar.getId()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReentrantLock h(String str) {
        ReentrantLock reentrantLock = this.f5953f.get(str);
        if (reentrantLock == null) {
            ReentrantLock reentrantLock2 = new ReentrantLock();
            this.f5953f.put(str, reentrantLock2);
            return reentrantLock2;
        }
        return reentrantLock;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AtomicBoolean i() {
        return this.f5954g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object j() {
        return this.f5957j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(boolean z) {
        this.f5956i.set(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return this.f5955h.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return this.f5956i.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(com.nostra13.universalimageloader.core.j.a aVar, String str) {
        this.f5952e.put(Integer.valueOf(aVar.getId()), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(LoadAndDisplayImageTask loadAndDisplayImageTask) {
        this.f5951d.execute(new a(loadAndDisplayImageTask));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(g gVar) {
        l();
        this.c.execute(gVar);
    }
}
