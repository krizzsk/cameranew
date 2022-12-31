package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class BannerCallbackThrottler {

    /* renamed from: d  reason: collision with root package name */
    private static BannerCallbackThrottler f5382d;
    private long a = 0;
    private boolean b = false;
    private int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ IronSourceBannerLayout a;
        final /* synthetic */ com.ironsource.mediationsdk.logger.b b;

        a(IronSourceBannerLayout ironSourceBannerLayout, com.ironsource.mediationsdk.logger.b bVar) {
            this.a = ironSourceBannerLayout;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            BannerCallbackThrottler.this.c(this.a, this.b);
        }
    }

    private BannerCallbackThrottler() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(IronSourceBannerLayout ironSourceBannerLayout, com.ironsource.mediationsdk.logger.b bVar) {
        if (ironSourceBannerLayout != null) {
            this.a = System.currentTimeMillis();
            this.b = false;
            ironSourceBannerLayout.k(bVar);
        }
    }

    public static synchronized BannerCallbackThrottler getInstance() {
        BannerCallbackThrottler bannerCallbackThrottler;
        synchronized (BannerCallbackThrottler.class) {
            if (f5382d == null) {
                f5382d = new BannerCallbackThrottler();
            }
            bannerCallbackThrottler = f5382d;
        }
        return bannerCallbackThrottler;
    }

    public boolean b() {
        boolean z;
        synchronized (this) {
            z = this.b;
        }
        return z;
    }

    public void d(IronSourceBannerLayout ironSourceBannerLayout, com.ironsource.mediationsdk.logger.b bVar) {
        synchronized (this) {
            if (this.b) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            int i2 = this.c;
            if (currentTimeMillis > i2 * 1000) {
                c(ironSourceBannerLayout, bVar);
                return;
            }
            this.b = true;
            new Handler(Looper.getMainLooper()).postDelayed(new a(ironSourceBannerLayout, bVar), (i2 * 1000) - currentTimeMillis);
        }
    }

    public void e(int i2) {
        this.c = i2;
    }
}
