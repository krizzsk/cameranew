package com.bytedance.sdk.openadsdk.h;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;
/* compiled from: SkipProxySelector.java */
/* loaded from: classes.dex */
class j extends ProxySelector {
    private static final List<Proxy> a = Collections.singletonList(Proxy.NO_PROXY);
    private final ProxySelector b = ProxySelector.getDefault();
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2067d;

    private j(String str, int i2) {
        this.c = str;
        this.f2067d = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, int i2) {
        ProxySelector.setDefault(new j(str, i2));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return (this.c.equalsIgnoreCase(uri.getHost()) && this.f2067d == uri.getPort()) ? a : this.b.select(uri);
        }
        throw new IllegalArgumentException("URI can't be null");
    }
}
