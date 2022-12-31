package com.huawei.hianalytics.c;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
/* loaded from: classes2.dex */
public abstract class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static KeyStore a() {
        KeyStore keyStore = KeyStore.getInstance("BKS");
        keyStore.load(null, null);
        String[] strArr = a.a;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            keyStore.setCertificateEntry("Certificate" + i2, a(strArr[i2]));
        }
        return keyStore;
    }

    static X509Certificate a(String str) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException unused) {
            com.huawei.hianalytics.b.b.c("StoreTools", "generateCertificate: UnsupportedEncodingException");
            throw new CertificateException("generateCertificate(): UnsupportedEncodingException");
        }
    }
}
