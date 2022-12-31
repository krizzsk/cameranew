package com.facebook.ads.redexgen.X;

import java.util.Set;
/* renamed from: com.facebook.ads.redexgen.X.Qj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1120Qj {
    public C1124Qn A00;
    public Set<String> A01;
    public Set<String> A02;
    public boolean A03;
    public boolean A04 = true;

    public final C1120Qj A00(C1124Qn c1124Qn) {
        this.A00 = c1124Qn;
        return this;
    }

    public final C1120Qj A01(Set<String> pinnedCertificates) {
        this.A01 = pinnedCertificates;
        return this;
    }

    public final C1120Qj A02(Set<String> pinnedPublicKeys) {
        this.A02 = pinnedPublicKeys;
        return this;
    }

    public final C1120Qj A03(boolean z) {
        this.A04 = z;
        return this;
    }

    public final C1120Qj A04(boolean z) {
        this.A03 = z;
        return this;
    }

    public final C1121Qk A05() {
        return new C1121Qk(this.A00, this.A04, this.A02, this.A01, this.A03);
    }
}
