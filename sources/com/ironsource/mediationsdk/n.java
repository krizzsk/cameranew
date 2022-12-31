package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
/* compiled from: ExpiredRvAdsManager.java */
/* loaded from: classes2.dex */
public class n {
    private Runnable a;
    private int b;
    private q c;

    /* renamed from: d  reason: collision with root package name */
    private com.ironsource.lifecycle.b f5639d;

    /* compiled from: ExpiredRvAdsManager.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ q a;

        a(n nVar, q qVar) {
            this.a = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            IronLog.INTERNAL.info("loaded ads are expired");
            q qVar = this.a;
            if (qVar != null) {
                qVar.A();
            }
        }
    }

    /* compiled from: ExpiredRvAdsManager.java */
    /* loaded from: classes2.dex */
    private static class b {
        private static volatile n a = new n(null);
    }

    /* synthetic */ n(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n c() {
        return b.a;
    }

    void a() {
        if (!b() || this.f5639d == null) {
            return;
        }
        IronLog.INTERNAL.info("canceling expiration timer");
        this.f5639d.f();
    }

    public boolean b() {
        return this.b != -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(q qVar, int i2) {
        this.c = qVar;
        if (i2 > 0) {
            this.b = i2;
            this.a = new a(this, qVar);
        } else {
            this.b = -1;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("initializing with expiredDurationInMinutes=" + this.b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(long j2) {
        if (b()) {
            long millis = TimeUnit.MINUTES.toMillis(this.b) - Math.max(j2, 0L);
            if (millis > 0) {
                a();
                this.f5639d = new com.ironsource.lifecycle.b(millis, this.a, true);
                Calendar calendar = Calendar.getInstance();
                calendar.add(14, (int) millis);
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.info("loaded ads will expire on: " + calendar.getTime() + " in " + String.format("%.2f", Double.valueOf((millis / 1000.0d) / 60.0d)) + " mins");
                return;
            }
            IronLog.INTERNAL.info("loaded ads are loaded immediately");
            this.c.A();
        }
    }

    private n() {
        this.b = 0;
    }
}
