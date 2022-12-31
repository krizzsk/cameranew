package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class CallbackThrottler {

    /* renamed from: e  reason: collision with root package name */
    private static final CallbackThrottler f5398e = new CallbackThrottler();

    /* renamed from: d  reason: collision with root package name */
    private int f5399d;
    private com.ironsource.mediationsdk.n0.l c = null;
    private Map<String, Long> a = new HashMap();
    private Map<String, Boolean> b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ com.ironsource.mediationsdk.logger.b b;

        a(String str, com.ironsource.mediationsdk.logger.b bVar) {
            this.a = str;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            CallbackThrottler.this.e(this.a, this.b);
            CallbackThrottler.this.b.put(this.a, Boolean.FALSE);
        }
    }

    private CallbackThrottler() {
    }

    private boolean d(String str) {
        if (!TextUtils.isEmpty(str) && this.b.containsKey(str)) {
            return this.b.get(str).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, com.ironsource.mediationsdk.logger.b bVar) {
        this.a.put(str, Long.valueOf(System.currentTimeMillis()));
        com.ironsource.mediationsdk.n0.l lVar = this.c;
        if (lVar != null) {
            lVar.a(bVar);
            com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
            i2.d(ironSourceTag, "onInterstitialAdLoadFailed(" + bVar.toString() + ")", 1);
        }
    }

    private void g(String str, com.ironsource.mediationsdk.logger.b bVar) {
        if (d(str)) {
            return;
        }
        if (!this.a.containsKey(str)) {
            e(str, bVar);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.a.get(str).longValue();
        if (currentTimeMillis > this.f5399d * 1000) {
            e(str, bVar);
            return;
        }
        this.b.put(str, Boolean.TRUE);
        new Handler(Looper.getMainLooper()).postDelayed(new a(str, bVar), (this.f5399d * 1000) - currentTimeMillis);
    }

    public static synchronized CallbackThrottler getInstance() {
        CallbackThrottler callbackThrottler;
        synchronized (CallbackThrottler.class) {
            callbackThrottler = f5398e;
        }
        return callbackThrottler;
    }

    public boolean c() {
        boolean d2;
        synchronized (this) {
            d2 = d("mediation");
        }
        return d2;
    }

    public void f(com.ironsource.mediationsdk.logger.b bVar) {
        synchronized (this) {
            g("mediation", bVar);
        }
    }

    public void h(int i2) {
        this.f5399d = i2;
    }

    public void i(com.ironsource.mediationsdk.n0.l lVar) {
        this.c = lVar;
    }
}
