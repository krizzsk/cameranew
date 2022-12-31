package com.huawei.hianalytics.c;

import android.os.Build;
import com.adjust.sdk.Constants;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
/* loaded from: classes2.dex */
public final class c extends SSLSocketFactory {
    private static SocketFactory b;
    private final SSLContext a;

    private c() {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        this.a = sSLContext;
        sSLContext.init(null, b(), null);
    }

    public static synchronized SocketFactory a() {
        String str;
        String str2;
        synchronized (c.class) {
            try {
                if (b == null) {
                    b = new c();
                }
                return b;
            } catch (IOException unused) {
                str = "Factory";
                str2 = "getInstance(): IOException: Failed to new SSLSocketFactory instance.";
                com.huawei.hianalytics.b.b.c(str, str2);
                return null;
            } catch (KeyManagementException unused2) {
                str = "Factory";
                str2 = "getInstance(): KeyManagementException: Failed to new SSLSocketFactory instance.";
                com.huawei.hianalytics.b.b.c(str, str2);
                return null;
            } catch (KeyStoreException unused3) {
                str = "Factory";
                str2 = "getInstance(): KeyStoreException: Failed to new SSLSocketFactory instance.";
                com.huawei.hianalytics.b.b.c(str, str2);
                return null;
            } catch (NoSuchAlgorithmException unused4) {
                str = "Factory";
                str2 = "getInstance(): NoSuchAlgorithmException: Failed to new SSLSocketFactory instance.";
                com.huawei.hianalytics.b.b.c(str, str2);
                return null;
            } catch (GeneralSecurityException unused5) {
                str = "Factory";
                str2 = "getInstance(): GeneralSecurityException: Failed to new SSLSocketFactory instance.";
                com.huawei.hianalytics.b.b.c(str, str2);
                return null;
            }
        }
    }

    private void a(Socket socket) {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            b(sSLSocket);
            a(sSLSocket);
        }
    }

    public static void a(SSLSocket sSLSocket) {
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        if (enabledCipherSuites == null || enabledCipherSuites.length == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : enabledCipherSuites) {
            if (!str.contains("3DES") && !str.contains("DES") && !str.contains(Constants.MD5) && !str.contains("RC4") && !str.contains("aNULL") && !str.contains("eNULL")) {
                arrayList.add(str);
            }
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    private void b(SSLSocket sSLSocket) {
        if (sSLSocket == null || Build.VERSION.SDK_INT < 16) {
            return;
        }
        sSLSocket.setEnabledProtocols(new String[]{"TLSv1.1", "TLSv1.2"});
    }

    private static TrustManager[] b() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
        trustManagerFactory.init(b.a());
        return trustManagerFactory.getTrustManagers();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) {
        Socket createSocket = this.a.getSocketFactory().createSocket(str, i2);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) {
        return createSocket(str, i2);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) {
        Socket createSocket = this.a.getSocketFactory().createSocket(socket, str, i2, z);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}
