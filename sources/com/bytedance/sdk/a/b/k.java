package com.bytedance.sdk.a.b;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
/* compiled from: ConnectionSpec.java */
/* loaded from: classes.dex */
public final class k {
    public static final k a;
    public static final k b;
    public static final k c;

    /* renamed from: h  reason: collision with root package name */
    private static final h[] f1091h;

    /* renamed from: d  reason: collision with root package name */
    final boolean f1092d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f1093e;

    /* renamed from: f  reason: collision with root package name */
    final String[] f1094f;

    /* renamed from: g  reason: collision with root package name */
    final String[] f1095g;

    static {
        h[] hVarArr = {h.aX, h.bb, h.aY, h.bc, h.bi, h.bh, h.ay, h.aI, h.az, h.aJ, h.ag, h.ah, h.E, h.I, h.f1082i};
        f1091h = hVarArr;
        a a2 = new a(true).a(hVarArr);
        ad adVar = ad.TLS_1_0;
        k a3 = a2.a(ad.TLS_1_3, ad.TLS_1_2, ad.TLS_1_1, adVar).a(true).a();
        a = a3;
        b = new a(a3).a(adVar).a(true).a();
        c = new a(false).a();
    }

    k(a aVar) {
        this.f1092d = aVar.a;
        this.f1094f = aVar.b;
        this.f1095g = aVar.c;
        this.f1093e = aVar.f1096d;
    }

    public boolean a() {
        return this.f1092d;
    }

    public List<h> b() {
        String[] strArr = this.f1094f;
        if (strArr != null) {
            return h.a(strArr);
        }
        return null;
    }

    public List<ad> c() {
        String[] strArr = this.f1095g;
        if (strArr != null) {
            return ad.a(strArr);
        }
        return null;
    }

    public boolean d() {
        return this.f1093e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            if (obj == this) {
                return true;
            }
            k kVar = (k) obj;
            boolean z = this.f1092d;
            if (z != kVar.f1092d) {
                return false;
            }
            return !z || (Arrays.equals(this.f1094f, kVar.f1094f) && Arrays.equals(this.f1095g, kVar.f1095g) && this.f1093e == kVar.f1093e);
        }
        return false;
    }

    public int hashCode() {
        if (this.f1092d) {
            return ((((527 + Arrays.hashCode(this.f1094f)) * 31) + Arrays.hashCode(this.f1095g)) * 31) + (!this.f1093e ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (this.f1092d) {
            String obj = this.f1094f != null ? b().toString() : "[all enabled]";
            String obj2 = this.f1095g != null ? c().toString() : "[all enabled]";
            return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f1093e + ")";
        }
        return "ConnectionSpec()";
    }

    /* compiled from: ConnectionSpec.java */
    /* loaded from: classes.dex */
    public static final class a {
        boolean a;
        String[] b;
        String[] c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1096d;

        a(boolean z) {
            this.a = z;
        }

        public a a(h... hVarArr) {
            if (this.a) {
                String[] strArr = new String[hVarArr.length];
                for (int i2 = 0; i2 < hVarArr.length; i2++) {
                    strArr[i2] = hVarArr[i2].bj;
                }
                return a(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a b(String... strArr) {
            if (this.a) {
                if (strArr.length != 0) {
                    this.c = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(k kVar) {
            this.a = kVar.f1092d;
            this.b = kVar.f1094f;
            this.c = kVar.f1095g;
            this.f1096d = kVar.f1093e;
        }

        public a a(String... strArr) {
            if (this.a) {
                if (strArr.length != 0) {
                    this.b = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a a(ad... adVarArr) {
            if (this.a) {
                String[] strArr = new String[adVarArr.length];
                for (int i2 = 0; i2 < adVarArr.length; i2++) {
                    strArr[i2] = adVarArr[i2].f1061f;
                }
                return b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a a(boolean z) {
            if (this.a) {
                this.f1096d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public k a() {
            return new k(this);
        }
    }

    private k b(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f1094f != null) {
            enabledCipherSuites = com.bytedance.sdk.a.b.a.c.a(h.a, sSLSocket.getEnabledCipherSuites(), this.f1094f);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f1095g != null) {
            enabledProtocols = com.bytedance.sdk.a.b.a.c.a(com.bytedance.sdk.a.b.a.c.f913h, sSLSocket.getEnabledProtocols(), this.f1095g);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a2 = com.bytedance.sdk.a.b.a.c.a(h.a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a2 != -1) {
            enabledCipherSuites = com.bytedance.sdk.a.b.a.c.a(enabledCipherSuites, supportedCipherSuites[a2]);
        }
        return new a(this).a(enabledCipherSuites).b(enabledProtocols).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SSLSocket sSLSocket, boolean z) {
        k b2 = b(sSLSocket, z);
        String[] strArr = b2.f1095g;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b2.f1094f;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean a(SSLSocket sSLSocket) {
        if (this.f1092d) {
            String[] strArr = this.f1095g;
            if (strArr == null || com.bytedance.sdk.a.b.a.c.b(com.bytedance.sdk.a.b.a.c.f913h, strArr, sSLSocket.getEnabledProtocols())) {
                String[] strArr2 = this.f1094f;
                return strArr2 == null || com.bytedance.sdk.a.b.a.c.b(h.a, strArr2, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }
}
