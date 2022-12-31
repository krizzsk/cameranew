package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
/* renamed from: com.facebook.ads.redexgen.X.Yg  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1322Yg implements InterfaceC06356k {
    public final /* synthetic */ YQ A00;

    public C1322Yg(YQ yq) {
        this.A00 = yq;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        String[] strArr;
        String[] strArr2;
        AnonymousClass61 anonymousClass61;
        String[] strArr3;
        strArr = this.A00.A06;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList();
            strArr2 = this.A00.A06;
            int length = strArr2.length;
            anonymousClass61 = this.A00.A03;
            int min = Math.min(length, anonymousClass61.A0U());
            for (int i2 = 0; i2 < min; i2++) {
                strArr3 = this.A00.A06;
                arrayList.add(strArr3[i2]);
            }
            return this.A00.A0E(arrayList);
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
