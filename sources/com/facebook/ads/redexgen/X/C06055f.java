package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.5f  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06055f {
    public final long A00;
    public final EnumC06045e A01;
    public final String A02;
    public final boolean A03;

    public C06055f(String str, boolean z, EnumC06045e enumC06045e) {
        this(str, z, enumC06045e, System.currentTimeMillis());
    }

    public C06055f(String str, boolean z, EnumC06045e enumC06045e, long j2) {
        this.A02 = str;
        this.A03 = z;
        this.A01 = enumC06045e;
        this.A00 = j2;
    }

    public static C06055f A00() {
        return new C06055f("", true, EnumC06045e.A06, -1L);
    }

    public final long A01() {
        return this.A00;
    }

    public final EnumC06045e A02() {
        return this.A01;
    }

    public final String A03() {
        return this.A02;
    }

    public final boolean A04() {
        return this.A03;
    }
}
