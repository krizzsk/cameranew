package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
/* loaded from: classes2.dex */
public class RVDemandOnlyListenerWrapper {
    private static final RVDemandOnlyListenerWrapper b = new RVDemandOnlyListenerWrapper();
    private com.ironsource.mediationsdk.n0.h a = null;

    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RVDemandOnlyListenerWrapper.this.a.e(this.a);
            RVDemandOnlyListenerWrapper rVDemandOnlyListenerWrapper = RVDemandOnlyListenerWrapper.this;
            rVDemandOnlyListenerWrapper.c("onRewardedVideoAdLoadSuccess() instanceId=" + this.a);
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
            RVDemandOnlyListenerWrapper.this.a.a(this.a, this.b);
            RVDemandOnlyListenerWrapper rVDemandOnlyListenerWrapper = RVDemandOnlyListenerWrapper.this;
            rVDemandOnlyListenerWrapper.c("onRewardedVideoAdLoadFailed() instanceId=" + this.a + "error=" + this.b.b());
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
            RVDemandOnlyListenerWrapper.this.a.b(this.a);
            RVDemandOnlyListenerWrapper rVDemandOnlyListenerWrapper = RVDemandOnlyListenerWrapper.this;
            rVDemandOnlyListenerWrapper.c("onRewardedVideoAdOpened() instanceId=" + this.a);
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
            RVDemandOnlyListenerWrapper.this.a.c(this.a);
            RVDemandOnlyListenerWrapper rVDemandOnlyListenerWrapper = RVDemandOnlyListenerWrapper.this;
            rVDemandOnlyListenerWrapper.c("onRewardedVideoAdClosed() instanceId=" + this.a);
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
            RVDemandOnlyListenerWrapper.this.a.g(this.a, this.b);
            RVDemandOnlyListenerWrapper rVDemandOnlyListenerWrapper = RVDemandOnlyListenerWrapper.this;
            rVDemandOnlyListenerWrapper.c("onRewardedVideoAdShowFailed() instanceId=" + this.a + "error=" + this.b.b());
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
            RVDemandOnlyListenerWrapper.this.a.f(this.a);
            RVDemandOnlyListenerWrapper rVDemandOnlyListenerWrapper = RVDemandOnlyListenerWrapper.this;
            rVDemandOnlyListenerWrapper.c("onRewardedVideoAdClicked() instanceId=" + this.a);
        }
    }

    /* loaded from: classes2.dex */
    class g implements Runnable {
        final /* synthetic */ String a;

        g(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RVDemandOnlyListenerWrapper.this.a.d(this.a);
            RVDemandOnlyListenerWrapper rVDemandOnlyListenerWrapper = RVDemandOnlyListenerWrapper.this;
            rVDemandOnlyListenerWrapper.c("onRewardedVideoAdRewarded() instanceId=" + this.a);
        }
    }

    private RVDemandOnlyListenerWrapper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
    }

    public static RVDemandOnlyListenerWrapper getInstance() {
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
            new Handler(Looper.getMainLooper()).post(new g(str));
        }
    }

    public void i(String str, com.ironsource.mediationsdk.logger.b bVar) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new e(str, bVar));
        }
    }

    public void j(String str) {
        if (this.a != null) {
            new Handler(Looper.getMainLooper()).post(new a(str));
        }
    }
}
