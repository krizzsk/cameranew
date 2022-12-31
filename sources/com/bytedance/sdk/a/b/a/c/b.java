package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.y;
import com.tapjoy.TJAdUnitConstants;
import java.io.IOException;
import java.net.ProtocolException;
/* compiled from: CallServerInterceptor.java */
/* loaded from: classes.dex */
public final class b implements t {
    private final boolean a;

    /* compiled from: CallServerInterceptor.java */
    /* loaded from: classes.dex */
    static final class a extends com.bytedance.sdk.a.a.g {
        long a;

        a(r rVar) {
            super(rVar);
        }

        @Override // com.bytedance.sdk.a.a.g, com.bytedance.sdk.a.a.r
        public void a_(com.bytedance.sdk.a.a.c cVar, long j2) throws IOException {
            super.a_(cVar, j2);
            this.a += j2;
        }
    }

    public b(boolean z) {
        this.a = z;
    }

    @Override // com.bytedance.sdk.a.b.t
    public aa a(t.a aVar) throws IOException {
        aa a2;
        g gVar = (g) aVar;
        c g2 = gVar.g();
        com.bytedance.sdk.a.b.a.b.g f2 = gVar.f();
        com.bytedance.sdk.a.b.a.b.c cVar = (com.bytedance.sdk.a.b.a.b.c) gVar.e();
        y a3 = gVar.a();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.i().c(gVar.h());
        g2.a(a3);
        gVar.i().a(gVar.h(), a3);
        aa.a aVar2 = null;
        if (f.c(a3.b()) && a3.d() != null) {
            if ("100-continue".equalsIgnoreCase(a3.a("Expect"))) {
                g2.a();
                gVar.i().e(gVar.h());
                aVar2 = g2.a(true);
            }
            if (aVar2 == null) {
                gVar.i().d(gVar.h());
                a aVar3 = new a(g2.a(a3, a3.d().b()));
                com.bytedance.sdk.a.a.d a4 = com.bytedance.sdk.a.a.l.a(aVar3);
                a3.d().a(a4);
                a4.close();
                gVar.i().a(gVar.h(), aVar3.a);
            } else if (!cVar.d()) {
                f2.d();
            }
        }
        g2.b();
        if (aVar2 == null) {
            gVar.i().e(gVar.h());
            aVar2 = g2.a(false);
        }
        aa a5 = aVar2.a(a3).a(f2.b().c()).a(currentTimeMillis).b(System.currentTimeMillis()).a();
        gVar.i().a(gVar.h(), a5);
        int c = a5.c();
        if (this.a && c == 101) {
            a2 = a5.h().a(com.bytedance.sdk.a.b.a.c.c).a();
        } else {
            a2 = a5.h().a(g2.a(a5)).a();
        }
        if (TJAdUnitConstants.String.CLOSE.equalsIgnoreCase(a2.a().a("Connection")) || TJAdUnitConstants.String.CLOSE.equalsIgnoreCase(a2.a("Connection"))) {
            f2.d();
        }
        if ((c == 204 || c == 205) && a2.g().a() > 0) {
            throw new ProtocolException("HTTP " + c + " had non-zero Content-Length: " + a2.g().a());
        }
        return a2;
    }
}
