package com.facebook.ads.redexgen.X;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Rg  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1143Rg extends C4A<C1137Ra> {
    public int A00;
    public int A01;
    public int A02;
    @Nullable
    public MU A03;
    public String A04;
    public List<PE> A05;
    public final SparseBooleanArray A06 = new SparseBooleanArray();
    public final AnonymousClass16 A07;
    public final C7J A08;
    public final XT A09;
    public final JT A0A;
    public final C1009Lz A0B;
    public final C1144Rh A0C;
    public final IS A0D;
    public final QZ A0E;

    public C1143Rg(XT xt, List<PE> list, AnonymousClass16 anonymousClass16, JT jt, C7J c7j, QZ qz, C1009Lz c1009Lz, MU mu, String str, C1144Rh c1144Rh, IS is) {
        this.A09 = xt;
        this.A0A = jt;
        this.A08 = c7j;
        this.A0E = qz;
        this.A0B = c1009Lz;
        this.A03 = mu;
        this.A07 = anonymousClass16;
        this.A05 = list;
        this.A04 = str;
        this.A0C = c1144Rh;
        this.A0D = is;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C4A
    @Nullable
    /* renamed from: A01 */
    public final C1137Ra A0C(ViewGroup viewGroup, int i2) {
        MU mu = this.A03;
        if (mu == null || this.A00 == 0) {
            return null;
        }
        return new C1137Ra(O2.A01(new OM(this.A09, this.A0A, mu, this.A07, null, this.A0E, this.A0B).A0I(this.A0D).A0J(), this.A04, this.A0C), this.A06, this.A0E, this.A05.size(), this.A09);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C4A
    /* renamed from: A02 */
    public final void A0E(C1137Ra c1137Ra, int i2) {
        c1137Ra.A0l(this.A05.get(i2), this.A0A, this.A08, this.A0B, this.A04, this.A00, this.A02, this.A01);
    }

    @Override // com.facebook.ads.redexgen.X.C4A
    public final int A0D() {
        return this.A05.size();
    }

    public final void A0F(int i2, int i3, int i4) {
        this.A00 = i2;
        this.A02 = i3;
        this.A01 = i4;
    }
}
