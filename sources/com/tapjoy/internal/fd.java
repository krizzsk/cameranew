package com.tapjoy.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.tapjoy.internal.eh;
/* loaded from: classes3.dex */
public final class fd extends eh {
    public static final ej c = new b();

    /* renamed from: d  reason: collision with root package name */
    public static final Integer f7493d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static final Double f7494e = Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);

    /* renamed from: f  reason: collision with root package name */
    public static final Integer f7495f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final Long f7496g = 0L;

    /* renamed from: h  reason: collision with root package name */
    public final String f7497h;

    /* renamed from: i  reason: collision with root package name */
    public final Integer f7498i;

    /* renamed from: j  reason: collision with root package name */
    public final Double f7499j;

    /* renamed from: k  reason: collision with root package name */
    public final String f7500k;

    /* renamed from: l  reason: collision with root package name */
    public final String f7501l;
    public final String m;
    public final String n;
    public final String o;
    public final Integer p;
    public final Long q;
    public final String r;
    public final String s;
    public final String t;
    public final String u;

    /* loaded from: classes3.dex */
    public static final class a extends eh.a {
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public Integer f7502d;

        /* renamed from: e  reason: collision with root package name */
        public Double f7503e;

        /* renamed from: f  reason: collision with root package name */
        public String f7504f;

        /* renamed from: g  reason: collision with root package name */
        public String f7505g;

        /* renamed from: h  reason: collision with root package name */
        public String f7506h;

        /* renamed from: i  reason: collision with root package name */
        public String f7507i;

        /* renamed from: j  reason: collision with root package name */
        public String f7508j;

        /* renamed from: k  reason: collision with root package name */
        public Integer f7509k;

        /* renamed from: l  reason: collision with root package name */
        public Long f7510l;
        public String m;
        public String n;
        public String o;
        public String p;

        public final fd b() {
            String str = this.c;
            if (str != null) {
                return new fd(this.c, this.f7502d, this.f7503e, this.f7504f, this.f7505g, this.f7506h, this.f7507i, this.f7508j, this.f7509k, this.f7510l, this.m, this.n, this.o, this.p, super.a());
            }
            throw eo.a(str, "productId");
        }
    }

    public fd(String str, Integer num, Double d2, String str2, String str3, String str4, String str5, String str6, Integer num2, Long l2, String str7, String str8, String str9, String str10, iu iuVar) {
        super(c, iuVar);
        this.f7497h = str;
        this.f7498i = num;
        this.f7499j = d2;
        this.f7500k = str2;
        this.f7501l = str3;
        this.m = str4;
        this.n = str5;
        this.o = str6;
        this.p = num2;
        this.q = l2;
        this.r = str7;
        this.s = str8;
        this.t = str9;
        this.u = str10;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof fd) {
            fd fdVar = (fd) obj;
            return a().equals(fdVar.a()) && this.f7497h.equals(fdVar.f7497h) && eo.a(this.f7498i, fdVar.f7498i) && eo.a(this.f7499j, fdVar.f7499j) && eo.a(this.f7500k, fdVar.f7500k) && eo.a(this.f7501l, fdVar.f7501l) && eo.a(this.m, fdVar.m) && eo.a(this.n, fdVar.n) && eo.a(this.o, fdVar.o) && eo.a(this.p, fdVar.p) && eo.a(this.q, fdVar.q) && eo.a(this.r, fdVar.r) && eo.a(this.s, fdVar.s) && eo.a(this.t, fdVar.t) && eo.a(this.u, fdVar.u);
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.b;
        if (i2 == 0) {
            int hashCode = ((a().hashCode() * 37) + this.f7497h.hashCode()) * 37;
            Integer num = this.f7498i;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
            Double d2 = this.f7499j;
            int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 37;
            String str = this.f7500k;
            int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
            String str2 = this.f7501l;
            int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
            String str3 = this.m;
            int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
            String str4 = this.n;
            int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
            String str5 = this.o;
            int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 37;
            Integer num2 = this.p;
            int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
            Long l2 = this.q;
            int hashCode10 = (hashCode9 + (l2 != null ? l2.hashCode() : 0)) * 37;
            String str6 = this.r;
            int hashCode11 = (hashCode10 + (str6 != null ? str6.hashCode() : 0)) * 37;
            String str7 = this.s;
            int hashCode12 = (hashCode11 + (str7 != null ? str7.hashCode() : 0)) * 37;
            String str8 = this.t;
            int hashCode13 = (hashCode12 + (str8 != null ? str8.hashCode() : 0)) * 37;
            String str9 = this.u;
            int hashCode14 = hashCode13 + (str9 != null ? str9.hashCode() : 0);
            this.b = hashCode14;
            return hashCode14;
        }
        return i2;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", productId=");
        sb.append(this.f7497h);
        if (this.f7498i != null) {
            sb.append(", productQuantity=");
            sb.append(this.f7498i);
        }
        if (this.f7499j != null) {
            sb.append(", productPrice=");
            sb.append(this.f7499j);
        }
        if (this.f7500k != null) {
            sb.append(", productPriceCurrency=");
            sb.append(this.f7500k);
        }
        if (this.f7501l != null) {
            sb.append(", productType=");
            sb.append(this.f7501l);
        }
        if (this.m != null) {
            sb.append(", productTitle=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", productDescription=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", transactionId=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", transactionState=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", transactionDate=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", campaignId=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", currencyPrice=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", receipt=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", signature=");
            sb.append(this.u);
        }
        StringBuilder replace = sb.replace(0, 2, "Purchase{");
        replace.append('}');
        return replace.toString();
    }

    /* loaded from: classes3.dex */
    static final class b extends ej {
        b() {
            super(eg.LENGTH_DELIMITED, fd.class);
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            fd fdVar = (fd) obj;
            ej ejVar = ej.p;
            int a = ejVar.a(1, fdVar.f7497h);
            Integer num = fdVar.f7498i;
            int a2 = a + (num != null ? ej.f7400d.a(2, num) : 0);
            Double d2 = fdVar.f7499j;
            int a3 = a2 + (d2 != null ? ej.o.a(3, d2) : 0);
            String str = fdVar.f7500k;
            int a4 = a3 + (str != null ? ejVar.a(4, str) : 0);
            String str2 = fdVar.f7501l;
            int a5 = a4 + (str2 != null ? ejVar.a(5, str2) : 0);
            String str3 = fdVar.m;
            int a6 = a5 + (str3 != null ? ejVar.a(6, str3) : 0);
            String str4 = fdVar.n;
            int a7 = a6 + (str4 != null ? ejVar.a(7, str4) : 0);
            String str5 = fdVar.o;
            int a8 = a7 + (str5 != null ? ejVar.a(8, str5) : 0);
            Integer num2 = fdVar.p;
            int a9 = a8 + (num2 != null ? ej.f7400d.a(9, num2) : 0);
            Long l2 = fdVar.q;
            int a10 = a9 + (l2 != null ? ej.f7405i.a(10, l2) : 0);
            String str6 = fdVar.r;
            int a11 = a10 + (str6 != null ? ejVar.a(11, str6) : 0);
            String str7 = fdVar.s;
            int a12 = a11 + (str7 != null ? ejVar.a(12, str7) : 0);
            String str8 = fdVar.t;
            int a13 = a12 + (str8 != null ? ejVar.a(13, str8) : 0);
            String str9 = fdVar.u;
            return a13 + (str9 != null ? ejVar.a(14, str9) : 0) + fdVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            fd fdVar = (fd) obj;
            ej ejVar = ej.p;
            ejVar.a(elVar, 1, fdVar.f7497h);
            Integer num = fdVar.f7498i;
            if (num != null) {
                ej.f7400d.a(elVar, 2, num);
            }
            Double d2 = fdVar.f7499j;
            if (d2 != null) {
                ej.o.a(elVar, 3, d2);
            }
            String str = fdVar.f7500k;
            if (str != null) {
                ejVar.a(elVar, 4, str);
            }
            String str2 = fdVar.f7501l;
            if (str2 != null) {
                ejVar.a(elVar, 5, str2);
            }
            String str3 = fdVar.m;
            if (str3 != null) {
                ejVar.a(elVar, 6, str3);
            }
            String str4 = fdVar.n;
            if (str4 != null) {
                ejVar.a(elVar, 7, str4);
            }
            String str5 = fdVar.o;
            if (str5 != null) {
                ejVar.a(elVar, 8, str5);
            }
            Integer num2 = fdVar.p;
            if (num2 != null) {
                ej.f7400d.a(elVar, 9, num2);
            }
            Long l2 = fdVar.q;
            if (l2 != null) {
                ej.f7405i.a(elVar, 10, l2);
            }
            String str6 = fdVar.r;
            if (str6 != null) {
                ejVar.a(elVar, 11, str6);
            }
            String str7 = fdVar.s;
            if (str7 != null) {
                ejVar.a(elVar, 12, str7);
            }
            String str8 = fdVar.t;
            if (str8 != null) {
                ejVar.a(elVar, 13, str8);
            }
            String str9 = fdVar.u;
            if (str9 != null) {
                ejVar.a(elVar, 14, str9);
            }
            elVar.a(fdVar.a());
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
                            aVar.c = (String) ej.p.a(ekVar);
                            break;
                        case 2:
                            aVar.f7502d = (Integer) ej.f7400d.a(ekVar);
                            break;
                        case 3:
                            aVar.f7503e = (Double) ej.o.a(ekVar);
                            break;
                        case 4:
                            aVar.f7504f = (String) ej.p.a(ekVar);
                            break;
                        case 5:
                            aVar.f7505g = (String) ej.p.a(ekVar);
                            break;
                        case 6:
                            aVar.f7506h = (String) ej.p.a(ekVar);
                            break;
                        case 7:
                            aVar.f7507i = (String) ej.p.a(ekVar);
                            break;
                        case 8:
                            aVar.f7508j = (String) ej.p.a(ekVar);
                            break;
                        case 9:
                            aVar.f7509k = (Integer) ej.f7400d.a(ekVar);
                            break;
                        case 10:
                            aVar.f7510l = (Long) ej.f7405i.a(ekVar);
                            break;
                        case 11:
                            aVar.m = (String) ej.p.a(ekVar);
                            break;
                        case 12:
                            aVar.n = (String) ej.p.a(ekVar);
                            break;
                        case 13:
                            aVar.o = (String) ej.p.a(ekVar);
                            break;
                        case 14:
                            aVar.p = (String) ej.p.a(ekVar);
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
