package com.facebook.ads.redexgen.X;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class RZ extends C4A<RT> {
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    @Nullable
    public MU A04;
    public String A05;
    public List<PE> A06;
    public final SparseBooleanArray A07 = new SparseBooleanArray();
    public final AnonymousClass16 A08;
    public final C7J A09;
    public final XT A0A;
    public final JT A0B;
    public final C1009Lz A0C;
    public final C1144Rh A0D;
    public final QZ A0E;

    public RZ(XT xt, List<PE> list, AnonymousClass16 anonymousClass16, JT jt, C7J c7j, QZ qz, C1009Lz c1009Lz, MU mu, String str, int i2, int i3, int i4, int i5, C1144Rh c1144Rh) {
        this.A0A = xt;
        this.A0B = jt;
        this.A09 = c7j;
        this.A0E = qz;
        this.A0C = c1009Lz;
        this.A04 = mu;
        this.A08 = anonymousClass16;
        this.A06 = list;
        this.A00 = i2;
        this.A03 = i5;
        this.A05 = str;
        this.A01 = i4;
        this.A02 = i3;
        this.A0D = c1144Rh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C4A
    /* renamed from: A01 */
    public final RT A0C(ViewGroup viewGroup, int i2) {
        return new RT(C1061Oa.A00(new OM(this.A0A, this.A0B, this.A04, this.A08, null, this.A0E, this.A0C).A0J(), this.A03, this.A05, this.A0D), this.A07, this.A0E, this.A00, this.A01, this.A02, this.A06.size(), this.A0A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C4A
    /* renamed from: A02 */
    public final void A0E(RT rt, int i2) {
        rt.A0l(this.A06.get(i2), this.A0B, this.A09, this.A0C, this.A05);
    }

    @Override // com.facebook.ads.redexgen.X.C4A
    public final int A0D() {
        return this.A06.size();
    }
}
