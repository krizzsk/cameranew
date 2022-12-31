package com.tapjoy.internal;

import com.tapjoy.internal.eh;
import com.tapjoy.internal.ej;
/* loaded from: classes3.dex */
public final class ex extends eh {
    public static final ej c = new b();

    /* renamed from: d  reason: collision with root package name */
    public static final ey f7451d = ey.APP;

    /* renamed from: e  reason: collision with root package name */
    public final ey f7452e;

    /* renamed from: f  reason: collision with root package name */
    public final String f7453f;

    /* renamed from: g  reason: collision with root package name */
    public final String f7454g;

    /* loaded from: classes3.dex */
    public static final class a extends eh.a {
        public ey c;

        /* renamed from: d  reason: collision with root package name */
        public String f7455d;

        /* renamed from: e  reason: collision with root package name */
        public String f7456e;

        public final ex b() {
            ey eyVar = this.c;
            if (eyVar == null || this.f7455d == null) {
                throw eo.a(eyVar, "type", this.f7455d, "name");
            }
            return new ex(this.c, this.f7455d, this.f7456e, super.a());
        }
    }

    public ex(ey eyVar, String str, String str2, iu iuVar) {
        super(c, iuVar);
        this.f7452e = eyVar;
        this.f7453f = str;
        this.f7454g = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ex) {
            ex exVar = (ex) obj;
            return a().equals(exVar.a()) && this.f7452e.equals(exVar.f7452e) && this.f7453f.equals(exVar.f7453f) && eo.a(this.f7454g, exVar.f7454g);
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.b;
        if (i2 == 0) {
            int hashCode = ((((a().hashCode() * 37) + this.f7452e.hashCode()) * 37) + this.f7453f.hashCode()) * 37;
            String str = this.f7454g;
            int hashCode2 = hashCode + (str != null ? str.hashCode() : 0);
            this.b = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", type=");
        sb.append(this.f7452e);
        sb.append(", name=");
        sb.append(this.f7453f);
        if (this.f7454g != null) {
            sb.append(", category=");
            sb.append(this.f7454g);
        }
        StringBuilder replace = sb.replace(0, 2, "EventGroup{");
        replace.append('}');
        return replace.toString();
    }

    /* loaded from: classes3.dex */
    static final class b extends ej {
        b() {
            super(eg.LENGTH_DELIMITED, ex.class);
        }

        private static ex b(ek ekVar) {
            a aVar = new a();
            long a = ekVar.a();
            while (true) {
                int b = ekVar.b();
                if (b == -1) {
                    ekVar.a(a);
                    return aVar.b();
                } else if (b == 1) {
                    try {
                        aVar.c = (ey) ey.ADAPTER.a(ekVar);
                    } catch (ej.a e2) {
                        aVar.a(b, eg.VARINT, Long.valueOf(e2.a));
                    }
                } else if (b == 2) {
                    aVar.f7455d = (String) ej.p.a(ekVar);
                } else if (b != 3) {
                    eg c = ekVar.c();
                    aVar.a(b, c, c.a().a(ekVar));
                } else {
                    aVar.f7456e = (String) ej.p.a(ekVar);
                }
            }
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            ex exVar = (ex) obj;
            int a = ey.ADAPTER.a(1, exVar.f7452e);
            ej ejVar = ej.p;
            int a2 = a + ejVar.a(2, exVar.f7453f);
            String str = exVar.f7454g;
            return a2 + (str != null ? ejVar.a(3, str) : 0) + exVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ Object a(ek ekVar) {
            return b(ekVar);
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            ex exVar = (ex) obj;
            ey.ADAPTER.a(elVar, 1, exVar.f7452e);
            ej ejVar = ej.p;
            ejVar.a(elVar, 2, exVar.f7453f);
            String str = exVar.f7454g;
            if (str != null) {
                ejVar.a(elVar, 3, str);
            }
            elVar.a(exVar.a());
        }
    }
}
