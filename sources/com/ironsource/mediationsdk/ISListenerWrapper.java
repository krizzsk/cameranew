package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
/* loaded from: classes2.dex */
public class ISListenerWrapper {
    private static final ISListenerWrapper b = new ISListenerWrapper();
    private com.ironsource.mediationsdk.n0.l a = null;

    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                ISListenerWrapper.this.a.c();
                ISListenerWrapper.this.c("onInterstitialAdReady()");
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements Runnable {
        final /* synthetic */ com.ironsource.mediationsdk.logger.b a;

        b(com.ironsource.mediationsdk.logger.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                ISListenerWrapper.this.a.a(this.a);
                ISListenerWrapper iSListenerWrapper = ISListenerWrapper.this;
                iSListenerWrapper.c("onInterstitialAdLoadFailed() error=" + this.a.b());
            }
        }
    }

    /* loaded from: classes2.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                ISListenerWrapper.this.a.h();
                ISListenerWrapper.this.c("onInterstitialAdOpened()");
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
                ISListenerWrapper.this.a.f();
                ISListenerWrapper.this.c("onInterstitialAdClosed()");
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
                ISListenerWrapper.this.a.j();
                ISListenerWrapper.this.c("onInterstitialAdShowSucceeded()");
            }
        }
    }

    /* loaded from: classes2.dex */
    class f implements Runnable {
        final /* synthetic */ com.ironsource.mediationsdk.logger.b a;

        f(com.ironsource.mediationsdk.logger.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                ISListenerWrapper.this.a.e(this.a);
                ISListenerWrapper iSListenerWrapper = ISListenerWrapper.this;
                iSListenerWrapper.c("onInterstitialAdShowFailed() error=" + this.a.b());
            }
        }
    }

    /* loaded from: classes2.dex */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                ISListenerWrapper.this.a.g();
                ISListenerWrapper.this.c("onInterstitialAdClicked()");
            }
        }
    }

    private ISListenerWrapper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
    }

    public static synchronized ISListenerWrapper getInstance() {
        ISListenerWrapper iSListenerWrapper;
        synchronized (ISListenerWrapper.class) {
            iSListenerWrapper = b;
        }
        return iSListenerWrapper;
    }

    public synchronized void d() {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new g());
        }
    }

    public synchronized void e() {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new d());
        }
    }

    public synchronized void f(com.ironsource.mediationsdk.logger.b bVar) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new b(bVar));
        }
    }

    public synchronized void g() {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new c());
        }
    }

    public synchronized void h() {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new a());
        }
    }

    public synchronized void i(com.ironsource.mediationsdk.logger.b bVar) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new f(bVar));
        }
    }

    public synchronized void j() {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new e());
        }
    }

    public synchronized void k(com.ironsource.mediationsdk.n0.l lVar) {
        this.a = lVar;
    }
}
