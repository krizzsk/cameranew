package j.a.a.a.a;

import com.android.pgvolley.toolbox.HurlStack;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
/* compiled from: TrustManager.java */
/* loaded from: classes3.dex */
public class e extends HurlStack {
    private static SSLSocketFactory a;

    public e() {
        super(null, a());
    }

    private static SSLSocketFactory a() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            SSLSocketFactory b = b();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            us.pinguo.advsdk.utils.b.a("init ssl consume:" + currentTimeMillis2);
            return b;
        } catch (Exception e2) {
            us.pinguo.advsdk.utils.b.a(e2.getMessage());
            return null;
        }
    }

    public static SSLSocketFactory b() throws Exception {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    try {
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, new TrustManager[]{new a(null, null, null)}, new SecureRandom());
                        a = sSLContext.getSocketFactory();
                    } catch (GeneralSecurityException unused) {
                        throw new Exception("Security exception configuring SSL context");
                    }
                }
            }
        }
        return a;
    }
}
