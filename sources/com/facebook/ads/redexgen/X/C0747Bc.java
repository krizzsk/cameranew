package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
/* renamed from: com.facebook.ads.redexgen.X.Bc  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0747Bc extends VA implements FI {
    public long A00;
    public boolean A01;
    public final int A02;
    public final int A03;
    public final Uri A04;
    public final CS A05;
    public final HQ A06;
    @Nullable
    public final Object A07;
    public final String A08;

    public C0747Bc(Uri uri, HQ hq, CS cs, int i2, @Nullable String str, int i3, @Nullable Object obj) {
        this.A04 = uri;
        this.A06 = hq;
        this.A05 = cs;
        this.A03 = i2;
        this.A08 = str;
        this.A02 = i3;
        this.A00 = -9223372036854775807L;
        this.A07 = obj;
    }

    private void A00(long j2, boolean z) {
        this.A00 = j2;
        this.A01 = z;
        A01(new V1(this.A00, this.A01, false, this.A07), null);
    }

    @Override // com.facebook.ads.redexgen.X.VA
    public final void A02() {
    }

    @Override // com.facebook.ads.redexgen.X.VA
    public final void A03(InterfaceC1278Wo interfaceC1278Wo, boolean z) {
        A00(this.A00, false);
    }

    @Override // com.facebook.ads.redexgen.X.FN
    public final V3 A4O(FL fl, HJ hj) {
        I6.A03(fl.A02 == 0);
        return new C0755Bk(this.A04, this.A06.A4C(), this.A05.A4G(), this.A03, A00(fl), this, hj, this.A08, this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.FN
    public final void A9P() throws IOException {
    }

    @Override // com.facebook.ads.redexgen.X.FI
    public final void AC5(long j2, boolean z) {
        if (j2 == -9223372036854775807L) {
            j2 = this.A00;
        }
        if (this.A00 == j2 && this.A01 == z) {
            return;
        }
        A00(j2, z);
    }

    @Override // com.facebook.ads.redexgen.X.FN
    public final void ADX(V3 v3) {
        ((C0755Bk) v3).A0R();
    }
}
