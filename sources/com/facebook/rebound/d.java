package com.facebook.rebound;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
/* compiled from: Spring.java */
/* loaded from: classes9.dex */
public class d {
    private static int o;
    private e a;
    private boolean b;
    private final String c;

    /* renamed from: g  reason: collision with root package name */
    private double f3150g;

    /* renamed from: h  reason: collision with root package name */
    private double f3151h;
    private final com.facebook.rebound.a n;

    /* renamed from: d  reason: collision with root package name */
    private final b f3147d = new b();

    /* renamed from: e  reason: collision with root package name */
    private final b f3148e = new b();

    /* renamed from: f  reason: collision with root package name */
    private final b f3149f = new b();

    /* renamed from: i  reason: collision with root package name */
    private boolean f3152i = true;

    /* renamed from: j  reason: collision with root package name */
    private double f3153j = 0.005d;

    /* renamed from: k  reason: collision with root package name */
    private double f3154k = 0.005d;

    /* renamed from: l  reason: collision with root package name */
    private CopyOnWriteArraySet<f> f3155l = new CopyOnWriteArraySet<>();
    private double m = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Spring.java */
    /* loaded from: classes9.dex */
    public static class b {
        double a;
        double b;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.facebook.rebound.a aVar) {
        if (aVar != null) {
            this.n = aVar;
            StringBuilder sb = new StringBuilder();
            sb.append("spring:");
            int i2 = o;
            o = i2 + 1;
            sb.append(i2);
            this.c = sb.toString();
            n(e.c);
            return;
        }
        throw new IllegalArgumentException("Spring cannot be created outside of a BaseSpringSystem");
    }

    private double d(b bVar) {
        return Math.abs(this.f3151h - bVar.a);
    }

    private void f(double d2) {
        b bVar = this.f3147d;
        b bVar2 = this.f3148e;
        double d3 = 1.0d - d2;
        bVar.a = (bVar.a * d2) + (bVar2.a * d3);
        bVar.b = (bVar.b * d2) + (bVar2.b * d3);
    }

    public d a(f fVar) {
        if (fVar != null) {
            this.f3155l.add(fVar);
            return this;
        }
        throw new IllegalArgumentException("newListener is required");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(double d2) {
        double d3;
        boolean z;
        boolean z2;
        boolean g2 = g();
        if (g2 && this.f3152i) {
            return;
        }
        this.m += d2 <= 0.064d ? d2 : 0.064d;
        e eVar = this.a;
        double d4 = eVar.b;
        double d5 = eVar.a;
        b bVar = this.f3147d;
        double d6 = bVar.a;
        double d7 = bVar.b;
        b bVar2 = this.f3149f;
        double d8 = bVar2.a;
        double d9 = bVar2.b;
        while (true) {
            d3 = this.m;
            if (d3 < 0.001d) {
                break;
            }
            double d10 = d3 - 0.001d;
            this.m = d10;
            if (d10 < 0.001d) {
                b bVar3 = this.f3148e;
                bVar3.a = d6;
                bVar3.b = d7;
            }
            double d11 = this.f3151h;
            double d12 = ((d11 - d8) * d4) - (d5 * d7);
            double d13 = d7 + (d12 * 0.001d * 0.5d);
            double d14 = ((d11 - (((d7 * 0.001d) * 0.5d) + d6)) * d4) - (d5 * d13);
            double d15 = d7 + (d14 * 0.001d * 0.5d);
            double d16 = ((d11 - (d6 + ((d13 * 0.001d) * 0.5d))) * d4) - (d5 * d15);
            double d17 = d6 + (d15 * 0.001d);
            double d18 = d7 + (d16 * 0.001d);
            d6 += (d7 + ((d13 + d15) * 2.0d) + d18) * 0.16666666666666666d * 0.001d;
            d7 += (d12 + ((d14 + d16) * 2.0d) + (((d11 - d17) * d4) - (d5 * d18))) * 0.16666666666666666d * 0.001d;
            d8 = d17;
            d9 = d18;
        }
        b bVar4 = this.f3149f;
        bVar4.a = d8;
        bVar4.b = d9;
        b bVar5 = this.f3147d;
        bVar5.a = d6;
        bVar5.b = d7;
        if (d3 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            f(d3 / 0.001d);
        }
        boolean z3 = true;
        if (g() || (this.b && h())) {
            double d19 = this.f3151h;
            this.f3150g = d19;
            this.f3147d.a = d19;
            o(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            z = true;
        } else {
            z = g2;
        }
        if (this.f3152i) {
            this.f3152i = false;
            z2 = true;
        } else {
            z2 = false;
        }
        if (z) {
            this.f3152i = true;
        } else {
            z3 = false;
        }
        Iterator<f> it = this.f3155l.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (z2) {
                next.c(this);
            }
            next.a(this);
            if (z3) {
                next.d(this);
            }
        }
    }

    public double c() {
        return this.f3147d.a;
    }

    public String e() {
        return this.c;
    }

    public boolean g() {
        return Math.abs(this.f3147d.b) <= this.f3153j && d(this.f3147d) <= this.f3154k;
    }

    public boolean h() {
        return (this.f3150g < this.f3151h && c() > this.f3151h) || (this.f3150g > this.f3151h && c() < this.f3151h);
    }

    public d i() {
        this.f3155l.clear();
        return this;
    }

    public d j() {
        b bVar = this.f3147d;
        double d2 = bVar.a;
        this.f3151h = d2;
        this.f3149f.a = d2;
        bVar.b = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        return this;
    }

    public d k(double d2) {
        this.f3150g = d2;
        this.f3147d.a = d2;
        this.n.a(e());
        Iterator<f> it = this.f3155l.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        return this;
    }

    public d l(double d2) {
        if (this.f3151h == d2 && g()) {
            return this;
        }
        this.f3150g = c();
        this.f3151h = d2;
        this.n.a(e());
        Iterator<f> it = this.f3155l.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
        return this;
    }

    public d m(boolean z) {
        this.b = z;
        return this;
    }

    public d n(e eVar) {
        if (eVar != null) {
            this.a = eVar;
            return this;
        }
        throw new IllegalArgumentException("springConfig is required");
    }

    public d o(double d2) {
        this.f3147d.b = d2;
        this.n.a(e());
        return this;
    }

    public boolean p() {
        return (g() && q()) ? false : true;
    }

    public boolean q() {
        return this.f3152i;
    }
}
