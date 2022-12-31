package com.bytedance.sdk.a.b.a.b;

import androidx.core.location.LocationRequestCompat;
import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.b.a.e.g;
import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ac;
import com.bytedance.sdk.a.b.i;
import com.bytedance.sdk.a.b.j;
import com.bytedance.sdk.a.b.k;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.q;
import com.bytedance.sdk.a.b.s;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.w;
import com.bytedance.sdk.a.b.y;
import com.tapjoy.TJAdUnitConstants;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import us.pinguo.common.network.HttpRequest;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: RealConnection.java */
/* loaded from: classes.dex */
public final class c extends g.b implements i {
    public boolean a;
    public int b;
    public int c = 1;

    /* renamed from: d  reason: collision with root package name */
    public final List<Reference<g>> f887d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public long f888e = LocationRequestCompat.PASSIVE_INTERVAL;

    /* renamed from: g  reason: collision with root package name */
    private final j f889g;

    /* renamed from: h  reason: collision with root package name */
    private final ac f890h;

    /* renamed from: i  reason: collision with root package name */
    private Socket f891i;

    /* renamed from: j  reason: collision with root package name */
    private Socket f892j;

    /* renamed from: k  reason: collision with root package name */
    private q f893k;

    /* renamed from: l  reason: collision with root package name */
    private w f894l;
    private com.bytedance.sdk.a.b.a.e.g m;
    private com.bytedance.sdk.a.a.e n;
    private com.bytedance.sdk.a.a.d o;

    public c(j jVar, ac acVar) {
        this.f889g = jVar;
        this.f890h = acVar;
    }

    private y e() {
        return new y.a().a(this.f890h.a().a()).a("Host", com.bytedance.sdk.a.b.a.c.a(this.f890h.a().a(), true)).a("Proxy-Connection", "Keep-Alive").a(HttpRequest.HEADER_USER_AGENT, com.bytedance.sdk.a.b.a.d.a()).d();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007d A[Catch: IOException -> 0x00e1, TRY_LEAVE, TryCatch #0 {IOException -> 0x00e1, blocks: (B:16:0x0075, B:18:0x007d), top: B:58:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r16, int r17, int r18, boolean r19, com.bytedance.sdk.a.b.e r20, com.bytedance.sdk.a.b.p r21) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.b.a.b.c.a(int, int, int, boolean, com.bytedance.sdk.a.b.e, com.bytedance.sdk.a.b.p):void");
    }

    public Socket b() {
        return this.f892j;
    }

    public q c() {
        return this.f893k;
    }

    public boolean d() {
        return this.m != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f890h.a().a().f());
        sb.append(":");
        sb.append(this.f890h.a().a().g());
        sb.append(", proxy=");
        sb.append(this.f890h.b());
        sb.append(" hostAddress=");
        sb.append(this.f890h.c());
        sb.append(" cipherSuite=");
        q qVar = this.f893k;
        sb.append(qVar != null ? qVar.a() : PortalFollowFeeds.TYPE_NONE);
        sb.append(" protocol=");
        sb.append(this.f894l);
        sb.append('}');
        return sb.toString();
    }

    private void a(int i2, int i3, int i4, com.bytedance.sdk.a.b.e eVar, p pVar) throws IOException {
        y e2 = e();
        s a = e2.a();
        for (int i5 = 0; i5 < 21; i5++) {
            a(i2, i3, eVar, pVar);
            e2 = a(i3, i4, e2, a);
            if (e2 == null) {
                return;
            }
            com.bytedance.sdk.a.b.a.c.a(this.f891i);
            this.f891i = null;
            this.o = null;
            this.n = null;
            pVar.a(eVar, this.f890h.c(), this.f890h.b(), null);
        }
    }

    private void a(int i2, int i3, com.bytedance.sdk.a.b.e eVar, p pVar) throws IOException {
        Proxy b = this.f890h.b();
        this.f891i = (b.type() == Proxy.Type.DIRECT || b.type() == Proxy.Type.HTTP) ? this.f890h.a().c().createSocket() : new Socket(b);
        pVar.a(eVar, this.f890h.c(), b);
        this.f891i.setSoTimeout(i3);
        try {
            com.bytedance.sdk.a.b.a.g.e.b().a(this.f891i, this.f890h.c(), i2);
            try {
                this.n = l.a(l.b(this.f891i));
                this.o = l.a(l.a(this.f891i));
            } catch (NullPointerException e2) {
                if ("throw with null exception".equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f890h.c());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    private void a(b bVar, com.bytedance.sdk.a.b.e eVar, p pVar) throws IOException {
        if (this.f890h.a().i() == null) {
            this.f894l = w.HTTP_1_1;
            this.f892j = this.f891i;
            return;
        }
        pVar.b(eVar);
        a(bVar);
        pVar.a(eVar, this.f893k);
        if (this.f894l == w.HTTP_2) {
            this.f892j.setSoTimeout(0);
            com.bytedance.sdk.a.b.a.e.g a = new g.a(true).a(this.f892j, this.f890h.a().a().f(), this.n, this.o).a(this).a();
            this.m = a;
            a.c();
        }
    }

    private void a(b bVar) throws IOException {
        SSLSocket sSLSocket;
        com.bytedance.sdk.a.b.a a = this.f890h.a();
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) a.i().createSocket(this.f891i, a.a().f(), a.a().g(), true);
            } catch (AssertionError e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            k a2 = bVar.a(sSLSocket);
            if (a2.d()) {
                com.bytedance.sdk.a.b.a.g.e.b().a(sSLSocket, a.a().f(), a.e());
            }
            sSLSocket.startHandshake();
            q a3 = q.a(sSLSocket.getSession());
            if (a.j().verify(a.a().f(), sSLSocket.getSession())) {
                a.k().a(a.a().f(), a3.b());
                String a4 = a2.d() ? com.bytedance.sdk.a.b.a.g.e.b().a(sSLSocket) : null;
                this.f892j = sSLSocket;
                this.n = l.a(l.b(sSLSocket));
                this.o = l.a(l.a(this.f892j));
                this.f893k = a3;
                this.f894l = a4 != null ? w.a(a4) : w.HTTP_1_1;
                if (sSLSocket != null) {
                    com.bytedance.sdk.a.b.a.g.e.b().b(sSLSocket);
                    return;
                }
                return;
            }
            X509Certificate x509Certificate = (X509Certificate) a3.b().get(0);
            throw new SSLPeerUnverifiedException("Hostname " + a.a().f() + " not verified:\n    certificate: " + com.bytedance.sdk.a.b.g.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.bytedance.sdk.a.b.a.i.e.a(x509Certificate));
        } catch (AssertionError e3) {
            e = e3;
            if (!com.bytedance.sdk.a.b.a.c.a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                com.bytedance.sdk.a.b.a.g.e.b().b(sSLSocket2);
            }
            com.bytedance.sdk.a.b.a.c.a((Socket) sSLSocket2);
            throw th;
        }
    }

    private y a(int i2, int i3, y yVar, s sVar) throws IOException {
        String str = "CONNECT " + com.bytedance.sdk.a.b.a.c.a(sVar, true) + " HTTP/1.1";
        while (true) {
            com.bytedance.sdk.a.b.a.d.a aVar = new com.bytedance.sdk.a.b.a.d.a(null, null, this.n, this.o);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.n.a().a(i2, timeUnit);
            this.o.a().a(i3, timeUnit);
            aVar.a(yVar.c(), str);
            aVar.b();
            aa a = aVar.a(false).a(yVar).a();
            long a2 = com.bytedance.sdk.a.b.a.c.e.a(a);
            if (a2 == -1) {
                a2 = 0;
            }
            com.bytedance.sdk.a.a.s b = aVar.b(a2);
            com.bytedance.sdk.a.b.a.c.b(b, Integer.MAX_VALUE, timeUnit);
            b.close();
            int c = a.c();
            if (c == 200) {
                if (this.n.c().e() && this.o.c().e()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else if (c == 407) {
                y a3 = this.f890h.a().d().a(this.f890h, a);
                if (a3 != null) {
                    if (TJAdUnitConstants.String.CLOSE.equalsIgnoreCase(a.a("Connection"))) {
                        return a3;
                    }
                    yVar = a3;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + a.c());
            }
        }
    }

    public boolean a(com.bytedance.sdk.a.b.a aVar, ac acVar) {
        if (this.f887d.size() >= this.c || this.a || !com.bytedance.sdk.a.b.a.a.a.a(this.f890h.a(), aVar)) {
            return false;
        }
        if (aVar.a().f().equals(a().a().a().f())) {
            return true;
        }
        if (this.m != null && acVar != null && acVar.b().type() == Proxy.Type.DIRECT && this.f890h.b().type() == Proxy.Type.DIRECT && this.f890h.c().equals(acVar.c()) && acVar.a().j() == com.bytedance.sdk.a.b.a.i.e.a && a(aVar.a())) {
            try {
                aVar.k().a(aVar.a().f(), c().b());
                return true;
            } catch (SSLPeerUnverifiedException unused) {
                return false;
            }
        }
        return false;
    }

    public boolean a(s sVar) {
        if (sVar.g() != this.f890h.a().a().g()) {
            return false;
        }
        if (sVar.f().equals(this.f890h.a().a().f())) {
            return true;
        }
        return this.f893k != null && com.bytedance.sdk.a.b.a.i.e.a.a(sVar.f(), (X509Certificate) this.f893k.b().get(0));
    }

    public com.bytedance.sdk.a.b.a.c.c a(v vVar, t.a aVar, g gVar) throws SocketException {
        if (this.m != null) {
            return new com.bytedance.sdk.a.b.a.e.f(vVar, aVar, gVar, this.m);
        }
        this.f892j.setSoTimeout(aVar.c());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.n.a().a(aVar.c(), timeUnit);
        this.o.a().a(aVar.d(), timeUnit);
        return new com.bytedance.sdk.a.b.a.d.a(vVar, gVar, this.n, this.o);
    }

    @Override // com.bytedance.sdk.a.b.i
    public ac a() {
        return this.f890h;
    }

    public boolean a(boolean z) {
        if (this.f892j.isClosed() || this.f892j.isInputShutdown() || this.f892j.isOutputShutdown()) {
            return false;
        }
        com.bytedance.sdk.a.b.a.e.g gVar = this.m;
        if (gVar != null) {
            return !gVar.d();
        }
        if (z) {
            try {
                int soTimeout = this.f892j.getSoTimeout();
                try {
                    this.f892j.setSoTimeout(1);
                    return !this.n.e();
                } finally {
                    this.f892j.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.a.b.a.e.g.b
    public void a(com.bytedance.sdk.a.b.a.e.i iVar) throws IOException {
        iVar.a(com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM);
    }

    @Override // com.bytedance.sdk.a.b.a.e.g.b
    public void a(com.bytedance.sdk.a.b.a.e.g gVar) {
        synchronized (this.f889g) {
            this.c = gVar.a();
        }
    }
}
