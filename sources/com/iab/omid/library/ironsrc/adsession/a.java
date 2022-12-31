package com.iab.omid.library.ironsrc.adsession;
/* loaded from: classes2.dex */
public final class a {
    private final g a;

    private a(g gVar) {
        this.a = gVar;
    }

    public static a a(b bVar) {
        g gVar = (g) bVar;
        d.d.a.a.a.g.e.c(bVar, "AdSession is null");
        d.d.a.a.a.g.e.h(gVar);
        d.d.a.a.a.g.e.f(gVar);
        a aVar = new a(gVar);
        gVar.o().d(aVar);
        return aVar;
    }

    public void b() {
        d.d.a.a.a.g.e.f(this.a);
        d.d.a.a.a.g.e.i(this.a);
        if (!this.a.k()) {
            try {
                this.a.d();
            } catch (Exception unused) {
            }
        }
        if (this.a.k()) {
            this.a.f();
        }
    }

    public void c() {
        d.d.a.a.a.g.e.g(this.a);
        d.d.a.a.a.g.e.i(this.a);
        this.a.g();
    }
}
