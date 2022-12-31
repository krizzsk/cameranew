package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
/* loaded from: classes2.dex */
public class ISDemandOnlyListenerWrapper {
    private static final ISDemandOnlyListenerWrapper b = new ISDemandOnlyListenerWrapper();
    private com.ironsource.mediationsdk.n0.g a = null;

    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ISDemandOnlyListenerWrapper.this.a.a(this.a);
            ISDemandOnlyListenerWrapper iSDemandOnlyListenerWrapper = ISDemandOnlyListenerWrapper.this;
            iSDemandOnlyListenerWrapper.c("onInterstitialAdReady() instanceId=" + this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ com.ironsource.mediationsdk.logger.b b;

        b(String str, com.ironsource.mediationsdk.logger.b bVar) {
            this.a = str;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ISDemandOnlyListenerWrapper.this.a.b(this.a, this.b);
            ISDemandOnlyListenerWrapper iSDemandOnlyListenerWrapper = ISDemandOnlyListenerWrapper.this;
            iSDemandOnlyListenerWrapper.c("onInterstitialAdLoadFailed() instanceId=" + this.a + " error=" + this.b.b());
        }
    }

    /* loaded from: classes2.dex */
    class c implements Runnable {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ISDemandOnlyListenerWrapper.this.a.d(this.a);
            ISDemandOnlyListenerWrapper iSDemandOnlyListenerWrapper = ISDemandOnlyListenerWrapper.this;
            iSDemandOnlyListenerWrapper.c("onInterstitialAdOpened() instanceId=" + this.a);
        }
    }

    /* loaded from: classes2.dex */
    class d implements Runnable {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ISDemandOnlyListenerWrapper.this.a.e(this.a);
            ISDemandOnlyListenerWrapper iSDemandOnlyListenerWrapper = ISDemandOnlyListenerWrapper.this;
            iSDemandOnlyListenerWrapper.c("onInterstitialAdClosed() instanceId=" + this.a);
        }
    }

    /* loaded from: classes2.dex */
    class e implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ com.ironsource.mediationsdk.logger.b b;

        e(String str, com.ironsource.mediationsdk.logger.b bVar) {
            this.a = str;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ISDemandOnlyListenerWrapper.this.a.c(this.a, this.b);
            ISDemandOnlyListenerWrapper iSDemandOnlyListenerWrapper = ISDemandOnlyListenerWrapper.this;
            iSDemandOnlyListenerWrapper.c("onInterstitialAdShowFailed() instanceId=" + this.a + " error=" + this.b.b());
        }
    }

    /* loaded from: classes2.dex */
    class f implements Runnable {
        final /* synthetic */ String a;

        f(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            ISDemandOnlyListenerWrapper.this.a.f(this.a);
            ISDemandOnlyListenerWrapper iSDemandOnlyListenerWrapper = ISDemandOnlyListenerWrapper.this;
            iSDemandOnlyListenerWrapper.c("onInterstitialAdClicked() instanceId=" + this.a);
        }
    }

    private ISDemandOnlyListenerWrapper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
    }

    public static ISDemandOnlyListenerWrapper getInstance() {
        return b;
    }

    public void d(String str) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new f(str));
        }
    }

    public void e(String str) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new d(str));
        }
    }

    public void f(String str, com.ironsource.mediationsdk.logger.b bVar) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new b(str, bVar));
        }
    }

    public void g(String str) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new c(str));
        }
    }

    public void h(String str) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new a(str));
        }
    }

    public void i(String str, com.ironsource.mediationsdk.logger.b bVar) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new e(str, bVar));
        }
    }
}
