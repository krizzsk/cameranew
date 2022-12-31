package com.bytedance.sdk.a.b;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
/* compiled from: Handshake.java */
/* loaded from: classes.dex */
public final class q {
    private final ad a;
    private final h b;
    private final List<Certificate> c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Certificate> f1110d;

    private q(ad adVar, h hVar, List<Certificate> list, List<Certificate> list2) {
        this.a = adVar;
        this.b = hVar;
        this.c = list;
        this.f1110d = list2;
    }

    public static q a(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List emptyList;
        List emptyList2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            h a = h.a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                ad a2 = ad.a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    emptyList = com.bytedance.sdk.a.b.a.c.a(certificateArr);
                } else {
                    emptyList = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    emptyList2 = com.bytedance.sdk.a.b.a.c.a(localCertificates);
                } else {
                    emptyList2 = Collections.emptyList();
                }
                return new q(a2, a, emptyList, emptyList2);
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public List<Certificate> b() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof q) {
            q qVar = (q) obj;
            return this.a.equals(qVar.a) && this.b.equals(qVar.b) && this.c.equals(qVar.c) && this.f1110d.equals(qVar.f1110d);
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.f1110d.hashCode();
    }

    public h a() {
        return this.b;
    }
}
