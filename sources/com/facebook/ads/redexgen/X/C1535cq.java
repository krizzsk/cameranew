package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.cq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1535cq extends AbstractC04860p {
    public static String[] A05 = {"RwkPFHsv9wotgH8PCqYhpIij5lIi", "drIC7gYxypHASOm9CvVJaHIQeep0", "f0dvIXyq27iv5zRXvkJTu2cqkG", "fzusVvXWPget8SSdASQ7tAMFHi8p37he", "Ar6p", "jDkSEm6Ik6fEWWn08WKTicIvFe3Dtksc", "J7vaKr0jTjoObEFZmlhET1S0K8S4ujA7", "2rimL2d5m8eNJCurq2ysJBza56R6EvG7"};
    public static final String A06 = C1535cq.class.getSimpleName();
    public C1537cs A00;
    public boolean A01;
    public final XT A02;
    public final JT A03;
    public final AbstractC1045Nk A04;

    public C1535cq(XT xt, JT jt, AbstractC1045Nk abstractC1045Nk, QZ qz, AbstractC04870q abstractC04870q) {
        super(xt, abstractC04870q, qz);
        this.A03 = jt;
        this.A04 = abstractC1045Nk;
        this.A02 = xt;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04860p
    public final void A06(Map<String, String> map) {
        C1537cs c1537cs = this.A00;
        if (c1537cs != null && !TextUtils.isEmpty(c1537cs.A61())) {
            this.A02.A0D().A2Y();
            AnonymousClass26.A00(this.A00.A05());
            JT jt = this.A03;
            String A61 = this.A00.A61();
            String[] strArr = A05;
            if (strArr[7].charAt(31) != strArr[6].charAt(31)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[0] = "Tkg0tGhzpCvpbpNuTPjRHtf4b45H";
            strArr2[1] = "dBPpzaB1YNfwJk5banXGE19c57tB";
            jt.A8v(A61, map);
        }
    }

    public final synchronized void A07() {
        if (!this.A01 && this.A00 != null) {
            this.A01 = true;
            if (!TextUtils.isEmpty(this.A00.A03())) {
                M1.A00(new C1536cr(this));
            }
        }
    }

    public final void A08(C1537cs c1537cs) {
        this.A00 = c1537cs;
    }
}
