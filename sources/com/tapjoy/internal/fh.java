package com.tapjoy.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import com.tapjoy.internal.eh;
import java.util.List;
/* loaded from: classes3.dex */
public final class fh extends eh {
    public static final ej c = new b();

    /* renamed from: d  reason: collision with root package name */
    public static final Long f7520d = 0L;

    /* renamed from: e  reason: collision with root package name */
    public static final Integer f7521e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static final Integer f7522f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final Integer f7523g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static final Long f7524h = 0L;

    /* renamed from: i  reason: collision with root package name */
    public static final Long f7525i = 0L;

    /* renamed from: j  reason: collision with root package name */
    public static final Long f7526j = 0L;

    /* renamed from: k  reason: collision with root package name */
    public static final Integer f7527k = 0;

    /* renamed from: l  reason: collision with root package name */
    public static final Double f7528l;
    public static final Long m;
    public static final Double n;
    public static final Boolean o;
    public static final Integer p;
    public static final Integer q;
    public static final Boolean r;
    public final Long A;
    public final String B;
    public final Integer C;
    public final Double D;
    public final Long E;
    public final Double F;
    public final String G;
    public final Boolean H;
    public final String I;
    public final Integer J;
    public final Integer K;
    public final String L;
    public final String M;
    public final String N;
    public final String O;
    public final String P;
    public final List Q;
    public final Boolean R;
    public final Long s;
    public final String t;
    public final Integer u;
    public final Integer v;
    public final List w;
    public final Integer x;
    public final Long y;
    public final Long z;

    /* loaded from: classes3.dex */
    public static final class a extends eh.a {
        public Boolean B;
        public Long c;

        /* renamed from: d  reason: collision with root package name */
        public String f7529d;

        /* renamed from: e  reason: collision with root package name */
        public Integer f7530e;

        /* renamed from: f  reason: collision with root package name */
        public Integer f7531f;

        /* renamed from: h  reason: collision with root package name */
        public Integer f7533h;

        /* renamed from: i  reason: collision with root package name */
        public Long f7534i;

        /* renamed from: j  reason: collision with root package name */
        public Long f7535j;

        /* renamed from: k  reason: collision with root package name */
        public Long f7536k;

        /* renamed from: l  reason: collision with root package name */
        public String f7537l;
        public Integer m;
        public Double n;
        public Long o;
        public Double p;
        public String q;
        public Boolean r;
        public String s;
        public Integer t;
        public Integer u;
        public String v;
        public String w;
        public String x;
        public String y;
        public String z;

        /* renamed from: g  reason: collision with root package name */
        public List f7532g = eo.a();
        public List A = eo.a();

        public final fh b() {
            return new fh(this.c, this.f7529d, this.f7530e, this.f7531f, this.f7532g, this.f7533h, this.f7534i, this.f7535j, this.f7536k, this.f7537l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, super.a());
        }
    }

    static {
        Double valueOf = Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        f7528l = valueOf;
        m = 0L;
        n = valueOf;
        Boolean bool = Boolean.FALSE;
        o = bool;
        p = 0;
        q = 0;
        r = bool;
    }

    public fh(Long l2, String str, Integer num, Integer num2, List list, Integer num3, Long l3, Long l4, Long l5, String str2, Integer num4, Double d2, Long l6, Double d3, String str3, Boolean bool, String str4, Integer num5, Integer num6, String str5, String str6, String str7, String str8, String str9, List list2, Boolean bool2, iu iuVar) {
        super(c, iuVar);
        this.s = l2;
        this.t = str;
        this.u = num;
        this.v = num2;
        this.w = eo.a("pushes", list);
        this.x = num3;
        this.y = l3;
        this.z = l4;
        this.A = l5;
        this.B = str2;
        this.C = num4;
        this.D = d2;
        this.E = l6;
        this.F = d3;
        this.G = str3;
        this.H = bool;
        this.I = str4;
        this.J = num5;
        this.K = num6;
        this.L = str5;
        this.M = str6;
        this.N = str7;
        this.O = str8;
        this.P = str9;
        this.Q = eo.a(JsonMarshaller.TAGS, list2);
        this.R = bool2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof fh) {
            fh fhVar = (fh) obj;
            return a().equals(fhVar.a()) && eo.a(this.s, fhVar.s) && eo.a(this.t, fhVar.t) && eo.a(this.u, fhVar.u) && eo.a(this.v, fhVar.v) && this.w.equals(fhVar.w) && eo.a(this.x, fhVar.x) && eo.a(this.y, fhVar.y) && eo.a(this.z, fhVar.z) && eo.a(this.A, fhVar.A) && eo.a(this.B, fhVar.B) && eo.a(this.C, fhVar.C) && eo.a(this.D, fhVar.D) && eo.a(this.E, fhVar.E) && eo.a(this.F, fhVar.F) && eo.a(this.G, fhVar.G) && eo.a(this.H, fhVar.H) && eo.a(this.I, fhVar.I) && eo.a(this.J, fhVar.J) && eo.a(this.K, fhVar.K) && eo.a(this.L, fhVar.L) && eo.a(this.M, fhVar.M) && eo.a(this.N, fhVar.N) && eo.a(this.O, fhVar.O) && eo.a(this.P, fhVar.P) && this.Q.equals(fhVar.Q) && eo.a(this.R, fhVar.R);
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.b;
        if (i2 == 0) {
            int hashCode = a().hashCode() * 37;
            Long l2 = this.s;
            int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
            String str = this.t;
            int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
            Integer num = this.u;
            int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
            Integer num2 = this.v;
            int hashCode5 = (((hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37) + this.w.hashCode()) * 37;
            Integer num3 = this.x;
            int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
            Long l3 = this.y;
            int hashCode7 = (hashCode6 + (l3 != null ? l3.hashCode() : 0)) * 37;
            Long l4 = this.z;
            int hashCode8 = (hashCode7 + (l4 != null ? l4.hashCode() : 0)) * 37;
            Long l5 = this.A;
            int hashCode9 = (hashCode8 + (l5 != null ? l5.hashCode() : 0)) * 37;
            String str2 = this.B;
            int hashCode10 = (hashCode9 + (str2 != null ? str2.hashCode() : 0)) * 37;
            Integer num4 = this.C;
            int hashCode11 = (hashCode10 + (num4 != null ? num4.hashCode() : 0)) * 37;
            Double d2 = this.D;
            int hashCode12 = (hashCode11 + (d2 != null ? d2.hashCode() : 0)) * 37;
            Long l6 = this.E;
            int hashCode13 = (hashCode12 + (l6 != null ? l6.hashCode() : 0)) * 37;
            Double d3 = this.F;
            int hashCode14 = (hashCode13 + (d3 != null ? d3.hashCode() : 0)) * 37;
            String str3 = this.G;
            int hashCode15 = (hashCode14 + (str3 != null ? str3.hashCode() : 0)) * 37;
            Boolean bool = this.H;
            int hashCode16 = (hashCode15 + (bool != null ? bool.hashCode() : 0)) * 37;
            String str4 = this.I;
            int hashCode17 = (hashCode16 + (str4 != null ? str4.hashCode() : 0)) * 37;
            Integer num5 = this.J;
            int hashCode18 = (hashCode17 + (num5 != null ? num5.hashCode() : 0)) * 37;
            Integer num6 = this.K;
            int hashCode19 = (hashCode18 + (num6 != null ? num6.hashCode() : 0)) * 37;
            String str5 = this.L;
            int hashCode20 = (hashCode19 + (str5 != null ? str5.hashCode() : 0)) * 37;
            String str6 = this.M;
            int hashCode21 = (hashCode20 + (str6 != null ? str6.hashCode() : 0)) * 37;
            String str7 = this.N;
            int hashCode22 = (hashCode21 + (str7 != null ? str7.hashCode() : 0)) * 37;
            String str8 = this.O;
            int hashCode23 = (hashCode22 + (str8 != null ? str8.hashCode() : 0)) * 37;
            String str9 = this.P;
            int hashCode24 = (((hashCode23 + (str9 != null ? str9.hashCode() : 0)) * 37) + this.Q.hashCode()) * 37;
            Boolean bool2 = this.R;
            int hashCode25 = hashCode24 + (bool2 != null ? bool2.hashCode() : 0);
            this.b = hashCode25;
            return hashCode25;
        }
        return i2;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.s != null) {
            sb.append(", installed=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", referrer=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", fq7=");
            sb.append(this.u);
        }
        if (this.v != null) {
            sb.append(", fq30=");
            sb.append(this.v);
        }
        if (!this.w.isEmpty()) {
            sb.append(", pushes=");
            sb.append(this.w);
        }
        if (this.x != null) {
            sb.append(", sessionTotalCount=");
            sb.append(this.x);
        }
        if (this.y != null) {
            sb.append(", sessionTotalDuration=");
            sb.append(this.y);
        }
        if (this.z != null) {
            sb.append(", sessionLastTime=");
            sb.append(this.z);
        }
        if (this.A != null) {
            sb.append(", sessionLastDuration=");
            sb.append(this.A);
        }
        if (this.B != null) {
            sb.append(", purchaseCurrency=");
            sb.append(this.B);
        }
        if (this.C != null) {
            sb.append(", purchaseTotalCount=");
            sb.append(this.C);
        }
        if (this.D != null) {
            sb.append(", purchaseTotalPrice=");
            sb.append(this.D);
        }
        if (this.E != null) {
            sb.append(", purchaseLastTime=");
            sb.append(this.E);
        }
        if (this.F != null) {
            sb.append(", purchaseLastPrice=");
            sb.append(this.F);
        }
        if (this.G != null) {
            sb.append(", idfa=");
            sb.append(this.G);
        }
        if (this.H != null) {
            sb.append(", idfaOptout=");
            sb.append(this.H);
        }
        if (this.I != null) {
            sb.append(", userId=");
            sb.append(this.I);
        }
        if (this.J != null) {
            sb.append(", userLevel=");
            sb.append(this.J);
        }
        if (this.K != null) {
            sb.append(", friendCount=");
            sb.append(this.K);
        }
        if (this.L != null) {
            sb.append(", uv1=");
            sb.append(this.L);
        }
        if (this.M != null) {
            sb.append(", uv2=");
            sb.append(this.M);
        }
        if (this.N != null) {
            sb.append(", uv3=");
            sb.append(this.N);
        }
        if (this.O != null) {
            sb.append(", uv4=");
            sb.append(this.O);
        }
        if (this.P != null) {
            sb.append(", uv5=");
            sb.append(this.P);
        }
        if (!this.Q.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.Q);
        }
        if (this.R != null) {
            sb.append(", pushOptout=");
            sb.append(this.R);
        }
        StringBuilder replace = sb.replace(0, 2, "User{");
        replace.append('}');
        return replace.toString();
    }

    /* loaded from: classes3.dex */
    static final class b extends ej {
        b() {
            super(eg.LENGTH_DELIMITED, fh.class);
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            fh fhVar = (fh) obj;
            Long l2 = fhVar.s;
            int a = l2 != null ? ej.f7405i.a(1, l2) : 0;
            String str = fhVar.t;
            int a2 = a + (str != null ? ej.p.a(2, str) : 0);
            Integer num = fhVar.u;
            int a3 = a2 + (num != null ? ej.f7400d.a(13, num) : 0);
            Integer num2 = fhVar.v;
            int a4 = a3 + (num2 != null ? ej.f7400d.a(14, num2) : 0) + fe.c.a().a(15, fhVar.w);
            Integer num3 = fhVar.x;
            int a5 = a4 + (num3 != null ? ej.f7400d.a(16, num3) : 0);
            Long l3 = fhVar.y;
            int a6 = a5 + (l3 != null ? ej.f7405i.a(17, l3) : 0);
            Long l4 = fhVar.z;
            int a7 = a6 + (l4 != null ? ej.f7405i.a(18, l4) : 0);
            Long l5 = fhVar.A;
            int a8 = a7 + (l5 != null ? ej.f7405i.a(19, l5) : 0);
            String str2 = fhVar.B;
            int a9 = a8 + (str2 != null ? ej.p.a(20, str2) : 0);
            Integer num4 = fhVar.C;
            int a10 = a9 + (num4 != null ? ej.f7400d.a(3, num4) : 0);
            Double d2 = fhVar.D;
            int a11 = a10 + (d2 != null ? ej.o.a(21, d2) : 0);
            Long l6 = fhVar.E;
            int a12 = a11 + (l6 != null ? ej.f7405i.a(4, l6) : 0);
            Double d3 = fhVar.F;
            int a13 = a12 + (d3 != null ? ej.o.a(22, d3) : 0);
            String str3 = fhVar.G;
            int a14 = a13 + (str3 != null ? ej.p.a(23, str3) : 0);
            Boolean bool = fhVar.H;
            int a15 = a14 + (bool != null ? ej.c.a(24, bool) : 0);
            String str4 = fhVar.I;
            int a16 = a15 + (str4 != null ? ej.p.a(5, str4) : 0);
            Integer num5 = fhVar.J;
            int a17 = a16 + (num5 != null ? ej.f7400d.a(6, num5) : 0);
            Integer num6 = fhVar.K;
            int a18 = a17 + (num6 != null ? ej.f7400d.a(7, num6) : 0);
            String str5 = fhVar.L;
            int a19 = a18 + (str5 != null ? ej.p.a(8, str5) : 0);
            String str6 = fhVar.M;
            int a20 = a19 + (str6 != null ? ej.p.a(9, str6) : 0);
            String str7 = fhVar.N;
            int a21 = a20 + (str7 != null ? ej.p.a(10, str7) : 0);
            String str8 = fhVar.O;
            int a22 = a21 + (str8 != null ? ej.p.a(11, str8) : 0);
            String str9 = fhVar.P;
            int a23 = a22 + (str9 != null ? ej.p.a(12, str9) : 0) + ej.p.a().a(26, fhVar.Q);
            Boolean bool2 = fhVar.R;
            return a23 + (bool2 != null ? ej.c.a(25, bool2) : 0) + fhVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            fh fhVar = (fh) obj;
            Long l2 = fhVar.s;
            if (l2 != null) {
                ej.f7405i.a(elVar, 1, l2);
            }
            String str = fhVar.t;
            if (str != null) {
                ej.p.a(elVar, 2, str);
            }
            Integer num = fhVar.u;
            if (num != null) {
                ej.f7400d.a(elVar, 13, num);
            }
            Integer num2 = fhVar.v;
            if (num2 != null) {
                ej.f7400d.a(elVar, 14, num2);
            }
            fe.c.a().a(elVar, 15, fhVar.w);
            Integer num3 = fhVar.x;
            if (num3 != null) {
                ej.f7400d.a(elVar, 16, num3);
            }
            Long l3 = fhVar.y;
            if (l3 != null) {
                ej.f7405i.a(elVar, 17, l3);
            }
            Long l4 = fhVar.z;
            if (l4 != null) {
                ej.f7405i.a(elVar, 18, l4);
            }
            Long l5 = fhVar.A;
            if (l5 != null) {
                ej.f7405i.a(elVar, 19, l5);
            }
            String str2 = fhVar.B;
            if (str2 != null) {
                ej.p.a(elVar, 20, str2);
            }
            Integer num4 = fhVar.C;
            if (num4 != null) {
                ej.f7400d.a(elVar, 3, num4);
            }
            Double d2 = fhVar.D;
            if (d2 != null) {
                ej.o.a(elVar, 21, d2);
            }
            Long l6 = fhVar.E;
            if (l6 != null) {
                ej.f7405i.a(elVar, 4, l6);
            }
            Double d3 = fhVar.F;
            if (d3 != null) {
                ej.o.a(elVar, 22, d3);
            }
            String str3 = fhVar.G;
            if (str3 != null) {
                ej.p.a(elVar, 23, str3);
            }
            Boolean bool = fhVar.H;
            if (bool != null) {
                ej.c.a(elVar, 24, bool);
            }
            String str4 = fhVar.I;
            if (str4 != null) {
                ej.p.a(elVar, 5, str4);
            }
            Integer num5 = fhVar.J;
            if (num5 != null) {
                ej.f7400d.a(elVar, 6, num5);
            }
            Integer num6 = fhVar.K;
            if (num6 != null) {
                ej.f7400d.a(elVar, 7, num6);
            }
            String str5 = fhVar.L;
            if (str5 != null) {
                ej.p.a(elVar, 8, str5);
            }
            String str6 = fhVar.M;
            if (str6 != null) {
                ej.p.a(elVar, 9, str6);
            }
            String str7 = fhVar.N;
            if (str7 != null) {
                ej.p.a(elVar, 10, str7);
            }
            String str8 = fhVar.O;
            if (str8 != null) {
                ej.p.a(elVar, 11, str8);
            }
            String str9 = fhVar.P;
            if (str9 != null) {
                ej.p.a(elVar, 12, str9);
            }
            ej.p.a().a(elVar, 26, fhVar.Q);
            Boolean bool2 = fhVar.R;
            if (bool2 != null) {
                ej.c.a(elVar, 25, bool2);
            }
            elVar.a(fhVar.a());
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ Object a(ek ekVar) {
            a aVar = new a();
            long a = ekVar.a();
            while (true) {
                int b = ekVar.b();
                if (b != -1) {
                    switch (b) {
                        case 1:
                            aVar.c = (Long) ej.f7405i.a(ekVar);
                            break;
                        case 2:
                            aVar.f7529d = (String) ej.p.a(ekVar);
                            break;
                        case 3:
                            aVar.m = (Integer) ej.f7400d.a(ekVar);
                            break;
                        case 4:
                            aVar.o = (Long) ej.f7405i.a(ekVar);
                            break;
                        case 5:
                            aVar.s = (String) ej.p.a(ekVar);
                            break;
                        case 6:
                            aVar.t = (Integer) ej.f7400d.a(ekVar);
                            break;
                        case 7:
                            aVar.u = (Integer) ej.f7400d.a(ekVar);
                            break;
                        case 8:
                            aVar.v = (String) ej.p.a(ekVar);
                            break;
                        case 9:
                            aVar.w = (String) ej.p.a(ekVar);
                            break;
                        case 10:
                            aVar.x = (String) ej.p.a(ekVar);
                            break;
                        case 11:
                            aVar.y = (String) ej.p.a(ekVar);
                            break;
                        case 12:
                            aVar.z = (String) ej.p.a(ekVar);
                            break;
                        case 13:
                            aVar.f7530e = (Integer) ej.f7400d.a(ekVar);
                            break;
                        case 14:
                            aVar.f7531f = (Integer) ej.f7400d.a(ekVar);
                            break;
                        case 15:
                            aVar.f7532g.add(fe.c.a(ekVar));
                            break;
                        case 16:
                            aVar.f7533h = (Integer) ej.f7400d.a(ekVar);
                            break;
                        case 17:
                            aVar.f7534i = (Long) ej.f7405i.a(ekVar);
                            break;
                        case 18:
                            aVar.f7535j = (Long) ej.f7405i.a(ekVar);
                            break;
                        case 19:
                            aVar.f7536k = (Long) ej.f7405i.a(ekVar);
                            break;
                        case 20:
                            aVar.f7537l = (String) ej.p.a(ekVar);
                            break;
                        case 21:
                            aVar.n = (Double) ej.o.a(ekVar);
                            break;
                        case 22:
                            aVar.p = (Double) ej.o.a(ekVar);
                            break;
                        case 23:
                            aVar.q = (String) ej.p.a(ekVar);
                            break;
                        case 24:
                            aVar.r = (Boolean) ej.c.a(ekVar);
                            break;
                        case 25:
                            aVar.B = (Boolean) ej.c.a(ekVar);
                            break;
                        case 26:
                            aVar.A.add(ej.p.a(ekVar));
                            break;
                        default:
                            eg c = ekVar.c();
                            aVar.a(b, c, c.a().a(ekVar));
                            break;
                    }
                } else {
                    ekVar.a(a);
                    return aVar.b();
                }
            }
        }
    }
}
