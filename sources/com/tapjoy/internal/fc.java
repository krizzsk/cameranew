package com.tapjoy.internal;

import com.tapjoy.internal.eh;
/* loaded from: classes3.dex */
public final class fc extends eh {
    public static final ej c = new b();

    /* renamed from: d  reason: collision with root package name */
    public final String f7488d;

    /* renamed from: e  reason: collision with root package name */
    public final String f7489e;

    /* renamed from: f  reason: collision with root package name */
    public final String f7490f;

    /* loaded from: classes3.dex */
    public static final class a extends eh.a {
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public String f7491d;

        /* renamed from: e  reason: collision with root package name */
        public String f7492e;

        public final fc b() {
            return new fc(this.c, this.f7491d, this.f7492e, super.a());
        }
    }

    public fc(String str, String str2, String str3) {
        this(str, str2, str3, iu.b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof fc) {
            fc fcVar = (fc) obj;
            return a().equals(fcVar.a()) && eo.a(this.f7488d, fcVar.f7488d) && eo.a(this.f7489e, fcVar.f7489e) && eo.a(this.f7490f, fcVar.f7490f);
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.b;
        if (i2 == 0) {
            int hashCode = a().hashCode() * 37;
            String str = this.f7488d;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
            String str2 = this.f7489e;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
            String str3 = this.f7490f;
            int hashCode4 = hashCode3 + (str3 != null ? str3.hashCode() : 0);
            this.b = hashCode4;
            return hashCode4;
        }
        return i2;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f7488d != null) {
            sb.append(", fq7Change=");
            sb.append(this.f7488d);
        }
        if (this.f7489e != null) {
            sb.append(", fq30Change=");
            sb.append(this.f7489e);
        }
        if (this.f7490f != null) {
            sb.append(", pushId=");
            sb.append(this.f7490f);
        }
        StringBuilder replace = sb.replace(0, 2, "Meta{");
        replace.append('}');
        return replace.toString();
    }

    public fc(String str, String str2, String str3, iu iuVar) {
        super(c, iuVar);
        this.f7488d = str;
        this.f7489e = str2;
        this.f7490f = str3;
    }

    /* loaded from: classes3.dex */
    static final class b extends ej {
        b() {
            super(eg.LENGTH_DELIMITED, fc.class);
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            fc fcVar = (fc) obj;
            String str = fcVar.f7488d;
            int a = str != null ? ej.p.a(1, str) : 0;
            String str2 = fcVar.f7489e;
            int a2 = a + (str2 != null ? ej.p.a(2, str2) : 0);
            String str3 = fcVar.f7490f;
            return a2 + (str3 != null ? ej.p.a(3, str3) : 0) + fcVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            fc fcVar = (fc) obj;
            String str = fcVar.f7488d;
            if (str != null) {
                ej.p.a(elVar, 1, str);
            }
            String str2 = fcVar.f7489e;
            if (str2 != null) {
                ej.p.a(elVar, 2, str2);
            }
            String str3 = fcVar.f7490f;
            if (str3 != null) {
                ej.p.a(elVar, 3, str3);
            }
            elVar.a(fcVar.a());
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
                    aVar.f7491d = (String) ej.p.a(ekVar);
                } else if (b != 3) {
                    eg c = ekVar.c();
                    aVar.a(b, c, c.a().a(ekVar));
                } else {
                    aVar.f7492e = (String) ej.p.a(ekVar);
                }
            }
        }
    }
}
