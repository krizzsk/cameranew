package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.aa;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.r;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* compiled from: OkHttpClient.java */
/* loaded from: classes.dex */
public class v implements Cloneable {
    static final List<w> a = com.bytedance.sdk.a.b.a.c.a(w.HTTP_2, w.HTTP_1_1);
    static final List<k> b = com.bytedance.sdk.a.b.a.c.a(k.a, k.c);
    final int A;
    final int B;
    final int C;
    final n c;

    /* renamed from: d  reason: collision with root package name */
    final Proxy f1129d;

    /* renamed from: e  reason: collision with root package name */
    final List<w> f1130e;

    /* renamed from: f  reason: collision with root package name */
    final List<k> f1131f;

    /* renamed from: g  reason: collision with root package name */
    final List<t> f1132g;

    /* renamed from: h  reason: collision with root package name */
    final List<t> f1133h;

    /* renamed from: i  reason: collision with root package name */
    final p.a f1134i;

    /* renamed from: j  reason: collision with root package name */
    final ProxySelector f1135j;

    /* renamed from: k  reason: collision with root package name */
    final m f1136k;

    /* renamed from: l  reason: collision with root package name */
    final c f1137l;
    final com.bytedance.sdk.a.b.a.a.e m;
    final SocketFactory n;
    final SSLSocketFactory o;
    final com.bytedance.sdk.a.b.a.i.c p;
    final HostnameVerifier q;
    final g r;
    final b s;
    final b t;
    final j u;
    final o v;
    final boolean w;
    final boolean x;
    final boolean y;
    final int z;

    /* compiled from: OkHttpClient.java */
    /* loaded from: classes.dex */
    public static final class a {
        int A;
        n a;
        Proxy b;
        List<w> c;

        /* renamed from: d  reason: collision with root package name */
        List<k> f1138d;

        /* renamed from: e  reason: collision with root package name */
        final List<t> f1139e;

        /* renamed from: f  reason: collision with root package name */
        final List<t> f1140f;

        /* renamed from: g  reason: collision with root package name */
        p.a f1141g;

        /* renamed from: h  reason: collision with root package name */
        ProxySelector f1142h;

        /* renamed from: i  reason: collision with root package name */
        m f1143i;

        /* renamed from: j  reason: collision with root package name */
        c f1144j;

        /* renamed from: k  reason: collision with root package name */
        com.bytedance.sdk.a.b.a.a.e f1145k;

        /* renamed from: l  reason: collision with root package name */
        SocketFactory f1146l;
        SSLSocketFactory m;
        com.bytedance.sdk.a.b.a.i.c n;
        HostnameVerifier o;
        g p;
        b q;
        b r;
        j s;
        o t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public a() {
            this.f1139e = new ArrayList();
            this.f1140f = new ArrayList();
            this.a = new n();
            this.c = v.a;
            this.f1138d = v.b;
            this.f1141g = p.a(p.a);
            this.f1142h = ProxySelector.getDefault();
            this.f1143i = m.a;
            this.f1146l = SocketFactory.getDefault();
            this.o = com.bytedance.sdk.a.b.a.i.e.a;
            this.p = g.a;
            b bVar = b.a;
            this.q = bVar;
            this.r = bVar;
            this.s = new j();
            this.t = o.a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 10000;
            this.y = 10000;
            this.z = 10000;
            this.A = 0;
        }

        public a a(long j2, TimeUnit timeUnit) {
            this.x = com.bytedance.sdk.a.b.a.c.a("timeout", j2, timeUnit);
            return this;
        }

        public a b(long j2, TimeUnit timeUnit) {
            this.y = com.bytedance.sdk.a.b.a.c.a("timeout", j2, timeUnit);
            return this;
        }

        public a c(long j2, TimeUnit timeUnit) {
            this.z = com.bytedance.sdk.a.b.a.c.a("timeout", j2, timeUnit);
            return this;
        }

        public a a(boolean z) {
            this.u = z;
            return this;
        }

        public a b(boolean z) {
            this.v = z;
            return this;
        }

        public v a() {
            return new v(this);
        }

        a(v vVar) {
            ArrayList arrayList = new ArrayList();
            this.f1139e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f1140f = arrayList2;
            this.a = vVar.c;
            this.b = vVar.f1129d;
            this.c = vVar.f1130e;
            this.f1138d = vVar.f1131f;
            arrayList.addAll(vVar.f1132g);
            arrayList2.addAll(vVar.f1133h);
            this.f1141g = vVar.f1134i;
            this.f1142h = vVar.f1135j;
            this.f1143i = vVar.f1136k;
            this.f1145k = vVar.m;
            this.f1144j = vVar.f1137l;
            this.f1146l = vVar.n;
            this.m = vVar.o;
            this.n = vVar.p;
            this.o = vVar.q;
            this.p = vVar.r;
            this.q = vVar.s;
            this.r = vVar.t;
            this.s = vVar.u;
            this.t = vVar.v;
            this.u = vVar.w;
            this.v = vVar.x;
            this.w = vVar.y;
            this.x = vVar.z;
            this.y = vVar.A;
            this.z = vVar.B;
            this.A = vVar.C;
        }
    }

    static {
        com.bytedance.sdk.a.b.a.a.a = new com.bytedance.sdk.a.b.a.a() { // from class: com.bytedance.sdk.a.b.v.1
            @Override // com.bytedance.sdk.a.b.a.a
            public void a(r.a aVar, String str) {
                aVar.a(str);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public void b(j jVar, com.bytedance.sdk.a.b.a.b.c cVar) {
                jVar.a(cVar);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public void a(r.a aVar, String str, String str2) {
                aVar.b(str, str2);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public boolean a(j jVar, com.bytedance.sdk.a.b.a.b.c cVar) {
                return jVar.b(cVar);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public com.bytedance.sdk.a.b.a.b.c a(j jVar, com.bytedance.sdk.a.b.a aVar, com.bytedance.sdk.a.b.a.b.g gVar, ac acVar) {
                return jVar.a(aVar, gVar, acVar);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public boolean a(com.bytedance.sdk.a.b.a aVar, com.bytedance.sdk.a.b.a aVar2) {
                return aVar.a(aVar2);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public Socket a(j jVar, com.bytedance.sdk.a.b.a aVar, com.bytedance.sdk.a.b.a.b.g gVar) {
                return jVar.a(aVar, gVar);
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public com.bytedance.sdk.a.b.a.b.d a(j jVar) {
                return jVar.a;
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public int a(aa.a aVar) {
                return aVar.c;
            }

            @Override // com.bytedance.sdk.a.b.a.a
            public void a(k kVar, SSLSocket sSLSocket, boolean z) {
                kVar.a(sSLSocket, z);
            }
        };
    }

    public v() {
        this(new a());
    }

    private SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw com.bytedance.sdk.a.b.a.c.a("No System TLS", (Exception) e2);
        }
    }

    private X509TrustManager z() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e2) {
            throw com.bytedance.sdk.a.b.a.c.a("No System TLS", (Exception) e2);
        }
    }

    public int b() {
        return this.A;
    }

    public int c() {
        return this.B;
    }

    public Proxy d() {
        return this.f1129d;
    }

    public ProxySelector e() {
        return this.f1135j;
    }

    public m f() {
        return this.f1136k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.a.b.a.a.e g() {
        c cVar = this.f1137l;
        return cVar != null ? cVar.a : this.m;
    }

    public o h() {
        return this.v;
    }

    public SocketFactory i() {
        return this.n;
    }

    public SSLSocketFactory j() {
        return this.o;
    }

    public HostnameVerifier k() {
        return this.q;
    }

    public g l() {
        return this.r;
    }

    public b m() {
        return this.t;
    }

    public b n() {
        return this.s;
    }

    public j o() {
        return this.u;
    }

    public boolean p() {
        return this.w;
    }

    public boolean q() {
        return this.x;
    }

    public boolean r() {
        return this.y;
    }

    public n s() {
        return this.c;
    }

    public List<w> t() {
        return this.f1130e;
    }

    public List<k> u() {
        return this.f1131f;
    }

    public List<t> v() {
        return this.f1132g;
    }

    public List<t> w() {
        return this.f1133h;
    }

    public p.a x() {
        return this.f1134i;
    }

    public a y() {
        return new a(this);
    }

    v(a aVar) {
        boolean z;
        this.c = aVar.a;
        this.f1129d = aVar.b;
        this.f1130e = aVar.c;
        List<k> list = aVar.f1138d;
        this.f1131f = list;
        this.f1132g = com.bytedance.sdk.a.b.a.c.a(aVar.f1139e);
        this.f1133h = com.bytedance.sdk.a.b.a.c.a(aVar.f1140f);
        this.f1134i = aVar.f1141g;
        this.f1135j = aVar.f1142h;
        this.f1136k = aVar.f1143i;
        this.f1137l = aVar.f1144j;
        this.m = aVar.f1145k;
        this.n = aVar.f1146l;
        loop0: while (true) {
            for (k kVar : list) {
                z = z || kVar.a();
            }
        }
        SSLSocketFactory sSLSocketFactory = aVar.m;
        if (sSLSocketFactory == null && z) {
            X509TrustManager z2 = z();
            this.o = a(z2);
            this.p = com.bytedance.sdk.a.b.a.i.c.a(z2);
        } else {
            this.o = sSLSocketFactory;
            this.p = aVar.n;
        }
        this.q = aVar.o;
        this.r = aVar.p.a(this.p);
        this.s = aVar.q;
        this.t = aVar.r;
        this.u = aVar.s;
        this.v = aVar.t;
        this.w = aVar.u;
        this.x = aVar.v;
        this.y = aVar.w;
        this.z = aVar.x;
        this.A = aVar.y;
        this.B = aVar.z;
        this.C = aVar.A;
        if (!this.f1132g.contains(null)) {
            if (this.f1133h.contains(null)) {
                throw new IllegalStateException("Null network interceptor: " + this.f1133h);
            }
            return;
        }
        throw new IllegalStateException("Null interceptor: " + this.f1132g);
    }

    public int a() {
        return this.z;
    }

    public e a(y yVar) {
        return x.a(this, yVar, false);
    }
}
