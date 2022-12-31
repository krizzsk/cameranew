package com.tencent.open.utils;

import android.annotation.TargetApi;
import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import com.tencent.open.log.SLog;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.params.HttpParams;
/* compiled from: ProGuard */
@TargetApi(17)
/* loaded from: classes3.dex */
public class k implements LayeredSocketFactory {
    private static final HostnameVerifier a = new StrictHostnameVerifier();
    private static final SSLCertificateSocketFactory b = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0, null);

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket connectSocket(Socket socket, String str, int i2, InetAddress inetAddress, int i3, HttpParams httpParams) throws IOException {
        socket.connect(new InetSocketAddress(str, i2));
        return socket;
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() {
        return new Socket();
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public boolean isSecure(Socket socket) throws IllegalArgumentException {
        if (socket instanceof SSLSocket) {
            return ((SSLSocket) socket).isConnected();
        }
        return false;
    }

    @Override // org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        SLog.v("openSDK_LOG.SNISocketFactory", "createSocket " + socket.toString() + " host:" + str + " port:" + i2 + " autoClose:" + z);
        InetAddress inetAddress = socket.getInetAddress();
        if (z) {
            socket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = b;
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i2);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (Build.VERSION.SDK_INT >= 17) {
            SLog.v("openSDK_LOG.SNISocketFactory", "Setting SNI hostname");
            sSLCertificateSocketFactory.setHostname(sSLSocket, str);
        } else {
            SLog.v("openSDK_LOG.SNISocketFactory", "No documented SNI support on Android <4.2, trying with reflection");
            try {
                sSLSocket.getClass().getMethod("setHostname", String.class).invoke(sSLSocket, str);
            } catch (Exception unused) {
                SLog.v("openSDK_LOG.SNISocketFactory", "SNI not useable");
            }
        }
        if (a.verify(str, sSLSocket.getSession())) {
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
    }
}
