package com.tapjoy.internal;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tapjoy.internal.ev;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public final class hm {
    final gy a;
    @Nullable
    ScheduledFuture c;
    final AtomicBoolean b = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f7627d = new Runnable() { // from class: com.tapjoy.internal.hm.1
        @Override // java.lang.Runnable
        public final void run() {
            if (hm.this.b.compareAndSet(true, false)) {
                gw.a("The session ended");
                gy gyVar = hm.this.a;
                long elapsedRealtime = SystemClock.elapsedRealtime() - gyVar.c;
                hc hcVar = gyVar.a;
                synchronized (hcVar) {
                    long a = hcVar.c.f7622i.a() + elapsedRealtime;
                    hcVar.c.f7622i.a(a);
                    hcVar.b.f7534i = Long.valueOf(a);
                }
                ev.a a2 = gyVar.a(ey.APP, "session");
                a2.f7446i = Long.valueOf(elapsedRealtime);
                gyVar.a(a2);
                gyVar.c = 0L;
                hc hcVar2 = gyVar.a;
                long longValue = a2.f7442e.longValue();
                synchronized (hcVar2) {
                    SharedPreferences.Editor a3 = hcVar2.c.a();
                    hcVar2.c.f7623j.a(a3, longValue);
                    hcVar2.c.f7624k.a(a3, elapsedRealtime);
                    a3.apply();
                    hcVar2.b.f7535j = Long.valueOf(longValue);
                    hcVar2.b.f7536k = Long.valueOf(elapsedRealtime);
                }
                final gx gxVar = gyVar.b;
                if (gxVar.b != null) {
                    gxVar.a();
                    new im() { // from class: com.tapjoy.internal.gx.1
                        @Override // com.tapjoy.internal.im
                        public final boolean a() {
                            return !gxVar.a.c();
                        }
                    }.run();
                }
                gxVar.a.flush();
                fs.f7544d.notifyObservers();
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f7628e = new Runnable() { // from class: com.tapjoy.internal.hm.2
        @Override // java.lang.Runnable
        public final void run() {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public hm(gy gyVar) {
        this.a = gyVar;
    }

    public final void a() {
        if (this.b.get()) {
            this.f7627d.run();
        }
    }
}
