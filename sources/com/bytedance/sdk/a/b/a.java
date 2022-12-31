package com.bytedance.sdk.a.b;

import com.bytedance.sdk.a.b.s;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
/* compiled from: Address.java */
/* loaded from: classes.dex */
public final class a {
    final s a;
    final o b;
    final SocketFactory c;

    /* renamed from: d  reason: collision with root package name */
    final b f853d;

    /* renamed from: e  reason: collision with root package name */
    final List<w> f854e;

    /* renamed from: f  reason: collision with root package name */
    final List<k> f855f;

    /* renamed from: g  reason: collision with root package name */
    final ProxySelector f856g;

    /* renamed from: h  reason: collision with root package name */
    final Proxy f857h;

    /* renamed from: i  reason: collision with root package name */
    final SSLSocketFactory f858i;

    /* renamed from: j  reason: collision with root package name */
    final HostnameVerifier f859j;

    /* renamed from: k  reason: collision with root package name */
    final g f860k;

    public a(String str, int i2, o oVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g gVar, b bVar, Proxy proxy, List<w> list, List<k> list2, ProxySelector proxySelector) {
        this.a = new s.a().a(sSLSocketFactory != null ? "https" : "http").d(str).a(i2).c();
        Objects.requireNonNull(oVar, "dns == null");
        this.b = oVar;
        Objects.requireNonNull(socketFactory, "socketFactory == null");
        this.c = socketFactory;
        Objects.requireNonNull(bVar, "proxyAuthenticator == null");
        this.f853d = bVar;
        Objects.requireNonNull(list, "protocols == null");
        this.f854e = com.bytedance.sdk.a.b.a.c.a(list);
        Objects.requireNonNull(list2, "connectionSpecs == null");
        this.f855f = com.bytedance.sdk.a.b.a.c.a(list2);
        Objects.requireNonNull(proxySelector, "proxySelector == null");
        this.f856g = proxySelector;
        this.f857h = proxy;
        this.f858i = sSLSocketFactory;
        this.f859j = hostnameVerifier;
        this.f860k = gVar;
    }

    public s a() {
        return this.a;
    }

    public o b() {
        return this.b;
    }

    public SocketFactory c() {
        return this.c;
    }

    public b d() {
        return this.f853d;
    }

    public List<w> e() {
        return this.f854e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.a.equals(aVar.a) && a(aVar)) {
                return true;
            }
        }
        return false;
    }

    public List<k> f() {
        return this.f855f;
    }

    public ProxySelector g() {
        return this.f856g;
    }

    public Proxy h() {
        return this.f857h;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.f853d.hashCode()) * 31) + this.f854e.hashCode()) * 31) + this.f855f.hashCode()) * 31) + this.f856g.hashCode()) * 31;
        Proxy proxy = this.f857h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f858i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f859j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        g gVar = this.f860k;
        return hashCode4 + (gVar != null ? gVar.hashCode() : 0);
    }

    public SSLSocketFactory i() {
        return this.f858i;
    }

    public HostnameVerifier j() {
        return this.f859j;
    }

    public g k() {
        return this.f860k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.a.f());
        sb.append(":");
        sb.append(this.a.g());
        if (this.f857h != null) {
            sb.append(", proxy=");
            sb.append(this.f857h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f856g);
        }
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(a aVar) {
        return this.b.equals(aVar.b) && this.f853d.equals(aVar.f853d) && this.f854e.equals(aVar.f854e) && this.f855f.equals(aVar.f855f) && this.f856g.equals(aVar.f856g) && com.bytedance.sdk.a.b.a.c.a(this.f857h, aVar.f857h) && com.bytedance.sdk.a.b.a.c.a(this.f858i, aVar.f858i) && com.bytedance.sdk.a.b.a.c.a(this.f859j, aVar.f859j) && com.bytedance.sdk.a.b.a.c.a(this.f860k, aVar.f860k) && a().g() == aVar.a().g();
    }
}
