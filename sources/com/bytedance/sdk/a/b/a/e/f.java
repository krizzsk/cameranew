package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.r;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.r;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.w;
import com.bytedance.sdk.a.b.y;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import us.pinguo.common.network.HttpRequest;
/* compiled from: Http2Codec.java */
/* loaded from: classes.dex */
public final class f implements com.bytedance.sdk.a.b.a.c.c {
    private static final com.bytedance.sdk.a.a.f b;
    private static final com.bytedance.sdk.a.a.f c;

    /* renamed from: d  reason: collision with root package name */
    private static final com.bytedance.sdk.a.a.f f966d;

    /* renamed from: e  reason: collision with root package name */
    private static final com.bytedance.sdk.a.a.f f967e;

    /* renamed from: f  reason: collision with root package name */
    private static final com.bytedance.sdk.a.a.f f968f;

    /* renamed from: g  reason: collision with root package name */
    private static final com.bytedance.sdk.a.a.f f969g;

    /* renamed from: h  reason: collision with root package name */
    private static final com.bytedance.sdk.a.a.f f970h;

    /* renamed from: i  reason: collision with root package name */
    private static final com.bytedance.sdk.a.a.f f971i;

    /* renamed from: j  reason: collision with root package name */
    private static final List<com.bytedance.sdk.a.a.f> f972j;

    /* renamed from: k  reason: collision with root package name */
    private static final List<com.bytedance.sdk.a.a.f> f973k;
    final com.bytedance.sdk.a.b.a.b.g a;

    /* renamed from: l  reason: collision with root package name */
    private final v f974l;
    private final t.a m;
    private final g n;
    private i o;

    static {
        com.bytedance.sdk.a.a.f a2 = com.bytedance.sdk.a.a.f.a("connection");
        b = a2;
        com.bytedance.sdk.a.a.f a3 = com.bytedance.sdk.a.a.f.a("host");
        c = a3;
        com.bytedance.sdk.a.a.f a4 = com.bytedance.sdk.a.a.f.a("keep-alive");
        f966d = a4;
        com.bytedance.sdk.a.a.f a5 = com.bytedance.sdk.a.a.f.a("proxy-connection");
        f967e = a5;
        com.bytedance.sdk.a.a.f a6 = com.bytedance.sdk.a.a.f.a("transfer-encoding");
        f968f = a6;
        com.bytedance.sdk.a.a.f a7 = com.bytedance.sdk.a.a.f.a("te");
        f969g = a7;
        com.bytedance.sdk.a.a.f a8 = com.bytedance.sdk.a.a.f.a("encoding");
        f970h = a8;
        com.bytedance.sdk.a.a.f a9 = com.bytedance.sdk.a.a.f.a("upgrade");
        f971i = a9;
        f972j = com.bytedance.sdk.a.b.a.c.a(a2, a3, a4, a5, a7, a6, a8, a9, c.c, c.f947d, c.f948e, c.f949f);
        f973k = com.bytedance.sdk.a.b.a.c.a(a2, a3, a4, a5, a7, a6, a8, a9);
    }

    public f(v vVar, t.a aVar, com.bytedance.sdk.a.b.a.b.g gVar, g gVar2) {
        this.f974l = vVar;
        this.m = aVar;
        this.a = gVar;
        this.n = gVar2;
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public r a(y yVar, long j2) {
        return this.o.h();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void b() throws IOException {
        this.o.h().close();
    }

    public static List<c> b(y yVar) {
        com.bytedance.sdk.a.b.r c2 = yVar.c();
        ArrayList arrayList = new ArrayList(c2.a() + 4);
        arrayList.add(new c(c.c, yVar.b()));
        arrayList.add(new c(c.f947d, com.bytedance.sdk.a.b.a.c.i.a(yVar.a())));
        String a2 = yVar.a("Host");
        if (a2 != null) {
            arrayList.add(new c(c.f949f, a2));
        }
        arrayList.add(new c(c.f948e, yVar.a().b()));
        int a3 = c2.a();
        for (int i2 = 0; i2 < a3; i2++) {
            com.bytedance.sdk.a.a.f a4 = com.bytedance.sdk.a.a.f.a(c2.a(i2).toLowerCase(Locale.US));
            if (!f972j.contains(a4)) {
                arrayList.add(new c(a4, c2.b(i2)));
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void a(y yVar) throws IOException {
        if (this.o != null) {
            return;
        }
        i a2 = this.n.a(b(yVar), yVar.d() != null);
        this.o = a2;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a2.e().a(this.m.c(), timeUnit);
        this.o.f().a(this.m.d(), timeUnit);
    }

    /* compiled from: Http2Codec.java */
    /* loaded from: classes.dex */
    class a extends com.bytedance.sdk.a.a.h {
        boolean a;
        long b;

        a(s sVar) {
            super(sVar);
            this.a = false;
            this.b = 0L;
        }

        @Override // com.bytedance.sdk.a.a.h, com.bytedance.sdk.a.a.s
        public long a(com.bytedance.sdk.a.a.c cVar, long j2) throws IOException {
            try {
                long a = b().a(cVar, j2);
                if (a > 0) {
                    this.b += a;
                }
                return a;
            } catch (IOException e2) {
                a(e2);
                throw e2;
            }
        }

        @Override // com.bytedance.sdk.a.a.h, com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            a(null);
        }

        private void a(IOException iOException) {
            if (this.a) {
                return;
            }
            this.a = true;
            f fVar = f.this;
            fVar.a.a(false, (com.bytedance.sdk.a.b.a.c.c) fVar, this.b, iOException);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public void a() throws IOException {
        this.n.b();
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public aa.a a(boolean z) throws IOException {
        aa.a a2 = a(this.o.d());
        if (z && com.bytedance.sdk.a.b.a.a.a.a(a2) == 100) {
            return null;
        }
        return a2;
    }

    public static aa.a a(List<c> list) throws IOException {
        r.a aVar = new r.a();
        int size = list.size();
        com.bytedance.sdk.a.b.a.c.k kVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = list.get(i2);
            if (cVar == null) {
                if (kVar != null && kVar.b == 100) {
                    aVar = new r.a();
                    kVar = null;
                }
            } else {
                com.bytedance.sdk.a.a.f fVar = cVar.f950g;
                String a2 = cVar.f951h.a();
                if (fVar.equals(c.b)) {
                    kVar = com.bytedance.sdk.a.b.a.c.k.a("HTTP/1.1 " + a2);
                } else if (!f973k.contains(fVar)) {
                    com.bytedance.sdk.a.b.a.a.a.a(aVar, fVar.a(), a2);
                }
            }
        }
        if (kVar != null) {
            return new aa.a().a(w.HTTP_2).a(kVar.b).a(kVar.c).a(aVar.a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // com.bytedance.sdk.a.b.a.c.c
    public ab a(aa aaVar) throws IOException {
        com.bytedance.sdk.a.b.a.b.g gVar = this.a;
        gVar.c.f(gVar.b);
        return new com.bytedance.sdk.a.b.a.c.h(aaVar.a(HttpRequest.HEADER_CONTENT_TYPE), com.bytedance.sdk.a.b.a.c.e.a(aaVar), com.bytedance.sdk.a.a.l.a(new a(this.o.g())));
    }
}
