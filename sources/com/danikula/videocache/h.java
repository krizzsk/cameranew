package com.danikula.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
/* compiled from: IgnoreHostProxySelector.java */
/* loaded from: classes.dex */
class h extends ProxySelector {

    /* renamed from: d  reason: collision with root package name */
    private static final List<Proxy> f2227d = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector a;
    private final String b;
    private final int c;

    h(ProxySelector proxySelector, String str, int i2) {
        j.d(proxySelector);
        this.a = proxySelector;
        j.d(str);
        this.b = str;
        this.c = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, int i2) {
        ProxySelector.setDefault(new h(ProxySelector.getDefault(), str, i2));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.a.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return this.b.equals(uri.getHost()) && this.c == uri.getPort() ? f2227d : this.a.select(uri);
    }
}
