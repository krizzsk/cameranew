package us.pinguo.repository2020.abtest;

import kotlin.jvm.internal.s;
/* compiled from: PriceAbTestManager.kt */
/* loaded from: classes6.dex */
public final class g {
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f11820d;

    public g(String id, String productId, String dollarPrice, String rmbPrice) {
        s.h(id, "id");
        s.h(productId, "productId");
        s.h(dollarPrice, "dollarPrice");
        s.h(rmbPrice, "rmbPrice");
        this.a = id;
        this.b = productId;
        this.c = dollarPrice;
        this.f11820d = rmbPrice;
    }

    public final String a() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return s.c(this.a, gVar.a) && s.c(this.b, gVar.b) && s.c(this.c, gVar.c) && s.c(this.f11820d, gVar.f11820d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.f11820d.hashCode();
    }

    public String toString() {
        return "PriceAbTestModel(id=" + this.a + ", productId=" + this.b + ", dollarPrice=" + this.c + ", rmbPrice=" + this.f11820d + ')';
    }
}
