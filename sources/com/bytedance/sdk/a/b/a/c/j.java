package com.bytedance.sdk.a.b.a.c;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.ac;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.s;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.a.b.z;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import us.pinguo.common.network.HttpRequest;
/* compiled from: RetryAndFollowUpInterceptor.java */
/* loaded from: classes.dex */
public final class j implements t {
    private final v a;
    private final boolean b;
    private com.bytedance.sdk.a.b.a.b.g c;

    /* renamed from: d  reason: collision with root package name */
    private Object f927d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f928e;

    public j(v vVar, boolean z) {
        this.a = vVar;
        this.b = z;
    }

    public boolean a() {
        return this.f928e;
    }

    public void a(Object obj) {
        this.f927d = obj;
    }

    @Override // com.bytedance.sdk.a.b.t
    public aa a(t.a aVar) throws IOException {
        aa a;
        y a2;
        y a3 = aVar.a();
        g gVar = (g) aVar;
        com.bytedance.sdk.a.b.e h2 = gVar.h();
        p i2 = gVar.i();
        this.c = new com.bytedance.sdk.a.b.a.b.g(this.a.o(), a(a3.a()), h2, i2, this.f927d);
        aa aaVar = null;
        int i3 = 0;
        while (!this.f928e) {
            try {
                try {
                    try {
                        a = gVar.a(a3, this.c, null, null);
                        if (aaVar != null) {
                            a = a.h().c(aaVar.h().a((ab) null).a()).a();
                        }
                        a2 = a(a);
                    } catch (IOException e2) {
                        if (!a(e2, !(e2 instanceof com.bytedance.sdk.a.b.a.e.a), a3)) {
                            throw e2;
                        }
                    }
                } catch (com.bytedance.sdk.a.b.a.b.e e3) {
                    if (!a(e3.a(), false, a3)) {
                        throw e3.a();
                    }
                }
                if (a2 == null) {
                    if (!this.b) {
                        this.c.c();
                    }
                    return a;
                }
                com.bytedance.sdk.a.b.a.c.a(a.g());
                int i4 = i3 + 1;
                if (i4 <= 20) {
                    if (!(a2.d() instanceof l)) {
                        if (!a(a, a2.a())) {
                            this.c.c();
                            this.c = new com.bytedance.sdk.a.b.a.b.g(this.a.o(), a(a2.a()), h2, i2, this.f927d);
                        } else if (this.c.a() != null) {
                            throw new IllegalStateException("Closing the body of " + a + " didn't close its backing stream. Bad interceptor?");
                        }
                        aaVar = a;
                        a3 = a2;
                        i3 = i4;
                    } else {
                        this.c.c();
                        throw new HttpRetryException("Cannot retry streamed HTTP body", a.c());
                    }
                } else {
                    this.c.c();
                    throw new ProtocolException("Too many follow-up requests: " + i4);
                }
            } catch (Throwable th) {
                this.c.a((IOException) null);
                this.c.c();
                throw th;
            }
        }
        this.c.c();
        throw new IOException("Canceled");
    }

    private com.bytedance.sdk.a.b.a a(s sVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        com.bytedance.sdk.a.b.g gVar;
        if (sVar.c()) {
            SSLSocketFactory j2 = this.a.j();
            hostnameVerifier = this.a.k();
            sSLSocketFactory = j2;
            gVar = this.a.l();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            gVar = null;
        }
        return new com.bytedance.sdk.a.b.a(sVar.f(), sVar.g(), this.a.h(), this.a.i(), sSLSocketFactory, hostnameVerifier, gVar, this.a.n(), this.a.d(), this.a.t(), this.a.u(), this.a.e());
    }

    private boolean a(IOException iOException, boolean z, y yVar) {
        this.c.a(iOException);
        if (this.a.r()) {
            return !(z && (yVar.d() instanceof l)) && a(iOException, z) && this.c.e();
        }
        return false;
    }

    private boolean a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private y a(aa aaVar) throws IOException {
        String a;
        s c;
        Proxy d2;
        if (aaVar != null) {
            com.bytedance.sdk.a.b.a.b.c b = this.c.b();
            ac a2 = b != null ? b.a() : null;
            int c2 = aaVar.c();
            String b2 = aaVar.a().b();
            if (c2 == 307 || c2 == 308) {
                if (!b2.equals("GET") && !b2.equals("HEAD")) {
                    return null;
                }
            } else if (c2 != 401) {
                if (c2 == 407) {
                    if (a2 != null) {
                        d2 = a2.b();
                    } else {
                        d2 = this.a.d();
                    }
                    if (d2.type() == Proxy.Type.HTTP) {
                        return this.a.n().a(a2, aaVar);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                } else if (c2 == 408) {
                    if (this.a.r() && !(aaVar.a().d() instanceof l)) {
                        if (aaVar.i() == null || aaVar.i().c() != 408) {
                            return aaVar.a();
                        }
                        return null;
                    }
                    return null;
                } else {
                    switch (c2) {
                        case IjkMediaCodecInfo.RANK_SECURE /* 300 */:
                        case 301:
                        case 302:
                        case 303:
                            break;
                        default:
                            return null;
                    }
                }
            } else {
                return this.a.m().a(a2, aaVar);
            }
            if (!this.a.q() || (a = aaVar.a(HttpRequest.HEADER_LOCATION)) == null || (c = aaVar.a().a().c(a)) == null) {
                return null;
            }
            if (c.b().equals(aaVar.a().a().b()) || this.a.p()) {
                y.a e2 = aaVar.a().e();
                if (f.c(b2)) {
                    boolean d3 = f.d(b2);
                    if (f.e(b2)) {
                        e2.a("GET", (z) null);
                    } else {
                        e2.a(b2, d3 ? aaVar.a().d() : null);
                    }
                    if (!d3) {
                        e2.b("Transfer-Encoding");
                        e2.b(HttpRequest.HEADER_CONTENT_LENGTH);
                        e2.b(HttpRequest.HEADER_CONTENT_TYPE);
                    }
                }
                if (!a(aaVar, c)) {
                    e2.b(HttpRequest.HEADER_AUTHORIZATION);
                }
                return e2.a(c).d();
            }
            return null;
        }
        throw new IllegalStateException();
    }

    private boolean a(aa aaVar, s sVar) {
        s a = aaVar.a().a();
        return a.f().equals(sVar.f()) && a.g() == sVar.g() && a.b().equals(sVar.b());
    }
}
