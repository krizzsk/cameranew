package com.tapjoy.internal;

import com.tapjoy.internal.eh;
/* loaded from: classes3.dex */
public final class eu extends eh {
    public static final ej c = new b();

    /* renamed from: d  reason: collision with root package name */
    public static final Integer f7422d = 0;

    /* renamed from: e  reason: collision with root package name */
    public final String f7423e;

    /* renamed from: f  reason: collision with root package name */
    public final Integer f7424f;

    /* renamed from: g  reason: collision with root package name */
    public final String f7425g;

    /* renamed from: h  reason: collision with root package name */
    public final String f7426h;

    /* renamed from: i  reason: collision with root package name */
    public final String f7427i;

    /* loaded from: classes3.dex */
    public static final class a extends eh.a {
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public Integer f7428d;

        /* renamed from: e  reason: collision with root package name */
        public String f7429e;

        /* renamed from: f  reason: collision with root package name */
        public String f7430f;

        /* renamed from: g  reason: collision with root package name */
        public String f7431g;

        public final eu b() {
            return new eu(this.c, this.f7428d, this.f7429e, this.f7430f, this.f7431g, super.a());
        }
    }

    public eu(String str, Integer num, String str2, String str3, String str4, iu iuVar) {
        super(c, iuVar);
        this.f7423e = str;
        this.f7424f = num;
        this.f7425g = str2;
        this.f7426h = str3;
        this.f7427i = str4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof eu) {
            eu euVar = (eu) obj;
            return a().equals(euVar.a()) && eo.a(this.f7423e, euVar.f7423e) && eo.a(this.f7424f, euVar.f7424f) && eo.a(this.f7425g, euVar.f7425g) && eo.a(this.f7426h, euVar.f7426h) && eo.a(this.f7427i, euVar.f7427i);
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.b;
        if (i2 == 0) {
            int hashCode = a().hashCode() * 37;
            String str = this.f7423e;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
            Integer num = this.f7424f;
            int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
            String str2 = this.f7425g;
            int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
            String str3 = this.f7426h;
            int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
            String str4 = this.f7427i;
            int hashCode6 = hashCode5 + (str4 != null ? str4.hashCode() : 0);
            this.b = hashCode6;
            return hashCode6;
        }
        return i2;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f7423e != null) {
            sb.append(", pkgVer=");
            sb.append(this.f7423e);
        }
        if (this.f7424f != null) {
            sb.append(", pkgRev=");
            sb.append(this.f7424f);
        }
        if (this.f7425g != null) {
            sb.append(", dataVer=");
            sb.append(this.f7425g);
        }
        if (this.f7426h != null) {
            sb.append(", installer=");
            sb.append(this.f7426h);
        }
        if (this.f7427i != null) {
            sb.append(", store=");
            sb.append(this.f7427i);
        }
        StringBuilder replace = sb.replace(0, 2, "App{");
        replace.append('}');
        return replace.toString();
    }

    /* loaded from: classes3.dex */
    static final class b extends ej {
        b() {
            super(eg.LENGTH_DELIMITED, eu.class);
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            eu euVar = (eu) obj;
            String str = euVar.f7423e;
            int a = str != null ? ej.p.a(1, str) : 0;
            Integer num = euVar.f7424f;
            int a2 = a + (num != null ? ej.f7400d.a(2, num) : 0);
            String str2 = euVar.f7425g;
            int a3 = a2 + (str2 != null ? ej.p.a(3, str2) : 0);
            String str3 = euVar.f7426h;
            int a4 = a3 + (str3 != null ? ej.p.a(4, str3) : 0);
            String str4 = euVar.f7427i;
            return a4 + (str4 != null ? ej.p.a(5, str4) : 0) + euVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            eu euVar = (eu) obj;
            String str = euVar.f7423e;
            if (str != null) {
                ej.p.a(elVar, 1, str);
            }
            Integer num = euVar.f7424f;
            if (num != null) {
                ej.f7400d.a(elVar, 2, num);
            }
            String str2 = euVar.f7425g;
            if (str2 != null) {
                ej.p.a(elVar, 3, str2);
            }
            String str3 = euVar.f7426h;
            if (str3 != null) {
                ej.p.a(elVar, 4, str3);
            }
            String str4 = euVar.f7427i;
            if (str4 != null) {
                ej.p.a(elVar, 5, str4);
            }
            elVar.a(euVar.a());
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ Object a(ek ekVar) {
            a aVar = new a();
            long a = ekVar.a();
            while (true) {
                int b = ekVar.b();
                if (b == -1) {
                    ekVar.a(a);
                    return aVar.b();
                } else if (b == 1) {
                    aVar.c = (String) ej.p.a(ekVar);
                } else if (b == 2) {
                    aVar.f7428d = (Integer) ej.f7400d.a(ekVar);
                } else if (b == 3) {
                    aVar.f7429e = (String) ej.p.a(ekVar);
                } else if (b == 4) {
                    aVar.f7430f = (String) ej.p.a(ekVar);
                } else if (b != 5) {
                    eg c = ekVar.c();
                    aVar.a(b, c, c.a().a(ekVar));
                } else {
                    aVar.f7431g = (String) ej.p.a(ekVar);
                }
            }
        }
    }
}
