package com.tapjoy.internal;

import com.tapjoy.internal.eh;
/* loaded from: classes3.dex */
public final class fa extends eh {
    public static final ej c = new b();

    /* renamed from: d  reason: collision with root package name */
    public static final Integer f7465d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static final Integer f7466e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static final Integer f7467f = 0;

    /* renamed from: g  reason: collision with root package name */
    public final String f7468g;

    /* renamed from: h  reason: collision with root package name */
    public final String f7469h;

    /* renamed from: i  reason: collision with root package name */
    public final String f7470i;

    /* renamed from: j  reason: collision with root package name */
    public final String f7471j;

    /* renamed from: k  reason: collision with root package name */
    public final String f7472k;

    /* renamed from: l  reason: collision with root package name */
    public final String f7473l;
    public final Integer m;
    public final Integer n;
    public final Integer o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;
    public final String u;
    public final String v;
    public final String w;
    public final String x;

    /* loaded from: classes3.dex */
    public static final class a extends eh.a {
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public String f7474d;

        /* renamed from: e  reason: collision with root package name */
        public String f7475e;

        /* renamed from: f  reason: collision with root package name */
        public String f7476f;

        /* renamed from: g  reason: collision with root package name */
        public String f7477g;

        /* renamed from: h  reason: collision with root package name */
        public String f7478h;

        /* renamed from: i  reason: collision with root package name */
        public Integer f7479i;

        /* renamed from: j  reason: collision with root package name */
        public Integer f7480j;

        /* renamed from: k  reason: collision with root package name */
        public Integer f7481k;

        /* renamed from: l  reason: collision with root package name */
        public String f7482l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;
        public String r;
        public String s;
        public String t;

        public final fa b() {
            return new fa(this.c, this.f7474d, this.f7475e, this.f7476f, this.f7477g, this.f7478h, this.f7479i, this.f7480j, this.f7481k, this.f7482l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, super.a());
        }
    }

    public fa(String str, String str2, String str3, String str4, String str5, String str6, Integer num, Integer num2, Integer num3, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, iu iuVar) {
        super(c, iuVar);
        this.f7468g = str;
        this.f7469h = str2;
        this.f7470i = str3;
        this.f7471j = str4;
        this.f7472k = str5;
        this.f7473l = str6;
        this.m = num;
        this.n = num2;
        this.o = num3;
        this.p = str7;
        this.q = str8;
        this.r = str9;
        this.s = str10;
        this.t = str11;
        this.u = str12;
        this.v = str13;
        this.w = str14;
        this.x = str15;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof fa) {
            fa faVar = (fa) obj;
            return a().equals(faVar.a()) && eo.a(this.f7468g, faVar.f7468g) && eo.a(this.f7469h, faVar.f7469h) && eo.a(this.f7470i, faVar.f7470i) && eo.a(this.f7471j, faVar.f7471j) && eo.a(this.f7472k, faVar.f7472k) && eo.a(this.f7473l, faVar.f7473l) && eo.a(this.m, faVar.m) && eo.a(this.n, faVar.n) && eo.a(this.o, faVar.o) && eo.a(this.p, faVar.p) && eo.a(this.q, faVar.q) && eo.a(this.r, faVar.r) && eo.a(this.s, faVar.s) && eo.a(this.t, faVar.t) && eo.a(this.u, faVar.u) && eo.a(this.v, faVar.v) && eo.a(this.w, faVar.w) && eo.a(this.x, faVar.x);
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.b;
        if (i2 == 0) {
            int hashCode = a().hashCode() * 37;
            String str = this.f7468g;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
            String str2 = this.f7469h;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
            String str3 = this.f7470i;
            int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
            String str4 = this.f7471j;
            int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
            String str5 = this.f7472k;
            int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
            String str6 = this.f7473l;
            int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
            Integer num = this.m;
            int hashCode8 = (hashCode7 + (num != null ? num.hashCode() : 0)) * 37;
            Integer num2 = this.n;
            int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
            Integer num3 = this.o;
            int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
            String str7 = this.p;
            int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 37;
            String str8 = this.q;
            int hashCode12 = (hashCode11 + (str8 != null ? str8.hashCode() : 0)) * 37;
            String str9 = this.r;
            int hashCode13 = (hashCode12 + (str9 != null ? str9.hashCode() : 0)) * 37;
            String str10 = this.s;
            int hashCode14 = (hashCode13 + (str10 != null ? str10.hashCode() : 0)) * 37;
            String str11 = this.t;
            int hashCode15 = (hashCode14 + (str11 != null ? str11.hashCode() : 0)) * 37;
            String str12 = this.u;
            int hashCode16 = (hashCode15 + (str12 != null ? str12.hashCode() : 0)) * 37;
            String str13 = this.v;
            int hashCode17 = (hashCode16 + (str13 != null ? str13.hashCode() : 0)) * 37;
            String str14 = this.w;
            int hashCode18 = (hashCode17 + (str14 != null ? str14.hashCode() : 0)) * 37;
            String str15 = this.x;
            int hashCode19 = hashCode18 + (str15 != null ? str15.hashCode() : 0);
            this.b = hashCode19;
            return hashCode19;
        }
        return i2;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f7468g != null) {
            sb.append(", mac=");
            sb.append(this.f7468g);
        }
        if (this.f7469h != null) {
            sb.append(", deviceId=");
            sb.append(this.f7469h);
        }
        if (this.f7470i != null) {
            sb.append(", deviceMaker=");
            sb.append(this.f7470i);
        }
        if (this.f7471j != null) {
            sb.append(", deviceModel=");
            sb.append(this.f7471j);
        }
        if (this.f7472k != null) {
            sb.append(", osName=");
            sb.append(this.f7472k);
        }
        if (this.f7473l != null) {
            sb.append(", osVer=");
            sb.append(this.f7473l);
        }
        if (this.m != null) {
            sb.append(", displayD=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", displayW=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", displayH=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", locale=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", timezone=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", pkgId=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", pkgSign=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", sdk=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", countrySim=");
            sb.append(this.u);
        }
        if (this.v != null) {
            sb.append(", countryNet=");
            sb.append(this.v);
        }
        if (this.w != null) {
            sb.append(", imei=");
            sb.append(this.w);
        }
        if (this.x != null) {
            sb.append(", androidId=");
            sb.append(this.x);
        }
        StringBuilder replace = sb.replace(0, 2, "Info{");
        replace.append('}');
        return replace.toString();
    }

    /* loaded from: classes3.dex */
    static final class b extends ej {
        b() {
            super(eg.LENGTH_DELIMITED, fa.class);
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            fa faVar = (fa) obj;
            String str = faVar.f7468g;
            int a = str != null ? ej.p.a(1, str) : 0;
            String str2 = faVar.f7469h;
            int a2 = a + (str2 != null ? ej.p.a(2, str2) : 0);
            String str3 = faVar.f7470i;
            int a3 = a2 + (str3 != null ? ej.p.a(3, str3) : 0);
            String str4 = faVar.f7471j;
            int a4 = a3 + (str4 != null ? ej.p.a(4, str4) : 0);
            String str5 = faVar.f7472k;
            int a5 = a4 + (str5 != null ? ej.p.a(5, str5) : 0);
            String str6 = faVar.f7473l;
            int a6 = a5 + (str6 != null ? ej.p.a(6, str6) : 0);
            Integer num = faVar.m;
            int a7 = a6 + (num != null ? ej.f7400d.a(7, num) : 0);
            Integer num2 = faVar.n;
            int a8 = a7 + (num2 != null ? ej.f7400d.a(8, num2) : 0);
            Integer num3 = faVar.o;
            int a9 = a8 + (num3 != null ? ej.f7400d.a(9, num3) : 0);
            String str7 = faVar.p;
            int a10 = a9 + (str7 != null ? ej.p.a(10, str7) : 0);
            String str8 = faVar.q;
            int a11 = a10 + (str8 != null ? ej.p.a(11, str8) : 0);
            String str9 = faVar.r;
            int a12 = a11 + (str9 != null ? ej.p.a(12, str9) : 0);
            String str10 = faVar.s;
            int a13 = a12 + (str10 != null ? ej.p.a(13, str10) : 0);
            String str11 = faVar.t;
            int a14 = a13 + (str11 != null ? ej.p.a(14, str11) : 0);
            String str12 = faVar.u;
            int a15 = a14 + (str12 != null ? ej.p.a(15, str12) : 0);
            String str13 = faVar.v;
            int a16 = a15 + (str13 != null ? ej.p.a(16, str13) : 0);
            String str14 = faVar.w;
            int a17 = a16 + (str14 != null ? ej.p.a(17, str14) : 0);
            String str15 = faVar.x;
            return a17 + (str15 != null ? ej.p.a(18, str15) : 0) + faVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            fa faVar = (fa) obj;
            String str = faVar.f7468g;
            if (str != null) {
                ej.p.a(elVar, 1, str);
            }
            String str2 = faVar.f7469h;
            if (str2 != null) {
                ej.p.a(elVar, 2, str2);
            }
            String str3 = faVar.f7470i;
            if (str3 != null) {
                ej.p.a(elVar, 3, str3);
            }
            String str4 = faVar.f7471j;
            if (str4 != null) {
                ej.p.a(elVar, 4, str4);
            }
            String str5 = faVar.f7472k;
            if (str5 != null) {
                ej.p.a(elVar, 5, str5);
            }
            String str6 = faVar.f7473l;
            if (str6 != null) {
                ej.p.a(elVar, 6, str6);
            }
            Integer num = faVar.m;
            if (num != null) {
                ej.f7400d.a(elVar, 7, num);
            }
            Integer num2 = faVar.n;
            if (num2 != null) {
                ej.f7400d.a(elVar, 8, num2);
            }
            Integer num3 = faVar.o;
            if (num3 != null) {
                ej.f7400d.a(elVar, 9, num3);
            }
            String str7 = faVar.p;
            if (str7 != null) {
                ej.p.a(elVar, 10, str7);
            }
            String str8 = faVar.q;
            if (str8 != null) {
                ej.p.a(elVar, 11, str8);
            }
            String str9 = faVar.r;
            if (str9 != null) {
                ej.p.a(elVar, 12, str9);
            }
            String str10 = faVar.s;
            if (str10 != null) {
                ej.p.a(elVar, 13, str10);
            }
            String str11 = faVar.t;
            if (str11 != null) {
                ej.p.a(elVar, 14, str11);
            }
            String str12 = faVar.u;
            if (str12 != null) {
                ej.p.a(elVar, 15, str12);
            }
            String str13 = faVar.v;
            if (str13 != null) {
                ej.p.a(elVar, 16, str13);
            }
            String str14 = faVar.w;
            if (str14 != null) {
                ej.p.a(elVar, 17, str14);
            }
            String str15 = faVar.x;
            if (str15 != null) {
                ej.p.a(elVar, 18, str15);
            }
            elVar.a(faVar.a());
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
                            aVar.f7474d = (String) ej.p.a(ekVar);
                            break;
                        case 3:
                            aVar.f7475e = (String) ej.p.a(ekVar);
                            break;
                        case 4:
                            aVar.f7476f = (String) ej.p.a(ekVar);
                            break;
                        case 5:
                            aVar.f7477g = (String) ej.p.a(ekVar);
                            break;
                        case 6:
                            aVar.f7478h = (String) ej.p.a(ekVar);
                            break;
                        case 7:
                            aVar.f7479i = (Integer) ej.f7400d.a(ekVar);
                            break;
                        case 8:
                            aVar.f7480j = (Integer) ej.f7400d.a(ekVar);
                            break;
                        case 9:
                            aVar.f7481k = (Integer) ej.f7400d.a(ekVar);
                            break;
                        case 10:
                            aVar.f7482l = (String) ej.p.a(ekVar);
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
                        case 15:
                            aVar.q = (String) ej.p.a(ekVar);
                            break;
                        case 16:
                            aVar.r = (String) ej.p.a(ekVar);
                            break;
                        case 17:
                            aVar.s = (String) ej.p.a(ekVar);
                            break;
                        case 18:
                            aVar.t = (String) ej.p.a(ekVar);
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
