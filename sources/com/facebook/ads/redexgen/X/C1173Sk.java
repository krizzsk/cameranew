package com.facebook.ads.redexgen.X;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Sk  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1173Sk extends C4A<C1137Ra> {
    public static String[] A0G = {"V9PMqjfJwvT67ZYY54", "KoZhm2HVOxwdWjftAINQcNHkYZyOyrrP", "1oETx6NwESVuh0koANzr27EeUl20v2", "JzBcWsy5jAKTLTxYYehZ60pyLdP8SU", "yKgplvdSiwxmZlK2YFEMAzZYc4XxSzpb", "X0kbEjSxeWmcBGftN2ECOwyfDlZVnKJa", "Tg1eBciSulZI8G7Ss5ny454cnfyvXG1B", "XTdAnKcq2fXupzVpmV"};
    public int A00;
    public int A01;
    public int A02;
    @Nullable
    public MU A03;
    public QZ A04;
    public String A05;
    public List<PE> A06;
    public final SparseBooleanArray A07 = new SparseBooleanArray();
    public final AnonymousClass16 A08;
    public final C7J A09;
    public final XT A0A;
    public final JT A0B;
    public final C1198Tj A0C;
    public final C1009Lz A0D;
    public final A1 A0E;
    public final IS A0F;

    public C1173Sk(XT xt, List<PE> list, AnonymousClass16 anonymousClass16, JT jt, C1198Tj c1198Tj, MU mu, String str, A1 a1, @Nullable IS is) {
        this.A0A = xt;
        this.A0B = jt;
        this.A0C = c1198Tj;
        this.A09 = c1198Tj.A0z();
        this.A04 = c1198Tj.A18();
        this.A0D = c1198Tj.A17();
        this.A03 = mu;
        this.A08 = anonymousClass16;
        this.A06 = list;
        this.A05 = str;
        this.A0E = a1;
        this.A0F = is;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C4A
    /* renamed from: A01 */
    public final C1137Ra A0C(ViewGroup viewGroup, int i2) {
        MU mu = this.A03;
        if (mu != null) {
            int i3 = this.A00;
            String[] strArr = A0G;
            if (strArr[7].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0G;
            strArr2[2] = "HBGrR4E5Ou8lGOrZM15HBBDd4CDBRH";
            strArr2[3] = "Dws66no3otUyrKWRXf01RsEai20ZIn";
            if (i3 == 0) {
                return null;
            }
            return new C1137Ra(O2.A00(new OM(this.A0A, this.A0B, mu, this.A08, null, this.A04, this.A0D).A0I(this.A0F).A0G(this.A0C).A0J(), this.A0C, this.A05, this.A0E), this.A07, this.A04, this.A06.size(), this.A0A);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C4A
    /* renamed from: A02 */
    public final void A0E(C1137Ra c1137Ra, int i2) {
        c1137Ra.A0m(this.A04);
        c1137Ra.A0l(this.A06.get(i2), this.A0B, this.A09, this.A0D, this.A05, this.A00, this.A02, this.A01);
    }

    @Override // com.facebook.ads.redexgen.X.C4A
    public final int A0D() {
        return this.A06.size();
    }

    public final void A0F(int i2, int i3, int i4) {
        this.A00 = i2;
        this.A02 = i3;
        this.A01 = i4;
    }

    public final void A0G(QZ qz) {
        this.A04 = qz;
    }
}
