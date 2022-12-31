package com.bytedance.sdk.a.b.a.g;

import android.os.Build;
import android.util.Log;
import com.bytedance.sdk.a.b.a.i.f;
import com.bytedance.sdk.a.b.w;
import com.tencent.matrix.trace.constants.Constants;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidPlatform.java */
/* loaded from: classes.dex */
public class a extends e {
    private final Class<?> a;
    private final d<Socket> b;
    private final d<Socket> c;

    /* renamed from: d  reason: collision with root package name */
    private final d<Socket> f1026d;

    /* renamed from: e  reason: collision with root package name */
    private final d<Socket> f1027e;

    /* renamed from: f  reason: collision with root package name */
    private final c f1028f = c.a();

    /* compiled from: AndroidPlatform.java */
    /* renamed from: com.bytedance.sdk.a.b.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0038a extends com.bytedance.sdk.a.b.a.i.c {
        private final Object a;
        private final Method b;

        C0038a(Object obj, Method method) {
            this.a = obj;
            this.b = method;
        }

        @Override // com.bytedance.sdk.a.b.a.i.c
        public List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.b.invoke(this.a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e3.getMessage());
                sSLPeerUnverifiedException.initCause(e3);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0038a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* compiled from: AndroidPlatform.java */
    /* loaded from: classes.dex */
    static final class b implements f {
        private final X509TrustManager a;
        private final Method b;

        b(X509TrustManager x509TrustManager, Method method) {
            this.b = method;
            this.a = x509TrustManager;
        }

        @Override // com.bytedance.sdk.a.b.a.i.f
        public X509Certificate a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.b.invoke(this.a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e2) {
                throw com.bytedance.sdk.a.b.a.c.a("unable to get issues and signature", (Exception) e2);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.a.equals(bVar.a) && this.b.equals(bVar.b);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode() + (this.b.hashCode() * 31);
        }
    }

    a(Class<?> cls, d<Socket> dVar, d<Socket> dVar2, d<Socket> dVar3, d<Socket> dVar4) {
        this.a = cls;
        this.b = dVar;
        this.c = dVar2;
        this.f1026d = dVar3;
        this.f1027e = dVar4;
    }

    private static boolean c() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i2) throws IOException {
        try {
            socket.connect(inetSocketAddress, i2);
        } catch (AssertionError e2) {
            if (!com.bytedance.sdk.a.b.a.c.a(e2)) {
                throw e2;
            }
            throw new IOException(e2);
        } catch (ClassCastException e3) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e3);
                throw iOException;
            }
            throw e3;
        } catch (SecurityException e4) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e4);
            throw iOException2;
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public boolean b(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return a(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.b(str);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw com.bytedance.sdk.a.b.a.c.a("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e3) {
            e = e3;
            throw com.bytedance.sdk.a.b.a.c.a("unable to determine cleartext support", e);
        } catch (InvocationTargetException e4) {
            e = e4;
            throw com.bytedance.sdk.a.b.a.c.a("unable to determine cleartext support", e);
        }
    }

    /* compiled from: AndroidPlatform.java */
    /* loaded from: classes.dex */
    static final class c {
        private final Method a;
        private final Method b;
        private final Method c;

        c(Method method, Method method2, Method method3) {
            this.a = method;
            this.b = method2;
            this.c = method3;
        }

        Object a(String str) {
            Method method = this.a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.b.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        boolean a(Object obj) {
            if (obj != null) {
                try {
                    this.c.invoke(obj, new Object[0]);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }

        static c a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new c(method3, method2, method);
        }
    }

    private boolean b(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.b(str);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public f b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.b(x509TrustManager);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(SSLSocket sSLSocket, String str, List<w> list) {
        if (str != null) {
            this.b.b(sSLSocket, Boolean.TRUE);
            this.c.b(sSLSocket, str);
        }
        d<Socket> dVar = this.f1027e;
        if (dVar == null || !dVar.a((d<Socket>) sSLSocket)) {
            return;
        }
        this.f1027e.d(sSLSocket, e.b(list));
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public String a(SSLSocket sSLSocket) {
        byte[] bArr;
        d<Socket> dVar = this.f1026d;
        if (dVar == null || !dVar.a((d<Socket>) sSLSocket) || (bArr = (byte[]) this.f1026d.d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, com.bytedance.sdk.a.b.a.c.f910e);
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(int i2, String str, Throwable th) {
        int min;
        int i3 = i2 != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i4 = 0;
        int length = str.length();
        while (i4 < length) {
            int indexOf = str.indexOf(10, i4);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i4 + Constants.DEFAULT_STARTUP_THRESHOLD_MS_WARM);
                Log.println(i3, "OkHttp", str.substring(i4, min));
                if (min >= indexOf) {
                    break;
                }
                i4 = min;
            }
            i4 = min + 1;
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public Object a(String str) {
        return this.f1028f.a(str);
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public void a(String str, Object obj) {
        if (this.f1028f.a(obj)) {
            return;
        }
        a(5, str, (Throwable) null);
    }

    private boolean a(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return b(str, cls, obj);
        }
    }

    @Override // com.bytedance.sdk.a.b.a.g.e
    public com.bytedance.sdk.a.b.a.i.c a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0038a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.a(x509TrustManager);
        }
    }

    public static e a() {
        Class<?> cls;
        d dVar;
        d dVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            d dVar3 = new d(null, "setUseSessionTickets", Boolean.TYPE);
            d dVar4 = new d(null, "setHostname", String.class);
            if (c()) {
                d dVar5 = new d(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                dVar2 = new d(null, "setAlpnProtocols", byte[].class);
                dVar = dVar5;
            } else {
                dVar = null;
                dVar2 = null;
            }
            return new a(cls2, dVar3, dVar4, dVar, dVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }
}
