package us.pinguo.advconfigdata.Utils;

import android.text.TextUtils;
import android.util.Base64;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes3.dex */
public class SSLX509TrustManager implements X509TrustManager {
    private String mUrl;
    private X509TrustManager standardTrustManager;

    /* JADX INFO: Access modifiers changed from: protected */
    public SSLX509TrustManager(KeyStore keyStore) throws NoSuchAlgorithmException, KeyStoreException {
        this.standardTrustManager = null;
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length != 0) {
            this.standardTrustManager = (X509TrustManager) trustManagers[0];
            return;
        }
        throw new NoSuchAlgorithmException("no trust manager found");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.standardTrustManager.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (!TextUtils.isEmpty(this.mUrl)) {
            if (!SSLManager.getInstance().verifyCertification(Base64.encodeToString(x509CertificateArr[0].getEncoded(), 0), this.mUrl).booleanValue()) {
                throw new CertificateException("certificate is error!");
            }
        }
        if (x509CertificateArr != null && x509CertificateArr.length == 1) {
            x509CertificateArr[0].checkValidity();
        } else {
            this.standardTrustManager.checkServerTrusted(x509CertificateArr, str);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.standardTrustManager.getAcceptedIssuers();
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }
}
