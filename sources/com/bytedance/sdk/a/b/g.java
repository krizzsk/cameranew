package com.bytedance.sdk.a.b;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
/* compiled from: CertificatePinner.java */
/* loaded from: classes.dex */
public final class g {
    public static final g a = new a().a();
    private final Set<b> b;
    private final com.bytedance.sdk.a.b.a.i.c c;

    /* compiled from: CertificatePinner.java */
    /* loaded from: classes.dex */
    public static final class a {
        private final List<b> a = new ArrayList();

        public g a() {
            return new g(new LinkedHashSet(this.a), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CertificatePinner.java */
    /* loaded from: classes.dex */
    public static final class b {
        final String a;
        final String b;
        final String c;

        /* renamed from: d  reason: collision with root package name */
        final com.bytedance.sdk.a.a.f f1076d;

        boolean a(String str) {
            if (this.a.startsWith("*.")) {
                int indexOf = str.indexOf(46);
                if ((str.length() - indexOf) - 1 == this.b.length()) {
                    String str2 = this.b;
                    if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                        return true;
                    }
                }
                return false;
            }
            return str.equals(this.b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.a.equals(bVar.a) && this.c.equals(bVar.c) && this.f1076d.equals(bVar.f1076d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.a.hashCode()) * 31) + this.c.hashCode()) * 31) + this.f1076d.hashCode();
        }

        public String toString() {
            return this.c + this.f1076d.b();
        }
    }

    g(Set<b> set, com.bytedance.sdk.a.b.a.i.c cVar) {
        this.b = set;
        this.c = cVar;
    }

    static com.bytedance.sdk.a.a.f b(X509Certificate x509Certificate) {
        return com.bytedance.sdk.a.a.f.a(x509Certificate.getPublicKey().getEncoded()).d();
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> a2 = a(str);
        if (a2.isEmpty()) {
            return;
        }
        com.bytedance.sdk.a.b.a.i.c cVar = this.c;
        if (cVar != null) {
            list = cVar.a(list, str);
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i2);
            int size2 = a2.size();
            com.bytedance.sdk.a.a.f fVar = null;
            com.bytedance.sdk.a.a.f fVar2 = null;
            for (int i3 = 0; i3 < size2; i3++) {
                b bVar = a2.get(i3);
                if (bVar.c.equals("sha256/")) {
                    if (fVar == null) {
                        fVar = b(x509Certificate);
                    }
                    if (bVar.f1076d.equals(fVar)) {
                        return;
                    }
                } else if (bVar.c.equals("sha1/")) {
                    if (fVar2 == null) {
                        fVar2 = a(x509Certificate);
                    }
                    if (bVar.f1076d.equals(fVar2)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + bVar.c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i4 = 0; i4 < size3; i4++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i4);
            sb.append("\n    ");
            sb.append(a((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = a2.size();
        for (int i5 = 0; i5 < size4; i5++) {
            sb.append("\n    ");
            sb.append(a2.get(i5));
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (com.bytedance.sdk.a.b.a.c.a(this.c, gVar.c) && this.b.equals(gVar.b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        com.bytedance.sdk.a.b.a.i.c cVar = this.c;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.b.hashCode();
    }

    List<b> a(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.b) {
            if (bVar.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g a(com.bytedance.sdk.a.b.a.i.c cVar) {
        return com.bytedance.sdk.a.b.a.c.a(this.c, cVar) ? this : new g(this.b, cVar);
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + b((X509Certificate) certificate).b();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static com.bytedance.sdk.a.a.f a(X509Certificate x509Certificate) {
        return com.bytedance.sdk.a.a.f.a(x509Certificate.getPublicKey().getEncoded()).c();
    }
}
