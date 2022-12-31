package com.bytedance.sdk.a.b.a.g;

import com.bytedance.sdk.a.b.a.i.f;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.w;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
/* compiled from: Platform.java */
/* loaded from: classes.dex */
public class e {
    private static final e a = a();
    private static final Logger b = Logger.getLogger(v.class.getName());

    public static e b() {
        return a;
    }

    public String a(SSLSocket sSLSocket) {
        return null;
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        socket.connect(inetSocketAddress, i2);
    }

    public void a(SSLSocket sSLSocket, String str, List<w> list) {
    }

    public void b(SSLSocket sSLSocket) {
    }

    public boolean b(String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] b(List<w> list) {
        com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            w wVar = list.get(i2);
            if (wVar != w.HTTP_1_0) {
                cVar.i(wVar.toString().length());
                cVar.b(wVar.toString());
            }
        }
        return cVar.q();
    }

    public void a(int i2, String str, Throwable th) {
        b.log(i2 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object a(String str) {
        if (b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    public static List<String> a(List<w> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            w wVar = list.get(i2);
            if (wVar != w.HTTP_1_0) {
                arrayList.add(wVar.toString());
            }
        }
        return arrayList;
    }

    public f b(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.a.b.a.i.b(x509TrustManager.getAcceptedIssuers());
    }

    public com.bytedance.sdk.a.b.a.i.c a(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.a.b.a.i.a(b(x509TrustManager));
    }

    private static e a() {
        e a2 = a.a();
        if (a2 != null) {
            return a2;
        }
        b a3 = b.a();
        if (a3 != null) {
            return a3;
        }
        e a4 = c.a();
        return a4 != null ? a4 : new e();
    }
}
