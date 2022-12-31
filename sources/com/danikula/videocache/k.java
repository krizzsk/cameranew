package com.danikula.videocache;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProxyCache.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: i  reason: collision with root package name */
    private static final org.slf4j.b f2229i = org.slf4j.c.i("ProxyCache");
    private final m a;
    private final com.danikula.videocache.a b;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicInteger f2231e;

    /* renamed from: f  reason: collision with root package name */
    private volatile Thread f2232f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f2233g;
    private final Object c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final Object f2230d = new Object();

    /* renamed from: h  reason: collision with root package name */
    private volatile int f2234h = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ProxyCache.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.k();
        }
    }

    public k(m mVar, com.danikula.videocache.a aVar) {
        j.d(mVar);
        this.a = mVar;
        j.d(aVar);
        this.b = aVar;
        this.f2231e = new AtomicInteger();
    }

    private void b() throws ProxyCacheException {
        int i2 = this.f2231e.get();
        if (i2 < 1) {
            return;
        }
        this.f2231e.set(0);
        throw new ProxyCacheException("Error reading source " + i2 + " times");
    }

    private void c() {
        try {
            this.a.close();
        } catch (ProxyCacheException e2) {
            h(new ProxyCacheException("Error closing source " + this.a, e2));
        }
    }

    private boolean d() {
        return Thread.currentThread().isInterrupted() || this.f2233g;
    }

    private void e(long j2, long j3) {
        f(j2, j3);
        synchronized (this.c) {
            this.c.notifyAll();
        }
    }

    private void i() {
        this.f2234h = 100;
        g(this.f2234h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        long j2 = -1;
        long j3 = 0;
        try {
            j3 = this.b.available();
            this.a.a(j3);
            j2 = this.a.length();
            byte[] bArr = new byte[8192];
            while (true) {
                int read = this.a.read(bArr);
                if (read != -1) {
                    synchronized (this.f2230d) {
                        if (d()) {
                            return;
                        }
                        this.b.e(bArr, read);
                    }
                    j3 += read;
                    e(j3, j2);
                } else {
                    n();
                    i();
                    break;
                }
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    private synchronized void l() throws ProxyCacheException {
        boolean z = (this.f2232f == null || this.f2232f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.f2233g && !this.b.d() && !z) {
            b bVar = new b();
            this.f2232f = new Thread(bVar, "Source reader for " + this.a);
            this.f2232f.start();
        }
    }

    private void n() throws ProxyCacheException {
        synchronized (this.f2230d) {
            if (!d() && this.b.available() == this.a.length()) {
                this.b.complete();
            }
        }
    }

    private void o() throws ProxyCacheException {
        synchronized (this.c) {
            try {
                try {
                    this.c.wait(1000L);
                } catch (InterruptedException e2) {
                    throw new ProxyCacheException("Waiting source data is interrupted!", e2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected void f(long j2, long j3) {
        int i2 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        int i3 = i2 == 0 ? 100 : (int) ((((float) j2) / ((float) j3)) * 100.0f);
        boolean z = i3 != this.f2234h;
        if ((i2 >= 0) && z) {
            g(i3);
        }
        this.f2234h = i3;
    }

    protected void g(int i2) {
        throw null;
    }

    protected final void h(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            f2229i.debug("ProxyCache is interrupted");
        } else {
            f2229i.error("ProxyCache error", th);
        }
    }

    public int j(byte[] bArr, long j2, int i2) throws ProxyCacheException {
        l.a(bArr, j2, i2);
        while (!this.b.d() && this.b.available() < i2 + j2 && !this.f2233g) {
            l();
            o();
            b();
        }
        int f2 = this.b.f(bArr, j2, i2);
        if (this.b.d() && this.f2234h != 100) {
            this.f2234h = 100;
            g(100);
        }
        return f2;
    }

    public void m() {
        synchronized (this.f2230d) {
            org.slf4j.b bVar = f2229i;
            bVar.debug("Shutdown proxy for " + this.a);
            try {
                this.f2233g = true;
                if (this.f2232f != null) {
                    this.f2232f.interrupt();
                }
                this.b.close();
            } catch (ProxyCacheException e2) {
                h(e2);
            }
        }
    }
}
