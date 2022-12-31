package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocketFactory;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbcd extends SSLSocketFactory {
    private SSLSocketFactory zzenp = (SSLSocketFactory) SSLSocketFactory.getDefault();
    private final /* synthetic */ zzbce zzenq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbcd(zzbce zzbceVar) {
        this.zzenq = zzbceVar;
    }

    private final Socket zza(Socket socket) throws SocketException {
        int i2;
        int i3;
        i2 = this.zzenq.zzens;
        if (i2 > 0) {
            i3 = this.zzenq.zzens;
            socket.setReceiveBufferSize(i3);
        }
        this.zzenq.zzb(socket);
        return socket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        return zza(this.zzenp.createSocket(socket, str, i2, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.zzenp.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.zzenp.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i2) throws IOException {
        return zza(this.zzenp.createSocket(str, i2));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException {
        return zza(this.zzenp.createSocket(str, i2, inetAddress, i3));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return zza(this.zzenp.createSocket(inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return zza(this.zzenp.createSocket(inetAddress, i2, inetAddress2, i3));
    }
}
