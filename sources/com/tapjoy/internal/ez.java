package com.tapjoy.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.internal.eh;
/* loaded from: classes3.dex */
public final class ez extends eh {
    public static final ej c = new b();

    /* renamed from: d  reason: collision with root package name */
    public static final Long f7457d = 0L;

    /* renamed from: e  reason: collision with root package name */
    public final String f7458e;

    /* renamed from: f  reason: collision with root package name */
    public final Long f7459f;

    /* loaded from: classes3.dex */
    public static final class a extends eh.a {
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public Long f7460d;

        public final ez b() {
            String str = this.c;
            if (str == null || this.f7460d == null) {
                throw eo.a(str, "name", this.f7460d, FirebaseAnalytics.Param.VALUE);
            }
            return new ez(this.c, this.f7460d, super.a());
        }
    }

    public ez(String str, Long l2) {
        this(str, l2, iu.b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ez) {
            ez ezVar = (ez) obj;
            return a().equals(ezVar.a()) && this.f7458e.equals(ezVar.f7458e) && this.f7459f.equals(ezVar.f7459f);
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.b;
        if (i2 == 0) {
            int hashCode = (((a().hashCode() * 37) + this.f7458e.hashCode()) * 37) + this.f7459f.hashCode();
            this.b = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", name=");
        sb.append(this.f7458e);
        sb.append(", value=");
        sb.append(this.f7459f);
        StringBuilder replace = sb.replace(0, 2, "EventValue{");
        replace.append('}');
        return replace.toString();
    }

    public ez(String str, Long l2, iu iuVar) {
        super(c, iuVar);
        this.f7458e = str;
        this.f7459f = l2;
    }

    /* loaded from: classes3.dex */
    static final class b extends ej {
        b() {
            super(eg.LENGTH_DELIMITED, ez.class);
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            ez ezVar = (ez) obj;
            return ej.p.a(1, ezVar.f7458e) + ej.f7405i.a(2, ezVar.f7459f) + ezVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            ez ezVar = (ez) obj;
            ej.p.a(elVar, 1, ezVar.f7458e);
            ej.f7405i.a(elVar, 2, ezVar.f7459f);
            elVar.a(ezVar.a());
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
                } else if (b != 2) {
                    eg c = ekVar.c();
                    aVar.a(b, c, c.a().a(ekVar));
                } else {
                    aVar.f7460d = (Long) ej.f7405i.a(ekVar);
                }
            }
        }
    }
}
