package j.a.a.a.a;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.util.Base64;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* compiled from: EasyX509TrustManager.java */
/* loaded from: classes3.dex */
public class a implements X509TrustManager {
    private X509TrustManager a;
    private d b;
    private c c;

    /* renamed from: d  reason: collision with root package name */
    private X509TrustManagerExtensions f8670d;

    public a(KeyStore keyStore, d dVar, c cVar) throws NoSuchAlgorithmException, KeyStoreException {
        this.a = null;
        this.f8670d = null;
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        this.b = dVar;
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length != 0) {
            this.a = (X509TrustManager) trustManagers[0];
            if (Build.VERSION.SDK_INT >= 17) {
                this.f8670d = new X509TrustManagerExtensions(this.a);
                return;
            }
            return;
        }
        throw new NoSuchAlgorithmException("no trust manager found");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.a.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        d dVar = this.b;
        if (dVar != null) {
            dVar.b(System.currentTimeMillis());
        }
        if (this.c == null) {
            if (Build.VERSION.SDK_INT < 17) {
                if (x509CertificateArr != null && x509CertificateArr.length == 1) {
                    x509CertificateArr[0].checkValidity();
                    return;
                } else {
                    this.a.checkServerTrusted(x509CertificateArr, str);
                    return;
                }
            }
            this.f8670d.checkServerTrusted(x509CertificateArr, str, "");
            return;
        }
        this.c.a(Base64.encodeToString(x509CertificateArr[0].getEncoded(), 0).replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "").replaceAll(" ", ""));
        throw null;
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.a.getAcceptedIssuers();
    }
}
