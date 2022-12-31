package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public class X1 implements C9E {
    public final /* synthetic */ String[] A00;

    public X1(String[] strArr) {
        this.A00 = strArr;
    }

    @Override // com.facebook.ads.redexgen.X.C9E
    public final boolean A2N(String str) {
        for (String str2 : this.A00) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }
}
