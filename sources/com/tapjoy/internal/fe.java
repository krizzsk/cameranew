package com.tapjoy.internal;

import com.tapjoy.TapjoyAuctionFlags;
import com.tapjoy.internal.eh;
/* loaded from: classes3.dex */
public final class fe extends eh {
    public static final ej c = new b();

    /* renamed from: d  reason: collision with root package name */
    public static final Long f7511d = 0L;

    /* renamed from: e  reason: collision with root package name */
    public static final Long f7512e = 0L;

    /* renamed from: f  reason: collision with root package name */
    public final String f7513f;

    /* renamed from: g  reason: collision with root package name */
    public final Long f7514g;

    /* renamed from: h  reason: collision with root package name */
    public final Long f7515h;

    /* loaded from: classes3.dex */
    public static final class a extends eh.a {
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public Long f7516d;

        /* renamed from: e  reason: collision with root package name */
        public Long f7517e;

        public final fe b() {
            String str = this.c;
            if (str == null || this.f7516d == null) {
                throw eo.a(str, TapjoyAuctionFlags.AUCTION_ID, this.f7516d, "received");
            }
            return new fe(this.c, this.f7516d, this.f7517e, super.a());
        }
    }

    public fe(String str, Long l2) {
        this(str, l2, null, iu.b);
    }

    public final a b() {
        a aVar = new a();
        aVar.c = this.f7513f;
        aVar.f7516d = this.f7514g;
        aVar.f7517e = this.f7515h;
        aVar.a(a());
        return aVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof fe) {
            fe feVar = (fe) obj;
            return a().equals(feVar.a()) && this.f7513f.equals(feVar.f7513f) && this.f7514g.equals(feVar.f7514g) && eo.a(this.f7515h, feVar.f7515h);
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.b;
        if (i2 == 0) {
            int hashCode = ((((a().hashCode() * 37) + this.f7513f.hashCode()) * 37) + this.f7514g.hashCode()) * 37;
            Long l2 = this.f7515h;
            int hashCode2 = hashCode + (l2 != null ? l2.hashCode() : 0);
            this.b = hashCode2;
            return hashCode2;
        }
        return i2;
    }

    @Override // com.tapjoy.internal.eh
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", id=");
        sb.append(this.f7513f);
        sb.append(", received=");
        sb.append(this.f7514g);
        if (this.f7515h != null) {
            sb.append(", clicked=");
            sb.append(this.f7515h);
        }
        StringBuilder replace = sb.replace(0, 2, "Push{");
        replace.append('}');
        return replace.toString();
    }

    public fe(String str, Long l2, Long l3, iu iuVar) {
        super(c, iuVar);
        this.f7513f = str;
        this.f7514g = l2;
        this.f7515h = l3;
    }

    /* loaded from: classes3.dex */
    static final class b extends ej {
        b() {
            super(eg.LENGTH_DELIMITED, fe.class);
        }

        @Override // com.tapjoy.internal.ej
        public final /* synthetic */ int a(Object obj) {
            fe feVar = (fe) obj;
            int a = ej.p.a(1, feVar.f7513f);
            ej ejVar = ej.f7405i;
            int a2 = a + ejVar.a(2, feVar.f7514g);
            Long l2 = feVar.f7515h;
            return a2 + (l2 != null ? ejVar.a(3, l2) : 0) + feVar.a().c();
        }

        @Override // com.tapjoy.internal.ej
        public final /* bridge */ /* synthetic */ void a(el elVar, Object obj) {
            fe feVar = (fe) obj;
            ej.p.a(elVar, 1, feVar.f7513f);
            ej ejVar = ej.f7405i;
            ejVar.a(elVar, 2, feVar.f7514g);
            Long l2 = feVar.f7515h;
            if (l2 != null) {
                ejVar.a(elVar, 3, l2);
            }
            elVar.a(feVar.a());
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
                    aVar.f7516d = (Long) ej.f7405i.a(ekVar);
                } else if (b != 3) {
                    eg c = ekVar.c();
                    aVar.a(b, c, c.a().a(ekVar));
                } else {
                    aVar.f7517e = (Long) ej.f7405i.a(ekVar);
                }
            }
        }
    }
}
