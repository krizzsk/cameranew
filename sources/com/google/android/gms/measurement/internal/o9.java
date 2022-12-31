package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
final class o9 extends SSLSocket {
    private final SSLSocket a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o9(p9 p9Var, SSLSocket sSLSocket) {
        this.a = sSLSocket;
    }

    @Override // javax.net.ssl.SSLSocket
    public final void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.a.addHandshakeCompletedListener(handshakeCompletedListener);
    }

    @Override // java.net.Socket
    public final void bind(SocketAddress socketAddress) throws IOException {
        this.a.bind(socketAddress);
    }

    @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        this.a.close();
    }

    @Override // java.net.Socket
    public final void connect(SocketAddress socketAddress) throws IOException {
        this.a.connect(socketAddress);
    }

    public final boolean equals(Object obj) {
        return this.a.equals(obj);
    }

    @Override // java.net.Socket
    public final SocketChannel getChannel() {
        return this.a.getChannel();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getEnableSessionCreation() {
        return this.a.getEnableSessionCreation();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getEnabledCipherSuites() {
        return this.a.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getEnabledProtocols() {
        return this.a.getEnabledProtocols();
    }

    @Override // java.net.Socket
    public final InetAddress getInetAddress() {
        return this.a.getInetAddress();
    }

    @Override // java.net.Socket
    public final InputStream getInputStream() throws IOException {
        return this.a.getInputStream();
    }

    @Override // java.net.Socket
    public final boolean getKeepAlive() throws SocketException {
        return this.a.getKeepAlive();
    }

    @Override // java.net.Socket
    public final InetAddress getLocalAddress() {
        return this.a.getLocalAddress();
    }

    @Override // java.net.Socket
    public final int getLocalPort() {
        return this.a.getLocalPort();
    }

    @Override // java.net.Socket
    public final SocketAddress getLocalSocketAddress() {
        return this.a.getLocalSocketAddress();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getNeedClientAuth() {
        return this.a.getNeedClientAuth();
    }

    @Override // java.net.Socket
    public final boolean getOOBInline() throws SocketException {
        return this.a.getOOBInline();
    }

    @Override // java.net.Socket
    public final OutputStream getOutputStream() throws IOException {
        return this.a.getOutputStream();
    }

    @Override // java.net.Socket
    public final int getPort() {
        return this.a.getPort();
    }

    @Override // java.net.Socket
    public final synchronized int getReceiveBufferSize() throws SocketException {
        return this.a.getReceiveBufferSize();
    }

    @Override // java.net.Socket
    public final SocketAddress getRemoteSocketAddress() {
        return this.a.getRemoteSocketAddress();
    }

    @Override // java.net.Socket
    public final boolean getReuseAddress() throws SocketException {
        return this.a.getReuseAddress();
    }

    @Override // java.net.Socket
    public final synchronized int getSendBufferSize() throws SocketException {
        return this.a.getSendBufferSize();
    }

    @Override // javax.net.ssl.SSLSocket
    public final SSLSession getSession() {
        return this.a.getSession();
    }

    @Override // java.net.Socket
    public final int getSoLinger() throws SocketException {
        return this.a.getSoLinger();
    }

    @Override // java.net.Socket
    public final synchronized int getSoTimeout() throws SocketException {
        return this.a.getSoTimeout();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getSupportedCipherSuites() {
        return this.a.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getSupportedProtocols() {
        return this.a.getSupportedProtocols();
    }

    @Override // java.net.Socket
    public final boolean getTcpNoDelay() throws SocketException {
        return this.a.getTcpNoDelay();
    }

    @Override // java.net.Socket
    public final int getTrafficClass() throws SocketException {
        return this.a.getTrafficClass();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getUseClientMode() {
        return this.a.getUseClientMode();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getWantClientAuth() {
        return this.a.getWantClientAuth();
    }

    @Override // java.net.Socket
    public final boolean isBound() {
        return this.a.isBound();
    }

    @Override // java.net.Socket
    public final boolean isClosed() {
        return this.a.isClosed();
    }

    @Override // java.net.Socket
    public final boolean isConnected() {
        return this.a.isConnected();
    }

    @Override // java.net.Socket
    public final boolean isInputShutdown() {
        return this.a.isInputShutdown();
    }

    @Override // java.net.Socket
    public final boolean isOutputShutdown() {
        return this.a.isOutputShutdown();
    }

    @Override // javax.net.ssl.SSLSocket
    public final void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.a.removeHandshakeCompletedListener(handshakeCompletedListener);
    }

    @Override // java.net.Socket
    public final void sendUrgentData(int i2) throws IOException {
        this.a.sendUrgentData(i2);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setEnableSessionCreation(boolean z) {
        this.a.setEnableSessionCreation(z);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setEnabledCipherSuites(String[] strArr) {
        this.a.setEnabledCipherSuites(strArr);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setEnabledProtocols(String[] strArr) {
        if (strArr != null && Arrays.asList(strArr).contains("SSLv3")) {
            ArrayList arrayList = new ArrayList(Arrays.asList(this.a.getEnabledProtocols()));
            if (arrayList.size() > 1) {
                arrayList.remove("SSLv3");
            }
            strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        this.a.setEnabledProtocols(strArr);
    }

    @Override // java.net.Socket
    public final void setKeepAlive(boolean z) throws SocketException {
        this.a.setKeepAlive(z);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setNeedClientAuth(boolean z) {
        this.a.setNeedClientAuth(z);
    }

    @Override // java.net.Socket
    public final void setOOBInline(boolean z) throws SocketException {
        this.a.setOOBInline(z);
    }

    @Override // java.net.Socket
    public final void setPerformancePreferences(int i2, int i3, int i4) {
        this.a.setPerformancePreferences(i2, i3, i4);
    }

    @Override // java.net.Socket
    public final synchronized void setReceiveBufferSize(int i2) throws SocketException {
        this.a.setReceiveBufferSize(i2);
    }

    @Override // java.net.Socket
    public final void setReuseAddress(boolean z) throws SocketException {
        this.a.setReuseAddress(z);
    }

    @Override // java.net.Socket
    public final synchronized void setSendBufferSize(int i2) throws SocketException {
        this.a.setSendBufferSize(i2);
    }

    @Override // java.net.Socket
    public final void setSoLinger(boolean z, int i2) throws SocketException {
        this.a.setSoLinger(z, i2);
    }

    @Override // java.net.Socket
    public final synchronized void setSoTimeout(int i2) throws SocketException {
        this.a.setSoTimeout(i2);
    }

    @Override // java.net.Socket
    public final void setTcpNoDelay(boolean z) throws SocketException {
        this.a.setTcpNoDelay(z);
    }

    @Override // java.net.Socket
    public final void setTrafficClass(int i2) throws SocketException {
        this.a.setTrafficClass(i2);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setUseClientMode(boolean z) {
        this.a.setUseClientMode(z);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setWantClientAuth(boolean z) {
        this.a.setWantClientAuth(z);
    }

    @Override // java.net.Socket
    public final void shutdownInput() throws IOException {
        this.a.shutdownInput();
    }

    @Override // java.net.Socket
    public final void shutdownOutput() throws IOException {
        this.a.shutdownOutput();
    }

    @Override // javax.net.ssl.SSLSocket
    public final void startHandshake() throws IOException {
        this.a.startHandshake();
    }

    @Override // javax.net.ssl.SSLSocket, java.net.Socket
    public final String toString() {
        return this.a.toString();
    }

    @Override // java.net.Socket
    public final void connect(SocketAddress socketAddress, int i2) throws IOException {
        this.a.connect(socketAddress, i2);
    }
}
