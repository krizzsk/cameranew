package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.b.ac;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.s;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
/* compiled from: RouteSelector.java */
/* loaded from: classes.dex */
public final class f {
    private final com.bytedance.sdk.a.b.a a;
    private final d b;
    private final com.bytedance.sdk.a.b.e c;

    /* renamed from: d  reason: collision with root package name */
    private final p f895d;

    /* renamed from: f  reason: collision with root package name */
    private int f897f;

    /* renamed from: e  reason: collision with root package name */
    private List<Proxy> f896e = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    private List<InetSocketAddress> f898g = Collections.emptyList();

    /* renamed from: h  reason: collision with root package name */
    private final List<ac> f899h = new ArrayList();

    /* compiled from: RouteSelector.java */
    /* loaded from: classes.dex */
    public static final class a {
        private final List<ac> a;
        private int b = 0;

        a(List<ac> list) {
            this.a = list;
        }

        public boolean a() {
            return this.b < this.a.size();
        }

        public ac b() {
            if (a()) {
                List<ac> list = this.a;
                int i2 = this.b;
                this.b = i2 + 1;
                return list.get(i2);
            }
            throw new NoSuchElementException();
        }

        public List<ac> c() {
            return new ArrayList(this.a);
        }
    }

    public f(com.bytedance.sdk.a.b.a aVar, d dVar, com.bytedance.sdk.a.b.e eVar, p pVar) {
        this.a = aVar;
        this.b = dVar;
        this.c = eVar;
        this.f895d = pVar;
        a(aVar.a(), aVar.h());
    }

    private boolean c() {
        return this.f897f < this.f896e.size();
    }

    private Proxy d() throws IOException {
        if (c()) {
            List<Proxy> list = this.f896e;
            int i2 = this.f897f;
            this.f897f = i2 + 1;
            Proxy proxy = list.get(i2);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.a.a().f() + "; exhausted proxy configurations: " + this.f896e);
    }

    public boolean a() {
        return c() || !this.f899h.isEmpty();
    }

    public a b() throws IOException {
        if (a()) {
            ArrayList arrayList = new ArrayList();
            while (c()) {
                Proxy d2 = d();
                int size = this.f898g.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ac acVar = new ac(this.a, d2, this.f898g.get(i2));
                    if (this.b.c(acVar)) {
                        this.f899h.add(acVar);
                    } else {
                        arrayList.add(acVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f899h);
                this.f899h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }

    public void a(ac acVar, IOException iOException) {
        if (acVar.b().type() != Proxy.Type.DIRECT && this.a.g() != null) {
            this.a.g().connectFailed(this.a.a().a(), acVar.b().address(), iOException);
        }
        this.b.a(acVar);
    }

    private void a(s sVar, Proxy proxy) {
        List<Proxy> a2;
        if (proxy != null) {
            this.f896e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.a.g().select(sVar.a());
            if (select != null && !select.isEmpty()) {
                a2 = com.bytedance.sdk.a.b.a.c.a(select);
            } else {
                a2 = com.bytedance.sdk.a.b.a.c.a(Proxy.NO_PROXY);
            }
            this.f896e = a2;
        }
        this.f897f = 0;
    }

    private void a(Proxy proxy) throws IOException {
        String f2;
        int g2;
        this.f898g = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                f2 = a(inetSocketAddress);
                g2 = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        } else {
            f2 = this.a.a().f();
            g2 = this.a.a().g();
        }
        if (g2 >= 1 && g2 <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f898g.add(InetSocketAddress.createUnresolved(f2, g2));
                return;
            }
            this.f895d.a(this.c, f2);
            List<InetAddress> a2 = this.a.b().a(f2);
            if (!a2.isEmpty()) {
                this.f895d.a(this.c, f2, a2);
                int size = a2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f898g.add(new InetSocketAddress(a2.get(i2), g2));
                }
                return;
            }
            throw new UnknownHostException(this.a.b() + " returned no addresses for " + f2);
        }
        throw new SocketException("No route to " + f2 + ":" + g2 + "; port is out of range");
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
