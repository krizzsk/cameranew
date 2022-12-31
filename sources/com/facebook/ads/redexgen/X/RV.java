package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.util.SparseBooleanArray;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public class RV extends QY {
    public final /* synthetic */ JT A00;
    public final /* synthetic */ C1009Lz A01;
    public final /* synthetic */ PE A02;
    public final /* synthetic */ RT A03;
    public final /* synthetic */ String A04;
    public final /* synthetic */ Map A05;

    public RV(RT rt, String str, PE pe, JT jt, Map map, C1009Lz c1009Lz) {
        this.A03 = rt;
        this.A04 = str;
        this.A02 = pe;
        this.A00 = jt;
        this.A05 = map;
        this.A01 = c1009Lz;
    }

    @Override // com.facebook.ads.redexgen.X.QY
    public final void A03() {
        QZ qz;
        SparseBooleanArray sparseBooleanArray;
        QZ qz2;
        SparseBooleanArray sparseBooleanArray2;
        qz = this.A03.A01;
        if (!qz.A0Z() && !TextUtils.isEmpty(this.A04)) {
            sparseBooleanArray = this.A03.A07;
            if (!sparseBooleanArray.get(this.A02.A02())) {
                JT jt = this.A00;
                String str = this.A04;
                C1055Nu c1055Nu = new C1055Nu(this.A05);
                qz2 = this.A03.A02;
                jt.A8v(str, c1055Nu.A03(qz2).A02(this.A01).A05());
                sparseBooleanArray2 = this.A03.A07;
                sparseBooleanArray2.put(this.A02.A02(), true);
            }
        }
    }
}
