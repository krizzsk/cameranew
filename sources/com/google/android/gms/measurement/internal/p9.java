package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
final class p9 extends SSLSocketFactory {
    private final SSLSocketFactory a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p9(SSLSocketFactory sSLSocketFactory) {
        this.a = sSLSocketFactory;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() throws IOException {
        return new o9(this, (SSLSocket) this.a.createSocket());
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.a.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i2) throws IOException {
        return new o9(this, (SSLSocket) this.a.createSocket(str, i2));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        return new o9(this, (SSLSocket) this.a.createSocket(str, i2, inetAddress, i3));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return new o9(this, (SSLSocket) this.a.createSocket(inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return new o9(this, (SSLSocket) this.a.createSocket(inetAddress, i2, inetAddress2, i3));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        return new o9(this, (SSLSocket) this.a.createSocket(socket, str, i2, z));
    }
}
