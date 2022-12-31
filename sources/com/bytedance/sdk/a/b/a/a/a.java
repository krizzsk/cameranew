package com.bytedance.sdk.a.b.a.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.b.a.a.c;
import com.bytedance.sdk.a.b.a.c.f;
import com.bytedance.sdk.a.b.a.c.h;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.w;
import com.bytedance.sdk.a.b.y;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import us.pinguo.common.network.HttpRequest;
/* compiled from: CacheInterceptor.java */
/* loaded from: classes.dex */
public final class a implements t {
    final e a;

    public a(e eVar) {
        this.a = eVar;
    }

    @Override // com.bytedance.sdk.a.b.t
    public aa a(t.a aVar) throws IOException {
        e eVar = this.a;
        aa a = eVar != null ? eVar.a(aVar.a()) : null;
        c a2 = new c.a(System.currentTimeMillis(), aVar.a(), a).a();
        y yVar = a2.a;
        aa aaVar = a2.b;
        e eVar2 = this.a;
        if (eVar2 != null) {
            eVar2.a(a2);
        }
        if (a != null && aaVar == null) {
            com.bytedance.sdk.a.b.a.c.a(a.g());
        }
        if (yVar == null && aaVar == null) {
            return new aa.a().a(aVar.a()).a(w.HTTP_1_1).a(TypedValues.PositionType.TYPE_PERCENT_HEIGHT).a("Unsatisfiable Request (only-if-cached)").a(com.bytedance.sdk.a.b.a.c.c).a(-1L).b(System.currentTimeMillis()).a();
        }
        if (yVar == null) {
            return aaVar.h().b(a(aaVar)).a();
        }
        try {
            aa a3 = aVar.a(yVar);
            if (a3 == null && a != null) {
            }
            if (aaVar != null) {
                if (a3.c() == 304) {
                    aa a4 = aaVar.h().a(a(aaVar.f(), a3.f())).a(a3.k()).b(a3.l()).b(a(aaVar)).a(a(a3)).a();
                    a3.g().close();
                    this.a.a();
                    this.a.a(aaVar, a4);
                    return a4;
                }
                com.bytedance.sdk.a.b.a.c.a(aaVar.g());
            }
            aa a5 = a3.h().b(a(aaVar)).a(a(a3)).a();
            if (this.a != null) {
                if (com.bytedance.sdk.a.b.a.c.e.b(a5) && c.a(a5, yVar)) {
                    return a(this.a.a(a5), a5);
                }
                if (f.a(yVar.b())) {
                    try {
                        this.a.b(yVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return a5;
        } finally {
            if (a != null) {
                com.bytedance.sdk.a.b.a.c.a(a.g());
            }
        }
    }

    private static aa a(aa aaVar) {
        return (aaVar == null || aaVar.g() == null) ? aaVar : aaVar.h().a((ab) null).a();
    }

    private aa a(final b bVar, aa aaVar) throws IOException {
        r a;
        if (bVar == null || (a = bVar.a()) == null) {
            return aaVar;
        }
        final com.bytedance.sdk.a.a.e c = aaVar.g().c();
        final com.bytedance.sdk.a.a.d a2 = l.a(a);
        return aaVar.h().a(new h(aaVar.a(HttpRequest.HEADER_CONTENT_TYPE), aaVar.g().a(), l.a(new s() { // from class: com.bytedance.sdk.a.b.a.a.a.1
            boolean a;

            @Override // com.bytedance.sdk.a.a.s
            public long a(com.bytedance.sdk.a.a.c cVar, long j2) throws IOException {
                try {
                    long a3 = c.a(cVar, j2);
                    if (a3 == -1) {
                        if (!this.a) {
                            this.a = true;
                            a2.close();
                        }
                        return -1L;
                    }
                    cVar.a(a2.c(), cVar.b() - a3, a3);
                    a2.u();
                    return a3;
                } catch (IOException e2) {
                    if (!this.a) {
                        this.a = true;
                        bVar.b();
                    }
                    throw e2;
                }
            }

            @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.a && !com.bytedance.sdk.a.b.a.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                    this.a = true;
                    bVar.b();
                }
                c.close();
            }

            @Override // com.bytedance.sdk.a.a.s
            public com.bytedance.sdk.a.a.t a() {
                return c.a();
            }
        }))).a();
    }

    private static com.bytedance.sdk.a.b.r a(com.bytedance.sdk.a.b.r rVar, com.bytedance.sdk.a.b.r rVar2) {
        r.a aVar = new r.a();
        int a = rVar.a();
        for (int i2 = 0; i2 < a; i2++) {
            String a2 = rVar.a(i2);
            String b = rVar.b(i2);
            if ((!"Warning".equalsIgnoreCase(a2) || !b.startsWith("1")) && (!a(a2) || rVar2.a(a2) == null)) {
                com.bytedance.sdk.a.b.a.a.a.a(aVar, a2, b);
            }
        }
        int a3 = rVar2.a();
        for (int i3 = 0; i3 < a3; i3++) {
            String a4 = rVar2.a(i3);
            if (!HttpRequest.HEADER_CONTENT_LENGTH.equalsIgnoreCase(a4) && a(a4)) {
                com.bytedance.sdk.a.b.a.a.a.a(aVar, a4, rVar2.b(i3));
            }
        }
        return aVar.a();
    }

    static boolean a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
