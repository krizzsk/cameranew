package com.bytedance.sdk.a.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* compiled from: CipherSuite.java */
/* loaded from: classes.dex */
public final class h {
    public static final h A;
    public static final h B;
    public static final h C;
    public static final h D;
    public static final h E;
    public static final h F;
    public static final h G;
    public static final h H;
    public static final h I;
    public static final h J;
    public static final h K;
    public static final h L;
    public static final h M;
    public static final h N;
    public static final h O;
    public static final h P;
    public static final h Q;
    public static final h R;
    public static final h S;
    public static final h T;
    public static final h U;
    public static final h V;
    public static final h W;
    public static final h X;
    public static final h Y;
    public static final h Z;
    static final Comparator<String> a;
    public static final h aA;
    public static final h aB;
    public static final h aC;
    public static final h aD;
    public static final h aE;
    public static final h aF;
    public static final h aG;
    public static final h aH;
    public static final h aI;
    public static final h aJ;
    public static final h aK;
    public static final h aL;
    public static final h aM;
    public static final h aN;
    public static final h aO;
    public static final h aP;
    public static final h aQ;
    public static final h aR;
    public static final h aS;
    public static final h aT;
    public static final h aU;
    public static final h aV;
    public static final h aW;
    public static final h aX;
    public static final h aY;
    public static final h aZ;
    public static final h aa;
    public static final h ab;
    public static final h ac;
    public static final h ad;
    public static final h ae;
    public static final h af;
    public static final h ag;
    public static final h ah;
    public static final h ai;
    public static final h aj;
    public static final h ak;
    public static final h al;
    public static final h am;
    public static final h an;
    public static final h ao;
    public static final h ap;
    public static final h aq;
    public static final h ar;
    public static final h as;
    public static final h at;
    public static final h au;
    public static final h av;
    public static final h aw;
    public static final h ax;
    public static final h ay;
    public static final h az;
    public static final h b;
    public static final h ba;
    public static final h bb;
    public static final h bc;
    public static final h bd;
    public static final h be;
    public static final h bf;
    public static final h bg;
    public static final h bh;
    public static final h bi;
    private static final Map<String, h> bk;
    public static final h c;

    /* renamed from: d  reason: collision with root package name */
    public static final h f1077d;

    /* renamed from: e  reason: collision with root package name */
    public static final h f1078e;

    /* renamed from: f  reason: collision with root package name */
    public static final h f1079f;

    /* renamed from: g  reason: collision with root package name */
    public static final h f1080g;

    /* renamed from: h  reason: collision with root package name */
    public static final h f1081h;

    /* renamed from: i  reason: collision with root package name */
    public static final h f1082i;

    /* renamed from: j  reason: collision with root package name */
    public static final h f1083j;

    /* renamed from: k  reason: collision with root package name */
    public static final h f1084k;

    /* renamed from: l  reason: collision with root package name */
    public static final h f1085l;
    public static final h m;
    public static final h n;
    public static final h o;
    public static final h p;
    public static final h q;
    public static final h r;
    public static final h s;
    public static final h t;
    public static final h u;
    public static final h v;
    public static final h w;
    public static final h x;
    public static final h y;
    public static final h z;
    final String bj;

    static {
        Comparator<String> comparator = new Comparator<String>() { // from class: com.bytedance.sdk.a.b.h.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(String str, String str2) {
                int min = Math.min(str.length(), str2.length());
                for (int i2 = 4; i2 < min; i2++) {
                    char charAt = str.charAt(i2);
                    char charAt2 = str2.charAt(i2);
                    if (charAt != charAt2) {
                        return charAt < charAt2 ? -1 : 1;
                    }
                }
                int length = str.length();
                int length2 = str2.length();
                if (length != length2) {
                    return length < length2 ? -1 : 1;
                }
                return 0;
            }
        };
        a = comparator;
        bk = new TreeMap(comparator);
        b = a("SSL_RSA_WITH_NULL_MD5", 1);
        c = a("SSL_RSA_WITH_NULL_SHA", 2);
        f1077d = a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        f1078e = a("SSL_RSA_WITH_RC4_128_MD5", 4);
        f1079f = a("SSL_RSA_WITH_RC4_128_SHA", 5);
        f1080g = a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        f1081h = a("SSL_RSA_WITH_DES_CBC_SHA", 9);
        f1082i = a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        f1083j = a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        f1084k = a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        f1085l = a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        m = a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        n = a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        o = a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        p = a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        q = a("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        r = a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        s = a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        t = a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        u = a("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        v = a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        w = a("TLS_KRB5_WITH_RC4_128_SHA", 32);
        x = a("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        y = a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        z = a("TLS_KRB5_WITH_RC4_128_MD5", 36);
        A = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        B = a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        C = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        D = a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        E = a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        F = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        G = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        H = a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        I = a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        J = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        K = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        L = a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        M = a("TLS_RSA_WITH_NULL_SHA256", 59);
        N = a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        O = a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        P = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        Q = a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        R = a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        S = a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        T = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        U = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        V = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        W = a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        X = a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        Y = a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        Z = a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        aa = a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        ab = a("TLS_PSK_WITH_RC4_128_SHA", 138);
        ac = a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        ad = a("TLS_PSK_WITH_AES_128_CBC_SHA", InspirePublishFragment.MAX_DESC_COUNT);
        ae = a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        af = a("TLS_RSA_WITH_SEED_CBC_SHA", 150);
        ag = a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        ah = a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        ai = a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        aj = a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        ak = a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        al = a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        am = a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        an = a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        ao = a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        ap = a("TLS_FALLBACK_SCSV", 22016);
        aq = a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        ar = a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        as = a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        at = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        au = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        av = a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        aw = a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        ax = a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        ay = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        az = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        aA = a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        aB = a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        aC = a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        aD = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        aE = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        aF = a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        aG = a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        aH = a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        aI = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        aJ = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        aK = a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        aL = a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        aM = a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        aN = a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        aO = a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        aP = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        aQ = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        aR = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        aS = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        aT = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        aU = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        aV = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        aW = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        aX = a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        aY = a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        aZ = a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        ba = a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        bb = a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        bc = a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        bd = a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        be = a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        bf = a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        bg = a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        bh = a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        bi = a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    }

    private h(String str) {
        Objects.requireNonNull(str);
        this.bj = str;
    }

    public static synchronized h a(String str) {
        h hVar;
        synchronized (h.class) {
            Map<String, h> map = bk;
            hVar = map.get(str);
            if (hVar == null) {
                hVar = new h(str);
                map.put(str, hVar);
            }
        }
        return hVar;
    }

    public String toString() {
        return this.bj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<h> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static h a(String str, int i2) {
        return a(str);
    }
}
