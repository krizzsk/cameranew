package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
/* loaded from: classes2.dex */
public class RVListenerWrapper {
    private static final RVListenerWrapper b = new RVListenerWrapper();
    private com.ironsource.mediationsdk.n0.s a = null;

    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                RVListenerWrapper.this.a.onRewardedVideoAdOpened();
                RVListenerWrapper.this.c("onRewardedVideoAdOpened()");
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                RVListenerWrapper.this.a.onRewardedVideoAdClosed();
                RVListenerWrapper.this.c("onRewardedVideoAdClosed()");
            }
        }
    }

    /* loaded from: classes2.dex */
    class c implements Runnable {
        final /* synthetic */ boolean a;

        c(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                RVListenerWrapper.this.a.i(this.a);
                RVListenerWrapper rVListenerWrapper = RVListenerWrapper.this;
                rVListenerWrapper.c("onRewardedVideoAvailabilityChanged() available=" + this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                RVListenerWrapper.this.a.o();
                RVListenerWrapper.this.c("onRewardedVideoAdStarted()");
            }
        }
    }

    /* loaded from: classes2.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                RVListenerWrapper.this.a.d();
                RVListenerWrapper.this.c("onRewardedVideoAdEnded()");
            }
        }
    }

    /* loaded from: classes2.dex */
    class f implements Runnable {
        final /* synthetic */ com.ironsource.mediationsdk.model.o a;

        f(com.ironsource.mediationsdk.model.o oVar) {
            this.a = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                RVListenerWrapper.this.a.p(this.a);
                RVListenerWrapper rVListenerWrapper = RVListenerWrapper.this;
                rVListenerWrapper.c("onRewardedVideoAdRewarded(" + this.a + ")");
            }
        }
    }

    /* loaded from: classes2.dex */
    class g implements Runnable {
        final /* synthetic */ com.ironsource.mediationsdk.logger.b a;

        g(com.ironsource.mediationsdk.logger.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                RVListenerWrapper.this.a.k(this.a);
                RVListenerWrapper rVListenerWrapper = RVListenerWrapper.this;
                rVListenerWrapper.c("onRewardedVideoAdShowFailed() error=" + this.a.b());
            }
        }
    }

    /* loaded from: classes2.dex */
    class h implements Runnable {
        final /* synthetic */ com.ironsource.mediationsdk.model.o a;

        h(com.ironsource.mediationsdk.model.o oVar) {
            this.a = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                RVListenerWrapper.this.a.t(this.a);
                RVListenerWrapper rVListenerWrapper = RVListenerWrapper.this;
                rVListenerWrapper.c("onRewardedVideoAdClicked(" + this.a + ")");
            }
        }
    }

    private RVListenerWrapper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
    }

    public static synchronized RVListenerWrapper getInstance() {
        RVListenerWrapper rVListenerWrapper;
        synchronized (RVListenerWrapper.class) {
            rVListenerWrapper = b;
        }
        return rVListenerWrapper;
    }

    public synchronized void d(com.ironsource.mediationsdk.model.o oVar) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new h(oVar));
        }
    }

    public synchronized void e() {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new b());
        }
    }

    public synchronized void f() {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new e());
        }
    }

    public synchronized void g() {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new a());
        }
    }

    public synchronized void h(com.ironsource.mediationsdk.model.o oVar) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new f(oVar));
        }
    }

    public synchronized void i(com.ironsource.mediationsdk.logger.b bVar) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new g(bVar));
        }
    }

    public synchronized void j() {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new d());
        }
    }

    public synchronized void k(boolean z) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new c(z));
        }
    }
}
