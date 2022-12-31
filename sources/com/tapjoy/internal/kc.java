package com.tapjoy.internal;

import com.tapjoy.internal.kf;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public abstract class kc implements kf {
    private final ReentrantLock a = new ReentrantLock();
    private final a b = new a(this, (byte) 0);
    private final a c = new a(this, (byte) 0);

    /* renamed from: d  reason: collision with root package name */
    private kf.a f7767d = kf.a.NEW;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7768e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends kb {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.tapjoy.internal.kb, java.util.concurrent.Future
        /* renamed from: a */
        public kf.a get(long j2, TimeUnit timeUnit) {
            try {
                return (kf.a) super.get(j2, timeUnit);
            } catch (TimeoutException unused) {
                throw new TimeoutException(kc.this.toString());
            }
        }

        /* synthetic */ a(kc kcVar, byte b) {
            this();
        }
    }

    private ke g() {
        this.a.lock();
        try {
            kf.a aVar = this.f7767d;
            if (aVar == kf.a.NEW) {
                kf.a aVar2 = kf.a.TERMINATED;
                this.f7767d = aVar2;
                this.b.a(aVar2);
                this.c.a(aVar2);
            } else if (aVar == kf.a.STARTING) {
                this.f7768e = true;
                this.b.a(kf.a.STOPPING);
            } else if (aVar == kf.a.RUNNING) {
                this.f7767d = kf.a.STOPPING;
                b();
            }
        } finally {
            try {
                this.a.unlock();
                return this.c;
            } catch (Throwable th) {
            }
        }
        this.a.unlock();
        return this.c;
    }

    protected abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Throwable th) {
        jp.a(th);
        this.a.lock();
        try {
            kf.a aVar = this.f7767d;
            if (aVar == kf.a.STARTING) {
                this.b.a(th);
                this.c.a((Throwable) new Exception("Service failed to start.", th));
            } else if (aVar == kf.a.STOPPING) {
                this.c.a(th);
            } else if (aVar == kf.a.RUNNING) {
                this.c.a((Throwable) new Exception("Service failed while running", th));
            } else if (aVar == kf.a.NEW || aVar == kf.a.TERMINATED) {
                throw new IllegalStateException("Failed while in state:" + this.f7767d, th);
            }
            this.f7767d = kf.a.FAILED;
        } finally {
            this.a.unlock();
        }
    }

    protected abstract void b();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        this.a.lock();
        try {
            if (this.f7767d == kf.a.STARTING) {
                kf.a aVar = kf.a.RUNNING;
                this.f7767d = aVar;
                if (this.f7768e) {
                    g();
                } else {
                    this.b.a(aVar);
                }
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Cannot notifyStarted() when the service is " + this.f7767d);
            a(illegalStateException);
            throw illegalStateException;
        } finally {
            this.a.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        this.a.lock();
        try {
            kf.a aVar = this.f7767d;
            if (aVar != kf.a.STOPPING && aVar != kf.a.RUNNING) {
                IllegalStateException illegalStateException = new IllegalStateException("Cannot notifyStopped() when the service is " + this.f7767d);
                a(illegalStateException);
                throw illegalStateException;
            }
            kf.a aVar2 = kf.a.TERMINATED;
            this.f7767d = aVar2;
            this.c.a(aVar2);
        } finally {
            this.a.unlock();
        }
    }

    @Override // com.tapjoy.internal.kf
    public final ke e() {
        this.a.lock();
        try {
            if (this.f7767d == kf.a.NEW) {
                this.f7767d = kf.a.STARTING;
                a();
            }
        } finally {
            try {
                this.a.unlock();
                return this.b;
            } catch (Throwable th) {
            }
        }
        this.a.unlock();
        return this.b;
    }

    @Override // com.tapjoy.internal.kf
    public final kf.a f() {
        kf.a aVar;
        this.a.lock();
        try {
            if (this.f7768e && this.f7767d == kf.a.STARTING) {
                aVar = kf.a.STOPPING;
            } else {
                aVar = this.f7767d;
            }
            return aVar;
        } finally {
            this.a.unlock();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + " [" + f() + "]";
    }
}
