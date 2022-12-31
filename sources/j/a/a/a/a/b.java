package j.a.a.a.a;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
/* compiled from: SslCalcTimeFactory.java */
/* loaded from: classes3.dex */
public class b {
    private SSLSocketFactory a;
    private d b;
    private c c;

    public b(long j2) {
        this.b = new d(j2);
        a();
    }

    public SSLSocketFactory a() {
        if (this.a == null) {
            synchronized (b.class) {
                if (this.a == null) {
                    try {
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, new TrustManager[]{new a(null, this.b, this.c)}, new SecureRandom());
                        this.a = sSLContext.getSocketFactory();
                    } catch (GeneralSecurityException unused) {
                        return null;
                    }
                }
            }
        }
        return this.a;
    }

    public d b() {
        return this.b;
    }
}
