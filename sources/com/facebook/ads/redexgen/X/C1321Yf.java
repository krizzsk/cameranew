package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Yf  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1321Yf implements InterfaceC06356k {
    public final /* synthetic */ YQ A00;

    public C1321Yf(YQ yq) {
        this.A00 = yq;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        String[] strArr;
        String[] strArr2;
        strArr = this.A00.A06;
        if (strArr != null) {
            YQ yq = this.A00;
            strArr2 = yq.A06;
            return yq.A04(strArr2.length);
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
