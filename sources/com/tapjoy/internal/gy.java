package com.tapjoy.internal;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.internal.ev;
import com.tapjoy.internal.ex;
import com.tapjoy.internal.fd;
import com.tapjoy.internal.fh;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public final class gy {
    final hc a;
    final gx b;
    long c;

    /* renamed from: d  reason: collision with root package name */
    private int f7591d = 1;

    /* renamed from: e  reason: collision with root package name */
    private final ex.a f7592e = new ex.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public gy(hc hcVar, gx gxVar) {
        this.a = hcVar;
        this.b = gxVar;
    }

    public final void a(String str, String str2, double d2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        double d3;
        hc hcVar = this.a;
        synchronized (hcVar) {
            SharedPreferences.Editor a = hcVar.c.a();
            int i2 = 1;
            if (str2.equals(hcVar.c.f7625l.a())) {
                i2 = 1 + hcVar.c.m.b();
                hcVar.c.m.a(a, i2);
                d3 = hcVar.c.n.a() + d2;
                hcVar.c.n.a(a, d3);
                a.apply();
            } else {
                hcVar.c.f7625l.a(a, str2);
                hcVar.c.m.a(a, 1);
                hcVar.c.n.a(a, d2);
                hcVar.c.o.a(a);
                hcVar.c.p.a(a);
                a.apply();
                fh.a aVar = hcVar.b;
                aVar.f7537l = str2;
                aVar.o = null;
                aVar.p = null;
                d3 = d2;
            }
            hcVar.b.m = Integer.valueOf(i2);
            hcVar.b.n = Double.valueOf(d3);
        }
        ev.a a2 = a(ey.APP, FirebaseAnalytics.Event.PURCHASE);
        fd.a aVar2 = new fd.a();
        aVar2.c = str;
        if (str2 != null) {
            aVar2.f7504f = str2;
        }
        aVar2.f7503e = Double.valueOf(d2);
        if (str5 != null) {
            aVar2.m = str5;
        }
        if (str3 != null) {
            aVar2.o = str3;
        }
        if (str4 != null) {
            aVar2.p = str4;
        }
        a2.p = aVar2.b();
        a(a2);
        hc hcVar2 = this.a;
        long longValue = a2.f7442e.longValue();
        synchronized (hcVar2) {
            SharedPreferences.Editor a3 = hcVar2.c.a();
            hcVar2.c.o.a(a3, longValue);
            hcVar2.c.p.a(a3, d2);
            a3.apply();
            hcVar2.b.o = Long.valueOf(longValue);
            hcVar2.b.p = Double.valueOf(d2);
        }
    }

    public final void a(String str, String str2, String str3, String str4, Map map) {
        ev.a a = a(ey.CUSTOM, str2);
        a.t = str;
        a.u = str3;
        a.v = str4;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                a.w.add(new ez((String) entry.getKey(), (Long) entry.getValue()));
            }
        }
        a(a);
    }

    public final void a(String str, String str2, int i2, long j2, long j3, Map map) {
        ev.a a = a(ey.USAGES, str);
        a.x = str2;
        a.y = Integer.valueOf(i2);
        a.z = Long.valueOf(j2);
        a.A = Long.valueOf(j3);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                a.w.add(new ez((String) entry.getKey(), (Long) entry.getValue()));
            }
        }
        a(a);
    }

    public final ev.a a(ey eyVar, String str) {
        fb b = this.a.b();
        ev.a aVar = new ev.a();
        aVar.f7444g = hc.a;
        aVar.c = eyVar;
        aVar.f7441d = str;
        if (v.c()) {
            aVar.f7442e = Long.valueOf(v.b());
            aVar.f7443f = Long.valueOf(System.currentTimeMillis());
        } else {
            aVar.f7442e = Long.valueOf(System.currentTimeMillis());
            aVar.f7445h = Long.valueOf(SystemClock.elapsedRealtime());
        }
        aVar.f7447j = b.f7483d;
        aVar.f7448k = b.f7484e;
        aVar.f7449l = b.f7485f;
        return aVar;
    }

    public final synchronized void a(ev.a aVar) {
        if (aVar.c != ey.USAGES) {
            int i2 = this.f7591d;
            this.f7591d = i2 + 1;
            aVar.n = Integer.valueOf(i2);
            ex.a aVar2 = this.f7592e;
            if (aVar2.c != null) {
                aVar.o = aVar2.b();
            }
            ex.a aVar3 = this.f7592e;
            aVar3.c = aVar.c;
            aVar3.f7455d = aVar.f7441d;
            aVar3.f7456e = aVar.t;
        }
        gx gxVar = this.b;
        ev b = aVar.b();
        try {
            hl hlVar = gxVar.a;
            synchronized (hlVar.a) {
                try {
                    hlVar.b.add(b);
                } catch (Exception unused) {
                    hlVar.a();
                    try {
                        hlVar.b.add(b);
                    } catch (Exception unused2) {
                    }
                }
            }
            if (gxVar.b != null) {
                if (!gw.a && b.n == ey.CUSTOM) {
                    gxVar.a(false);
                    return;
                }
                gxVar.a(true);
                return;
            }
            gxVar.a.flush();
        } catch (Exception unused3) {
        }
    }
}
