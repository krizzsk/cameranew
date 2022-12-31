package com.tapjoy.internal;

import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.internal.eh;
import com.tapjoy.internal.ej;
import com.tencent.matrix.report.Issue;
import java.util.List;
/* loaded from: classes3.dex */
public final class ev extends eh {
    public static final ej c = new b();

    /* renamed from: d  reason: collision with root package name */
    public static final ey f7432d = ey.APP;

    /* renamed from: e  reason: collision with root package name */
    public static final Long f7433e = 0L;

    /* renamed from: f  reason: collision with root package name */
    public static final Long f7434f = 0L;

    /* renamed from: g  reason: collision with root package name */
    public static final Long f7435g = 0L;

    /* renamed from: h  reason: collision with root package name */
    public static final Long f7436h = 0L;

    /* renamed from: i  reason: collision with root package name */
    public static final Integer f7437i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static final Integer f7438j = 0;

    /* renamed from: k  reason: collision with root package name */
    public static final Integer f7439k = 0;

    /* renamed from: l  reason: collision with root package name */
    public static final Long f7440l = 0L;
    public static final Long m = 0L;
    public final fd A;
    public final String B;
    public final String C;
    public final fc D;
    public final String E;
    public final String F;
    public final String G;
    public final List H;
    public final String I;
    public final Integer J;
    public final Long K;
    public final Long L;
    public final ey n;
    public final String o;
    public final Long p;
    public final Long q;
    public final String r;
    public final Long s;
    public final Long t;
    public final fa u;
    public final eu v;
    public final fh w;
    public final Integer x;
    public final Integer y;
    public final ex z;

    /* loaded from: classes3.dex */
    public static final class a extends eh.a {
        public Long A;
        public ey c;

        /* renamed from: d  reason: collision with root package name */
        public String f7441d;

        /* renamed from: e  reason: collision with root package name */
        public Long f7442e;

        /* renamed from: f  reason: collision with root package name */
        public Long f7443f;

        /* renamed from: g  reason: collision with root package name */
        public String f7444g;

        /* renamed from: h  reason: collision with root package name */
        public Long f7445h;

        /* renamed from: i  reason: collision with root package name */
        public Long f7446i;

        /* renamed from: j  reason: collision with root package name */
        public fa f7447j;

        /* renamed from: k  reason: collision with root package name */
        public eu f7448k;

        /* renamed from: l  reason: collision with root package name */
        public fh f7449l;
        public Integer m;
        public Integer n;
        public ex o;
        public fd p;
        public String q;
        public String r;
        public fc s;
        public String t;
        public String u;
        public String v;
        public List w = eo.a();
        public String x;
        public Integer y;
        public Long z;

        public final ev b() {
            ey eyVar = this.c;
            if (eyVar == null || this.f7441d == null || this.f7442e == null) {
                throw eo.a(eyVar, "type", this.f7441d, "name", this.f7442e, Issue.ISSUE_REPORT_TIME);
            }
            return new ev(this.c, this.f7441d, this.f7442e, this.f7443f, this.f7444g, this.f7445h, this.f7446i, this.f7447j, this.f7448k, this.f7449l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, super.a());
        }
    }

    public ev(ey eyVar, String str, Long l2, Long l3, String str2, Long l4, Long l5, fa faVar, eu euVar, fh fhVar, Integer num, Integer num2, ex exVar, fd fdVar, String str3, String str4, fc fcVar, String str5, String str6, String str7, List list, String str8, Integer num3, Long l6, Long l7, iu iuVar) {
        super(c, iuVar);
        this.n = eyVar;
        this.o = str;
        this.p = l2;
        this.q = l3;
        this.r = str2;
        this.s = l4;
        this.t = l5;
        this.u = faVar;
        this.v = euVar;
        this.w = fhVar;
        this.x = num;
        this.y = num2;
        this.z = exVar;
        this.A = fdVar;
        this.B = str3;
        this.C = str4;
        this.D = fcVar;
        this.E = str5;
        this.F = str6;
        this.G = str7;
        this.H = eo.a(TJAdUnitConstants.String.USAGE_TRACKER_VALUES, list);
        this.I = str8;
        this.J = num3;
        this.K = l6;
        this.L = l7;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ev) {
            ev evVar = (ev) obj;
            return a().equals(evVar.a()) && this.n.equals(evVar.n) && this.o.equals(evVar.o) && this.p.equals(evVar.p) && eo.a(this.q, evVar.q) && eo.a(this.r, evVar.r) && eo.a(this.s, evVar.s) && eo.a(this.t, evVar.t) && eo.a(this.u, evVar.u) && eo.a(this.v, evVar.v) && eo.a(this.w, evVar.w) && eo.a(this.x, evVar.x) && eo.a(this.y, evVar.y) && eo.a(this.z, evVar.z) && eo.a(this.A, evVar.A) && eo.a(this.B, evVar.B) && eo.a(this.C, evVar.C) && eo.a(this.D, evVar.D) && eo.a(this.E, evVar.E) && eo.a(this.F, evVar.F) && eo.a(this.G, evVar.G) && this.H.equals(evVar.H) && eo.a(this.I, evVar.I) && eo.a(this.J, evVar.J) && eo.a(this.K, evVar.K) && eo.a(this.L, evVar.L);
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.b;
        if (i2 == 0) {
            int hashCode = ((((((a().hashCode() * 37) + this.n.hashCode()) * 37) + this.o.hashCode()) * 37) + this.p.hashCode()) * 37;
            Long l2 = this.q;
            int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
            String str = this.r;
            int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
            Long l3 = this.s;
            int hashCode4 = (hashCode3 + (l3 != null ? l3.hashCode() : 0)) * 37;
            Long l4 = this.t;
            int hashCode5 = (hashCode4 + (l4 != null ? l4.hashCode() : 0)) * 37;
            fa faVar = this.u;
            int hashCode6 = (hashCode5 + (faVar != null ? faVar.hashCode() : 0)) * 37;
            eu euVar = this.v;
            int hashCode7 = (hashCode6 + (euVar != null ? euVar.hashCode() : 0)) * 37;
            fh fhVar = this.w;
            int hashCode8 = (hashCode7 + (fhVar != null ? fhVar.hashCode() : 0)) * 37;
            Integer num = this.x;
            int hashCode9 = (hashCode8 + (num != null ? num.hashCode() : 0)) * 37;
            Integer num2 = this.y;
            int hashCode10 = (hashCode9 + (num2 != null ? num2.hashCode() : 0)) * 37;
            ex exVar = this.z;
            int hashCode11 = (hashCode10 + (exVar != null ? exVar.hashCode() : 0)) * 37;
            fd fdVar = this.A;
            int hashCode12 = (hashCode11 + (fdVar != null ? fdVar.hashCode() : 0)) * 37;
            String str2 = this.B;
            int hashCode13 = (hashCode12 + (str2 != null ? str2.hashCode() : 0)) * 37;
            String str3 = this.C;
            int hashCode14 = (hashCode13 + (str3 != null ? str3.hashCode() : 0)) * 37;
            fc fcVar = this.D;
            int hashCode15 = (hashCode14 + (fcVar != null ? fcVar.hashCode() : 0)) * 37;
            String str4 = this.E;
            int hashCode16 = (hashCode15 + (str4 != null ? str4.hashCode() : 0)) * 37;
            String str5 = this.F;
            int hashCode17 = (hashCode16 + (str5 != null ? str5.hashCode() : 0)) * 37;
            String str6 = this.G;
            int hashCode18 = (((hashCode17 + (str6 != null ? str6.hashCode() : 0)) * 37) + this.H.hashCode()) * 37;
            String str7 = this.I;
            int hashCode19 = (hashCode18 + (str7 != null ? str7.hashCode() : 0)) * 37;
            Integer num3 = this.J;
            int hashCode20 = (hashCode19 + (num3 != null ? num3.hashCode() : 0)) * 37;
            Long l5 = this.K;
            int hashCode21 = (hashCode20 + (l5 != null ? l5.hashCode() : 0)) * 37;
            Long l6 = this.L;
            int hashCode22 = hashCode21 + (l6 != null ? l6.hashCode() : 0);
            this.b = hashCode22;
            return hashCode22;
        }
        return i2;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", type=");
        sb.append(this.n);
        sb.append(", name=");
        sb.append(this.o);
        sb.append(", time=");
        sb.append(this.p);
        if (this.q != null) {
            sb.append(", systemTime=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", instanceId=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", elapsedRealtime=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", duration=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", info=");
            sb.append(this.u);
        }
        if (this.v != null) {
            sb.append(", app=");
            sb.append(this.v);
        }
        if (this.w != null) {
            sb.append(", user=");
            sb.append(this.w);
        }
        if (this.x != null) {
            sb.append(", xxx_session_seq=");
            sb.append(this.x);
        }
        if (this.y != null) {
            sb.append(", eventSeq=");
            sb.append(this.y);
        }
        if (this.z != null) {
            sb.append(", eventPrev=");
            sb.append(this.z);
        }
        if (this.A != null) {
            sb.append(", purchase=");
            sb.append(this.A);
        }
        if (this.B != null) {
            sb.append(", exception=");
            sb.append(this.B);
        }
        if (this.C != null) {
            sb.append(", metaBase=");
            sb.append(this.C);
        }
        if (this.D != null) {
            sb.append(", meta=");
            sb.append(this.D);
        }
        if (this.E != null) {
            sb.append(", category=");
            sb.append(this.E);
        }
        if (this.F != null) {
            sb.append(", p1=");
            sb.append(this.F);
        }
        if (this.G != null) {
            sb.append(", p2=");
            sb.append(this.G);
        }
        if (!this.H.isEmpty()) {
            sb.append(", values=");
            sb.append(this.H);
        }
        if (this.I != null) {
            sb.append(", dimensions=");
            sb.append(this.I);
        }
        if (this.J != null) {
            sb.append(", count=");
            sb.append(this.J);
        }
        if (this.K != null) {
            sb.append(", firstTime=");
            sb.append(this.K);
        }
        if (this.L != null) {
            sb.append(", lastTime=");
            sb.append(this.L);
        }
        StringBuilder replace = sb.replace(0, 2, "Event{");
        replace.append('}');
        return replace.toString();
    }

    /* loaded from: classes3.dex */
    static final class b extends ej {
        b() {
            super(eg.LENGTH_DELIMITED, ev.class);
        }

        private static ev b(ek ekVar) {
            a aVar = new a();
            long a = ekVar.a();
            while (true) {
                int b = ekVar.b();
                if (b != -1) {
                    switch (b) {
                        case 1:
                            try {
                                aVar.c = (ey) ey.ADAPTER.a(ekVar);
                                break;
                            } catch (ej.a e2) {
                                aVar.a(b, eg.VARINT, Long.valueOf(e2.a));
                                break;
                            }
                        case 2:
                            aVar.f7441d = (String) ej.p.a(ekVar);
                            break;
                        case 3:
                            aVar.f7442e = (Long) ej.f7405i.a(ekVar);
                            break;
                        case 4:
                            aVar.f7446i = (Long) ej.f7405i.a(ekVar);
                            break;
                        case 5:
                            aVar.f7447j = (fa) fa.c.a(ekVar);
                            break;
                        case 6:
                            aVar.f7448k = (eu) eu.c.a(ekVar);
                            break;
                        case 7:
                            aVar.f7449l = (fh) fh.c.a(ekVar);
                            break;
                        case 8:
                            aVar.m = (Integer) ej.f7400d.a(ekVar);
                            break;
                        case 9:
                            aVar.n = (Integer) ej.f7400d.a(ekVar);
                            break;
                        case 10:
                            aVar.o = (ex) ex.c.a(ekVar);
                            break;
                        case 11:
                            aVar.p = (fd) fd.c.a(ekVar);
                            break;
                        case 12:
                            aVar.q = (String) ej.p.a(ekVar);
                            break;
                        case 13:
                            aVar.r = (String) ej.p.a(ekVar);
                            break;
                        case 14:
                            aVar.t = (String) ej.p.a(ekVar);
                            break;
                        case 15:
                            aVar.u = (String) ej.p.a(ekVar);
                            break;
                        case 16:
                            aVar.v = (String) ej.p.a(ekVar);
                            break;
                        case 17:
                            aVar.w.add(ez.c.a(ekVar));
                            break;
                        case 18:
                            aVar.s = (fc) fc.c.a(ekVar);
                            break;
                        case 19:
                            aVar.f7443f = (Long) ej.f7405i.a(ekVar);
                            break;
                        case 20:
                            aVar.f7444g = (String) ej.p.a(ekVar);
                            break;
                        case 21:
                            aVar.f7445h = (Long) ej.f7405i.a(ekVar);
                            break;
                        case 22:
                            aVar.x = (String) ej.p.a(ekVar);
                            break;
                        case 23:
                            aVar.y = (Integer) ej.f7400d.a(ekVar);
                            break;
                        case 24:
                            aVar.z = (Long) ej.f7405i.a(ekVar);
                            break;
                        case 25:
                            aVar.A = (Long) ej.f7405i.a(ekVar);
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

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            ev evVar = (ev) obj;
            int a = ey.ADAPTER.a(1, evVar.n);
            ej ejVar = ej.p;
            int a2 = a + ejVar.a(2, evVar.o);
            ej ejVar2 = ej.f7405i;
            int a3 = a2 + ejVar2.a(3, evVar.p);
            Long l2 = evVar.q;
            int a4 = a3 + (l2 != null ? ejVar2.a(19, l2) : 0);
            String str = evVar.r;
            int a5 = a4 + (str != null ? ejVar.a(20, str) : 0);
            Long l3 = evVar.s;
            int a6 = a5 + (l3 != null ? ejVar2.a(21, l3) : 0);
            Long l4 = evVar.t;
            int a7 = a6 + (l4 != null ? ejVar2.a(4, l4) : 0);
            fa faVar = evVar.u;
            int a8 = a7 + (faVar != null ? fa.c.a(5, faVar) : 0);
            eu euVar = evVar.v;
            int a9 = a8 + (euVar != null ? eu.c.a(6, euVar) : 0);
            fh fhVar = evVar.w;
            int a10 = a9 + (fhVar != null ? fh.c.a(7, fhVar) : 0);
            Integer num = evVar.x;
            int a11 = a10 + (num != null ? ej.f7400d.a(8, num) : 0);
            Integer num2 = evVar.y;
            int a12 = a11 + (num2 != null ? ej.f7400d.a(9, num2) : 0);
            ex exVar = evVar.z;
            int a13 = a12 + (exVar != null ? ex.c.a(10, exVar) : 0);
            fd fdVar = evVar.A;
            int a14 = a13 + (fdVar != null ? fd.c.a(11, fdVar) : 0);
            String str2 = evVar.B;
            int a15 = a14 + (str2 != null ? ejVar.a(12, str2) : 0);
            String str3 = evVar.C;
            int a16 = a15 + (str3 != null ? ejVar.a(13, str3) : 0);
            fc fcVar = evVar.D;
            int a17 = a16 + (fcVar != null ? fc.c.a(18, fcVar) : 0);
            String str4 = evVar.E;
            int a18 = a17 + (str4 != null ? ejVar.a(14, str4) : 0);
            String str5 = evVar.F;
            int a19 = a18 + (str5 != null ? ejVar.a(15, str5) : 0);
            String str6 = evVar.G;
            int a20 = a19 + (str6 != null ? ejVar.a(16, str6) : 0) + ez.c.a().a(17, evVar.H);
            String str7 = evVar.I;
            int a21 = a20 + (str7 != null ? ejVar.a(22, str7) : 0);
            Integer num3 = evVar.J;
            int a22 = a21 + (num3 != null ? ej.f7400d.a(23, num3) : 0);
            Long l5 = evVar.K;
            int a23 = a22 + (l5 != null ? ejVar2.a(24, l5) : 0);
            Long l6 = evVar.L;
            return a23 + (l6 != null ? ejVar2.a(25, l6) : 0) + evVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ Object a(ek ekVar) {
            return b(ekVar);
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            ev evVar = (ev) obj;
            ey.ADAPTER.a(elVar, 1, evVar.n);
            ej ejVar = ej.p;
            ejVar.a(elVar, 2, evVar.o);
            ej ejVar2 = ej.f7405i;
            ejVar2.a(elVar, 3, evVar.p);
            Long l2 = evVar.q;
            if (l2 != null) {
                ejVar2.a(elVar, 19, l2);
            }
            String str = evVar.r;
            if (str != null) {
                ejVar.a(elVar, 20, str);
            }
            Long l3 = evVar.s;
            if (l3 != null) {
                ejVar2.a(elVar, 21, l3);
            }
            Long l4 = evVar.t;
            if (l4 != null) {
                ejVar2.a(elVar, 4, l4);
            }
            fa faVar = evVar.u;
            if (faVar != null) {
                fa.c.a(elVar, 5, faVar);
            }
            eu euVar = evVar.v;
            if (euVar != null) {
                eu.c.a(elVar, 6, euVar);
            }
            fh fhVar = evVar.w;
            if (fhVar != null) {
                fh.c.a(elVar, 7, fhVar);
            }
            Integer num = evVar.x;
            if (num != null) {
                ej.f7400d.a(elVar, 8, num);
            }
            Integer num2 = evVar.y;
            if (num2 != null) {
                ej.f7400d.a(elVar, 9, num2);
            }
            ex exVar = evVar.z;
            if (exVar != null) {
                ex.c.a(elVar, 10, exVar);
            }
            fd fdVar = evVar.A;
            if (fdVar != null) {
                fd.c.a(elVar, 11, fdVar);
            }
            String str2 = evVar.B;
            if (str2 != null) {
                ejVar.a(elVar, 12, str2);
            }
            String str3 = evVar.C;
            if (str3 != null) {
                ejVar.a(elVar, 13, str3);
            }
            fc fcVar = evVar.D;
            if (fcVar != null) {
                fc.c.a(elVar, 18, fcVar);
            }
            String str4 = evVar.E;
            if (str4 != null) {
                ejVar.a(elVar, 14, str4);
            }
            String str5 = evVar.F;
            if (str5 != null) {
                ejVar.a(elVar, 15, str5);
            }
            String str6 = evVar.G;
            if (str6 != null) {
                ejVar.a(elVar, 16, str6);
            }
            ez.c.a().a(elVar, 17, evVar.H);
            String str7 = evVar.I;
            if (str7 != null) {
                ejVar.a(elVar, 22, str7);
            }
            Integer num3 = evVar.J;
            if (num3 != null) {
                ej.f7400d.a(elVar, 23, num3);
            }
            Long l5 = evVar.K;
            if (l5 != null) {
                ejVar2.a(elVar, 24, l5);
            }
            Long l6 = evVar.L;
            if (l6 != null) {
                ejVar2.a(elVar, 25, l6);
            }
            elVar.a(evVar.a());
        }
    }
}
